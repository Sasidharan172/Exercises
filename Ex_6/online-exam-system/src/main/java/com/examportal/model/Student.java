package com.examportal.model;

import java.util.Date;

public class Student {
  private int studentId;
  private String username;
  private String password;
  private String fullName;
  private String email;
  private Date createdAt;

  // Default constructor
  public Student() {
  }

  // Parameterized constructor
  public Student(int studentId, String username, String fullName, String email) {
    this.studentId = studentId;
    this.username = username;
    this.fullName = fullName;
    this.email = email;
  }

  // Getters and Setters
  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  @Override
  public String toString() {
    return "Student{" +
        "studentId=" + studentId +
        ", username='" + username + '\'' +
        ", fullName='" + fullName + '\'' +
        ", email='" + email + '\'' +
        ", createdAt=" + createdAt +
        '}';
  }
}
