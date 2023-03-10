package no.sahin.gui.Listener;

import jdk.internal.misc.Unsafe;
import no.sahin.gui.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinLeaveListener implements Listener {

    private Main c;

    public JoinLeaveListener(Main instance) {
        this.c = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (this.c.getConfig().getBoolean("joinMessage")) {

            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("JOIN_MESSAGE").replace("<player>", p.getDisplayName())));
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (this.c.getConfig().getBoolean("leaveMessage")) {


            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("LEAVE_MESSAGE").replace("<player>", p.getDisplayName())));
        }
    }
}