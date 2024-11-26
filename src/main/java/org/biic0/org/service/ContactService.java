package org.biic0.org.service;

import jakarta.transaction.Transactional;
import org.biic0.org.domain.Contact;
import org.biic0.org.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService implements IContactService {

    private final ContactRepository contactRepository;

    @Autowired
    public ContactService(ContactRepository contactRepository){
        this.contactRepository = contactRepository;
    }

    @Override
    public Contact create(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact read(String email) {
        return contactRepository.findByEmail(email);
    }


    @Override
    public Contact update(Contact contact) {
        return contactRepository.save(contact);
    }

    @Transactional
    public void deleteByEmail(String email){
        contactRepository.deleteByEmail(email);
    }

    @Override
    public List<Contact> getAll() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactByEmail(String email) {
        return null;
    }




}
