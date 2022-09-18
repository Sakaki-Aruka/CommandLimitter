package commandlimit.commandlimit;

import org.bukkit.event.block.BlockBreakEvent;

import static commandlimit.commandlimit.SettingsLoad.*;

public class BlockBreak {
    public void blockBreakMain(BlockBreakEvent event){
        try{
            String name = event.getPlayer().getName();
            String blockID = event.getBlock().getType().name();
            if(!(freePlayers.contains(name)) && unlockBlocks.contains(blockID)){
                freePlayers.add(name);

                for(String loop : unlockMessages){
                    event.getPlayer().sendMessage(loop);
                }
                return;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
