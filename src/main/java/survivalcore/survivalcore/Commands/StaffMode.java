package survivalcore.survivalcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import survivalcore.survivalcore.Main;

public class StaffMode implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg1, String[] args) {

        if (command.getName().equalsIgnoreCase("staffmode")) {

            if (sender instanceof Player && sender.hasPermission("heaven.staff")) {

                if (!(args.length==0)) {

                    if (args[0].equalsIgnoreCase("on") || args[0].equalsIgnoreCase("enabled")){
                        Player executor = (Player) sender;
                        if(!(Main.InStaff.contains(executor.getUniqueId()))){
                            executor.sendMessage(ChatColor.GREEN + "Your staff mode has been " + ChatColor.GREEN + "enabled");
                            executor.setGameMode(GameMode.SPECTATOR);
                            Main.InStaff.add(executor.getUniqueId());

                        }else {
                            sender.sendMessage(ChatColor.RED + "You are already in staff mode");
                        }
                    }

                    if (args[0].equalsIgnoreCase("off") || args[0].equalsIgnoreCase("disabled")) {
                        Player executor = (Player) sender;
                        if(Main.InStaff.contains(executor.getUniqueId())) {
                            executor.sendMessage(ChatColor.GREEN + "Your staff mode has been " + ChatColor.RED + "disabled");
                            executor.setGameMode(GameMode.SURVIVAL);
                            Main.InStaff.remove(executor.getUniqueId());

                        }else {
                            sender.sendMessage(ChatColor.RED + "You are not in staff mode");
                        }
                    }

                }else {
                    sender.sendMessage(ChatColor.RED + "Please specify if you want to turn staffmode on or off");
                }
            }

        }
        return false;
    }
}
