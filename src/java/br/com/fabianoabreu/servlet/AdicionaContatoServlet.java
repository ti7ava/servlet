/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Renato
 */
public class AdicionaContatoServlet extends HttpServlet {

    
   @Override
   protected void service(HttpServletRequest request,
                                HttpServletResponse response)
                                throws IOException, ServletException {
                // busca o writer
                PrintWriter out = response.getWriter();
                           //teste     
                // buscando os parâmetros no request
                String nome = request.getParameter("nome");
                String endereco = request.getParameter("endereco");
                String email = request.getParameter("email");
                String dataEmTexto = request
                        .getParameter("dataNascimento");
                Calendar dataNascimento = null;
                
                // fazendo a conversão da data
                try {
                    Date date = 
                            new SimpleDateFormat("dd/MM/yyyy")
                            .parse(dataEmTexto);
                    dataNascimento = Calendar.getInstance();
                    dataNascimento.setTime(date);
                } catch (ParseException e) {
                    out.println("Erro de conversão da data");
                    return; //para a execução do método
                }
                
                // monta um objeto contato
                Contato contato = new Contato();
                contato.setNome(nome);
                contato.setEndereco(endereco);
                contato.setEmail(email);
                contato.setDataNascimento(dataNascimento);
                
                // salva o contato
                Connection connection = (Connection) request.getAttribute("conexao");
// passe a conexão no construtor
ContatoDao dao = new ContatoDao(connection);
                dao.adiciona(contato);
                
                // imprime o nome do contato que foi adicionado
//                out.println("<html>");
//                out.println("<body>");
//                out.println("Contato " + contato.getNome() +
//                        " adicionado com sucesso");
//                out.println("</body>");
//                out.println("</html>");

                RequestDispatcher rd = request.getRequestDispatcher("/contato-adicionado.jsp");
                rd.forward(request,response);

            }

}
