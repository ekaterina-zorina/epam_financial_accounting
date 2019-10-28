package by.epam.financial_accounting.controller.impl;

import by.epam.financial_accounting.bean.Transaction;
import by.epam.financial_accounting.controller.command.Command;
import by.epam.financial_accounting.service.TransactionService;
import by.epam.financial_accounting.service.exception.ServiceException;
import by.epam.financial_accounting.service.factory.ServiceFactory;

public class CreateTransaction implements Command {

    @Override
    public String execute(String request) {
        String[] params = request.split(" ");
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TransactionService transactionService = serviceFactory.getTransactionService();

        try {
            int id = serviceFactory.getIdGenerator().nextId();
            String description = params[1];
            double sum = Double.parseDouble(params[2]);

            transactionService.createTransaction(new Transaction(id, description, sum));
            response = "Transaction successfully added";
        } catch (ServiceException e) {
            response = "Error during adding transaction";
        }

        return response;
    }
}
