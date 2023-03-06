package de.artus.easterevent2023.utils;

import de.artus.easterevent2023.Easterevent2023;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EggConfig {


    public static File ConfigFile = new File(Easterevent2023.getPlugin(Easterevent2023.class).getDataFolder(), "eggs.yml");
    public static FileConfiguration Config = YamlConfiguration.loadConfiguration(ConfigFile);

    public static void save() {
        try {
            Config.save(ConfigFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void placeEgg(Location location) {
        List<Location> locations = getEggLocations();
        location.setYaw(0f);
        location.setPitch(0f);
        locations.add(location);
        Config.set("eggs", locations);
        save();
    }

    public static List<Location> getEggLocations() {
        List<Location> locations = (List<Location>) Config.getList("eggs");
        if (locations == null) locations = new ArrayList<>();
        return locations;
    }

    public static boolean isEggAtPosition(Location location) {
        location.setYaw(0f);
        location.setPitch(0f);


        return getEggLocations().contains(location) && location.getBlock().getType() != Material.AIR;
    }


}
