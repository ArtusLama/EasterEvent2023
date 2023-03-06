package de.artus.easterevent2023.events;

import de.artus.easterevent2023.utils.GameScoreboard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinQuitEvent implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        GameScoreboard.setPlayerScoreboard(e.getPlayer());
    }


}
