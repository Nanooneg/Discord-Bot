package com.nanoo.discord.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nanoo.discord.utils.EmbedBuilderUtils;
import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author nanoo
 * @create 12/12/2019 - 18:22
 */
public class ServerInfo extends Command {
    
    public ServerInfo() {
        this.name = "serverinfo";
        this.aliases = new String[]{"server"};
        this.help = "Informations sur le server";
        this.category = new Category("Info");
    }
    
    @Override
    protected void execute(CommandEvent commandEvent) {
    
        EmbedBuilderUtils builderUtils = new EmbedBuilderUtils();
    
        /* Static values */
        String requestUser = commandEvent.getAuthor().getName();
        String requestUserIconUrl = commandEvent.getAuthor().getAvatarUrl();
    
        String embedTitle = "Informations sur le server";
        String embedThumbnailUrl = "https://banner2.cleanpng.com/20180319/ebq/kisspng-configuration-management-computer-icons-symbol-bus-gear-download-icon-5ab05383f3a0e4.5304297115215051559979.jpg";
        
        Map<String,String> fields = getServerInfos(commandEvent);
        
        EmbedBuilder embedBuilder = builderUtils.buildAndFillFields(fields);
        embedBuilder.setTitle(embedTitle);
        embedBuilder.setDescription("** Lien invitation : **\n" +
                Objects.requireNonNull(commandEvent.getGuild().getDefaultChannel()).createInvite().complete().getUrl());
        embedBuilder.setThumbnail(embedThumbnailUrl);
        embedBuilder.setColor(Color.RED);
        embedBuilder.setFooter("Requête effectuée par " + requestUser , requestUserIconUrl);
        
        commandEvent.getChannel().sendMessage(embedBuilder.build()).queue();
    }
    
    private Map<String,String> getServerInfos (CommandEvent commandEvent){
        Map<String,String> fields = new HashMap<>();
        
        /* Layout element */
        String whiteBar = "> ";
        
        /* Static values : fields name */
        String nameField = "**Nom**";
        String ownerNameField = "**Propriétaire**";
        String memberNumberField = "**Membres**";
        
        /* Values from original demand */
        String nameValue = commandEvent.getGuild().getName();
        String ownerNameValue = Objects.requireNonNull(commandEvent.getGuild().getOwner()).getEffectiveName();
        String memberNumberValue = String.valueOf(commandEvent.getGuild().getMembers().size());
        
        /* Add fields names and values */
        fields.put(nameField,whiteBar + nameValue);
        fields.put(ownerNameField,whiteBar + ownerNameValue);
        fields.put(memberNumberField,whiteBar + memberNumberValue);
        
        return fields;
    }
    
}
