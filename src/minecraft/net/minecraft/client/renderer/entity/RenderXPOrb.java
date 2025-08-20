package net.minecraft.client.renderer.entity;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import optifine.Config;
import optifine.CustomColors;

public class RenderXPOrb extends Render {
   private static final ResourceLocation experienceOrbTextures = new ResourceLocation("textures/entity/experience_orb.png");
   private static final String __OBFID = "CL_00000993";

   public RenderXPOrb(RenderManager renderManagerIn) {
      super(renderManagerIn);
      this.shadowSize = 0.15F;
      this.shadowOpaque = 0.75F;
   }

   public void doRender(EntityXPOrb entity, double x, double y, double z, float entityYaw, float partialTicks) {
      GlStateManager.pushMatrix();
      GlStateManager.translate((float)x, (float)y, (float)z);
      this.bindEntityTexture(entity);
      int i = entity.getTextureByXP();
      float f = (float)(i % 4 * 16 + 0) / 64.0F;
      float f1 = (float)(i % 4 * 16 + 16) / 64.0F;
      float f2 = (float)(i / 4 * 16 + 0) / 64.0F;
      float f3 = (float)(i / 4 * 16 + 16) / 64.0F;
      float f4 = 1.0F;
      float f5 = 0.5F;
      float f6 = 0.25F;
      int j = entity.getBrightnessForRender(partialTicks);
      int k = j % 65536;
      int l = j / 65536;
      OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)k / 1.0F, (float)l / 1.0F);
      GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
      float f7 = 255.0F;
      float f8 = ((float)entity.xpColor + partialTicks) / 2.0F;
      l = (int)((MathHelper.sin(f8 + 0.0F) + 1.0F) * 0.5F * 255.0F);
      boolean flag = true;
      int i1 = (int)((MathHelper.sin(f8 + ((float) (Math.PI * 4.0 / 3.0))) + 1.0F) * 0.1F * 255.0F);
      GlStateManager.rotate(180.0F - this.renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
      GlStateManager.rotate(-this.renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
      float f9 = 0.3F;
      GlStateManager.scale(0.3F, 0.3F, 0.3F);
      Tessellator tessellator = Tessellator.getInstance();
      WorldRenderer worldrenderer = tessellator.getWorldRenderer();
      worldrenderer.begin(7, DefaultVertexFormats.POSITION_TEX_COLOR_NORMAL);
      int j1 = l;
      int k1 = 255;
      int l1 = i1;
      if (Config.isCustomColors()) {
         int i2 = CustomColors.getXpOrbColor(f8);
         if (i2 >= 0) {
            j1 = i2 >> 16 & 0xFF;
            k1 = i2 >> 8 & 0xFF;
            l1 = i2 >> 0 & 0xFF;
         }
      }

      worldrenderer.pos((double)(0.0F - f5), (double)(0.0F - f6), 0.0).tex((double)f, (double)f3).color(j1, k1, l1, 128).normal(0.0F, 1.0F, 0.0F).endVertex();
      worldrenderer.pos((double)(f4 - f5), (double)(0.0F - f6), 0.0).tex((double)f1, (double)f3).color(j1, k1, l1, 128).normal(0.0F, 1.0F, 0.0F).endVertex();
      worldrenderer.pos((double)(f4 - f5), (double)(1.0F - f6), 0.0).tex((double)f1, (double)f2).color(j1, k1, l1, 128).normal(0.0F, 1.0F, 0.0F).endVertex();
      worldrenderer.pos((double)(0.0F - f5), (double)(1.0F - f6), 0.0).tex((double)f, (double)f2).color(j1, k1, l1, 128).normal(0.0F, 1.0F, 0.0F).endVertex();
      tessellator.draw();
      GlStateManager.disableBlend();
      GlStateManager.disableRescaleNormal();
      GlStateManager.popMatrix();
      super.doRender(entity, x, y, z, entityYaw, partialTicks);
   }

   protected ResourceLocation getEntityTexture(EntityXPOrb entity) {
      return experienceOrbTextures;
   }

   @Override
   protected ResourceLocation getEntityTexture(Entity entity) {
      return this.getEntityTexture((EntityXPOrb)entity);
   }

   @Override
   public void doRender(Entity entity, double x, double y, double z, float entityYaw, float partialTicks) {
      this.doRender((EntityXPOrb)entity, x, y, z, entityYaw, partialTicks);
   }
}
