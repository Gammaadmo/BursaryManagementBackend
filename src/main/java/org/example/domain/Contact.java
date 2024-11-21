package org.example.domain;

import java.util.Objects;

public class Contact {
    // Member variables to store contact information
    private String name;
    private String email;
    private String phoneNumber;
    private String address;

    // Default constructor
    public Contact() {
    }

    public Contact(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
      }

    //getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) && Objects.equals(email, contact.email) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, phoneNumber, address);
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private String email;
        private String phoneNumber;
        private String address;


    public Builder setName(String name) {
        this.name = name;
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
        public Builder setAddress (String address){
            this.address = address;
            return this;
        }

        public Builder copy(Contact contact) {
            this.name = contact.name;
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
