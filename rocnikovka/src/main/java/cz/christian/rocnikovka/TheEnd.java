package cz.christian.rocnikovka;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

public class TheEnd implements Listener {
    private boolean oneTimeTp = false;
    @EventHandler
    public void endLogic(PlayerChangedWorldEvent event){
        if(!oneTimeTp) {
            //teleport do předem připravené místnosti
            oneTimeTp = true;
            Player player = event.getPlayer();
            Location l = new Location(Bukkit.getWorld("world"), -529, 50, -83);
            player.teleport(l);
            //reload pluginu
            Bukkit.reload();
            Bukkit.getServer().reloadData();
            player.sendMessage("Dohrál jsi!");
        }
    }
}
