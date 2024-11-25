package com.examportal.dao;

import com.examportal.model.*;
import com.examportal.util.DBUtil;
import java.sql.*;
import java.util.*;

public class StudentDAO {
  public List<Map<String, Object>> getStudentMarkList(int studentId) throws Exception {
    List<Map<String, Object>> results = new ArrayList<>();
    try (Connection conn = DBUtil.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "SELECT e.title, er.score, er.completed_date " +
                "FROM exam_results er " +
                "JOIN exams e ON er.exam_id = e.exam_id " +
                "WHERE er.student_id = ? " +
                "ORDER BY er.completed_date DESC")) {

      stmt.setInt(1, studentId);
      ResultSet rs = stmt.executeQuery();

      while (rs.next()) {
        Map<String, Object> result = new HashMap<>();
        result.put("examTitle", rs.getString("title"));
        result.put("score", rs.getInt("score"));
        result.put("completedDate", rs.getTimestamp("completed_date"));
        results.add(result);
      }
    }
    return results;
  }
}
