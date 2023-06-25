package test;

import main.Movie;
import main.MovieCatalog;
import main.MovieRental;
import main.RentalCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RentalCalculatorTest {

    private MovieCatalog movieCatalog;

    @BeforeEach
    void setUp() {
        movieCatalog = new MovieCatalog();
        movieCatalog.addMovie("F001", new Movie("You've Got Mail", "regular"));
        movieCatalog.addMovie("F002", new Movie("Matrix", "regular"));
        movieCatalog.addMovie("F003", new Movie("Cars", "children"));
        movieCatalog.addMovie("F004", new Movie("Fast & Furious X", "new"));
    }

    @Test
    void calculateAmount_regularMovie() {
        MovieRental rental = new MovieRental("F001", 3);
        double expectedAmount = 3.5;
        double actualAmount = RentalCalculator.calculateAmount(rental, movieCatalog);
        Assertions.assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void calculateAmount_newMovie() {
        MovieRental rental = new MovieRental("F004", 2);
        double expectedAmount = 6.0;
        double actualAmount = RentalCalculator.calculateAmount(rental, movieCatalog);
        Assertions.assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void calculateAmount_childrenMovie() {
        MovieRental rental = new MovieRental("F003", 4);
        double expectedAmount = 3.0;
        double actualAmount = RentalCalculator.calculateAmount(rental, movieCatalog);
        Assertions.assertEquals(expectedAmount, actualAmount);
    }

    @Test
    void calculateFrequentEnterPoints_regularMovie() {
        MovieRental rental = new MovieRental("F001", 3);
        int expectedPoints = 1;
        int actualPoints = RentalCalculator.calculateFrequentEnterPoints(rental, movieCatalog);
        Assertions.assertEquals(expectedPoints, actualPoints);
    }

    @Test
    void calculateFrequentEnterPoints_newMovie() {
        MovieRental rental = new MovieRental("F004", 3);
        int expectedPoints = 2;
        int actualPoints = RentalCalculator.calculateFrequentEnterPoints(rental, movieCatalog);
        Assertions.assertEquals(expectedPoints, actualPoints);
    }
}