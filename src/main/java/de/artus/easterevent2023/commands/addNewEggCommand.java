package de.artus.easterevent2023.commands;

import de.artus.easterevent2023.utils.EggConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class addNewEggCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (sender instanceof Player player) {
            if (player.isOp()) {
                EggConfig.placeEgg(player.getLocation().toBlockLocation());
            }
        }
        return false;
    }
}
