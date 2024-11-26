package org.biic0.org.repository;

import org.biic0.org.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact findByEmail(String email);
    Contact deleteByEmail(String email);

}
