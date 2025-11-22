package com.scu.prvms;

/**
 * Represents an employee operating a ride in the theme park.
 * Extends Person with employee-specific attributes.
 */
public class Employee extends Person {
    private String employeeId;  // Unique employee identifier
    private String shift;       // Work shift (e.g., Morning, Afternoon, Evening)

    /**
     * Default constructor for Employee.
     */
    public Employee() {}

    /**
     * Parameterized constructor to initialize employee details.
     * @param id Person ID (inherited from Person)
     * @param name Full name (inherited from Person)
     * @param contact Contact information (inherited from Person)
     * @param employeeId Unique employee ID
     * @param shift Work shift
     */
    public Employee(String id, String name, String contact, String employeeId, String shift) {
        super(id, name, contact);
        this.employeeId = employeeId;
        this.shift = shift;
    }

    /**
     * @return The employee's unique ID
     */
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }

    /**
     * @return The employee's work shift
     */
    public String getShift() { return shift; }
    public void setShift(String shift) { this.shift = shift; }
}