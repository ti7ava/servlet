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



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <c:import url="cabecalho.jsp" />
        <!-- cria o DAO -->
        
<!--a tag jsp:useBean, capaz de instanciar determinada classe através do 
construtor sem argumentos e dar um nome (id) para essa variável.-->        
<!--jsp:useBean id="dao" class="br.com.fabianoabreu.servlet.ContatoDao"/>-->

<table>
    <tr>
                <th>Nome:</th>    
                <th>Email:</th>
                <th>Endereço:</th>
                <th>Nascimento:</th>
            </tr>
            <br>
<!-- percorre contatos montando as linhas da tabela -->
<!--A JSTL core disponibiliza uma tag chamada c:forEach capaz de iterar por uma coleção-->
<!--c:forEach var="contato" items="{dao.lista}"--> <!--Como temos a variável dao, 
                                             desejamos chamar o método getLista e podemos fazer 
                                              isso através da EL:{dao.lista}-->
<!--precisamos indicar a coleção na qual vamos iterar, através do atributo items e
também como chamará o objeto que será atribuído para cada iteração no 
atributo var-->
 <c:forEach var="contato" items="${contatos}"> 
    <tr>


<td>${contato.nome}</td>
<td>
<c:if test="${not empty contato.email}">
<a href="mailto:${contato.email}">${contato.email}</a>
</c:if>

<c:if test="${empty contato.email}">
E-mail não informado
</c:if>
</td>



<td>${contato.endereco}</td>
<td><fmt:formatDate value="${contato.dataNascimento.time}"
pattern="dd/MM/yyyy" /></td>


<td>
    
<a href="mvc?logica=RemoveContatoLogic&id=${contato.id}">Remover</a>    
</td>

<td>
    
<a href="mvc?logica=MostraContatoLogic&id=${contato.id}">Alterar</a>    
</td>

</tr>
</c:forEach>
</table>



<!--É possível criar um contador do tipo int dentro do seu laço forEach. 
Para isso, basta definir o atributo chamado varStatus para a variável 
desejada e utilizar a propriedade count dessa variável.-->

<table border="1">
    <tr>
                <th>Ordem:</th>    
                <th>Nome:</th>
                
            </tr>
            <br>
<c:forEach var="contato" items="${contatos}" varStatus="id">
<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff' }" >
<td>${id.count}</td><td>${contato.nome}</td>
</tr>
</c:forEach>
</table>

<c:import url="rodape.jsp" />
    </body>
</html>
