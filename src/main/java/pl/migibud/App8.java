package pl.migibud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Actor;
import pl.migibud.model.Movie;

public class App8 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();


		Actor actor = session.get(Actor.class, 7L);
		actor.getMovies().add(session.get(Movie.class,2L));


		transaction.commit();
		session.close();

	}
}
