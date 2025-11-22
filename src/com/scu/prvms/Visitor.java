package com.scu.prvms;

/**
 * Represents a visitor in the theme park, extending Person with visitor-specific attributes.
 */
public class Visitor extends Person {
    private String ticketNumber;  // Unique ticket number for the visitor
    private boolean isMember;     // Indicates if the visitor is a member

    /**
     * Default constructor for Visitor.
     */
    public Visitor() {}

    /**
     * Parameterized constructor to initialize visitor details.
     * @param id Person ID (inherited from Person)
     * @param name Full name (inherited from Person)
     * @param contact Contact information (inherited from Person)
     * @param ticketNumber Unique ticket number
     * @param isMember Membership status
     */
    public Visitor(String id, String name, String contact, String ticketNumber, boolean isMember) {
        super(id, name, contact);
        this.ticketNumber = ticketNumber;
        this.isMember = isMember;
    }

    /**
     * @return The visitor's ticket number
     */
    public String getTicketNumber() { return ticketNumber; }
    public void setTicketNumber(String ticketNumber) { this.ticketNumber = ticketNumber; }

    /**
     * @return True if the visitor is a member, false otherwise
     */
    public boolean isMember() { return isMember; }
    public void setMember(boolean member) { isMember = member; }

    /**
     * Overrides toString to provide a readable representation of the Visitor.
     * @return Formatted string with visitor details
     */
    @Override
    public String toString() {
        return "Visitor{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", ticketNumber='" + ticketNumber + '\'' +
                ", isMember=" + isMember +
                '}';
    }
}