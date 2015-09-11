package lycheisuemon.multiengineering.block;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lycheisuemon.multiengineering.main.MultiBlockEngineering;
import lycheisuemon.multiengineering.tileentity.TileEntityLightingBlock;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockLighting extends BlockContainer
{

	public BlockLighting(Material material)
	{
		super(material);
		this.setHardness(2.0F);
		this.setResistance(5.0F);
		this.setLightLevel(0.7F);
		this.setCreativeTab(MultiBlockEngineering.tabMultiEngineering);
	}

	@SideOnly(Side.CLIENT)
	public void addInfomation(ItemStack itemstack, EntityPlayer player, List list, boolean b)
	{
		list.add("addinfomation method test.");
	}

	public int getRenderType()
	{
		return -1;
	}

	public boolean isOpaqueCube()
	{
		return false;
	}

	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
	{
		return new TileEntityLightingBlock();
	}
}
