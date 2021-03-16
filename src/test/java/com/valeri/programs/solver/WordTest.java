package com.valeri.programs.solver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

    @Test
    public void shouldBeFalseWhenWordContainsOnlyTheLettersInPhrase() {
        Word w = new Word("abcd");

        Word pw = new Word("ab");
        Word pw2 = new Word("de");
        Phrase phrase = new Phrase(Arrays.asList(pw, pw2));

        Assertions.assertFalse(w.containsOnly(phrase));
    }

    @Test
    public void shouldBeTrueWhenWordContainsOnlyTheLettersInPhrase() {
        Word w = new Word("abcd");

        Word pw = new Word("aab");
        Word pw2 = new Word("cdd");
        Phrase phrase = new Phrase(Arrays.asList(pw, pw2));

        Assertions.assertTrue(w.containsOnly(phrase));
    }
}
