package com.java.flipkart.service;

import com.java.flipkart.model.Answer;
import com.java.flipkart.model.Question;
import com.java.flipkart.model.User;

import java.util.ArrayList;
import java.util.List;

public class AnswerService {

   private List<Answer> answers;
   private UserService userService;

   public AnswerService(UserService userService){
       answers = new ArrayList<>();
       this.userService = userService;
   }


    public boolean answerPresentForQuestion(Question question){
        return answers.stream().anyMatch(answer -> answer.getQuestionId() == question.getId());
    }

    public Answer answerQuestion(Question question, User user, String ans){
        if(!userService.hasSubscribedToSomeTopics(user, question.getTopics())){
            System.out.println("User not subscribed to topic to answer");
            return null;
        }
        Answer answer = new Answer(ans, user, question.getId());
        answers.add(answer);
        System.out.println("Answer added" + answer);
        return answer;
    }

    public void acceptAnswer(User user, Answer answer, Question question){
        if(!question.getCreatedBy().equals(user)){
            System.out.println("Only creator of question can accept answers");
            return;
        }
        System.out.println("Answer accepted");
        answer.accept();
    }

    public void showAnswer(Question question){

       answers.stream().filter(answer -> answer.getQuestionId() == question.getId())
               .forEach(System.out::println);
    }

    public void upvote(Answer answer){
       answer.upvote();
       System.out.println("Answer upvoted");
    }
}
