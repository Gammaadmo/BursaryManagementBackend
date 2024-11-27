package org.biic0.org.repository;

import org.biic0.org.domain.Bursar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BursarRepository extends JpaRepository<Bursar, String> {
    // You can add custom queries if needed here
    // Example: Find by registration number
    Bursar findByRegistrationNumber(String registrationNumber);
}
