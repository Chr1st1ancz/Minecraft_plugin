package cz.christian.rocnikovka;

import org.bukkit.Location;
import org.bukkit.StructureType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import static org.bukkit.StructureType.STRONGHOLD;
import static org.bukkit.StructureType.getStructureTypes;

public class Prikazy implements Listener {

    @EventHandler
    public void playerJoin(PlayerJoinEvent event) {
        Player player = (Player) event.getPlayer();
        player.sendMessage("Tady bude příběh");
    }
    //reset pozice po hitnutí enemy
    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event){
        Entity entity = event.getEntity();
        if(entity instanceof Player){
            Player player = (Player) entity;
            Location currlocation = player.getLocation();
            Location newlocation = currlocation.add(Math.random()*100, 100, Math.random()*100);
            player.teleport(newlocation);
            while(player.isFlying()){
                player.setHealthScale(1000);
            }

            player.sendMessage("Byl jsi hitnut enemy, teleportuju na random místo");

        }
    }

}
