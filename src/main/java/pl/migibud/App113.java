package pl.migibud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Actor;
import pl.migibud.model.Movie;
import pl.migibud.repos.MovieRepo;

import java.util.Optional;

public class App113 {
	public static void main(String[] args) {

		MovieRepo movieRepo = new MovieRepo(HibernateUtil.getSessionFactory());
		Optional<Movie> byId = movieRepo.findById(5L);

		System.out.println(byId.isEmpty());


	}
}
