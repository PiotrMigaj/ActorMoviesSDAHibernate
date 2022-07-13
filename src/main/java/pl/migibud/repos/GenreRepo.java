package pl.migibud.repos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Genre;

import java.util.List;
import java.util.Optional;

public class GenreRepo {

	private final SessionFactory sessionFactory;

	public GenreRepo(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Genre> findAll(){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Genre> genres = session.createQuery("FROM Genre", Genre.class).getResultList();
		transaction.commit();
		session.close();
		return genres;
	}

	public Optional<Genre> findById(Long id){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Optional<Genre> genre = Optional.ofNullable(session.get(Genre.class,id));
		transaction.commit();
		session.close();
		return genre;
	}
}
