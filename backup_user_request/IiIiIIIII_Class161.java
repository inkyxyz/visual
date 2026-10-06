package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.util.math.MathHelper;
import pyrock.utility.render.ColorRGBA;
import rockstar.client.III;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IiIII_Class9;
import rockstar.client.IiIIiiiii_Class160;
import rockstar.client.IiIiiIIiI_Class179;
import rockstar.client.IiiIiiIiI_Class219;
import rockstar.client.IiiiIiIii_Class236;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIIIiiIi_Class270;
import rockstar.client.iIIIiIIIi_Class274;
import rockstar.client.iIIIiIIiI_Class275;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iI_Class3;
import rockstar.client.iIiiiIIiI_Class371;
import rockstar.client.iIiiiIiII_Class373;
import rockstar.client.iIiiiiIiI_Class379;
import rockstar.client.iiIIIIIIi_Class386;
import rockstar.client.iiIiIIIII_Class417;
import rockstar.client.iiIiIIiii_Class424;

public class IiIiIIIII_Class161
extends iI_Class3
implements iIIiIIiIi_Class294 {
    public static IiIiIIIII_Class161 I_field_fdef2cc;
    private static final Pattern I_field_5fd3861f;
    private final HashMap<Character, Float> I_field_64d80c39 = new HashMap();
    private final List<Nested1_6df13420> I_field_7865b31 = new ArrayList<Nested1_6df13420>();
    private final IIiIIi_Class10 I_field_856d0221;
    private float[] I_field_b4b = new float[0];
    private float[] i_field_b4b = new float[]{0.0f};
    private boolean I_field_5a = true;
    private String I_field_523beb0a = "";
    private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
    private boolean i_field_5a;
    private final IiiiIiIii_Class236 i_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.I_field_dd60aac);
    private int I_field_49;
    private Nested1_6df13400 I_field_93ed2287;
    private int i_field_49 = -1;
    private long I_field_4a = 0L;
    private int II_field_49 = 0;
    private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
    private String i_field_523beb0a = "";
    private String II_field_523beb0a = "";
    private Map<String, IiIIiiiii_Class160> I_field_a567c40b = new HashMap<String, IiIIiiiii_Class160>();
    private String Ii_field_523beb0a = "";
    private float iI_field_46;
    private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
    private float ii_field_46 = 1.0f;
    private ColorRGBA I_field_d0c8ec5 = ColorRGBA.WHITE;
    private boolean II_field_5a;
    private int Ii_field_49;
    private boolean Ii_field_5a;

    public void I_method_1d5afa89(String string) {
        if (string == null) {
            string = "";
        }
        if (this.II_field_5a) {
            string = this.I_method_f4043d37(string);
        }
        this.I_field_7865b31.clear();
        this.I_field_523beb0a = "";
        this.I_field_49 = 0;
        Matcher matcher = I_field_5fd3861f.matcher(string);
        while (matcher.find() && (this.Ii_field_49 <= 0 || this.I_field_7865b31.size() < this.Ii_field_49)) {
            Nested1_6df13420 nested1_6df13420 = new Nested1_6df13420(matcher.group());
            nested1_6df13420.I_field_dc7facc.I_method_edd6dd21(1.0f);
            this.I_field_7865b31.add(nested1_6df13420);
        }
        this.I_field_5a = true;
        this.Ii_method_fb7800a2();
        this.I_field_49 = this.I_field_7865b31.size();
        this.I_field_93ed2287 = null;
        this.iI_field_46 = 0.0f;
        this.I_field_991c1e8c.I_method_23e11e3f();
    }

    public final void i_method_18ae5e5f() {
        if (this.I_field_7865b31.isEmpty()) {
            this.I_field_93ed2287 = null;
            this.I_field_49 = 0;
            return;
        }
        this.I_field_93ed2287 = new Nested1_6df13400(true, 0, this.I_field_7865b31.size());
        this.I_field_49 = this.I_field_7865b31.size();
    }

    private String I_method_f4043d37(String string) {
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl = false;
        for (int i = 0; i < string.length(); ++i) {
            char c = string.charAt(i);
            if (Character.isDigit(c)) {
                stringBuilder.append(c);
                continue;
            }
            if (!(c != '.' && c != ',' || bl)) {
                stringBuilder.append('.');
                bl = true;
                continue;
            }
            if (c != '-' || !stringBuilder.isEmpty()) continue;
            stringBuilder.append('-');
        }
        if (stringBuilder.length() == 1 && stringBuilder.charAt(0) == '-') {
            return "";
        }
        return stringBuilder.toString();
    }

    @Override
    protected void i_method_bdd4e0ec(III iII) {
        float f;
        float f2;
        if (this.i_field_5a) {
            iIIIIiiIi_Class270.I_method_a2b06dff();
        }
        float f3 = 0.0f;
        float f4 = this.Ii_field_46 / 2.0f - this.I_field_856d0221.I_method_a649725c() / 2.0f;
        float f5 = this.I_field_856d0221.I_method_a649725c() / 8.0f;
        if (this.I_field_7865b31.removeIf(nested1_6df13420 -> nested1_6df13420.I_field_dc7facc.I_method_6ac4da6f() == 0.0f && nested1_6df13420.I_field_5a)) {
            this.I_field_5a = true;
        }
        this.I_field_49 = Math.min(this.I_field_49, this.I_field_7865b31.size());
        this.III_method_71d41adf();
        this.I_field_dc7facc.I_method_edd72835(this.i_field_5a);
        if (this.I_field_93ed2287 != null) {
            this.I_field_93ed2287.I_field_49 = MathHelper.clamp((int)this.I_field_93ed2287.I_field_49, (int)0, (int)this.I_field_7865b31.size());
            this.I_field_93ed2287.i_field_49 = MathHelper.clamp((int)this.I_field_93ed2287.i_field_49, (int)0, (int)this.I_field_7865b31.size());
            if (this.I_field_93ed2287.I_method_5f594fad() == this.I_field_93ed2287.i_method_5f67db8d()) {
                this.I_field_93ed2287 = null;
            }
        }
        if (this.i_field_49 != -1) {
            this.I_field_991c1e8c.I_method_23e11e3f();
            int n = -1;
            f2 = 0.0f;
            for (int i = 0; i < this.I_field_7865b31.size(); ++i) {
                f = this.I_field_b4b[i];
                if ((float)iII.I_method_b1c3e152() < this.I_field_46 + this.iI_field_46 + f2 + f + f / 2.0f) {
                    n = i;
                    break;
                }
                f2 += f;
            }
            if (n == -1) {
                n = this.I_field_7865b31.size();
            }
            if (n != this.i_field_49) {
                this.I_field_93ed2287 = new Nested1_6df13400(n > this.i_field_49, Math.min(this.i_field_49, n), Math.max(this.i_field_49, n));
                this.I_field_49 = n;
            } else {
                if (this.I_field_93ed2287 != null) {
                    this.I_field_49 = this.I_field_93ed2287.I_method_5f594fad();
                }
                this.I_field_93ed2287 = null;
            }
        }
        if (this.I_method_7ae26dde(iII) && this.ii_field_46 > 0.0f) {
            iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.iI_field_aa52e62c);
        }
        this.Ii_method_fb7800a2();
        float f6 = this.i_field_b4b[this.I_field_49];
        f2 = this.I_field_93ed2287 == null ? 0.0f : this.i_field_b4b[this.I_field_93ed2287.I_method_5f594fad()];
        float f7 = this.I_field_93ed2287 == null ? 0.0f : this.i_field_b4b[this.I_field_93ed2287.i_method_5f67db8d()];
        iIiiiIiII_Class373.I_method_d5a5ee51(iII.getMatrices(), this.I_field_46, this.i_field_46, this.II_field_46, this.Ii_field_46);
        f = RenderSystem.getShaderColor()[3];
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)(f * this.ii_field_46));
        iII.drawRect(this.I_field_46 + this.iI_field_46 + f4 + f2, this.i_field_46 + f4 - 1.0f, f7 - f2, this.I_field_856d0221.I_method_a649725c() + 2.0f, IiiiiIIIi_Class242.ii_field_d0c8ec5.withAlpha(114.75f * this.I_field_dc7facc.I_method_6ac4da6f()));
        iiIIIIIIi_Class386 iiIIIIIIi_Class3862 = new iiIIIIIIi_Class386(VertexFormats.POSITION_TEXTURE_COLOR, this.I_field_856d0221.I_method_36d49b4b());
        if (this.I_field_7865b31.isEmpty()) {
            iII.drawText(this.I_field_856d0221, this.i_field_523beb0a, this.I_field_46 + f3 + f4, this.i_field_46 + f4 - 2.0f * this.I_field_dc7facc.I_method_6ac4da6f(), this.I_field_d0c8ec5.mulAlpha(0.75f * (1.0f - this.I_field_dc7facc.I_method_6ac4da6f())));
        }
        if (!this.Ii_field_523beb0a.isEmpty() && this.Ii_field_523beb0a.toLowerCase().startsWith(this.I_field_523beb0a.toLowerCase()) && !this.I_field_523beb0a.isEmpty()) {
            iII.drawText(this.I_field_856d0221, this.I_field_523beb0a + this.Ii_field_523beb0a.substring(this.I_field_523beb0a.length()), this.I_field_46 + f3 + f4, this.i_field_46 + f4, this.I_field_d0c8ec5.mulAlpha(0.5882353f * this.I_field_dc7facc.I_method_6ac4da6f()));
        }
        for (int i = 0; i < this.I_field_7865b31.size(); ++i) {
            Nested1_6df13420 nested1_6df134202 = this.I_field_7865b31.get(i);
            String string = nested1_6df134202.I_field_523beb0a;
            if (this.Ii_field_5a) {
                string = "*";
            }
            nested1_6df134202.I_field_dc7facc.I_method_edd6ec25(200L);
            nested1_6df134202.I_field_dc7facc.I_method_edd72835(!nested1_6df134202.I_field_5a);
            IiIiiIIiI_Class179.I_method_d5fb8067(iII, this.I_field_856d0221, string, this.I_field_46 + f3 + f4 + this.iI_field_46, this.i_field_46 + f4 + 2.0f - 2.0f * nested1_6df134202.I_field_dc7facc.I_method_6ac4da6f(), this.I_field_856d0221.I_method_a649725c(), this.I_field_d0c8ec5.mulAlpha(nested1_6df134202.I_field_dc7facc.I_method_6ac4da6f()));
            f3 += this.I_field_b4b[i] * nested1_6df134202.I_field_dc7facc.I_method_6ac4da6f();
        }
        ((iIiiiiIiI_Class379)iiIIIIIIi_Class3862).II_method_ed687102();
        f6 += (float)(this.I_field_49 == this.I_field_7865b31.size() ? 1 : 0);
        if (this.i_field_991c1e8c.I_method_58432069(10L)) {
            if (!this.I_field_7865b31.isEmpty() && f6 + f4 + this.iI_field_46 > this.II_field_46 - 5.0f) {
                this.iI_field_46 -= this.I_field_b4b[0];
                this.i_field_991c1e8c.I_method_23e11e3f();
            } else if (!this.I_field_7865b31.isEmpty() && f6 + f4 + this.iI_field_46 < 5.0f) {
                this.iI_field_46 += this.I_field_b4b[0];
                this.i_field_991c1e8c.I_method_23e11e3f();
            }
            if (IiIiiIIiI_Class179.I_method_cc1ab81a(this.I_field_856d0221, this.I_field_523beb0a) < this.II_field_46 - 10.0f) {
                this.iI_field_46 = 0.0f;
            }
        }
        this.i_field_dc7facc.I_method_df2f9087(IiiiIiiII_Class237.i_field_dd60aac);
        this.i_field_dc7facc.I_method_edd6dd11(f6);
        iIiiiIIiI_Class371.I_method_6a1c0f0f(iII.getMatrices(), this.I_field_46 + f4 + this.iI_field_46 + this.i_field_dc7facc.I_method_6ac4da6f() + f5 / 2.0f, this.i_field_46 + f4 - 1.0f, Math.clamp(f6 - this.i_field_dc7facc.I_method_6ac4da6f(), -20.0f, 20.0f));
        iII.drawRect(this.I_field_46 + f4 + this.i_field_dc7facc.I_method_6ac4da6f() + this.iI_field_46, this.i_field_46 + f4 - 1.0f, f5, this.I_field_856d0221.I_method_a649725c() + 2.0f, this.I_field_d0c8ec5.mulAlpha((float)((double)(0.78431374f * this.I_field_dc7facc.I_method_6ac4da6f()) * (!this.I_field_991c1e8c.I_method_58432069(300L) ? 3.0 : iIIiiiiiI_Class319.I_method_a586e9cd((double)System.currentTimeMillis() / 200.0) + 2.0) / 3.0)));
        iIiiiIIiI_Class371.I_method_10503b11(iII.getMatrices());
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)f);
        iIiiiIiII_Class373.I_method_ff80a1df();
    }

    @Override
    public void I_method_400ceaa7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        if (this.I_method_a74cd690(d, d2)) {
            if (iiIII_Class9 == IiIII_Class9.I_field_2f4c8d6c) {
                long l = System.currentTimeMillis();
                this.II_field_49 = l - this.I_field_4a < 500L ? ++this.II_field_49 : 1;
                this.I_field_4a = l;
                this.I_method_fb5b3035(true);
                float f = 0.0f;
                int n = this.I_field_7865b31.size();
                this.III_method_71d41adf();
                for (int i = 0; i < this.I_field_7865b31.size(); ++i) {
                    float f2 = this.I_field_b4b[i];
                    if (d < (double)(this.I_field_46 + this.iI_field_46 + f + f2 + f2 / 2.0f)) {
                        n = i;
                        break;
                    }
                    f += f2;
                }
                this.I_field_49 = n;
                if (this.II_field_49 == 2) {
                    this.iI_method_fd2c64e2();
                    this.i_field_49 = -1;
                } else {
                    this.I_field_93ed2287 = null;
                    this.i_field_49 = this.I_field_49;
                }
            }
        } else {
            this.I_method_fb5b3035(false);
        }
    }

    @Override
    public void i_method_6a097ac7(double d, double d2, IiIII_Class9 iiIII_Class9) {
        this.i_field_49 = -1;
    }

    public void I_method_fb5b3035(boolean bl) {
        if (bl && I_field_fdef2cc != null && I_field_fdef2cc != this) {
            I_field_fdef2cc.I_method_fb5b3035(false);
        }
        this.i_field_5a = bl;
        if (bl) {
            I_field_fdef2cc = this;
        }
    }

    @Override
    public void I_method_c1acbc24(int n, int n2, int n3) {
        if (!this.i_field_5a) {
            return;
        }
        if ((n == 259 || n == 261) && this.I_field_93ed2287 != null) {
            this.ii_method_fd3af0c2();
            iiIiIIIII_Class417.III_field_34b2ba6c.I_method_7289b65f(0.3f, 1.2f);
            this.i_method_fd1de084(0);
        } else if (n == 259 && this.I_field_49 > 0) {
            int n4 = Screen.hasControlDown() ? Math.max(1, this.I_method_fb5b3028(false)) : 1;
            for (int i = 0; i < n4; ++i) {
                this.i_method_fd1de084(-1);
                Nested1_6df13420 nested1_6df13420 = null;
                for (int j = this.I_field_49; j >= 0; --j) {
                    Nested1_6df13420 nested1_6df134202 = this.I_field_7865b31.get(j);
                    if (nested1_6df134202.I_field_5a) continue;
                    nested1_6df13420 = nested1_6df134202;
                    break;
                }
                if (nested1_6df13420 == null) continue;
                nested1_6df13420.I_field_5a = true;
            }
            iiIiIIIII_Class417.III_field_34b2ba6c.I_method_7289b65f(0.3f, 1.2f);
        } else if (n == 261 && this.I_field_49 < this.I_field_7865b31.size()) {
            int n5 = Screen.hasControlDown() ? Math.max(1, this.I_method_fb5b3028(true)) : 1;
            block2: for (int i = 0; i < n5 && this.I_field_49 < this.I_field_7865b31.size(); ++i) {
                for (int j = this.I_field_49; j < this.I_field_7865b31.size(); ++j) {
                    Nested1_6df13420 nested1_6df13420 = this.I_field_7865b31.get(j);
                    if (nested1_6df13420.I_field_5a) continue;
                    nested1_6df13420.I_field_5a = true;
                    continue block2;
                }
            }
            this.i_method_fd1de084(0);
            iiIiIIIII_Class417.III_field_34b2ba6c.I_method_7289b65f(0.3f, 1.2f);
        } else if (n == 263) {
            int n6;
            iiIiIIIII_Class417.III_field_34b2ba6c.I_method_7289b65f(0.3f, 1.3f);
            int n7 = n6 = Screen.hasControlDown() ? Math.max(1, this.I_method_fb5b3028(false)) : 1;
            if (Screen.hasShiftDown()) {
                this.II_method_71c59681(-n6);
            } else if (this.I_field_93ed2287 != null) {
                this.I_field_49 = this.I_field_93ed2287.I_method_5f594fad();
                this.I_field_93ed2287 = null;
                return;
            }
            this.i_method_fd1de084(-n6);
        } else if (n == 262) {
            int n8;
            iiIiIIIII_Class417.III_field_34b2ba6c.I_method_7289b65f(0.3f, 1.3f);
            int n9 = n8 = Screen.hasControlDown() ? Math.max(1, this.I_method_fb5b3028(true)) : 1;
            if (Screen.hasShiftDown()) {
                this.II_method_71c59681(n8);
            } else if (this.I_field_93ed2287 != null) {
                this.I_field_49 = this.I_field_93ed2287.i_method_5f67db8d();
                this.I_field_93ed2287 = null;
                return;
            }
            this.i_method_fd1de084(n8);
        } else if (Screen.isSelectAll((int)n)) {
            this.I_field_93ed2287 = new Nested1_6df13400(true, 0, this.I_field_7865b31.size());
        } else if (Screen.isCopy((int)n)) {
            if (this.I_field_93ed2287 != null) {
                IiIiIIIII_Class161.I_field_3a9bda27.keyboard.setClipboard(this.iI_method_4eabaffe());
                return;
            }
            IiIiIIIII_Class161.I_field_3a9bda27.keyboard.setClipboard(this.I_field_523beb0a);
        } else if (Screen.isCut((int)n)) {
            if (this.I_field_93ed2287 != null) {
                IiIiIIIII_Class161.I_field_3a9bda27.keyboard.setClipboard(this.iI_method_4eabaffe());
                this.ii_method_fd3af0c2();
                this.i_method_fd1de084(0);
                return;
            }
            IiIiIIIII_Class161.I_field_3a9bda27.keyboard.setClipboard(this.I_field_523beb0a);
            for (Nested1_6df13420 nested1_6df13420 : this.I_field_7865b31) {
                nested1_6df13420.I_field_5a = true;
            }
            this.I_field_523beb0a = "";
        } else if (Screen.isPaste((int)n)) {
            this.i_method_ee124e69(IiIiIIIII_Class161.I_field_3a9bda27.keyboard.getClipboard());
        } else if (n == 258 || n == 257) {
            this.Ii_method_fb7800a2();
            IiIIiiiii_Class160 iiIIiiiii_Class160 = this.I_field_a567c40b.get(this.Ii_field_523beb0a);
            if (iiIIiiiii_Class160 != null) {
                this.II_method_fb6974c2();
                if (n == 257) {
                    iiIIiiiii_Class160.I_method_bc6510f5().run();
                } else {
                    iiIIiiiii_Class160.i_method_2983915().run();
                }
                this.I_method_fb5b3035(false);
                return;
            }
            if (n == 257) {
                this.I_method_fb5b3035(false);
            }
        } else if (n == 259 && this.I_field_7865b31.isEmpty()) {
            this.I_method_fb5b3035(false);
        }
        this.Ii_method_fb7800a2();
    }

    @Override
    public boolean I_method_b71e84c9(char c, int n) {
        if (!this.i_field_5a) {
            return false;
        }
        if (this.II_field_5a) {
            if (!Character.isDigit(c) && c != '.' && c != '-' && c != ',') {
                return false;
            }
            if (c == '-' && this.I_field_49 != 0) {
                return false;
            }
            if ((c == '.' || c == ',') && (this.I_field_523beb0a.contains(".") || this.I_field_523beb0a.contains(","))) {
                return false;
            }
            if (c == ',') {
                c = (char)46;
            }
        }
        if (c == ' ') {
            iiIiIIIII_Class417.III_field_34b2ba6c.I_method_7289b65f(0.3f, 0.8f);
        } else {
            if (!this.I_field_64d80c39.containsKey(Character.valueOf(c))) {
                this.I_field_64d80c39.put(Character.valueOf(c), Float.valueOf(iIIiiiiiI_Class319.I_method_b56b22f(0.8, 1.2)));
            }
            iiIiIIIII_Class417.III_field_34b2ba6c.I_method_7289b65f(0.3f, this.I_field_64d80c39.get(Character.valueOf(c)).floatValue());
        }
        this.I_method_fb5ad9de(c);
        this.Ii_method_fb7800a2();
        return true;
    }

    private void Ii_method_fb7800a2() {
        String string = this.I_field_523beb0a;
        StringBuilder stringBuilder = new StringBuilder();
        for (Nested1_6df13420 nested1_6df13420 : this.I_field_7865b31) {
            if (nested1_6df13420.I_field_5a) continue;
            stringBuilder.append(nested1_6df13420.I_field_523beb0a);
        }
        this.I_field_523beb0a = stringBuilder.toString();
        if (!string.equals(this.I_field_523beb0a)) {
            this.Ii_field_523beb0a = "";
            String string2 = IiiIiiIiI_Class219.I_method_12a37157(this.I_field_523beb0a);
            int n = Integer.MAX_VALUE;
            for (String string3 : this.I_field_a567c40b.keySet()) {
                int n2 = IiiIiiIiI_Class219.i_method_ca495fc6(IiiIiiIiI_Class219.I_method_12a37157(string3), string2);
                if (n2 >= n && (n2 != n || string3.compareToIgnoreCase(this.Ii_field_523beb0a) >= 0)) continue;
                this.Ii_field_523beb0a = string3;
                n = n2;
            }
        }
    }

    public int I_method_fb5b3028(boolean bl) {
        int n = 0;
        if (bl) {
            for (int i = this.I_field_49; i < this.I_field_7865b31.size(); ++i) {
                Nested1_6df13420 nested1_6df13420 = this.I_field_7865b31.get(i);
                if (!nested1_6df13420.I_field_5a && !nested1_6df13420.I_field_523beb0a.equals(" ")) {
                    ++n;
                    continue;
                }
                break;
            }
        } else {
            for (int i = this.I_field_49 - 1; i >= 0; --i) {
                Nested1_6df13420 nested1_6df13420 = this.I_field_7865b31.get(i);
                if (!nested1_6df13420.I_field_5a && !nested1_6df13420.I_field_523beb0a.equals(" ")) {
                    ++n;
                    continue;
                }
                break;
            }
        }
        return n;
    }

    public void i_method_ee124e69(String string) {
        Matcher matcher = I_field_5fd3861f.matcher(string == null ? "" : string);
        while (matcher.find()) {
            this.iI_method_2b8ada2c(matcher.group());
        }
    }

    public void I_method_fb5ad9de(char c) {
        this.iI_method_2b8ada2c(String.valueOf(c));
    }

    private void iI_method_2b8ada2c(String string) {
        this.ii_method_fd3af0c2();
        if (this.I_field_49 > 0 && this.I_field_49 <= this.I_field_7865b31.size()) {
            Nested1_6df13420 nested1_6df13420 = this.I_field_7865b31.get(this.I_field_49 - 1);
            if (!nested1_6df13420.I_field_5a && this.I_method_3143f417(nested1_6df13420.I_field_523beb0a, string)) {
                nested1_6df13420.I_field_523beb0a = nested1_6df13420.I_field_523beb0a + string;
                this.I_field_5a = true;
                return;
            }
        }
        if (this.Ii_field_49 > 0 && this.I_field_7865b31.size() >= this.Ii_field_49) {
            return;
        }
        this.I_field_7865b31.add(Math.clamp((long)this.I_field_49, 0, this.I_field_7865b31.size()), new Nested1_6df13420(string));
        this.I_field_5a = true;
        this.i_method_fd1de084(1);
        I_field_fdef2cc = this;
    }

    private boolean I_method_3143f417(String string, String string2) {
        if (string.endsWith("\u200d")) {
            return true;
        }
        if (string.length() == 1 && Character.isHighSurrogate(string.charAt(0)) && Character.isLowSurrogate(string2.charAt(0))) {
            return true;
        }
        int n = string2.codePointAt(0);
        if (n == 8205 || n == 8419 || n == 65038 || n == 65039 || n >= 127995 && n <= 127999) {
            return true;
        }
        int n2 = string.codePointCount(0, string.length());
        int n3 = string.codePointAt(0);
        return n2 == 1 && n3 >= 127462 && n3 <= 127487 && n >= 127462 && n <= 127487;
    }

    private void i_method_fd1de084(int n) {
        this.I_field_49 = MathHelper.clamp((int)(this.I_field_49 + n), (int)0, (int)this.I_field_7865b31.size());
        this.I_field_991c1e8c.I_method_23e11e3f();
    }

    public void II_method_fb6974c2() {
        this.I_field_7865b31.clear();
        this.I_field_5a = true;
        this.I_field_523beb0a = "";
        this.Ii_field_523beb0a = "";
    }

    private void iI_method_fd2c64e2() {
        Nested1_6df13420 nested1_6df13420;
        if (this.I_field_7865b31.isEmpty()) {
            return;
        }
        int n = this.I_field_49;
        int n2 = this.I_field_49;
        int n3 = this.I_field_49 - 1;
        while (n3 >= 0) {
            nested1_6df13420 = this.I_field_7865b31.get(n3);
            if (nested1_6df13420.I_field_5a || nested1_6df13420.I_field_523beb0a.equals(" ") || !nested1_6df13420.I_field_523beb0a.codePoints().allMatch(Character::isLetterOrDigit)) break;
            n = n3--;
        }
        for (n3 = this.I_field_49; n3 < this.I_field_7865b31.size(); ++n3) {
            nested1_6df13420 = this.I_field_7865b31.get(n3);
            if (nested1_6df13420.I_field_5a || nested1_6df13420.I_field_523beb0a.equals(" ") || !nested1_6df13420.I_field_523beb0a.codePoints().allMatch(Character::isLetterOrDigit)) break;
            n2 = n3 + 1;
        }
        if (n != n2) {
            this.I_field_93ed2287 = new Nested1_6df13400(true, n, n2);
            this.I_field_49 = n2;
        }
    }

    private void ii_method_fd3af0c2() {
        if (this.I_field_93ed2287 == null) {
            return;
        }
        for (Nested1_6df13420 nested1_6df13420 : this.I_method_8564d1e8()) {
            nested1_6df13420.I_field_5a = true;
        }
        this.I_field_49 = this.I_field_93ed2287.I_method_5f594fad();
        this.I_field_93ed2287 = null;
    }

    private List<Nested1_6df13420> I_method_8564d1e8() {
        ArrayList<Nested1_6df13420> arrayList = new ArrayList<Nested1_6df13420>();
        for (int i = this.I_field_93ed2287.I_method_5f594fad(); i < this.I_field_93ed2287.i_method_5f67db8d(); ++i) {
            arrayList.add(this.I_field_7865b31.get(i));
        }
        return arrayList;
    }

    private String iI_method_4eabaffe() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = this.I_field_93ed2287.I_method_5f594fad(); i < this.I_field_93ed2287.i_method_5f67db8d(); ++i) {
            stringBuilder.append(this.I_field_7865b31.get((int)i).I_field_523beb0a);
        }
        return stringBuilder.toString();
    }

    private void II_method_71c59681(int n) {
        if (this.I_field_93ed2287 == null) {
            this.I_field_93ed2287 = new Nested1_6df13400(n > 0, this.I_field_49, this.I_field_49);
        }
        if (!this.I_field_93ed2287.I_field_5a) {
            this.I_field_93ed2287.I_field_49 = MathHelper.clamp((int)(this.I_field_93ed2287.I_method_5f594fad() + n), (int)0, (int)this.I_field_7865b31.size());
        } else {
            this.I_field_93ed2287.i_field_49 = MathHelper.clamp((int)(this.I_field_93ed2287.i_method_5f67db8d() + n), (int)0, (int)this.I_field_7865b31.size());
        }
    }

    public void I_method_fb5af064(int n) {
        this.Ii_field_49 = n;
        if (n > 0 && this.I_field_7865b31.size() > n) {
            while (this.I_field_7865b31.size() > n) {
                this.I_field_7865b31.remove(this.I_field_7865b31.size() - 1);
            }
            this.I_field_5a = true;
            this.I_field_49 = Math.min(this.I_field_49, this.I_field_7865b31.size());
            this.Ii_method_fb7800a2();
        }
    }

    public IiIiIIIII_Class161 I_method_3d77f3b5() {
        this.Ii_field_5a = true;
        this.I_field_5a = true;
        return this;
    }

    private void III_method_71d41adf() {
        if (!this.I_field_5a) {
            return;
        }
        int n = this.I_field_7865b31.size();
        if (this.I_field_b4b.length < n) {
            this.I_field_b4b = new float[n];
        }
        if (this.i_field_b4b.length <= n) {
            this.i_field_b4b = new float[n + 1];
        }
        this.i_field_b4b[0] = 0.0f;
        for (int i = 0; i < n; ++i) {
            String string = this.Ii_field_5a ? "*" : this.I_field_7865b31.get((int)i).I_field_523beb0a;
            this.I_field_b4b[i] = IiIiiIIiI_Class179.I_method_cc1ab81a(this.I_field_856d0221, string);
            this.i_field_b4b[i + 1] = this.i_field_b4b[i] + this.I_field_b4b[i];
        }
        this.I_field_5a = false;
    }

    @Generated
    public IiIiIIIII_Class161(IIiIIi_Class10 iIiIIi_Class10) {
        this.I_field_856d0221 = iIiIIi_Class10;
    }

    @Generated
    public String I_method_d2579001() {
        return this.I_field_523beb0a;
    }

    @Generated
    public boolean I_method_189fd283() {
        return this.i_field_5a;
    }

    @Generated
    public String i_method_65764021() {
        return this.i_field_523beb0a;
    }

    @Generated
    public String II_method_7df45c1e() {
        return this.II_field_523beb0a;
    }

    @Generated
    public void II_method_e557b20c(String string) {
        this.i_field_523beb0a = string;
    }

    @Generated
    public void Ii_method_b60f05ec(String string) {
        this.II_field_523beb0a = string;
    }

    @Generated
    public void I_method_7d30db26(Map<String, IiIIiiiii_Class160> map) {
        this.I_field_a567c40b = map;
    }

    @Generated
    public String Ii_method_11130c3e() {
        return this.Ii_field_523beb0a;
    }

    @Generated
    public void iI_method_a8609f1e(float f) {
        this.ii_field_46 = f;
    }

    @Generated
    public ColorRGBA I_method_9717cee() {
        return this.I_field_d0c8ec5;
    }

    @Generated
    public void I_method_13a617e0(ColorRGBA colorRGBA) {
        this.I_field_d0c8ec5 = colorRGBA;
    }

    @Generated
    public boolean i_method_18ae5e63() {
        return this.II_field_5a;
    }

    @Generated
    public void i_method_fd1e2055(boolean bl) {
        this.II_field_5a = bl;
    }

    @Generated
    public int I_method_189fd272() {
        return this.Ii_field_49;
    }

    static {
        I_field_5fd3861f = Pattern.compile("\\X");
    }

    static class Nested1_6df13420 {
        final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0f, IiiiIiiII_Class237.III_field_dd60aac);
        boolean I_field_5a;
        String I_field_523beb0a;

        Nested1_6df13420(String string) {
            this.I_field_523beb0a = string;
        }
    }

    static class Nested1_6df13400 {
        final boolean I_field_5a;
        int I_field_49;
        int i_field_49;

        int I_method_5f594fad() {
            return Math.min(this.i_field_49, this.I_field_49);
        }

        int i_method_5f67db8d() {
            return Math.max(this.i_field_49, this.I_field_49);
        }

        @Generated
        public Nested1_6df13400(boolean bl, int n, int n2) {
            this.I_field_5a = bl;
            this.I_field_49 = n;
            this.i_field_49 = n2;
        }
    }
}

