
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head class="hearder">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="estilos.css" rel="stylesheet" type="text/css"/>
        <title>Practica #1</title>
    </head>
    <body class="body">
        <h1 class="titulo">Practica Servlest-Aplicacion web para estadistica</h1>
        <form action="practica1" method="get" align="center">
            <p class="subtitulo">Ingrese lista de enteros separados por comas</p>
            <table align="center">
                <tr>
                    <th class="p">numeros </th>
                    <th><input type="text" name="numeros"></th>
                </tr>

            </table><br>

            <th> Tu media Es: </th>
            <th>  <%= request.getParameter("media")%></th>


            <input type="submit" class="button" value="Calcular">
            <button type="button" class="button" onclick="location = 'index.jsp'">Regresar</button> <br>    
        </form>

        <table align="center" class="subtitulo2">
            <tr>
                <th> Media=  </th>
                <th>  <%= request.getParameter("media")%></th> <br>
            </tr>  
            <tr>
                <th> Desviación Estándar=  </th><br>
            <th>  <%= request.getParameter("Desviacionestandar")%></th>
            </tr> 


    </table>
</body>
</html>
