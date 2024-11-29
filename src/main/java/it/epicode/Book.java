package it.epicode;

public class Book extends Cathalog implements Publication{
    private String author;
    private String genre;

    public Book(String ISBN, String title, int yearPublished, int numberOfPages, String author, String genre) {
        super(ISBN, title, yearPublished, numberOfPages);
        this.author = author;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Author: " + author +
                "\nGenre: " + genre;
    }

}