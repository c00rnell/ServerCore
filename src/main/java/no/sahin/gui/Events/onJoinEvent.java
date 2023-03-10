package no.sahin.gui.Events;

import no.sahin.gui.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinEvent implements Listener {
    private Main c;

    public onJoinEvent(Main instance) {
        this.c = instance;
    }


    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (this.c.getConfig().getBoolean("motdMessage")) {

            e.setJoinMessage("");
            for (int i = 0; i < 200; i++)
                p.sendMessage("");
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("LINE1")));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("LINE2")));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("LINE3")));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("LINE4")));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("LINE5")));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("LINE6")));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("LINE7")));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("LINE8")));
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', ""));
        }
    }
}