<%-- 
    Document   : bemvindo.jsp
    Created on : 30/01/2017, 15:03:16
    Author     : Ten Renato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<%-- comentário em JSP aqui: nossa primeira página JSP --%>
<%
String mensagem = "Bem vindo ao sistema de CURSOS!";
%>
<% out.println(mensagem); %>
<br />
<%
String desenvolvido = "Desenvolvido por (RENATO)";
%>
<%= desenvolvido %>
<br />
<%
System.out.println("Tudo foi executado!");
%>
</body>
</html>
