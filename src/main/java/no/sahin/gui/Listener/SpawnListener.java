package no.sahin.gui.Listener;

import no.sahin.gui.Commands.SpawnCommand;
import no.sahin.gui.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SpawnListener implements Listener {

    private final Main plugin;
    public SpawnListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        if(!e.getPlayer().hasPlayedBefore()){
            Location location = plugin.getConfig().getLocation("spawn");
            if(location != null){
                e.getPlayer().teleport(location);
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        e.getEntity().spigot().respawn();
        p.performCommand("spawn");
    }
}