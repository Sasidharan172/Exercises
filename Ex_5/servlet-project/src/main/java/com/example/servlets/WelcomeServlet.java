package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.util.Date;

@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    // Check various session tracking mechanisms
    HttpSession session = request.getSession(false);
    Cookie[] cookies = request.getCookies();
    String cookieUsername = null;
    String formSessionId = request.getParameter("sessionId");

    // Check cookies
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("username")) {
          cookieUsername = cookie.getValue();
        }
      }
    }

    if (session != null && session.getAttribute("username") != null) {
      String username = (String) session.getAttribute("username");
      outputWelcomePage(out, username, session);
    } else if (cookieUsername != null) {
      // Create new session from cookie
      session = request.getSession(true);
      session.setAttribute("username", cookieUsername);
      outputWelcomePage(out, cookieUsername, session);
    } else {
      response.sendRedirect("index.html");
    }
  }

  private void outputWelcomePage(PrintWriter out, String username, HttpSession session) {
    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    out.println("<title>Welcome</title>");
    out.println("<style>");
    // Add CSS styles here (similar to login page)
    out.println(
        "body { font-family: 'Segoe UI', sans-serif; line-height: 1.6; background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%); min-height: 100vh; margin: 0; padding: 20px; }");
    out.println(
        ".container { max-width: 800px; margin: 0 auto; background: white; padding: 30px; border-radius: 10px; box-shadow: 0 8px 16px rgba(0,0,0,0.1); }");
    out.println(".header { text-align: center; margin-bottom: 30px; }");
    out.println(".session-info { background: #f8f9fa; padding: 20px; border-radius: 5px; margin: 20px 0; }");
    out.println(
        ".btn { display: inline-block; padding: 10px 20px; background: #4CAF50; color: white; text-decoration: none; border-radius: 5px; margin-top: 20px; }");
    out.println(".btn:hover { background: #45a049; }");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");

    out.println("<div class='container'>");
    out.println("<div class='header'>");
    out.println("<h1>Welcome, " + username + "!</h1>");
    out.println("</div>");

    out.println("<div class='session-info'>");
    out.println("<h3>Session Information:</h3>");
    out.println("<p>Session ID: " + session.getId() + "</p>");
    out.println("<p>Creation Time: " + new Date(session.getCreationTime()) + "</p>");
    out.println("<p>Last Accessed Time: " + new Date(session.getLastAccessedTime()) + "</p>");
    out.println("<p>Max Inactive Interval: " + session.getMaxInactiveInterval() + " seconds</p>");
    out.println("</div>");

    out.println("<div style='text-align: center;'>");
    out.println("<a href='LogoutServlet' class='btn'>Logout</a>");
    out.println("</div>");

    out.println("</div>");
    out.println("</body></html>");
  }
}
