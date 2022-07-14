package pl.migibud.repos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.BaseEntity;
import pl.migibud.model.Movie;

import java.util.List;
import java.util.Optional;

public class MovieRepo {

	private final SessionFactory sessionFactory;

	public MovieRepo(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Movie addMovie(Movie movie) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try {
			session.persist(movie);
			transaction.commit();
			return movie;
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

	public void removeMovie(Movie movie) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			String hql = "SELECT m FROM Movie m";
			List<Movie> resultList = session.createQuery(hql, Movie.class)
					.getResultList();
			System.out.println(resultList);
			Long movieId = resultList.stream().filter(m -> m.equals(movie)).map(BaseEntity::getId).findFirst().get();
			System.out.println(movieId);

			Movie movie1 = session.get(Movie.class, movieId);
			movie1.getActors().stream().forEach(a->a.getMovies().remove(movie1));
			movie1.getActors().clear();

			session.remove(movie1);

			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null) {
				transaction.rollback();
			}
		} finally {
			session.close();
		}

	}

	public Optional<Movie> findById(Long id){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		try {
			Movie movie = session.get(Movie.class, id);
			System.out.println(movie);
			return Optional.ofNullable(movie);
		}catch (Exception e){
			e.printStackTrace();
			if (transaction!=null){
				transaction.rollback();
			}
			return Optional.empty();
		}finally {
			session.close();
		}
	}
}
