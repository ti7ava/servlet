/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.sendEmail;

import java.net.Authenticator;
import java.net.PasswordAuthentication;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Ten Renato
 */
public class Email {
  
    public void sendEmail() throws EmailException {
    
        //alterar para o ip e a porta do seu proxy
//System.setProperty("http.proxyHost", "10.100.122.181");
//System.setProperty("http.proxyPort", "8080");
////a danada da autenticaÃ§Ã£o que sÃ³ funcionou desta forma...
////no seuUsuario e suaSenha vocÃª coloca seu login e sua senha do proxy...
//Authenticator.setDefault(new Authenticator() {
//@Override
//protected PasswordAuthentication getPasswordAuthentication() {
//return new PasswordAuthentication("1227149", "19751976".toCharArray());
//}
//});
        
        
   SimpleEmail email = new SimpleEmail();
   //Utilize o hostname do seu provedor de email
   System.out.println("alterando hostname...");
   email.setHostName("smtp.gmail.com");
   //Quando a porta utilizada nÃ£o Ã© a padrÃ£o (gmail = 465)
   email.setSmtpPort(465);
   //Adicione os destinatÃ¡rios
   email.addTo("solusoftic@gmail.com", "Renato");
   //Configure o seu email do qual enviarÃ¡
   email.setFrom("solusoftic@gmail.com", "Renato");
   //Adicione um assunto
   email.setSubject("Test message");
   //Adicione a mensagem do email
   email.setMsg("This is a simple test of commons-email");
   //Para autenticar no servidor Ã© necessÃ¡rio chamar os dois mÃ©todos abaixo
   System.out.println("autenticando...");
   email.setSSL(true);
   email.setAuthentication("solusoftic", "Bia19752002");
   System.out.println("enviando...");
   email.send();
   System.out.println("Email enviado!");
}
    
}
