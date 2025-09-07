package HibernateExercises.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

    @ManyToMany(mappedBy = "movies", fetch = FetchType.EAGER)
    private List<Actor> actors;

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", genre=" + genre +
                ", actors=" + actors == null ? "null" : actors.toString() +
                '}';
    }
}
