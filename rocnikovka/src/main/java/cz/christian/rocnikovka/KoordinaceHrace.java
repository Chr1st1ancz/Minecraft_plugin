package cz.christian.rocnikovka;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;


import java.util.Timer;

import static org.bukkit.StructureType.STRONGHOLD;

public class KoordinaceHrace implements Listener {
    int moving = 0;
    Location tempLocation = null;
    @EventHandler
    public void whenPlayerMoves(PlayerMoveEvent event){
        Player player = event.getPlayer();
        Location currlocation = player.getLocation();
        Location structure = player.getWorld().locateNearestStructure(player.getLocation(), STRONGHOLD, 50000, true);
        if((event.getTo().getX() != event.getFrom().getX()) && (event.getTo().getZ() != event.getFrom().getZ())) {
            if(!event.getPlayer().isFlying()) {
                 moving = moving+1;
                if(moving > 50){
                    moving = 0;
                    if(currlocation.distance(structure) > 200){
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
                        player.sendMessage("Od strongholdu jsi " + Math.round(currlocation.distance(structure)) + " daleko.");
                    }
                }
                }
        }

       // player.sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(("Od strongholdu jsi " + Math.round(currlocation.distance(structure)) + " daleko.")));
      //  Player player = event.getPlayer();
       // Block currentBlock = player.getLocation().getBlock().getRelative(BlockFace.DOWN);


    }
}
