package com.nanoo.discord.commands;

import com.nanoo.discord.config.Command;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

/**
 * @author nanoo
 * @create 11/12/2019 - 22:58
 */
public class CalculateCommand extends ListenerAdapter {
    
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
    
        String[] messageReceived = event.getMessage().getContentRaw().split(" ");
        
        if (messageReceived[0].equalsIgnoreCase(Command.COMMAND_CALCULATE)){
    
            String messageError = "mauvais format de calcul mon pote !";
            String messageExplication = "Pour utiliser la calculatrice, tape !calculate puis ton opération " +
                                        "en séparant les chiffres et le signe par un espace comme ça : \" !calculate 5 + 3 \" ";
            
            if (messageReceived.length == 1){
                event.getChannel().sendMessage(messageExplication).queue();
            }else if (messageReceived.length == 4){
                double a = Double.parseDouble(messageReceived[1]);
                double b = Double.parseDouble(messageReceived[3]);
                String operator = messageReceived[2];
                
                event.getChannel().sendMessage("Le résultat est : " + doCalcul(a,b,operator)).queue();
            }else {
                event.getChannel().sendMessage(messageError).queue();
                event.getChannel().sendMessage(messageExplication).queue();
            }
        
        }
        
    }
    
    private Double doCalcul(double a, double b, String operator){
        
        if ("+".equals(operator)) {
            try {
                return a + b;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if ("-".equals(operator)) {
            try {
                return a - b;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if ("/".equals(operator)) {
            try {
                return a / b;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if ("*".equals(operator)) {
            try {
                return a * b;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        
        return null;
    }
    
}
