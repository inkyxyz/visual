package rockstar.client;

import com.mojang.authlib.GameProfile;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.ClientStatusC2SPacket;
import net.minecraft.network.packet.c2s.play.CloseHandledScreenC2SPacket;
import net.minecraft.network.packet.c2s.play.HandSwingC2SPacket;
import net.minecraft.network.packet.c2s.play.ClientStatusC2SPacket.Mode;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.Full;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.LookAndOnGround;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.OnGroundOnly;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.PositionAndOnGround;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class IIIiIIiI_Class19 {
   private final iiiiiii_Class128 I_field_c2f1c7cc;
   private final IIIiIIii_Class20 I_field_77fad761;
   private Vec3d I_field_5bba0d50 = Vec3d.ZERO;
   private float I_field_46;
   private float i_field_46;
   private boolean I_field_5a;
   private boolean i_field_5a;
   private boolean II_field_5a;
   private boolean Ii_field_5a = true;
   private boolean iI_field_5a;
   private boolean ii_field_5a;
   private float II_field_46 = 20.0F;
   private int I_field_49 = 20;
   private int i_field_49;
   private ItemStack I_field_f2735522 = ItemStack.EMPTY;
   private ItemStack i_field_f2735522 = ItemStack.EMPTY;
   private boolean III_field_5a;
   private IIIiIIIi_Class18 I_field_77fa5f41;
   private Entity I_field_77e0818c;
   private ItemStack[] I_field_6132843d;
   private int II_field_49;
   private long I_field_4a;
   private long i_field_4a;
   private long II_field_4a;
   private double I_field_44;
   private double i_field_44;
   private double II_field_44;
   private float Ii_field_46;
   private float iI_field_46;
   private boolean IIi_field_5a = true;
   private int Ii_field_49;
   private final List<IIIiIIiI_Class19.Nested1_834ea0d3> I_field_7865b31 = new ArrayList<>();

   public IIIiIIiI_Class19(iiiiiii_Class128 var1, IIIiIIii_Class20 var2) {
      this.I_field_c2f1c7cc = var1;
      this.I_field_77fad761 = var2;
   }

   public void I_method_5b9ad0cc() {
      this.ii_method_199fbc15();
      this.i_method_5ba95cac();
      this.III_method_e208b9ec();
   }

   public void i_method_5ba95cac() {
      IIIIIiIi_Class6 var1 = this.I_field_c2f1c7cc.I_method_e09ce338();
      this.I_field_5bba0d50 = var1.I_method_d573f06();
      this.I_field_46 = var1.I_method_6865f47c();
      this.i_field_46 = var1.i_method_6874805c();
      this.I_field_5a = var1.iI_method_a62a8479();
      this.i_field_5a = var1.ii_method_a6391059();
      this.Ii_field_5a = var1.III_method_e899edb0();
      this.iI_field_5a = var1.IiI_method_ea5cddd0();
      this.ii_field_5a = var1.iII_method_1f350190();
      this.II_field_46 = var1.II_method_a4679445();
      this.I_field_49 = var1.I_method_6865f47f();
      this.i_field_49 = var1.i_method_6874805f();
      this.I_field_f2735522 = var1.I_method_f82e14ac();
      this.i_field_f2735522 = var1.i_method_b32594cc();
      if (this.III_field_5a) {
         this.III_method_a4893713(MinecraftClient.getInstance());
      }

      this.I_field_77fad761.i_method_1f8cdacd(var1);
      this.IIi_method_e21745cc();
   }

   public boolean I_method_56b325f7(MinecraftClient var1) {
      if (var1 != null && var1.world != null && var1.player != null) {
         this.I_field_77e0818c = var1.getCameraEntity();
         this.iI_method_b94fae9c(var1);
         this.III_field_5a = true;
         this.Ii_method_fdc87a5c(var1);
         this.III_method_a4893713(var1);
         this.IIi_method_e21745cc();
         var1.setCameraEntity(this.I_field_77fa5f41);
         return true;
      } else {
         return false;
      }
   }

   public void I_method_56b325f3(MinecraftClient var1) {
      this.III_field_5a = false;
      this.ii_method_a5f6527c(var1);
      if (var1 != null && this.I_field_77fa5f41 != null && var1.getCameraEntity() == this.I_field_77fa5f41) {
         var1.setCameraEntity((Entity)(var1.player != null ? var1.player : this.I_field_77e0818c));
      }

      if (this.I_field_77fa5f41 != null) {
         this.I_field_77fa5f41.i_method_f57d086c();
         this.I_field_77fa5f41 = null;
      }

      this.I_field_77e0818c = null;
   }

   public void i_method_4359c9d3(MinecraftClient var1) {
      if (this.III_field_5a && var1 != null && var1.player != null && var1.options != null) {
         IIIIIiIi_Class6 var2 = this.I_field_c2f1c7cc.I_method_e09ce338();
         var2.I_method_e6c7f98c(var1.player.getYaw(), var1.player.getPitch());
         double var3 = this.I_method_17bffb76(var1.options.forwardKey.isPressed()) - this.I_method_17bffb76(var1.options.backKey.isPressed());
         double var5 = this.I_method_17bffb76(var1.options.rightKey.isPressed()) - this.I_method_17bffb76(var1.options.leftKey.isPressed());
         boolean var7 = var1.options.sprintKey.isPressed() && var3 > 0.0 && !var1.options.sneakKey.isPressed();
         boolean var8 = var1.options.sneakKey.isPressed();
         this.I_field_c2f1c7cc.i_method_18986e55(var7);
         this.I_field_c2f1c7cc.I_method_16d57e35(var8);
         this.I_method_76f10d74(var1, var2);
         this.I_method_40d9fda7(var2, var3, var5, var7, var8, var1.options.jumpKey.isPressed());
         this.II_method_1121d67c(var1);
      }
   }

   private void I_method_40d9fda7(IIIIIiIi_Class6 var1, double var2, double var4, boolean var6, boolean var7, boolean var8) {
      double var9 = Math.sqrt(var2 * var2 + var4 * var4);
      if (var9 > 1.0) {
         var2 /= var9;
         var4 /= var9;
      }

      double var11 = this.I_field_c2f1c7cc.I_method_e08ecf78().II_method_17ff5003();
      if (var6) {
         var11 *= this.I_field_c2f1c7cc.I_method_e08ecf78().Iii_method_e9cb25da();
      } else if (var7) {
         var11 *= this.I_field_c2f1c7cc.I_method_e08ecf78().iII_method_1e94bdba();
      }

      double var13 = Math.toRadians(var1.I_method_6865f47c());
      double var15 = Math.sin(var13);
      double var17 = Math.cos(var13);
      Vec3d var19 = var1.I_method_d573f06();
      double var20 = (-var15 * var2 + var17 * var4) * var11;
      double var22 = (var17 * var2 + var15 * var4) * var11;
      this.II_field_5a = var8;
      if (var1.IiI_method_ea5cddd0()) {
         double var30 = 0.0;
         double var26 = Math.max(this.I_field_c2f1c7cc.I_method_e08ecf78().iIi_method_1ea3499a(), (double)var1.ii_method_a6391045());
         if (var8) {
            var30 += var26;
         }

         if (var7) {
            var30 -= var26;
         }

         double var28 = this.I_field_c2f1c7cc.I_method_e08ecf78().iiI_method_2057adda();
         if (Math.abs(var20) > var28 || Math.abs(var22) > var28 || Math.abs(var30) > var28) {
            var1.I_method_f21a8072(var19.x + var20, var19.y + var30, var19.z + var22);
            var1.II_method_e88ba91f(false);
         }
      } else {
         if (var8) {
            this.I_field_c2f1c7cc.Ii_method_16f24ea2();
         }

         double var24 = this.I_field_c2f1c7cc.I_method_e08ecf78().iiI_method_2057adda();
         if (Math.abs(var20) > var24 || Math.abs(var22) > var24) {
            var1.I_method_f21a8072(var19.x + var20, var19.y, var19.z + var22);
         }
      }
   }

   private void II_method_1121d67c(MinecraftClient var1) {
      long var2 = System.currentTimeMillis();
      long var4 = this.I_field_c2f1c7cc.I_method_e08ecf78().i_method_9164ca0();
      boolean var6 = var1.options.attackKey.isPressed();
      boolean var7 = var1.options.useKey.isPressed();
      if (var6) {
         boolean var8 = this.I_field_c2f1c7cc.II_method_16e3c2c6();
         if (var8 || var2 - this.I_field_4a >= var4) {
            this.I_field_c2f1c7cc.I_method_9da3c483();
            this.I_field_4a = var2;
         }
      } else {
         this.I_field_c2f1c7cc.IIi_method_c5b218bf();
      }

      if (var7 && var2 - this.i_field_4a >= var4) {
         this.I_field_c2f1c7cc.i_method_9db25063();
         this.i_field_4a = var2;
      }

      if (var1.options.dropKey.isPressed() && var2 - this.II_field_4a >= var4) {
         this.I_field_c2f1c7cc.II_method_c5954852(false);
         this.II_field_4a = var2;
      }
   }

   public void I_method_d927833e(Vec3d var1) {
      if (var1 != null) {
         this.I_field_c2f1c7cc.I_method_b644c79f(var1.x, var1.y, var1.z);
      }
   }

   public void I_method_4bc944c0(Vec3d var1, double var2) {
      this.I_field_c2f1c7cc.I_method_331eac73(var1, var2);
   }

   public void I_method_26853c32(double var1, double var3, double var5) {
      this.I_field_c2f1c7cc.i_method_530c2fbf(var1, var3, var5);
   }

   public void II_method_17ce4015() {
      this.I_field_c2f1c7cc.Ii_method_16f24ea2();
   }

   public void I_method_17bffb88(boolean var1) {
      this.I_field_c2f1c7cc.I_method_16d57e35(var1);
   }

   public void i_method_1982eba8(boolean var1) {
      this.I_field_c2f1c7cc.i_method_18986e55(var1);
   }

   public void I_method_db19174d(Hand var1) {
      this.I_field_c2f1c7cc.I_method_8e4568d5().I_method_f0d1c168(new HandSwingC2SPacket(var1 == null ? Hand.MAIN_HAND : var1));
   }

   public void II_method_e1fa755f(boolean var1) {
      this.I_field_c2f1c7cc.II_method_c5954852(var1);
   }

   public void Ii_method_17dccbf5() {
      this.I_field_c2f1c7cc.I_method_8e4568d5().I_method_f0d1c168(new ClientStatusC2SPacket(Mode.PERFORM_RESPAWN));
   }

   public void iI_method_19913035() {
      if (this.I_field_c2f1c7cc.Ii_method_16f24ea6() && this.I_field_c2f1c7cc.I_method_e09ce338().I_method_6865f490()) {
         int var1 = this.I_field_c2f1c7cc.I_method_e09ce338().Ii_method_a4762028();
         this.I_field_c2f1c7cc.I_method_8e4568d5().I_method_f0d1c168(new CloseHandledScreenC2SPacket(var1));
         this.I_field_c2f1c7cc.I_method_e09ce338().I_method_a4590ff7(var1);
      }
   }

   public boolean I_method_17bfbbbb(int var1) {
      return this.I_field_c2f1c7cc.I_method_16d53e68(var1);
   }

   public void I_method_967139(int var1, int var2, SlotActionType var3, long var4) {
      long var6 = System.currentTimeMillis() + Math.max(0L, var4);
      this.I_field_7865b31.add(new IIIiIIiI_Class19.Nested1_834ea0d3(var1, var2, var3 == null ? SlotActionType.PICKUP : var3, var6));
   }

   public boolean I_method_96bb943e(Item var1) {
      return this.I_field_c2f1c7cc.I_method_c28f1feb(var1);
   }

   public ItemStack I_method_3753958b(Hand var1) {
      return var1 == Hand.OFF_HAND ? this.i_field_f2735522 : this.I_field_f2735522;
   }

   public Vec3d I_method_b3d52b46() {
      return this.I_field_c2f1c7cc.I_method_4cb6e3b9();
   }

   public Vec3d i_method_57cdaf26() {
      return this.I_field_c2f1c7cc.i_method_f0af6799();
   }

   public boolean I_method_5b9ad0d0() {
      return this.II_field_46 > 0.0F;
   }

   public boolean i_method_5ba95cb0() {
      return !this.I_method_5b9ad0d0();
   }

   private double I_method_17bffb76(boolean var1) {
      return var1 ? 1.0 : 0.0;
   }

   private void ii_method_199fbc15() {
      if (!this.I_field_7865b31.isEmpty()) {
         long var1 = System.currentTimeMillis();
         Iterator var3 = this.I_field_7865b31.iterator();

         while (var3.hasNext()) {
            IIIiIIiI_Class19.Nested1_834ea0d3 var4 = (IIIiIIiI_Class19.Nested1_834ea0d3)var3.next();
            if (var1 >= var4.I_method_cf8deebb()) {
               this.I_field_c2f1c7cc.I_method_d346d622(var4.I_method_cf8deeba(), var4.i_method_cf9c7a9a(), var4.I_method_a479d3ee());
               var3.remove();
            }
         }
      }
   }

   private void III_method_e208b9ec() {
      if (this.I_field_c2f1c7cc.Ii_method_16f24ea6()) {
         IIIIIiIi_Class6 var1 = this.I_field_c2f1c7cc.I_method_e09ce338();
         this.Ii_field_49++;
         double var2 = var1.I_method_6865f47a() - this.I_field_44;
         double var4 = var1.i_method_6874805a() - this.i_field_44;
         double var6 = var1.II_method_a4679443() - this.II_field_44;
         float var8 = MathHelper.wrapDegrees(var1.I_method_6865f47c() - this.Ii_field_46);
         float var9 = var1.i_method_6874805c() - this.iI_field_46;
         boolean var10 = this.Ii_field_49 >= Math.max(1, this.I_field_c2f1c7cc.I_method_e08ecf78().IiI_method_e9bc99ff());
         boolean var11 = var2 * var2 + var4 * var4 + var6 * var6 > this.I_field_c2f1c7cc.I_method_e08ecf78().iiiI_method_ec6ff703() || var10;
         boolean var12 = Math.abs(var8) > this.I_field_c2f1c7cc.I_method_e08ecf78().iiii_method_ec7e82e3()
            || Math.abs(var9) > this.I_field_c2f1c7cc.I_method_e08ecf78().iiii_method_ec7e82e3();
         boolean var13 = var1.III_method_e899edb0() != this.IIi_field_5a;
         if (var11 && var12) {
            this.I_field_c2f1c7cc
               .I_method_8e4568d5()
               .I_method_f0d1c168(
                  new Full(
                     var1.I_method_6865f47a(),
                     var1.i_method_6874805a(),
                     var1.II_method_a4679443(),
                     var1.I_method_6865f47c(),
                     var1.i_method_6874805c(),
                     var1.III_method_e899edb0(),
                     false
                  )
               );
         } else if (var11) {
            this.I_field_c2f1c7cc
               .I_method_8e4568d5()
               .I_method_f0d1c168(
                  new PositionAndOnGround(var1.I_method_6865f47a(), var1.i_method_6874805a(), var1.II_method_a4679443(), var1.III_method_e899edb0(), false)
               );
         } else if (var12) {
            this.I_field_c2f1c7cc
               .I_method_8e4568d5()
               .I_method_f0d1c168(new LookAndOnGround(var1.I_method_6865f47c(), var1.i_method_6874805c(), var1.III_method_e899edb0(), false));
         } else {
            if (!var13) {
               return;
            }

            this.I_field_c2f1c7cc.I_method_8e4568d5().I_method_f0d1c168(new OnGroundOnly(var1.III_method_e899edb0(), false));
         }

         if (var11) {
            this.I_field_44 = var1.I_method_6865f47a();
            this.i_field_44 = var1.i_method_6874805a();
            this.II_field_44 = var1.II_method_a4679443();
            this.Ii_field_49 = 0;
         }

         if (var12) {
            this.Ii_field_46 = var1.I_method_6865f47c();
            this.iI_field_46 = var1.i_method_6874805c();
         }

         this.IIi_field_5a = var1.III_method_e899edb0();
         var1.I_method_6865f48c();
      }
   }

   private void Ii_method_fdc87a5c(MinecraftClient var1) {
      if (this.I_field_77fa5f41 == null || this.I_field_77fa5f41.clientWorld != var1.world || this.I_field_77fa5f41.isRemoved()) {
         if (this.I_field_77fa5f41 != null) {
            this.I_field_77fa5f41.i_method_f57d086c();
         }

         UUID var2 = UUID.nameUUIDFromBytes(("RockstarBotCamera:" + this.I_field_c2f1c7cc.I_method_7b75de01()).getBytes(StandardCharsets.UTF_8));
         this.I_field_77fa5f41 = new IIIiIIIi_Class18(var1.world, new GameProfile(var2, this.I_field_c2f1c7cc.I_method_7b75de01()));
         this.I_field_77fa5f41.I_method_f56e7c8c();
      }
   }

   private void iI_method_b94fae9c(MinecraftClient var1) {
      if (var1 != null && var1.player != null && this.I_field_6132843d == null) {
         PlayerInventory var2 = var1.player.getInventory();
         this.I_field_6132843d = new ItemStack[var2.size()];

         for (int var3 = 0; var3 < this.I_field_6132843d.length; var3++) {
            this.I_field_6132843d[var3] = this.I_method_d2274a(var2.getStack(var3));
         }

         this.II_field_49 = var2.selectedSlot;
      }
   }

   private void ii_method_a5f6527c(MinecraftClient var1) {
      if (var1 != null && var1.player != null && this.I_field_6132843d != null) {
         PlayerInventory var2 = var1.player.getInventory();

         for (int var3 = 0; var3 < this.I_field_6132843d.length && var3 < var2.size(); var3++) {
            var2.setStack(var3, this.I_method_d2274a(this.I_field_6132843d[var3]));
         }

         var2.selectedSlot = MathHelper.clamp(this.II_field_49, 0, 8);
         var2.markDirty();
         this.I_field_6132843d = null;
      } else {
         this.I_field_6132843d = null;
      }
   }

   private void III_method_a4893713(MinecraftClient var1) {
      if (var1 != null && var1.player != null) {
         IIIIIiIi_Class6 var2 = this.I_field_c2f1c7cc.I_method_e09ce338();
         PlayerInventory var3 = var1.player.getInventory();
         ItemStack[] var4 = var2.I_method_12cfb5f3();

         for (int var5 = 0; var5 < var4.length && var5 < 36 && var5 < var3.size(); var5++) {
            var3.setStack(var5, this.I_method_d2274a(var4[var5]));
         }

         ItemStack[] var8 = var2.i_method_b6c839d3();

         for (int var6 = 0; var6 < var8.length; var6++) {
            int var7 = 36 + var6;
            if (var7 < var3.size()) {
               var3.setStack(var7, this.I_method_d2274a(var8[var6]));
            }
         }

         if (40 < var3.size()) {
            var3.setStack(40, this.I_method_d2274a(var2.i_method_b32594cc()));
         }

         var3.selectedSlot = MathHelper.clamp(var2.i_method_6874805f(), 0, 8);
         var3.markDirty();
      }
   }

   private void I_method_76f10d74(MinecraftClient var1, IIIIIiIi_Class6 var2) {
      if (var1 != null && var1.player != null && var2 != null) {
         int var3 = MathHelper.clamp(var1.player.getInventory().selectedSlot, 0, 8);
         if (var3 != var2.i_method_6874805f()) {
            this.I_field_c2f1c7cc.i_method_18982e84(var3);
         }
      }
   }

   private ItemStack I_method_d2274a(ItemStack var1) {
      return var1 == null ? ItemStack.EMPTY : var1.copy();
   }

   private void IIi_method_e21745cc() {
      if (this.III_field_5a && this.I_field_77fa5f41 != null && !this.I_field_77fa5f41.isRemoved()) {
         this.I_field_77fa5f41.I_method_aa0fe7ba(this.I_field_c2f1c7cc);
      }
   }

   @Generated
   public iiiiiii_Class128 I_method_9d601642() {
      return this.I_field_c2f1c7cc;
   }

   @Generated
   public IIIiIIii_Class20 I_method_eb5657ab() {
      return this.I_field_77fad761;
   }

   @Generated
   public Vec3d II_method_39fd74cf() {
      return this.I_field_5bba0d50;
   }

   @Generated
   public float I_method_5b9ad0bc() {
      return this.I_field_46;
   }

   @Generated
   public float i_method_5ba95c9c() {
      return this.i_field_46;
   }

   @Generated
   public boolean II_method_17ce4019() {
      return this.I_field_5a;
   }

   @Generated
   public boolean Ii_method_17dccbf9() {
      return this.i_field_5a;
   }

   @Generated
   public boolean iI_method_19913039() {
      return this.II_field_5a;
   }

   @Generated
   public boolean ii_method_199fbc19() {
      return this.Ii_field_5a;
   }

   @Generated
   public boolean III_method_e208b9f0() {
      return this.iI_field_5a;
   }

   @Generated
   public boolean IIi_method_e21745d0() {
      return this.ii_field_5a;
   }

   @Generated
   public float II_method_17ce4005() {
      return this.II_field_46;
   }

   @Generated
   public int I_method_5b9ad0bf() {
      return this.I_field_49;
   }

   @Generated
   public int i_method_5ba95c9f() {
      return this.i_field_49;
   }

   @Generated
   public ItemStack I_method_5021a06c() {
      return this.I_field_f2735522;
   }

   @Generated
   public ItemStack i_method_b19208c() {
      return this.i_field_f2735522;
   }

   @Generated
   public boolean IiI_method_e3cbaa10() {
      return this.III_field_5a;
   }

   @Generated
   public IIIiIIIi_Class18 I_method_eb55df8b() {
      return this.I_field_77fa5f41;
   }

   @Generated
   public Entity I_method_bcf6a502() {
      return this.I_field_77e0818c;
   }

   @Generated
   public ItemStack[] I_method_b94da233() {
      return this.I_field_6132843d;
   }

   @Generated
   public int II_method_17ce4008() {
      return this.II_field_49;
   }

   @Generated
   public long I_method_5b9ad0c0() {
      return this.I_field_4a;
   }

   @Generated
   public long i_method_5ba95ca0() {
      return this.i_field_4a;
   }

   @Generated
   public long II_method_17ce4009() {
      return this.II_field_4a;
   }

   @Generated
   public double I_method_5b9ad0ba() {
      return this.I_field_44;
   }

   @Generated
   public double i_method_5ba95c9a() {
      return this.i_field_44;
   }

   @Generated
   public double II_method_17ce4003() {
      return this.II_field_44;
   }

   @Generated
   public float Ii_method_17dccbe5() {
      return this.Ii_field_46;
   }

   @Generated
   public float iI_method_19913025() {
      return this.iI_field_46;
   }

   @Generated
   public boolean Iii_method_e3da35f0() {
      return this.IIi_field_5a;
   }

   @Generated
   public int Ii_method_17dccbe8() {
      return this.Ii_field_49;
   }

   @Generated
   public List<IIIiIIiI_Class19.Nested1_834ea0d3> I_method_422dcffb() {
      return this.I_field_7865b31;
   }

   static final class Nested1_834ea0d3 {
      private final int I_field_49;
      private final int i_field_49;
      private final SlotActionType I_field_f6578f3f;
      private final long I_field_4a;

      Nested1_834ea0d3(int var1, int var2, SlotActionType var3, long var4) {
         this.I_field_49 = var1;
         this.i_field_49 = var2;
         this.I_field_f6578f3f = var3;
         this.I_field_4a = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_834ea0d3[slot=" + this.I_field_49 + ", button=" + this.i_field_49 + ", actionType=" + this.I_field_f6578f3f + ", runAtMs=" + this.I_field_4a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f6578f3f);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIiIIiI_Class19.Nested1_834ea0d3 other = (IIIiIIiI_Class19.Nested1_834ea0d3) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_49, other.i_field_49)
            && java.util.Objects.equals(this.I_field_f6578f3f, other.I_field_f6578f3f)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a);
      }

      public int I_method_cf8deeba() {
         return this.I_field_49;
      }

      public int i_method_cf9c7a9a() {
         return this.i_field_49;
      }

      public SlotActionType I_method_a479d3ee() {
         return this.I_field_f6578f3f;
      }

      public long I_method_cf8deebb() {
         return this.I_field_4a;
      }
   }
}
