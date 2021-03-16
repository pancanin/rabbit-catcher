package com.valeri.programs.solver;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Phrase {
    private final List<Word> words;

    public Phrase(List<Word> words) {
        this.words = words;
    }

    public Phrase(String phrase) {
        this.words = Arrays.stream(phrase.split(" "))
                .map(Word::new)
                .collect(Collectors.toList());
    }

    public int getWordCount() {
        return this.words.size();
    }

    public String computeSortedLetters() {
        return this.toString()
            .chars()
            .mapToObj(c -> "" + (char)c)
            .sorted()
            .reduce("", (partialString, element) -> partialString + element);
    }

    public Set<Character> getUniqChars() {
        return words.stream()
                .flatMap(word -> word.getUniqChars().stream())
                .collect(Collectors.toSet());
    }

    public boolean checkAnagram(Phrase other) {
        return this.computeSortedLetters().equals(other.computeSortedLetters());
    }

    public String calculateMD5Hash(){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(this.toString().getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();

            return DatatypeConverter.printHexBinary(digest);
        } catch (Exception e) {
            return "";
        }
    }

    @Override
    public String toString() {
        return this.words.stream()
                .map(Word::getPlainText)
                .collect(Collectors.joining(" "));
    }
}
