package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import moscow.rockstar.mixin.accessors.AbstractSoundInstanceAccessor;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.TntEntity;
import net.minecraft.entity.projectile.thrown.PotionEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.ExplosionS2CPacket;
import net.minecraft.network.packet.s2c.play.PlaySoundS2CPacket;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.SoundEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Donate Effects",
   category = ModuleCategory.VISUALS,
   iI_method_476ab839 = true,
   III_method_a89e5834 = "modules.descriptions.donate_effects"
)
public class DonateEffectsModule extends Module {
   private BooleanSetting I_field_ba20ca4c;
   private BooleanSetting i_field_ba20ca4c;
   private BooleanSetting II_field_ba20ca4c;
   private static final float I_field_46 = 8.0F;
   private static final float i_field_46 = 1.0F;
   private static final float II_field_46 = 0.5F;
   private MultiSelectSetting I_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 III_field_51de8227;
   private final Map<Integer, DonateEffectsModule.Nested1_51152be9> I_field_a567c40b = new HashMap<>();
   private final List<DonateEffectsModule.Nested1_a7c6e060> I_field_7865b31 = new CopyOnWriteArrayList<>();
   private static final long I_field_4a = 1000L;
   private static final double I_field_44 = 4.0;
   private final Map<Integer, DonateEffectsModule.Nested1_a7c6e080> i_field_a567c40b = new ConcurrentHashMap<>();
   private static final Map<String, Identifier> II_field_a567c40b = Map.of(
      "potion-radiation",
      RockstarClient.id("icons/potions/radio.png"),
      "potion-paladin",
      RockstarClient.id("icons/potions/shield.png"),
      "potion-assassin",
      RockstarClient.id("icons/potions/sword.png"),
      "potion-holy-water",
      RockstarClient.id("icons/potions/holy.png"),
      "potion-popper",
      RockstarClient.id("icons/potions/bomb.png"),
      "potion-drowsiness",
      RockstarClient.id("icons/potions/moon.png"),
      "potion-rage",
      RockstarClient.id("icons/potions/angry.png")
   );
   private final IiIIIiII_Class69<ReceivePacketEvent> I_field_3d936f41 = var1 -> {
      if (this.I_field_ba20ca4c.i_method_9b12da03() || this.i_field_ba20ca4c.i_method_9b12da03()) {
         if (var1.getPacket() instanceof ExplosionS2CPacket var2 && this.I_method_dc319f8f(var2.center())) {
            this.I_method_3aeb8e94(this.ii_field_51de8227.isSelected(), var2.center(), 8.0F, 3.0F, 2.0F, new ColorRGBA(255.0F, 155.0F, 0.0F));
         }

         if (var1.getPacket() instanceof PlaySoundS2CPacket var4) {
            String var6 = var4.getSound().getIdAsString();
            if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
               if (var6.contains("minecraft:entity.illusioner.mirror_move") && (var4.getVolume() == 1.0F || var4.getPitch() == 0.0F)) {
                  this.I_method_514e54b(this.I_field_51de8227.isSelected(), I_method_4fd50139(var4), 20.0F, 1.5F, 2.0F);
               }

               if ((var6.contains("minecraft:entity.wither.break_block") || var6.contains("minecraft:block.piston.extend")) && var4.getVolume() == 0.7F
                  || var4.getVolume() == 0.2F && var4.getPitch() == 1.0F
                  || var4.getPitch() == 0.5) {
                  this.I_method_3aeb8e94(this.ii_field_51de8227.isSelected(), I_method_4fd50139(var4), 5.0F, 3.0F, 2.0F, new ColorRGBA(255.0F, 255.0F, 255.0F));
               }

               if (var6.contains("minecraft:entity.illusioner.cast_spell") && (var4.getVolume() == 1.0F || var4.getPitch() == 1.0F)) {
                  this.I_method_3aeb8e94(this.i_field_51de8227.isSelected(), I_method_4fd50139(var4), 5.0F, 3.0F, 2.0F, new ColorRGBA(255.0F, 255.0F, 255.0F));
               }

               if (var6.contains("minecraft:entity.illusioner.prepare_blindness") && (var4.getVolume() == 1.0F || var4.getPitch() == 0.0F)) {
                  this.I_method_3aeb8e94(this.II_field_51de8227.isSelected(), I_method_4fd50139(var4), 15.0F, 1.5F, 2.0F, new ColorRGBA(255.0F, 255.0F, 255.0F));
               }
            } else if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.Iii_field_ac164e6c)) {
               if (var6.contains("minecraft:item.firecharge.use") && (var4.getVolume() == 0.5 || var4.getPitch() == 1.0F)) {
                  this.I_method_3aeb8e94(this.Ii_field_51de8227.isSelected(), I_method_4fd50139(var4), 20.0F, 1.5F, 2.0F, new ColorRGBA(255.0F, 155.0F, 0.0F));
               }

               if (var6.contains("minecraft:block.beacon.activate") && (var4.getVolume() == 0.5 || var4.getPitch() == 1.0F)) {
                  this.I_method_3aeb8e94(this.i_field_51de8227.isSelected(), I_method_4fd50139(var4), 5.0F, 3.0F, 2.0F, new ColorRGBA(255.0F, 255.0F, 255.0F));
               }

               if (var6.contains("minecraft:entity.illusioner.mirror_move") && (var4.getVolume() == 0.5 || var4.getPitch() == 1.0F)) {
                  this.I_method_3aeb8e94(this.II_field_51de8227.isSelected(), I_method_4fd50139(var4), 15.0F, 1.5F, 2.0F, new ColorRGBA(255.0F, 255.0F, 255.0F));
               }

               if (var6.contains("minecraft:entity.illusioner.prepare_blindness") && (var4.getVolume() == 0.5 || var4.getPitch() == 1.0F)) {
                  this.I_method_514e54b(this.I_field_51de8227.isSelected(), I_method_4fd50139(var4), 20.0F, 1.5F, 2.0F);
               }
            } else if (iIIIiiiII_Class285.Ii_method_b349c526()) {
               if (var6.contains("minecraft:entity.generic.explode") && (var4.getVolume() == 1.0F || var4.getPitch() == 1.0F)) {
                  this.I_method_3aeb8e94(this.ii_field_51de8227.isSelected(), I_method_4fd50139(var4), 8.0F, 3.0F, 2.0F, new ColorRGBA(255.0F, 155.0F, 0.0F));
               }

               if (var6.contains("minecraft:block.beacon.deactivate") && (var4.getVolume() == 1.5 || var4.getPitch() == 1.0F)) {
                  this.I_method_3aeb8e94(
                     this.III_field_51de8227.isSelected(), I_method_4fd50139(var4), 25.0F, 1.5F, 2.0F, new ColorRGBA(255.0F, 255.0F, 255.0F)
                  );
               }
            }
         }
      }
   };
   private final IiIIIiII_Class69<SoundEvent> i_field_3d936f41 = var1 -> {
      if (this.I_field_ba20ca4c.i_method_9b12da03() || this.i_field_ba20ca4c.i_method_9b12da03()) {
         if (iIIIiiiII_Class285.Ii_method_b349c526()) {
            SoundInstance var2 = var1.getSound();
            if (var2 != null) {
               String var3 = var2.getId().toString();
               float var4 = ((AbstractSoundInstanceAccessor)(Object)var2).rockstar$getVolume();
               if (var3.equals("minecraft:entity.generic.explode") && var4 == 4.0F) {
                  BlockPos var5 = new BlockPos((int)var2.getX(), (int)var2.getY(), (int)var2.getZ());
                  this.I_method_3aeb8e94(this.iI_field_51de8227.isSelected(), var5.toCenterPos(), 4.0F, 1.5F, 2.0F, new ColorRGBA(255.0F, 155.0F, 0.0F));
               }
            }
         }
      }
   };
   private final IiIIIiII_Class69<WorldChangeEvent> II_field_3d936f41 = var1 -> {
      this.I_field_a567c40b.clear();
      this.I_field_7865b31.clear();
      this.i_field_a567c40b.clear();
   };
   private final IiIIIiII_Class69<Render3DEvent> Ii_field_3d936f41 = var1 -> {
      if (!this.I_field_7865b31.isEmpty()) {
         if (I_field_3a9bda27 != null && I_field_3a9bda27.world != null) {
            MatrixStack var2 = var1.getMatrices();
            var2.push();
            RenderSystem.enableBlend();
            RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
            RenderSystem.enableDepthTest();
            RenderSystem.disableCull();
            RenderSystem.depthMask(false);
            HashMap<Identifier, List<DonateEffectsModule.Nested1_a7c6e060>> var3 = new HashMap<>();

            for (DonateEffectsModule.Nested1_a7c6e060 var5 : this.I_field_7865b31) {
               var3.computeIfAbsent(var5.I_field_6a3d6525, var0 -> new ArrayList<>()).add(var5);
            }

            for (Entry var12 : (Iterable<Entry>)(Iterable<?>)var3.entrySet()) {
               Identifier var6 = (Identifier)var12.getKey();
               List var7 = (List)var12.getValue();
               RenderSystem.setShaderTexture(0, var6);
               RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
               BufferBuilder var8 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

               for (DonateEffectsModule.Nested1_a7c6e060 var10 : (Iterable<DonateEffectsModule.Nested1_a7c6e060>)(Iterable<?>)var7) {
                  if (!var10.I_method_28005f5e()) {
                     var10.I_method_28005f5a();
                     var10.I_method_74f97b15(var1, var8);
                  }
               }

               BuiltBuffer var13 = var8.endNullable();
               if (var13 != null) {
                  BufferRenderer.drawWithGlobalProgram(var13);
               }
            }

            this.I_field_7865b31.removeIf(DonateEffectsModule.Nested1_a7c6e060::I_method_28005f5e);
            RenderSystem.depthMask(true);
            RenderSystem.setShaderTexture(0, 0);
            RenderSystem.disableBlend();
            RenderSystem.enableCull();
            RenderSystem.disableDepthTest();
            var2.pop();
         }
      }
   };

   public DonateEffectsModule() {
      this.IiI_method_3c3e1a9f();
      iIiiIIIII_Class353.I_field_ca4d26c.I_method_7a2ce21f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_3c3e1a9f() {
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.donate_effects.sonar");
      this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.donate_effects.shockwave").I_method_decd82b5();
      this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.donate_effects.potions").I_method_decd82b5();
      this.I_field_bbe3ba6c = new MultiSelectSetting(
         this, "modules.settings.donate_effects.targets", () -> !this.I_field_ba20ca4c.i_method_9b12da03() && !this.i_field_ba20ca4c.i_method_9b12da03()
      );
      this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.donate_effects.targets.dez").select();
      this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.donate_effects.targets.aura").select();
      this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.donate_effects.targets.pil").select();
      this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.donate_effects.targets.fire").select();
      this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.donate_effects.targets.boom").select();
      this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.donate_effects.targets.trapka").select();
      this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.donate_effects.targets.stun").select();
   }

   private boolean I_method_dc319f8f(Vec3d var1) {
      long var2 = System.currentTimeMillis();

      for (DonateEffectsModule.Nested1_a7c6e080 var5 : this.i_field_a567c40b.values()) {
         if (var5.I_method_5e9b732e() > var2 && var5.I_method_c1945934().squaredDistanceTo(var1) <= 16.0) {
            return true;
         }
      }

      return false;
   }

   private void Iii_method_3c4ca67f() {
      if (I_field_3a9bda27.world == null) {
         if (!this.i_field_a567c40b.isEmpty()) {
            this.i_field_a567c40b.clear();
         }
      } else {
         long var1 = System.currentTimeMillis();

         for (Entity var4 : I_field_3a9bda27.world.getEntities()) {
            if (var4 instanceof TntEntity var5) {
               this.i_field_a567c40b.put(var5.getId(), new DonateEffectsModule.Nested1_a7c6e080(var5.getPos(), var1 + 1000L));
            }
         }

         this.i_field_a567c40b.values().removeIf(var2 -> var2.I_method_5e9b732e() <= var1);
      }
   }

   private static Vec3d I_method_4fd50139(PlaySoundS2CPacket var0) {
      return new BlockPos((int)var0.getX(), (int)var0.getY(), (int)var0.getZ()).toCenterPos();
   }

   private void I_method_514e54b(boolean var1, Vec3d var2, float var3, float var4, float var5) {
      this.I_method_3aeb8e94(var1, var2, var3, var4, var5, IiiiiIIIi_Class242.i_method_5dfec6e());
   }

   private void I_method_3aeb8e94(boolean var1, Vec3d var2, float var3, float var4, float var5, ColorRGBA var6) {
      if (this.I_field_ba20ca4c.i_method_9b12da03() && var1) {
         iIiiiIiii_Class376.I_field_434eee2c.I_method_9b9d710a(var2, var3, var4, var5, var6);
      }

      if (this.i_field_ba20ca4c.i_method_9b12da03()) {
         iIiiIIIII_Class353.I_field_ca4d26c.I_method_9f5a2f2c(var2, 8.0F, 1.0F, var6, 0.5F);
      }
   }

   @Override
   public void II_method_6642fd22() {
      super.II_method_6642fd22();
      this.Iii_method_3c4ca67f();
      if (!this.II_field_ba20ca4c.i_method_9b12da03()) {
         if (!this.I_field_a567c40b.isEmpty()) {
            this.I_field_a567c40b.clear();
         }
      } else if (I_field_3a9bda27 != null && I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         HashSet var1 = new HashSet();

         for (Entity var3 : I_field_3a9bda27.world.getEntities()) {
            if (var3 instanceof PotionEntity var4) {
               int var5 = var4.getId();
               var1.add(var5);
               DonateEffectsModule.Nested1_51152be9 var6 = this.I_field_a567c40b.get(var5);
               Vec3d var7 = var4.getPos();
               if (var6 != null) {
                  this.I_field_a567c40b.put(var5, new DonateEffectsModule.Nested1_51152be9(var7, var6.I_field_f2735522));
               } else {
                  this.I_field_a567c40b.put(var5, new DonateEffectsModule.Nested1_51152be9(var7, var4.getStack().copy()));
               }
            }
         }

         Iterator var23 = this.I_field_a567c40b.entrySet().iterator();

         while (var23.hasNext()) {
            Entry var24 = (Entry)var23.next();
            int var25 = (Integer)var24.getKey();
            if (!var1.contains(var25)) {
               DonateEffectsModule.Nested1_51152be9 var26 = (DonateEffectsModule.Nested1_51152be9)var24.getValue();
               Vec3d var27 = var26.I_field_5bba0d50;
               String var28 = IiiiiIiii_Class248.I_method_ba1e2b7f(var26.I_field_f2735522);
               if (var28 == null) {
                  var23.remove();
               } else {
                  Identifier var8 = II_field_a567c40b.getOrDefault(var28, RockstarClient.id("icons/add.png"));

                  ColorRGBA var9 = switch (var28) {
                     case "potion-radiation" -> new ColorRGBA(99.0F, 255.0F, 0.0F);
                     case "potion-paladin" -> new ColorRGBA(74.0F, 180.0F, 255.0F);
                     case "potion-assassin" -> new ColorRGBA(255.0F, 68.0F, 68.0F);
                     case "potion-holy-water" -> new ColorRGBA(255.0F, 255.0F, 255.0F);
                     case "potion-popper" -> new ColorRGBA(255.0F, 170.0F, 0.0F);
                     case "potion-drowsiness" -> new ColorRGBA(136.0F, 85.0F, 255.0F);
                     case "potion-rage" -> new ColorRGBA(255.0F, 69.0F, 0.0F);
                     default -> IiiiiIIIi_Class242.i_method_5dfec6e();
                  };

                  for (int var10 = 0; var10 < 20; var10++) {
                     double var29 = 1.5;
                     double var13 = Math.random() * Math.PI * 2.0;
                     double var15 = Math.sqrt(Math.random()) * var29;
                     double var17 = Math.cos(var13) * var15;
                     double var19 = Math.sin(var13) * var15;
                     Vec3d var21 = var27.add(var17, 0.0, var19);
                     boolean var22 = "potion-popper".equals(var28) || "potion-paladin".equals(var28);
                     this.I_field_7865b31.add(new DonateEffectsModule.Nested1_a7c6e060(var21, var9, var8, var22));
                  }

                  var23.remove();
               }
            }
         }
      }
   }

   static final class Nested1_51152be9 {
      final Vec3d I_field_5bba0d50;
      final ItemStack I_field_f2735522;

      Nested1_51152be9(Vec3d var1, ItemStack var2) {
         this.I_field_5bba0d50 = var1;
         this.I_field_f2735522 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_51152be9[pos=" + this.I_field_5bba0d50 + ", stack=" + this.I_field_f2735522 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         DonateEffectsModule.Nested1_51152be9 other = (DonateEffectsModule.Nested1_51152be9) var1;
         return java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
            && java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522);
      }

      public Vec3d I_method_d8f84d2b() {
         return this.I_field_5bba0d50;
      }

      public ItemStack I_method_40d02de7() {
         return this.I_field_f2735522;
      }
   }

   static class Nested1_a7c6e060 {
      double I_field_44;
      double i_field_44;
      double II_field_44;
      double Ii_field_44;
      double iI_field_44;
      double ii_field_44;
      long I_field_4a;
      long i_field_4a;
      ColorRGBA I_field_d0c8ec5;
      Identifier I_field_6a3d6525;
      boolean I_field_5a;

      Nested1_a7c6e060(Vec3d var1, ColorRGBA var2, Identifier var3, boolean var4) {
         this.I_field_44 = var1.x;
         this.i_field_44 = var1.y;
         this.II_field_44 = var1.z;
         this.I_field_d0c8ec5 = var2;
         this.I_field_6a3d6525 = var3;
         this.I_field_5a = var4;
         this.Ii_field_44 = 0.0;
         this.iI_field_44 = 0.003 + Math.random() * 0.003;
         this.ii_field_44 = 0.0;
         this.I_field_4a = System.currentTimeMillis();
         this.i_field_4a = 800L;
      }

      boolean I_method_28005f5e() {
         return System.currentTimeMillis() - this.I_field_4a > this.i_field_4a;
      }

      void I_method_28005f5a() {
         long var1 = System.currentTimeMillis();
         long var3 = var1 - this.I_field_4a;
         if (var3 >= 0L) {
            this.I_field_44 = this.I_field_44 + this.Ii_field_44;
            this.i_field_44 = this.i_field_44 + this.iI_field_44;
            this.II_field_44 = this.II_field_44 + this.ii_field_44;
         }
      }

      float I_method_28005f4a() {
         long var1 = System.currentTimeMillis() - this.I_field_4a;
         float var3 = MathHelper.clamp((float)var1 / (float)this.i_field_4a, 0.0F, 1.0F);
         return 1.0F - var3;
      }

      void I_method_74f97b15(Render3DEvent var1, BufferBuilder var2) {
         MatrixStack var3 = var1.getMatrices();
         Camera var4 = iIIiIIiIi_Class294.I_field_3a9bda27.gameRenderer.getCamera();
         float var5 = 0.15F;
         float var6 = this.I_method_28005f4a();
         var3.push();
         iIiiiIIiI_Class371.I_method_7d461059(var3, new Vec3d(this.I_field_44, this.i_field_44, this.II_field_44));
         var3.multiply(var4.getRotation());
         int var7 = this.I_field_5a ? 180 : 0;
         ColorRGBA var8 = this.I_field_d0c8ec5.mulAlpha(0.9F * var6);
         iIiiIIiii_Class360.I_method_9433ea04(var3, var2, -var5 / 2.0F, -var5 / 2.0F, 0.0, var5, var5, var8, var7);
         var3.pop();
      }
   }

   static final class Nested1_a7c6e080 {
      private final Vec3d I_field_5bba0d50;
      private final long I_field_4a;

      Nested1_a7c6e080(Vec3d var1, long var2) {
         this.I_field_5bba0d50 = var1;
         this.I_field_4a = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_a7c6e080[pos=" + this.I_field_5bba0d50 + ", expireAt=" + this.I_field_4a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         DonateEffectsModule.Nested1_a7c6e080 other = (DonateEffectsModule.Nested1_a7c6e080) var1;
         return java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a);
      }

      public Vec3d I_method_c1945934() {
         return this.I_field_5bba0d50;
      }

      public long I_method_5e9b732e() {
         return this.I_field_4a;
      }
   }
}
