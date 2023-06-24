import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    String expected = "Rental Record for C. U. Stomer\n\tYou've Got Mail\t3.5\n\tMatrix\t2.0\nAmount owed is 5.5\nYou earned 2 frequent points\n";

    MovieCatalog movieCatalog = new MovieCatalog();
    movieCatalog.addMovie("F001", new Movie("You've Got Mail", "regular"));
    movieCatalog.addMovie("F002", new Movie("Matrix", "regular"));
    movieCatalog.addMovie("F003", new Movie("Cars", "childrens"));
    movieCatalog.addMovie("F004", new Movie("Fast & Furious X", "new"));

    RentalInfo rentalInfo = new RentalInfo(movieCatalog);

    String result = rentalInfo.statement(new Customer("C. U. Stomer", Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1))));

    if (!result.equals(expected)) {
      throw new AssertionError("Expected: " + System.lineSeparator() + String.format(expected) + System.lineSeparator() + System.lineSeparator() + "Got: " + System.lineSeparator() + result);
    }

    System.out.println("Success");
  }
}
