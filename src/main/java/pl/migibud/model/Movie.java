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
@ToString
public class Movie extends BaseEntity{

	String title;
	int yearOfRelease;

	public Movie(String title, int yearOfRelease) {
		this.title = title;
		this.yearOfRelease = yearOfRelease;
	}

	public Movie(String title, int yearOfRelease, Genre genre) {
		this.title = title;
		this.yearOfRelease = yearOfRelease;
		this.genre = genre;
	}

	@ManyToMany(cascade = {CascadeType.PERSIST}, mappedBy = "movies")
	Set<Actor> actors = new HashSet<>();

	@ManyToOne(cascade = {CascadeType.PERSIST})
	@JoinColumn(name = "genre_id")
	Genre genre;

	public void addActor(Actor actor) {
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
		return yearOfRelease == movie.yearOfRelease && Objects.equals(title, movie.title) && Objects.equals(genre, movie.genre);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, yearOfRelease, genre);
	}
}
