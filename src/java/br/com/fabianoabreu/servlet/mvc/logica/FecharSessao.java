/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet.mvc.logica;

import br.com.fabianoabreu.servlet.Contato;
import br.com.fabianoabreu.servlet.ContatoDao;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Renato
 */
public class FecharSessao implements Logica {


  // A sessÃ£o Ã© parecida com um objeto do tipo Map<String, Object>, podemos guardar nela qualquer objeto
//que quisermos dando-lhes uma chave que Ã© uma String. 
  
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        
         
            HttpSession session = req.getSession(false); 
            session.invalidate();
            
            String loginURI = req.getContextPath() + "/mvc?logica=autenticacao";
            
            //res.sendRedirect(loginURI);
            return "mvc?logica=autenticacao";
}
            
        
    }
    
    

    
    
    
    
    
    
    
    
    
    
    


