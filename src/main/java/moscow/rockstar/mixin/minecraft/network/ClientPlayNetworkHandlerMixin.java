package moscow.rockstar.mixin.minecraft.network;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import moscow.rockstar.mixin.accessors.EntityS2CPacketAccessor;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.s2c.play.CooldownUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityPositionSyncS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityS2CPacket;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.util.math.Vec3d;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import pyrock.events.game.EventSetCooldown;
import rockstar.client.RemovalsModule;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiiIii_Class252;
import rockstar.client.iIIiIIiIi_Class294;
import rockstar.client.BackTrackModule;

@Mixin(value={ClientPlayNetworkHandler.class})
public class ClientPlayNetworkHandlerMixin
implements iIIiIIiIi_Class294 {
    @WrapWithCondition(method={"onEntityStatus"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/particle/ParticleManager;addEmitter(Lnet/minecraft/entity/Entity;Lnet/minecraft/particle/ParticleEffect;I)V")})
    private boolean rockstar$hideTotemParticles(ParticleManager particleManager, Entity entity, ParticleEffect particleEffect, int n) {
        RemovalsModule iIiIiIIiI_Class83 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        return !iIiIiIIiI_Class83.isEnabled() || !iIiIiIIiI_Class83.IIi_method_c5dcd8b0().isSelected();
    }

    @WrapWithCondition(method={"onEntityStatus"}, at={@At(value="INVOKE", target="Lnet/minecraft/client/render/GameRenderer;showFloatingItem(Lnet/minecraft/item/ItemStack;)V")})
    private boolean rockstar$hideTotemItem(GameRenderer gameRenderer, ItemStack itemStack) {
        RemovalsModule iIiIiIIiI_Class83 = RockstarClient.getInstance().getModuleManager().getModule(RemovalsModule.class);
        return !iIiIiIIiI_Class83.isEnabled() || !iIiIiIIiI_Class83.IIi_method_c5dcd8b0().isSelected();
    }

    @Inject(method={"onEntity"}, at={@At(value="TAIL")})
    public void onEntity(EntityS2CPacket entityS2CPacket, CallbackInfo callbackInfo) {
        ClientPlayNetworkHandler clientPlayNetworkHandler = (ClientPlayNetworkHandler)(Object)this;
        ClientWorld clientWorld = clientPlayNetworkHandler.getWorld();
        if (clientWorld == null) {
            return;
        }
        int n = ((EntityS2CPacketAccessor)(Object)entityS2CPacket).getId();
        Entity entity = clientWorld.getEntityById(n);
        if (entity == null) {
            return;
        }
        double d = (double)entityS2CPacket.getDeltaX() / 4096.0;
        double d2 = (double)entityS2CPacket.getDeltaY() / 4096.0;
        double d3 = (double)entityS2CPacket.getDeltaZ() / 4096.0;
        Vec3d vec3d = IiiiiiIii_Class252.I_method_34ed4d41(entity).add(d, d2, d3);
        IiiiiiIii_Class252.I_method_7b13a0a3(entity, vec3d);
        BackTrackModule iiIiiIRockstarClient182 = RockstarClient.getInstance().getModuleManager().getModule(BackTrackModule.class);
        iiIiiIRockstarClient182.I_method_3d57e354(entity, vec3d, System.currentTimeMillis());
    }

    @Inject(method={"onEntityPositionSync"}, at={@At(value="HEAD")})
    private void onEntityPositionSyncPacket(EntityPositionSyncS2CPacket entityPositionSyncS2CPacket, CallbackInfo callbackInfo) {
        ClientPlayNetworkHandler clientPlayNetworkHandler = (ClientPlayNetworkHandler)(Object)this;
        ClientWorld clientWorld = clientPlayNetworkHandler.getWorld();
        if (clientWorld == null) {
            return;
        }
        int n = entityPositionSyncS2CPacket.id();
        Entity entity = clientWorld.getEntityById(n);
        if (entity == null) {
            return;
        }
        Vec3d vec3d = entityPositionSyncS2CPacket.values().position();
        IiiiiiIii_Class252.I_method_7b13a0a3(entity, vec3d);
        BackTrackModule iiIiiIRockstarClient182 = RockstarClient.getInstance().getModuleManager().getModule(BackTrackModule.class);
        iiIiiIRockstarClient182.i_method_f546e374(entity, vec3d, System.currentTimeMillis());
    }

    @Inject(method={"onCooldownUpdate"}, at={@At(value="HEAD")}, cancellable=true)
    private void handleCooldown(CooldownUpdateS2CPacket cooldownUpdateS2CPacket, CallbackInfo callbackInfo) {
        EventSetCooldown eventSetCooldown = new EventSetCooldown(cooldownUpdateS2CPacket.cooldown(), cooldownUpdateS2CPacket.cooldownGroup());
        RockstarClient.getInstance().I_method_7897deab().I_method_e7f802ad(eventSetCooldown);
        if (eventSetCooldown.getCooldown() != cooldownUpdateS2CPacket.cooldown()) {
            callbackInfo.cancel();
            ClientPlayNetworkHandlerMixin.I_field_3a9bda27.player.getItemCooldownManager().set(cooldownUpdateS2CPacket.cooldownGroup(), eventSetCooldown.getCooldown());
        }
    }
}

