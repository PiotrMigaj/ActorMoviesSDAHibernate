package pl.migibud.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "movies")

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
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
}
