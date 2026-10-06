package rockstar.client;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lombok.Generated;
import moscow.rockstar.mixin.accessors.ItemCooldownEntryAccessor;
import moscow.rockstar.mixin.accessors.ItemCooldownManagerAccessor;
import net.minecraft.block.Block;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.consume.UseAction;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket.Action;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import pyrock.events.game.EntityJumpEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Aura",
   category = ModuleCategory.COMBAT,
   III_method_a89e5834 = "modules.descriptions.aura"
)
public class AuraModule extends Module {
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private MultiSelectSetting I_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 III_field_51de8227;
   private ModeSetting I_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private ModeSetting.Nested1_42765c60 II_field_500d0627;
   private ModeSetting i_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
   private ModeSetting.Nested1_42765c60 iI_field_500d0627;
   private ModeSetting II_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 ii_field_500d0627;
   private ModeSetting.Nested1_42765c60 III_field_500d0627;
   private ModeSetting.Nested1_42765c60 IIi_field_500d0627;
   private ModeSetting Ii_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 IiI_field_500d0627;
   private ModeSetting.Nested1_42765c60 Iii_field_500d0627;
   private ModeSetting.Nested1_42765c60 iII_field_500d0627;
   private ModeSetting.Nested1_42765c60 iIi_field_500d0627;
   private BooleanSetting I_field_ba20ca4c;
   private BooleanSetting i_field_ba20ca4c;
   private ModeSetting iI_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 iiI_field_500d0627;
   private ModeSetting.Nested1_42765c60 iii_field_500d0627;
   private RangeSetting I_field_bbe3b68c;
   private BooleanSetting II_field_ba20ca4c;
   private BooleanSetting Ii_field_ba20ca4c;
   private BooleanSetting iI_field_ba20ca4c;
   private BooleanSetting ii_field_ba20ca4c;
   private BooleanSetting III_field_ba20ca4c;
   private BooleanSetting IIi_field_ba20ca4c;
   private BooleanSetting IiI_field_ba20ca4c;
   private ModeSetting ii_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 IIII_field_500d0627;
   private ModeSetting.Nested1_42765c60 IIIi_field_500d0627;
   private ModeSetting.Nested1_42765c60 IIiI_field_500d0627;
   private ModeSetting.Nested1_42765c60 IIii_field_500d0627;
   private ModeSetting.Nested1_42765c60 IiII_field_500d0627;
   private ModeSetting III_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 IiIi_field_500d0627;
   private ModeSetting.Nested1_42765c60 IiiI_field_500d0627;
   private ModeSetting.Nested1_42765c60 Iiii_field_500d0627;
   private ModeSetting IIi_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 iIII_field_500d0627;
   private ModeSetting.Nested1_42765c60 iIIi_field_500d0627;
   private ModeSetting.Nested1_42765c60 iIiI_field_500d0627;
   private MultiSelectSetting i_field_bbe3ba6c;
   private MultiSelectSetting.Nested1_42856060 IIi_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 IiI_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 Iii_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iII_field_51de8227;
   private MultiSelectSetting.Nested1_42856060 iIi_field_51de8227;
   private iiIiIIiii_Class424 I_field_991c1e8c;
   private long I_field_4a;
   private float I_field_46;
   boolean I_field_5a;
   boolean i_field_5a;
   boolean II_field_5a;
   int I_field_49;
   private final iiiIIiIi_Class230 I_field_62e8bb61 = new iiiIIiIi_Class230();
   private iiiIIiii_Class232 I_field_62e93381;
   private int i_field_49;
   private iiIIiIIii_Class404 I_field_32e13e6c;
   private boolean Ii_field_5a;
   private boolean iI_field_5a;
   private int II_field_49 = -1;
   private boolean ii_field_5a;
   private static final float i_field_46 = 1.5F;
   private static final int Ii_field_49 = 4;
   private static final long i_field_4a = 200L;
   private float II_field_46 = iIIiiiiiI_Class319.iI_method_330da892(0.0F, 1.0F);
   private long II_field_4a;
   private final Map<String, Integer> I_field_a567c40b = new LinkedHashMap<>();
   private final IiIIIiII_Class69<EntityJumpEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.player == var1.getEntity()) {
         if (this.III_field_bbe33e6c.I_method_ce989e26(this.IiiI_field_500d0627)
            && I_field_3a9bda27.player.isOnGround()
            && I_field_3a9bda27.player.getMainHandStack().getItem() instanceof SwordItem) {
            LivingEntity var2 = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c();
            if (iIIIiIiiI_Class279.I_method_5a6fa1f8(I_field_3a9bda27.player).I_method_2db0dd85(IiiiiIiII_Class245.I_method_71f7f60e(var2), 40, true) > 10) {
               var1.cancel();
            }
         }
      }
   };

   public AuraModule() {
      this.IiI_method_ce89e1cc();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_ce89e1cc() {
      this.i_field_bbe33e6c = new ModeSetting(this, "modules.settings.aura.rotationMode");
      this.iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.aura.noRotation");
      this.Ii_field_500d0627 = new iiiIIIiI_Class227(this.i_field_bbe33e6c).select();
      new iiiIIIII_Class225(this.i_field_bbe33e6c);
      this.I_field_62e93381 = new iiiIIiii_Class232(this.i_field_bbe33e6c);
      this.II_field_bbe33e6c = new ModeSetting(
         this, "modules.settings.aura.returnMode", () -> this.i_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627)
      );
      this.ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "modules.settings.aura.returnMode.none");
      this.III_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "modules.settings.aura.returnMode.smooth").select();
      this.IIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "modules.settings.aura.returnMode.camera");
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.aura.attackDistance")
         .I_method_c8c9a7d7(0.1F)
         .i_method_65e2aff7(6.0F)
         .II_method_b0f56334(0.1F)
         .Ii_method_4e0e6b54(3.0F)
         .I_method_bfc3b958(var0 -> " %s".formatted(IiIiIIII_Class81.I_method_f25a980a("block")) + iIIIIiIiI_Class267.i_method_c309455f(var0))
         .I_method_a8d4839d(var1 -> {
            if (this.i_field_73178e8c != null && this.i_field_73178e8c.Ii_method_a20abcd2() < var1) {
               this.i_field_73178e8c.Ii_method_4e0e6b54(var1);
            }

            return var1;
         });
      this.i_field_73178e8c = new SliderSetting(this, "modules.settings.aura.aimDistance")
         .I_method_c8c9a7d7(0.1F)
         .i_method_65e2aff7(9.0F)
         .II_method_b0f56334(0.1F)
         .Ii_method_4e0e6b54(3.0F)
         .I_method_bfc3b958(var0 -> " %s".formatted(IiIiIIII_Class81.I_method_f25a980a("block")) + iIIIIiIiI_Class267.i_method_c309455f(var0))
         .I_method_a8d4839d(var1 -> this.I_field_73178e8c == null ? var1 : Math.max(this.I_field_73178e8c.Ii_method_a20abcd2(), var1));
      this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.aura.onlyCrits").I_method_decd82b5();
      this.Ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.aura.smart_criticals", () -> !this.II_field_ba20ca4c.i_method_9b12da03());
      this.ii_field_bbe33e6c = new ModeSetting(this, "modules.settings.aura.walls");
      this.IIII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.aura.walls.none").select();
      this.IIIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.aura.walls.all");
      this.IIiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.aura.walls.doors");
      this.IIii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.aura.walls.rw");
      this.IiII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.aura.walls.ft");
      this.iI_field_ba20ca4c = new BooleanSetting(this, "modules.settings.aura.rayTrace").I_method_decd82b5();
      this.IIi_field_ba20ca4c = new BooleanSetting(this, "modules.settings.aura.targeting").I_method_decd82b5();
      this.ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.aura.onlyWeapon");
      this.III_field_ba20ca4c = new BooleanSetting(this, "modules.settings.aura.auto_mace", "modules.settings.aura.auto_mace.description");
      this.IiI_field_ba20ca4c = new BooleanSetting(this, "modules.settings.aura.no_hit_inv");
      this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.aura.targets");
      this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.players").select();
      this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.animals").select();
      this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.mobs").select();
      this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.invisibles").select();
      this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.nakedPlayers").select();
      this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.rockUsers");
      this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.aura.targets.friends");
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.aura.sorting");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.aura.distanceSorting").select();
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.aura.healthSorting");
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.aura.fovSorting");
      this.Ii_field_bbe33e6c = new ModeSetting(this, "modules.settings.aura.moveCorrectionMode");
      this.IiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.aura.noMoveCorrection");
      this.Iii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.aura.directMoveCorrection");
      this.iII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.aura.silentMoveCorrection").select();
      this.iIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.aura.targeted_move_correction");
      this.I_field_ba20ca4c = new BooleanSetting(
         this, "modules.settings.aura.force_targeted_ranged", () -> this.Ii_field_bbe33e6c.I_method_ce989e26(this.iIi_field_500d0627)
      );
      this.i_field_ba20ca4c = new BooleanSetting(
         this,
         "modules.settings.aura.force_behind_targeted",
         () -> !this.I_field_ba20ca4c.i_method_9b12da03() || this.Ii_field_bbe33e6c.I_method_ce989e26(this.iIi_field_500d0627)
      );
      this.iI_field_bbe33e6c = new ModeSetting(this, "modules.settings.aura.styleAttack");
      this.iiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.iI_field_bbe33e6c, "1.8");
      this.iii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.iI_field_bbe33e6c, "1.9").select();
      this.I_field_bbe3b68c = new RangeSetting(this, "modules.settings.aura.cps_limiter", this.iii_field_500d0627::isSelected)
         .II_method_c7edb334(1.0F)
         .Ii_method_6506bb54(20.0F)
         .iI_method_cdf5af14(1.0F)
         .I_method_3944a7d7(8.0F)
         .i_method_d65daff7(12.0F);
      this.III_field_bbe33e6c = new ModeSetting(this, "modules.settings.aura.crit_calc");
      this.IiIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.III_field_bbe33e6c, "modules.settings.aura.crit_calc.old").select();
      this.IiiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.III_field_bbe33e6c, "modules.settings.aura.crit_calc.new");
      this.Iiii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.III_field_bbe33e6c, "modules.settings.aura.crit_calc.air");
      this.IIi_field_bbe33e6c = new ModeSetting(this, "modules.settings.aura.sprint_reset");
      this.iIII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.IIi_field_bbe33e6c, "modules.settings.aura.sprint_reset.smart");
      this.iIIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.IIi_field_bbe33e6c, "modules.settings.aura.sprint_reset.normal");
      this.iIiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.IIi_field_bbe33e6c, "modules.settings.aura.sprint_reset.packet");
      this.iIII_field_500d0627.select();
      this.i_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.aura.utilities");
      this.IIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.aura.resolver");
      this.IiI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.aura.useHit");
      this.iIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(
         this.i_field_bbe3ba6c, "modules.settings.aura.no_teammates_1_8", () -> !this.iiI_field_500d0627.isSelected()
      );
      this.Iii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.aura.sync");
      this.iII_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.aura.sync_tps");
      this.I_field_991c1e8c = new iiIiIIiii_Class424();
   }

   public iiiIIiII_Class229 I_method_ca3480b() {
      if (this.ii_field_bbe33e6c == null || this.ii_field_bbe33e6c.I_method_ce989e26(this.IIII_field_500d0627)) {
         return iiiIIiII_Class229.I_field_62e8b781;
      } else if (this.ii_field_bbe33e6c.I_method_ce989e26(this.IIIi_field_500d0627)) {
         return iiiIIiII_Class229.i_field_62e8b781;
      } else if (this.ii_field_bbe33e6c.I_method_ce989e26(this.IIiI_field_500d0627)) {
         return iiiIIiII_Class229.II_field_62e8b781;
      } else if (this.ii_field_bbe33e6c.I_method_ce989e26(this.IiII_field_500d0627)) {
         return iiiIIiII_Class229.Ii_field_62e8b781;
      } else {
         return this.ii_field_bbe33e6c.I_method_ce989e26(this.IIii_field_500d0627) ? iiiIIiII_Class229.iI_field_62e8b781 : iiiIIiII_Class229.I_field_62e8b781;
      }
   }

   @Override
   public void II_method_6642fd22() {
      if (this.i_field_73178e8c.Ii_method_a20abcd2() < this.I_field_73178e8c.Ii_method_a20abcd2()) {
         this.i_field_73178e8c.Ii_method_4e0e6b54(this.I_field_73178e8c.Ii_method_a20abcd2());
      }

      if (I_field_3a9bda27.player != null) {
         if (this.i_field_bbe33e6c.i_method_f85f3850() instanceof iiiIIIIi_Class226 var1) {
            var1.update();
         }

         ElytraTargetModule var10 = RockstarClient.getInstance().getModuleManager().getModule(ElytraTargetModule.class);
         boolean var11 = var10.isEnabled();
         float var3 = var11 ? var10.II_method_42bc1d8b().Ii_method_a20abcd2() : Math.max(this.i_field_73178e8c.Ii_method_a20abcd2(), this.I_method_bc03f87c());
         IiIIIiIiI_Class139.Nested1_a87537e0 var4 = new IiIIIiIiI_Class139.Nested1_a87537e0()
            .I_method_1f3a928b(this.I_field_51de8227.isSelected())
            .i_method_da3212ab(!var11 && this.i_field_51de8227.isSelected())
            .II_method_9a5032be(!var11 && this.II_field_51de8227.isSelected())
            .iI_method_3e48b69e(this.Ii_field_51de8227.isSelected())
            .ii_method_f94036be(this.iI_field_51de8227.isSelected())
            .III_method_81ee98eb(this.ii_field_51de8227.isSelected())
            .Ii_method_5547b2de(this.III_field_51de8227.isSelected())
            .IiI_method_25e71ccb(this.iIi_field_51de8227.isSelected() && this.iiI_field_500d0627.isSelected())
            .I_method_7d0aed77(var3);
         if (var11 || this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)) {
            var4.I_method_8fd609a4(IiIIIiIII_Class137.I_field_c8f916f9);
         } else if (this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)) {
            var4.I_method_8fd609a4(IiIIIiIII_Class137.i_field_c8f916f9);
         } else if (this.I_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627)) {
            var4.I_method_8fd609a4(IiIIIiIII_Class137.II_field_c8f916f9);
         }

         IiIIIiIiI_Class139 var5 = var4.I_method_7ebd8d70();
         LivingEntity var7 = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815() instanceof LivingEntity var8 ? var8 : null;
         if (!this.IIi_field_ba20ca4c.i_method_9b12da03()
            || var7 == null
            || !var5.I_method_b72bafcb(var7)
            || MathHelper.sqrt((float)I_field_3a9bda27.player.squaredDistanceTo(iiIIiIiIi_Class406.I_method_396699c1(var7))) > var3
            || !I_field_3a9bda27.world.hasEntity(var7)
            || !var7.isAlive()
            || AntiBotModule.I_method_fe179c75(var7)) {
            RockstarClient.getInstance().I_method_9a638462().I_method_aa3068e7(var5);
            var7 = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815() instanceof LivingEntity var13 ? var13 : null;
         }

         if (var7 != null) {
            this.iI_method_e348e408(var7);
            this.i_field_5a = false;

            for (PlayerEntity var9 : I_field_3a9bda27.world.getPlayers()) {
               if (I_field_3a9bda27.player.distanceTo(var9) < 4.0F
                  && RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var9.getNameForScoreboard())) {
                  this.i_field_5a = true;
               }
            }

            this.II_method_ff8ac828(var7);
            if (this.iii_method_5338190()) {
               this.I_field_a567c40b
                  .merge("\u0441\u043f\u0440\u0438\u043d\u0442-\u0440\u0435\u0441\u0435\u0442 (\u0434\u043e \u0443\u0434\u0430\u0440\u0430)", 1, Integer::sum);
               return;
            }

            if (this.I_method_b1834867(var7, true)) {
               if (this.Ii_method_1fa9b04c(var7)) {
                  this.I_field_a567c40b
                     .merge(
                        "\u0441\u043f\u0440\u0438\u043d\u0442-\u0440\u0435\u0441\u0435\u0442 (\u0432\u043c\u0435\u0441\u0442\u043e \u0443\u0434\u0430\u0440\u0430)",
                        1,
                        Integer::sum
                     );
                  return;
               }

               this.I_field_a567c40b.merge("\u2605 \u0423\u0414\u0410\u0420 \u0412\u042b\u041f\u041e\u041b\u041d\u0415\u041d", 1, Integer::sum);
               this.i_method_b23be4b1(var7);
            }
         } else {
            IiIIIIii_Class68.I_field_108dc26c.I_method_73f3183b(this);
            this.Iii_method_ce986dac();
            if (this.i_field_bbe33e6c.i_method_f85f3850() instanceof iiiIIIIi_Class226 var15) {
               this.Ii_field_5a = false;
               var15.targetNull();
            }
         }
      }
   }

   public boolean I_method_b1834867(LivingEntity var1, boolean var2) {
      if (!this.IiI_method_ce89e1d0()) {
         return this.I_method_ebe8975a("\u043a\u0443\u043b\u0434\u0430\u0443\u043d \u0430\u0443\u0440\u044b");
      } else if (AntiBotModule.I_method_fe179c75(var1)) {
         return this.I_method_ebe8975a("antibot");
      } else if (this.iI_field_bbe33e6c.I_method_ce989e26(this.iiI_field_500d0627)
         && this.iIi_field_51de8227.isSelected()
         && var1 instanceof PlayerEntity var3
         && IiIIIiIiI_Class139.I_method_b9048f8d(I_field_3a9bda27.player, var3)) {
         return this.I_method_ebe8975a("\u0441\u043e\u044e\u0437\u043d\u0438\u043a");
      } else {
         CriticalsModule var8 = RockstarClient.getInstance().getModuleManager().getModule(CriticalsModule.class);
         if (var8.iII_method_2c60a1f0() && !var8.IiI_method_f7887e30()) {
            return this.I_method_ebe8975a("\u043c\u043e\u0434\u0443\u043b\u044c Criticals");
         } else if (this.ii_field_ba20ca4c.i_method_9b12da03() && !IiiiiiiII_Class253.II_method_7a1ca106()) {
            return this.I_method_ebe8975a("\u043d\u0435 \u043e\u0440\u0443\u0436\u0438\u0435 \u0432 \u0440\u0443\u043a\u0435");
         } else if (this.IiII_method_2c14f19()) {
            return this.I_method_ebe8975a("\u0438\u0441\u043f\u043e\u043b\u044c\u0437\u0443\u0435\u0442\u0441\u044f \u043f\u0440\u0435\u0434\u043c\u0435\u0442");
         } else if (this.i_field_bbe33e6c.i_method_f85f3850() instanceof iiiIIIIi_Class226 var4 && !var4.canAttack()) {
            return this.I_method_ebe8975a("\u0440\u0435\u0436\u0438\u043c \u043d\u0435 \u0445\u043e\u0447\u0435\u0442 \u0431\u0438\u0442\u044c");
         } else if (I_field_3a9bda27.currentScreen instanceof InventoryScreen && this.IiI_field_ba20ca4c.i_method_9b12da03()) {
            return this.I_method_ebe8975a("\u043e\u0442\u043a\u0440\u044b\u0442 \u0438\u043d\u0432\u0435\u043d\u0442\u0430\u0440\u044c");
         } else if (this.Iii_field_51de8227.isSelected() && I_field_3a9bda27.player.hurtTime > 0 && this.i_field_5a) {
            return this.I_method_ebe8975a("sync \u043f\u043e hurtTime");
         } else if (!this.i_method_b23be4b5(var1)) {
            return this.I_method_ebe8975a("\u0434\u0430\u043b\u0435\u043a\u043e (attackDistance)");
         } else {
            if (this.ii_method_367cc2c(var1) && IiiiiIiII_Class245.I_method_cca9db15() != null) {
               if (!this.IIII_method_cc263b39()) {
                  return this.I_method_ebe8975a(
                     "\u043e\u0436\u0438\u0434\u0430\u0435\u043c \u0432\u044b\u0441\u043e\u0442\u0443 \u0434\u043b\u044f \u0431\u0443\u043b\u0430\u0432\u044b"
                  );
               }

               if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) && !this.IIIi_method_cc34c719()) {
                  return this.I_method_ebe8975a(
                     "\u043e\u0436\u0438\u0434\u0430\u0435\u043c \u0441\u0432\u0430\u043f \u043d\u0430 \u0431\u0443\u043b\u0430\u0432\u0443"
                  );
               }
            }

            ElytraTargetModule var9 = RockstarClient.getInstance().getModuleManager().getModule(ElytraTargetModule.class);
            boolean var10 = var9.isEnabled() && I_field_3a9bda27.player.isGliding() && I_field_3a9bda27.player.getVelocity().length() < 6.0;
            if (var10) {
               return true;
            } else if (!(this.i_field_bbe33e6c.i_method_f85f3850() instanceof iiiIIIII_Class225 var6 && var6.I_method_98d118f0())
               && !iIIiiiiiI_Class319.I_method_9b00cfe4(
                  this.I_method_bc03f87c(),
                  RockstarClient.getInstance().I_method_58785402().II_method_f098f858().I_method_14534e0f(),
                  RockstarClient.getInstance().I_method_58785402().II_method_f098f858().i_method_1461d9ef(),
                  I_field_3a9bda27.player,
                  var1,
                  this.I_method_ca3480b()
               )
               && this.iI_field_ba20ca4c.i_method_9b12da03()
               && var2
               && (this.I_field_62e8bb61.I_method_746a540b() == null || this.I_field_62e8bb61.I_method_cb91c89f() <= 1)
               && !this.II_field_5a) {
               return this.I_method_ebe8975a("\u0440\u0435\u0439\u0442\u0440\u0435\u0439\u0441 \u043d\u0435 \u043f\u0440\u043e\u0445\u043e\u0434\u0438\u0442");
            } else if (this.iiI_method_524f5b0() && this.II_method_ff8ac82c(var1) && !IiiiiIiII_Class245.I_method_cd07807a(var1, true)) {
               return this.I_method_ebe8975a("\u0436\u0434\u0451\u043c \u043a\u0440\u0438\u0442");
            } else {
               this.I_field_a567c40b
                  .merge("\u043f\u0440\u043e\u0432\u0435\u0440\u043a\u0438 \u043f\u0440\u043e\u0439\u0434\u0435\u043d\u044b", 1, Integer::sum);
               return true;
            }
         }
      }
   }

   private boolean I_method_ebe8975a(String var1) {
      this.I_field_a567c40b.merge(var1, 1, Integer::sum);
      return false;
   }

   public boolean I_method_921cfc95(LivingEntity var1) {
      return this.i_method_95416447(var1, false);
   }

   public boolean i_method_95416447(LivingEntity var1, boolean var2) {
      CriticalsModule var3 = RockstarClient.getInstance().getModuleManager().getModule(CriticalsModule.class);
      if (var3.iII_method_2c60a1f0() && !var3.IiI_method_f7887e30()) {
         return false;
      } else if (this.ii_field_ba20ca4c.i_method_9b12da03() && !IiiiiiiII_Class253.II_method_7a1ca106()) {
         return false;
      } else if (this.IiII_method_2c14f19()) {
         return false;
      } else if (this.i_field_bbe33e6c.i_method_f85f3850() instanceof iiiIIIIi_Class226 var4 && !var4.canAttack()) {
         return false;
      } else if (I_field_3a9bda27.currentScreen instanceof InventoryScreen && this.IiI_field_ba20ca4c.i_method_9b12da03()) {
         return false;
      } else if (this.Iii_field_51de8227.isSelected() && I_field_3a9bda27.player.hurtTime > 0 && this.i_field_5a) {
         return false;
      } else {
         if (var2) {
            if (I_field_3a9bda27.player
                  .getEyePos()
                  .add(0.0, -1.0, 0.0)
                  .distanceTo(iiIIiIiIi_Class406.I_method_47b889e6(var1, IiiiiIiII_Class245.I_method_34612227(var1, this.IIi_field_51de8227.isSelected())))
               > this.I_method_bc03f87c()) {
               return false;
            }
         } else if (!this.i_method_b23be4b5(var1)) {
            return false;
         }

         return !this.iiI_method_524f5b0() || !this.II_method_ff8ac82c(var1) || IiiiiIiII_Class245.I_method_71f7f622(var1);
      }
   }

   private boolean II_method_ff8ac82c(LivingEntity var1) {
      float var2 = this.I_method_921cfc81(var1);
      return var2 <= var1.getHealth();
   }

   public boolean IiI_method_ce89e1d0() {
      if (I_field_3a9bda27.player == null) {
         return false;
      } else if (I_field_3a9bda27.player.isSubmergedInWater() && iIIIiiiII_Class285.Ii_method_b349c526()) {
         return this.iIi_method_3709170();
      } else {
         float var1 = this.II_method_c48a1045();
         float var2 = this.iII_field_51de8227.isSelected() ? Math.min(1.0F, 0.8F * var1) : 0.8F;
         boolean var3 = I_field_3a9bda27.player.getAttackCooldownProgress(0.0F) >= var2;
         return this.iI_field_bbe33e6c.I_method_ce989e26(this.iiI_field_500d0627)
            ? this.I_field_991c1e8c.I_method_58432069(this.I_method_bc03f880())
            : var3 && this.I_field_991c1e8c.I_method_58432069(Math.round(500.0F * var1));
      }
   }

   private boolean iIi_method_3709170() {
      if (I_field_3a9bda27.player.getAttackCooldownProgress(0.0F) < 1.0F) {
         this.II_field_4a = 0L;
         return false;
      } else {
         if (this.II_field_4a == 0L) {
            this.II_field_4a = System.currentTimeMillis();
         }

         long var1 = Math.round(Math.clamp(this.II_field_46, 0.0F, 1.0F) * 200.0F);
         return System.currentTimeMillis() - this.II_field_4a >= var1;
      }
   }

   public float I_method_921cfc81(LivingEntity var1) {
      return 0.0F;
   }

   private void I_method_921cfc91(LivingEntity var1) {
      if (this.I_method_ca3480b() == iiiIIiII_Class229.iI_field_62e8b781 && I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && var1 != null) {
         iiIIiIIii_Class404 var2 = this.i_field_bbe33e6c.i_method_f85f3850() instanceof iiiIIIII_Class225 var3 && var3.I_method_98d118f0()
            ? var3.I_method_a7842782()
            : iiIIiIiIi_Class406.I_method_a2bb2af5(var1, this);
         List var7 = this.I_method_36a272b2(var1, var2);
         if (!var7.isEmpty()) {
            for (BlockHitResult var5 : (Iterable<BlockHitResult>)(Iterable<?>)var7) {
               Direction var6 = var5.getSide();
               I_field_3a9bda27.player.networkHandler.sendPacket(new PlayerActionC2SPacket(Action.STOP_DESTROY_BLOCK, var5.getBlockPos(), var6));
               I_field_3a9bda27.player.networkHandler.sendPacket(new PlayerActionC2SPacket(Action.START_DESTROY_BLOCK, var5.getBlockPos(), var6));
            }
         }
      }
   }

   private List<BlockHitResult> I_method_36a272b2(LivingEntity var1, iiIIiIIii_Class404 var2) {
      ArrayList var3 = new ArrayList();
      if (var1 != null && I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         float var4 = I_field_3a9bda27.getRenderTickCounter().getTickDelta(false);
         Vec3d var5 = I_field_3a9bda27.player.getCameraPosVec(var4);
         Vec3d var6 = iIIiiiiiI_Class319.I_method_dcd241b9(var2.i_method_1461d9ef(), var2.I_method_14534e0f());
         double var7 = var6.lengthSquared();
         if (var7 < 1.0E-8) {
            return var3;
         } else {
            Vec3d var9 = var6.multiply(1.0 / Math.sqrt(var7));
            double var10 = this.I_method_bc03f87c();
            Vec3d var12 = var5.add(var9.multiply(var10));
            double var13 = I_method_e2e8ea4b(var5, var9, var12, var10, var1);
            LinkedHashSet var15 = new LinkedHashSet();
            var15.add(var5);
            Vec3d var16 = I_method_39537a78(var9);
            if (var16.lengthSquared() > 1.0E-8) {
               var16 = var16.normalize().multiply(0.09);
               var15.add(var5.add(var16));
               var15.add(var5.subtract(var16));
            }

            ArrayList var17 = new ArrayList();
            HashSet var18 = new HashSet();

            for (Vec3d var20 : (Iterable<Vec3d>)(Iterable<?>)var15) {
               Vec3d var21 = var20.add(var9.multiply(var10));

               for (BlockHitResult var23 : this.I_method_4a7d4255(var20, var21, var9, var5, var13)) {
                  if (var18.add(var23.getBlockPos())) {
                     var17.add(var23);
                  }
               }
            }

            var17.sort(Comparator.comparingDouble(var2x -> ((net.minecraft.entity.Entity)var2x).getPos().subtract(var5).dotProduct(var9)));
            var3.addAll(var17);
            return var3;
         }
      } else {
         return var3;
      }
   }

   private static Vec3d I_method_39537a78(Vec3d var0) {
      Vec3d var1 = new Vec3d(var0.x, 0.0, var0.z);
      if (var1.lengthSquared() < 1.0E-8) {
         return Vec3d.ZERO;
      } else {
         var1 = var1.normalize();
         return new Vec3d(-var1.z, 0.0, var1.x);
      }
   }

   private static double I_method_e2e8ea4b(Vec3d var0, Vec3d var1, Vec3d var2, double var3, LivingEntity var5) {
      Box var6 = var5.getBoundingBox();
      Optional var7 = var6.raycast(var0, var2);
      if (var7.isPresent()) {
         return ((Vec3d)var7.get()).subtract(var0).dotProduct(var1);
      } else {
         double var8 = var5.getEyePos().subtract(var0).dotProduct(var1);
         return var8 > 0.0 && var8 <= var3 ? var8 : var3;
      }
   }

   private List<BlockHitResult> I_method_4a7d4255(Vec3d var1, Vec3d var2, Vec3d var3, Vec3d var4, double var5) {
      ArrayList var7 = new ArrayList();
      Vec3d var8 = var1;
      HashSet var9 = new HashSet();
      double var10 = 1.0E-4;

      for (int var12 = 0; var12 < 40; var12++) {
         BlockHitResult var13 = I_field_3a9bda27.world.raycast(new RaycastContext(var8, var2, ShapeType.COLLIDER, FluidHandling.NONE, I_field_3a9bda27.player));
         if (var13.getType() != Type.BLOCK) {
            break;
         }

         BlockHitResult var14 = var13;
         double var15 = var14.getPos().subtract(var4).dotProduct(var3);
         if (var15 >= var5 - 1.0E-4) {
            break;
         }

         Block var17 = I_field_3a9bda27.world.getBlockState(var14.getBlockPos()).getBlock();
         if (!(var17 instanceof DoorBlock) && !(var17 instanceof TrapdoorBlock)) {
            BlockPos var18 = var14.getBlockPos();
            if (!var9.add(var18)) {
               var8 = var14.getPos().add(var3.multiply(0.02));
            } else {
               var7.add(var14);
               var8 = var14.getPos().add(var3.multiply(0.01));
            }
         } else {
            var8 = var14.getPos().add(var3.multiply(0.01));
         }
      }

      return var7;
   }

   @Compile(
      obfuscation = 1
   )
   private void i_method_b23be4b1(LivingEntity var1) {
      if (I_field_3a9bda27.interactionManager != null && I_field_3a9bda27.player != null) {
         this.I_method_921cfc91(var1);
         Hand var2 = null;
         this.I_field_5a = this.IIii_method_cdf7b739();
         if (this.I_field_5a) {
            var2 = I_field_3a9bda27.player.getActiveHand();
            I_field_3a9bda27.player.networkHandler.sendPacket(new PlayerActionC2SPacket(Action.RELEASE_USE_ITEM, BlockPos.ORIGIN, Direction.DOWN));
         }

         if (IiiiiIiII_Class245.i_method_9216de42(var1) && IiiiiIiII_Class245.II_method_1b0f003f(var1)) {
            IiiiiIiII_Class245.Ii_method_3b2de85f(var1);
         }

         iIIiiiIii_Class316 var3 = this.ii_method_367cc2c(var1) && this.IIII_method_cc263b39() ? IiiiiIiII_Class245.I_method_cca9db15() : null;
         if (var3 != null && !iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
            iIIiIiiIi_Class302.I_method_fe0755c5(var3, () -> I_field_3a9bda27.interactionManager.attackEntity(I_field_3a9bda27.player, var1));
         } else {
            I_field_3a9bda27.interactionManager.attackEntity(I_field_3a9bda27.player, var1);
         }

         IiIIIIii_Class68.I_field_108dc26c.I_method_73f3183b(this);
         I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
         if (this.I_field_5a && var2 != null) {
            Hand var4 = var2;
            I_field_3a9bda27.interactionManager
               .sendSequencedPacket(
                  I_field_3a9bda27.world,
                  var1x -> new PlayerInteractItemC2SPacket(
                     var4,
                     var1x,
                     RockstarClient.getInstance().I_method_58785402().II_method_f098f858().I_method_14534e0f(),
                     RockstarClient.getInstance().I_method_58785402().II_method_f098f858().i_method_1461d9ef()
                  )
               );
         }

         if (this.i_field_bbe33e6c.i_method_f85f3850() instanceof iiiIIIIi_Class226 var6) {
            var6.attack();
         }

         this.I_field_32e13e6c = new iiIIiIIii_Class404(iIIiiiiiI_Class319.I_method_b56b22f(5.0, 20.0), iIIiiiiiI_Class319.I_method_b56b22f(5.0, 10.0));
         this.I_field_991c1e8c.I_method_23e11e3f();
         this.II_field_46 = iIIiiiiiI_Class319.iI_method_330da892(0.0F, 1.0F);
         this.II_field_4a = 0L;
         this.i_field_49++;
         this.I_field_46 = this.i_field_49 % 9 == 0 ? 0.08F : 0.0F;
      }
   }

   @Compile(
      obfuscation = 1
   )
   private void II_method_ff8ac828(LivingEntity var1) {
      if (!this.ii_field_ba20ca4c.i_method_9b12da03() || IiiiiiiII_Class253.II_method_7a1ca106()) {
         boolean var3 = this.I_field_ba20ca4c.i_method_9b12da03()
            && var1 != null
            && this.III_method_3fd66f75(var1)
            && !this.Ii_field_bbe33e6c.I_method_ce989e26(this.iIi_field_500d0627);
         this.Ii_field_5a = var3;
         iiIIiIIIi_Class402 var2;
         if (this.Ii_field_bbe33e6c.I_method_ce989e26(this.iII_field_500d0627)) {
            var2 = iiIIiIIIi_Class402.Ii_field_32e0c64c;
         } else if (this.Ii_field_bbe33e6c.I_method_ce989e26(this.Iii_field_500d0627)) {
            var2 = iiIIiIIIi_Class402.i_field_32e0c64c;
         } else if (!this.Ii_field_bbe33e6c.I_method_ce989e26(this.iIi_field_500d0627) && !var3) {
            var2 = iiIIiIIIi_Class402.I_field_32e0c64c;
         } else {
            var2 = iiIIiIIIi_Class402.III_field_32e0c64c;
         }

         iiIIiIiII_Class405 var4 = RockstarClient.getInstance().I_method_58785402();
         if (this.i_field_bbe33e6c.I_method_ce989e26(this.iI_field_500d0627)) {
            if (var2 == iiIIiIIIi_Class402.III_field_32e0c64c && var1 != null) {
               var4.I_method_1acbf705(
                  var4.I_method_fb1d7ad5(), iiIIiIIIi_Class402.III_field_32e0c64c, 180.0F, 180.0F, 180.0F, iiIIiIiiI_Class407.II_field_32efc66c
               );
            }
         } else {
            if (this.i_field_bbe33e6c.i_method_f85f3850() instanceof iiiIIIIi_Class226 var5) {
               iiIIiiIIi_Class410 var9 = var4.I_method_fcdff2d5();
               var5.rotate(var4, this.I_method_bc03f87c(), this.I_method_ca3480b().I_method_94f6b4d0(), this.iI_field_ba20ca4c.i_method_9b12da03(), var2, var1);
               iiIIiiIIi_Class410 var7 = var4.I_method_fcdff2d5();
               if (var7 != null && var7 != var9) {
                  var7.I_method_8c318c7(this.I_method_c078bb42());
                  var7.I_method_3f6cb887(var5 instanceof iiiIIiii_Class232 var8 ? var8::I_method_adc0dea2 : null);
               }
            }
         }
      }
   }

   private iiIIiIIiI_Class403 I_method_c078bb42() {
      if (this.II_field_bbe33e6c.I_method_ce989e26(this.ii_field_500d0627)) {
         return iiIIiIIiI_Class403.I_field_32e13a8c;
      } else {
         return this.II_field_bbe33e6c.I_method_ce989e26(this.IIi_field_500d0627) ? iiIIiIIiI_Class403.II_field_32e13a8c : iiIIiIIiI_Class403.i_field_32e13a8c;
      }
   }

   private boolean iiI_method_524f5b0() {
      return this.Ii_field_ba20ca4c != null && this.Ii_field_ba20ca4c.i_method_9b12da03() && !this.Iiii_field_500d0627.isSelected()
         ? I_field_3a9bda27.options != null && I_field_3a9bda27.options.jumpKey.isPressed() || !I_field_3a9bda27.player.isOnGround()
         : this.II_field_ba20ca4c.i_method_9b12da03();
   }

   private boolean iii_method_5338190() {
      if (I_field_3a9bda27.player == null) {
         return false;
      } else if (iIIIIiIII_Class265.I_method_6fefbe43()) {
         return true;
      } else if (this.iiI_method_524f5b0() && iIIIIIiii_Class264.i_method_aa7c7d78(I_field_3a9bda27.player)) {
         iIIIIiIII_Class265.I_method_8d3241d4(I_field_3a9bda27.player);
         return true;
      } else {
         return false;
      }
   }

   private boolean Ii_method_1fa9b04c(LivingEntity var1) {
      boolean var2 = this.IIi_field_bbe33e6c.I_method_ce989e26(this.iIIi_field_500d0627);
      boolean var3 = this.IIi_field_bbe33e6c.I_method_ce989e26(this.iIiI_field_500d0627);
      if (RockstarClient.getInstance().getModuleManager().getModule(KnockbackTweaksModule.class).isEnabled()) {
         return false;
      } else if ((var2 || var3) && I_field_3a9bda27.player != null) {
         if (iIIIIiIII_Class265.I_method_6fefbe43() || iIIIIiIII_Class265.I_method_eacbd82b(I_field_3a9bda27.player)) {
            return true;
         } else if (!I_field_3a9bda27.player.isSprinting()) {
            iIIIIiIII_Class265.i_method_a5c35847(I_field_3a9bda27.player);
            return false;
         } else {
            iIIIIiIII_Class265.I_method_e89e02c2(I_field_3a9bda27.player, () -> this.Ii_method_1fa9b048(var1), var3);
            return true;
         }
      } else {
         return false;
      }
   }

   private void Ii_method_1fa9b048(LivingEntity var1) {
      if (this.isEnabled()
         && I_field_3a9bda27.player != null
         && I_field_3a9bda27.interactionManager != null
         && var1 != null
         && !var1.isRemoved()
         && var1.isAlive()) {
         if (this.I_method_b1834867(var1, true)) {
            this.i_method_b23be4b1(var1);
         }
      }
   }

   public boolean Iii_method_ce986db0() {
      if (!this.IIi_field_bbe33e6c.I_method_ce989e26(this.iIII_field_500d0627)) {
         return false;
      } else if (RockstarClient.getInstance().getModuleManager().getModule(KnockbackTweaksModule.class).isEnabled()) {
         return false;
      } else {
         LivingEntity var2 = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815() instanceof LivingEntity var3 ? var3 : null;
         if (var2 == null || I_field_3a9bda27.player == null) {
            return false;
         } else if (!this.iI_field_bbe33e6c.I_method_ce989e26(this.iiI_field_500d0627) && !I_field_3a9bda27.player.isSubmergedInWater()) {
            CriticalsModule var5 = RockstarClient.getInstance().getModuleManager().getModule(CriticalsModule.class);
            boolean var4 = var5.iII_method_2c60a1f0()
                  && (var5.Iii_method_f7970a10() && this.I_field_991c1e8c.I_method_58432069(500L) || I_field_3a9bda27.player.isOnGround())
               || !I_field_3a9bda27.player.isOnGround()
                  && iIIIiIiiI_Class279.I_method_5a6fa1f8(I_field_3a9bda27.player)
                     .I_method_9e608586(
                        IiiiiIiII_Class245.I_method_71f7f60e(var2),
                        !iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)
                              && !iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.Iii_field_ac164e6c)
                              && !iIIIiiiII_Class285.Ii_method_b349c526()
                           ? 1
                           : iIIiiiiiI_Class319.I_field_ec5bca73.nextInt(3)
                     );
            return this.iiI_method_524f5b0()
               && this.II_method_ff8ac82c(var2)
               && (
                  var4
                     || IiiiiIiII_Class245.I_method_cd07807a(var2, true)
                     || !this.I_field_991c1e8c
                        .I_method_58432069(
                           !iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c) && !iIIIiiiII_Class285.Ii_method_b349c526()
                              ? 50L
                              : (long)iIIiiiiiI_Class319.iI_method_330da892(50.0F, 150.0F)
                        )
               );
         } else {
            return false;
         }
      }
   }

   public float I_method_bc03f87c() {
      float var1 = RockstarClient.getInstance().getModuleManager().getModule(AirStuckModule.class).I_method_541fa8bc();
      return var1 > 0.0F ? var1 : this.I_field_73178e8c.Ii_method_a20abcd2();
   }

   public boolean i_method_b23be4b5(LivingEntity var1) {
      return this.I_field_62e8bb61.I_method_cb91c89f() > 1 && this.Iiii_field_500d0627.isSelected()
         ? this.I_field_62e8bb61.I_method_746a540b().I_method_23447f66().distanceTo(var1.getPos()) < 6.0
         : I_field_3a9bda27.player
               .getEyePos()
               .distanceTo(iiIIiIiIi_Class406.I_method_47b889e6(var1, IiiiiIiII_Class245.I_method_34612227(var1, this.IIi_field_51de8227.isSelected())))
            <= this.I_method_bc03f87c();
   }

   @Override
   public void onEnable() {
      if (this.i_field_bbe33e6c.i_method_f85f3850() instanceof iiiIIIIi_Class226 var1) {
         var1.enabled();
      }

      if (this.Iiii_field_500d0627.isSelected()) {
         this.I_field_62e8bb61.I_method_cb91c8ac();
      }

      this.iI_field_5a = false;
      this.Iii_method_ce986dac();
      super.onEnable();
   }

   @Override
   public void onDisable() {
      IiIIIIii_Class68.I_field_108dc26c.i_method_44aa6c1b(this);
      this.Iii_method_ce986dac();
      RockstarClient.getInstance().I_method_9a638462().II_method_2b2a54e2();
      if (I_field_3a9bda27.player != null) {
         iIIIIiIII_Class265.i_method_a5c35847(I_field_3a9bda27.player);
      }

      if (this.I_field_62e93381 != null) {
         this.I_field_62e93381.targetNull();
      }

      this.I_field_62e8bb61.i_method_cba0548c();
      super.onDisable();
   }

   private void iI_method_e348e408(LivingEntity var1) {
      if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c) && this.iI_method_e348e40c(var1)) {
         if (!IiIIIIii_Class68.I_field_108dc26c.I_method_73f3183f(this) && !I_field_3a9bda27.player.getMainHandStack().isOf(Items.MACE)) {
            iIIiiiIii_Class316 var2 = IiiiiIiII_Class245.I_method_cca9db15();
            if (var2 != null && IiIIIIii_Class68.I_field_108dc26c.I_method_c950d12f(this, var2)) {
               this.II_field_49 = I_field_3a9bda27.player.age;
               this.ii_field_5a = I_field_3a9bda27.player.getItemCooldownManager().isCoolingDown(var2.I_method_7b7e0bb9());
            }
         } else {
            if (I_field_3a9bda27.player.getItemCooldownManager().isCoolingDown(Items.MACE.getDefaultStack())) {
               this.ii_field_5a = true;
            }
         }
      } else {
         IiIIIIii_Class68.I_field_108dc26c.I_method_73f3183b(this);
         this.Iii_method_ce986dac();
      }
   }

   private boolean iI_method_e348e40c(LivingEntity var1) {
      if (!this.III_field_ba20ca4c.i_method_9b12da03()
         || var1 == null
         || I_field_3a9bda27.player == null
         || I_field_3a9bda27.player.isOnGround()
         || I_field_3a9bda27.player.isGliding()
         || I_field_3a9bda27.player.hasStatusEffect(StatusEffects.SLOW_FALLING)) {
         return false;
      } else if (this.ii_method_367cc2c(var1)) {
         return true;
      } else {
         iIIiiiIii_Class316 var2 = IiiiiIiII_Class245.I_method_cca9db15();
         if (var2 == null) {
            return false;
         } else {
            int var3 = this.I_method_921cfc84(var1);
            return var3 >= 0 && this.I_method_fd7462d(var2) >= var3 - 4;
         }
      }
   }

   private int I_method_921cfc84(LivingEntity var1) {
      double var2 = I_field_3a9bda27.player.getY();
      double var4 = I_field_3a9bda27.player.getVelocity().y;
      float var6 = I_field_3a9bda27.player.fallDistance;
      double var7 = var1.getBoundingBox().maxY;

      for (int var9 = 1; var9 <= 40; var9++) {
         var2 += var4;
         if (var4 < 0.0) {
            var6 -= (float)var4;
         } else {
            var6 = 0.0F;
         }

         if (var4 < 0.0 && var6 + Math.max(0.0, var2 - var7) > 1.5) {
            return var9;
         }

         if (var4 < 0.0 && var2 < var1.getBoundingBox().minY - 2.0) {
            return -1;
         }

         var4 = (var4 - 0.08) * 0.98;
      }

      return -1;
   }

   private int I_method_fd7462d(iIIiiiIii_Class316 var1) {
      if (!I_field_3a9bda27.player.getItemCooldownManager().isCoolingDown(var1.I_method_7b7e0bb9())) {
         return 0;
      } else {
         ItemCooldownManagerAccessor var2 = (ItemCooldownManagerAccessor)(Object)I_field_3a9bda27.player.getItemCooldownManager();
         Identifier var3 = var2.rockstar$getGroup(var1.I_method_7b7e0bb9());
         Object var4 = var2.rockstar$getEntries().get(var3);
         return var4 == null ? 0 : Math.max(0, ((ItemCooldownEntryAccessor)(Object)var4).rockstar$getEndTick() - var2.rockstar$getTick());
      }
   }

   private void Iii_method_ce986dac() {
      this.II_field_49 = -1;
      this.ii_field_5a = false;
   }

   private boolean ii_method_367cc2c(LivingEntity var1) {
      if (this.III_field_ba20ca4c.i_method_9b12da03()
         && var1 != null
         && I_field_3a9bda27.player != null
         && !I_field_3a9bda27.player.isOnGround()
         && !I_field_3a9bda27.player.isGliding()
         && !I_field_3a9bda27.player.hasStatusEffect(StatusEffects.SLOW_FALLING)) {
         double var2 = Math.max(0.0, I_field_3a9bda27.player.getY() - var1.getBoundingBox().maxY);
         return I_field_3a9bda27.player.fallDistance + var2 > 1.5;
      } else {
         return false;
      }
   }

   private boolean IIII_method_cc263b39() {
      return I_field_3a9bda27.player.fallDistance > 1.5F && I_field_3a9bda27.player.getVelocity().y < 0.0;
   }

   private boolean IIIi_method_cc34c719() {
      return I_field_3a9bda27.player.getMainHandStack().isOf(Items.MACE)
            && !I_field_3a9bda27.player.getItemCooldownManager().isCoolingDown(I_field_3a9bda27.player.getMainHandStack())
         ? this.II_field_49 < 0 || this.ii_field_5a || I_field_3a9bda27.player.age - this.II_field_49 >= 4
         : false;
   }

   private long I_method_bc03f880() {
      int var1 = (int)this.I_field_bbe3b68c.i_method_e92b420f();
      int var2 = (int)this.I_field_bbe3b68c.II_method_3a8908f2();
      if (var1 > var2) {
         int var3 = var1;
         var1 = var2;
         var2 = var3;
      }

      int var4 = iIIiiiiiI_Class319.I_field_ec5bca73.nextInt(var1, var2 + 1);
      return Math.max(1L, 1000L / var4);
   }

   private float II_method_c48a1045() {
      if (!this.iII_field_51de8227.isSelected()) {
         return 1.0F;
      } else {
         float var1 = RockstarClient.getInstance().I_method_d1ad67e2().I_method_2bde91cf();
         if (var1 <= 0.0F || Float.isNaN(var1)) {
            return 1.0F;
         } else {
            return var1 >= 19.0F ? 1.0F : Math.max(25.0F / var1, 1.0F);
         }
      }
   }

   private boolean IIiI_method_cde92b59() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.player.isUsingItem()) {
         UseAction var1 = I_field_3a9bda27.player.getActiveItem().getItem().getUseAction(I_field_3a9bda27.player.getActiveItem());
         return var1 == UseAction.EAT || var1 == UseAction.DRINK;
      } else {
         return false;
      }
   }

   private boolean IIii_method_cdf7b739() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.player.isUsingItem()) {
         UseAction var1 = I_field_3a9bda27.player.getActiveItem().getItem().getUseAction(I_field_3a9bda27.player.getActiveItem());
         return var1 == UseAction.BLOCK;
      } else {
         return false;
      }
   }

   private boolean IiII_method_2c14f19() {
      if (I_field_3a9bda27.player == null || !I_field_3a9bda27.player.isUsingItem()) {
         return false;
      } else if (!this.IiI_field_51de8227.isSelected()) {
         return false;
      } else {
         return this.IIiI_method_cde92b59() ? true : I_field_3a9bda27.player.getActiveHand() == Hand.OFF_HAND && !this.IIii_method_cdf7b739();
      }
   }

   private boolean III_method_3fd66f75(LivingEntity var1) {
      return var1.getMainHandStack().isOf(Items.CROSSBOW)
         || var1.getOffHandStack().isOf(Items.CROSSBOW)
         || var1.getMainHandStack().isOf(Items.TRIDENT)
         || var1.getOffHandStack().isOf(Items.TRIDENT);
   }

   private long i_method_bc128460() {
      if (this.iI_field_bbe33e6c.I_method_ce989e26(this.iiI_field_500d0627)) {
         int var1 = (int)Math.max(this.I_field_bbe3b68c.i_method_e92b420f(), this.I_field_bbe3b68c.II_method_3a8908f2());
         return Math.max(1L, 1000L / Math.max(1, var1));
      } else {
         return Math.round(500.0F * this.II_method_c48a1045());
      }
   }

   @Generated
   public SliderSetting I_method_af0f42() {
      return this.I_field_73178e8c;
   }

   @Generated
   public ModeSetting I_method_497abf22() {
      return this.i_field_bbe33e6c;
   }

   @Generated
   public BooleanSetting I_method_47b84b02() {
      return this.I_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting i_method_5d4dbee2() {
      return this.i_field_ba20ca4c;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 I_method_d5c7315d() {
      return this.iiI_field_500d0627;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 i_method_dbcf2d3d() {
      return this.iii_field_500d0627;
   }

   @Generated
   public RangeSetting I_method_497b3742() {
      return this.I_field_bbe3b68c;
   }

   @Generated
   public BooleanSetting II_method_5de5c98b() {
      return this.II_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting Ii_method_737b3d6b() {
      return this.Ii_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting iI_method_fafed1ab() {
      return this.iI_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting ii_method_1094458b() {
      return this.ii_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting III_method_d681c22() {
      return this.III_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting IIi_method_22fd9002() {
      return this.IIi_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting IiI_method_aa812442() {
      return this.IiI_field_ba20ca4c;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 II_method_168f31a6() {
      return this.IiIi_field_500d0627;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 Ii_method_1c972d86() {
      return this.IiiI_field_500d0627;
   }

   @Generated
   public ModeSetting.Nested1_42765c60 iI_method_d186b1c6() {
      return this.Iiii_field_500d0627;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 I_method_d798ad5d() {
      return this.IIi_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 i_method_dda0a93d() {
      return this.IiI_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 II_method_1860ada6() {
      return this.Iii_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 Ii_method_1e68a986() {
      return this.iII_field_51de8227;
   }

   @Generated
   public MultiSelectSetting.Nested1_42856060 iI_method_d3582dc6() {
      return this.iIi_field_51de8227;
   }

   @Generated
   public iiIiIIiii_Class424 I_method_26b39f42() {
      return this.I_field_991c1e8c;
   }

   @Generated
   public float i_method_bc12845c() {
      return this.I_field_46;
   }

   @Generated
   public iiiIIiIi_Class230 I_method_ca34beb() {
      return this.I_field_62e8bb61;
   }

   @Generated
   public iiiIIiii_Class232 I_method_ca3c40b() {
      return this.I_field_62e93381;
   }

   @Generated
   public int II_method_c48a1048() {
      return this.i_field_49;
   }

   @Generated
   public iiIIiIIii_Class404 I_method_c078bf22() {
      return this.I_field_32e13e6c;
   }

   @Generated
   public void I_method_8718561a(iiIIiIIii_Class404 var1) {
      this.I_field_32e13e6c = var1;
   }

   @Generated
   public boolean iII_method_3620590() {
      return this.Ii_field_5a;
   }

   @Generated
   public Map<String, Integer> i_method_b59e69a1() {
      return this.I_field_a567c40b;
   }
}
