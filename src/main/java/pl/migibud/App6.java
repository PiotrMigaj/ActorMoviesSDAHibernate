package pl.migibud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Actor;
import pl.migibud.model.Movie;

public class App6
{
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Actor actor = new Actor("Piotr","Migaj",1992);
		actor.getMovies().add(session.get(Movie.class,1L));
		session.persist(actor);


		transaction.commit();
		session.close();

	}
}
