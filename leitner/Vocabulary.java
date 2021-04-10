package leitner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Vocabulary {
    private final InputScanner scanner;
    public Map<String, String> translations;

    public Vocabulary(String filename) throws IOException {
        scanner = new InputScanner(filename);
        translations = new HashMap<>();
        fillVocabulary();
    }

    private void fillVocabulary() throws IOException {
        while (scanner.hasNextLine()) {
            scanLine();
        }
        scanner.close();
    }

    private void scanLine() throws IOException {
        StringBuilder word = new StringBuilder(), translation = new StringBuilder();
        if (!scanner.hasNext()) {
            throw new IOException("Invalid input provided: no word");
        }
        while (scanner.hasNext()) {
            String cur = scanner.next();
            if (cur.equals("-")) {
                break;
            } else {
                if (word.length() != 0) {
                    word.append(' ');
                }
                word.append(cur);
            }
        }
        if (word.length() == 0) {
            throw new IOException("Invalid input: no word");
        }
        while (scanner.hasNext()) {
            if (translation.length() != 0) {
                translation.append(' ');
            }
            translation.append(scanner.next());
        }
        if (translation.length() == 0) {
            throw new IOException("Invalid input: no translation");
        }
        if (translations.get(word.toString()) != null && !translation.toString().equals(translations.get(word.toString()))) {
            throw new IOException("One word has multiple translations");
        }
        translations.put(word.toString(), translation.toString());
    }

}
