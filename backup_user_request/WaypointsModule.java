package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import globals.client.Information;
import globals.client.api.RockNetClient;
import globals.shared.proto.Packets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Waypoints",
   category = ModuleCategory.UTILS
)
public class WaypointsModule extends Module {
   private KeybindSetting I_field_ba20522c;
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private BooleanSetting I_field_ba20ca4c;
   private ColorSetting I_field_bbd4b66c;
   private static final String I_field_523beb0a = "%self%";
   private final Map<String, WaypointsModule.Nested1_449cd480> I_field_a567c40b = new HashMap<>();
   private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41 = var1 -> {
      if (this.I_field_ba20522c.I_method_51ee2d08(var1.getKey()) && var1.getAction() == 1 && I_field_3a9bda27.currentScreen == null) {
         this.Iii_method_bb0f327f();
      }
   };
   private final IiIIIiII_Class69<MouseEvent> i_field_3d936f41 = var1 -> {
      if (this.I_field_ba20522c.I_method_51ee2d08(var1.getButton()) && I_field_3a9bda27.currentScreen == null) {
         this.Iii_method_bb0f327f();
      }
   };
   private final IiIIIiII_Class69<Render3DEvent> II_field_3d936f41 = var1 -> {
      MatrixStack var2 = var1.getMatrices();
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
      RenderSystem.enableDepthTest();
      RenderSystem.disableCull();
      RenderSystem.depthMask(false);
      Camera var3 = I_field_3a9bda27.gameRenderer.getCamera();
      Identifier var4 = RockstarClient.id("textures/bloom.png");
      RenderSystem.setShaderTexture(0, var4);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      BufferBuilder var5 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

      for (WaypointsModule.Nested1_449cd480 var7 : this.I_field_a567c40b.values()) {
         Entity var8 = null;
         ColorRGBA var9 = this.I_method_eaaf0871(var7);

         for (Entity var11 : I_field_3a9bda27.world.getEntities()) {
            if (var11.getName().getString().equals(var7.I_method_c493e886())) {
               var8 = var11;
            }
         }

         if (var8 != I_field_3a9bda27.player) {
            var2.push();
            iIiiiIIiI_Class371.I_method_7d461059(var2, var7.I_field_5bba0d50);
            boolean var16 = I_field_3a9bda27.player.getPos().distanceTo(var7.I_field_5bba0d50) > 60.0;
            int var17 = var16 ? 150 : 10;

            for (int var12 = 0; var12 < var17; var12++) {
               float var13 = 0.6F;
               if (var16) {
                  var13 *= 2.0F;
               }

               float var14 = var13 * 5.0F;
               var2.push();
               var2.translate(0.0F, var12 / 5.0F, 0.0F);
               var2.multiply(var3.getRotation());
               iIiiIIiii_Class360.I_method_a9f124df(
                  var2,
                  var5,
                  -var14 / 2.0F,
                  -var14 / 2.0F,
                  -var13 / 2.0F,
                  var14,
                  var14,
                  var9.mulAlpha((0.4F + var7.I_field_dc7facc.I_method_6ac4da6f() * 0.7F) * var7.i_field_dc7facc.I_method_6ac4da6f() / 5.0F)
               );
               iIiiIIiii_Class360.I_method_a9f124df(
                  var2,
                  var5,
                  -var13 / 2.0F,
                  -var13 / 2.0F,
                  -var13 / 2.0F,
                  var13,
                  var13,
                  var9.mulAlpha((0.4F + var7.I_field_dc7facc.I_method_6ac4da6f() * 0.7F) * var7.i_field_dc7facc.I_method_6ac4da6f())
               );
               var2.pop();
            }

            var2.pop();
         }
      }

      BuiltBuffer var15 = var5.endNullable();
      if (var15 != null) {
         BufferRenderer.drawWithGlobalProgram(var15);
      }

      RenderSystem.depthMask(true);
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.disableBlend();
      RenderSystem.enableCull();
      RenderSystem.disableDepthTest();
   };
   private final IiIIIiII_Class69<PreHudRenderEvent> Ii_field_3d936f41 = var1 -> {
      MatrixStack var2 = var1.getContext().getMatrices();
      this.I_field_a567c40b
         .values()
         .removeIf(var0 -> var0.I_field_991c1e8c.I_method_58432069(var0.I_field_4a) && var0.i_field_dc7facc.I_method_6ac4da6f() <= 0.01F);

      for (WaypointsModule.Nested1_449cd480 var4 : this.I_field_a567c40b.values()) {
         if (var4 instanceof WaypointsModule.Nested1_449cd460 var5) {
            Entity var6 = null;

            for (Entity var8 : I_field_3a9bda27.world.getEntities()) {
               if (var8.getName().getString().equals(var5.I_method_c493e886())) {
                  var6 = var8;
               }
            }

            if (var6 != null) {
               var5.I_field_5bba0d50 = iIiiiiIII_Class377.I_method_689b1a13(var6, I_field_3a9bda27.getRenderTickCounter().getTickDelta(true));
            }
         }

         Vec2f var9 = iIiiiiIII_Class377.I_method_211fc242(var4.I_field_5bba0d50.add(0.0, 0.5, 0.0));
         if (var9 != null) {
            float var10 = (float)I_field_3a9bda27.player.getPos().distanceTo(var4.I_field_5bba0d50);
            float var11 = MathHelper.clamp(1.0F - var10 / 20.0F, 0.5F, 1.0F);
            float var12 = (0.4F + var4.I_field_dc7facc.I_method_6ac4da6f() * 0.7F) * var4.i_field_dc7facc.I_method_6ac4da6f();
            var2.push();
            var2.translate(var9.x, var9.y, 0.0F);
            var2.scale(var11, var11, 1.0F);
            IiIIiIIiI_Class147.I_method_856ade58(var1.getContext(), var4.I_method_c493e886(), var10, this.I_method_eaaf0871(var4), var12);
            var2.pop();
         }

         this.I_method_13942a02(var4);
      }
   };

