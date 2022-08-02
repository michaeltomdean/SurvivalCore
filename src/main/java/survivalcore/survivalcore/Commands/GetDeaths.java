package survivalcore.survivalcore.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import survivalcore.survivalcore.Main;

public class GetDeaths implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg1, String[] args){

        if (sender instanceof Player){

            int deaths = 0;

            if (Main.getInstance().data.getConfig().contains(((Player) sender).getUniqueId() + ".deaths")){
                deaths = Main.getInstance().data.getConfig().getInt(((Player) sender).getUniqueId().toString() + ".deaths");
                sender.sendMessage("You have died " + ChatColor.GREEN + deaths + ChatColor.WHITE + " times");
            }else{
                sender.sendMessage("You have died " + ChatColor.GREEN +  "0" + ChatColor.WHITE + " times");
            }

        }

        return false;

    }
}
