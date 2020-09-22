package com.trutsin.model;

public class Film {
    private int year;
    private String genre;

    public Film() {
    }

    public Film(int year, String genre) {
        this.year = year;
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Film{" +
                "year=" + year +
                ", genre='" + genre + '\'' +
                '}';
    }
}
