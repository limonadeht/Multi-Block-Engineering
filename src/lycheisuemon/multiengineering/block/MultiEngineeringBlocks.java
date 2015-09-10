package lycheisuemon.multiengineering.block;

import cpw.mods.fml.common.registry.GameRegistry;
import lycheisuemon.multiengineering.main.MultiBlockEngineering;
import lycheisuemon.multiengineering.tileentity.TileEntityBasicGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class MultiEngineeringBlocks
{
	public static Block BlockSampleDuct;
	public static Block BlockBasicGeneratorIdle;
	public static Block BlockBasicGeneratorActive;

	public static void registerMultiEngineeringBlocks()
	{
		BlockSampleDuct = new BlockSampleDuct(Material.rock).setCreativeTab(MultiBlockEngineering.tabMultiEngineering);
		GameRegistry.registerBlock(BlockSampleDuct, "SampleDuct");

		BlockBasicGeneratorIdle = new BasicGenerator(false).setBlockName("Basic Generator").setCreativeTab(MultiBlockEngineering.tabMultiEngineering);
		GameRegistry.registerBlock(BlockBasicGeneratorIdle, "BlockBasicGeneratorIdle");

		BlockBasicGeneratorActive = new BasicGenerator(true).setBlockName("Basic Generator Active").setLightLevel(0.625F);
		GameRegistry.registerBlock(BlockBasicGeneratorActive, "BlockBasicGeneratorActive");

		//TileEntityのregisterしちゃう？しちゃう！
		GameRegistry.registerTileEntity(TileEntityBasicGenerator.class, "Basic Generator");
	}
}
