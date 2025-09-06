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
@Table(name = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "year_of_release")
    private String yearOfRelease;

    @OneToOne
    private Genre genres;

    @ManyToMany(mappedBy = "movies")
    private List<Actor> actors;

}
