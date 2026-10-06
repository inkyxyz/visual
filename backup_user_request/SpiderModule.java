package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Items;
import net.minecraft.util.Hand;
import net.minecraft.util.function.BooleanBiFunction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.player.EventMotion;
import pyrock.events.player.InputEvent;
import rockstar.client.ModeSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiiiIi_Class318;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Spider", category=ModuleCategory.MOVEMENT, III_method_a89e5834="modules.descriptions.spider")
public class SpiderModule
extends Module {
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
    private int I_field_49 = -1;
    private int i_field_49 = -1;
    private int II_field_49 = -1;
    private int Ii_field_49 = -1;
    private Hand I_field_19fedc5f = Hand.MAIN_HAND;
    private boolean I_field_5a;
    private boolean i_field_5a;
    private final IiIIIiII_Class69<EventMotion> I_field_3d936f41 = eventMotion -> {
        if (this.i_field_500d0627.isSelected()) {
            if (!SpiderModule.I_field_3a9bda27.player.horizontalCollision || !this.iII_method_5cf0f990()) {
                return;
            }
            eventMotion.setGround(true);
            SpiderModule.I_field_3a9bda27.player.setOnGround(true);
        }
    };
    private final IiIIIiII_Class69<ClientPlayerTickEvent> i_field_3d936f41 = clientPlayerTickEvent -> {
        if (SpiderModule.I_field_3a9bda27.player == null || SpiderModule.I_field_3a9bda27.world == null) {
            return;
        }
        if (!this.II_field_500d0627.isSelected() && this.I_field_5a) {
            this.Iii_method_282761ac();
        }
        if (!this.Ii_field_500d0627.isSelected() && this.i_field_5a) {
            this.iII_method_5cf0f98c();
        }
        if (this.I_field_500d0627.isSelected()) {
            if (!SpiderModule.I_field_3a9bda27.player.horizontalCollision) {
                return;
            }
            SpiderModule.I_field_3a9bda27.player.prevY -= 2.0E-232;
            if (SpiderModule.I_field_3a9bda27.player.isOnGround()) {
                SpiderModule.I_field_3a9bda27.player.setVelocity(SpiderModule.I_field_3a9bda27.player.getVelocity().getX(), 0.42, SpiderModule.I_field_3a9bda27.player.getVelocity().getZ());
            }
        } else if (this.i_field_500d0627.isSelected()) {
            if (!SpiderModule.I_field_3a9bda27.player.horizontalCollision || !this.iII_method_5cf0f990()) {
                return;
            }
            SpiderModule.I_field_3a9bda27.player.prevY -= 2.0E-232;
            if (SpiderModule.I_field_3a9bda27.player.isOnGround()) {
                SpiderModule.I_field_3a9bda27.player.setVelocity(SpiderModule.I_field_3a9bda27.player.getVelocity().getX(), 0.42, SpiderModule.I_field_3a9bda27.player.getVelocity().getZ());
            }
        } else if (this.II_field_500d0627.isSelected()) {
            if (!this.I_field_5a && !this.IiI_method_2818d5d0()) {
                return;
            }
            if (!SpiderModule.I_field_3a9bda27.player.horizontalCollision) {
                return;
            }
            if (this.i_field_49 >= 0 && this.i_field_49 <= 8) {
                SpiderModule.I_field_3a9bda27.player.getInventory().selectedSlot = this.i_field_49;
            }
            SpiderModule.I_field_3a9bda27.player.setPitch(75.0f);
            if (SpiderModule.I_field_3a9bda27.player.age % 3 == 0) {
                I_field_3a9bda27.doItemUse();
            }
        } else if (this.Ii_field_500d0627.isSelected()) {
            if (!this.i_field_5a && !this.Iii_method_282761b0()) {
                return;
            }
            if (this.I_field_19fedc5f == Hand.MAIN_HAND && this.Ii_field_49 >= 0 && this.Ii_field_49 <= 8) {
                SpiderModule.I_field_3a9bda27.player.getInventory().selectedSlot = this.Ii_field_49;
            }
            if (SpiderModule.I_field_3a9bda27.player.horizontalCollision) {
                RockstarClient.getInstance().I_method_58785402().I_method_1acbf705(new iiIIiIIii_Class404((double)SpiderModule.I_field_3a9bda27.player.getYaw(), 78.5), iiIIiIIIi_Class402.i_field_32e0c64c, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.iI_field_32efc66c);
                SpiderModule.I_field_3a9bda27.interactionManager.interactItem((PlayerEntity)SpiderModule.I_field_3a9bda27.player, this.I_field_19fedc5f);
                I_field_3a9bda27.doItemUse();
            }
        }
    };
    private final IiIIIiII_Class69<InputEvent> II_field_3d936f41 = inputEvent -> {
        if (SpiderModule.I_field_3a9bda27.player == null) {
            return;
        }
        if (this.II_field_500d0627.isSelected() && SpiderModule.I_field_3a9bda27.player.horizontalCollision) {
            inputEvent.setJump(true);
            return;
        }
        if (this.Ii_field_500d0627.isSelected() && SpiderModule.I_field_3a9bda27.player.horizontalCollision) {
            inputEvent.setJump(true);
        }
    };

    public SpiderModule() {
        this.IiI_method_2818d5cc();
    }

    @Compile(obfuscation=4)
    private void IiI_method_2818d5cc() {
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.spider.mode");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.flight.vanilla");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "FunTime");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.spider.mode.water");
        this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.spider.mode.sphere");
    }

    @Override
    public void onEnable() {
        if (SpiderModule.I_field_3a9bda27.player == null) {
            return;
        }
        if (this.II_field_500d0627.isSelected()) {
            this.IiI_method_2818d5d0();
        } else if (this.Ii_field_500d0627.isSelected()) {
            this.Iii_method_282761b0();
        }
    }

    @Override
    public void onDisable() {
        this.Iii_method_282761ac();
        this.iII_method_5cf0f98c();
        this.I_field_49 = -1;
        this.i_field_49 = -1;
        this.II_field_49 = -1;
        this.Ii_field_49 = -1;
        this.I_field_19fedc5f = Hand.MAIN_HAND;
        this.I_field_5a = false;
        this.i_field_5a = false;
        SpiderModule.I_field_3a9bda27.options.useKey.setPressed(false);
    }

    private boolean IiI_method_2818d5d0() {
        if (this.I_field_5a) {
            return true;
        }
        if (SpiderModule.I_field_3a9bda27.player == null) {
            return false;
        }
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695());
        iIIiIiIii_Class300 iIIiIiIii_Class3002 = iIIiiIiII_Class3092.I_method_5d34dd7d(Items.WATER_BUCKET);
        if (iIIiIiIii_Class3002 == null || iIIiIiIii_Class3002.I_method_dfe89263()) {
            this.setEnabled(false, true);
            return false;
        }
        this.i_field_49 = SpiderModule.I_field_3a9bda27.player.getInventory().selectedSlot;
        if (this.i_field_49 < 0 || this.i_field_49 > 8) {
            SpiderModule.I_field_3a9bda27.player.getInventory().selectedSlot = this.i_field_49 = 0;
        }
        this.I_field_49 = iIIiIiIii_Class3002.I_method_dfe89252();
        iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_49, this.i_field_49);
        this.I_field_5a = true;
        return true;
    }

    private void Iii_method_282761ac() {
        if (!this.I_field_5a) {
            this.I_field_49 = -1;
            this.i_field_49 = -1;
            return;
        }
        if (SpiderModule.I_field_3a9bda27.player != null && this.I_field_49 != -1 && this.i_field_49 >= 0 && this.i_field_49 <= 8) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_49, this.i_field_49);
            SpiderModule.I_field_3a9bda27.player.getInventory().selectedSlot = this.i_field_49;
        }
        this.I_field_49 = -1;
        this.i_field_49 = -1;
        this.I_field_5a = false;
    }

    private boolean Iii_method_282761b0() {
        if (this.i_field_5a) {
            return true;
        }
        if (SpiderModule.I_field_3a9bda27.player == null) {
            return false;
        }
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.Ii_method_1c02fc38().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75()).I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695());
        iIIiIiIii_Class300 iIIiIiIii_Class3002 = iIIiiIiII_Class3092.I_method_5d34dd7d(Items.PLAYER_HEAD);
        if (iIIiIiIii_Class3002 == null || iIIiIiIii_Class3002.I_method_dfe89263()) {
            this.setEnabled(false, true);
            return false;
        }
        if (iIIiIiIii_Class3002 instanceof iIIiiiiIi_Class318) {
            this.I_field_19fedc5f = Hand.OFF_HAND;
            this.II_field_49 = -1;
            this.Ii_field_49 = -1;
        } else {
            this.I_field_19fedc5f = Hand.MAIN_HAND;
            this.Ii_field_49 = SpiderModule.I_field_3a9bda27.player.getInventory().selectedSlot;
            if (this.Ii_field_49 < 0 || this.Ii_field_49 > 8) {
                SpiderModule.I_field_3a9bda27.player.getInventory().selectedSlot = this.Ii_field_49 = 0;
            }
            this.II_field_49 = iIIiIiIii_Class3002.I_method_dfe89252();
            iIIiIiIiI_Class299.iI_method_c617e8c2(this.II_field_49, this.Ii_field_49);
        }
        this.i_field_5a = true;
        return true;
    }

    private void iII_method_5cf0f98c() {
        if (!this.i_field_5a) {
            this.II_field_49 = -1;
            this.Ii_field_49 = -1;
            this.I_field_19fedc5f = Hand.MAIN_HAND;
            return;
        }
        if (SpiderModule.I_field_3a9bda27.player != null && this.I_field_19fedc5f == Hand.MAIN_HAND && this.II_field_49 != -1 && this.Ii_field_49 >= 0 && this.Ii_field_49 <= 8) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(this.II_field_49, this.Ii_field_49);
            SpiderModule.I_field_3a9bda27.player.getInventory().selectedSlot = this.Ii_field_49;
        }
        this.II_field_49 = -1;
        this.Ii_field_49 = -1;
        this.I_field_19fedc5f = Hand.MAIN_HAND;
        this.i_field_5a = false;
    }

    private boolean iII_method_5cf0f990() {
        if (SpiderModule.I_field_3a9bda27.world == null || SpiderModule.I_field_3a9bda27.player == null) {
            return false;
        }
        Box box = SpiderModule.I_field_3a9bda27.player.getBoundingBox();
        double d = Math.max((double)SpiderModule.I_field_3a9bda27.player.getWidth() * 0.15, 0.03);
        Box box2 = box.expand(d, 0.0, d);
        BlockPos blockPos = BlockPos.ofFloored((double)box2.minX, (double)box.minY, (double)box2.minZ);
        BlockPos blockPos2 = BlockPos.ofFloored((double)box2.maxX, (double)box.maxY, (double)box2.maxZ);
        for (BlockPos blockPos3 : BlockPos.iterate((BlockPos)blockPos, (BlockPos)blockPos2)) {
            BlockState blockState = SpiderModule.I_field_3a9bda27.world.getBlockState(blockPos3);
            if (!this.I_method_22a1283f(blockState, blockPos3, box, box2)) continue;
            return true;
        }
        return false;
    }

    private boolean I_method_22a1283f(BlockState blockState, BlockPos blockPos, Box box, Box box2) {
        if (blockState.isAir()) {
            return false;
        }
        VoxelShape voxelShape = blockState.getCollisionShape((BlockView)SpiderModule.I_field_3a9bda27.world, blockPos);
        if (voxelShape.isEmpty() || !VoxelShapes.matchesAnywhere((VoxelShape)voxelShape, (VoxelShape)VoxelShapes.fullCube(), (BooleanBiFunction)BooleanBiFunction.NOT_SAME)) {
            return false;
        }
        for (Box box3 : voxelShape.getBoundingBoxes()) {
            Box box4 = box3.offset(blockPos);
            if (!box4.intersects(box2) || !(box4.maxY > box.minY) || !(box4.minY < box.maxY)) continue;
            return true;
        }
        return false;
    }
}

