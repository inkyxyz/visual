package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.TntEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;

@ModuleInfo(
   name = "TNT Timer",
   category = ModuleCategory.VISUALS,
   iI_method_476ab839 = true,
   III_method_a89e5834 = "modules.descriptions.tnt_timer"
)
public class TntTimerModule extends Module {
   private IIiIIi_Class10 I_field_856d0221 = null;
   private final IiIIIiII_Class69<PreHudRenderEvent> I_field_3d936f41 = var1 -> {
      if (this.I_field_856d0221 == null) {
         this.I_field_856d0221 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(12.0F);
      }

      ArrayList var2 = new ArrayList();

      for (Entity var4 : I_field_3a9bda27.world.getEntities()) {
         if (var4 instanceof TntEntity var5) {
            var2.add(new TntTimerModule.Nested1_fc438a0(var5));
         }
      }

      iiIIIIIii_Class388 var7 = new iiIIIIIii_Class388(VertexFormats.POSITION_COLOR, var1.getContext().getMatrices());

      for (TntTimerModule.Nested1_fc438a0 var11 : (Iterable<TntTimerModule.Nested1_fc438a0>)(Iterable<?>)var2) {
         var11.I_method_d474b07e(var1.getContext(), this.I_field_856d0221, TntTimerModule.Nested1_fc43880.I_field_2c7aae07);
      }

      var7.II_method_ed687102();

      for (TntTimerModule.Nested1_fc438a0 var12 : (Iterable<TntTimerModule.Nested1_fc438a0>)(Iterable<?>)var2) {
         var12.I_method_d474b07e(var1.getContext(), this.I_field_856d0221, TntTimerModule.Nested1_fc43880.i_field_2c7aae07);
      }

      iiIIIIIIi_Class386 var10 = new iiIIIIIIi_Class386(VertexFormats.POSITION_TEXTURE_COLOR, this.I_field_856d0221.I_method_36d49b4b());

      for (TntTimerModule.Nested1_fc438a0 var6 : (Iterable<TntTimerModule.Nested1_fc438a0>)(Iterable<?>)var2) {
         var6.I_method_d474b07e(var1.getContext(), this.I_field_856d0221, TntTimerModule.Nested1_fc43880.II_field_2c7aae07);
      }

      var10.II_method_ed687102();
   };

   static enum Nested1_fc43880 {
      I_field_2c7aae07,
      i_field_2c7aae07,
      II_field_2c7aae07;
   }

   static class Nested1_fc438a0 {
      private final Vec3d I_field_5bba0d50;
      private final String I_field_523beb0a;

      public Nested1_fc438a0(TntEntity var1) {
         this.I_field_5bba0d50 = var1.getLerpedPos(iIIiIIiIi_Class294.I_field_3a9bda27.getRenderTickCounter().getTickDelta(true)).add(0.0, 0.5, 0.0);
         int var2 = var1.getFuse();
         float var3 = var2 / 20.0F;
         this.I_field_523beb0a = IiIiIIII_Class81.I_method_1410d1e5("modules.tnt_timer.format", var3);
      }

      void I_method_d474b07e(CustomDrawContext var1, IIiIIi_Class10 var2, TntTimerModule.Nested1_fc43880 var3) {
         Vec2f var4 = iIiiiiIII_Class377.I_method_211fc242(this.I_field_5bba0d50);
         if (var4 != null) {
            float var5 = (float)iIIiIIiIi_Class294.I_field_3a9bda27.player.getPos().distanceTo(this.I_field_5bba0d50);
            float var6 = MathHelper.clamp(1.0F - var5 / 20.0F, 0.5F, 1.0F);
            float var7 = this.I_method_966cac5d(var4) / 255.0F;
            MatrixStack var8 = var1.getMatrices();
            var8.push();
            var8.translate(var4.x, var4.y, 0.0F);
            var8.scale(var6, var6, 1.0F);
            float var9 = var2.I_method_2c375926(this.I_field_523beb0a) + 18.0F;
            float var10 = -var9 / 2.0F;
            float var11 = var2.I_method_a649725c();
            float var12 = 4.0F;
            float var13 = 2.0F;
            switch (var3) {
               case I_field_2c7aae07:
                  var1.drawRect(
                     var10 - var13, -var12, var9 + var13 * 2.0F + 4.0F, var11 + var12 * 2.0F, IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F).mulAlpha(var7)
                  );
                  break;
               case i_field_2c7aae07:
                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var7);
                  var1.drawItem(new ItemStack(Items.TNT), (int)var10, -3);
                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                  break;
               case II_field_2c7aae07:
                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var7);
                  var1.drawText(var2, this.I_field_523beb0a, (int)(var10 + 20.0F), 0.0F, ColorRGBA.WHITE);
                  RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
            }

            var8.pop();
         }
      }

      private float I_method_966cac5d(Vec2f var1) {
         if (var1 != null && iIIiIIiIi_Class294.I_field_3a9bda27.getWindow() != null) {
            int var2 = iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getScaledWidth();
            int var3 = iIIiIIiIi_Class294.I_field_3a9bda27.getWindow().getScaledHeight();
            float var4 = var1.x - var2 / 2.0F;
            float var5 = var1.y - var3 / 2.0F;
            float var6 = (float)Math.sqrt(var2 * var2 + var3 * var3) / 12.0F;
            return 90.0F + 165.0F * Math.min((float)Math.sqrt(var4 * var4 + var5 * var5) / var6, 1.0F);
         } else {
            return 255.0F;
         }
      }
   }
}
