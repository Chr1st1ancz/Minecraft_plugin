package cz.christian.rocnikovka;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class Rocnikovka extends JavaPlugin {

    @Override
    public void onEnable() {
       // new Prikazy();
        getServer().getPluginManager().registerEvents(new Prikazy(), this);
        getServer().getPluginManager().registerEvents(new KoordinaceHrace(), this);
        new WorldCreator("arena").name("world").createWorld();
        getLogger().info("Plugin se zapnul");
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin se vypnul");
    }
}
