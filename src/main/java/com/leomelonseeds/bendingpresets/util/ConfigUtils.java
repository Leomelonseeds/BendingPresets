package com.leomelonseeds.bendingpresets.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.leomelonseeds.bendingpresets.BendingPresets;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;

public class ConfigUtils {
    
    public FileConfiguration getPlayerConfig(Player player) {
        String uuid = player.getUniqueId().toString();
        return null;
    }
    
    /**
     * Reloads all loaded configs, closing all GUIs
     */
    public static void reloadConfigs() {
        BendingPresets.getPlugin().reloadConfig();
    }

    /**
     * Get a string from the config's "strings" section
     * Plays an associated sound too, if there is any
     * 
     * @param player
     * @param string
     * @return the parsed string
     */
    public static String getString(String string, Player player) {
        String prefix = BendingPresets.getPlugin().getConfig().getString("strings.prefix");
        String msg = BendingPresets.getPlugin().getConfig().getString("strings." + string);
        sendConfigSound(string, player);
        return ChatColor.translateAlternateColorCodes('&', prefix + msg);
    }
    
    /**
     * Send a sound to the player.
     *
     * @param path the key of the sounds in "sounds"
     * @param player the player to send sound to
     */
    public static void sendConfigSound(String path, Player player) {
        ConfigurationSection soundConfig = BendingPresets.getPlugin().getConfig().getConfigurationSection("sounds");

        if (!soundConfig.contains(path)) {
            return;
        }

        Sound sound = Sound.valueOf(soundConfig.getString(path + ".sound"));
        float volume = (float) soundConfig.getDouble(path + ".volume");
        float pitch = (float) soundConfig.getDouble(path + ".pitch");

        player.playSound(player.getLocation(), sound, SoundCategory.MASTER, volume, pitch);
    }
    
    /**
     * Get a line, translate it to a component.
     * 
     * @param line
     * @return
     */
    public static Component toComponent(String line) {
        return Component.text(ChatColor.translateAlternateColorCodes('&', line));
    }
    
    /**
     * Get lines to translate to components
     * 
     * @param line
     * @return
     */
    public static List<Component> toComponent(List<String> lines) {
        List<Component> result = new ArrayList<>();
        for (String s : lines) {
            result.add(toComponent(s));
        }
        return result;
    }

    /**
     * Component to plain text!
     * 
     * @param component
     * @return
     */
    public static String toPlain(Component component) {
        return PlainTextComponentSerializer.plainText().serialize(component);
    }
}