   public WaypointsModule() {
      this.IiI_method_bb00a69f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_bb00a69f() {
      this.I_field_ba20522c = new KeybindSetting(this, "modules.settings.waypoints.key").I_method_4288e15a(86);
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.waypoints.player_time")
         .II_method_b0f56334(1.0F)
         .I_method_c8c9a7d7(5.0F)
         .i_method_65e2aff7(100.0F)
         .Ii_method_4e0e6b54(20.0F);
      this.i_field_73178e8c = new SliderSetting(this, "modules.settings.waypoints.block_time")
         .II_method_b0f56334(1.0F)
         .I_method_c8c9a7d7(5.0F)
         .i_method_65e2aff7(20.0F)
         .Ii_method_4e0e6b54(10.0F);
      this.I_field_ba20ca4c = new BooleanSetting(this, "theme.sync").I_method_decd82b5();
      this.I_field_bbd4b66c = new ColorSetting(this, "modules.settings.waypoints.color", this.I_field_ba20ca4c::i_method_9b12da03)
         .I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e())
         .I_method_af5a85eb(false);
   }

   private void Iii_method_bb0f327f() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         ColorRGBA var1 = this.I_method_35d7008e();
         Vec3d var2 = I_field_3a9bda27.player.getRotationVec(I_field_3a9bda27.getRenderTickCounter().getTickDelta(true));
         Vec3d var3 = I_field_3a9bda27.player.getEyePos().add(var2.multiply(200.0));
         Entity var4 = null;

         for (Entity var6 : I_field_3a9bda27.world.getEntities()) {
            Vec3d var7 = (Vec3d)var6.getBoundingBox().expand(0.3).raycast(I_field_3a9bda27.player.getEyePos(), var3).orElse(null);
            if (var7 != null) {
               double var8 = I_field_3a9bda27.player.getEyePos().distanceTo(var7);
               if (var8 <= 200.0) {
                  var4 = var6;
               }
            }
         }

