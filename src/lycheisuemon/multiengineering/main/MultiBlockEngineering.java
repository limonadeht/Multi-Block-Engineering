package lycheisuemon.multiengineering.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = MultiBlockEngineering.MOD_ID, version = MultiBlockEngineering.VERSION, useMetadata = true)
public class MultiBlockEngineering
{
	@Mod.Instance("MultiBlockEngineering")
	//INSTANCE
	public static MultiBlockEngineering instance;
	public static final String MOD_ID = "MultiBlockEngineering";
	public static final String VERSION = "Alpha-1.0";

	//CREATIVETABS
	public static final CreativeTabs tabAdvTorch = new MultiBlockEngineeringTab("MultiBlockEngineering");

	@EventHandler
    public void preInit( FMLPreInitializationEvent e )
    {

    }

	@EventHandler
    public void Init( FMLInitializationEvent e )
    {

    }
}
