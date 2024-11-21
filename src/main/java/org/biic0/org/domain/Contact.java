package org.biic0.org.domain;

import java.util.Objects;

public class Contact {

    // Member variables to store contact information
    private String email;
    private String phoneNumber;
    private String address;

    // Default constructor
    public Contact() {
    }

    public Contact(Builder builder) {
        this.email = builder.email;
        this.phoneNumber = builder.phoneNumber;
        this.address = builder.address;
    }

    //getters

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
        return  Objects.equals(email, contact.email) && Objects.equals(phoneNumber, contact.phoneNumber) && Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, phoneNumber, address);
    }

    @Override
    public String toString() {
        return "Contact{" +
                " email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public static class Builder {
        private String email;
        private String phoneNumber;
        private String address;



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
