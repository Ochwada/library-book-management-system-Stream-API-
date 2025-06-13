package com.library_book_management_system;

import java.util.List;

/**
 * Demo Class
 */
public class App {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();

        List<Books> bookInventory = List.of(
                new Books("The Hobbit", "J.R.R. Tolkien", "Fantasy", 15.99, 50, false),
                new Books("1984", "George Orwell", "Dystopian", 12.50, 80, true),
                new Books("To Kill a Mockingbird", "Harper Lee", "Classic", 10.99, 120, true),
                new Books("Clean Code", "Robert C. Martin", "Programming", 35.00, 40, false),
                new Books("The Pragmatic Programmer", "Andrew Hunt", "Programming", 42.50, 30, true),
                new Books("Sapiens", "Yuval Noah Harari", "History", 18.20, 70, true),
                new Books("The Great Gatsby", "F. Scott Fitzgerald", "Classic", 9.99, 90, false),
                new Books("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "Fantasy", 25.00, 60, false)
        );

        // ------------------
        System.out.println("\n=== Low Stock Books(< 50 copies) ===\n");
        service.filterLowStockBooks(bookInventory, 50).forEach(System.out::println);

        // ------------------
        System.out.println("\n=== List all Book Titles (uppercase, sorted, no duplicates) ===\n");
        service.allBooksTitlesUpper(bookInventory).forEach(System.out::println);

        // ------------------
        System.out.println("\n === Group books by genre === \n");
        service.groupByGenre(bookInventory).forEach((genre, books) -> {
            System.out.println("Genre: " + genre); // Genre Title
            books.forEach(book -> // Loop through the books and print
            {
                System.out.println("    -" + book.getTitle());
            });
        });

        // ------------------
        System.out.println("\n === Partition books into digital vs physical === \n");
        service.partitionDigitalOrPhysical(bookInventory).forEach(
                (partition, books) ->
                {
                    System.out.println((partition ? "\n--Digital--\n" : "\n--Physical--\n") + books);
                });

        // ------------------
        System.out.println("\n === Calculate Total Inventory Value  === \n");
        double total  = service.totalInventory(bookInventory);
        System.out.println("€ " + String.format("%.2f", total));

        // ------------------
        System.out.println("\n === Most Expensive Book  === \n");
        System.out.println(service.mostExpensiveBook(bookInventory));


    }
}
