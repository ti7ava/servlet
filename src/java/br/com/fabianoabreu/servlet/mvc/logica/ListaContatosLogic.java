/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet.mvc.logica;

import br.com.fabianoabreu.servlet.Contato;
import br.com.fabianoabreu.servlet.ContatoDao;
import java.sql.Connection;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ten Renato
 */
public class ListaContatosLogic implements Logica {
@Override
public String executa(HttpServletRequest req, HttpServletResponse res)
throws Exception {
    
    Connection connection = (Connection) req.getAttribute("conexao");
// passe a conexão no construtor

    
List<Contato> contatos = new ContatoDao(connection).getLista();
req.setAttribute("contatos", contatos);

//RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/jsp/lista-contatos.jsp");
//rd.forward(req, res);
//return("OK");
//res.setContentType("text/html");                           
//res.sendRedirect("/WEB-INF/jsp/lista-contatos.jsp");    
//return("OK");


return "/WEB-INF/jsp/lista-contatos.jsp";
}
}
