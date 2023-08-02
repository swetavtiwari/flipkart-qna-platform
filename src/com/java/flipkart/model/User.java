package com.java.flipkart.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private Profession profession;

    private List<Topic> subscribedTopics;
    private boolean loggedIn;

    public User(String name, Profession profession){
        this.id = UUID.randomUUID();
        this.name = name;
        this.profession = profession;
        this.subscribedTopics = new ArrayList<>();
        this.loggedIn = true;
    }

    public void subscribe(List<Topic> topics){
        subscribedTopics.addAll(topics);
    }

    public List<Topic> getSubscribedTopics() {
        return subscribedTopics;
    }

    public String getName(){
        return name;
    }

    public UUID getId(){
        return id;
    }

    public boolean equals(Object other){
        if(!(other instanceof  User)){
            return false;
        }
        return ((User) other).getId() == id;
    }

    public void logOut() {
        this.loggedIn = false;
    }

    public void logIn() {
        this.loggedIn = true;
    }

    public String toString(){
        return name + " profession: "+ profession;
    }
}
