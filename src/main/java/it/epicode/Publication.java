package it.epicode;

public interface Publication {
    String getISBN();

    String getTitle();

    int getYearPublished();

    int getNumberOfPages();

    void setTitle(String newTitle);

    void setYearPublished(int yearPublished);

    void setNumberOfPages(int numberOfPages);
}
