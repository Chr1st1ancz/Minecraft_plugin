package cz.christian.rocnikovka;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import cz.christian.rocnikovka.KoordinaceHrace;

import static org.bukkit.StructureType.STRONGHOLD;

public class TeleportWhenEnemyHit implements Listener {
    //reset pozice po hitnutí enemy
    private boolean msgtype = false;
    private boolean oneTimeMsg = false;
    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event) {
        Entity entity = event.getEntity();
        Player player = (Player) entity;
        Location currlocation = player.getLocation();
        Location structure = player.getWorld().locateNearestStructure(player.getLocation(), STRONGHOLD, 50000, true);
        if (currlocation.distance(structure) > 100 && oneTimeMsg == false) {

            if (entity instanceof Player) {
                Location newlocation = currlocation.add(Math.random() * 100, 0, Math.random() * 100);
                Block Yheight = player.getWorld().getHighestBlockAt(newlocation);
                newlocation.setY(Yheight.getY() + 1);
                player.teleport(newlocation);

                if (msgtype == true) {
                    player.sendMessage("Byl jsi hitnut enemy, teleportuju na random místo");
                } else if (!msgtype) {
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
