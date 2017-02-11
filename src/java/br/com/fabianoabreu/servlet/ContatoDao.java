/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet;

import br.com.fabianoabreu.servlet.ConnectionFactory;
import br.com.fabianoabreu.servlet.Contato;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

/**
 *
 * @author Renato
 */
public class ContatoDao {
   
    // a conexão com o banco de dados
   private Connection connection;
 
   public ContatoDao(Connection connection) {
this.connection = connection;
}
  
   public void adiciona(Contato contato) {
     String sql = "insert into contatos " +
             "(nome,email,endereco,dataNascimento,login,senha)" +
             " values (?,?,?,?,?,?)";
 
     try {
         // prepared statement para inserção
         PreparedStatement stmt = connection.prepareStatement(sql);
 
         // seta os valores
         stmt.setString(1,contato.getNome());
         stmt.setString(2,contato.getEmail());
         stmt.setString(3,contato.getEndereco());
         stmt.setDate(4, new Date(
                 contato.getDataNascimento().getTimeInMillis()));
         stmt.setString(5, contato.getLogin());
         stmt.setString(6, contato.getSenha());
 
         // executa
         stmt.execute();
         stmt.close();
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
  
   public List<Contato> getLista() {
     try {
         List<Contato> contatos = new ArrayList<Contato>();
         PreparedStatement stmt = this.connection.
                 prepareStatement("select * from contatos");
         ResultSet rs = stmt.executeQuery();
 
         while (rs.next()) {
             // criando o objeto Contato
             Contato contato = new Contato();
             contato.setId(rs.getLong("id"));
             contato.setNome(rs.getString("nome"));
             contato.setEmail(rs.getString("email"));
             contato.setEndereco(rs.getString("endereco"));
 
             // montando a data através do Calendar
             Calendar data = Calendar.getInstance();
             data.setTime(rs.getDate("dataNascimento"));
             contato.setDataNascimento(data);
 
             // adicionando o objeto à lista
             contatos.add(contato);
         }
         rs.close();
         stmt.close();
         return contatos;
         
     } 
     
     catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
   
   public List<Contato> getContato(String c){
       
       List<Contato> contatos = new ArrayList<Contato>();
       String sql = "SELECT * FROM contatos WHERE nome LIKE '"+c+"'";
     try {
         PreparedStatement stmt = this.connection
                 .prepareStatement(sql);
         
         System.out.println("String é: " + sql);
         ResultSet rs = stmt.executeQuery();
     
     while (rs.next()) {
             // criando o objeto Contato
             Contato contato = new Contato();
             contato.setId(rs.getLong("id"));
             contato.setNome(rs.getString("nome"));
             contato.setEmail(rs.getString("email"));
             contato.setEndereco(rs.getString("endereco"));
 
             // montando a data através do Calendar
             Calendar data = Calendar.getInstance();
             data.setTime(rs.getDate("dataNascimento"));
             contato.setDataNascimento(data);
             
             contatos.add(contato);
             // adicionando o objeto à lista
             
         }
     
     rs.close();
     stmt.close();
     }
      catch (SQLException e) {
         throw new RuntimeException(e);
       
   }
     
         
         return contatos;
   }
   
   
   
   
 public void altera(Contato contato) {
     String sql = "update contatos set nome=?, email=?,"+
             "endereco=?, dataNascimento=? where id=?";
 
     try {
         PreparedStatement stmt = connection
                 .prepareStatement(sql);
         stmt.setString(1, contato.getNome());
         stmt.setString(2, contato.getEmail());
         stmt.setString(3, contato.getEndereco());
         
         stmt.setDate(4, new Date(contato.getDataNascimento()
                 .getTimeInMillis()));
         stmt.setLong(5, contato.getId());
         
         stmt.execute();
         
         stmt.close();
     } catch (SQLException e) {
         
         System.out.println("AAAAAAAAAAAAAAAABBBBBBBBBBBBBBB");
         throw new RuntimeException(e);
         
     }
 }
   
   
   
 public void remove(Contato contato) {
     try {
         PreparedStatement stmt = connection
                 .prepareStatement("delete from contatos where id=?");
         stmt.setLong(1, contato.getId());
         stmt.execute();
         stmt.close();
     } catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
   
  
   public Contato getContatoId(String identifier){
       
       
       
       Contato contato = new Contato();
       
       
       //long id = Long.parseLong(identifier);
       //System.out.println("ID: "+id);
       String sql = "SELECT * FROM contatos WHERE id LIKE '"+identifier+"'";
       
       System.out.println(sql);
       
     try {
         PreparedStatement stmt = this.connection
                 .prepareStatement(sql);
         
         
         ResultSet rs = stmt.executeQuery();
         
         while (rs.next()) {
     
     System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAA");
             // criando o objeto Contato
             
             
             System.out.println(rs.getString("nome"));
             
             contato.setId(rs.getLong("id"));
             contato.setNome(rs.getString("nome"));
             
             
             
             
             contato.setEmail(rs.getString("email"));
             contato.setEndereco(rs.getString("endereco"));
 
             // montando a data através do Calendar
             Calendar data = Calendar.getInstance();
             data.setTime(rs.getDate("dataNascimento"));
             contato.setDataNascimento(data);
             
             
         }
             
             // adicionando o objeto à lista
             
      
     
     rs.close();
     stmt.close();
     }
      catch (SQLException e) {
         throw new RuntimeException(e);
       
   }
     
         
         return contato;
   } 

    public String autentica(Contato contato) {
        
        String autenticacao = "Usuario não autenticado";
        
        String sql = "SELECT login, senha FROM contatos WHERE login=? AND senha = ?";
        
        //String sql = "SELECT * FROM contatos";
              //  + " WHERE login = ? AND senha = ?";
        
        
       try {
         PreparedStatement stmt = connection
                 .prepareStatement(sql);
         stmt.setString(1, contato.getLogin());
         stmt.setString(2, contato.getSenha());
         ResultSet rs = stmt.executeQuery();
         
         while (rs.next()) {
             
             autenticacao = "Usuario autenticado";
         }
         rs.close();
         stmt.close();
         return autenticacao;
         
     } catch (SQLException e) {
         throw new RuntimeException(e);
     } 
        
    }
 
   
   
     
   
}//fim da classe ContatoDao.java
