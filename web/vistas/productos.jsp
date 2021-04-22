<%-- 
    Document   : productos
    Created on : 21-abr-2021, 0:41:02
    Author     : Jorge
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Productos"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    ArrayList<Productos> lista = (ArrayList<Productos>)request.getAttribute("lista");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista de Productos</h1>
        <table border="1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Precio Bs.</th>
                <th>Tipo</th>
            </tr>
            <c:forEach var="item" items="${lista}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.precio}</td>
                    <td>${item.tipo}</td>
                </tr>
            </c:forEach>
            
        </table>
        <br>
        <a href="index.jsp">Volver</a>
    </body>
</html>
