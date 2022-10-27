/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entities.users;
import services.usersCRUD;

/**
 *
 * @author Ayoub
 */
public class session {
     private static final usersCRUD fs = new usersCRUD();

    private static session instance = null;
    private static users user = null;

    private session(users userConnected) {
        super();
        session.user = userConnected;

    }

    private session(users userConnected, Boolean b) {
        super();
        session.user = userConnected;
    }

    public final static session getInstance(users userConnected) {

        if (session.instance == null) {
            session.instance = new session(userConnected);
        }
        return session.instance;
    }

    public final static session getFirstInstance(users userConnected) {

        if (session.instance == null) {

            session.instance = new session(userConnected, false);

        }
        return session.instance;
    }

    public static usersCRUD getFs() {
        return fs;
    }

    public static session getInstance() {
        return instance;
    }

    public static users getUser() {
        return user;
    }

    public static void setUser(users user) {
        session.user = user;
    }
    
}
