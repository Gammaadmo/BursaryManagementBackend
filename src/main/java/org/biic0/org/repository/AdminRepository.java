package org.biic0.org.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.biic0.org.domain.Admin;


@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {

        Admin findByAdmin_UserId(String userId);

        Admin findByUserNameAndPassword(String userName, String password);
    }


