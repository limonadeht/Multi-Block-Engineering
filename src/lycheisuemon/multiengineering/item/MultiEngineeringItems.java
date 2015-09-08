package lycheisuemon.multiengineering.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class MultiEngineeringItems
{
	public static Item SampleTCTools;

	public static void registerMultiEngineeringItems()
	{
		SampleTCTools = new ItemSampleTCTools().setUnlocalizedName("ItemSampleTCTools");
		GameRegistry.registerItem(SampleTCTools, "ItemSampleTCTools");
	}
}
