package com.nanoo.discord.filters;

import com.nanoo.discord.commands.NameFilterToggle;
import com.nanoo.discord.config.Bot;
import com.nanoo.discord.config.Emoji;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

/**
 * @author nanoo
 * @create 17/12/2019 - 11:48
 */
public class NameFilter extends ListenerAdapter {
    
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
        
        if (!event.getAuthor().getName().equalsIgnoreCase(Bot.getNameValue())){
            
            String[] messageReceived = event.getMessage().getContentRaw().split(" ");
            
            if (NameFilterToggle.nameFilterOn){
                for (String messageWord : messageReceived) {
                    if (messageWord.equalsIgnoreCase(Bot.getNameValue())) {
                        
                        event.getMessage().addReaction(Emoji.LUCKBOT_EMOJI).queue();
                        
                    }
                }
            }
            
        }
        
    }
    
}
