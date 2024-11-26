package org.biic0.org.controller;

import org.biic0.org.domain.Bursary;
import org.biic0.org.service.BursaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bursaries")
public class BursaryController {

    private final BursaryService bursaryService;

    @Autowired
    public BursaryController(BursaryService bursaryService) {
        this.bursaryService = bursaryService;
    }

    @PostMapping
    public ResponseEntity<Bursary> createBursary(@RequestBody Bursary bursary) {
        Bursary createdBursary = bursaryService.create(bursary);
        return new ResponseEntity<>(createdBursary, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bursary> getBursary(@PathVariable Long id) {
        Bursary bursary = bursaryService.read(id);
        if (bursary == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bursary, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Bursary>> getAllBursaries() {
        List<Bursary> bursaries = bursaryService.getAll();
        return new ResponseEntity<>(bursaries, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bursary> updateBursary(@PathVariable Long id, @RequestBody Bursary bursary) {
        Bursary existingBursary = bursaryService.read(id);
        if (existingBursary == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        bursary.setId(id);
        Bursary updatedBursary = bursaryService.update(bursary);
        return new ResponseEntity<>(updatedBursary, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBursary(@PathVariable Long id) {
        if (!bursaryService.delete(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
