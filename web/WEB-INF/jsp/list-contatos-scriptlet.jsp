<%-- 
    Document   : lista-contatos-scriptlet
    Created on : 30/01/2017, 15:15:05
    Author     : Ten Renato
--%>
<%@ page import="java.util.*,
br.com.fabianoabreu.servlet.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <style>
table, th, td {
    border: 1px solid black;
}
</style>
    
    </head>
    <body>
        
        <table>
            <tr>
                <th>Nome:</th>    
                <th>Email:</th>
                <th>Endereço:</th>
                <th>Nascimento:</th>
            </tr>
            <br>
<%
ContatoDao dao = new ContatoDao();
List<Contato> contatos = dao.getLista();
for (Contato contato : contatos ) {
%>
<tr>
    <td><%=contato.getNome() %></td>
<td><%=contato.getEmail() %></td>
<td><%=contato.getEndereco() %></td>
<td><%=contato.getDataNascimento().getTime() %></td>
</tr>
<%
}
%>
</table>
        
    </body>
</html>
