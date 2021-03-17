package com.valeri.programs.solver;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.Set;

public class PhraseTest {

    @Test
    public void shouldReturnAllUniqueCharactersInPhrase() {
        Phrase phrase = new Phrase("aabbcc ccddee");

        Set<Character> uniq = phrase.getUniqueChars();

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
    public void shouldBeTrueWhenPhrasesAreAnagrams3() {
        Phrase p = new Phrase("tolstoy tutsi unwrap");
        Phrase p2 = new Phrase("poultry outwits ants");

        Assertions.assertTrue(p.checkAnagram(p2));
    }

    @Test
    public void shouldBeTrueWhenPhrasesAreAnagrams4() {
        Phrase p = new Phrase("new york times");
        Phrase p2 = new Phrase("monkeys write");

        Assertions.assertTrue(p.checkAnagram(p2));
    }

    @Test
    public void shouldBeTrueWhenPhrasesAreAnagrams5() {
        Phrase p = new Phrase("church of scientology");
        Phrase p2 = new Phrase("rich chosen goofy cult");

        Assertions.assertTrue(p.checkAnagram(p2));
    }

    @Test
    public void shouldBeTrueWhenPhrasesAreAnagrams6() {
        Phrase p = new Phrase("mcdonald`s");
        p.addWord("restaurants");
        p.removeLastWord();
        p.addWord("restaurants");
        p.addWord("chain");
        p.removeLastWord();
        Phrase p2 = new Phrase("uncle sam`s standard rot");

        Assertions.assertTrue(p.checkAnagram(p2));
    }

    @Test
    public void shouldBeFalseWhenPhrasesAreAnagrams() {
        Phrase p = new Phrase("JVM platform kicks ass o");
        Phrase p2 = new Phrase("form splat kick sass");

        Assertions.assertFalse(p.checkAnagram(p2));
    }

    @Test
    public void shouldReturnThePhraseAsSentenceText() {
        String pText = "a e cb dfgh";
        Phrase p = new Phrase(pText);

        Assertions.assertEquals(pText, p.toString());
    }

    @Test
    public void shouldReturnMD5HashOfThePhrase() {
        String hash = "35454B055CC325EA1AF2126E27707052".toLowerCase(Locale.ROOT);
        String password = "ILoveJava";
        Phrase p = new Phrase(password);

        Assertions.assertEquals(hash, p.calculateMD5Hash());
    }

}
