package lycheisuemon.multiengineering.gui;

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
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3)
	{

	}
}
