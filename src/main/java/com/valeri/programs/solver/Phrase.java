package com.valeri.programs.solver;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Phrase {
    private final List<Word> words;

    public Phrase(List<Word> words) {
        this.words = words;
    }

    public int getWordCount() {
        throw new NotImplementedException();
    }

    public Set<Character> getUniqChars() {
        return words.stream()
                .flatMap(word -> word.getUniqChars().stream())
                .collect(Collectors.toSet());
    }

    public boolean checkAnagram(Phrase other) {
        throw new NotImplementedException();
    }

    public String calculateMD5Hash() {
        throw new NotImplementedException();
    }
}
