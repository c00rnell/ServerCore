package no.sahin.gui.Listener;

import no.sahin.gui.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerChatEvent;

public class ColorListener implements Listener {

    private final Main plugin;
    public ColorListener(Main plugin) { this.plugin = plugin; }
    
    @EventHandler
    public void onSignColor(SignChangeEvent event) {
        for (int i = 0; i < 4; i++)
            event.setLine(i, ChatColor.translateAlternateColorCodes('&', event.getLine(i)));
    }

    @EventHandler
    public void onChat(PlayerChatEvent event) {
        event.setMessage(color(event.getMessage()));
    }
    public String color(String msg) {
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}