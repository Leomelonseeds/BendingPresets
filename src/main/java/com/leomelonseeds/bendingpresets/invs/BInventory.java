package com.leomelonseeds.bendingpresets.invs;

import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;

import com.leomelonseeds.bendingpresets.BendingPresets;

public interface BInventory {
    InventoryManager manager = BendingPresets.getPlugin().getInvs();
    
    public void updateInventory();
    
    public void registerClick(int slot, ClickType type);
    
    public Inventory getInventory();
}
