/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.botdiscord;

import com.rometools.rome.io.FeedException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

/**
 *
 * @author Bogdan
 */
public class Main {

    public static void main(String[] args){
        JDA jda = null;
        try {
            jda = JDABuilder.createDefault("ODMyOTA0MTEyMjQwMDY2NTkw.YHqkZg.HhgzPEHjiSu6lKSSEJRIv-MGji0").build(); //conectarea la bot prin cheia privata
        } catch (LoginException ex) {
            System.out.println("Eroare la logare!");
        }
        jda.getPresence().setActivity(Activity.watching("himself get coded"));
        jda.addEventListener(new Commands(jda));
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
    }
}
