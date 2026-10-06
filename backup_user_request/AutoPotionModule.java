package rockstar.client;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SplashPotionItem;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.c2s.play.UpdateSelectedSlotC2SPacket;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Hand;
import pyrock.events.player.ClientPlayerTickEvent;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.iIIIIIiII_Class261;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.iIIiiiIii_Class316;
import rockstar.client.iIIiiiiII_Class317;
import rockstar.client.iiIIiIIIi_Class402;
import rockstar.client.iiIIiIIii_Class404;
import rockstar.client.iiIIiIiiI_Class407;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Potion", category=ModuleCategory.COMBAT, III_method_a89e5834="modules.descriptions.auto_potion")
public class AutoPotionModule
extends Module {
    private MultiSelectSetting I_field_bbe3ba6c;
    private Nested1_96bf8133 I_field_bf3ed59c;
    private Nested1_96bf8133 i_field_bf3ed59c;
    private Nested1_96bf8133 II_field_bf3ed59c;
    private int I_field_49;
    private int i_field_49;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = clientPlayerTickEvent -> {
        if (AutoPotionModule.I_field_3a9bda27.player == null || AutoPotionModule.I_field_3a9bda27.world == null || AutoPotionModule.I_field_3a9bda27.interactionManager == null || I_field_3a9bda27.getNetworkHandler() == null || AutoPotionModule.I_field_3a9bda27.player.isGliding()) {
            return;
        }
        ++this.I_field_49;
        List<iIIiIiIii_Class300> list = this.I_method_8f0b585b();
        if (this.I_field_49 < 20 || list.isEmpty()) {
            this.i_field_49 = 0;
            return;
        }
        float f = AutoPotionModule.I_field_3a9bda27.player.getYaw();
        iiIIiIIii_Class404 iiIIiIIii_Class4042 = new iiIIiIIii_Class404(f, 90.0f);
        float f2 = ThreadLocalRandom.current().nextFloat(275.0f, 444.0f);
        RockstarClient.getInstance().I_method_58785402().I_method_1acbf705(iiIIiIIii_Class4042, iiIIiIIIi_Class402.Ii_field_32e0c64c, f2, f2, f2, iiIIiIiiI_Class407.iI_field_32efc66c);
        if (RockstarClient.getInstance().I_method_58785402().i_method_10b2eeb5().I_method_24e31c97(iiIIiIIii_Class4042) > 1.0f) {
            this.i_field_49 = 0;
            return;
        }
        if (this.i_field_49++ < 1) {
            return;
        }
        int n2 = AutoPotionModule.I_field_3a9bda27.player.getInventory().selectedSlot;
        boolean bl = false;
        for (iIIiIiIii_Class300 iIIiIiIii_Class3002 : list) {
            if (!this.I_method_eec9a27e(iIIiIiIii_Class3002)) continue;
            if (iIIiIiIii_Class3002 instanceof iIIiiiIii_Class316) {
                int n3;
                iIIiiiIii_Class316 iIIiiiIii_Class3162 = (iIIiiiIii_Class316)iIIiIiIii_Class3002;
                AutoPotionModule.I_field_3a9bda27.player.getInventory().selectedSlot = n3 = iIIiiiIii_Class3162.II_method_b9cf08f5();
                I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new UpdateSelectedSlotC2SPacket(n3));
                AutoPotionModule.I_field_3a9bda27.interactionManager.sendSequencedPacket(AutoPotionModule.I_field_3a9bda27.world, n -> new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, n, f, 90.0f));
            } else {
                iIIiIiIiI_Class299.iI_method_c617e8c2(iIIiIiIii_Class3002.I_method_dfe89252(), n2);
                I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new UpdateSelectedSlotC2SPacket(n2));
                AutoPotionModule.I_field_3a9bda27.interactionManager.sendSequencedPacket(AutoPotionModule.I_field_3a9bda27.world, n -> new PlayerInteractItemC2SPacket(Hand.MAIN_HAND, n, f, 90.0f));
                iIIiIiIiI_Class299.iI_method_c617e8c2(iIIiIiIii_Class3002.I_method_dfe89252(), n2);
            }
            bl = true;
        }
        AutoPotionModule.I_field_3a9bda27.player.getInventory().selectedSlot = n2;
        I_field_3a9bda27.getNetworkHandler().sendPacket((Packet)new UpdateSelectedSlotC2SPacket(n2));
        this.i_field_49 = 0;
        if (bl) {
            this.I_field_49 = 0;
            RockstarClient.getInstance().I_method_58785402().i_method_3e2418e7(new iiIIiIIii_Class404(AutoPotionModule.I_field_3a9bda27.player.getYaw(), AutoPotionModule.I_field_3a9bda27.player.getPitch()));
        }
    };

    public AutoPotionModule() {
        this.IiI_method_57b805ac();
    }

    @Compile(obfuscation=4)
    private void IiI_method_57b805ac() {
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.auto_potion.potions");
        this.I_field_bf3ed59c = new Nested1_96bf8133(this.I_field_bbe3ba6c, "modules.settings.auto_potion.potions.strength", (RegistryEntry<StatusEffect>)StatusEffects.STRENGTH);
        this.I_field_bf3ed59c.select();
        this.i_field_bf3ed59c = new Nested1_96bf8133(this.I_field_bbe3ba6c, "modules.settings.auto_potion.potions.speed", (RegistryEntry<StatusEffect>)StatusEffects.SPEED);
        this.i_field_bf3ed59c.select();
        this.II_field_bf3ed59c = new Nested1_96bf8133(this.I_field_bbe3ba6c, "modules.settings.auto_potion.potions.fire_resistance", (RegistryEntry<StatusEffect>)StatusEffects.FIRE_RESISTANCE);
        this.II_field_bf3ed59c.select();
    }

    @Override
    public void onEnable() {
        this.I_field_49 = 20;
        this.i_field_49 = 0;
    }

    @Override
    public void onDisable() {
        this.i_field_49 = 0;
        if (AutoPotionModule.I_field_3a9bda27.player != null) {
            RockstarClient.getInstance().I_method_58785402().i_method_3e2418e7(new iiIIiIIii_Class404(AutoPotionModule.I_field_3a9bda27.player.getYaw(), AutoPotionModule.I_field_3a9bda27.player.getPitch()));
        }
    }

    private List<iIIiIiIii_Class300> I_method_8f0b585b() {
        ArrayList<iIIiIiIii_Class300> arrayList = new ArrayList<iIIiIiIii_Class300>();
        Predicate<ItemStack> predicate = itemStack -> !itemStack.isEmpty() && itemStack.getItem() instanceof SplashPotionItem;
        for (Nested1_96bf8133 nested1_96bf8133 : this.i_method_4457907b()) {
            RegistryEntry<StatusEffect> registryEntry = nested1_96bf8133.I_field_3b804775;
            if (AutoPotionModule.I_field_3a9bda27.player.hasStatusEffect(registryEntry)) continue;
            Predicate<ItemStack> predicate2 = this.I_method_5e3bf524(registryEntry);
            iIIiiiIii_Class316 iIIiiiIii_Class3162 = iIIiiIiIi_Class310.I_method_6a489695().I_method_77fa4424(itemStack -> predicate.test((ItemStack)itemStack) && predicate2.test((ItemStack)itemStack));
            if (iIIiiiIii_Class3162 != null && this.I_method_eec9a27e(iIIiiiIii_Class3162)) {
                arrayList.add(iIIiiiIii_Class3162);
                continue;
            }
            iIIiiiiII_Class317 iIIiiiiII_Class3172 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_77fa4424(itemStack -> predicate.test((ItemStack)itemStack) && predicate2.test((ItemStack)itemStack));
            if (iIIiiiiII_Class3172 == null || !this.I_method_eec9a27e(iIIiiiiII_Class3172)) continue;
            arrayList.add(iIIiiiiII_Class3172);
        }
        return arrayList;
    }

    private List<Nested1_96bf8133> i_method_4457907b() {
        List<Nested1_96bf8133> list = List.of(this.I_field_bf3ed59c, this.i_field_bf3ed59c, this.II_field_bf3ed59c);
        List<Nested1_96bf8133> list2 = this.I_field_bbe3ba6c.i_method_faf6de68().stream().map(Nested1_96bf8133.class::cast).toList();
        ArrayList<Nested1_96bf8133> arrayList = new ArrayList<Nested1_96bf8133>();
        for (Nested1_96bf8133 nested1_96bf8133 : list) {
            if (!list2.contains(nested1_96bf8133)) continue;
            arrayList.add(nested1_96bf8133);
        }
        return arrayList;
    }

    private boolean I_method_eec9a27e(iIIiIiIii_Class300 iIIiIiIii_Class3002) {
        ItemStack itemStack = iIIiIiIii_Class3002.I_method_7b7e0bb9();
        return !itemStack.isEmpty() && itemStack.getItem() instanceof SplashPotionItem;
    }

    private Predicate<ItemStack> I_method_5e3bf524(RegistryEntry<StatusEffect> registryEntry) {
        return itemStack -> {
            if (itemStack.isEmpty() || !(itemStack.getItem() instanceof SplashPotionItem)) {
                return false;
            }
            return iIIIIIiII_Class261.I_method_2d41c106(itemStack).stream().anyMatch(statusEffectInstance -> statusEffectInstance.getEffectType() == registryEntry);
        };
    }

    static class Nested1_96bf8133
    extends MultiSelectSetting.Nested1_42856060 {
        final RegistryEntry<StatusEffect> I_field_3b804775;

        Nested1_96bf8133(MultiSelectSetting iIiiiiiii_Class128, String string, RegistryEntry<StatusEffect> registryEntry) {
            super(iIiiiiiii_Class128, string);
            this.I_field_3b804775 = registryEntry;
        }
    }
}

