package rockstar.client;

import com.mojang.authlib.GameProfile;
import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.BitSet;
import java.util.OptionalDouble;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import lombok.Generated;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.OtherClientPlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.message.LastSeenMessageList.Acknowledgment;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;
import net.minecraft.network.packet.c2s.play.ClickSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket;
import net.minecraft.network.packet.c2s.play.CommandExecutionC2SPacket;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractEntityC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientCommandC2SPacket.Mode;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket.Action;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EmptyBlockView;

public class iiiiiii_Class128 {
   private final String I_field_523beb0a;
   private final iiiiiIi_Class126 I_field_c2f14fac;
   private final IIIIIiIi_Class6 I_field_416dd741;
   private final IIIiIIii_Class20 I_field_77fad761;
   private final IIIiIIiI_Class19 I_field_77fad381;
   private IIIIIIii_Class4 I_field_415fc381;
   private IIIIIIiI_Class3 I_field_415fbfa1;
   private IIIIiIII_Class9 I_field_432237a1 = new IIIIiiIi_Class14();
   private boolean I_field_5a;
   private int I_field_49;
   private boolean i_field_5a;
   private String i_field_523beb0a;
   private int i_field_49 = 25565;
   private int II_field_49 = 0;
   private double I_field_44;
   private double i_field_44;
   private double II_field_44;
   private double Ii_field_44;
   private double iI_field_44 = Double.NaN;
   private long I_field_4a;
   private BlockPos I_field_670402ba;
   private Direction I_field_3b03ad36 = Direction.UP;
   private double ii_field_44;
   private long i_field_4a;
   private long II_field_4a;
   private int Ii_field_49;

   public iiiiiii_Class128(String var1, IIIIIIii_Class4 var2) {
      this.I_field_523beb0a = var1;
      this.I_field_415fc381 = var2;
      this.I_field_416dd741 = new IIIIIiIi_Class6();
      this.I_field_77fad761 = new IIIiIIii_Class20(var1);
      this.I_field_77fad381 = new IIIiIIiI_Class19(this, this.I_field_77fad761);
      this.I_field_c2f14fac = new iiiiiIi_Class126(this);
      this.I_field_49 = var2.iIi_method_1ea3499f();
   }

   public void I_method_68c7979a(String var1, int var2) {
      this.i_field_523beb0a = var1;
      this.i_field_49 = var2;
      this.i_field_5a = false;
      this.I_field_77fad761.I_method_2934264d(var1, var2);
      this.I_field_c2f14fac.I_method_2d9d33ba(var1, var2);
   }

   public void I_method_9da3c47f() {
      this.i_field_5a = true;
      this.I_method_b8ab1d60(new IIIIiiIi_Class14());
      this.IIi_method_c5b218bf();
      this.I_field_77fad761.i_method_9244708c();
      this.I_field_c2f14fac.I_method_dc5c5f();
   }

   public void i_method_9db2505f() {
      this.I_field_c2f14fac.i_method_eae83f();
      if (this.I_field_c2f14fac.I_method_dc5c63()) {
         this.II_field_49++;
         if (this.I_field_77fad381.IiI_method_e3cbaa10()) {
            this.I_field_77fad381.i_method_4359c9d3(MinecraftClient.getInstance());
         } else if (this.I_field_432237a1 != null) {
            this.I_field_432237a1.I_method_f2de637a(this);
         }

         this.iIi_method_fc4d2c9f();
         this.I_field_77fad761.I_method_9f766ed(this.I_field_416dd741);
         this.I_field_77fad381.I_method_5b9ad0cc();
      }
   }

   public void II_method_16e3c2c2() {
      this.Ii_method_16f24ea2();
   }

   public void Ii_method_16f24ea2() {
      if (this.I_field_c2f14fac.I_method_dc5c63()) {
         if (this.I_field_416dd741.IiI_method_ea5cddd0()) {
            Vec3d var1 = this.I_field_416dd741.I_method_d573f06();
            this.I_field_416dd741
               .I_method_f21a8072(
                  var1.x, var1.y + Math.max(this.I_field_415fc381.iIi_method_1ea3499a(), (double)this.I_field_416dd741.ii_method_a6391045()), var1.z
               );
            this.I_field_416dd741.II_method_e88ba91f(false);
         } else if (this.I_field_416dd741.III_method_e899edb0()) {
            this.iiI_method_fe0190df();
            this.Ii_field_44 = this.I_field_415fc381.iIi_method_1ea3499a();
            this.I_field_416dd741.II_method_e88ba91f(false);
         }
      }
   }

   public void iI_method_18a6b2e2() {
      this.I_method_16d57e35(!this.I_field_416dd741.iI_method_a62a8479());
   }

