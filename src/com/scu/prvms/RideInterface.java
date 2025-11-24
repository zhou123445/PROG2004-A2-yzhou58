package com.scu.prvms;

/**
 * Interface defining core functionalities for a theme park ride.
 * Enforces implementation of queue operations, history management, and ride cycle execution.
 */
public interface RideInterface {
    // Part3 Queue operations
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue();
    void printQueue();

    // Part4 History operations
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();

    // Part5 Ride cycle
    void runOneCycle();
}