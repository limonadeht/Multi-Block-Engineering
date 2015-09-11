package lycheisuemon.multiengineering.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import lycheisuemon.multiengineering.render.RenderLighting;
import lycheisuemon.multiengineering.tileentity.TileEntityLightingBlock;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class ClientProxy extends ServerProxy
{
	public void registerRenderThings()
	{
		//Lighting
		TileEntitySpecialRenderer render = new RenderLighting();
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLightingBlock.class, render);
	}

	public void registerTileEntitySpecialRenderer()
	{

	}
}
