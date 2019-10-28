package by.epam.financial_accounting.service.factory;

import by.epam.financial_accounting.service.TransactionService;
import by.epam.financial_accounting.service.UserService;
import by.epam.financial_accounting.service.impl.TransactionServiceImpl;
import by.epam.financial_accounting.service.impl.UserServiceImpl;
import by.epam.financial_accounting.service.util.TransactionIdGenerator;

public class ServiceFactory {
    private TransactionIdGenerator idGenerator;
    {
        idGenerator = TransactionIdGenerator.getInstance();
    }

    private static final ServiceFactory instance = new ServiceFactory();

    private final TransactionService transactionService = new TransactionServiceImpl();
    private final UserService userService = new UserServiceImpl();

    public static ServiceFactory getInstance() {
        return instance;
    }

    public TransactionService getTransactionService() {
        return transactionService;
    }

    public UserService getUserService() {
        return userService;
    }

    public TransactionIdGenerator getIdGenerator() {
        return idGenerator;
    }
}
