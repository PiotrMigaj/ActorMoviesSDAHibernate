package pl.migibud;

import pl.migibud.model.Actor;
import pl.migibud.model.Movie;
import pl.migibud.repos.MovieRepo;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class App116 {
	public static void main(String[] args) {

		MovieRepo movieRepo = new MovieRepo(HibernateUtil.getSessionFactory());

		List<Movie> harryPotter = movieRepo.findAll();

		Set<Actor> collect = harryPotter.stream()
				.flatMap(m -> m.getActors().stream())
				.collect(Collectors.toSet());

		System.out.println(collect);


	}
}
