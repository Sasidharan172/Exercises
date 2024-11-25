package com.examportal.servlet;

import com.examportal.dao.StudentDAO;
import com.examportal.model.Student;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/marklist")
public class MarkListServlet extends HttpServlet {
  private StudentDAO studentDAO = new StudentDAO();

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    try {
      Student student = (Student) request.getSession().getAttribute("student");
      request.setAttribute("markList", studentDAO.getStudentMarkList(student.getStudentId()));
      request.setAttribute("student", student);
      request.getRequestDispatcher("/marklist.jsp").forward(request, response);
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
