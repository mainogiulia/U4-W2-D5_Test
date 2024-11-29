package it.epicode;

public class ISBNNotFoundException extends RuntimeException {
    public ISBNNotFoundException(String message) {
        super(message);
    }
}