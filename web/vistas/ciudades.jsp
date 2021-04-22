<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Ciudades"%>
<%
    ArrayList<Ciudades> lista = (ArrayList<Ciudades>)request.getAttribute("lista_ciudades");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Datos de la Ciudades</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Nombre</th>
                <th>Capital</th>
                <th>Numero de Hab</th>
            </tr>
            <c:forEach var="item" items="${lista_ciudades}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.nombre}</td>
                    <td>${item.capital}</td>
                    <td>${item.habitantes}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="index.jsp">Volver</a>
    </body>
</html>
