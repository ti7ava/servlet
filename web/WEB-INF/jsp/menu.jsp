<%-- 
    Document   : menu
    Created on : 11/02/2017, 21:01:15
    Author     : Renato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<%
	// verificando se tem um atributo login na sessao
	// se tiver vai continuar e mostrar o menu
	
//String ssRp = request.getParameter("invalidate"); 
//if(ssRp!= null) session.invalidate();

//Você deve definir explicitamente o cabeçalho da resposta e deixar que o navegador 
//saiba não armazenar essas páginas em cache.Defina o cabeçalho de resposta como 
//abaixo para todas as páginas jsp que não devem ser mostradas no clique do botão Voltar.

response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);




        if(session.getAttribute("login") != null) {
        
        System.out.println("Atributo--->"+session.getAttribute("login"));

%>

<html>
<body>
<h2>Página inicial da Lista de Tarefas</h2>
<p>Bem vindo, ${login}</p>
criar um button com script para verificar se o usuraio esta logado. Se nao estiver, deve redirecionar
<a href="mvc?logica=AddContatoLogic">Clique aqui</a> para acessar a lista de tarefas
<a href="mvc?logica=FecharSessao">LOGOUT</a> 
</body>
</html>
<%
	// se não existir um login na sessao, 
	// vai enviar para a página de login novamente
	} else {
//response.sendRedirect(request.getContextPath() + "/WEB-INF/jsp/autenticaUser.jsp");

%>
            
            <jsp:forward page="/WEB-INF/jsp/autenticaUser.jsp"></jsp:forward>
<%
}
%>