package com.nanoo.discord;

import com.nanoo.discord.commands.Calculate;
import com.nanoo.discord.config.Bot;
import com.nanoo.discord.events.CategoryCreate;
import com.nanoo.discord.events.HelloEvent;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

/**
 * @author nanoo
 * @create 11/12/2019 - 19:27
 */
public class AppMain {
    
    public static void main(String[] args) throws LoginException {
    
        /* Bot creation with token given on discord dev dashboard */
        JDA jda = new JDABuilder(Bot.BOT_TOKEN).build();
        
        /* Add some Event listener to the bot */
        jda.addEventListener(new HelloEvent(),         // respond to "hello" messages
                             new CategoryCreate(),     // send message on category created event
                             new Calculate());         // make basic calculation
        
        
    }
    
}
