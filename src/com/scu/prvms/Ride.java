package com.scu.prvms;

import java.util.LinkedList;
import java.util.Queue;

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

    // Interface method stubs (to be implemented in subsequent modules)
    @Override public void addVisitorToQueue(Visitor visitor) {}
    @Override public void removeVisitorFromQueue() {}
    @Override public void printQueue() {}
    @Override public void addVisitorToHistory(Visitor visitor) {}
    @Override public boolean checkVisitorFromHistory(Visitor visitor) { return false; }
    @Override public int numberOfVisitors() { return 0; }
    @Override public void printRideHistory() {}
    @Override public void runOneCycle() {}
}