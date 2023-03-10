package no.sahin.gui.Staff;

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

public class ClearChat implements CommandExecutor {

    private Main c;
    public ClearChat(Main instance) { this.c = instance; }

    BossBar bb = Bukkit.createBossBar(ChatColor.translateAlternateColorCodes('&', "&e&l(!)" + " &rCHAT IS NOW CLEARED " + "&e&l(!)"), BarColor.YELLOW, BarStyle.SOLID);
    BossBar bb1 = Bukkit.createBossBar(ChatColor.translateAlternateColorCodes('&', "&e&l(!)" + " &rCHAT IS NOW CLEARED " + "&e&l(!)"), BarColor.BLUE, BarStyle.SOLID);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("core.clearchat")) {
            if (!p.hasPermission("core.staff")) {
                for (int i = 0; i < 100; i++) {
                    Bukkit.broadcastMessage("");
                }
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " &fThe chat was cleared by staff."));
                bb.addPlayer((p));

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(c, new Runnable() {
                    @Override
                    public void run() {
                        bb.removeAll();
                    }
                }, 20 * 1);
            } else {
                p.sendMessage("");
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " &fThe chat was cleared by staff."));
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&l&oNOTE: &fAs a staffmember, you can still read old chat."));
                bb1.addPlayer((p));

                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(c, new Runnable() {
                    @Override
                    public void run() {
                        bb1.removeAll();
                    }
                }, 20 * 1);
            }
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + this.c.noPermissions));
        }
        return true;
    }
}