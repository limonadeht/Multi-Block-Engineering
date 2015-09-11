package lycheisuemon.multiengineering.item;

import cpw.mods.fml.common.registry.GameRegistry;
import lycheisuemon.multiengineering.main.MultiBlockEngineering;
import net.minecraft.item.Item;

public class MultiEngineeringItems
{
	public static Item SampleTCTools;
	public static Item ItemTooltipTest;

	public static void registerMultiEngineeringItems()
	{
		SampleTCTools = new ItemSampleTCTools().setUnlocalizedName("ItemSampleTCTools");
		GameRegistry.registerItem(SampleTCTools, "ItemSampleTCTools");

		ItemTooltipTest = new ItemTooltipTest().setCreativeTab(MultiBlockEngineering.tabMultiEngineering);
		GameRegistry.registerItem(ItemTooltipTest, "ItemTooltipTest");
	}
}
