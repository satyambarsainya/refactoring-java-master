package main;

import java.util.stream.Collectors;

public class RentalInfo {

    private final MovieCatalog movieCatalog;

    public RentalInfo(MovieCatalog movieCatalog) {
        this.movieCatalog = movieCatalog;
    }

    public String statement(Customer customer) {
        double totalAmount = customer.getRentals().stream()
                .mapToDouble(r -> RentalCalculator.calculateAmount(r, movieCatalog))
                .sum();

        int frequentEnterPoints = customer.getRentals().stream()
                .mapToInt(r -> RentalCalculator.calculateFrequentEnterPoints(r, movieCatalog))
                .sum();

        return "Rental Record for " + customer.getName() + "\n" +
               customer.getRentals().stream()
                       .map(r -> "\t" + movieCatalog.getMovieTitle(r.getMovieId()) + "\t" + RentalCalculator.calculateAmount(r, movieCatalog))
                       .collect(Collectors.joining("\n")) +
               "\nAmount owed is " + totalAmount + "\n" +
               "You earned " + frequentEnterPoints + " frequent points\n";
    }
}
