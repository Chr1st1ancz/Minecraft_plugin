package cz.christian.rocnikovka;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static org.bukkit.StructureType.STRONGHOLD;

public class KoordinaceHrace implements Listener {
   private double moving = 0;
   private boolean foundStronghold = false;
   private Location tempLocation = null;
    @EventHandler
    public void whenPlayerMoves(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Location currlocation = player.getLocation();
        Location structure = player.getWorld().locateNearestStructure(player.getLocation(), STRONGHOLD, 50000, true);
        if((event.getTo().getX() != event.getFrom().getX()) && (event.getTo().getZ() != event.getFrom().getZ())) {
                 moving = moving+0.2;
                if(moving > 50){
                    moving = 0;
                    if(currlocation.distance(structure) > 300){
                        if(tempLocation == null){
                            tempLocation = currlocation;
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
                        if(currlocation.distance(structure) < 100 && foundStronghold == false){
                            player.sendMessage("Kopej! Je někde pod tebou");
                            foundStronghold = true;
                            new FoundStronghold();
                        }
                    }
                }

        }

       // player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(("Od strongholdu jsi " + Math.round(currlocation.distance(structure)) + " daleko.")));
      //  Player player = event.getPlayer();
       // Block currentBlock = player.getLocation().getBlock().getRelative(BlockFace.DOWN);


    }
}
