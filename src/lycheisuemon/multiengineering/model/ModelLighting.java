package lycheisuemon.multiengineering.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLighting extends ModelBase
{
	public static ModelLighting instance = new ModelLighting();

  //fields
    ModelRenderer LightMain;
    ModelRenderer LightBase;
    ModelRenderer LightStick1;
    ModelRenderer LightStick2;
    ModelRenderer LightStick3;
    ModelRenderer LightStick4;
    ModelRenderer LightRoof;
    ModelRenderer LiughtRod1;
    ModelRenderer LightRod2;
    ModelRenderer LightRod3;
    ModelRenderer LightRod4;

  public ModelLighting()
  {
    textureWidth = 64;
    textureHeight = 32;

      LightMain = new ModelRenderer(this, 0, 8);
      LightMain.addBox(0F, 0F, 0F, 4, 7, 4);
      LightMain.setRotationPoint(-2F, 16F, -2F);
      LightMain.setTextureSize(64, 32);
      LightMain.mirror = true;
      setRotation(LightMain, 0F, 0F, 0F);
      LightBase = new ModelRenderer(this, 0, 21);
      LightBase.addBox(0F, 0F, 0F, 10, 1, 10);
      LightBase.setRotationPoint(-5F, 23F, -5F);
      LightBase.setTextureSize(64, 32);
      LightBase.mirror = true;
      setRotation(LightBase, 0F, 0F, 0F);
      LightStick1 = new ModelRenderer(this, 0, 24);
      LightStick1.addBox(0F, 0F, 0F, 1, 7, 1);
      LightStick1.setRotationPoint(-4F, 16F, 3F);
      LightStick1.setTextureSize(64, 32);
      LightStick1.mirror = true;
      setRotation(LightStick1, 0F, 0F, 0F);
      LightStick2 = new ModelRenderer(this, 0, 24);
      LightStick2.addBox(0F, 0F, 0F, 1, 7, 1);
      LightStick2.setRotationPoint(-4F, 16F, -4F);
      LightStick2.setTextureSize(64, 32);
      LightStick2.mirror = true;
      setRotation(LightStick2, 0F, 0F, 0F);
      LightStick3 = new ModelRenderer(this, 0, 24);
      LightStick3.addBox(0F, 0F, 0F, 1, 7, 1);
      LightStick3.setRotationPoint(3F, 16F, -4F);
      LightStick3.setTextureSize(64, 32);
      LightStick3.mirror = true;
      setRotation(LightStick3, 0F, 0F, 0F);
      LightStick4 = new ModelRenderer(this, 0, 24);
      LightStick4.addBox(0F, 0F, 0F, 1, 7, 1);
      LightStick4.setRotationPoint(3F, 16F, 3F);
      LightStick4.setTextureSize(64, 32);
      LightStick4.mirror = true;
      setRotation(LightStick4, 0F, 0F, 0F);
      LightRoof = new ModelRenderer(this, 0, 21);
      LightRoof.addBox(0F, 0F, 0F, 10, 1, 10);
      LightRoof.setRotationPoint(-5F, 15F, -5F);
      LightRoof.setTextureSize(64, 32);
      LightRoof.mirror = true;
      setRotation(LightRoof, 0F, 0F, 0F);
      LiughtRod1 = new ModelRenderer(this, 0, 30);
      LiughtRod1.addBox(0F, 0F, 0F, 1, 1, 1);
      LiughtRod1.setRotationPoint(-1F, 13F, -1F);
      LiughtRod1.setTextureSize(64, 32);
      LiughtRod1.mirror = true;
      setRotation(LiughtRod1, 0F, 0F, 0F);
      LightRod2 = new ModelRenderer(this, 0, 30);
      LightRod2.addBox(0F, 0F, 0F, 1, 1, 1);
      LightRod2.setRotationPoint(-1F, 14F, -2F);
      LightRod2.setTextureSize(64, 32);
      LightRod2.mirror = true;
      setRotation(LightRod2, 0F, 0F, 0F);
      LightRod3 = new ModelRenderer(this, 0, 30);
      LightRod3.addBox(0F, 0F, 0F, 1, 1, 1);
      LightRod3.setRotationPoint(-1F, 13F, 0F);
      LightRod3.setTextureSize(64, 32);
      LightRod3.mirror = true;
      setRotation(LightRod3, 0F, 0F, 0F);
      LightRod4 = new ModelRenderer(this, 0, 30);
      LightRod4.addBox(0F, 0F, 0F, 1, 1, 1);
      LightRod4.setRotationPoint(-1F, 14F, 1F);
      LightRod4.setTextureSize(64, 32);
      LightRod4.mirror = true;
      setRotation(LightRod4, 0F, 0F, 0F);
  }

  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    LightMain.render(f5);
    LightBase.render(f5);
    LightStick1.render(f5);
    LightStick2.render(f5);
    LightStick3.render(f5);
    LightStick4.render(f5);
    LightRoof.render(f5);
    LiughtRod1.render(f5);
    LightRod2.render(f5);
    LightRod3.render(f5);
    LightRod4.render(f5);
  }

  public void renderModel(float f)
  {
	  LightMain.render(f);;
	  LightBase.render(f);;
	  LightStick1.render(f);;
	  LightStick2.render(f);;
	  LightStick3.render(f);;
	  LightStick4.render(f);;
	  LightRoof.render(f);;
	  LiughtRod1.render(f);;
	  LightRod2.render(f);;
	  LightRod3.render(f);;
	  LightRod4.render(f);;
  }

  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }

  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}

