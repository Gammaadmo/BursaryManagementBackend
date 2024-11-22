package org.biic0.org.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@EqualsAndHashCode
@ToString
public class Bursar {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String bursarId;

    private String name;
    private String registrationNumber;
    private String contactNumber;
    private String emailAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    protected Bursar() {}

    private Bursar(Builder builder) {
        this.bursarId = builder.bursarId;
        this.name = builder.name;
        this.registrationNumber = builder.registrationNumber;
        this.contactNumber = builder.contactNumber;
        this.emailAddress = builder.emailAddress;
        this.user = builder.user;
    }

    public static class Builder {
        private String bursarId;
        private String name;
        private String registrationNumber;
        private String contactNumber;
        private String emailAddress;
        private User user;

        public Builder setBursarId(String bursarId) {
            this.bursarId = bursarId;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
            return this;
        }

        public Builder setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
            return this;
        }

        public Builder setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder copy(Bursar bursar) {
            this.bursarId = bursar.bursarId;
            this.name = bursar.name;
            this.registrationNumber = bursar.registrationNumber;
            this.contactNumber = bursar.contactNumber;
            this.emailAddress = bursar.emailAddress;
            this.user = bursar.user;
            return this;
        }

        public Bursar build() {
            return new Bursar(this);
        }
    }
}
