package com.nanoo.discord.events;

import com.nanoo.discord.config.DiscordConfig;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

/**
 * @author nanoo
 * @create 11/12/2019 - 20:44
 */
public class HelloEvent extends ListenerAdapter {
    
    /**
     * This method listen to all message send on guild and respond to specific content.
     *
     * @param messageEvent message event on guild server
     */
    @Override
    public void onGuildMessageReceived (GuildMessageReceivedEvent messageEvent){
        int i;
        int j;
    
        String[] messageReceived = messageEvent.getMessage().getContentRaw().split(" ");
        String messageReceivedAuthor = messageEvent.getAuthor().getName();
        
        if (!messageReceivedAuthor.equalsIgnoreCase(DiscordConfig.BOT_NAME)){
            for ( i=0 , j=messageReceived.length ; i<j ; i++ ){
        
                if (messageReceived[i].equalsIgnoreCase("hello")){
                    messageEvent.getChannel().sendMessage("Hi there ! La forme " + messageReceivedAuthor + " ? :)").queue();
                }else if (messageReceived[i].equalsIgnoreCase("salut")){
                    messageEvent.getChannel().sendMessage("Salut à toi aussi ! Comment tu vas " + messageEvent.getAuthor().getName() + " aujourd'hui ?").queue();
                }
            }
        }
    
    }

}
