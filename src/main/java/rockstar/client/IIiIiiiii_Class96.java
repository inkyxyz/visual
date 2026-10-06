package rockstar.client;

import globals.shared.proto.Packets;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lombok.Generated;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.entry.RegistryEntry;
import pyrock.events.render.HudRenderEvent;
import pyrock.utility.render.ColorRGBA;

public class IIiIiiiii_Class96 {
   private final List<IIiIiiiiI_Class95> I_field_7865b31 = new ArrayList<>();
   private final IiIIIiII_Class69<HudRenderEvent> I_field_3d936f41 = var1 -> {
      EnumMap var2 = new EnumMap<>(IIiIiiiii_Class96.Nested1_465fc480.class);

      for (IIiIiiiii_Class96.Nested1_465fc480 var6 : IIiIiiiii_Class96.Nested1_465fc480.values()) {
         var2.put(var6, 0.0F);
      }

      for (IIiIiiiiI_Class95 var8 : this.I_field_7865b31) {
         IIiIiiiii_Class96.Nested1_465fc480 var9 = I_method_f8c71af8(var8);
         float var10 = (Float)var2.get(var9);
         var8.I_method_4c865e1f();
         var8.I_method_df9d7d83(var1.getContext(), var10);
         if (var8.I_field_dc7facc.I_method_6ac4da6f() >= 0.5F) {
            var2.put(var9, var10 + 30.0F);
         }
      }

      this.I_field_7865b31.removeIf(IIiIiiiiI_Class95::I_method_4c865e23);
   };

   public IIiIiiiii_Class96() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   public final void I_method_bd45d2f1(IIiiIIIII_Class97 var1, String var2) {
      this.I_field_7865b31.add(new IIiiIIIiI_Class99(var1, var2));
   }

   public final void I_method_ba60827b(IIiiIIIII_Class97 var1, String var2, String var3) {
      this.I_field_7865b31.add(new IIiiIIIIi_Class98(var1, var2, var3));
   }

   public final void I_method_3e267b76(Packets.Nested1_e38dcab6 var1, String var2) {
      if (iIIiIIiIi_Class294.I_field_3a9bda27.player != null) {
         this.I_field_7865b31.add(new IIiiIIIii_Class100(var1, var2));
         iiIiIIIII_Class417.Ii_field_34b2ba6c.I_method_87d2e181(1.0F);
      }
   }

   public final void I_method_d4f65dab(String var1, ItemStack var2) {
      this.I_field_7865b31.add(new IIiiIIiII_Class101(var1, var2));
   }

   public final void I_method_5c1040c8(String var1, String var2, RegistryEntry<StatusEffect> var3) {
      this.I_field_7865b31.add(new IIiiIIiII_Class101(var1, var2, var3));
   }

   public final void I_method_25a77f6a(String var1, String var2, ItemStack var3, ColorRGBA var4) {
      this.I_field_7865b31.add(new IIiiIIiII_Class101(var1, var2, var3, var4));
   }

   public final void I_method_e608a9b5(String var1, String var2, ItemStack var3) {
      this.I_field_7865b31.add(new IIiiIIiII_Class101(var1, var2, var3));
   }

   private static IIiIiiiii_Class96.Nested1_465fc480 I_method_f8c71af8(IIiIiiiiI_Class95 var0) {
      if (var0 instanceof IIiiIIIii_Class100) {
         return IIiIiiiii_Class96.Nested1_465fc480.II_field_c950a207;
      } else {
         return var0 instanceof IIiiIIIIi_Class98 ? IIiIiiiii_Class96.Nested1_465fc480.i_field_c950a207 : IIiIiiiii_Class96.Nested1_465fc480.I_field_c950a207;
      }
   }

   @Generated
   public List<IIiIiiiiI_Class95> I_method_a804268() {
      return this.I_field_7865b31;
   }

   @Generated
   public IiIIIiII_Class69<HudRenderEvent> I_method_f7bafdb8() {
      return this.I_field_3d936f41;
   }

   static enum Nested1_465fc480 {
      I_field_c950a207,
      i_field_c950a207,
      II_field_c950a207;
   }
}
