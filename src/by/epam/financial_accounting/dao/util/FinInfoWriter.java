package by.epam.financial_accounting.dao.util;

import by.epam.financial_accounting.dao.exception.DAOException;

import java.io.FileWriter;
import java.io.IOException;

public class FinInfoWriter implements AutoCloseable {
    FileWriter writer;

    public FinInfoWriter(String path) throws IOException {
        writer = new FileWriter(path, true);
    }

    public void writeNote(String note) throws IOException {
        writer.write(note + '\n');
        writer.flush();
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
