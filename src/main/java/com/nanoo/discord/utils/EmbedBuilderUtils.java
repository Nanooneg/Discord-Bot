package com.nanoo.discord.utils;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.Map;

/**
 * @author nanoo
 * @create 12/12/2019 - 10:09
 */
public class EmbedBuilderUtils {
    
    public EmbedBuilder build (String embedTitle, Map<String,String> fields, String thumbnail){
    
        EmbedBuilder embedBuilder = new EmbedBuilder();
        
        /* Add title */
        embedBuilder.setTitle(embedTitle);
        /* Add color */
        embedBuilder.setColor(Color.YELLOW); // TODO add some random color selection maybe
        /* Add thumbnail */
        if (thumbnail.length() > 0)
            embedBuilder.setThumbnail(thumbnail);
        /* Add fields */
        for (Map.Entry<String,String> entry : fields.entrySet()){
    
            embedBuilder.addField(entry.getKey(),entry.getValue(),true);
    
        }
        
        return embedBuilder;
        
    }

}
