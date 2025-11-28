package com.scu.prvms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Collections;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Represents a theme park ride, implementing RideInterface to manage queues, history, and cycles.
 */
public class Ride implements RideInterface {
    private String rideId;
    private String rideName;
    private Employee operator;
    private Queue<Visitor> waitingLine = new LinkedList<>(); // FIFO queue for waiting visitors
    private LinkedList<Visitor> rideHistory = new LinkedList<>(); // History of visitors who rode
    private int maxRider; // Maximum visitors per cycle
    private int numOfCycles = 0; // Number of cycles the ride has run

    /**
     * Default constructor for Ride.
     */
    public Ride() {}

    /**
     * Parameterized constructor to initialize ride details.
     * @param rideId Unique ride ID
     * @param rideName Ride name
     * @param operator Employee operating the ride
     * @param maxRider Maximum visitors per cycle
     */
    public Ride(String rideId, String rideName, Employee operator, int maxRider) {
        this.rideId = rideId;
        this.rideName = rideName;
        this.operator = operator;
        this.maxRider = maxRider;
    }

    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }
    public int getNumOfCycles() { return numOfCycles; }
    public void setNumOfCycles(int numOfCycles) { this.numOfCycles = numOfCycles; }
    public Queue<Visitor> getWaitingLine() { return waitingLine; }
    public LinkedList<Visitor> getRideHistory() { return rideHistory; }

    // Part3: Queue Operations
    /**
     * Adds a visitor to the ride's waiting queue.
     * @param visitor Visitor to add; if null, prints an error message
     */
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Failed: Cannot add null visitor to queue");
            return;
        }
        waitingLine.add(visitor);
        System.out.println("Success: Visitor " + visitor.getName() + " added to " + rideName + " queue");
    }

    /**
     * Removes the front visitor from the waiting queue.
     * If the queue is empty, prints an error message.
     */
    @Override
    public void removeVisitorFromQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Failed: " + rideName + " queue is empty");
            return;
        }
        Visitor removed = waitingLine.poll();
        System.out.println("Success: Visitor " + removed.getName() + " removed from queue");
    }

    /**
     * Prints all visitors in the waiting queue with their details.
     */
    @Override
    public void printQueue() {
        System.out.println(rideName + " Waiting Queue (" + waitingLine.size() + " visitors):");
        if (waitingLine.isEmpty()) {
            System.out.println("No visitors");
            return;
        }
        int index = 1;
        for (Visitor v : waitingLine) {
            System.out.println(index + ". " + v.toString());
            index++;
        }
    }

    // Part4A: History Operations
    /**
     * Adds a visitor to the ride's history of riders.
     * @param visitor Visitor to add; if null, prints an error message
     */
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor == null) {
            System.out.println("Failed: Cannot add null visitor to history");
            return;
        }
        rideHistory.add(visitor);
        System.out.println("Success: Visitor " + visitor.getName() + " added to " + rideName + " history");
    }

    /**
     * Checks if a visitor exists in the ride's history (matches by ticket number).
     * @param visitor Visitor to check; returns false if null or history is empty
     * @return True if the visitor is found, false otherwise
     */
    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null || rideHistory.isEmpty()) return false;
        for (Visitor v : rideHistory) {
            if (v.getTicketNumber().equals(visitor.getTicketNumber())) return true;
        }
        return false;
    }

    /**
     * @return The number of visitors in the ride's history
     */
    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    /**
     * Prints all visitors in the ride's history using an Iterator.
     */
    @Override
    public void printRideHistory() {
        System.out.println(rideName + " Ride History (" + rideHistory.size() + " visitors):");
        if (rideHistory.isEmpty()) {
            System.out.println("No records");
            return;
        }
        Iterator<Visitor> it = rideHistory.iterator();
        int index = 1;
        while (it.hasNext()) {
            System.out.println(index + ". " + it.next().toString());
            index++;
        }
    }
    // Part4B: History Sorting
    /**
     * Sorts the ride history records. Rule: Members come first, then sort by name in ascending order.
     * If the history is empty, prints an error message and terminates sorting.
     */
    public void sortRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println("Failed: History is empty, cannot sort");
            return;
        }
        Collections.sort(rideHistory, new VisitorComparator());
        System.out.println("Success: History sorted (members first, name ascending)");
    }
    // Part5: Ride Cycle Execution
    /**
     * Executes a complete ride cycle: checking, loading, running, unloading, and recording history.
     * This method implements the RideInterface's runOneCycle method.
     */
    @Override
    public void runOneCycle() {
        System.out.println("\n==============================================");
        System.out.println("=== Starting Ride Cycle for " + this.rideName + " ===");

        // 1. Check if the ride can start (at least one visitor in queue)
        if (!canStartRide()) {
            System.out.println("Cannot start ride. The waiting queue is empty.");
            System.out.println("==============================================");
            return;
        }

        // 2. Load visitors from queue to the ride
        LinkedList<Visitor> currentPassengers = loadVisitors();

        // 3. Simulate the ride in progress
        simulateRide();

        // 4. Unload visitors and record them to history
        unloadAndRecordHistory(currentPassengers);

        // 5. Increment the cycle count
        this.numOfCycles++;

        System.out.println("=== Ride Cycle Completed Successfully ===");
        System.out.println("==============================================");
    }

    /**
     * Helper method to check if the ride can start.
     * @return true if there is at least one visitor in the waiting queue.
     */
    private boolean canStartRide() {
        if (operator == null) {
            System.out.println("Cannot start ride. No operator assigned.");
            return false;
        }
        if (waitingLine.isEmpty()) {
            System.out.println("Cannot start ride. The waiting queue is empty.");
            return false;
        }
        return true;
    }

    /**
     * Helper method to load visitors from the waiting queue.
     * It will load up to the ride's maximum capacity.
     * @return A list of visitors that have been loaded onto the ride.
     */
    private LinkedList<Visitor> loadVisitors() {
        System.out.println("\nLoading visitors...");
        LinkedList<Visitor> currentPassengers = new LinkedList<>();
        int visitorsToLoad = Math.min(this.maxRider, this.waitingLine.size());

        for (int i = 0; i < visitorsToLoad; i++) {
            Visitor visitor = this.waitingLine.poll(); // Removes from queue
            currentPassengers.add(visitor); // Adds to current passengers
            System.out.println("Loaded: " + visitor.getName());
        }
        System.out.println("Loaded " + currentPassengers.size() + " visitors.");
        return currentPassengers;
    }

    /**
     * Helper method to simulate the ride duration.
     */
    private void simulateRide() {
        System.out.println("\nRide is now in progress... Enjoy!");
        try {
            // Simulate a 2-second ride
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Ride was interrupted.");
            Thread.currentThread().interrupt(); // Restore interrupt status
        }
    }

    /**
     * Helper method to unload visitors and record their ride in history.
     * @param currentPassengers The list of visitors to unload and record.
     */
    private void unloadAndRecordHistory(LinkedList<Visitor> currentPassengers) {
        System.out.println("\nUnloading visitors and recording history...");
        for (Visitor visitor : currentPassengers) {
            this.rideHistory.add(visitor); // Add to history
            System.out.println("Unloaded and recorded: " + visitor.getName());
        }
        System.out.println("All visitors have been unloaded.");
    }
    public void exportRideHistory(String filePath) {
        System.out.println("\n=== Exporting History to " + filePath + " ===");
        if (rideHistory.isEmpty()) {
            System.out.println("Failed: History is empty, no need to export");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Visitor v : rideHistory) {
                String line = v.getId() + "," + v.getName() + "," + v.getContact() + "," + v.getTicketNumber() + "," + v.isMember();
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Success: Export completed");
        } catch (IOException e) {
            System.out.println("Failed: Export error - " + e.getMessage());
        }
    }
    public void importRideHistory(String filePath) {
        System.out.println("\n=== Importing History from " + filePath + " ===");
        rideHistory.clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] fields = line.split(",");
                if (fields.length != 5) {
                    System.out.println("Warning: Skipping invalid line - " + line);
                    continue;
                }
                try {
                    String id = fields[0].trim();
                    String name = fields[1].trim();
                    String contact = fields[2].trim();
                    String ticket = fields[3].trim();
                    boolean isMember = Boolean.parseBoolean(fields[4].trim());
                    rideHistory.add(new Visitor(id, name, contact, ticket, isMember));
                    count++;
                } catch (Exception e) {
                    System.out.println("Warning: Skipping malformed line - " + line);
                }
            }
            System.out.println("Success: Imported " + count + " records");
        } catch (IOException e) {
            System.out.println("Failed: Import error - " + e.getMessage());
        }
    }
}