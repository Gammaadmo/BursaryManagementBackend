package FactoryTest;

import org.biic0.org.factory.AdminFactory;
import org.biic0.org.domain.Admin;
import org.biic0.org.domain.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminFactoryTest {

    @Test
    void buildAdmin() {
        // Create an Admin object using the factory
        Admin admin = AdminFactory.createAdmin(
                "Ad252",
                "pop252@",
                "BokangB",
                "user123",
                "Oyola",
                "Mpiko",
                "oyo@gmail.com",
                "Oyo123",
                "0618234567"
        );

        // Assertions to validate the created Admin object
        assertNotNull(admin, "Admin object should not be null");
        assertEquals("Ad252", admin.getAdminID(), "Admin ID does not match");
        assertEquals("pop252@", admin.getPassword(), "Password does not match");
        assertEquals("BokangB", admin.getUserName(), "User Name does not match");

        // Validate the User object inside the Admin object
        User user = admin.getUser();
        assertNotNull(user, "User object should not be null");
        assertEquals("user123", user.getUserId(), "User ID does not match");
        assertEquals("Oyola", user.getFirstName(), "First Name does not match");
        assertEquals("Mpiko", user.getLastName(), "Last Name does not match");
        assertEquals("oyo@gmail.com", user.getEmail(), "Email does not match");
        assertEquals("Oyo123", user.getPassword(), "User Password does not match");
        assertEquals("0618234567", user.getMobile(), "Mobile does not match");
    }

    @Test
    void buildAdminWithInvalidData() {
        // Test case for invalid input
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AdminFactory.createAdmin(
                    null, // Invalid Admin ID
                    "password",
                    "userName",
                    "userId",
                    "firstName",
                    "lastName",
                    "email",
                    "userPassword",
                    "mobile"
            );
        });

        String expectedMessage = "Admin ID cannot be null or empty";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage), "Exception message does not match");
    }
}
