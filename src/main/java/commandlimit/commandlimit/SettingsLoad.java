package commandlimit.commandlimit;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.ArrayList;
import java.util.Arrays;

public class SettingsLoad {
    public static FileConfiguration FC;

    public void FC(FileConfiguration fileConfiguration){
        FC = fileConfiguration;
        this.loads();
    }

    public static ArrayList<String> limitCommandsAll;
    public static ArrayList<String> limitCommandsPattern;
    public static ArrayList<String> unlockBlocks;
    public static ArrayList<String> freePlayers;
    public static ArrayList<String> warnMessages;
    public static ArrayList<String> unlockMessages;

    private void loads(){
        limitCommandsAll = new ArrayList<>(Arrays.asList(FC.getString("limitCommands.all").split(",")));
        limitCommandsPattern = new ArrayList<>(Arrays.asList(FC.getString("limitCommands.pattern").split(",")));

        unlockBlocks = new ArrayList<>(Arrays.asList(FC.getString("blocks").split(",")));
        freePlayers = new ArrayList<>(Arrays.asList(FC.getString("freePlayers").split(",")));

        warnMessages = new ArrayList<>(Arrays.asList(FC.getString("warnMessages").split("!&!")));
        unlockMessages = new ArrayList<>(Arrays.asList(FC.getString("unlockMessages").split("!&!")));


    }
}
