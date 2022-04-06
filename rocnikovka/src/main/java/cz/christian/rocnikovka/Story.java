package cz.christian.rocnikovka;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static org.bukkit.StructureType.STRONGHOLD;

public class Story implements CommandExecutor {

    private int countTime = 1;
    private int helperWithMin;
    private int count = 0;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        Location currlocation = player.getLocation();
        Location structure = player.getWorld().locateNearestStructure(player.getLocation(), STRONGHOLD, 50000, true);
        double distance = currlocation.distance(structure);
        double finalTime = distance * 20 + 12000;
        double min = (finalTime / 20) / 60;
        helperWithMin = (int) min;
        mainStory();
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Rocnikovka.getInstance(), new Runnable() {
            @Override
            public void run() {
                player.teleport(Bukkit.getServer().getWorld("world").getSpawnLocation());
                Bukkit.reload();
                Bukkit.getServer().reloadData();
                player.sendMessage("Nestihl jsi dojít do " + Math.round(min) + " min do Strongholdu :(, pokud to chceš zkusit znovu, napiš /pluginenable");
            }
        }, (long) finalTime);// 20 L == 1 sec
        timer();

        return true;
    }
    public void mainStory(){
        String[] text2 = {"Ale", "ne", "atomové", "bomby", "byly", "svrženy", "na", "Evropu.", "Musíš", "se", "dostat", "do", "Strongholdu", "do" + Math.round(helperWithMin) + " min,", "jinak", "tě", "radiace", "zabije.", "Cestou", "potkáš", "různé ",
                "překážky", "a", "nebezpečí.", "Souřadnice", "Strongholdu", "nejsou", "známy,", "ale", "máš", "u", "sebe", "GPS", "lokátor,", "který", "ti", "do", "chatu", "bude", "vypisovat,", "pokud", "ses", "přiblížil.", "Štastnou", "cestu!"};
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Rocnikovka.getInstance(), new Runnable() {
                @Override
                public void run() {
                    Bukkit.broadcastMessage(text2[count]);
                    count++;
                    if(count < 45) {
                        mainStory();
                    }
                }

            }, 10);
        }



    public void timer() {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Rocnikovka.getInstance(), new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage("Zbývá ti " + (Math.round(helperWithMin) - countTime) + " minut.");
                countTime++;
                timer();
            }
        }, 1200L);
    }
}


