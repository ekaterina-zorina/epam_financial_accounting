package by.epam.financial_accounting.dao;

import by.epam.financial_accounting.bean.Transaction;
import by.epam.financial_accounting.dao.exception.DAOException;

import java.util.List;

public interface TransactionDAO {
    void addTransaction(Transaction transaction) throws DAOException;
    List<Transaction> readTransactions() throws DAOException;
    void deleteTransaction(int transactionId) throws DAOException;
    void deleteTransaction(Transaction transaction) throws DAOException;
    Transaction findTransactionById(int transactionId) throws DAOException;
    int lastId() throws DAOException;
}
