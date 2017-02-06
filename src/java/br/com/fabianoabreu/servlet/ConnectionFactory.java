/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Renato
 */
public class ConnectionFactory {
  
    public Connection getConnection() {
     /*Quando você utiliza o método estático Class.forName(), o Class Loader tenta inicializar 
esta classe. Esta classe (que é o nosso driver jdbc) possui um bloco inicializador estático 
(não se preocupe caso você não conheça este recurso), que irá registrar essa classe 
como um driver JDBC, avisando o java.sql.DriverManager, pelo método registerDriver.*/
        
		try {
			Class.forName("com.mysql.jdbc.Driver");//Sete o driver no início da classe. Se não dá erro no Apache
		} catch (Exception e) {
			System.out.println("ERRO");
			e.printStackTrace();
		}
	
        
        
        
        try {
         
         return DriverManager.getConnection(
 "jdbc:mysql://localhost/deitel", "deitel", "deitel");
     } 
     
     catch (SQLException e) {
         throw new RuntimeException(e);
     }
 }
    
}
