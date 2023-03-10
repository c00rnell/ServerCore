package no.sahin.gui.Commands;

import no.sahin.gui.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadConfigCommand implements CommandExecutor {
    private Main c;
    public ReloadConfigCommand(Main instance) {
        this.c = instance;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("core")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " §rType §e/core help&r for more information."));

        } else if (args[0].equalsIgnoreCase("reload")) {
            if (p.hasPermission("core.reload")) {
                this.c.reloadConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " &rThe &econfig.yml &rfile is now reloaded."));
            }

        } else if (args[0].equalsIgnoreCase("help")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m                                         "));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/core " + "&r - The main command for this plugin."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/core reload" + "&r - Will reload the config.yml file."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/gamemode" + "&r - Opens a GUI with GameModes."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/heal" + "&r - Reset your health."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/feed" + "&r - Reset your hunger."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/fly" + "&r - Shortcut for enabling fly mode."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/vanish" + "&r - Shortcut for enabling invisible mode."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/spawn" + "&r - Teleport to spawnpoint."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&e/setspawn" + "&r - Create new spawnpoint."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&7&m                                         "));
        }
}
        return true;
          }
    }