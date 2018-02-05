package com.application.service;

import com.application.models.User;
import com.application.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Milos on 2/5/2018.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> list(){
        return userRepository.findAll();
    }

    public User getUserById(long id){
        return userRepository.findOne(id);
    }

    public List<User> getFriendsForUser(long id){

        User n = getUserById(id);

        List<User> tempUsers = new ArrayList<>();

        for (int i = 0; i < n.friends.length; i++) {
            int userID = n.friends[i];
            User u = getUserById(userID);
            tempUsers.add(u);
        }
        return tempUsers;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> save(List<User> users){
        return userRepository.save(users);
    }
}
