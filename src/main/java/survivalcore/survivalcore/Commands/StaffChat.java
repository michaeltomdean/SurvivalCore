package survivalcore.survivalcore.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StaffChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg1, String[] args) {

        if (args.length!=0) {

            if (sender instanceof Player) {

                if (sender.hasPermission("heaven.staff")) {

                    if (command.getName().equalsIgnoreCase("staffchat") || command.getName().equalsIgnoreCase("sc") || command.getName().equalsIgnoreCase("ac")) {
                        String message = "";

                        for (int i=0; i!=args.length; i++) {
                            message += args[i] + " ";
                        }

                        for (Player anyplayer : Bukkit.getOnlinePlayers()) {

                            if (anyplayer.hasPermission("heaven.staff")) {
                                anyplayer.sendMessage(ChatColor.GRAY + "[" + ChatColor.DARK_RED + "Staff Chat" + ChatColor.DARK_GRAY + "] " + ChatColor.GREEN + sender.getName() + ": " + ChatColor.WHITE + message);
                            }

                        }
                    }
                }
            }

        }
        return false;
    }
}