         Object var10;
         if (var4 != null) {
            var10 = new WaypointsModule.Nested1_449cd460(
               var1, var4.getName().getString(), var4.getPos(), (long)this.I_field_73178e8c.Ii_method_a20abcd2() * 1000L
            );
         } else {
            HitResult var11 = I_field_3a9bda27.player.raycast(200.0, I_field_3a9bda27.getRenderTickCounter().getTickDelta(true), false);
            if (var11.getType() != Type.BLOCK || !(var11 instanceof BlockHitResult var13)) {
               return;
            }

            var10 = new WaypointsModule.Nested1_449cd480(var1, var13.getPos(), (long)this.i_field_73178e8c.Ii_method_a20abcd2() * 1000L);
         }

         this.I_field_a567c40b.put("%self%", (WaypointsModule.Nested1_449cd480)var10);
         RockNetClient var12 = RockstarClient.getInstance().I_method_cd3d46d0();
         if (Information.getUser() != null && var12.getGameInfo() != null) {
            var12.send(
               new Packets.Nested1_3630dbf0(
                  ((WaypointsModule.Nested1_449cd480)var10).I_method_c493e886(),
                  new Packets.Nested1_3834b16e(
                     ((WaypointsModule.Nested1_449cd480)var10).I_field_5bba0d50.x,
                     ((WaypointsModule.Nested1_449cd480)var10).I_field_5bba0d50.y,
                     ((WaypointsModule.Nested1_449cd480)var10).I_field_5bba0d50.z
                  ),
                  "",
                  var12.getGameInfo().server(),
                  var12.getGameInfo().hash(),
                  ((WaypointsModule.Nested1_449cd480)var10).I_method_dd5dff2e(),
                  var1.getRGB()
               )
            );
         }
      }
   }

   @Override
   public void II_method_6642fd22() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && !this.I_field_a567c40b.isEmpty()) {
         if (I_field_3a9bda27.player.age % 10 == 0) {
            RockNetClient var1 = RockstarClient.getInstance().I_method_cd3d46d0();
            if (Information.getUser() == null || var1.getGameInfo() == null) {
               return;
            }

            for (Entry var3 : this.I_field_a567c40b.entrySet()) {
               if (!((WaypointsModule.Nested1_449cd480)var3.getValue()).I_method_c493e886().contains(" ")) {
                  Entity var4 = null;

                  for (Entity var6 : I_field_3a9bda27.world.getEntities()) {
                     if (var6.getName().getString().equals(((WaypointsModule.Nested1_449cd480)var3.getValue()).I_method_c493e886())) {
                        var4 = var6;
                     }
                  }

                  if (var4 != null) {
                     WaypointsModule.Nested1_449cd480 var7 = (WaypointsModule.Nested1_449cd480)var3.getValue();
                     var1.send(
                        new Packets.Nested1_571f5383(
                           var7.I_method_c493e886(),
                           new Packets.Nested1_3834b16e(var4.getPos().x, var4.getPos().y, var4.getPos().z),
                           "",
                           var1.getGameInfo().server(),
                           var1.getGameInfo().hash()
                        )
                     );
                  }
               }
            }
         }
      }
   }

   private void I_method_13942a02(WaypointsModule.Nested1_449cd480 var1) {
      if (var1.i_field_dc7facc.I_method_6ac4da6f() == 1.0F) {
         var1.I_field_dc7facc.i_method_6ad3665f();
         var1.I_field_dc7facc.I_method_edd6ec25(Math.max((var1.I_field_4a - var1.I_field_991c1e8c.I_method_23e11e33()) / 4L, 450L));
      } else {
         var1.I_field_dc7facc.I_method_edd6ec25(0L);
         var1.I_field_dc7facc.I_method_edd6dd11(1.0F);
      }

      var1.I_field_dc7facc.I_method_edd6ec25(Math.max((var1.I_field_4a - var1.I_field_991c1e8c.I_method_23e11e33()) / 4L, 450L));
      if (var1.I_field_991c1e8c.I_method_23e11e33() >= var1.I_field_4a) {
         var1.i_field_dc7facc.I_method_edd6dd11(0.0F);
      } else {
         var1.i_field_dc7facc.I_method_edd6dd11(1.0F);
      }
   }

   private ColorRGBA I_method_35d7008e() {
      return this.I_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.I_field_bbd4b66c.I_method_bde5f08e();
   }

   private ColorRGBA I_method_eaaf0871(WaypointsModule.Nested1_449cd480 var1) {
      return this.I_field_ba20ca4c.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : var1.I_field_d0c8ec5;
   }

   public void I_method_6219fd86(Packets.Nested1_4af0fc48 var1) {
      if (!this.I_method_4d09391d(var1.author())) {
         Packets.Nested1_3834b16e var2 = var1.vector();
         if (var1.name().contains(" ")) {
            WaypointsModule.Nested1_449cd480 var3 = new WaypointsModule.Nested1_449cd480(
               ColorRGBA.fromInt(var1.color()), new Vec3d(var2.x(), var2.y(), var2.z()), var1.livingTime()
            );
            this.I_field_a567c40b.put(var1.author().username(), var3);
         } else {
            WaypointsModule.Nested1_449cd460 var4 = new WaypointsModule.Nested1_449cd460(
               ColorRGBA.fromInt(var1.color()), var1.name(), new Vec3d(var2.x(), var2.y(), var2.z()), var1.livingTime()
            );
            this.I_field_a567c40b.put(var1.author().username(), var4);
         }
      }
   }

   public void I_method_ce84c793(Packets.Nested1_b318355b var1) {
      if (!this.I_method_4d09391d(var1.author())) {
         Entity var2 = null;

         for (Entity var4 : I_field_3a9bda27.world.getEntities()) {
            if (var4.getName().getString().equals(var1.name())) {
               var2 = var4;
            }
         }

         if (var2 == null) {
            for (WaypointsModule.Nested1_449cd480 var7 : this.I_field_a567c40b.values()) {
               if (var7.I_method_c493e886().equals(var1.name())) {
                  Packets.Nested1_3834b16e var5 = var1.vector();
                  var7.I_method_f3a0710(new Vec3d(var5.x(), var5.y(), var5.z()));
               }
            }
         }
      }
   }

   private boolean I_method_4d09391d(Packets.Nested1_1da0dac9 var1) {
      if (var1 == null) {
         return false;
      } else {
         return Information.getUser() != null && Information.getUser().username().equalsIgnoreCase(var1.username())
            ? true
            : var1.gameInfo() != null && I_field_3a9bda27.getSession().getUsername().equals(var1.gameInfo().nickname());
      }
   }

   static class Nested1_449cd460 extends WaypointsModule.Nested1_449cd480 {
      private final String I_field_523beb0a;

      public Nested1_449cd460(ColorRGBA var1, String var2, Vec3d var3, long var4) {
         super(var1, var3, var4);
         this.I_field_523beb0a = var2;
      }

      @Override
      public String I_method_c493e886() {
         return this.I_field_523beb0a;
      }
   }

   static class Nested1_449cd480 {
      final ColorRGBA I_field_d0c8ec5;
      public Vec3d I_field_5bba0d50;
      final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
      final long I_field_4a;
      final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);
      final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.III_field_dd60aac);

      public String I_method_c493e886() {
         return String.format("%s %s %s", Math.round(this.I_field_5bba0d50.x), Math.round(this.I_field_5bba0d50.y), Math.round(this.I_field_5bba0d50.z));
      }

      @Generated
      public Nested1_449cd480(ColorRGBA var1, Vec3d var2, long var3) {
         this.I_field_d0c8ec5 = var1;
         this.I_field_5bba0d50 = var2;
         this.I_field_4a = var3;
      }

      @Generated
      public void I_method_f3a0710(Vec3d var1) {
         this.I_field_5bba0d50 = var1;
      }

      @Generated
      public long I_method_dd5dff2e() {
         return this.I_field_4a;
      }
   }
}
