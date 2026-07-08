import java.io.*;
import java.util.Scanner;

public class NotesManager {

    static final String FILE_NAME = "notes.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n========== NOTES MANAGER ==========");
            System.out.println("1. Add Note");
            System.out.println("2. View Notes");
            System.out.println("3. Search Note");
            System.out.println("4. Delete Note");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addNote();
                    break;

                case 2:
                    viewNotes();
                    break;

                case 3:
                    searchNote();
                    break;

                case 4:
                    deleteNote();
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

    // Add Note
    static void addNote() {

        try {

            System.out.print("Enter Note ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Title: ");
            String title = sc.nextLine();

            System.out.print("Enter Content: ");
            String content = sc.nextLine();

            Note note = new Note(id, title, content);

            FileWriter fw = new FileWriter(FILE_NAME, true);
            fw.write(note.toString() + "\n");
            fw.close();

            System.out.println("Note Added Successfully!");

        } catch (IOException e) {
            System.out.println("File Error!");
        }
    }

    // View Notes
    static void viewNotes() {

        try {

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                System.out.println("-------------------------");
                System.out.println("ID      : " + data[0]);
                System.out.println("Title   : " + data[1]);
                System.out.println("Content : " + data[2]);
            }

            br.close();

        } catch (IOException e) {
            System.out.println("File Error!");
        }
    }

    // Search Note
    static void searchNote() {

        try {

            System.out.print("Enter Note ID: ");
            int id = sc.nextInt();

            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) == id) {

                    System.out.println("Note Found!");
                    System.out.println("ID      : " + data[0]);
                    System.out.println("Title   : " + data[1]);
                    System.out.println("Content : " + data[2]);

                    br.close();
                    return;
                }
            }

            br.close();

            System.out.println("Note Not Found.");

        } catch (IOException e) {
            System.out.println("File Error!");
        }
    }

    // Delete Note
    static void deleteNote() {

        try {

            System.out.print("Enter Note ID: ");
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
                System.out.println("Note Deleted Successfully!");
            else
                System.out.println("Note Not Found.");

        } catch (IOException e) {
            System.out.println("File Error!");
        }
    }
}