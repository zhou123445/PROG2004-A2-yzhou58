package com.scu.prvms;

/**
 * Abstract class representing a generic person in the theme park system.
 * Encapsulates common attributes and behaviors for employees and visitors.
 */
public abstract class Person {
    private String id;       // Unique identifier for the person
    private String name;     // Full name of the person
    private String contact;  // Contact information (e.g., phone number)

    /**
     * Default constructor for Person.
     */
    public Person() {}

    /**
     * Parameterized constructor to initialize all attributes.
     * @param id Unique identifier
     * @param name Full name
     * @param contact Contact information
     */
    public Person(String id, String name, String contact) {
        this.id = id;
        this.name = name;
        this.contact = contact;
    }

    /**
     * @return The person's unique ID
     */
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    /**
     * @return The person's full name
     */
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    /**
     * @return The person's contact information
     */
    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }
}