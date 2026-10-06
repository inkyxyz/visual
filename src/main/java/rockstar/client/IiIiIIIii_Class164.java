package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import lombok.Generated;
import moscow.rockstar.mixin.accessors.DrawContextAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.render.VertexConsumerProvider;
import org.lwjgl.opengl.GL11;
import pyrock.events.render.ChatRenderEvent;
import pyrock.events.render.HudRenderEvent;
import pyrock.events.window.ChatClickEvent;
import pyrock.events.window.ChatReleaseEvent;
import pyrock.events.window.ChatScrollEvent;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIiI_Class11;
import rockstar.client.ViewModelModule;
import rockstar.client.IIiiiIIIi_Class114;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.IiIIiIIIi_Class146;
import rockstar.client.IiIIiIiiI_Class151;
import rockstar.client.IiIIiiIii_Class156;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.IiIiIIIIi_Class162;
import rockstar.client.IiIiIIiII_Class165;
import rockstar.client.IiIiIIiIi_Class166;
import rockstar.client.IiIiIIiiI_Class167;
import rockstar.client.IiIiIIiii_Class168;
import rockstar.client.IiIiIiIIi_Class170;
import rockstar.client.IiIiIiIiI_Class171;
import rockstar.client.IiIiIiIii_Class172;
import rockstar.client.IiIiIiiII_Class173;
import rockstar.client.IiIiIiiIi_Class174;
import rockstar.client.IiIiIiiiI_Class175;
import rockstar.client.IiIiIiiii_Class176;
import rockstar.client.IiIiiIIII_Class177;
import rockstar.client.RockstarClient;
import rockstar.client.IiiIIIiii_Class200;
import rockstar.client.IiiIIiIII_Class201;
import rockstar.client.IiiIIiIIi_Class202;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiiiI_Class127;
import rockstar.client.iIIIIiII_Class133;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIIiI_Class291;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiIIiiI_Class295;
import rockstar.client.iIiiiIIiI_Class371;
import rockstar.client.iIiiiiIii_Class380;
import rockstar.client.iiIiIIiii_Class424;
import rockstar.client.iiiIIII_Class113;
import ua.mintantileak.spk.Compile;

