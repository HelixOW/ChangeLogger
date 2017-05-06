package de.alphahelix.changelogger.files;

import de.alphahelix.alphalibary.file.SimpleFile;

public class OptionsFile extends SimpleFile {
    public OptionsFile() {
        super("plugins/ChangeLogger", "options.yml");
    }

    @Override
    public void addValues() {
        setDefault("Inventory.title", "§6Changelogs");
        setDefault("Inventory.rows", 1);
    }

    public String getTitle() {
        return  getColorString("Inventory.title");
    }

    public int getSize() {
        return getInt("Inventory.rows") * 9;
    }
}
