package leitner;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class Lesson {
    private final Vocabulary vocabulary;
    public HashSet<String>[] buckets = new HashSet[10];
    private int numBucket;

    public Lesson(String filename) throws IOException {
        vocabulary = new Vocabulary(filename);
        for (int i = 0; i < 10; i++) {
            buckets[i] = new HashSet<>();
        }
        for (String word : vocabulary.translations.keySet()) {
            buckets[0].add(word);
        }
    }

    public void study() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("The lesson begins");
        while (true) {
            String question = makeQuestion();
            String answer = scanner.nextLine();
            if (answer.length() == 0) {
                System.out.println("The lesson is over");
                return;
            }
            checkAnswer(question, answer);
        }
    }

    private String makeQuestion() {
        numBucket = getBucket();
        String question = buckets[numBucket].iterator().next();
        System.out.println("What is the translation for " + question + " ?");
        return question;
    }

    private int getBucket() {
        double random = Math.random(), curValue = 0.5;
        int ans = 0;
        while (random > curValue && ans < 9) {
            random -= curValue;
            curValue /= 2;
            ans++;
        }
        if (buckets[ans].size() == 0) {
            return getNearest(ans);
        } else {
            return ans;
        }
    }

    private int getNearest(int id) {
        int l = id - 1, r = id + 1;
        while (l >= 0 && buckets[l].size() == 0) {
            l--;
        }
        while (r < 10 && buckets[r].size() == 0) {
            r++;
        }
        if (l < 0) {
            return r;
        }
        if (r > 9) {
            return l;
        }
        if (id - l < r - id) {
            return l;
        } else {
            return r;
        }
    }

    private void checkAnswer(String word, String translation) {
        if (translation.equals(vocabulary.translations.get(word))) {
            System.out.println("You are right!");
            if (numBucket < 9) {
                buckets[numBucket++].remove(word);
                buckets[numBucket].add(word);
            }
        } else {
            System.out.println("Your answer is incorrect! The correct translation is " + vocabulary.translations.get(word));
            buckets[numBucket].remove(word);
            buckets[0].add(word);
        }
    }
}
