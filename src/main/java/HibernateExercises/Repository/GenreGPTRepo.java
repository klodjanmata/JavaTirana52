package HibernateExercises.Repository;

import HibernateExercises.Entity.Genre;

public class GenreGPTRepo extends GenericRepository<Genre, Long>{

    public GenreGPTRepo(Class<Genre> entityClass) {
        super(entityClass);
    }

}
