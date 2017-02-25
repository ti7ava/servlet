/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renato
 */
public class Redireciona extends HttpServlet {

    
    @Override
    protected void service(HttpServletRequest request,HttpServletResponse response)
                                throws IOException, ServletException {
       // request.getRequestDispatcher("/WEB-INF/jsp/autenticaUser.jsp").forward(request, response);
    System.out.println("Vou tentar redirecionar");
    
    request.getRequestDispatcher("/WEB-INF/jsp/autenticaUser.jsp?invalidate=true").forward(request, response);

//String pagina="autenticaUser.jsp";   
//response.sendRedirect(pagina);    redirect envia para o navegador 
//o endereço da página e avisa ao navegador para ele mesmo solicitar a página. Então, com a página
//armazenada em web-inf o navegador não consegue acessar porque ele vai requisitar a página diretamente
//mas o acesso ao web-inf é proibido de fora da aplicação
    
    }
    }

   


