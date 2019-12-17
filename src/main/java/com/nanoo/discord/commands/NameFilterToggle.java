package com.nanoo.discord.commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

/**
 * @author nanoo
 * @create 17/12/2019 - 11:50
 */
public class NameFilterToggle extends Command {
    
    public NameFilterToggle() {
        this.name = "name-toggle";
        this.aliases = new String[]{"nametoggle","nameToggle"};
        this.help = "Activer/Désactiver les réactions de Virus quand on cite son nom";
        this.category = new Category("Intérupteur");
        this.cooldown = 5;
        this.arguments = "[statut]";
    }
    
    /* filter toggle status ( true by default ) */
    public static boolean nameFilterOn = true;
    
    @Override
    protected void execute(CommandEvent commandEvent) {
        commandEvent.reply("La commande n'est pas encore implémentée !");
    }
}