   public void I_method_16d57e35(boolean var1) {
      if (this.I_field_c2f14fac.I_method_dc5c63()) {
         if (this.I_field_416dd741.iI_method_a62a8479() != var1) {
            this.I_field_416dd741.I_method_a4594fc8(var1);
            this.I_method_fff88225(var1 ? Mode.PRESS_SHIFT_KEY : Mode.RELEASE_SHIFT_KEY);
         }
      }
   }

   public void i_method_18986e55(boolean var1) {
      if (this.I_field_c2f14fac.I_method_dc5c63()) {
         if (this.I_field_416dd741.ii_method_a6391059() != var1) {
            this.I_field_416dd741.i_method_a61c3fe8(var1);
            this.I_method_fff88225(var1 ? Mode.START_SPRINTING : Mode.STOP_SPRINTING);
         }
      }
   }

   public void ii_method_18b53ec2() {
      if (this.I_field_c2f14fac.I_method_dc5c63()) {
         this.I_field_c2f14fac.I_method_f0d1c168(new HandSwingC2SPacket(Hand.MAIN_HAND));
      }
   }

   public void I_method_c0c879e7(Entity var1) {
      if (this.I_field_c2f14fac.I_method_dc5c63() && var1 != null) {
         this.I_field_c2f14fac.I_method_f0d1c168(PlayerInteractEntityC2SPacket.attack(var1, this.I_field_416dd741.iI_method_a62a8479()));
         this.I_field_c2f14fac.I_method_f0d1c168(new HandSwingC2SPacket(Hand.MAIN_HAND));
      }
   }

   public void I_method_16d53e64(int var1) {
      if (this.I_field_c2f14fac.I_method_dc5c63() && var1 >= 0) {
         Entity var2 = this.I_method_48eb3e9a(var1);
         if (var2 == null) {
            this.ii_method_18b53ec2();
         } else {
            this.I_method_c0c879e7(var2);
         }
      }
   }

