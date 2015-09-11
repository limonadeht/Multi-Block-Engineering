package lycheisuemon.multiengineering.item;

import java.util.List;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lycheisuemon.multiengineering.main.MultiBlockEngineering;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemTooltipTest extends Item
{
	public ItemTooltipTest()
	{
		this.setCreativeTab(MultiBlockEngineering.tabMultiEngineering);
	}

	@SideOnly(Side.CLIENT)
	public void addInfomation(ItemStack itemstack, EntityPlayer player, List list, boolean b)
	{
		list.add("addinfomation method test.");
	}
}
