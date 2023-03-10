package no.sahin.gui.Commands;

import no.sahin.gui.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;

public class SpawnCommand implements CommandExecutor {

    private Main c;

    public SpawnCommand(Main instance) {
        this.c = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("");
            return true;
        }
        Player p = (Player) sender;
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("Core").getDataFolder(), "spawn.yml");
        YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
        if (p.hasPermission("core.spawn")) {
            if (file.exists()) {
                Location loc = p.getLocation();
                double yaw = cfg.getDouble("Spawn.YAW");
                double pitch = cfg.getDouble("Spawn.PITCH");
                loc.setX(cfg.getDouble("Spawn.X"));
                loc.setY(cfg.getDouble("Spawn.Y"));
                loc.setZ(cfg.getDouble("Spawn.Z"));
                loc.setYaw((float) yaw);
                loc.setPitch((float) pitch);
                World world = Bukkit.getWorld(cfg.getString("Spawn.WORLD"));
                loc.setWorld(world);
                p.teleport(loc);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("SPAWN")));
            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("NONESPAWN")));
            }
        } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + this.c.noPermissions));
        }
        return false;
    }
}