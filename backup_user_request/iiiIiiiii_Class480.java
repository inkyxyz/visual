package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.registry.tag.FluidTags;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos.Mutable;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import org.jetbrains.annotations.Nullable;

public final class iiiIiiiii_Class480 implements iiiiIIiII_Class485 {
   private static final double I_field_44 = 0.08;
   private final int I_field_49;
   private final int i_field_49;
   private final int II_field_49;
   private final boolean I_field_5a;
   private final iiiIiiiii_Class480.Nested1_1863cfe9 I_field_275920a6 = new iiiIiiiii_Class480.Nested1_1863cfe9();
   private boolean i_field_5a;
   private boolean II_field_5a;
   @Nullable
   private String I_field_523beb0a;
   private boolean Ii_field_5a;
   private boolean iI_field_5a;
   private int Ii_field_49;
   private int iI_field_49;
   private int ii_field_49;
   private int III_field_49 = -100;
   private int IIi_field_49 = -1000;
   private double i_field_44 = Double.MAX_VALUE;
   private double II_field_44;
   private float I_field_46;
   private float i_field_46;
   private boolean ii_field_5a;
   private iiiIiiiii_Class480.Nested1_1863cfc9 I_field_27591cc6;
   private int IiI_field_49;
   private boolean III_field_5a;
   private int Iii_field_49;
   private int iII_field_49;
   private boolean IIi_field_5a;
   private boolean IiI_field_5a;
   private boolean Iii_field_5a;
   private int iIi_field_49;
   private int iiI_field_49;
   private boolean iII_field_5a;
   private int iii_field_49;
   private double Ii_field_44;
   private int IIII_field_49;
   private boolean iIi_field_5a;
   private int IIIi_field_49;
   @Nullable
   private Vec3d I_field_5bba0d50;
   private long I_field_4a;
   @Nullable
   private CompletableFuture<List<Vec3d>> I_field_b866bf5e;
   private List<Vec3d> I_field_7865b31;
   private int IIiI_field_49;
   private int IIii_field_49;
   private volatile List<Vec3d> i_field_7865b31;

   public iiiIiiiii_Class480(int var1, int var2, int var3, boolean var4) {
      this.I_field_27591cc6 = iiiIiiiii_Class480.Nested1_1863cfc9.I_field_27591cc6;
      this.I_field_4a = Long.MIN_VALUE;
      this.I_field_7865b31 = List.of();
      this.IIii_field_49 = -10000;
      this.i_field_7865b31 = List.of();
      this.I_field_49 = var1;
      this.i_field_49 = var2;
      this.II_field_49 = var3;
      this.I_field_5a = var4;
   }

   public iiiIiiiii_Class480(BlockPos var1) {
      this(var1.getX(), var1.getY(), var1.getZ(), true);
   }

   @Override
   public String I_method_31075c81() {
      return "elytra";
   }

   @Override
   public String i_method_c4260ca1() {
      if (this.i_field_5a) {
         return "\u043f\u0430\u0443\u0437\u0430";
      } else if (this.II_field_5a) {
         return "\u0433\u043e\u0442\u043e\u0432\u043e";
      } else if (this.iIi_field_5a) {
         return "\u043f\u043e\u0441\u0430\u0434\u043a\u0430";
      } else {
         int var1 = (int)Math.round(Math.sqrt(Math.max(0.0, this.i_field_44)));
         if (!this.Ii_field_5a) {
            return "\u0441\u0442\u0430\u0440\u0442";
         } else if (this.IIi_field_5a) {
            return "\u043e\u0431\u0445\u043e\u0434 \u0442\u0443\u043f\u0438\u043a\u0430";
         } else {
            return this.iII_field_5a
               ? "\u043e\u0431\u0445\u043e\u0434 \u043f\u043e \u0432\u044b\u0441\u043e\u0442\u0435"
               : (
                     this.ii_field_5a
                        ? "\u0430\u0432\u0430\u0440\u0438\u0439\u043d\u044b\u0439 \u043d\u0430\u0431\u043e\u0440 \u0432\u044b\u0441\u043e\u0442\u044b, "
                        : ""
                  )
                  + "\u0434\u043e \u0446\u0435\u043b\u0438 "
                  + var1
                  + "\u043c";
         }
      }
   }

   public List<Vec3d> I_method_4e9dbe68() {
      return this.i_field_7865b31;
   }

   public Vec3d I_method_2e6f539() {
      return new Vec3d(this.I_field_49 + 0.5, this.I_field_5a ? this.i_field_49 + 0.5 : this.I_method_8f3b75ed(), this.II_field_49 + 0.5);
   }

