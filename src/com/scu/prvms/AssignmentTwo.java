package com.scu.prvms;

/**
 * Main class for the PROG2004 Assignment 2, containing demo methods for all modules.
 */
public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo demo = new AssignmentTwo();
        demo.partThree();
        demo.partFourA(); // Add: Call history management test
        demo.partFourB(); // Add: Call history sorting test
        demo.partFive();
        demo.partSixSevenFileIO();
    }

    /** Demo method for Part 3: Queue Management */
    public void partThree() {
        System.out.println("\n=== Part3 Queue Management Demo ===");
        Employee operator = new Employee("E001", "Mr. Zhang", "13800138000", "EMP001", "Morning");
        Ride rollerCoaster = new Ride("R001", "Roller Coaster", operator, 2);

        Visitor v1 = new Visitor("V001", "Xiao Ming", "13900139001", "T001", true);
        Visitor v2 = new Visitor("V002", "Xiao Hong", "13900139002", "T002", false);
        Visitor v3 = new Visitor("V003", "Xiao Gang", "13900139003", "T003", true);
        Visitor v4 = new Visitor("V004", "Xiao Li", "13900139004", "T004", false);
        Visitor v5 = new Visitor("V005", "Xiao Qiang", "13900139005", "T005", true);
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        rollerCoaster.printQueue();
        rollerCoaster.removeVisitorFromQueue();
        System.out.println("\n=== After Removal ===");
        rollerCoaster.printQueue();
    }

    /** Demo method for Part 4A: Ride History Management */
    public void partFourA() {
        // Add: Fill in partFourA test logic
        System.out.println("\n=== Part4A Ride History Demo ===");
        Employee op = new Employee("E001", "Mr. Zhang", "13800138000", "EMP001", "Morning");
        Ride roller = new Ride("R001", "Roller Coaster", op, 2);

        Visitor v1 = new Visitor("V001", "Xiao Ming", "13900139001", "T001", true);
        Visitor v2 = new Visitor("V002", "Xiao Hong", "13900139002", "T002", false);
        Visitor v3 = new Visitor("V003", "Xiao Gang", "13900139003", "T003", true);
        Visitor v4 = new Visitor("V004", "Xiao Li", "13900139004", "T004", false);
        Visitor v5 = new Visitor("V005", "Xiao Qiang", "13900139005", "T005", true);
        roller.addVisitorToHistory(v1);
        roller.addVisitorToHistory(v2);
        roller.addVisitorToHistory(v3);
        roller.addVisitorToHistory(v4);
        roller.addVisitorToHistory(v5);

        System.out.println("History count: " + roller.numberOfVisitors());
        Visitor checkV3 = new Visitor("", "", "", "T003", true);
        System.out.println("Is Xiao Gang in history? " + (roller.checkVisitorFromHistory(checkV3) ? "Yes" : "No"));
        roller.printRideHistory();
    }

    /** Demo method for Part 4B: History Sorting */
    public void partFourB() {
        // Add: Fill in partFourB test logic
        System.out.println("\n=== Part4B History Sorting Demo ===");
        Employee op = new Employee("E001", "Mr. Zhang", "13800138000", "EMP001", "Morning");
        Ride roller = new Ride("R001", "Roller Coaster", op, 2);

        Visitor v1 = new Visitor("V001", "Xiao Ming", "13900139001", "T001", true);
        Visitor v2 = new Visitor("V002", "Xiao Hong", "13900139002", "T002", false);
        Visitor v3 = new Visitor("V003", "Xiao Gang", "13900139003", "T003", true);
        Visitor v4 = new Visitor("V004", "Xiao Li", "13900139004", "T004", false);
        Visitor v5 = new Visitor("V005", "Xiao Qiang", "13900139005", "T005", true);
        roller.addVisitorToHistory(v1);
        roller.addVisitorToHistory(v2);
        roller.addVisitorToHistory(v3);
        roller.addVisitorToHistory(v4);
        roller.addVisitorToHistory(v5);

        System.out.println("=== Before Sorting ===");
        roller.printRideHistory();
        roller.sortRideHistory();
        System.out.println("\n=== After Sorting ===");
        roller.printRideHistory();
    }

    /** Demo method for Part 5: Ride Cycle Execution */
    public void partFive() {
        // Print a header to clearly indicate the start of this demonstration
        System.out.println("\n=== Part5: Ride Cycle Execution Demo ===");

        // --- 1. Initialize Test Data ---
        // Create an Employee object to act as the ride operator
        Employee rideOperator = new Employee("E001", "Mr. Zhang", "13800138000", "EMP001", "Morning");

        // Create a Ride object (Roller Coaster) with a maximum capacity of 2 visitors
        Ride rollerCoaster = new Ride("R001", "Roller Coaster", rideOperator, 2);

        // Create 10 Visitor objects (mix of members and non-members) to populate the queue
        Visitor v1 = new Visitor("V001", "Xiao Ming", "13900139001", "T001", true);   // Member
        Visitor v2 = new Visitor("V002", "Xiao Hong", "13900139002", "T002", false);  // Non-Member
        Visitor v3 = new Visitor("V003", "Xiao Gang", "13900139003", "T003", true);   // Member
        Visitor v4 = new Visitor("V004", "Xiao Li", "13900139004", "T004", false);    // Non-Member
        Visitor v5 = new Visitor("V005", "Xiao Qiang", "13900139005", "T005", true);  // Member
        Visitor v6 = new Visitor("V006", "Xiao Mei", "13900139006", "T006", false);   // Non-Member
        Visitor v7 = new Visitor("V007", "Xiao Liang", "13900139007", "T007", true);  // Member
        Visitor v8 = new Visitor("V008", "Xiao Min", "13900139008", "T008", false);   // Non-Member
        Visitor v9 = new Visitor("V009", "Xiao Yu", "13900139009", "T009", true);     // Member
        Visitor v10 = new Visitor("V010", "Xiao Qi", "13900139010", "T010", false);   // Non-Member

        // Add all created visitors to the ride's waiting queue (FIFO order)
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);
        rollerCoaster.addVisitorToQueue(v6);
        rollerCoaster.addVisitorToQueue(v7);
        rollerCoaster.addVisitorToQueue(v8);
        rollerCoaster.addVisitorToQueue(v9);
        rollerCoaster.addVisitorToQueue(v10);

        // --- 2. Pre-Cycle State Validation ---
        System.out.println("\n=== Pre-Cycle State ===");
        System.out.println("Waiting Queue (before cycle):");
        rollerCoaster.printQueue(); // Display the full queue (10 visitors) before the ride cycle

        // --- 3. Execute the Ride Cycle ---
        // This single method call encapsulates the entire ride process:
        // Check → Load → Simulate → Unload → Record History
        rollerCoaster.runOneCycle();

        // --- 4. Post-Cycle State Validation ---
        System.out.println("\n=== Post-Cycle State ===");

        // Validate queue modification: should contain 8 visitors (first 2 removed)
        System.out.println("Waiting Queue (after cycle):");
        rollerCoaster.printQueue();

        // Validate history recording: should contain the 2 visitors who just rode
        System.out.println("\nRide History (after cycle):");
        rollerCoaster.printRideHistory();

        // Validate cycle counter increment: should now be 1
        System.out.println("\nTotal Cycles Executed: " + rollerCoaster.getNumOfCycles());
    }

    /** Demo method for Part 6: File Export */
    public void partSixSevenFileIO() {
        System.out.println("\n=== Part6-7: File I/O (Export & Import) Demo ===");
        Employee operator = new Employee("E001", "Mr. Zhang", "13800138000", "EMP001", "Morning");
        Ride rollerCoaster = new Ride("R001", "Roller Coaster", operator, 2);
        String csvFilePath = "ride_history.csv"; // File path (saved in project root directory)

        // 1. Prepare test data for export
        Visitor v1 = new Visitor("V001", "Xiao Ming", "13900139001", "T001", true);
        Visitor v2 = new Visitor("V002", "Xiao Hong", "13900139002", "T002", false);
        Visitor v3 = new Visitor("V003", "Xiao Gang", "13900139003", "T003", true);
        rollerCoaster.addVisitorToHistory(v1);
        rollerCoaster.addVisitorToHistory(v2);
        rollerCoaster.addVisitorToHistory(v3);

        // 2. Export history to CSV file
        System.out.println("\n[Step 1: Export Ride History to CSV]");
        System.out.println("History before export (count: " + rollerCoaster.numberOfVisitors() + "):");
        rollerCoaster.printRideHistory();

        rollerCoaster.exportRideHistory(csvFilePath);

        // 3. Clear existing history to test import (avoids mixing old/new data)
        System.out.println("\n[Step 2: Clear History for Import Validation]");
        rollerCoaster.getRideHistory().clear();
        System.out.println("History after clear (count: " + rollerCoaster.numberOfVisitors() + "):");
        rollerCoaster.printRideHistory();

        // 4. Import history from CSV file and verify
        System.out.println("\n[Step 3: Import Ride History from CSV]");
        rollerCoaster.importRideHistory(csvFilePath);

        System.out.println("History after import (count: " + rollerCoaster.numberOfVisitors() + "):");
        rollerCoaster.printRideHistory();
    }
}