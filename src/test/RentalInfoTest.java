package test;

import main.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class RentalInfoTest {

    private MovieCatalog movieCatalog;
    private RentalInfo rentalInfo;

    @BeforeEach
    void setUp() {
        movieCatalog = new MovieCatalog();
        movieCatalog.addMovie("F001", new Movie("You've Got Mail", "regular"));
        movieCatalog.addMovie("F002", new Movie("Matrix", "regular"));
        movieCatalog.addMovie("F003", new Movie("Cars", "children"));
        movieCatalog.addMovie("F004", new Movie("Fast & Furious X", "new"));
        rentalInfo = new RentalInfo(movieCatalog);
    }

    @Test
    void statement() {
        Customer customer = new Customer("C. U. Stomer", Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1)));
        String expectedStatement = """
                Rental Record for C. U. Stomer
                \tYou've Got Mail\t3.5
                \tMatrix\t2.0
                Amount owed is 5.5
                You earned 2 frequent points
                """;
        String actualStatement = rentalInfo.statement(customer);
        Assertions.assertEquals(expectedStatement, actualStatement);
    }
}







