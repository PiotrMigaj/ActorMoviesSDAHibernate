package pl.migibud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Actor;
import pl.migibud.model.Movie;

public class App
{
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Movie movie = new Movie("Harry Potter",2010);
		movie.addActor(new Actor("Daniel","Radcliff",1989));
		session.persist(movie);

		transaction.commit();
		session.close();

	}
}
