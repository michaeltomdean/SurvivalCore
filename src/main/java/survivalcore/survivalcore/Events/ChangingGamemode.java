package survivalcore.survivalcore.Events;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import survivalcore.survivalcore.Main;

public class ChangingGamemode implements Listener {

    @EventHandler(priority=EventPriority.LOWEST)
    public void onGamemodeChange(PlayerGameModeChangeEvent e) {
        GameMode changedto = e.getNewGameMode();

        if (changedto.equals(GameMode.SURVIVAL)){
            e.getPlayer().sendMessage("Your gamemode has been changed to " + ChatColor.GREEN + "survival.");
        }

        if (changedto.equals(GameMode.CREATIVE)) {
            e.getPlayer().sendMessage("Your gamemode has been changed to " + ChatColor.GREEN + "creative.");
        }

        if (changedto.equals(GameMode.SPECTATOR) && !Main.InStaff.contains(e.getPlayer().getUniqueId())) {
            e.getPlayer().sendMessage("Your gamemode has been changed to " + ChatColor.GREEN + "spectator.");
        }

        if (changedto.equals(GameMode.ADVENTURE)) {
            e.getPlayer().sendMessage("Your gamemode has been changed to " + ChatColor.GREEN + "adventure." );
        }
    }

}

