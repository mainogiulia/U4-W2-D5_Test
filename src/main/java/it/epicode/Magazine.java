package it.epicode;

public class Magazine extends Cathalog implements Publication{
    private Regularity regularity;

    public Magazine(String ISBN, String title, int yearPublished, int numberOfPages, Regularity regularity) {
        super(ISBN, title, yearPublished, numberOfPages);
        this.regularity = regularity;
    }

    public Regularity getRegularity() {
        return regularity;
    }

    public void setRegularity(Regularity regularity) {
        this.regularity = regularity;
    }

    @Override
    public String toString() {
        return "Regularity= " + regularity;
    }
}