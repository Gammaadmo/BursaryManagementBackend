package org.biic0.org.repository;

import org.biic0.org.domain.Bursary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BursaryRepository extends JpaRepository<Bursary, Long> {
    // You can add custom queries if needed
}
