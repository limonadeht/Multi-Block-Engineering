package lycheisuemon.multiengineering.main;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import lycheisuemon.multiengineering.block.MultiEngineeringBlocks;
import lycheisuemon.multiengineering.gui.GuiHandler;
import lycheisuemon.multiengineering.item.MultiEngineeringItems;
import lycheisuemon.multiengineering.proxy.ServerProxy;
import net.minecraft.creativetab.CreativeTabs;

@Mod(modid = MultiBlockEngineering.MOD_ID, version = MultiBlockEngineering.VERSION, useMetadata = true)
public class MultiBlockEngineering
{
	@Mod.Instance("MultiBlockEngineering")
	//INSTANCE
	public static MultiBlockEngineering Instance;
	public static final String MOD_ID = "MultiBlockEngineering";
	public static final String VERSION = "Alpha-1.0";

	@SidedProxy(clientSide = "lycheisuemon.multiengineering.proxy.ClientProxy", serverSide = "lycheisuemon.multiengineering.proxy.ServerProxy")
	public static ServerProxy serverproxy;

	//CREATIVETABS
	public static final CreativeTabs tabMultiEngineering = new MultiBlockEngineeringTab("MultiBlockEngineering");

	@EventHandler
    public void preInit( FMLPreInitializationEvent e )
    {
		MultiEngineeringItems.registerMultiEngineeringItems();
		MultiEngineeringBlocks.registerMultiEngineeringBlocks();

		serverproxy.registerRenderThings();
		serverproxy.registerTileEntitySpecialRenderer();

		NetworkRegistry.INSTANCE.registerGuiHandler(MultiBlockEngineering.Instance, new GuiHandler());
    }

	@EventHandler
    public void Init( FMLInitializationEvent e )
    {
    }
}
