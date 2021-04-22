<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
    Document   : libros
    Created on : 20-abr-2021, 23:29:13
    Author     : Jorge
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.emergentes.modelo.Libros"%>
<%
    ArrayList<Libros> libros = (ArrayList<Libros>)request.getAttribute("libros");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Lista Libros</h1>
        <table border="1">
            <tr>
                <th>ID</th>
                <th>TITULO</th>
                <th>AUTOR</th>
                <th>CODIGO ISBN</th>
            </tr>
            <c:forEach var="item" items="${libros}">
                <tr>
                    <td>${item.id}</td>
                    <td>${item.titulo}</td>
                    <td>${item.autor}</td>
                    <td>${item.isbn}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="index.jsp">Volver</a>
    </body>
</html>
