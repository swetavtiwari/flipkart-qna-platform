package com.java.flipkart.service;

import com.java.flipkart.model.Profession;
import com.java.flipkart.model.Topic;
import com.java.flipkart.model.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserService {

    Set<User> users;


    public User signup(String name, Profession profession) {
        User user = new User(name, profession);
        System.out.println("Welcome " + user.getName());
        return user;
    }

    public void subscribe(User user, List<Topic> topics){
        user.subscribe(topics);
    }

    public boolean hasSubscribedToAllTopics(User user, List<Topic> topics) {
      return  new HashSet<>(user.getSubscribedTopics()).containsAll(topics);
    }
    public boolean hasSubscribedToSomeTopics(User user, List<Topic> topics) {
      return  user.getSubscribedTopics().stream().anyMatch(topics::contains);
    }

    public void logOut(User user){
        user.logOut();
        System.out.println(user.getName() + " logged out");
    }

    public void logIn(User user){
        user.logIn();
        System.out.println(user.getName() + " logged in");
    }

    public void showProfile(User user){
        System.out.println(user);
    }
}
