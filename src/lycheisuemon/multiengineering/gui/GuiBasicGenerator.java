package lycheisuemon.multiengineering.gui;

import org.lwjgl.opengl.GL11;

import lycheisuemon.multiengineering.tileentity.TileEntityBasicGenerator;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiBasicGenerator extends GuiContainer
{
	public static final ResourceLocation bground = new ResourceLocation("multiengineering", "textures/gui/basicgenerator_gui.png");

	public TileEntityBasicGenerator basicGenerator;

	public GuiBasicGenerator(InventoryPlayer inventoryplayer, TileEntityBasicGenerator entity) {
		super(new ContainerBasicGenerator(inventoryplayer, entity));

		this.basicGenerator = entity;

		this.xSize = 176;
		this.ySize = 166;
	}

	public void drawGuiContainerforegroundLayer(int par, int par2)
	{
		String name = this.basicGenerator.hasCustomInventoryName() ? this.basicGenerator.getInventoryName() : I18n.format(this.basicGenerator.getInventoryName(), new Object[0]);

		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2,  6, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory", new Object[0]), 128, this.ySize - 96 + 2, 4210752);

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
		 GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
	        this.mc.getTextureManager().bindTexture(bground);
	        int k = (this.width - this.xSize) / 2;
	        int l = (this.height - this.ySize) / 2;
	        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	        int i1;

	        if (this.basicGenerator.isBurning())
	        {
	            i1 = this.basicGenerator.getBurnTimeRemainingScaled(12);
	            this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1, 14, i1 + 2);
	        }

	        i1 = this.basicGenerator.getCookProgressScaled(24);
	        this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
	}
}
