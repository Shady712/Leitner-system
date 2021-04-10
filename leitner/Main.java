package leitner;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            Lesson lesson = new Lesson(args[0]);
            lesson.study();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