   @Override
   public boolean I_method_8f3b7603() {
      if (this.i_field_5a) {
         return false;
      } else if (this.II_field_5a) {
         return true;
      } else {
         MinecraftClient var1 = MinecraftClient.getInstance();
         if (var1.player != null && var1.world != null) {
            ClientPlayerEntity var2 = var1.player;
            ClientWorld var3 = var1.world;
            this.Ii_field_49++;
            iiIiiIiII_Class437.I_method_d9acc61f();
            if (!this.i_method_ddc0bb26(var2)) {
               iiiIIIIii_Class452.i_method_e5eeaa09("\u042d\u043b\u0438\u0442\u0440\u0430 \u043d\u0435 \u043d\u0430\u0434\u0435\u0442\u0430");
               this.I_field_523beb0a = "\u044d\u043b\u0438\u0442\u0440\u0430 \u043d\u0435 \u043d\u0430\u0434\u0435\u0442\u0430";
               this.I_method_8f3b75ff();
               return true;
            } else {
               if (!this.iIi_field_5a && this.II_method_38459a23(var2)) {
                  this.I_method_94a4be09("\u042d\u043b\u0438\u0442\u0440\u0430 \u043f\u043e\u0447\u0442\u0438 \u0441\u043b\u043e\u043c\u0430\u043d\u0430");
               }

               if (!this.Ii_field_5a) {
                  this.I_field_46 = var2.getYaw();
                  this.i_field_46 = MathHelper.clamp(var2.getPitch(), -50.0F, 50.0F);
                  boolean var4 = var3.getDimension().hasCeiling();
                  this.II_field_44 = var4 ? MathHelper.clamp(var2.getY(), 45.0, 100.0) : MathHelper.clamp(var2.getY(), 16.0, 118.0);
                  this.Ii_field_5a = true;
               }

               if (this.iIi_field_5a) {
                  return this.I_method_86924a9(var1, var2, var3);
               } else {
                  double var10 = this.i_method_ddc0bb10(var2);
                  if (this.Ii_method_df9bca43(var2)) {
                     iiiIIIIii_Class452.I_method_15375629("\u0414\u043e\u043b\u0435\u0442\u0435\u043b\u0438 \u0434\u043e \u0446\u0435\u043b\u0438");
                     this.II_field_5a = true;
                     this.Ii_method_5850cd22();
                     return true;
                  } else {
                     iiIiiiiii_Class448 var6 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
                     var6.I_method_359d223f();
                     var6.i_method_7fcac895(false);
                     var6.II_method_44ae3612(false);
                     var6.Ii_method_46712632(false);
                     var6.ii_method_7d0c3a12(false);
                     if (!var2.isGliding()) {
                        this.I_method_7131be81(var1, var2, var3, var6);
                        return false;
                     } else {
                        this.ii_field_49 = 0;
                        this.I_field_27591cc6 = iiiIiiiii_Class480.Nested1_1863cfc9.I_field_27591cc6;
                        this.iI_field_5a = false;
                        var6.I_method_7e07d875(true);
                        var6.III_method_52d38c15(true);
                        var6.iI_method_7b4949f2(false);
                        this.I_method_5833aa1f(var10);
                        if (this.iI_field_49 >= 500) {
                           this.I_method_94a4be09(
                              "\u041d\u0435 \u043f\u043e\u043b\u0443\u0447\u0430\u0435\u0442\u0441\u044f \u043f\u0440\u0438\u0431\u043b\u0438\u0437\u0438\u0442\u044c\u0441\u044f \u043a \u0446\u0435\u043b\u0438"
                           );
                           return this.I_method_86924a9(var1, var2, var3);
                        } else {
                           this.I_method_bcbcea20(var3, var2);
                           this.i_method_7b29a600(var3, var2);
                           iiiIiiiii_Class480.Nested1_6c2440a0 var7 = this.I_method_36db60b1(var3, var2);
                           var7 = this.I_method_8ba36c92(var3, var2, var7);
                           this.ii_field_5a = var7.I_method_d435271e();
                           if (var7.I_method_d435271e() && var7.I_method_d435270d() <= 8) {
                              this.iiI_field_49++;
                           } else {
                              this.iiI_field_49 = Math.max(0, this.iiI_field_49 - 2);
                           }

                           if (this.iiI_field_49 > 12) {
                              this.I_method_94a4be09(
                                 "\u0417\u0430\u0436\u0430\u0442 \u0432 \u0443\u0437\u043a\u043e\u043c \u043f\u0440\u043e\u0441\u0442\u0440\u0430\u043d\u0441\u0442\u0432\u0435"
                              );
                              return this.I_method_86924a9(var1, var2, var3);
                           } else {
                              float var8 = this.ii_field_5a ? 18.0F : 11.0F;
                              float var9 = this.ii_field_5a ? 11.0F : 6.0F;
                              this.I_field_46 = I_method_1a1ac551(this.I_field_46, var7.I_method_d435270a(), var8);
                              this.i_field_46 = I_method_1a1ac551(this.i_field_46, var7.i_method_d443b2ea(), var9);
                              this.i_field_46 = MathHelper.clamp(this.i_field_46, -50.0F, 50.0F);
                              iiIiiIiII_Class437.I_method_5c4d35b9(new iiIIiIIii_Class404(this.I_field_46, this.i_field_46), 45.0F, 35.0F, 45.0F);
                              this.I_method_30d94286(var1, var2, var7);
                              return false;
                           }
                        }
                     }
                  }
               }
            }
         } else {
            return false;
         }
      }
   }

   private void I_method_7131be81(MinecraftClient var1, ClientPlayerEntity var2, World var3, iiIiiiiii_Class448 var4) {
      this.ii_field_49++;
      if (!this.iI_field_5a) {
         iiiIIIIii_Class452.I_method_15375629("\u0412\u0437\u043b\u0435\u0442\u0430\u044e \u043d\u0430 \u044d\u043b\u0438\u0442\u0440\u0435...");
         this.iI_field_5a = true;
      }

      if (this.ii_field_49 > 600) {
         if (var2.isOnGround()) {
            iiiIIIIii_Class452.i_method_e5eeaa09(
               "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0432\u0437\u043b\u0435\u0442\u0435\u0442\u044c (\u043d\u0435\u0442 \u043c\u0435\u0441\u0442\u0430 \u043d\u0430\u0434 \u0433\u043e\u043b\u043e\u0432\u043e\u0439 \u0438\u043b\u0438 \u0444\u0435\u0439\u0435\u0440\u0432\u0435\u0440\u043a\u043e\u0432)"
            );
            this.I_method_8f3b75ff();
         } else {
            this.I_method_94a4be09(
               "\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0440\u0430\u0437\u043e\u0433\u043d\u0430\u0442\u044c\u0441\u044f \u043d\u0430 \u044d\u043b\u0438\u0442\u0440\u0435"
            );
         }
      } else if (var2.isOnGround() && !this.I_method_bcbcea24(var3, var2)) {
         iiiIIIIii_Class452.i_method_e5eeaa09(
            "\u041d\u0430\u0434 \u0433\u043e\u043b\u043e\u0432\u043e\u0439 \u043d\u0435\u0442 \u043c\u0435\u0441\u0442\u0430 \u0434\u043b\u044f \u0432\u0437\u043b\u0451\u0442\u0430 \u043d\u0430 \u044d\u043b\u0438\u0442\u0440\u0435"
         );
         this.I_method_8f3b75ff();
      } else {
         var4.I_method_7e07d875(false);
         var4.III_method_52d38c15(false);
         boolean var5;
         if (var2.isOnGround()) {
            this.I_field_27591cc6 = iiiIiiiii_Class480.Nested1_1863cfc9.I_field_27591cc6;
            this.IiI_field_49 = 0;
            var5 = true;
         } else {
            switch (this.I_field_27591cc6) {
               case I_field_27591cc6:
                  this.I_field_27591cc6 = iiiIiiiii_Class480.Nested1_1863cfc9.i_field_27591cc6;
                  this.IiI_field_49 = 0;
                  var5 = false;
                  break;
               case i_field_27591cc6:
                  this.IiI_field_49++;
                  var5 = false;
                  if (this.IiI_field_49 >= 2) {
                     this.I_field_27591cc6 = iiiIiiiii_Class480.Nested1_1863cfc9.II_field_27591cc6;
                     this.IiI_field_49 = 0;
                  }
                  break;
               case II_field_27591cc6:
                  var5 = true;
                  if (var1.getNetworkHandler() != null && this.Ii_field_49 - this.III_field_49 >= 2) {
                     var1.getNetworkHandler().sendPacket(new ClientCommandC2SPacket(var2, Mode.START_FALL_FLYING));
                     this.III_field_49 = this.Ii_field_49;
                  }

                  this.IiI_field_49++;
                  if (this.IiI_field_49 >= 4) {
                     this.I_field_27591cc6 = iiiIiiiii_Class480.Nested1_1863cfc9.i_field_27591cc6;
                     this.IiI_field_49 = 0;
                     var5 = false;
                  }
                  break;
               default:
                  var5 = false;
            }
         }

         var4.iI_method_7b4949f2(var5 && !this.III_field_5a || var5 && var2.isOnGround());
         this.III_field_5a = var5;
         float var6 = this.I_method_366a8af2(var2);
         this.I_field_46 = var6;
         this.i_field_46 = -6.0F;
         iiIiiIiII_Class437.I_method_5c4d35b9(new iiIIiIIii_Class404(var6, -6.0F), 45.0F, 35.0F, 45.0F);
      }
   }

   private boolean I_method_bcbcea24(World var1, ClientPlayerEntity var2) {
      Mutable var3 = new Mutable();
      int var4 = MathHelper.floor(var2.getX());
      int var5 = MathHelper.floor(var2.getZ());
      int var6 = MathHelper.floor(var2.getY());

      for (int var7 = 2; var7 <= 3; var7++) {
         var3.set(var4, var6 + var7, var5);
         if (!var1.getBlockState(var3).getCollisionShape(var1, var3).isEmpty()) {
            return false;
         }
      }

      return true;
   }

