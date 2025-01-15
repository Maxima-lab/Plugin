package com.example.pingchecker;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class PingChecker extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("PingChecker Plugin Enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PingChecker Plugin Disabled!");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        // If the command is '/ping'
        if (command.getName().equalsIgnoreCase("ping")) {
            // If the sender is a player
            if (sender instanceof Player) {
                Player player = (Player) sender;
                int ping = player.getPing(); // Get the player's ping
                player.sendMessage("§aYour ping is: §e" + ping + "ms");
            } else { // If the sender is the console
                if (args.length == 0) {
                    sender.sendMessage("§cPlease specify a player.");
                    return false;
                }

                // Get the player from the arguments
                Player target = getServer().getPlayer(args[0]);

                // Check if the player is online
                if (target != null) {
                    int ping = target.getPing(); // Get the target player's ping
                    sender.sendMessage("§a" + target.getName() + "'s ping is: §e" + ping + "ms");
                } else {
                    sender.sendMessage("§cPlayer not found or not online.");
                }
            }
            return true;
        }
        return false;
    }
}
