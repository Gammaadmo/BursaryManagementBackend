package org.biic0.org.controller;

import org.biic0.org.domain.Bursar;
import org.biic0.org.domain.User;
import org.biic0.org.service.BursarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bursar")
@CrossOrigin(origins = "http://localhost:5173")
public class BursarController {

    private final BursarService bursarService;

    @Autowired
    public BursarController(BursarService bursarService) {
        this.bursarService = bursarService;
    }

    @PostMapping("/create")
    public ResponseEntity<Bursar> createBursar(@RequestBody BursarRequest bursarRequest) {
        Bursar bursar = bursarService.create(
                new Bursar.Builder()
                        .setBursarId(bursarRequest.getBursarId())
                        .setName(bursarRequest.getName())
                        .setRegistrationNumber(bursarRequest.getRegistrationNumber())
                        .setContactNumber(bursarRequest.getContactNumber())
                        .setEmailAddress(bursarRequest.getEmailAddress())
                        .setUser(bursarRequest.getUser())
                        .build()
        );
        return ResponseEntity.ok(bursar);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bursar>> getAllBursars() {
        List<Bursar> bursarList = bursarService.getAll();
        return ResponseEntity.ok(bursarList);
    }

    @GetMapping("/{bursarId}")
    public ResponseEntity<Bursar> getBursarById(@PathVariable String bursarId) {
        Bursar bursar = bursarService.read(bursarId);
        return bursar != null ? ResponseEntity.ok(bursar) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{bursarId}")
    public ResponseEntity<Bursar> updateBursar(@PathVariable String bursarId, @RequestBody BursarRequest bursarRequest) {
        Bursar existingBursar = bursarService.read(bursarId);
        if (existingBursar != null) {
            Bursar updatedBursar = new Bursar.Builder()
                    .setBursarId(bursarId)
                    .setName(bursarRequest.getName())
                    .setRegistrationNumber(bursarRequest.getRegistrationNumber())
                    .setContactNumber(bursarRequest.getContactNumber())
                    .setEmailAddress(bursarRequest.getEmailAddress())
                    .setUser(bursarRequest.getUser())
                    .build();
            return ResponseEntity.ok(bursarService.update(updatedBursar));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{bursarId}")
    public ResponseEntity<Void> deleteBursar(@PathVariable String bursarId) {
        Bursar bursar = bursarService.read(bursarId);
        if (bursar != null) {
            bursarService.delete(bursarId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public static class BursarRequest {
        private String bursarId;
        private String name;
        private String registrationNumber;
        private String contactNumber;
        private String emailAddress;
        private User user;

        public String getBursarId() {
            return bursarId;
        }

        public void setBursarId(String bursarId) {
            this.bursarId = bursarId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRegistrationNumber() {
            return registrationNumber;
        }

        public void setRegistrationNumber(String registrationNumber) {
            this.registrationNumber = registrationNumber;
        }

        public String getContactNumber() {
            return contactNumber;
        }

        public void setContactNumber(String contactNumber) {
            this.contactNumber = contactNumber;
        }

        public String getEmailAddress() {
            return emailAddress;
        }

        public void setEmailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
}


