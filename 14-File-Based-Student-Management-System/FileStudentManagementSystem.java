import java.io.*;
import java.util.*;

public class FileStudentManagementSystem {

    static final String FILE_NAME = "students.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== FILE STUDENT MANAGEMENT ==========");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    // Add Student
    static void addStudent() {

        try {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Department: ");
            String dept = sc.nextLine();

            System.out.print("Enter CGPA: ");
            double cgpa = sc.nextDouble();

            Student student = new Student(id, name, dept, cgpa);

            FileWriter fw = new FileWriter(FILE_NAME, true);

            fw.write(student.toString() + "\n");

            fw.close();

            System.out.println("Student Added Successfully!");

        } catch (IOException e) {
            System.out.println("File Error!");
        }
    }

    // View Students
    static void viewStudents() {

        try {

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println("-------------------------");
                System.out.println("ID         : " + data[0]);
                System.out.println("Name       : " + data[1]);
                System.out.println("Department : " + data[2]);
                System.out.println("CGPA       : " + data[3]);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File Error!");
        }
    }

    // Search Student
    static void searchStudent() {

        try {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) == id) {

                    System.out.println("Student Found");
                    System.out.println("ID         : " + data[0]);
                    System.out.println("Name       : " + data[1]);
                    System.out.println("Department : " + data[2]);
                    System.out.println("CGPA       : " + data[3]);

                    br.close();
                    return;
                }
            }

            br.close();

            System.out.println("Student Not Found.");

        } catch (IOException e) {
            System.out.println("File Error!");
        }
    }

    // Delete Student
    static void deleteStudent() {

        try {

            System.out.print("Enter Student ID: ");
            int id = sc.nextInt();

            File inputFile = new File(FILE_NAME);
            File tempFile = new File("temp.txt");

            BufferedReader br = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile));

            String line;
            boolean found = false;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) == id) {
                    found = true;
                    continue;
                }

                bw.write(line);
                bw.newLine();
            }

            br.close();
            bw.close();

            inputFile.delete();
            tempFile.renameTo(inputFile);

            if (found)
                System.out.println("Student Deleted Successfully!");
            else
                System.out.println("Student Not Found.");

        } catch (IOException e) {
            System.out.println("File Error!");
        }
    }
}