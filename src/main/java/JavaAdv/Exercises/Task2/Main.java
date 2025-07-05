package JavaAdv.Exercises.Task2;

public class Main {
    public static void main(String[] args) {
        Person p = new Lecturer(4000, "Mish dhe Peshk");
        System.out.println(p.toString());

        p = new Student("Emiljano", "Puka", "Java Developer", 1, 1000);
        System.out.println(p.toString());

        Student student = new Student("Informatike", 2, 1500);
        System.out.println(student);

        Lecturer lecturer = new Lecturer("Kristjana", "Orikum", 5000, "Web Development");
        System.out.println(lecturer);
    }
}
