package org.biic0.org.factory;

import org.biic0.org.domain.User;
import org.biic0.org.util.Helper;

public class UserFactory {
    public static User createUser(String firstName, String lastName, String email, String mobile, String password) {
        // Validate inputs
        if (Helper.isNullOrEmpty(firstName) || Helper.isNullOrEmpty(lastName) ||
                Helper.isNullOrEmpty(email) || Helper.isNullOrEmpty(mobile) ||
                Helper.isNullOrEmpty(password)) {
            throw new IllegalArgumentException("User details cannot be null or empty.");
        }
        return new User.Builder()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setMobile(mobile)
                .setPassword(password)
                .build();
    }


}
