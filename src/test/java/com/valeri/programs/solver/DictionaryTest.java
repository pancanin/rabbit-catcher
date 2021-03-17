package com.valeri.programs.solver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class DictionaryTest {

    @Test
    public void shouldReturnWordsContainingAllCharacters() {
        Word w = new Word("hello");
        Word w2 = new Word("zdravei");
        Dictionary dict = new Dictionary(Arrays.asList(w, w2));
        Phrase phrase = new Phrase(Arrays.asList(w, new Word("world")));

        List<Word> containing = dict.getWordsContainingOnly(phrase);

        Assertions.assertEquals(1, containing.size());
        Assertions.assertEquals(w, containing.get(0));
    }

    @Test
    public void shouldReturnWordsContainingAllCharacters_2() {
        Word w = new Word("a");
        Word w2 = new Word("ab");
        Word w3 = new Word("ac");
        Word w4 = new Word("bc");
        Word w5 = new Word("fe");
        Word w6 = new Word("ou");
        Word w7 = new Word("pass");
        Word w8 = new Word("port");
        Dictionary dict = new Dictionary(Arrays.asList(w, w2, w3, w4, w5, w6, w7, w8));
        Phrase phrase = new Phrase(Arrays.asList(new Word("passport"), new Word("for")));

        List<Word> containing = dict.getWordsContainingOnly(phrase);

        Assertions.assertEquals(3, containing.size());
        Assertions.assertTrue(w.equals(containing.get(0)));
        Assertions.assertTrue(w7.equals(containing.get(1)));
        Assertions.assertTrue(w8.equals(containing.get(2)));
    }

    @Test
    public void shouldReturnEmptyWhenWordHasMoreCharsThanPhrase() {
        Word w = new Word("guitar");
        Dictionary dictionary = new Dictionary(Arrays.asList(w));
        Phrase p = new Phrase(Arrays.asList(new Word("tar")));

        List<Word> containing = dictionary.getWordsContainingOnly(p);

        Assertions.assertTrue(containing.isEmpty());
    }

    @Test
    public void shouldGenerateVariations() {
        Word w = new Word("the");
        Word w2 = new Word("brown");
        Word w3 = new Word("fox");
        Word w4 = new Word("jumped");
        Phrase p = new Phrase(Arrays.asList(w, w2, w3, w4));
        List<Word> wordsFromPhrase = Arrays.asList(w, w2, w3, w4);
        Dictionary d = new Dictionary(wordsFromPhrase);

        List<Phrase> variations = d.generateVariations(p);
        int variationsWithRepetitionsCount = (int)Math.pow(p.getWordCount(), p.getWordCount());
        Assertions.assertEquals(variationsWithRepetitionsCount, variations.size());
        Assertions.assertTrue(variations.stream().anyMatch(v -> "fox jumped the brown".equals(v.toString())));
    }


}
