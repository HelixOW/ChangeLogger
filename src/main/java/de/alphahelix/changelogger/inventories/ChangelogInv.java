package de.alphahelix.changelogger.inventories;

import de.alphahelix.alphalibary.menus.Menu;
import de.alphahelix.alphalibary.menus.MenuElement;
import de.alphahelix.changelogger.ChangeLogger;
import de.alphahelix.changelogger.instances.ChangeLog;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class ChangelogInv {
    
    private static Menu menu;

    public static void fillInventory() {
    
        menu = new Menu(ChangeLogger.getOptionsFile().getTitle(), ChangeLogger.getOptionsFile().getSize());
    
        ChangeLog[] logs = ChangeLogger.getChangelogFile().getLogEntries();
    
        for(int i = 0; i < logs.length; i++) {
            int finalI = i;
            menu.addElement(i, new MenuElement() {
                @Override
                public ItemStack getIcon (Player player) {
                    return logs[finalI].getIcon();
                }
            
                @Override
                public void click (InventoryClickEvent inventoryClickEvent) {
                    inventoryClickEvent.setCancelled(true);
                }
            });
        }
    }

    public static void openInventory(Player p) {
        if(menu == null) return;
    
        menu.open(p);
    }
}
