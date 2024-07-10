import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

public class NoteTaking {
    private static Map<String, String> notes = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to the Note Taking App!");

        boolean running = true;
        while (running) {
            System.out.println("\nOptions: \n1. Create Note \n2. View Note \n3. List Notes \n4. Delete Note \n5. Export Note \n6. Modify Note \n7. Exit ");
            System.out.print("Choose an option: ");
            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    createNote();
                    break;
                case "2":
                    viewNote();
                    break;
                case "3":
                    listNotes();
                    break;
                case "4":
                    deleteNote();
                    break;
                case "5":
                    exportNotes();
                    break;
                case "6":
                    modifyNote();
                    break;
                case "7":
                    running = false;
                    System.out.println("Exiting Note Taking App. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void createNote() {
        System.out.print("Enter note title: ");
        String title = scanner.nextLine();
        System.out.print("Enter note content: ");
        String content = scanner.nextLine();

        notes.put(title, content);
        System.out.println("Note created successfully.");
    }

    private static void viewNote() {
        System.out.print("Enter note title to view: ");
        String title = scanner.nextLine();

        if (notes.containsKey(title)) {
            System.out.println("Content: " + notes.get(title));
        } else {
            System.out.println("Note not found.");
        }
    }

    private static void listNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes found.");
        } else {
            System.out.println("Notes:");
            notes.keySet().forEach(title -> System.out.println("- " + title));
        }
    }

    private static void deleteNote() {
        System.out.print("Enter note title to delete: ");
        String title = scanner.nextLine();

        if (notes.remove(title) != null) {
            System.out.println("Note deleted successfully.");
        } else {
            System.out.println("Note not found.");
        }
    }

    private static void exportNotes() {
        try (FileWriter writer = new FileWriter("notes_export.txt")) {
        for (Map.Entry<String, String> entry : notes.entrySet()) {
            writer.write("Title: " + entry.getKey() + "\nContent: " + entry.getValue() + "\n\n");
        }
        System.out.println("Notes exported successfully to notes_export.txt");
    } catch (IOException e) {
        System.out.println("An error occurred while exporting notes.");
        e.printStackTrace();
        }
    }

private static void modifyNote() {
    System.out.print("Enter the title of the note you want to modify: ");
    String title = scanner.nextLine();

    if (notes.containsKey(title)) {
        System.out.print("Enter new content for the note: ");
        String newContent = scanner.nextLine();
        notes.put(title, newContent);
        System.out.println("Note modified successfully.");
    } else {
        System.out.println("Note not found.");
        }
    }

}