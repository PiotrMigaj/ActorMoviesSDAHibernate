package pl.migibud;

import pl.migibud.model.Movie;
import pl.migibud.repos.MovieRepo;

import java.util.List;
import java.util.Optional;

public class App114 {
	public static void main(String[] args) {

		MovieRepo movieRepo = new MovieRepo(HibernateUtil.getSessionFactory());

		List<Movie> all = movieRepo.findAll();

		System.out.println(all);


	}
}
