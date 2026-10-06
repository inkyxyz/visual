package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import lombok.Generated;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Object Info",
   category = ModuleCategory.VISUALS,
   III_method_a89e5834 = "modules.descriptions.object_info"
)
public class ObjectInfoModule extends Module {
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private final Map<BlockPos, ObjectInfoModule.Nested1_a997e460> I_field_a567c40b = new HashMap<>();
   private final List<ObjectInfoModule.Nested1_a997e440> I_field_7865b31 = new ArrayList<>();
   static final Random I_field_6ece06ac = new Random();
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = var1 -> {
      if (var1.getPacket() instanceof PlaySoundS2CPacket var2) {
         String var5 = var2.getSound().getIdAsString();
         if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
            if (var5.contains("minecraft:block.anvil.place")
               && (var2.getVolume() == 0.5F || var2.getVolume() == 0.7F)
               && (var2.getPitch() == 1.1F || var2.getPitch() == 0.5F)) {
               BlockPos var4 = new BlockPos((int)var2.getX(), (int)var2.getY(), (int)var2.getZ());
               this.I_field_a567c40b
                  .put(var4, new ObjectInfoModule.Nested1_a997e460(var4.up().add(0, 0, 0), ObjectInfoModule.Nested1_8964a409.ii_field_d672d086));
            }

            if ((var5.contains("minecraft:entity.wither.break_block") || var5.contains("minecraft:block.anvil.place")) && var2.getVolume() == 0.7F
               || var2.getVolume() == 0.2F && var2.getPitch() == 1.0F) {
               BlockPos var6 = new BlockPos((int)var2.getX(), (int)var2.getY(), (int)var2.getZ());
               this.I_field_a567c40b
                  .put(var6, new ObjectInfoModule.Nested1_a997e460(var6.up().add(0, 0, 0), ObjectInfoModule.Nested1_8964a409.I_field_d672d086));
            }
         } else if (iIIIiiiII_Class285.Ii_method_b349c526()) {
            if (var5.contains("minecraft:entity.generic.explode") && (var2.getVolume() == 1.0F || var2.getPitch() == 1.0F)) {
               BlockPos var7 = new BlockPos((int)var2.getX(), (int)var2.getY(), (int)var2.getZ());
               this.I_field_a567c40b.put(var7, new ObjectInfoModule.Nested1_a997e460(var7, ObjectInfoModule.Nested1_8964a409.iI_field_d672d086));
               this.I_field_a567c40b.put(var7.up(), new ObjectInfoModule.Nested1_a997e460(var7.up(), ObjectInfoModule.Nested1_8964a409.Ii_field_d672d086));
            }

            if (var5.contains("minecraft:block.beacon.deactivate") && (var2.getVolume() == 1.5 || var2.getPitch() == 1.0F)) {
               BlockPos var8 = new BlockPos((int)var2.getX(), (int)var2.getY(), (int)var2.getZ());
               this.I_field_a567c40b.put(var8, new ObjectInfoModule.Nested1_a997e460(var8, ObjectInfoModule.Nested1_8964a409.iI_field_d672d086));
            }
         }
      }
   };
   private final IiIIIiII_Class69<PreHudRenderEvent> i_field_3d936f41 = var1 -> {
      try {
         for (ObjectInfoModule.Nested1_a997e460 var3 : this.I_field_a567c40b.values()) {
            var3.I_method_164aa01d(var1);
         }
      } catch (ConcurrentModificationException var4) {
      }
   };
   private final IiIIIiII_Class69<Render3DEvent> II_field_3d936f41 = var1 -> {
      MatrixStack var2 = var1.getMatrices();
      var2.push();
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
      RenderSystem.enableDepthTest();
      RenderSystem.disableCull();
      RenderSystem.depthMask(false);
      Identifier var3 = RockstarClient.id("textures/bloom.png");
      RenderSystem.setShaderTexture(0, var3);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      BufferBuilder var4 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
      BlockPos var5 = null;

      try {
         for (Entry var7 : this.I_field_a567c40b.entrySet()) {
            ObjectInfoModule.Nested1_a997e460 var8 = (ObjectInfoModule.Nested1_a997e460)var7.getValue();
            var2.push();
            var8.I_method_e007f15(var1, var4);
            var2.pop();
            if (var8.I_field_991c1e8c.I_method_58432069(var8.I_method_75658402().I_method_a1e77d45())) {
               this.I_method_c9b41e02(var8);
               var5 = (BlockPos)var7.getKey();
            }
         }
      } catch (ConcurrentModificationException var9) {
      }

      Iterator var10 = this.I_field_7865b31.iterator();

      while (var10.hasNext()) {
         ObjectInfoModule.Nested1_a997e440 var11 = (ObjectInfoModule.Nested1_a997e440)var10.next();
         if (var11.I_method_3d96c77e()) {
            var10.remove();
         } else {
            var11.I_method_3d96c77a();
            var11.I_method_1072cef5(var1, var4);
         }
      }

      if (var5 != null) {
         this.I_field_a567c40b.remove(var5);
      }

      iIiiiIIiI_Class371.I_method_c59155f0(var4);
      RenderSystem.depthMask(true);
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.disableBlend();
      RenderSystem.enableCull();
      RenderSystem.disableDepthTest();
      var2.pop();
   };
   private final IiIIIiII_Class69<WorldChangeEvent> Ii_field_3d936f41 = var1 -> {
      this.I_field_a567c40b.clear();
      this.I_field_7865b31.clear();
   };

   public ObjectInfoModule() {
      this.IiI_method_51d482bf();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_51d482bf() {
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.object_info.particleMode");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.object_info.particleMode.gravity");
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.object_info.particleMode.scatter");
   }

   private void I_method_c9b41e02(ObjectInfoModule.Nested1_a997e460 var1) {
      if (var1.I_field_d672d086 == ObjectInfoModule.Nested1_8964a409.iI_field_d672d086) {
         Vec3d var2 = var1.I_field_670402ba.toCenterPos();
         float[][] var3 = new float[][]{
            {15.0F, -15.0F, 15.0F, 0.0F, 1.0F, 0.0F},
            {-15.0F, -15.0F, 15.0F, 0.0F, 1.0F, 0.0F},
            {15.0F, -15.0F, -15.0F, 0.0F, 1.0F, 0.0F},
            {-15.0F, -15.0F, -15.0F, 0.0F, 1.0F, 0.0F},
            {-15.0F, 15.0F, 15.0F, 1.0F, 0.0F, 0.0F},
            {-15.0F, -15.0F, 15.0F, 1.0F, 0.0F, 0.0F},
            {-15.0F, 15.0F, -15.0F, 1.0F, 0.0F, 0.0F},
            {-15.0F, -15.0F, -15.0F, 1.0F, 0.0F, 0.0F},
            {15.0F, 15.0F, -15.0F, 0.0F, 0.0F, 1.0F},
            {-15.0F, 15.0F, -15.0F, 0.0F, 0.0F, 1.0F},
            {15.0F, -15.0F, -15.0F, 0.0F, 0.0F, 1.0F},
            {-15.0F, -15.0F, -15.0F, 0.0F, 0.0F, 1.0F}
         };

         for (float[] var7 : var3) {
            for (float var8 = 0.0F; var8 < 30.0F; var8 += 0.2F) {
               float var9 = var7[0] + var8 * var7[3];
               float var10 = var7[1] + var8 * var7[4];
               float var11 = var7[2] + var8 * var7[5];
               float var12 = 0.005F;
               float var13 = (I_field_6ece06ac.nextFloat() - 0.5F) * 2.0F * var12;
               float var14 = (I_field_6ece06ac.nextFloat() - 0.5F) * 2.0F * var12;
               float var15 = (I_field_6ece06ac.nextFloat() - 0.5F) * 2.0F * var12;
               this.I_field_7865b31
                  .add(
                     new ObjectInfoModule.Nested1_a997e440(
                        var2, var9, var10, var11, var13, var14, var15, this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)
                     )
                  );
            }
         }
      }
   }

   static enum Nested1_8964a409 {
      I_field_d672d086("object_info.trap", Items.NETHERITE_SCRAP, 15000L),
      i_field_d672d086("object_info.dragon", Items.NETHERITE_SCRAP, 30000L),
      II_field_d672d086("object_info.dragon", Items.NETHERITE_SCRAP, 60000L),
      Ii_field_d672d086("object_info.boom_trap", Items.PRISMARINE_SHARD, 11000L),
      iI_field_d672d086("object_info.stan", Items.NETHER_STAR, 15000L),
      ii_field_d672d086("object_info.plast", Items.DRIED_KELP, 20000L);

      final String I_field_523beb0a;
      final Item I_field_3c05b08c;
      final long I_field_4a;

      public String I_method_3fc4a36f() {
         return IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a);
      }

      @Generated
      public String i_method_d2e3538f() {
         return this.I_field_523beb0a;
      }

      @Generated
      public Item I_method_5994ac87() {
         return this.I_field_3c05b08c;
      }

      @Generated
      public long I_method_a1e77d45() {
         return this.I_field_4a;
      }

      @Generated
      private Nested1_8964a409(String var3, Item var4, long var5) {
         this.I_field_523beb0a = var3;
         this.I_field_3c05b08c = var4;
         this.I_field_4a = var5;
      }
   }

   class Nested1_a997e440 {
      double I_field_44;
      double i_field_44;
      double II_field_44;
      float I_field_46;
      float i_field_46;
      float II_field_46;
      long I_field_4a;
      float Ii_field_46 = 1.0F;
      float iI_field_46 = 2.5F;
      float ii_field_46;
      long i_field_4a;
      boolean I_field_5a;
      float III_field_46;
      static final float IIi_field_46 = 0.4F;

      Nested1_a997e440(Vec3d var2, float var3, float var4, float var5, float var6, float var7, float var8, boolean var9) {
         this.I_field_44 = var2.x + var3;
         this.i_field_44 = var2.y + var4;
         this.II_field_44 = var2.z + var5;
         this.I_field_46 = var6;
         this.i_field_46 = var7;
         this.II_field_46 = var8;
         this.I_field_4a = System.currentTimeMillis();
         this.I_field_5a = var9;
         this.ii_field_46 = 2.0E-4F + ObjectInfoModule.I_field_6ece06ac.nextFloat() * 4.0E-4F;
         this.i_field_4a = 2000 + ObjectInfoModule.I_field_6ece06ac.nextInt(2000);
         this.III_field_46 = var9 ? 0.9999F : 0.999F;
      }

      void I_method_3d96c77a() {
         if (this.I_field_5a) {
            this.i_field_46 = this.i_field_46 - this.ii_field_46;
         }

         this.I_field_46 = this.I_field_46 * this.III_field_46;
         this.i_field_46 = this.i_field_46 * this.III_field_46;
         this.II_field_46 = this.II_field_46 * this.III_field_46;
         double var1 = this.I_field_44 + this.I_field_46;
         double var3 = this.i_field_44 + this.i_field_46;
         double var5 = this.II_field_44 + this.II_field_46;
         if (this.I_field_5a) {
            BlockPos var7 = BlockPos.ofFloored(this.I_field_44, var3 - 0.5, this.II_field_44);
            if (!iIIiIIiIi_Class294.I_field_3a9bda27.world.getBlockState(var7).isAir()) {
               this.i_field_46 = -this.i_field_46 * 0.4F;
               var3 = this.i_field_44;
            }

            BlockPos var8 = BlockPos.ofFloored(var1, this.i_field_44, this.II_field_44);
            if (!iIIiIIiIi_Class294.I_field_3a9bda27.world.getBlockState(var8).isAir()) {
               this.I_field_46 = -this.I_field_46 * 0.4F;
               var1 = this.I_field_44;
            }

            BlockPos var9 = BlockPos.ofFloored(this.I_field_44, this.i_field_44, var5);
            if (!iIIiIIiIi_Class294.I_field_3a9bda27.world.getBlockState(var9).isAir()) {
               this.II_field_46 = -this.II_field_46 * 0.4F;
               var5 = this.II_field_44;
            }
         }

         this.I_field_44 = var1;
         this.i_field_44 = var3;
         this.II_field_44 = var5;
      }

      float I_method_3d96c76a() {
         return MathHelper.clamp((float)(System.currentTimeMillis() - this.I_field_4a) / (float)this.i_field_4a, 0.0F, 1.0F);
      }

      float i_method_3da5534a() {
         return 1.0F - this.I_method_3d96c76a();
      }

      boolean I_method_3d96c77e() {
         return System.currentTimeMillis() - this.I_field_4a > this.i_field_4a;
      }

      void I_method_1072cef5(Render3DEvent var1, BufferBuilder var2) {
         MatrixStack var3 = var1.getMatrices();
         Camera var4 = iIIiIIiIi_Class294.I_field_3a9bda27.gameRenderer.getCamera();
         float var5 = this.i_method_3da5534a();
         var3.push();
         iIiiiIIiI_Class371.I_method_7d461059(var3, new Vec3d(this.I_field_44, this.i_field_44, this.II_field_44));
         var3.multiply(var4.getRotation());
         iIiiIIiii_Class360.I_method_a9f124df(
            var3,
            var2,
            -this.Ii_field_46 / 2.0F,
            -this.Ii_field_46 / 2.0F,
            0.0,
            this.Ii_field_46,
            this.Ii_field_46,
            IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(0.9F * var5)
         );
         iIiiIIiii_Class360.I_method_a9f124df(
            var3,
            var2,
            -this.iI_field_46 / 2.0F,
            -this.iI_field_46 / 2.0F,
            0.0,
            this.iI_field_46,
            this.iI_field_46,
            IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(0.1F * var5)
         );
         var3.pop();
      }
   }

   static class Nested1_a997e460 {
      final BlockPos I_field_670402ba;
      final ObjectInfoModule.Nested1_8964a409 I_field_d672d086;
      iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();

      void I_method_164aa01d(PreHudRenderEvent var1) {
         int var2 = (int)((float)(this.I_field_d672d086.I_method_a1e77d45() - this.I_field_991c1e8c.I_method_23e11e33()) / 1000.0F);
         MatrixStack var3 = var1.getContext().getMatrices();
         BlockPos var4 = this.I_field_670402ba;
         Vec3d var5 = var4.add(0, 1, 0).toCenterPos();
         Vec2f var6 = iIiiiiIII_Class377.I_method_211fc242(var5);
         if (var6 != null) {
            float var7 = (float)iIIiIIiIi_Class294.I_field_3a9bda27.player.getPos().distanceTo(Vec3d.of(var4));
            float var8 = MathHelper.clamp(1.0F - var7 / 20.0F, 0.5F, 1.0F) * 0.5F;
            float var9 = 1.0F - (float)this.I_field_991c1e8c.I_method_23e11e33() / (float)this.I_field_d672d086.I_method_a1e77d45();
            String var10 = "0:" + (var2 < 10 ? "0" + var2 : var2);
            float var11 = 150.0F;
            float var12 = 150.0F;
            var3.push();
            var3.translate(var6.x - var11 / 2.0F, var6.y - var12 / 2.0F, 0.0F);
            iIiiiIIiI_Class371.II_method_e18635ac(var3, var11 / 2.0F, var12 / 2.0F, var8);
            var1.getContext()
               .drawBlurredRect(0.0F, 0.0F, var11, var12, 45.0F, 5.0F, IIiii_Class8.I_method_893b2757(26.0F), IiiiiIIIi_Class242.Ii_field_d0c8ec5);
            var1.getContext()
               .drawSquircle(0.0F, 0.0F, var11, var12, 5.0F, IIiii_Class8.I_method_893b2757(26.0F), new ColorRGBA(9.0F, 9.0F, 11.0F).mulAlpha(0.5F));
            var1.getContext().drawCircleProgress(var11 / 2.0F, var12 / 2.0F, 48.0F, 6.0F, var9, IiiiiIIIi_Class242.i_method_5dfec6e());
            var1.getContext().drawItem(this.I_field_d672d086.I_method_5994ac87(), 60.0F, 50.0F, 1.875F);
            var1.getContext()
               .drawCenteredText(IIiIiI_Class11.ii_field_857c0621.I_method_3a2d5e3(20.0F), var10, var11 / 2.0F, 86.0F, IiiiiIIIi_Class242.iI_method_8e08d3b1());
            iIiiiIIiI_Class371.I_method_10503b11(var3);
            var3.pop();
         }
      }

      void I_method_e007f15(Render3DEvent var1, BufferBuilder var2) {
         if (this.I_field_d672d086 == ObjectInfoModule.Nested1_8964a409.iI_field_d672d086) {
            float var3 = 1.0F;
            float var4 = 2.5F;
            MatrixStack var5 = var1.getMatrices();
            Camera var6 = iIIiIIiIi_Class294.I_field_3a9bda27.gameRenderer.getCamera();
            iIiiiIIiI_Class371.I_method_7d461059(var5, this.I_field_670402ba.toCenterPos());
            float[][] var7 = new float[][]{
               {15.0F, -15.0F, 15.0F, 0.0F, 1.0F, 0.0F},
               {-15.0F, -15.0F, 15.0F, 0.0F, 1.0F, 0.0F},
               {15.0F, -15.0F, -15.0F, 0.0F, 1.0F, 0.0F},
               {-15.0F, -15.0F, -15.0F, 0.0F, 1.0F, 0.0F},
               {-15.0F, 15.0F, 15.0F, 1.0F, 0.0F, 0.0F},
               {-15.0F, -15.0F, 15.0F, 1.0F, 0.0F, 0.0F},
               {-15.0F, 15.0F, -15.0F, 1.0F, 0.0F, 0.0F},
               {-15.0F, -15.0F, -15.0F, 1.0F, 0.0F, 0.0F},
               {15.0F, 15.0F, -15.0F, 0.0F, 0.0F, 1.0F},
               {-15.0F, 15.0F, -15.0F, 0.0F, 0.0F, 1.0F},
               {15.0F, -15.0F, -15.0F, 0.0F, 0.0F, 1.0F},
               {-15.0F, -15.0F, -15.0F, 0.0F, 0.0F, 1.0F}
            };

            for (float[] var11 : var7) {
               for (float var12 = 0.0F; var12 < 30.0F; var12 += 0.2F) {
                  var5.push();
                  var5.translate(var11[0] + var12 * var11[3], var11[1] + var12 * var11[4], var11[2] + var12 * var11[5]);
                  var5.multiply(var6.getRotation());
                  iIiiIIiii_Class360.I_method_a9f124df(
                     var5, var2, -var3 / 2.0F, -var3 / 2.0F, 0.0, var3, var3, IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(0.9F)
                  );
                  iIiiIIiii_Class360.I_method_a9f124df(
                     var5, var2, -var4 / 2.0F, -var4 / 2.0F, 0.0, var4, var4, IiiiiIIIi_Class242.i_method_5dfec6e().mulAlpha(0.1F)
                  );
                  var5.pop();
               }
            }
         }
      }

      @Generated
      public BlockPos I_method_1e389836() {
         return this.I_field_670402ba;
      }

      @Generated
      public ObjectInfoModule.Nested1_8964a409 I_method_75658402() {
         return this.I_field_d672d086;
      }

      @Generated
      public iiIiIIiii_Class424 I_method_80a67c90() {
         return this.I_field_991c1e8c;
      }

      @Generated
      public Nested1_a997e460(BlockPos var1, ObjectInfoModule.Nested1_8964a409 var2) {
         this.I_field_670402ba = var1;
         this.I_field_d672d086 = var2;
      }
   }
}
