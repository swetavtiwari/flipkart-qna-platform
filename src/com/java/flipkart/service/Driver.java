package com.java.flipkart.service;

import com.java.flipkart.model.*;

import java.util.List;

public class Driver {

    private UserService userService;
    private QuestionService questionService;
    private AnswerService answerService;

    public Driver() {
        userService = new UserService();
        answerService = new AnswerService(userService);
        questionService = new QuestionService(userService, answerService);
    }

    public void start() {

        User sachin = userService.signup("Sachin", Profession.DEVELOPER);
        userService.subscribe(sachin, List.of(Topic.JAVA, Topic.HADOOP, Topic.JDK));
        questionService.addQuestion(sachin, "What are new opensource jdks", List.of(Topic.JAVA, Topic.JDK));
        Question question2 = questionService.addQuestion(sachin, "Does Hadoop work on JDK 11", List.of(Topic.HADOOP, Topic.JDK));
        questionService.getQuestions(null, null);
        System.out.println("----------------------");
        questionService.getQuestions(List.of(Topic.JAVA), null);
        System.out.println("----------------------");
        questionService.getQuestions(List.of(Topic.JAVA), true);
        System.out.println("----------------------");
        userService.logOut(sachin);

        User kalyan = userService.signup("Kalyan", Profession.DEVELOPER);
        userService.subscribe(kalyan, List.of(Topic.APACHE, Topic.HADOOP));
        System.out.println("----------------------");
        questionService.getQuestions(null, null);
        System.out.println("----------------------");
        questionService.addQuestion(kalyan, "Does Apache Spark straming of data from hdfs", List.of(Topic.APACHE, Topic.HADOOP));
        System.out.println("----------------------");
        Answer answerQ2 = answerService.answerQuestion(question2, kalyan, "Yes Hadoop 3 and aove supports it");
        System.out.println("----------------------");
        questionService.getQuestions(null, null);
        System.out.println("----------------------");
        userService.logOut(kalyan);

        User lokesh = userService.signup("Lokesh", Profession.DEVELOPER);
        userService.subscribe(kalyan, List.of(Topic.APACHE, Topic.HADOOP, Topic.JAVA));
        System.out.println("----------------------");
        questionService.getQuestions(null, null);
        System.out.println("----------------------");
        questionService.showQuestion(question2);
        System.out.println("----------------------");
        answerService.acceptAnswer(lokesh, answerQ2, question2);
        answerService.upvote(answerQ2);
        userService.logOut(lokesh);

        userService.logIn(sachin);
        System.out.println("----------------------");
        questionService.getQuestions(null, null);
        userService.showProfile(kalyan);
        System.out.println("----------------------");
        questionService.showQuestion(question2);
        System.out.println("----------------------");
        answerService.acceptAnswer(sachin, answerQ2, question2);
        System.out.println("----------------------");
        userService.showProfile(kalyan);
        System.out.println("----------------------");
        questionService.getQuestions(null, true);
        System.out.println("----------------------");
        userService.logOut(sachin);
    }
}
