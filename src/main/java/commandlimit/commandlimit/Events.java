package commandlimit.commandlimit;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Events implements Listener {
    @EventHandler
    public void onCommandPreProcess(PlayerCommandPreprocessEvent event){
        new PreProcess().preProcessMain(event);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event){
        new BlockBreak().blockBreakMain(event);
    }
}
