package com.nanoo.discord.commands;

import com.nanoo.discord.config.Command;
import com.nanoo.discord.utils.EmbedBuilderUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nanoo
 * @create 12/12/2019 - 10:05
 */
public class UserInfoCommand extends ListenerAdapter {
    
    
    @Override
    public void onGuildMessageReceived(@Nonnull GuildMessageReceivedEvent event) {
    
        String[] messageReceived = event.getMessage().getContentRaw().split(" ");
    
        if(messageReceived[0].equalsIgnoreCase(Command.COMMAND_USER_INFO)){
    
            /* Static values */
            String requestUser = event.getAuthor().getName();
            String requestUserIconUrl = event.getAuthor().getAvatarUrl();
            
            String embedTitle = "Infos utilisateur";
            String embedThumbnailUrl = "https://spyshoproundrock.com/wp-content/uploads/2019/07/Spy_Shop_Logo.png";
    
            /* Static values = messages */
            String messageErrorCommand = "Hey le vicieux !! Faut être précis quand on veux faire la fouine :wink:";
            String messageErrorName = "Euhhhhh...Connait pas !!";
            String messageExplication = "Pour utiliser cette commande tu dois taper : \" !info nomDuGarsTuVeuxToutSavoirDessus \" :zany_face:";
    
            EmbedBuilderUtils embedBuilderUtils = new EmbedBuilderUtils();
            
            if (messageReceived.length == 1){
                event.getChannel().sendMessage(messageExplication).queue();
            }else if (messageReceived.length == 2){
                /* User we ask about */
                String name = messageReceived[1];
                
                try{
                    User user = event.getGuild().getMembersByName(name,true).get(0).getUser();
                    /* generate embed content */
                    EmbedBuilder embedBuilder = embedBuilderUtils.buildAndFillFields(getUserInfos(user));
                    /* Add static values in embed object */
                    embedBuilder.setTitle(embedTitle);
                    embedBuilder.setThumbnail(embedThumbnailUrl);
                    embedBuilder.setColor(Color.YELLOW);
                    embedBuilder.setFooter("Requête effectué par " + requestUser , requestUserIconUrl);
                    
                    event.getMessage().delete().queue(); // delete message ( embed content has user signature in footer anyway )
                    event.getChannel().sendMessage(embedBuilder.build()).queue();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                    event.getChannel().sendMessage(messageErrorName).queue();
                }
                
            }else {
                event.getChannel().sendMessage(messageErrorCommand).queue();
                event.getChannel().sendMessage(messageExplication).queue();
            }
        
        }
        
    }
    
    private Map<String,String> getUserInfos (User user){
        Map<String,String> fields = new HashMap<>();
        
        /* Static values : fields name */
        String nameField = "Nom";
        String tagField = "Tag";
        String createdField = "Création";
    
        /* Values from original demand */
        String nameValue = user.getName();
        String tagValue = user.getAsTag();
        String createdValue = user.getTimeCreated().format(DateTimeFormatter.ofPattern("dd MMM yyyy"));
        
        /* Add fields names and values */
        fields.put(createdField,createdValue);
        fields.put(nameField,nameValue);
        fields.put(tagField,tagValue);
        
        return fields;
    }
    
}
