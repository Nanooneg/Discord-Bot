package com.nanoo.discord.utils;

import net.dv8tion.jda.api.EmbedBuilder;

import java.awt.*;
import java.util.Map;

/**
 * @author nanoo
 * @create 12/12/2019 - 10:09
 */
public class EmbedBuilderUtils {
    
    public EmbedBuilder buildAndFillFields (Map<String,String> fields){
    
        EmbedBuilder embedBuilder = new EmbedBuilder();

        /* Add fields */
        for (Map.Entry<String,String> entry : fields.entrySet()){
    
            embedBuilder.addField(entry.getKey(),entry.getValue(),true);
    
        }
        
        return embedBuilder;
        
    }

}
