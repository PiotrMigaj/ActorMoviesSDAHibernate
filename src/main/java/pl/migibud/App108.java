package pl.migibud;

import pl.migibud.model.Actor;
import pl.migibud.repos.ActorRepo;

import java.util.List;

public class App108 {
	public static void main(String[] args) {

		ActorRepo actorRepo = new ActorRepo(HibernateUtil.getSessionFactory());
		List<Actor> aj = actorRepo.findAllWithLastNameEndsWith("aj");
		System.out.println(aj);
	}
}
