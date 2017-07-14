package de.alphahelix.changelogger;

import de.alphahelix.alphalibary.AlphaLibary;
import de.alphahelix.alphalibary.mysql.JSONDatabase;
import de.alphahelix.alphalibary.mysql.MySQLAPI;
import de.alphahelix.changelogger.commands.ChangeLogCommand;
import de.alphahelix.changelogger.files.ChangelogFile;
import de.alphahelix.changelogger.files.OptionsFile;
import de.alphahelix.changelogger.inventories.ChangelogInv;

public class ChangeLogger extends AlphaLibary {

    private static ChangeLogger instance;
    
    private static JSONDatabase jDB;

    private static OptionsFile optionsFile;
    private static ChangelogFile changelogFile;

    public static ChangeLogger getInstance() {
        return instance;
    }

    public static ChangelogFile getChangelogFile() {
        return changelogFile;
    }

    public static OptionsFile getOptionsFile() {
        return optionsFile;
    }
    
    public static JSONDatabase getJDB () {
        return jDB;
    }
    
    @Override
    public void onEnable () {
        super.onEnable();
        instance = this;
        optionsFile = new OptionsFile();
        
        if(optionsFile.getMySQL()) {
            for(MySQLAPI api : MySQLAPI.getMysqlDBs()) {
                api.initMySQLAPI();
                jDB = new JSONDatabase(JSONDatabase.UniqueIdentifier.NAME, "Changelog", api.getDatabase());
                break;
            }
        }
        
        changelogFile = new ChangelogFile();
        
        new ChangeLogCommand();
        
        ChangelogInv.fillInventory();
    }
}
