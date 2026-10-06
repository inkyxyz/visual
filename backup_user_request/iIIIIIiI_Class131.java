package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import globals.client.Information;
import globals.shared.proto.Packets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import lombok.Generated;
import net.minecraft.block.BlockState;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Tessellator;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexConsumerProvider.Immediate;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.block.BlockRenderManager;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.item.HeldItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import org.joml.Vector4f;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

public class iIIIIIiI_Class131 extends IiiiIiiI_Class119 implements iIIiIIiii_Class296 {
   public static boolean I_field_5a;
   public static boolean i_field_5a;
   public static Entity I_field_77e0818c;
   private static IiiiiIII_Class121 I_field_12aa4f81;
   private static IiiiIiii_Class120 I_field_10f66741;
   private static IiiiiIiI_Class123 I_field_12aac7a1;
   private static final int I_field_49 = 15728880;
   private static final int i_field_49 = 10;
   private static final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(255.0F, 255.0F, 255.0F, 255.0F);
   private final iIiiIIiII_Class357 I_field_cb35e4c = new iIiiIIiII_Class357(true).I_method_cc37aab5().I_method_7d3fafd7(1.0F);
   private final iIiiIIiII_Class357 i_field_cb35e4c = new iIiiIIiII_Class357(true).I_method_cc37aab5().I_method_7d3fafd7(1.0F);
   private final iIiiIIiII_Class357 II_field_cb35e4c = new iIiiIIiII_Class357(true).I_method_cc37aab5().I_method_7d3fafd7(1.0F);
   private final iIiiI_Class23 I_field_6433b52c = iIiiI_Class23.I_method_e3b16f5();
   private final iIiiI_Class23 i_field_6433b52c = iIiiI_Class23.I_method_e3b16f5();
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private boolean II_field_5a = false;
   private boolean Ii_field_5a = false;
   private boolean iI_field_5a = false;
   private boolean ii_field_5a = false;
   private int II_field_49 = -1;
   private int Ii_field_49 = -1;
   private int iI_field_49 = -1;
   private int ii_field_49 = -1;
   private float I_field_46;
   private float i_field_46;
   private float II_field_46;
   private float Ii_field_46;
   private boolean III_field_5a;
   private final BooleanSetting I_field_ba20ca4c = this.I_method_5436696c("esp.glow");
   private final SliderSetting I_field_73178e8c = new SliderSetting(this, "esp.glow.strength")
      .I_method_c8c9a7d7(1.0F)
      .i_method_65e2aff7(5.0F)
      .II_method_b0f56334(1.0F)
      .Ii_method_4e0e6b54(3.0F);
   private final SliderSetting i_field_73178e8c = new SliderSetting(this, "esp.glow.strength_items")
      .I_method_c8c9a7d7(1.0F)
      .i_method_65e2aff7(5.0F)
      .II_method_b0f56334(1.0F)
      .Ii_method_4e0e6b54(3.0F);
   private final BooleanSetting i_field_ba20ca4c = this.I_method_e97d5695((var0, var1, var2) -> {
      String var3 = var2 == IiiiiIiI_Class123.Ii_field_12aac7a1 ? "esp.glow.item_color" : "esp.glow.entity_color";
      return new BooleanSetting(var0, var3, () -> !var1.i_method_9b12da03()).I_method_decd82b5();
   });
   private final BooleanSetting II_field_ba20ca4c = this.I_method_96c36dc8(
      "esp.glow.entity_color",
      (var0, var1, var2) -> new BooleanSetting(var0, "theme.sync", () -> !var1.i_method_9b12da03() || var2.i_method_9b12da03()).I_method_decd82b5()
   );
   private final BooleanSetting Ii_field_ba20ca4c = this.I_method_e0ef16b2(
      "esp.glow.entity_color",
      "theme.sync",
      (var0, var1, var2, var3) -> new BooleanSetting(
         var0, "esp.glow.gradient", () -> !var1.i_method_9b12da03() || var2.i_method_9b12da03() || var3.i_method_9b12da03()
      )
   );
   private final ColorSetting I_field_bbd4b66c = this.I_method_492d23d7(
      "esp.glow.entity_color",
      "theme.sync",
      "esp.glow.gradient",
      (var0, var1, var2, var3, var4) -> new ColorSetting(
            var0, "esp.glow.color", () -> !var1.i_method_9b12da03() || var2.i_method_9b12da03() || var3.i_method_9b12da03() || var4.i_method_9b12da03()
         )
         .I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e())
   );
   private final List<GradientColorSetting> I_field_7865b31 = new ArrayList<>();
   private boolean IIi_field_5a;
   private final GradientColorSetting I_field_bbd52aac = this.I_method_492d23d7(
      "esp.glow.entity_color",
      "theme.sync",
      "esp.glow.gradient",
      (var1, var2, var3, var4, var5) -> {
         iIIIIIiI_Class131.Nested1_6fb55c93 var6 = new iIIIIIiI_Class131.Nested1_6fb55c93(
            var1,
            "esp.glow.gradient_color",
            () -> !var2.i_method_9b12da03() || var3.i_method_9b12da03() || var4.i_method_9b12da03() || !var5.i_method_9b12da03(),
            this::I_method_f6a9ddda
         );
         var6.I_method_1119eb95(new ColorRGBA(255.0F, 80.0F, 200.0F, 255.0F), new ColorRGBA(80.0F, 160.0F, 255.0F, 255.0F));
         this.I_field_7865b31.add(var6);
         return var6;
      }
   );
   private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = var1 -> {
      this.iI_field_5a = false;
      if (this.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741)) {
         this.i_field_cb35e4c.I_method_53fdf4b5(true);
         this.i_field_cb35e4c.i_method_766109df();
      }

      if (this.I_method_ea8b70b0() && this.I_field_991c1e8c.I_method_58432069(10L)) {
         boolean var2 = this.i_method_6c6ff6d1(IiiiIiii_Class120.i_field_10f66741);
         this.I_field_cb35e4c.I_method_53fdf4b5(true);
         I_field_5a = true;
         this.Ii_field_5a = false;
         this.I_field_46 = this.i_field_46 = Float.POSITIVE_INFINITY;
         this.II_field_46 = this.Ii_field_46 = Float.NEGATIVE_INFINITY;
         this.III_field_5a = false;

         for (Entity var4 : I_field_3a9bda27.world.getEntities()) {
            if (!(var4 instanceof ItemEntity) && this.I_method_d2b4487e(var4)) {
               this.i_method_9004835a(var4, var1);
            }
         }

         I_field_5a = false;
         this.I_field_cb35e4c.i_method_766109df();
         if (this.Ii_field_5a && this.IIi_method_274fe210()) {
            this.I_method_88b44c45(this.I_field_cb35e4c, I_field_d0c8ec5);
         }

         this.ii_field_5a = false;
         if (var2) {
            this.II_field_cb35e4c.I_method_53fdf4b5(true);
            i_field_5a = true;

            for (Entity var6 : I_field_3a9bda27.world.getEntities()) {
               if (var6 instanceof ItemEntity && this.I_method_d2b4487e(var6)) {
                  this.I_method_65d2933a(var6, var1);
               }
            }

            i_field_5a = false;
            this.II_field_cb35e4c.i_method_766109df();
         }

         if (this.Ii_field_5a) {
            this.i_method_a2dc08ec();
         } else {
            this.II_field_49 = this.Ii_field_49 = this.iI_field_49 = this.ii_field_49 = -1;
         }

         this.II_field_5a = true;
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   };
   private final IiIIIiII_Class69<PreHudRenderEvent> i_field_3d936f41 = var1 -> {
      boolean var2 = this.I_method_ea8b70b0();
      if (var2) {
         if (this.II_field_5a) {
            if (this.Ii_field_5a) {
               iIiiIIiii_Class360.I_field_6433b52c.i_method_dd886024((int)this.I_field_73178e8c.Ii_method_a20abcd2());
               iIiiIIiii_Class360.I_field_6433b52c.i_method_dd8854e1(7.0F);
               iIiiIIiii_Class360.I_field_6433b52c.Ii_method_a06defbe(1.0F);
               iIiiIIiii_Class360.I_field_6433b52c.II_method_9eaaff9e(1.0F);
               iIiiIIiii_Class360.I_field_6433b52c.I_method_6119a907(this.I_field_cb35e4c, -1, -1, -1, -1);
            }

            this.II_field_5a = false;
         }

         if (this.Ii_field_5a) {
            int var3 = iIiiI_Class23.II_method_dbd3f455();
            if (var3 != 0) {
               this.I_method_88a7d8cb(var3, -0.5F, this.IIi_method_274fe210());
            }
         }
      }

      if (this.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741) && this.iI_field_5a) {
         boolean var5 = this.II_method_132c1cda(IiiiIiii_Class120.I_field_10f66741);
         if (var5) {
            this.I_method_88b44c45(this.i_field_cb35e4c, I_field_d0c8ec5);
         } else {
            ColorRGBA var4 = this.I_method_3249b37b();
            if (var4 != null) {
               this.I_method_88b44c45(this.i_field_cb35e4c, var4);
            }
         }

         this.I_field_6433b52c.i_method_dd886024((int)this.i_field_73178e8c.Ii_method_a20abcd2());
         this.I_field_6433b52c.i_method_dd8854e1(7.0F);
         this.I_field_6433b52c.II_method_9eaaff9e(1.0F);
         this.I_field_6433b52c.Ii_method_a06defbe(1.0F);
         this.I_field_6433b52c.ii_method_d709039e(-8.0F);
         this.I_field_6433b52c.I_method_6119a907(this.i_field_cb35e4c, -1, -1, -1, -1);
         IiiiiIii_Class124.I_method_a75705ba(this.I_field_6433b52c.I_method_bd32b395());
         int var7 = this.I_field_6433b52c.I_method_716ded2();
         if (var7 != 0) {
            this.I_method_88a7d8cb(var7, -0.5F, var5);
         }
      }

      if (this.i_method_6c6ff6d1(IiiiIiii_Class120.i_field_10f66741) && this.ii_field_5a) {
         boolean var6 = this.II_method_132c1cda(IiiiIiii_Class120.i_field_10f66741);
         if (var6) {
            this.I_method_88b44c45(this.II_field_cb35e4c, I_field_d0c8ec5);
         } else {
            ColorRGBA var8 = this.i_method_ba30bf5b();
            if (var8 != null) {
               this.I_method_88b44c45(this.II_field_cb35e4c, var8);
            }
         }

         this.i_field_6433b52c.i_method_dd886024((int)this.i_field_73178e8c.Ii_method_a20abcd2());
         this.i_field_6433b52c.i_method_dd8854e1(7.0F);
         this.i_field_6433b52c.II_method_9eaaff9e(1.0F);
         this.i_field_6433b52c.Ii_method_a06defbe(1.0F);
         this.i_field_6433b52c.I_method_6119a907(this.II_field_cb35e4c, -1, -1, -1, -1);
         int var9 = this.i_field_6433b52c.I_method_716ded2();
         if (var9 != 0) {
            this.I_method_88a7d8cb(var9, -0.5F, var6);
         }
      }
   };
   private static final int III_field_49 = 4;
   private static final float iI_field_46 = 80.0F;

   private void I_method_f6a9ddda(GradientColorSetting var1) {
      if (!this.IIi_field_5a) {
         this.IIi_field_5a = true;

         try {
            ColorRGBA var2 = var1.I_method_b3b144ce();
            ColorRGBA var3 = var1.i_method_3b9850ae();

            for (GradientColorSetting var5 : this.I_field_7865b31) {
               if (var5 != var1) {
                  if (var2 != null) {
                     var5.I_method_3431d5d6(var2);
                  }

                  if (var3 != null) {
                     var5.i_method_a6225df6(var3);
                  }
               }
            }
         } finally {
            this.IIi_field_5a = false;
         }
      }
   }

   private boolean IIi_method_274fe210() {
      for (IiiiiIiI_Class123 var4 : new IiiiiIiI_Class123[]{IiiiiIiI_Class123.i_field_12aac7a1, IiiiiIiI_Class123.II_field_12aac7a1}) {
         if (this.II_method_7949e53a(var4)) {
            return true;
         }
      }

      for (IiiiiIII_Class121 var8 : IiiiiIII_Class121.values()) {
         if (this.II_method_7786f51a(var8)) {
            return true;
         }
      }

      return false;
   }

   private boolean II_method_7949e53a(IiiiiIiI_Class123 var1) {
      if (!this.i_method_d28dbf31(var1)) {
         return false;
      } else {
         BooleanSetting var2 = this.I_method_c9c6d("esp.glow.entity_color", var1);
         if (var2 != null && var2.i_method_9b12da03()) {
            return false;
         } else {
            BooleanSetting var3 = this.I_method_c9c6d("theme.sync", var1);
            if (var3 != null && var3.i_method_9b12da03()) {
               return false;
            } else {
               BooleanSetting var4 = this.I_method_c9c6d("esp.glow.gradient", var1);
               return var4 != null && var4.i_method_9b12da03();
            }
         }
      }
   }

   private boolean II_method_7786f51a(IiiiiIII_Class121 var1) {
      if (!this.i_method_d0cacf11(var1)) {
         return false;
      } else {
         BooleanSetting var2 = this.I_method_62f3944d("esp.glow.entity_color", var1);
         if (var2 != null && var2.i_method_9b12da03()) {
            return false;
         } else {
            BooleanSetting var3 = this.I_method_62f3944d("theme.sync", var1);
            if (var3 != null && var3.i_method_9b12da03()) {
               return false;
            } else {
               BooleanSetting var4 = this.I_method_62f3944d("esp.glow.gradient", var1);
               return var4 != null && var4.i_method_9b12da03();
            }
         }
      }
   }

   private boolean II_method_132c1cda(IiiiIiii_Class120 var1) {
      if (!this.i_method_6c6ff6d1(var1)) {
         return false;
      } else {
         BooleanSetting var2 = this.I_method_60b28c0d("esp.glow.entity_color", var1);
         if (var2 != null && var2.i_method_9b12da03()) {
            return false;
         } else {
            BooleanSetting var3 = this.I_method_60b28c0d("theme.sync", var1);
            if (var3 != null && var3.i_method_9b12da03()) {
               return false;
            } else {
               BooleanSetting var4 = this.I_method_60b28c0d("esp.glow.gradient", var1);
               return var4 != null && var4.i_method_9b12da03();
            }
         }
      }
   }

   public iIIIIIiI_Class131() {
      super(
         "glow",
         new IiiiIiii_Class120[]{IiiiIiii_Class120.I_field_10f66741, IiiiIiii_Class120.i_field_10f66741},
         IiiiiIiI_Class123.I_field_12aac7a1,
         IiiiiIiI_Class123.i_field_12aac7a1,
         IiiiiIiI_Class123.II_field_12aac7a1,
         IiiiiIiI_Class123.Ii_field_12aac7a1
      );
      this.I_field_6433b52c.I_method_716dedf();
      this.i_field_6433b52c.I_method_716dedf();
      this.I_method_1b2c55bc(
         this.I_field_73178e8c,
         new IiiiiIiI_Class123[]{IiiiiIiI_Class123.I_field_12aac7a1, IiiiiIiI_Class123.i_field_12aac7a1, IiiiiIiI_Class123.II_field_12aac7a1}
      );
      this.I_method_1b2c55bc(this.i_field_73178e8c, new IiiiiIiI_Class123[]{IiiiiIiI_Class123.Ii_field_12aac7a1});
   }

   public boolean I_method_d2b4487e(Entity var1) {
      if (var1 instanceof PlayerEntity var2) {
         if (I_field_12aa4f81 != null) {
            return this.i_method_d0cacf11(I_field_12aa4f81);
         } else if (var2 == I_field_3a9bda27.player) {
            return this.i_method_d0cacf11(IiiiiIII_Class121.i_field_12aa4f81);
         } else if (I_method_1683065(var2)) {
            return this.i_method_d0cacf11(IiiiiIII_Class121.Ii_field_12aa4f81);
         } else {
            return RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var2.getName().getString())
               ? this.i_method_d0cacf11(IiiiiIII_Class121.II_field_12aa4f81)
               : this.i_method_d0cacf11(IiiiiIII_Class121.I_field_12aa4f81);
         }
      } else if (var1 instanceof HostileEntity) {
         return this.i_method_d28dbf31(IiiiiIiI_Class123.i_field_12aac7a1);
      } else if (var1 instanceof AnimalEntity) {
         return this.i_method_d28dbf31(IiiiiIiI_Class123.II_field_12aac7a1);
      } else if (var1 instanceof ItemEntity) {
         return I_field_10f66741 != null ? this.i_method_6c6ff6d1(I_field_10f66741) : this.i_method_6c6ff6d1(IiiiIiii_Class120.i_field_10f66741);
      } else {
         return false;
      }
   }

   public ColorRGBA I_method_6ef746e9(Entity var1) {
      BooleanSetting var2;
      BooleanSetting var3;
      ColorSetting var4;
      if (var1 instanceof PlayerEntity var5) {
         IiiiiIII_Class121 var6 = I_field_12aa4f81 != null ? I_field_12aa4f81 : I_method_ca2eb1d6(var5);
         var2 = this.I_method_62f3944d("esp.glow.entity_color", var6);
         var3 = this.I_method_62f3944d("theme.sync", var6);
         var4 = this.I_method_62f3944d("esp.glow.color", var6);
      } else if (var1 instanceof HostileEntity) {
         IiiiiIiI_Class123 var7 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.i_field_12aac7a1;
         var2 = this.I_method_c9c6d("esp.glow.entity_color", var7);
         var3 = this.I_method_c9c6d("theme.sync", var7);
         var4 = this.I_method_c9c6d("esp.glow.color", var7);
      } else {
         if (!(var1 instanceof AnimalEntity)) {
            return null;
         }

         IiiiiIiI_Class123 var8 = I_field_12aac7a1 != null ? I_field_12aac7a1 : IiiiiIiI_Class123.II_field_12aac7a1;
         var2 = this.I_method_c9c6d("esp.glow.entity_color", var8);
         var3 = this.I_method_c9c6d("theme.sync", var8);
         var4 = this.I_method_c9c6d("esp.glow.color", var8);
      }

      if (var2 == null || var2.i_method_9b12da03()) {
         return null;
      } else if (var3 != null && var3.i_method_9b12da03()) {
         return IiiiiIIIi_Class242.i_method_5dfec6e();
      } else {
         return var4 != null ? var4.I_method_bde5f08e() : IiiiiIIIi_Class242.i_method_5dfec6e();
      }
   }

   public ColorRGBA I_method_3249b37b() {
      return this.I_method_8f26c9bc(IiiiIiii_Class120.I_field_10f66741);
   }

   public ColorRGBA i_method_ba30bf5b() {
      return this.I_method_8f26c9bc(IiiiIiii_Class120.i_field_10f66741);
   }

   private ColorRGBA I_method_8f26c9bc(IiiiIiii_Class120 var1) {
      BooleanSetting var2 = this.I_method_60b28c0d("esp.glow.entity_color", var1);
      BooleanSetting var3 = this.I_method_60b28c0d("theme.sync", var1);
      ColorSetting var4 = this.I_method_60b28c0d("esp.glow.color", var1);
      if (var2 == null || var2.i_method_9b12da03()) {
         return null;
      } else if (var3 != null && var3.i_method_9b12da03()) {
         return IiiiiIIIi_Class242.i_method_5dfec6e();
      } else {
         return var4 != null ? var4.I_method_bde5f08e() : IiiiiIIIi_Class242.i_method_5dfec6e();
      }
   }

   public void I_method_eda90fc9(
      HeldItemRenderer var1, AbstractClientPlayerEntity var2, ItemStack var3, ModelTransformationMode var4, boolean var5, MatrixStack var6, int var7
   ) {
      if (this.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741)) {
         if (var3 != null && !var3.isEmpty()) {
            i_field_5a = true;
            this.i_field_cb35e4c.I_method_53fdf4b5(false);
            Immediate var8 = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();

            try {
               var1.renderItem(var2, var3, var4, var5, var6, var8, 15728880);
               var8.draw();
               this.iI_field_5a = true;
            } catch (Exception var10) {
            }

            this.i_field_cb35e4c.i_method_766109df();
            i_field_5a = false;
         }
      }
   }

   public void I_method_c76b816(BlockRenderManager var1, BlockState var2, MatrixStack var3, int var4) {
      if (this.i_method_6c6ff6d1(IiiiIiii_Class120.I_field_10f66741)) {
         if (var2 != null) {
            i_field_5a = true;
            this.i_field_cb35e4c.I_method_53fdf4b5(false);
            Immediate var5 = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();

            try {
               var1.renderBlockAsEntity(var2, var3, var5, 15728880, var4);
               var5.draw();
               this.iI_field_5a = true;
            } catch (Exception var7) {
            }

            this.i_field_cb35e4c.i_method_766109df();
            i_field_5a = false;
         }
      }
   }

   private void I_method_65d2933a(Entity var1, Render3DEvent var2) {
      if (var1 != null && var1.isAlive()) {
         MatrixStack var3 = var2.getMatrices();
         Camera var4 = I_field_3a9bda27.gameRenderer.getCamera();
         Vec3d var5 = iIiiiiIII_Class377.I_method_689b1a13(var1, var2.getTickDelta());
         Vec3d var6 = var4.getPos();
         var3.push();
         var3.translate(var5.x - var6.x, var5.y - var6.y, var5.z - var6.z);
         RenderSystem.disableDepthTest();
         RenderSystem.enableBlend();
         EntityRenderDispatcher var7 = I_field_3a9bda27.getEntityRenderDispatcher();
         Immediate var8 = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();
         I_field_77e0818c = var1;

         try {
            var7.render(var1, 0.0, 0.0, 0.0, var2.getTickDelta(), var3, var8, 15728880, var7.getRenderer(var1));
            var8.draw();
            this.ii_field_5a = true;
         } catch (Exception var10) {
         }

         I_field_77e0818c = null;
         RenderSystem.enableDepthTest();
         var3.pop();
      }
   }

   private void i_method_9004835a(Entity var1, Render3DEvent var2) {
      if (var1 != null && var1.isAlive()) {
         if (var1 != I_field_3a9bda27.player || !I_field_3a9bda27.options.getPerspective().isFirstPerson()) {
            MatrixStack var3 = var2.getMatrices();
            Camera var4 = I_field_3a9bda27.gameRenderer.getCamera();
            Vec3d var5 = iIiiiiIII_Class377.I_method_689b1a13(var1, var2.getTickDelta());
            Vec3d var6 = var4.getPos();
            var3.push();
            var3.translate(var5.x - var6.x, var5.y - var6.y, var5.z - var6.z);
            RenderSystem.disableDepthTest();
            RenderSystem.enableBlend();
            EntityRenderDispatcher var7 = I_field_3a9bda27.getEntityRenderDispatcher();
            Immediate var8 = I_field_3a9bda27.getBufferBuilders().getEntityVertexConsumers();
            I_field_77e0818c = var1;

            try {
               var7.render(var1, 0.0, 0.0, 0.0, var2.getTickDelta(), var3, var8, 15728880, var7.getRenderer(var1));
               var8.draw();
               this.I_method_bd6a95d0(var1, var6);
               this.Ii_field_5a = true;
            } catch (Exception var10) {
            }

            I_field_77e0818c = null;
            RenderSystem.enableDepthTest();
            var3.pop();
         }
      }
   }

   private void I_method_88a7d8cb(int var1, float var2, boolean var3) {
      ColorRGBA var4 = this.I_field_bbd52aac.I_method_b3b144ce();
      ColorRGBA var5 = this.I_field_bbd52aac.i_method_3b9850ae();
      if (var3 && var4 != null && var5 != null) {
         this.I_method_8c4bf949(var1, var2, I_method_5d4b2e6(var4), I_method_5d4b2e6(var5));
      } else {
         this.I_method_2570bf29(var1, var2);
      }
   }

   private void I_method_2570bf29(int var1, float var2) {
      RenderSystem.setShaderTexture(0, var1);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      RenderSystem.enableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.blendFunc(SrcFactor.ONE, DstFactor.ONE);
      iIiiIIiii_Class360.I_method_4355d27f(0.0F, var2, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
      iIiiIIiii_Class360.I_method_4355d27f(0.0F, var2, I_field_587075c2.getScaledWidth(), I_field_587075c2.getScaledHeight());
      RenderSystem.depthMask(true);
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.disableBlend();
      RenderSystem.enableCull();
      RenderSystem.disableDepthTest();
   }

   private void I_method_88b44c45(iIiiIIiII_Class357 var1, ColorRGBA var2) {
      var1.beginWrite(true);
      RenderSystem.enableBlend();
      GlStateManager._blendFuncSeparate(772, 0, 0, 1);
      RenderSystem.disableDepthTest();
      RenderSystem.disableCull();
      RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      int var3 = i_method_7acf2306(var2);
      float var4 = I_field_587075c2.getScaledWidth();
      float var5 = I_field_587075c2.getScaledHeight();
      BufferBuilder var6 = Tessellator.getInstance().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      var6.vertex(0.0F, 0.0F, 0.0F).color(var3);
      var6.vertex(0.0F, var5, 0.0F).color(var3);
      var6.vertex(var4, var5, 0.0F).color(var3);
      var6.vertex(var4, 0.0F, 0.0F).color(var3);
      BufferRenderer.drawWithGlobalProgram(var6.end());
      RenderSystem.defaultBlendFunc();
      I_field_3a9bda27.getFramebuffer().beginWrite(true);
   }

   private void I_method_8c4bf949(int var1, float var2, int var3, int var4) {
      RenderSystem.setShaderTexture(0, var1);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      RenderSystem.enableBlend();
      RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
      RenderSystem.blendFunc(SrcFactor.ONE, DstFactor.ONE);
      float var5 = I_field_587075c2.getScaledWidth();
      float var6 = I_field_587075c2.getScaledHeight();
      float var7 = var6 / 4.0F;
      float var8 = 2.0F * var7;
      float var9 = (float)(System.currentTimeMillis() % 1000000L) / 1000.0F;
      float var10 = var9 * 80.0F % var8;
      byte var11 = 2;

      for (int var12 = 0; var12 < 2; var12++) {
         BufferBuilder var13 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

         for (int var14 = -var11; var14 < 4 + var11; var14++) {
            boolean var15 = Math.floorMod(var14, 2) == 0;
            int var16 = var15 ? var3 : var4;
            int var17 = var15 ? var4 : var3;
            float var18 = var2 + var14 * var7 - var10;
            float var19 = var18 + var7;
            float var20 = 1.0F - (var18 - var2) / var6;
            float var21 = 1.0F - (var19 - var2) / var6;
            var13.vertex(0.0F, var18, 0.0F).texture(0.0F, var20).color(var16);
            var13.vertex(0.0F, var19, 0.0F).texture(0.0F, var21).color(var17);
            var13.vertex(var5, var19, 0.0F).texture(1.0F, var21).color(var17);
            var13.vertex(var5, var18, 0.0F).texture(1.0F, var20).color(var16);
         }

         BufferRenderer.drawWithGlobalProgram(var13.end());
      }

      RenderSystem.depthMask(true);
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.disableBlend();
      RenderSystem.enableCull();
      RenderSystem.disableDepthTest();
   }

   private static int I_method_5d4b2e6(ColorRGBA var0) {
      int var1 = Math.round(var0.getRed()) & 0xFF;
      int var2 = Math.round(var0.getGreen()) & 0xFF;
      int var3 = Math.round(var0.getBlue()) & 0xFF;
      return 0xFF000000 | var1 << 16 | var2 << 8 | var3;
   }

   private static int i_method_7acf2306(ColorRGBA var0) {
      float var1 = Math.max(0.0F, Math.min(1.0F, var0.getAlpha() / 255.0F));
      int var2 = Math.round(var0.getRed() * var1) & 0xFF;
      int var3 = Math.round(var0.getGreen() * var1) & 0xFF;
      int var4 = Math.round(var0.getBlue() * var1) & 0xFF;
      return 0xFF000000 | var2 << 16 | var3 << 8 | var4;
   }

   private void I_method_bd6a95d0(Entity var1, Vec3d var2) {
      if (!this.III_field_5a) {
         Box var3 = var1.getBoundingBox();
         Matrix4f var4 = new Matrix4f(RenderSystem.getProjectionMatrix()).mul(RenderSystem.getModelViewMatrix());
         double[] var5 = new double[]{var3.minX, var3.maxX};
         double[] var6 = new double[]{var3.minY, var3.maxY};
         double[] var7 = new double[]{var3.minZ, var3.maxZ};
         Vector4f var8 = new Vector4f();

         for (double var12 : var5) {
            for (double var17 : var6) {
               for (double var22 : var7) {
                  var8.set((float)(var12 - var2.x), (float)(var17 - var2.y), (float)(var22 - var2.z), 1.0F);
                  var8.mul(var4);
                  if (var8.w <= 1.0E-4F) {
                     this.III_field_5a = true;
                     return;
                  }

                  float var24 = var8.x / var8.w;
                  float var25 = var8.y / var8.w;
                  if (var24 < this.I_field_46) {
                     this.I_field_46 = var24;
                  }

                  if (var24 > this.II_field_46) {
                     this.II_field_46 = var24;
                  }

                  if (var25 < this.i_field_46) {
                     this.i_field_46 = var25;
                  }

                  if (var25 > this.Ii_field_46) {
                     this.Ii_field_46 = var25;
                  }
               }
            }
         }
      }
   }

   private void i_method_a2dc08ec() {
      int var1 = I_field_3a9bda27.getWindow().getFramebufferWidth();
      int var2 = I_field_3a9bda27.getWindow().getFramebufferHeight();
      if (!this.III_field_5a && !(this.I_field_46 > this.II_field_46)) {
         byte var3 = 96;
         float var4 = (this.I_field_46 * 0.5F + 0.5F) * var1;
         float var5 = (this.II_field_46 * 0.5F + 0.5F) * var1;
         float var6 = (this.i_field_46 * 0.5F + 0.5F) * var2;
         float var7 = (this.Ii_field_46 * 0.5F + 0.5F) * var2;
         int var8 = (int)Math.floor(var4) - var3;
         int var9 = (int)Math.floor(var6) - var3;
         int var10 = (int)Math.ceil(var5 - var4) + var3 * 2;
         int var11 = (int)Math.ceil(var7 - var6) + var3 * 2;
         if (var8 < 0) {
            var10 += var8;
            var8 = 0;
         }

         if (var9 < 0) {
            var11 += var9;
            var9 = 0;
         }

         if (var8 < var1 && var9 < var2) {
            if (var8 + var10 > var1) {
               var10 = var1 - var8;
            }

            if (var9 + var11 > var2) {
               var11 = var2 - var9;
            }

            this.II_field_49 = var8;
            this.Ii_field_49 = var9;
            this.iI_field_49 = var10;
            this.ii_field_49 = var11;
         } else {
            this.II_field_49 = this.Ii_field_49 = this.iI_field_49 = this.ii_field_49 = -1;
         }
      } else {
         this.II_field_49 = 0;
         this.Ii_field_49 = 0;
         this.iI_field_49 = var1;
         this.ii_field_49 = var2;
      }
   }

   private static IiiiiIII_Class121 I_method_ca2eb1d6(PlayerEntity var0) {
      if (var0 == I_field_3a9bda27.player) {
         return IiiiiIII_Class121.i_field_12aa4f81;
      } else if (RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var0.getName().getString())) {
         return IiiiiIII_Class121.II_field_12aa4f81;
      } else {
         return I_method_1683065(var0) ? IiiiiIII_Class121.Ii_field_12aa4f81 : IiiiiIII_Class121.I_field_12aa4f81;
      }
   }

   private static boolean I_method_1683065(PlayerEntity var0) {
      String var1 = var0.getName().getString();

      for (Packets.Nested1_1da0dac9 var3 : Information.getVisiblePlayers()) {
         if (var3.gameInfo() != null && var1.equals(var3.gameInfo().nickname())) {
            return true;
         }
      }

      return false;
   }

   @Generated
   public iIiiIIiII_Class357 I_method_9cffc382() {
      return this.I_field_cb35e4c;
   }

   @Generated
   public iIiiIIiII_Class357 i_method_b2953762() {
      return this.i_field_cb35e4c;
   }

   @Generated
   public iIiiIIiII_Class357 II_method_460090b() {
      return this.II_field_cb35e4c;
   }

   @Generated
   public iIiiI_Class23 I_method_4bf2562() {
      return this.I_field_6433b52c;
   }

   @Generated
   public iIiiI_Class23 i_method_3fe98942() {
      return this.i_field_6433b52c;
   }

   @Generated
   public iiIiIIiii_Class424 I_method_296883c2() {
      return this.I_field_991c1e8c;
   }

   @Generated
   public boolean i_method_a2dc08f0() {
      return this.II_field_5a;
   }

   @Generated
   public boolean II_method_b6f11bd9() {
      return this.Ii_field_5a;
   }

   @Generated
   public boolean Ii_method_b6ffa7b9() {
      return this.iI_field_5a;
   }

   @Generated
   public boolean iI_method_b8b40bf9() {
      return this.ii_field_5a;
   }

   @Generated
   public int I_method_a2cd7cff() {
      return this.II_field_49;
   }

   @Generated
   public int i_method_a2dc08df() {
      return this.Ii_field_49;
   }

   @Generated
   public int II_method_b6f11bc8() {
      return this.iI_field_49;
   }

   @Generated
   public int Ii_method_b6ffa7a8() {
      return this.ii_field_49;
   }

   @Generated
   public float I_method_a2cd7cfc() {
      return this.I_field_46;
   }

   @Generated
   public float i_method_a2dc08dc() {
      return this.i_field_46;
   }

   @Generated
   public float II_method_b6f11bc5() {
      return this.II_field_46;
   }

   @Generated
   public float Ii_method_b6ffa7a5() {
      return this.Ii_field_46;
   }

   @Generated
   public boolean ii_method_b8c297d9() {
      return this.III_field_5a;
   }

   @Generated
   public BooleanSetting I_method_4a6d2f82() {
      return this.I_field_ba20ca4c;
   }

   @Generated
   public SliderSetting I_method_363f3c2() {
      return this.I_field_73178e8c;
   }

   @Generated
   public SliderSetting i_method_18f967a2() {
      return this.i_field_73178e8c;
   }

   @Generated
   public BooleanSetting i_method_6002a362() {
      return this.i_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting II_method_b1cd750b() {
      return this.II_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting Ii_method_c762e8eb() {
      return this.Ii_field_ba20ca4c;
   }

   @Generated
   public ColorSetting I_method_4c211ba2() {
      return this.I_field_bbd4b66c;
   }

   @Generated
   public List<GradientColorSetting> I_method_d6451bbb() {
      return this.I_field_7865b31;
   }

   @Generated
   public boolean III_method_27415630() {
      return this.IIi_field_5a;
   }

   @Generated
   public GradientColorSetting I_method_4c218fe2() {
      return this.I_field_bbd52aac;
   }

   @Generated
   public IiIIIiII_Class69<Render3DEvent> I_method_2a8b4b() {
      return this.I_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<PreHudRenderEvent> i_method_2a271b6b() {
      return this.i_field_3d936f41;
   }

   @Generated
   public static void I_method_1026af8d(IiiiiIII_Class121 var0) {
      I_field_12aa4f81 = var0;
   }

   @Generated
   public static IiiiiIII_Class121 I_method_d5416b8b() {
      return I_field_12aa4f81;
   }

   @Generated
   public static void I_method_abcbd74d(IiiiIiii_Class120 var0) {
      I_field_10f66741 = var0;
   }

   @Generated
   public static IiiiIiii_Class120 I_method_d38d834b() {
      return I_field_10f66741;
   }

   @Generated
   public static void I_method_11e99fad(IiiiiIiI_Class123 var0) {
      I_field_12aac7a1 = var0;
   }

   @Generated
   public static IiiiiIiI_Class123 I_method_d541e3ab() {
      return I_field_12aac7a1;
   }

   static class Nested1_6fb55c93 extends GradientColorSetting {
      private final Consumer<GradientColorSetting> I_field_f9f609fa;

      Nested1_6fb55c93(IIiiiIIiI_Class115 var1, String var2, BooleanSupplier var3, Consumer<GradientColorSetting> var4) {
         super(var1, var2, var3);
         this.I_field_f9f609fa = var4;
      }

      @Override
      public GradientColorSetting I_method_3431d5d6(ColorRGBA var1) {
         super.I_method_3431d5d6(var1);
         if (this.I_field_f9f609fa != null) {
            this.I_field_f9f609fa.accept(this);
         }

         return this;
      }

      @Override
      public GradientColorSetting i_method_a6225df6(ColorRGBA var1) {
         super.i_method_a6225df6(var1);
         if (this.I_field_f9f609fa != null) {
            this.I_field_f9f609fa.accept(this);
         }

         return this;
      }
   }
}
