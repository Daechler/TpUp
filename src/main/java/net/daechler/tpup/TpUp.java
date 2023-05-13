package net.daechler.tpup;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TpUp extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin activation message
        getLogger().info(ChatColor.GREEN + getName() + " has been activated!");
    }

    @Override
    public void onDisable() {
        // Plugin disable message
        getLogger().info(ChatColor.RED + getName() + " has been disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Check if the command sender is a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Only players can use this command!");
            return true;
        }

        Player player = (Player) sender;

        // Check if the command is "/tpup"
        if (cmd.getName().equalsIgnoreCase("tpup")) {
            // Check if the command has an argument
            if (args.length == 1) {
                try {
                    int blocks = Integer.parseInt(args[0]);

                    // Teleport the player up by the specified number of blocks
                    player.teleport(player.getLocation().add(0, blocks, 0));

                    player.sendMessage(ChatColor.GREEN + "You have been teleported up by " + blocks + " blocks!");
                } catch (NumberFormatException e) {
                    player.sendMessage(ChatColor.RED + "Invalid argument! Please provide a valid number of blocks.");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Invalid usage! Correct usage: /tpup <blocks>");
            }
            return true;
        }

        return false;
    }
}
