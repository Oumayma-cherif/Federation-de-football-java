/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import entities.User;

/**
 *
 * @author amine
 */
public class session {
    private static User user = null;
    
    public session(User u) {
        this.user = u;
    }
    
    public static User getSession() {
        return user;
    }
}
