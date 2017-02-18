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
        <script type="text/javascript" src="js/jquery.js"></script>
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
     
   <form id="formulario" name="AdicionaContato" action="mvc" method="POST">
        <input type="hidden" name="logica" value="AdicionaContatoLogic" />
        
            <br><br>
            <table width="450" align="center">
                <caption><h2>Cadastro de novo Usuário:</h2></caption>
                <tr>
                    <td>Nome:</td>
                    <td> <input type="text" name="nombre" id="nome"/></td>
                </tr>
                <tr>
                    <td> E-mail: </td>
                    <td><input type="text" name="mail" id="email" /></td>
                </tr>
                <tr>
                <td>Endereço: </td>
                <td><input type="text" name="locale" id="endereco"/></td>
                </tr>
                <tr>
                    <td> Data Nascimento: </td>
                    <td> <infocon:campoData id="dataNascimento" /></td>
                </tr>
                <tr>
                    <td> Login:</td>
                    <td><input type="text" name="loginID" id="login"/></td>
                </tr>
                <tr>
                    <td>Senha:</td>
                    <td><input type="text" name="senhaID"  id="senha"/></td>
                </tr>
                <tr>
                    <td> <a href="#" onclick="cadastro()"><input type="button" value="Cadastro" name="Cadastro2" /></a></td>
                </tr>
                <!--<tr>
                    <td colspan="2"><input type="submit" value="Entrar" /></td>
                </tr>-->
                
            </table>
            
        </form>
        
       
        
        
        <script type="text/javascript">
            
function cadastro(){

//var form = document.getElementById('formulario');
//var login = document.getElementById('login');
//var senha = document.getElementById('senha');


    // alerta o valor do campo
    //alert("Login: "+login.value+"Senha: "+senha.value);
    
    // $.get impede o reenvio do form no refresh da pagina
    //enviar requisições assíncronas, ou seja, manter a página que estava aberta intacta, 
    //e recuperar a resposta dessa requisição para fazermos qualquer processamento com eles.
    $.get("mvc?logica=AdicionaContatoLogic&login="+document.getElementById('login').value+"&senha="+document.getElementById('senha').value+
            "&endereco="+document.getElementById('endereco').value+"&nome="+document.getElementById('nome').value+"&email="+
            document.getElementById('email').value+"&dataNascimento="+document.getElementById('dataNascimento').value);

alert("Cadastro realizado com sucesso!!!!");

document.getElementById('login').value="";
document.getElementById('senha').value="";
document.getElementById('nome').value="";
document.getElementById('email').value="";
document.getElementById('endereco').value="";
document.getElementById('dataNascimento').value="";

    
    
}
</script>
   
   <!--<form name="AdicionaContato" action="mvc" method="POST">
    <input type="hidden" name="logica" value="AdicionaContatoLogic" />
      Nome: <input type="text" name="nome" /><br />
      E-mail: <input type="text" name="email" /><br />
      Endereço: <input type="text" name="endereco" /><br />
      Data Nascimento: 
        infocon:campoData id="dataNascimento" /><br />
        Login:<input type="text" name="login" /><br />
        Senha:<input type="text" name="senha"  /><br />
      
      <input type="submit" value="Gravar" />
    </form>-->
    
    <c:import url="rodape.jsp" />
    </body>
</html>
