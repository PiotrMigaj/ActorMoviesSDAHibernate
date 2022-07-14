package pl.migibud;

import pl.migibud.model.Movie;
import pl.migibud.repos.MovieRepo;

public class App111 {
	public static void main(String[] args) {

		MovieRepo movieRepo = new MovieRepo(HibernateUtil.getSessionFactory());
		Movie movie = new Movie("Przeminęło z wiatrem",1966);
		movieRepo.removeMovie(movie);
	}
}
