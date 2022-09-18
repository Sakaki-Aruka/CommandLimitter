package commandlimit.commandlimit;

import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static commandlimit.commandlimit.SettingsLoad.*;

public class PreProcess {
    public void preProcessMain(PlayerCommandPreprocessEvent event){

        //debug
        event.getPlayer().sendMessage("ct:"+new ArrayList<String>(Arrays.asList(event.getMessage())).get(0));

        for(String loop : limitCommandsAll){
            this.sub(event,loop,true);
        }
        for(String loop : limitCommandsPattern){
            this.sub(event,loop,false);
        }
    }

    public void sub(PlayerCommandPreprocessEvent event,String loop,boolean all){
        if((event.getMessage().equalsIgnoreCase(loop) && all) || (event.getMessage().contains(loop) && !all)){

            //debug
            event.getPlayer().sendMessage("contains");

            if(!(freePlayers.contains(event.getPlayer().getName()))){
                event.setCancelled(true);

                for(String loop2 : warnMessages){
                    event.getPlayer().sendMessage(loop2);
                }

                return;
            }
        }
    }
}
