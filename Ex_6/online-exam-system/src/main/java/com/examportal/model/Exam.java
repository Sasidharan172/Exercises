package com.examportal.model;

import java.util.Date;
import java.util.List;

public class Exam {
  private int examId;
  private String title;
  private String description;
  private int durationMinutes;
  private int totalMarks;
  private double passingPercentage;
  private Date createdAt;
  private List<Question> questions;

  // Default constructor
  public Exam() {
  }

  // Parameterized constructor
  public Exam(int examId, String title, int durationMinutes, int totalMarks) {
    this.examId = examId;
    this.title = title;
    this.durationMinutes = durationMinutes;
    this.totalMarks = totalMarks;
  }

  // Getters and Setters
  public int getExamId() {
    return examId;
  }

  public void setExamId(int examId) {
    this.examId = examId;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public int getDurationMinutes() {
    return durationMinutes;
  }

  public void setDurationMinutes(int durationMinutes) {
    this.durationMinutes = durationMinutes;
  }

  public int getTotalMarks() {
    return totalMarks;
  }

  public void setTotalMarks(int totalMarks) {
    this.totalMarks = totalMarks;
  }

  public double getPassingPercentage() {
    return passingPercentage;
  }

  public void setPassingPercentage(double passingPercentage) {
    this.passingPercentage = passingPercentage;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public List<Question> getQuestions() {
    return questions;
  }

  public void setQuestions(List<Question> questions) {
    this.questions = questions;
  }

  @Override
  public String toString() {
    return "Exam{" +
        "examId=" + examId +
        ", title='" + title + '\'' +
        ", description='" + description + '\'' +
        ", durationMinutes=" + durationMinutes +
        ", totalMarks=" + totalMarks +
        ", passingPercentage=" + passingPercentage +
        ", createdAt=" + createdAt +
        ", questionsCount=" + (questions != null ? questions.size() : 0) +
        '}';
  }
}
