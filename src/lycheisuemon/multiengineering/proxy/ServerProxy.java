package lycheisuemon.multiengineering.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import lycheisuemon.multiengineering.main.MultiBlockEngineering;
import lycheisuemon.multiengineering.tileentity.TileEntityLightingBlock;

public class ServerProxy
{
	public void registerRenderThings()
	{

	}

	public void registerTileEntitySpecialRenderer()
	{
		GameRegistry.registerTileEntity(TileEntityLightingBlock.class, MultiBlockEngineering.MOD_ID + ":BlockLighting");
	}
}
