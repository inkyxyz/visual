package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicBoolean;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;

public final class iiiiIIIiI_Class483 implements iiiiIIiII_Class485 {
   private final iiiIIiiii_Class464 I_field_fa3d426c;
   @Nullable
   private iiiIIIiii_Class456 I_field_f87a524c;
   @Nullable
   private CompletableFuture<Optional<iiiIIIiiI_Class455>> I_field_b866bf5e;
   private boolean I_field_5a;
   private boolean i_field_5a;
   @Nullable
   private String I_field_523beb0a;
   private long I_field_4a = 0L;
   private int I_field_49 = 0;
   private static final int i_field_49 = 8;
   private static final int II_field_49 = 12;
   private static final long i_field_4a = 2500L;
   @Nullable
   private CompletableFuture<Optional<iiiIIIiiI_Class455>> i_field_b866bf5e;
   @Nullable
   private iiiIIIiiI_Class455 I_field_f87a4e6c;
   @Nullable
   private iiiIIiIIi_Class458 I_field_fa2e3e6c;
   private int Ii_field_49 = -1;
   private long II_field_4a;
   @Nullable
   private AtomicBoolean I_field_1232aa16;
   private boolean II_field_5a;
   private static final double I_field_44 = 3.5;
   private static final int iI_field_49 = 60;
   private int ii_field_49 = -1;
   private int III_field_49;
   private boolean Ii_field_5a;
   private int IIi_field_49;
   private static final double i_field_44 = 2.0;
   private static final int IiI_field_49 = 80;

   public iiiiIIIiI_Class483(iiiIIiiii_Class464 var1) {
      this.I_field_fa3d426c = var1;
   }

   @Override
   public String I_method_31075c81() {
      return "goto";
   }

   @Override
   public String i_method_c4260ca1() {
      if (this.I_field_5a) {
         return "\u043f\u0430\u0443\u0437\u0430";
      } else if (this.i_field_5a) {
         return "\u0433\u043e\u0442\u043e\u0432\u043e";
      } else if (this.I_field_b866bf5e != null && !this.I_field_b866bf5e.isDone()) {
         return "\u043f\u043e\u0438\u0441\u043a \u043f\u0443\u0442\u0438...";
      } else {
         return this.I_field_f87a524c == null
            ? "\u043f\u0443\u0442\u044c \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d"
            : "\u0448\u0430\u0433 "
               + (this.I_field_f87a524c.I_method_7d7f71f2() + 1)
               + "/"
               + this.I_field_f87a524c.I_method_24228ed5().i_method_6a8fca68().size();
      }
   }

