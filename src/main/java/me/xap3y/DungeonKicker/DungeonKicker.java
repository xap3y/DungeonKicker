package me.xap3y.DungeonKicker;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = DungeonKicker.MODID, version = DungeonKicker.VERSION)
public class DungeonKicker
{
    public static final String MODID = "DungeonKicker";
    public static final String VERSION = "1.0";
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new ChatEventHandler());
    }
}
