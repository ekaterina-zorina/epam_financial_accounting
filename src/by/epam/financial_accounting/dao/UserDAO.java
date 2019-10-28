package by.epam.financial_accounting.dao;

import by.epam.financial_accounting.bean.AuthorizationInfo;
import by.epam.financial_accounting.dao.exception.DAOException;

public interface UserDAO {
    boolean signIn(AuthorizationInfo authInfo) throws DAOException;
}
