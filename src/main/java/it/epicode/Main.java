package it.epicode;

import javax.xml.catalog.CatalogException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws CatalogException, ISBNNotFoundException {
        Scanner scanner = new Scanner(System.in);
        boolean choice = true;

        while (choice) {
            System.out.println("----------------------------------- " +
                    "\nWhat do you want to do?" +
                    "\n1: Create a book or a magazine" +
                    "\n2: Search through ISBN" +
                    "\n3: Delete through ISBN" +
                    "\n4: Search through year of publication" +
                    "\n5: Search book through author" +
                    "\n6: Update an element through ISBN" +
                    "\n7: Status" +
                    "\nOther number: Exit program");

            int userChoice = scanner.nextInt();
            scanner.nextLine();

            switch (userChoice) {
                case 1:
                    try {
                        Archive.createProduct();
                        break;
                    } catch (CathalogException e) {
                        throw new RuntimeException(e);
                    }
                case 2:
                    try {
                        Archive.searchByISBN();
                        break;
                    } catch (ISBNNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                case 3:
                    try {
                        Archive.deleteByISBN();
                        break;
                    } catch (ISBNNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                case 4:
                    try {
                        Archive.searchByYearPublished();
                        break;
                    } catch (CathalogException e) {
                        throw new RuntimeException(e);
                    }
                case 5:
                    try {
                        Archive.searchByAuthor();
                        break;
                    } catch (CathalogException e) {
                        throw new RuntimeException(e);
                    }
                case 6:
                    try {
                        Archive.updateByISBN();
                        break;
                    } catch (ISBNNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                case 7:
                    Archive.printBookAndMagazineCounts();
                    Archive.printProductWithMostPages();
                    Archive.printAveragePages();
                    break;
                default:
                    choice = false;
                    break;

            }
        }
    }
}
