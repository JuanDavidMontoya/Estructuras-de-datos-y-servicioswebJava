<%-- 
    Document   : index
    Created on : 29-may-2019, 18:55:15
    Author     : Juan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Aplicacion WEB para estadistica</h1>
        <p>Ingrese la lista de numeros enteros separados por comas</p>

        <form action="lista" method="post">
            Lista: <input type="text" name="lista" required="required"><br><br>
            
            <br>
            <input type="submit" name="lista" value="lista y genera">
        </form>

        <label class="form-group">Moda : </label>
                <input type="text" name="nombre" value="<%=request.getParameter("moda")%>"/><br><br>    

                <label class="form-group">Media : </label>
                <input type="text" name="nombre" value="<%=request.getParameter("media")%>"/><br><br>
    </body>
</html>
