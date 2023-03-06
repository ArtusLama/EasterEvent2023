package de.artus.easterevent2023.logic;

import de.artus.easterevent2023.utils.EggConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Skull;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.metadata.MetadataValue;

import java.util.*;

public class Game {


    public static boolean running = false;
    public static Map<UUID, Integer> eggsFound = new HashMap<>();


    public static void startGame() {
        spawnEggs();

    }
    public static void spawnEggs() {
        List<Location> eggVariants = new ArrayList<>();
        World world = Bukkit.getWorld("world");
        eggVariants.add(new Location(world, 736, 38, -1013));
        eggVariants.add(new Location(world, 736, 38, -1013));
        eggVariants.add(new Location(world, 736, 38, -1013));
        eggVariants.add(new Location(world, 736, 38, -1013));
        eggVariants.add(new Location(world, 736, 38, -1013));

        eggVariants.add(new Location(world, 735, 38, -1013));
        eggVariants.add(new Location(world, 735, 38, -1013));
        eggVariants.add(new Location(world, 735, 38, -1013));
        eggVariants.add(new Location(world, 735, 38, -1013));
        eggVariants.add(new Location(world, 735, 38, -1013));

        eggVariants.add(new Location(world, 734, 38, -1013));
        eggVariants.add(new Location(world, 734, 38, -1013));
        eggVariants.add(new Location(world, 734, 38, -1013));
        eggVariants.add(new Location(world, 734, 38, -1013));
        eggVariants.add(new Location(world, 734, 38, -1013));

        eggVariants.add(new Location(world, 735, 38, -1012)); // gold egg

        EggConfig.getEggLocations().forEach(eggLocation -> {
            Block egg = eggVariants.get(new Random().nextInt(eggVariants.size())).getBlock();


            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
                    "clone %d %d %d %d %d %d %d %d %d".formatted(egg.getX(), egg.getY(), egg.getZ(), egg.getX(), egg.getY(), egg.getZ(), eggLocation.getBlock().getX(), eggLocation.getBlock().getY(), eggLocation.getBlock().getZ()));


        });

        eggsFound.clear();
        running = true;
    }




    public static void playerFoundEgg(Player player, Location location) {
        eggsFound.put(player.getUniqueId(), eggsFound.getOrDefault(player.getUniqueId(), 0) + 1);
        location.getBlock().setType(Material.AIR);
    }


}
