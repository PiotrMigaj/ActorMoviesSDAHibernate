package pl.migibud.testremove;

import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) {

		Set<Film> films = new HashSet<>();
		films.add(new Film("Harry Potter"));

		Film film = new Film("Harry Potter");
		film.setId(1L);

		films.add(film);

		System.out.println(films);


	}
}
