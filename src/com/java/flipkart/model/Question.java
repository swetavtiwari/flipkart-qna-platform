package com.java.flipkart.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Question {
    UUID id;
    String question;
    List<Topic> topics;

    User createdBy;

    int upVotes;

    public Question(User user, String question, List<Topic> topics) {
        this.id = UUID.randomUUID();
        this.createdBy = user;
        this.question = question;
        this.topics = new ArrayList<>(topics);
    }

    public UUID getId() {
        return id;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public String getQuestion() {
        return question;
    }

    public int getUpVotes() {
        return upVotes;
    }

    public User getCreatedBy(){
        return createdBy;
    }

    public void upvote() {
        upVotes++;
    }

    public String toString(){
        return String.format("\n %s \n %s \n %d upvotes \n", createdBy.getName(), question, upVotes);
    }
}
