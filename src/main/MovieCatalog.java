package main;

import java.util.HashMap;

public class MovieCatalog {
    private final HashMap<String, Movie> movies;

    public MovieCatalog() {
        movies = new HashMap<>();
    }

    public void addMovie(String movieId, Movie movie) {
        movies.put(movieId, movie);
    }

    public String getMovieTitle(String movieId) {
        Movie movie = movies.get(movieId);
        return movie != null ? movie.getTitle() : null;
    }

    public String getMovieCode(String movieId) {
        Movie movie = movies.get(movieId);
        return movie != null ? movie.getCode() : null;
    }
}
