package test;

import main.Movie;
import main.MovieCatalog;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MovieCatalogTest {

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
    void getMovieTitle() {
        String expectedTitle = "You've Got Mail";
        Assertions.assertEquals(expectedTitle, movieCatalog.getMovieTitle("F001"));
    }

    @Test
    void getMovieCode() {
        String expectedCode = "regular";
        Assertions.assertEquals(expectedCode, movieCatalog.getMovieCode("F001"));
    }
}