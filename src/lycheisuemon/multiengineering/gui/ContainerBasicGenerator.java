package lycheisuemon.multiengineering.gui;

import lycheisuemon.multiengineering.tileentity.TileEntityBasicGenerator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class ContainerBasicGenerator extends Container
{
	private TileEntityBasicGenerator basicGenerator;

	public ContainerBasicGenerator(InventoryPlayer inventory, TileEntityBasicGenerator entity)
	{
		this.basicGenerator = entity;
	}

	@Override
	public boolean canInteractWith(EntityPlayer var1)
	{
		return false;
	}
}
