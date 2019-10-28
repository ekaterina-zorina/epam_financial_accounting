package by.epam.financial_accounting.dao.impl;

import by.epam.financial_accounting.bean.Transaction;
import by.epam.financial_accounting.dao.TransactionDAO;
import by.epam.financial_accounting.dao.exception.DAOException;
import by.epam.financial_accounting.dao.util.FinInfoReader;
import by.epam.financial_accounting.dao.util.FinInfoWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileTransactionDAO implements TransactionDAO {

    @Override
    public void addTransaction(Transaction transaction) throws DAOException {
        try (FinInfoWriter fileNoteWriter = new FinInfoWriter("resources\\Transactions.txt")) {
            String transactionInfo = transaction.getId() + " " + transaction.getDescription() + " " +
                    transaction.getSum();

            fileNoteWriter.writeNote(transactionInfo);
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public List<Transaction> readTransactions() throws DAOException {
        try (FinInfoReader fileNoteReader = new FinInfoReader("resources\\Transactions.txt")) {
            List<Transaction> transactions = new ArrayList<>();
            String finNote;
            String[] transactionInfo;

            while ((finNote = fileNoteReader.readNote()) != null) {
                transactionInfo = finNote.split(" ");
                transactions.add(new Transaction(Integer.parseInt(transactionInfo[0]), transactionInfo[1],
                        Double.parseDouble(transactionInfo[2])));
            }
            return transactions;
        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteTransaction(int transactionId) throws DAOException {
        List<Transaction> transactions = readTransactions();

        for (Transaction transaction : transactions) {
            if (transaction.getId() == transactionId) {
                transactions.remove(transaction);

                try (FileWriter fileWriter = new FileWriter("resources\\Transactions.txt", false)) {
                    for (Transaction transaction1 : transactions) {
                        fileWriter.write(transaction1.getId() + " " + transaction1.getDescription() + " " +
                                transaction1.getSum() + '\n');
                    }
                } catch (IOException e) {
                    throw new DAOException(e);
                }

                return;
            }
        }
    }

    @Override
    public void deleteTransaction(Transaction transaction) throws DAOException {
        List<Transaction> transactions = readTransactions();

        if (transactions.contains(transaction)) {
            transactions.remove(transaction);

            try (FileWriter fileWriter = new FileWriter("resources\\Transactions.txt", false)) {
                for (Transaction transaction1 : transactions) {
                    fileWriter.write(transaction1.getId() + " " + transaction1.getDescription() + " " +
                            transaction1.getSum() + '\n');
                }
            } catch (IOException e) {
                throw new DAOException(e);
            }
        }
        else {
            return;
        }
    }

    @Override
    public Transaction findTransactionById(int transactionId) throws DAOException {
        List<Transaction> transactions = readTransactions();

        for (Transaction transaction : transactions) {
            if (transaction.getId() == transactionId) {
                return transaction;
            }
        }

        throw new DAOException("There is no transaction with such id");
    }

    @Override
    public int lastId() throws DAOException {
        try (FinInfoReader fileNoteReader = new FinInfoReader("resources\\Transactions.txt")) {
            String last, line;
            last = null;

            while ((line = fileNoteReader.readNote()) != null) {
                last = line;
            }

            if (last != null) {
                String[] info = last.split(" ");
                return Integer.parseInt(info[0]);
            }

            return 0;

        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }
}
