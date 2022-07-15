package pl.migibud.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "actors")

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "movies",callSuper = true)
public class Actor extends BaseEntity{
	String name, lastName;
	int yearOfBirth;

	public Actor(String name, String lastName, int yearOfBirth) {
		this.name = name;
		this.lastName = lastName;
		this.yearOfBirth = yearOfBirth;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	@ToString.Exclude
	@JoinTable(
			name = "actors_to_movies",
			joinColumns = @JoinColumn(name = "actor_id"),
			inverseJoinColumns = @JoinColumn(name = "movie_id")
	)
	Set<Movie> movies = new HashSet<>();

	public void addMovie(Movie movie){
		this.movies.add(movie);
	}
}
