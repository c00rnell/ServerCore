package no.sahin.gui.Staff;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import no.sahin.gui.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatMode implements Listener, CommandExecutor {

    private Main c;
    public ChatMode(Main instance) {
        this.c = instance;
    }
    private boolean chatLocked = false;
    private Set<UUID> bypassPlayers = new HashSet<>();


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("chatmute")) {
            if (!sender.hasPermission("core.chatmute")) {
                sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
                return true;
            }
            this.chatLocked = !this.chatLocked;
            if (this.chatLocked) {
                Bukkit.broadcastMessage(ChatColor.RED + "Chat has been locked by an admin.");
            } else {
                Bukkit.broadcastMessage(ChatColor.GREEN + "Chat has been unlocked by an admin.");
            }
            return true;
        }
        return false;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (this.chatLocked && !this.bypassPlayers.contains(event.getPlayer().getUniqueId()) && !event.getPlayer().hasPermission("core.bypass")) {
            event.setCancelled(true);
            event.getPlayer().sendMessage(ChatColor.RED + "Chat is currently locked by an admin.");
        }
    }

    public void addBypassPlayer(Player player) {
        this.bypassPlayers.add(player.getUniqueId());
    }

    public void removeBypassPlayer(Player player) {
        this.bypassPlayers.remove(player.getUniqueId());
    }
}