package com.valeri.programs.solver;

import org.junit.platform.commons.util.ClassLoaderUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Collectors;

final public class Driver {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Phrase phraseAnagram = new Phrase("poultry outwits ants");
        String easyHash = "e4820b45d2277f3844eac66c903e84be";
        String mediumHash = "23170acc097c24edb98fc5488ab033fe";
        String hardHash = "665e5bcb0c20062fe8abaaf4628bb154";

        List<String> usefulWords = Files.readAllLines(Paths.get("src/main/resources/wordlist"))
                .stream()
                .parallel()
                .filter(w -> w.chars().allMatch(c -> phraseAnagram.getUniqChars().contains((char)c)))
                .collect(Collectors.toList());

        List<List<String>> wordArrangements = new ArrayList<>();
        List<String> reversedUsefulWords = new ArrayList<>(usefulWords);
        Collections.reverse(reversedUsefulWords);
        wordArrangements.add(reversedUsefulWords);

        List<String> shuffled1 = new ArrayList<>(usefulWords);
        Collections.shuffle(shuffled1);
        wordArrangements.add(shuffled1);

        List<String> shuffled2 = new ArrayList<>(reversedUsefulWords);
        Collections.shuffle(shuffled2);
        wordArrangements.add(shuffled2);

        wordArrangements.add(usefulWords);

        int cores = Runtime.getRuntime().availableProcessors();
        CountDownLatch latch = new CountDownLatch(cores);

        for (int i = 0; i < cores; i++) {
            int finalI = i;
            new Thread(() -> {
                AnagramGenerator anagramGenerator = new AnagramGenerator(
                        wordArrangements.get(finalI),
                        phraseAnagram,
                        hardHash
                );
                anagramGenerator.generateVariations();
                latch.countDown();
            }).start();
        }

        latch.await();
    }
}
