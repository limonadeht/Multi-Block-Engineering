package lycheisuemon.multiengineering.block;

import cpw.mods.fml.common.registry.GameRegistry;
import lycheisuemon.multiengineering.main.MultiBlockEngineering;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MultiEngineeringBlocks
{
	public static Block BlockSampleDuct;
	public static Block BlockGasTank;

	public static void registerMultiEngineeringBlocks()
	{
		BlockSampleDuct = new BlockSampleDuct(Material.rock).setCreativeTab(MultiBlockEngineering.tabMultiEngineering);
		GameRegistry.registerBlock(BlockSampleDuct, "SampleDuct");

		BlockGasTank = new BlockSimpleTankMk1().setCreativeTab(MultiBlockEngineering.tabMultiEngineering);
		GameRegistry.registerBlock(BlockGasTank, "Gas Tank");
	}
}
