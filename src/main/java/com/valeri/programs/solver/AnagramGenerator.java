package com.valeri.programs.solver;

import java.util.List;

public class AnagramGenerator {
    private final List<String> words;
    private final Phrase anagramPhrase;
    private final Phrase candidatePhrase;
    private final String targetHash;

    public AnagramGenerator(List<String> words, Phrase anagramPhrase, String targetHash) {
        this.words = words;
        this.anagramPhrase = anagramPhrase;
        this.candidatePhrase = new Phrase();
        this.targetHash = targetHash;
    }

    public void generateVariations() {
        generateVariations(words, this.anagramPhrase.getWordCount(), 0);
    }

    private void generateVariations(List<String> input, int depth, int index) {
        if (candidatePhrase.hasMoreLetters(anagramPhrase)) {
            return;
        }

        if (depth == 0) {
            if (candidatePhrase.checkAnagram(anagramPhrase) &&
                    candidatePhrase.calculateMD5Hash().equals(targetHash)) {
                System.out.println(candidatePhrase);
                System.exit(0);
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
