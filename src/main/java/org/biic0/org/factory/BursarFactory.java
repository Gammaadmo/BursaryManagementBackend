package org.biic0.org.factory;

import org.biic0.org.domain.Bursar;
import org.biic0.org.domain.User;

public class BursarFactory {

    public static Bursar createBursar(String bursarID, String name, String registrationNumber, User user) {
        return new Bursar.Builder()
                .setBursarID(bursarID)
                .setName(name)
                .setRegistrationNumber(registrationNumber)
                .setUser(user)
                .build();
    }

    public Bursar createBursar(String bursarID, String name, String department) {
        return null;
    }
}
