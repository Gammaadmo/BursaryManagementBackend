package org.biic0.org.service;

import org.biic0.org.domain.Bursar;
import org.biic0.org.repository.BursarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BursarService {

    private final BursarRepository bursarRepository;

    @Autowired
    public BursarService(BursarRepository bursarRepository) {
        this.bursarRepository = bursarRepository;
    }

    public Bursar create(Bursar bursar) {
        return bursarRepository.save(bursar);
    }

    public List<Bursar> getAll() {
        return bursarRepository.findAll();
    }

    public Bursar read(String bursarId) {
        Optional<Bursar> bursar = bursarRepository.findById(bursarId);
        return bursar.orElse(null); // returns null if not found
    }

    public Bursar update(Bursar bursar) {
        if (bursarRepository.existsById(bursar.getBursarId())) {
            return bursarRepository.save(bursar);
        }
        return null; // Return null if not found
    }

    public boolean delete(String bursarId) {
        if (bursarRepository.existsById(bursarId)) {
            bursarRepository.deleteById(bursarId);
            return true;
        }
        return false; // Return false if not found
    }
}
