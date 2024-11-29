package it.epicode;

import java.util.*;

public class Archive {
    static Scanner scanner = new Scanner(System.in);

    static Set<String> allISBN = new HashSet<>();
    static Map<String, Publication> publicationByISBN = new HashMap<>();
    static Set<Book> bookCollection = new HashSet<>();

    //METODO PER CREARE UN LIBRO O UNA RIVISTA

    public static void createProduct() throws CathalogException {
        System.out.println("Do you want to create a book (1) or a magazine (2)?");
        int choice = scanner.nextInt();
        scanner.nextLine();
        if (choice == 1) { //-----------------------------------------------LIBRO
            System.out.println("Input book ISBN");
            String ISBN = scanner.nextLine();
            System.out.println("What's the book title?");
            String title = scanner.nextLine();
            if (!allISBN.contains(ISBN)) {
                allISBN.add(ISBN);
            } else {
                throw new CathalogException("This ISBN already exists");
            }
            System.out.println("In which year was the book published?");
            int yearPublished = scanner.nextInt();
            scanner.nextLine();
            System.out.println("How many pages does the book have?");
            int numberOfPages = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Who is the author?");
            String author = scanner.nextLine();
            System.out.println("What genre is the book?");
            String genre = scanner.nextLine();
            Book book = new Book(ISBN, title, yearPublished, numberOfPages, author, genre);
            publicationByISBN.put(ISBN, book);
            bookCollection.add(book);
            System.out.println("Book created successfully!");
        } else if (choice == 2) { //-----------------------------------------RIVISTA
            System.out.println("Input magazine ISBN");
            String ISBN = scanner.nextLine();
            System.out.println("What's the magazine title?");
            String title = scanner.nextLine();
            if (!allISBN.contains(ISBN)) {
                allISBN.add(ISBN);
            } else {
                throw new CathalogException("This ISBN already exists");
            }
            System.out.println("In which year was the magazine published?");
            int yearPublished = scanner.nextInt();
            scanner.nextLine();
            System.out.println("How many pages does the magazine have?");
            int numberOfPages = scanner.nextInt();
            scanner.nextLine();
            System.out.println("What is the regularity of the magazine? 1: weekly, 2:monthly, 3:biannual");
            int regularityInput = scanner.nextInt();
            scanner.nextLine();

            Regularity regularity = null;

            switch (regularityInput) {
                case 1:
                    regularity = Regularity.WEEKLY;
                    break;
                case 2:
                    regularity = Regularity.MONTHLY;
                    break;
                case 3:
                    regularity = Regularity.BIANNUAL;
                    break;
                default:
                    System.out.println("Invalid regularity input. Please choose from 1 to 3.");
            }
            if (regularity != null) {
                Magazine magazine = new Magazine(ISBN, title, yearPublished, numberOfPages, regularity);
                publicationByISBN.put(ISBN, magazine);
                System.out.println("Magazine created successfully!");
            }
        } else {
            throw new CathalogException("Invalid input. Please choose between 1 and 2.");
        }
    }

    //METODO PER CERCARE UN LIBRO O RIVISTA TRAMITE ISBN

    public static void searchByISBN() throws ISBNNotFoundException {
        System.out.println("Enter the ISBN to search for:");
        String isbnToSearch = scanner.nextLine();

        if (publicationByISBN.containsKey(isbnToSearch)) {
            Publication foundPublication = publicationByISBN.get(isbnToSearch);
            System.out.println("Publication with ISBN " + isbnToSearch + " found.");
            System.out.println("Title: " + foundPublication.getTitle());
            System.out.println("Year Published: " + foundPublication.getYearPublished());
            System.out.println("Number of Pages: " + foundPublication.getNumberOfPages());
            System.out.println(foundPublication);
        } else {
            throw new ISBNNotFoundException("ISBN not found in the archive.");
        }
    }

    //METODO PER ElIMINARE UN LIBRO O RIVISTA TRAMITE ISBN

    public static void deleteByISBN() throws ISBNNotFoundException {
        System.out.println("Enter the ISBN to delete:");
        String isbnToDelete = scanner.nextLine();

        if (publicationByISBN.containsKey(isbnToDelete)) {
            Publication deletedPublication = publicationByISBN.remove(isbnToDelete);
            System.out.println("Publication with ISBN " + isbnToDelete + " deleted successfully.");
        } else {
            throw new ISBNNotFoundException("ISBN not found in the archive.");
        }
    }

