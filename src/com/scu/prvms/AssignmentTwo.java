package com.scu.prvms;

/**
 * Main class for the PROG2004 Assignment 2, containing demo methods for all modules.
 */
public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo demo = new AssignmentTwo();
        demo.partThree();
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
    public void partFourA() {}

    /** Demo method for Part 4B: History Sorting */
    public void partFourB() {}

    /** Demo method for Part 5: Ride Cycle Execution */
    public void partFive() {}

    /** Demo method for Part 6: File Export */
    public void partSix() {}

    /** Demo method for Part 7: File Import */
    public void partSeven() {}
}