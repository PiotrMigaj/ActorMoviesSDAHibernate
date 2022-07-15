package pl.migibud;

import pl.migibud.model.Movie;
import pl.migibud.repos.MovieRepo;

import java.util.List;
import java.util.Optional;

public class App115 {
	public static void main(String[] args) {

		MovieRepo movieRepo = new MovieRepo(HibernateUtil.getSessionFactory());

		Optional<Movie> harryPotter = movieRepo.findMovieByTitle("Harry Potter");

		System.out.println(harryPotter.get());


	}
}
