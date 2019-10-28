package by.epam.financial_accounting.controller.impl;

import by.epam.financial_accounting.controller.command.Command;

public class WrongRequest implements Command {

    @Override
    public String execute(String request) {
        return "Wrong request";
    }
}