   @Override
   public boolean I_method_8f3b7603() {
      if (this.I_field_5a) {
         return false;
      } else if (this.i_field_5a) {
         return true;
      } else {
         MinecraftClient var1 = MinecraftClient.getInstance();
         if (var1.player == null) {
            return false;
         } else {
            iiIiiIiII_Class437.I_method_d9acc61f();
            if (this.i_method_e5a34d2a(var1)) {
               return false;
            } else if (this.Ii_field_5a) {
               return this.II_method_b808bd8d(var1);
            } else {
               if (this.I_field_b866bf5e != null) {
                  if (!this.I_field_b866bf5e.isDone()) {
                     this.i_method_e5a34d26(var1);
                     return false;
                  }

                  Optional var2 = this.I_field_b866bf5e.getNow(Optional.empty());
                  this.I_field_b866bf5e = null;
                  if (var2.isEmpty()) {
                     iiiIIIIii_Class452.i_method_e5eeaa09("\u041f\u0443\u0442\u044c \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d");
                     this.I_field_523beb0a = "\u043f\u0443\u0442\u044c \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d";
                     this.I_method_8f3b75ff();
                     return true;
                  }

                  iiiIIIiiI_Class455 var3 = (iiiIIIiiI_Class455)var2.get();
                  this.I_field_f87a524c = new iiiIIIiii_Class456(var3, this.I_field_fa3d426c);
                  iiIiiIiIi_Class438.I_method_12f562b5().I_method_49f9c0a7(this.I_field_f87a524c);
                  iiiIIIIii_Class452.II_method_e906ca6c(
                     "\u041f\u0443\u0442\u044c \u043d\u0430\u0439\u0434\u0435\u043d: " + var3.i_method_6a8fca68().size() + " \u0448\u0430\u0433\u043e\u0432"
                  );
                  iiIiiIiiI_Class439.I_method_d84555da(this.I_method_31075c81(), var3.i_method_6a8fca68().size());
               }

               if (this.I_field_f87a524c == null) {
                  this.III_method_6856eabf();
                  this.i_method_e5a34d26(var1);
                  return false;
               } else if (this.ii_field_49 >= 0) {
                  this.I_method_f8fca946(var1);
                  return false;
               } else if (this.Ii_method_36bb4c6()) {
                  if (this.I_method_f8fca94a(var1)) {
                     return false;
                  } else {
                     this.III_method_6856eabf();
                     this.I_field_f87a524c = null;
                     iiIiiIiIi_Class438.I_method_12f562b5().I_method_49f9c0a7(null);
                     return false;
                  }
               } else {
                  this.Ii_method_36bb4c2();
                  this.iI_method_5201902();
                  int var9 = this.I_field_f87a524c.I_method_7d7f71f2();
                  iiiIIIiii_Class456.Nested1_98c1c480 var10 = this.I_field_f87a524c.I_method_a5c86c30();
                  this.I_method_af9d8b02(var9, this.I_field_f87a524c);
                  switch (var10) {
                     case I_field_c32ea207:
                        return false;
                     case i_field_c32ea207:
                        if (this.I_field_fa3d426c
                           .I_method_ad4f4c08((int)Math.floor(var1.player.getX()), (int)Math.floor(var1.player.getY()), (int)Math.floor(var1.player.getZ()))) {
                           iiiIIIIii_Class452.I_method_15375629("\u0414\u043e\u0448\u043b\u0438 \u0434\u043e \u0446\u0435\u043b\u0438");
                           this.i_field_5a = true;
                           this.IIi_method_6865769f();
                           return true;
                        } else if (this.I_field_f87a4e6c != null
                           && this.I_field_fa2e3e6c != null
                           && this.I_field_fa2e3e6c.equals(this.I_field_f87a524c.I_method_24228ed5().i_method_3563f6d5())) {
                           iiiIIIiiI_Class455 var11 = this.I_field_f87a4e6c;
                           this.I_field_f87a4e6c = null;
                           this.I_field_fa2e3e6c = null;
                           this.II_field_5a = false;
                           this.I_field_f87a524c = new iiiIIIiii_Class456(var11, this.I_field_fa3d426c);
                           iiIiiIiIi_Class438.I_method_12f562b5().I_method_49f9c0a7(this.I_field_f87a524c);
                           iiIiiIiiI_Class439.I_method_d84555da(this.I_method_31075c81(), var11.i_method_6a8fca68().size());
                           return false;
                        } else {
                           this.ii_method_52ea4e2();
                           this.I_field_f87a524c = null;
                           iiIiiIiIi_Class438.I_method_12f562b5().I_method_49f9c0a7(null);
                           Vec3d var4 = this.I_field_fa3d426c.I_method_f4d54579();
                           double var5 = Math.hypot(var4.x - var1.player.getX(), var4.z - var1.player.getZ());
                           double var7 = var4.y - var1.player.getY();
                           if (var5 <= 2.0 && var7 > -3.5 && var7 < 0.62) {
                              this.Ii_field_5a = true;
                              this.IIi_field_49 = 0;
                              return false;
                           }

                           this.III_method_6856eabf();
                           return false;
                        }
                     case II_field_c32ea207:
                        this.I_field_49++;
                        if (this.I_field_49 > 5) {
                           iiiIIIIii_Class452.i_method_e5eeaa09(
                              "\u0421\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u043d\u043e\u0433\u043e \u0441\u0431\u043e\u0435\u0432, \u043e\u0441\u0442\u0430\u043d\u0430\u0432\u043b\u0438\u0432\u0430\u0435\u043c\u0441\u044f"
                           );
                           this.I_field_523beb0a = "\u0441\u043b\u0438\u0448\u043a\u043e\u043c \u043c\u043d\u043e\u0433\u043e \u0441\u0431\u043e\u0435\u0432";
                           this.I_method_8f3b75ff();
                           return true;
                        }

                        this.ii_method_52ea4e2();
                        this.I_field_f87a524c = null;
                        iiIiiIiIi_Class438.I_method_12f562b5().I_method_49f9c0a7(null);
                        this.III_method_6856eabf();
                        return false;
                     default:
                        return false;
                  }
               }
            }
         }
      }
   }

