package com.sandunika.userservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User updateUser(Long id, User user) {
        User oldUser = userRepository.findById(id).orElse(null);
        if(oldUser!=null)
        {
            oldUser.setUserName(user.getUserName());
            userRepository.save(oldUser);
        }
        return oldUser;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
