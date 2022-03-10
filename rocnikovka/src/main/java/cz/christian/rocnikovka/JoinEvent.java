package cz.christian.rocnikovka;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.server.PluginEnableEvent;

public class JoinEvent implements Listener{

    @EventHandler
    public void story(PlayerJoinEvent event){
        String nick = event.getPlayer().getDisplayName();
        event.setJoinMessage(ChatColor.GOLD + nick + " se připojil");

    }
}
