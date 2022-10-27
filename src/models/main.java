/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.mail.MessagingException;
import util.EmailSender;

/**
 *
 * @author asus
 */
public class main {
    public static void main (String[] args ) throws MessagingException{
        EmailSender.sendEmailWithAttachments("dhieff.14@gmail.com","Request validation" , "your request has been added");
    }
    
}
