package pl.migibud;

import pl.migibud.HibernateUtil;
import pl.migibud.model.Genre;
import pl.migibud.repos.GenreRepo;

public class App101 {
	public static void main(String[] args) {

		GenreRepo genreRepo = new GenreRepo(HibernateUtil.getSessionFactory());
		System.out.println(genreRepo.findAll());

		Genre genre = genreRepo.findById(1L).get();
		System.out.println(genre);

	}
}
