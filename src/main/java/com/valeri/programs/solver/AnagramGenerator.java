package com.valeri.programs.solver;

import java.util.List;

public class AnagramGenerator {
    private final List<String> words;
    private final Phrase targetPhrase;
    private final Phrase candidatePhrase;
    private final String targetHash;

    public AnagramGenerator(List<String> words, Phrase targetPhrase, String targetHash) {
        this.words = words;
        this.targetPhrase = targetPhrase;
        this.candidatePhrase = new Phrase();
        this.targetHash = targetHash;
    }

    public void generateVariations() {
        generateVariations(words, this.targetPhrase.getWordCount(), 0);
    }

    void generateVariations(List<String> input, int depth, int index) {
        if (candidatePhrase.hasMoreLetters(targetPhrase)) {
            return;
        }

        if (depth == 0) {
            if (candidatePhrase.checkAnagram(targetPhrase)) {
                if (candidatePhrase.calculateMD5Hash().equals(targetHash)) {
                    System.out.println(candidatePhrase);
                    System.exit(0);
                }
            }
        } else {
            for (int i = index; i < input.size(); i++) {
                candidatePhrase.addWord(input.get(i));
                generateVariations(input, depth - 1, index + 1);
                candidatePhrase.removeLastWord();
            }
        }
    }
}
