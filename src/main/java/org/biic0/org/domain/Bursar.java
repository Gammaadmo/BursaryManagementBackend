package org.biic0.org.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "bursar")
public class Bursar {

    @Id
    private String bursarID;
    private String name;
    private String registrationNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    private String department; // Added department field

    // Default Constructor
    public Bursar(String bursarID, String name, String registrationNumber, String department, User user) {
        this.bursarID = bursarID;
        this.name = name;
        this.registrationNumber = registrationNumber;
        this.department = department;
        this.user = user;
    }

    // Builder Constructor
    public Bursar(Builder builder) {
        this.bursarID = builder.bursarID;
        this.name = builder.name;
        this.registrationNumber = builder.registrationNumber;
        this.user = builder.user;
        this.department = builder.department; // Set department in builder
    }

    public Bursar() {}

    // Getters
    public String getBursarID() {
        return bursarID;
    }

    public String getName() {
        return name;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public User getUser() {
        return user;
    }

    public String getDepartment() { // Added getter for department
        return department;
    }

    // Setters
    public void setDepartment(String department) { // Added setter for department
        this.department = department;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bursar bursar)) return false;
        return Objects.equals(bursarID, bursar.bursarID) &&
                Objects.equals(name, bursar.name) &&
                Objects.equals(registrationNumber, bursar.registrationNumber) &&
                Objects.equals(user, bursar.user) &&
                Objects.equals(department, bursar.department); // Include department in equals
    }

    @Override
    public int hashCode() {
        return Objects.hash(bursarID, name, registrationNumber, user, department); // Include department in hashCode
    }

    // toString
    @Override
    public String toString() {
        return "Bursar{" +
                "bursarID='" + bursarID + '\'' +
                ", name='" + name + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", user=" + user +
                ", department='" + department + '\'' +  // Include department in toString
                '}';
    }

    // Builder Class
    public static class Builder {
        private String bursarID;
        private String name;
        private String registrationNumber;
        private User user;
        private String department; // Added department to Builder

        public Builder setBursarID(String bursarID) {
            this.bursarID = bursarID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setDepartment(String department) { // Added setter for department in Builder
            this.department = department;
            return this;
        }

        public Builder copy(Bursar bursar) {
            this.bursarID = bursar.bursarID;
            this.name = bursar.name;
            this.registrationNumber = bursar.registrationNumber;
            this.user = bursar.user;
            this.department = bursar.department; // Copy department as well
            return this;
        }

        public Bursar build() {
            // Ensure all required fields are set before building
            if (bursarID == null || name == null || registrationNumber == null || user == null || department == null) {
                throw new IllegalStateException("Bursar fields are not fully set!");
            }
            return new Bursar(this);
        }

        public Bursar setEmail(String mail) {
            return null;
        }
    }
}
