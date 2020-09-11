package com.nanoo.discord.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import com.nanoo.discord.config.Bot;

/**
 * @author nanoo
 * @create 17/12/2019 - 11:50
 */
public class NameFilterToggle extends Command {
    
    public NameFilterToggle() {
        this.name = "name-toggle";
        this.aliases = new String[]{"nametoggle","nameToggle"};
        this.help = "Activer/Désactiver les réactions de " + Bot.getNameValue() + " quand on cite son nom";
        this.category = new Category("Intérupteur");
        this.cooldown = 5;
        this.arguments = "[statut]";
    }
    
    /* filter toggle status ( true by default ) */
    public static boolean nameFilterOn = true;

    @Override
    protected void execute(CommandEvent commandEvent) {

        String[] arguments = commandEvent.getArgs().split(" ");
        String newStatus = arguments[0];
        if (commandEvent.getArgs().isEmpty() || arguments.length > 1) {
            commandEvent.reply("Vous devez donner un paramètre à cette commande : ON ou OFF");
            commandEvent.reply("Exemple : $nametoggle on");
        } else {
            if (nameFilterOn && newStatus.equalsIgnoreCase("on")) {
                commandEvent.reply("Déjà sur le pont ! tu pisses dans un violon bro :partying_face:");
            } else if (nameFilterOn && newStatus.equalsIgnoreCase("off")) {
                nameFilterOn = false;
                commandEvent.reply("Ok " + commandEvent.getAuthor().getName() + " je ferme mon gueule ...");
            } else if (!nameFilterOn && newStatus.equalsIgnoreCase("on")) {
                nameFilterOn = true;
                commandEvent.reply("Merci " + commandEvent.getAuthor().getName() + " !!");
            } else if (!nameFilterOn && newStatus.equalsIgnoreCase("off")) {
                commandEvent.reply("Ca va !! Je sais : JE FERME MON GUEULE");
            }else {
                commandEvent.reply("Vous devez donner un paramètre à cette commande : ON ou OFF");
                commandEvent.reply("Exemple : $nametoggle on");
            }
        }

    }
}
