package pl.migibud;

import pl.migibud.model.Genre;
import pl.migibud.repos.GenreRepo;

public class App104 {
	public static void main(String[] args) {

		GenreRepo genreRepo = new GenreRepo(HibernateUtil.getSessionFactory());
		Genre genre = new Genre("Fantasy");
		genreRepo.removeGenre(genre);


	}
}