public class IiIiIIIii_Class164
implements iIIiIIiIi_Class294,
iIIiIIiiI_Class295 {
    private final List<IiIiIIiII_Class165> I_field_7865b31 = new ArrayList<IiIiIIiII_Class165>();
    private final List<IiIiIIiII_Class165> i_field_7865b31 = new ArrayList<IiIiIIiII_Class165>();
    private final List<IiIiIIiII_Class165> II_field_7865b31 = Collections.unmodifiableList(this.I_field_7865b31);
    private final List<IiIiIIiII_Class165> Ii_field_7865b31 = Collections.unmodifiableList(this.i_field_7865b31);
    private final List<IiIiIIiII_Class165> iI_field_7865b31 = new Nested1_6e003800();
    private final List<IiIIiiIii_Class156> ii_field_7865b31 = new ArrayList<IiIIiiIii_Class156>();
    public IiIiiIIII_Class177 I_field_467a06ac;
    public IiIiIiIIi_Class170 I_field_11a1e6cc;
    private final IiIiIIiiI_Class167 I_field_fedf6cc = new IiIiIIiiI_Class167();
    private final IiIiIIIIi_Class162 I_field_fdef6ac = new IiIiIIIIi_Class162();
    private String I_field_523beb0a = "";
    private IiIIiIiiI_Class151 I_field_a9c1a28c;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private float I_field_46;
    private float i_field_46;
    private final IiIIIiII_Class69<HudRenderEvent> I_field_3d936f41 = hudRenderEvent -> {
        III iII = III.I_method_5728d20f(hudRenderEvent.getContext(), IiIiIIIii_Class164.I_field_3a9bda27.currentScreen == null ? -1 : (int)iIIiIIIiI_Class291.I_method_81637b4f().getX(), IiIiIIIii_Class164.I_field_3a9bda27.currentScreen == null ? -1 : (int)iIIiIIIiI_Class291.I_method_81637b4f().getY(), MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false));
        if (this.I_field_a9c1a28c == null) {
            this.I_field_a9c1a28c = new IiIIiIiiI_Class151(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(10.0f), 10.0f, 300L, IiiiIiiII_Class237.I_field_dd60aac).I_method_49374335();
        }
        this.I_field_523beb0a = "";
        this.i_method_ec10da5f();
        this.I_field_fdef6ac.I_method_4f3ae65f();
        IiIiIIiIi_Class166.I_method_3022089c(iII, this.iI_field_7865b31.size());
        InterfaceModule ifaceMod = RockstarClient.getInstance().getModuleManager().getModule(InterfaceModule.class);
        float hudScale = ifaceMod != null ? ifaceMod.getHudScale() : 1.0f;
        boolean scaleHud = Math.abs(hudScale - 1.0f) > 0.001f;
        if (scaleHud) {
            iII.getMatrices().push();
            iII.getMatrices().scale(hudScale, hudScale, 1.0f);
        }
        try (iIiiiiIii_Class380 iIiiiiIii_Class3802 = iIiiiiIii_Class380.i_method_9a230ed5();){
            for (IiIiIIiII_Class165 iIIiIIiRockstarClient942 : this.iI_field_7865b31) {
                iIIiIIiRockstarClient942.render(iII);
                float sel = iIIiIIiRockstarClient942.getSelecting().I_method_6ac4da6f();
                if (sel <= 0.001f) continue;
                float f = iIIiIIiRockstarClient942.getAnimation().I_method_6ac4da6f() * iIIiIIiRockstarClient942.getVisible().I_method_6ac4da6f();
                float f2 = 0.5f + f * 0.5f - 0.05f * sel;
                iIIiIIiRockstarClient942.getLoadingAnim().I_method_edd6ec25(1500L);
                iIIiIIiRockstarClient942.getLoadingAnim().I_method_edd6dd11(1.0f);
                if (iIIiIIiRockstarClient942.getLoadingAnim().I_method_6ac4da6f() == 1.0f) {
                    iIIiIIiRockstarClient942.getLoadingAnim().I_method_edd6dd21(0.0f);
                }

                float elemScale = iIIiIIiRockstarClient942.getScale();
                boolean elemScaled = Math.abs(elemScale - 1.0f) > 0.001f;
                if (elemScaled) {
                    iII.getMatrices().push();
                    iII.getMatrices().translate(iIIiIIiRockstarClient942.getX(), iIIiIIiRockstarClient942.getY(), 0.0f);
                    iII.getMatrices().scale(elemScale, elemScale, 1.0f);
                    iII.getMatrices().translate(-iIIiIIiRockstarClient942.getX(), -iIIiIIiRockstarClient942.getY(), 0.0f);
                }

                float elemW = iIIiIIiRockstarClient942.getWidth();
                float elemH = iIIiIIiRockstarClient942 instanceof IiIiIIiii_Class168 ? Math.max(20.0f, iIIiIIiRockstarClient942.getHeight()) : iIIiIIiRockstarClient942.getHeight();

                iIiiiIIiI_Class371.II_method_e18635ac(iII.getMatrices(), iIIiIIiRockstarClient942.getX() + elemW / 2.0f, iIIiIIiRockstarClient942.getY() + elemH / 2.0f, f2);

                iII.drawRoundedBorder(
                    iIIiIIiRockstarClient942.getX() - 1.5f,
                    iIIiIIiRockstarClient942.getY() - 1.5f,
                    elemW + 3.0f,
                    elemH + 3.0f,
                    1.2f,
                    IIiii_Class8.I_method_893b2757(6.0f),
                    IiiiiIIIi_Class242.i_method_5dfec6e().withAlpha(200.0f * sel)
                );

                iII.drawLoadingRect(
                    iIIiIIiRockstarClient942.getX(),
                    iIIiIIiRockstarClient942.getY(),
                    elemW,
                    elemH,
                    iIIiIIiRockstarClient942.getLoadingAnim().I_method_6ac4da6f() * 2.2f - 0.5f,
                    IIiii_Class8.I_method_893b2757(7.0f),
                    ColorRGBA.WHITE.withAlpha(100.0f * sel)
                );
                iIiiiIIiI_Class371.I_method_10503b11(iII.getMatrices());

                if (elemScaled) {
                    iII.getMatrices().pop();
                }
            }
            this.I_field_fdef6ac.I_method_c0a9659d(iII);
            this.I_field_a9c1a28c.I_method_a74dc6cc(I_field_73c6d26c.I_method_804ee20f() / 2.0f, 30.0f);
            if (!this.I_field_523beb0a.contains(".description")) {
                this.I_field_a9c1a28c.I_method_ceb35a49(this.I_field_523beb0a);
                this.I_field_a9c1a28c.I_method_7ae26dda(iII);
            }
        }
        if (scaleHud) {
            iII.getMatrices().pop();
        }
        IiIiIIiIi_Class166.i_method_6b4c6c7c(iII, this.iI_field_7865b31.size());
        boolean bl = IiIiIIIii_Class164.I_field_3a9bda27.currentScreen instanceof ChatScreen;
        for (IiIIiiIii_Class156 iiIIiiIii_Class1562 : this.ii_field_7865b31) {
            if (bl) continue;
            iiIIiiIii_Class1562.I_method_c3d80455(false);
        }
        if (!bl && !this.ii_field_7865b31.isEmpty()) {
            this.I_method_9f1d2f07(iII);
        }
        if (!bl) {
            for (IiIiIIiII_Class165 iiIiIIiII_Class165 : this.iI_field_7865b31) {
                if (!iiIiIIiII_Class165.isDragging()) continue;
                iiIiIIiII_Class165.onMouseReleased(iiIiIIiII_Class165.getX(), iiIiIIiII_Class165.getY(), IiIII_Class9.I_field_2f4c8d6c);
            }
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.I_field_aa52e62c);
        }
        this.ii_field_7865b31.removeIf(iiIIiiIii_Class156 -> iiIIiiIii_Class156.I_method_ea650b95().I_method_6ac4da6f() == 0.0f && !iiIIiiIii_Class156.II_method_c3e648e6());
    };
    private final IiIIIiII_Class69<ChatRenderEvent> i_field_3d936f41 = chatRenderEvent -> {
        III iII = III.I_method_5728d20f(chatRenderEvent.getContext(), IiIiIIIii_Class164.I_field_3a9bda27.currentScreen == null ? -1 : (int)iIIiIIIiI_Class291.I_method_81637b4f().getX(), IiIiIIIii_Class164.I_field_3a9bda27.currentScreen == null ? -1 : (int)iIIiIIIiI_Class291.I_method_81637b4f().getY(), MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false));
        this.I_method_9f1d2f07(iII);
    };
    private final IiIIIiII_Class69<ChatScrollEvent> II_field_3d936f41 = chatScrollEvent -> {
        for (IiIIiiIii_Class156 iiIIiiIii_Class156 : this.ii_field_7865b31) {
            iiIIiiIii_Class156.I_method_6b0ad25f(chatScrollEvent.getX(), chatScrollEvent.getY(), chatScrollEvent.getHorizontal(), chatScrollEvent.getVertical());
        }
        for (IiIiIIiII_Class165 elem : this.iI_field_7865b31) {
            if (elem.isShowing() && elem.isHovered(chatScrollEvent.getX(), chatScrollEvent.getY())) {
                elem.setScale(elem.getScale() + (float)chatScrollEvent.getVertical() * 0.05F);
                RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
                return;
            }
        }
    };
    private final IiIIIiII_Class69<ChatClickEvent> Ii_field_3d936f41 = chatClickEvent -> {
        for (IiIIiiIii_Class156 object : this.ii_field_7865b31) {
            object.I_method_400ceaa7(chatClickEvent.getX(), chatClickEvent.getY(), IiIII_Class9.I_method_40dce65a(chatClickEvent.getButton()));
            if (object.I_method_a74dc6d0(chatClickEvent.getX(), chatClickEvent.getY())) {
                return;
            }
            object.I_method_c3d80455(false);
        }
        for (IiIiIIiII_Class165 iiIiIIiII_Class165 : this.iI_field_7865b31) {
            iiIiIIiII_Class165.onMouseClicked(chatClickEvent.getX(), chatClickEvent.getY(), IiIII_Class9.I_method_40dce65a(chatClickEvent.getButton()));
            if ((!iiIiIIiII_Class165.isHovered(chatClickEvent.getX(), chatClickEvent.getY()) || !iiIiIIiII_Class165.isShowing()) && !iiIiIIiII_Class165.isDragging()) continue;
            return;
        }
        if (chatClickEvent.getButton() == 1 && this.I_method_f4b5a2c3(chatClickEvent.getX(), chatClickEvent.getY())) {
            return;
        }
        if (chatClickEvent.getButton() == 1 && !this.i_method_9e870e08().isEmpty()) {
            IiIIiiIii_Class156 iiIIiiIii_Class1562 = new IiIIiiIii_Class156(chatClickEvent.getX(), chatClickEvent.getY(), 90.0f, 6.0f).i_method_3f1b2bf7(120.0f).I_method_c43e1b0(IiIiIIII_Class81.I_method_f25a980a("whatadd"), 8, true);
            for (IiIiIIiII_Class165 iiIiIIiII_Class165 : this.i_method_9e870e08()) {
                iiIIiiIii_Class1562.I_method_78c7e89(IiIiIIII_Class81.I_method_f25a980a(iiIiIIiII_Class165.getName()), iiIiIIiII_Class165.getIcon(), iiIIiiIii_Class156 -> {
                    iiIiIIiII_Class165.pos(chatClickEvent.getX(), chatClickEvent.getY());
                    iiIiIIiII_Class165.setShowing(true);
                    iiIIiiIii_Class156.I_method_c3d80455(false);
                    RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
                });
            }
            this.ii_field_7865b31.add(iiIIiiIii_Class1562);
        } else if (chatClickEvent.getButton() == 1 && this.i_method_9e870e08().isEmpty() && this.I_field_991c1e8c.I_method_58432069(600L)) {
            RockstarClient.getInstance().I_method_5cb1af22().I_method_20d0f49b(iiiIIII_Class113.i_field_c11fcfcc, IiIiIIII_Class81.I_method_f25a980a("hud.no_elements"), IiIiIIII_Class81.I_method_f25a980a("hud.no_elements.desc"));
            this.I_field_991c1e8c.I_method_23e11e3f();
        }
    };
    private final IiIIIiII_Class69<ChatReleaseEvent> iI_field_3d936f41 = chatReleaseEvent -> {
        for (IiIIiiIii_Class156 iIIiIIiRockstarClient942 : this.ii_field_7865b31) {
            iIIiIIiRockstarClient942.i_method_6a097ac7(chatReleaseEvent.getX(), chatReleaseEvent.getY(), IiIII_Class9.I_method_40dce65a(chatReleaseEvent.getButton()));
            if (!iIIiIIiRockstarClient942.I_method_a74dc6d0(chatReleaseEvent.getX(), chatReleaseEvent.getY())) continue;
            return;
        }
        for (IiIiIIiII_Class165 iiIiIIiII_Class165 : this.iI_field_7865b31) {
            iiIiIIiII_Class165.onMouseReleased(chatReleaseEvent.getX(), chatReleaseEvent.getY(), IiIII_Class9.I_method_40dce65a(chatReleaseEvent.getButton()));
        }
    };

    @Compile(obfuscation=4)
    private void I_method_ec024e7f() {
        RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
        List<IiIiIIiII_Class165> list = new ArrayList<>();
        list.add(new IiIiIiIiI_Class171());
        list.add(new IiIiIiiII_Class173());
        list.add(new IiIiIiiiI_Class175());
        this.I_field_467a06ac = new IiIiiIIII_Class177();
        list.add(this.I_field_467a06ac);
        list.add(new IiiIIiIIi_Class202());
        list.add(new IiiIIiIII_Class201());
        this.I_field_11a1e6cc = new IiIiIiIIi_Class170();
        this.I_field_11a1e6cc.setShowing(false);
        this.iI_field_7865b31.addAll(list);
    }

    public IiIiIIIii_Class164() {
        this.I_method_ec024e7f();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void I_method_9f1d2f07(III iII) {
        VertexConsumerProvider.Immediate immediate = ((DrawContextAccessor)((Object)iII)).getVertexConsumers();
        immediate.draw();
        boolean bl = GL11.glIsEnabled((int)2929);
        RenderSystem.disableDepthTest();
        iII.getMatrices().push();
        iII.getMatrices().translate(0.0f, 0.0f, 2000.0f);
        try (iIiiiiIii_Class380 iIiiiiIii_Class3802 = iIiiiiIii_Class380.i_method_9a230ed5();){
            for (IiIIiiIii_Class156 iiIIiiIii_Class156 : this.ii_field_7865b31) {
                iiIIiiIii_Class156.I_method_a20223d7(10.0f).I_method_7ae26dda(iII);
            }
        }
        finally {
            immediate.draw();
            iII.getMatrices().pop();
            if (bl) {
                RenderSystem.enableDepthTest();
            } else {
                RenderSystem.disableDepthTest();
            }
        }
    }

    public boolean I_method_a22acbc8(int n, int n2, int n3) {
        for (int i = this.ii_field_7865b31.size() - 1; i >= 0; --i) {
            IiIIiiIii_Class156 iiIIiiIii_Class156 = this.ii_field_7865b31.get(i);
            if (!iiIIiiIii_Class156.II_method_c3e648e6() || !iiIIiiIii_Class156.I_method_2d0713e8(n, n2, n3)) continue;
            return true;
        }
        return false;
    }

    public boolean I_method_f4b450e9(char c, int n) {
        for (int i = this.ii_field_7865b31.size() - 1; i >= 0; --i) {
            IiIIiiIii_Class156 iiIIiiIii_Class156 = this.ii_field_7865b31.get(i);
            if (!iiIIiiIii_Class156.II_method_c3e648e6() || !iiIIiiIii_Class156.I_method_b71e84c9(c, n)) continue;
            return true;
        }
        return false;
    }

    public boolean I_method_f4b70b23(int n, int n2) {
        long l;
        boolean bl;
        boolean bl2;
        if ((n2 & 2) == 0) {
            return false;
        }
        boolean bl3 = bl2 = n == 89;
        if (!bl2 && n != 90) {
            return false;
        }
        boolean bl4 = false;
        for (int i = this.ii_field_7865b31.size() - 1; i >= 0; --i) {
            IiIIiiIii_Class156 iiIIiiIii_Class156 = this.ii_field_7865b31.get(i);
            if (!iiIIiiIii_Class156.II_method_c3e648e6()) continue;
            bl4 = true;
            if (!(bl2 ? iiIIiiIii_Class156.i_method_61368643() : iiIIiiIii_Class156.I_method_6127fa63())) continue;
            return true;
        }
        if (bl4) {
            return true;
        }
        ViewModelModule iIiIiiIIi_Class90 = RockstarClient.getInstance().getModuleManager().getModule(ViewModelModule.class);
        boolean bl5 = bl = iIiIiiIIi_Class90 != null && iIiIiiIIi_Class90.IiI_method_3272c683();
        long l2 = !bl ? Long.MIN_VALUE : (bl2 ? IIiiiIIIi_Class114.i_method_6f9514fb(iIiIiiIIi_Class90) : IIiiiIIIi_Class114.I_method_d27c0cdb(iIiIiiIIi_Class90));
        long l3 = l = bl2 ? this.I_field_fedf6cc.i_method_b19b6253() : this.I_field_fedf6cc.I_method_b18cd673();
        if (l2 > l && (bl2 ? IIiiiIIIi_Class114.i_method_6f95150b(iIiIiiIIi_Class90) : IIiiiIIIi_Class114.I_method_d27c0ceb(iIiIiiIIi_Class90))) {
            return true;
        }
        if (l != Long.MIN_VALUE) {
            if (bl2) {
                this.I_field_fedf6cc.i_method_b19b625f();
            } else {
                this.I_field_fedf6cc.I_method_b18cd67f();
            }
            return true;
        }
        return bl && (bl2 ? IIiiiIIIi_Class114.i_method_6f95150b(iIiIiiIIi_Class90) : IIiiiIIIi_Class114.I_method_d27c0ceb(iIiIiiIIi_Class90));
    }

    private void i_method_ec10da5f() {
        float f = I_field_73c6d26c.I_method_804ee20f();
        float f2 = I_field_73c6d26c.i_method_805d6def();
        if (this.I_field_46 == 0.0f || this.i_field_46 == 0.0f) {
            this.I_field_46 = f;
            this.i_field_46 = f2;
            return;
        }
        if (f == this.I_field_46 && f2 == this.i_field_46) {
            return;
        }
        for (IiIiIIiII_Class165 iiIiIIiII_Class165 : this.iI_field_7865b31) {
            iiIiIIiII_Class165.reanchor(this.I_field_46, this.i_field_46, f, f2);
        }
        this.I_field_46 = f;
        this.i_field_46 = f2;
    }

    private boolean I_method_f4b5a2c3(float f, float f2) {
        iIIIIiII_Class133 iIIIIiII_Class1332 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIiII_Class133.class);
        if (iIIIIiII_Class1332 != null && iIIIIiII_Class1332.I_method_260eb590(f, f2)) {
            return true;
        }
        IiIIiIIIi_Class146 iiIIiIIIi_Class146 = RockstarClient.getInstance().I_method_cf3ba822();
        return iiIIiIIIi_Class146 != null && iiIIiIIIi_Class146.I_method_91faae23(f, f2);
    }

    public List<IiIiIIiII_Class165> I_method_e93ad5e8() {
        return this.II_field_7865b31;
    }

    public List<IiIiIIiII_Class165> i_method_9e870e08() {
        return this.Ii_field_7865b31;
    }

    void I_method_11341087(IiIiIIiII_Class165 iiIiIIiII_Class165) {
        if (!this.iI_field_7865b31.contains(iiIiIIiII_Class165)) {
            return;
        }
        this.II_method_945678c2();
    }

    void II_method_945678c2() {
        this.I_field_7865b31.clear();
        this.i_field_7865b31.clear();
        for (IiIiIIiII_Class165 iiIiIIiII_Class165 : this.iI_field_7865b31) {
            if (iiIiIIiII_Class165.isShowing()) {
                this.I_field_7865b31.add(iiIiIIiII_Class165);
                continue;
            }
            this.i_field_7865b31.add(iiIiIIiII_Class165);
        }
    }

    public <T extends IiIiIIiII_Class165> T I_method_ce2cb1f(String string) {
        return (T)((IiIiIIiII_Class165)this.iI_field_7865b31.stream().filter(iiIiIIiII_Class165 -> iiIiIIiII_Class165.getName().equalsIgnoreCase(string)).findFirst().orElse(null));
    }

    @Generated
    public List<IiIiIIiII_Class165> II_method_5fa7d45() {
        return this.I_field_7865b31;
    }

    @Generated
    public List<IiIiIIiII_Class165> Ii_method_bb46b565() {
        return this.i_field_7865b31;
    }

    @Generated
    public List<IiIiIIiII_Class165> iI_method_fa354925() {
        return this.II_field_7865b31;
    }

    @Generated
    public List<IiIiIIiII_Class165> ii_method_af818145() {
        return this.Ii_field_7865b31;
    }

    @Generated
    public List<IiIiIIiII_Class165> III_method_812fc188() {
        return this.iI_field_7865b31;
    }

    @Generated
    public List<IiIIiiIii_Class156> IIi_method_367bf9a8() {
        return this.ii_field_7865b31;
    }

    @Generated
    public IiIiiIIII_Class177 I_method_35128395() {
        return this.I_field_467a06ac;
    }

    @Generated
    public IiIiIiIIi_Class170 I_method_3a63b5() {
        return this.I_field_11a1e6cc;
    }

    @Generated
    public IiIiIIiiI_Class167 I_method_fe8673b5() {
        return this.I_field_fedf6cc;
    }

    @Generated
    public IiIiIIIIi_Class162 I_method_fe777395() {
        return this.I_field_fdef6ac;
    }

    @Generated
    public String I_method_98bc9401() {
        return this.I_field_523beb0a;
    }

    @Generated
    public IiIIiIiiI_Class151 I_method_985a1f75() {
        return this.I_field_a9c1a28c;
    }

    @Generated
    public iiIiIIiii_Class424 I_method_87b49b75() {
        return this.I_field_991c1e8c;
    }

    @Generated
    public float I_method_ec024e6f() {
        return this.I_field_46;
    }

    @Generated
    public float i_method_ec10da4f() {
        return this.i_field_46;
    }

    @Generated
    public IiIIIiII_Class69<HudRenderEvent> I_method_faf33138() {
        return this.I_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<ChatRenderEvent> i_method_24efc158() {
        return this.i_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<ChatScrollEvent> II_method_bca30855() {
        return this.II_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<ChatClickEvent> Ii_method_e69f9875() {
        return this.Ii_field_3d936f41;
    }

    @Generated
    public IiIIIiII_Class69<ChatReleaseEvent> iI_method_d2387c35() {
        return this.iI_field_3d936f41;
    }

    @Generated
    public void I_method_23967689(String string) {
        this.I_field_523beb0a = string;
    }

    final class Nested1_6e003800
    extends ArrayList<IiIiIIiII_Class165> {
        Nested1_6e003800() {
        }

        public boolean I_method_f3b02670(IiIiIIiII_Class165 iiIiIIiII_Class165) {
            boolean bl = super.add(iiIiIIiII_Class165);
            if (bl) {
                IiIiIIIii_Class164.this.II_method_945678c2();
            }
            return bl;
        }

        public void I_method_f7918a3d(int n, IiIiIIiII_Class165 iiIiIIiII_Class165) {
            super.add(n, iiIiIIiII_Class165);
            IiIiIIIii_Class164.this.II_method_945678c2();
        }

        @Override
        public boolean addAll(Collection<? extends IiIiIIiII_Class165> collection) {
            boolean bl = super.addAll(collection);
            if (bl) {
                IiIiIIIii_Class164.this.II_method_945678c2();
            }
            return bl;
        }

        @Override
        public boolean addAll(int n, Collection<? extends IiIiIIiII_Class165> collection) {
            boolean bl = super.addAll(n, collection);
            if (bl) {
                IiIiIIIii_Class164.this.II_method_945678c2();
            }
            return bl;
        }

        public IiIiIIiII_Class165 I_method_9257731f(int n) {
            IiIiIIiII_Class165 iiIiIIiII_Class165 = (IiIiIIiII_Class165)super.remove(n);
            IiIiIIIii_Class164.this.II_method_945678c2();
            return iiIiIIiII_Class165;
        }

        @Override
        public boolean remove(Object object) {
            boolean bl = super.remove(object);
            if (bl) {
                IiIiIIIii_Class164.this.II_method_945678c2();
            }
            return bl;
        }

        @Override
        public boolean removeAll(Collection<?> collection) {
            boolean bl = super.removeAll(collection);
            if (bl) {
                IiIiIIIii_Class164.this.II_method_945678c2();
            }
            return bl;
        }

        @Override
        public boolean removeIf(Predicate<? super IiIiIIiII_Class165> predicate) {
            boolean bl = super.removeIf(predicate);
            if (bl) {
                IiIiIIIii_Class164.this.II_method_945678c2();
            }
            return bl;
        }

        @Override
        public boolean retainAll(Collection<?> collection) {
            boolean bl = super.retainAll(collection);
            if (bl) {
                IiIiIIIii_Class164.this.II_method_945678c2();
            }
            return bl;
        }

        public IiIiIIiII_Class165 I_method_de5be5d3(int n, IiIiIIiII_Class165 iiIiIIiII_Class165) {
            IiIiIIiII_Class165 iiIiIIiII_Class1652 = super.set(n, iiIiIIiII_Class165);
            IiIiIIIii_Class164.this.II_method_945678c2();
            return iiIiIIiII_Class1652;
        }

        @Override
        public void clear() {
            if (this.isEmpty()) {
                return;
            }
            super.clear();
            IiIiIIIii_Class164.this.II_method_945678c2();
        }

    }
}

