# Refactoring Java

The code creates an information slip about movie rentals.
Rewrite and improve the code after your own liking.

Think: you are responsible for the solution, this is a solution you will have to put your name on.

## Handing in the assignment

Reason how you have been thinking and the decisions you took.
You can hand in the result any way you feel (git patch, pull-request or ZIP-file).
Note: the Git history must be included.

## To run the test:

```
javac src/*.java
java -cp src main.Main
```

### **Single Responsibility Principle (SRP): Each class should have a single responsibility.**

```
RentalInfo.java:

  Extracted the movie information into a separate class i.e MovieCatalog which is responsible for storing 
  and retrieving movie details.
```

```
Customer.java:

  No changes needed. It already has a single responsibility.
```

```
Main.java:

  I have changed some code in order to create MovieCatalog object and add movie to it and later this object 
  to the RentalInfo object.
```

```
Movie.java:

  No changes needed. It represents a movie and has a single responsibility.
```

```
MovieRental.java:

  No changes needed. It represents a movie rental and has a single responsibility.
```

### **Open-Closed Principle (OCP): Classes should be open for extension but closed for modification.**

```
RentalInfo.java:

  I have moved the calculation of the rental amount for each movie to a separate class i.e into 
  RentalCalculator which can be easily extended to handle different types of movies.
```

### **Dependency Inversion Principle (DIP): High-level modules should not depend on low-level modules; both should depend on abstractions.**

```
RentalInfo.java:

  Extracted the movie information dependency into a MovieCatalog class and passed an instance of this class 
  to the RentalInfo class.
```
### I have also added Unit Test Cases for every class in the project.
### I have made use of Java 8 wherever possible