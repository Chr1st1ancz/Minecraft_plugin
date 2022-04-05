package cz.christian.rocnikovka;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class TheEnd implements Listener {
    @EventHandler
    public void endLogic(PlayerChangedWorldEvent event){
        Player player = event.getPlayer();
        player.teleport(Bukkit.getServer().getWorld("world").getSpawnLocation());
        Bukkit.reload();
        Bukkit.getServer().reloadData();
        player.sendMessage("Dohrál jsi!");
    }
}
