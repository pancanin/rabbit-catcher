package com.valeri.programs.solver;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;

class Phrase {
    private final List<Word> words;

    public Phrase(List<Word> words) {
        this.words = words;
    }

    public int getWordCount() {
        throw new NotImplementedException();
    }

    public boolean checkAnagram(Phrase other) {
        throw new NotImplementedException();
    }

    public String calculateMD5Hash() {
        throw new NotImplementedException();
    }
}
