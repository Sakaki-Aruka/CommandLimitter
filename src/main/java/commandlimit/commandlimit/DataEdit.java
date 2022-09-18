package commandlimit.commandlimit;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import static commandlimit.commandlimit.SettingsLoad.freePlayers;
import static commandlimit.commandlimit.SettingsLoad.unlockBlocks;

public class DataEdit implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command,String label,String[] args){

        if(args[0].equalsIgnoreCase("show") && args.length==2){
            //show
            String settingsKey = args[1];
            if(settingsKey.equalsIgnoreCase("players")){
                sender.sendMessage("[Limit edit]:"+freePlayers);
            }else if(settingsKey.equalsIgnoreCase("blocks")){
                sender.sendMessage("[Limit edit]:"+unlockBlocks);
            }
            return true;


        }else if(args[0].equalsIgnoreCase("edit") && args.length==4){
            //edit
            if(args[1].equalsIgnoreCase("players") && args[2].equalsIgnoreCase("add")){
                freePlayers.add(0,args[3]);
                sender.sendMessage("[Limit edit]:"+freePlayers);
                return true;
            }else if(args[1].equalsIgnoreCase("players") && args[2].equalsIgnoreCase("remove") && freePlayers.contains(args[3])){
                freePlayers.remove(args[3]);
                sender.sendMessage("[Limit edit]:"+freePlayers);
                return true;
            }else if(args[1].equalsIgnoreCase("players") && args[2].equalsIgnoreCase("clear") && args[3].equalsIgnoreCase("all")){
                freePlayers.clear();
                sender.sendMessage("[Limit edit]:"+freePlayers);
            }
            return false;

        }else{
            return false;
        }
    }
}
