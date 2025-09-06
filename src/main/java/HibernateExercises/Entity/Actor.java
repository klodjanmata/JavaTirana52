package HibernateExercises.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "actor")
public class Actor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @ManyToMany
    private List<Movie> movies;

}
