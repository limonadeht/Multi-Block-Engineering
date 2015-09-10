package lycheisuemon.multiengineering.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;
import lycheisuemon.multiengineering.block.BasicGenerator;
import lycheisuemon.multiengineering.item.MultiEngineeringItems;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBasicGenerator extends TileEntity implements ISidedInventory
{
	private String localizedName;

	private static final int[] slots_top = new int[]{0};
	private static final int[] slots_bottom = new int[]{2, 1};
	private static final int[] slots_side = new int[]{1};

	private ItemStack[] slots = new ItemStack [3];

	public int furnaceSpeed = 150;
	public int burnTime;
	public int currentItemBurnTime;
	public int cookTime;

	public void setGuiDisplayName(String displayname)
	{
		this.localizedName = displayname;
	}

	public String getInventoryName()
	{
		return this.hasCustomInventoryName() ? this.localizedName : "container.basicGenerator";
	}

	public boolean hasCustomInventoryName()
	{
		return this.localizedName != null && this.localizedName.length() > 0;
	}

	public int getSizeInventory()
	{
		return this.slots.length;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_)
	{
		return null;
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_)
	{
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_)
	{
		return null;
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_)
	{

	}

	@Override
	public int getInventoryStackLimit()
	{
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_)
	{
		return false;
	}

	@Override
	public void openInventory()
	{
	}

	@Override
	public void closeInventory()
	{
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack itemstack)
	{
		return i == 2 ? false : (i == 1 ? isItemFuel(itemstack) : true);
	}

	public static boolean isItemFuel(ItemStack itemstack)
	{
		return getItemBurnTime(itemstack) > 0;
	}

	private static int getItemBurnTime(ItemStack itemstack)
	{
		if(itemstack == null)
		{
			return 0;
		}else{
			Item item = itemstack.getItem();

			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
			{
				Block block = Block.getBlockFromItem(item);

				if(item == MultiEngineeringItems.SampleTCTools) return 800;
				if(item == Items.coal) return 1600;
				if(item == Items.stick) return 100;
				if(item == Items.lava_bucket) return 20000;
				if(block == Blocks.sapling) return 100;
				if(item == Items.blaze_rod) return 2400;
				if(block == Blocks.coal_block) return 14400;

				return GameRegistry.getFuelValue(itemstack);
			}
		}
		return 0;
	}

	public void updateEntity()
	{
		boolean flag = this.burnTime > 0;
		boolean flag1 = false;

		if(this.isBurning())
		{
			this.burnTime--;
		}
		if(this.worldObj.isRemote)
		{
			if(this.burnTime == 0 && this.canSmelt())
			{
				this.currentItemBurnTime = this.burnTime = getItemBurnTime(this.slots[1]);

				if(this.isBurning())
				{
					flag1 = true;

					if(this.slots[1] != null)
					{
						this.slots[1].stackSize--;

						if(this.slots[1].stackSize == 0)
						{
							this.slots[1] = this.slots[1].getItem().getContainerItem(this.slots[1]);
						}
					}
				}
			}

			if(this.isBurning() && this.canSmelt())
			{
				this.cookTime++;

				if(this.cookTime == this.furnaceSpeed)
				{
					this.cookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			}else{
				this.cookTime = 0;
			}

			if(flag != this.isBurning())
			{
				flag1 = true;
				BasicGenerator.updateBasicGeneratorState(this.burnTime > 0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
			}
		}
		if(flag1)
		{
			this.markDirty();
		}
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int var1)
	{
		return var1 == 0 ? slots_bottom : (var1 == 1 ? slots_top : slots_side);
	}

	@Override
	public boolean canInsertItem(int i, ItemStack itemstack, int var3)
	{
		return this.isItemValidForSlot(i, itemstack);
	}

	@Override
	public boolean canExtractItem(int i, ItemStack itemstack, int j)
	{
		return j != 0 || i != 1 || itemstack.getItem() == Items.bucket;
	}
}
