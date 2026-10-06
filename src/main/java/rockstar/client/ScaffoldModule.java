package rockstar.client;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.FallingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket.Full;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Direction.Axis;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.player.InputEvent;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Scaffold",
   III_method_a89e5834 = "modules.descriptions.scaffold",
   category = ModuleCategory.PLAYER
)
public class ScaffoldModule extends Module {
   private static final int I_field_49 = 4;
   private static final int i_field_49 = 4;
   private static final double I_field_44 = 0.001;
   private static final double i_field_44 = 0.02;
   private RangeSetting I_field_bbe3b68c;
   private SliderSetting I_field_73178e8c;
   private ModeSetting I_field_bbe33e6c;
   ModeSetting.Nested1_42765c60 I_field_500d0627;
   private ModeSetting.Nested1_42765c60 i_field_500d0627;
   private ModeSetting.Nested1_42765c60 II_field_500d0627;
   ModeSetting.Nested1_42765c60 Ii_field_500d0627;
   private ModeSetting i_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 iI_field_500d0627;
   private ModeSetting.Nested1_42765c60 ii_field_500d0627;
   private ModeSetting.Nested1_42765c60 III_field_500d0627;
   private ModeSetting.Nested1_42765c60 IIi_field_500d0627;
   private ModeSetting II_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 IiI_field_500d0627;
   private ModeSetting.Nested1_42765c60 Iii_field_500d0627;
   private ModeSetting.Nested1_42765c60 iII_field_500d0627;
   private ModeSetting.Nested1_42765c60 iIi_field_500d0627;
   private ModeSetting.Nested1_42765c60 iiI_field_500d0627;
   private ModeSetting.Nested1_42765c60 iii_field_500d0627;
   private ModeSetting Ii_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 IIII_field_500d0627;
   private ModeSetting.Nested1_42765c60 IIIi_field_500d0627;
   private ModeSetting.Nested1_42765c60 IIiI_field_500d0627;
   private ModeSetting.Nested1_42765c60 IIii_field_500d0627;
   private ModeSetting.Nested1_42765c60 IiII_field_500d0627;
   private ModeSetting.Nested1_42765c60 IiIi_field_500d0627;
   private ModeSetting.Nested1_42765c60 IiiI_field_500d0627;
   private ModeSetting.Nested1_42765c60 Iiii_field_500d0627;
   private ModeSetting iI_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 iIII_field_500d0627;
   private ModeSetting.Nested1_42765c60 iIIi_field_500d0627;
   private ModeSetting.Nested1_42765c60 iIiI_field_500d0627;
   private SliderSetting i_field_73178e8c;
   private SliderSetting II_field_73178e8c;
   private SliderSetting Ii_field_73178e8c;
   private BooleanSetting I_field_ba20ca4c;
   private ModeSetting ii_field_bbe33e6c;
   private ModeSetting.Nested1_42765c60 iIii_field_500d0627;
   private ModeSetting.Nested1_42765c60 iiII_field_500d0627;
   private ModeSetting.Nested1_42765c60 iiIi_field_500d0627;
   private ModeSetting.Nested1_42765c60 iiiI_field_500d0627;
   private BooleanSetting i_field_ba20ca4c;
   private BooleanSetting II_field_ba20ca4c;
   private SliderSetting iI_field_73178e8c;
   private SliderSetting ii_field_73178e8c;
   private BooleanSetting Ii_field_ba20ca4c;
   BooleanSetting iI_field_ba20ca4c;
   private RangeSetting i_field_bbe3b68c;
   private RangeSetting II_field_bbe3b68c;
   private BooleanSetting ii_field_ba20ca4c;
   BooleanSetting III_field_ba20ca4c;
   BooleanSetting IIi_field_ba20ca4c;
   private BooleanSetting IiI_field_ba20ca4c;
   private BooleanSetting Iii_field_ba20ca4c;
   BooleanSetting iII_field_ba20ca4c;
   SliderSetting III_field_73178e8c;
   private SliderSetting IIi_field_73178e8c;
   private RangeSetting Ii_field_bbe3b68c;
   private RangeSetting iI_field_bbe3b68c;
   private SliderSetting IiI_field_73178e8c;
   private SliderSetting Iii_field_73178e8c;
   private SliderSetting iII_field_73178e8c;
   private SliderSetting iIi_field_73178e8c;
   private SliderSetting iiI_field_73178e8c;
   private SliderSetting iii_field_73178e8c;
   private BooleanSetting iIi_field_ba20ca4c;
   private BooleanSetting iiI_field_ba20ca4c;
   private BooleanSetting iii_field_ba20ca4c;
   private BooleanSetting IIII_field_ba20ca4c;
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private final ArrayDeque<BlockPos> I_field_f27e4628 = new ArrayDeque<>(4);
   private final ArrayDeque<Vec3d> i_field_f27e4628 = new ArrayDeque<>(5);
   private ScaffoldModule.Nested1_b1961009 I_field_b46ee486;
   private ScaffoldModule.Nested1_81997c40 I_field_f54de247;
   private BlockPos I_field_670402ba;
   private BlockPos i_field_670402ba;
   private Direction I_field_3b03ad36;
   ScaffoldModule.Nested1_b1960c29 I_field_b46e6c66;
   ScaffoldModule.Nested1_81997c60 I_field_f54de627;
   private ScaffoldModule.Nested1_812b7580 I_field_d95eae07;
   private BlockPos II_field_670402ba;
   private float I_field_46;
   private int II_field_49;
   private int Ii_field_49;
   private int iI_field_49;
   int ii_field_49;
   private int III_field_49;
   private int IIi_field_49;
   private int IiI_field_49;
   private float i_field_46;
   private int Iii_field_49;
   private double II_field_44;
   private boolean I_field_5a;
   private boolean i_field_5a;
   private boolean II_field_5a;
   private boolean Ii_field_5a;
   private float II_field_46;
   private long I_field_4a;
   private float Ii_field_46;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> i_field_3d936f41;
   private final IiIIIiII_Class69<InputEvent> II_field_3d936f41;
   private final IiIIIiII_Class69<WorldChangeEvent> Ii_field_3d936f41;

