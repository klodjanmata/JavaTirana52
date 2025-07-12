package JavaAdv.Exercises.Collections.Task2;

public enum Genre {
    DRAMA,
    NOVEL,
    POESY,
    ROMANCE,
    ROMAN,
    FANTASY,
    SCIENCE_FICTION,
    BIOGRAPHY,
    ENCYCLOPEDIA;

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[ ");

        for (Genre genre : Genre.values()) {
            result.append(genre);
            result.append(", ");
        }

        result.append(" ]");
        return result.toString();
    }
}
