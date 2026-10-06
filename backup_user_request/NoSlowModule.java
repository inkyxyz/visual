package rockstar.client;

import net.minecraft.block.Blocks;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.consume.UseAction;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerActionC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.player.InputEvent;
import pyrock.events.player.SlowDownEvent;
import rockstar.client.ModeSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="No Slow", category=ModuleCategory.MOVEMENT)
public class NoSlowModule
extends Module {
    private int I_field_49;
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
    private ModeSetting.Nested1_42765c60 iI_field_500d0627;
    private ModeSetting.Nested1_42765c60 ii_field_500d0627;
    private ModeSetting.Nested1_42765c60 III_field_500d0627;
    private int i_field_49 = -1;
    private boolean I_field_5a;
    private int II_field_49;
    private final IiIIIiII_Class69<SlowDownEvent> I_field_3d936f41 = slowDownEvent -> {
        int n2;
        if (NoSlowModule.I_field_3a9bda27.player == null || NoSlowModule.I_field_3a9bda27.world == null || NoSlowModule.I_field_3a9bda27.interactionManager == null) {
            return;
        }
        if (this.Ii_field_500d0627.isSelected() && (this.II_field_49 > 0 || this.iII_method_5c50b5d0())) {
            this.Iii_method_27871dec();
            slowDownEvent.cancel();
            return;
        }
        if (this.III_field_500d0627.isSelected()) {
            this.I_method_a61ac5d((SlowDownEvent)slowDownEvent);
            return;
        }
        if (this.Iii_method_27871df0()) {
            this.I_field_49 = 0;
            this.iII_method_5c50b5cc();
            return;
        }
        if (this.ii_field_500d0627.isSelected()) {
            if (this.IiI_method_27789210() || NoSlowModule.I_field_3a9bda27.player.getMainHandStack().isOf(Items.CROSSBOW) || NoSlowModule.I_field_3a9bda27.player.getMainHandStack().isOf(Items.MILK_BUCKET)) {
                NoSlowModule.I_field_3a9bda27.player.setSprinting(true);
                slowDownEvent.cancel();
            }
            return;
        }
        if (this.II_field_500d0627.isSelected() || this.iI_field_500d0627.isSelected()) {
            if (NoSlowModule.I_field_3a9bda27.player.isGliding()) {
                return;
            }
            if (NoSlowModule.I_field_3a9bda27.player.age % 2 == 0 && !NoSlowModule.I_field_3a9bda27.player.isSneaking()) {
                slowDownEvent.cancel();
            }
            return;
        }
        this.iIi_method_5c5f41ac();
        if (NoSlowModule.I_field_3a9bda27.player.getActiveHand() == Hand.MAIN_HAND && !this.Ii_field_500d0627.isSelected() && !this.i_field_500d0627.isSelected()) {
            NoSlowModule.I_field_3a9bda27.interactionManager.sendSequencedPacket(NoSlowModule.I_field_3a9bda27.world, n -> new PlayerInteractItemC2SPacket(Hand.OFF_HAND, n, NoSlowModule.I_field_3a9bda27.player.getYaw(), NoSlowModule.I_field_3a9bda27.player.getPitch()));
            slowDownEvent.cancel();
            return;
        }
        if (!this.Ii_field_500d0627.isSelected() && !this.i_field_500d0627.isSelected()) {
            NoSlowModule.I_field_3a9bda27.interactionManager.sendSequencedPacket(NoSlowModule.I_field_3a9bda27.world, n -> new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, n, NoSlowModule.I_field_3a9bda27.player.getYaw(), NoSlowModule.I_field_3a9bda27.player.getPitch()));
        } else {
            ++this.I_field_49;
        }
        boolean bl = NoSlowModule.I_field_3a9bda27.player.getActiveItem().isOf(Items.GOLDEN_APPLE) || NoSlowModule.I_field_3a9bda27.player.getActiveItem().isOf(Items.ENCHANTED_GOLDEN_APPLE);
        int n3 = n2 = bl ? 4 : 2;
        if (this.I_field_49 >= n2 && (!bl || !NoSlowModule.I_field_3a9bda27.player.isOnGround()) || this.I_field_500d0627.isSelected() || this.I_field_49 >= 2 && this.i_field_500d0627.isSelected()) {
            slowDownEvent.cancel();
            this.I_field_49 = 0;
        }
    };
    private final IiIIIiII_Class69<InputEvent> i_field_3d936f41 = inputEvent -> {
        if (this.ii_field_500d0627.isSelected() && NoSlowModule.I_field_3a9bda27.player.isUsingItem() && this.IiI_method_27789210()) {
            inputEvent.setJump(false);
            if (NoSlowModule.I_field_3a9bda27.player.hasStatusEffect(StatusEffects.SPEED)) {
                NoSlowModule.I_field_3a9bda27.player.setVelocity(NoSlowModule.I_field_3a9bda27.player.getVelocity().x * 0.71, NoSlowModule.I_field_3a9bda27.player.getVelocity().y, NoSlowModule.I_field_3a9bda27.player.getVelocity().z * 0.71);
            }
        }
    };
    private final IiIIIiII_Class69<ClientPlayerTickEvent> II_field_3d936f41 = clientPlayerTickEvent -> {
        if (NoSlowModule.I_field_3a9bda27.player == null || NoSlowModule.I_field_3a9bda27.world == null || NoSlowModule.I_field_3a9bda27.player.getItemCooldownManager() == null || I_field_3a9bda27.getNetworkHandler() == null) {
            return;
        }
        if (this.II_field_49 > 0) {
            if (this.Ii_field_500d0627.isSelected()) {
                this.Iii_method_27871dec();
            }
            --this.II_field_49;
        }
        if (this.III_field_500d0627.isSelected()) {
            this.iiI_method_5e13a5ec();
        }
        if (this.i_field_500d0627.isSelected() && !this.Iii_method_27871df0()) {
            this.iIi_method_5c5f41ac();
        } else {
            this.iII_method_5c50b5cc();
        }
        if (!this.I_field_500d0627.isSelected()) {
            return;
        }
        if (!NoSlowModule.I_field_3a9bda27.player.getItemCooldownManager().isCoolingDown(NoSlowModule.I_field_3a9bda27.player.getMainHandStack().getItem().getDefaultStack()) && !NoSlowModule.I_field_3a9bda27.player.getItemCooldownManager().isCoolingDown(NoSlowModule.I_field_3a9bda27.player.getOffHandStack().getItem().getDefaultStack()) && NoSlowModule.I_field_3a9bda27.player.isUsingItem() && NoSlowModule.I_field_3a9bda27.player.fallDistance < 1.0f && NoSlowModule.I_field_3a9bda27.player.getActiveHand() == Hand.OFF_HAND) {
            I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new UpdateSelectedSlotC2SPacket(NoSlowModule.I_field_3a9bda27.player.getInventory().selectedSlot % 8 + 1));
            I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new UpdateSelectedSlotC2SPacket(NoSlowModule.I_field_3a9bda27.player.getInventory().selectedSlot));
        }
    };
    private final IiIIIiII_Class69<SendPacketEvent> Ii_field_3d936f41 = sendPacketEvent -> {
        PlayerInteractItemC2SPacket playerInteractItemC2SPacket;
        if (NoSlowModule.I_field_3a9bda27.player == null || NoSlowModule.I_field_3a9bda27.world == null || !this.Ii_field_500d0627.isSelected()) {
            return;
        }
        Packet<?> packet = sendPacketEvent.getPacket();
        if (packet instanceof PlayerInteractItemC2SPacket && this.I_method_5c146532(this.I_method_6ddc7d8b((playerInteractItemC2SPacket = (PlayerInteractItemC2SPacket)packet).getHand()))) {
            this.II_field_49 = 4;
            this.Iii_method_27871dec();
        }
    };

    public NoSlowModule() {
        this.IiI_method_2778920c();
    }

    @Compile(obfuscation=4)
    private void IiI_method_2778920c() {
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.noslow.mode");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.noslow.grim");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "GrimNew");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.noslow.grim_tick");
        this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.noslow.spooky");
        this.iI_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.noslow.holly");
        this.ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "VonTam");
        this.III_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "LonyGrief");
    }

    private boolean IiI_method_27789210() {
        if (NoSlowModule.I_field_3a9bda27.player == null || NoSlowModule.I_field_3a9bda27.world == null) {
            return false;
        }
        if (IiiiiiiII_Class253.I_method_59c3e499(0.0, -1.0, 0.0) == Blocks.SNOW || IiiiiiiII_Class253.I_method_59c3e499(0.0, -1.0, 0.0) == Blocks.SHORT_GRASS) {
            return true;
        }
        return IiiiiiiII_Class253.I_method_59c3e499(0.0, 0.0, 0.0) == Blocks.SNOW || IiiiiiiII_Class253.I_method_59c3e499(0.0, 0.0, 0.0) == Blocks.SHORT_GRASS;
    }

    private boolean Iii_method_27871df0() {
        return (NoSlowModule.I_field_3a9bda27.player.getMainHandStack().getUseAction() == UseAction.BLOCK || NoSlowModule.I_field_3a9bda27.player.getOffHandStack().getUseAction() == UseAction.EAT) && NoSlowModule.I_field_3a9bda27.player.getActiveHand() == Hand.MAIN_HAND || !NoSlowModule.I_field_3a9bda27.player.isUsingItem();
    }

    private boolean I_method_5c146532(ItemStack itemStack) {
        if (itemStack == null || itemStack.isEmpty()) {
            return false;
        }
        return itemStack.isOf(Items.ENDER_EYE) || itemStack.isOf(Items.FIRE_CHARGE) || itemStack.isOf(Items.PHANTOM_MEMBRANE) || itemStack.isOf(Items.SUGAR) || itemStack.isOf(Items.SNOWBALL) || itemStack.isOf(Items.NETHER_STAR) || itemStack.isOf(Items.PRISMARINE_SHARD) || itemStack.isOf(Items.FIREWORK_STAR);
    }

    private boolean iII_method_5c50b5d0() {
        return NoSlowModule.I_field_3a9bda27.player.isUsingItem() && (this.I_method_5c146532(NoSlowModule.I_field_3a9bda27.player.getActiveItem()) || this.I_method_5c146532(this.I_method_6ddc7d8b(NoSlowModule.I_field_3a9bda27.player.getActiveHand())));
    }

    private ItemStack I_method_6ddc7d8b(Hand hand) {
        return hand == Hand.OFF_HAND ? NoSlowModule.I_field_3a9bda27.player.getOffHandStack() : NoSlowModule.I_field_3a9bda27.player.getMainHandStack();
    }

    private void Iii_method_27871dec() {
        this.iIi_method_5c5f41ac();
        this.I_field_49 = 0;
    }

    private void iII_method_5c50b5cc() {
        this.i_field_49 = -1;
        this.I_field_5a = false;
    }

    private void iIi_method_5c5f41ac() {
        if (!this.i_field_500d0627.isSelected()) {
            this.iII_method_5c50b5cc();
            NoSlowModule.I_field_3a9bda27.player.setSprinting(!iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.II_field_ac164e6c));
            return;
        }
        int n = NoSlowModule.I_field_3a9bda27.player.age;
        if (this.i_field_49 != n) {
            this.I_field_5a = this.i_field_49 != -1 && !this.I_field_5a;
            this.i_field_49 = n;
        }
        NoSlowModule.I_field_3a9bda27.player.setSprinting(this.I_field_5a);
    }

    private void I_method_a61ac5d(SlowDownEvent slowDownEvent) {
        if (NoSlowModule.I_field_3a9bda27.player.isGliding() || !NoSlowModule.I_field_3a9bda27.player.isUsingItem()) {
            return;
        }
        if (NoSlowModule.I_field_3a9bda27.player.getActiveHand() == Hand.OFF_HAND) {
            if (NoSlowModule.I_field_3a9bda27.player.age % 2 == 0 && !NoSlowModule.I_field_3a9bda27.player.isSneaking()) {
                slowDownEvent.cancel();
            }
            return;
        }
        if (NoSlowModule.I_field_3a9bda27.player.getItemUseTime() > 0) {
            slowDownEvent.cancel();
        }
    }

    private void iiI_method_5e13a5ec() {
        if (NoSlowModule.I_field_3a9bda27.player.networkHandler == null || NoSlowModule.I_field_3a9bda27.player.isGliding()) {
            return;
        }
        if (NoSlowModule.I_field_3a9bda27.player.isUsingItem() && NoSlowModule.I_field_3a9bda27.player.getItemUseTime() == 0) {
            NoSlowModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerActionC2SPacket(PlayerActionC2SPacket.Action.DROP_ALL_ITEMS, BlockPos.ORIGIN, NoSlowModule.I_field_3a9bda27.player.getHorizontalFacing()));
        }
    }

    @Override
    public void onDisable() {
        this.I_field_49 = 0;
        this.II_field_49 = 0;
        this.iII_method_5c50b5cc();
    }
}

