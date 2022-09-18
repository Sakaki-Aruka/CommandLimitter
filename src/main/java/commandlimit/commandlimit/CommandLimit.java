package commandlimit.commandlimit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import static commandlimit.commandlimit.SettingsLoad.*;

public final class CommandLimit extends JavaPlugin implements CommandExecutor {

    public void load(){
        new SettingsLoad().FC(getConfig());
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.load();
        getServer().getPluginManager().registerEvents(new Events(),this);
        getCommand("commandlimitreload").setExecutor(this);
        getCommand("limitedit").setExecutor(new DataEdit());

    }

    @Override
    public void onDisable() {
        this.configWrite();
    }

    public void configWrite(){
        String StrFreePlayers = String.join(",",freePlayers);
        FC.set("freePlayers",StrFreePlayers);
        saveConfig();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){
        if(sender instanceof Player){
            if(!(sender.isOp())){
                return false;
            }
        }

        this.configWrite();

        // clear all arrayList
        freePlayers.clear();
        limitCommandsAll.clear();
        limitCommandsPattern.clear();
        unlockBlocks.clear();
        warnMessages.clear();
        unlockMessages.clear();
        reloadConfig();
        this.load();

        return true;
    }
}
