package com.descomplica.FrameBlog.services.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.descomplica.FrameBlog.models.User;
import com.descomplica.FrameBlog.repository.UserRepository;
import com.descomplica.FrameBlog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User save(final User user) {
        User existingUser = userRepository.findByUsername(user.getName());
        if (Objects.nonNull(existingUser)) {
            throw new RuntimeException("Existing User");
        }

        String passwordHash = passwordEncoder.encode(user.getPassword());

        User entity = new User(user.getUserId(), user.getName(), user.getEmail(), user.getPassword(),
                user.getUsername(), user.getRole());
        User newUser = userRepository.save(entity);
        return new User(newUser.getUserId(), newUser.getName(), newUser.getEmail(), passwordHash,
                newUser.getUsername(), newUser.getRole());
    }

    @Override
    public List<User> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public User get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public User update(Long id, User user) {
        User userUpdate = userRepository.findById(id).orElse(null);
        if (Objects.nonNull(userUpdate)) {
            String passwordHash = passwordEncoder.encode(user.getPassword());
            userUpdate.setName(user.getName());
            userUpdate.setEmail(user.getEmail());
            userUpdate.setPassword(passwordHash);
            userUpdate.setRole(user.getRole());
            userUpdate.setUsername(user.getUsername());
            return userRepository.save(userUpdate);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
