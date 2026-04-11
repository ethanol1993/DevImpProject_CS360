import java.util.ArrayList;
import java.util.Scanner;

public class controls {
    
    private String id;

    // Lists to simulate stored data
    private final ArrayList<String> memberNames = new ArrayList<>();
    private final ArrayList<String> membershipStatuses = new ArrayList<>();

    private final ArrayList<String> membershipPlans = new ArrayList<>();
    private final ArrayList<Double> membershipPrices = new ArrayList<>();

    // Default constructor
    public controls() {
        this.id = "CTRL-001";

        // Sample members
        memberNames.add("Alex");
        membershipStatuses.add("active");

        memberNames.add("Jordan");
        membershipStatuses.add("paused");

        memberNames.add("Taylor");
        membershipStatuses.add("expired");

        // Sample membership plans
        membershipPlans.add("Basic");
        membershipPrices.add(29.99);

        membershipPlans.add("Standard");
        membershipPrices.add(49.99);

        membershipPlans.add("Premium");
        membershipPrices.add(69.99);
    }

    // Overloaded constructor to allow custom ID
    public controls(String id) {
        this();
        this.id = id;
    }

    // Getter for ID
    public String getId() {
        return id;
    }

    // Setter for ID
    public void setId(String id){
        this.id = id;
    }

    // Admin and staff controls for managing members and membership plans

    public void manageMember() {
        Scanner scan = new Scanner(System.in);
        boolean running = true;

        // Loop until user chooses to exit
        while (running) {
            System.out.println("\n=== Admin / Staff Controls ===");
            System.out.println("1. View members");
            System.out.println("2. Update member membership status");
            System.out.println("3. Add membership plan");
            System.out.println("4. Update membership pricing");
            System.out.println("5. View membership plans");
            System.out.println("6. Return");
            System.out.print("Enter choice: ");

            int choice = readInt(scan);

            // Handle user selection
            switch (choice) {
                case 1:
                    displayMembers();
                    break;
                case 2:
                    updateMemberStatus(scan);
                    break;
                case 3:
                    addMembershipPlan(scan);
                    break;
                case 4:
                    updateMembershipPricing(scan);
                    break;
                case 5:
                    displayPlans();
                    break;
                case 6:
                    running = false;
                    System.out.println("Returning to previous menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Reports for admin and staff to view membership trends, attendance, and no-show rates

    public void viewReports() {
        System.out.println("\n=== Reports ===");

        int activeCount = 0;
        int pausedCount = 0;
        int expiredCount = 0;

        // Count membership statuses
        for (String status : membershipStatuses) {
            if (status.equalsIgnoreCase("active")) {
                activeCount++;
            } else if (status.equalsIgnoreCase("paused")) {
                pausedCount++;
            } else if (status.equalsIgnoreCase("expired")) {
                expiredCount++;
            }
        }

        // Display summary
        System.out.println("Total Members: " + memberNames.size());
        System.out.println("Active Memberships: " + activeCount);
        System.out.println("Paused Memberships: " + pausedCount);
        System.out.println("Expired Memberships: " + expiredCount);

        // Simulated reports based on case study requirements
        System.out.println("\nAttendance Trends:");
        System.out.println("- Morning attendance is steady.");
        System.out.println("- Evening classes have the highest turnout.");

        System.out.println("\nPeak Hours:");
        System.out.println("- 6:00 AM to 8:00 AM");
        System.out.println("- 5:00 PM to 7:00 PM");

        System.out.println("\nNo-Show Rates:");
        if (memberNames.isEmpty()) {
            System.out.println("- No data available.");
        } else {
            double estimatedNoShowRate = (expiredCount * 100.0) / memberNames.size();
            System.out.printf("- Estimated no-show rate: %.2f%%%n", estimatedNoShowRate);
        }
    }

    // ================================
    // HELPER METHODS
    // ================================

    // Displays all members and their membership status
    private void displayMembers() {
        System.out.println("\n--- Member List ---");
        if (memberNames.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        for (int i = 0; i < memberNames.size(); i++) {
            System.out.println((i + 1) + ". " + memberNames.get(i)
                    + " | Status: " + membershipStatuses.get(i));
        }
    }

    // Allows admin to update a member's membership status
    private void updateMemberStatus(Scanner scan) {
        if (memberNames.isEmpty()) {
            System.out.println("No members available to update.");
            return;
        }

        displayMembers();
        System.out.print("Select member number: ");
        int index = readInt(scan) - 1;

        if (index < 0 || index >= memberNames.size()) {
            System.out.println("Invalid member selection.");
            return;
        }

        System.out.println("Choose new status:");
        System.out.println("1. active");
        System.out.println("2. paused");
        System.out.println("3. expired");
        System.out.print("Enter choice: ");
        int statusChoice = readInt(scan);

        String newStatus;
        switch (statusChoice) {
            case 1: newStatus = "active"; break;
            case 2: newStatus = "paused"; break;
            case 3: newStatus = "expired"; break;
            default:
                System.out.println("Invalid status choice.");
                return;
        }

        membershipStatuses.set(index, newStatus);
        System.out.println(memberNames.get(index) + " membership updated to " + newStatus + ".");
    }

    // Adds a new membership plan and price
    private void addMembershipPlan(Scanner scan) {
        System.out.print("Enter new membership plan name: ");
        String planName = scan.nextLine().trim();

        if (planName.isEmpty()) {
            System.out.println("Plan name cannot be empty.");
            return;
        }

        System.out.print("Enter price: ");
        double price = readDouble(scan);

        membershipPlans.add(planName);
        membershipPrices.add(price);

        System.out.printf("Plan added: %s - $%.2f%n", planName, price);
    }

    // Updates pricing for an existing plan
    private void updateMembershipPricing(Scanner scan) {
        if (membershipPlans.isEmpty()) {
            System.out.println("No membership plans available.");
            return;
        }

        displayPlans();
        System.out.print("Select plan number: ");
        int index = readInt(scan) - 1;

        if (index < 0 || index >= membershipPlans.size()) {
            System.out.println("Invalid selection.");
            return;
        }

        System.out.print("Enter new price: ");
        double newPrice = readDouble(scan);

        membershipPrices.set(index, newPrice);
        System.out.printf("Updated %s to $%.2f%n", membershipPlans.get(index), newPrice);
    }

    // Displays all membership plans
    private void displayPlans() {
        System.out.println("\n--- Membership Plans ---");

        for (int i = 0; i < membershipPlans.size(); i++) {
            System.out.printf("%d. %s - $%.2f%n",
                    i + 1,
                    membershipPlans.get(i),
                    membershipPrices.get(i));
        }
    }

    // Safely reads an integer from user input
    private int readInt(Scanner scan) {
        while (!scan.hasNextInt()) {
            System.out.print("Enter a valid number: ");
            scan.nextLine();
        }
        int value = scan.nextInt();
        scan.nextLine();
        return value;
    }

    // Safely reads a double (price input)
    private double readDouble(Scanner scan) {
        while (!scan.hasNextDouble()) {
            System.out.print("Enter a valid number: ");
            scan.nextLine();
        }
        double value = scan.nextDouble();
        scan.nextLine();
        return value;
    }
}
