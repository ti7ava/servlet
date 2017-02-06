<%-- 
    Document   : lista-contatos
    Created on : 30/01/2017, 20:18:35
    Author     : Renato
--%>

<!--A JSTL é a API que encapsulou em tags simples toda a 
funcionalidade que diversas páginasWeb precisam-->

<!--define qual taglib vamos utilizar e um nome, chamado prefixo-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!--tag para formatação de Datas-->
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@taglib tagdir="/WEB-INF/tags" prefix="infocon" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/jquery-ui.css" rel="stylesheet">
        <script src="js/jquery.js"></script>
        <script src="js/jquery-ui.js"></script>
        
        <title>Altera Contato</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp" />
        <!-- cria o DAO -->
        
<!--a tag jsp:useBean, capaz de instanciar determinada classe através do 
construtor sem argumentos e dar um nome (id) para essa variável.-->        
<!--jsp:useBean id="dao" class="br.com.fabianoabreu.servlet.ContatoDao"/>-->


<!-- percorre contatos montando as linhas da tabela -->
<!--A JSTL core disponibiliza uma tag chamada c:forEach capaz de iterar por uma coleção-->
<!--c:forEach var="contato" items="{dao.lista}"--> <!--Como temos a variável dao, 
                                             desejamos chamar o método getLista e podemos fazer 
                                              isso através da EL:{dao.lista}-->
<!--precisamos indicar a coleção na qual vamos iterar, através do atributo items e
também como chamará o objeto que será atribuído para cada iteração no 
atributo var-->
 
<h2> Altere as informações do Contato</h2>
<form name="AlteraContato" action="mvc">
    <input type="hidden" name="logica" value="AlteraContatoLogic" />
    
    <label>Id - (Não pode ser alterado):</label> <input type="text" name="id" value="${contato.id}" readonly="readonly" /><br><br>
    <label for ="nome">Nome:</label> <input type="text" name="nome" id ="nome" value="${contato.nome}" /><br><br><!--id pega foco do label for e name pega os dados de entrada de texto-->
    <label for ="email">Email:</label> <input type="text" name="email" id="email" value="${contato.email}" /><br><br>
    <label for ="endereco">Endereço:</label> <input type="text" name="endereco" id="endereco" value="${contato.endereco}" /><br><br>
    Nascimento:<infocon:campoData id="dataNascimento" /><br><br>
    
    <input type="submit" value="Alterar" />
    
</form>

<c:import url="rodape.jsp" />
    </body>
</html>
