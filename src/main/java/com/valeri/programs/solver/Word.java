package com.valeri.programs.solver;

import java.util.Objects;
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

    public String getPlainText() {
        return this.word;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word1 = (Word) o;
        return word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
