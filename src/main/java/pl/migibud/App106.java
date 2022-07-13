package pl.migibud;

import pl.migibud.model.Actor;
import pl.migibud.repos.ActorRepo;

import java.util.Optional;

public class App106 {
	public static void main(String[] args) {

		ActorRepo actorRepo = new ActorRepo(HibernateUtil.getSessionFactory());
		Optional<Actor> byId = actorRepo.findById(5L);
		System.out.println(byId.orElseThrow(()->new RuntimeException("Lipa")));
	}
}
