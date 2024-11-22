package org.biic0.org.domain;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
@Table(name = "admin")
public class Admin {


        @Id
        private String adminID;
        private String password;
        private String userName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
        private User user;



    public Admin() {
        }

        public Admin(Builder builder) {
            this.adminID = builder.adminID;
            this.password = builder.password;
            this.userName = builder.userName;
            this.user  = builder.user;

        }

        public String getAdminID() {
            return adminID;
        }

        public String getPassword() {
            return password;
        }

        public String getUserName() {
            return userName;
        }
       // public User getUser() {
        //return user;
        //}

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Admin admin)) return false;
            return Objects.equals(adminID, admin.adminID) &&
                    Objects.equals(password, admin.password) &&
                    Objects.equals(userName, admin.userName);
                    //Objects.equals(user, admin.user);
        }

       @Override
       public int hashCode() {
           return Objects.hash(adminID, password, userName,user);
        }

        @Override
        public String toString() {
            return "Admin{" +
                    "adminID='" + adminID + '\'' +
                    ", password='" + password + '\'' +
                    ", userName='" + userName + '\'' +
                   ", user='" + user+ '\'' +
                    '}';
        }

    public User getUser() {
        return user;
    }

    public static class Builder {
            private String adminID;
            private String password;
            private String userName;
           private User user;

            public Builder setAdminID(String adminID) {
                this.adminID = adminID;
                return this;
            }

            public Builder setPassword(String password) {
                this.password = password;
                return this;
            }

            public Builder setUserName(String userName) {
                this.userName = userName;
                return this;
            }
           public Builder setUser(User user) {
              this.user = user;
              return this;
            }

            public Builder copy(Admin admin) {
                this.adminID = admin.adminID;
                this.password = admin.password;
                this.userName = admin.userName;
                this.user = admin.user;
                return this;
            }

            public Admin build() {
                return new Admin(this);
            }
        }
    }


