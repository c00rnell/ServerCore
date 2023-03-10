package no.sahin.gui.Commands;

import no.sahin.gui.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionType;

import java.util.ArrayList;
import java.util.List;

public class GameModeGUICommand implements Listener, CommandExecutor {

    private String invName = "GameMode Selector";

    public static ArrayList<Player> invisible = new ArrayList<>();

    Main c;

    public GameModeGUICommand(Main plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.c = plugin;
    }

    @EventHandler
    public void onClickItem(InventoryClickEvent e) {
        Inventory inv = e.getInventory();
        if(e.getWhoClicked() instanceof Player) {
            Player p = (Player)e.getWhoClicked();
            if(e.getView().getTitle().equals(invName)) {
                e.setCancelled(true);

                if(e.getCurrentItem() != null) {
                    ItemStack i = e.getCurrentItem();

                    if (i.getType() == Material.IRON_SWORD) {
                        if (p.hasPermission("core.survival")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("SURVIVAL")));
                            p.setGameMode(GameMode.SURVIVAL);
                            p.closeInventory();
                        }
                        else {
                            p.sendMessage((ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX")) + this.c.noPermissions));
                            p.closeInventory();
                        }
                    }

                    else if (i.getType() == Material.GRASS_BLOCK) {
                        if (p.hasPermission("core.creative")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("CREATIVE")));
                            p.setGameMode(GameMode.CREATIVE);
                            p.closeInventory();
                        }
                        else {
                            p.sendMessage((ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX")) + this.c.noPermissions));
                            p.closeInventory();
                        }
                    }

                    else if (i.getType() == Material.LEATHER_BOOTS) {
                        if (p.hasPermission("core.adventure")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("ADVENTURE")));
                            p.setGameMode(GameMode.ADVENTURE);
                            p.closeInventory();
                        } else {
                            p.sendMessage((ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX")) + this.c.noPermissions));
                            p.closeInventory();
                        }
                    }

                    else if (i.getType() == Material.ENDER_EYE) {
                        if (p.hasPermission("core.spectator")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("SPECTATOR")));
                            p.setGameMode(GameMode.SPECTATOR);
                            p.closeInventory();
                        } else {
                            p.sendMessage((ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX")) + this.c.noPermissions));
                            p.closeInventory();
                        }
                    }

                    else if (i.getType() == Material.FEATHER) {
                        if (p.hasPermission("core.fly")) {
                            if (!p.getAllowFlight()) {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("FLY_ENABLE")));
                                p.setAllowFlight(true);
                                p.closeInventory();
                            } else {
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("FLY_DISABLE")));
                                p.setAllowFlight(false);
                                p.closeInventory();
                            }
                        } else {
                            p.sendMessage((ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX")) + this.c.noPermissions));
                            p.closeInventory();
                        }
                    }

                    else if (i.getType() == Material.POTION) {
                        if (p.hasPermission("core.vanish")) {
                            if (!p.isInvisible()) {
                                p.setInvisible(true);
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("VANISH_ENABLE")));
                                p.closeInventory();
                            } else {
                                p.setInvisible(false);
                                p.sendMessage(ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX") + " " + this.c.getConfig().getString("VANISH_DISABLE")));
                                p.closeInventory();
                            }
                        } else {
                            p.sendMessage((ChatColor.translateAlternateColorCodes('&', this.c.getConfig().getString("PREFIX")) + this.c.noPermissions));
                            p.closeInventory();
                        }
                    }
                }
            }
        }
   }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Inventory inv = Bukkit.createInventory(player, 9 * 3, invName);

        ItemStack potion = new ItemStack(Material.POTION, 1, (short) 8270);
        PotionMeta meta = (PotionMeta) potion.getItemMeta();
        meta.setBasePotionData(new PotionData(PotionType.INVISIBILITY));
        potion.setItemMeta(meta);

        inv.setItem(10, getItem(new ItemStack(Material.IRON_SWORD),"&7&lSURVIVAL", "&fClick here!"));
        inv.setItem(11, getItem(new ItemStack(Material.GRASS_BLOCK), "&7&lCREATIVE", "&fClick here!"));
        inv.setItem(12, getItem(new ItemStack(Material.LEATHER_BOOTS), "&7&lADVENTURE", "&fClick here!"));
        inv.setItem(13, getItem(new ItemStack(Material.ENDER_EYE), "&7&lSPECTATOR", "&fClick here!"));
        inv.setItem(15, getItem(new ItemStack(Material.FEATHER), "&7&lFLY", "&fClick here!"));
        inv.setItem(16, getItem(potion, "&7&lINVISIBILITY", "&fClick here!"));

        player.openInventory(inv);
        return true;
    }

    private ItemStack getItem(ItemStack item, String name, String ... lore) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));

        List<String> lores = new ArrayList<>();
        for(String s : lore) {
            lores.add(ChatColor.translateAlternateColorCodes('&', s));
        }


        meta.setLore(lores);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
        item.setItemMeta(meta);
        return item;
    }

}