package de.artus.easterevent2023.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class RainbowColor {

    private static final List<ChatColor> colors = new ArrayList<>(List.of(
            ChatColor.DARK_RED,
            ChatColor.RED,
            ChatColor.YELLOW,
            ChatColor.GREEN,
            ChatColor.DARK_GREEN,
            ChatColor.DARK_AQUA,
            ChatColor.AQUA,
            ChatColor.BLUE,
            ChatColor.DARK_BLUE,
            ChatColor.DARK_PURPLE,
            ChatColor.LIGHT_PURPLE
    ));

    public static String get(String string) {

        StringBuilder out = new StringBuilder();
        int colorIndex = 0;
        for (char symbol : string.toCharArray()) {
            if (Character.isSpaceChar(symbol)) continue;
            out.append(colors.get(colorIndex));
            out.append(symbol);
            colorIndex++;
            if (colorIndex >= colors.size()) colorIndex = 0;
        }
        return out.toString();
    }
}
