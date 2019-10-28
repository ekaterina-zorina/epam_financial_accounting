package by.epam.financial_accounting.dao.factory;

import by.epam.financial_accounting.dao.TransactionDAO;
import by.epam.financial_accounting.dao.UserDAO;
import by.epam.financial_accounting.dao.impl.FileTransactionDAO;
import by.epam.financial_accounting.dao.impl.FileUserDAO;

public class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final UserDAO fileUserImpl = new FileUserDAO();
    private final TransactionDAO fileTransactionImpl = new FileTransactionDAO();

    public static DAOFactory getInstance() {
        return instance;
    }

    public UserDAO getUserDAO() {
        return fileUserImpl;
    }

    public TransactionDAO getTransactionDAO() {
        return fileTransactionImpl;
    }
}
