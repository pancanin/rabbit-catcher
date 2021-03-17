package com.valeri.programs.solver;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class Phrase {
    private final Stack<String> words;
    private final Map<Character, Long> occurences;

    public Phrase(String phrase) {
        this.words = new Stack<>();
        this.words.addAll(Arrays.asList(phrase.split(" ")));
        this.occurences = calcOccurences();
    }

    public Phrase() {
        this.words = new Stack<>();
        this.occurences = new HashMap<>();
    }

    public void addWord(String w) {
        this.words.add(w);

        for (int i = 0; i < w.length(); i++) {
            if (!this.occurences.containsKey(w.charAt(i))) {
                this.occurences.put(w.charAt(i), 0L);
            }

            this.occurences.put(w.charAt(i), this.occurences.get(w.charAt(i)) + 1);
        }
    }

    public void removeLastWord() {
        String w = this.words.pop();

        for (int i = 0; i < w.length(); i++) {
            this.occurences.put(w.charAt(i), this.occurences.get(w.charAt(i)) - 1);

            if (this.occurences.get(w.charAt(i)) == 0) {
                this.occurences.remove(w.charAt(i));
            }
        }
    }

    public int getWordCount() {
        return this.words.size();
    }

    public Set<Character> getUniqChars() {
        return this.occurences.keySet();
    }

    public boolean checkAnagram(Phrase other) {
        return this.getUniqChars().equals(other.getUniqChars());
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

    private Map<Character, Long> calcOccurences() {
        return this.words
                .stream()
                .flatMapToInt(CharSequence::chars)
                .mapToObj(i -> (char) i)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public boolean hasMoreLetters(Phrase other) {
        Map<Character, Long> phraseLetterOccurences = this.calcOccurences();
        Map<Character, Long> otherOccurences = other.getOccurences();

        for (Map.Entry<Character, Long> entry : phraseLetterOccurences.entrySet()) {
            if (otherOccurences.get(entry.getKey()) < entry.getValue()) {
                return true;
            }
        }

        return false;
    }

    public Map<Character, Long> getOccurences() {
        return Collections.unmodifiableMap(this.occurences);
    }

    @Override
    public String toString() {
        return String.join(" ", this.words);
    }

}
