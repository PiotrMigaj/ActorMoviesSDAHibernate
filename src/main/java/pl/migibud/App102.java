package pl.migibud;

import pl.migibud.model.Genre;
import pl.migibud.repos.GenreRepo;

public class App102 {
	public static void main(String[] args) {

		GenreRepo genreRepo = new GenreRepo(HibernateUtil.getSessionFactory());
		System.out.println(genreRepo.findAll());

		Genre genre = genreRepo.findByName("Fantasy").get();
		System.out.println(genre);



	}
}
