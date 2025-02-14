package com.example.genaibootcamp.tahir.langportal.langportal.dto;

import java.util.List;

public class WordDTO {
    private String japanese;
    private String romaji;
    private String english;
    private List<Part> parts;

    // Getters and Setters
    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String japanese) {
        this.japanese = japanese;
    }

    public String getRomaji() {
        return romaji;
    }

    public void setRomaji(String romaji) {
        this.romaji = romaji;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public List<Part> getParts() {
        return parts;
    }

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public static class Part {
        private String kanji;
        private List<String> romaji;

        // Getters and Setters
        public String getKanji() {
            return kanji;
        }

        public void setKanji(String kanji) {
            this.kanji = kanji;
        }

        public List<String> getRomaji() {
            return romaji;
        }

        public void setRomaji(List<String> romaji) {
            this.romaji = romaji;
        }
    }
}