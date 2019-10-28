package by.epam.financial_accounting.service;

import by.epam.financial_accounting.bean.AuthorizationInfo;
import by.epam.financial_accounting.service.exception.ServiceException;

public interface UserService {
    boolean signIn(AuthorizationInfo authInfo) throws ServiceException;
    void signOut(AuthorizationInfo authInfo) throws ServiceException;
}
