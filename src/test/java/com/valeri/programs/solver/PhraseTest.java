package com.valeri.programs.solver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;

public class PhraseTest {

    @Test
    public void shouldReturnAllUniqueCharactersInPhrase() {
        Word w = new Word("aabbcc");
        Word w2 = new Word("ccddee");
        Phrase phrase = new Phrase(Arrays.asList(w, w2));

        Set<Character> uniq = phrase.getUniqChars();

        Assertions.assertEquals(5, uniq.size());
        Assertions.assertTrue(uniq.contains('a'));
        Assertions.assertTrue(uniq.contains('b'));
        Assertions.assertTrue(uniq.contains('c'));
        Assertions.assertTrue(uniq.contains('d'));
        Assertions.assertTrue(uniq.contains('e'));
    }

}
