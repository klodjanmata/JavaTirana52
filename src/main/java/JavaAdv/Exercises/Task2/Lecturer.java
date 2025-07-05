package JavaAdv.Exercises.Task2;

public class Lecturer extends Person{
    private String specialization;
    private int salary;

    public Lecturer(int salary, String specialization) {
        this.salary = salary;
        this.specialization = specialization;
    }

    public Lecturer(String name, String address, int salary, String specialization) {
        super(name, address);
        this.salary = salary;
        this.specialization = specialization;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Lecturer{" + super.toString() + "\t" +
                "specialization='" + specialization + '\'' +
                ", salary=" + salary +
                '}';
    }
}