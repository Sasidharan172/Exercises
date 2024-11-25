package com.examportal.model;

import java.util.Date;

public class Question {
  private int questionId;
  private int examId;
  private String questionText;
  private String optionA;
  private String optionB;
  private String optionC;
  private String optionD;
  private char correctAnswer;
  private int marks;
  private Date createdAt;

  // Default constructor
  public Question() {
  }

  // Parameterized constructor
  public Question(int questionId, String questionText, int marks) {
    this.questionId = questionId;
    this.questionText = questionText;
    this.marks = marks;
  }

  // Getters and Setters
  public int getQuestionId() {
    return questionId;
  }

  public void setQuestionId(int questionId) {
    this.questionId = questionId;
  }

  public int getExamId() {
    return examId;
  }

  public void setExamId(int examId) {
    this.examId = examId;
  }

  public String getQuestionText() {
    return questionText;
  }

  public void setQuestionText(String questionText) {
    this.questionText = questionText;
  }

  public String getOptionA() {
    return optionA;
  }

  public void setOptionA(String optionA) {
    this.optionA = optionA;
  }

  public String getOptionB() {
    return optionB;
  }

  public void setOptionB(String optionB) {
    this.optionB = optionB;
  }

  public String getOptionC() {
    return optionC;
  }

  public void setOptionC(String optionC) {
    this.optionC = optionC;
  }

  public String getOptionD() {
    return optionD;
  }

  public void setOptionD(String optionD) {
    this.optionD = optionD;
  }

  public char getCorrectAnswer() {
    return correctAnswer;
  }

  public void setCorrectAnswer(char correctAnswer) {
    this.correctAnswer = correctAnswer;
  }

  public int getMarks() {
    return marks;
  }

  public void setMarks(int marks) {
    this.marks = marks;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "Question{" +
        "questionId=" + questionId +
        ", examId=" + examId +
        ", questionText='" + questionText + '\'' +
        ", marks=" + marks +
        ", correctAnswer=" + correctAnswer +
        '}';
  }
}
