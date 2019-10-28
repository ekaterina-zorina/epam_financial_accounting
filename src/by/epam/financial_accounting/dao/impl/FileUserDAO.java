package by.epam.financial_accounting.dao.impl;

import by.epam.financial_accounting.bean.AuthorizationInfo;
import by.epam.financial_accounting.dao.UserDAO;
import by.epam.financial_accounting.dao.exception.DAOException;
import by.epam.financial_accounting.dao.util.FinInfoReader;

import java.io.*;

public class FileUserDAO implements UserDAO {

    @Override
    public boolean signIn(AuthorizationInfo authInfo) throws DAOException {
        try (FinInfoReader fileNoteReader = new FinInfoReader("resources\\AuthInfo.txt")) {
            String s = fileNoteReader.readNote();
            String[] info = s.split(" ");

            AuthorizationInfo infoFromFile = new AuthorizationInfo(info[0], info[1]);

            if (authInfo.equals(infoFromFile)) {
                return true;
            }
            return false;

        } catch (FileNotFoundException e) {
            throw new DAOException(e);
        } catch (IOException e) {
            throw new DAOException(e);
        }
    }
}
