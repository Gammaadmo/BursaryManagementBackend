package org.biic0.org.factory;

import org.biic0.org.domain.Contact;
import org.biic0.org.util.Helper;


public class ContactFactory {

    public static Contact buildContact(String email,
                                       String phoneNumber,
                                       String address) {

        if (!Helper.isValidEmail(email) || Helper.isNullorEmpty(phoneNumber) || Helper.isNullorEmpty(address)) {
            return null;
        }

        return new Contact.Builder()
                .setEmail(email)
                .setPhoneNumber(phoneNumber)
                .setAddress(address)
                .build();
    }
}
