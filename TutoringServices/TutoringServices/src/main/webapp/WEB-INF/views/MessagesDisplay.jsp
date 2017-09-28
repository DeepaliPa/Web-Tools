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
                    <th>From</th>
                    <th>To</th>
                    <th>Messages</th>
                 <!--   <th>Reply</th> -->  
                </tr>


                <c:forEach var="data" items="${sessionScope.listValue}">
                    <tr>
                        <td>
                            <c:out value="${data.fromUser}"></c:out>
                        </td>
                        <td>
                            <c:out value="${data.userName}"></c:out>
                        </td>
                        <td>
                        	<c:out value="${data.message}"></c:out> 
                        </td>
                      <!--   <td>
                        	<a href="reply.htm?toUser=<c:out value="${data.fromUser}"/>">Reply</a>  
                        </td>--> 

                    </tr>
                </c:forEach>

            </table>  
            
        </form>
<p><a href="redirect.htm">Go To Home Page!</a></p>
</body>
</html>