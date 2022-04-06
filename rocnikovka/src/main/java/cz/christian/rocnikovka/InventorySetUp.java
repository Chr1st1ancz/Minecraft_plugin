package cz.christian.rocnikovka;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class InventorySetUp implements Listener {
    @EventHandler
    public void inventory(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        //pokud nemá hráč itemy, dá mu to meč, krumpáč a enderperly po joinu
        if (!player.getInventory().contains(Material.DIAMOND_SWORD)) {
            ItemStack[] items = {new ItemStack(Material.DIAMOND_SWORD), new ItemStack(Material.DIAMOND_PICKAXE), new ItemStack(Material.ENDER_EYE, 16)};
            player.getInventory().addItem(items);
            player.sendMessage("Dostaneš tady meč, krumpáč a enderperly, to, co s nimi budeš dělat se dozvíš po příkazu /pluginenable");
        }
    }
}
