package org.biic0.org.domain;

import jakarta.persistence.*;
import lombok.Getter;
import java.util.Date;
import java.util.Objects;

@Entity
public class Bursary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Name of the bursary
    private String description; // Detailed information about the bursary
    private Double amount; // Total amount of the bursary
    private String eligibilityCriteria; // Qualification criteria
    @Getter
    private Date applicationStartDate; // Start date for applications
    private Date applicationEndDate; // End date for applications
    private Integer numberOfAwards; // Total number of awards available
    private Boolean isRenewable; // Indicates if the bursary is renewable
    private String academicYear; // Academic year for which the bursary applies
    private String status; // Status: Open, Closed, Awarded
    private String contactEmail; // Contact email for inquiries
    private String contactPhoneNumber; // Contact phone number for inquiries
    private String institutionName; // Name of the institution offering the bursary
    private String fundingOrganization; // Organization or sponsor providing the bursary funds


    private Bursary(BursaryBuilder builder) {
        this.name = builder.name;
        this.description = builder.description;
        this.amount = builder.amount;
        this.eligibilityCriteria = builder.eligibilityCriteria;
        this.applicationStartDate = builder.applicationStartDate;
        this.applicationEndDate = builder.applicationEndDate;
        this.numberOfAwards = builder.numberOfAwards;
        this.isRenewable = builder.isRenewable;
        this.academicYear = builder.academicYear;
        this.status = builder.status;
        this.contactEmail = builder.contactEmail;
        this.contactPhoneNumber = builder.contactPhoneNumber;
        this.institutionName = builder.institutionName;
        this.fundingOrganization = builder.fundingOrganization;
    }

    public Bursary() {

    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getAmount() {
        return amount;
    }

    public String getEligibilityCriteria() {
        return eligibilityCriteria;
    }

    public Date getApplicationEndDate() {
        return applicationEndDate;
    }

    public Integer getNumberOfAwards() {
        return numberOfAwards;
    }

    public Boolean getRenewable() {
        return isRenewable;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public String getStatus() {
        return status;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public String getFundingOrganization() {
        return fundingOrganization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bursary bursary = (Bursary) o;
        return Objects.equals(id, bursary.id) && Objects.equals(name, bursary.name) && Objects.equals(description, bursary.description) && Objects.equals(amount, bursary.amount) && Objects.equals(eligibilityCriteria, bursary.eligibilityCriteria) && Objects.equals(applicationStartDate, bursary.applicationStartDate) && Objects.equals(applicationEndDate, bursary.applicationEndDate) && Objects.equals(numberOfAwards, bursary.numberOfAwards) && Objects.equals(isRenewable, bursary.isRenewable) && Objects.equals(academicYear, bursary.academicYear) && Objects.equals(status, bursary.status) && Objects.equals(contactEmail, bursary.contactEmail) && Objects.equals(contactPhoneNumber, bursary.contactPhoneNumber) && Objects.equals(institutionName, bursary.institutionName) && Objects.equals(fundingOrganization, bursary.fundingOrganization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, amount, eligibilityCriteria, applicationStartDate, applicationEndDate, numberOfAwards, isRenewable, academicYear, status, contactEmail, contactPhoneNumber, institutionName, fundingOrganization);
    }

    @Override
    public String toString() {
        return "Bursary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", amount=" + amount +
                ", eligibilityCriteria='" + eligibilityCriteria + '\'' +
                ", applicationStartDate=" + applicationStartDate +
                ", applicationEndDate=" + applicationEndDate +
                ", numberOfAwards=" + numberOfAwards +
                ", isRenewable=" + isRenewable +
                ", academicYear='" + academicYear + '\'' +
                ", status='" + status + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", contactPhoneNumber='" + contactPhoneNumber + '\'' +
                ", institutionName='" + institutionName + '\'' +
                ", fundingOrganization='" + fundingOrganization + '\'' +
                '}';
    }

    public static class BursaryBuilder {
        private String name;
        private String description;
        private Double amount;
        private String eligibilityCriteria;
        private Date applicationStartDate;
        private Date applicationEndDate;
        private Integer numberOfAwards;
        private Boolean isRenewable;
        private String academicYear;
        private String status;
        private String contactEmail;
        private String contactPhoneNumber;
        private String institutionName;
        private String fundingOrganization;

        public BursaryBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public BursaryBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public BursaryBuilder setAmount(Double amount) {
            this.amount = amount;
            return this;
        }

        public BursaryBuilder setEligibilityCriteria(String eligibilityCriteria) {
            this.eligibilityCriteria = eligibilityCriteria;
            return this;
        }

        public BursaryBuilder setApplicationStartDate(Date applicationStartDate) {
            this.applicationStartDate = applicationStartDate;
            return this;
        }

        public BursaryBuilder setApplicationEndDate(Date applicationEndDate) {
            this.applicationEndDate = applicationEndDate;
            return this;
        }

        public BursaryBuilder setNumberOfAwards(Integer numberOfAwards) {
            this.numberOfAwards = numberOfAwards;
            return this;
        }

        public BursaryBuilder setRenewable(Boolean renewable) {
            isRenewable = renewable;
            return this;
        }

        public BursaryBuilder setAcademicYear(String academicYear) {
            this.academicYear = academicYear;
            return this;
        }

        public BursaryBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public BursaryBuilder setContactEmail(String contactEmail) {
            this.contactEmail = contactEmail;
            return this;
        }

        public BursaryBuilder setContactPhoneNumber(String contactPhoneNumber) {
            this.contactPhoneNumber = contactPhoneNumber;
            return this;
        }

        public BursaryBuilder setInstitutionName(String institutionName) {
            this.institutionName = institutionName;
            return this;
        }

        public BursaryBuilder setFundingOrganization(String fundingOrganization) {
            this.fundingOrganization = fundingOrganization;
            return this;
        }

        public Bursary build() {
            return new Bursary(this);
        }
    }
}
