package pl.migibud.repos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import pl.migibud.model.Actor;

import java.util.List;
import java.util.Optional;

public class ActorRepo {

	private final SessionFactory sessionFactory;

	public ActorRepo(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Actor addActor(Actor actor){

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		try{
			session.persist(actor);
			transaction.commit();
			return actor;
		}catch (Exception e){
			e.printStackTrace();
			if (transaction!=null){
				transaction.rollback();
			}
			return null;
		}finally {
			session.close();
		}
	}

	public Optional<Actor> findById(Long id){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Actor actor = session.get(Actor.class, id);
		transaction.commit();
		session.close();
		return Optional.ofNullable(actor);
	}

	public List<Actor> findAllBornAfter(int lowerBoundExclusive){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();

		List<Actor> year = session.createQuery("SELECT a FROM Actor a WHERE a.yearOfBirth> :year", Actor.class)
				.setParameter("year", lowerBoundExclusive)
				.getResultList();

		transaction.commit();
		session.close();
		return year;
	}
}
