package pyrock.utility.render;

import com.mojang.blaze3d.systems.RenderSystem;
import moscow.rockstar.mixin.accessors.DrawContextAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.item.ItemRenderState;
import net.minecraft.client.texture.AbstractTexture;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ModelTransformationMode;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.crash.CrashException;
import net.minecraft.util.crash.CrashReport;
import net.minecraft.util.crash.CrashReportSection;
import net.minecraft.util.math.Vec2f;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import org.joml.Quaternionf;
import org.joml.Quaternionfc;
import org.joml.Vector3f;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.Rect;
import rockstar.client.InterfaceModule;
import rockstar.client.IIiIIi_Class10;
import rockstar.client.IIiiII_Class13;
import rockstar.client.IIiii_Class8;
import rockstar.client.IiIIIi_Class18;
import rockstar.client.IiIIi_Class10;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiIIIi_Class242;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iIIiiiiiI_Class319;
import rockstar.client.iIiiIIiii_Class360;
import rockstar.client.iIiiiIiiI_Class375;
import rockstar.client.iIiiiiIii_Class380;
import rockstar.client.iiIIIiIII_Class393;

public class CustomDrawContext
extends DrawContext
implements iIIiIIiIi_Class294 {
    private final DrawContext originalContext;
    private int itemBatchDepth;
    private boolean itemBatchHasVertices;
    private boolean itemBatchFlatLighting;
    private float[] itemBatchShaderColor;

    public CustomDrawContext(DrawContext drawContext) {
        super(MinecraftClient.getInstance(), ((DrawContextAccessor)(Object)drawContext).getVertexConsumers());
        this.originalContext = drawContext;
    }

    public static CustomDrawContext of(DrawContext drawContext) {
        return new CustomDrawContext(drawContext);
    }

    public Nested1_f061f568 beginItemBatch() {
        if (this.itemBatchDepth++ == 0) {
            iIiiiiIii_Class380.I_method_5f4b621f();
            this.itemBatchHasVertices = false;
            this.itemBatchShaderColor = null;
        }
        return new Nested1_f061f568();
    }

    void endItemBatch() {
        if (this.itemBatchDepth <= 0) {
            return;
        }
        if (--this.itemBatchDepth == 0) {
            this.flushItemBatch();
            DiffuseLighting.disableGuiDepthLighting();
            this.itemBatchShaderColor = null;
        }
    }

    private void flushItemBatch() {
        if (!this.itemBatchHasVertices) {
            return;
        }
        float[] fArray = (float[])RenderSystem.getShaderColor().clone();
        if (this.itemBatchShaderColor != null) {
            RenderSystem.setShaderColor((float)this.itemBatchShaderColor[0], (float)this.itemBatchShaderColor[1], (float)this.itemBatchShaderColor[2], (float)this.itemBatchShaderColor[3]);
        }
        if (this.itemBatchFlatLighting) {
            DiffuseLighting.disableGuiDepthLighting();
        } else {
            DiffuseLighting.enableGuiDepthLighting();
        }
        ((DrawContextAccessor)(Object)this.originalContext).getVertexConsumers().draw();
        RenderSystem.setShaderColor((float)fArray[0], (float)fArray[1], (float)fArray[2], (float)fArray[3]);
        this.itemBatchHasVertices = false;
        this.itemBatchShaderColor = null;
    }

    private boolean sameShaderColor(float[] fArray) {
        if (this.itemBatchShaderColor == null || fArray == null) {
            return false;
        }
        return Float.compare(this.itemBatchShaderColor[0], fArray[0]) == 0 && Float.compare(this.itemBatchShaderColor[1], fArray[1]) == 0 && Float.compare(this.itemBatchShaderColor[2], fArray[2]) == 0 && Float.compare(this.itemBatchShaderColor[3], fArray[3]) == 0;
    }

    public void drawEntity(int n, int n2, int n3, int n4, int n5, float f, float f2, float f3, LivingEntity livingEntity) {
        float f4 = (float)(n + n3) / 2.0f;
        float f5 = (float)(n2 + n4) / 2.0f;
        this.enableScissor(n, n2, n3, n4);
        Quaternionf quaternionf = new Quaternionf().rotateZ((float)Math.PI);
        Quaternionf quaternionf2 = new Quaternionf().rotateX(0.0f);
        quaternionf.mul((Quaternionfc)quaternionf2);
        float f6 = livingEntity.bodyYaw;
        float f7 = livingEntity.getYaw();
        float f8 = livingEntity.getPitch();
        float f9 = livingEntity.prevHeadYaw;
        float f10 = livingEntity.headYaw;
        livingEntity.bodyYaw = 180.0f;
        livingEntity.setYaw(180.0f);
        livingEntity.setPitch(0.0f);
        livingEntity.headYaw = livingEntity.getYaw();
        livingEntity.prevHeadYaw = livingEntity.getYaw();
        float f11 = livingEntity.getScale();
        Vector3f vector3f = new Vector3f(0.0f, livingEntity.getHeight() / 2.0f + f * f11, 0.0f);
        float f12 = (float)n5 / f11;
        InventoryScreen.drawEntity((DrawContext)this.originalContext, (float)f4, (float)f5, (float)f12, (Vector3f)vector3f, (Quaternionf)quaternionf, (Quaternionf)quaternionf2, (LivingEntity)livingEntity);
        livingEntity.bodyYaw = f6;
        livingEntity.setYaw(f7);
        livingEntity.setPitch(f8);
        livingEntity.prevHeadYaw = f9;
        livingEntity.headYaw = f10;
        this.disableScissor();
    }

    public void drawClientRect(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.drawClientRect(f, f2, f3, f4, f5, f6, f7, IiiiiIIIi_Class242.I_method_5ac4a715().I_method_37580a2f(), false);
    }

    public void drawClientRect(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        this.drawClientRect(f, f2, f3, f4, f5, f6, f7, f8, false);
    }

    public void drawClientRect(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean bl) {
        this.drawClientRect(f, f2, f3, f4, f5, f6, f7, f8, bl, false);
    }

    public void drawClientRect(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean bl, boolean bl2) {
        float effectiveRad = f8 <= 0.0F ? InterfaceModule.getCornerRadius() : f8;
        IIiii_Class8 iIiii_Class8 = IIiii_Class8.I_method_893b2757(effectiveRad);
        String style = InterfaceModule.getVisualStyle();
        boolean isCyber = "Tactical Cyber".equalsIgnoreCase(style) || InterfaceModule.isCyberHud();
        float opacityMul = InterfaceModule.getGlassOpacity();
        float blurVal = InterfaceModule.getBlurStrength();
        float glowMul = InterfaceModule.getBorderGlow();

        if (isCyber) {
            ColorRGBA accent = IiiiiIIIi_Class242.I_method_7df8e08e();
            this.drawSquircle(f, f2, f3, f4, f7, iIiii_Class8, new ColorRGBA(10.0F, 14.0F, 20.0F, 235.0F * f5 * opacityMul));
            this.drawSquircleBorder(f, f2, f3, f4, 1.0F, f7, iIiii_Class8, new ColorRGBA(30.0F, 50.0F, 75.0F, 190.0F * f5));
            this.drawBlurredRect(f, f2, f3, f4, blurVal * 0.6F, f7, iIiii_Class8, accent.withAlpha(60.0F * f5 * glowMul));
            float bLen = Math.min(6.0F, Math.min(f3, f4) * 0.3F);
            ColorRGBA bracketCol = accent.withAlpha(240.0F * f5);
            this.drawRect(f, f2, bLen, 1.5F, bracketCol);
            this.drawRect(f, f2, 1.5F, bLen, bracketCol);
            this.drawRect(f + f3 - bLen, f2, bLen, 1.5F, bracketCol);
            this.drawRect(f + f3 - 1.5F, f2, 1.5F, bLen, bracketCol);
            this.drawRect(f, f2 + f4 - 1.5F, bLen, 1.5F, bracketCol);
            this.drawRect(f, f2 + f4 - bLen, 1.5F, bLen, bracketCol);
            this.drawRect(f + f3 - bLen, f2 + f4 - 1.5F, bLen, 1.5F, bracketCol);
            this.drawRect(f + f3 - 1.5F, f2 + f4 - bLen, 1.5F, bLen, bracketCol);
            return;
        }

        // --- AUTHENTIC LIQUID GLASS STYLING ---
        if (bl2) {
            // Settings menu / popup dropdown: sleek dark translucent glass without nested refraction
            this.drawSquircle(f, f2, f3, f4, f7, iIiii_Class8, new ColorRGBA(15.0F, 16.0F, 22.0F, 225.0F * f5 * opacityMul));
            this.drawSquircleBorder(f, f2, f3, f4, 0.75F, f7, iIiii_Class8, IiiiiIIIi_Class242.IiI_field_d0c8ec5.withAlpha(120.0F * f5));
            return;
        }

        // Full Liquid Glass: optical blur, shader refraction, and Fresnel specular edge
        if (InterfaceModule.iII_method_f9a41e83()) {
            this.drawBlurredRect(f, f2, f3, f4, blurVal, f7, iIiii_Class8, ColorRGBA.WHITE.withAlpha(220.0F * f5 * InterfaceModule.i_method_fddc3e0f()));
        }
        if (InterfaceModule.Iii_method_c4da86a3()) {
            this.drawLiquidGlass(f, f2, f3, f4, f7, 0.08F + 0.07F * f6, iIiii_Class8, ColorRGBA.WHITE.withAlpha(255.0F * f5 * InterfaceModule.I_method_fdcdb22f()));
        }
        // Base glass tint
        this.drawSquircle(f, f2, f3, f4, f7, iIiii_Class8, new ColorRGBA(18.0F, 20.0F, 28.0F, 150.0F * f5 * opacityMul));
        // Specular glass perimeter highlight + glow
        if (bl) {
            this.drawSquircleBorder(f, f2, f3, f4, 0.8F, f7, iIiii_Class8, new ColorRGBA(255.0F, 255.0F, 255.0F, 70.0F * f5));
            if (glowMul > 0.01F) {
                ColorRGBA themeAccent = IiiiiIIIi_Class242.I_method_7df8e08e();
                this.drawBlurredRect(f, f2, f3, f4, 10.0F, f7, iIiii_Class8, themeAccent.withAlpha(40.0F * f5 * glowMul));
            }
        }
    }

    public void pushMatrix() {
        this.getMatrices().push();
    }

    public void popMatrix() {
        this.getMatrices().pop();
    }

    public void drawRect(float f, float f2, float f3, float f4, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_64122a2e(this.getMatrices(), f, f2, f3, f4, colorRGBA);
    }

    public void drawLine(Vec2f vec2f, Vec2f vec2f2, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_4c7ece4e(this.getMatrices(), vec2f, vec2f2, colorRGBA);
    }

    public void drawBezier(Vec2f vec2f, Vec2f vec2f2, Vec2f vec2f3, Vec2f vec2f4, ColorRGBA colorRGBA, int n) {
        iIiiIIiii_Class360.I_method_b485d5d5(this.getMatrices(), vec2f, vec2f2, vec2f3, vec2f4, colorRGBA, n);
    }

    public void drawSmoothBezier(float f, float f2, float f3, float f4, Vec2f vec2f, Vec2f vec2f2, Vec2f vec2f3, Vec2f vec2f4, float f5, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_7154cfb0(this.getMatrices(), f, f2, f3, f4, vec2f, vec2f2, vec2f3, vec2f4, f5, colorRGBA);
    }

    public void drawAreaGradient(float[] fArray, float[] fArray2, float f, ColorRGBA colorRGBA, ColorRGBA colorRGBA2) {
        iIiiIIiii_Class360.I_method_fce64af9(this.getMatrices(), fArray, fArray2, f, colorRGBA, colorRGBA2);
    }

    public void drawSquircle(float f, float f2, float f3, float f4, float f5, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_9215be48(this.getMatrices(), f, f2, f3, f4, f5, iIiii_Class8, colorRGBA);
    }

    public void drawSquircle(float f, float f2, float f3, float f4, float f5, IIiii_Class8 iIiii_Class8, IiIIi_Class10 iiIIi_Class10) {
        iIiiIIiii_Class360.I_method_8fd5f68f(this.getMatrices(), f, f2, f3, f4, f5, iIiii_Class8, iiIIi_Class10);
    }

    public void drawSquircle(float f, float f2, float f3, float f4, float f5, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA, ColorRGBA colorRGBA2, ColorRGBA colorRGBA3, ColorRGBA colorRGBA4) {
        iIiiIIiii_Class360.I_method_43fbeb57(this.getMatrices(), f, f2, f3, f4, f5, iIiii_Class8, colorRGBA, colorRGBA2, colorRGBA3, colorRGBA4);
    }

    public void drawRoundedRect(float f, float f2, float f3, float f4, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_4e16a74a(this.getMatrices(), f, f2, f3, f4, iIiii_Class8, colorRGBA);
    }

    public void drawRoundedRect(float f, float f2, float f3, float f4, IIiii_Class8 iIiii_Class8, IiIIi_Class10 iiIIi_Class10) {
        iIiiIIiii_Class360.I_method_8573da11(this.getMatrices(), f, f2, f3, f4, iIiii_Class8, iiIIi_Class10);
    }

    public void drawRocknetGlass(Rect rect, float f, float f2, float f3, float f4, float f5, float f6, IIiii_Class8 iIiii_Class8, boolean bl) {
        iIiii_Class8 = new IIiii_Class8(iIiii_Class8.I_method_b483cecf() * f5 / 2.0f, iIiii_Class8.i_method_b4925aaf() * f5 / 2.0f, iIiii_Class8.Ii_method_dc139032() * f5 / 2.0f, iIiii_Class8.II_method_dc050452() * f5 / 2.0f);
        ColorRGBA colorRGBA = ColorRGBA.WHITE;
        TextureManager textureManager = MinecraftClient.getInstance().getTextureManager();
        AbstractTexture abstractTexture = textureManager.getTexture(RockstarClient.id(bl ? "rocknet/background.png" : "rocknet/blur.png"));
        iIiiIIiii_Class360.I_method_34145f56(rect, this.getMatrices(), f, f2, f3, f4, iIiii_Class8, colorRGBA, colorRGBA.getAlpha() / 255.0f, f4 == 240.0f ? 100 : 50, colorRGBA.withAlpha(255.0f), 1.0f, true, 0.0f, f6, f5, abstractTexture.getGlId());
    }

    public void drawLiquidGlass(float f, float f2, float f3, float f4, float f5, float f6, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiii_Class8 = new IIiii_Class8(iIiii_Class8.I_method_b483cecf() * f5 / 2.0f, iIiii_Class8.i_method_b4925aaf() * f5 / 2.0f, iIiii_Class8.Ii_method_dc139032() * f5 / 2.0f, iIiii_Class8.II_method_dc050452() * f5 / 2.0f);
        iIiiIIiii_Class360.I_method_78e2b35d(this.getMatrices(), f - 5.0f * InterfaceModule.i_method_fddc3e0f(), f2 - 5.0f * InterfaceModule.i_method_fddc3e0f(), f3 + 10.0f * InterfaceModule.i_method_fddc3e0f(), f4 + 10.0f * InterfaceModule.i_method_fddc3e0f(), iIiii_Class8, colorRGBA, colorRGBA.getAlpha() / 255.0f * InterfaceModule.I_method_fdcdb22f(), (IiiiiIIIi_Class242.I_method_5ac4a715().iI_method_b57b2512() + (float)(f4 == 240.0f ? 2 : 1)) * InterfaceModule.I_method_fdcdb22f(), colorRGBA.withAlpha(255.0f), 1.0f, true, 0.0f, (f6 == 0.08f ? IiiiiIIIi_Class242.I_method_5ac4a715().ii_method_b589b0f2() : f6) * InterfaceModule.I_method_fdcdb22f(), f5, false);
    }

    public void drawLiquidGlass(float f, float f2, float f3, float f4, float f5, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA, boolean bl) {
        iIiii_Class8 = new IIiii_Class8(iIiii_Class8.I_method_b483cecf() * f5 / 2.0f, iIiii_Class8.i_method_b4925aaf() * f5 / 2.0f, iIiii_Class8.Ii_method_dc139032() * f5 / 2.0f, iIiii_Class8.II_method_dc050452() * f5 / 2.0f);
        iIiiIIiii_Class360.I_method_78e2b35d(this.getMatrices(), f, f2, f3, f4, iIiii_Class8, colorRGBA, colorRGBA.getAlpha() / 255.0f, f4 == 240.0f ? 100.0f : 50.0f, colorRGBA.withAlpha(255.0f), 1.0f, true, 0.0f, 0.08f, f5, bl);
    }

    public void drawLoadingRect(float f, float f2, float f3, float f4, float f5, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.i_method_b39d0e68(this.getMatrices(), f, f2, f3, f4, f5, iIiii_Class8, colorRGBA);
    }

    public void drawRoundedBorder(float f, float f2, float f3, float f4, float f5, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.II_method_a4465a65(this.getMatrices(), f, f2, f3, f4, f5, iIiii_Class8, colorRGBA);
    }

    public void drawDashedBorder(float f, float f2, float f3, float f4, float f5, IIiii_Class8 iIiii_Class8, float f6, float f7, ColorRGBA colorRGBA, float f8, float f9, float f10, float f11) {
        iIiiIIiii_Class360.I_method_36dfa408(this.getMatrices(), f, f2, f3, f4, f5, iIiii_Class8, f6, f7, colorRGBA, f8, f9, f10, f11);
    }

    public void drawSquircleBorder(float f, float f2, float f3, float f4, float f5, float f6, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_cdf9870a(this.getMatrices(), f, f2, f3, f4, f5, f6, iIiii_Class8, colorRGBA);
    }

    public void drawTexture(Identifier identifier, Rect rect) {
        this.drawTexture(identifier, rect, ColorRGBA.WHITE);
    }

    public void drawTexture(Identifier identifier, Rect rect, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_1c6a5031(this.getMatrices(), identifier, rect.getX(), rect.getY(), rect.getWidth(), rect.getHeight(), colorRGBA);
    }

    public void drawTexture(Identifier identifier, float f, float f2, float f3, float f4) {
        iIiiIIiii_Class360.I_method_1c6a5031(this.getMatrices(), identifier, f, f2, f3, f4, ColorRGBA.WHITE);
    }

    public void drawTexture(Identifier identifier, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_30d83731(this.getMatrices(), identifier, f, f2, f3, f4, f5, f6, f7, f8, colorRGBA);
    }

    public void drawTexture(Identifier identifier, float f, float f2, float f3, float f4, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_1c6a5031(this.getMatrices(), identifier, f, f2, f3, f4, colorRGBA);
    }

    public void drawSprite(iiIIIiIII_Class393 iiIIIiIII_Class3932, float f, float f2, float f3, float f4, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_53b46eca(this.getMatrices(), iiIIIiIII_Class3932, f, f2, f3, f4, colorRGBA);
    }

    public void drawRoundedTexture(Identifier identifier, float f, float f2, float f3, float f4, IIiii_Class8 iIiii_Class8) {
        iIiiIIiii_Class360.I_method_df29c398(this.getMatrices(), identifier, f, f2, f3, f4, iIiii_Class8);
    }

    public void drawRoundedTexture(Identifier identifier, float f, float f2, float f3, float f4, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_e1f86de7(this.getMatrices(), identifier, f, f2, f3, f4, iIiii_Class8, colorRGBA);
    }

    public void drawShadow(float f, float f2, float f3, float f4, float f5, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.Ii_method_c5cdaa85(this.getMatrices(), f, f2, f3, f4, f5, iIiii_Class8, colorRGBA);
    }

    public void drawBlurredRect(float f, float f2, float f3, float f4, float f5, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.iI_method_b3a90e45(this.getMatrices(), f, f2, f3, f4, f5, iIiii_Class8, colorRGBA);
    }

    public void drawGlobalsBlur(Rect rect, float f, float f2, float f3, float f4, IIiii_Class8 iIiii_Class8, float f5) {
        iIiiIIiii_Class360.I_method_bc6b2f81(this.getMatrices(), rect, f, f2, f3, f4, iIiii_Class8, f5);
    }

    public void drawGlobalsBlur(Rect rect, float f, float f2, float f3, float f4, IIiii_Class8 iIiii_Class8) {
        iIiiIIiii_Class360.I_method_bc6b2f81(this.getMatrices(), rect, f, f2, f3, f4, iIiii_Class8, 1.0f);
    }

    public void drawBlurredRect(float f, float f2, float f3, float f4, float f5, float f6, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.i_method_dd5c3aea(this.getMatrices(), f, f2, f3, f4, f5, f6, iIiii_Class8, colorRGBA);
    }

    public void drawBackdropBlur(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_3ed5d708(this.getMatrices(), f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, iIiii_Class8, colorRGBA);
    }

    public void drawText(IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, ColorRGBA colorRGBA) {
        IiIIIi_Class18.I_method_f6065e6c(iIiIIi_Class10.I_method_36d49b4b(), string, iIiIIi_Class10.iI_method_24b6c285(), colorRGBA.getRGB(), this.getMatrices().peek().getPositionMatrix(), f, f2, 0.0f);
    }

    public void drawText(IIiIIi_Class10 iIiIIi_Class10, Text text, float f, float f2) {
        IiIIIi_Class18.I_method_c904cf99(iIiIIi_Class10.I_method_36d49b4b(), text, iIiIIi_Class10.iI_method_24b6c285(), this.getMatrices().peek().getPositionMatrix(), f, f2, 0.0f);
    }

    public void drawFadeoutText(IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, ColorRGBA colorRGBA, float f3, float f4) {
        IiIIIi_Class18.I_method_31d23fe8(iIiIIi_Class10.I_method_36d49b4b(), string, iIiIIi_Class10.iI_method_24b6c285(), colorRGBA.getRGB(), this.getMatrices().peek().getPositionMatrix(), f, f2, 0.0f, true, f3, f4);
    }

    public void drawFadeoutText(IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, ColorRGBA colorRGBA, float f3, float f4, float f5) {
        IiIIIi_Class18.I_method_87624d8(iIiIIi_Class10.I_method_36d49b4b(), string, iIiIIi_Class10.iI_method_24b6c285(), colorRGBA.getRGB(), this.getMatrices().peek().getPositionMatrix(), f, f2, 0.0f, true, f3, f4, f5);
    }

    public void drawFadeText(IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, ColorRGBA colorRGBA, float f3, float f4, float f5) {
        float f6 = Math.max(1.0f, f5);
        float f7 = Math.max(0.0f, f3) / f6;
        float f8 = (f6 - Math.max(0.0f, f4)) / f6;
        IiIIIi_Class18.I_method_c38d46d8(iIiIIi_Class10.I_method_36d49b4b(), string, iIiIIi_Class10.iI_method_24b6c285(), colorRGBA.getRGB(), this.getMatrices().peek().getPositionMatrix(), f, f2, 0.0f, true, f8, 1.0f, f6, 0.0f, f7);
    }

    public void drawCenteredText(IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, ColorRGBA colorRGBA) {
        this.drawText(iIiIIi_Class10, string, f - iIiIIi_Class10.I_method_36d49b4b().I_method_c000b13a(string, iIiIIi_Class10.iI_method_24b6c285()) / 2.0f, f2, colorRGBA);
    }

    public void drawTextWithShadow(IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, ColorRGBA colorRGBA, ColorRGBA colorRGBA2, float f3, float f4, float f5) {
        if (colorRGBA2.getAlpha() > 1.0f) {
            float f6 = Math.max(1.0f, Math.min(10.0f, f5));
            float f7 = 0.0f;
            IiIIIi_Class18.I_method_8df56b6c(iIiIIi_Class10.I_method_36d49b4b(), string, iIiIIi_Class10.iI_method_24b6c285(), colorRGBA2.getRGB(), this.getMatrices().peek().getPositionMatrix(), f + f3, f2 + f4, 0.0f, f7, f6);
        }
        this.drawText(iIiIIi_Class10, string, f, f2, colorRGBA);
    }

    public void drawCenteredTextWithShadow(IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, ColorRGBA colorRGBA, ColorRGBA colorRGBA2, float f3, float f4, float f5) {
        this.drawTextWithShadow(iIiIIi_Class10, string, f - iIiIIi_Class10.I_method_36d49b4b().I_method_c000b13a(string, iIiIIi_Class10.iI_method_24b6c285()) / 2.0f, f2, colorRGBA, colorRGBA2, f3, f4, f5);
    }

    public void drawRightText(IIiIIi_Class10 iIiIIi_Class10, String string, float f, float f2, ColorRGBA colorRGBA) {
        this.drawText(iIiIIi_Class10, string, f - iIiIIi_Class10.I_method_36d49b4b().I_method_c000b13a(string, iIiIIi_Class10.iI_method_24b6c285()), f2, colorRGBA);
    }

    public void drawIcon(String string, float f, float f2, float f3) {
        this.drawIcon(string, f, f2, f3, ColorRGBA.WHITE);
    }

    public void drawIcon(String string, float f, float f2, float f3, ColorRGBA colorRGBA) {
        Integer n = IIiiII_Class13.I_method_d04bdedd(string);
        if (n == null) {
            Object object = string.endsWith(".png") ? string : "icons/" + string + ".png";
            this.drawTexture(RockstarClient.id((String)object), f, f2, f3, f3, colorRGBA);
            return;
        }
        IiIIIi_Class18.I_method_6f9f3db5(IIiiII_Class13.I_method_a9f1134b(), n, f, f2, f3, colorRGBA.getRGB(), this.getMatrices().peek().getPositionMatrix());
    }

    public void drawItem(Item item, float f, float f2, float f3) {
        this.drawItem(item.getDefaultStack(), f, f2, f3);
    }

    public void drawItem(ItemStack itemStack, float f, float f2, float f3) {
        iIiiiiIii_Class380.I_method_5f4b621f();
        this.getMatrices().push();
        this.getMatrices().translate(f, f2, 0.0f);
        this.getMatrices().scale(f3, f3, f3);
        DiffuseLighting.enableGuiDepthLighting();
        this.drawItem(itemStack, 0, 0);
        DiffuseLighting.disableGuiDepthLighting();
        this.getMatrices().pop();
    }

    public void drawHead(AbstractClientPlayerEntity abstractClientPlayerEntity, float f, float f2, float f3, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_2f76388b(this.getMatrices(), abstractClientPlayerEntity, f, f2, f3, iIiii_Class8, colorRGBA);
    }

    public void drawHead(LivingEntity livingEntity, float f, float f2, float f3, IIiii_Class8 iIiii_Class8, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_84c2640d(this.getMatrices(), livingEntity, f, f2, f3, iIiii_Class8, colorRGBA);
    }

    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_4a80026e(this.getMatrices(), f, f2, f3, f4, f5, f6, colorRGBA);
    }

    public void drawArc(float f, float f2, float f3, float f4, float f5, float f6, ColorRGBA colorRGBA, boolean bl) {
        iIiiIIiii_Class360.I_method_580fe26(this.getMatrices(), f, f2, f3, f4, f5, f6, colorRGBA, bl);
    }

    public void drawCircleProgress(float f, float f2, float f3, float f4, float f5, ColorRGBA colorRGBA) {
        iIiiIIiii_Class360.I_method_5b4598f0(this.getMatrices(), f, f2, f3, f4, f5, colorRGBA);
    }

    public void drawBatchItem(ItemStack itemStack, float f, float f2, float f3) {
        this.drawBatchItem(itemStack, f, f2, f3, 0);
    }

    public void drawBatchItem(ItemStack itemStack, float f, float f2, float f3, int n) {
        this.prepareItemDraw();
        this.getMatrices().push();
        this.getMatrices().translate(f, f2, 0.0f);
        this.getMatrices().scale(f3, f3, f3);
        this.drawBatchItemInternal((LivingEntity)CustomDrawContext.I_field_3a9bda27.player, (World)CustomDrawContext.I_field_3a9bda27.world, itemStack, 0.0f, 0.0f, 0, n);
        this.getMatrices().pop();
    }

    public void drawBatchItem(ItemStack itemStack, float f, float f2) {
        this.drawBatchItem(itemStack, f, f2, 0);
    }

    public void drawBatchItem(ItemStack itemStack, float f, float f2, int n) {
        this.prepareItemDraw();
        this.drawBatchItemInternal((LivingEntity)CustomDrawContext.I_field_3a9bda27.player, (World)CustomDrawContext.I_field_3a9bda27.world, itemStack, f, f2, 0, n);
    }

    private void prepareItemDraw() {
        if (this.itemBatchDepth > 0 && iIiiiiIii_Class380.i_method_5f59ee03()) {
            this.flushItemBatch();
        }
        iIiiiiIii_Class380.I_method_5f4b621f();
    }

    private void drawBatchItemInternal(@Nullable LivingEntity livingEntity, @Nullable World world, ItemStack itemStack, float f, float f2, int n) {
        this.drawBatchItemInternal(livingEntity, world, itemStack, f, f2, n, 0);
    }

    private void drawBatchItemInternal(@Nullable LivingEntity livingEntity, @Nullable World world, ItemStack itemStack, float f, float f2, int n, int n2) {
        MatrixStack matrixStack = this.getMatrices();
        ItemRenderState itemRenderState = ((DrawContextAccessor)(Object)this.originalContext).getItemRenderState();
        VertexConsumerProvider.Immediate immediate = ((DrawContextAccessor)(Object)this.originalContext).getVertexConsumers();
        if (!itemStack.isEmpty()) {
            I_field_3a9bda27.getItemModelManager().update(itemRenderState, itemStack, ModelTransformationMode.GUI, false, world, livingEntity, n);
            matrixStack.push();
            matrixStack.translate(f + 8.0f, f2 + 8.0f, (float)(150 + (itemRenderState.hasDepth() ? n2 : 0)));
            try {
                boolean bl;
                matrixStack.scale(16.0f, -16.0f, 16.0f);
                boolean bl2 = bl = !itemRenderState.isSideLit();
                if (this.itemBatchDepth > 0) {
                    float[] fArray = (float[])RenderSystem.getShaderColor().clone();
                    if (this.itemBatchHasVertices && (this.itemBatchFlatLighting != bl || !this.sameShaderColor(fArray))) {
                        this.flushItemBatch();
                    }
                    if (!this.itemBatchHasVertices) {
                        if (bl) {
                            immediate.draw();
                        }
                        this.itemBatchFlatLighting = bl;
                        this.itemBatchShaderColor = fArray;
                    }
                    if (bl) {
                        DiffuseLighting.disableGuiDepthLighting();
                    } else {
                        DiffuseLighting.enableGuiDepthLighting();
                    }
                    iIiiiIiiI_Class375.I_method_2953ca26(itemRenderState, matrixStack, (VertexConsumerProvider)immediate, 0xF000F0, OverlayTexture.DEFAULT_UV);
                    this.itemBatchHasVertices = true;
                } else {
                    if (bl) {
                        immediate.draw();
                        DiffuseLighting.disableGuiDepthLighting();
                    } else {
                        DiffuseLighting.enableGuiDepthLighting();
                    }
                    iIiiiIiiI_Class375.I_method_2953ca26(itemRenderState, matrixStack, (VertexConsumerProvider)immediate, 0xF000F0, OverlayTexture.DEFAULT_UV);
                    immediate.draw();
                    if (bl) {
                        DiffuseLighting.enableGuiDepthLighting();
                    }
                }
            }
            catch (Throwable throwable) {
                CrashReport crashReport = CrashReport.create((Throwable)throwable, (String)"Rendering item");
                CrashReportSection crashReportSection = crashReport.addElement("Item being rendered");
                crashReportSection.add("Item Type", () -> String.valueOf(itemStack.getItem()));
                crashReportSection.add("Item Components", () -> String.valueOf(itemStack.getComponents()));
                crashReportSection.add("Item Foil", () -> String.valueOf(itemStack.hasGlint()));
                throw new CrashException(crashReport);
            }
            matrixStack.pop();
            DiffuseLighting.disableGuiDepthLighting();
        }
    }

    public final class Nested1_f061f568
    implements AutoCloseable {
        private boolean closed;

        @Override
        public void close() {
            if (this.closed) {
                return;
            }
            this.closed = true;
            CustomDrawContext.this.endItemBatch();
        }
    }
}

