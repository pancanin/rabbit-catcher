package com.valeri.programs.solver;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Phrase {
    private final List<Word> words;

    public Phrase(List<Word> words) {
        this.words = words;
    }

    public Phrase(String phrase) {
        this.words = Arrays.stream(phrase.split(" "))
                .map(Word::new)
                .collect(Collectors.toList());
    }

    public int getWordCount() {
        throw new NotImplementedException();
    }

    public String computeSortedLetters() {
        return this.words.stream()
            .map(Word::getPlainText)
            .collect(Collectors.joining(""))
            .chars()
            .mapToObj(c -> "" + (char)c)
            .sorted()
            .reduce("", (partialString, element) -> partialString + element);
    }

    public Set<Character> getUniqChars() {
        return words.stream()
                .flatMap(word -> word.getUniqChars().stream())
                .collect(Collectors.toSet());
    }

    public boolean checkAnagram(Phrase other) {
        return this.computeSortedLetters().equals(other.computeSortedLetters());
    }

    public String calculateMD5Hash() {
        throw new NotImplementedException();
    }
}
