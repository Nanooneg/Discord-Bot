package com.nanoo.discord.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.coobird.thumbnailator.Thumbnails;
import net.dv8tion.jda.api.entities.MessageEmbed;

import javax.print.DocFlavor;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.net.URL;

/**
 * @author nanoo
 * @create 14/12/2019 - 12:20
 */
public class Image extends Command {
    
    public Image() {
        this.name = "image";
        this.arguments = "[width] [height] [imageUrl] [degrees to rotate(optional)]";
        this.aliases = new String[]{"thumbnail"};
        this.help = "Manipulation d'image : donne le lien d'une image et tu peux la redimensionner et/ou la faire tourner";
        this.category = new Category("Outil");
    }
    
    @Override
    protected void execute(CommandEvent commandEvent) {
    
        if (commandEvent.getArgs().equalsIgnoreCase("")){
            
            commandEvent.reply("Vous devez donner au moins trois paramètres à cette commande : Largeur / Hauteur / Url de la photo " +
                    "et en supplément, un degré si vous souhaitez la faire tourner.");
            commandEvent.reply("Exemple : $image 600 400 http://url.de.ma.photo 90 => tourne de 90° la photo à l'adresse donnée " +
                    "et la redimenssione à 600*400 px");
            
        }else{
            String[] arguments = commandEvent.getArgs().split(" ");
            if (arguments.length < 3 || arguments.length > 4){
                commandEvent.reply("Vous devez donner au moins trois paramètres à cette commande : Largeur / Hauteur / Url de la photo " +
                        "et en supplément, un degré si vous souhaitez la faire tourner.");
                commandEvent.reply("Exemple : $image 600 400 http://url.de.ma.photo 90 => tourne de 90° la photo à l'adresse donnée " +
                        "et la redimenssione à 600*400 px");
            }else{
                try {
                    
                    int width = Integer.parseInt(arguments[0]);
                    int height = Integer.parseInt(arguments[1]);
                    URL imageUrl = new URL(arguments[2]);
                    int degreeRotation = 0;
    
                    if (arguments.length == 4) {
                        degreeRotation = Integer.parseInt(arguments[3]);
                    }
    
                    ByteArrayOutputStream os = new ByteArrayOutputStream();
                    Thumbnails.of(imageUrl).forceSize(width,height).rotate(degreeRotation).outputFormat("png").toOutputStream(os);
                    byte[] imageInBytes = os.toByteArray();
    
                    commandEvent.reply(commandEvent.getAuthor().getAsMention() + ", voilà ton image : ");
                    commandEvent.getChannel().sendFile(imageInBytes,"resized.png").queue();
                    
                }catch (Exception e){
                    
                    System.out.println(e.getMessage());
                    commandEvent.reply("Un de vos arguement n'est pas bon !");
                    commandEvent.reply("Exemple : $image 600 400 http://url.de.ma.photo 90 => tourne de 90° la photo à l'adresse donnée " +
                            "et la redimenssione à 600*400 px");
                    
                }
            }
        }
        
    }
}
