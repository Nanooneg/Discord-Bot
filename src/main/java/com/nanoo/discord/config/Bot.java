package com.nanoo.discord.config;

import java.util.ResourceBundle;

/**
 * @author nanoo
 * @create 11/12/2019 - 21:11
 */
public class Bot {
    
    private static final String CONFIG_FILE_NAME = "discord-config.properties";
    private static final String TOKEN_KEY = "token";
    private static final String OWNER_ID_KEY = "ownerId";
    private static final String NAME_KEY = "name";
    
    private Bot() {}
    
    public static String tokenValue = setTokenValue();
    public static String ownerIdValue = setOwnerIdValue();
    public static String nameValue = setNameValue();
    
    private static String setTokenValue() {
        if (ResourceBundle.getBundle(CONFIG_FILE_NAME).containsKey(TOKEN_KEY)) {
            return ResourceBundle.getBundle(CONFIG_FILE_NAME).getString(TOKEN_KEY);
        }else {
            return System.getenv(TOKEN_KEY);
        }
    }
    
    private static String setOwnerIdValue() {
        if (ResourceBundle.getBundle(CONFIG_FILE_NAME).containsKey(OWNER_ID_KEY)) {
            return ResourceBundle.getBundle(CONFIG_FILE_NAME).getString(OWNER_ID_KEY);
        }else {
            return System.getenv(OWNER_ID_KEY);
        }
    }
    
    private static String setNameValue() {
        if (ResourceBundle.getBundle(CONFIG_FILE_NAME).containsKey(NAME_KEY)) {
            return ResourceBundle.getBundle(CONFIG_FILE_NAME).getString(NAME_KEY);
        }else {
            return System.getenv(NAME_KEY);
        }
    }
    
}
