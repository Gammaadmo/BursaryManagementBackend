package org.biic0.org.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.biic0.org.domain.Admin;
import org.biic0.org.repository.AdminRepository;

import java.util.List;

@Service
    public class AdminService implements IAdminService {

        private final AdminRepository repo;

        @Autowired
        AdminService(AdminRepository repository) {
            this.repo = repository;
        }

        @Override
        public List<Admin> getall() {
            return repo.findAll();
        }

        @Override
        public Admin create(Admin admin) {
            return repo.save(admin);
        }

    @Override
    public Admin read(Long aLong) {
        return null;
    }

    @Override
        public Admin read(String adminID) {
            return repo.findById(adminID).orElse(null);
        }

        @Override
        public Admin update(Admin admin) {
            return repo.save(admin);
        }

        @Override
        public void delete(String adminID) {
            repo.deleteById(adminID);
        }
    }


