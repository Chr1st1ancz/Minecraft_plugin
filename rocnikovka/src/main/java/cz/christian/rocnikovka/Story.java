package cz.christian.rocnikovka;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Story implements CommandExecutor {


        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            Player player = (Player) sender;

            String text = ("Ale ne, atomové bomby byly svrženy na Evropu. Musíš se dostat do Strongholdu do 10 min, jinak tě radiace zabije. Cestou potkáš různé " +
                    "překážky a nebezpečí. Souřadnice Strongholdu nejsou známy, ale máš u sebe GPS lokátor, který ti do chatu bude vypisovat, pokud jsi se přiblížil. Štastnou cestu!");
            try {
                for (String s : text.split(" ")) {
                        Thread.sleep(500);
                        player.sendMessage(s);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
           /* Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) this, new Runnable() {
                @Override
                public void run() {
                    player.teleport(Bukkit.getServer().getWorld("world").getSpawnLocation());
                    Bukkit.reload();
                    Bukkit.getServer().reloadData();
                    player.sendMessage("Nestihl jsi dojít do 10 min do Strongholdu :(, pokud to chceš zkusit znovu, napiš /pluginenable");
                }
            }, 1200L);// 20 L == 1 sec*/









            return true;
        }
    }


