package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class WordLoader {

    private final int wordLength;

    public WordLoader(int wordLength) {
        this.wordLength = wordLength;
    }

    public String load() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resourceAsStream = classLoader.getResource("words_" + wordLength + ".txt");
        try {
            List<String> lines = Files.readAllLines(Paths.get(resourceAsStream.toURI()));
            int numberOfLines = lines.size();
            Random random = new Random();
            int line = random.nextInt(0, numberOfLines);
            return lines.get(line);

        } catch (IOException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
