package com.scu.prvms;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Represents a theme park ride, managing visitor queues, ride history, and cycle operations.
 * Will implement RideInterface in subsequent modules.
 */
public class Ride {
    private String rideId;    // Unique identifier for the ride
    private String rideName;  // Name of the ride
    private Employee operator;// Employee operating the ride

    /**
     * Default constructor for Ride.
     */
    public Ride() {}

    /**
     * Parameterized constructor to initialize ride details.
     * @param rideId Unique ride ID
     * @param rideName Ride name
     * @param operator Employee operating the ride
     */
    public Ride(String rideId, String rideName, Employee operator) {
        this.rideId = rideId;
        this.rideName = rideName;
        this.operator = operator;
    }

    /**
     * @return The ride's unique ID
     */
    public String getRideId() { return rideId; }
    public void setRideId(String rideId) { this.rideId = rideId; }

    /**
     * @return The ride's name
     */
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }

    /**
     * @return The employee operating the ride
     */
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }
}