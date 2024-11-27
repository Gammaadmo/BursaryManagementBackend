package org.biic0.org.repository;
import org.biic0.org.domain.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


    public interface ContactRepository extends JpaRepository<Contact, String> {
        List<Contact> findContactByEmail(String email);
    }


