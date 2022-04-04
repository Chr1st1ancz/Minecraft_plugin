package cz.christian.rocnikovka;

import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
public class FoundStronghold implements Listener {
    private int overallCount = 0;
    @EventHandler
    public void entityDeath(EntityDeathEvent event) {
        Entity killer = event.getEntity().getKiller();
        Entity entity = event.getEntity();
        if (killer instanceof Player){

            if (overallCount < 11) {
                overallCount++;
                entity.sendMessage("Zabil jsi enemy!" + (10 - overallCount) + " zbývá");
                Entity ent = entity.getWorld().spawnEntity(entity.getLocation(), EntityType.ZOMBIE);
                ((Zombie) ent).setHealth(20);
            }
            entity.sendMessage("Zabil jsi všechny, rychle, zakopej se do Strongholdu, najdi portál a stoupni si na něj.");
        }
        }
}



