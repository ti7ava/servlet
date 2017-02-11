/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet.mvc.logica;

import br.com.fabianoabreu.servlet.Contato;
import br.com.fabianoabreu.servlet.ContatoDao;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ten Renato
 */
public class cadastroSite implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
     
 String login = req.getParameter("login");
 String senha = req.getParameter("senha");
  
Contato contato = new Contato();
contato.setLogin(login);
contato.setSenha(senha);
contato.setEndereco("Site Infocon");
contato.setNome(login);
contato.setEmail(login);

Calendar data = Calendar.getInstance();
contato.setDataNascimento(data);




Connection connection = (Connection) req.getAttribute("conexao");
// passe a conexão no construtor
ContatoDao dao = new ContatoDao(connection);
dao.adiciona(contato);



System.out.println("Adicionando contato... ");
//return "lista-contatos.jsp";

return "mvc?logica=ListaContatosLogic"; //To change body of generated methods, choose Tools | Templates.
    }
    }
    


        
    
    

