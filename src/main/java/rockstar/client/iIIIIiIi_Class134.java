package rockstar.client;

import globals.client.Information;
import globals.shared.proto.Packets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import pyrock.events.render.Render3DEvent;

public class iIIIIiIi_Class134 extends IiiiIiiI_Class119 {
   private final Object I_field_5f790d9c;
   private final BooleanSetting I_field_ba20ca4c;
   private volatile iIIIIiIi_Class134.Nested1_716a3913 I_field_39eb19bc;
   private volatile iIIIIiIi_Class134.Nested1_716a38f3 I_field_39eb15dc;
   private volatile Predicate<Entity> I_field_93e25d0f;
   private final IiIIIiII_Class69<Render3DEvent> I_field_3d936f41 = var1x -> {
      if (this.I_field_39eb19bc != null || this.I_field_39eb15dc != null) {
         if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
            if (IiiiiiiI_Class127.I_method_731950d0() && this.I_method_ea8b70b0()) {
               ArrayList var2x = new ArrayList();

               for (Entity var4 : I_field_3a9bda27.world.getEntities()) {
                  if (this.I_method_9adfa4de(var4) && (this.I_field_93e25d0f == null || this.I_field_93e25d0f.test(var4))) {
                     var2x.add(var4);
                  }
               }

               if (!var2x.isEmpty()) {
                  iIIIIiIi_Class134.Nested1_716a38f3 var7 = this.I_field_39eb15dc;
                  if (var7 != null) {
                     var7.render(var2x, var1x);
                  } else {
                     iIIIIiIi_Class134.Nested1_716a3913 var8 = this.I_field_39eb19bc;
                     if (var8 != null) {
                        for (Entity var6 : (Iterable<Entity>)(Iterable<?>)var2x) {
                           var8.render(var6, var1x);
                        }
                     }
                  }
               }
            }
         }
      }
   };

   public iIIIIiIi_Class134(Object var1, String var2, IiiiiIiI_Class123... var3) {
      super(var2, new IiiiIiii_Class120[]{IiiiIiii_Class120.i_field_10f66741}, var3);
      this.I_field_5f790d9c = var1;
      this.I_field_ba20ca4c = this.I_method_5436696c(var2);
   }

   public Object I_method_c594c006() {
      return this.I_field_5f790d9c;
   }

   public BooleanSetting I_method_39762f22() {
      return this.I_field_ba20ca4c;
   }

   public void I_method_4f73aae8(iIIIIiIi_Class134.Nested1_716a3913 var1) {
      this.I_field_39eb19bc = var1;
   }

   public void I_method_4f651f08(iIIIIiIi_Class134.Nested1_716a38f3 var1) {
      this.I_field_39eb15dc = var1;
   }

   public void I_method_aed029bb(Predicate<Entity> var1) {
      this.I_field_93e25d0f = var1;
   }

   public void I_method_f29f4d(IiiiiIiI_Class123 var1) {
      this.I_method_54b913ca(new IiiiiIiI_Class123[]{var1});
   }

   public void I_method_ff2faf2d(IiiiiIII_Class121 var1) {
      this.I_method_52f623aa(new IiiiiIII_Class121[]{var1});
   }

   private boolean I_method_9adfa4de(Entity var1) {
      if (var1 instanceof PlayerEntity var2) {
         if (!this.I_method_bcf84b51(IiiiiIiI_Class123.I_field_12aac7a1)) {
            return false;
         } else if (var2 == I_field_3a9bda27.player) {
            return this.i_method_d0cacf11(IiiiiIII_Class121.i_field_12aa4f81);
         } else if (I_method_7ebdf005(var2)) {
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
      } else {
         return var1 instanceof ItemEntity ? this.i_method_6c6ff6d1(IiiiIiii_Class120.i_field_10f66741) : false;
      }
   }

   private static boolean I_method_7ebdf005(PlayerEntity var0) {
      String var1 = var0.getName().getString();

      for (Packets.Nested1_1da0dac9 var3 : Information.getVisiblePlayers()) {
         if (var3.gameInfo() != null && var1.equals(var3.gameInfo().nickname())) {
            return true;
         }
      }

      return false;
   }

   public interface Nested1_716a38f3 {
      void render(List<Entity> var1, Render3DEvent var2);
   }

   public interface Nested1_716a3913 {
      void render(Entity var1, Render3DEvent var2);
   }
}
