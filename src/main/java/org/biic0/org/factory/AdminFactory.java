package org.biic0.org.factory;

import org.biic0.org.domain.Admin;
import org.biic0.org.domain.User;

public class AdminFactory {

    public static Admin createAdmin(
            String adminID,
            String password,
            String userName,
            String userId,
            String firstName,
            String lastName,
            String email,
            String userPassword,
            String mobile) {

        if (adminID == null || adminID.isEmpty()) {
            throw new IllegalArgumentException("Admin ID cannot be null or empty");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("User Name cannot be null or empty");
        }

        if (userId == null || userId.isEmpty()) {
            throw new IllegalArgumentException("User ID cannot be null or empty");
        }
        if (firstName == null || firstName.isEmpty()) {
            throw new IllegalArgumentException("First Name cannot be null or empty");
        }
        if (lastName == null || lastName.isEmpty()) {
            throw new IllegalArgumentException("Last Name cannot be null or empty");
        }
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }
        if (userPassword == null || userPassword.isEmpty()) {
            throw new IllegalArgumentException("User Password cannot be null or empty");
        }
        if (mobile == null || mobile.isEmpty()) {
            throw new IllegalArgumentException("Mobile cannot be null or empty");
        }

        // Build User object
        User user = new User.Builder()
                .setUserId(userId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setEmail(email)
                .setPassword(userPassword)
                .setMobile(mobile)
                .build();

        // Build Admin object
        return new Admin.Builder()
                .setAdminID(adminID)
                .setPassword(password)
                .setUserName(userName)
                .setUser(user)
                .build();
    }
}
