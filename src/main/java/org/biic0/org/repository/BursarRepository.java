package org.biic0.org.repository;

import org.biic0.org.domain.Bursar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BursarRepository extends JpaRepository<Bursar, String> {
    // Add custom queries if necessary
    // For example:
    // Optional<Bursar> findByName(String name);
}
