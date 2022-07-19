package survivalcore.survivalcore.Events;


import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatFormatting implements Listener {

    @EventHandler(priority=EventPriority.HIGHEST)
    public void chats(AsyncPlayerChatEvent e){

        Player player = e.getPlayer();

        e.setFormat(player.getName() + ": " + ChatColor.GREEN + e.getMessage());

    }


}