   private void Ii_method_36bb4c2() {
      if (this.I_field_f87a524c != null && this.i_field_b866bf5e == null && this.I_field_f87a4e6c == null) {
         List var1 = this.I_field_f87a524c.I_method_24228ed5().i_method_6a8fca68();
         int var2 = var1.size() - this.I_field_f87a524c.I_method_7d7f71f2();
         iiiIIiIIi_Class458 var3 = this.I_field_f87a524c.I_method_24228ed5().i_method_3563f6d5();
         boolean var4 = this.I_field_fa3d426c.I_method_ad4f4c08(var3.I_method_6d204e12(), var3.i_method_6d2ed9f2(), var3.II_method_36f86d15());
         if (var2 <= 8) {
            if (!var4 && !this.II_field_5a) {
               this.Ii_field_49 = -1;
               this.I_field_fa2e3e6c = var3;
               this.I_field_1232aa16 = new AtomicBoolean();
               this.i_field_b866bf5e = iiiIIiIII_Class457.I_method_e443eca3(var3, this.I_field_fa3d426c, this.I_field_1232aa16);
            }
         } else if (!var4) {
            long var5 = System.currentTimeMillis();
            if (var5 - this.II_field_4a >= 2500L) {
               int var7 = this.I_field_f87a524c.I_method_7d7f71f2() + 12;
               if (var7 < var1.size()) {
                  this.II_field_4a = var5;
                  this.Ii_field_49 = var7;
                  this.I_field_fa2e3e6c = this.I_field_f87a524c.I_method_24228ed5().I_method_b5439248().get(var7);
                  this.I_field_1232aa16 = new AtomicBoolean();
                  this.i_field_b866bf5e = iiiIIiIII_Class457.I_method_e443eca3(this.I_field_fa2e3e6c, this.I_field_fa3d426c, this.I_field_1232aa16);
               }
            }
         }
      }
   }

   private void iI_method_5201902() {
      if (this.i_field_b866bf5e != null && this.i_field_b866bf5e.isDone()) {
         Optional var1 = this.i_field_b866bf5e.getNow(Optional.empty());
         this.i_field_b866bf5e = null;
         boolean var2 = this.Ii_field_49 >= 0;
         if (!var1.isEmpty() && !((iiiIIIiiI_Class455)var1.get()).i_method_6a8fca68().isEmpty()) {
            if (var2) {
               this.I_method_2f8b867((iiiIIIiiI_Class455)var1.get());
               this.Ii_field_49 = -1;
               this.I_field_fa2e3e6c = null;
            } else {
               this.I_field_f87a4e6c = (iiiIIIiiI_Class455)var1.get();
            }
         } else {
            if (!var2) {
               this.II_field_5a = true;
            }

            this.Ii_field_49 = -1;
            if (var2) {
               this.I_field_fa2e3e6c = null;
            }
         }
      }
   }

   private void I_method_2f8b867(iiiIIIiiI_Class455 var1) {
      if (this.I_field_f87a524c != null && this.I_field_fa2e3e6c != null) {
         List var2 = this.I_field_f87a524c.I_method_24228ed5().I_method_b5439248();
         List var3 = this.I_field_f87a524c.I_method_24228ed5().i_method_6a8fca68();
         int var4 = this.I_field_f87a524c.I_method_7d7f71f2();
         int var5 = this.Ii_field_49;
         if (var5 > var4 && var5 < var2.size() && ((iiiIIiIIi_Class458)var2.get(var5)).equals(this.I_field_fa2e3e6c)) {
            if (var1.I_method_1fce82f5().equals(this.I_field_fa2e3e6c)) {
               iiiIIiIIi_Class458 var6 = this.I_field_f87a524c.I_method_24228ed5().i_method_3563f6d5();
               iiiIIiIIi_Class458 var7 = var1.i_method_3563f6d5();
               boolean var8 = this.I_field_fa3d426c.I_method_ad4f4c08(var7.I_method_6d204e12(), var7.i_method_6d2ed9f2(), var7.II_method_36f86d15());
               if (var8
                  || !(
                     this.I_field_fa3d426c.I_method_ad4f4bf2(var7.I_method_6d204e12(), var7.i_method_6d2ed9f2(), var7.II_method_36f86d15())
                        >= this.I_field_fa3d426c.I_method_ad4f4bf2(var6.I_method_6d204e12(), var6.i_method_6d2ed9f2(), var6.II_method_36f86d15()) - 1.0
                  )) {
                  ArrayList var9 = new ArrayList(var2.subList(var4, var5 + 1));
                  var9.addAll(var1.I_method_b5439248().subList(1, var1.I_method_b5439248().size()));
                  ArrayList var10 = new ArrayList(var3.subList(var4, var5));
                  var10.addAll(var1.i_method_6a8fca68());
                  this.I_field_f87a524c = new iiiIIIiii_Class456(new iiiIIIiiI_Class455(var9, var10), this.I_field_fa3d426c);
                  iiIiiIiIi_Class438.I_method_12f562b5().I_method_49f9c0a7(this.I_field_f87a524c);
                  iiIiiIiiI_Class439.I_method_d84555da(this.I_method_31075c81(), var10.size());
               }
            }
         }
      }
   }

