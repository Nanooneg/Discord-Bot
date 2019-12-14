package com.nanoo.discord.config;

import java.util.ResourceBundle;

/**
 * @author nanoo
 * @create 11/12/2019 - 21:11
 */
public class Bot {
    
    private Bot() {}
    
    /* Get token in properties file */
    public static String getToken() {
        return ResourceBundle.getBundle("discord-config").getString("token");
    }
    public static String getOwnerId() { return ResourceBundle.getBundle("discord-config").getString("ownerId"); }
    
    public static final String BOT_NAME = "Virus";
    
    
    
    
}
