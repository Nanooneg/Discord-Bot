package com.nanoo.discord.filters;

import com.nanoo.discord.commands.CoffeeFilterToggle;
import com.nanoo.discord.config.Bot;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

/**
 * @author nanoo
 * @create 12/12/2019 - 16:27
 */
public class CoffeeFilter extends ListenerAdapter {
    
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
    
        if (!event.getAuthor().getName().equalsIgnoreCase(Bot.getBotName())){
    
            String[] listCoffeeWord = {"café","cafe","caféine","cafeine"};
            String[] messageReceived = event.getMessage().getContentRaw().split(" ");
    
            if (CoffeeFilterToggle.coffeeFilterOn){
                for (String messageWord : messageReceived) {
                    for (String coffeeWord : listCoffeeWord) {
                        if (messageWord.equalsIgnoreCase(coffeeWord)) {
                    
                            event.getChannel().sendMessage("CAFE ??? Oui un pour moi aussi merci " + event.getAuthor().getName() +
                                    " !! :zany_face: ").queue();
                    
                        }
                    }
                }
            }
            
        }
        
    }
}
