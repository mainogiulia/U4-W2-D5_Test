package it.epicode;

import java.util.ArrayList;
import java.util.List;

public abstract class Cathalog {
    private final String ISBN;
    private String title;
    private int yearPublished;
    private int numberOfPages;

   /* private List<Book> books;
    private List<Magazine> magazines;*/

    public Cathalog(String ISBN, String title, int yearPublished, int numberOfPages) {
        this.ISBN = ISBN;
        this.title = title;
        this.yearPublished = yearPublished;
        this.numberOfPages = numberOfPages;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }
}