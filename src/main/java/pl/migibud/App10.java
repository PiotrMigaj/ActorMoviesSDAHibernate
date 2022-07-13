package pl.migibud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Movie;

public class App10 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();


		Movie movie = session.get(Movie.class, 2L);
		movie.getActors().forEach(a->a.getMovies().clear());
		session.remove(movie);

//		Actor actor = session.get(Actor.class,5L);
//		session.remove(actor);


		transaction.commit();
		session.close();

	}
}
