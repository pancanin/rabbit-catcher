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

    @Test
    public void shouldBeTrueWhenPhrasesAreAnagrams() {
        Phrase p = new Phrase("the brown fox");
        Phrase p2 = new Phrase("brow then fox");

        Assertions.assertTrue(p.checkAnagram(p2));
    }

    @Test
    public void shouldBeTrueWhenPhrasesAreAnagrams2() {
        Phrase p = new Phrase("JVM platform kicks ass o");
        Phrase p2 = new Phrase("form plato kick sass VMJ");

        Assertions.assertTrue(p.checkAnagram(p2));
    }

    @Test
    public void shouldBeFalseWhenPhrasesAreAnagrams() {
        Phrase p = new Phrase("JVM platform kicks ass o");
        Phrase p2 = new Phrase("form splat kick sass");

        Assertions.assertFalse(p.checkAnagram(p2));
    }

    @Test
    public void shouldReturnSortedLettersOfAWord() {
        Phrase p = new Phrase("a e cb dfgh");

        Assertions.assertEquals("   abcdefgh", p.computeSortedLetters());
    }

    @Test
    public void shouldReturnThePhraseAsSentenceText() {
        String pText = "a e cb dfgh";
        Phrase p = new Phrase(pText);

        Assertions.assertEquals(pText, p.toString());
    }

    @Test
    public void shouldReturnMD5HashOfThePhrase() {
        String hash = "35454B055CC325EA1AF2126E27707052";
        String password = "ILoveJava";
        Phrase p = new Phrase(password);

        Assertions.assertEquals(hash, p.calculateMD5Hash());
    }

}
