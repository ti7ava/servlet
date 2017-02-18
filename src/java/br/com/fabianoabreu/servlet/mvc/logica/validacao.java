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
public class validacao implements Logica {


  // A sessão é parecida com um objeto do tipo Map<String, Object>, podemos guardar nela qualquer objeto
//que quisermos dando-lhes uma chave que é uma String. 
  
    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        
        System.out.println("Usuario de login---->"+login);

        Connection connection = (Connection) req.getAttribute("conexao");
// passe a conexão no construtor
        Contato contato = new Contato();
        contato.setLogin(login);
        contato.setSenha(senha);

        ContatoDao dao = new ContatoDao(connection);
        String autenticacao = dao.autentica(contato);
        
         
         HttpSession session = req.getSession(); 
        if (autenticacao.equals("Usuario autenticado")) {
           
            System.out.println("Usuario situacao:--->"+autenticacao);
            //usuario.setLogin(login);
            
            session.setAttribute("login",login);

            return "/WEB-INF/jsp/menu.jsp";
}
            
        else {
            session.setAttribute("login",null);
            session.invalidate();
            
            //usuario.setLogin(null);
            return "/WEB-INF/jsp/autenticaUser.jsp";
        }

    }
    
    

    
    
    
    
    
    
    
    
    
    
    

}
