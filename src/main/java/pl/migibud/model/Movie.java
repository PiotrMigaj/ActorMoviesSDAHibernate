package pl.migibud.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "movies")

@NoArgsConstructor
@Getter
@Setter


public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String title;
	int yearOfRelease;

	public Movie(String title, int yearOfRelease) {
		this.title = title;
		this.yearOfRelease = yearOfRelease;
	}

	@ManyToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE},mappedBy = "movies")
	Set<Actor> actors = new HashSet<>();

	public void addActor(Actor actor){
		this.actors.add(actor);
		actor.addMovie(this);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Movie movie = (Movie) o;
		return yearOfRelease == movie.yearOfRelease && Objects.equals(id, movie.id) && Objects.equals(title, movie.title);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, yearOfRelease);
	}
}
