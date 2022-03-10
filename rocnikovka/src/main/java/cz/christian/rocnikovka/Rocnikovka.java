package cz.christian.rocnikovka;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Rocnikovka extends JavaPlugin implements CommandExecutor, Listener {

    private boolean isOn = false;

    @Override
    public void onEnable() {
        getLogger().info("Plugin se zapnul");
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        this.getCommand("storyEnable").setExecutor(new Story());
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!isOn) {
            Player player = (Player) sender;
            player.sendMessage("Plugin se zapl");
            getServer().getPluginManager().registerEvents(new TeleportWhenEnemyHit(), this);
            getServer().getPluginManager().registerEvents(new KoordinaceHrace(), this);
            isOn = true;
            return true;
        }
        else{
            return false;
        }
    }


    @Override
    public void onDisable() {
        getLogger().info("Plugin se vypnul");
    }
}
