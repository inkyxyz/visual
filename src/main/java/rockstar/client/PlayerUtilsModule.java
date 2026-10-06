package rockstar.client;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.DeathScreen;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FishingRodItem;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import org.jetbrains.annotations.NotNull;
import pyrock.events.game.BlockBreakEvent;
import pyrock.events.game.InternalAttackEvent;
import pyrock.events.game.StartBreakBlockEvent;
import pyrock.events.player.InputEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.ModeSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiiIii_Class316;
import rockstar.client.iIIiiiiII_Class317;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.Module;
import rockstar.client.AuraModule;
import rockstar.client.iiIiIIiii_Class424;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Player Utils", category=ModuleCategory.PLAYER, III_method_a89e5834="modules.descriptions.player_utils")
public class PlayerUtilsModule
extends Module {
    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 III_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 IIi_field_51de8227;
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private SliderSetting I_field_73178e8c;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
    private boolean I_field_5a;
    private boolean i_field_5a;
    private boolean II_field_5a;
    private boolean Ii_field_5a;
    private boolean iI_field_5a;
    private int I_field_49 = -1;
    private int i_field_49 = -1;
    private iIIiIiIii_Class300 I_field_1242a2ac;
    private long I_field_4a = -1L;
    private long i_field_4a;
    private long II_field_4a = -1L;
    private long Ii_field_4a;
    private int II_field_49 = -1;
    private final IiIIIiII_Class69<InternalAttackEvent> I_field_3d936f41 = internalAttackEvent -> {
        if (this.Ii_field_51de8227.isSelected() && internalAttackEvent.getEntity() instanceof PlayerEntity && RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(internalAttackEvent.getEntity().getName().getString())) {
            internalAttackEvent.cancel();
        }
    };
    private final IiIIIiII_Class69<StartBreakBlockEvent> i_field_3d936f41 = startBreakBlockEvent -> {
        iIIiIiIii_Class300 iIIiIiIii_Class3002;
        if (!this.IIi_field_51de8227.isSelected() || PlayerUtilsModule.I_field_3a9bda27.player == null || PlayerUtilsModule.I_field_3a9bda27.world == null) {
            return;
        }
        BlockState blockState = PlayerUtilsModule.I_field_3a9bda27.world.getBlockState(startBreakBlockEvent.getBlockPos());
        if (blockState.isAir()) {
            return;
        }
        ItemStack itemStack = PlayerUtilsModule.I_field_3a9bda27.player.getMainHandStack();
        float f = this.I_method_70f02526(itemStack, blockState);
        iIIiIiIii_Class300 iIIiIiIii_Class3003 = this.I_method_f5e90902(blockState, f);
        iIIiiiIii_Class316 iIIiiiIii_Class3162 = iIIiIiIiI_Class299.I_method_d0256375();
        if (iIIiIiIii_Class3003 == null || iIIiIiIii_Class3003.equals(iIIiiiIii_Class3162)) {
            return;
        }
        if (this.Ii_field_5a) {
            this.iII_method_ebc4729f();
        }
        this.I_field_49 = PlayerUtilsModule.I_field_3a9bda27.player.getInventory().selectedSlot;
        if (this.Ii_field_5a) {
            iIIiIiIii_Class3002 = this.I_method_f5e90902(blockState, f);
            if (iIIiIiIii_Class3002 == null || iIIiIiIii_Class3002.equals(iIIiiiIii_Class3162)) {
                return;
            }
            this.iII_method_ebc4729f();
        }
        if (iIIiIiIii_Class3003 instanceof iIIiiiIii_Class316) {
            iIIiIiIii_Class3002 = (iIIiiiIii_Class316)iIIiIiIii_Class3003;
            if (((iIIiiiIii_Class316)iIIiIiIii_Class3002).II_method_b9cf08f5() == this.I_field_49) {
                return;
            }
            this.i_field_49 = ((iIIiiiIii_Class316)iIIiIiIii_Class3002).II_method_b9cf08f5();
            iIIiIiIiI_Class299.I_method_4c2ca067((iIIiiiIii_Class316)iIIiIiIii_Class3002);
            this.iI_field_5a = false;
            this.Ii_field_5a = true;
            return;
        }
        if (iIIiIiIii_Class3003 instanceof iIIiiiiII_Class317) {
            this.i_field_49 = this.I_field_49;
            this.I_field_1242a2ac = iIIiIiIii_Class3003;
            iIIiIiIiI_Class299.iI_method_c617e8c2(iIIiIiIii_Class3003.I_method_dfe89252(), this.i_field_49);
            this.iI_field_5a = true;
            this.Ii_field_5a = true;
        }
    };
    private final IiIIIiII_Class69<BlockBreakEvent> II_field_3d936f41 = blockBreakEvent -> {
        if (!this.IIi_field_51de8227.isSelected()) {
            return;
        }
        if (this.Ii_field_5a && PlayerUtilsModule.I_field_3a9bda27.player != null && !PlayerUtilsModule.I_field_3a9bda27.options.attackKey.isPressed()) {
            this.iII_method_ebc4729f();
        }
    };
    private final IiIIIiII_Class69<InputEvent> Ii_field_3d936f41 = inputEvent -> {
        if (this.III_field_51de8227.isSelected() && this.II_field_5a && this.i_field_500d0627.isSelected() && PlayerUtilsModule.I_field_3a9bda27.player.isOnGround() && (float)PlayerUtilsModule.I_field_3a9bda27.player.age % this.I_field_73178e8c.Ii_method_a20abcd2() == 5.0f) {
            inputEvent.setJump(true);
        }
    };

    public PlayerUtilsModule() {
        this.IiI_method_b6ec4edf();
    }

    @Compile(obfuscation=4)
    private void IiI_method_b6ec4edf() {
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.player_utils.select_setting").I_method_702bd95a(1);
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_respawn");
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_fish");
        this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.fast_ladder");
        this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.no_friend_damage");
        this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.fast_break");
        this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.player_utils.block_trap");
        this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.anti_afk");
        this.IIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.auto_tool");
        this.I_field_bbe33e6c = new ModeSetting((IIiiiIIiI_Class115)this, "modules.settings.anti_afk.mode", () -> !this.III_field_51de8227.isSelected());
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.anti_afk.send");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.anti_afk.jump");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.anti_afk.swing");
        this.I_field_73178e8c = new SliderSetting(this, "modules.settings.anti_afk.delay", "modules.settings.anti_afk.delay.description", () -> !this.III_field_51de8227.isSelected()).I_method_c8c9a7d7(5.0f).i_method_65e2aff7(60.0f).II_method_b0f56334(5.0f).Ii_method_4e0e6b54(50.0f);
    }

    @Override
    public void II_method_6642fd22() {
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092;
        iIIiIiIii_Class300 iIIiIiIii_Class3002;
        LivingEntity livingEntity;
        if (this.Ii_field_5a && (PlayerUtilsModule.I_field_3a9bda27.player == null || !PlayerUtilsModule.I_field_3a9bda27.options.attackKey.isPressed())) {
            this.iII_method_ebc4729f();
        }
        if (this.iI_field_51de8227.isSelected()) {
            PlayerUtilsModule.I_field_3a9bda27.interactionManager.blockBreakingCooldown = 0;
            if (PlayerUtilsModule.I_field_3a9bda27.interactionManager.getBlockBreakingProgress() > 1) {
                PlayerUtilsModule.I_field_3a9bda27.interactionManager.blockBreakingCooldown = 1;
            }
        }
        if (this.III_field_51de8227.isSelected()) {
            if (this.I_field_991c1e8c.I_method_58432069(10000L)) {
                this.II_field_5a = true;
            }
            if (IiiiiiiII_Class253.I_method_1cb61e43()) {
                this.II_field_5a = false;
                this.I_field_991c1e8c.I_method_23e11e3f();
            }
            if (this.II_field_5a && (float)PlayerUtilsModule.I_field_3a9bda27.player.age % this.I_field_73178e8c.Ii_method_a20abcd2() == 5.0f) {
                if (this.I_field_500d0627.isSelected()) {
                    PlayerUtilsModule.I_field_3a9bda27.player.networkHandler.sendChatMessage(IiIiIIII_Class81.I_method_1410d1e5("player_utils.hello_message", String.valueOf(Math.random())));
                    this.II_field_5a = false;
                    this.I_field_991c1e8c.I_method_23e11e3f();
                } else if (this.II_field_500d0627.isSelected()) {
                    PlayerUtilsModule.I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
                    this.II_field_5a = false;
                    this.I_field_991c1e8c.I_method_23e11e3f();
                }
            }
        }
        if (this.I_field_51de8227.isSelected()) {
            if (PlayerUtilsModule.I_field_3a9bda27.currentScreen instanceof DeathScreen) {
                if (this.II_field_49 == -1 && !PlayerUtilsModule.I_field_3a9bda27.player.isAlive()) {
                    this.II_field_49 = 0;
                }
                ++this.II_field_49;
                int n = 20;
                if (this.II_field_49 >= n) {
                    PlayerUtilsModule.I_field_3a9bda27.player.requestRespawn();
                    I_field_3a9bda27.setScreen(null);
                    this.II_field_49 = -1;
                }
            } else {
                this.II_field_49 = -1;
            }
        }
        if (this.i_field_51de8227.isSelected() && PlayerUtilsModule.I_field_3a9bda27.player.getMainHandStack().getItem() instanceof FishingRodItem) {
            if (PlayerUtilsModule.I_field_3a9bda27.player.fishHook != null) {
                if (((Boolean)PlayerUtilsModule.I_field_3a9bda27.player.fishHook.getDataTracker().get(FishingBobberEntity.CAUGHT_FISH)).booleanValue() && this.I_field_4a == -1L) {
                    this.I_field_4a = System.currentTimeMillis();
                    this.i_field_4a = (long)(180.0f + iIIiiiiiI_Class319.iI_method_330da892(0.0f, 220.0f) + (float)I_field_3a9bda27.getNetworkHandler().getPlayerListEntry(PlayerUtilsModule.I_field_3a9bda27.player.getUuid()).getLatency() / 2.0f);
                }
                if (this.I_field_4a != -1L && System.currentTimeMillis() - this.I_field_4a >= this.i_field_4a) {
                    this.Iii_method_b6fadabf();
                    this.I_field_4a = -1L;
                    this.I_field_5a = true;
                    this.i_field_991c1e8c.I_method_23e11e3f();
                }
            } else {
                if (this.I_field_5a && this.i_field_991c1e8c.I_method_58432069((long)(600.0f + iIIiiiiiI_Class319.iI_method_330da892(20.0f, 70.0f)))) {
                    this.Iii_method_b6fadabf();
                    this.I_field_5a = false;
                    this.i_field_5a = false;
                    this.i_field_991c1e8c.I_method_23e11e3f();
                } else if (!this.I_field_5a && this.i_field_5a && this.i_field_991c1e8c.I_method_58432069((long)(3000.0f + iIIiiiiiI_Class319.iI_method_330da892(40.0f, 110.0f)))) {
                    this.Iii_method_b6fadabf();
                    this.i_field_5a = false;
                    this.i_field_991c1e8c.I_method_23e11e3f();
                }
                this.I_field_4a = -1L;
            }
        }
        if (PlayerUtilsModule.I_field_3a9bda27.player != null && PlayerUtilsModule.I_field_3a9bda27.world.getBlockState(PlayerUtilsModule.I_field_3a9bda27.player.getBlockPos()).isOf(Blocks.LADDER) && this.II_field_51de8227.isSelected()) {
            PlayerUtilsModule.I_field_3a9bda27.player.setVelocity(PlayerUtilsModule.I_field_3a9bda27.player.getVelocity().multiply(1.0, 1.43, 1.0));
        }
        if (this.ii_field_51de8227.isSelected() && (livingEntity = RockstarClient.getInstance().I_method_9a638462().I_method_4517f36c()) != null && PlayerUtilsModule.I_field_3a9bda27.player.getPos().distanceTo(livingEntity.getPos()) <= (double)RockstarClient.getInstance().getModuleManager().getModule(AuraModule.class).I_method_af0f42().Ii_method_a20abcd2() && (iIIiIiIii_Class3002 = (iIIiiIiII_Class3092 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695())).I_method_77fa4424(itemStack -> itemStack.getItem() instanceof BlockItem)) != null) {
            BlockPos[] blockPosArray = this.I_method_36de87dd(livingEntity);
            this.I_method_97601cb(iIIiIiIii_Class3002.I_method_dfe89252(), blockPosArray);
        }
        super.II_method_6642fd22();
    }

    private void Iii_method_b6fadabf() {
        PlayerUtilsModule.I_field_3a9bda27.interactionManager.interactItem((PlayerEntity)PlayerUtilsModule.I_field_3a9bda27.player, Hand.MAIN_HAND);
        PlayerUtilsModule.I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
    }

    private iIIiIiIii_Class300 I_method_f5e90902(BlockState blockState, float f) {
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.I_method_6a489695().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75());
        iIIiIiIii_Class300 iIIiIiIii_Class3002 = null;
        float f2 = f;
        for (iIIiIiIii_Class300 iIIiIiIii_Class3003 : iIIiiIiII_Class3092.I_method_617d3e68()) {
            float f3;
            ItemStack itemStack = iIIiIiIii_Class3003.I_method_7b7e0bb9();
            if (itemStack == null || itemStack.isEmpty() || !((f3 = this.I_method_70f02526(itemStack, blockState)) > f2)) continue;
            f2 = f3;
            iIIiIiIii_Class3002 = iIIiIiIii_Class3003;
        }
        if (iIIiIiIii_Class3002 == null || f2 <= 1.0f || f2 <= f) {
            return null;
        }
        return iIIiIiIii_Class3002;
    }

    private float I_method_70f02526(ItemStack itemStack, BlockState blockState) {
        if (itemStack == null || itemStack.isEmpty()) {
            return 0.0f;
        }
        return itemStack.getMiningSpeedMultiplier(blockState);
    }

    private void iII_method_ebc4729f() {
        if (!this.Ii_field_5a || PlayerUtilsModule.I_field_3a9bda27.player == null) {
            return;
        }
        if (this.iI_field_5a && this.I_field_1242a2ac != null && this.i_field_49 != -1) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_1242a2ac.I_method_dfe89252(), this.i_field_49);
        }
        if (this.I_field_49 != -1) {
            iIIiIiIiI_Class299.i_method_8225b484(this.I_field_49);
        }
        this.Ii_field_5a = false;
        this.iI_field_5a = false;
        this.I_field_49 = -1;
        this.i_field_49 = -1;
        this.I_field_1242a2ac = null;
    }

    private void I_method_97601cb(int n2, BlockPos[] blockPosArray) {
        for (BlockPos blockPos : blockPosArray) {
            BlockHitResult blockHitResult;
            if (!PlayerUtilsModule.I_field_3a9bda27.world.isAir(blockPos)) continue;
            if (n2 == 40) {
                blockHitResult = new BlockHitResult(blockPos.down().toCenterPos(), Direction.UP, blockPos.down(), false);
                PlayerUtilsModule.I_field_3a9bda27.interactionManager.sendSequencedPacket(PlayerUtilsModule.I_field_3a9bda27.world, n -> new PlayerInteractBlockC2SPacket(Hand.OFF_HAND, blockHitResult, n));
                continue;
            }
            if (n2 >= 36) {
                PlayerUtilsModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new UpdateSelectedSlotC2SPacket(n2 - 36));
                blockHitResult = new BlockHitResult(blockPos.down().toCenterPos(), Direction.UP, blockPos.down(), false);
                PlayerUtilsModule.I_field_3a9bda27.interactionManager.sendSequencedPacket(PlayerUtilsModule.I_field_3a9bda27.world, n -> new PlayerInteractBlockC2SPacket(Hand.MAIN_HAND, blockHitResult, n));
                PlayerUtilsModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new UpdateSelectedSlotC2SPacket(PlayerUtilsModule.I_field_3a9bda27.player.getInventory().selectedSlot));
                continue;
            }
            PlayerUtilsModule.I_field_3a9bda27.interactionManager.clickSlot(PlayerUtilsModule.I_field_3a9bda27.player.currentScreenHandler.syncId, n2, 0, SlotActionType.PICKUP, (PlayerEntity)PlayerUtilsModule.I_field_3a9bda27.player);
            PlayerUtilsModule.I_field_3a9bda27.interactionManager.clickSlot(PlayerUtilsModule.I_field_3a9bda27.player.currentScreenHandler.syncId, 44, 0, SlotActionType.PICKUP, (PlayerEntity)PlayerUtilsModule.I_field_3a9bda27.player);
        }
    }

    private BlockPos @NotNull [] I_method_36de87dd(LivingEntity livingEntity) {
        BlockPos blockPos = livingEntity.getBlockPos();
        return new BlockPos[]{blockPos.add(1, 0, 0), blockPos.add(-1, 0, 0), blockPos.add(0, 0, 1), blockPos.add(0, 0, -1), blockPos.add(0, 3, 0), blockPos.add(1, 2, 0), blockPos.add(-1, 2, 0), blockPos.add(0, 2, 1), blockPos.add(0, 2, -1)};
    }

    @Override
    public void onDisable() {
        this.I_field_5a = false;
    }
}

