package de.artus.easterevent2023;

import de.artus.easterevent2023.commands.addNewEggCommand;
import de.artus.easterevent2023.commands.startGameCommand;
import de.artus.easterevent2023.events.playerCollectEggEvent;
import de.artus.easterevent2023.utils.EggConfig;
import de.artus.easterevent2023.utils.GameScoreboard;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Easterevent2023 extends JavaPlugin {

    @Override
    public void onEnable() {
        EggConfig.save();

        getCommand("newegg").setExecutor(new addNewEggCommand());
        getCommand("startgame").setExecutor(new startGameCommand());

        PluginManager pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new playerCollectEggEvent(), this);

        Bukkit.getOnlinePlayers().forEach(GameScoreboard::setPlayerScoreboard);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
