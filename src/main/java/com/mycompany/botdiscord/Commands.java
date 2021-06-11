/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.botdiscord;

import com.rometools.rome.io.FeedException;
import java.io.IOException;
import static java.lang.Thread.sleep;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 *
 * @author crist
 */
public class Commands extends ListenerAdapter {

    List<User> users = new ArrayList<>();
    JDA jda;

    public Commands(JDA jda) {
        this.jda = jda;
    }

    private boolean isUserInit(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return true;
            }
        }
        return false;
    }

    private User getUserByName(String username) {
        for (User user : users) {
            if (user.getName().equals(username)) {
                return user;
            }
        }
        return null;
    }

    /**
     *
     * @param event
     */
    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        String args = event.getMessage().getContentRaw();

        if (args.equalsIgnoreCase("Salut, botDiscord")) {
            event.getChannel().sendTyping().queue();
            event.getChannel().sendMessage("Alege o tema, " + event.getAuthor().getName() + "!").queueAfter(500, TimeUnit.MILLISECONDS);
            event.getChannel().sendMessage("1. Java\n2. C++\n3. Programare").queueAfter(1, TimeUnit.SECONDS);
            users.add(new User(event.getAuthor().getName()));
        } else if (isUserInit(event.getAuthor().getName()) && !getUserByName(event.getAuthor().getName()).hasTheme()) {
            if (args.equalsIgnoreCase("Java")) {
                event.getChannel().sendMessage("Tema Java a fost aleasa!\n Astept intrebarile. \n În caz că vrei să schimbi tema te rog să respecți șablonul: Aleg tema 'nume tema' ").queueAfter(1, TimeUnit.SECONDS);
                users.forEach(i -> {
                    System.out.println(i.getName());
                });
                getUserByName(event.getAuthor().getName()).setChooseTheme(true);
                getUserByName(event.getAuthor().getName()).setTheme(ServerRSS.limbaj.JAVA);
            } else if (args.equalsIgnoreCase("C++")) {
                event.getChannel().sendMessage("Tema C++ a fost aleasa!\n Astept intrebarile. \n În caz că vrei să schimbi tema te rog să respecți șablonul: Aleg tema 'nume tema' ").queueAfter(1, TimeUnit.SECONDS);
                getUserByName(event.getAuthor().getName()).setChooseTheme(true);
                getUserByName(event.getAuthor().getName()).setTheme(ServerRSS.limbaj.CPP);
            } else if (args.equalsIgnoreCase("Programare")) {
                event.getChannel().sendMessage("Tema programare a fost aleasa!\n Astept intrebarile. \n În caz că vrei să schimbi tema te rog să respecți șablonul: Aleg tema 'nume tema' ").queueAfter(1, TimeUnit.SECONDS);
                getUserByName(event.getAuthor().getName()).setChooseTheme(true);
                getUserByName(event.getAuthor().getName()).setTheme(ServerRSS.limbaj.PROGRAMARE);
            } else {
                event.getChannel().sendMessage("Aceasta tema nu este disponibila.").queueAfter(1, TimeUnit.SECONDS);
            }
        } else if (isUserInit(event.getAuthor().getName()) && getUserByName(event.getAuthor().getName()).hasTheme()) {
            System.out.println(args);
            switch (args) {
                case "Aleg tema C++":
                    event.getChannel().sendMessage("Tema C++ a fost aleasa!\n Astept intrebarile. \n În caz că vrei să schimbi tema te rog să respecți șablonul: Aleg tema 'nume tema' ").queueAfter(1, TimeUnit.SECONDS);
                    getUserByName(event.getAuthor().getName()).setTheme(ServerRSS.limbaj.CPP);
                    break;
                case "Aleg tema Java":
                    event.getChannel().sendMessage("Tema Java a fost aleasa!\n Astept intrebarile. \n În caz că vrei să schimbi tema te rog să respecți șablonul: Aleg tema 'nume tema' ").queueAfter(1, TimeUnit.SECONDS);
                    getUserByName(event.getAuthor().getName()).setTheme(ServerRSS.limbaj.JAVA);
                    break;
                case "Aleg tema Programare":
                    event.getChannel().sendMessage("Tema Programare a fost aleasa!\n Astept intrebarile. \n În caz că vrei să schimbi tema te rog să respecți șablonul: Aleg tema 'nume tema' ").queueAfter(1, TimeUnit.SECONDS);
                    getUserByName(event.getAuthor().getName()).setTheme(ServerRSS.limbaj.PROGRAMARE);
                    break;
                default:
                    try {
                    ServerRSS server = new ServerRSS(getUserByName(event.getAuthor().getName()).getTheme());
                    String answer = server.searchQuestion(args);
                    event.getChannel().sendMessage(answer).queueAfter(1, TimeUnit.SECONDS);
                } catch (IOException ex) {
                    Logger.getLogger(Commands.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalArgumentException ex) {
                    Logger.getLogger(Commands.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FeedException ex) {
                    Logger.getLogger(Commands.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
