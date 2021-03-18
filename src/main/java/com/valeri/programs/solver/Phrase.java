package com.valeri.programs.solver;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Phrase {
    private final Stack<String> words;
    private final Map<Character, Long> groupingCountByCharacter;

    public Phrase(String phrase) {
        this.words = new Stack<>();
        this.words.addAll(Arrays.asList(phrase.split(" ")));
        this.groupingCountByCharacter = countByCharacter();
    }

    public Phrase() {
        this.words = new Stack<>();
        this.groupingCountByCharacter = new HashMap<>();
    }

    public void addWord(String w) {
        this.words.add(w);

        for (int i = 0; i < w.length(); i++) {
            if (!this.groupingCountByCharacter.containsKey(w.charAt(i))) {
                this.groupingCountByCharacter.put(w.charAt(i), 0L);
            }

            this.groupingCountByCharacter.put(w.charAt(i), this.groupingCountByCharacter.get(w.charAt(i)) + 1);
        }
    }

    public void removeLastWord() {
        String w = this.words.pop();

        for (int i = 0; i < w.length(); i++) {
            this.groupingCountByCharacter.put(w.charAt(i), this.groupingCountByCharacter.get(w.charAt(i)) - 1);

            if (this.groupingCountByCharacter.get(w.charAt(i)) == 0) {
                this.groupingCountByCharacter.remove(w.charAt(i));
            }
        }
    }

    public int getWordCount() {
        return this.words.size();
    }

    public Set<Character> getUniqueChars() {
        return this.groupingCountByCharacter.keySet();
    }

    public boolean checkAnagram(Phrase other) {
        return this.getUniqueChars().equals(other.getUniqueChars());
    }

    public String calculateMD5Hash(){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(this.toString().getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();

            return DatatypeConverter.printHexBinary(digest).toLowerCase(Locale.ROOT);
        } catch (Exception e) {
            return "";
        }
    }

    public boolean hasMoreLetters(Phrase other) {
        Map<Character, Long> phraseLetterOccurences = this.getCountByCharacter();
        Map<Character, Long> otherOccurences = other.getCountByCharacter();

        for (Map.Entry<Character, Long> entry : phraseLetterOccurences.entrySet()) {
            if (otherOccurences.get(entry.getKey()) < entry.getValue()) {
                return true;
            }
        }

        return false;
    }

    public Map<Character, Long> getCountByCharacter() {
        return Collections.unmodifiableMap(this.groupingCountByCharacter);
    }

    private Map<Character, Long> countByCharacter() {
        return this.words
                .stream()
                .flatMapToInt(CharSequence::chars)
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    @Override
    public String toString() {
        return String.join(" ", this.words);
    }

}
