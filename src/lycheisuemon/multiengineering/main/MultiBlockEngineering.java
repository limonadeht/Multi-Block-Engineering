package lycheisuemon.multiengineering.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import lycheisuemon.multiengineering.block.MultiEngineeringBlocks;
import lycheisuemon.multiengineering.item.MultiEngineeringItems;
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
	public static final CreativeTabs tabMultiEngineering = new MultiBlockEngineeringTab("MultiBlockEngineering");

	@EventHandler
    public void preInit( FMLPreInitializationEvent e )
    {
		MultiEngineeringItems.registerMultiEngineeringItems();
		MultiEngineeringBlocks.registerMultiEngineeringBlocks();
    }

	@EventHandler
    public void Init( FMLInitializationEvent e )
    {

    }
}
