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
public class PrimeiraLogica implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        System.out.println("Executando a logica ...");
        System.out.println("Retornando o nome da página JSP ...");
        return "/WEB-INF/jsp/primeira-logica.jsp"; //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
