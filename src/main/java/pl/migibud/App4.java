package pl.migibud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Genre;
import pl.migibud.model.Movie;

public class App4
{
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		Genre genre = session.get(Genre.class, 1L);
		genre.getMovies().stream().forEach(m->m.setGenre(null));
		session.remove(genre);

		transaction.commit();
		session.close();

	}
}
