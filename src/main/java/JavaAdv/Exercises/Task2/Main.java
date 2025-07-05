package JavaAdv.Exercises.Task2;

import JavaAdv.Exercises.Helper;

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

        System.out.println("Getting student from user: ");
        Student studentFromUser = new Student();
        studentFromUser.setName(Helper.getStringFromUser("Name"));
        studentFromUser.setAddress(Helper.getStringFromUser("Address"));
        studentFromUser.setTypeOfStudy(Helper.getStringFromUser("TypeOfStudy"));
        studentFromUser.setYearOfStudy(Helper.getIntFromUser("YearOfStudy"));
        studentFromUser.setStudyPrice(Helper.getIntFromUser("PriceOfStudy"));
        System.out.println(studentFromUser);
    }
}
