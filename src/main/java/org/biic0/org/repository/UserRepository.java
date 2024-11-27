package org.biic0.org.repository;

import org.biic0.org.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    List<User> findUserByEmail(String email);
}
