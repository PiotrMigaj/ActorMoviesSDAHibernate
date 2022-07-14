package pl.migibud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Genre;
import pl.migibud.model.Movie;
import pl.migibud.repos.MovieRepo;

public class App110 {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Genre genre = new Genre("Classic");
		session.persist(genre);
		System.out.println(genre.getId());
		Movie movie = session.get(Movie.class, 3L);
		genre.getMovies().add(movie);
		movie.setGenre(genre);


		transaction.commit();
		session.close();
	}
}
