package de.alphahelix.changelogger.files;

import de.alphahelix.alphalibary.file.SimpleJSONFile;
import de.alphahelix.alphalibary.item.ItemBuilder;
import de.alphahelix.changelogger.instances.ChangeLog;
import org.bukkit.Material;

import java.util.ArrayList;

public class ChangelogFile extends SimpleJSONFile {

    public ChangelogFile() {
        super("plugins/ChangeLogger", "changelog.json");

        if(!isEmpty()) return;

        addValuesToList("Logs", new ChangeLog(
                        "§6§lThe inital Update",
                        new ItemBuilder(Material.PAPER).setGlow().build(),
                        "§6Information§8:",
                        "§6- §7Version§8: §6 1.0",
                        "§6Features§8:",
                        "§6- §7ChangeLogger has been added"),
                new ChangeLog(
                        "§6§lThe next big Update",
                        new ItemBuilder(Material.WOOD_AXE).setGlow().build(),
                        "§6Information§8:",
                        "§6- §7Version§8: §6 1.1",
                        "§6Features§8:",
                        "§6- §7We now have 5wAAg")
        );
    }

    public ArrayList<ChangeLog> getLogEntries() {
        return getListValues("Logs", ChangeLog.class);
    }
}
