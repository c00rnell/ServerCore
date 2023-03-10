package no.sahin.gui.Commands;

import no.sahin.gui.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCommand implements CommandExecutor {

    private Main c;

    public BroadcastCommand(Main instance) {
        this.c = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        Player p = (Player) sender;

        if (p.hasPermission("core.broadcast")) {
            if (!p.hasPermission("core.staff")) {
                if (args.length >= 1) {
                    String msg = "";
                    for (int i = 0; i < args.length; i++) {
                        msg = String.valueOf(msg) + args[i] + " ";
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX")) + " " + ChatColor.WHITE + msg);
                    }
                }
            } else {
                if (args.length >= 1) {
                    String msg = "";
                    for (int i = 0; i < args.length; i++) {
                        msg = String.valueOf(msg) + args[i] + " ";
                        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX")) + " " + ChatColor.WHITE + msg);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l&oNOTE: &fIt was " + "&e" + p.getDisplayName() + " &fwho sent the announcement."));
                    }
                }
            }
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + this.c.noPermissions));
        }
        return true;
    }
}