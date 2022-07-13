package pl.migibud;

import pl.migibud.model.Genre;
import pl.migibud.repos.GenreRepo;

public class App103 {
	public static void main(String[] args) {

		GenreRepo genreRepo = new GenreRepo(HibernateUtil.getSessionFactory());
		System.out.println(genreRepo.findAll());

		Genre genre = new Genre("Comedy");
		Genre genre1 = genreRepo.addGenre(genre);

		System.out.println(genre==genre1);
	}
}
