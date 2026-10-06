package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.EmptyBlockView;

public class IIIIiIIi_Class10 implements IIIIiIII_Class9 {
   private IIIIiIIi_Class10.Nested1_1d1438d3 I_field_38111fc;
   private BlockPos I_field_670402ba;
   private Direction I_field_3b03ad36;
   private long I_field_4a;
   private int I_field_49;
   private int i_field_49;
   private boolean I_field_5a;
   private boolean i_field_5a;
   private int II_field_49;

   public IIIIiIIi_Class10() {
      this.I_field_38111fc = IIIIiIIi_Class10.Nested1_1d1438d3.I_field_38111fc;
      this.I_field_3b03ad36 = Direction.UP;
      this.II_field_49 = -1;
   }

   @Override
   public void I_method_f2de637a(iiiiiii_Class128 var1) {
      if (var1 != null) {
         switch (this.I_field_38111fc) {
            case I_field_38111fc:
               this.i_method_9ced039a(var1);
               break;
            case i_field_38111fc:
               this.II_method_c6706851(var1);
               break;
            case II_field_38111fc:
               this.Ii_method_f06cf871(var1);
               break;
            case Ii_field_38111fc:
               this.iI_method_dc05dc31(var1);
               break;
            case iI_field_38111fc:
               this.ii_method_6026c51(var1);
         }
      }
   }

   private void i_method_9ced039a(iiiiiii_Class128 var1) {
      iiiiiii_Class128.Nested1_ec28200 var2 = this.I_method_ee7bc5ab(var1);
      if (var2 == null) {
         this.I_method_f4ce38cc();
         var1.Iii_method_c77508df();
      } else {
         this.I_field_670402ba = var2.I_method_a5de6273().getBlockPos().toImmutable();
         this.I_field_3b03ad36 = var2.I_method_a5de6273().getSide();
         this.III_method_e2ef0e5a(var1);
         if (this.I_method_72f0737e(var1)) {
            this.I_field_49 = 0;
            if (!this.i_field_5a) {
               this.I_field_38111fc = IIIIiIIi_Class10.Nested1_1d1438d3.i_field_38111fc;
               this.i_field_49 = 0;
               this.I_field_5a = false;
            } else {
               this.I_field_38111fc = IIIIiIIi_Class10.Nested1_1d1438d3.II_field_38111fc;
            }
         }
      }
   }

   private void II_method_c6706851(iiiiiii_Class128 var1) {
      if (this.I_field_670402ba != null && this.I_method_a37ce478(var1, this.I_field_670402ba)) {
         this.III_method_e2ef0e5a(var1);
         if (this.I_method_72f0737e(var1)) {
            Direction var2 = this.I_field_3b03ad36 == null ? var1.I_method_1de0a859(this.I_field_670402ba) : this.I_field_3b03ad36;
            if (!this.I_field_5a) {
               var1.I_method_dbaec697(this.I_field_670402ba, var2);
               this.I_field_5a = true;
               this.i_field_49 = 0;
            } else {
               this.i_field_49++;
               if (this.i_field_49 >= Math.max(1, var1.I_method_e08ecf78().III_method_e7f9a9df())) {
                  var1.i_method_bd2ba6b7(this.I_field_670402ba, var2);
                  this.i_field_5a = true;
                  this.I_field_5a = false;
                  this.i_field_49 = 0;
                  this.I_field_38111fc = IIIIiIIi_Class10.Nested1_1d1438d3.II_field_38111fc;
               }
            }
         }
      } else {
         this.I_field_38111fc = IIIIiIIi_Class10.Nested1_1d1438d3.I_field_38111fc;
         this.I_field_5a = false;
      }
   }

   private void Ii_method_f06cf871(iiiiiii_Class128 var1) {
      if (++this.I_field_49 >= Math.max(1, var1.I_method_e08ecf78().Ii_method_180ddbe8())) {
         this.II_field_49 = var1.I_method_1729e358().I_method_abc2e8e6("\u0413\u0420\u0418\u0424", "GRIEF");
         if (this.II_field_49 > 0) {
            var1.I_method_98066c89("/sellwood");
            this.I_field_38111fc = IIIIiIIi_Class10.Nested1_1d1438d3.Ii_field_38111fc;
            this.I_field_49 = 0;
            return;
         }

         this.I_field_49 = 0;
      }

      iiiiiii_Class128.Nested1_ec28200 var2 = this.I_method_ee7bc5ab(var1);
      if (var2 != null) {
         this.I_field_670402ba = var2.I_method_a5de6273().getBlockPos().toImmutable();
         this.I_field_3b03ad36 = var2.I_method_a5de6273().getSide();
      }

      if (this.I_field_670402ba != null && this.I_method_a37ce478(var1, this.I_field_670402ba)) {
         this.III_method_e2ef0e5a(var1);
         if (this.I_method_72f0737e(var1)) {
            long var3 = System.currentTimeMillis();
            if (var3 - this.I_field_4a >= var1.I_method_e08ecf78().ii_method_19d0cc09()) {
               Direction var5 = this.I_field_3b03ad36 == null ? var1.I_method_1de0a859(this.I_field_670402ba) : this.I_field_3b03ad36;
               var1.i_method_b1654e4a(new BlockHitResult(this.I_field_670402ba.toCenterPos(), var5, this.I_field_670402ba, false));
               this.I_field_4a = var3;
            }
         }
      } else {
         this.I_field_38111fc = IIIIiIIi_Class10.Nested1_1d1438d3.I_field_38111fc;
      }
   }

