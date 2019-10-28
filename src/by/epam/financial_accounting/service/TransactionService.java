package by.epam.financial_accounting.service;

import by.epam.financial_accounting.bean.Transaction;
import by.epam.financial_accounting.service.exception.ServiceException;

public interface TransactionService {
    void createTransaction(Transaction transaction) throws ServiceException;
    Transaction readTransaction(int transactionId) throws ServiceException;
    void updateTransaction(int transactionId, Transaction transaction) throws ServiceException;
    void deleteTransaction(int transactionId) throws ServiceException;
}
