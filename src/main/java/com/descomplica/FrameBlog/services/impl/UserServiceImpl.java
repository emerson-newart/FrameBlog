package com.descomplica.FrameBlog.services.impl;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.descomplica.FrameBlog.models.User;
import com.descomplica.FrameBlog.repository.UserRepository;
import com.descomplica.FrameBlog.services.UserService;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(final User user) {
      User existingUser = userRepository.findByUsernaame(user.getName());
      if (Objects.nonNull(existingUser)) {
         throw new RuntimeException("Existing User");
      }
       User entity = new User(user.getUserId(), user.getName(), user.getEmail(), user.getPassword(), user.getRole());
       User newUser = userRepository.save(entity);
       return new User(newUser.getUserId(), newUser.getName(), newUser.getEmail(), newUser.getPassword(), newUser.getRole());
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }
    
}