   private void I_method_30d94286(MinecraftClient var1, ClientPlayerEntity var2, iiiIiiiii_Class480.Nested1_6c2440a0 var3) {
      if (!this.iIi_field_5a) {
         if (!this.IIi_field_5a) {
            if (this.Ii_field_49 - this.IIi_field_49 >= 12) {
               if (this.iII_field_5a && this.Ii_field_44 > var2.getY() + 4.0) {
                  if (var3.I_method_d435270d() >= 38 || var3.i_method_d443b2ea() < -12.0F) {
                     this.I_method_dc585afb(var1, var2);
                  }
               } else if (var3.I_method_d435271e()) {
                  if (var3.i_method_d443b2ea() < -12.0F) {
                     this.I_method_dc585afb(var1, var2);
                  }
               } else if (var3.I_method_d435270d() >= 38) {
                  if (this.Ii_field_49 - this.IIi_field_49 >= 32) {
                     if (this.I_method_366a8af0(var2) < 1.05F || this.i_field_46 < -6.0F) {
                        this.I_method_dc585afb(var1, var2);
                     }
                  }
               }
            }
         }
      }
   }

   private void I_method_dc585afb(MinecraftClient var1, ClientPlayerEntity var2) {
      if (var1.interactionManager != null) {
         Hand var3;
         if (var2.getOffHandStack().isOf(Items.FIREWORK_ROCKET)) {
            var3 = Hand.OFF_HAND;
         } else {
            if (!this.I_method_366a8b06(var2)) {
               return;
            }

            var3 = Hand.MAIN_HAND;
         }

         var1.interactionManager.interactItem(var2, var3);
         this.IIi_field_49 = this.Ii_field_49;
      }
   }

   private boolean I_method_366a8b06(ClientPlayerEntity var1) {
      if (var1.getMainHandStack().isOf(Items.FIREWORK_ROCKET)) {
         return true;
      } else {
         PlayerInventory var2 = var1.getInventory();

         for (int var3 = 0; var3 < 9; var3++) {
            if (var2.getStack(var3).isOf(Items.FIREWORK_ROCKET)) {
               iiiIIIIII_Class449.I_method_10f45cc4(var3);
               return true;
            }
         }

         return false;
      }
   }

   private boolean Ii_method_5850cd26() {
      return this.Ii_field_49 - this.IIi_field_49 < 30;
   }

   private void I_method_bcbcea20(World var1, ClientPlayerEntity var2) {
      if (this.I_field_b866bf5e != null) {
         if (this.I_field_b866bf5e.isDone()) {
            List var4 = this.I_field_b866bf5e.getNow(List.of());
            this.I_field_b866bf5e = null;
            if (!var4.isEmpty()) {
               this.I_field_7865b31 = var4;
               this.IIiI_field_49 = 0;
            }
         }
      } else {
         boolean var3 = this.I_field_7865b31.isEmpty()
            || this.IIiI_field_49 >= this.I_field_7865b31.size()
            || this.Ii_field_49 - this.IIii_field_49 > 40
            || this.I_field_7865b31.get(this.IIiI_field_49).distanceTo(var2.getPos()) > 28.0;
         if (var3) {
            this.IIii_field_49 = this.Ii_field_49;
            this.I_field_b866bf5e = iiiIIIiII_Class453.I_method_4b273f33(var1, var2.getPos(), this.I_method_2e6f539());
         }
      }
   }

   @Nullable
   private Vec3d I_method_8567399a(World var1, ClientPlayerEntity var2) {
      while (this.IIiI_field_49 < this.I_field_7865b31.size() && this.I_field_7865b31.get(this.IIiI_field_49).distanceTo(var2.getPos()) < 6.0) {
         this.IIiI_field_49++;
      }

      if (this.IIiI_field_49 + 1 < this.I_field_7865b31.size()) {
         Vec3d var3 = this.I_field_7865b31.get(this.IIiI_field_49 + 1);
         Vec3d var4 = var2.getEyePos();
         BlockHitResult var5 = var1.raycast(new RaycastContext(var4, var3, ShapeType.COLLIDER, FluidHandling.ANY, var2));
         if (var5.getType() == Type.MISS) {
            this.IIiI_field_49++;
         }
      }

      return this.IIiI_field_49 >= this.I_field_7865b31.size() ? null : this.I_field_7865b31.get(this.IIiI_field_49);
   }

