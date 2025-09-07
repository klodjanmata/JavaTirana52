package HibernateExercises.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@Entity
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "year_of_release")
    private int yearOfRelease;

    @OneToOne
    private Genre genre;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

}
