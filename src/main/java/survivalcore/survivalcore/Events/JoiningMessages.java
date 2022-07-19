package survivalcore.survivalcore.Events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoiningMessages implements Listener {

    @EventHandler(priority=EventPriority.HIGHEST)
    public void JoiningMessage(PlayerJoinEvent e) {
        Player player = e.getPlayer();

        if (player.getGameMode()==GameMode.SPECTATOR || player.getGameMode()==GameMode.CREATIVE) {
            player.setGameMode(GameMode.SURVIVAL);
        }
        return;
    }

}
