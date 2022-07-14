package pl.migibud;

import pl.migibud.model.Actor;
import pl.migibud.model.Movie;
import pl.migibud.repos.ActorRepo;
import pl.migibud.repos.MovieRepo;

import java.util.List;

public class App109 {
	public static void main(String[] args) {

		MovieRepo movieRepo = new MovieRepo(HibernateUtil.getSessionFactory());
		movieRepo.addMovie(new Movie("Przeminęło z wiatrem",1966));
	}
}
