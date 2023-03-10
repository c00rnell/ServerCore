package no.sahin.gui;

import no.sahin.gui.Commands.*;
import no.sahin.gui.Events.onJoinEvent;
import no.sahin.gui.Listener.JoinLeaveListener;
import no.sahin.gui.Listener.ColorListener;
import no.sahin.gui.Listener.SpawnListener;
import no.sahin.gui.Staff.ChatMode;
import no.sahin.gui.Staff.ClearChat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    FileConfiguration config = getConfig();
    public void onLoad() {
        saveDefaultConfig();
    }

    String PREFIX, LINE1, LINE2, LINE3, LINE4, LINE5, LINE6, LINE7, LINE8, HEAL, FEED, FLY_ENABLE, FLY_DISABLE, COLORCODE, SETSPAWN, SPAWN, NONESPAWN, VANISH_DISABLE, VANISH_ENABLE, SURVIVAL, SPECTATOR, CREATIVE, ADVENTURE, JOIN_MESSAGE, FIRSTJOIN_MESSAGE, LEAVE_MESSAGE;
    public String noPermissions = ChatColor.translateAlternateColorCodes('&', this.getConfig().getString("COLORCODE") + " You don't have permission to execute this.");

    @Override
    public void onEnable() {

        getLogger().info("#############################################");
        getLogger().info("#                                           #");
        getLogger().info("#           Core v0.0.4 Enabled             #");
        getLogger().info("#                                           #");
        getLogger().info("#          Made by c0rnell_#6523            #");
        getLogger().info("#             and Aleols1#0001              #");
        getLogger().info("#                                           #");
        getLogger().info("#############################################");

        getCommand("gamemode").setExecutor(new GameModeGUICommand(this));
        getCommand("heal").setExecutor(new HealCommand(this));
        getCommand("feed").setExecutor(new FeedCommand(this));
        getCommand("fly").setExecutor(new FlyCommand(this));
        getCommand("vanish").setExecutor(new VanishCommand(this));
        getCommand("setspawn").setExecutor(new SetSpawnCommand(this));
        getCommand("spawn").setExecutor(new SpawnCommand(this));

        getCommand("core").setExecutor(new ReloadConfigCommand(this));
        getCommand("broadcast").setExecutor(new BroadcastCommand(this));
        getCommand("clearchat").setExecutor(new ClearChat(this));
        getCommand("chatmute").setExecutor(new ChatMode(this));

        Bukkit.getServer().getPluginManager().registerEvents(new onJoinEvent(this), (Plugin)this);
        Bukkit.getServer().getPluginManager().registerEvents(new SpawnListener(this), (Plugin)this);
        Bukkit.getServer().getPluginManager().registerEvents(new ColorListener(this), (Plugin)this);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinLeaveListener(this), (Plugin)this);


        getConfig().addDefault("joinMessage", true);
        getConfig().addDefault("leaveMessage", true);
        getConfig().addDefault("motdMessage", true);
        getConfig().options().copyDefaults(true);
        saveDefaultConfig();

        this.PREFIX = getConfig().getString("PREFIX").replace('&', '§');
        this.COLORCODE = getConfig().getString("COLORCODE").replace('&', '§');

        this.JOIN_MESSAGE = getConfig().getString("JOIN_MESSAGE").replace('&', '§');
        this.LEAVE_MESSAGE = getConfig().getString("LEAVE_MESSAGE").replace('&', '§');

        this.SURVIVAL = getConfig().getString("SURVIVAL").replace('&', '§');
        this.CREATIVE = getConfig().getString("CREATIVE").replace('&', '§');
        this.ADVENTURE = getConfig().getString("ADVENTURE").replace('&', '§');
        this.SPECTATOR = getConfig().getString("SPECTATOR").replace('&', '§');
        this.FLY_ENABLE = getConfig().getString("FLY_ENABLE").replace('&', '§');
        this.FLY_DISABLE = getConfig().getString("FLY_DISABLE").replace('&', '§');
        this.VANISH_ENABLE = getConfig().getString("VANISH_ENABLE").replace('&', '§');
        this.VANISH_DISABLE = getConfig().getString("VANISH_DISABLE").replace('&', '§');

        this.LINE1 = getConfig().getString("LINE1").replace('&', '§');
        this.LINE2 = getConfig().getString("LINE2").replace('&', '§');
        this.LINE3 = getConfig().getString("LINE3").replace('&', '§');
        this.LINE4 = getConfig().getString("LINE4").replace('&', '§');
        this.LINE5 = getConfig().getString("LINE5").replace('&', '§');
        this.LINE6 = getConfig().getString("LINE6").replace('&', '§');
        this.LINE7 = getConfig().getString("LINE7").replace('&', '§');
        this.LINE8 = getConfig().getString("LINE7").replace('&', '§');

        this.HEAL = getConfig().getString("HEAL").replace('&', '§');
        this.FEED = getConfig().getString("FEED").replace('&', '§');

        this.SETSPAWN = getConfig().getString("SETSPAWN").replace('&', '§');
        this.SPAWN = getConfig().getString("SPAWN").replace('&', '§');
        this.NONESPAWN = getConfig().getString("NONESPAWN").replace('&', '§');

    }

    @Override
    public void onDisable() {}
}