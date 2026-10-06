package rockstar.client;

import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerAbilities;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.network.packet.s2c.play.PlayerPositionLookS2CPacket;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.network.SendPacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.player.EventMotion;
import pyrock.events.player.EventOnTravelPost;
import pyrock.events.player.InputEvent;
import rockstar.client.GuiMoveModule;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.ModeSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiIiii_Class248;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIiIIi_Class298;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiiIiI_Class315;
import rockstar.client.iIiIiiIIi_Class346;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Flight", category=ModuleCategory.MOVEMENT)
public class FlightModule
extends Module {
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private SliderSetting I_field_73178e8c;
    private boolean I_field_5a;
    private boolean i_field_5a;
    private boolean II_field_5a;
    private float I_field_46;
    private int I_field_49;
    private boolean Ii_field_5a;
    private boolean iI_field_5a;
    private boolean ii_field_5a;
    private final Nested1_9121b4d3 I_field_112315fc = new Nested1_9121b4d3();
    private final IiIIIiII_Class69<EventMotion> I_field_3d936f41 = eventMotion -> {
        if (this.i_field_500d0627.isSelected()) {
            RockstarClient.getInstance().I_method_58785402().I_method_1acbf705(new iiIIiIIii_Class404(FlightModule.I_field_3a9bda27.player.getYaw(), 0.0f), iiIIiIIIi_Class402.i_field_32e0c64c, 180.0f, 180.0f, 180.0f, iiIIiIiiI_Class407.ii_field_32efc66c);
            ClientPlayerEntity clientPlayerEntity = FlightModule.I_field_3a9bda27.player;
            if (clientPlayerEntity != null && clientPlayerEntity.isAlive() && clientPlayerEntity.isGliding()) {
                clientPlayerEntity.setVelocity(clientPlayerEntity.getVelocity().x, clientPlayerEntity.getVelocity().y + 0.0305, clientPlayerEntity.getVelocity().z);
            }
        }
    };
    private final IiIIIiII_Class69<InputEvent> i_field_3d936f41 = inputEvent -> {
        if (this.i_field_500d0627.isSelected()) {
            if (iIIiIiIiI_Class299.i_method_e5bad375().I_method_158af795() != Items.ELYTRA) {
                return;
            }
            if (FlightModule.I_field_3a9bda27.player.isInFluid()) {
                return;
            }
            inputEvent.setJump(FlightModule.I_field_3a9bda27.player.age % 2 == 0);
        }
    };
    private final IiIIIiII_Class69<ReceivePacketEvent> II_field_3d936f41 = receivePacketEvent -> {
        if (!this.II_field_500d0627.isSelected()) {
            return;
        }
        if (receivePacketEvent.getPacket() instanceof PlayerPositionLookS2CPacket) {
            this.I_field_49 = 2;
            this.Ii_field_5a = true;
        }
    };
    private final IiIIIiII_Class69<SendPacketEvent> Ii_field_3d936f41 = sendPacketEvent -> {
        if (!this.II_field_500d0627.isSelected() || this.iI_field_5a) {
            return;
        }
        if (!(sendPacketEvent.getPacket() instanceof PlayerMoveC2SPacket)) {
            return;
        }
        if (FlightModule.I_field_3a9bda27.player != null && FlightModule.I_field_3a9bda27.player.isGliding() && this.I_field_49 == 0 && !this.Ii_field_5a) {
            this.iI_field_5a = true;
            try {
                FlightModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerMoveC2SPacket.OnGroundOnly(true, true));
            }
            finally {
                this.iI_field_5a = false;
            }
            sendPacketEvent.cancel();
        }
        this.Ii_field_5a = false;
    };
    private final IiIIIiII_Class69<ClientPlayerTickEvent> iI_field_3d936f41 = clientPlayerTickEvent -> {
        if (this.II_field_500d0627.isSelected() && this.I_field_49 > 0) {
            --this.I_field_49;
        }
    };
    private final IiIIIiII_Class69<EventOnTravelPost> ii_field_3d936f41 = eventOnTravelPost -> {
        double d;
        if (!this.II_field_500d0627.isSelected() || FlightModule.I_field_3a9bda27.player == null) {
            return;
        }
        Vec3d vec3d = FlightModule.I_field_3a9bda27.player.getVelocity();
        Vec3d vec3d2 = FlightModule.I_field_3a9bda27.player.getRotationVector();
        float f = FlightModule.I_field_3a9bda27.player.getPitch() * ((float)Math.PI / 180);
        double d2 = Math.sqrt(vec3d2.x * vec3d2.x + vec3d2.z * vec3d2.z);
        double d3 = vec3d.horizontalLength();
        boolean bl = FlightModule.I_field_3a9bda27.player.getVelocity().y <= 0.0;
        double d4 = bl && FlightModule.I_field_3a9bda27.player.hasStatusEffect(StatusEffects.SLOW_FALLING) ? Math.min(FlightModule.I_field_3a9bda27.player.getFinalGravity(), 0.01) : FlightModule.I_field_3a9bda27.player.getFinalGravity();
        double d5 = MathHelper.square((double)Math.cos(f));
        vec3d = vec3d.add(0.0, d4 * (-1.0 + d5 * 0.75), 0.0);
        if (vec3d.y < 0.0 && d2 > 0.0) {
            d = vec3d.y * -0.1 * d5;
            vec3d = vec3d.add(vec3d2.x * d / d2, d, vec3d2.z * d / d2);
        }
        if (f < 0.0f && d2 > 0.0) {
            d = d3 * (double)(-MathHelper.sin((float)f)) * (double)0.04f;
            vec3d = vec3d.add(-vec3d2.x * d / d2, d * 3.2, -vec3d2.z * d / d2);
        }
        if (d2 > 0.0) {
            vec3d = vec3d.add((vec3d2.x / d2 * d3 - vec3d.x) * 0.1, 0.0, (vec3d2.z / d2 * d3 - vec3d.z) * 0.1);
        }
        d = Math.toRadians(FlightModule.I_field_3a9bda27.player.getYaw());
        double d6 = -Math.sin(d);
        double d7 = Math.cos(d);
        if (this.I_field_49 >= 1) {
            double d8 = 0.09f;
            eventOnTravelPost.setOldVelocity(vec3d.multiply((double)0.99f, (double)0.98f, (double)0.99f).add(d6 * d8, (double)0.03f, d7 * d8));
        } else {
            eventOnTravelPost.setOldVelocity(vec3d.multiply((double)0.3f, (double)0.3f, (double)0.3f));
        }
    };

    public FlightModule() {
        this.IiI_method_a2c5160c();
    }

    @Compile(obfuscation=4)
    private void IiI_method_a2c5160c() {
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.flight.mode");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.flight.vanilla");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.flight.elytra_y");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.flight.elytra_exploit");
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.flight.speed", () -> !this.I_field_500d0627.isSelected()).Ii_method_4e0e6b54(1.0f).I_method_c8c9a7d7(0.1f).i_method_65e2aff7(10.0f).II_method_b0f56334(0.1f);
    }

    @Override
    public final void onEnable() {
        this.ii_field_5a = false;
        this.iiI_method_d96029ec();
        if (this.i_field_500d0627.isSelected() && FlightModule.I_field_3a9bda27.player != null) {
            if (!FlightModule.I_field_3a9bda27.player.isOnGround()) {
                this.toggle();
                iIIIIIIii_Class260.I_method_468cf607(Text.of((String)"\u041d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e \u0432\u043a\u043b\u044e\u0447\u0430\u0442\u044c \u043d\u0430 \u0437\u0435\u043c\u043b\u0435"));
                return;
            }
            if (FlightModule.I_field_3a9bda27.player.getVelocity().length() > (double)0.1f) {
                this.toggle();
                iIIIIIIii_Class260.I_method_468cf607(Text.of((String)"\u041d\u0435\u043e\u0431\u0445\u043e\u0434\u0438\u043c\u043e \u0441\u0442\u043e\u044f\u0442\u044c"));
                return;
            }
            this.Iii_method_a2d3a1ec();
        }
        super.onEnable();
    }

    @Override
    @Compile
    public final void II_method_6642fd22() {
        if (FlightModule.I_field_3a9bda27.player == null || FlightModule.I_field_3a9bda27.world == null) {
            return;
        }
        if (this.I_field_500d0627.isSelected()) {
            this.I_method_295d8bd5(FlightModule.I_field_3a9bda27.player);
            return;
        }
        this.iIi_method_d7abc5ac();
    }

    @Override
    public final void onDisable() {
        this.iIi_method_d7abc5ac();
        this.iiI_method_d96029ec();
        if (this.ii_field_5a && FlightModule.I_field_3a9bda27.player != null) {
            this.iII_method_d79d39cc();
        }
        this.ii_field_5a = false;
        super.onDisable();
    }

    private void Iii_method_a2d3a1ec() {
        iIIiiiIiI_Class315 iIIiiiIiI_Class3152 = iIIiIiIiI_Class299.i_method_e5bad375();
        if (iIIiiiIiI_Class3152.I_method_158af795() == Items.ELYTRA) {
            return;
        }
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.I_method_6a489695().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75()).I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
        iIIiIiIii_Class300 iIIiIiIii_Class3002 = iIIiiIiII_Class3092.I_method_77fa4424(itemStack -> itemStack.getItem() == Items.ELYTRA && !itemStack.willBreakNextUse());
        if (iIIiIiIii_Class3002 == null) {
            return;
        }
        this.ii_field_5a = true;
        this.I_field_112315fc.I_method_6786cfc7(iIIiIiIii_Class3002, iIIiiiIiI_Class3152);
    }

    private void iII_method_d79d39cc() {
        iIIiiiIiI_Class315 iIIiiiIiI_Class3152 = iIIiIiIiI_Class299.i_method_e5bad375();
        if (iIIiiiIiI_Class3152.I_method_158af795() != Items.ELYTRA) {
            return;
        }
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.I_method_6a489695().I_method_fdeecb5d(iIIiiIiIi_Class310.i_method_7fde0a75()).I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
        iIIiIiIii_Class300 iIIiIiIii_Class3002 = FlightModule.I_method_a6d97710(iIIiiIiII_Class3092);
        if (iIIiIiIii_Class3002 == null) {
            return;
        }
        this.I_field_112315fc.I_method_6786cfc7(iIIiIiIii_Class3002, iIIiiiIiI_Class3152);
    }

    private static iIIiIiIii_Class300 I_method_a6d97710(iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092) {
        iIIiIiIii_Class300 iIIiIiIii_Class3002 = null;
        int n = Integer.MIN_VALUE;
        for (iIIiIiIii_Class300 iIIiIiIii_Class3003 : iIIiiIiII_Class3092.I_method_617d3e68()) {
            int n2;
            ArmorItem armorItem;
            Item item;
            ItemStack itemStack = iIIiIiIii_Class3003.I_method_7b7e0bb9();
            if (itemStack.isEmpty() || !((item = itemStack.getItem()) instanceof ArmorItem) || ((iIiIiiIIi_Class346)(armorItem = (ArmorItem)item)).rockstar$getType() != EquipmentType.CHESTPLATE || (n2 = FlightModule.I_method_83c85be6(armorItem, itemStack)) <= n) continue;
            n = n2;
            iIIiIiIii_Class3002 = iIIiIiIii_Class3003;
        }
        return iIIiIiIii_Class3002;
    }

    private static int I_method_83c85be6(ArmorItem armorItem, ItemStack itemStack) {
        IiiiiIiii_Class248.Nested1_95187080 nested1_95187080 = IiiiiIiii_Class248.I_method_7613ca72(itemStack);
        if (nested1_95187080 != null && "SunHelmet".equals(nested1_95187080.I_method_3665aca6())) {
            return Integer.MAX_VALUE;
        }
        ArmorMaterial armorMaterial = ((iIiIiiIIi_Class346)armorItem).rockstar$getMaterial();
        EquipmentType equipmentType = ((iIiIiiIIi_Class346)armorItem).rockstar$getType();
        int n = armorMaterial.defense().getOrDefault(equipmentType, 0);
        int n2 = (int)armorMaterial.toughness();
        int n3 = iIIiIiIIi_Class298.I_method_7ea237bf(itemStack, (RegistryKey<Enchantment>)Enchantments.PROTECTION);
        return n * 5 + n3 * 3 + n2;
    }

    private void I_method_295d8bd5(ClientPlayerEntity clientPlayerEntity) {
        PlayerAbilities playerAbilities = clientPlayerEntity.getAbilities();
        if (!this.I_field_5a) {
            this.i_field_5a = playerAbilities.allowFlying;
            this.II_field_5a = playerAbilities.flying;
            this.I_field_46 = playerAbilities.getFlySpeed();
            this.I_field_5a = true;
        }
        if (!playerAbilities.allowFlying) {
            playerAbilities.allowFlying = true;
        }
        if (!playerAbilities.flying) {
            playerAbilities.flying = true;
        }
        float f = Math.clamp(0.05f * this.I_field_73178e8c.Ii_method_a20abcd2(), 0.0f, 1.0f);
        if (Math.abs(playerAbilities.getFlySpeed() - f) > 1.0E-4f) {
            playerAbilities.setFlySpeed(f);
        }
    }

    private void iIi_method_d7abc5ac() {
        if (!this.I_field_5a) {
            return;
        }
        this.I_field_5a = false;
        if (FlightModule.I_field_3a9bda27.player == null) {
            return;
        }
        PlayerAbilities playerAbilities = FlightModule.I_field_3a9bda27.player.getAbilities();
        if (!FlightModule.I_field_3a9bda27.player.isCreative() && !FlightModule.I_field_3a9bda27.player.isSpectator()) {
            playerAbilities.allowFlying = this.i_field_5a;
            playerAbilities.flying = this.II_field_5a;
        }
        playerAbilities.setFlySpeed(this.I_field_46);
    }

    private void iiI_method_d96029ec() {
        this.I_field_49 = 0;
        this.Ii_field_5a = false;
        this.iI_field_5a = false;
    }

    static class Nested1_9121b4d3
    implements iIIiIIiIi_Class294 {
        private Nested2_cf87d0b8 I_field_54b539b7;
        private boolean I_field_5a;
        private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> this.I_method_8e875ac7();

        Nested1_9121b4d3() {
        }

        void I_method_6786cfc7(iIIiIiIii_Class300 iIIiIiIii_Class3002, iIIiIiIii_Class300 iIIiIiIii_Class3003) {
            this.I_field_54b539b7 = new Nested2_cf87d0b8(iIIiIiIii_Class3002, iIIiIiIii_Class3003);
            if (!this.I_field_5a) {
                RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
                this.I_field_5a = true;
            }
        }

        private void I_method_8e875ac7() {
            if (Nested1_9121b4d3.I_field_3a9bda27.player == null) {
                this.I_field_54b539b7 = null;
                this.i_method_8e95e6a7();
                return;
            }
            if (this.I_field_54b539b7 == null) {
                this.i_method_8e95e6a7();
                return;
            }
            GuiMoveModule iIIiIiIII_Class41 = RockstarClient.getInstance().getModuleManager().getModule(GuiMoveModule.class);
            if (this.I_field_54b539b7.I_field_1242a2ac.I_method_dfe89252() >= 36 && this.I_field_54b539b7.I_field_1242a2ac.I_method_dfe89252() <= 44) {
                iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_54b539b7.i_field_1242a2ac.I_method_dfe89252(), this.I_field_54b539b7.I_field_1242a2ac.I_method_dfe89252() - 36);
                this.I_field_54b539b7 = null;
            } else if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
                if (this.I_field_54b539b7.I_field_49 == 0 && iIIiIiIII_Class41.I_method_eb75c1e8().isEmpty()) {
                    iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_54b539b7.I_field_1242a2ac.I_method_dfe89252(), 8);
                    iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_54b539b7.i_field_1242a2ac.I_method_dfe89252(), 8);
                    iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_54b539b7.I_field_1242a2ac.I_method_dfe89252(), 8);
                    ++this.I_field_54b539b7.I_field_49;
                } else if (this.I_field_54b539b7.I_field_49 == 1 && iIIiIiIII_Class41.I_method_eb75c1e8().isEmpty()) {
                    ++this.I_field_54b539b7.I_field_49;
                } else if (this.I_field_54b539b7.I_field_49 == 2 && iIIiIiIII_Class41.I_method_eb75c1e8().isEmpty()) {
                    ++this.I_field_54b539b7.I_field_49;
                }
            } else if (this.I_field_54b539b7.I_field_49 == 0 && iIIiIiIII_Class41.I_method_eb75c1e8().isEmpty()) {
                iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_54b539b7.I_field_1242a2ac.I_method_dfe89252(), 8);
                ++this.I_field_54b539b7.I_field_49;
            } else if (this.I_field_54b539b7.I_field_49 == 1 && iIIiIiIII_Class41.I_method_eb75c1e8().isEmpty()) {
                iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_54b539b7.i_field_1242a2ac.I_method_dfe89252(), 8);
                ++this.I_field_54b539b7.I_field_49;
            } else if (this.I_field_54b539b7.I_field_49 == 2 && iIIiIiIII_Class41.I_method_eb75c1e8().isEmpty()) {
                iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_54b539b7.I_field_1242a2ac.I_method_dfe89252(), 8);
                ++this.I_field_54b539b7.I_field_49;
            }
            if (this.I_field_54b539b7 != null && this.I_field_54b539b7.I_field_49 >= 3) {
                this.I_field_54b539b7 = null;
            }
            if (this.I_field_54b539b7 == null) {
                this.i_method_8e95e6a7();
            }
        }

        private void i_method_8e95e6a7() {
            if (this.I_field_5a) {
                RockstarClient.getInstance().I_method_7897deab().i_method_f30f2128(this);
                this.I_field_5a = false;
            }
        }

        static class Nested2_cf87d0b8 {
            int I_field_49;
            final iIIiIiIii_Class300 I_field_1242a2ac;
            final iIIiIiIii_Class300 i_field_1242a2ac;

            Nested2_cf87d0b8(iIIiIiIii_Class300 iIIiIiIii_Class3002, iIIiIiIii_Class300 iIIiIiIii_Class3003) {
                this.I_field_1242a2ac = iIIiIiIii_Class3002;
                this.i_field_1242a2ac = iIIiIiIii_Class3003;
            }
        }
    }
}

