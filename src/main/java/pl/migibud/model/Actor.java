package pl.migibud.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actors")

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Actor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	String name, lastName;
	int yearOfBirth;

	public Actor(String name, String lastName, int yearOfBirth) {
		this.name = name;
		this.lastName = lastName;
		this.yearOfBirth = yearOfBirth;
	}

	@ManyToMany
	@JoinTable(
			name = "actors_to_movies",
			joinColumns = @JoinColumn(name = "actor_id"),
			inverseJoinColumns = @JoinColumn(name = "movie_id")
	)
	Set<Movie> movies = new HashSet<>();
}
