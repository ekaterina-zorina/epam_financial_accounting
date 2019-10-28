package by.epam.financial_accounting.service.impl;

import by.epam.financial_accounting.bean.AuthorizationInfo;
import by.epam.financial_accounting.dao.UserDAO;
import by.epam.financial_accounting.dao.exception.DAOException;
import by.epam.financial_accounting.dao.factory.DAOFactory;
import by.epam.financial_accounting.service.UserService;
import by.epam.financial_accounting.service.exception.ServiceException;

public class UserServiceImpl implements UserService {
    @Override
    public boolean signIn(AuthorizationInfo authInfo) throws ServiceException {
        if (authInfo.getLogin() == null || authInfo.getLogin().isEmpty()) {
            throw new ServiceException("Incorrect login");
        }

        try {
            DAOFactory daoFactory = DAOFactory.getInstance();
            UserDAO userDAO = daoFactory.getUserDAO();
            if (userDAO.signIn(authInfo)) {
                return true;
            }
            return false;
        } catch (DAOException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void signOut(AuthorizationInfo authInfo) throws ServiceException {

    }
}
