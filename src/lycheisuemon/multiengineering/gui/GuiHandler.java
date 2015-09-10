package lycheisuemon.multiengineering.gui;

import cpw.mods.fml.common.network.IGuiHandler;
import lycheisuemon.multiengineering.tileentity.TileEntityBasicGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler
{
	public GuiHandler()
	{

	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null)
		{
			switch(ID)
			{
			case GuiId.Gui_BasicGenerator:
			if(entity instanceof TileEntityBasicGenerator)
			{
				return new ContainerBasicGenerator(player.inventory, (TileEntityBasicGenerator) entity);
			}
			return null;
			}
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null)
		{
			switch(ID)
			{
			case GuiId.Gui_BasicGenerator:
			if(entity instanceof TileEntityBasicGenerator)
			{
				return new GuiBasicGenerator(player.inventory, (TileEntityBasicGenerator) entity);
			}
			return null;
			}
		}
		return null;
	}
}
