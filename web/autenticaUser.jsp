<%-- 
    Document   : autenticaUser
    Created on : 09/02/2017, 20:48:45
    Author     : Renato
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <form name="validaUsuario" action="mvc" method="POST">
        <input type="hidden" name="logica" value="validacao" />
            <table border="0">
                <thead>
                    <tr>
                        <th colspan="2">Autenticação</th>
                        
                    </tr>
                </thead>
                
                <tbody>
                    <tr>
                        <td>Login:</td>
                        <td><input type="text" name="login" size="20" /> </td>
                    </tr>
                    
                    <tr>
                        <td>Senha:</td>
                        <td><input type="password" name="senha" size="20" /></td>
                    </tr>
                    
                    <tr>
                        <td><input type="submit" value="Entrar" /></td>
                        
                    </tr>
                </tbody>
            </table>

        
        </form>
        
    </body>
</html>
