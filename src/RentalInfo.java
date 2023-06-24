public class RentalInfo {

  private final MovieCatalog movieCatalog;

  public RentalInfo(MovieCatalog movieCatalog) {
    this.movieCatalog = movieCatalog;
  }

  public String statement(Customer customer) {
    double totalAmount = 0;
    int frequentEnterPoints = 0;
    String result = "Rental Record for " + customer.getName() + "\n";

    for (MovieRental r : customer.getRentals()) {
      double thisAmount = RentalCalculator.calculateAmount(r, movieCatalog);

      frequentEnterPoints += RentalCalculator.calculateFrequentEnterPoints(r, movieCatalog);

      result += "\t" + movieCatalog.getMovieTitle(r.getMovieId()) + "\t" + thisAmount + "\n";
      totalAmount += thisAmount;
    }

    result += "Amount owed is " + totalAmount + "\n";
    result += "You earned " + frequentEnterPoints + " frequent points\n";

    return result;
  }
}
