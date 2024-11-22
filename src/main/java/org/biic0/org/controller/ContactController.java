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
    @CrossOrigin("http://localhost:8081")

    public class ContactController {

        private final ContactService contactService;

        @Autowired
        public ContactController(ContactService contactService) {
            this.contactService = contactService;
        }

        @PostMapping("/create")
        public ResponseEntity<Contact> create(@RequestBody Contact contact) {
            Contact createdContact = contactService.create(contact);
            return new ResponseEntity<>(createdContact, HttpStatus.CREATED);
        }


        @GetMapping("/read/{email}")
        public ResponseEntity<Contact> read(@PathVariable String email) {
            Contact contact = contactService.read(email);
            if (contact != null) {
                return  ResponseEntity.ok(contact);
            } else {
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
        }


        @PutMapping("/update")
        public ResponseEntity<Contact> update(@RequestBody Contact contact) {
            if (contact.getEmail() == null) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Contact updatedContact = contactService.update(contact);
            return new ResponseEntity<>(updatedContact, HttpStatus.OK);
        }

        @GetMapping("/allContacts")
        public List<Contact> getAll (){
            return contactService.getAll();
        }


}
