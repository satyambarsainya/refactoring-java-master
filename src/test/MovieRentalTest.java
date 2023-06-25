package test;

import main.MovieRental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MovieRentalTest {

    @Test
    void getMovieId() {
        String expectedMovieId = "F001";
        MovieRental movieRental = new MovieRental(expectedMovieId, 5);
        Assertions.assertEquals(expectedMovieId, movieRental.getMovieId());
    }

    @Test
    void getDays() {
        int expectedDays = 3;
        MovieRental movieRental = new MovieRental("F001", expectedDays);
        Assertions.assertEquals(expectedDays, movieRental.getDays());
    }
}