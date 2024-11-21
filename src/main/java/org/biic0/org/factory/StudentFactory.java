package org.biic0.org.factory;

import org.biic0.org.domain.Address;
import org.biic0.org.domain.Contact;
import org.biic0.org.domain.Student;
import org.biic0.org.domain.User;
import org.biic0.org.util.Helper;

import java.time.LocalDate;

public class StudentFactory {
    public static Student createStudent(User user, Contact contact, Address address, LocalDate dateOfBirth,
                                        String nationalId, String universityName, String studentNumber, int yearOfStudy) {
        // Validate inputs
        if (Helper.isNullOrEmpty(user) || Helper.isNullOrEmpty(contact) || Helper.isNullOrEmpty(address) ||
                Helper.isNullOrEmpty(dateOfBirth) || Helper.isNullOrEmpty(nationalId) ||
                Helper.isNullOrEmpty(universityName) || Helper.isNullOrEmpty(studentNumber) ||
                Helper.isNullOrEmpty(yearOfStudy)) {
            throw new IllegalArgumentException("Student details cannot be null or empty.");
        }
        return new Student.Builder()
                .setUser(user)
               // .setContact(contact)
                .setAddress(address)
                .setDateOfBirth(dateOfBirth)
                .setNationalId(nationalId)
                .setUniversityName(universityName)
                .setStudentNumber(studentNumber)
                .setYearOfStudy(yearOfStudy)
                .build();
    }
}
