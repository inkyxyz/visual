package rockstar.client;

import java.util.Comparator;
import java.util.List;
import lombok.Generated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import org.jetbrains.annotations.Nullable;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.KeybindSetting;
import rockstar.client.ModeSetting;
import rockstar.client.MultiSelectSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiIiii_Class248;
import rockstar.client.IiiiiiIII_Class249;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iIIIiiIii_Class284;
import rockstar.client.iIIIiiiII_Class285;
import rockstar.client.iIIiIiIiI_Class299;
import rockstar.client.iIIiIiIii_Class300;
import rockstar.client.iIIiiIiII_Class309;
import rockstar.client.iIIiiIiIi_Class310;
import rockstar.client.Module;
import rockstar.client.iiIiIIiii_Class424;
import rockstar.client.AutoTotemModule;
import rockstar.client.iiiIiIi_Class118;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Auto Swap", category=ModuleCategory.PLAYER)
public class AutoSwapModule
extends Module {
    private KeybindSetting I_field_ba20522c;
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting i_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting II_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private ModeSetting.Nested1_42765c60 Ii_field_500d0627;
    private KeybindSetting i_field_ba20522c;
    private KeybindSetting II_field_ba20522c;
    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
    private MultiSelectSetting i_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 III_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 IIi_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 IiI_field_51de8227;
    private boolean I_field_5a;
    private boolean i_field_5a;
    private boolean II_field_5a;
    private int I_field_49 = -1;
    private static final long I_field_4a = 1000L;
    private static final float I_field_46 = 2.0f;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
    private float i_field_46 = -1.0f;
    private final IiIIIiII_Class69<KeyPressEvent> I_field_3d936f41 = keyPressEvent -> {
        KeybindSetting iIiiiIiIi_Class118;
        if (keyPressEvent.getAction() != 1 || AutoSwapModule.I_field_3a9bda27.currentScreen != null) {
            return;
        }
        KeybindSetting iIiiiIiIi_Class1182 = iIiiiIiIi_Class118 = this.II_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627) ? this.i_field_ba20522c : this.II_field_ba20522c;
        if (iIiiiIiIi_Class118.I_method_51ee2d08(keyPressEvent.getKey())) {
            this.iII_method_6927827f();
        }
        if (this.I_field_ba20522c.I_method_51ee2d08(keyPressEvent.getKey()) && !this.i_field_5a && this.iiI_method_6aea72a3()) {
            this.iIi_method_69360e5f();
        }
    };
    private final IiIIIiII_Class69<MouseEvent> i_field_3d936f41 = mouseEvent -> {
        if (AutoSwapModule.I_field_3a9bda27.currentScreen != null) {
            return;
        }
        if (this.i_field_ba20522c.I_method_51ee2d08(mouseEvent.getButton()) || this.II_field_ba20522c.I_method_51ee2d08(mouseEvent.getButton())) {
            boolean bl = this.I_field_5a = !this.I_field_5a;
        }
        if (this.I_field_ba20522c.I_method_51ee2d08(mouseEvent.getButton()) && !this.i_field_5a && this.iiI_method_6aea72a3()) {
            this.iIi_method_69360e5f();
        }
    };

    public AutoSwapModule() {
        this.IiI_method_344f5ebf();
    }

    @Compile(obfuscation=4)
    private void IiI_method_344f5ebf() {
        this.I_field_ba20522c = new KeybindSetting(this, "modules.settings.auto_swap.button");
        this.I_field_bbe33e6c = new ModeSetting(this, "modules.settings.auto_swap.item");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_swap.item.talisman").select();
        this.i_field_bbe33e6c = new ModeSetting(this, "modules.settings.auto_swap.swap_to");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_swap.swap_to.talisman").select();
        this.II_field_bbe33e6c = new ModeSetting(this, "\u0421\u0435\u0440\u0432\u0435\u0440");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "HW").select();
        this.Ii_field_500d0627 = new ModeSetting.Nested1_42765c60(this.II_field_bbe33e6c, "VonTam");
        this.i_field_ba20522c = new KeybindSetting(this, "modules.settings.auto_swap.auto_cerber", () -> !this.II_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627));
        this.II_field_ba20522c = new KeybindSetting(this, "\u0410\u0432\u0442\u043e \u044f\u0440\u043e\u0441\u0442\u044c/\u043a\u0430\u0440\u0430\u0442\u0435\u043b\u044c", () -> !this.II_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627));
        this.I_field_bbe3ba6c = new MultiSelectSetting((IIiiiIIiI_Class115)this, "\u0411\u0440\u0430\u0442\u044c \u0426\u0435\u0440\u0431\u0435\u0440", () -> !this.II_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627));
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "\u0412\u0441\u0435\u0433\u0434\u0430");
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "\u041a\u043e\u0433\u0434\u0430 \u0431\u0435\u0437 \u043c\u0435\u0447\u0430", this.I_field_51de8227::isSelected).select();
        this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "\u041a\u043e\u0433\u0434\u0430 \u043b\u0438\u0432\u0430\u0435\u0442", this.I_field_51de8227::isSelected).select();
        this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "\u041a\u043e\u0433\u0434\u0430 \u0432 \u044d\u043b\u0438\u0442\u0440\u0435", this.I_field_51de8227::isSelected).select();
        this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "\u0415\u0441\u043b\u0438 \u0442\u0435\u0431\u044f \u043d\u0435 \u0431\u044c\u044e\u0442");
        this.i_field_bbe3ba6c = new MultiSelectSetting((IIiiiIIiI_Class115)this, "\u0411\u0440\u0430\u0442\u044c \u044f\u0440\u043e\u0441\u0442\u044c/\u043a\u0430\u0440\u0430\u0442\u0435\u043b\u044f", () -> !this.II_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627));
        this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "\u0412\u0441\u0435\u0433\u0434\u0430");
        this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "\u041a\u043e\u0433\u0434\u0430 \u0431\u0435\u0437 \u043c\u0435\u0447\u0430", this.ii_field_51de8227::isSelected).select();
        this.IIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "\u041a\u043e\u0433\u0434\u0430 \u043b\u0438\u0432\u0430\u0435\u0442", this.ii_field_51de8227::isSelected).select();
        this.IiI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "\u041a\u043e\u0433\u0434\u0430 \u0432 \u044d\u043b\u0438\u0442\u0440\u0435", this.ii_field_51de8227::isSelected).select();
        new ModeSetting.Nested1_42765c60(this.i_field_bbe33e6c, "modules.settings.auto_swap.swap_to.orb");
        new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "modules.settings.auto_swap.item.orb");
    }

    @Override
    public void onEnable() {
        super.onEnable();
        this.I_field_5a = false;
        this.i_field_5a = false;
        this.II_field_5a = false;
        this.I_field_49 = -1;
        this.Iii_method_345dea9f();
    }

    @Override
    public void onDisable() {
        super.onDisable();
        this.I_field_5a = false;
        this.i_field_5a = false;
        this.II_field_5a = false;
        this.I_field_49 = -1;
        this.Iii_method_345dea9f();
    }

    private void Iii_method_345dea9f() {
        this.i_field_991c1e8c.I_method_58432065(0L);
        this.i_field_46 = -1.0f;
    }

    @Override
    public void II_method_6642fd22() {
        LivingEntity livingEntity;
        LivingEntity livingEntity2;
        Entity entity = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815();
        LivingEntity livingEntity3 = livingEntity2 = entity instanceof LivingEntity ? (livingEntity = (LivingEntity)entity) : null;
        if (AutoSwapModule.I_field_3a9bda27.player == null) {
            return;
        }
        this.iii_method_6af8fe7f();
        boolean bl = this.I_method_f8ddf765(iIIiIiIiI_Class299.I_method_d0337735().I_method_7b7e0bb9());
        if (!bl) {
            this.i_field_5a = false;
        }
        if (this.i_field_5a && this.I_field_49 != -1 && !this.I_method_211e2a02(livingEntity2)) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_49, 40);
            this.II_field_5a = true;
            this.I_field_49 = -1;
            this.i_field_5a = false;
            return;
        }
        if (!this.I_field_5a || livingEntity2 == null) {
            return;
        }
        if (this.I_method_211e2a02(livingEntity2) && !this.i_field_5a && this.iiI_method_6aea72a3()) {
            this.iiI_method_6aea729f();
            this.i_field_5a = true;
        }
    }

    public boolean IiI_method_344f5ec3() {
        if (!this.isEnabled() || AutoSwapModule.I_field_3a9bda27.player == null) {
            return false;
        }
        return this.I_field_5a && (this.i_field_5a || this.I_method_f8ddf765(iIIiIiIiI_Class299.I_method_d0337735().I_method_7b7e0bb9()));
    }

    private void iII_method_6927827f() {
        boolean bl = this.I_field_5a = !this.I_field_5a;
        if (!this.I_field_5a && this.i_field_5a && this.I_field_49 != -1) {
            iIIiIiIiI_Class299.iI_method_c617e8c2(this.I_field_49, 40);
            this.I_field_49 = -1;
            this.i_field_5a = false;
        }
    }

    private void iIi_method_69360e5f() {
        boolean bl;
        if (AutoSwapModule.I_field_3a9bda27.currentScreen != null || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.i_field_ac164e6c) && !this.I_field_991c1e8c.I_method_58432069(150L)) {
            return;
        }
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695()).I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
        boolean bl2 = bl = !this.I_field_500d0627.isSelected() && !this.i_field_500d0627.isSelected();
        if (this.II_field_500d0627.isSelected() && bl) {
            this.I_method_df416067(iIIiiIiII_Class3092);
            return;
        }
        List<@Nullable iIIiIiIii_Class300> list = iIIiiIiII_Class3092.I_method_fe8cb900(this.I_field_500d0627.isSelected() ? Items.TOTEM_OF_UNDYING : Items.PLAYER_HEAD);
        List<@Nullable iIIiIiIii_Class300> list2 = iIIiiIiII_Class3092.I_method_fe8cb900(this.i_field_500d0627.isSelected() ? Items.TOTEM_OF_UNDYING : Items.PLAYER_HEAD);
        iIIiIiIii_Class300 iIIiIiIii_Class3004 = list.stream().min(Comparator.comparingInt(iIIiIiIii_Class3002 -> IiiiiiIII_Class249.i_method_ada0ef54(iIIiIiIii_Class3002.I_method_7b7e0bb9()) - (iIIiIiIii_Class3002.I_method_dfe89252() == 45 ? 199 : this.I_method_4b1994ba((iIIiIiIii_Class300)iIIiIiIii_Class3002)))).orElse(null);
        iIIiIiIii_Class300 iIIiIiIii_Class3005 = list2.stream().filter(iIIiIiIii_Class3003 -> iIIiIiIii_Class3004 != iIIiIiIii_Class3003).min(Comparator.comparingInt(iIIiIiIii_Class3002 -> IiiiiiIII_Class249.i_method_ada0ef54(iIIiIiIii_Class3002.I_method_7b7e0bb9()) - (iIIiIiIii_Class3002.I_method_dfe89252() == 45 ? 199 : this.I_method_4b1994ba((iIIiIiIii_Class300)iIIiIiIii_Class3002)))).orElse(null);
        if (iIIiIiIii_Class3004 == null || iIIiIiIii_Class3005 == null) {
            return;
        }
        iIIiIiIiI_Class299.iI_method_c617e8c2((AutoSwapModule.I_field_3a9bda27.player.getOffHandStack().getItem() == iIIiIiIii_Class3004.I_method_158af795() ? iIIiIiIii_Class3005 : iIIiIiIii_Class3004).I_method_dfe89252(), 40);
        this.I_field_991c1e8c.I_method_23e11e3f();
        ItemStack itemStack = AutoSwapModule.I_field_3a9bda27.player.getOffHandStack();
        IiiiiIiii_Class248.Nested1_95187080 nested1_95187080 = IiiiiIiii_Class248.I_method_7613ca72(itemStack);
        if (nested1_95187080 != null && itemStack.getItem() != Items.AIR) {
            String string = nested1_95187080.I_method_2310f504(itemStack);
            RockstarClient.getInstance().I_method_5cb1af22().I_method_67864747(new iiiIiIi_Class118(IiIiIIII_Class81.I_method_1410d1e5("alerts.moved_to_offhand", string), itemStack).I_method_7ab92a7f(string).I_method_c9efc756(nested1_95187080.I_method_40d7118b(itemStack)));
        }
    }

    private void I_method_df416067(iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092) {
        ItemStack itemStack2;
        ItemStack itemStack3;
        List<ItemStack> list = iIIiiIiII_Class3092.I_method_fe8cb900(Items.PLAYER_HEAD).stream().filter(iIIiIiIii_Class3002 -> iIIiIiIii_Class3002 != null && iIIiIiIii_Class3002.I_method_7b7e0bb9() != null).map(iIIiIiIii_Class300::I_method_7b7e0bb9).filter(itemStack -> {
            IiiiiIiii_Class248.Nested1_95187080 nested1_95187080 = IiiiiIiii_Class248.I_method_7613ca72(itemStack);
            return nested1_95187080 != null && nested1_95187080.Ii_method_e2d6074b();
        }).toList();
        ItemStack itemStack4 = AutoSwapModule.I_field_3a9bda27.player.getOffHandStack();
        ItemStack itemStack5 = IiiiiiIII_Class249.ii_method_b6087cc5(list);
        ItemStack itemStack6 = IiiiiiIII_Class249.III_method_6e3ca08(list);
        if (itemStack5 != null && itemStack6 != null) {
            itemStack3 = ItemStack.areEqual((ItemStack)itemStack4, (ItemStack)itemStack5) ? itemStack6 : itemStack5;
        } else {
            itemStack2 = IiiiiiIII_Class249.IIi_method_f8170a28(list);
            if (itemStack6 != null && itemStack2 != null) {
                itemStack3 = ItemStack.areEqual((ItemStack)itemStack4, (ItemStack)itemStack6) ? itemStack2 : itemStack6;
            } else {
                return;
            }
        }
        if (ItemStack.areEqual((ItemStack)itemStack3, (ItemStack)itemStack4)) {
            return;
        }
        ItemStack targetHead = itemStack3;
        iIIiIiIii_Class300 iIIiIiIii_Class3003 = iIIiiIiII_Class3092.I_method_fe8cb900(Items.PLAYER_HEAD).stream().filter(iIIiIiIii_Class3002 -> ItemStack.areEqual(iIIiIiIii_Class3002.I_method_7b7e0bb9(), targetHead)).findFirst().orElse(null);
        if (iIIiIiIii_Class3003 == null || iIIiIiIii_Class3003.I_method_dfe89252() == 45) {
            return;
        }
        iIIiIiIiI_Class299.iI_method_c617e8c2(iIIiIiIii_Class3003.I_method_dfe89252(), 40);
        this.I_field_991c1e8c.I_method_23e11e3f();
        IiiiiIiii_Class248.Nested1_95187080 nested1_95187080 = IiiiiIiii_Class248.I_method_7613ca72(targetHead);
        if (nested1_95187080 != null) {
            String string = nested1_95187080.I_method_2310f504(targetHead);
            RockstarClient.getInstance().I_method_5cb1af22().I_method_67864747(new iiiIiIi_Class118(IiIiIIII_Class81.I_method_1410d1e5("alerts.moved_to_offhand", string), targetHead).I_method_7ab92a7f(string).I_method_c9efc756(nested1_95187080.I_method_40d7118b(targetHead)));
        }
    }

    private void iiI_method_6aea729f() {
        if (AutoSwapModule.I_field_3a9bda27.currentScreen != null) {
            return;
        }
        iIIiiIiII_Class309<iIIiIiIii_Class300> iIIiiIiII_Class3092 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695()).I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38());
        List<@Nullable iIIiIiIii_Class300> list = iIIiiIiII_Class3092.I_method_144f4b9(this::I_method_f8ddf765);
        iIIiIiIii_Class300 iIIiIiIii_Class3003 = list.stream().filter(iIIiIiIii_Class3002 -> iIIiIiIii_Class3002.I_method_dfe89252() != 45).min(Comparator.comparingInt(this::i_method_e8329cda).thenComparing(iIIiIiIii_Class3002 -> IiiiiiIII_Class249.i_method_ada0ef54(iIIiIiIii_Class3002.I_method_7b7e0bb9()))).orElse(null);
        if (iIIiIiIii_Class3003 == null) {
            return;
        }
        this.I_field_49 = iIIiIiIii_Class3003.I_method_dfe89252();
        ItemStack itemStack = iIIiIiIii_Class3003.I_method_7b7e0bb9();
        iIIiIiIiI_Class299.iI_method_c617e8c2(iIIiIiIii_Class3003.I_method_dfe89252(), 40);
        IiiiiIiii_Class248.Nested1_95187080 nested1_95187080 = IiiiiIiii_Class248.I_method_7613ca72(itemStack);
        if (nested1_95187080 != null && itemStack.getItem() != Items.AIR) {
            String string = nested1_95187080.I_method_2310f504(itemStack);
            RockstarClient.getInstance().I_method_5cb1af22().I_method_67864747(new iiiIiIi_Class118(IiIiIIII_Class81.I_method_1410d1e5("alerts.moved_to_offhand", string), itemStack).I_method_7ab92a7f(string).I_method_c9efc756(nested1_95187080.I_method_40d7118b(itemStack)));
        }
    }

    private boolean iiI_method_6aea72a3() {
        return !RockstarClient.getInstance().getModuleManager().getModule(AutoTotemModule.class).Iii_method_6f0929f0();
    }

    private void iii_method_6af8fe7f() {
        float f = AutoSwapModule.I_field_3a9bda27.player.getHealth() + AutoSwapModule.I_field_3a9bda27.player.getAbsorptionAmount();
        if (this.i_field_46 >= 0.0f && AutoSwapModule.I_field_3a9bda27.player.hurtTime > 0 && this.i_field_46 - f >= 2.0f) {
            this.i_field_991c1e8c.I_method_23e11e3f();
        }
        this.i_field_46 = f;
    }

    private boolean I_method_211e2a02(LivingEntity livingEntity) {
        PlayerEntity playerEntity;
        if (!this.I_field_5a) {
            return false;
        }
        if (this.iii_method_6af8fe83() && !this.i_field_991c1e8c.I_method_58432069(1000L)) {
            return false;
        }
        if (this.IIII_method_1f105ca6()) {
            return true;
        }
        if (AutoSwapModule.I_field_3a9bda27.player.hurtTime > 0 || livingEntity == null) {
            return false;
        }
        if (this.IIIi_method_1f1ee886() && !(livingEntity.getMainHandStack().getItem() instanceof SwordItem)) {
            return true;
        }
        if (this.IIiI_method_20d34cc6() && IiiiiiiII_Class253.i_method_efa40a22(livingEntity) && !AutoSwapModule.I_field_3a9bda27.player.isTouchingWater()) {
            return true;
        }
        return this.IIii_method_20e1d8a6() && livingEntity instanceof PlayerEntity && (playerEntity = (PlayerEntity)livingEntity).getInventory().getArmorStack(2).getItem() == Items.ELYTRA;
    }

    private boolean iii_method_6af8fe83() {
        return this.II_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627) && this.iI_field_51de8227.isSelected();
    }

    private boolean IIII_method_1f105ca6() {
        return this.II_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627) ? this.I_field_51de8227.isSelected() : this.ii_field_51de8227.isSelected();
    }

    private boolean IIIi_method_1f1ee886() {
        return this.II_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627) ? this.i_field_51de8227.isSelected() : this.III_field_51de8227.isSelected();
    }

    private boolean IIiI_method_20d34cc6() {
        return this.II_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627) ? this.II_field_51de8227.isSelected() : this.IIi_field_51de8227.isSelected();
    }

    private boolean IIii_method_20e1d8a6() {
        return this.II_field_bbe33e6c.I_method_ce989e26(this.II_field_500d0627) ? this.Ii_field_51de8227.isSelected() : this.IiI_field_51de8227.isSelected();
    }

    private int I_method_4b1994ba(iIIiIiIii_Class300 iIIiIiIii_Class3002) {
        return this.I_field_5a && this.I_method_f8ddf765(iIIiIiIii_Class3002.I_method_7b7e0bb9()) ? -99 : 0;
    }

    private boolean I_method_f8ddf765(ItemStack itemStack) {
        if (itemStack == null || itemStack.isEmpty()) {
            return false;
        }
        IiiiiIiii_Class248.Nested1_95187080 nested1_95187080 = IiiiiIiii_Class248.I_method_7613ca72(itemStack);
        if (nested1_95187080 == null) {
            return false;
        }
        String string = nested1_95187080.I_method_3665aca6();
        if (string == null) {
            return false;
        }
        if (this.II_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627)) {
            if (!nested1_95187080.iI_method_e48a6b8b()) {
                return false;
            }
            return string.equals("\u042f\u0440\u043e\u0441\u0442\u0438") || string.equals("\u041a\u0430\u0440\u0430\u0442\u0435\u043b\u044f");
        }
        if (!nested1_95187080.Ii_method_e2d6074b()) {
            return false;
        }
        return string.equals("Cerber");
    }

    private int i_method_e8329cda(iIIiIiIii_Class300 iIIiIiIii_Class3002) {
        IiiiiIiii_Class248.Nested1_95187080 nested1_95187080 = IiiiiIiii_Class248.I_method_7613ca72(iIIiIiIii_Class3002.I_method_7b7e0bb9());
        if (nested1_95187080 == null) {
            return 2;
        }
        String string = nested1_95187080.I_method_3665aca6();
        if (string == null) {
            return 2;
        }
        if (this.II_field_bbe33e6c.I_method_ce989e26(this.Ii_field_500d0627)) {
            if (!nested1_95187080.iI_method_e48a6b8b()) {
                return 2;
            }
            if (string.equals("\u041a\u0430\u0440\u0430\u0442\u0435\u043b\u044f")) {
                return 0;
            }
            if (string.equals("\u042f\u0440\u043e\u0441\u0442\u0438")) {
                return 1;
            }
            return 2;
        }
        if (!nested1_95187080.Ii_method_e2d6074b()) {
            return 2;
        }
        return string.equals("Cerber") ? 0 : 1;
    }

    @Generated
    public boolean Iii_method_345deaa3() {
        return this.I_field_5a;
    }

    @Generated
    public boolean iII_method_69278283() {
        return this.i_field_5a;
    }

    @Generated
    public boolean iIi_method_69360e63() {
        return this.II_field_5a;
    }
}
