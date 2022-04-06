package cz.christian.rocnikovka;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class FoundStronghold implements Listener {
    private int overallCount = 0;
    private boolean oneTimeMsg = false;
    @EventHandler
    public void entityDeath(EntityDeathEvent event) {
        Entity killer = event.getEntity().getKiller();
        Entity entity = event.getEntity();
        if (killer instanceof Player) {
            if(entity.isCustomNameVisible()) {
                if (overallCount < 10) {
                    overallCount++;
                    Location currlocation = killer.getLocation();
                    Location newlocation = currlocation.add(Math.random() * 5, 0, Math.random() * 5);
                    Block Yheight = killer.getWorld().getHighestBlockAt(newlocation);
                    newlocation.setY(Yheight.getY() + 1);
                    Entity ent = entity.getWorld().spawnEntity(newlocation, EntityType.ZOMBIE);
                    ((Zombie) ent).setHealth(20);
                    ent.setCustomName("Attacker " + overallCount);
                    ent.setCustomNameVisible(true);
                    ((Zombie) ent).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 500, 10));
                    Bukkit.broadcastMessage("Zabil jsi enemy! " + (10 - overallCount) + " zbývá");
                }
                else{
                    if (killer instanceof Player) {
                        if(entity.isCustomNameVisible()) {
                            overallCount++;
                        }}
                }
                if (overallCount > 10 && !oneTimeMsg) {
                    oneTimeMsg = true;
                    Bukkit.broadcastMessage("Zabil jsi všechny, rychle, zakopej se do Strongholdu, najdi portál, vyplň je perlami a skoč do něj.");
                }
            }
        }
        }
}



