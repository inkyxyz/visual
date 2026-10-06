package rockstar.client;

import java.util.Map;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import pyrock.events.render.ChatRenderEvent;
import pyrock.events.window.ChatClickEvent;
import pyrock.events.window.ChatReleaseEvent;
import rockstar.client.III;
import rockstar.client.IIiIIiII_Class37;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIIiIIiI_Class147;
import rockstar.client.IiIIiiIii_Class156;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIiiiiIII_Class377;
import rockstar.client.iiIiIiIii_Class428;

public class IiIIiIIIi_Class146
implements iIIiIIiIi_Class294 {
    private IiIIiiIii_Class156 I_field_ab760aac;
    private final IiIIIiII_Class69<ChatRenderEvent> I_field_3d936f41 = chatRenderEvent -> {
        if (this.I_field_ab760aac == null) {
            return;
        }
        III iII = III.I_method_5728d20f(chatRenderEvent.getContext(), IiIIiIIIi_Class146.I_field_3a9bda27.currentScreen == null ? -1 : (int)iIIiIIIiI_Class291.I_method_81637b4f().getX(), IiIIiIIIi_Class146.I_field_3a9bda27.currentScreen == null ? -1 : (int)iIIiIIIiI_Class291.I_method_81637b4f().getY(), MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false));
        this.I_field_ab760aac.I_method_7ae26dda(iII);
    };
    private final IiIIIiII_Class69<ChatClickEvent> i_field_3d936f41 = chatClickEvent -> {
        if (this.I_field_ab760aac != null) {
            this.I_field_ab760aac.I_method_400ceaa7(chatClickEvent.getX(), chatClickEvent.getY(), IiIII_Class9.I_method_40dce65a(chatClickEvent.getButton()));
            if (this.I_field_ab760aac.I_method_a74dc6d0(chatClickEvent.getX(), chatClickEvent.getY())) {
                return;
            }
            this.I_field_ab760aac.I_method_c3d80455(false);
        }
        if (chatClickEvent.getButton() != 1) {
            return;
        }
        Map.Entry<String, Vec3d> entry = this.I_method_15b7de66(chatClickEvent.getX(), chatClickEvent.getY());
        if (entry != null) {
            this.I_method_d4725201(chatClickEvent.getX(), chatClickEvent.getY(), entry.getKey(), entry.getValue());
        }
    };
    private final IiIIIiII_Class69<ChatReleaseEvent> II_field_3d936f41 = chatReleaseEvent -> {
        if (this.I_field_ab760aac != null) {
            this.I_field_ab760aac.i_method_6a097ac7(chatReleaseEvent.getX(), chatReleaseEvent.getY(), IiIII_Class9.I_method_40dce65a(chatReleaseEvent.getButton()));
        }
    };

    public IiIIiIIIi_Class146() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
    }

    private void I_method_d4725201(float f, float f2, String string, Vec3d vec3d) {
        boolean bl;
        this.I_field_ab760aac = new IiIIiiIii_Class156(f, f2, 110.0f, 6.0f).i_method_a1faeedf(string).I_method_88131b75().I_method_78c7e89(IiIiIIII_Class81.I_method_f25a980a("way.autopilot"), "plane", iiIIiiIii_Class156 -> {
            IIiIIiII_Class37 iIiIIiII_Class37 = IIiIIiII_Class37.I_method_b34f53cb();
            if (iIiIIiII_Class37 != null) {
                iIiIIiII_Class37.I_method_27941b3e(new Vec3d(vec3d.x + 0.5, vec3d.y, vec3d.z + 0.5));
            }
            iiIIiiIii_Class156.I_method_c3d80455(false);
        });
        boolean bl2 = bl = iiIiIiIii_Class428.I_method_b0496283() && iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa63();
        if (bl) {
            this.I_field_ab760aac.I_method_78c7e89(IiIiIIII_Class81.I_method_f25a980a("way.stop"), "xmark", iiIIiiIii_Class156 -> {
                iiIiIiIii_Class428.I_method_483e9b95().I_method_1381fa5f();
                iiIIiiIii_Class156.I_method_c3d80455(false);
            });
        } else {
            this.I_field_ab760aac.I_method_78c7e89(IiIiIIII_Class81.I_method_f25a980a("way.goto"), "path", iiIIiiIii_Class156 -> {
                if (iiIiIiIii_Class428.I_method_b0496283()) {
                    iiIiIiIii_Class428.I_method_483e9b95().I_method_54107219(new BlockPos((int)Math.floor(vec3d.x), (int)Math.floor(vec3d.y), (int)Math.floor(vec3d.z)));
                }
                iiIIiiIii_Class156.I_method_c3d80455(false);
            });
        }
        this.I_field_ab760aac.I_method_78c7e89(IiIiIIII_Class81.I_method_f25a980a("remove"), "trash", iiIIiiIii_Class156 -> {
            RockstarClient.getInstance().I_method_cf3ba442().I_method_d7f5649(string);
            iiIIiiIii_Class156.I_method_c3d80455(false);
        });
    }

    public boolean I_method_91faae23(double d, double d2) {
        return this.I_method_15b7de66(d, d2) != null;
    }

    private Map.Entry<String, Vec3d> I_method_15b7de66(double d, double d2) {
        if (IiIIiIIIi_Class146.I_field_3a9bda27.player == null || IiIIiIIIi_Class146.I_field_3a9bda27.world == null) {
            return null;
        }
        for (Map.Entry<String, Vec3d> entry : RockstarClient.getInstance().I_method_cf3ba442().I_method_173f1fee()) {
            float f;
            float f2;
            float f3;
            Vec3d vec3d = entry.getValue();
            Vec2f vec2f = iIiiiiIII_Class377.I_method_211fc242(vec3d.add(0.0, 0.5, 0.0));
            if (vec2f == null) continue;
            float f4 = (float)IiIIiIIIi_Class146.I_field_3a9bda27.player.getPos().distanceTo(vec3d.add(0.5, 0.5, 0.5));
            float f5 = MathHelper.clamp((float)(1.1f - f4 / 100.0f), (float)0.6f, (float)1.1f);
            IiIIiIIiI_Class147.Nested1_ea18c20 nested1_ea18c20 = IiIIiIIiI_Class147.I_method_ccaff086(entry.getKey(), f4);
            float f6 = vec2f.x + nested1_ea18c20.I_method_dbb0b8a() * f5;
            if (!iIIiIIIiI_Class291.I_method_c3f86263(f6, f3 = vec2f.y + nested1_ea18c20.i_method_dc9976a() * f5, f2 = nested1_ea18c20.II_method_a9b55ef7() * f5, f = nested1_ea18c20.Ii_method_a9c3ead7() * f5, d, d2)) continue;
            return entry;
        }
        return null;
    }
}

