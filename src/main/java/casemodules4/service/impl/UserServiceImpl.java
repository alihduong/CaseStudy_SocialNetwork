package casemodules4.service.impl;

import casemodules4.model.User;
import casemodules4.repository.IUserRepository;
import casemodules4.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public Iterable<User> findAll() {
        return iUserRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return iUserRepository.findById(id);
    }

    @Override
    public User save(User user) {
        return iUserRepository.save(user);
    }

    @Override
    public void remove(Long id) {
        iUserRepository.deleteById(id);
    }
}
