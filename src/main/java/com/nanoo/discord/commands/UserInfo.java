package com.nanoo.discord.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.jagrosh.jdautilities.commons.waiter.EventWaiter;
import com.nanoo.discord.utils.EmbedBuilderUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;

import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;


/**
 * @author nanoo
 * @create 16/12/2019 - 10:35
 */
public class UserInfo extends Command {
    
    private final EventWaiter eventWaiter;
    
    public UserInfo(EventWaiter eventWaiter) {
        this.name = "user-info";
        this.aliases = new String[]{"userinfo"};
        this.help = "Informations sur un utilisateur";
        this.category = new Category("Info");
        this.cooldown = 5;
        this.arguments = "[name]";
        this.eventWaiter = eventWaiter;
    }
    
    @Override
    protected void execute(CommandEvent commandEvent) {
        
        commandEvent.reply("Ok petite fouine ! donne moi le nom d'un utilisateur sous cette forme : @user");
        eventWaiter.waitForEvent(GuildMessageReceivedEvent.class,
                e -> e.getAuthor().equals(commandEvent.getAuthor()) && e.getChannel().equals(commandEvent.getChannel()) ,
                e -> {
                    try {
                        Member name = e.getMessage().getMentionedMembers().get(0);
                        Map<String, String> fields = getUserInfos(name);
        
                        EmbedBuilderUtils builderUtils = new EmbedBuilderUtils();
        
                        String requestUser = e.getAuthor().getName();
                        String requestUserIconUrl = e.getAuthor().getAvatarUrl();
        
                        EmbedBuilder embedBuilder = builderUtils.buildAndFillFields(fields);
                        embedBuilder.setTitle("Informations sur " + name.getUser().getName());
                        embedBuilder.setThumbnail(name.getUser().getAvatarUrl());
                        embedBuilder.setColor(Color.YELLOW);
                        embedBuilder.setFooter("Requête effectuée par " + requestUser, requestUserIconUrl);
        
                        commandEvent.reply(embedBuilder.build());
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                        commandEvent.reply("Vous devez indiquer un utilisateur en le mentionnant : @username");
                    }
                } , 10 , TimeUnit.SECONDS , () -> commandEvent.reply("Tu t'es endormi ??! Relance la commande Columbo"));
        
    }
    
    private Map<String,String> getUserInfos (Member name){
        Map<String,String> fields = new HashMap<>();
        
        /* Layout element */
        String whiteBar = "> ";
        
        /* Static values : fields name */
        String nameField = "**Nom**";
        String statusField = "**Statut**";
        String roleField = "**Rôle**";
        
        /* Values from original demand */
        String nameValue = name.getUser().getName();
        String statusValue = name.getOnlineStatus().toString();
        String roleValue = getRoleListAsString(name.getRoles());
        
        /* Add fields names and values */
        fields.put(nameField,whiteBar + nameValue);
        fields.put(statusField,whiteBar + statusValue);
        fields.put(roleField,whiteBar + roleValue);

        
        return fields;
    }
    
    private String getRoleListAsString (List<Role> rolelist){
        StringBuilder roles = new StringBuilder();
    
        if (!rolelist.isEmpty()){
            for (Role role : rolelist){
                roles.append(role.getName());
            }
        }else {
            roles = new StringBuilder("Pas de rôle");
        }
    
        return roles.toString();
    }
    
}