   private void iI_method_dc05dc31(iiiiiii_Class128 var1) {
      var1.Iii_method_c77508df();
      if (++this.I_field_49 >= Math.max(1, var1.I_method_e08ecf78().iI_method_19c24028())) {
         var1.I_method_98066c89("/hub");
         this.I_field_38111fc = IIIIiIIi_Class10.Nested1_1d1438d3.iI_field_38111fc;
         this.I_field_49 = 0;
      }
   }

   private void ii_method_6026c51(iiiiiii_Class128 var1) {
      var1.Iii_method_c77508df();
      if (++this.I_field_49 >= Math.max(1, var1.I_method_e08ecf78().iI_method_19c24028())) {
         var1.I_method_b8ab1d60(new IIIIiIiI_Class11(this.II_field_49));
      }
   }

   private iiiiiii_Class128.Nested1_ec28200 I_method_ee7bc5ab(iiiiiii_Class128 var1) {
      iiiiiii_Class128.Nested1_ec28200 var2 = var1.I_method_4a21e990(var1.I_method_e08ecf78().iii_method_206639ba());
      return var2 != null && this.I_method_a37ce478(var1, var2.I_method_a5de6273().getBlockPos()) ? var2 : null;
   }

   private boolean I_method_a37ce478(iiiiiii_Class128 var1, BlockPos var2) {
      if (var2 != null && (var1.I_method_1729e358().I_method_747b892a(var2) || var1.I_method_1729e358().i_method_9ecf1d0a(var2))) {
         BlockState var3 = var1.I_method_1729e358().I_method_27bc425(var2);
         return var3.isAir() || var3.getHardness(EmptyBlockView.INSTANCE, var2) < 0.0F
            ? false
            : !var1.I_method_e08ecf78().I_method_907c0d0() || this.I_method_26fefa85(var3);
      } else {
         return false;
      }
   }

   private boolean I_method_26fefa85(BlockState var1) {
      Identifier var2 = Registries.BLOCK.getId(var1.getBlock());
      if (var2 == null) {
         return false;
      } else {
         String var3 = var2.toString();
         return var3.contains("_log")
            || var3.contains("_wood")
            || var3.equals("minecraft:crimson_stem")
            || var3.equals("minecraft:warped_stem")
            || var3.equals("minecraft:stripped_crimson_stem")
            || var3.equals("minecraft:stripped_warped_stem");
      }
   }

   private void III_method_e2ef0e5a(iiiiiii_Class128 var1) {
      if (this.I_field_670402ba != null) {
         Vec3d var2 = this.I_field_670402ba.toCenterPos();
         var1.I_method_b644c79f(var2.x, var2.y, var2.z);
         var1.Iii_method_c77508df();
      }
   }

   private boolean I_method_72f0737e(iiiiiii_Class128 var1) {
      return this.I_field_670402ba != null && var1.I_method_331eac77(this.I_field_670402ba.toCenterPos(), var1.I_method_e08ecf78().IiIi_method_4df42aa3());
   }

   private void I_method_f4ce38cc() {
      this.I_field_670402ba = null;
      this.I_field_3b03ad36 = Direction.UP;
   }

   @Override
   public String I_method_dcc0dd54() {
      return this.I_field_670402ba == null
         ? "CyclicRebreak " + this.I_field_38111fc
         : "CyclicRebreak "
            + this.I_field_38111fc
            + " "
            + this.I_field_670402ba.getX()
            + " "
            + this.I_field_670402ba.getY()
            + " "
            + this.I_field_670402ba.getZ();
   }

   static enum Nested1_1d1438d3 {
      I_field_38111fc,
      i_field_38111fc,
      II_field_38111fc,
      Ii_field_38111fc,
      iI_field_38111fc;
   }
}
