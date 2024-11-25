package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    // 1. Invalidate HTTP Session
    HttpSession session = request.getSession(false);
    if (session != null) {
      session.invalidate();
    }

    // 2. Remove Cookies
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
      for (Cookie cookie : cookies) {
        if (cookie.getName().equals("username") || cookie.getName().equals("sessionId")) {
          cookie.setMaxAge(0);
          response.addCookie(cookie);
        }
      }
    }

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html lang='en'>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
    out.println("<title>Logout</title>");
    out.println("<meta http-equiv='refresh' content='3;url=index.html'>");
    out.println("<style>");
    out.println(
        "body { font-family: 'Segoe UI', sans-serif; line-height: 1.6; background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%); min-height: 100vh; display: flex; justify-content: center; align-items: center; margin: 0; }");
    out.println(
        ".container { background: white; padding: 30px; border-radius: 10px; box-shadow: 0 8px 16px rgba(0,0,0,0.1); text-align: center; }");
    out.println(".success-message { color: #4CAF50; margin-bottom: 15px; }");
    out.println("</style>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='container'>");
    out.println("<h3 class='success-message'>Logout Successful!</h3>");
    out.println("<p>Redirecting to login page in 3 seconds...</p>");
    out.println("</div>");
    out.println("</body></html>");
  }
}
