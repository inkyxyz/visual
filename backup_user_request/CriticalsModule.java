package rockstar.client;

import net.minecraft.block.Blocks;
import net.minecraft.entity.decoration.EndCrystalEntity;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import pyrock.events.game.InternalAttackEvent;
import rockstar.client.ModeSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiII_Class405;
import rockstar.client.iiIIiIiIi_Class406;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Criticals", category=ModuleCategory.COMBAT)
public class CriticalsModule
extends Module {
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private int I_field_49;
    private final IiIIIiII_Class69<InternalAttackEvent> I_field_3d936f41 = internalAttackEvent -> {
        if (internalAttackEvent.isCancelled()) {
            return;
        }
        if (CriticalsModule.I_field_3a9bda27.player == null || CriticalsModule.I_field_3a9bda27.world == null) {
            return;
        }
        iiIIiIiII_Class405 iiIIiIiII_Class4052 = RockstarClient.getInstance().I_method_58785402();
        if (this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)) {
            this.I_method_4bab5dee((InternalAttackEvent)internalAttackEvent);
            return;
        }
        if (CriticalsModule.I_field_3a9bda27.player.isTouchingWater()) {
            return;
        }
        if (!this.IiI_method_f7887e30()) {
            return;
        }
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = iiIIiIiII_Class4052.I_method_3d166e03() ? iiIIiIiII_Class4052.I_method_fb1d7ad5() : iiIIiIiII_Class4052.II_method_f098f858();
        iiIIiIIii_Class404 iiIIiIIii_Class4043 = iiIIiIiIi_Class406.I_method_565091b5(iiIIiIiII_Class4052.II_method_f098f858(), new iiIIiIIii_Class404(iiIIiIIii_Class4042.I_method_14534e0f() + iIIiiiiiI_Class319.I_method_b56b22f(-5.0, 5.0), iiIIiIIii_Class4042.i_method_1461d9ef() + iIIiiiiiI_Class319.I_method_b56b22f(-5.0, 5.0)));
        CriticalsModule.I_field_3a9bda27.player.fallDistance = iIIiiiiiI_Class319.I_method_b56b22f(1.0E-5f, 1.0E-4f);
        CriticalsModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerMoveC2SPacket.Full(CriticalsModule.I_field_3a9bda27.player.getX(), CriticalsModule.I_field_3a9bda27.player.getY() - (double)CriticalsModule.I_field_3a9bda27.player.fallDistance, CriticalsModule.I_field_3a9bda27.player.getZ(), iiIIiIIii_Class4043.I_method_14534e0f(), iiIIiIIii_Class4043.i_method_1461d9ef(), CriticalsModule.I_field_3a9bda27.player.isOnGround(), CriticalsModule.I_field_3a9bda27.player.horizontalCollision));
    };

    public CriticalsModule() {
        this.IiI_method_f7887e2c();
    }

    @Compile(obfuscation=4)
    private void IiI_method_f7887e2c() {
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.criticals.mode");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.criticals.mode.default").select();
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.criticals.mode.reallyworld");
    }

    @Override
    public void II_method_6642fd22() {
        this.I_field_49 = this.Iii_method_f7970a10() ? ++this.I_field_49 : 0;
    }

    public boolean IiI_method_f7887e30() {
        if (this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)) {
            return !this.iIi_method_2c6f2dd0() || this.iii_method_2e321df0();
        }
        return CriticalsModule.I_field_3a9bda27.player != null && CriticalsModule.I_field_3a9bda27.player.fallDistance <= 0.0f && !CriticalsModule.I_field_3a9bda27.player.isOnGround() && this.I_field_49 > 0;
    }

    public boolean Iii_method_f7970a10() {
        if (!this.isEnabled() || CriticalsModule.I_field_3a9bda27.player == null || CriticalsModule.I_field_3a9bda27.world == null) {
            return false;
        }
        if (this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627)) {
            return this.iIi_method_2c6f2dd0();
        }
        return CriticalsModule.I_field_3a9bda27.player.fallDistance <= 0.0f && !CriticalsModule.I_field_3a9bda27.player.isOnGround();
    }

    public boolean iII_method_2c60a1f0() {
        return this.isEnabled() && !this.I_field_bbe33e6c.I_method_ce989e26(this.i_field_500d0627);
    }

    private boolean iii_method_2e321df0() {
        if (CriticalsModule.I_field_3a9bda27.player == null || CriticalsModule.I_field_3a9bda27.world == null || CriticalsModule.I_field_3a9bda27.player.isOnGround()) {
            return false;
        }
        double d = CriticalsModule.I_field_3a9bda27.player.getY();
        return d != (double)((int)d) && (CriticalsModule.I_field_3a9bda27.player.isInLava() || this.iiI_method_2e239210());
    }

    private void I_method_4bab5dee(InternalAttackEvent internalAttackEvent) {
        float f;
        if (internalAttackEvent.getEntity() == null || internalAttackEvent.getEntity() instanceof EndCrystalEntity || !this.iii_method_2e321df0()) {
            return;
        }
        CriticalsModule.I_field_3a9bda27.player.fallDistance = f = iIIiiiiiI_Class319.I_method_b56b22f(1.0E-7f, 1.0E-6f);
        CriticalsModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerMoveC2SPacket.Full(CriticalsModule.I_field_3a9bda27.player.getX(), CriticalsModule.I_field_3a9bda27.player.getY() - (double)f, CriticalsModule.I_field_3a9bda27.player.getZ(), CriticalsModule.I_field_3a9bda27.player.getYaw(), CriticalsModule.I_field_3a9bda27.player.getPitch(), false, CriticalsModule.I_field_3a9bda27.player.horizontalCollision));
    }

    public boolean iIi_method_2c6f2dd0() {
        return this.isEnabled() && CriticalsModule.I_field_3a9bda27.player != null && CriticalsModule.I_field_3a9bda27.world != null && (CriticalsModule.I_field_3a9bda27.player.hasStatusEffect(StatusEffects.SLOW_FALLING) || this.iiI_method_2e239210());
    }

    public boolean iiI_method_2e239210() {
        if (CriticalsModule.I_field_3a9bda27.player == null || CriticalsModule.I_field_3a9bda27.world == null) {
            return false;
        }
        Box box = CriticalsModule.I_field_3a9bda27.player.getBoundingBox();
        int n = (int)Math.floor(box.minX);
        int n2 = (int)Math.floor(box.minY);
        int n3 = (int)Math.floor(box.minZ);
        int n4 = (int)Math.ceil(box.maxX);
        int n5 = (int)Math.ceil(box.maxY);
        int n6 = (int)Math.ceil(box.maxZ);
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int i = n; i < n4; ++i) {
            for (int j = n2; j < n5; ++j) {
                for (int k = n3; k < n6; ++k) {
                    if (!CriticalsModule.I_field_3a9bda27.world.getBlockState((BlockPos)mutable.set(i, j, k)).isOf(Blocks.COBWEB)) continue;
                    return true;
                }
            }
        }
        return false;
    }
}

