package cz.christian.rocnikovka;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Rocnikovka extends JavaPlugin implements CommandExecutor, Listener {

    private boolean isOn = false;
    private static Rocnikovka instance;
    @Override
            public void onEnable(){
        instance = this;
        getLogger().info("Plugin se zapnul");
        getServer().getPluginManager().registerEvents(new JoinEvent(), this);
        getServer().getPluginManager().registerEvents(new InventorySetUp(),this);
    }
    public static Rocnikovka getInstance(){
        return instance;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!isOn) {
            Player player = (Player) sender;
            player.sendMessage("Plugin se zapl. Napiš /storyenable, aby ses dozvěděl, co s těmi věcmi v tvém inventáři máš dělat");
            getServer().getPluginManager().registerEvents(new KoordinaceHrace(), this);
            this.getCommand("storyEnable").setExecutor(new Story());
            this.getCommand("reloadPlugin").setExecutor(new ReloadPlugin());
            getServer().getPluginManager().registerEvents(new FoundStronghold(),this);
            getServer().getPluginManager().registerEvents(new TheEnd(),this);
            getServer().getPluginManager().registerEvents(new TeleportWhenEnemyHit(), this);

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
