<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <c:choose>
   
        <c:when test="${empty requestScope.listUsers}">
            <form >
            <h1>Nothing to display</h1>
            </form>
        </c:when>
        <c:otherwise>
        <!-- <form action="actionPendingRequests.htm" method="POST"> -->
            <table border="1 solid black">
            <thead>
                <tr>
                    <td>Username</td>
                    <td>User Email</td>
                    <td>User Type</td>
                    <td>Gender</td>
                    <td>Age</td>
                    <td>Action</td>
                </tr>
            </thead>
            <tr>
            <c:forEach items="${requestScope.listUsers}" var="data">
                <tr>
                    <td>
                        <c:out value="${data.username}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.email}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.type}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.gender}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.age}"></c:out>
                    </td>
                    <td><a href="actionPendingRequests.htm?username=${data.username}&action=Approved">Accept</a>
                    <a href="actionPendingRequests.htm?username=${data.username}&action=Rejected">Reject</a></td>
                </tr>
            </c:forEach>
            </tr>
        </table>
        <!-- </form> -->
        </c:otherwise>
    </c:choose>
  <p><a href="redirect.htm">Go To Home Page!</a></p>
</body>
</html>