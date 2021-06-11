/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.botdiscord;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.FeedException;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 *
 * @author Bogdan
 */
public class ServerRSS {

    SyndFeed feed;

    public static enum limbaj {
        JAVA,
        CPP,
        PROGRAMARE
    }

    public ServerRSS(limbaj limb) throws IOException, IllegalArgumentException, FeedException {
        switch (limb) {
            case JAVA:
                //File fileJava = new File("D:\\Facultate\\An2 Sem2\\PA\\Proiect_botDiscord_Java\\src\\main\\java\\com\\mycompany\\botdiscord\\IntrebariJava.xml");
                String urlJava = "http://localhost/IntrebariJava.xml";
                feed = new SyndFeedInput().build(new XmlReader(new URL(urlJava)));
                break;
            case CPP:
                //File fileCpp = new File("D:\\Facultate\\An2 Sem2\\PA\\Proiect_botDiscord_Java\\src\\main\\java\\com\\mycompany\\botdiscord\\IntrebariCpp.xml");
                String urlCpp = "http://localhost/IntrebariCpp.xml";
                feed = new SyndFeedInput().build(new XmlReader(new URL(urlCpp)));
                break;
            case PROGRAMARE:
                //File fileProgramare = new File("D:\\Facultate\\An2 Sem2\\PA\\Proiect_botDiscord_Java\\src\\main\\java\\com\\mycompany\\botdiscord\\IntrebariProgramare.xml");
                String urlProgramare = "http://localhost/IntrebariProgramare.xml";
                feed = new SyndFeedInput().build(new XmlReader(new URL(urlProgramare)));
                break;
        }
    }

    public String searchQuestion(String question) {
        for (SyndEntry entry : feed.getEntries()) {
            if (entry.getTitle().contains(question)) {
                return entry.getDescription().getValue();
            }
        }
        return "Intrebare gresita";
    }
}
