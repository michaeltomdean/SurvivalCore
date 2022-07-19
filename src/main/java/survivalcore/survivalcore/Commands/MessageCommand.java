package survivalcore.survivalcore.Commands;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class MessageCommand implements CommandExecutor{

    private HashMap<UUID,UUID> Reply = new HashMap<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String arg1, String[] args) {

        if (sender instanceof Player) {

            if (command.getName().equalsIgnoreCase("msg") || command.getName().equalsIgnoreCase("w")) {
                Player messagee = (Player) sender;

                if (!(args[0]==null)) {
                    Player receiver = Bukkit.getPlayer(args[0]);

                    if (!(receiver==null)) {
                        String message = "";

                        for(int i=1; i !=args.length; i++) {
                            message += args[i] + " ";
                        }
                        receiver.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "MSG" + ChatColor.GRAY + "] " + ChatColor.AQUA + messagee.getName() + ": " +ChatColor.WHITE + message);
                        messagee.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "MSG" + ChatColor.GRAY + "] " + ChatColor.AQUA + messagee.getName() + ": " +ChatColor.WHITE + message);
                        Reply.put(receiver.getUniqueId(), messagee.getUniqueId());
                        Reply.put(messagee.getUniqueId(), receiver.getUniqueId());

                    }else {
                        messagee.sendMessage(ChatColor.RED + "The player you are trying to message is not online");
                    }

                }else {
                    messagee.sendMessage(ChatColor.RED + "Please enter a player name");
                }
            }

            if (command.getName().equalsIgnoreCase("r") || command.getName().equalsIgnoreCase("reply")) {
                Player messagee = (Player) sender;

                if (Reply.containsValue(messagee.getUniqueId())) {
                    Player receiver = Bukkit.getPlayer(Reply.get(messagee.getUniqueId()));

                    if (!(receiver==null)) {
                        String message = "";

                        for(int i=0; i !=args.length; i++) {
                            message += args[i] + " ";
                        }
                        receiver.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "MSG" + ChatColor.GRAY + "] " + ChatColor.AQUA + messagee.getName() + ": " +ChatColor.WHITE + message);
                        messagee.sendMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "MSG" + ChatColor.GRAY + "] " + ChatColor.AQUA + messagee.getName() + ": " +ChatColor.WHITE + message);
                        Reply.put(receiver.getUniqueId(), messagee.getUniqueId());
                        Reply.put(messagee.getUniqueId(), receiver.getUniqueId());

                    }else {
                        messagee.sendMessage(ChatColor.RED + "That player is no longer online");
                    }

                }else {
                    messagee.sendMessage(ChatColor.RED + "You have no recent messages to reply to");
                }
            }


        }
        return false;
    }

}
