package de.alphahelix.changelogger.instances;

import de.alphahelix.alphalibary.item.ItemBuilder;
import org.bukkit.inventory.ItemStack;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

public class ChangeLog implements Serializable {

    private String title;
    private Map<String, Object> icon;
    private String[] informations;

    public ChangeLog(String title, ItemStack icon, String... infos) {
        this.title = title;
        this.icon = icon.serialize();
        this.informations = infos;
    }

    public String getTitle() {
        return title;
    }

    public ItemStack getIcon() {
        return new ItemBuilder(ItemStack.deserialize(icon)).setName(title).setLore(informations).build();
    }

    public String[] getInformations() {
        return informations;
    }

    @Override
    public String toString() {
        return "ChangeLog{" +
                "title='" + title + '\'' +
                ", icon=" + icon +
                ", informations=" + Arrays.toString(informations) +
                '}';
    }
}