   private void ii_method_52ea4e2() {
      if (this.I_field_1232aa16 != null) {
         this.I_field_1232aa16.set(true);
      }

      this.I_field_1232aa16 = null;
      this.i_field_b866bf5e = null;
      this.I_field_f87a4e6c = null;
      this.I_field_fa2e3e6c = null;
      this.Ii_field_49 = -1;
      this.II_field_5a = false;
   }

   private boolean I_method_f8fca94a(MinecraftClient var1) {
      if (this.I_field_f87a524c != null && var1.player != null) {
         iiiIIIiIi_Class454 var2;
         try {
            var2 = new iiiIIIiIi_Class454();
         } catch (IllegalStateException var23) {
            return false;
         }

         List var3 = this.I_field_f87a524c.I_method_24228ed5().I_method_b5439248();
         double var4 = var1.player.getX();
         double var6 = var1.player.getY();
         double var8 = var1.player.getZ();
         int var10 = this.I_field_f87a524c.I_method_7d7f71f2();
         int var11 = Math.min(var3.size() - 1, var10 + 15);
         int var12 = -1;
         double var13 = 3.5;

         for (int var15 = var10; var15 <= var11; var15++) {
            iiiIIiIIi_Class458 var16 = (iiiIIiIIi_Class458)var3.get(var15);
            double var17 = var16.i_method_6d2ed9f2() - var6;
            if (!(var17 > 1.2) && !(var17 < -2.5)) {
               double var19 = Math.hypot(var16.I_method_6d204e12() + 0.5 - var4, var16.II_method_36f86d15() + 0.5 - var8);
               if (!(var19 >= var13)) {
                  double var21 = Math.max(var6, (double)var16.i_method_6d2ed9f2()) + 0.05;
                  if (var2.I_method_7085e723(
                     (int)Math.floor(var4), (int)Math.floor(var8), var16.I_method_6d204e12(), var16.II_method_36f86d15(), var21, var6 + 1.85
                  )) {
                     var12 = var15;
                     var13 = var19;
                  }
               }
            }
         }

         if (var12 < 0) {
            return false;
         } else {
            this.ii_field_49 = var12;
            this.III_field_49 = 0;
            iiIiiIiIi_Class438.I_method_12f562b5().I_method_49f9c0a7(null);
            return true;
         }
      } else {
         return false;
      }
   }

