package no.sahin.gui.Configs;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class Config {
    private static File file;
    private static FileConfiguration customFile;

    public static String format(String s)
    {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static void setup(final Plugin plugin){
        customFile = plugin.getConfig();
    }

    public static FileConfiguration get(){
        return customFile;
    }

    public static void save(final Plugin plugin){
        plugin.saveDefaultConfig();
    }

    public static void reload(final Plugin plugin){
        customFile = plugin.getConfig();
    }

}