public class Student {

    private int id;
    private String name;
    private int age;
    private String course;

    // Constructor
    public Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    // Getter Methods
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student ID : " + id +
               "\nName       : " + name +
               "\nAge        : " + age +
               "\nCourse     : " + course;
    }
}