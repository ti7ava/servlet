/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fabianoabreu.sendEmail;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.EmailException;


/**
 *
 * @author Ten Renato
 */
public class EnvioTest {
    
    public static void main(String[] args){
        
                
        Email envio = new Email();
        try {
            envio.sendEmail();
        } catch (EmailException ex) {
            Logger.getLogger(EnvioTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}
