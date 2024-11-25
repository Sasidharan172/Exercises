package com.examportal.dao;

import com.examportal.model.*;
import com.examportal.util.DBUtil;
import java.sql.*;
import java.util.*;

public class ExamDAO {
  public List<Question> getExamQuestions(int examId) throws Exception {
    List<Question> questions = new ArrayList<>();
    try (Connection conn = DBUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "SELECT * FROM questions WHERE exam_id = ?")) {

      stmt.setInt(1, examId);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        Question question = new Question();
        question.setQuestionId(rs.getInt("question_id"));
        question.setQuestionText(rs.getString("question_text"));
        question.setOptionA(rs.getString("option_a"));
        question.setOptionB(rs.getString("option_b"));
        question.setOptionC(rs.getString("option_c"));
        question.setOptionD(rs.getString("option_d"));
        question.setMarks(rs.getInt("marks"));
        questions.add(question);
      }
    }
    return questions;
  }

  public void submitExam(int studentId, int examId, int score) throws Exception {
    try (Connection conn = DBUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO exam_results (student_id, exam_id, score) VALUES (?, ?, ?)")) {

      stmt.setInt(1, studentId);
      stmt.setInt(2, examId);
      stmt.setInt(3, score);
      stmt.executeUpdate();
    }
  }
}
