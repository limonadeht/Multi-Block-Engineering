package lycheisuemon.multiengineering.item;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lycheisuemon.multiengineering.main.MultiBlockEngineering;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import thaumcraft.api.IScribeTools;

public class ItemSampleTCTools extends Item implements IScribeTools
{
	@SideOnly(Side.CLIENT)
    public IIcon icon;

	public ItemSampleTCTools()
	{
		maxStackSize = 0;
		canRepair = false;
		setMaxDamage(100);
		setCreativeTab(MultiBlockEngineering.tabMultiEngineering);
		setHasSubtypes(false);
	}

	@SideOnly(Side.CLIENT)
    @Override
    public void registerIcons(IIconRegister ir) {
        this.icon = ir.registerIcon("forbidden:primewell");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public IIcon getIconFromDamage(int par1) {
        return this.icon;
    }

    @Override
    public EnumRarity getRarity(ItemStack stack){
        return EnumRarity.epic;
    }

    @Override
    public void setDamage(ItemStack stack, int damage){
        super.setDamage(stack, 0);
    }
}