    //METODO PER CERCARE UN LIBRO O RIVISTA TRAMITE ANNO DI PUBBLICAZIONE

    public static void searchByYearPublished() throws CathalogException {
        System.out.println("Enter the year to search for:");
        int yearToSearch = scanner.nextInt();
        scanner.nextLine();

        boolean found = false;
        for (Publication publication : publicationByISBN.values()) {
            if (publication.getYearPublished() == yearToSearch) {
                found = true;
                System.out.println("Publication published in the year " + yearToSearch + " found:");
                System.out.println("ISBN: " + publication.getISBN());
                System.out.println("Title: " + publication.getTitle());
                System.out.println("Number of Pages: " + publication.getNumberOfPages());
                System.out.println(publication);
            }
        }
        if (!found) {
            throw new CathalogException("No publications found for year: " + yearToSearch);
        }
    }

    //METODO PER CERCARE UN LIBRO TRAMITE AUTORE

    public static void searchByAuthor() throws CathalogException {
        System.out.println("Enter the author to search for:");
        String authorToSearch = scanner.nextLine();

        boolean found = false;
        for (Book book : bookCollection) {
            if (Objects.equals(book.getAuthor(), authorToSearch)) {
                found = true;
                System.out.println("Book author " + authorToSearch + " found:");
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Title: " + book.getTitle());
                System.out.println("Year Published: " + book.getYearPublished());
                System.out.println("Number of Pages: " + book.getNumberOfPages());
                System.out.println(book);
            }
        }
        if (!found) {
            throw new CathalogException("No books found for year: " + authorToSearch);
        }
    }

    //METODO PER MODIFICARE UN LIBRO O RIVISTA TRAMITE ISBN

    public static void updateByISBN() throws ISBNNotFoundException {
        System.out.println("Enter the ISBN of the publication to update:");
        String isbnToUpdate = scanner.nextLine();

        if (publicationByISBN.containsKey(isbnToUpdate)) {
            Publication publicationToUpdate = publicationByISBN.get(isbnToUpdate);

            System.out.println("Enter the new title (leave blank to keep the current one):");
            String newTitle = scanner.nextLine();
            if (!newTitle.isEmpty()) {
                publicationToUpdate.setTitle(newTitle);
            }

            System.out.println("Enter the new year published (leave blank to keep the current one):");
            String newYearPublished = scanner.nextLine();
            if (!newYearPublished.isEmpty()) {
                publicationToUpdate.setYearPublished(Integer.parseInt(newYearPublished));
            }

            System.out.println("Enter the new number of pages (leave blank to keep the current one):");
            String newNumberOfPages = scanner.nextLine();
            if (!newNumberOfPages.isEmpty()) {
                try {
                    publicationToUpdate.setNumberOfPages(Integer.parseInt(newNumberOfPages));
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number of pages format. Please enter a valid integer.");
                }
            }

            publicationByISBN.put(isbnToUpdate, publicationToUpdate);
            System.out.println("Publication with ISBN " + isbnToUpdate + " updated successfully.");
        } else {
            throw new ISBNNotFoundException("ISBN not found in the archive.");
        }
    }

    //METODO PER STAMPARE LE STATISTICHE DELL'ARCHIVIO

    public static void printBookAndMagazineCounts() {
        if (publicationByISBN.isEmpty()) {
            System.out.println("Status error.");
        } else {
            int bookCount = 0;
            int magazineCount = 0;

            for (Publication publication : publicationByISBN.values()) {
                if (publication instanceof Book) {
                    bookCount++;
                } else if (publication instanceof Magazine) {
                    magazineCount++;
                }
            }

            System.out.println("Total number of books: " + bookCount);
            System.out.println("Total number of magazines: " + magazineCount);
        }
    }

    public static void printProductWithMostPages() {
        if (publicationByISBN.isEmpty()) {
            System.out.println("The archive is empty.");
        } else {
            Publication productWithMostPages = publicationByISBN.values().stream()
                    .max(Comparator.comparingInt(Publication::getNumberOfPages))
                    .orElse(null);

                System.out.println("The product with the most pages is " + productWithMostPages.getTitle());
        }
    }

    public static void printAveragePages() {
        if (publicationByISBN.isEmpty()) {
            System.out.println("Please tray again after importing some publications.");
        } else {

            double averagePages = publicationByISBN.values().stream()
                    .mapToInt(Publication::getNumberOfPages)
                    .average()
                    .orElse(0.0);

            System.out.println("The average number of pages is: " + averagePages);
        }
    }
}
