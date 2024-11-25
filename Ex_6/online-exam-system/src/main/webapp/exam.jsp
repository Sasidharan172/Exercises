<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Online Examination</title>
</head>
<body>
    <h2>${exam.title}</h2>
    <form action="submitExam" method="post">
        <input type="hidden" name="examId" value="${exam.examId}">
        <c:forEach items="${exam.questions}" var="question" varStatus="status">
            <div class="question">
                <p>${status.count}. ${question.questionText}</p>
                <input type="radio" name="q${question.questionId}" value="A"> ${question.optionA}<br>
                <input type="radio" name="q${question.questionId}" value="B"> ${question.optionB}<br>
                <input type="radio" name="q${question.questionId}" value="C"> ${question.optionC}<br>
                <input type="radio" name="q${question.questionId}" value="D"> ${question.optionD}<br>
            </div>
        </c:forEach>
        <input type="submit" value="Submit Exam">
    </form>
</body>
</html>
