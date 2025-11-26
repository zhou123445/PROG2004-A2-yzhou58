package com.scu.prvms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;

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

    @Override
    public void runOneCycle() {
    }
}