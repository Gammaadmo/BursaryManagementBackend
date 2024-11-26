package org.biic0.org.service;

import org.apache.catalina.User;
import org.biic0.org.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public org.biic0.org.domain.User create(org.biic0.org.domain.User user) {
        return userRepository.save(user);
    }

    @Override
    public org.biic0.org.domain.User read(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public org.biic0.org.domain.User update(org.biic0.org.domain.User user) {
        return userRepository.save(user);
    }

    @Override
    public org.biic0.org.domain.User update(User user) {
        return null;
    }

    @Override
    public List<org.biic0.org.domain.User> getAll() {
        return userRepository.findAll();
    }
    public List<org.biic0.org.domain.User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }//oyo
}