   private void I_method_f8fca946(MinecraftClient var1) {
      if (var1.player != null && this.I_field_f87a524c != null) {
         List var2 = this.I_field_f87a524c.I_method_24228ed5().I_method_b5439248();
         if (this.ii_field_49 >= var2.size()) {
            this.ii_field_49 = -1;
         } else {
            iiiIIiIIi_Class458 var3 = (iiiIIiIIi_Class458)var2.get(this.ii_field_49);
            double var4 = var1.player.getX();
            double var6 = var1.player.getY();
            double var8 = var1.player.getZ();
            double var10 = Math.hypot(var3.I_method_6d204e12() + 0.5 - var4, var3.II_method_36f86d15() + 0.5 - var8);
            double var12 = var6 - var3.i_method_6d2ed9f2();
            if (var10 < 0.5 && var12 > -1.2 && var12 < 1.2) {
               this.I_field_f87a524c.I_method_326f40e4(this.ii_field_49);
               iiIiiIiIi_Class438.I_method_12f562b5().I_method_49f9c0a7(this.I_field_f87a524c);
               this.ii_field_49 = -1;
            } else if (++this.III_field_49 <= 60 && !(var10 > 6.0)) {
               float var14 = (float)Math.toDegrees(Math.atan2(var3.II_method_36f86d15() + 0.5 - var8, var3.I_method_6d204e12() + 0.5 - var4)) - 90.0F;
               iiIiiIiII_Class437.I_method_cb5ea4a7(new iiIIiIIii_Class404(var14, 0.0F));
               iiIiiiiii_Class448 var15 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
               var15.I_method_359d223f();
               var15.III_method_52d38c15(false);
               var15.i_method_7fcac895(false);
               var15.II_method_44ae3612(false);
               var15.Ii_method_46712632(false);
               var15.ii_method_7d0c3a12(false);
               var15.I_method_7e07d875(true);
               boolean var16 = var1.player.isTouchingWater()
                  ? var6 < var3.i_method_6d2ed9f2() + 0.2
                  : var1.player.horizontalCollision && var1.player.isOnGround();
               var15.iI_method_7b4949f2(var16);
            } else {
               this.ii_field_49 = -1;
               this.I_field_f87a524c = null;
               this.III_method_6856eabf();
            }
         }
      } else {
         this.ii_field_49 = -1;
      }
   }

   private boolean i_method_e5a34d2a(MinecraftClient var1) {
      if (var1.player == null) {
         return false;
      } else if (!var1.player.isSubmergedInWater()) {
         return false;
      } else if (var1.player.getAir() >= 80) {
         return false;
      } else {
         iiIiiIiII_Class437.I_method_cb5ea4a7(new iiIIiIIii_Class404(var1.player.getYaw(), -90.0F));
         iiIiiiiii_Class448 var2 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
         var2.I_method_359d223f();
         var2.I_method_7e07d875(true);
         var2.i_method_7fcac895(false);
         var2.II_method_44ae3612(false);
         var2.Ii_method_46712632(false);
         var2.ii_method_7d0c3a12(false);
         var2.III_method_52d38c15(true);
         var2.iI_method_7b4949f2(true);
         return true;
      }
   }

   private void i_method_e5a34d26(MinecraftClient var1) {
      iiIiiiiii_Class448 var2 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
      var2.I_method_359d223f();
      var2.I_method_7e07d875(false);
      var2.i_method_7fcac895(false);
      var2.II_method_44ae3612(false);
      var2.Ii_method_46712632(false);
      var2.III_method_52d38c15(false);
      var2.ii_method_7d0c3a12(false);
      var2.iI_method_7b4949f2(var1.player != null && var1.player.isTouchingWater());
   }

   private boolean Ii_method_36bb4c6() {
      MinecraftClient var1 = MinecraftClient.getInstance();
      if (var1.player != null && this.I_field_f87a524c != null) {
         iiiIiIIII_Class465 var2 = this.I_field_f87a524c.I_method_5aae9eb5();
         if (var2 == null) {
            return false;
         } else {
            double var3 = var1.player.getX();
            double var5 = var1.player.getY();
            double var7 = var1.player.getZ();
            iiiIIiIIi_Class458 var9 = var2.I_method_48c58ad5();
            iiiIIiIIi_Class458 var10 = var2.i_method_5e5afeb5();
            double var11 = Math.hypot(var3 - (var9.I_method_6d204e12() + 0.5), var7 - (var9.II_method_36f86d15() + 0.5))
               + Math.abs(var5 - var9.i_method_6d2ed9f2());
            double var13 = Math.hypot(var3 - (var10.I_method_6d204e12() + 0.5), var7 - (var10.II_method_36f86d15() + 0.5))
               + Math.abs(var5 - var10.i_method_6d2ed9f2());
            return Math.min(var11, var13) > 2.5;
         }
      } else {
         return false;
      }
   }

   private void III_method_6856eabf() {
      long var1 = System.currentTimeMillis();
      if (var1 - this.I_field_4a >= 250L) {
         this.I_field_4a = var1;
         if (this.I_field_b866bf5e == null || this.I_field_b866bf5e.isDone()) {
            this.ii_method_52ea4e2();
            MinecraftClient var3 = MinecraftClient.getInstance();
            if (var3.player != null) {
               iiiIIiIIi_Class458 var4 = iiiIIiIiI_Class459.I_method_cae0235c(var3);
               this.I_field_b866bf5e = iiiIIiIII_Class457.I_method_7ef4ea55(var4, this.I_field_fa3d426c);
            }
         }
      }
   }

