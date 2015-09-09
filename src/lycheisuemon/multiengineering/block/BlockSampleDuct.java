package lycheisuemon.multiengineering.block;

import cofh.api.transport.IItemDuct;
import lycheisuemon.multiengineering.main.MultiBlockEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.ForgeDirection;

public class BlockSampleDuct extends Block implements IItemDuct{

	public BlockSampleDuct(Material material)
	{
		super(material);
		setBlockName("SampleDuct");
		setCreativeTab(MultiBlockEngineering.tabMultiEngineering);
	}

	@Override
	public ItemStack insertItem(ForgeDirection from, ItemStack item)
	{
		return null;
	}

}
