package no.sahin.gui.Commands;

import no.sahin.gui.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCommand implements CommandExecutor {

    private Main c;
    public FeedCommand(Main instance) {
        this.c = instance;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;

            if (p.hasPermission("core.feed")) {
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("FEED")));
            } else {
                p.sendMessage((ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX")) + this.c.noPermissions));
            }
        }
        return true;
    }
}
