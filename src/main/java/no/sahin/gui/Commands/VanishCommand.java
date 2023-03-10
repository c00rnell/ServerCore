package no.sahin.gui.Commands;

import no.sahin.gui.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCommand implements CommandExecutor {

    private Main c;
    public VanishCommand(Main instance) {
        this.c = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("core.vanish")) {
            if (!p.isInvisible()) {
                p.setInvisible(true);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("VANISH_ENABLE")));
                p.closeInventory();
            } else {
                p.setInvisible(false);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("VANISH_DISABLE")));
                p.closeInventory();
            }
        } else {
            p.sendMessage((ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX")) + this.c.noPermissions));
            p.closeInventory();
        }
        return false;
    }
}
