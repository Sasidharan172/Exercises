package com.examportal.model;

import java.util.Date;

public class ExamResult {
  private int resultId;
  private int studentId;
  private int examId;
  private int score;
  private double percentage;
  private boolean passed;
  private Date completedDate;

  // Additional fields for display purposes
  private String studentName;
  private String examTitle;

  // Default constructor
  public ExamResult() {
  }

  // Parameterized constructor
  public ExamResult(int studentId, int examId, int score) {
    this.studentId = studentId;
    this.examId = examId;
    this.score = score;
  }

  // Getters and Setters
  public int getResultId() {
    return resultId;
  }

  public void setResultId(int resultId) {
    this.resultId = resultId;
  }

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public int getExamId() {
    return examId;
  }

  public void setExamId(int examId) {
    this.examId = examId;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public double getPercentage() {
    return percentage;
  }

  public void setPercentage(double percentage) {
    this.percentage = percentage;
  }

  public boolean isPassed() {
    return passed;
  }

  public void setPassed(boolean passed) {
    this.passed = passed;
  }

  public Date getCompletedDate() {
    return completedDate;
  }

  public void setCompletedDate(Date completedDate) {
    this.completedDate = completedDate;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getExamTitle() {
    return examTitle;
  }

  public void setExamTitle(String examTitle) {
    this.examTitle = examTitle;
  }

  @Override
  public String toString() {
    return "ExamResult{" +
        "resultId=" + resultId +
        ", studentId=" + studentId +
        ", examId=" + examId +
        ", score=" + score +
        ", percentage=" + percentage +
        ", passed=" + passed +
        ", completedDate=" + completedDate +
        ", studentName='" + studentName + '\'' +
        ", examTitle='" + examTitle + '\'' +
        '}';
  }
}
