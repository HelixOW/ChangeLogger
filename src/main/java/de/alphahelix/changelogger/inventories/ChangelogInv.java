package de.alphahelix.changelogger.inventories;

import de.alphahelix.alphalibary.inventorys.InventoryBuilder;
import de.alphahelix.changelogger.ChangeLogger;
import de.alphahelix.changelogger.instances.ChangeLog;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class ChangelogInv {

    private static Inventory i;

    public static void fillInventory() {
        InventoryBuilder ib = new InventoryBuilder(ChangeLogger.getOptionsFile().getTitle(), ChangeLogger.getOptionsFile().getSize()) {
            @Override
            public void onOpen(InventoryOpenEvent e) {}

            @Override
            public void onClose(InventoryCloseEvent e) {}
        };

        ArrayList<ChangeLog> logs = ChangeLogger.getChangelogFile().getLogEntries();

        for(ChangeLog log : logs) {
            ib.addItem(new InventoryBuilder.SimpleItem(log.getIcon(), logs.indexOf(log)) {
                @Override
                public void onClick(InventoryClickEvent inventoryClickEvent) {
                    inventoryClickEvent.setCancelled(true);
                }
            });
        }

        i = ib.build();
    }

    public static void openInventory(Player p) {
        if(i == null) return;

        p.openInventory(i);
    }
}
