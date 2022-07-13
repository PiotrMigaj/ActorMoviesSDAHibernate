package pl.migibud.model;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "genres")

@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = "movies",callSuper = true)
public class Genre extends BaseEntity {

	String name;

	@OneToMany(mappedBy = "genre")
	@ToString.Exclude
	Set<Movie> movies = new HashSet<>();

	public Genre(String name) {
		this.name = name;
	}
}
