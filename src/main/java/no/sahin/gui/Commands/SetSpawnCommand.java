package no.sahin.gui.Commands;

import java.io.File;
import java.io.IOException;
import no.sahin.gui.Configs.Config;
import no.sahin.gui.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {

    private Main c;
    public SetSpawnCommand(Main instance) {
        this.c = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("");
            return true;
        }
        Player p = (Player)sender;
        File file = new File(Bukkit.getServer().getPluginManager().getPlugin("Core").getDataFolder(), "spawn.yml");
        if(p.hasPermission("core.setspawn")) {
            if(args.length == 0) {
                try {
                    file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Location loc = p.getLocation();
                double x = loc.getX();
                double y = loc.getY();
                double z = loc.getZ();
                float yaw = loc.getYaw();
                float pitch = loc.getPitch();
                String world = loc.getWorld().getName();
                YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
                cfg.set("Spawn.X", Double.valueOf(x));
                cfg.set("Spawn.Y", Double.valueOf(y));
                cfg.set("Spawn.Z", Double.valueOf(z));
                cfg.set("Spawn.YAW", Float.valueOf(yaw));
                cfg.set("Spawn.PITCH", Float.valueOf(pitch));
                cfg.set("Spawn.WORLD", world);
                try {
                    cfg.save(file);
                } catch (IOException e) {
                    e.printStackTrace();
                } p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("SETSPAWN")));
            } else {
                p.sendMessage("");
            }
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + this.c.noPermissions));
        }
        return false;
    }
}