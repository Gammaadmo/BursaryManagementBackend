package org.biic0.org.factory;
import org.biic0.org.domain.Address;
import org.biic0.org.domain.Contact;
import org.biic0.org.util.Helper;

    public class ContactFactory {
        public static Contact createContact(String email, String phoneNumber, Address address) {
            // Validate inputs
            if (Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(phoneNumber) || Helper.isNullOrEmpty(address)) {
                throw new IllegalArgumentException("Contact details cannot be null or empty.");
            }

            return new Contact.Builder()
                    .setEmail(email)
                    .setPhoneNumber(phoneNumber)
                    .setAddress(address)
                    .build();
        }
    }

