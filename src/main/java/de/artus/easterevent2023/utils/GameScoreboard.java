package de.artus.easterevent2023.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class GameScoreboard {


    public static void setPlayerScoreboard(Player player) {
        Scoreboard board = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective obj = board.registerNewObjective("scoreboard", "dummy", RainbowColor.get("EASTER EVENT"));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);



    }

    public static void update(Player player) {

    }


}
