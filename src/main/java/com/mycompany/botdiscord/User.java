/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.botdiscord;

/**
 *
 * @author Bogdan
 */
public class User {
    private String name;
    private boolean chooseTheme = false;
    private ServerRSS.limbaj theme;
    
    User(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setChooseTheme(boolean chooseTheme) {
        this.chooseTheme = chooseTheme;
    }

    public void setTheme(ServerRSS.limbaj theme) {
        this.theme = theme;
    }

    public String getName() {
        return name;
    }
    
    public boolean isInit() {
        return name.isEmpty() ? false : true;
    }

    public boolean hasTheme() {
        return chooseTheme;
    }

    public ServerRSS.limbaj getTheme() {
        return theme;
    }   
    
}
