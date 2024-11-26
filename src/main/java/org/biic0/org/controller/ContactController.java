package org.biic0.org.controller;

import org.biic0.org.domain.Contact;
import org.biic0.org.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contact")
@CrossOrigin(origins = "http://localhost:5173")
public class ContactController {
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createContact(@RequestBody Contact contact) {
        try {
            if (contact == null) {
                return ResponseEntity.badRequest().body("Contact cannot be null.");
            }

            contactService.create(contact);
            return ResponseEntity.status(HttpStatus.CREATED).body("Contact created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error creating contact: " + e.getMessage());
        }
    }

    @GetMapping("/read/{email}")
    public ResponseEntity<Contact> readContact(@PathVariable String email) {
        try {
            Contact readContact = contactService.read(email);
            if (readContact == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(readContact, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateContact(@RequestBody Contact contact) {
        try {
            if (contact.getEmail() == null || contact.getEmail().isEmpty()) {
                return ResponseEntity.badRequest().body("Email cannot be null or empty.");
            }

            contactService.update(contact);
            return ResponseEntity.status(HttpStatus.OK).body("Contact updated successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error updating contact: " + e.getMessage());
        }
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Contact>> getAllContacts() {
        try {
            List<Contact> contacts = contactService.getAll();
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<List<Contact>> findContactsByEmail(@PathVariable String email) {
        try {
            List<Contact> contacts = contactService.findContactByEmail(email);
            if (contacts.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(contacts, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
