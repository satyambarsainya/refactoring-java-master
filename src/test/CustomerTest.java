package test;

import main.Customer;
import main.MovieRental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class CustomerTest {

    private Customer customer;
    private List<MovieRental> rentals;

    @BeforeEach
    void setUp() {
        rentals = Arrays.asList(new MovieRental("F001", 3), new MovieRental("F002", 1));
        customer = new Customer("C. U. Stomer", rentals);
    }

    @Test
    void getName() {
        String expectedName = "C. U. Stomer";
        Assertions.assertEquals(expectedName, customer.getName());
    }

    @Test
    void getRentals() {
        Assertions.assertEquals(rentals, customer.getRentals());
    }
}