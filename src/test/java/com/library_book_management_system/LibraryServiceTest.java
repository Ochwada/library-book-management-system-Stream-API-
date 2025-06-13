package com.library_book_management_system;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Arrays;
import java.util.Map;

/**
 * *******************************************************
 * Package: com.library_book_management_system
 * File: LibraryServiceTest.java
 * Author: Ochwada
 * Date: Friday, 13.Jun.2025, 2:19 PM
 * Description:
 * Objective:
 * *******************************************************
 */


public class LibraryServiceTest {

    private LibraryService service;
    private List<Books> sampleBooks;

    @BeforeAll // JUnit runs this once before any test method in this class.
    static void beforeAllTests() {
        System.out.println("\uD83E\uDDFF Stating LibraryService Tests...  ");
    }

    @BeforeEach
    void setUp() {
        System.out.println("\uD83D\uDD38 New Setup: Create a new object.");

        service = new LibraryService();

        sampleBooks = List.of(
                new Books("The Alchemist", "Paulo Coelho", "Philosophy", 14.99, 65, true),
                new Books("The Silent Patient", "Alex Michaelides", "Thriller", 19.99, 45, true),
                new Books("Thinking, Fast and Slow", "Daniel Kahneman", "Psychology", 21.00, 55, false),
                new Books("The Lean Startup", "Eric Ries", "Business", 29.99, 35, true)
        );
    }

    @AfterEach
    void tearDown(TestInfo testInfo) {
        System.out.println("✔\uFE0FTest Passed: 📃 " + testInfo.getDisplayName());
    }

    @AfterAll
    static void afterAllTests() {
        System.out.println("✅  LibraryServiceTest ✨ Tests  Successfully Done ✨");
    }

    // -----------------------------------------------------
    // TESTS
    // -----------------------------------------------------
    @Test
    @DisplayName("Filter Low Stock Books Test")
    void testFilterLowStockBooks() {
        List<Books> lowStock = service.filterLowStockBooks(sampleBooks, 50);
        assertEquals(2, lowStock.size());
    }

    @Test
    @DisplayName("Total Inventory")
    void testTotalInventory() {
        double expectedTotal =
                14.99 * 65 +
                        19.99 * 45 +
                        21.00 * 55 +
                        29.99 * 35;
        double totalValue = service.totalInventory(sampleBooks);
        assertEquals(expectedTotal, totalValue, 0.01);
    }

    @Test
    @DisplayName("Most Expensive Book")
    void testMostExpensiveBook() {
        assertTrue(service.mostExpensiveBook(sampleBooks).isPresent());
        assertEquals("The Lean Startup", service.mostExpensiveBook(sampleBooks).get().getTitle());
    }

    @Test
    @DisplayName("Partition Digital Or Physical")
    void  testPartitionDigitalOrPhysical(){
        Map<Boolean, List<Books>> result = service.partitionDigitalOrPhysical(sampleBooks);

        int isDigital = result.get(true).size();
        int isPhysical = result.get(false).size();

        assertEquals(3,isDigital);
        assertEquals(1, isPhysical);

    }

}
