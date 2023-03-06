package de.artus.easterevent2023.events;

import de.artus.easterevent2023.logic.Game;
import de.artus.easterevent2023.utils.EggConfig;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class playerCollectEggEvent implements Listener {


    @EventHandler
    public void onCollect(PlayerInteractEvent e) {
        if (Game.running) {
            if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if (EggConfig.isEggAtPosition(e.getClickedBlock().getLocation().toBlockLocation())) {
                    Game.playerFoundEgg(e.getPlayer(), e.getClickedBlock().getLocation());
                }
            }
        }
    }


}
