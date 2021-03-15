package com.valeri.programs.solver;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

}
