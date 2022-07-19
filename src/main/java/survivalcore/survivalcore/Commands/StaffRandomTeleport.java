package survivalcore.survivalcore.Commands;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import survivalcore.survivalcore.Main;

public class StaffRandomTeleport implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg1, String[] args) {

        if (sender instanceof Player) {
            Player executor = (Player) sender;

            if (command.getName().equalsIgnoreCase("t")) {

                if (Main.InStaff.contains(executor.getUniqueId())) {
                    ArrayList<Player> allPlayers = new ArrayList<>();

                    for (Player anyplayer : Bukkit.getOnlinePlayers()) {

                        if (!(anyplayer.hasPermission("heaven.staff"))) {
                            allPlayers.add(anyplayer);
                        }
                    }

                    if (allPlayers.isEmpty()) {
                        executor.sendMessage(ChatColor.WHITE + "There are no players to teleport to");
                        return false;
                    }
                    int RandomInt = new Random().nextInt(allPlayers.size());
                    Player RandomPlayer = allPlayers.get(RandomInt);
                    executor.teleport(RandomPlayer);
                    executor.sendMessage(ChatColor.WHITE + "You have been teleported to " + ChatColor.GREEN + RandomPlayer.getName());
                }
            }
        }

        return false;
    }

}
