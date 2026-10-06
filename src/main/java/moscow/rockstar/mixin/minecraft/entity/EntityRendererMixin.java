package moscow.rockstar.mixin.minecraft.entity;

import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import rockstar.client.WardenHelperModule;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiiiI_Class127;
import rockstar.client.iIIIIiII_Class133;

@Mixin({EntityRenderer.class})
public abstract class EntityRendererMixin<T extends Entity, S extends EntityRenderState> {
   @Inject(
      method = {"getDisplayName"},
      at = {@At("HEAD")},
      cancellable = true
   )
   private void onRenderLabel(T var1, CallbackInfoReturnable<Text> var2) {
      if (var1 instanceof ArmorStandEntity var3) {
         WardenHelperModule var4 = RockstarClient.getInstance().getModuleManager().getModule(WardenHelperModule.class);
         if (var4 != null && var4.I_method_fa108cf1(var3)) {
            var2.setReturnValue(null);
            return;
         }
      }

      if (var1 instanceof PlayerEntity var5) {
         iIIIIiII_Class133 var6 = IiiiiiiI_Class127.I_method_e1e653cb().I_method_b8f96026(iIIIIiII_Class133.class);
         if (var6 != null && var6.I_method_bfc7acbe(var5)) {
            var2.setReturnValue(null);
            return;
         }
         if (RockstarClient.getInstance() != null && RockstarClient.getInstance().I_method_7a5acaeb() != null
               && RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var5.getName().getString())) {
            var2.setReturnValue(Text.literal("§a" + var5.getName().getString()));
         }
      }
   }
}
