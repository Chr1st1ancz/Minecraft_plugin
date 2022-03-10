package cz.christian.rocnikovka;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class TeleportWhenEnemyHit implements Listener {
    //reset pozice po hitnutí enemy
    private boolean msgtype = false;
    @EventHandler
    public void onPlayerDamage(EntityDamageByEntityEvent event){
        Entity entity = event.getEntity();
        if(entity instanceof Player){
            Player player = (Player) entity;
            Location currlocation = player.getLocation();
            Location newlocation = currlocation.add(Math.random()*100, 0, Math.random()*100);
            Block Yheight = player.getWorld().getHighestBlockAt(newlocation);
             newlocation.setY(Yheight.getY()+1);
            player.teleport(newlocation);

            if(msgtype == true) {
                player.sendMessage("Byl jsi hitnut enemy, teleportuju na random místo");
            }
            else if(!msgtype){
                player.sendMessage("Zapomněl jsem říct, že hit od enemy tě teleportuje na náhodné místo :)");
                msgtype = true;
            }

        }
    }

}
