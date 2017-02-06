<%-- 
    Document   : adiciona-contato
    Created on : 01/02/2017, 15:47:30
    Author     : Renato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="infocon" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <link href="css/jquery-ui.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp" />
        <h1>Adiciona Contatos</h1>
    <hr />
   <!-- <form action="adicionaContato"><!--mapeado em web.xml como AdicionaContatoServlet-->
     
   <form name="AdicionaContato" action="mvc">
    <input type="hidden" name="logica" value="AdicionaContatoLogic" />
      Nome: <input type="text" name="nome" /><br />
      E-mail: <input type="text" name="email" /><br />
      Endereço: <input type="text" name="endereco" /><br />
      Data Nascimento: 
        <infocon:campoData id="dataNascimento" /><br />
      
      <input type="submit" value="Gravar" />
    </form>
    
    <c:import url="rodape.jsp" />
    </body>
</html>
