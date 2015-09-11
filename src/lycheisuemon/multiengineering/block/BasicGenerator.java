package lycheisuemon.multiengineering.block;

import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lycheisuemon.multiengineering.main.MultiBlockEngineering;
import lycheisuemon.multiengineering.tileentity.TileEntityBasicGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BasicGenerator extends BlockContainer
{

	@SideOnly(Side.CLIENT)
	private IIcon top;
	@SideOnly(Side.CLIENT)
	private IIcon front;

	private static boolean isBurning;
	private final boolean isBurning2;
	private final Random random = new Random();

	protected BasicGenerator(boolean isActive) {
		super(Material.rock);
		isBurning2 = isActive;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
	{
		this.blockIcon = iconregister.registerIcon("multiengineering:bgene_side");
		this.front = iconregister.registerIcon((this.isBurning2 ? "multiengineering:bgene_fronton" : "multiengineering:bgene_frontoff"));
		this.top = iconregister.registerIcon("multiengineering:bgene_top");
	}

	public IIcon getIcon(int side, int meta) {
		if (side == 1) {
			return top;
		} else if (side == 3) {
			return front;
		} else {
			return this.blockIcon;
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		player.openGui(MultiBlockEngineering.Instance, 0, world, x, y, z);
		return true;
	}

	public Item getItemDropped(int par1, Random random, int par3) {
		return Item.getItemFromBlock(MultiEngineeringBlocks.BlockBasicGeneratorIdle);
	}

	public Item getItem(World world, int par2, int par3, int par4) {
		return Item.getItemFromBlock(MultiEngineeringBlocks.BlockBasicGeneratorIdle);
	}

	/**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World world, int par2)
    {
        return new TileEntityBasicGenerator();
    }


	@SideOnly(Side.CLIENT)
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
		this.direction(world, x, y, z);
	}

	private void direction(World world, int x, int y, int z) {
		if (!world.isRemote) {
			Block direction = world.getBlock(x, y, z - 1);
			Block direction1 = world.getBlock(x, y, z + 1);
			Block direction2 = world.getBlock(x - 1, y, z);
			Block direction3 = world.getBlock(x + 1, y, z);
			byte byte0 = 3;

			if (direction.func_149730_j() && direction.func_149730_j()) {
				byte0 = 3;
			}

			if (direction1.func_149730_j() && direction1.func_149730_j()) {
				byte0 = 2;
			}

			if (direction2.func_149730_j() && direction2.func_149730_j()) {
				byte0 = 5;
			}

			if (direction3.func_149730_j() && direction3.func_149730_j()) {
				byte0 = 4;
			}

			world.setBlockMetadataWithNotify(x, y, z, byte0, 2);
		}
	}

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack)
	{
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if(l == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(l == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if(l == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(l == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}
	}

	public static void updateBlockState(boolean burning, World world, int x, int y, int z) {
		int direction = world.getBlockMetadata(x, y, z);
		TileEntity tileentity = world.getTileEntity(x, y, z);
		isBurning = true;

		if (burning) {
			world.setBlock(x, y, z, MultiEngineeringBlocks.BlockBasicGeneratorActive);
		} else {
			world.setBlock(x, y, z, MultiEngineeringBlocks.BlockBasicGeneratorIdle);
		}

		isBurning = false;
		world.setBlockMetadataWithNotify(x, y, z, direction, 2);

		if (tileentity != null) {
			tileentity.validate();
			world.setTileEntity(x, y, z, tileentity);
		}
	}

	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		if (!isBurning) {
			TileEntityBasicGenerator tileentitytutfurnace = (TileEntityBasicGenerator) world.getTileEntity(x, y, z);

			if (tileentitytutfurnace != null) {
				for (int i = 0; i < tileentitytutfurnace.getSizeInventory(); ++i) {
					ItemStack itemstack = tileentitytutfurnace.getStackInSlot(i);

					if (itemstack != null) {
						float f = this.random.nextFloat() * 0.6F + 0.1F;
						float f1 = this.random.nextFloat() * 0.6F + 0.1F;
						float f2 = this.random.nextFloat() * 0.6F + 0.1F;

						while (itemstack.stackSize > 0) {
							int j = this.random.nextInt(21) + 10;

							if (j > itemstack.stackSize) {
								j = itemstack.stackSize;
							}

							itemstack.stackSize -= j;
							EntityItem entityitem = new EntityItem(world, (double) ((float) x + f), (double) ((float) y + f1), (double) ((float) z + f2), new ItemStack(itemstack.getItem(), j, itemstack.getItemDamage()));

							if (itemstack.hasTagCompound()) {
								entityitem.getEntityItem().setTagCompound(((NBTTagCompound) itemstack.getTagCompound().copy()));
							}

							float f3 = 0.025F;
							entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
							entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.1F);
							entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);
							world.spawnEntityInWorld(entityitem);
						}
					}
				}
				world.func_147453_f(x, y, z, block);
			}
		}
		super.breakBlock(world, x, y, z, block, meta);
	}

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if (this.isBurning2) {
			int direction = world.getBlockMetadata(x, y, z);

			float xx = (float) x + 0.5F, yy = (float) y + random.nextFloat() * 6.0F / 16.0F, zz = (float) z + 0.5F, xx2 = random.nextFloat() * 0.3F - 0.2F, zz2 = 0.5F;

			if (direction == 4) {
				world.spawnParticle("smoke", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
			} else if (direction == 5) {
				world.spawnParticle("smoke", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
			} else if (direction == 3) {
				world.spawnParticle("smoke", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
			} else if (direction == 2) {
				world.spawnParticle("smoke", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
				world.spawnParticle("flame", (double) (xx - zz2), (double) yy, (double) (zz + xx2), 0.0F, 0.0F, 0.0F);
			}
		}
	}

	/*
	private final boolean isActive;

	@SideOnly(Side.CLIENT)
	private IIcon iconFront;

	@SideOnly(Side.CLIENT)
	private IIcon iconTop;

	private static boolean keepInventory;

	public BasicGenerator(boolean isActive)
	{
		super(Material.iron);

		this.isActive = isActive;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconregister)
	{
		this.blockIcon = iconregister.registerIcon("multiengineering:bgene_side");
		this.iconFront = iconregister.registerIcon((this.isActive ? "multiengineering:bgene_fronton" : "multiengineering:bgene_frontoff"));
		this.iconTop = iconregister.registerIcon("multiengineering:bgene_top");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata)
	{
		//return metadata == 0 && side == 3 ? this.iconFront : (side == metadata ? this.iconFront : this.blockIcon);
		//return side == 1 ? this.iconTop : side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side != metadata? this.blockIcon : this.iconFront));
		return side == 1 ? this.iconTop : (side == 0 ? this.iconTop : (side != metadata ? this.blockIcon : this.iconFront));
	}

	public Item getItemDropped(World world, int x, int y, int z)
	{
		return Item.getItemFromBlock(MultiEngineeringBlocks.BlockBasicGeneratorIdle);
	}

	public void onBlockAdded(World world, int x, int y, int z)
	{
		super.onBlockAdded(world, x, y, z);
		this.setDefaultDirection(world, x, y, z);
	}

	private void setDefaultDirection(World world, int x, int y, int z)
	{
		if(!world.isRemote)
		{
			Block b1 = world.getBlock(x, y, z - 1);
			Block b2 = world.getBlock(x, y, z + 1);
			Block b3 = world.getBlock(x - 1, y, z);
			Block b4 = world.getBlock(x + 1, y, z);

			byte b0 = 3;

			if(b1.func_149730_j() && !b2.func_149730_j())
			{
				b0 = 3;

			}
			if(b2.func_149730_j() && !b1.func_149730_j())
			{
				b0 = 2;

			}
			if(b3.func_149730_j() && !b4.func_149730_j())
			{
				b0 = 5;

			}
			if(b4.func_149730_j() && !b3.func_149730_j())
			{
				b0 = 4;

			}

			world.setBlockMetadataWithNotify(x, y, z, b0, 2);
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ)
	{
		if(!world.isRemote)
		{
			FMLNetworkHandler.openGui(player, MultiBlockEngineering.Instance, GuiId.Gui_BasicGenerator, world, x, y, z);
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i)
	{
		return new TileEntityBasicGenerator();
	}

	//TODO randomDisplayTick

	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entityplayer, ItemStack itemstack)
	{
		int l = MathHelper.floor_double((double)(entityplayer.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

		if(l == 0)
		{
			world.setBlockMetadataWithNotify(x, y, z, 2, 2);
		}
		if(l == 1)
		{
			world.setBlockMetadataWithNotify(x, y, z, 5, 2);
		}
		if(l == 2)
		{
			world.setBlockMetadataWithNotify(x, y, z, 3, 2);
		}
		if(l == 3)
		{
			world.setBlockMetadataWithNotify(x, y, z, 4, 2);
		}

		if(itemstack.hasDisplayName())
		{
			((TileEntityBasicGenerator)world.getTileEntity(x, y, z)).setGuiDisplayName(itemstack.getDisplayName());
		}
	}

	public static void updateBasicGeneratorState(boolean active, World worldObj, int xCoord, int yCoord, int zCoord)
	{
		int i = worldObj.getBlockMetadata(xCoord, yCoord, zCoord);

		TileEntity tileentity = worldObj.getTileEntity(xCoord, yCoord, zCoord);
		keepInventory = true;

		if(active)
		{
			worldObj.setBlock(xCoord, yCoord, zCoord, MultiEngineeringBlocks.BlockBasicGeneratorActive);
		}else{
			worldObj.setBlock(xCoord, yCoord, zCoord, MultiEngineeringBlocks.BlockBasicGeneratorIdle);
		}

		keepInventory = false;

		worldObj.setBlockMetadataWithNotify(xCoord, yCoord, zCoord, i, 2);

		if(tileentity != null)
		{
			tileentity.validate();
			worldObj.setTileEntity(xCoord, yCoord, zCoord, tileentity);
		}
	}

	public static void updateBlockState(boolean b, World worldObj, int xCoord, int yCoord, int zCoord) {
		// TODO 自動生成されたメソッド・スタブ

	}
	*/
}
