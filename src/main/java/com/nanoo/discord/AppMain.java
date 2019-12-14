package com.nanoo.discord;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.nanoo.discord.commands.*;
import com.nanoo.discord.config.Bot;
import com.nanoo.discord.events.CategoryCreate;
import com.nanoo.discord.events.HelloEvent;
import com.nanoo.discord.filters.CoffeeFilter;
import com.nanoo.discord.filters.CoffeeFilterToggle;
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
        JDA jda = new JDABuilder(Bot.getToken()).build();
    
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId(Bot.getOwnerId());
        builder.setPrefix("$");
        builder.setHelpWord("helpme");
        builder.addCommands(new ServerInfo(),    // give info on server
                            new Image());        // modify image
    
        CommandClient commandClient = builder.build();
        
        jda.addEventListener(commandClient);
        
       /*
        *//* Add some Event listener to the bot *//*
        jda.addEventListener(new HelloEvent(),         // respond to "hello" messages
                             new CategoryCreate(),     // send message on category created event
                             new CalculateCommand(),   // make basic calculation
                             new InviteCommand(),      // create invitation to server
                             new UserInfoCommand(),    // gives info on some user
                             new CoffeeFilterToggle(), // toggle coffe filter
                             new CoffeeFilter());      // filter for coffee word
        */
        
    }
    
}
