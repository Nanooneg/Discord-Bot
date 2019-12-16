package com.nanoo.discord.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

/**
 * @author nanoo
 * @create 16/12/2019 - 11:22
 */
public class CoffeeFilterToggle extends Command {
    
    public CoffeeFilterToggle() {
        this.name = "coffee-toggle";
        this.aliases = new String[]{"coffeetoggle","coffeeToggle"};
        this.help = "Activer/Désactiver le filtre à café :zany_face:";
        this.category = new Category("Intérupteur");
        this.cooldown = 5;
        this.arguments = "[statut]";
    }
    
    /* filter toggle status ( true by default ) */
    public static boolean coffeeFilterOn = true;
    
    @Override
    protected void execute(CommandEvent commandEvent) {
    
        String[] arguments = commandEvent.getArgs().split(" ");
        String newStatus = arguments[0];
        if (commandEvent.getArgs().isEmpty() || arguments.length > 1) {
            commandEvent.reply("Vous devez donner un paramètre à cette commande : ON ou OFF");
            commandEvent.reply("Exemple : $coffeetoggle on");
        } else {
            if (coffeeFilterOn && newStatus.equalsIgnoreCase("on")) {
                commandEvent.reply("No stress !! La cafétière est déjà remplie :partying_face:");
            } else if (coffeeFilterOn && newStatus.equalsIgnoreCase("off")) {
                coffeeFilterOn = false;
                commandEvent.reply("Le filtre à café est cassé !! je répète le filtre à café est cassé et c'est la faute " +
                        "de " + commandEvent.getAuthor().getName());
            } else if (!coffeeFilterOn && newStatus.equalsIgnoreCase("on")) {
                coffeeFilterOn = true;
                commandEvent.reply("Merci " + commandEvent.getAuthor().getName() + " !! Café pour tout le monde");
            } else if (!coffeeFilterOn && newStatus.equalsIgnoreCase("off")) {
                commandEvent.reply("Ca va !! on sait : PLUS de café");
            }else {
                commandEvent.reply("Vous devez donner un paramètre à cette commande : ON ou OFF");
                commandEvent.reply("Exemple : $coffeetoggle on");
            }
        }
        
    }
}