   private iiiIiiiii_Class480.Nested1_6c2440a0 I_method_36db60b1(World var1, ClientPlayerEntity var2) {
      Vec3d var3 = var2.getPos();
      Vec3d var4 = var2.getVelocity();
      Vec3d var5 = null;
      float var6 = 20.0F;
      if (!this.iIi_field_5a && !this.iII_field_5a && !this.IIi_field_5a) {
         Vec3d var7 = this.I_field_7865b31.isEmpty() ? null : this.I_method_8567399a(var1, var2);
         if (var7 != null) {
            var5 = var7;
            if (var7.y > var2.getY() + 2.0) {
               var6 = 34.0F;
            }
         }
      }

      if (var5 == null) {
         var5 = this.I_method_eec8b164(var1, var2, this.i_method_a6df7919());
      }

      Vec3d var38 = var5.subtract(var2.getEyePos());
      double var8 = Math.hypot(var38.x, var38.z);
      float var10 = (float)Math.toDegrees(Math.atan2(var38.z, var38.x)) - 90.0F;
      float var11 = MathHelper.clamp((float)(-Math.toDegrees(Math.atan2(var38.y, Math.max(0.001, var8)))), -var6, var6);
      if (this.IIi_field_5a) {
         var10 += this.IiI_field_5a ? 90.0F : -90.0F;
         var11 = MathHelper.clamp(var11, -20.0F, 0.0F);
      }

      if (var1.getDimension().hasCeiling() && var2.getY() > 112.0) {
         var11 = Math.max(var11, 8.0F);
      }

      if (this.iIi_field_5a && this.I_field_5bba0d50 != null) {
         double var12 = var2.getY() - this.I_field_5bba0d50.y;
         float var14 = var12 < 5.0 ? 6.0F : 22.0F;
         var11 = MathHelper.clamp(var11, -50.0F, var14);
      }

      int var39 = this.Ii_method_5850cd26() ? 30 - (this.Ii_field_49 - this.IIi_field_49) : 0;
      iiiIiiiii_Class480.Nested1_6c2440a0 var13 = null;
      iiiIiiiii_Class480.Nested1_1863d3a9 var40 = null;
      double var15 = Double.NEGATIVE_INFINITY;

      for (float var20 : this.I_field_275920a6.I_field_b4b) {
         for (float var24 : this.I_field_275920a6.i_field_b4b) {
            float var25 = var10 + var20;
            float var26 = MathHelper.clamp(var11 + var24, -50.0F, 50.0F);
            iiiIiiiii_Class480.Nested1_1863d3a9 var27 = this.I_method_c3938f9b(
               var1, var3, var4, this.I_field_46, this.i_field_46, var25, var26, 7.5F, 4.5F, var39, 50
            );
            double var28;
            if (!var27.I_field_5a) {
               var28 = 50.0 * 1000.0;
            } else {
               int var30 = 50 - var27.I_field_49;
               var28 = var27.I_field_49 * 100.0 - var30 * var30 * 5.0;
            }

            double var53 = Math.abs(iiIIiIiIi_Class406.II_method_95f3d8d2(var25, var10)) * 0.22 + Math.abs(var26 - var11) * 0.16;
            double var32 = Math.abs(iiIIiIiIi_Class406.II_method_95f3d8d2(this.I_field_46, var25)) * 0.1 + Math.abs(this.i_field_46 - var26) * 0.1;
            double var34 = (Math.sqrt(this.i_field_44) - var27.I_field_5bba0d50.distanceTo(this.I_method_2e6f539())) * 0.5;
            double var36 = var28 - var53 - var32 + var34;
            if (var13 == null || var36 > var15) {
               var15 = var36;
               var13 = new iiiIiiiii_Class480.Nested1_6c2440a0(var25, var26, var27.I_field_49, false);
               var40 = var27;
            }
         }
      }

      if (var13 == null) {
         this.i_field_7865b31 = List.of();
         return new iiiIiiiii_Class480.Nested1_6c2440a0(this.I_field_46, -50.0F, 0, true);
      } else if (!var40.I_field_5a) {
         this.i_field_7865b31 = List.copyOf(var40.I_field_7865b31);
         return var13;
      } else {
         iiiIiiiii_Class480.Nested1_6c2440a0 var41 = null;
         iiiIiiiii_Class480.Nested1_1863d3a9 var42 = null;
         double var43 = Double.NEGATIVE_INFINITY;

         for (float var48 : this.I_field_275920a6.II_field_b4b) {
            for (float var52 : this.I_field_275920a6.Ii_field_b4b) {
               float var29 = var10 + var48;
               iiiIiiiii_Class480.Nested1_1863d3a9 var54 = this.I_method_c3938f9b(
                  var1, var3, var4, this.I_field_46, this.i_field_46, var29, var52, 14.0F, 8.5F, var39, 50
               );
               int var31 = var54.I_field_5a ? var54.I_field_49 : 50;
               double var55 = Math.abs(iiIIiIiIi_Class406.II_method_95f3d8d2(this.I_field_46, var29));
               double var56 = Math.abs(iiIIiIiIi_Class406.II_method_95f3d8d2(var29, var10));
               double var57 = var31 * 10000.0 - var55 * 10.0 - var56;
               if (var41 == null || var57 > var43) {
                  var43 = var57;
                  var41 = new iiiIiiiii_Class480.Nested1_6c2440a0(var29, var52, var31, true);
                  var42 = var54;
               }
            }
         }

         int var45 = var41 != null ? var41.I_method_d435270d() : 0;
         if (var45 <= 8) {
            this.i_field_7865b31 = List.copyOf(var40.I_field_7865b31);
            return new iiiIiiiii_Class480.Nested1_6c2440a0(this.I_field_46, -50.0F, var45, true);
         } else if (var41 != null && var41.I_method_d435270d() >= var13.I_method_d435270d()) {
            this.i_field_7865b31 = List.copyOf(var42.I_field_7865b31);
            return var41;
         } else {
            this.i_field_7865b31 = List.copyOf(var40.I_field_7865b31);
            return new iiiIiiiii_Class480.Nested1_6c2440a0(
               var13.I_method_d435270a(), Math.min(var13.i_method_d443b2ea(), -25.0F), var13.I_method_d435270d(), true
            );
         }
      }
   }

   private void i_method_7b29a600(World var1, ClientPlayerEntity var2) {
      if (this.IIi_field_5a) {
         this.iII_field_49--;
         if (this.iII_field_49 <= 0) {
            this.IIi_field_5a = false;
            this.Iii_field_49 = 0;
         }
      } else if (this.iII_field_5a) {
         this.iii_field_49--;
         boolean var8 = Math.abs(var2.getY() - this.Ii_field_44) < 4.0;
         if (this.iii_field_49 <= 0 || var8) {
            this.iII_field_5a = false;
            this.Iii_field_49 = 0;
         }
      } else {
         if (this.ii_field_5a) {
            this.Iii_field_49++;
         } else {
            this.Iii_field_49 = Math.max(0, this.Iii_field_49 - 2);
         }

         if (this.Iii_field_49 >= 25) {
            if (this.iIi_field_49 >= 3) {
               if (this.IIII_field_49 < 2) {
                  boolean var7 = var1.getDimension().hasCeiling();
                  this.Ii_field_44 = var7
                     ? Math.max(45.0, var2.getY() - 24.0)
                     : Math.min(118.0, Math.max(var2.getY() + 24.0, this.I_method_bcbcea0e(var1, var2) + 18.0));
                  this.iII_field_5a = true;
                  this.iii_field_49 = 70;
                  this.IIII_field_49++;
                  this.iIi_field_49 = 0;
                  this.Iii_field_49 = 0;
                  iiiIIIIii_Class452.I_method_15375629(
                     "\u041e\u0431\u0445\u043e\u0434 \u043d\u0435 \u043f\u043e\u043c\u043e\u0433 \u2014 \u043c\u0435\u043d\u044f\u044e \u0432\u044b\u0441\u043e\u0442\u0443 ("
                        + (int)this.Ii_field_44
                        + ")"
                  );
               } else {
                  this.I_method_94a4be09(
                     "\u041d\u0435 \u043f\u043e\u043b\u0443\u0447\u0430\u0435\u0442\u0441\u044f \u043d\u0430\u0439\u0442\u0438 \u043f\u0440\u043e\u0445\u043e\u0434"
                  );
               }
            } else {
               if (this.iIi_field_49 > 0) {
                  this.IiI_field_5a = !this.Iii_field_5a;
               } else {
                  Vec3d var3 = this.I_method_2e6f539().subtract(var2.getEyePos());
                  float var4 = (float)Math.toDegrees(Math.atan2(var3.z, var3.x)) - 90.0F;
                  iiiIiiiii_Class480.Nested1_1863d3a9 var5 = this.I_method_c3938f9b(
                     var1, var2.getPos(), var2.getVelocity(), this.I_field_46, this.i_field_46, var4 + 90.0F, 0.0F, 14.0F, 8.5F, 0, 50
                  );
                  iiiIiiiii_Class480.Nested1_1863d3a9 var6 = this.I_method_c3938f9b(
                     var1, var2.getPos(), var2.getVelocity(), this.I_field_46, this.i_field_46, var4 - 90.0F, 0.0F, 14.0F, 8.5F, 0, 50
                  );
                  this.IiI_field_5a = var5.I_field_49 >= var6.I_field_49;
               }

               this.Iii_field_5a = this.IiI_field_5a;
               this.IIi_field_5a = true;
               this.iII_field_49 = 30;
               this.iIi_field_49++;
               iiiIIIIii_Class452.I_method_15375629(
                  "\u041a\u0440\u0443\u0436\u0443 \u0432 \u0442\u0443\u043f\u0438\u043a\u0435 \u2014 \u043b\u0435\u0447\u0443 \u043f\u0435\u0440\u043f\u0435\u043d\u0434\u0438\u043a\u0443\u043b\u044f\u0440\u043d\u043e \u0446\u0435\u043b\u0438"
               );
            }
         }
      }
   }

