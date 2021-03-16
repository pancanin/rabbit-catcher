package com.valeri.programs.solver;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
        throw new NotImplementedException();
    }
}
