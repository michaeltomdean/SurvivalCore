package survivalcore.survivalcore.Events;



import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;


public class CancellingCreepers implements Listener {

    @EventHandler(priority=EventPriority.HIGHEST)
    public void onCreeperDamage(EntityExplodeEvent e){

        if (e.getEntity() instanceof Creeper) {

            e.blockList().clear();

        }

    }
}
