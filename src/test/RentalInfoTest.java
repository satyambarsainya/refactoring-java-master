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
        String expectedStatement = "Rental Record for C. U. Stomer\n" +
                                   customer.getRentals().stream()
                                           .map(rental -> "\t" + movieCatalog.getMovieTitle(rental.getMovieId()) + "\t" + RentalCalculator.calculateAmount(rental, movieCatalog))
                                           .reduce("", (acc, rentalInfo) -> acc + rentalInfo + "\n") +
                                   "Amount owed is " + calculateTotalAmount(customer) + "\n" +
                                   "You earned " + calculateTotalFrequentEnterPoints(customer) + " frequent points\n";
        String actualStatement = rentalInfo.statement(customer);
        Assertions.assertEquals(expectedStatement, actualStatement);
    }

    private double calculateTotalAmount(Customer customer) {
        return customer.getRentals().stream()
                .mapToDouble(rental -> RentalCalculator.calculateAmount(rental, movieCatalog))
                .sum();
    }

    private int calculateTotalFrequentEnterPoints(Customer customer) {
        return customer.getRentals().stream()
                .mapToInt(rental -> RentalCalculator.calculateFrequentEnterPoints(rental, movieCatalog))
                .sum();
    }
}