   private Vec3d I_method_eec8b164(World var1, ClientPlayerEntity var2, Vec3d var3) {
      if (this.iIi_field_5a) {
         return var3;
      } else {
         double var4 = var2.getX();
         double var6 = var2.getZ();
         double var8 = var3.x - var4;
         double var10 = var3.z - var6;
         double var12 = Math.hypot(var8, var10);
         if (this.iII_field_5a) {
            if (var12 < 1.0) {
               return new Vec3d(var3.x, this.Ii_field_44, var3.z);
            } else {
               double var18 = var8 / var12;
               double var16 = var10 / var12;
               return new Vec3d(var4 + var18 * 16.0, this.Ii_field_44, var6 + var16 * 16.0);
            }
         } else {
            boolean var14 = var1.getDimension().hasCeiling();
            if (var14) {
               if (var12 > 32.0) {
                  double var20 = MathHelper.clamp(var3.y, 45.0, 100.0);
                  return new Vec3d(var3.x, var20, var3.z);
               } else {
                  return var3;
               }
            } else {
               if (var12 > 40.0) {
                  double var15 = this.I_method_bcbcea0e(var1, var2) + 14.0;
                  var15 = MathHelper.clamp(var15, 16.0, 118.0);
                  if (var3.y < var15) {
                     return new Vec3d(var3.x, var15, var3.z);
                  }
               }

               return var3;
            }
         }
      }
   }

   private double I_method_bcbcea0e(World var1, ClientPlayerEntity var2) {
      Vec3d var3 = this.I_method_2e6f539().subtract(var2.getPos());
      double var4 = Math.hypot(var3.x, var3.z);
      double var6 = var4 > 1.0 ? var3.x / var4 : 0.0;
      double var8 = var4 > 1.0 ? var3.z / var4 : 0.0;
      double var10 = var1.getBottomY();

      for (int var15 : this.I_field_275920a6.I_field_b4e) {
         int var16 = MathHelper.floor(var2.getX() + var6 * var15);
         int var17 = MathHelper.floor(var2.getZ() + var8 * var15);
         if (var1.isPosLoaded(var16, var17)) {
            int var18 = var1.getTopY(net.minecraft.world.Heightmap.Type.MOTION_BLOCKING, var16, var17);
            if (var18 > var10) {
               var10 = var18;
            }
         }
      }

      return var10;
   }

   private iiiIiiiii_Class480.Nested1_6c2440a0 I_method_8ba36c92(World var1, ClientPlayerEntity var2, iiiIiiiii_Class480.Nested1_6c2440a0 var3) {
      Vec3d var4 = var2.getVelocity();
      double var5 = var4.length();
      if (var5 < 0.4) {
         return var3;
      } else {
         Vec3d var7 = this.I_method_2e6f539();
         double var8 = Math.hypot(var7.x - var2.getX(), var7.z - var2.getZ());
         if (var8 < 24.0) {
            return var3;
         } else {
            Vec3d var10 = var2.getEyePos();
            double var11 = Math.min(48.0, var5 * 28.0 + 4.0);
            BlockHitResult var13 = var1.raycast(new RaycastContext(var10, var10.add(var4.multiply(var11 / var5)), ShapeType.COLLIDER, FluidHandling.NONE, var2));
            if (var13.getType() != Type.BLOCK) {
               return var3;
            } else if (var13.getPos().distanceTo(var7) < 12.0) {
               return var3;
            } else {
               double var14 = var13.getPos().distanceTo(var10) / Math.max(0.1, var5);
               return var14 < 14.0
                  ? new iiiIiiiii_Class480.Nested1_6c2440a0(var3.I_method_d435270a(), Math.min(var3.i_method_d443b2ea(), -35.0F), (int)var14, true)
                  : var3;
            }
         }
      }
   }

   private Vec3d i_method_a6df7919() {
      return this.iIi_field_5a && this.I_field_5bba0d50 != null ? this.I_field_5bba0d50 : this.I_method_2e6f539();
   }

   private void I_method_94a4be09(String var1) {
      if (!this.iIi_field_5a && !this.II_field_5a) {
         iiiIIIIii_Class452.i_method_e5eeaa09(var1 + " \u2014 \u0437\u0430\u0445\u043e\u0436\u0443 \u043d\u0430 \u043f\u043e\u0441\u0430\u0434\u043a\u0443");
         this.iIi_field_5a = true;
         this.IIIi_field_49 = 0;
         this.I_field_5bba0d50 = null;
         this.I_field_4a = Long.MIN_VALUE;
         this.IIi_field_5a = false;
         this.iII_field_5a = false;
         this.ii_field_5a = false;
         this.iI_field_49 = 0;
      }
   }

   private boolean I_method_86924a9(MinecraftClient var1, ClientPlayerEntity var2, World var3) {
      this.IIIi_field_49++;
      if (var2.isOnGround()) {
         iiiIIIIii_Class452.I_method_15375629("\u0421\u0435\u043b \u043d\u0430 \u0437\u0435\u043c\u043b\u044e");
         this.II_field_5a = true;
         this.Ii_method_5850cd22();
         return true;
      } else if (this.IIIi_field_49 > 300) {
         iiiIIIIii_Class452.i_method_e5eeaa09(
            "\u041f\u043e\u0441\u0430\u0434\u043a\u0430 \u043d\u0435 \u0443\u0434\u0430\u043b\u0430\u0441\u044c \u0437\u0430 \u043b\u0438\u043c\u0438\u0442 \u2014 \u043e\u0442\u043c\u0435\u043d\u044f\u044e"
         );
         this.I_field_523beb0a = "\u043f\u043e\u0441\u0430\u0434\u043a\u0430 \u043d\u0435 \u0443\u0434\u0430\u043b\u0430\u0441\u044c";
         this.I_method_8f3b75ff();
         return true;
      } else {
         if (this.I_field_5bba0d50 == null || this.Ii_field_49 - this.I_field_4a > 20L) {
            Vec3d var4 = this.i_method_94c9ed7a(var3, var2);
            if (var4 != null) {
               this.I_field_5bba0d50 = var4;
            }

            this.I_field_4a = this.Ii_field_49;
         }

         iiIiiiiii_Class448 var13 = iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5();
         var13.I_method_359d223f();
         var13.i_method_7fcac895(false);
         var13.II_method_44ae3612(false);
         var13.Ii_method_46712632(false);
         var13.ii_method_7d0c3a12(false);
         var13.iI_method_7b4949f2(false);
         if (!var2.isGliding()) {
            var13.I_method_7e07d875(false);
            var13.III_method_52d38c15(false);
            return false;
         } else if (this.I_field_5bba0d50 == null) {
            var13.I_method_7e07d875(false);
            var13.III_method_52d38c15(false);
            this.i_field_46 = I_method_1a1ac551(this.i_field_46, -50.0F, 11.0F);
            iiIiiIiII_Class437.I_method_5c4d35b9(new iiIIiIIii_Class404(this.I_field_46, this.i_field_46), 45.0F, 35.0F, 45.0F);
            this.i_field_7865b31 = List.of();
            return false;
         } else {
            var13.I_method_7e07d875(true);
            var13.III_method_52d38c15(true);
            Vec3d var5 = this.I_field_5bba0d50.subtract(var2.getEyePos());
            double var6 = Math.hypot(var5.x, var5.z);
            float var8 = (float)Math.toDegrees(Math.atan2(var5.z, var5.x)) - 90.0F;
            float var9 = (float)(-Math.toDegrees(Math.atan2(var5.y, Math.max(0.001, var6))));
            double var10 = var2.getY() - this.I_field_5bba0d50.y;
            float var12 = var10 < 5.0 ? 6.0F : 22.0F;
            var9 = MathHelper.clamp(var9, -50.0F, var12);
            if (var10 < 5.0 && var6 < 2.5) {
               var13.I_method_7e07d875(false);
               var13.III_method_52d38c15(false);
               var9 = Math.min(var9, -3.0F);
            }

            this.I_field_46 = I_method_1a1ac551(this.I_field_46, var8, 11.0F);
            this.i_field_46 = I_method_1a1ac551(this.i_field_46, var9, 6.0F);
            this.i_field_46 = MathHelper.clamp(this.i_field_46, -50.0F, 50.0F);
            iiIiiIiII_Class437.I_method_5c4d35b9(new iiIIiIIii_Class404(this.I_field_46, this.i_field_46), 45.0F, 35.0F, 45.0F);
            this.i_field_7865b31 = List.of(var2.getPos(), this.I_field_5bba0d50);
            return false;
         }
      }
   }

