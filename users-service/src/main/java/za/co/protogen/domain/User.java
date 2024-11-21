package za.co.protogen.domain;

import java.time.LocalDate;

public class User {
    private Long id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String rsaId;

    // Constructors, getters, and setters
    public User() {}

    public User(Long id, String firstName, String lastName, LocalDate dateOfBirth, String rsaId) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.rsaId = rsaId;
    }

    // Getters and setters for each attribute
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(LocalDate dateOfBirth) { this.dateOfBirth = dateOfBirth; }

    public String getRsaId() { return rsaId; }
    public void setRsaId(String rsaId) { this.rsaId = rsaId; }
}
