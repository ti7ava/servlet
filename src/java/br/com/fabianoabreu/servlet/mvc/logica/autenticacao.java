/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renato
 */
public class autenticacao implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
//      String login = req.getParameter("login");
//      String senha = req.getParameter("senha");
//        
return "/WEB-INF/jsp/autenticaUser.jsp";
//      
    }
    
    
}