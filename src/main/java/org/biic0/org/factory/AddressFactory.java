package org.biic0.org.factory;

import org.biic0.org.domain.Address;
import org.biic0.org.util.Helper;

public class AddressFactory {
    public static Address createAddress(String addressId, String streetName, String suburb, String town, String zipCode) {
        // Validate inputs
        if (Helper.isNullOrEmpty(addressId) || Helper.isNullOrEmpty(streetName) ||
                Helper.isNullOrEmpty(suburb) || Helper.isNullOrEmpty(town) || Helper.isNullOrEmpty(zipCode)) {
            throw new IllegalArgumentException("Address details cannot be null or empty.");
        }
        return new Address.Builder()
                .setAddressId(addressId)
                .setStreetName(streetName)
                .setSuburb(suburb)
                .setTown(town)
                .setZipCode(zipCode)
                .build();
        }
}