   public void III_method_c5a38cdf() {
      if (this.I_field_c2f14fac.I_method_dc5c63()) {
         this.I_field_c2f14fac
            .I_method_f0d1c168(
               new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, 0, this.I_field_416dd741.I_method_6865f47c(), this.I_field_416dd741.i_method_6874805c())
            );
      }
   }

   public void I_method_937762a(BlockHitResult var1) {
      if (this.I_field_c2f14fac.I_method_dc5c63() && var1 != null) {
         this.I_field_c2f14fac.I_method_f0d1c168(new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, var1, this.iI_method_18a6b2d5()));
         this.I_field_c2f14fac.I_method_f0d1c168(new HandSwingC2SPacket(Hand.MAIN_HAND));
      }
   }

   public void i_method_b1654e4a(BlockHitResult var1) {
      if (this.I_field_c2f14fac.I_method_dc5c63() && var1 != null) {
         BlockPos var2 = var1.getBlockPos();
         Direction var3 = var1.getSide();
         this.I_method_dbaec697(var2, var3);
         this.i_method_bd2ba6b7(var2, var3);
      }
   }

   public void I_method_dbaec697(BlockPos var1, Direction var2) {
      if (this.I_field_c2f14fac.I_method_dc5c63() && var1 != null) {
         this.I_field_c2f14fac
            .I_method_f0d1c168(new PlayerActionC2SPacket(Action.START_DESTROY_BLOCK, var1, var2 == null ? Direction.UP : var2, this.iI_method_18a6b2d5()));
         this.I_field_c2f14fac.I_method_f0d1c168(new HandSwingC2SPacket(Hand.MAIN_HAND));
      }
   }

   public void i_method_bd2ba6b7(BlockPos var1, Direction var2) {
      if (this.I_field_c2f14fac.I_method_dc5c63() && var1 != null) {
         this.I_field_c2f14fac
            .I_method_f0d1c168(new PlayerActionC2SPacket(Action.STOP_DESTROY_BLOCK, var1, var2 == null ? Direction.UP : var2, this.iI_method_18a6b2d5()));
      }
   }

   public boolean I_method_9da3c483() {
      if (!this.I_field_c2f14fac.I_method_dc5c63()) {
         return false;
      } else {
         iiiiiii_Class128.Nested1_ec28200 var1 = this.I_method_4a21e990(this.I_field_415fc381.iii_method_206639ba());
         iiiiiii_Class128.Nested1_ec28220 var2 = this.I_method_4a21ed70(var1 == null ? this.I_field_415fc381.iii_method_206639ba() : var1.I_method_b328c1a8());
         if (var2 != null) {
            this.IIi_method_c5b218bf();
            this.I_method_16d53e64(var2.I_method_5ba73618().I_method_cbb38a9a());
            return true;
         } else if (var1 != null) {
            this.II_method_38ebc287(var1.I_method_a5de6273());
            return true;
         } else {
            this.IIi_method_c5b218bf();
            this.ii_method_18b53ec2();
            return false;
         }
      }
   }

   public boolean i_method_9db25063() {
      if (!this.I_field_c2f14fac.I_method_dc5c63()) {
         return false;
      } else {
         iiiiiii_Class128.Nested1_ec28200 var1 = this.I_method_4a21e990(this.I_field_415fc381.iii_method_206639ba());
         if (var1 != null) {
            this.I_method_937762a(var1.I_method_a5de6273());
            return true;
         } else {
            this.III_method_c5a38cdf();
            return false;
         }
      }
   }

   public void II_method_c5954852(boolean var1) {
      if (this.I_field_c2f14fac.I_method_dc5c63()) {
         this.I_field_c2f14fac.I_method_f0d1c168(new PlayerActionC2SPacket(var1 ? Action.DROP_ALL_ITEMS : Action.DROP_ITEM, BlockPos.ORIGIN, Direction.DOWN));
      }
   }

   public void i_method_18982e84(int var1) {
      if (this.I_field_c2f14fac.I_method_dc5c63()) {
         if (var1 >= 0 && var1 <= 8) {
            this.I_field_416dd741.II_method_e88b694e(var1);
            this.I_field_c2f14fac.I_method_f0d1c168(new UpdateSelectedSlotC2SPacket(var1));
         }
      }
   }

   public boolean I_method_c28f1feb(Item var1) {
      if (this.I_field_c2f14fac.I_method_dc5c63() && var1 != null) {
         for (int var2 = 0; var2 < 9; var2++) {
            ItemStack var3 = this.I_field_416dd741.I_method_12cfb5f3()[var2];
            if (var3 != null && !var3.isEmpty() && var3.getItem() == var1) {
               this.i_method_18982e84(var2);
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public boolean I_method_16d53e68(int var1) {
      return this.I_method_d346d622(var1, 0, SlotActionType.PICKUP);
   }

   public boolean I_method_d346d622(int var1, int var2, SlotActionType var3) {
      if (this.I_field_c2f14fac.I_method_dc5c63() && this.I_field_416dd741.I_method_6865f490() && var1 >= 0) {
         SlotActionType var4 = var3 == null ? SlotActionType.PICKUP : var3;
         Int2ObjectOpenHashMap var5 = new Int2ObjectOpenHashMap();
         ItemStack var6 = this.I_field_416dd741.II_method_adf79583();
         if (var4 == SlotActionType.PICKUP && var2 == 0) {
            ItemStack var7 = this.I_field_416dd741.I_method_3609521(var1).copy();
            ItemStack var8 = var6 == null ? ItemStack.EMPTY : var6.copy();
            ItemStack var9 = var7 == null ? ItemStack.EMPTY : var7.copy();
            this.I_field_416dd741.I_method_727a05b9(this.I_field_416dd741.Ii_method_a4762028(), this.I_field_416dd741.iI_method_a62a8468(), var1, var8);
            this.I_field_416dd741.i_method_a8ce14ce(var9);
            var5.put(var1, var8.copy());
            var6 = var9;
         }

         this.I_field_c2f14fac
            .I_method_f0d1c168(
               new ClickSlotC2SPacket(
                  this.I_field_416dd741.Ii_method_a4762028(),
                  this.I_field_416dd741.iI_method_a62a8468(),
                  var1,
                  var2,
                  var4,
                  var6 == null ? ItemStack.EMPTY : var6.copy(),
                  var5
               )
            );
         return true;
      } else {
         return false;
      }
   }

   public boolean II_method_16e3c2c6() {
      iiiiiii_Class128.Nested1_ec28200 var1 = this.I_method_4a21e990(this.I_field_415fc381.iii_method_206639ba());
      return var1 != null && this.I_method_f857b43d(var1.I_method_a5de6273().getBlockPos());
   }

   public void IIi_method_c5b218bf() {
      if (this.I_field_670402ba != null && this.I_field_c2f14fac.I_method_dc5c63()) {
         this.I_field_c2f14fac
            .I_method_f0d1c168(
               new PlayerActionC2SPacket(
                  Action.ABORT_DESTROY_BLOCK,
                  this.I_field_670402ba,
                  this.I_field_3b03ad36 == null ? Direction.UP : this.I_field_3b03ad36,
                  this.iI_method_18a6b2d5()
               )
            );
         this.iII_method_fc3ea0bf();
      } else {
         this.iII_method_fc3ea0bf();
      }
   }

   private void II_method_38ebc287(BlockHitResult var1) {
      if (var1 != null && this.I_field_c2f14fac.I_method_dc5c63()) {
         BlockPos var2 = var1.getBlockPos();
         Direction var3 = var1.getSide() == null ? this.I_method_1de0a859(var2) : var1.getSide();
         if (!this.I_method_f857b43d(var2)) {
            this.IIi_method_c5b218bf();
         } else if (this.I_field_416dd741.iII_method_1f350190()) {
            this.IIi_method_c5b218bf();
            this.i_method_b1654e4a(var1);
         } else {
            long var4 = System.currentTimeMillis();
            if (!var2.equals(this.I_field_670402ba)) {
               this.IIi_method_c5b218bf();
               this.I_field_670402ba = var2.toImmutable();
               this.I_field_3b03ad36 = var3;
               this.ii_field_44 = 0.0;
               this.i_field_4a = var4;
               this.II_field_4a = 0L;
               this.I_method_dbaec697(this.I_field_670402ba, this.I_field_3b03ad36);
            } else {
               this.I_field_3b03ad36 = var3;
               BlockState var6 = this.I_field_77fad761.I_method_27bc425(var2);
               double var7 = Math.max(1.0, (var4 - this.i_field_4a) / 50.0);
               this.i_field_4a = var4;
               double var9 = Math.max(
                  this.I_field_415fc381.IIIIi_method_d22456da(),
                  var6.getHardness(EmptyBlockView.INSTANCE, var2) * this.I_field_415fc381.IIIII_method_d215cafa()
               );
               this.ii_field_44 += var7 / var9;
               if (var4 - this.II_field_4a >= this.I_field_415fc381.Iii_method_e9cb25e0()) {
                  this.I_field_c2f14fac.I_method_f0d1c168(new HandSwingC2SPacket(Hand.MAIN_HAND));
                  this.II_field_4a = var4;
               }

               if (this.ii_field_44 >= 1.0) {
                  this.i_method_bd2ba6b7(var2, this.I_field_3b03ad36);
                  this.iII_method_fc3ea0bf();
               }
            }
         }
      }
   }

   private boolean I_method_f857b43d(BlockPos var1) {
      if (var1 == null) {
         return false;
      } else {
         BlockState var2 = this.I_field_77fad761.I_method_27bc425(var1);
         return !var2.isAir() && var2.getHardness(EmptyBlockView.INSTANCE, var1) >= 0.0F;
      }
   }

   private void iII_method_fc3ea0bf() {
      this.I_field_670402ba = null;
      this.I_field_3b03ad36 = Direction.UP;
      this.ii_field_44 = 0.0;
      this.i_field_4a = 0L;
      this.II_field_4a = 0L;
   }

   public void I_method_98066c89(String var1) {
      if (this.I_field_c2f14fac.I_method_dc5c63()) {
         if (var1.startsWith("/")) {
            this.i_method_68bdc069(var1.substring(1));
         } else {
            this.I_field_c2f14fac
               .I_method_f0d1c168(
                  new ChatMessageC2SPacket(var1, Instant.now(), ThreadLocalRandom.current().nextLong(), null, new Acknowledgment(0, new BitSet()))
               );
         }
      }
   }

   public void i_method_68bdc069(String var1) {
      if (this.I_field_c2f14fac.I_method_dc5c63()) {
         this.I_field_c2f14fac.I_method_f0d1c168(new CommandExecutionC2SPacket(var1));
      }
   }

   public void I_method_b8ab1d60(IIIIiIII_Class9 var1) {
      this.I_field_432237a1 = (IIIIiIII_Class9)(var1 == null ? new IIIIiiIi_Class14() : var1);
   }

   public void IiI_method_c7667cff() {
      this.I_method_b8ab1d60(new IIIIiiIi_Class14());
      this.IIi_method_c5b218bf();
      this.I_field_44 = 0.0;
      this.i_field_44 = 0.0;
      this.II_field_44 = 0.0;
   }

   public void I_method_b644c79f(double var1, double var3, double var5) {
      Vec3d var7 = this.I_field_416dd741.I_method_d573f06();
      double var8 = var1 - var7.x;
      double var10 = var3 - (var7.y + this.I_field_415fc381.iiIi_method_eabb92c3());
      double var12 = var5 - var7.z;
      double var14 = Math.sqrt(var8 * var8 + var12 * var12);
      float var16 = (float)Math.toDegrees(Math.atan2(-var8, var12));
      float var17 = (float)Math.toDegrees(-Math.atan2(var10, var14));
      this.I_field_416dd741
         .I_method_e6c7f98c(
            this.I_method_b661e6d1(this.I_field_416dd741.I_method_6865f47c(), var16, (float)this.I_field_415fc381.ii_method_19d0cc03()),
            this.I_method_b661e6d1(this.I_field_416dd741.i_method_6874805c(), var17, (float)this.I_field_415fc381.III_method_e7f9a9da())
         );
   }

   public void i_method_530c2fbf(double var1, double var3, double var5) {
      this.I_field_416dd741.I_method_f21a8072(var1, var3, var5);
      this.Ii_field_44 = 0.0;
      this.iI_field_44 = var3;
      this.I_field_416dd741.II_method_e88ba91f(true);
   }

   public void I_method_331eac73(Vec3d var1, double var2) {
      if (var1 != null) {
         Vec3d var4 = this.I_field_416dd741.I_method_d573f06();
         double var5 = var1.x - var4.x;
         double var7 = var1.z - var4.z;
         double var9 = Math.sqrt(var5 * var5 + var7 * var7);
         this.I_method_b644c79f(var1.x, var1.y + this.I_field_415fc381.iiIi_method_eabb92c3(), var1.z);
         if (!(var9 <= var2) && !(var9 < 1.0E-4)) {
            double var11 = this.I_field_415fc381.II_method_17ff5003() * this.I_field_415fc381.i_method_9164c9a();
            double var13 = Math.min(var11, Math.max(0.0, var9 - var2));
            this.I_field_44 = this.I_method_b644c78d(this.I_field_44, var13, this.I_field_415fc381.Ii_method_180ddbe3());
            this.i_field_44 = var5 / var9 * this.I_field_44;
            this.II_field_44 = var7 / var9 * this.I_field_44;
            double var15 = var1.y - var4.y;
            if (var15 > this.I_field_415fc381.iiII_method_eaad06e3() && this.I_field_416dd741.III_method_e899edb0()) {
               this.Ii_method_16f24ea2();
            }

            this.I_field_416dd741.I_method_f21a8072(var4.x + this.i_field_44, var4.y, var4.z + this.II_field_44);
         } else {
            this.Iii_method_c77508df();
         }
      }
   }

   public void Iii_method_c77508df() {
      if (Math.abs(this.i_field_44) < 1.0E-5 && Math.abs(this.II_field_44) < 1.0E-5) {
         this.I_field_44 = 0.0;
         this.i_field_44 = 0.0;
         this.II_field_44 = 0.0;
      } else {
         this.i_field_44 = this.i_field_44 * this.I_field_415fc381.iI_method_19c24023();
         this.II_field_44 = this.II_field_44 * this.I_field_415fc381.iI_method_19c24023();
         this.I_field_44 = this.I_field_44 * this.I_field_415fc381.iI_method_19c24023();
         Vec3d var1 = this.I_field_416dd741.I_method_d573f06();
         this.I_field_416dd741.I_method_f21a8072(var1.x + this.i_field_44, var1.y, var1.z + this.II_field_44);
      }
   }

   public void I_method_16d52b9f(double var1) {
      double var3 = Math.toRadians(this.I_field_416dd741.I_method_6865f47c());
      Vec3d var5 = this.I_field_416dd741.I_method_d573f06();
      this.I_field_416dd741.I_method_f21a8072(var5.x - Math.sin(var3) * var1, var5.y, var5.z + Math.cos(var3) * var1);
   }

   public double I_method_5c7cd919(Vec3d var1) {
      return this.I_field_416dd741.I_method_d573f06().distanceTo(var1);
   }

   public double i_method_3794d139(Vec3d var1) {
      Vec3d var2 = this.I_field_416dd741.I_method_d573f06();
      double var3 = var1.x - var2.x;
      double var5 = var1.z - var2.z;
      return Math.sqrt(var3 * var3 + var5 * var5);
   }

   public boolean I_method_16d54229(long var1) {
      return var1 - this.I_field_4a >= this.I_field_415fc381.iIi_method_1ea349a0();
   }

   public void I_method_16d54225(long var1) {
      this.I_field_4a = var1;
   }

   public void Ii_method_c7583872(boolean var1) {
      this.I_field_416dd741.II_method_e88ba91f(var1);
      if (var1) {
         this.Ii_field_44 = 0.0;
         this.iI_field_44 = this.I_field_416dd741.i_method_6874805a();
      }
   }

   private void iIi_method_fc4d2c9f() {
      if (this.I_field_416dd741.IiI_method_ea5cddd0()) {
         this.Ii_field_44 = 0.0;
         this.I_field_416dd741.II_method_e88ba91f(false);
      } else if (this.I_field_416dd741.III_method_e899edb0() && Math.abs(this.Ii_field_44) <= this.I_field_415fc381.iiI_method_2057adda()) {
         this.iiI_method_fe0190df();
      } else {
         Vec3d var1 = this.I_field_416dd741.I_method_d573f06();
         double var2 = var1.y + this.Ii_field_44;
         OptionalDouble var4 = this.I_method_14cccab5(var1.x, Math.max(var1.y, var2), var1.z);
         boolean var5 = var4.isPresent();
         double var6 = var4.orElse(this.iI_field_44);
         if (this.Ii_field_44 <= 0.0
            && !Double.isNaN(var6)
            && var2 <= var6 + this.I_field_415fc381.iIiI_method_b5d4e323()
            && var1.y >= var6 - this.I_field_415fc381.iIiI_method_b5d4e323()) {
            this.I_field_416dd741.I_method_f21a8072(var1.x, var6, var1.z);
            this.I_field_416dd741.II_method_e88ba91f(true);
            this.Ii_field_44 = 0.0;
            this.iI_field_44 = var6;
         } else {
            this.I_field_416dd741.I_method_f21a8072(var1.x, var2, var1.z);
            this.I_field_416dd741.II_method_e88ba91f(false);
            this.Ii_field_44 = Math.max(
               (this.Ii_field_44 - this.I_field_415fc381.Iiii_method_4fb71ac3()) * this.I_field_415fc381.iIII_method_b411f303(),
               -this.I_field_415fc381.iIIi_method_b4207ee3()
            );
            if (var5 && Math.abs(var2 - var4.getAsDouble()) <= this.I_field_415fc381.iIiI_method_b5d4e323()) {
               this.iI_field_44 = var4.getAsDouble();
            }
         }
      }
   }

   private void iiI_method_fe0190df() {
      Vec3d var1 = this.I_field_416dd741.I_method_d573f06();
      OptionalDouble var2 = this.I_method_14cccab5(var1.x, var1.y, var1.z);
      if (var2.isEmpty()) {
         if (Double.isNaN(this.iI_field_44)) {
            this.iI_field_44 = var1.y;
         }
      } else {
         this.iI_field_44 = var2.getAsDouble();
         if (Math.abs(var1.y - this.iI_field_44) <= this.I_field_415fc381.iIiI_method_b5d4e323()) {
            this.I_field_416dd741.I_method_f21a8072(var1.x, this.iI_field_44, var1.z);
         }
      }
   }

   private OptionalDouble I_method_14cccab5(double var1, double var3, double var5) {
      int var7 = MathHelper.floor(var3);
      int var8 = MathHelper.floor(var3 - this.I_field_415fc381.iIii_method_b5e36f03());

      for (int var9 = var7; var9 >= var8; var9--) {
         BlockPos var10 = BlockPos.ofFloored(var1, var9, var5);
         if (this.I_field_77fad761.II_method_63292a73(var10)) {
            return OptionalDouble.of(var9 + 1.0);
         }
      }

      return OptionalDouble.empty();
   }

   public iiiiiii_Class128.Nested1_ec28200 I_method_4a21e990(double var1) {
      double var3 = Math.max(0.0, var1);
      double var5 = Math.max(this.I_field_415fc381.IIII_method_174a8ae3(), this.I_field_415fc381.iiI_method_2057adda());
      Vec3d var7 = this.I_method_4cb6e3b9();
      Vec3d var8 = this.i_method_f0af6799();
      BlockPos var9 = BlockPos.ofFloored(var7);

      for (double var10 = var5; var10 <= var3; var10 += var5) {
         Vec3d var12 = var7.add(var8.multiply(var10));
         BlockPos var13 = BlockPos.ofFloored(var12);
         if (!var13.equals(var9)) {
            BlockState var14 = this.I_field_77fad761.I_method_27bc425(var13);
            if (!var14.isAir()) {
               Direction var15 = this.I_method_ed365e57(var9, var13, var8);
               return new iiiiiii_Class128.Nested1_ec28200(new BlockHitResult(var12, var15, var13, false), var10);
            }

            var9 = var13;
         }
      }

      return null;
   }

   public iiiiiii_Class128.Nested1_ec28220 I_method_4a21ed70(double var1) {
      Vec3d var3 = this.I_method_4cb6e3b9();
      Vec3d var4 = this.i_method_f0af6799();
      double var5 = this.I_field_415fc381.IIIi_method_175916c3();
      long var7 = this.I_field_77fad761.Ii_method_b4a43409();
      iiiiiii_Class128.Nested1_ec28220 var9 = null;

      for (IIIiIIii_Class20.Nested1_834f18f3 var11 : this.I_field_77fad761.i_method_724ddbbb()) {
         if (var11.I_method_cbb38a9a() != this.I_field_77fad761.II_method_b495a828()
            && var11.I_method_cbb38a9a() != this.I_field_416dd741.II_method_a4679448()
            && var7 - var11.I_method_cbb38a9b() <= this.I_field_415fc381.II_method_17ff5009()) {
            Vec3d var12 = var11.I_method_5c773e1().add(0.0, this.I_field_415fc381.IIiI_method_190d7b03(), 0.0);
            Vec3d var13 = var12.subtract(var3);
            double var14 = var13.dotProduct(var4);
            if (!(var14 < 0.0) && !(var14 > var1)) {
               Vec3d var16 = var3.add(var4.multiply(var14));
               if (!(var12.distanceTo(var16) > var5) && (var9 == null || var14 < var9.I_method_e9c3d588())) {
                  var9 = new iiiiiii_Class128.Nested1_ec28220(var11, var14);
               }
            }
         }
      }

      return var9;
   }

   public Vec3d I_method_4cb6e3b9() {
      return this.I_field_416dd741.I_method_d573f06().add(0.0, this.I_field_415fc381.iiIi_method_eabb92c3(), 0.0);
   }

   public Vec3d i_method_f0af6799() {
      return Vec3d.fromPolar(this.I_field_416dd741.i_method_6874805c(), this.I_field_416dd741.I_method_6865f47c()).normalize();
   }

   public boolean I_method_331eac77(Vec3d var1, double var2) {
      if (var1 == null) {
         return false;
      } else {
         Vec3d var4 = this.I_method_4cb6e3b9();
         double var5 = var1.x - var4.x;
         double var7 = var1.y - var4.y;
         double var9 = var1.z - var4.z;
         double var11 = Math.sqrt(var5 * var5 + var9 * var9);
         float var13 = (float)Math.toDegrees(Math.atan2(-var5, var9));
         float var14 = (float)Math.toDegrees(-Math.atan2(var7, var11));
         double var15 = Math.abs(MathHelper.wrapDegrees(var13 - this.I_field_416dd741.I_method_6865f47c()));
         double var17 = Math.abs(var14 - this.I_field_416dd741.i_method_6874805c());
         return var15 <= var2 && var17 <= var2;
      }
   }

   public Direction I_method_1de0a859(BlockPos var1) {
      if (var1 == null) {
         return Direction.UP;
      } else {
         Vec3d var2 = this.I_method_4cb6e3b9();
         Vec3d var3 = var1.toCenterPos();
         return Direction.getFacing(var2.x - var3.x, var2.y - var3.y, var2.z - var3.z);
      }
   }

   private Direction I_method_ed365e57(BlockPos var1, BlockPos var2, Vec3d var3) {
      int var4 = var2.getX() - var1.getX();
      int var5 = var2.getY() - var1.getY();
      int var6 = var2.getZ() - var1.getZ();
      if (var4 > 0) {
         return Direction.WEST;
      } else if (var4 < 0) {
         return Direction.EAST;
      } else if (var5 > 0) {
         return Direction.DOWN;
      } else if (var5 < 0) {
         return Direction.UP;
      } else if (var6 > 0) {
         return Direction.NORTH;
      } else {
         return var6 < 0 ? Direction.SOUTH : Direction.getFacing(-var3.x, -var3.y, -var3.z);
      }
   }

   private Entity I_method_48eb3e9a(int var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (var2.world == null) {
         return null;
      } else {
         Entity var3 = var2.world.getEntityById(var1);
         if (var3 != null) {
            return var3;
         } else {
            UUID var4 = UUID.nameUUIDFromBytes(("RockstarBotTarget:" + this.I_field_523beb0a + ":" + var1).getBytes(StandardCharsets.UTF_8));
            OtherClientPlayerEntity var5 = new OtherClientPlayerEntity(var2.world, new GameProfile(var4, "BotTarget"));
            var5.setId(var1);
            return var5;
         }
      }
   }

   private void I_method_fff88225(Mode var1) {
      if (var1 != null && this.I_field_416dd741.II_method_a4679448() >= 0) {
         Entity var2 = this.I_method_48eb3e9a(this.I_field_416dd741.II_method_a4679448());
         if (var2 != null) {
            this.I_field_c2f14fac.I_method_f0d1c168(new ClientCommandC2SPacket(var2, var1));
         }
      }
   }

   private int iI_method_18a6b2d5() {
      return this.Ii_field_49++;
   }

   private double I_method_b644c78d(double var1, double var3, double var5) {
      return var1 < var3 ? Math.min(var1 + var5, var3) : Math.max(var1 - var5, var3);
   }

   private float I_method_b661e6d1(float var1, float var2, float var3) {
      float var4 = MathHelper.wrapDegrees(var2 - var1);
      float var5 = MathHelper.clamp(var4, -var3, var3);
      return MathHelper.wrapDegrees(var1 + var5);
   }

   public boolean Ii_method_16f24ea6() {
      return this.I_field_c2f14fac.I_method_dc5c63();
   }

   public iiiiiiI_Class127 I_method_8e45dd15() {
      return this.I_field_c2f14fac.I_method_f12cd4f5();
   }

   @Generated
   public String I_method_7b75de01() {
      return this.I_field_523beb0a;
   }

   @Generated
   public iiiiiIi_Class126 I_method_8e4568d5() {
      return this.I_field_c2f14fac;
   }

   @Generated
   public IIIIIiIi_Class6 I_method_e09ce338() {
      return this.I_field_416dd741;
   }

   @Generated
   public IIIiIIii_Class20 I_method_1729e358() {
      return this.I_field_77fad761;
   }

   @Generated
   public IIIiIIiI_Class19 I_method_1729df78() {
      return this.I_field_77fad381;
   }

   @Generated
   public IIIIIIii_Class4 I_method_e08ecf78() {
      return this.I_field_415fc381;
   }

   @Generated
   public IIIIIIiI_Class3 I_method_e08ecb98() {
      return this.I_field_415fbfa1;
   }

   @Generated
   public IIIIiIII_Class9 I_method_e2514398() {
      return this.I_field_432237a1;
   }

   @Generated
   public boolean iI_method_18a6b2e6() {
      return this.I_field_5a;
   }

   @Generated
   public int I_method_9da3c472() {
      return this.I_field_49;
   }

   @Generated
   public boolean ii_method_18b53ec6() {
      return this.i_field_5a;
   }

   @Generated
   public String i_method_e948e21() {
      return this.i_field_523beb0a;
   }

   @Generated
   public int i_method_9db25052() {
      return this.i_field_49;
   }

   @Generated
   public int II_method_16e3c2b5() {
      return this.II_field_49;
   }

   @Generated
   public double I_method_9da3c46d() {
      return this.I_field_44;
   }

   @Generated
   public double i_method_9db2504d() {
      return this.i_field_44;
   }

   @Generated
   public double II_method_16e3c2b0() {
      return this.II_field_44;
   }

   @Generated
   public double Ii_method_16f24e90() {
      return this.Ii_field_44;
   }

   @Generated
   public double iI_method_18a6b2d0() {
      return this.iI_field_44;
   }

   @Generated
   public long I_method_9da3c473() {
      return this.I_field_4a;
   }

   @Generated
   public BlockPos I_method_65ff27b1() {
      return this.I_field_670402ba;
   }

   @Generated
   public Direction I_method_1b6d271f() {
      return this.I_field_3b03ad36;
   }

   @Generated
   public double ii_method_18b53eb0() {
      return this.ii_field_44;
   }

   @Generated
   public long i_method_9db25053() {
      return this.i_field_4a;
   }

   @Generated
   public long II_method_16e3c2b6() {
      return this.II_field_4a;
   }

   @Generated
   public int Ii_method_16f24e95() {
      return this.Ii_field_49;
   }

   @Generated
   public void I_method_1db53140(IIIIIIii_Class4 var1) {
      this.I_field_415fc381 = var1;
   }

   @Generated
   public void I_method_1da6a560(IIIIIIiI_Class3 var1) {
      this.I_field_415fbfa1 = var1;
   }

   @Generated
   public void iI_method_fc305c32(boolean var1) {
      this.I_field_5a = var1;
   }

   @Generated
   public void II_method_c5950881(int var1) {
      this.I_field_49 = var1;
   }

   public static final class Nested1_ec28200 {
      private final BlockHitResult I_field_51edcc0f;
      private final double I_field_44;

      public Nested1_ec28200(BlockHitResult var1, double var2) {
         this.I_field_51edcc0f = var1;
         this.I_field_44 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_ec28200[hitResult=" + this.I_field_51edcc0f + ", distance=" + this.I_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_51edcc0f);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiiiiii_Class128.Nested1_ec28200 other = (iiiiiii_Class128.Nested1_ec28200) var1;
         return java.util.Objects.equals(this.I_field_51edcc0f, other.I_field_51edcc0f)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44);
      }

      public BlockHitResult I_method_a5de6273() {
         return this.I_field_51edcc0f;
      }

      public double I_method_b328c1a8() {
         return this.I_field_44;
      }
   }

   public static final class Nested1_ec28220 {
      private final IIIiIIii_Class20.Nested1_834f18f3 I_field_64a235dc;
      private final double I_field_44;

      public Nested1_ec28220(IIIiIIii_Class20.Nested1_834f18f3 var1, double var2) {
         this.I_field_64a235dc = var1;
         this.I_field_44 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_ec28220[snapshot=" + this.I_field_64a235dc + ", distance=" + this.I_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_64a235dc);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iiiiiii_Class128.Nested1_ec28220 other = (iiiiiii_Class128.Nested1_ec28220) var1;
         return java.util.Objects.equals(this.I_field_64a235dc, other.I_field_64a235dc)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44);
      }

      public IIIiIIii_Class20.Nested1_834f18f3 I_method_5ba73618() {
         return this.I_field_64a235dc;
      }

      public double I_method_e9c3d588() {
         return this.I_field_44;
      }
   }
}
