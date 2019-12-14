package com.nanoo.discord.filters;

import com.nanoo.discord.config.Command;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

/**
 * @author nanoo
 * @create 12/12/2019 - 16:18
 */
public class CoffeeFilterToggle extends ListenerAdapter {
    
    /* filter toggle status ( true by default ) */
    static boolean coffeeFilterOn = true;
    
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
    
        String[] messageReceived = event.getMessage().getContentRaw().split(" ");

        if ( messageReceived[0].equalsIgnoreCase(Command.COMMAND_TOGGLE_COFFEE_FILTER) ){
            
            if (coffeeFilterOn){
                coffeeFilterOn = false;
                event.getChannel().sendMessage("Le filtre à café est cassé !! je répète le filtre à café est cassé et c'est la faute " +
                        "de " + event.getAuthor().getName()).queue();
            }else {
                coffeeFilterOn = true;
                event.getChannel().sendMessage("Merci " + event.getAuthor().getName() + " !! Café pour tout le monde").queue();
            }
            
        }
    
    }
}
