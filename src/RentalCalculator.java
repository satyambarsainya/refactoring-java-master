public class RentalCalculator {

    public static double calculateAmount(MovieRental rental, MovieCatalog movieCatalog) {
        double amount = 0;

        String movieCode = movieCatalog.getMovieCode(rental.getMovieId());

        switch (movieCode) {
            case "regular" -> {
                amount = 2;
                if (rental.getDays() > 2) {
                    amount += (rental.getDays() - 2) * 1.5;
                }
            }
            case "new" -> amount = rental.getDays() * 3;
            case "children" -> {
                amount = 1.5;
                if (rental.getDays() > 3) {
                    amount += (rental.getDays() - 3) * 1.5;
                }
            }
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
