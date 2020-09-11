package com.nanoo.discord.commands;

import com.nanoo.discord.config.Command;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

/**
 * @author nanoo
 * @create 12/12/2019 - 09:27
 */
public class InviteCommand extends ListenerAdapter {
    
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
    
        String[] messageReceived = event.getMessage().getContentRaw().split(" ");

        if(messageReceived[0].equalsIgnoreCase(Command.COMMAND_INVITE)){
    
            String messageError = "Je n'ai rien compris :zany_face:";
            String messageExplication = "Cette commande génère une invitation. Pour l'utiliser, " +
                                        "tape : \" !invite create \" ;)";
        
            if (messageReceived.length == 1){
                event.getChannel().sendMessage(messageExplication).queue();
            }else if (messageReceived.length == 2 && messageReceived[1].equalsIgnoreCase("create")){
                event.getChannel().sendMessage("Voilà le lien d'invitation : " +
                        event.getChannel().createInvite().complete().getUrl()).queue();
            }else {
                event.getChannel().sendMessage(messageError).queue();
                event.getChannel().sendMessage(messageExplication).queue();
            }
        
        }
    
    
    }
}
