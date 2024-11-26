package org.biic0.org.domain;

import jakarta.persistence.*;
import java.util.Objects;

@Table(name = "contact")
@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String contactID; // Added a unique identifier field for the Contact entity.

    private String email;
    private String phoneNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    public Contact() {
    }

    public Contact(Builder builder) {
        this.contactID = builder.contactID;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
    }

    // Getters
    public String getContactID() {
        return contactID;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Address getAddress() {
        return address;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(contactID, contact.contactID) &&
                Objects.equals(email, contact.email) &&
                Objects.equals(phoneNumber, contact.phoneNumber) &&
                Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactID, email, phoneNumber, address);
    }

    // ToString
    @Override
    public String toString() {
        return "Contact{" +
                "contactID='" + contactID + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address=" + address +
                '}';
    }

    // Builder Class
    public static class Builder {
        private String contactID;
        private String email;
        private String phoneNumber;
        private Address address;

        public Builder setContactID(String contactID) {
            this.contactID = contactID;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder copy(Contact contact) {
            this.contactID = contact.contactID;
            this.email = contact.email;
            this.phoneNumber = contact.phoneNumber;
            this.address = contact.address;
            return this;
        }

        public Contact build() {
            return new Contact(this);
        }
    }
}
