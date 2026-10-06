package moscow.rockstar.mixin.minecraft.client.gui.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import moscow.rockstar.mixin.accessors.ScreenAccessor;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.AnvilScreen;
import net.minecraft.client.gui.screen.ingame.CraftingScreen;
import net.minecraft.client.gui.screen.ingame.CreativeInventoryScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.InventoryScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.util.InputUtil;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import pyrock.events.render.ScreenRenderEvent;
import pyrock.events.window.ContainerClickEvent;
import pyrock.events.window.ContainerReleaseEvent;
import pyrock.utility.render.CustomDrawContext;
import rockstar.client.InventoryUtilsModule;
import rockstar.client.BeautifullyModule;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiIiiII_Class237;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.iiIiIIiii_Class424;

@Mixin(value={HandledScreen.class})
public abstract class HandledScreenMixin
implements iIIiIIiIi_Class294 {
    @Unique
    private iiIiIIiii_Class424 timer;
    @Unique
    private long rockstar$openTime;
    @Unique
    private boolean rockstar$scaled;
    @Unique
    private float rockstar$progress;
    @Shadow
    protected int field_2776;
    @Shadow
    protected int field_2800;
    @Shadow
    protected int field_2792;
    @Shadow
    protected int field_2779;

    @Unique
    private iiIiIIiii_Class424 rockstar$timer() {
        if (this.timer == null) {
            this.timer = new iiIiIIiii_Class424();
        }
        return this.timer;
    }

    @Shadow
    protected abstract boolean method_2387(Slot var1, double var2, double var4);

    @Shadow
    protected abstract void method_2383(Slot var1, int var2, int var3, SlotActionType var4);

    @Inject(method={"init"}, at={@At(value="HEAD")})
    private void rockstar$startOpenAnimation(CallbackInfo callbackInfo) {
        this.rockstar$openTime = System.currentTimeMillis();
    }

    @Inject(method={"renderBackground"}, at={@At(value="HEAD")})
    private void rockstar$beginOpenAnimation(DrawContext drawContext, int n, int n2, float f, CallbackInfo callbackInfo) {
        this.rockstar$scaled = false;
        if (!BeautifullyModule.iII_method_e63bea43()) {
            return;
        }
        float f2 = (float)(System.currentTimeMillis() - this.rockstar$openTime) / 200.0f;
        if (f2 >= 1.0f || f2 < 0.0f) {
            return;
        }
        this.rockstar$progress = IiiiIiiII_Class237.i_field_dd60aac.ease(f2, 0.0f, 1.0f, 1.0f);
        this.rockstar$scaled = true;
        drawContext.draw();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)MathHelper.clamp((float)(f2 * 2.0f), (float)0.0f, (float)1.0f));
    }

    @Inject(method={"renderBackground"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/gui/screen/ingame/HandledScreen;renderInGameBackground(Lnet/minecraft/client/gui/DrawContext;)V", shift=At.Shift.AFTER)})
    private void rockstar$pushOpenAnimation(DrawContext drawContext, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (!this.rockstar$scaled) {
            return;
        }
        float f2 = this.field_2776 + this.field_2792 / 2.0f;
        float f3 = this.field_2800 + this.field_2779 / 2.0f;
        float f4 = 0.88f + 0.12f * this.rockstar$progress;
        drawContext.getMatrices().push();
        drawContext.getMatrices().translate(f2, f3 + (1.0f - this.rockstar$progress) * 10.0f, 0.0f);
        drawContext.getMatrices().scale(f4, f4, 1.0f);
        drawContext.getMatrices().translate(-f2, -f3, 0.0f);
    }

    @Inject(method={"render"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/util/math/MatrixStack;pop()V", shift=At.Shift.AFTER)})
    private void rockstar$popOpenAnimation(DrawContext drawContext, int n, int n2, float f, CallbackInfo callbackInfo) {
        if (!this.rockstar$scaled) {
            return;
        }
        this.rockstar$scaled = false;
        drawContext.draw();
        drawContext.getMatrices().pop();
        RenderSystem.setShaderColor((float)1.0f, (float)1.0f, (float)1.0f, (float)1.0f);
    }

    @Inject(method={"init"}, at={@At(value="TAIL")})
    private void init(CallbackInfo callbackInfo) {
        if (!(RockstarClient.getInstance().i_method_e8604970() || HandledScreenMixin.I_field_3a9bda27.currentScreen instanceof InventoryScreen || HandledScreenMixin.I_field_3a9bda27.currentScreen instanceof CreativeInventoryScreen || HandledScreenMixin.I_field_3a9bda27.currentScreen instanceof CraftingScreen || HandledScreenMixin.I_field_3a9bda27.currentScreen instanceof AnvilScreen || HandledScreenMixin.I_field_3a9bda27.currentScreen.getTitle().getString().toLowerCase().contains("\u0430\u0443\u043a\u0446\u0438\u043e\u043d\u044b") || HandledScreenMixin.I_field_3a9bda27.currentScreen.getTitle().getString().toLowerCase().contains("\u0445\u0440\u0430\u043d\u0438\u043b\u0438\u0449\u0435"))) {
            Text text = Text.of((String)IiIiIIII_Class81.I_method_f25a980a("inventory.button.move"));
            int n = HandledScreenMixin.I_field_3a9bda27.textRenderer.getWidth((StringVisitable)text) + 20;
            int n2 = 80;
            int n3 = 200;
            int n4 = Math.max(n2, Math.min(n3, n));
            ButtonWidget buttonWidget2 = ButtonWidget.builder((Text)text, buttonWidget -> this.stealItems()).dimensions(this.field_2776 + this.field_2792 / 2 - n4 / 2, this.field_2800 - 20, n4, 18).build();
            ((ScreenAccessor)((Object)this)).invokeAddDrawableChild(buttonWidget2);
            Text text2 = Text.of((String)IiIiIIII_Class81.I_method_f25a980a("inventory.button.steal"));
            int n5 = HandledScreenMixin.I_field_3a9bda27.textRenderer.getWidth((StringVisitable)text2) + 20;
            int n6 = 80;
            int n7 = 200;
            int n8 = Math.max(n6, Math.min(n7, n5));
            ButtonWidget buttonWidget3 = ButtonWidget.builder((Text)text2, buttonWidget -> this.moveItems()).dimensions(this.field_2776 + this.field_2792 / 2 - n8 / 2, this.field_2800 - 40, n8, 18).build();
            ((ScreenAccessor)((Object)this)).invokeAddDrawableChild(buttonWidget3);
        }
    }

    @Inject(method={"render"}, at={@At(value="TAIL")})
    private void onRender(DrawContext drawContext, int n, int n2, float f, CallbackInfo callbackInfo) {
        CustomDrawContext customDrawContext = CustomDrawContext.of(drawContext);
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new ScreenRenderEvent(customDrawContext, f));
        DefaultedList defaultedList = HandledScreenMixin.I_field_3a9bda27.player.currentScreenHandler.slots;
        for (Slot slot : (Iterable<Slot>)(Iterable<?>)defaultedList) {
            InventoryUtilsModule iIIiIiIIi_Class42 = RockstarClient.getInstance().getModuleManager().getModule(InventoryUtilsModule.class);
            if (!this.method_2387(slot, n, n2) || !slot.isEnabled() || !iIIiIiIIi_Class42.isEnabled() || !iIIiIiIIi_Class42.I_method_22880b0().isSelected() || !this.rockstar$timer().I_method_58432069((long)iIIiIiIIi_Class42.I_method_61b19b55().Ii_method_a20abcd2()) || !InputUtil.isKeyPressed((long)I_field_3a9bda27.getWindow().getHandle(), (int)340) || GLFW.glfwGetMouseButton((long)I_field_3a9bda27.getWindow().getHandle(), (int)0) != 1) continue;
            this.method_2383(slot, slot.id, 0, SlotActionType.QUICK_MOVE);
            this.rockstar$timer().I_method_23e11e3f();
        }
    }

    @Inject(method={"mouseClicked"}, at={@At(value="HEAD")})
    private void onMouseClick(double d, double d2, int n, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new ContainerClickEvent((float)d, (float)d2, n));
    }

    @Inject(method={"mouseReleased"}, at={@At(value="HEAD")})
    public void mouseReleased(double d, double d2, int n, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(new ContainerReleaseEvent((float)d, (float)d2, n));
    }

    @Unique
    private void moveItems() {
        if (HandledScreenMixin.I_field_3a9bda27.player != null && HandledScreenMixin.I_field_3a9bda27.interactionManager != null) {
            int n = HandledScreenMixin.I_field_3a9bda27.player.currentScreenHandler.slots.size() - 36;
            int n2 = HandledScreenMixin.I_field_3a9bda27.player.currentScreenHandler.slots.size() - 1;
            for (int i = n; i <= n2; ++i) {
                Slot slot = HandledScreenMixin.I_field_3a9bda27.player.currentScreenHandler.getSlot(i);
                if (slot == null) continue;
                HandledScreenMixin.I_field_3a9bda27.interactionManager.clickSlot(HandledScreenMixin.I_field_3a9bda27.player.currentScreenHandler.syncId, i, 0, SlotActionType.QUICK_MOVE, (PlayerEntity)HandledScreenMixin.I_field_3a9bda27.player);
            }
        }
    }

    @Unique
    private void stealItems() {
        if (HandledScreenMixin.I_field_3a9bda27.player != null && HandledScreenMixin.I_field_3a9bda27.interactionManager != null) {
            int n = HandledScreenMixin.I_field_3a9bda27.player.currentScreenHandler.slots.size() - 36;
            for (int i = 0; i < n; ++i) {
                Slot slot = HandledScreenMixin.I_field_3a9bda27.player.currentScreenHandler.getSlot(i);
                if (slot == null) continue;
                HandledScreenMixin.I_field_3a9bda27.interactionManager.clickSlot(HandledScreenMixin.I_field_3a9bda27.player.currentScreenHandler.syncId, i, 0, SlotActionType.QUICK_MOVE, (PlayerEntity)HandledScreenMixin.I_field_3a9bda27.player);
            }
        }
    }
}

