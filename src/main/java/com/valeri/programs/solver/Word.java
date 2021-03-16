package com.valeri.programs.solver;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Set;
import java.util.stream.Collectors;

class Word {

    private final String word;

    public Word(String word) {
        this.word = word;
    }

    public Set<Character> getUniqChars() {
        return word.chars()
                .mapToObj(c -> (char)c)
                .collect(Collectors.toSet());
    }

    public boolean containsOnly(Phrase p) {
        Set<Character> uniqueInPhrase = p.getUniqChars();
        return word.chars()
                .mapToObj(c -> (char) c)
                .allMatch(uniqueInPhrase::contains);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Word)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        return this.hashCode() == obj.hashCode();
    }
}
