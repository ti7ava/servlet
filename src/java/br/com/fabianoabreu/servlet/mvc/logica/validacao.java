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


public class Usuario{
    
private String login;

        /**
         * @return the login
         */
        public String getLogin() {
            return login;
        }

        /**
         * @param login the login to set
         */
        public void setLogin(String login) {
            this.login = login;
        }
        
}
    
    
    
  // A sessão é parecida com um objeto do tipo Map<String, Object>, podemos guardar nela qualquer objeto
//que quisermos dando-lhes uma chave que é uma String. 
public String efetuaLogin(Usuario usuario, HttpServletRequest req, HttpServletResponse res, HttpSession session) throws Exception {

 
 String autenticacao = usuario.getLogin();
if (autenticacao.equals("Usuario autenticado")){
session.setAttribute("usuarioLogado", usuario);

return "/WEB-INF/jsp/menu.jsp";
}else return "/WEB-INF/jsp/autenticaUser.jsp";

}
    

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");

        Connection connection = (Connection) req.getAttribute("conexao");
// passe a conexão no construtor
        Contato contato = new Contato();
        contato.setLogin(login);
        contato.setSenha(senha);

        ContatoDao dao = new ContatoDao(connection);
        String autenticacao = dao.autentica(contato);
        
        

        if (autenticacao.equals("Usuario autenticado")) {
           
            Usuario usuario = new Usuario();
            usuario.setLogin("Usuario autenticado");
            
            validacao validado = new validacao();
            HttpSession session = req.getSession(true); 
            validado.efetuaLogin(usuario, req, res, session);
            
            return "/WEB-INF/jsp/menu.jsp";
        } 
        
        else {

            return "404.html";
        }

    }
    
    

    
    
    
    
    
    
    
    
    
    
    

}
