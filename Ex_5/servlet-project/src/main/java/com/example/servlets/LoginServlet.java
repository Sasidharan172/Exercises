package com.example.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("remember");
        String formSessionId = request.getParameter("sessionId");

        if (username != null && password != null && username.equals("admin") && password.equals("password")) {
            // 1. HTTP Session
            HttpSession session = request.getSession(true);
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(30 * 60); // 30 minutes

            // 2. Cookie-based tracking
            if (rememberMe != null && rememberMe.equals("on")) {
                Cookie userCookie = new Cookie("username", username);
                userCookie.setMaxAge(7 * 24 * 60 * 60); // 1 week
                response.addCookie(userCookie);

                Cookie sessionCookie = new Cookie("sessionId", session.getId());
                sessionCookie.setMaxAge(7 * 24 * 60 * 60);
                response.addCookie(sessionCookie);
            }

            // 3. URL Rewriting (as fallback)
            String encodedURL = response.encodeRedirectURL("WelcomeServlet");
            response.sendRedirect(encodedURL);
        } else {
            out.println("<!DOCTYPE html>");
            out.println("<html><head>");
            out.println("<meta http-equiv='refresh' content='3;url=index.html'>");
            out.println("<style>");
            out.println(".error-container { text-align: center; padding: 20px; }");
            out.println(".error-message { color: #f44336; }");
            out.println("</style>");
            out.println("</head><body>");
            out.println("<div class='error-container'>");
            out.println("<h3 class='error-message'>Invalid login credentials!</h3>");
            out.println("<p>Redirecting to login page in 3 seconds...</p>");
            out.println("</div>");
            out.println("</body></html>");
        }
    }
}
