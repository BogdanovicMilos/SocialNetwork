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

    public List<User> getDirectFriendsForUser(long id){

        List<User> friends = new ArrayList<>();

        User n = getUserById(id);

        for (int i = 0; i < n.friends.length; i++) {
            int userID = n.friends[i];
            User u = getUserById(userID);
            friends.add(u);
        }

        return friends;
    }

    public List<User> getFriendsOfFriendsForUser(long id){

        List<User> friendsOfFriends = new ArrayList<>();
        List<User> friends = getDirectFriendsForUser(id);

        for(int i = 0; i < friends.size(); i++) {
            User user = friends.get(i);
            List<User> fof = getDirectFriendsForUser(user.id);
            friendsOfFriends.addAll(fof);
        }

        return friendsOfFriends;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Iterable<User> save(List<User> users){
        return userRepository.save(users);
    }
}
