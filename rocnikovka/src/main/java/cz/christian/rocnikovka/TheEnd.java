package cz.christian.rocnikovka;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class TheEnd implements Listener {
    @EventHandler
    public void endLogic(PlayerChangedWorldEvent event){
        Player player = event.getPlayer();
        Location l = new Location(Bukkit.getWorld("world"), -529, 50, -83);
        player.teleport(l);
        Bukkit.reload();
        Bukkit.getServer().reloadData();
        player.sendMessage("Dohrál jsi!");
    }
}
