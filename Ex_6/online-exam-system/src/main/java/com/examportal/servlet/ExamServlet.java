package com.examportal.servlet;

import com.examportal.dao.ExamDAO;
import com.examportal.model.Exam;
import com.examportal.model.Question;
import com.examportal.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.util.List;
import java.io.IOException;

@WebServlet("/exam")
public class ExamServlet extends HttpServlet {
  private ExamDAO examDAO = new ExamDAO();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      int examId = Integer.parseInt(request.getParameter("examId"));
      Exam exam = new Exam();
      exam.setQuestions(examDAO.getExamQuestions(examId));
      request.setAttribute("exam", exam);
      request.getRequestDispatcher("/exam.jsp").forward(request, response);
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // Handle exam submission
    try {
      int examId = Integer.parseInt(request.getParameter("examId"));
      int studentId = ((Student) request.getSession().getAttribute("student")).getStudentId();
      // Calculate score based on submitted answers
      int score = calculateScore(request, examDAO.getExamQuestions(examId));
      examDAO.submitExam(studentId, examId, score);
      response.sendRedirect("marklist");
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  private int calculateScore(HttpServletRequest request, List<Question> questions) {
    int score = 0;
    for (Question question : questions) {
      String answer = request.getParameter("q" + question.getQuestionId());
      if (answer != null && answer.charAt(0) == question.getCorrectAnswer()) {
        score += question.getMarks();
      }
    }
    return score;
  }
}
