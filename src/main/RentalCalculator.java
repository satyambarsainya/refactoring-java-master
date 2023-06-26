package main;

public class RentalCalculator {

    public static double calculateAmount(MovieRental rental, MovieCatalog movieCatalog) {
        double amount = 0;

        String movieCode = movieCatalog.getMovieCode(rental.getMovieId());

        switch (movieCode) {
            case "regular":
                amount = 2 + Math.max(0, rental.getDays() - 2) * 1.5;
                break;
            case "new":
                amount = rental.getDays() * 3;
                break;
            case "children":
                amount = 1.5 + Math.max(0, rental.getDays() - 3) * 1.5;
                break;
        }

        return amount;
    }

    public static int calculateFrequentEnterPoints(MovieRental rental, MovieCatalog movieCatalog) {
        int frequentEnterPoints = 1;

        String movieCode = movieCatalog.getMovieCode(rental.getMovieId());

        if (movieCode.equals("new") && rental.getDays() > 2) {
            frequentEnterPoints++;
        }

        return frequentEnterPoints;
    }
}
