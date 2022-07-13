package pl.migibud.repos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import pl.migibud.model.Genre;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class GenreRepo {

	private final SessionFactory sessionFactory;

	public GenreRepo(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public List<Genre> findAll() {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		List<Genre> genres = session.createQuery("FROM Genre", Genre.class).getResultList();
		transaction.commit();
		session.close();
		return genres;
	}

	public Optional<Genre> findById(Long id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Optional<Genre> genre = Optional.ofNullable(session.get(Genre.class, id));
		transaction.commit();
		session.close();
		return genre;
	}

	public Optional<Genre> findByName(String name) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		String hql = "FROM Genre G WHERE G.name = :genre_name";
		List<Genre> resultList = session.createQuery(hql, Genre.class)
				.setParameter("genre_name", name)
				.getResultList();
		Optional<Genre> genre = resultList.stream().findAny();

		transaction.commit();
		session.close();
		return genre;
	}

	public Genre addGenre(Genre genre) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.persist(genre);
			transaction.commit();
			return genre;
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
			return null;
		} finally {
			session.close();
		}
	}

	public void removeGenre(Genre genre) {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			Long genreId = session.createQuery("FROM Genre", Genre.class).getResultList()
					.stream()
					.filter(g -> g.getName().equals(genre.getName()))
					.map(n -> n.getId())
					.findFirst()
					.get();

			Genre genre1 = session.get(Genre.class, genreId);
			genre1.getMovies().forEach(movie -> movie.setGenre(null));

			session.remove(genre1);
			transaction.commit();
		} catch (NoSuchElementException e) {
			System.out.println("There is no genre with name: "+genre.getName());
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}

		} finally {
			session.close();
		}
	}


}
