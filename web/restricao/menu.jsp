<%-- 
    Document   : menu
    Created on : 11/02/2017, 21:01:15
    Author     : Renato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        response.setDateHeader("Expires", 0); // Proxies.
        
        session = request.getSession(false);
        String loginURI = request.getContextPath() + "/mvc?logica=autenticacao";
        System.out.println("LoginURI = "+ loginURI);
        System.out.println("Atributo--->"+session.getAttribute("login"));
	// verificando se tem um atributo login na sessao
	// se tiver vai continuar e mostrar o menu
	if(session.getAttribute("login") != null) {
        
        System.out.println("Atributo--->"+session.getAttribute("login"));
        
        
%>

<html>
<body>
<h2>Página inicial da Lista de Tarefas</h2>
<p>Bem vindo, ${login}</p>

<a href="/infocon-agenda/mvc?logica=AddContatoLogic">Clique aqui</a> para acessar a lista de tarefas<br>
<a href="/infocon-agenda/mvc?logica=FecharSessao">Logout/Sair</a>
</body>
</html>
<%
	// se não existir um login na sessao, 
	// vai enviar para a página de login novamente
	} else {

%>
	<jsp:forward page="/WEB-INF/jsp/autenticaUser.jsp"></jsp:forward>
<%
}
%>