   @Nullable
   private Vec3d i_method_94c9ed7a(World var1, ClientPlayerEntity var2) {
      Mutable var3 = new Mutable();
      int var4 = MathHelper.floor(var2.getX());
      int var5 = MathHelper.floor(var2.getZ());
      int var6 = Math.min(var1.getTopYInclusive() - 1, MathHelper.floor(var2.getY()));
      Vec3d var7 = null;
      double var8 = Double.NEGATIVE_INFINITY;
      byte var10 = 8;

      for (int var11 = -var10; var11 <= var10; var11++) {
         for (int var12 = -var10; var12 <= var10; var12++) {
            int var13 = var4 + var11;
            int var14 = var5 + var12;
            boolean var15 = false;

            for (int var16 = var6; var16 > var1.getBottomY() + 2; var16--) {
               var3.set(var13, var16, var14);
               if (!var1.isPosLoaded(var3)) {
                  var15 = true;
                  break;
               }

               BlockState var17 = var1.getBlockState(var3);
               FluidState var18 = var17.getFluidState();
               if (var18.isIn(FluidTags.LAVA) || I_method_4732abb8(var17)) {
                  var15 = true;
                  break;
               }

               if (!var17.isAir() && !var17.isReplaceable() && !var17.getCollisionShape(var1, var3).isEmpty()) {
                  BlockPos var19 = new BlockPos(var13, var16 + 1, var14);
                  BlockPos var20 = new BlockPos(var13, var16 + 2, var14);
                  if (var1.getBlockState(var19).getCollisionShape(var1, var19).isEmpty() && var1.getBlockState(var20).getCollisionShape(var1, var20).isEmpty()) {
                     double var21 = var13 + 0.5;
                     double var23 = var16 + 1.1;
                     double var25 = var14 + 0.5;
                     double var27 = Math.hypot(var21 - var2.getX(), var25 - var2.getZ());
                     double var29 = var2.getY() - var23;
                     if (!(var29 < 2.0)) {
                        double var31 = Math.toDegrees(Math.atan2(var29, Math.max(0.5, var27)));
                        double var33 = -Math.abs(var31 - 20.0) * 2.0 - var27 * 0.3 - var29 * 0.1;
                        if (var33 > var8) {
                           var8 = var33;
                           var7 = new Vec3d(var21, var23, var25);
                        }
                     }
                  }
                  break;
               }
            }

            if (var15) {
            }
         }
      }

      return var7;
   }

   private iiiIiiiii_Class480.Nested1_1863d3a9 I_method_c3938f9b(
      World var1, Vec3d var2, Vec3d var3, float var4, float var5, float var6, float var7, float var8, float var9, int var10, int var11
   ) {
      Vec3d var12 = var2;
      Vec3d var13 = var3;
      float var14 = var4;
      float var15 = var5;
      int var16 = var10;
      ArrayList var17 = new ArrayList(var11);

      for (int var18 = 0; var18 < var11; var18++) {
         var14 = I_method_1a1ac551(var14, var6, var8);
         var15 = I_method_1a1ac551(var15, var7, var9);
         Vec3d var19 = I_method_109d7979(var14, var15);
         double var20 = Math.toRadians(var15);
         double var22 = Math.hypot(var19.x, var19.z);
         double var24 = Math.hypot(var13.x, var13.z);
         double var26 = var19.length();
         double var28 = Math.cos(var20);
         var28 = var28 * var28 * Math.min(1.0, var26 / 0.4);
         var13 = var13.add(0.0, 0.08 * (-1.0 + var28 * 0.75), 0.0);
         if (var13.y < 0.0 && var22 > 0.0) {
            double var30 = var13.y * -0.1 * var28;
            var13 = var13.add(var19.x * var30 / var22, var30, var19.z * var30 / var22);
         }

         if (var20 < 0.0 && var22 > 0.0) {
            double var39 = var24 * -Math.sin(var20) * 0.04;
            var13 = var13.add(-var19.x * var39 / var22, var39 * 3.2, -var19.z * var39 / var22);
         }

         if (var22 > 0.0) {
            var13 = var13.add((var19.x / var22 * var24 - var13.x) * 0.1, 0.0, (var19.z / var22 * var24 - var13.z) * 0.1);
         }

         if (var16 > 0) {
            double var40 = 1.5;
            var13 = var13.add(
               var19.x * 0.1 + (var19.x * var40 - var13.x) * 0.5,
               var19.y * 0.1 + (var19.y * var40 - var13.y) * 0.5,
               var19.z * 0.1 + (var19.z * var40 - var13.z) * 0.5
            );
            var16--;
         }

         var13 = new Vec3d(var13.x * 0.99, var13.y * 0.98, var13.z * 0.99);
         Vec3d var41 = var12;
         var12 = var12.add(var13);
         var17.add(var12);
         double var31 = var13.length();
         int var33 = Math.max(1, (int)Math.ceil(var31 / 0.6));

         for (int var34 = 1; var34 <= var33; var34++) {
            Vec3d var35 = var41.add(var13.multiply((double)var34 / var33));
            iiiIiiiii_Class480.Nested1_6c244080 var36 = var34 == var33 ? this.I_method_2f4c7ddc(var1, var35, false) : this.I_method_2f4c7ddc(var1, var35, true);
            if (var36 == iiiIiiiii_Class480.Nested1_6c244080.i_field_5c1ba607) {
               return new iiiIiiiii_Class480.Nested1_1863d3a9(var18, true, var12, var17);
            }

            if (var36 == iiiIiiiii_Class480.Nested1_6c244080.II_field_5c1ba607) {
               return new iiiIiiiii_Class480.Nested1_1863d3a9(var18, true, var12, var17);
            }
         }
      }

      return new iiiIiiiii_Class480.Nested1_1863d3a9(var11, false, var12, var17);
   }

