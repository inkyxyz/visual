package rockstar.client;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.block.ChestBlock;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.InterfaceModule;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIiiiiIII_Class377;
import rockstar.client.Module;

@ModuleInfo(name="Warden Helper", category=ModuleCategory.VISUALS, iI_method_476ab839=true)
public class WardenHelperModule
extends Module {
    private static final Pattern I_field_5fd3861f = Pattern.compile("(\\d{1,2}):(\\d{2})(?::(\\d{2}))?");
    private static final Pattern i_field_5fd3861f = Pattern.compile("(\\d+)\\s*(\u0441|s|\u0441\u0435\u043a|sec)");
    private static final Pattern II_field_5fd3861f = Pattern.compile("(\\d+)\\s*(\u043c|m|\u043c\u0438\u043d|min(?:\\.|ute)?)\\s*(?:(\\d+)\\s*(\u0441|s|\u0441\u0435\u043a|sec(?:\\.|ond)?))?");
    private final IiIIIiII_Class69<PreHudRenderEvent> I_field_3d936f41 = preHudRenderEvent -> {
        if (WardenHelperModule.I_field_3a9bda27.world == null || WardenHelperModule.I_field_3a9bda27.player == null) {
            return;
        }
        MatrixStack matrixStack = preHudRenderEvent.getContext().getMatrices();
        ColorRGBA colorRGBA = IiiiiIIIi_Class242.i_method_5dfec6e();
        for (Entity entity : WardenHelperModule.I_field_3a9bda27.world.getEntities()) {
            Vec3d vec3d;
            Vec2f vec2f;
            String string;
            ArmorStandEntity armorStandEntity;
            if (!(entity instanceof ArmorStandEntity) || !this.I_method_fa108cf1(armorStandEntity = (ArmorStandEntity)entity) || (string = this.i_method_f96e1d97(armorStandEntity.getName().getString())) == null || (vec2f = iIiiiiIII_Class377.I_method_211fc242(vec3d = iIiiiiIII_Class377.I_method_689b1a13((Entity)armorStandEntity, I_field_3a9bda27.getRenderTickCounter().getTickDelta(true)).add(0.0, 1.2, 0.0))) == null) continue;
            float f = (float)WardenHelperModule.I_field_3a9bda27.player.getPos().distanceTo(vec3d);
            float f2 = MathHelper.clamp((float)(1.0f - f / 20.0f), (float)0.5f, (float)1.0f);
            matrixStack.push();
            matrixStack.translate(vec2f.x, vec2f.y, 0.0f);
            matrixStack.scale(f2, f2, 1.0f);
            WardenHelperModule.I_method_c92e01a8(preHudRenderEvent.getContext(), string, colorRGBA, 1.0f);
            matrixStack.pop();
        }
    };

    public boolean I_method_fa108cf1(ArmorStandEntity armorStandEntity) {
        if (!this.isEnabled()) {
            return false;
        }
        if (WardenHelperModule.I_field_3a9bda27.world == null) {
            return false;
        }
        String string = armorStandEntity.getName().getString();
        if (string == null || string.isBlank()) {
            return false;
        }
        if (this.i_method_f96e1d97(string) == null) {
            return false;
        }
        return this.I_method_e784c177(armorStandEntity.getBlockPos()) != null;
    }

    private String i_method_f96e1d97(String string) {
        Matcher matcher = I_field_5fd3861f.matcher(string);
        if (matcher.find()) {
            return matcher.group();
        }
        matcher = II_field_5fd3861f.matcher(string);
        if (matcher.find()) {
            return matcher.group();
        }
        matcher = i_field_5fd3861f.matcher(string);
        if (matcher.find()) {
            return matcher.group();
        }
        return null;
    }

    private BlockPos I_method_e784c177(BlockPos blockPos) {
        if (WardenHelperModule.I_field_3a9bda27.world == null) {
            return null;
        }
        for (int i = 1; i <= 3; ++i) {
            BlockPos blockPos2 = blockPos.down(i);
            if (!(WardenHelperModule.I_field_3a9bda27.world.getBlockState(blockPos2).getBlock() instanceof ChestBlock)) continue;
            return blockPos2;
        }
        return null;
    }

    private static void I_method_c92e01a8(CustomDrawContext customDrawContext, String string, ColorRGBA colorRGBA, float f) {
        float f2 = MathHelper.clamp((float)f, (float)0.0f, (float)1.0f);
        if (f2 <= 0.01f) {
            return;
        }
        float f3 = f2 * InterfaceModule.I_method_fdcdb22f();
        float f4 = f2 * InterfaceModule.i_method_fddc3e0f();
        if (f3 > 0.01f) {
            WardenHelperModule.i_method_c01481c8(customDrawContext, string, colorRGBA, f3);
        }
        if (f4 > 0.01f) {
            WardenHelperModule.II_method_80d1d9c5(customDrawContext, string, colorRGBA, f4);
        }
    }

    private static void i_method_c01481c8(CustomDrawContext customDrawContext, String string, ColorRGBA colorRGBA, float f) {
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(10.0f);
        float f2 = 6.0f;
        float f3 = 21.0f;
        float f4 = 8.0f;
        float f5 = 6.0f;
        float f6 = iIiIIi_Class10.I_method_2c375926(string);
        float f7 = Math.max(f4 * 2.0f + f2 + f5 + f6, 52.0f) - 1.0f;
        float f8 = -f7 / 2.0f;
        float f9 = 4.0f;
        IIiii_Class8 iIiii_Class8 = IIiii_Class8.I_method_893b2757(f3 / 2.0f);
        ColorRGBA colorRGBA2 = IiiiiIIIi_Class242.Ii_method_a0f56f71().withAlpha(60.0f * f);
        ColorRGBA colorRGBA3 = IiiiiIIIi_Class242.iI_method_8e08d3b1().withAlpha(255.0f * f);
        customDrawContext.drawLiquidGlass(f8, f9, f7, f3, 2.0f, 0.08f, iIiii_Class8, ColorRGBA.WHITE.withAlpha(191.0f));
        customDrawContext.drawRoundedRect(f8, f9, f7, f3, iIiii_Class8, colorRGBA2);
        float f10 = f8 + f4;
        float f11 = f9 + (f3 - f2) / 2.0f;
        customDrawContext.drawRoundedRect(f10, f11, f2, f2, IIiii_Class8.I_method_893b2757(f2 / 2.0f), colorRGBA.withAlpha(245.0f * f));
        customDrawContext.drawText(iIiIIi_Class10, string, f10 + f2 + f5, f9 + (f3 - iIiIIi_Class10.I_method_a649725c()) / 2.0f, colorRGBA3);
    }

    private static void II_method_80d1d9c5(CustomDrawContext customDrawContext, String string, ColorRGBA colorRGBA, float f) {
        IIiIIi_Class10 iIiIIi_Class10 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(9.0f);
        float f2 = 21.0f;
        float f3 = 6.0f;
        float f4 = 8.0f;
        float f5 = 6.0f;
        float f6 = WardenHelperModule.I_method_bbb7ed51(iIiIIi_Class10.I_method_2c375926(string));
        float f7 = f3 + f5 + f6;
        float f8 = WardenHelperModule.I_method_bbb7ed51(f7 + f4 * 2.0f);
        float f9 = WardenHelperModule.I_method_bbb7ed51(-f8 / 2.0f);
        float f10 = 5.5f;
        IIiii_Class8 iIiii_Class8 = IIiii_Class8.I_method_893b2757(f2 / 2.0f);
        ColorRGBA colorRGBA2 = new ColorRGBA(13.0f, 18.0f, 20.0f, 238.0f * f);
        customDrawContext.drawRoundedRect(f9, f10, f8, f2, iIiii_Class8, colorRGBA2);
        float f11 = f9 + f4;
        float f12 = WardenHelperModule.I_method_ad7f1111(f10, f2, f3);
        customDrawContext.drawRoundedRect(f11, f12, f3, f3, IIiii_Class8.I_method_893b2757(f3 / 2.0f), colorRGBA.withAlpha(245.0f * f));
        float f13 = f11 + f3 + f5;
        float f14 = WardenHelperModule.I_method_bbb7ed51(f10 + (f2 - iIiIIi_Class10.I_method_a649725c()) / 2.0f - 0.5f);
        customDrawContext.drawText(iIiIIi_Class10, string, f13, f14, ColorRGBA.WHITE.withAlpha(250.0f * f));
    }

    private static float I_method_ad7f1111(float f, float f2, float f3) {
        return WardenHelperModule.I_method_bbb7ed51(f + (f2 - f3) / 2.0f);
    }

    private static float I_method_bbb7ed51(float f) {
        return (float)Math.round(f * 2.0f) / 2.0f;
    }
}

