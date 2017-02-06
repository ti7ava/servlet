/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet.mvc.logica;

import br.com.fabianoabreu.servlet.Contato;
import br.com.fabianoabreu.servlet.ContatoDao;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ten Renato
 */
public class MostraContatoLogic implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        

        
        String id = req.getParameter("id");
        System.out.println("Id -----> "+id);
        
//        Contato contato = new Contato();
//        contato.setId(Long.parseLong(id));
        Contato contato = new Contato();
        ContatoDao dao = new ContatoDao();
        
        
        System.out.println("");
        
        contato = dao.getContatoId(id);
        
        System.out.println("TTTTTTTTTTTTTTTTTTVVVVVVVVVVVVVVVVVVVVVVV");
                
        req.setAttribute("contato", contato);
        
        return "/WEB-INF/jsp/listaContato.jsp";
        
    }
    
}
