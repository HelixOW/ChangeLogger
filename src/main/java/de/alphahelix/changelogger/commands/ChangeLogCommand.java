package de.alphahelix.changelogger.commands;

import de.alphahelix.alphalibary.command.SimpleCommand;
import de.alphahelix.changelogger.inventories.ChangelogInv;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class ChangeLogCommand extends SimpleCommand {
    public ChangeLogCommand() {
        super("changelog", "See the changelogs of this server :).", "cl");
    }

    @Override
    public boolean execute(CommandSender cs, String s, String[] args) {

        if(cs instanceof Player) {
            ChangelogInv.openInventory((Player) cs);
        }

        return true;
    }

    @Override
    public List<String> tabComplete(CommandSender commandSender, String s, String[] strings) {
        return null;
    }
}
