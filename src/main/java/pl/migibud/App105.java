package pl.migibud;

import pl.migibud.model.Actor;
import pl.migibud.model.Genre;
import pl.migibud.repos.ActorRepo;
import pl.migibud.repos.GenreRepo;

public class App105 {
	public static void main(String[] args) {

		ActorRepo actorRepo = new ActorRepo(HibernateUtil.getSessionFactory());
		actorRepo.addActor(new Actor("Robert","deNiro",1960));
	}
}
