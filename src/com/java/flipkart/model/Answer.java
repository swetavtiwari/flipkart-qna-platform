package com.java.flipkart.model;

import java.util.UUID;

public class Answer {

    UUID id;
    UUID questionId;
    String answer;

    boolean accepted;

    User createdBy;
    int upVotes;

    public Answer(String answer, User createdBy, UUID questionId){
        this.answer = answer;
        this.createdBy = createdBy;
        this.questionId = questionId;
    }

    public UUID getId(){
        return id;
    }

    public UUID getQuestionId(){
        return questionId;
    }

    public String getAnswer(){
        return answer;
    }


    public int getUpVotes(){
        return upVotes;
    }

    public void accept() {
        this.accepted = true;
    }

    public void upvote() {
        upVotes++;
    }

    public String toString(){
        return String.format("+++ %s \n %d upvotes \n -----\n" , answer, upVotes);
    }
}
