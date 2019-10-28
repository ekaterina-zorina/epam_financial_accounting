package by.epam.financial_accounting;

import by.epam.financial_accounting.bean.AuthorizationInfo;
import by.epam.financial_accounting.controller.Controller;
import by.epam.financial_accounting.service.TransactionService;
import by.epam.financial_accounting.service.UserService;
import by.epam.financial_accounting.service.factory.ServiceFactory;

public class Main {
    public static void main(String[] args) {

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();
        TransactionService transactionService = serviceFactory.getTransactionService();

        AuthorizationInfo authInfo = new AuthorizationInfo("katya0858", "poiuy154");

        String response;

        Controller controller = Controller.getInstance();

        response = controller.executeTask("sign_in katya0858 poiuy154");
        System.out.println(response);

        response = controller.executeTask("create_transaction salary 165");
        System.out.println(response);

        response = controller.executeTask("create_transaction shopping -58");
        System.out.println(response);

        response = controller.executeTask("read_transaction 1");
        System.out.println(response);

        response = controller.executeTask("update_transaction 1 salary 120");
        System.out.println(response);

        response = controller.executeTask("delete_transaction 2");
        System.out.println(response);
    }
}
