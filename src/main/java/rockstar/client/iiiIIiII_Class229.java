package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.RaycastContext.ShapeType;

public enum iiiIIiII_Class229 {
   I_field_62e8b781,
   i_field_62e8b781,
   II_field_62e8b781,
   Ii_field_62e8b781,
   iI_field_62e8b781;

   public boolean I_method_3b59c27(BlockView var1, BlockPos var2, BlockState var3) {
      return switch (this) {
         case I_field_62e8b781 -> false;
         case i_field_62e8b781, iI_field_62e8b781 -> true;
         case II_field_62e8b781 -> var3.getBlock() instanceof DoorBlock || var3.getBlock() instanceof TrapdoorBlock;
         case Ii_field_62e8b781 -> !var3.isFullCube(var1, var2);
      };
   }

   public ShapeType I_method_ff544d6b() {
      return this == II_field_62e8b781 ? ShapeType.OUTLINE : ShapeType.COLLIDER;
   }

   public boolean I_method_94f6b4d0() {
      return this == i_field_62e8b781 || this == iI_field_62e8b781;
   }
}
