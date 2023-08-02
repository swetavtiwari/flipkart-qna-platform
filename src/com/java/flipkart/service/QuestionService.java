package com.java.flipkart.service;

import com.java.flipkart.model.Answer;
import com.java.flipkart.model.Question;
import com.java.flipkart.model.Topic;
import com.java.flipkart.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class QuestionService {

    private List<Question> questions;
    private UserService userService;
    private AnswerService answerService;

    public QuestionService(UserService userService, AnswerService answerService){

        this.questions = new ArrayList<>();
        this.userService = userService;
        this.answerService = answerService;

    }

    public Question addQuestion(User user, String question, List<Topic> topics){
        if(!userService.hasSubscribedToAllTopics(user,topics)){
            System.out.println("User not subscribed to topic");
            return null;
        }

        Question question1 = new Question(user, question, topics);
        questions.add(question1);
        System.out.println("Question Added");
        return question1;
    }

    public void getQuestions(List<Topic> topics, Boolean answered){
        Predicate<Question> filterOnTopic = getFilterOnTopic(topics);
        questions.stream()
                .filter(filterOnTopic)
                .filter(question -> Objects.isNull(answered)
                        || answerService.answerPresentForQuestion(question) == answered)
                .forEach(System.out::println);
    }

    public void upvote(Question question){
        question.upvote();
    }

    private static Predicate<Question> getFilterOnTopic(List<Topic> topics) {
        return Objects.isNull(topics)
                ? q -> true
                : question -> topics.stream().anyMatch(topic -> question.getTopics().contains(topic));
    }

    public void showQuestion(Question question2) {
        questions.stream().filter(question -> question.getId() ==(question2.getId()))
                .findFirst()
                .ifPresent(question -> {
                    System.out.println(question);
                    answerService.showAnswer(question);
                } );
    }
}
