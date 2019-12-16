package com.nanoo.discord.config;

import java.util.ResourceBundle;

/**
 * @author nanoo
 * @create 11/12/2019 - 21:11
 */
public class Bot {
    
    private static final String CONFIG_FILE_NAME = "discord-config";
    
    private Bot() {}
    
    /* Get token in properties file */
    public static String getToken() { return ResourceBundle.getBundle(CONFIG_FILE_NAME).getString("token"); }
    public static String getOwnerId() { return ResourceBundle.getBundle(CONFIG_FILE_NAME).getString("ownerId"); }
    public static String getBotName() { return ResourceBundle.getBundle(CONFIG_FILE_NAME).getString("name"); }
    
    
}
