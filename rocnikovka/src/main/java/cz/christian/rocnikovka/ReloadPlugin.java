package cz.christian.rocnikovka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadPlugin implements CommandExecutor{
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        player.teleport(Bukkit.getServer().getWorld("world").getSpawnLocation());
        Bukkit.reload();
        Bukkit.getServer().reloadData();

            player.sendMessage("Plugin se restartoval. Napiš /pluginEnable pro zapnutí.");
        return true;
    }

}
