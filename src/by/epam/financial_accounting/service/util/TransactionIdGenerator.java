package by.epam.financial_accounting.service.util;

import by.epam.financial_accounting.dao.TransactionDAO;
import by.epam.financial_accounting.dao.exception.DAOException;
import by.epam.financial_accounting.dao.factory.DAOFactory;
import by.epam.financial_accounting.dao.impl.FileTransactionDAO;
import by.epam.financial_accounting.service.exception.ServiceException;

public class TransactionIdGenerator {
    private static final TransactionIdGenerator instance = new TransactionIdGenerator();

    public static TransactionIdGenerator getInstance() {
        return instance;
    }

    public int nextId() throws ServiceException {
        DAOFactory daoFactory = DAOFactory.getInstance();
        TransactionDAO transactionDAO = daoFactory.getTransactionDAO();

        try {
            int lastId = transactionDAO.lastId();
            return lastId + 1;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }
}
