package pl.migibud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Genre;
import pl.migibud.model.Movie;

public class App3
{
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Genre genre = session.get(Genre.class, 2L);
		Movie movie = session.get(Movie.class, 1L);
		movie.setGenre(genre);

		transaction.commit();
		session.close();

	}
}
