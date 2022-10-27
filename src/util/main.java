/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author Hannachi
 */
public class main {
    public static void main(String[] args ){
        try {
            EmailSender.sendEmailWithAttachments("hssan.hannachi@esprit.tn", "Service creation", "Your service has been added successfully");
        } catch (MessagingException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
