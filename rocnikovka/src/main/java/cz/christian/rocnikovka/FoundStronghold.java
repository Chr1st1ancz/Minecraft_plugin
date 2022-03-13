package cz.christian.rocnikovka;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FoundStronghold extends KoordinaceHrace implements Listener {
    private int entityCount = 0;
    private int overallCount = 0;
    private boolean mobSpawn = false;

    @EventHandler
    public void foundStronghold(PlayerMoveEvent event){
        if(foundStronghold) {
            while (overallCount < 12) {
                Player player = (Player) event;
                if (!mobSpawn) {
                    Entity ent = player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                    ((Zombie) ent).setHealth(1000);
                    mobSpawn = true;
                    entityCount = 0;
                }
                if (entityCount == 1) {
                    mobSpawn = false;
                }
            }
        }


    }
    @EventHandler
    public void entityDeath(EntityDeathEvent event){
        Player player = (Player) event;
        entityCount++;
        overallCount++;
        player.sendMessage("Zabil jsi enemy!" + (10-overallCount) + " zbývá");

    }
}
