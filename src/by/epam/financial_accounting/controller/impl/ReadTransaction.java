package by.epam.financial_accounting.controller.impl;

import by.epam.financial_accounting.bean.Transaction;
import by.epam.financial_accounting.controller.command.Command;
import by.epam.financial_accounting.service.TransactionService;
import by.epam.financial_accounting.service.exception.ServiceException;
import by.epam.financial_accounting.service.factory.ServiceFactory;

public class ReadTransaction implements Command {

    @Override
    public String execute(String request) {
        String[] params = request.split(" ");
        int id = Integer.parseInt(params[1]);
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionService transactionService = serviceFactory.getTransactionService();

        try {
            Transaction transaction = transactionService.readTransaction(id);
            response = transaction.getId() + " " + transaction.getDescription() + " " + transaction.getSum();
        } catch (ServiceException e) {
            response = "Error during reading transaction";
        }

        return response;
    }
}
