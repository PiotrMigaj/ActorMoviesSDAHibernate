package pl.migibud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Actor;
import pl.migibud.model.Movie;
import pl.migibud.repos.MovieRepo;

public class App112 {
	public static void main(String[] args) {

		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Movie movie = session.get(Movie.class, 6L);
		movie.addActor(new Actor("Julia","Roberts",1972));

		session.persist(movie);

		transaction.commit();
		session.close();
	}
}
