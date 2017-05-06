package de.alphahelix.changelogger;

import de.alphahelix.changelogger.commands.ChangeLogCommand;
import de.alphahelix.changelogger.files.ChangelogFile;
import de.alphahelix.changelogger.files.OptionsFile;
import de.alphahelix.changelogger.inventories.ChangelogInv;
import org.bukkit.plugin.java.JavaPlugin;

public class ChangeLogger extends JavaPlugin {

    private static ChangeLogger instance;

    private static OptionsFile optionsFile;
    private static ChangelogFile changelogFile;

    @Override
    public void onEnable() {
        instance = this;
        changelogFile = new ChangelogFile();
        optionsFile = new OptionsFile();

        new ChangeLogCommand();

        ChangelogInv.fillInventory();
    }

    public static ChangeLogger getInstance() {
        return instance;
    }

    public static ChangelogFile getChangelogFile() {
        return changelogFile;
    }

    public static OptionsFile getOptionsFile() {
        return optionsFile;
    }
}
