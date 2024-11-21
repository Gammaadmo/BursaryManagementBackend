package org.biic0.org.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Objects;

@Getter
@Entity
@EqualsAndHashCode
@ToString
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String addressId;

    private String streetName;
    private String suburb;
    private String town;
    private String zipCode;

    protected Address() {

    }
    private Address(Builder builder) {
        this.addressId = builder.addressId;
        this.streetName = builder.streetName;
        this.suburb = builder.suburb;
        this.town = builder.town;
        this.zipCode = builder.zipCode;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getTown() {
        return town;
    }

    public String getZipCode() {
        return zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return Objects.equals(getAddressId(), address.getAddressId()) && Objects.equals(getStreetName(), address.getStreetName()) && Objects.equals(getSuburb(), address.getSuburb()) && Objects.equals(getTown(), address.getTown()) && Objects.equals(getZipCode(), address.getZipCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddressId(), getStreetName(), getSuburb(), getTown(), getZipCode());
    }

    @Override
    public String toString() {
        return "Address{" +
                "addressId='" + addressId + '\'' +
                ", streetName='" + streetName + '\'' +
                ", suburb='" + suburb + '\'' +
                ", town='" + town + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }

    public static class Builder {
        private String addressId;
        private String streetName;
        private String suburb;
        private String town;
        private String zipCode;

        public void setAddressId(String addressId) {
            this.addressId = addressId;
        }

        public void setStreetName(String streetName) {
            this.streetName = streetName;
        }

        public void setSuburb(String suburb) {
            this.suburb = suburb;
        }

        public void setTown(String town) {
            this.town = town;
        }

        public void setZipCode(String zipCode) {
            this.zipCode = zipCode;
        }

        public Builder copy(Address address) {
            this.addressId = address.addressId;
            this.streetName = address.streetName;
            this.suburb = address.suburb;
            this.town = address.town;
            this.zipCode = address.zipCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
    }
