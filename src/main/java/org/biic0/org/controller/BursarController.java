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
                        .setBursarID(bursarRequest.getBursarID())
                        .setName(bursarRequest.getName())
                        .setRegistrationNumber(bursarRequest.getRegistrationNumber())
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

    @GetMapping("/{bursarID}")
    public ResponseEntity<Bursar> getBursarById(@PathVariable String bursarID) {
        Bursar bursar = bursarService.read(bursarID);
        return bursar != null ? ResponseEntity.ok(bursar) : ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{bursarID}")
    public ResponseEntity<Bursar> updateBursar(@PathVariable String bursarID, @RequestBody BursarRequest bursarRequest) {
        Bursar existingBursar = bursarService.read(bursarID);
        if (existingBursar != null) {
            Bursar updatedBursar = new Bursar.Builder()
                    .setBursarID(bursarID)
                    .setName(bursarRequest.getName())
                    .setRegistrationNumber(bursarRequest.getRegistrationNumber())
                    .setUser(bursarRequest.getUser())
                    .build();
            return ResponseEntity.ok(bursarService.update(updatedBursar));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{bursarID}")
    public ResponseEntity<Void> deleteBursar(@PathVariable String bursarID) {
        Bursar bursar = bursarService.read(bursarID);
        if (bursar != null) {
            bursarService.delete(bursarID);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    public static class BursarRequest {
        private String bursarID;
        private String name;
        private String registrationNumber;
        private User user;

        public String getBursarID() {
            return bursarID;
        }

        public void setBursarID(String bursarID) {
            this.bursarID = bursarID;
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

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }
    }
}