   private iiiIiiiii_Class480.Nested1_6c244080 I_method_2f4c7ddc(World var1, Vec3d var2, boolean var3) {
      Mutable var4 = new Mutable();
      boolean var5 = false;
      double[][] var6 = var3 ? this.I_field_275920a6.i_field_160e4 : this.I_field_275920a6.I_field_160e4;

      for (double[] var10 : var6) {
         int var11 = MathHelper.floor(var2.x + var10[0]);
         int var12 = MathHelper.floor(var2.y + var10[1]);
         int var13 = MathHelper.floor(var2.z + var10[2]);
         if (var12 <= var1.getBottomY() + 2 || var12 >= var1.getTopYInclusive() - 2) {
            return iiiIiiiii_Class480.Nested1_6c244080.i_field_5c1ba607;
         }

         var4.set(var11, var12, var13);
         if (!var1.isPosLoaded(var4)) {
            var5 = true;
         } else {
            BlockState var14 = var1.getBlockState(var4);
            if (I_method_4732abb8(var14)) {
               return iiiIiiiii_Class480.Nested1_6c244080.i_field_5c1ba607;
            }

            FluidState var15 = var14.getFluidState();
            if (var15.isIn(FluidTags.LAVA)) {
               return iiiIiiiii_Class480.Nested1_6c244080.i_field_5c1ba607;
            }

            if (!var14.isAir() && !var14.isReplaceable() && !var14.getCollisionShape(var1, var4).isEmpty()) {
               return iiiIiiiii_Class480.Nested1_6c244080.i_field_5c1ba607;
            }
         }
      }

      return var5 ? iiiIiiiii_Class480.Nested1_6c244080.II_field_5c1ba607 : iiiIiiiii_Class480.Nested1_6c244080.I_field_5c1ba607;
   }

   private static boolean I_method_4732abb8(BlockState var0) {
      return var0.isOf(Blocks.LAVA)
         || var0.isOf(Blocks.FIRE)
         || var0.isOf(Blocks.SOUL_FIRE)
         || var0.isOf(Blocks.MAGMA_BLOCK)
         || var0.isOf(Blocks.CAMPFIRE)
         || var0.isOf(Blocks.SOUL_CAMPFIRE);
   }

   private boolean i_method_ddc0bb26(ClientPlayerEntity var1) {
      ItemStack var2 = var1.getEquippedStack(EquipmentSlot.CHEST);
      return !var2.isEmpty() && var2.isOf(Items.ELYTRA);
   }

   private boolean II_method_38459a23(ClientPlayerEntity var1) {
      ItemStack var2 = var1.getEquippedStack(EquipmentSlot.CHEST);
      if (var2.isEmpty() || !var2.isOf(Items.ELYTRA)) {
         return false;
      } else {
         return !var2.isDamageable() ? false : var2.getMaxDamage() - var2.getDamage() <= 10;
      }
   }

   private void I_method_5833aa1f(double var1) {
      if (!this.IIi_field_5a && !this.iII_field_5a && !this.iIi_field_5a) {
         if (!this.ii_field_5a) {
            if (var1 + 9.0 < this.i_field_44) {
               this.i_field_44 = var1;
               this.iI_field_49 = 0;
               this.Iii_field_49 = 0;
               this.iIi_field_49 = 0;
               this.IIII_field_49 = 0;
            } else {
               this.iI_field_49++;
            }
         }
      }
   }

   private double I_method_366a8af0(ClientPlayerEntity var1) {
      return Math.hypot(var1.getVelocity().x, var1.getVelocity().z);
   }

   private float I_method_366a8af2(ClientPlayerEntity var1) {
      Vec3d var2 = this.I_method_2e6f539().subtract(var1.getEyePos());
      return (float)Math.toDegrees(Math.atan2(var2.z, var2.x)) - 90.0F;
   }

   private double i_method_ddc0bb10(ClientPlayerEntity var1) {
      double var2 = var1.getX() - (this.I_field_49 + 0.5);
      double var4 = var1.getZ() - (this.II_field_49 + 0.5);
      if (!this.I_field_5a) {
         return var2 * var2 + var4 * var4;
      } else {
         double var6 = var1.getY() - (this.i_field_49 + 0.5);
         return var2 * var2 + var6 * var6 + var4 * var4;
      }
   }

   private boolean Ii_method_df9bca43(ClientPlayerEntity var1) {
      double var2 = var1.getX() - (this.I_field_49 + 0.5);
      double var4 = var1.getZ() - (this.II_field_49 + 0.5);
      double var6 = Math.hypot(var2, var4);
      double var8 = MathHelper.clamp(this.I_method_366a8af0(var1) * 5.0 + 3.0, 8.0, 12.0);
      return var6 <= var8;
   }

   private double I_method_8f3b75ed() {
      return this.I_field_5a ? this.i_field_49 + 0.5 : this.II_field_44;
   }

   private static Vec3d I_method_109d7979(float var0, float var1) {
      float var2 = (float)Math.toRadians(var0);
      float var3 = (float)Math.toRadians(var1);
      float var4 = MathHelper.cos(var3);
      return new Vec3d(-MathHelper.sin(var2) * var4, -MathHelper.sin(var3), MathHelper.cos(var2) * var4).normalize();
   }

   private static float I_method_1a1ac551(float var0, float var1, float var2) {
      float var3 = iiIIiIiIi_Class406.II_method_95f3d8d2(var0, var1);
      return Math.abs(var3) <= var2 ? var1 : var0 + Math.signum(var3) * var2;
   }

   @Override
   public void I_method_8f3b75ff() {
      this.Ii_method_5850cd22();
   }

   @Override
   public void i_method_8f4a01df() {
      this.i_field_5a = true;
      iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5().i_method_35abae1f();
   }

   @Override
   public void II_method_58424142() {
      this.i_field_5a = false;
   }

   @Override
   public boolean i_method_8f4a01e3() {
      return this.i_field_5a;
   }

   @Override
   public boolean II_method_58424146() {
      return this.II_field_5a;
   }

   @Nullable
   @Override
   public String II_method_f53e1f9e() {
      return this.I_field_523beb0a;
   }

   private void Ii_method_5850cd22() {
      this.i_field_7865b31 = List.of();
      this.I_field_7865b31 = List.of();
      this.I_field_b866bf5e = null;
      iiIiiIiIi_Class438.I_method_12f562b5().I_method_14b8caf5().i_method_35abae1f();
   }

   static enum Nested1_1863cfc9 {
      I_field_27591cc6,
      i_field_27591cc6,
      II_field_27591cc6;

      public static iiiIiiiii_Class480.Nested1_1863cfc9[] I_method_117e5bdc() {
         return values();
      }

      public static iiiIiiiii_Class480.Nested1_1863cfc9 I_method_9b233e21(String var0) {
         return Enum.valueOf(iiiIiiiii_Class480.Nested1_1863cfc9.class, var0);
      }
   }

