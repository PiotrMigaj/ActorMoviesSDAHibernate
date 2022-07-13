package pl.migibud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Actor;
import pl.migibud.model.Genre;
import pl.migibud.model.Movie;

public class App11 {
	public static void main(String[] args) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();


		Actor actor1 = new Actor("Piotr","Migaj",1992);
		Actor actor2 = new Actor("Anna","Migaj",1994);
		Actor actor3 = new Actor("Basia","Migaj",2022);

		Movie movie1 = new Movie("Harry Potter",1999);
		movie1.addActor(actor1);
		movie1.addActor(actor2);

		Movie movie2 = new Movie("Władca Pierścieni",2030);
		movie2.addActor(actor2);
		movie2.addActor(actor3);
		movie2.setGenre(new Genre("Fantasy"));

		session.persist(movie1);
		session.persist(movie2);


		transaction.commit();
		session.close();

	}
}
