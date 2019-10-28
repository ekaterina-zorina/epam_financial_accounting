package by.epam.financial_accounting.controller.impl;

import by.epam.financial_accounting.bean.AuthorizationInfo;
import by.epam.financial_accounting.controller.command.Command;
import by.epam.financial_accounting.service.UserService;
import by.epam.financial_accounting.service.exception.ServiceException;
import by.epam.financial_accounting.service.factory.ServiceFactory;

public class SignIn implements Command {

    @Override
    public String execute(String request) {
        String[] params = request.split(" ");

        String login = params[1];
        String password = params[2];
        String response = null;

        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        UserService userService = serviceFactory.getUserService();

        try {
            userService.signIn(new AuthorizationInfo(login, password));
            response = "Welcome";
        } catch (ServiceException e) {
            response = "Error during authorization procedure";
        }

        return response;
    }
}
