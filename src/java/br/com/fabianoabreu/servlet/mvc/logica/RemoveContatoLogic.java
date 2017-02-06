/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet.mvc.logica;

import br.com.fabianoabreu.servlet.Contato;
import br.com.fabianoabreu.servlet.ContatoDao;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ten Renato
 */
public class RemoveContatoLogic implements Logica{
    
@Override
public String executa(HttpServletRequest req, HttpServletResponse res)throws Exception {

    
    long id = Long.parseLong(req.getParameter("id"));

Contato contato = new Contato();
contato.setId(id);
ContatoDao dao = new ContatoDao();
dao.remove(contato);
System.out.println("Excluindo contato... ");
//return "lista-contatos.jsp";
return "mvc?logica=ListaContatosLogic";
}    
    
}
