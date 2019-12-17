package com.nanoo.discord.events;

import com.nanoo.discord.config.Bot;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

/**
 * @author nanoo
 * @create 11/12/2019 - 20:44
 */
public class HelloEvent extends ListenerAdapter {
    
    /**
     * This method listen to all message send on guild and respond to specific content.
     *
     * @param event message event on guild server
     */
    @Override
    public void onGuildMessageReceived (@Nonnull GuildMessageReceivedEvent event){
        
        String[] messageReceived = event.getMessage().getContentRaw().split(" ");
        String messageReceivedAuthor = event.getAuthor().getName();
        
        if (!messageReceivedAuthor.equalsIgnoreCase(Bot.nameValue)){
            for (String s : messageReceived) {
                if (s.equalsIgnoreCase("hello")) {
                    event.getChannel().sendMessage("Hi there ! La forme " + messageReceivedAuthor + " ? :)").queue();
                } else if (s.equalsIgnoreCase("salut")) {
                    event.getChannel().sendMessage("Salut à toi aussi ! Comment tu vas " + event.getAuthor().getName() + " aujourd'hui ?").queue();
                }
            }
        }
    
    }

}
