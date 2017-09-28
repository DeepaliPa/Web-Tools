<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Page</title>
</head>
<body>

        <form>   
            <table border="1">          
                <tr>
                    <th>Username</th>
                    <th>age</th>
                    <th>Gender</th>
                    <th>Subject Category</th>
                    <th>Tutoring Type</th>
                    <th>Email</th>
                    <th>Send Message</th>
                </tr>


                <c:forEach var="data" items="${sessionScope.listValue}">
                    <tr>
                        <td>
                            <c:out value="${data.username}"></c:out>
                        </td>
                        <td>
                            <c:out value="${data.age}"></c:out>
                        </td>
                        <td>
                        	<c:out value="${data.gender}"></c:out> 
                        </td>
                        <td>
                        	<c:out value="${data.subjectCategory}"></c:out>   
                        </td>
                        <td>
                        	<c:out value="${data.tutoringType}"></c:out>
                        </td>
                        <td>
                        	<c:out value="${data.email}"></c:out>
                        </td>
                        <td>
                        	<a href="reply.htm?toUser=<c:out value="${data.username}"/>">Send</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>  
        
        </form>
<p><a href="redirect.htm">Go To Home Page!</a></p>
</body>
</html>