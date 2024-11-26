package org.biic0.org.factory;

import org.biic0.org.domain.Bursary;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BursaryFactory {

    public Bursary createBursary(String name, String description, Double amount, String eligibilityCriteria,
                                 Date applicationStartDate, Date applicationEndDate, Integer numberOfAwards,
                                 Boolean isRenewable, String academicYear, String status, String contactEmail,
                                 String contactPhoneNumber, String institutionName, String fundingOrganization) {
        return new Bursary.BursaryBuilder()
                .setName(name)
                .setDescription(description)
                .setAmount(amount)
                .setEligibilityCriteria(eligibilityCriteria)
                .setApplicationStartDate(applicationStartDate)
                .setApplicationEndDate(applicationEndDate)
                .setNumberOfAwards(numberOfAwards)
                .setRenewable(isRenewable)
                .setAcademicYear(academicYear)
                .setStatus(status)
                .setContactEmail(contactEmail)
                .setContactPhoneNumber(contactPhoneNumber)
                .setInstitutionName(institutionName)
                .setFundingOrganization(fundingOrganization)
                .build();
    }

    public Bursary createDefaultBursary() {
        // Example of creating a default bursary instance
        return new Bursary.BursaryBuilder()
                .setName("Default Bursary")
                .setDescription("This is a default bursary.")
                .setAmount(1000.0)
                .setEligibilityCriteria("Open to all students.")
                .setApplicationStartDate(new Date())
                .setApplicationEndDate(new Date(System.currentTimeMillis() + 7L * 24 * 60 * 60 * 1000)) // 1 week from now
                .setNumberOfAwards(10)
                .setRenewable(false)
                .setAcademicYear("2024/2025")
                .setStatus("Open")
                .setContactEmail("default@institution.com")
                .setContactPhoneNumber("000-000-0000")
                .setInstitutionName("Default Institution")
                .setFundingOrganization("Default Organization")
                .build();
    }
}
