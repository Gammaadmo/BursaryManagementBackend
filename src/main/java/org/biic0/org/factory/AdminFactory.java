package org.biic0.org.factory;
import org.biic0.org.domain.Admin;
import org.biic0.org.domain.User;

public class AdminFactory {


        public static Admin createAdmin(String adminID, String password, String userName, User user) {

            if (adminID == null || adminID.isEmpty()) {
                throw new IllegalArgumentException("Admin ID cannot be null or empty");
            }
            if (password == null || password.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be null or empty");
            }
            if (userName == null || userName.isEmpty()) {
                throw new IllegalArgumentException("User Name cannot be null or empty");
            }
            if (user == null) {
                throw new IllegalArgumentException("User cannot be null");
            }

            return new Admin.Builder()
                    .setAdminID(adminID)
                    .setPassword(password)
                    .setUserName(userName)
                    .setUser(user)
                    .build();
        }
    }


