package cz.christian.rocnikovka;

import org.bukkit.World;
import org.bukkit.WorldCreator;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class Rocnikovka extends JavaPlugin {

    @Override
    public void onEnable() {
        new WorldCreator("arena").name("world").createWorld();
        getLogger().info("Plugin se zapnul");

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin se vypnul");
    }
}
