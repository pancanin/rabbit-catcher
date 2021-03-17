package com.valeri.programs.solver;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

class Dictionary {
    private final List<Word> words;

    public Dictionary(List<Word> words) {
        this.words = words;
    }

    public List<Word> getWordsContainingOnly(Phrase phrase) {
        return words.stream()
                .filter(w -> w.containsOnly(phrase))
                .collect(Collectors.toList());
    }

    public List<Phrase> generateVariations(Phrase phrase) {
        Stack<Word> wordStack = new Stack<>();
        List<List<Word>> variations = new ArrayList<>();

        generateVariations(this.words, phrase.getWordCount(), wordStack, variations);

        return variations
                .stream()
                .map(Phrase::new)
                .collect(Collectors.toList());
    }

    void generateVariations(List<Word> input, int depth, Stack<Word> wordStack, List<List<Word>> variations) {
        if (depth == 0) {
            variations.add(new ArrayList<>(wordStack));
        } else {
            for (int i = 0; i < input.size(); i++) {
                wordStack.add(input.get(i));
                generateVariations(input, depth - 1, wordStack, variations);
                wordStack.pop();
            }
        }
    }
}
