package leitner;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class InputScanner implements AutoCloseable {
    private final BufferedReader reader;
    private int symbol;
    private boolean lines = true;

    public InputScanner(String fileName) throws IOException {
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName), StandardCharsets.UTF_8));
        symbol = reader.read();
    }

    private boolean lineSeparator(char x) {
        return x == '\n' || x == '\r';
    }

    private boolean check(char x) {
        return Character.isLetter(x) || Character.getType(x) == Character.DASH_PUNCTUATION || x == '\'';
    }

    public void nextLine() throws IOException {
        symbol = reader.read();
        if (lineSeparator((char)symbol)) {
            symbol = reader.read();
        }
        if (symbol == -1) {
            lines = false;
        }
    }

    public boolean hasNextLine() {
        return lines;
    }

    private void skip() throws IOException {
        while (symbol != -1 && !check((char)symbol)) {
            symbol = reader.read();
            if (lineSeparator((char)symbol)) {
                break;
            }
            if (symbol == -1) {
                lines = false;
            }
        }
    }

    public boolean hasNext() throws IOException {
        if (symbol == -1) {
            return false;
        }
        if (lineSeparator((char)symbol)) {
            nextLine();
            return false;
        }
        skip();
        if (lineSeparator((char)symbol)) {
            nextLine();
            return false;
        }
        return check((char)symbol);
    }

    public String next()
            throws IOException
    {
        skip();
        StringBuilder builder = new StringBuilder();
        while (symbol != -1 && check((char)symbol)) {
            builder.append((char)symbol);
            symbol = reader.read();
            if (symbol == -1) {
                lines = false;
            }
        }
        return builder.toString();
    }

    public void close() throws IOException {
            reader.close();
    }
}
