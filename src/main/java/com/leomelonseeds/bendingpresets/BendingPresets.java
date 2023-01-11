package com.leomelonseeds.bendingpresets;

import java.util.logging.Level;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import com.leomelonseeds.bendingpresets.invs.InventoryManager;
import com.leomelonseeds.bendingpresets.util.JSONManager;

public class BendingPresets extends JavaPlugin {
    
    private static BendingPresets plugin;
    private JSONManager json;
    private InventoryManager invs;
    
    @Override
    public void onEnable() {
        
        plugin = this;
        
        json = new JSONManager();
        invs = new InventoryManager();
        
        saveDefaultConfig();
        
    }
    
    @Override
    public void onDisable() {
        
    }
    
    public static BendingPresets getPlugin() {
        return plugin;
    }
    
    public void log(String msg) {
        Bukkit.getLogger().log(Level.INFO, "[BendingPresets] " + msg);
    }
    
    public JSONManager getJSON() {
        return json;
    }
    
    public InventoryManager getInvs() {
        return invs;
    }
}
