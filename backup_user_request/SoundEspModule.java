package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.sound.SoundInstance;
import net.minecraft.client.sound.WeightedSoundSet;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.MutableText;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.SoundEvent;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.utility.render.CustomDrawContext;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Sound ESP",
   category = ModuleCategory.VISUALS,
   iI_method_476ab839 = true,
   III_method_a89e5834 = "modules.descriptions.sound_esp"
)
public class SoundEspModule extends Module {
   private MultiSelectSetting I_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
   private IIiIIi_Class10 I_field_856d0221 = null;
   private final List<SoundEspModule.Nested1_e01c0a0> I_field_7865b31 = new ArrayList<>();
   private final IiIIIiII_Class69<SoundEvent> I_field_3d936f41 = var1 -> {
      SoundInstance var2 = var1.getSound();
      if (this.I_method_9b42bc7e(var2)) {
         SoundEspModule.Nested1_e01c0a0 var3 = new SoundEspModule.Nested1_e01c0a0(var1.getSound());
         this.I_field_7865b31.add(var3);
      }
   };
   private final IiIIIiII_Class69<PreHudRenderEvent> i_field_3d936f41 = var1 -> {
      if (this.I_field_856d0221 == null) {
         this.I_field_856d0221 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(12.0F);
      }

      this.I_field_7865b31.removeIf(SoundEspModule.Nested1_e01c0a0::I_method_40c7a71e);
      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      iiIIIIIii_Class388 var2 = new iiIIIIIii_Class388(VertexFormats.POSITION_COLOR, var1.getContext().getMatrices());

      for (SoundEspModule.Nested1_e01c0a0 var4 : this.I_field_7865b31) {
         var4.I_method_edbfa07e(var1.getContext(), this.I_field_856d0221, SoundEspModule.Nested1_e01c080.I_field_f5ee2607);
      }

      var2.II_method_ed687102();

      for (SoundEspModule.Nested1_e01c0a0 var8 : this.I_field_7865b31) {
         var8.I_method_edbfa07e(var1.getContext(), this.I_field_856d0221, SoundEspModule.Nested1_e01c080.i_field_f5ee2607);
      }

      iiIIIIIIi_Class386 var7 = new iiIIIIIIi_Class386(VertexFormats.POSITION_TEXTURE_COLOR, this.I_field_856d0221.I_method_36d49b4b());

      for (SoundEspModule.Nested1_e01c0a0 var5 : this.I_field_7865b31) {
         var5.I_method_edbfa07e(var1.getContext(), this.I_field_856d0221, SoundEspModule.Nested1_e01c080.II_field_f5ee2607);
      }

      var7.II_method_ed687102();
      RenderSystem.disableBlend();
   };

   public SoundEspModule() {
      this.IiI_method_1e6a4e7f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_1e6a4e7f() {
      this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.sound_esp.select");
      this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.sound_esp.select.trident").select();
      this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.sound_esp.select.tnt");
      this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.sound_esp.select.fireworks").select();
   }

   private boolean I_method_9b42bc7e(SoundInstance var1) {
      String var2 = var1.getId().toString().toLowerCase();
      if (var2.equals("minecraft:entity.generic.explode") && this.i_field_51de8227.isSelected()) {
         return true;
      } else {
         return (var2.equals("minecraft:item.trident.throw") || var2.equals("minecraft:item.trident.return")) && this.I_field_51de8227.isSelected()
            ? true
            : var2.equals("minecraft:entity.firework_rocket.launch") && this.II_field_51de8227.isSelected();
      }
   }

   static enum Nested1_e01c080 {
      I_field_f5ee2607,
      i_field_f5ee2607,
      II_field_f5ee2607;
   }

   static class Nested1_e01c0a0 {
      private final SoundInstance I_field_d7d4c7bb;
      private final Vec3d I_field_5bba0d50;
      private final iiIiIIiii_Class424 I_field_991c1e8c;

      Nested1_e01c0a0(SoundInstance var1) {
         this.I_field_d7d4c7bb = var1;
         this.I_field_5bba0d50 = new Vec3d(var1.getX(), var1.getY(), var1.getZ());
         this.I_field_991c1e8c = new iiIiIIiii_Class424();
      }

      void I_method_edbfa07e(CustomDrawContext var1, IIiIIi_Class10 var2, SoundEspModule.Nested1_e01c080 var3) {
         if (iIIiIIiIi_Class294.I_field_3a9bda27.player != null) {
            Vec3d var4 = this.I_field_5bba0d50.add(0.0, 0.5, 0.0);
            float var5 = (float)iIIiIIiIi_Class294.I_field_3a9bda27.player.getPos().distanceTo(this.I_field_5bba0d50);
            WeightedSoundSet var6 = this.I_field_d7d4c7bb.getSoundSet(iIIiIIiIi_Class294.I_field_3a9bda27.getSoundManager());
            if (var6 != null && var6.getSubtitle() != null) {
               MutableText var7 = var6.getSubtitle().copy().append(" (").append(String.format("%.0f", var5) + "m").append(")");
               Vec2f var8 = iIiiiiIII_Class377.I_method_211fc242(var4);
               if (var8 != null) {
                  float var9 = MathHelper.clamp(1.0F - var5 / 20.0F, 0.5F, 1.0F);
                  float var10 = this.I_method_2286345d(var8) / 255.0F;
                  Item var11 = this.I_method_deb64b50();
                  float var12 = var11 != null ? 18.0F : 0.0F;
                  MatrixStack var13 = var1.getMatrices();
                  var13.push();
                  var13.translate(var8.x, var8.y, 0.0F);
                  var13.scale(var9, var9, 1.0F);
                  float var14 = var2.I_method_d8d0de4a(var7);
                  float var15 = var14 + var12;
                  float var16 = -var15 / 2.0F;
                  switch (var3) {
                     case I_field_f5ee2607:
                        float var17 = var2.I_method_a649725c();
                        float var18 = 4.0F;
                        float var19 = 2.0F;
                        var1.drawRect(
                           var16 - var19,
                           -var18,
                           var15 + var19 * 2.0F,
                           var17 + var18 * 2.0F,
                           IiiiiIIIi_Class242.iI_field_d0c8ec5.mulAlpha(0.5F).mulAlpha(var10)
                        );
                        break;
                     case i_field_f5ee2607:
                        if (var11 != null) {
                           RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var10);
                           DiffuseLighting.disableGuiDepthLighting();
                           var1.drawItem(new ItemStack(var11), (int)var16, -3);
                           DiffuseLighting.enableGuiDepthLighting();
                           RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                        }
                        break;
                     case II_field_f5ee2607:
                        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, var10);
                        var1.drawText(var2, var7, (int)(var16 + var12), 0.0F);
                        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                  }

                  var13.pop();
               }
            }
         }
      }

      private Item I_method_deb64b50() {
         String var1 = this.I_field_d7d4c7bb.getId().toString().toLowerCase();

         return switch (var1) {
            case "minecraft:entity.generic.explode" -> Items.TNT;
            case "minecraft:item.trident.throw", "minecraft:item.trident.return" -> Items.TRIDENT;
            case "minecraft:entity.firework_rocket.launch" -> Items.FIREWORK_ROCKET;
            default -> null;
         };
      }

      public boolean I_method_40c7a71e() {
         return this.I_field_991c1e8c.I_method_58432069(5000L);
      }

      private float I_method_2286345d(Vec2f var1) {
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
