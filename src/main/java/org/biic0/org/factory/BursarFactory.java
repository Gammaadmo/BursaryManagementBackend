package org.biic0.org.factory;

import org.biic0.org.domain.Bursar;
import org.biic0.org.domain.User;
import org.springframework.stereotype.Component;

@Component
public class BursarFactory {

    public Bursar createBursar(String bursarId, String name, String registrationNumber,
                               String contactNumber, String emailAddress, User user) {
        return new Bursar.Builder()
                .setBursarId(bursarId)
                .setName(name)
                .setRegistrationNumber(registrationNumber)
                .setContactNumber(contactNumber)
                .setEmailAddress(emailAddress)
                .setUser(user)
                .build();
    }

    public Bursar createDefaultBursar(User user) {
        // Example of creating a default bursar instance
        return new Bursar.Builder()
                .setBursarId(generateBursarId())
                .setName("Default Name")
                .setRegistrationNumber("Default Reg Number")
                .setContactNumber("0000000000")
                .setEmailAddress("default@example.com")
                .setUser(user)
                .build();
    }

    private String generateBursarId() {
        // Add your logic for generating a unique bursar ID
        return "Bursar-" + System.currentTimeMillis();
    }
}
