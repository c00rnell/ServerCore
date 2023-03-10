package no.sahin.gui.Commands;

import no.sahin.gui.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCommand implements CommandExecutor {

    private Main c;
    public HealCommand(Main instance) {
        this.c = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player)sender;

            if (p.hasPermission("core.heal")) {
                p.setHealth(20);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("HEAL")));
            } else {
                p.sendMessage((ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX")) + this.c.noPermissions));
            }
        }
        return true;
    }
}
