package com.valeri.programs.solver;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

class Dictionary {
    private final List<Word> words;

    public Dictionary(List<Word> words) {
        this.words = words;
    }

    public List<Word> getWordsContainingAll(Set<Character> characters) {
        throw new NotImplementedException();
    }

    public List<Phrase> generateVariations(Phrase phrase) {
        throw new NotImplementedException();
    }
}
