package com.syte.syte.Service;

import com.syte.syte.Model.Entity.User;
import com.syte.syte.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    public void Save(User user) {
        userRepository.saveAndFlush(user);
    }

    public User findUserByUsername(String username) {

        List<User> list_users = userRepository.findAll();
        for (User user : list_users) {
            if (Objects.equals(user.getUsername(), username)) {
                return user;
            }
        }
        return null;
    }
}
