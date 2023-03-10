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

import java.util.ArrayList;

public class StaffMode implements CommandExecutor {

    private Main c;
    public StaffMode(Main instance) {
        this.c = instance;
        this.isEnabled = new ArrayList<>();
    }

    private ArrayList<Player> isEnabled;

    BossBar bb = Bukkit.createBossBar(ChatColor.translateAlternateColorCodes('&', "&c&l(!)" + " &rSTAFFMODE " + "&c&l(!)"), BarColor.RED, BarStyle.SOLID);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        if (p.hasPermission("core.staff")) {
            this.isEnabled.add(p);
            p.sendMessage("staffmode enabled");
        } else {
            this.isEnabled.remove(p);
            p.sendMessage("staffmode disabled");
        }
        return true;
    }

    public boolean is(Player p) {
        return this.isEnabled.contains(p);
    }
}
