package org.biic0.org.repository;

import org.biic0.org.domain.Bursar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // Ensure this annotation is added
public interface BursarRepository extends JpaRepository<Bursar, String> {
    // You can add custom queries if needed here.
}
