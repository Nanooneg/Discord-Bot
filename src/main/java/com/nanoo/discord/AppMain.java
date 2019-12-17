package com.nanoo.discord;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.nanoo.discord.commands.CoffeeFilterToggle;
import com.nanoo.discord.commands.Image;
import com.nanoo.discord.commands.ServerInfo;
import com.nanoo.discord.commands.UserInfo;
import com.nanoo.discord.config.Bot;
import com.nanoo.discord.events.CategoryCreate;
import com.nanoo.discord.events.HelloEvent;
import com.nanoo.discord.filters.CoffeeFilter;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

/**
 * @author nanoo
 * @create 11/12/2019 - 19:27
 */
public class AppMain {
    
    public static void main(String[] args) throws LoginException {
        
        JDA jda = new JDABuilder(Bot.getTokenValue()).build();
    
        EventWaiter eventWaiter = new EventWaiter();
        
        CommandClientBuilder builder = new CommandClientBuilder();
        builder.setOwnerId(Bot.getOwnerIdValue());
        builder.setPrefix("$");
        builder.setHelpWord("helpme");
        builder.setActivity(Activity.watching("Pandémie : **VirusPorn**"));
        builder.addCommands(new ServerInfo(),                   // give info on server
                            new Image(),                        // modify image
                            new UserInfo(eventWaiter),          // give info on user
                            new CoffeeFilterToggle());          // toggle coffee filter
        
        CommandClient commandClient = builder.build();
        
        jda.addEventListener(commandClient,
                            new HelloEvent(),         // respond to "hello" messages
                            new CategoryCreate(),     // send message on category created event
                            new CoffeeFilter(),       // filter for coffee word
                            eventWaiter               // event waiter
                            );
        
       
        /* TODO make commands
        CalculateCommand(),   // make basic calculation
        InviteCommand(),      // create invitation to server */
        
    }
    
}
