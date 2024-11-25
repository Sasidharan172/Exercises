<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Student Mark List</title>
    <style>
        table { border-collapse: collapse; width: 100%; }
        th, td { border: 1px solid black; padding: 8px; text-align: left; }
        th { background-color: #f2f2f2; }
    </style>
</head>
<body>
    <h2>Mark List for ${student.fullName}</h2>
    <table>
        <tr>
            <th>Exam Title</th>
            <th>Score</th>
            <th>Completion Date</th>
        </tr>
        <c:forEach items="${markList}" var="result">
            <tr>
                <td>${result.examTitle}</td>
                <td>${result.score}</td>
                <td><fmt:formatDate value="${result.completedDate}" pattern="dd-MM-yyyy HH:mm"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
