package cz.christian.rocnikovka;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static org.bukkit.StructureType.STRONGHOLD;

public class PlayerMovement implements Listener {
   private double moving = 0;
   public boolean foundStronghold = false;
   private Location tempLocation = null;
    @EventHandler
    public void whenPlayerMoves(PlayerMoveEvent event){
        //inicializace
        Player player = event.getPlayer();
        Location currlocation = player.getLocation();
        //lokace strongholdu
        Location structure = player.getWorld().locateNearestStructure(player.getLocation(), STRONGHOLD, 50000, true);
       //podmínka, když se pohne hráč
        if((event.getTo().getX() != event.getFrom().getX()) && (event.getTo().getZ() != event.getFrom().getZ())) {
                 moving = moving+0.2;
                if(moving > 50){
                    moving = 0;
                    if(currlocation.distance(structure) > 300){
                        if(tempLocation == null){
                            tempLocation = currlocation;
                            player.sendMessage("Každých 50 bloků se ti do chatu zobrazí, jestli jsi se přiblížil nebo ne");
                        }
                    if(tempLocation.distance(structure) > currlocation.distance(structure)){
                            player.sendMessage("Přihořívá");
                            tempLocation = currlocation;
                    }
                    else if((tempLocation.distance(structure) < currlocation.distance(structure))){
                        player.sendMessage("Samá voda");
                        tempLocation = currlocation;
                    }
                    }
                    else{
                        if(currlocation.distance(structure) > 100) {
                            player.sendMessage("Od strongholdu jsi " + Math.round(currlocation.distance(structure)) + " daleko.");
                        }
                        //když dojdeš do strongholdu, dál kod pokračuje v FoundStronghold
                        if(currlocation.distance(structure) < 100 && !foundStronghold){
                            player.sendMessage("Ale ne, lidi tě chtějí zabít, aby mohli jít do tvého bunkru. Zabij je!");
                            foundStronghold = true;
                            Entity ent = player.getWorld().spawnEntity(player.getLocation(), EntityType.ZOMBIE);
                            ((Zombie) ent).setHealth(20);
                            ent.setCustomName("Attacker " + 0);
                            ent.setCustomNameVisible(true);
                            ((Zombie) ent).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 500, 10));
                        }
                    }
                }

        }

       // player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(("Od strongholdu jsi " + Math.round(currlocation.distance(structure)) + " daleko.")));
      //  Player player = event.getPlayer();
       // Block currentBlock = player.getLocation().getBlock().getRelative(BlockFace.DOWN);


    }
}
