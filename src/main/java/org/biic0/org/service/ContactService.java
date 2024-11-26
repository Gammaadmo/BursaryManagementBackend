package org.biic0.org.service;

import org.biic0.org.domain.Contact;
import org.biic0.org.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


    @Service
    public class ContactService implements IContactService {
        private final ContactRepository contactRepository;

        @Autowired
        public ContactService(ContactRepository contactRepository) {
            this.contactRepository = contactRepository;
        }

        @Override
        public Contact create(Contact contact) {
            return contactRepository.save(contact);
        }

        @Override
        public Contact read(String email) {
            return contactRepository.findById(email).orElse(null);
        }

        @Override
        public Contact update(Contact contact) {
        return contactRepository.save(contact);
        }

        @Override
        public List<Contact> getAll() {
            return List.of();
        }

        public List<Contact> findContactByEmail(String email) {
            return contactRepository.findContactByEmail(email);
        }
    }
