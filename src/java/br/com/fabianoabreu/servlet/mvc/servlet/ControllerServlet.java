/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet.mvc.servlet;

import br.com.fabianoabreu.servlet.mvc.logica.Logica;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ControllerServlet extends HttpServlet {
@Override
protected void service(HttpServletRequest request,
HttpServletResponse response)
throws ServletException, IOException {
String parametro = request.getParameter("logica");
System.out.println("Logica------>"+parametro);
String nomeDaClasse = "br.com.fabianoabreu.servlet.mvc.logica." + parametro;
try {
Class classe = Class.forName(nomeDaClasse);
Logica logica = (Logica) classe.newInstance();
String pagina = logica.executa(request, response);
request.getRequestDispatcher(pagina).forward(request, response);
} catch (Exception e) {
throw new ServletException(
"A lógica de negócios causou uma exceção", e);
}
}
}