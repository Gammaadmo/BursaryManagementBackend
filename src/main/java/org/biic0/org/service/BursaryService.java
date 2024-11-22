package org.biic0.org.service;

import org.biic0.org.domain.Bursary;
import org.biic0.org.repository.BursaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BursaryService implements IBursaryService {

    private final BursaryRepository bursaryRepository;

    @Autowired
    public BursaryService(BursaryRepository bursaryRepository) {
        this.bursaryRepository = bursaryRepository;
    }

    @Override
    public Bursary create(Bursary bursary) {
        return bursaryRepository.save(bursary);
    }

    @Override
    public List<Bursary> getAll() {
        return bursaryRepository.findAll();
    }

    @Override
    public Bursary read(String bursaryId) {
        return null;
    }

    @Override
    public Bursary read(Long bursaryId) {
        Optional<Bursary> bursary = bursaryRepository.findById(bursaryId);
        return bursary.orElse(null);
    }

    @Override
    public Bursary update(Bursary bursary) {
        return bursaryRepository.save(bursary);
    }

    @Override
    public boolean delete(String bursaryId) {
        return false;
    }

    @Override
    public boolean delete(Long bursaryId) {
        if (bursaryRepository.existsById(bursaryId)) {
            bursaryRepository.deleteById(bursaryId);
            return true;
        }
        return false;
    }
}
