package com.nanoo.discord.events;

import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.channel.category.CategoryCreateEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

/**
 * @author nanoo
 * @create 11/12/2019 - 22:06
 */
public class CategoryCreate extends ListenerAdapter {
    
    /**
     * This method listen on category creation event and display a message in default channel is the
     * guild has one.
     *
     * @param event category creation event on guild server
     */
    @Override
    public void onCategoryCreate(@Nonnull CategoryCreateEvent event) {
        TextChannel defaultChannel = event.getGuild().getDefaultChannel();
       
        assert (defaultChannel != null);
        defaultChannel.sendMessage("Hey quelqu'un a crée une nouvelle catégorie !!! " +
                "ça sent le ménage dans les salons ou un nouvelle arrivage d'endroit super " +
                "pour parler de tout et de rien :sweatsmile:").queue();
    }
    
}
