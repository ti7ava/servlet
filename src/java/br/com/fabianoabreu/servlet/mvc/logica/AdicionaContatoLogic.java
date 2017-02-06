/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet.mvc.logica;

import br.com.fabianoabreu.servlet.Contato;
import br.com.fabianoabreu.servlet.ContatoDao;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renato
 */
public class AdicionaContatoLogic implements Logica{

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
        
        
 
 String nome = req.getParameter("nome");
 String endereco = req.getParameter("endereco");
 String email = req.getParameter("email");
 String dataemTexto = req.getParameter("dataNascimento");
 Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataemTexto);
Calendar dataNascimento = Calendar.getInstance();
dataNascimento.setTime(date);
 
Contato contato = new Contato();
contato.setNome(nome);
contato.setEmail(email);
contato.setEndereco(endereco);
contato.setDataNascimento(dataNascimento);

ContatoDao dao = new ContatoDao();
dao.adiciona(contato);

System.out.println("Adicionando contato... ");
//return "lista-contatos.jsp";
return "mvc?logica=ListaContatosLogic"; //To change body of generated methods, choose Tools | Templates.
    }
    }
    

