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

/**
 *
 * @author Renato
 */
public class validacao implements Logica {

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

            return "/WEB-INF/jsp/cabecalho.jsp";
        } else {

            return "404.html";
        }

    }

}
