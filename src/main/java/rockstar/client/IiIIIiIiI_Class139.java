package rockstar.client;

import globals.client.Information;
import globals.shared.proto.Packets;
import java.util.Comparator;
import java.util.function.Function;
import lombok.Generated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Team;
import net.minecraft.util.Formatting;

public class IiIIIiIiI_Class139 implements iIIiIIiIi_Class294 {
   boolean I_field_5a;
   boolean i_field_5a;
   boolean II_field_5a;
   boolean Ii_field_5a;
   boolean iI_field_5a;
   boolean ii_field_5a;
   boolean III_field_5a;
   boolean IIi_field_5a;
   boolean IiI_field_5a;
   float I_field_46 = -1.0F;
   Function<Entity, Float> I_field_aad1658 = var1 -> this.I_field_46;
   Comparator<Entity> I_field_c8f916f9;

   public IiIIIiIiI_Class139() {
      this.I_field_c8f916f9 = IiIIIiIII_Class137.I_field_c8f916f9;
   }

   public boolean I_method_b72bafcb(Entity var1) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && var1 != null) {
         if (var1 instanceof IiiiiiiIi_Class254
            && RockstarClient.getInstance().getModuleManager().getModule(FreeCameraModule.class).isEnabled()) {
            return false;
         } else if (var1 instanceof LivingEntity && var1 != I_field_3a9bda27.player) {
            if (var1 instanceof LivingEntity var2 && var2.isDead()) {
               return false;
            } else if (!this.i_method_72232feb((Entity)var1)) {
               return false;
            } else if (var1 instanceof ArmorStandEntity) {
               return this.IIi_field_5a && (this.iI_field_5a || !var1.isInvisible());
            } else {
               if (!this.Ii_field_5a) {
                  for (Packets.Nested1_1da0dac9 var3 : Information.getVisiblePlayers()) {
                     if (var3.gameInfo() != null && var3.gameInfo().nickname() != null && var3.gameInfo().nickname().equals(var1.getName().getString())) {
                        return false;
                     }
                  }
               }

               switch (var1) {
                  case PlayerEntity var4:
                     if (AntiBotModule.I_method_fe179c75(var4)) {
                        return false;
                     } else {
                        boolean var10 = RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var4.getName().getString());
                        if (var10 && (RockstarClient.getInstance().I_method_7a5acaeb().isFriendlyFireProtection() || !this.III_field_5a)) {
                           return false;
                        } else if (this.IiI_field_5a && I_method_b9048f8d(I_field_3a9bda27.player, var4)) {
                           return false;
                        } else {
                           boolean var11 = this.I_method_8225ce38(var4);
                           boolean var7 = var4.isInvisible();
                           if (!var7 || this.iI_field_5a || this.I_field_5a && !var11) {
                              if (!this.I_field_5a && !this.ii_field_5a) {
                                 return false;
                              }

                              if (this.I_field_5a && this.ii_field_5a) {
                                 return true;
                              }

                              if (!this.I_field_5a) {
                                 return false;
                              }

                              return !var11;
                           }

                           return false;
                        }
                     }
                  case AnimalEntity var5:
                     if (var5.isInvisible() && !this.iI_field_5a) {
                        return false;
                     }

                     return this.i_field_5a;
                  case MobEntity var6:
                     if (var6.isInvisible() && !this.iI_field_5a) {
                        return false;
                     }

                     return this.II_field_5a;
                  default:
                     return false;
               }
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   public final boolean i_method_72232feb(Entity var1) {
      if (I_field_3a9bda27.player == null) {
         return false;
      } else {
         float var2 = this.I_field_aad1658.apply(var1);
         return var2 <= 0.0F ? true : I_field_3a9bda27.player.getEyePos().distanceTo(iiIIiIiIi_Class406.I_method_396699c1(var1)) <= var2;
      }
   }

   private boolean I_method_8225ce38(PlayerEntity var1) {
      for (ItemStack var3 : var1.getAllArmorItems()) {
         if (var3 != null && !var3.isEmpty()) {
            return false;
         }
      }

      return true;
   }

   public static boolean I_method_b9048f8d(PlayerEntity var0, PlayerEntity var1) {
      if (var0 != null && var1 != null && var0 != var1) {
         Team var2 = var0.getScoreboardTeam();
         Team var3 = var1.getScoreboardTeam();
         if (var2 != null && var3 != null) {
            Formatting var4 = var2.getColor();
            Formatting var5 = var3.getColor();
            boolean var6 = var4 != null && var4 != Formatting.RESET;
            boolean var7 = var5 != null && var5 != Formatting.RESET;
            if (var6 && var7) {
               return var4 == var5;
            } else {
               String var8 = var2.getName();
               String var9 = var3.getName();
               return var8 != null && !var8.isBlank() && var8.equals(var9);
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Generated
   public boolean I_method_a15ec2a3() {
      return this.I_field_5a;
   }

   @Generated
   public boolean i_method_a16d4e83() {
      return this.i_field_5a;
   }

   @Generated
   public boolean II_method_8a8888a6() {
      return this.II_field_5a;
   }

   @Generated
   public boolean Ii_method_8a971486() {
      return this.Ii_field_5a;
   }

   @Generated
   public boolean iI_method_8c4b78c6() {
      return this.iI_field_5a;
   }

   @Generated
   public boolean ii_method_8c5a04a6() {
      return this.ii_field_5a;
   }

   @Generated
   public boolean III_method_c6978303() {
      return this.III_field_5a;
   }

   @Generated
   public boolean IIi_method_c6a60ee3() {
      return this.IIi_field_5a;
   }

   @Generated
   public boolean IiI_method_c85a7323() {
      return this.IiI_field_5a;
   }

   @Generated
   public float I_method_a15ec28f() {
      return this.I_field_46;
   }

   @Generated
   public Function<Entity, Float> I_method_65fd0121() {
      return this.I_field_aad1658;
   }

   @Generated
   public Comparator<Entity> I_method_1e9cc50() {
      return this.I_field_c8f916f9;
   }

   public static class Nested1_a87537e0 {
      private final IiIIIiIiI_Class139 I_field_74daf2ec = new IiIIIiIiI_Class139();

      public IiIIIiIiI_Class139.Nested1_a87537e0 I_method_1f3a928b(boolean var1) {
         this.I_field_74daf2ec.I_field_5a = var1;
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 i_method_da3212ab(boolean var1) {
         this.I_field_74daf2ec.i_field_5a = var1;
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 II_method_9a5032be(boolean var1) {
         this.I_field_74daf2ec.II_field_5a = var1;
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 Ii_method_5547b2de(boolean var1) {
         this.I_field_74daf2ec.Ii_field_5a = var1;
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 iI_method_3e48b69e(boolean var1) {
         this.I_field_74daf2ec.iI_field_5a = var1;
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 ii_method_f94036be(boolean var1) {
         this.I_field_74daf2ec.ii_field_5a = var1;
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 III_method_81ee98eb(boolean var1) {
         this.I_field_74daf2ec.III_field_5a = var1;
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 IIi_method_3ce6190b(boolean var1) {
         this.I_field_74daf2ec.IIi_field_5a = var1;
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 IiI_method_25e71ccb(boolean var1) {
         this.I_field_74daf2ec.IiI_field_5a = var1;
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 I_method_7d0aed77(float var1) {
         this.I_field_74daf2ec.I_field_46 = var1;
         this.I_field_74daf2ec.I_field_aad1658 = var1x -> var1;
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 I_method_a0c5cd89(Function<Entity, Float> var1) {
         this.I_field_74daf2ec.I_field_aad1658 = var1;
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 I_method_8fd609a4(Comparator<Entity> var1) {
         this.I_field_74daf2ec.I_field_c8f916f9 = var1;
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 i_method_ef79dda9(Function<Entity, Double> var1) {
         this.I_field_74daf2ec.I_field_c8f916f9 = IiIIIiIII_Class137.I_method_a351cdbc(var1);
         return this;
      }

      public IiIIIiIiI_Class139.Nested1_a87537e0 II_method_8415f33c(Function<Entity, Double> var1) {
         this.I_field_74daf2ec.I_field_c8f916f9 = IiIIIiIII_Class137.i_method_e6c1a19c(var1);
         return this;
      }

      public IiIIIiIiI_Class139 I_method_7ebd8d70() {
         return this.I_field_74daf2ec;
      }
   }
}
