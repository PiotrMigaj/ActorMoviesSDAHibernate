package pl.migibud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Actor;
import pl.migibud.model.Genre;
import pl.migibud.model.Movie;

public class App12 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Movie movie = session.get(Movie.class, 2L);
		movie.getActors().stream()
				.forEach(actor -> actor.getMovies().remove(movie));
//		movie.getActors().stream()
//				.forEach(actor -> actor.getMovies().forEach(movie1 -> movie1.setId(movie1.getId().equals(2L)?null:2L)));
//		session.remove(movie);

		transaction.commit();
		session.close();

	}
}
