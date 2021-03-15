package com.valeri.programs.solver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class WordTest {
    @Test
    public void shouldReturnTheUniqueCharactersInWord() {
        Word w = new Word("abbc");
        Set<Character> uniq = w.getUniqChars();

        Assertions.assertEquals(3, uniq.size());
        Assertions.assertTrue(uniq.contains('a'));
        Assertions.assertTrue(uniq.contains('b'));
        Assertions.assertTrue(uniq.contains('c'));
    }
}