   static final class Nested1_1863cfe9 {
      final double I_field_44 = 8.0;
      final double i_field_44 = 12.0;
      final double II_field_44 = 9.0;
      final int I_field_49 = 500;
      final int i_field_49 = 600;
      final int II_field_49 = 2;
      final int Ii_field_49 = 4;
      final float I_field_46 = -6.0F;
      final int iI_field_49 = 32;
      final int ii_field_49 = 12;
      final int III_field_49 = 30;
      final int IIi_field_49 = 38;
      final float i_field_46 = 1.05F;
      final float II_field_46 = 6.0F;
      final float Ii_field_46 = 12.0F;
      final int IiI_field_49 = 10;
      final float iI_field_46 = 50.0F;
      final float ii_field_46 = 20.0F;
      final float[] I_field_b4b = new float[]{-65.0F, -38.0F, -18.0F, 0.0F, 18.0F, 38.0F, 65.0F};
      final float[] i_field_b4b = new float[]{-38.0F, -25.0F, -14.0F, -5.0F, 6.0F, 16.0F};
      final float[] II_field_b4b = new float[]{0.0F, -35.0F, 35.0F, -70.0F, 70.0F, -110.0F, 110.0F, -150.0F, 150.0F, 180.0F};
      final float[] Ii_field_b4b = new float[]{-50.0F, -35.0F, -20.0F, -8.0F, 6.0F};
      final float III_field_46 = 11.0F;
      final float IIi_field_46 = 6.0F;
      final float IiI_field_46 = 18.0F;
      final float Iii_field_46 = 11.0F;
      final float iII_field_46 = 45.0F;
      final float iIi_field_46 = 35.0F;
      final float iiI_field_46 = 45.0F;
      final int Iii_field_49 = 50;
      final float iii_field_46 = 7.5F;
      final float IIII_field_46 = 4.5F;
      final float IIIi_field_46 = 14.0F;
      final float IIiI_field_46 = 8.5F;
      final double Ii_field_44 = 0.22;
      final double iI_field_44 = 0.16;
      final double ii_field_44 = 0.1;
      final double III_field_44 = 0.5;
      final int iII_field_49 = 16;
      final int iIi_field_49 = 118;
      final int iiI_field_49 = 45;
      final int iii_field_49 = 100;
      final int IIII_field_49 = 112;
      final double IIi_field_44 = 40.0;
      final double IiI_field_44 = 14.0;
      final int[] I_field_b4e = new int[]{0, 8, 20, 36, 56};
      final double Iii_field_44 = 14.0;
      final int IIIi_field_49 = 40;
      final double iII_field_44 = 28.0;
      final double iIi_field_44 = 6.0;
      final float IIii_field_46 = 34.0F;
      final int IIiI_field_49 = 2;
      final int IIii_field_49 = 70;
      final int IiII_field_49 = 25;
      final int IiIi_field_49 = 30;
      final int IiiI_field_49 = 3;
      final int Iiii_field_49 = 8;
      final int iIII_field_49 = 12;
      final int iIIi_field_49 = 300;
      final int iIiI_field_49 = 20;
      final int iIii_field_49 = 8;
      final float IiII_field_46 = 22.0F;
      final float IiIi_field_46 = 6.0F;
      final double iiI_field_44 = 5.0;
      final double[][] I_field_160e4 = new double[][]{
         {0.0, 0.1, 0.0},
         {0.0, 0.9, 0.0},
         {0.0, 1.7, 0.0},
         {0.0, 2.3, 0.0},
         {0.0, -0.5, 0.0},
         {0.8, 0.1, 0.0},
         {0.8, 0.9, 0.0},
         {0.8, 1.7, 0.0},
         {-0.8, 0.1, 0.0},
         {-0.8, 0.9, 0.0},
         {-0.8, 1.7, 0.0},
         {0.0, 0.1, 0.8},
         {0.0, 0.9, 0.8},
         {0.0, 1.7, 0.8},
         {0.0, 0.1, -0.8},
         {0.0, 0.9, -0.8},
         {0.0, 1.7, -0.8},
         {0.6, 0.1, 0.6},
         {-0.6, 0.1, 0.6},
         {0.6, 0.1, -0.6},
         {-0.6, 0.1, -0.6},
         {0.6, 0.9, 0.6},
         {-0.6, 0.9, 0.6},
         {0.6, 0.9, -0.6},
         {-0.6, 0.9, -0.6},
         {0.6, 1.7, 0.6},
         {-0.6, 1.7, 0.6},
         {0.6, 1.7, -0.6},
         {-0.6, 1.7, -0.6}
      };
      final double[][] i_field_160e4 = new double[][]{
         {0.0, 0.1, 0.0},
         {0.0, 0.9, 0.0},
         {0.0, 1.7, 0.0},
         {0.7, 0.9, 0.0},
         {-0.7, 0.9, 0.0},
         {0.0, 0.9, 0.7},
         {0.0, 0.9, -0.7},
         {0.7, 0.1, 0.0},
         {-0.7, 0.1, 0.0},
         {0.0, 0.1, 0.7},
         {0.0, 0.1, -0.7},
         {0.7, 1.7, 0.0},
         {-0.7, 1.7, 0.0},
         {0.0, 1.7, 0.7},
         {0.0, 1.7, -0.7},
         {0.5, 0.9, 0.5},
         {-0.5, 0.9, 0.5},
         {0.5, 0.9, -0.5},
         {-0.5, 0.9, -0.5}
      };
   }

   static final class Nested1_1863d3a9 {
      final int I_field_49;
      final boolean I_field_5a;
      final Vec3d I_field_5bba0d50;
      final List<Vec3d> I_field_7865b31;

      Nested1_1863d3a9(int var1, boolean var2, Vec3d var3, List<Vec3d> var4) {
         this.I_field_49 = var1;
         this.I_field_5a = var2;
         this.I_field_5bba0d50 = var3;
         this.I_field_7865b31 = var4;
      }
   }

   static enum Nested1_6c244080 {
      I_field_5c1ba607,
      i_field_5c1ba607,
      II_field_5c1ba607;

      public static iiiIiiiii_Class480.Nested1_6c244080[] I_method_17fcaf28() {
         return values();
      }

      public static iiiIiiiii_Class480.Nested1_6c244080 I_method_c7ca5735(String var0) {
         return Enum.valueOf(iiiIiiiii_Class480.Nested1_6c244080.class, var0);
      }
   }

   static final class Nested1_6c2440a0 {
      private final float I_field_46;
      private final float i_field_46;
      private final int I_field_49;
      private final boolean I_field_5a;

      Nested1_6c2440a0(float var1, float var2, int var3, boolean var4) {
         this.I_field_46 = var1;
         this.i_field_46 = var2;
         this.I_field_49 = var3;
         this.I_field_5a = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_6c2440a0[yaw=" + this.I_field_46 + ", pitch=" + this.i_field_46 + ", safeTicks=" + this.I_field_49 + ", emergency=" + this.I_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiiIiiiii_Class480.Nested1_6c2440a0 other = (iiiIiiiii_Class480.Nested1_6c2440a0) var1;
         return java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a);
      }

      public float I_method_d435270a() {
         return this.I_field_46;
      }

      public float i_method_d443b2ea() {
         return this.i_field_46;
      }

      public int I_method_d435270d() {
         return this.I_field_49;
      }

      public boolean I_method_d435271e() {
         return this.I_field_5a;
      }
   }
}
