import java.util.ArrayList;
import java.util.Scanner;

public class Trainer {

    private String Name;
    private String Id;

    // Stores members in a class and their attendance status
    private final ArrayList<String> classRoster;
    private final ArrayList<String> attendanceStatus;

    // Default constructor
    public Trainer() {
        this.Name = "Unknown Trainer";
        this.Id = "T-000";
        this.classRoster = new ArrayList<>();
        this.attendanceStatus = new ArrayList<>();
    }

    // Constructor with parameters
    public Trainer(String name, String id) {
        this.Name = name;
        this.Id = id;
        this.classRoster = new ArrayList<>();
        this.attendanceStatus = new ArrayList<>();
    }

    // Getter for trainer name
    protected String getName() {
        return Name;
    }

    // Getter for trainer ID
    public String getId() {
        return Id;
    }

    // Setter for name
    public void setName(String name) {
        this.Name = name;
    }

    // Setter for ID
    public void setId(String id) {
        this.Id = id;
    }

    // Adds a member to the class roster
    public void addMemberToRoster(String memberName) {
        if (memberName == null || memberName.trim().isEmpty()) {
            System.out.println("Invalid name.");
            return;
        }

        classRoster.add(memberName);
        attendanceStatus.add("Not Marked"); // Default attendance state
        System.out.println(memberName + " added to roster.");
    }

    // Displays all members in the class
    public void viewClassRoster() {
        System.out.println("\n=== Class Roster (" + Name + ") ===");

        if (classRoster.isEmpty()) {
            System.out.println("No members in this class.");
            return;
        }

        for (int i = 0; i < classRoster.size(); i++) {
            System.out.println((i + 1) + ". " + classRoster.get(i)
                    + " | Status: " + attendanceStatus.get(i));
        }
    }

    // Allows trainer to mark attendance via console
    public void markAttendance() {
        Scanner scan = new Scanner(System.in);

        if (classRoster.isEmpty()) {
            System.out.println("No members to mark.");
            return;
        }

        boolean running = true;

        while (running) {
            viewClassRoster();

            System.out.println("\n1. Mark present");
            System.out.println("2. Mark no-show");
            System.out.println("3. Mark remaining as present");
            System.out.println("4. Return");
            System.out.print("Choice: ");

            int choice = readInt(scan);

            switch (choice) {
                case 1:
                    updateAttendance(scan, "Present");
                    break;
                case 2:
                    updateAttendance(scan, "No-Show");
                    break;
                case 3:
                    // Marks all unmarked members as present
                    for (int i = 0; i < attendanceStatus.size(); i++) {
                        if (attendanceStatus.get(i).equals("Not Marked")) {
                            attendanceStatus.set(i, "Present");
                        }
                    }
                    System.out.println("All remaining marked present.");
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    // Calculates no-show percentage for reporting
    public double getNoShowRate() {
        if (classRoster.isEmpty()) {
            return 0.0;
        }

        int noShowCount = 0;

        for (String status : attendanceStatus) {
            if (status.equalsIgnoreCase("No-Show")) {
                noShowCount++;
            }
        }

        return (noShowCount * 100.0) / classRoster.size();
    }

    // Updates attendance for a selected member
    private void updateAttendance(Scanner scan, String status) {
        System.out.print("Select member number: ");
        int index = readInt(scan) - 1;

        if (index < 0 || index >= classRoster.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        attendanceStatus.set(index, status);
        System.out.println(classRoster.get(index) + " marked as " + status + ".");
    }

    // Helper method to safely read integers
    private int readInt(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scan.nextLine();
        }
        int value = scan.nextInt();
        scan.nextLine();
        return value;
    }
}