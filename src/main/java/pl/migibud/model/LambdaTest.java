package pl.migibud.model;

import java.util.ArrayList;
import java.util.List;

public class LambdaTest {


	public static void main(String[] args) {
		Movie movie1 = new Movie("W", 1994);
		Movie movie2 = new Movie("X", 1995);
		Movie movie3 = new Movie("Y", 1996);
		Movie movie4 = new Movie("W", 1997);

		List<Movie> movies = new ArrayList<>();
		movies.add(movie1);
		movies.add(movie2);
		movies.add(movie3);
		movies.add(movie4);


		movies.forEach(System.out::println);
		movies.forEach(movie -> movie.setTitle(movie.getTitle().equals("w") ? null : "W"));
		movies.forEach(System.out::println);
	}
}
