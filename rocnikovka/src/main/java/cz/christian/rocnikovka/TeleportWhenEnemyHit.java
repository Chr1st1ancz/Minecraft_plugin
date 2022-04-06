package cz.christian.rocnikovka;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import static org.bukkit.StructureType.STRONGHOLD;

public class TeleportWhenEnemyHit implements Listener {
    //reset pozice po hitnutí enemy
    private boolean msgtype = false;
    private boolean oneTimeMsg = false;
    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        //definice entity, hráče a lokace
        Entity entity = event.getEntity();
        Player player = (Player) event.getEntity();
        Location currlocation = player.getLocation();
        Location structure = player.getWorld().locateNearestStructure(player.getLocation(), STRONGHOLD, 50000, true);
        if (currlocation.distance(structure) > 120 && !oneTimeMsg) {
            //když enemy hitne hráče, hráč se teleportuje
            if (entity instanceof Player) {
                Location newlocation = currlocation.add(Math.random() * 100, 0, Math.random() * 100);
                Block Yheight = player.getWorld().getHighestBlockAt(newlocation);
                newlocation.setY(Yheight.getY() + 1);
                player.teleport(newlocation);
                if (msgtype) {
                    player.sendMessage("Byl jsi hitnut enemy, teleportuju na random místo");
                } else {
                    player.sendMessage("Zapomněl jsem říct, že hit od enemy tě teleportuje na náhodné místo :)");
                    msgtype = true;
                }


            }

        }
        else {
            if (!oneTimeMsg) {
                player.sendMessage("Teleportování po hitu je disabled");
                oneTimeMsg = true;
            }
        }
    }

}
