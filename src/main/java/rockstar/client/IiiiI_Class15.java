package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.render.VertexFormats;
import org.lwjgl.opengl.GL11;

public class IiiiI_Class15 implements iIIiIIiIi_Class294, iIIiIIiii_Class296 {
   private static final float I_field_46 = 0.25F;
   private static final float i_field_46 = 100.0F;
   private static final float II_field_46 = 64.0F;
   private iIiiIIiII_Class357 I_field_cb35e4c;
   private iIiiIIiII_Class357 i_field_cb35e4c;
   private IiiIi_Class14 I_field_2f5b1d2c;
   private long I_field_4a;
   private boolean I_field_5a;

   public void I_method_6769b1f() {
      this.I_field_2f5b1d2c = new IiiIi_Class14(RockstarClient.id("adaptive_state/data"), VertexFormats.POSITION_TEXTURE_COLOR);
   }

   public void I_method_25e00c41(float var1, float var2, float var3) {
      if (this.I_field_2f5b1d2c != null && !RockstarClient.getInstance().i_method_e8604970()) {
         if (this.I_field_cb35e4c == null) {
            this.I_field_cb35e4c = new iIiiIIiII_Class357(false);
            this.i_field_cb35e4c = new iIiiIIiII_Class357(false);
         }

         this.I_field_cb35e4c.I_method_7d3fafd7(0.25F);
         this.i_field_cb35e4c.I_method_7d3fafd7(0.25F);
         if (this.I_field_cb35e4c.getColorAttachment() <= 0) {
            this.I_field_cb35e4c.setClearColor(0.0F, 0.0F, 0.0F, 1.0F);
            this.I_field_cb35e4c.I_method_53fdf4b5(true);
            this.I_field_cb35e4c.i_method_766109df();
         }

         long var4 = System.currentTimeMillis();
         float var6 = Math.min(64.0F, this.I_field_4a == 0L ? 64.0F : (float)(var4 - this.I_field_4a));
         if (!this.I_field_5a || !(var6 <= 0.0F)) {
            this.I_field_4a = var4;
            boolean var7 = !this.I_field_5a || this.I_field_cb35e4c.textureWidth != this.i_field_cb35e4c.textureWidth;
            float var8 = var7 ? 1.0F : (float)(1.0 - Math.exp(-var6 / 100.0F));
            float var9 = I_field_3a9bda27.getWindow().getFramebufferWidth();
            float var10 = I_field_3a9bda27.getWindow().getFramebufferHeight();
            boolean var11 = GL11.glIsEnabled(3089);
            if (var11) {
               GL11.glDisable(3089);
            }

            try {
               RenderSystem.disableBlend();
               ShaderProgram var12 = this.I_field_2f5b1d2c.I_method_33f6c16b();
               var12.getUniform("Threshold").set(var1, var2);
               var12.getUniform("Probe").set(var9 > 0.0F ? var3 / var9 : 0.0F, var10 > 0.0F ? var3 / var10 : 0.0F);
               var12.getUniform("Rate").set(var8);
               this.i_field_cb35e4c.I_method_53fdf4b5(true);
               RenderSystem.setShaderTexture(0, iIIiI_Class19.I_method_af142f2());
               RenderSystem.setShaderTexture(1, this.I_field_cb35e4c.getColorAttachment());
               iIiiIIiii_Class360.I_method_4355d27f(0.0F, 0.0F, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
               this.i_field_cb35e4c.i_method_766109df();
               RenderSystem.setShaderTexture(0, 0);
               RenderSystem.setShaderTexture(1, 0);
            } finally {
               if (var11) {
                  GL11.glEnable(3089);
               }
            }

            iIiiIIiII_Class357 var16 = this.i_field_cb35e4c;
            this.i_field_cb35e4c = this.I_field_cb35e4c;
            this.I_field_cb35e4c = var16;
            this.I_field_5a = true;
         }
      }
   }

   public int I_method_6769b12() {
      return this.I_field_cb35e4c == null ? 0 : this.I_field_cb35e4c.getColorAttachment();
   }
}
