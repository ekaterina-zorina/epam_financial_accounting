package by.epam.financial_accounting.dao.util;

import java.io.*;

public class FinInfoReader implements AutoCloseable {
    BufferedReader reader;

    public FinInfoReader(String path) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(path));
    }

    public String readNote() throws IOException {
        String line = reader.readLine();

        if (line != null) {
            return line;
        }

        return null;
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
