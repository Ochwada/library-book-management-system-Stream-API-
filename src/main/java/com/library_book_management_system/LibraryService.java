package com.library_book_management_system;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * *******************************************************
 * Package: com.library_book_management_system
 * File: LibraryService.java
 * Author: Ochwada
 * Date: Friday, 13.Jun.2025, 2:19 PM
 * Description: Contains methods that demonstrate intermediate and terminal steam operations.
 * Objective: Class with only methods THAT manages the Book library
 * *******************************************************
 */


public class LibraryService {

    /**
     * Filters books that have stock (number of copies) below the specified threshold.
     * <p>
     * This method uses Java Stream API's {@code filter()} intermediate operation to
     * select books whose available copies are less than the given stock value.
     * <p>
     * The result is collected into a list using {@code toList()}.
     *
     * @param bookInventory the list of books to check
     * @param stock         the stock threshold; books with fewer copies than this value will be included
     * @return a list of books where copies in stock are below the given threshold
     */
    public List<Books> filterLowStockBooks(List<Books> bookInventory, int stock) {
        return bookInventory.stream()
                .filter(book -> book.getCopies() < stock) // Intermediate operation: filtering
                .toList(); // Terminal operation: collect result into list

    }


    /**
     * Retrieves a list of all book titles in uppercase, with duplicates removed and sorted alphabetically.
     * This method uses Java Stream API to:
     * <ul>
     *   <li>Convert each book title to uppercase ({@code map()}).</li>
     *   <li>Remove duplicate titles ({@code distinct()}).</li>
     *   <li>Sort the titles alphabetically ({@code sorted()}).</li>
     *   <li>Collect the final result into a list ({@code toList()}).</li>
     * </ul>
     *
     * @param bookInventory the list of books to process
     * @return a list of unique, sorted, uppercase book titles
     */
    public List<String> allBooksTitlesUpper(List<Books> bookInventory) {
        return bookInventory.stream()
                .map(book -> book.getTitle().toUpperCase()) // Intermediate: convert titles to uppercase
                .distinct() // Intermediate: remove duplicates
                .sorted() // Intermediate: sort alphabetically
                .toList(); // Terminal: collect into list
    }

    /**
     * Groups books by their genre.
     * <p>
     * This method processes the provided list of books and organizes them into groups
     * based on their genre using Java Stream API's {@code groupingBy()} collector.
     * <p>
     * The result is a {@code Map} where:
     * <ul>
     *   <li>The key is the genre name (as a {@code String}).</li>
     *   <li>The value is a list of {@code Books} that belong to that genre.</li>
     * </ul>
     *
     * @param bookInventory the list of books to group
     * @return a map where each key is a genre and its value is the list of books belonging to that genre
     */
    public Map<String, List<Books>> groupByGenre(List<Books> bookInventory) {
        return bookInventory.stream()
                .collect(Collectors.groupingBy(Books::getGenre)); //Terminal: collect into groups

    }

    /**
     * Partitions books into digital and physical formats.
     * <p>
     * This method processes the provided list of books and separates them into two groups
     * based on their digital availability using Java Stream API's {@code groupingBy()} collector.
     * <p>
     * The result is a {@code Map<Boolean, List<Books>>} where:
     * <ul>
     *   <li>{@code true} key contains books that are available in digital format.</li>
     *   <li>{@code false} key contains books that are physical (non-digital).</li>
     * </ul>
     *
     * @param bookInventory the list of books to partition
     * @return a map where keys represent whether the book is digital (true) or physical (false)
     */
    public Map<Boolean, List<Books>> partitionDigitalOrPhysical(List<Books> bookInventory) {
        return bookInventory.stream()
                .collect(Collectors.groupingBy(Books::isDigital));
    }

    /**
     * Calculates the total inventory value of all books.
     * <p>
     * This method computes the total value by multiplying the price and number of copies
     * for each book, and then summing these values using Java Stream API's {@code map()}
     * and {@code reduce()} operations.
     * <p>
     * The result is the sum of all individual book values.
     *
     * @param bookInventory the list of books in inventory
     * @return the total inventory value as a double
     */
    public double totalInventory(List<Books> bookInventory) {
        return bookInventory.stream()
                .map(book -> book.getPrice() * book.getCopies())
                .reduce(0.0, Double::sum);
    }

    // Find the most expensive book
    public Optional<Books> mostExpensiveBook(List<Books> bookInventory){
        return  bookInventory.stream()
                .max(Comparator.comparing(Books::getPrice));
    }
}
