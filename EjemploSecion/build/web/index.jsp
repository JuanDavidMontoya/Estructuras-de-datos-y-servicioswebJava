<%-- 
    Document   : index
    Created on : 15-may-2019, 18:47:51
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
HttpSession sesion = request.getSession();
String login = (String)sesion.getAttribute("login");
if (login == null){
   response.sendRedirect("login.jsp");
}

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Ejemplo Loggin!</h1>

        


    </body>
</html>
