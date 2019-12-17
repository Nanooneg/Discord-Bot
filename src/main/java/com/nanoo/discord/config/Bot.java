package com.nanoo.discord.config;

import java.util.ResourceBundle;

/**
 * @author nanoo
 * @create 11/12/2019 - 21:11
 */
public class Bot {
    
    private static final String CONFIG_FILE_NAME = "discord-config";
    private static final String TOKEN_KEY = "token";
    private static final String OWNER_ID_KEY = "ownerId";
    private static final String NAME_KEY = "name";
    
    private Bot() {}
    
    public static String getTokenValue() {
        if (System.getenv(TOKEN_KEY) != null) {
            return System.getenv(TOKEN_KEY);
        } else {
            return ResourceBundle.getBundle(CONFIG_FILE_NAME).getString(TOKEN_KEY);
        }
    }
    
    public static String getOwnerIdValue() {
        if (System.getenv(OWNER_ID_KEY) != null) {
            return System.getenv(OWNER_ID_KEY);
        } else {
            return ResourceBundle.getBundle(CONFIG_FILE_NAME).getString(OWNER_ID_KEY);
        }
    }
    
    public static String getNameValue() {
        if (System.getenv(NAME_KEY) != null) {
            return System.getenv(NAME_KEY);
        } else {
            return ResourceBundle.getBundle(CONFIG_FILE_NAME).getString(NAME_KEY);
        }
    }
    
}
