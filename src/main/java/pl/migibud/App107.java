package pl.migibud;

import pl.migibud.model.Actor;
import pl.migibud.repos.ActorRepo;

import java.util.List;
import java.util.Optional;

public class App107 {
	public static void main(String[] args) {

		ActorRepo actorRepo = new ActorRepo(HibernateUtil.getSessionFactory());
		List<Actor> allBornAfter = actorRepo.findAllBornAfter(1993);
		System.out.println(allBornAfter);
	}
}
