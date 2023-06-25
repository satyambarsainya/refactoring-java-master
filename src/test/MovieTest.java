package test;

import main.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MovieTest {

    @Test
    void getTitle() {
        String expectedTitle = "Movie Title";
        Movie movie = new Movie(expectedTitle, "regular");
        Assertions.assertEquals(expectedTitle, movie.getTitle());
    }

    @Test
    void getCode() {
        String expectedCode = "regular";
        Movie movie = new Movie("Movie Title", expectedCode);
        Assertions.assertEquals(expectedCode, movie.getCode());
    }
}