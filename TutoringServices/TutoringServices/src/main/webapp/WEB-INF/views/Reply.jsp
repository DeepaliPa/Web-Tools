<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compose Message</title>
    </head>
    <body>
        
        <form action="sendMessage.htm" method="post">
            <h3>From:</h3>
            <c:out value="${sessionScope.usernameVal}"></c:out>
            <h3>To:</h3>
            <c:out  value="${sessionScope.toUser}"></c:out>
            <h3>Message:</h3>
            <textarea name="message" rows="6" cols="10" required></textarea>
            <br />
            <input type="hidden" name="from" value="${sessionScope.usernameVal}"/>  
            <input type="hidden" name="to" value="${sessionScope.toUser}"/>  
            <input type="submit" value="Send" />         
        </form>
        <p><a href="viewStudent.htm">Go To Home Page!</a></p>
    </body>
</html>