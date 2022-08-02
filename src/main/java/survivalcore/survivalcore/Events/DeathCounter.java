package survivalcore.survivalcore.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import survivalcore.survivalcore.Main;

public class DeathCounter implements Listener {

    @EventHandler(priority= EventPriority.HIGHEST)
    public void onPlayerDeath(PlayerDeathEvent e) {

        Player player = e.getPlayer();

        int deaths = 0;
        if (Main.getInstance().data.getConfig().contains(player.getUniqueId().toString() + ".deaths")) {
            deaths = Main.getInstance().data.getConfig().getInt(player.getUniqueId().toString() + ".deaths");
        }
        Main.getInstance().data.getConfig().set(player.getUniqueId().toString() + ".deaths", (deaths + 1));
        Main.getInstance().data.saveConfig();
    }

}