   public ScaffoldModule() {
      this.I_field_f54de627 = ScaffoldModule.Nested1_81997c60.I_field_f54de627;
      this.I_field_46 = Float.NaN;
      this.II_field_44 = Double.NaN;
      this.I_field_3d936f41 = new IiIIIiII_Class69<ClientPlayerTickEvent>() {
         public void onEvent(ClientPlayerTickEvent var1) {
            ScaffoldModule.this.Iii_method_b320769f();
            ScaffoldModule.this.iIi_method_e7f89a5f();
            ScaffoldModule.this.iII_method_e7ea0e7f();
            ScaffoldModule.this.iiI_method_e9acfe9f();
         }

         @Override
         public int I_method_f12c6485() {
            return 2;
         }
      };
      this.i_field_3d936f41 = new IiIIIiII_Class69<ClientPlayerTickEvent>() {
         public void onEvent(ClientPlayerTickEvent var1) {
            ScaffoldModule.this.iii_method_e9bb8a7f();
         }

         @Override
         public int I_method_f12c6485() {
            return -2;
         }
      };
      this.II_field_3d936f41 = new IiIIIiII_Class69<InputEvent>() {
         public void onEvent(InputEvent var1) {
            ScaffoldModule.this.I_field_f54de627 = ScaffoldModule.Nested1_81997c60.I_method_c344e94f(var1);
            ScaffoldModule.this.I_field_b46e6c66 = ScaffoldModule.this.I_field_f54de627.iI_method_da4b0f6b()
               ? ScaffoldModule.this.I_method_9035be3a(ScaffoldModule.this.I_field_f54de627)
               : null;
            if (ScaffoldModule.this.Ii_field_500d0627.isSelected()) {
               ScaffoldModule.this.i_method_11401159(var1);
            }

            if (ScaffoldModule.this.IIi_field_ba20ca4c.i_method_9b12da03() && ScaffoldModule.this.I_field_500d0627.isSelected()) {
               ScaffoldModule.this.I_method_9c45a139(var1);
            }

            if (ScaffoldModule.this.iII_field_ba20ca4c.i_method_9b12da03()
               && ScaffoldModule.this.i_method_a4de2e0d() > ScaffoldModule.this.III_field_73178e8c.Ii_method_a20abcd2()) {
               var1.setForward(0.0F);
               var1.setStrafe(0.0F);
            }

            if (ScaffoldModule.this.ii_field_49 > 0) {
               var1.setSneak(true);
               ScaffoldModule.this.ii_field_49--;
            }

            if (ScaffoldModule.this.iI_field_ba20ca4c.i_method_9b12da03()
               && ScaffoldModule.this.I_field_500d0627.isSelected()
               && ScaffoldModule.this.I_method_9c45a13d(var1)) {
               var1.setSneak(true);
            }

            ScaffoldModule.Nested1_b1960c09 var2 = ScaffoldModule.this.I_method_8b169b3d();
            if (var2.I_method_68571555()) {
               var1.setJump(true);
            }

            if (var2.i_method_6865a135()) {
               var1.setForward(0.0F);
               var1.setStrafe(0.0F);
            }

            if (var2.II_method_a29a8c34()) {
               var1.setForward(-1.0F);
               var1.setStrafe(0.0F);
            }

            if (var2.I_method_68571544() > 0) {
               var1.setSneak(true);
               ScaffoldModule.this.ii_field_49 = Math.max(ScaffoldModule.this.ii_field_49, var2.I_method_68571544());
            }

            if (ScaffoldModule.this.III_field_ba20ca4c.i_method_9b12da03()
               && ScaffoldModule.this.I_field_500d0627.isSelected()
               && ScaffoldModule.this.iII_method_e7ea0e83()) {
               var1.setSneak(false);
            }
         }

         @Override
         public int I_method_f12c6485() {
            return -1;
         }
      };
      this.Ii_field_3d936f41 = var1 -> this.IIiI_method_7a6240c2();
      this.IiI_method_b311eabf();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_b311eabf() {
      this.I_field_bbe3b68c = new RangeSetting(this, "modules.settings.scaffold.delay")
         .II_method_c7edb334(0.0F)
         .Ii_method_6506bb54(40.0F)
         .iI_method_cdf5af14(1.0F)
         .I_method_3944a7d7(0.0F)
         .i_method_d65daff7(0.0F);
      this.I_field_73178e8c = new SliderSetting(this, "modules.settings.scaffold.min_dist")
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(0.25F)
         .II_method_b0f56334(0.01F)
         .Ii_method_4e0e6b54(0.0F);
      this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.scaffold.technique");
      this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.scaffold.technique.normal").select();
      this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.scaffold.technique.expand");
      this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.scaffold.technique.god_bridge");
      this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.scaffold.technique.breezily");
      this.i_field_bbe33e6c = new ModeSetting(this, "modules.settings.scaffold.same_y");
      this.iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.scaffold.same_y.off").select();
      this.ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.scaffold.same_y.on");
      this.III_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.scaffold.same_y.falling");
      this.IIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.scaffold.same_y.hypixel");
      this.II_field_bbe33e6c = new ModeSetting(this, "modules.settings.scaffold.tower");
      this.IiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "modules.settings.scaffold.tower.none").select();
      this.Iii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "modules.settings.scaffold.tower.motion_mode");
      this.iII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "modules.settings.scaffold.tower.pulldown");
      this.iIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "modules.settings.scaffold.tower.karhu");
      this.iiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "modules.settings.scaffold.tower.vulcan");
      this.iii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "modules.settings.scaffold.tower.hypixel");
      this.Ii_field_bbe33e6c = new ModeSetting(
         this, "modules.settings.scaffold.rotation_mode", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)
      );
      this.IIII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.scaffold.rotation_mode.center");
      this.IIIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.scaffold.rotation_mode.random");
      this.IIiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.scaffold.rotation_mode.stabilized").select();
      this.IIii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.scaffold.rotation_mode.nearest_rotation");
      this.IiII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.scaffold.rotation_mode.reverse_yaw");
      this.IiIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.scaffold.rotation_mode.diagonal_yaw");
      this.IiiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.scaffold.rotation_mode.angle_yaw");
      this.Iiii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.Ii_field_bbe33e6c, "modules.settings.scaffold.rotation_mode.edge_point");
      this.iI_field_bbe33e6c = new ModeSetting(this, "modules.settings.scaffold.rotation_timing");
      this.iIII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.iI_field_bbe33e6c, "modules.settings.scaffold.rotation_timing.normal").select();
      this.iIIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.iI_field_bbe33e6c, "modules.settings.scaffold.rotation_timing.on_tick");
      this.iIiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.iI_field_bbe33e6c, "modules.settings.scaffold.rotation_timing.on_tick_snap");
      this.i_field_73178e8c = new SliderSetting(this, "modules.settings.scaffold.rotation_speed")
         .II_method_b0f56334(5.0F)
         .I_method_c8c9a7d7(30.0F)
         .i_method_65e2aff7(180.0F)
         .Ii_method_4e0e6b54(180.0F);
      this.II_field_73178e8c = new SliderSetting(this, "modules.settings.scaffold.aim_tolerance")
         .II_method_b0f56334(0.5F)
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(20.0F)
         .Ii_method_4e0e6b54(10.0F);
      this.Ii_field_73178e8c = new SliderSetting(this, "modules.settings.scaffold.stable_ticks")
         .II_method_b0f56334(1.0F)
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(5.0F)
         .Ii_method_4e0e6b54(0.0F);
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.scaffold.consider_inventory").I_method_a4d009eb(false);
      this.ii_field_bbe33e6c = new ModeSetting(this, "modules.settings.scaffold.move_correction");
      this.iIii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.scaffold.move_correction.off");
      this.iiII_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.scaffold.move_correction.strict");
      this.iiIi_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.scaffold.move_correction.silent").select();
      this.iiiI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.ii_field_bbe33e6c, "modules.settings.scaffold.move_correction.change_look");
      this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.scaffold.auto_block").I_method_decd82b5();
      this.II_field_ba20ca4c = new BooleanSetting(this, "modules.settings.scaffold.auto_block.always", () -> !this.i_field_ba20ca4c.i_method_9b12da03())
         .I_method_a4d009eb(false);
      this.iI_field_73178e8c = new SliderSetting(
            this, "modules.settings.scaffold.auto_block.slot_reset_delay", () -> !this.i_field_ba20ca4c.i_method_9b12da03()
         )
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(40.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(5.0F);
      this.ii_field_73178e8c = new SliderSetting(
            this, "modules.settings.scaffold.auto_block.do_not_use_below", () -> !this.i_field_ba20ca4c.i_method_9b12da03()
         )
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(64.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(1.0F);
      this.Ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.scaffold.ledge").I_method_decd82b5();
      this.iI_field_ba20ca4c = new BooleanSetting(
            this, "modules.settings.scaffold.eagle", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)
         )
         .I_method_a4d009eb(false);
      this.i_field_bbe3b68c = new RangeSetting(this, "modules.settings.scaffold.eagle.blocks", () -> !this.iI_field_ba20ca4c.i_method_9b12da03())
         .II_method_c7edb334(0.0F)
         .Ii_method_6506bb54(10.0F)
         .iI_method_cdf5af14(1.0F)
         .I_method_3944a7d7(0.0F)
         .i_method_d65daff7(0.0F);
      this.II_field_bbe3b68c = new RangeSetting(this, "modules.settings.scaffold.eagle.edge_distance", () -> !this.iI_field_ba20ca4c.i_method_9b12da03())
         .II_method_c7edb334(0.01F)
         .Ii_method_6506bb54(1.3F)
         .iI_method_cdf5af14(0.01F)
         .I_method_3944a7d7(0.01F)
         .i_method_d65daff7(0.05F);
      this.ii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.scaffold.eagle.only_on_ground", () -> !this.iI_field_ba20ca4c.i_method_9b12da03())
         .I_method_decd82b5();
      this.III_field_ba20ca4c = new BooleanSetting(
            this, "modules.settings.scaffold.down", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)
         )
         .I_method_a4d009eb(false);
      this.IIi_field_ba20ca4c = new BooleanSetting(
            this, "modules.settings.scaffold.stabilize_movement", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)
         )
         .I_method_decd82b5();
      this.IiI_field_ba20ca4c = new BooleanSetting(
            this, "modules.settings.scaffold.ceiling", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)
         )
         .I_method_a4d009eb(false);
      this.Iii_field_ba20ca4c = new BooleanSetting(
            this, "modules.settings.scaffold.head_hitter", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.I_field_500d0627)
         )
         .I_method_a4d009eb(false);
      this.iII_field_ba20ca4c = new BooleanSetting(this, "modules.settings.scaffold.speed_limiter").I_method_a4d009eb(false);
      this.III_field_73178e8c = new SliderSetting(
            this, "modules.settings.scaffold.speed_limiter.speed", () -> !this.iII_field_ba20ca4c.i_method_9b12da03()
         )
         .I_method_c8c9a7d7(0.01F)
         .i_method_65e2aff7(0.4F)
         .II_method_b0f56334(0.01F)
         .Ii_method_4e0e6b54(0.11F);
      this.IIi_field_73178e8c = new SliderSetting(
            this, "modules.settings.scaffold.expand.length", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)
         )
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(10.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(4.0F);
      this.Ii_field_bbe3b68c = new RangeSetting(
            this, "modules.settings.scaffold.breezily.edge_distance", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627)
         )
         .II_method_c7edb334(0.25F)
         .Ii_method_6506bb54(0.5F)
         .iI_method_cdf5af14(0.01F)
         .I_method_3944a7d7(0.45F)
         .i_method_d65daff7(0.5F);
      this.iI_field_bbe3b68c = new RangeSetting(
            this, "modules.settings.scaffold.god_bridge.sneak_time", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627)
         )
         .II_method_c7edb334(1.0F)
         .Ii_method_6506bb54(10.0F)
         .iI_method_cdf5af14(1.0F)
         .I_method_3944a7d7(1.0F)
         .i_method_d65daff7(1.0F);
      this.IiI_field_73178e8c = new SliderSetting(
            this, "modules.settings.scaffold.god_bridge.force_sneak_below", () -> !this.I_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627)
         )
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(10.0F)
         .II_method_b0f56334(1.0F)
         .Ii_method_4e0e6b54(3.0F);
      this.Iii_field_73178e8c = new SliderSetting(
            this, "modules.settings.scaffold.tower.motion", () -> !this.II_field_bbe33e6c.I_method_ce989e26(this.Iii_field_500d0627)
         )
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(1.0F)
         .II_method_b0f56334(0.01F)
         .Ii_method_4e0e6b54(0.42F);
      this.iII_field_73178e8c = new SliderSetting(
            this, "modules.settings.scaffold.tower.trigger_height", () -> !this.II_field_bbe33e6c.I_method_ce989e26(this.Iii_field_500d0627)
         )
         .I_method_c8c9a7d7(0.76F)
         .i_method_65e2aff7(1.0F)
         .II_method_b0f56334(0.01F)
         .Ii_method_4e0e6b54(0.78F);
      this.iIi_field_73178e8c = new SliderSetting(
            this, "modules.settings.scaffold.tower.slow", () -> !this.II_field_bbe33e6c.I_method_ce989e26(this.Iii_field_500d0627)
         )
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(3.0F)
         .II_method_b0f56334(0.05F)
         .Ii_method_4e0e6b54(1.0F);
      this.iiI_field_73178e8c = new SliderSetting(
            this, "modules.settings.scaffold.tower.pulldown_trigger", () -> !this.II_field_bbe33e6c.I_method_ce989e26(this.iII_field_500d0627)
         )
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(0.2F)
         .II_method_b0f56334(0.01F)
         .Ii_method_4e0e6b54(0.1F);
      this.iii_field_73178e8c = new SliderSetting(
            this, "modules.settings.scaffold.tower.karhu_trigger", () -> !this.II_field_bbe33e6c.I_method_ce989e26(this.iIi_field_500d0627)
         )
         .I_method_c8c9a7d7(0.0F)
         .i_method_65e2aff7(0.2F)
         .II_method_b0f56334(0.01F)
         .Ii_method_4e0e6b54(0.06F);
      this.iIi_field_ba20ca4c = new BooleanSetting(
            this, "modules.settings.scaffold.tower.karhu_pulldown", () -> !this.II_field_bbe33e6c.I_method_ce989e26(this.iIi_field_500d0627)
         )
         .I_method_decd82b5();
      this.iiI_field_ba20ca4c = new BooleanSetting(this, "modules.settings.scaffold.reset_sprint").I_method_decd82b5();
      this.iii_field_ba20ca4c = new BooleanSetting(this, "modules.settings.scaffold.simulate_placement_attempts").I_method_a4d009eb(false);
      this.IIII_field_ba20ca4c = new BooleanSetting(
            this, "modules.settings.scaffold.simulate_placement_attempts.failed_only", () -> !this.iii_field_ba20ca4c.i_method_9b12da03()
         )
         .I_method_decd82b5();
   }

   @Override
   public void onEnable() {
      if (I_field_3a9bda27.player != null) {
         this.II_field_49 = I_field_3a9bda27.player.getBlockPos().getY() - 1;
         this.Ii_field_49 = I_field_3a9bda27.player.getBlockPos().getY();
         this.iI_field_49 = 2;
         this.i_field_5a = I_field_3a9bda27.player.isOnGround();
      }

      this.IIiI_method_7a6240c2();
      this.IiII_method_af3a6482();
      this.Ii_field_46 = this.I_method_29b82497(this.Ii_field_bbe3b68c);
      this.I_field_991c1e8c.I_method_23e11e3f();
   }

   @Override
   public void onDisable() {
      this.IIiI_method_7a6240c2();
   }

   void Iii_method_b320769f() {
      if (I_field_3a9bda27.player != null) {
         boolean var1 = I_field_3a9bda27.player.isOnGround();
         if (var1) {
            this.II_field_49 = I_field_3a9bda27.player.getBlockPos().getY() - 1;
            this.iI_field_49++;
            this.I_field_5a = false;
            this.Iii_field_49 = 0;
         } else {
            this.Iii_field_49++;
         }

         if (I_field_3a9bda27.options.jumpKey.isPressed()) {
            this.Ii_field_49 = I_field_3a9bda27.player.getBlockPos().getY();
            this.iI_field_49 = 2;
         }

         boolean var2 = this.i_field_5a && !var1 && I_field_3a9bda27.player.getVelocity().y > 0.0;
         if (var2) {
            this.II_field_44 = I_field_3a9bda27.player.getY();
         }

         this.i_field_5a = var1;
      }
   }

   void iII_method_e7ea0e7f() {
      if (I_field_3a9bda27.player != null) {
         if (this.Iii_field_ba20ca4c.i_method_9b12da03() && this.I_field_500d0627.isSelected() && this.iiI_method_e9acfea3() && this.IIIi_method_78addc86()) {
            I_field_3a9bda27.player.jump();
         }
      }
   }

   void iIi_method_e7f89a5f() {
      if (I_field_3a9bda27.player != null
         && !this.II_field_bbe33e6c.I_method_ce989e26(this.IiI_field_500d0627)
         && this.iii_method_e9bb8a83()
         && this.II_method_f5339cf5() > 0
         && this.IIII_method_789f50a6()) {
         Vec3d var1 = I_field_3a9bda27.player.getVelocity();
         if (this.II_field_bbe33e6c.I_method_ce989e26(this.Iii_field_500d0627)) {
            if (!Double.isNaN(this.II_field_44)) {
               if (I_field_3a9bda27.player.getY() > this.II_field_44 + this.iII_field_73178e8c.Ii_method_a20abcd2()) {
                  I_field_3a9bda27.player
                     .setPosition(I_field_3a9bda27.player.getX(), Math.floor(I_field_3a9bda27.player.getY()), I_field_3a9bda27.player.getZ());
                  Vec3d var2 = I_field_3a9bda27.player.getVelocity();
                  double var3 = this.iIi_field_73178e8c.Ii_method_a20abcd2();
                  I_field_3a9bda27.player.setVelocity(var2.x * var3, this.Iii_field_73178e8c.Ii_method_a20abcd2(), var2.z * var3);
                  this.II_field_44 = I_field_3a9bda27.player.getY();
               }
            }
         } else if (this.II_field_bbe33e6c.I_method_ce989e26(this.iII_field_500d0627)) {
            if (!I_field_3a9bda27.player.isOnGround() && var1.y < this.iiI_field_73178e8c.Ii_method_a20abcd2()) {
               I_field_3a9bda27.player.setVelocity(var1.x, -1.0, var1.z);
            }
         } else if (this.II_field_bbe33e6c.I_method_ce989e26(this.iIi_field_500d0627)) {
            if (this.iIi_field_ba20ca4c.i_method_9b12da03() && !I_field_3a9bda27.player.isOnGround() && var1.y < this.iii_field_73178e8c.Ii_method_a20abcd2()) {
               I_field_3a9bda27.player.setVelocity(var1.x, var1.y - 1.0, var1.z);
            }
         } else if (this.II_field_bbe33e6c.I_method_ce989e26(this.iiI_field_500d0627)) {
            if (I_field_3a9bda27.player.age % 2 == 0) {
               I_field_3a9bda27.player.setVelocity(var1.x, 0.7, var1.z);
            } else {
               I_field_3a9bda27.player.setVelocity(var1.x, this.IIIi_method_78addc86() ? 0.42 : 0.6, var1.z);
            }
         } else {
            if (this.II_field_bbe33e6c.I_method_ce989e26(this.iii_field_500d0627)) {
               if (I_field_3a9bda27.player.getX() % 1.0 != 0.0 && !this.IIIi_method_78addc86()) {
                  I_field_3a9bda27.player
                     .setVelocity(Math.min(Math.round(I_field_3a9bda27.player.getX()) - I_field_3a9bda27.player.getX(), 0.281), var1.y, var1.z);
               }

               if (this.Iii_field_49 > 14) {
                  I_field_3a9bda27.player.setVelocity(var1.x * 0.6, var1.y - 0.09, var1.z * 0.6);
                  return;
               }

               if (this.Iii_field_49 % 3 == 0) {
                  I_field_3a9bda27.player.setVelocity(var1.x, 0.42, var1.z);
                  this.I_method_f52505df(0.247 - ThreadLocalRandom.current().nextFloat() / 100.0F);
               } else if (this.Iii_field_49 % 3 == 2) {
                  I_field_3a9bda27.player.setVelocity(var1.x, 1.0 - I_field_3a9bda27.player.getY() % 1.0, var1.z);
               }
            }
         }
      } else {
         this.II_field_44 = Double.NaN;
      }
   }

   void iiI_method_e9acfe9f() {
      if (!IiiiiiiII_Class253.i_method_1cc4aa23()) {
         this.IIIi_method_78addc82();
      } else {
         ScaffoldModule.Nested1_81997c40 var1 = this.I_method_3608fcb0();
         if (var1 == null) {
            this.IIIi_method_78addc82();
         } else {
            if (this.II_field_ba20ca4c.i_method_9b12da03() && var1.I_method_9ed42f7e()) {
               this.II_method_b1407641(var1.I_method_9ed42f6d());
            }

            this.I_field_f54de247 = var1;
            ScaffoldModule.Nested1_b1961009 var2 = this.I_method_8b17173d();
            if (var2 == null) {
               this.IIIi_method_78addc82();
               this.I_field_f54de247 = var1;
            } else {
               this.I_method_82ebc9c5(var2);
               if (this.iI_field_bbe33e6c.I_method_ce989e26(this.iIII_field_500d0627)) {
                  iiIIiIIii_Class404 var3 = this.I_method_165a0b1b(var2);
                  if (var3 != null) {
                     this.i_method_748c3ca7(var3);
                  }
               }
            }
         }
      }
   }

   void iii_method_e9bb8a7f() {
      if (!IiiiiiiII_Class253.i_method_1cc4aa23()) {
         this.IIIi_method_78addc82();
      } else {
         this.IIII_method_789f50a2();
         if (this.I_field_b46ee486 != null && this.I_field_f54de247 != null) {
            ScaffoldModule.Nested1_81997c40 var1 = this.I_method_3608fcb0();
            if (var1 == null) {
               this.IIIi_method_78addc82();
            } else {
               this.I_field_f54de247 = var1;
               ScaffoldModule.Nested1_b1961009 var2 = this.I_field_b46ee486;
               if (!this.I_method_82ebc9c9(var2)) {
                  this.IIIi_method_78addc82();
               } else {
                  iiIIiIIii_Class404 var3 = this.I_method_165a0b1b(var2);
                  if (var3 == null) {
                     this.III_field_49 = 0;
                  } else {
                     if (!this.iI_field_bbe33e6c.I_method_ce989e26(this.iIIi_field_500d0627)
                        && !this.iI_field_bbe33e6c.I_method_ce989e26(this.iIiI_field_500d0627)) {
                        if (!this.I_method_d773348b(var3)) {
                           this.III_field_49 = 0;
                           return;
                        }
                     } else {
                        this.I_method_d7733487(var3);
                        RockstarClient.getInstance().I_method_58785402().iI_method_61073f84(var3);
                        if (this.iI_field_bbe33e6c.I_method_ce989e26(this.iIiI_field_500d0627)) {
                           this.i_method_748c3ca7(var3);
                        }
                     }

                     this.III_field_49++;
                     if (this.III_field_49 >= (int)this.Ii_field_73178e8c.Ii_method_a20abcd2()) {
                        if (this.I_field_991c1e8c.I_method_58432069(this.I_method_a4cfa233())) {
                           BlockHitResult var4 = this.I_method_3e8b4cba(var2, var3);
                           if (var4 == null) {
                              this.III_field_49 = 0;
                              this.I_method_a6a9a05c(var2, var1);
                           } else {
                              this.I_method_56cfcc21(var1, var2, var4);
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private void IIII_method_789f50a2() {
      this.II_field_5a = false;
      if (this.iiI_field_ba20ca4c.i_method_9b12da03() && I_field_3a9bda27.player != null) {
         this.II_field_5a = I_field_3a9bda27.player.isSprinting();
         I_field_3a9bda27.options.sprintKey.setPressed(false);
         I_field_3a9bda27.player.setSprinting(false);
      }
   }

   private void I_method_d7733487(iiIIiIIii_Class404 var1) {
      I_field_3a9bda27.player
         .networkHandler
         .sendPacket(
            new Full(
               I_field_3a9bda27.player.getX(),
               I_field_3a9bda27.player.getY(),
               I_field_3a9bda27.player.getZ(),
               var1.I_method_14534e0f(),
               MathHelper.clamp(var1.i_method_1461d9ef(), -90.0F, 90.0F),
               I_field_3a9bda27.player.isOnGround(),
               I_field_3a9bda27.player.horizontalCollision
            )
         );
      RockstarClient.getInstance().I_method_58785402().Ii_method_62e6c38().I_method_7616dd81(var1.I_method_14534e0f());
      RockstarClient.getInstance().I_method_58785402().Ii_method_62e6c38().i_method_77d9cda1(var1.i_method_1461d9ef());
   }

   private ScaffoldModule.Nested1_b1961009 I_method_8b17173d() {
      Vec3d var1 = this.I_method_2c76f25f(this.I_field_b46e6c66);
      if (var1 == null) {
         var1 = I_field_3a9bda27.player.getPos();
      }

      ModeSetting.Nested1_42765c60 var2 = this.I_method_90c82090();
      if (var2 == this.i_field_500d0627) {
         return this.I_method_1a5e9591(var1);
      } else {
         ScaffoldModule.Nested1_b1961009 var3 = this.I_method_a2896968(this.I_method_cfbe481a(var1), var2 == this.I_field_500d0627);
         return var3 == null && this.I_field_b46ee486 != null && this.I_method_82ebc9c9(this.I_field_b46ee486)
            ? this.I_method_b804017(this.I_field_b46ee486, I_field_3a9bda27.player.getEyePos())
            : var3;
      }
   }

   private ScaffoldModule.Nested1_b1961009 I_method_1a5e9591(Vec3d var1) {
      int var2 = (int)this.IIi_field_73178e8c.Ii_method_a20abcd2();

      for (int var3 = 0; var3 <= var2; var3++) {
         BlockPos var4 = this.I_method_7b9e0258(var1, var3);
         ScaffoldModule.Nested1_b1961009 var5 = this.I_method_a2896968(
            this.I_method_22c0b5ce(this.I_method_c129e177(var4), ScaffoldModule.Nested1_b1960fe9.I_field_b46ee0a6), false
         );
         if (var5 != null) {
            return var5.I_method_41cd1859(true);
         }
      }

      return null;
   }

   private ScaffoldModule.Nested1_b1961009 I_method_a2896968(Set<BlockPos> var1, boolean var2) {
      Vec3d var3 = I_field_3a9bda27.player.getEyePos();
      iiIIiIIii_Class404 var4 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
      ScaffoldModule.Nested1_b1961009 var5 = null;
      double var6 = Double.MAX_VALUE;
      ArrayList var8 = new ArrayList(var1);
      var8.sort(this.I_method_8101bc5e(I_field_3a9bda27.player.getPos(), this.I_field_b46e6c66));

      for (BlockPos var10 : (Iterable<BlockPos>)(Iterable<?>)var8) {
         if (this.I_method_b4dc21fd(var10)) {
            for (Direction var14 : Direction.values()) {
               if (var14 != Direction.UP || var2) {
                  BlockPos var15 = var10.offset(var14);
                  Direction var16 = var14.getOpposite();
                  if (this.I_method_cb1580db(var15, var16)) {
                     for (Vec3d var18 : this.I_method_cae20014(var15, var16, var3)) {
                        double var19 = I_field_3a9bda27.player.getBlockInteractionRange();
                        double var21 = var3.squaredDistanceTo(var18);
                        if (!(var21 > var19 * var19)) {
                           ScaffoldModule.Nested1_b1961009 var23 = new ScaffoldModule.Nested1_b1961009(
                              var10, var15, var16, var18, this.I_method_2c649995(var3, var18), !var2 || this.Iii_method_b32076a3()
                           );
                           ScaffoldModule.Nested1_b1961009 var24 = this.I_method_b804017(var23, var3);
                           if (var24 != null) {
                              iiIIiIIii_Class404 var25 = var24.I_method_95423ba7();
                              double var26 = var21 + this.I_method_7ee752d(var4, var25) * 0.15;
                              if (this.i_method_58b3cad4(this.I_method_a6895380(var4), var24)) {
                                 var26 -= 2.0;
                              }

                              if (this.I_field_b46e6c66 != null) {
                                 var26 += this.I_field_b46e6c66.I_method_3bee5e27(var24.I_method_12e1bd1f().toCenterPos()) * 0.25;
                              }

                              if (var26 < var6) {
                                 var6 = var26;
                                 var5 = var24;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var5;
   }

   private ScaffoldModule.Nested1_b1961009 I_method_b804017(ScaffoldModule.Nested1_b1961009 var1, Vec3d var2) {
      if (!this.I_method_82ebc9c9(var1)) {
         return null;
      } else {
         iiIIiIIii_Class404 var3 = this.i_method_ee440c9b(var1, var2);
         ScaffoldModule.Nested1_b1961009 var4 = var1.I_method_2a7e9b07(var3);
         if (!var4.I_method_3bb99155() && !this.i_method_58b3cad4(this.I_method_f8aff21c(var3, var2), var4)) {
            iiIIiIIii_Class404 var5 = this.I_method_28f2f47b(var1, var2);
            return var5 == null ? null : var1.I_method_2a7e9b07(var5);
         } else {
            return var4;
         }
      }
   }

   private iiIIiIIii_Class404 I_method_28f2f47b(ScaffoldModule.Nested1_b1961009 var1, Vec3d var2) {
      Vec3d var3 = I_field_3a9bda27.player.getVelocity();
      int var4 = Math.max(1, (int)Math.ceil(2.0));

      for (int var5 = 1; var5 <= var4; var5++) {
         Vec3d var6 = var2.add(var3.x * var5, 0.0, var3.z * var5);
         iiIIiIIii_Class404 var7 = this.i_method_ee440c9b(var1, var6);
         ScaffoldModule.Nested1_b1961009 var8 = var1.I_method_2a7e9b07(var7);
         if (var8.I_method_3bb99155() || this.i_method_58b3cad4(this.I_method_f8aff21c(var7, var6), var8)) {
            return var7;
         }
      }

      return null;
   }

   private iiIIiIIii_Class404 i_method_ee440c9b(ScaffoldModule.Nested1_b1961009 var1, Vec3d var2) {
      if (this.I_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627)) {
         return this.i_method_d6d376fb(var1);
      } else if (this.I_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627)) {
         return this.II_method_124ae0de(var1);
      } else {
         return this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)
            ? this.I_method_2c649995(var2, var1.I_method_12e1bd1f().toCenterPos())
            : var1.I_method_95423ba7();
      }
   }

   private iiIIiIIii_Class404 I_method_165a0b1b(ScaffoldModule.Nested1_b1961009 var1) {
      if (var1 == null) {
         return null;
      } else if (this.II_field_500d0627.isSelected()) {
         return this.i_method_d6d376fb(var1);
      } else if (this.Ii_field_500d0627.isSelected()) {
         return this.II_method_124ae0de(var1);
      } else {
         return this.i_field_500d0627.isSelected()
            ? this.I_method_2c649995(I_field_3a9bda27.player.getEyePos(), var1.I_method_12e1bd1f().toCenterPos())
            : var1.I_method_95423ba7();
      }
   }

   private iiIIiIIii_Class404 i_method_d6d376fb(ScaffoldModule.Nested1_b1961009 var1) {
      if (!this.I_field_f54de627.iI_method_da4b0f6b()) {
         return this.Ii_method_d2c44cbe(var1);
      } else {
         float var2 = this.I_method_f5250d51(this.I_method_56cd1df2(this.I_field_f54de627) + 180.0F);
         boolean var3 = Math.floorMod((int)var2, 90) == 0;
         if (!var3) {
            return new iiIIiIIii_Class404(var2, 75.6F);
         } else {
            if (I_field_3a9bda27.player.isOnGround()) {
               double var4 = Math.toRadians(var2);
               this.Ii_field_5a = Math.floor(I_field_3a9bda27.player.getX() + Math.cos(var4) * 0.5) != Math.floor(I_field_3a9bda27.player.getX())
                  || Math.floor(I_field_3a9bda27.player.getZ() + Math.sin(var4) * 0.5) != Math.floor(I_field_3a9bda27.player.getZ());
               Vec3d var6 = I_field_3a9bda27.player.getPos().add(Math.cos(var4) * 0.6, 0.0, Math.sin(var4) * 0.6);
               boolean var7 = I_field_3a9bda27.world.getBlockState(I_field_3a9bda27.player.getBlockPos().down()).isAir();
               boolean var8 = I_field_3a9bda27.world.getBlockState(BlockPos.ofFloored(var6).down()).isAir();
               if (var7 && var8) {
                  this.Ii_field_5a = !this.Ii_field_5a;
               }
            }

            return new iiIIiIIii_Class404(var2 + (this.Ii_field_5a ? 45 : -45), 75.7F);
         }
      }
   }

   private iiIIiIIii_Class404 II_method_124ae0de(ScaffoldModule.Nested1_b1961009 var1) {
      if (!this.I_field_f54de627.iI_method_da4b0f6b()) {
         return this.Ii_method_d2c44cbe(var1);
      } else {
         float var2 = this.I_method_f5250d51(this.I_method_56cd1df2(this.I_field_f54de627) + 180.0F);
         boolean var3 = Math.floorMod((int)var2, 90) == 0;
         return new iiIIiIIii_Class404(var2, var3 ? 80.0F : 75.6F);
      }
   }

   private iiIIiIIii_Class404 Ii_method_d2c44cbe(ScaffoldModule.Nested1_b1961009 var1) {
      float var2 = (float)Math.floor(var1.I_method_95423ba7().I_method_14534e0f() / 90.0F) * 90.0F;
      return new iiIIiIIii_Class404(var2 + 45.0F, 75.0F);
   }

   private BlockHitResult I_method_3e8b4cba(ScaffoldModule.Nested1_b1961009 var1, iiIIiIIii_Class404 var2) {
      BlockHitResult var3 = this.I_method_a6895380(var2);
      if (var3 != null && this.I_method_7736eab4(var3, var1)) {
         return var3;
      } else {
         return var1.I_method_3bb99155() ? var1.I_method_99edc8ca() : null;
      }
   }

   private boolean I_method_7736eab4(BlockHitResult var1, ScaffoldModule.Nested1_b1961009 var2) {
      return this.i_method_58b3cad4(var1, var2) && this.I_method_c711a06e(var1);
   }

   private boolean I_method_c711a06e(BlockHitResult var1) {
      Vec3d var2 = var1.getPos().subtract(I_field_3a9bda27.player.getEyePos());
      Direction var3 = var1.getSide();
      if (var3.getAxis() == Axis.Y) {
         return true;
      } else {
         double var4 = var3 != Direction.NORTH && var3 != Direction.SOUTH ? var2.x : var2.z;
         return Math.abs(var4) >= this.I_field_73178e8c.Ii_method_a20abcd2();
      }
   }

   private Set<BlockPos> I_method_cfbe481a(Vec3d var1) {
      BlockPos var2 = this.I_method_c129e177(BlockPos.ofFloored(var1));
      ScaffoldModule.Nested1_b1960fe9 var3 = this.Iii_method_b32076a3()
         ? ScaffoldModule.Nested1_b1960fe9.II_field_b46ee0a6
         : ScaffoldModule.Nested1_b1960fe9.I_field_b46ee0a6;
      if (this.IiI_field_ba20ca4c.i_method_9b12da03() && this.I_field_500d0627.isSelected() && this.iIi_method_e7f89a63()) {
         var3 = ScaffoldModule.Nested1_b1960fe9.i_field_b46ee0a6;
      }

      Set var4 = this.I_method_22c0b5ce(var2, var3);
      Vec3d var5 = I_field_3a9bda27.player.getVelocity();
      this.I_method_9df75de(var4, var1.x + var5.x, var2.getY(), var1.z + var5.z);
      Box var6 = I_field_3a9bda27.player.getBoundingBox().offset(var5.x, 0.0, var5.z);
      this.I_method_9df75de(var4, var6.minX, var2.getY(), var6.minZ);
      this.I_method_9df75de(var4, var6.minX, var2.getY(), var6.maxZ);
      this.I_method_9df75de(var4, var6.maxX, var2.getY(), var6.minZ);
      this.I_method_9df75de(var4, var6.maxX, var2.getY(), var6.maxZ);
      return var4;
   }

   private Set<BlockPos> I_method_22c0b5ce(BlockPos var1, ScaffoldModule.Nested1_b1960fe9 var2) {
      LinkedHashSet var3 = new LinkedHashSet();
      var3.add(var1);
      var3.add(var1.north());
      var3.add(var1.south());
      var3.add(var1.east());
      var3.add(var1.west());
      if (var2 == ScaffoldModule.Nested1_b1960fe9.i_field_b46ee0a6) {
         var3.add(var1.north().east());
         var3.add(var1.north().west());
         var3.add(var1.south().east());
         var3.add(var1.south().west());
         var3.add(var1.up());
         var3.add(var1.down());
      } else if (var2 == ScaffoldModule.Nested1_b1960fe9.II_field_b46ee0a6) {
         var3.add(var1.down());
         var3.add(var1.down().north());
         var3.add(var1.down().south());
         var3.add(var1.down().east());
         var3.add(var1.down().west());
      }

      return var3;
   }

   private void I_method_9df75de(Set<BlockPos> var1, double var2, double var4, double var6) {
      var1.add(BlockPos.ofFloored(var2, var4, var6));
   }

   private BlockPos I_method_c129e177(BlockPos var1) {
      if (this.iii_method_e9bb8a83() || this.I_field_5a) {
         return this.i_method_26a04997(var1);
      } else if (this.Iii_method_b32076a3()) {
         return var1.add(0, -2, 0);
      } else if (this.IiI_field_ba20ca4c.i_method_9b12da03() && this.I_field_500d0627.isSelected() && this.iIi_method_e7f89a63()) {
         return var1.add(0, 3, 0);
      } else if (!I_field_3a9bda27.player.input.playerInput.jump() || this.IIIi_method_78addc86() && !I_field_3a9bda27.player.horizontalCollision) {
         if (this.i_field_bbe33e6c.I_method_ce989e26(this.ii_field_500d0627)) {
            return new BlockPos(var1.getX(), this.II_field_49, var1.getZ());
         } else if (this.i_field_bbe33e6c.I_method_ce989e26(this.III_field_500d0627)) {
            return I_field_3a9bda27.player.getVelocity().y < 0.2 ? new BlockPos(var1.getX(), this.II_field_49, var1.getZ()) : var1.down();
         } else if (!this.i_field_bbe33e6c.I_method_ce989e26(this.IIi_field_500d0627)) {
            return var1.down();
         } else if (I_field_3a9bda27.player.getVelocity().y == -0.15233518685055708 && this.iI_field_49 >= 2) {
            this.iI_field_49 = 0;
            return new BlockPos(var1.getX(), this.Ii_field_49, var1.getZ());
         } else {
            return new BlockPos(var1.getX(), this.Ii_field_49 - 1, var1.getZ());
         }
      } else {
         return var1.down();
      }
   }

   private BlockPos i_method_26a04997(BlockPos var1) {
      if (this.II_field_bbe33e6c.I_method_ce989e26(this.iii_field_500d0627) && !this.IIIi_method_78addc86()) {
         BlockPos[] var2 = new BlockPos[]{var1.add(0, 0, 1), var1.add(0, 0, -1), var1.add(1, 0, 0), var1.add(-1, 0, 0)};
         BlockPos var3 = null;
         double var4 = Double.MAX_VALUE;

         for (BlockPos var9 : var2) {
            double var10 = this.I_method_799defb3(var9).squaredDistanceTo(I_field_3a9bda27.player.getPos());
            if (var10 < var4) {
               var4 = var10;
               var3 = var9.down();
            }
         }

         if (var3 != null && !I_field_3a9bda27.world.getBlockState(var3).isSideSolidFullSquare(I_field_3a9bda27.world, var3, Direction.UP)) {
            return var3;
         }
      }

      return var1.down();
   }

   private BlockPos I_method_7b9e0258(Vec3d var1, int var2) {
      float var3 = I_field_3a9bda27.player.getYaw();
      return BlockPos.ofFloored(var1).add((int)(-Math.sin(Math.toRadians(var3)) * var2), 0, (int)(Math.cos(Math.toRadians(var3)) * var2));
   }

   private Comparator<BlockPos> I_method_8101bc5e(Vec3d var1, ScaffoldModule.Nested1_b1960c29 var2) {
      return (var3, var4) -> {
         if (var2 != null) {
            int var5 = Double.compare(var2.I_method_3bee5e27(this.I_method_799defb3(var3)), var2.I_method_3bee5e27(this.I_method_799defb3(var4)));
            if (var5 != 0) {
               return var5;
            }
         }

         return Double.compare(this.I_method_799defb3(var3).squaredDistanceTo(var1), this.I_method_799defb3(var4).squaredDistanceTo(var1));
      };
   }

   private ScaffoldModule.Nested1_81997c40 I_method_3608fcb0() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         int var1 = I_field_3a9bda27.player.getInventory().selectedSlot;
         ItemStack var2 = I_field_3a9bda27.player.getInventory().getStack(var1);
         if (this.I_method_51968365(var2)) {
            return new ScaffoldModule.Nested1_81997c40(Hand.MAIN_HAND, var1, var2);
         } else if (this.I_method_51968365(I_field_3a9bda27.player.getOffHandStack())) {
            return new ScaffoldModule.Nested1_81997c40(Hand.OFF_HAND, -1, I_field_3a9bda27.player.getOffHandStack());
         } else {
            return !this.i_field_ba20ca4c.i_method_9b12da03() ? null : this.i_method_3c10f890();
         }
      } else {
         return null;
      }
   }

   private ScaffoldModule.Nested1_81997c40 i_method_3c10f890() {
      ScaffoldModule.Nested1_81997c40 var1 = null;
      ScaffoldModule.Nested1_81997c40 var2 = null;
      int var3 = (int)this.ii_field_73178e8c.Ii_method_a20abcd2();

      for (int var4 = 0; var4 < 9; var4++) {
         ItemStack var5 = I_field_3a9bda27.player.getInventory().getStack(var4);
         if (this.I_method_51968365(var5)) {
            ScaffoldModule.Nested1_81997c40 var6 = new ScaffoldModule.Nested1_81997c40(Hand.MAIN_HAND, var4, var5);
            if (var2 == null || this.I_method_a0e63112(var6, var2) > 0) {
               var2 = var6;
            }

            if (var5.getCount() > var3 && (var1 == null || this.I_method_a0e63112(var6, var1) > 0)) {
               var1 = var6;
            }
         }
      }

      return var1 != null ? var1 : var2;
   }

   private int I_method_a0e63112(ScaffoldModule.Nested1_81997c40 var1, ScaffoldModule.Nested1_81997c40 var2) {
      return Integer.compare(this.I_method_e13a9b86(var1.I_method_ffe9a87e(), true), this.I_method_e13a9b86(var2.I_method_ffe9a87e(), true));
   }

   private int I_method_e13a9b86(ItemStack var1, boolean var2) {
      Block var3 = ((BlockItem)var1.getItem()).getBlock();
      BlockState var4 = var3.getDefaultState();
      int var5 = 0;
      if (!this.i_method_f58f0745(var1)) {
         var5 += 1000000;
      }

      if (var4.isSideSolidFullSquare(I_field_3a9bda27.world, BlockPos.ORIGIN, Direction.UP)) {
         var5 += 100000;
      }

      if (!var4.getCollisionShape(I_field_3a9bda27.world, BlockPos.ORIGIN).isEmpty()) {
         var5 += 10000;
      }

      return var5 + (var2 ? var1.getCount() : 64 - var1.getCount());
   }

   private boolean I_method_51968365(ItemStack var1) {
      if (var1 != null && !var1.isEmpty()) {
         if (var1.getItem() instanceof BlockItem var3) {
            Block var4 = var3.getBlock();
            if (this.I_method_7c86256f(var4)) {
               return false;
            } else {
               BlockState var5 = var4.getDefaultState();
               return var5.isSideSolidFullSquare(I_field_3a9bda27.world, BlockPos.ORIGIN, Direction.UP)
                  && !var5.getCollisionShape(I_field_3a9bda27.world, BlockPos.ORIGIN).isEmpty();
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private boolean I_method_7c86256f(Block var1) {
      return var1 instanceof FallingBlock || var1 == Blocks.TNT || var1 == Blocks.COBWEB || var1 == Blocks.NETHER_PORTAL || var1 == Blocks.POWDER_SNOW;
   }

   private boolean i_method_f58f0745(ItemStack var1) {
      if (!(var1.getItem() instanceof BlockItem var2)) {
         return true;
      } else {
         Block var5 = var2.getBlock();
         BlockState var4 = var5.getDefaultState();
         return var5.getSlipperiness() > 0.6F
            || var5 instanceof BlockWithEntity
            || var4.getCollisionShape(I_field_3a9bda27.world, BlockPos.ORIGIN).isEmpty()
            || var5 == Blocks.CRAFTING_TABLE
            || var5 == Blocks.SMITHING_TABLE
            || var5 == Blocks.FLETCHING_TABLE
            || var5 == Blocks.ENCHANTING_TABLE
            || var5 == Blocks.CAULDRON
            || var5 == Blocks.MAGMA_BLOCK;
      }
   }

   private int II_method_f5339cf5() {
      int var1 = this.I_method_51968365(I_field_3a9bda27.player.getOffHandStack()) ? I_field_3a9bda27.player.getOffHandStack().getCount() : 0;
      if (!this.i_field_ba20ca4c.i_method_9b12da03()) {
         ItemStack var4 = I_field_3a9bda27.player.getInventory().getStack(I_field_3a9bda27.player.getInventory().selectedSlot);
         return var1 + (this.I_method_51968365(var4) ? var4.getCount() : 0);
      } else {
         for (int var2 = 0; var2 < 9; var2++) {
            ItemStack var3 = I_field_3a9bda27.player.getInventory().getStack(var2);
            if (this.I_method_51968365(var3)) {
               var1 += var3.getCount();
            }
         }

         return var1;
      }
   }

   private boolean I_method_b4dc21fd(BlockPos var1) {
      BlockState var2 = I_field_3a9bda27.world.getBlockState(var1);
      return var2.isAir() || var2.getCollisionShape(I_field_3a9bda27.world, var1).isEmpty() && I_field_3a9bda27.world.getFluidState(var1).isEmpty();
   }

   private boolean I_method_cb1580db(BlockPos var1, Direction var2) {
      BlockState var3 = I_field_3a9bda27.world.getBlockState(var1);
      return !var3.isAir() && !var3.getCollisionShape(I_field_3a9bda27.world, var1).isEmpty() && var3.isSideSolidFullSquare(I_field_3a9bda27.world, var1, var2);
   }

   private boolean I_method_82ebc9c9(ScaffoldModule.Nested1_b1961009 var1) {
      double var2 = I_field_3a9bda27.player.getBlockInteractionRange();
      return this.I_method_b4dc21fd(var1.I_method_12e1bd1f())
         && this.I_method_cb1580db(var1.i_method_87dc2d3f(), var1.I_method_add3f71())
         && var1.i_method_87dc2d3f().offset(var1.I_method_add3f71()).equals(var1.I_method_12e1bd1f())
         && I_field_3a9bda27.player.getEyePos().squaredDistanceTo(var1.I_method_7e93f50b()) <= var2 * var2;
   }

   private void i_method_748c3ca7(iiIIiIIii_Class404 var1) {
      float var2 = this.i_field_73178e8c.Ii_method_a20abcd2();
      RockstarClient.getInstance()
         .I_method_58785402()
         .I_method_1acbf705(
            new iiIIiIIii_Class404(var1.I_method_14534e0f(), var1.i_method_1461d9ef()),
            this.I_method_894166f5(),
            var2,
            var2,
            var2,
            iiIIiIiiI_Class407.iI_field_32efc66c
         );
   }

   private iiIIiIIIi_Class402 I_method_894166f5() {
      if (this.ii_field_bbe33e6c.I_method_ce989e26(this.iiII_field_500d0627)) {
         return iiIIiIIIi_Class402.II_field_32e0c64c;
      } else if (this.ii_field_bbe33e6c.I_method_ce989e26(this.iiIi_field_500d0627)) {
         return iiIIiIIIi_Class402.Ii_field_32e0c64c;
      } else {
         return this.ii_field_bbe33e6c.I_method_ce989e26(this.iiiI_field_500d0627) ? iiIIiIIIi_Class402.ii_field_32e0c64c : iiIIiIIIi_Class402.I_field_32e0c64c;
      }
   }

   private boolean I_method_d773348b(iiIIiIIii_Class404 var1) {
      iiIIiIIii_Class404 var2 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
      float var3 = Math.abs(MathHelper.wrapDegrees(var2.I_method_14534e0f() - var1.I_method_14534e0f()));
      float var4 = Math.abs(var2.i_method_1461d9ef() - var1.i_method_1461d9ef());
      float var5 = this.II_field_73178e8c.Ii_method_a20abcd2();
      return var3 <= var5 && var4 <= var5;
   }

   private BlockHitResult I_method_a6895380(iiIIiIIii_Class404 var1) {
      return this.I_method_f8aff21c(var1, I_field_3a9bda27.player.getEyePos());
   }

   private BlockHitResult I_method_f8aff21c(iiIIiIIii_Class404 var1, Vec3d var2) {
      Vec3d var3 = var2.add(
         I_field_3a9bda27.player
            .getRotationVector(var1.i_method_1461d9ef(), var1.I_method_14534e0f())
            .multiply(I_field_3a9bda27.player.getBlockInteractionRange())
      );
      return I_field_3a9bda27.world.raycast(new RaycastContext(var2, var3, ShapeType.OUTLINE, FluidHandling.NONE, I_field_3a9bda27.player));
   }

   private iiIIiIIii_Class404 I_method_2c649995(Vec3d var1, Vec3d var2) {
      double var3 = var2.x - var1.x;
      double var5 = var2.y - var1.y;
      double var7 = var2.z - var1.z;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)Math.toDegrees(Math.atan2(var7, var3)) - 90.0F;
      float var12 = (float)(-Math.toDegrees(Math.atan2(var5, var9)));
      return new iiIIiIIii_Class404(var11, MathHelper.clamp(var12, -90.0F, 90.0F));
   }

   private boolean i_method_58b3cad4(BlockHitResult var1, ScaffoldModule.Nested1_b1961009 var2) {
      if (var1 != null && var1.getType() == Type.BLOCK) {
         BlockPos var3 = var1.getBlockPos();
         Direction var4 = var1.getSide();
         BlockPos var5 = var3.offset(var4);
         return var3.equals(var2.i_method_87dc2d3f()) && var4 == var2.I_method_add3f71() && var5.equals(var2.I_method_12e1bd1f())
            ? this.I_method_b4dc21fd(var5) && this.I_method_cb1580db(var3, var4)
            : false;
      } else {
         return false;
      }
   }

   private List<Vec3d> I_method_cae20014(BlockPos var1, Direction var2, Vec3d var3) {
      ArrayList var4 = new ArrayList();
      double var5 = this.Ii_field_bbe33e6c.I_method_ce989e26(this.Iiii_field_500d0627) ? 0.04 : 0.18;
      double var7 = this.Ii_field_bbe33e6c.I_method_ce989e26(this.Iiii_field_500d0627) ? 0.96 : 0.82;
      double var9 = MathHelper.clamp(var3.x - var1.getX(), var5, var7);
      double var11 = MathHelper.clamp(var3.y - var1.getY(), var5, var7);
      double var13 = MathHelper.clamp(var3.z - var1.getZ(), var5, var7);
      double var15 = 0.5;
      double var17 = 0.82;
      if (this.Ii_field_bbe33e6c.I_method_ce989e26(this.IIII_field_500d0627)) {
         var9 = var15;
         var11 = var15;
         var13 = var15;
      } else if (this.Ii_field_bbe33e6c.I_method_ce989e26(this.IIIi_field_500d0627)) {
         var9 = this.I_method_af7c162d(var5, var7);
         var11 = this.I_method_af7c162d(var5, var7);
         var13 = this.I_method_af7c162d(var5, var7);
      } else if (this.Ii_field_bbe33e6c.I_method_ce989e26(this.IiII_field_500d0627)) {
         var9 = 1.0 - var9;
         var13 = 1.0 - var13;
      } else if (this.Ii_field_bbe33e6c.I_method_ce989e26(this.IiIi_field_500d0627)) {
         var9 = var9 < 0.5 ? var5 : var7;
         var13 = var13 < 0.5 ? var5 : var7;
      } else if (this.Ii_field_bbe33e6c.I_method_ce989e26(this.IiiI_field_500d0627)) {
         float var19 = MathHelper.wrapDegrees(I_field_3a9bda27.player.getYaw());
         var9 = Math.sin(Math.toRadians(var19)) > 0.0 ? var7 : var5;
         var13 = Math.cos(Math.toRadians(var19)) > 0.0 ? var7 : var5;
      }

      if (var2.getAxis() == Axis.X) {
         double var21 = var1.getX() + (var2 == Direction.EAST ? 1 : 0);
         this.I_method_2525b14e(var4, var21, var1.getY() + var11, var1.getZ() + var13);
         this.I_method_2525b14e(var4, var21, var1.getY() + var17, var1.getZ() + var13);
         this.I_method_2525b14e(var4, var21, var1.getY() + var11, var1.getZ() + var15);
         this.I_method_2525b14e(var4, var21, var1.getY() + var17, var1.getZ() + var15);
         this.I_method_2525b14e(var4, var21, var1.getY() + var15, var1.getZ() + var15);
      } else if (var2.getAxis() == Axis.Y) {
         double var22 = var1.getY() + (var2 == Direction.UP ? 1 : 0);
         this.I_method_2525b14e(var4, var1.getX() + var9, var22, var1.getZ() + var13);
         this.I_method_2525b14e(var4, var1.getX() + var9, var22, var1.getZ() + var15);
         this.I_method_2525b14e(var4, var1.getX() + var15, var22, var1.getZ() + var13);
         this.I_method_2525b14e(var4, var1.getX() + var15, var22, var1.getZ() + var15);
      } else {
         double var23 = var1.getZ() + (var2 == Direction.SOUTH ? 1 : 0);
         this.I_method_2525b14e(var4, var1.getX() + var9, var1.getY() + var11, var23);
         this.I_method_2525b14e(var4, var1.getX() + var9, var1.getY() + var17, var23);
         this.I_method_2525b14e(var4, var1.getX() + var15, var1.getY() + var11, var23);
         this.I_method_2525b14e(var4, var1.getX() + var15, var1.getY() + var17, var23);
         this.I_method_2525b14e(var4, var1.getX() + var15, var1.getY() + var15, var23);
      }

      if (this.Ii_field_bbe33e6c.I_method_ce989e26(this.IIii_field_500d0627)) {
         iiIIiIIii_Class404 var24 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
         var4.sort(Comparator.comparingDouble((Vec3d var3x) -> this.I_method_7ee752d(var24, this.I_method_2c649995(var3, var3x))));
      } else if (this.Ii_field_bbe33e6c.I_method_ce989e26(this.IIiI_field_500d0627) && this.I_field_b46e6c66 != null) {
         var4.sort(Comparator.comparingDouble((Vec3d var2x) -> this.I_field_b46e6c66.I_method_3bee5e27(var2x) + var2x.squaredDistanceTo(var3) * 0.05));
      } else {
         var4.sort(Comparator.comparingDouble((Vec3d var1x) -> var1x.squaredDistanceTo(var3)));
      }

      return var4;
   }

   private void I_method_2525b14e(List<Vec3d> var1, double var2, double var4, double var6) {
      Vec3d var8 = new Vec3d(var2, var4, var6);
      if (!var1.contains(var8)) {
         var1.add(var8);
      }
   }

   private double I_method_7ee752d(iiIIiIIii_Class404 var1, iiIIiIIii_Class404 var2) {
      return Math.abs(MathHelper.wrapDegrees(var1.I_method_14534e0f() - var2.I_method_14534e0f()))
         + Math.abs(var1.i_method_1461d9ef() - var2.i_method_1461d9ef());
   }

   private void I_method_56cfcc21(ScaffoldModule.Nested1_81997c40 var1, ScaffoldModule.Nested1_b1961009 var2, BlockHitResult var3) {
      if (this.iiI_field_ba20ca4c.i_method_9b12da03()) {
         I_field_3a9bda27.options.sprintKey.setPressed(false);
         if (this.II_field_5a || I_field_3a9bda27.player.isSprinting()) {
            iIIIIiIII_Class265.I_method_e89e02c2(I_field_3a9bda27.player, () -> this.i_method_62946001(var1, var2, var3), true);
            this.II_field_5a = false;
            return;
         }

         I_field_3a9bda27.player.setSprinting(false);
      }

      this.i_method_62946001(var1, var2, var3);
   }

   private void i_method_62946001(ScaffoldModule.Nested1_81997c40 var1, ScaffoldModule.Nested1_b1961009 var2, BlockHitResult var3) {
      if (IiiiiiiII_Class253.i_method_1cc4aa23()) {
         if (var1.I_method_9ed42f7e()) {
            this.II_method_b1407641(var1.I_method_9ed42f6d());
         }

         ActionResult var4 = I_field_3a9bda27.interactionManager.interactBlock(I_field_3a9bda27.player, var1.I_method_f1c0df83(), var3);
         if (var4.isAccepted()) {
            I_field_3a9bda27.player.swingHand(var1.I_method_f1c0df83());
            this.I_method_b4dc21f9(var2.I_method_12e1bd1f());
         }
      }
   }

   private void I_method_b4dc21f9(BlockPos var1) {
      this.i_method_df2fb5d9(var1);
      this.I_method_74be9f45(this.I_field_b46e6c66, this.I_field_b46e6c66 == null ? null : this.i_method_f8976e3f(this.I_field_b46e6c66));
      this.IIii_method_7a70cca2();
      this.I_field_991c1e8c.I_method_23e11e3f();
      this.IIIi_method_78addc82();
   }

   private void I_method_a6a9a05c(ScaffoldModule.Nested1_b1961009 var1, ScaffoldModule.Nested1_81997c40 var2) {
      if (this.iii_field_ba20ca4c.i_method_9b12da03() && this.IIIi_method_78addc86() && var2 != null && var1 != null) {
         if (!this.IIII_field_ba20ca4c.i_method_9b12da03() || !var1.I_method_3bb99155()) {
            if (ThreadLocalRandom.current().nextInt(3) == 0) {
               I_field_3a9bda27.player.swingHand(var2.I_method_f1c0df83());
            }
         }
      }
   }

   private void I_method_82ebc9c5(ScaffoldModule.Nested1_b1961009 var1) {
      if (!var1.I_method_12e1bd1f().equals(this.I_field_670402ba)
         || !var1.i_method_87dc2d3f().equals(this.i_field_670402ba)
         || var1.I_method_add3f71() != this.I_field_3b03ad36) {
         this.III_field_49 = 0;
      }

      this.I_field_b46ee486 = var1;
      this.I_field_670402ba = var1.I_method_12e1bd1f();
      this.i_field_670402ba = var1.i_method_87dc2d3f();
      this.I_field_3b03ad36 = var1.I_method_add3f71();
   }

   private void IIIi_method_78addc82() {
      this.I_field_b46ee486 = null;
      this.I_field_f54de247 = null;
      this.I_field_670402ba = null;
      this.i_field_670402ba = null;
      this.I_field_3b03ad36 = null;
      this.III_field_49 = 0;
   }

   private void IIiI_method_7a6240c2() {
      this.IIIi_method_78addc82();
      this.I_field_f27e4628.clear();
      this.i_field_f27e4628.clear();
      this.I_field_b46e6c66 = null;
      this.I_field_f54de627 = ScaffoldModule.Nested1_81997c60.I_field_f54de627;
      this.I_field_d95eae07 = null;
      this.II_field_670402ba = null;
      this.I_field_46 = Float.NaN;
      this.ii_field_49 = 0;
      this.IIi_field_49 = 0;
      this.Iii_field_49 = 0;
      this.II_field_44 = Double.NaN;
      this.I_field_5a = false;
      this.Ii_field_5a = false;
      this.II_field_46 = 0.0F;
      this.I_field_4a = 0L;
   }

   ScaffoldModule.Nested1_b1960c29 I_method_9035be3a(ScaffoldModule.Nested1_81997c60 var1) {
      Vec3d var2 = this.I_method_3a4af51b(this.I_method_56cd1df2(var1));
      ScaffoldModule.Nested1_812b7580 var3 = this.I_method_d7bcd230();
      if (var3 == null) {
         return null;
      } else {
         this.I_field_d95eae07 = var3;
         ScaffoldModule.Nested1_b1960c29 var4 = this.I_method_8b169f1d();
         Vec3d var5;
         if (var4 != null && var4.i_method_ad9208cb().dotProduct(var2) >= 0.5) {
            var5 = var4.I_method_9e513bf3(I_field_3a9bda27.player.getPos());
         } else {
            var5 = new Vec3d(
               var3.I_method_5bb65156().getX() + 0.5 + var3.I_method_5cbfe28(),
               I_field_3a9bda27.player.getY(),
               var3.I_method_5bb65156().getZ() + 0.5 + var3.i_method_5da8a08()
            );
         }

         return new ScaffoldModule.Nested1_b1960c29(new Vec3d(var5.x, I_field_3a9bda27.player.getY(), var5.z), var2);
      }
   }

   private ScaffoldModule.Nested1_b1960c29 I_method_8b169f1d() {
      if (this.I_field_f27e4628.size() < 2) {
         return null;
      } else {
         BlockPos var1 = null;
         BlockPos var2 = null;

         for (BlockPos var4 : this.I_field_f27e4628) {
            var2 = var1;
            var1 = var4;
         }

         if (var1 != null && var2 != null) {
            Vec3d var7 = this.i_method_75d7b93(var2);
            Vec3d var8 = this.i_method_75d7b93(var1);
            Vec3d var5 = var8.subtract(var7).normalize();
            Vec3d var6 = var7.add(var8).multiply(0.5);
            return new ScaffoldModule.Nested1_b1960c29(var6, var5);
         } else {
            return null;
         }
      }
   }

   private ScaffoldModule.Nested1_812b7580 I_method_d7bcd230() {
      List var1 = this.I_method_55238a28();
      if (var1.isEmpty()) {
         this.I_field_d95eae07 = null;
         this.II_field_670402ba = null;
         return null;
      } else {
         var1.sort(null);
         ScaffoldModule.Nested1_812b7560 var2 = (ScaffoldModule.Nested1_812b7560)var1.getFirst();
         ScaffoldModule.Nested1_812b7560 var3 = this.I_method_12664202(var1, var2);
         this.II_field_670402ba = var3.I_method_3b976936();
         return new ScaffoldModule.Nested1_812b7580(
            var3.I_method_3b976936(),
            I_field_3a9bda27.player.getX() - (var3.I_method_3b976936().getX() + 0.5),
            I_field_3a9bda27.player.getZ() - (var3.I_method_3b976936().getZ() + 0.5)
         );
      }
   }

   private List<ScaffoldModule.Nested1_812b7560> I_method_55238a28() {
      ArrayList var1 = new ArrayList();
      LinkedHashSet var2 = new LinkedHashSet();
      double[] var3 = new double[]{0.301, 0.0, -0.301};

      for (double var7 : var3) {
         for (double var12 : var3) {
            BlockPos var14 = BlockPos.ofFloored(
               I_field_3a9bda27.player.getX() + var7, I_field_3a9bda27.player.getY() - 1.0, I_field_3a9bda27.player.getZ() + var12
            );
            if (var2.add(var14) && !I_field_3a9bda27.world.getBlockState(var14).getCollisionShape(I_field_3a9bda27.world, var14).isEmpty()) {
               var1.add(this.I_method_f7428c8a(var14));
            }
         }
      }

      return var1;
   }

   private ScaffoldModule.Nested1_812b7560 I_method_12664202(List<ScaffoldModule.Nested1_812b7560> var1, ScaffoldModule.Nested1_812b7560 var2) {
      ScaffoldModule.Nested1_812b7560 var3 = null;
      ScaffoldModule.Nested1_812b7560 var4 = null;
      BlockPos var5 = this.I_field_f27e4628.peekLast();

      for (ScaffoldModule.Nested1_812b7560 var7 : var1) {
         if (Objects.equals(var7.I_method_3b976936(), var5)) {
            var3 = var7;
         }

         if (Objects.equals(var7.I_method_3b976936(), this.II_field_670402ba)) {
            var4 = var7;
         }
      }

      if (var3 != null && var3.I_method_5ac27b0b(var2)) {
         return var3;
      } else {
         return var4 != null && var4.I_method_5ac27b0b(var2) ? var4 : var2;
      }
   }

   private ScaffoldModule.Nested1_812b7560 I_method_f7428c8a(BlockPos var1) {
      Box var2 = I_field_3a9bda27.player.getBoundingBox();
      List var3 = I_field_3a9bda27.world.getBlockState(var1).getCollisionShape(I_field_3a9bda27.world, var1).getBoundingBoxes();
      double var4 = Double.POSITIVE_INFINITY;
      double var6 = 0.0;

      for (Box var9 : (Iterable<Box>)(Iterable<?>)var3) {
         Box var10 = var9.offset(var1);
         double var11 = Math.min(var2.maxX, var10.maxX) - Math.max(var2.minX, var10.minX);
         double var13 = Math.min(var2.maxZ, var10.maxZ) - Math.max(var2.minZ, var10.minZ);
         if (!(var11 <= 0.0) && !(var13 <= 0.0)) {
            double var15 = Math.abs(var2.minY - var10.maxY);
            double var17 = var11 * var13;
            if (var15 + 0.001 < var4) {
               var4 = var15;
               var6 = var17;
            } else if (Math.abs(var15 - var4) <= 0.001) {
               var6 += var17;
            }
         }
      }

      return new ScaffoldModule.Nested1_812b7560(var1, var6, var4, this.I_method_d6a67cad(this.I_method_799defb3(var1), I_field_3a9bda27.player.getPos()));
   }

   private Vec3d I_method_3a4af51b(float var1) {
      if (!Float.isNaN(this.I_field_46) && MathHelper.angleBetween(var1, this.I_field_46) <= 30.0F) {
         return this.i_method_1562ed3b(this.I_field_46);
      } else {
         float var2 = var1 / 180.0F * 4.0F + 4.0F;
         float var3 = Math.round(var2);
         float var4 = MathHelper.wrapDegrees((var3 - 4.0F) / 4.0F * 180.0F);
         this.I_field_46 = var4;
         return this.i_method_1562ed3b(var4);
      }
   }

   private void i_method_df2fb5d9(BlockPos var1) {
      if (!var1.equals(this.I_field_f27e4628.peekLast())) {
         while (this.I_field_f27e4628.size() >= 4) {
            this.I_field_f27e4628.removeFirst();
         }

         this.I_field_f27e4628.add(var1);
      }
   }

   private Vec3d I_method_2c76f25f(ScaffoldModule.Nested1_b1960c29 var1) {
      if (var1 != null && !this.I_method_f52505e3(0.05)) {
         Vec3d var2 = this.i_method_f8976e3f(var1);
         if (var2 == null) {
            return null;
         } else {
            Vec3d var3 = I_field_3a9bda27.player.getPos();
            Vec3d var4 = var2.subtract(var3);
            Vec3d var5 = this.I_method_e059abf9(var2, var4);
            Vec3d var6 = this.I_method_5a183179();
            if (var6 != null) {
               float var7 = (float)Math.atan2(var1.i_method_ad9208cb().z, var1.i_method_ad9208cb().x);
               Vec3d var8 = var2.add(this.I_method_15ac2e6f(var6, -var7));
               return this.I_method_80895299(var5, var8, this.I_method_a4cfa22d());
            } else {
               return this.I_field_d95eae07 != null ? var5.add(this.I_field_d95eae07.I_method_5cbfe28(), 0.0, this.I_field_d95eae07.i_method_5da8a08()) : var5;
            }
         }
      } else {
         return null;
      }
   }

   private void I_method_74be9f45(ScaffoldModule.Nested1_b1960c29 var1, Vec3d var2) {
      if (var1 != null && var2 != null) {
         float var3 = (float)Math.atan2(var1.i_method_ad9208cb().z, var1.i_method_ad9208cb().x);
         Vec3d var4 = this.I_method_15ac2e6f(I_field_3a9bda27.player.getPos().subtract(var2), var3);
         this.i_field_f27e4628.addLast(var4);

         while (this.i_field_f27e4628.size() > 4) {
            this.i_field_f27e4628.removeFirst();
         }
      }
   }

   private Vec3d I_method_5a183179() {
      if (this.i_field_f27e4628.isEmpty()) {
         return null;
      } else {
         double var1 = 0.0;
         double var3 = 0.0;
         double var5 = 0.0;

         for (Vec3d var8 : this.i_field_f27e4628) {
            var1 += var8.x;
            var3 += var8.y;
            var5 += var8.z;
         }

         double var9 = this.i_field_f27e4628.size();
         return new Vec3d(var1 / var9, var3 / var9, var5 / var9);
      }
   }

   private Vec3d i_method_f8976e3f(ScaffoldModule.Nested1_b1960c29 var1) {
      Vec3d var2 = var1.I_method_9e513bf3(I_field_3a9bda27.player.getPos()).add(0.0, -0.1, 0.0);
      Vec3d var3 = var1.i_method_ad9208cb().normalize();
      Vec3d var4 = var2;

      for (double var5 = 0.0; var5 <= 3.0; var5 += 0.05) {
         Vec3d var7 = var2.add(var3.multiply(var5));
         if (!this.I_method_af7c1643(var7.x, var7.z)) {
            return new Vec3d(var4.x, I_field_3a9bda27.player.getY(), var4.z);
         }

         var4 = var7;
      }

      return null;
   }

   private Vec3d I_method_e059abf9(Vec3d var1, Vec3d var2) {
      double var3 = 0.2;
      return !(var3 <= 0.0) && !(var2.lengthSquared() < 1.0E-6) ? var1.subtract(var2.normalize().multiply(var3)) : var1;
   }

   private double I_method_a4cfa22d() {
      byte var1 = 2;
      return MathHelper.clamp((double)this.i_field_f27e4628.size() / var1, 0.0, 1.0);
   }

   ScaffoldModule.Nested1_b1960c09 I_method_8b169b3d() {
      if (this.Ii_field_ba20ca4c.i_method_9b12da03() && I_field_3a9bda27.player != null) {
         iiIIiIIii_Class404 var1 = this.I_method_165a0b1b(this.I_field_b46ee486);
         if (var1 == null) {
            var1 = RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5();
         }

         if (this.I_method_f52505e3(0.05)) {
            int var2 = this.I_method_d773347a(var1);
            boolean var3 = this.II_method_f5339cf5() <= 0;
            boolean var4 = var2 >= 1;
            if (var3 || var4) {
               return new ScaffoldModule.Nested1_b1960c09(false, Math.max(1, var2), false, false);
            }
         }

         if (!this.II_field_500d0627.isSelected() || !this.IiI_method_b311eac3()) {
            return ScaffoldModule.Nested1_b1960c09.I_field_b46e6886;
         } else if (this.II_method_f5339cf5() < this.IiI_field_73178e8c.Ii_method_a20abcd2()) {
            return new ScaffoldModule.Nested1_b1960c09(false, this.I_method_29b8249a(this.iI_field_bbe3b68c), false, false);
         } else {
            int var5 = ThreadLocalRandom.current().nextInt(4);

            return switch (var5) {
               case 0 -> new ScaffoldModule.Nested1_b1960c09(true, 0, false, false);
               case 1 -> new ScaffoldModule.Nested1_b1960c09(false, this.I_method_29b8249a(this.iI_field_bbe3b68c), false, false);
               case 2 -> new ScaffoldModule.Nested1_b1960c09(false, 0, true, false);
               default -> new ScaffoldModule.Nested1_b1960c09(false, 0, false, true);
            };
         }
      } else {
         return ScaffoldModule.Nested1_b1960c09.I_field_b46e6886;
      }
   }

   private int I_method_d773347a(iiIIiIIii_Class404 var1) {
      iiIIiIIii_Class404 var2 = RockstarClient.getInstance().I_method_58785402().II_method_f098f858();
      float var3 = Math.max(1.0F, this.i_field_73178e8c.Ii_method_a20abcd2());
      double var4 = this.I_method_7ee752d(var2, var1);
      return (int)Math.ceil(var4 / var3);
   }

   private boolean IiI_method_b311eac3() {
      Vec3d var1 = I_field_3a9bda27.player.getVelocity();
      Vec3d var2 = I_field_3a9bda27.player.getPos().add(var1.x, 0.0, var1.z);
      return !this.I_method_af7c1643(var2.x, var2.z);
   }

   boolean I_method_9c45a13d(InputEvent var1) {
      if (this.iII_method_e7ea0e83()) {
         return false;
      } else if (!I_field_3a9bda27.player.isOnGround() && this.ii_field_ba20ca4c.i_method_9b12da03()) {
         return false;
      } else if (!I_field_3a9bda27.player.getAbilities().flying && this.IIi_field_49 == 0) {
         ScaffoldModule.Nested1_81997c60 var2 = ScaffoldModule.Nested1_81997c60.I_method_c344e94f(var1);
         return this.I_method_82d70280(var2, this.i_field_46);
      } else {
         return false;
      }
   }

   private void IIii_method_7a70cca2() {
      if (this.iI_field_ba20ca4c.i_method_9b12da03()) {
         this.IIi_field_49++;
         if (this.IIi_field_49 > this.IiI_field_49) {
            this.IiII_method_af3a6482();
         }
      }
   }

   private void IiII_method_af3a6482() {
      this.IIi_field_49 = 0;
      this.IiI_field_49 = this.I_method_29b8249a(this.i_field_bbe3b68c);
      this.i_field_46 = this.I_method_29b82497(this.II_field_bbe3b68c);
   }

   void I_method_9c45a139(InputEvent var1) {
      if (this.I_field_b46e6c66 != null && (!var1.isJump() || !I_field_3a9bda27.player.isOnGround())) {
         Vec3d var2 = this.I_field_b46e6c66.I_method_9e513bf3(I_field_3a9bda27.player.getPos());
         Vec3d var3 = var2.subtract(I_field_3a9bda27.player.getPos());
         Vec3d var4 = new Vec3d(I_field_3a9bda27.player.getVelocity().x, 0.0, I_field_3a9bda27.player.getVelocity().z);
         boolean var5 = var3.dotProduct(var4) > 0.0;
         double var6 = var5 ? 0.075 : 0.2;
         if (!(var2.squaredDistanceTo(I_field_3a9bda27.player.getPos()) < var6 * var6)) {
            ScaffoldModule.Nested1_81997c60 var8 = ScaffoldModule.Nested1_81997c60.I_method_c344e94f(var1);
            ScaffoldModule.Nested1_81997c60 var9 = this.I_method_d543c306(var3, I_field_3a9bda27.player.getYaw());
            boolean var10 = var8.I_method_d56f435e() || var8.i_method_d57dcf3e();
            boolean var11 = var8.II_method_d8881f4b() || var8.Ii_method_d896ab2b();
            var1.setForward(var10 ? var1.getForward() : var9.I_method_d56f434a());
            var1.setStrafe(var11 ? var1.getStrafe() : var9.i_method_d57dcf2a());
         }
      }
   }

   void i_method_11401159(InputEvent var1) {
      if (!var1.isSneak() && var1.getForward() > 0.0F) {
         if (I_field_3a9bda27.world.getBlockState(I_field_3a9bda27.player.getBlockPos().down()).isAir()) {
            this.I_field_4a = System.currentTimeMillis();
         } else if (System.currentTimeMillis() - this.I_field_4a > 500L) {
            return;
         }

         double var2 = I_field_3a9bda27.player.getX() - Math.floor(I_field_3a9bda27.player.getX());
         double var4 = I_field_3a9bda27.player.getZ() - Math.floor(I_field_3a9bda27.player.getZ());
         double var6 = this.Ii_field_46;
         double var8 = 1.0 - var6;
         float var10 = 0.0F;
         Direction var11 = this.I_method_13f5b781(I_field_3a9bda27.player.getYaw());
         if (var11 == Direction.SOUTH) {
            if (var2 > var8) {
               var10 = 1.0F;
            }

            if (var2 < var6) {
               var10 = -1.0F;
            }
         } else if (var11 == Direction.NORTH) {
            if (var2 > var8) {
               var10 = -1.0F;
            }

            if (var2 < var6) {
               var10 = 1.0F;
            }
         } else if (var11 == Direction.EAST) {
            if (var4 > var8) {
               var10 = -1.0F;
            }

            if (var4 < var6) {
               var10 = 1.0F;
            }
         } else if (var11 == Direction.WEST) {
            if (var4 > var8) {
               var10 = 1.0F;
            }

            if (var4 < var6) {
               var10 = -1.0F;
            }
         }

         if (this.II_field_46 != var10 && var10 != 0.0F) {
            this.II_field_46 = var10;
            this.Ii_field_46 = this.I_method_29b82497(this.Ii_field_bbe3b68c);
         }

         var1.setStrafe(this.II_field_46);
      }
   }

   private boolean Iii_method_b32076a3() {
      return this.III_field_ba20ca4c.i_method_9b12da03() && this.I_field_500d0627.isSelected() && I_field_3a9bda27.options.sneakKey.isPressed();
   }

   boolean iII_method_e7ea0e83() {
      BlockPos var1 = I_field_3a9bda27.player.getBlockPos().add(0, -2, 0);
      return this.Iii_method_b32076a3() && I_field_3a9bda27.world.getBlockState(var1).isSideSolidFullSquare(I_field_3a9bda27.world, var1, Direction.UP);
   }

   private boolean iIi_method_e7f89a63() {
      return !I_field_3a9bda27.world.getBlockState(I_field_3a9bda27.player.getBlockPos().down()).isAir();
   }

   private boolean iiI_method_e9acfea3() {
      BlockPos var1 = I_field_3a9bda27.player.getBlockPos().up(2);
      return !I_field_3a9bda27.world.getBlockState(var1).getCollisionShape(I_field_3a9bda27.world, var1).isEmpty() && I_field_3a9bda27.player.isOnGround();
   }

   private boolean iii_method_e9bb8a83() {
      boolean var1 = !this.II_field_bbe33e6c.I_method_ce989e26(this.IiI_field_500d0627) && I_field_3a9bda27.options.jumpKey.isPressed();
      if (var1) {
         this.I_field_5a = true;
      }

      return var1;
   }

   private ModeSetting.Nested1_42765c60 I_method_90c82090() {
      return this.iii_method_e9bb8a83() ? this.I_field_500d0627 : this.I_field_bbe33e6c.i_method_f85f3850();
   }

   private boolean IIII_method_789f50a6() {
      Box var1 = I_field_3a9bda27.player.getBoundingBox().expand(0.5, 0.0, 0.5).offset(0.0, -1.05, 0.0);
      return this.I_method_b78fcf09(var1);
   }

   private boolean I_method_f52505e3(double var1) {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         Box var3 = I_field_3a9bda27.player.getBoundingBox();
         return !this.I_method_b78fcf09(var3.offset(var1, -0.05, 0.0))
            || !this.I_method_b78fcf09(var3.offset(-var1, -0.05, 0.0))
            || !this.I_method_b78fcf09(var3.offset(0.0, -0.05, var1))
            || !this.I_method_b78fcf09(var3.offset(0.0, -0.05, -var1));
      } else {
         return false;
      }
   }

   private boolean I_method_82d70280(ScaffoldModule.Nested1_81997c60 var1, double var2) {
      Vec3d var4 = var1.I_method_6b0df0a0(I_field_3a9bda27.player.getYaw());
      if (var4.lengthSquared() < 1.0E-6) {
         return this.I_method_f52505e3(var2);
      } else {
         Box var5 = I_field_3a9bda27.player.getBoundingBox().offset(var4.x * var2, -0.05, var4.z * var2);
         return !this.I_method_b78fcf09(var5);
      }
   }

   private boolean I_method_b78fcf09(Box var1) {
      double var2 = I_field_3a9bda27.player.getWidth() / 6.0;
      double var4 = (var1.minX + var1.maxX) * 0.5;
      double var6 = (var1.minZ + var1.maxZ) * 0.5;
      return this.I_method_af7c1643(var1.minX + var2, var1.minZ + var2)
         || this.I_method_af7c1643(var4, var1.minZ + var2)
         || this.I_method_af7c1643(var1.maxX - var2, var1.minZ + var2)
         || this.I_method_af7c1643(var1.minX + var2, var6)
         || this.I_method_af7c1643(var4, var6)
         || this.I_method_af7c1643(var1.maxX - var2, var6)
         || this.I_method_af7c1643(var1.minX + var2, var1.maxZ - var2)
         || this.I_method_af7c1643(var4, var1.maxZ - var2)
         || this.I_method_af7c1643(var1.maxX - var2, var1.maxZ - var2);
   }

   private boolean I_method_af7c1643(double var1, double var3) {
      BlockPos var5 = BlockPos.ofFloored(var1, I_field_3a9bda27.player.getBoundingBox().minY - 0.001, var3);
      BlockState var6 = I_field_3a9bda27.world.getBlockState(var5);
      return !var6.isAir() && !var6.getCollisionShape(I_field_3a9bda27.world, var5).isEmpty();
   }

   private void I_method_f52505df(double var1) {
      if (I_field_3a9bda27.player != null) {
         double var3 = I_field_3a9bda27.player.input.movementForward;
         double var5 = I_field_3a9bda27.player.input.movementSideways;
         float var7 = I_field_3a9bda27.player.getYaw();
         if (var3 != 0.0 || var5 != 0.0) {
            if (var3 != 0.0) {
               if (var5 > 0.0) {
                  var7 += var3 > 0.0 ? -45.0F : 45.0F;
               } else if (var5 < 0.0) {
                  var7 += var3 > 0.0 ? 45.0F : -45.0F;
               }

               var5 = 0.0;
               var3 = var3 > 0.0 ? 1.0 : -1.0;
            }

            double var8 = Math.sin(Math.toRadians(var7 + 90.0));
            double var10 = Math.cos(Math.toRadians(var7 + 90.0));
            double var12 = var3 * var1 * var10 + var5 * var1 * var8;
            double var14 = var3 * var1 * var8 - var5 * var1 * var10;
            I_field_3a9bda27.player.setVelocity(var12, I_field_3a9bda27.player.getVelocity().y, var14);
         }
      }
   }

   private boolean IIIi_method_78addc86() {
      return I_field_3a9bda27.player != null
         && (I_field_3a9bda27.player.input.movementForward != 0.0F || I_field_3a9bda27.player.input.movementSideways != 0.0F);
   }

   double i_method_a4de2e0d() {
      Vec3d var1 = I_field_3a9bda27.player.getVelocity();
      return Math.hypot(var1.x, var1.z);
   }

   private float I_method_56cd1df2(ScaffoldModule.Nested1_81997c60 var1) {
      double var2 = var1.I_method_d56f434a();
      double var4 = var1.i_method_d57dcf2a();
      return var2 == 0.0 && var4 == 0.0
         ? I_field_3a9bda27.player.getYaw()
         : MathHelper.wrapDegrees((float)Math.toDegrees(IiiiiiiII_Class253.I_method_2edb44cf(I_field_3a9bda27.player.getYaw(), var2, var4)));
   }

   private ScaffoldModule.Nested1_81997c60 I_method_d543c306(Vec3d var1, float var2) {
      if (var1.lengthSquared() < 1.0E-6) {
         return ScaffoldModule.Nested1_81997c60.I_field_f54de627;
      } else {
         double var3 = Math.toRadians(var2);
         double var5 = Math.sin(var3);
         double var7 = Math.cos(var3);
         double var9 = var1.x;
         double var11 = var1.z;
         double var13 = var11 * var7 - var9 * var5;
         double var15 = var9 * var7 + var11 * var5;
         double var17 = Math.max(Math.abs(var13), Math.abs(var15));
         if (var17 > 1.0) {
            var13 /= var17;
            var15 /= var17;
         }

         return ScaffoldModule.Nested1_81997c60.I_method_5f4e84ab((float)var13, (float)var15);
      }
   }

   private Vec3d i_method_1562ed3b(float var1) {
      double var2 = Math.toRadians(var1);
      return new Vec3d(-Math.sin(var2), 0.0, Math.cos(var2)).normalize();
   }

   private Direction I_method_13f5b781(float var1) {
      int var2 = MathHelper.floor(MathHelper.wrapDegrees(var1) / 90.0F + 0.5) & 3;

      return switch (var2) {
         case 0 -> Direction.SOUTH;
         case 1 -> Direction.WEST;
         case 2 -> Direction.NORTH;
         default -> Direction.EAST;
      };
   }

   private float I_method_f5250d51(float var1) {
      return Math.round(var1 / 45.0F) * 45.0F;
   }

   private void II_method_b1407641(int var1) {
      if (var1 >= 0 && var1 < 9 && I_field_3a9bda27.player.getInventory().selectedSlot != var1) {
         I_field_3a9bda27.player.getInventory().selectedSlot = var1;
      }
   }

   private long I_method_a4cfa233() {
      return this.I_method_29b8249a(this.I_field_bbe3b68c) * 50L;
   }

   private int I_method_29b8249a(RangeSetting var1) {
      int var2 = Math.round(Math.min(var1.i_method_e92b420f(), var1.II_method_3a8908f2()));
      int var3 = Math.round(Math.max(var1.i_method_e92b420f(), var1.II_method_3a8908f2()));
      return var3 <= var2 ? var2 : ThreadLocalRandom.current().nextInt(var2, var3 + 1);
   }

   private float I_method_29b82497(RangeSetting var1) {
      float var2 = Math.min(var1.i_method_e92b420f(), var1.II_method_3a8908f2());
      float var3 = Math.max(var1.i_method_e92b420f(), var1.II_method_3a8908f2());
      return var3 <= var2 ? var2 : (float)this.I_method_af7c162d(var2, var3);
   }

   private double I_method_af7c162d(double var1, double var3) {
      return ThreadLocalRandom.current().nextDouble(var1, var3);
   }

   private Vec3d I_method_80895299(Vec3d var1, Vec3d var2, double var3) {
      return new Vec3d(MathHelper.lerp(var3, var1.x, var2.x), MathHelper.lerp(var3, var1.y, var2.y), MathHelper.lerp(var3, var1.z, var2.z));
   }

   private Vec3d I_method_15ac2e6f(Vec3d var1, float var2) {
      double var3 = Math.cos(var2);
      double var5 = Math.sin(var2);
      return new Vec3d(var1.x * var3 + var1.z * var5, var1.y, var1.z * var3 - var1.x * var5);
   }

   private Vec3d I_method_799defb3(BlockPos var1) {
      return new Vec3d(var1.getX() + 0.5, var1.getY() + 0.5, var1.getZ() + 0.5);
   }

   private Vec3d i_method_75d7b93(BlockPos var1) {
      return new Vec3d(var1.getX() + 0.5, var1.getY(), var1.getZ() + 0.5);
   }

   private double I_method_d6a67cad(Vec3d var1, Vec3d var2) {
      double var3 = var1.x - var2.x;
      double var5 = var1.z - var2.z;
      return var3 * var3 + var5 * var5;
   }

   static final class Nested1_812b7560 implements Comparable<ScaffoldModule.Nested1_812b7560> {
      private final BlockPos I_field_670402ba;
      private final double I_field_44;
      private final double i_field_44;
      private final double II_field_44;

      Nested1_812b7560(BlockPos var1, double var2, double var4, double var6) {
         this.I_field_670402ba = var1;
         this.I_field_44 = var2;
         this.i_field_44 = var4;
         this.II_field_44 = var6;
      }

      @Override
      public int compareTo(ScaffoldModule.Nested1_812b7560 var1) {
         if (this.i_field_44 + 0.001 < var1.i_field_44) {
            return -1;
         } else if (var1.i_field_44 + 0.001 < this.i_field_44) {
            return 1;
         } else if (this.I_field_44 > var1.I_field_44 + 0.02) {
            return -1;
         } else {
            return this.I_field_44 + 0.02 < var1.I_field_44 ? 1 : Double.compare(this.II_field_44, var1.II_field_44);
         }
      }

      boolean I_method_5ac27b0b(ScaffoldModule.Nested1_812b7560 var1) {
         return this.i_field_44 > var1.i_field_44 + 0.001 ? false : this.I_field_44 + 0.02 >= var1.I_field_44;
      }

      @Override
      public final String toString() {
         return "Nested1_812b7560[blockPos=" + this.I_field_670402ba + ", overlapArea=" + this.I_field_44 + ", surfaceDelta=" + this.i_field_44 + ", horizontalDistanceToPlayerSqr=" + this.II_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_670402ba);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         ScaffoldModule.Nested1_812b7560 other = (ScaffoldModule.Nested1_812b7560) var1;
         return java.util.Objects.equals(this.I_field_670402ba, other.I_field_670402ba)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44)
            && java.util.Objects.equals(this.i_field_44, other.i_field_44)
            && java.util.Objects.equals(this.II_field_44, other.II_field_44);
      }

      public BlockPos I_method_3b976936() {
         return this.I_field_670402ba;
      }

      public double I_method_cf30ea48() {
         return this.I_field_44;
      }

      public double i_method_cf3f7628() {
         return this.i_field_44;
      }

      public double II_method_16fb5835() {
         return this.II_field_44;
      }
   }

   static final class Nested1_812b7580 {
      private final BlockPos I_field_670402ba;
      private final double I_field_44;
      private final double i_field_44;

      Nested1_812b7580(BlockPos var1, double var2, double var4) {
         this.I_field_670402ba = var1;
         this.I_field_44 = var2;
         this.i_field_44 = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_812b7580[blockPos=" + this.I_field_670402ba + ", offsetX=" + this.I_field_44 + ", offsetZ=" + this.i_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_670402ba);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         ScaffoldModule.Nested1_812b7580 other = (ScaffoldModule.Nested1_812b7580) var1;
         return java.util.Objects.equals(this.I_field_670402ba, other.I_field_670402ba)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44)
            && java.util.Objects.equals(this.i_field_44, other.i_field_44);
      }

      public BlockPos I_method_5bb65156() {
         return this.I_field_670402ba;
      }

      public double I_method_5cbfe28() {
         return this.I_field_44;
      }

      public double i_method_5da8a08() {
         return this.i_field_44;
      }
   }

   static final class Nested1_81997c40 {
      private final Hand I_field_19fedc5f;
      private final int I_field_49;
      private final ItemStack I_field_f2735522;

      Nested1_81997c40(Hand var1, int var2, ItemStack var3) {
         this.I_field_19fedc5f = var1;
         this.I_field_49 = var2;
         this.I_field_f2735522 = var3;
      }

      boolean I_method_9ed42f7e() {
         return this.I_field_19fedc5f == Hand.MAIN_HAND && this.I_field_49 >= 0;
      }

      @Override
      public final String toString() {
         return "Nested1_81997c40[hand=" + this.I_field_19fedc5f + ", hotbarSlot=" + this.I_field_49 + ", stack=" + this.I_field_f2735522 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_19fedc5f);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f2735522);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         ScaffoldModule.Nested1_81997c40 other = (ScaffoldModule.Nested1_81997c40) var1;
         return java.util.Objects.equals(this.I_field_19fedc5f, other.I_field_19fedc5f)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_f2735522, other.I_field_f2735522);
      }

      public Hand I_method_f1c0df83() {
         return this.I_field_19fedc5f;
      }

      public int I_method_9ed42f6d() {
         return this.I_field_49;
      }

      public ItemStack I_method_ffe9a87e() {
         return this.I_field_f2735522;
      }
   }

   static final class Nested1_81997c60 {
      private final boolean I_field_5a;
      private final boolean i_field_5a;
      private final boolean II_field_5a;
      private final boolean Ii_field_5a;
      static final ScaffoldModule.Nested1_81997c60 I_field_f54de627 = new ScaffoldModule.Nested1_81997c60(false, false, false, false);

      private Nested1_81997c60(boolean var1, boolean var2, boolean var3, boolean var4) {
         this.I_field_5a = var1;
         this.i_field_5a = var2;
         this.II_field_5a = var3;
         this.Ii_field_5a = var4;
      }

      static ScaffoldModule.Nested1_81997c60 I_method_c344e94f(InputEvent var0) {
         return I_method_5f4e84ab(var0.getForward(), var0.getStrafe());
      }

      static ScaffoldModule.Nested1_81997c60 I_method_5f4e84ab(float var0, float var1) {
         return new ScaffoldModule.Nested1_81997c60(var0 > 0.0F, var0 < 0.0F, var1 > 0.0F, var1 < 0.0F);
      }

      boolean iI_method_da4b0f6b() {
         return this.I_field_5a || this.i_field_5a || this.II_field_5a || this.Ii_field_5a;
      }

      float I_method_d56f434a() {
         if (this.I_field_5a == this.i_field_5a) {
            return 0.0F;
         } else {
            return this.I_field_5a ? 1.0F : -1.0F;
         }
      }

      float i_method_d57dcf2a() {
         if (this.II_field_5a == this.Ii_field_5a) {
            return 0.0F;
         } else {
            return this.II_field_5a ? 1.0F : -1.0F;
         }
      }

      Vec3d I_method_6b0df0a0(float var1) {
         double var2 = this.I_method_d56f434a();
         double var4 = this.i_method_d57dcf2a();
         double var6 = Math.sqrt(var2 * var2 + var4 * var4);
         if (var6 < 1.0E-6) {
            return Vec3d.ZERO;
         } else {
            double var8 = Math.toRadians(var1);
            double var10 = Math.sin(var8);
            double var12 = Math.cos(var8);
            double var14 = (var4 * var12 - var2 * var10) / var6;
            double var16 = (var2 * var12 + var4 * var10) / var6;
            return new Vec3d(var14, 0.0, var16);
         }
      }

      @Override
      public final String toString() {
         return "Nested1_81997c60[forward=" + this.I_field_5a + ", backward=" + this.i_field_5a + ", left=" + this.II_field_5a + ", right=" + this.Ii_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.Ii_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         ScaffoldModule.Nested1_81997c60 other = (ScaffoldModule.Nested1_81997c60) var1;
         return java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.i_field_5a, other.i_field_5a)
            && java.util.Objects.equals(this.II_field_5a, other.II_field_5a)
            && java.util.Objects.equals(this.Ii_field_5a, other.Ii_field_5a);
      }

      public boolean I_method_d56f435e() {
         return this.I_field_5a;
      }

      public boolean i_method_d57dcf3e() {
         return this.i_field_5a;
      }

      public boolean II_method_d8881f4b() {
         return this.II_field_5a;
      }

      public boolean Ii_method_d896ab2b() {
         return this.Ii_field_5a;
      }
   }

   static final class Nested1_b1960c09 {
      private final boolean I_field_5a;
      private final int I_field_49;
      private final boolean i_field_5a;
      private final boolean II_field_5a;
      static final ScaffoldModule.Nested1_b1960c09 I_field_b46e6886 = new ScaffoldModule.Nested1_b1960c09(false, 0, false, false);

      Nested1_b1960c09(boolean var1, int var2, boolean var3, boolean var4) {
         this.I_field_5a = var1;
         this.I_field_49 = var2;
         this.i_field_5a = var3;
         this.II_field_5a = var4;
      }

      @Override
      public final String toString() {
         return "Nested1_b1960c09[jump=" + this.I_field_5a + ", sneakTime=" + this.I_field_49 + ", stopInput=" + this.i_field_5a + ", stepBack=" + this.II_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         ScaffoldModule.Nested1_b1960c09 other = (ScaffoldModule.Nested1_b1960c09) var1;
         return java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.i_field_5a, other.i_field_5a)
            && java.util.Objects.equals(this.II_field_5a, other.II_field_5a);
      }

      public boolean I_method_68571555() {
         return this.I_field_5a;
      }

      public int I_method_68571544() {
         return this.I_field_49;
      }

      public boolean i_method_6865a135() {
         return this.i_field_5a;
      }

      public boolean II_method_a29a8c34() {
         return this.II_field_5a;
      }
   }

   static final class Nested1_b1960c29 {
      private final Vec3d I_field_5bba0d50;
      private final Vec3d i_field_5bba0d50;

      Nested1_b1960c29(Vec3d var1, Vec3d var2) {
         var2 = var2.lengthSquared() < 1.0E-6 ? new Vec3d(0.0, 0.0, 1.0) : var2.normalize();
         this.I_field_5bba0d50 = var1;
         this.i_field_5bba0d50 = var2;
      }

      Vec3d I_method_9e513bf3(Vec3d var1) {
         Vec3d var2 = var1.subtract(this.I_field_5bba0d50);
         return this.I_field_5bba0d50.add(this.i_field_5bba0d50.multiply(var2.dotProduct(this.i_field_5bba0d50)));
      }

      double I_method_3bee5e27(Vec3d var1) {
         return this.I_method_9e513bf3(var1).distanceTo(var1);
      }

      @Override
      public final String toString() {
         return "Nested1_b1960c29[origin=" + this.I_field_5bba0d50 + ", direction=" + this.i_field_5bba0d50 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_5bba0d50);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         ScaffoldModule.Nested1_b1960c29 other = (ScaffoldModule.Nested1_b1960c29) var1;
         return java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
            && java.util.Objects.equals(this.i_field_5bba0d50, other.i_field_5bba0d50);
      }

      public Vec3d I_method_99984eb() {
         return this.I_field_5bba0d50;
      }

      public Vec3d i_method_ad9208cb() {
         return this.i_field_5bba0d50;
      }
   }

   static enum Nested1_b1960fe9 {
      I_field_b46ee0a6,
      i_field_b46ee0a6,
      II_field_b46ee0a6;
   }

   static final class Nested1_b1961009 {
      private final BlockPos I_field_670402ba;
      private final BlockPos i_field_670402ba;
      private final Direction I_field_3b03ad36;
      private final Vec3d I_field_5bba0d50;
      private final iiIIiIIii_Class404 I_field_32e13e6c;
      private final boolean I_field_5a;

      Nested1_b1961009(BlockPos var1, BlockPos var2, Direction var3, Vec3d var4, iiIIiIIii_Class404 var5, boolean var6) {
         this.I_field_670402ba = var1;
         this.i_field_670402ba = var2;
         this.I_field_3b03ad36 = var3;
         this.I_field_5bba0d50 = var4;
         this.I_field_32e13e6c = var5;
         this.I_field_5a = var6;
      }

      ScaffoldModule.Nested1_b1961009 I_method_2a7e9b07(iiIIiIIii_Class404 var1) {
         return new ScaffoldModule.Nested1_b1961009(
            this.I_field_670402ba, this.i_field_670402ba, this.I_field_3b03ad36, this.I_field_5bba0d50, var1, this.I_field_5a
         );
      }

      ScaffoldModule.Nested1_b1961009 I_method_41cd1859(boolean var1) {
         return new ScaffoldModule.Nested1_b1961009(
            this.I_field_670402ba, this.i_field_670402ba, this.I_field_3b03ad36, this.I_field_5bba0d50, this.I_field_32e13e6c, var1
         );
      }

      BlockHitResult I_method_99edc8ca() {
         return new BlockHitResult(this.I_field_5bba0d50, this.I_field_3b03ad36, this.i_field_670402ba, false);
      }

      @Override
      public final String toString() {
         return "Nested1_b1961009[placedBlock=" + this.I_field_670402ba + ", supportBlock=" + this.i_field_670402ba + ", side=" + this.I_field_3b03ad36 + ", hitVec=" + this.I_field_5bba0d50 + ", rotation=" + this.I_field_32e13e6c + ", allowFallbackHit=" + this.I_field_5a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_670402ba);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_670402ba);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_3b03ad36);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_32e13e6c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         ScaffoldModule.Nested1_b1961009 other = (ScaffoldModule.Nested1_b1961009) var1;
         return java.util.Objects.equals(this.I_field_670402ba, other.I_field_670402ba)
            && java.util.Objects.equals(this.i_field_670402ba, other.i_field_670402ba)
            && java.util.Objects.equals(this.I_field_3b03ad36, other.I_field_3b03ad36)
            && java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
            && java.util.Objects.equals(this.I_field_32e13e6c, other.I_field_32e13e6c)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a);
      }

      public BlockPos I_method_12e1bd1f() {
         return this.I_field_670402ba;
      }

      public BlockPos i_method_87dc2d3f() {
         return this.i_field_670402ba;
      }

      public Direction I_method_add3f71() {
         return this.I_field_3b03ad36;
      }

      public Vec3d I_method_7e93f50b() {
         return this.I_field_5bba0d50;
      }

      public iiIIiIIii_Class404 I_method_95423ba7() {
         return this.I_field_32e13e6c;
      }

      public boolean I_method_3bb99155() {
         return this.I_field_5a;
      }
   }
}
