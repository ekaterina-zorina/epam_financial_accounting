package by.epam.financial_accounting.controller.impl;

import by.epam.financial_accounting.controller.command.Command;
import by.epam.financial_accounting.service.TransactionService;
import by.epam.financial_accounting.service.exception.ServiceException;
import by.epam.financial_accounting.service.factory.ServiceFactory;

public class DeleteTransaction implements Command {

    @Override
    public String execute(String request) {
        String[] params = request.split(" ");
        int id = Integer.parseInt(params[1]);
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionService transactionService = serviceFactory.getTransactionService();

        try {
            transactionService.deleteTransaction(id);
            response = "Transaction successfully deleted";
        } catch(ServiceException e) {
            response = "Error during deleting transaction";
        }

        return response;
    }
}
