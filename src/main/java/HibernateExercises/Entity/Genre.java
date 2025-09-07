package HibernateExercises.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Table(name = "genre")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
}