   @Override
   public void I_method_8f3b75ff() {
      this.IIi_method_6865769f();
   }

   @Override
   public void i_method_8f4a01df() {
      this.I_field_5a = true;
      iiIiiiiii_Class448 var1 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
      var1.I_method_7e07d875(false);
      var1.i_method_7fcac895(false);
      var1.II_method_44ae3612(false);
      var1.Ii_method_46712632(false);
      var1.iI_method_7b4949f2(false);
      var1.III_method_52d38c15(false);
   }

   @Override
   public void II_method_58424142() {
      this.I_field_5a = false;
   }

   @Override
   public boolean i_method_8f4a01e3() {
      return this.I_field_5a;
   }

   @Override
   public boolean II_method_58424146() {
      return this.i_field_5a;
   }

   @Nullable
   @Override
   public String II_method_f53e1f9e() {
      return this.I_field_523beb0a;
   }

   private void I_method_af9d8b02(int var1, iiiIIIiii_Class456 var2) {
      List var3 = var2.I_method_24228ed5().i_method_6a8fca68();
      int var4 = var3.size();
      int var5 = Math.min(var2.I_method_7d7f71f2(), var4);

      for (int var6 = Math.max(var1, 0); var6 < var5; var6++) {
         iiiIIiIIi_Class458 var7 = ((iiiIiIIII_Class465)var3.get(var6)).i_method_5e5afeb5();
         iiIiiIiiI_Class439.I_method_1d99019a(
            this.I_method_31075c81(), var7.I_method_6d204e12(), var7.i_method_6d2ed9f2(), var7.II_method_36f86d15(), var6 + 1, var4
         );
      }
   }

   private boolean II_method_b808bd8d(MinecraftClient var1) {
      if (var1.player == null) {
         return false;
      } else {
         int var2 = (int)Math.floor(var1.player.getX());
         int var3 = (int)Math.floor(var1.player.getY());
         int var4 = (int)Math.floor(var1.player.getZ());
         if (this.I_field_fa3d426c.I_method_ad4f4c08(var2, var3, var4)) {
            iiiIIIIii_Class452.I_method_15375629("\u0414\u043e\u0448\u043b\u0438 \u0434\u043e \u0446\u0435\u043b\u0438");
            this.i_field_5a = true;
            this.Ii_field_5a = false;
            this.IIi_method_6865769f();
            return true;
         } else {
            Vec3d var5 = this.I_field_fa3d426c.I_method_f4d54579();
            double var6 = var5.x - var1.player.getX();
            double var8 = var5.z - var1.player.getZ();
            double var10 = Math.hypot(var6, var8);
            if (!(var10 > 3.0) && this.IIi_field_49++ <= 100) {
               iiIiiiiii_Class448 var12 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
               var12.I_method_359d223f();
               var12.III_method_52d38c15(false);
               var12.iI_method_7b4949f2(false);
               var12.i_method_7fcac895(false);
               var12.II_method_44ae3612(false);
               var12.Ii_method_46712632(false);
               var12.ii_method_7d0c3a12(false);
               if (var10 < 0.15) {
                  var12.I_method_7e07d875(false);
               } else {
                  if (var10 > 0.35) {
                     float var13 = (float)Math.toDegrees(Math.atan2(var8, var6)) - 90.0F;
                     iiIiiIiII_Class437.I_method_cb5ea4a7(new iiIIiIIii_Class404(var13, 0.0F));
                  }

                  var12.I_method_7e07d875(true);
               }

               return false;
            } else {
               this.Ii_field_5a = false;
               this.III_method_6856eabf();
               return false;
            }
         }
      }
   }

   private void IIi_method_6865769f() {
      iiIiiiiii_Class448 var1 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
      var1.i_method_35abae1f();
      this.I_field_f87a524c = null;
      this.I_field_b866bf5e = null;
      this.Ii_field_5a = false;
      this.ii_field_49 = -1;
      this.ii_method_52ea4e2();
      iiIiiIiIi_Class438.I_method_12f562b5().I_method_49f9c0a7(null);
   }

   @Generated
   public iiiIIiiii_Class464 I_method_f0df7335() {
      return this.I_field_fa3d426c;
   }
}
