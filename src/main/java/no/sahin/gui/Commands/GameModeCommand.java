package no.sahin.gui.Commands;

import no.sahin.gui.Main;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand implements CommandExecutor {

    private Main c;
    public GameModeCommand(Main instance) {
        this.c = instance;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("gamemode")) {
            if (args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " §rType §e/core help&r for more information."));

            } else if (args[0].equalsIgnoreCase("survival")) {
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("SURVIVAL")));
            } else if (args[0].equalsIgnoreCase("creative")) {
                p.setGameMode(GameMode.CREATIVE);
            } else if (args[0].equalsIgnoreCase("adventure")) {
                p.setGameMode(GameMode.ADVENTURE);
            } else if (args[0].equalsIgnoreCase("spectator")) {
                p.setGameMode(GameMode.SPECTATOR);
            }
        }
        return true;
    }
}
