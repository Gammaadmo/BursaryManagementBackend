package org.biic0.org.domain;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Objects;

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

    //@OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "contact_id")
    //private Contact contact;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    private LocalDate dateOfBirth;
    private String nationalId;
    private String universityName;
    private String studentNumber;
    private int yearOfStudy;

    protected Student() {
    }

    private Student(Builder builder) {
        this.studentId = builder.studentId;
        this.user = builder.user;
        //this.contact = builder.contact;
        this.address = builder.address;
        this.dateOfBirth = builder.dateOfBirth;
        this.nationalId = builder.nationalId;
        this.universityName = builder.universityName;
        this.studentNumber = builder.studentNumber;
        this.yearOfStudy = builder.yearOfStudy;
    }

    public String getStudentId() {
        return studentId;
    }

    public User getUser() {
        return user;
    }

    //public Contact getContact() {
    //    return contact;
    //}

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public String getNationalId() {
        return nationalId;
    }

    public String getUniversityName() {
        return universityName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }


    //@Override
    //public boolean equals(Object o) {
    //    if (this == o) return true;
    //    if (!(o instanceof Student student)) return false;
    //    return getYearOfStudy() == student.getYearOfStudy() && Objects.equals(getStudentId(), student.getStudentId()) && Objects.equals(getUser(), student.getUser()) && Objects.equals(getContact(), student.getContact()) && Objects.equals(getAddress(), student.getAddress()) && Objects.equals(getDateOfBirth(), student.getDateOfBirth()) && Objects.equals(getNationalId(), student.getNationalId()) && Objects.equals(getUniversityName(), student.getUniversityName()) && Objects.equals(getStudentNumber(), student.getStudentNumber());
    //}

    //@Override
    //public int hashCode() {
      //  return Objects.hash(getStudentId(), getUser(), getContact(), getAddress(), getDateOfBirth(), getNationalId(), getUniversityName(), getStudentNumber(), getYearOfStudy());
   // }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", user=" + user +
               // ", contact=" + contact +
                ", address=" + address +
                ", dateOfBirth=" + dateOfBirth +
                ", nationalId='" + nationalId + '\'' +
                ", universityName='" + universityName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", yearOfStudy=" + yearOfStudy +
                '}';
    }

    public static class Builder {
        private String studentId;
        private User user;
        //private Contact contact;
        private Address address;
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
       // public Builder setContact(Contact contact) {
       //     this.contact = contact;
       //     return this;
       // }
       public Builder setAddress(Address address) {
           this.address = address;
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
            //this.contact = student.contact;
            this.address = student.address;
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