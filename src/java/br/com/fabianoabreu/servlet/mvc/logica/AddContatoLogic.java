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
public class AddContatoLogic implements Logica{//apenas para redirecionar. Para não permitir acesso direto via jsp

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        return "/WEB-INF/jsp/adiciona-contato.jsp";
    }
    
}
