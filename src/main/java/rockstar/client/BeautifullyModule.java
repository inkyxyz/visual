package rockstar.client;

import lombok.Generated;
import moscow.rockstar.mixin.accessors.CameraAccessor;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.CameraUpdateEvent;
import rockstar.client.IIiiiIIiI_Class115;
import rockstar.client.MultiSelectSetting;
import rockstar.client.SliderSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.RockstarClient;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="Beautifully", category=ModuleCategory.VISUALS, iI_method_476ab839=true)
public class BeautifullyModule
extends Module {
    public static final long I_field_4a = 200L;
    private MultiSelectSetting I_field_bbe3ba6c;
    private MultiSelectSetting.Nested1_42856060 I_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 i_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 II_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
    private MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
    private SliderSetting I_field_73178e8c;
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.iIiI_field_dd60aac);
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, IiiiIiiII_Class237.iIiI_field_dd60aac);
    private final IiIIIiII_Class69<CameraUpdateEvent> I_field_3d936f41 = cameraUpdateEvent -> {
        if (!this.I_field_51de8227.isSelected()) {
            this.I_field_dc7facc.I_method_edd6dd21(cameraUpdateEvent.isThirdPerson() ? 1.0f : 0.0f);
            this.i_field_dc7facc.I_method_edd6dd21(cameraUpdateEvent.isThirdPerson() && cameraUpdateEvent.isInverseView() ? 1.0f : 0.0f);
            return;
        }
        boolean bl = cameraUpdateEvent.isThirdPerson();
        boolean bl2 = cameraUpdateEvent.isInverseView();
        float f = cameraUpdateEvent.getTickDelta();
        this.I_field_dc7facc.I_method_df2f9087(bl ? IiiiIiiII_Class237.I_method_ae57f375(0.31, 0.87, 0.41, 1.3) : IiiiIiiII_Class237.I_method_ae57f375(0.17, 0.85, 0.29, 0.99));
        this.I_field_dc7facc.I_method_edd6ec25(400L);
        this.i_field_dc7facc.I_method_df2f9087(IiiiIiiII_Class237.I_method_ae57f375(0.31, 0.87, 0.43, 0.94));
        Entity entity = cameraUpdateEvent.getFocusedEntity();
        float f2 = this.I_field_dc7facc.I_method_edd6dd11(bl ? 1.0f : 0.0f);
        float f3 = this.i_field_dc7facc.I_method_edd6dd11(bl && bl2 ? 1.0f : 0.0f);
        if (this.I_field_dc7facc.I_method_6ac4da83() && this.i_field_dc7facc.I_method_6ac4da83()) {
            return;
        }
        CameraAccessor cameraAccessor = (CameraAccessor)(Object)cameraUpdateEvent.getCamera();
        double d = MathHelper.lerp((double)f, (double)entity.prevX, (double)entity.getX());
        double d2 = MathHelper.lerp((double)f, (double)entity.prevY, (double)entity.getY()) + (double)MathHelper.lerp((float)f, (float)cameraAccessor.getLastCameraY(), (float)cameraAccessor.getCameraY());
        double d3 = MathHelper.lerp((double)f, (double)entity.prevZ, (double)entity.getZ());
        cameraAccessor.invokeSetPos(new Vec3d(d, d2, d3));
        cameraAccessor.setThirdPerson(bl || f2 >= 0.1f);
        if (f2 > 0.001f) {
            float f4;
            cameraAccessor.invokeSetRotation(entity.getYaw(f), entity.getPitch(f));
            if (bl2 || f3 > 0.001f) {
                f4 = bl2 ? 180.0f * f3 : -180.0f * f3;
                cameraAccessor.invokeSetRotation(cameraUpdateEvent.getCamera().getYaw() + f4, iIIiiiiiI_Class319.I_method_5f7ff5cf(cameraUpdateEvent.getCamera().getPitch(), -cameraUpdateEvent.getCamera().getPitch(), this.i_field_dc7facc.I_method_6ac4da6f()));
            }
            f4 = entity instanceof LivingEntity ? ((LivingEntity)entity).getScale() : 1.0f;
            cameraAccessor.invokeMoveBy(-cameraAccessor.invokeClipToSpace(4.0f * f4 * f2), 0.0f, 0.0f);
        }
    };

    public BeautifullyModule() {
        this.IiI_method_b163c67f();
    }

    @Compile(obfuscation=4)
    private void IiI_method_b163c67f() {
        this.I_field_bbe3ba6c = new MultiSelectSetting(this, "modules.settings.beautifully.select");
        this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.beautifully.smooth_f5").select();
        this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.beautifully.chat_animation").select();
        this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.beautifully.tab_animation").select();
        this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.beautifully.inventory_animation").select();
        this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.beautifully.chat_history", "modules.settings.beautifully.chat_history.desc");
        this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.beautifully.custom_tab_columns", "modules.settings.beautifully.custom_tab_columns.desc");
        this.I_field_73178e8c = new SliderSetting((IIiiiIIiI_Class115)this, "modules.settings.beautifully.tab_columns", () -> !this.ii_field_51de8227.isSelected()).I_method_c8c9a7d7(1.0f).i_method_65e2aff7(5.0f).II_method_b0f56334(1.0f).Ii_method_4e0e6b54(2.0f);
    }

    private static BeautifullyModule I_method_e898ab5() {
        if (RockstarClient.getInstance() == null || RockstarClient.getInstance().getModuleManager() == null) {
            return null;
        }
        BeautifullyModule iIiIIIiii_Class72 = RockstarClient.getInstance().getModuleManager().getModule(BeautifullyModule.class);
        return iIiIIIiii_Class72 != null && iIiIIIiii_Class72.isEnabled() ? iIiIIIiii_Class72 : null;
    }

    public static boolean IiI_method_b163c683() {
        BeautifullyModule iIiIIIiii_Class72 = BeautifullyModule.I_method_e898ab5();
        return iIiIIIiii_Class72 != null && iIiIIIiii_Class72.i_field_51de8227.isSelected();
    }

    public static boolean Iii_method_b1725263() {
        BeautifullyModule iIiIIIiii_Class72 = BeautifullyModule.I_method_e898ab5();
        return iIiIIIiii_Class72 != null && iIiIIIiii_Class72.II_field_51de8227.isSelected();
    }

    public static boolean iII_method_e63bea43() {
        BeautifullyModule iIiIIIiii_Class72 = BeautifullyModule.I_method_e898ab5();
        return iIiIIIiii_Class72 != null && iIiIIIiii_Class72.Ii_field_51de8227.isSelected();
    }

    public static boolean iIi_method_e64a7623() {
        BeautifullyModule iIiIIIiii_Class72 = BeautifullyModule.I_method_e898ab5();
        return iIiIIIiii_Class72 != null && iIiIIIiii_Class72.iI_field_51de8227.isSelected();
    }

    public static int II_method_bb574935() {
        BeautifullyModule iIiIIIiii_Class72 = BeautifullyModule.I_method_e898ab5();
        if (iIiIIIiii_Class72 == null || !iIiIIIiii_Class72.ii_field_51de8227.isSelected()) {
            return 0;
        }
        return (int)iIiIIIiii_Class72.I_field_73178e8c.Ii_method_a20abcd2();
    }

    @Generated
    public MultiSelectSetting I_method_e3aef6d5() {
        return this.I_field_bbe3ba6c;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 I_method_b3cc4850() {
        return this.I_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 i_method_b9d44430() {
        return this.i_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 II_method_c2a07113() {
        return this.II_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 Ii_method_c8a86cf3() {
        return this.Ii_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 iI_method_7d97f133() {
        return this.iI_field_51de8227;
    }

    @Generated
    public MultiSelectSetting.Nested1_42856060 ii_method_839fed13() {
        return this.ii_field_51de8227;
    }

    @Generated
    public SliderSetting I_method_9ae2caf5() {
        return this.I_field_73178e8c;
    }

    @Generated
    public IiiiIiIii_Class236 i_method_4b28ab15() {
        return this.I_field_dc7facc;
    }

    @Generated
    public IiiiIiIii_Class236 II_method_5dd0b4b8() {
        return this.i_field_dc7facc;
    }

    @Generated
    public IiIIIiII_Class69<CameraUpdateEvent> I_method_78aa81b8() {
        return this.I_field_3d936f41;
    }
}

