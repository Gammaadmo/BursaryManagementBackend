package org.biic0.org.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Entity
@EqualsAndHashCode
@ToString

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String studentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    private LocalDate dateOfBirth;
    private String nationalId;
    private String universityName;
    private String studentNumber;
    private int yearOfStudy;

    protected Student() {}

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.user = builder.user;
        this.dateOfBirth = builder.dateOfBirth;
        this.nationalId = builder.nationalId;
        this.universityName = builder.universityName;
        this.studentNumber = builder.studentNumber;
        this.yearOfStudy = builder.yearOfStudy;
    }
    public static class Builder {
        private String studentId;
        private User user;
        private LocalDate dateOfBirth;
        private String nationalId;
        private String universityName;
        private String studentNumber;
        private int yearOfStudy;

        public Builder setStudentId(String studentId) {
            this.studentId = studentId;
            return this;
        }
        public Builder setUser(User user) {
            this.user = user;
            return this;
        }

        public Builder setDateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder setNationalId(String nationalId) {
            this.nationalId = nationalId;
            return this;
        }
        public Builder setUniversityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public Builder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Builder setYearOfStudy(int yearOfStudy) {
            this.yearOfStudy = yearOfStudy;
            return this;
        }
        public Builder copy(Student student) {
            this.studentId = student.studentId;
            this.user = student.user;
            this.dateOfBirth = student.dateOfBirth;
            this.nationalId = student.nationalId;
            this.universityName = student.universityName;
            this.studentNumber = student.studentNumber;
            this.yearOfStudy = student.yearOfStudy;
            return this;
        }
        public Student build() {
            return new Student(this);
        }
    }
}