package no.sahin.gui.Managers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import no.sahin.gui.Inject.Inject;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class FileManager {
    @Inject
    private JavaPlugin plugin;

    private final HashMap<String, FileConfiguration> configurationMap = new HashMap<>();

    public void loadAllFileConfigurations() {
        this.configurationMap.clear();
        this.configurationMap.put("config", loadFileConfiguration("config.yml"));
        this.configurationMap.put("language", loadFileConfiguration("language.yml"));
    }

    public void saveFile(FileConfiguration fileConfiguration, String path) {
        File file = new File(this.plugin.getDataFolder(), path);
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public FileConfiguration get(String name) {
        return this.configurationMap.get(name);
    }

    public FileConfiguration loadFileConfiguration(String name) {
        File file = new File(this.plugin.getDataFolder(), name);
        if (!file.exists())
            try {
                this.plugin.saveResource(name, true);
            } catch (IllegalArgumentException e) {
                return null;
            }
        return (FileConfiguration)YamlConfiguration.loadConfiguration(file);
    }
}
