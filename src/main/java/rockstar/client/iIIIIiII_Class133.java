package rockstar.client;

import globals.client.Information;
import globals.client.ui.CosmeticRender;
import globals.shared.proto.Packets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import lombok.Generated;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.DiffuseLighting;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.consume.UseAction;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.text.MutableText;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec2f;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.render.ChatRenderEvent;
import pyrock.events.render.PreHudRenderEvent;
import pyrock.events.window.ChatClickEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;

public class iIIIIiII_Class133 extends IiiiIiiI_Class119 {
   private static final int I_field_49 = 11;
   private static final int i_field_49 = 9;
   private static final float I_field_46 = 0.5F;
   private static final float i_field_46 = 1.0F;
   private static final float II_field_46 = 20.0F;
   private static final float Ii_field_46 = 22.0F;
   private static final float iI_field_46 = 4.0F;
   private static final float ii_field_46 = 3.0F;
   private static final float III_field_46 = 5.0F;
   private static final float IIi_field_46 = 14.0F;
   private static final float IiI_field_46 = 4.0F;
   private static final float Iii_field_46 = 4.0F;
   private static final float iII_field_46 = 18.0F;
   private static final float iIi_field_46 = -15.0F;
   private static final int II_field_49 = 11;
   private static final float iiI_field_46 = 0.6F;
   private static final float iii_field_46 = 9.0F;
   private static final float IIII_field_46 = 26.0F;
   private final List<Entity> I_field_7865b31 = new ArrayList<>();
   private final Map<Entity, Packets.Nested1_1da0dac9> I_field_a567c40b = new HashMap<>();
   private final Map<ItemEntity, List<iIIIIiII_Class133.Nested1_7169c0d3>> i_field_a567c40b = new HashMap<>();
   private final Map<Entity, Text> II_field_a567c40b = new HashMap<>();
   private final Map<Entity, Float> Ii_field_a567c40b = new HashMap<>();
   private final Map<Entity, Float> iI_field_a567c40b = new HashMap<>();
   private final BooleanSetting I_field_ba20ca4c = this.I_method_5436696c("esp.nametags");
   private final BooleanSetting i_field_ba20ca4c = this.i_method_e56d20dc(var0 -> new BooleanSetting(var0, "esp.nametags.show_armor"));
   private final BooleanSetting II_field_ba20ca4c = this.i_method_e56d20dc(var0 -> new BooleanSetting(var0, "esp.nametags.show_item_use"));
   private final BooleanSetting Ii_field_ba20ca4c = new BooleanSetting(
      this, "esp.nametags.background", () -> !this.i_method_d28dbf31(IiiiiIiI_Class123.Ii_field_12aac7a1)
   );
   private final BooleanSetting showFriendsGreen = new BooleanSetting(this, "Зеленые друзья").I_method_decd82b5();
   private final BooleanSetting showDistance = new BooleanSetting(this, "Дистанция").I_method_decd82b5();
   private final ModeSetting healthDisplayMode = new ModeSetting(this, "Отображение HP");
   private final ModeSetting.Nested1_42765c60 hpModeNumber = new ModeSetting.Nested1_42765c60(this.healthDisplayMode, "Число").select();
   private final ModeSetting.Nested1_42765c60 hpModePercent = new ModeSetting.Nested1_42765c60(this.healthDisplayMode, "Проценты");
   private final ModeSetting.Nested1_42765c60 hpModeNone = new ModeSetting.Nested1_42765c60(this.healthDisplayMode, "Выключено");
   private final iIiiIiiIi_Class366 I_field_e76524c = new iIiiIiiIi_Class366();
   private IiIIiiIii_Class156 I_field_ab760aac;
   private String I_field_523beb0a;
   private long I_field_4a;
   private final IiIIIiII_Class69<PreHudRenderEvent> I_field_3d936f41 = var1x -> {
      this.II_method_43596015();
      if (this.I_method_ea8b70b0()) {
         MatrixStack var2x = var1x.getContext().getMatrices();
         float var3x = var1x.getTickDelta();
         this.i_method_23a3cac();
         List var4 = this.i_method_10d281b();
         iiIIIIiii_Class392 var5 = new iiIIIIiii_Class392(IIiIiI_Class11.i_field_857c0621, 5.0F);
         iiIIIIiii_Class392 var6 = new iiIIIIiii_Class392(IIiIiI_Class11.i_field_857c0621, 0.0F);
         this.I_method_74f10f31(var5, var6, var2x, var4, var3x);
         this.I_method_a81be2f4(var5, var2x, var3x);
         this.I_method_c52a0c23(var5, var2x, var4, var3x);
         this.I_field_e76524c.I_method_357b71ff();
         var5.I_method_184247c4(this.I_field_e76524c.I_method_357b71f2(), 14.0F, 4.0F);
         var6.I_method_874ac61f();
         var5.I_method_874ac61f();
         this.I_method_d92e775f(var1x, var2x, var3x);
         this.i_method_fa27177f(var1x, var2x, var3x);
         this.II_method_5a827b6(var1x, var2x, var3x);

         for (Entity var8 : this.I_field_7865b31) {
            Vec3d var9 = iIiiiiIII_Class377.I_method_689b1a13(var8, var3x).add(0.0, var8.getBoundingBox().getLengthY() / 2.0, 0.0);
            Vec2f var10 = iIiiiiIII_Class377.I_method_211fc242(var9);
            if (var10 != null && var8.getType() == EntityType.PLAYER) {
               PlayerEntity var11 = (PlayerEntity)var8;
               BooleanSetting var12 = this.I_method_62f3944d("esp.nametags.show_item_use", this.I_method_f1d4e616(var11));
               if (var12 != null && var12.i_method_9b12da03()) {
                  this.i_method_4ba47a91(var1x, var2x, var11, var10);
               }
            }
         }

         DiffuseLighting.disableGuiDepthLighting();
         var1x.getContext().draw();
         this.Ii_method_26a0c7d6(var1x, var2x, var3x);
         if (!(I_field_3a9bda27.currentScreen instanceof ChatScreen)) {
            this.I_field_ab760aac = null;
         }
      }
   };
   private final IiIIIiII_Class69<ChatRenderEvent> i_field_3d936f41 = var1x -> {
      if (this.I_method_ea8b70b0()) {
         III var2x = III.I_method_5728d20f(
            var1x.getContext(),
            I_field_3a9bda27.currentScreen == null ? -1 : (int)iIIiIIIiI_Class291.I_method_81637b4f().getX(),
            I_field_3a9bda27.currentScreen == null ? -1 : (int)iIIiIIIiI_Class291.I_method_81637b4f().getY(),
            MinecraftClient.getInstance().getRenderTickCounter().getTickDelta(false)
         );
         if (this.I_field_ab760aac != null) {
            this.I_field_ab760aac.I_method_7ae26dda(var2x);
         }
      }
   };
   private final IiIIIiII_Class69<ChatClickEvent> II_field_3d936f41 = var1x -> {
      if (this.I_method_ea8b70b0()) {
         if (this.I_field_ab760aac != null) {
            this.I_field_ab760aac.I_method_400ceaa7(var1x.getX(), var1x.getY(), IiIII_Class9.I_method_40dce65a(var1x.getButton()));
            if (this.I_field_ab760aac.I_method_a74dc6d0(var1x.getX(), var1x.getY())) {
               return;
            }

            this.I_field_ab760aac.I_method_c3d80455(false);
         }

         for (Entity var3x : this.I_field_7865b31) {
            if (var3x.getType() == EntityType.PLAYER) {
               Vec2f var4 = this.I_method_120057bd(var3x, 1.0F);
               if (var4 != null && this.I_method_cd860351(var3x, var4, var1x.getX(), var1x.getY())) {
                  this.I_method_eb03d7ba(var1x.getX(), var1x.getY(), var3x);
                  return;
               }
            }
         }

         for (Entity var6 : this.I_field_a567c40b.keySet()) {
            Vec2f var7 = this.I_method_120057bd(var6, 1.0F);
            if (var7 != null && this.i_method_13770731(var6, var7, var1x.getX(), var1x.getY())) {
               this.I_method_eb03d7ba(var1x.getX(), var1x.getY(), var6);
               return;
            }
         }
      }
   };
   private final IiIIIiII_Class69<ReceivePacketEvent> Ii_field_3d936f41 = var1x -> {
      if (this.I_field_523beb0a != null && var1x.getPacket() instanceof GameMessageS2CPacket var2x) {
         String var4 = var2x.content().getString().toLowerCase(Locale.ROOT);
         if (var4.contains("unknown command")
            || var4.contains("unknown or incomplete command")
            || var4.contains("command not found")
            || var4.contains("no permission")
            || var4.contains("not have permission")
            || var4.contains("insufficient permission")
            || var4.contains("not allowed to use")
            || var4.contains("cannot use this command")
            || var4.contains("can't use this command")
            || var4.contains("\u043d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u0430\u044f \u043a\u043e\u043c\u0430\u043d\u0434\u0430")
            || var4.contains("\u043a\u043e\u043c\u0430\u043d\u0434\u0430 \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d\u0430")
            || var4.contains("\u043d\u0435\u0442 \u043f\u0440\u0430\u0432")
            || var4.contains("\u043d\u0435\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u043f\u0440\u0430\u0432")
            || var4.contains("\u043d\u0435 \u0445\u0432\u0430\u0442\u0430\u0435\u0442 \u043f\u0440\u0430\u0432")
            || var4.contains("\u0434\u043e\u0441\u0442\u0443\u043f \u0437\u0430\u043f\u0440\u0435\u0449\u0435\u043d")
            || var4.contains("\u0434\u043e\u0441\u0442\u0443\u043f \u0437\u0430\u043f\u0440\u0435\u0449\u0451\u043d")) {
            this.I_field_4a = 0L;
         }
      }
   };

   public iIIIIiII_Class133() {
      super(
         "nametags",
         IiiiiIiI_Class123.I_field_12aac7a1,
         IiiiiIiI_Class123.i_field_12aac7a1,
         IiiiiIiI_Class123.II_field_12aac7a1,
         IiiiiIiI_Class123.Ii_field_12aac7a1
      );
      this.I_method_1b2c55bc(this.Ii_field_ba20ca4c, new IiiiiIiI_Class123[]{IiiiiIiI_Class123.Ii_field_12aac7a1});
      this.Ii_field_ba20ca4c.I_method_decd82b5();
      this.I_method_54b913ca(new IiiiiIiI_Class123[]{IiiiiIiI_Class123.Ii_field_12aac7a1});
      this.I_method_52f623aa(
         new IiiiiIII_Class121[]{IiiiiIII_Class121.I_field_12aa4f81, IiiiiIII_Class121.II_field_12aa4f81, IiiiiIII_Class121.Ii_field_12aa4f81}
      );
      BooleanSetting var1 = this.I_method_62f3944d("esp.nametags.show_armor", IiiiiIII_Class121.I_field_12aa4f81);
      BooleanSetting var2 = this.I_method_62f3944d("esp.nametags.show_armor", IiiiiIII_Class121.II_field_12aa4f81);
      BooleanSetting var3 = this.I_method_62f3944d("esp.nametags.show_armor", IiiiiIII_Class121.Ii_field_12aa4f81);
      if (var1 != null) {
         var1.I_method_decd82b5();
      }

      if (var2 != null) {
         var2.I_method_decd82b5();
      }

      if (var3 != null) {
         var3.I_method_decd82b5();
      }
   }

   @Override
   public void I_method_d9976c2e(III var1, Entity var2, float var3, float var4, IiiiiIiI_Class123 var5, IiiiiIII_Class121 var6) {
      var1.getMatrices().push();
      var1.getMatrices().translate(0.0F, -var2.getHeight() * 15.0F, 0.0F);
      var1.getMatrices().translate(var3, var4, 0.0F);
      var1.getMatrices().scale(0.6F, 0.6F, 1.0F);
      var1.getMatrices().translate(-var3, -var4, 0.0F);
      if (var5 == IiiiiIiI_Class123.I_field_12aac7a1) {
         this.I_method_9545d8ed(var1, var2, var3, var4, var6);
      } else if (var5 == IiiiiIiI_Class123.Ii_field_12aac7a1 && var2 instanceof ItemEntity var7) {
         this.I_method_e7205d9(var1, var7, var3, var4);
      } else if (var5 == IiiiiIiI_Class123.i_field_12aac7a1 || var5 == IiiiiIiI_Class123.II_field_12aac7a1) {
         this.I_method_9708c90d(var1, var2, var3, var4, var5);
      }

      var1.getMatrices().pop();
   }

   private void I_method_9545d8ed(III var1, Entity var2, float var3, float var4, IiiiiIII_Class121 var5) {
      if (var5 == IiiiiIII_Class121.Ii_field_12aa4f81) {
         this.I_method_8a5d9e6c(var1, var2, var3, var4);
      } else {
         String var6 = var2.getName().getString();
         IIiIIi_Class10 var7 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F);
         float var8 = var7.I_method_2c375926(var6 + " ");
         float var9 = var7.I_method_2c375926("[20]");
         float var10 = 22.0F + var8 + var9 + 4.0F;
         float var11 = var3 - var10 / 2.0F;
         float var12 = var4 - 11.0F;
         var1.drawRoundedRect(var11, var12, var10, 22.0F, IIiii_Class8.I_method_893b2757(5.0F), new ColorRGBA(12.0F, 12.0F, 12.0F, 235.0F));
         if (var2 instanceof AbstractClientPlayerEntity var13) {
            var1.drawHead(var13, var11 + 4.0F, var12 + 4.0F, 14.0F, IIiii_Class8.I_method_893b2757(4.0F), ColorRGBA.WHITE);
         }

         float var16 = var11 + 4.0F + 14.0F + 4.0F;
         float var14 = var12 + (22.0F - var7.I_method_a649725c()) / 2.0F;
         var1.drawText(var7, var6 + " ", var16, var14, ColorRGBA.WHITE);
         var1.drawText(var7, "[20]", var16 + var8, var14, new ColorRGBA(255.0F, 85.0F, 85.0F));
         BooleanSetting var15 = this.I_method_62f3944d("esp.nametags.show_armor", var5);
         if (var15 != null && var15.i_method_9b12da03()) {
            this.I_method_bd7ad85a(var1, var3, var12 - 12.0F);
         }
      }
   }

   private void I_method_8a5d9e6c(III var1, Entity var2, float var3, float var4) {
      String var5 = var2.getName().getString();
      float var6 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F).I_method_2c375926(var5) + 31.0F;
      float var7 = 26.0F;
      float var8 = var3 - var6 / 2.0F;
      float var9 = var4 - var7 / 2.0F;
      var1.drawRoundedRect(var8, var9, var6, var7, IIiii_Class8.I_method_893b2757(7.0F), new ColorRGBA(12.0F, 12.0F, 12.0F, 255.0F));
      var1.drawRoundedTexture(RockstarClient.id("rocknet/avatar.png"), var8 + 5.0F, var9 + 5.0F, 16.0F, 16.0F, IIiii_Class8.I_method_893b2757(7.0F));
      var1.drawText(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(11.0F), var5, var8 + 25.0F, var9 + 9.0F, ColorRGBA.WHITE);
      BooleanSetting var10 = this.I_method_62f3944d("esp.nametags.show_armor", IiiiiIII_Class121.Ii_field_12aa4f81);
      if (var10 != null && var10.i_method_9b12da03()) {
         this.I_method_bd7ad85a(var1, var3, var9 - 20.0F);
      }
   }

   private void I_method_bd7ad85a(III var1, float var2, float var3) {
      ItemStack var4 = new ItemStack(Items.NETHERITE_HELMET);
      ItemStack var5 = new ItemStack(Items.NETHERITE_CHESTPLATE);
      ItemStack var6 = new ItemStack(Items.NETHERITE_LEGGINGS);
      ItemStack var7 = new ItemStack(Items.NETHERITE_BOOTS);
      ItemStack var8 = new ItemStack(Items.NETHERITE_SWORD);
      ItemStack var9 = new ItemStack(Items.TOTEM_OF_UNDYING);
      List var10 = List.of(var4, var5, var6, var7, var8, var9);
      float var11 = var10.size() * 12.0F;
      float var12 = var2 - var11 / 2.0F;

      for (int var13 = 0; var13 < var10.size(); var13++) {
         var1.drawItem((ItemStack)var10.get(var13), (int)(var12 + var13 * 12), (int)var3, 0.75F);
      }
   }

   private void I_method_e7205d9(III var1, ItemEntity var2, float var3, float var4) {
      String var5 = var2.getStack().getName().getString();
      float var6 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F).I_method_2c375926(var5);
      float var7 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F).I_method_a649725c();
      if (this.Ii_field_ba20ca4c.i_method_9b12da03()) {
         var1.drawRect(var3 - var6 / 2.0F - 3.0F, var4 - 3.0F, var6 + 6.0F, var7 + 6.0F, new ColorRGBA(0.0F, 0.0F, 0.0F, 100.0F));
      }

      var1.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F), var5, var3 - var6 / 2.0F, var4, ColorRGBA.WHITE);
   }

   private void I_method_9708c90d(III var1, Entity var2, float var3, float var4, IiiiiIiI_Class123 var5) {
      if (var2 instanceof LivingEntity var6) {
         String var7 = var2.getName().getString();
         int var8 = (int)var6.getHealth();
         String var9 = var7 + " [" + var8 + "]";
         float var10 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F).I_method_2c375926(var9);
         float var11 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F).I_method_a649725c();
         var1.drawRect(var3 - var10 / 2.0F - 3.0F, var4 - 3.0F, var10 + 6.0F, var11 + 6.0F, new ColorRGBA(0.0F, 0.0F, 0.0F, 100.0F));
         var1.drawText(IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F), var7 + " ", var3 - var10 / 2.0F, var4, ColorRGBA.WHITE);
         var1.drawText(
            IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F),
            "[" + var8 + "]",
            var3 - var10 / 2.0F + IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F).I_method_2c375926(var7 + " "),
            var4,
            new ColorRGBA(255.0F, 85.0F, 85.0F)
         );
      }
   }

   public boolean I_method_bfc7acbe(Entity var1) {
      if (var1 instanceof PlayerEntity var2) {
         if (var2 == I_field_3a9bda27.player) {
            return I_field_3a9bda27.options.getPerspective().isFirstPerson() ? false : this.i_method_d0cacf11(IiiiiIII_Class121.i_field_12aa4f81);
         }
         if (var2.isInvisible()) {
            return false;
         }
         if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
            net.minecraft.util.hit.BlockHitResult hit = I_field_3a9bda27.world.raycast(new net.minecraft.world.RaycastContext(
               I_field_3a9bda27.player.getEyePos(),
               var2.getEyePos(),
               net.minecraft.world.RaycastContext.ShapeType.COLLIDER,
               net.minecraft.world.RaycastContext.FluidHandling.NONE,
               I_field_3a9bda27.player
            ));
            if (hit.getType() != net.minecraft.util.hit.HitResult.Type.MISS) {
               return false;
            }
         }
         if (this.I_method_4569b425(var2)) {
            return this.i_method_d0cacf11(IiiiiIII_Class121.Ii_field_12aa4f81);
         } else {
            return RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var2.getName().getString())
               ? this.i_method_d0cacf11(IiiiiIII_Class121.II_field_12aa4f81)
               : this.i_method_d0cacf11(IiiiiIII_Class121.I_field_12aa4f81);
         }
      } else if (var1 instanceof ItemEntity) {
         return this.i_method_d28dbf31(IiiiiIiI_Class123.Ii_field_12aac7a1);
      } else if (var1 instanceof HostileEntity) {
         return this.i_method_d28dbf31(IiiiiIiI_Class123.i_field_12aac7a1);
      } else {
         return var1 instanceof AnimalEntity ? this.i_method_d28dbf31(IiiiiIiI_Class123.II_field_12aac7a1) : false;
      }
   }

   private float I_method_bfc7acaa(Entity var1) {
      if (I_field_3a9bda27.player.age % 25 == 0) {
      }

      float var2 = var1.distanceTo(I_field_3a9bda27.player);
      return MathHelper.clamp(1.0F - var2 / 20.0F, 0.5F, 1.0F);
   }

   private boolean I_method_4569b425(PlayerEntity var1) {
      String var2 = var1.getName().getString();

      for (Packets.Nested1_1da0dac9 var4 : Information.getVisiblePlayers()) {
         if (var4.gameInfo() != null && var2.equals(var4.gameInfo().nickname())) {
            return true;
         }
      }

      return false;
   }

   private IiiiiIII_Class121 I_method_f1d4e616(PlayerEntity var1) {
      if (var1 == I_field_3a9bda27.player) {
         return IiiiiIII_Class121.i_field_12aa4f81;
      } else {
         return RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var1.getName().getString())
            ? IiiiiIII_Class121.II_field_12aa4f81
            : IiiiiIII_Class121.I_field_12aa4f81;
      }
   }

   private Vec2f I_method_120057bd(Entity var1, float var2) {
      Vec3d var3 = iIiiiiIII_Class377.I_method_689b1a13(var1, var2).add(0.0, var1.getBoundingBox().getLengthY() + 0.65, 0.0);
      return iIiiiiIII_Class377.I_method_211fc242(var3);
   }

   private void i_method_23a3cac() {
      this.I_field_7865b31.clear();
      this.I_field_a567c40b.clear();
      this.i_field_a567c40b.clear();
      this.II_field_a567c40b.clear();
      this.Ii_field_a567c40b.clear();
      this.iI_field_a567c40b.clear();

      for (Entity var2 : I_field_3a9bda27.world.getEntities()) {
         if (this.I_method_bfc7acbe(var2)
            && (var2.getType() == EntityType.PLAYER || var2.getType() == EntityType.ITEM || var2 instanceof HostileEntity || var2 instanceof AnimalEntity)) {
            boolean var3 = false;

            for (Packets.Nested1_1da0dac9 var5 : Information.getVisiblePlayers()) {
               if (var5.gameInfo() != null && var5.gameInfo().nickname() != null && var5.gameInfo().nickname().equals(var2.getName().getString())) {
                  this.I_field_a567c40b.put(var2, var5);
                  var3 = true;
                  break;
               }
            }

            if (!var3) {
               this.I_field_7865b31.add(var2);
            }
         }
      }
   }

   private List<List<ItemEntity>> i_method_10d281b() {
      LinkedList var1 = new LinkedList();
      HashSet var2 = new HashSet();

      for (Entity var4 : this.I_field_7865b31) {
         if (var4 instanceof ItemEntity var5 && !var2.contains(var5)) {
            LinkedList var6 = new LinkedList();
            var6.add(var5);
            var2.add(var5);

            for (Entity var8 : this.I_field_7865b31) {
               if (var8 instanceof ItemEntity var9 && !var2.contains(var9) && var5.squaredDistanceTo(var9) < 1.0) {
                  var6.add(var9);
                  var2.add(var9);
               }
            }

            var1.add(var6);
         }
      }

      return var1;
   }

   private void I_method_74f10f31(iiIIIIiii_Class392 var1, iiIIIIiii_Class392 var2, MatrixStack var3, List<List<ItemEntity>> var4, float var5) {
      for (Entity var7 : this.I_field_7865b31) {
         if (var7.getType() == EntityType.PLAYER || var7 instanceof HostileEntity || var7 instanceof AnimalEntity) {
            Vec2f var8 = this.I_method_120057bd(var7, var5);
            if (var8 != null) {
               this.I_method_3daed84d(var1, var3, var7, var8);
            }
         }
      }

      for (List var11 : var4) {
         if (!var11.isEmpty()) {
            Vec2f var13 = this.I_method_120057bd((Entity)var11.getFirst(), var5);
            if (var13 != null && this.Ii_field_ba20ca4c.i_method_9b12da03()) {
               this.I_method_bb5453ea(var2, var3, var11, var13);
            }
         }
      }

      for (Entity var12 : this.I_field_7865b31) {
         if (var12.getType() == EntityType.ITEM) {
            Vec2f var14 = this.I_method_120057bd(var12, var5);
            if (var14 != null) {
               this.I_method_b4a75b00(var2, var3, (ItemEntity)var12, var14);
            }
         }
      }
   }

   private void I_method_c52a0c23(iiIIIIiii_Class392 var1, MatrixStack var2, List<List<ItemEntity>> var3, float var4) {
      for (Entity var6 : this.I_field_7865b31) {
         if (var6.getType() == EntityType.PLAYER || var6 instanceof HostileEntity || var6 instanceof AnimalEntity) {
            Vec2f var7 = this.I_method_120057bd(var6, var4);
            if (var7 != null) {
               this.i_method_73d4406d(var1, var2, var6, var7);
            }
         }
      }

      for (List var10 : var3) {
         if (!var10.isEmpty()) {
            Vec2f var12 = this.I_method_120057bd((Entity)var10.getFirst(), var4);
            if (var12 != null) {
               this.i_method_17e837ca(var1, var2, var10, var12);
            }
         }
      }

      for (Entity var11 : this.I_field_7865b31) {
         if (var11.getType() == EntityType.ITEM) {
            Vec2f var13 = this.I_method_120057bd(var11, var4);
            if (var13 != null) {
               this.i_method_b9bb320(var1, var2, (ItemEntity)var11, var13);
            }
         }
      }
   }

   private Text i_method_97a458d0(Entity var1) {
      return this.II_field_a567c40b
         .computeIfAbsent(
            var1,
            var1x -> {
               Text var2 = this.Ii_method_75fd2527(var1x);
               return (Text)(var1x instanceof PlayerEntity && this.i_method_23a3cb0()
                  ? var2
                  : iIIIIiIiI_Class267.I_method_29fdec38(var2, IIiIiI_Class11.i_field_857c0621));
            }
         );
   }

   private float i_method_7abf2cca(Entity var1) {
      return this.Ii_field_a567c40b.computeIfAbsent(var1, this::II_method_84494e01);
   }

   private float II_method_84494e01(Entity var1) {
      Text var2 = this.i_method_97a458d0(var1);
      if (var1 instanceof PlayerEntity && this.i_method_23a3cb0()) {
         float var4 = iiIIIIIII_Class385.I_method_44b27a85(IIiIiI_Class11.i_field_857c0621, IIiIiI_Class11.III_field_857c0621, var2.getString(), 11.0F);
         return 22.0F + var4 + 4.0F;
      } else {
         float var3 = iiIIIIiii_Class392.I_method_e4abc32a(IIiIiI_Class11.i_field_857c0621, var2, 11.0F);
         return var1 instanceof PlayerEntity ? 22.0F + var3 + 4.0F : var3 + 8.0F;
      }
   }

   private boolean i_method_7abf2cde(Entity var1) {
      if (!IIIiIiIi_Class22.II_method_40fdec79()) {
         return false;
      } else {
         String var2 = this.i_method_97a458d0(var1).getString();
         return IIIiIiIi_Class22.I_method_7f49082a(var2) != var2;
      }
   }

   private float Ii_method_3f40ce21(Entity var1) {
      return !IIIiIiIi_Class22.II_method_40fdec79() ? this.i_method_7abf2cca(var1) : this.iI_field_a567c40b.computeIfAbsent(var1, var1x -> {
         float[] var2 = new float[1];
         IIIiIiIi_Class22.I_method_4d8e94ea(() -> var2[0] = this.II_method_84494e01(var1x));
         return var2[0];
      });
   }

   private void I_method_a81be2f4(iiIIIIiii_Class392 var1, MatrixStack var2, float var3) {
      for (Entity var5 : this.I_field_7865b31) {
         if (var5.getType() == EntityType.PLAYER && var5 instanceof AbstractClientPlayerEntity var6) {
            Vec2f var7 = this.I_method_120057bd(var5, var3);
            if (var7 != null) {
               int var8 = this.I_field_e76524c.I_method_b81c3233(var6.getSkinTextures().texture());
               if (var8 >= 0) {
                  float var9 = this.I_method_bfc7acaa(var5);
                  float var10 = this.i_method_7abf2cca(var5);
                  var2.push();
                  var2.translate(var7.x, var7.y, 0.0F);
                  var2.scale(var9, var9, 1.0F);
                  float var11 = -var10 / 2.0F + 4.0F;
                  float var12 = 7.0F;
                  var1.I_method_c963086f(
                     var2.peek().getPositionMatrix(),
                     var11,
                     var12,
                     this.I_field_e76524c.I_method_79f340d4(var8),
                     this.I_field_e76524c.i_method_7bb630f4(var8),
                     this.I_field_e76524c.I_method_357b71ef(),
                     -this.Ii_method_3f40ce21(var5) / 2.0F + 4.0F
                  );
                  var2.pop();
               }
            }
         }
      }
   }

   private void I_method_d92e775f(PreHudRenderEvent var1, MatrixStack var2, float var3) {
      for (Entity var5 : this.I_field_7865b31) {
         if (var5.getType() == EntityType.PLAYER) {
            PlayerEntity var6 = (PlayerEntity)var5;
            BooleanSetting var7 = this.I_method_62f3944d("esp.nametags.show_armor", this.I_method_f1d4e616(var6));
            if (var7 != null && var7.i_method_9b12da03()) {
               Vec2f var8 = this.I_method_120057bd(var5, var3);
               if (var8 != null) {
                  this.I_method_10cefa71(var1, var2, var6, var8);
               }
            }
         }
      }
   }

   private void i_method_fa27177f(PreHudRenderEvent var1, MatrixStack var2, float var3) {
      for (Entity var5 : this.I_field_7865b31) {
         if (var5.getType() == EntityType.ITEM) {
            Vec2f var6 = this.I_method_120057bd(var5, var3);
            if (var6 != null) {
               this.I_method_921ee535(var1, var2, (ItemEntity)var5, var6);
            }
         }
      }
   }

   private Text II_method_c37c0507(Entity var1) {
      NameProtectModule var2 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
      IiIIiiII_Class77 var3 = RockstarClient.getInstance().I_method_7a5acaeb();
      boolean var4 = var2.I_method_7e8002b5().i_method_9b12da03();
      String var5 = var2.i_method_4d0caf15().II_method_da016c1e();
      boolean var6 = var4 && var3.I_method_19c9437a(var1.getName().getString()) && var2.isEnabled();
      boolean var7 = var1 == I_field_3a9bda27.player && var2.isEnabled();
      boolean var8 = IIIiIiIi_Class22.I_method_f1941870();
      if (var8 && (var6 || var7)) {
         var2.II_method_6ed9f394(var1.getName().getString());
         var6 = false;
         var7 = false;
      }

      MutableText var9 = Text.empty();
      if (var1 instanceof PlayerEntity var10) {
         if (!this.hpModeNone.isSelected()) {
            float hp = IiiiiiiII_Class253.I_method_6c00a1c4(var10);
            if (this.hpModePercent.isSelected()) {
               int pct = (int)((hp / 20.0F) * 100.0F);
               var9 = Text.of(" [" + pct + "%]").copy().withColor(-2142128);
            } else {
               int var11 = (int)hp;
               var9 = Text.of(" [" + (var11 == 1000 ? "?" : var11) + "]").copy().withColor(-2142128);
            }
         }
         if (this.showDistance.i_method_9b12da03() && I_field_3a9bda27.player != null) {
            int dist = (int)I_field_3a9bda27.player.distanceTo(var10);
            var9.append(Text.of(" " + dist + "m").copy().withColor(-4342339));
         }
      }

      Text baseName;
      if (var6) {
         baseName = Text.of(var5);
      } else if (var7) {
         baseName = Text.of(var2.I_method_37773b35().II_method_da016c1e());
      } else if (var2.isEnabled() && var2.i_method_94157695().i_method_9b12da03()) {
         baseName = Text.of(var2.II_method_6ed9f394(var1.getName().getString()));
      } else {
         baseName = var1.getDisplayName();
      }
      boolean isFriend = var3 != null && var3.I_method_19c9437a(var1.getName().getString());
      if (isFriend && this.showFriendsGreen.i_method_9b12da03()) {
         return Text.of("§a" + baseName.getString()).copy().append(var9);
      }
      return baseName.copy().append(var9);
   }

   private Text Ii_method_75fd2527(Entity var1) {
      if (var1 instanceof PlayerEntity) {
         return this.II_method_c37c0507(var1);
      } else if (var1 instanceof LivingEntity var2) {
         int var3 = (int)var2.getHealth();
         MutableText var4 = Text.of(" [" + var3 + "]").copy().withColor(-2142128);
         return var1.getDisplayName().copy().append(var4);
      } else {
         return var1.getDisplayName().copy();
      }
   }

   private void I_method_3daed84d(iiIIIIiii_Class392 var1, MatrixStack var2, Entity var3, Vec2f var4) {
      if (var3 instanceof LivingEntity) {
         float var5 = this.I_method_bfc7acaa(var3);
         float var6 = this.i_method_7abf2cca(var3);
         var2.push();
         var2.translate(var4.x, var4.y, 0.0F);
         var2.scale(var5, var5, 1.0F);
         ColorRGBA var7;
         if (var3 instanceof PlayerEntity var8 && RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var8.getName().getString())) {
            var7 = new ColorRGBA(14.0F, 32.0F, 16.0F, 235.0F);
         } else {
            var7 = new ColorRGBA(12.0F, 12.0F, 12.0F, 235.0F);
         }

         float var10 = this.Ii_method_3f40ce21(var3);
         var1.I_method_662ac30(var2.peek().getPositionMatrix(), -var6 / 2.0F, 3.0F, var6, 22.0F, var7, -var10 / 2.0F, var10);
         if (this.i_method_7abf2cde(var3)) {
            float var9 = Math.max(var6, var10);
            var1.I_method_df2d602f(var2.peek().getPositionMatrix(), -var9 / 2.0F, 3.0F, var9, 22.0F);
         }

         var2.pop();
      }
   }

   private void i_method_73d4406d(iiIIIIiii_Class392 var1, MatrixStack var2, Entity var3, Vec2f var4) {
      if (var3 instanceof LivingEntity) {
         float var5 = this.I_method_bfc7acaa(var3);
         float var6 = this.i_method_7abf2cca(var3);
         var2.push();
         var2.translate(var4.x, var4.y, 0.0F);
         var2.scale(var5, var5, 1.0F);
         Matrix4f var7 = var2.peek().getPositionMatrix();
         Text var8 = this.i_method_97a458d0(var3);
         float var9 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F).I_method_a649725c();
         float var10 = 3.0F + (22.0F - var9) / 2.0F;
         float var11 = this.Ii_method_3f40ce21(var3);
         float var12;
         float var13;
         if (var3 instanceof PlayerEntity) {
            var12 = -var6 / 2.0F + 4.0F + 14.0F + 4.0F;
            var13 = -var11 / 2.0F + 4.0F + 14.0F + 4.0F;
         } else {
            var12 = -var1.I_method_4f299e89(var8, 11.0F) / 2.0F;
            var13 = var12;
         }

         if (!(var3 instanceof PlayerEntity) || !this.i_method_23a3cb0()) {
            var1.I_method_51dd97a9(var7, var8, 11.0F, var12, var10, 0.0F, var13);
         }

         if (var3 instanceof PlayerEntity var14 && !this.i_method_23a3cb0()) {
            ItemStack var15 = var14.getOffHandStack();
            IiiiiIiii_Class248.Nested1_95187080 var16 = IiiiiIiii_Class248.i_method_fde1be52(var15);
            if (var16 != null
               && (
                  var16.Ii_method_e2d6074b() || var16.iI_method_e48a6b8b() && var16.I_method_f2690c42() != IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6
               )) {
               Text var17 = this.I_method_f0838649(var15, var16);
               float var18 = var1.I_method_4f299e89(var17, 9.0F);
               var1.I_method_5538aef7(var7, var17, 9.0F, -var18 / 2.0F, 27.0F, 0.0F);
            }
         }

         var2.pop();
      }
   }

   private boolean i_method_23a3cb0() {
      return iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.II_field_ac164e6c)
         || iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.iiI_field_ac164e6c);
   }

   private void II_method_5a827b6(PreHudRenderEvent var1, MatrixStack var2, float var3) {
      if (this.i_method_23a3cb0()) {
         iiIIIIIII_Class385 var4 = new iiIIIIIII_Class385(IIiIiI_Class11.i_field_857c0621, IIiIiI_Class11.III_field_857c0621);
         var4.I_method_3a5ea7a7(var1.getContext());

         for (Entity var6 : this.I_field_7865b31) {
            if (var6.getType() == EntityType.PLAYER) {
               Vec2f var7 = this.I_method_120057bd(var6, var3);
               if (var7 != null) {
                  float var8 = this.I_method_bfc7acaa(var6);
                  float var9 = this.i_method_7abf2cca(var6);
                  Text var10 = this.i_method_97a458d0(var6);
                  float var11 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F).I_method_a649725c();
                  float var12 = 3.0F + (22.0F - var11) / 2.0F;
                  float var13 = -var9 / 2.0F + 4.0F + 14.0F + 4.0F;
                  var2.push();
                  var2.translate(var7.x, var7.y, 0.0F);
                  var2.scale(var8, var8, 1.0F);
                  var4.I_method_c073d717(var2.peek().getPositionMatrix(), var10, 11.0F, var13, var12, 0.0F);
                  var2.pop();
               }
            }
         }

         var4.I_method_b7c2ae3f();
      }
   }

   private void I_method_10cefa71(PreHudRenderEvent var1, MatrixStack var2, PlayerEntity var3, Vec2f var4) {
      float var5 = this.I_method_bfc7acaa(var3);
      var2.push();
      var2.translate(var4.x, var4.y, 0.0F);
      var2.scale(var5, var5, 1.0F);
      LinkedList var6 = new LinkedList();
      var6.add((ItemStack)var3.getInventory().armor.get(3));
      var6.add((ItemStack)var3.getInventory().armor.get(2));
      var6.add((ItemStack)var3.getInventory().armor.get(1));
      var6.add((ItemStack)var3.getInventory().armor.get(0));
      var6.add(var3.getMainHandStack());
      var6.add(var3.getOffHandStack());
      var6.removeIf(value -> ((ItemStack)value).isEmpty());
      if (!var6.isEmpty()) {
         float var7 = (var6.size() - 1) * 18.0F + 16.0F;
         float var8 = -var7 / 2.0F;

         try (CustomDrawContext.Nested1_f061f568 var9 = var1.getContext().beginItemBatch()) {
            for (int var10 = 0; var10 < var6.size(); var10++) {
               var1.getContext().drawBatchItem((ItemStack)var6.get(var10), var8 + var10 * 18.0F, -15.0F);
            }
         }
      }

      var2.pop();
   }

   private void i_method_4ba47a91(PreHudRenderEvent var1, MatrixStack var2, PlayerEntity var3, Vec2f var4) {
      if (var3.isUsingItem()) {
         ItemStack var5 = var3.getActiveItem();
         if (!var5.isEmpty()) {
            UseAction var6 = var5.getUseAction();
            if (var6 == UseAction.EAT || var6 == UseAction.DRINK) {
               int var7 = var5.getMaxUseTime(var3);
               int var8 = var3.getItemUseTimeLeft();
               if (var7 > 0) {
                  float var9 = 1.0F - (float)var8 / var7;
                  float var10 = var3.distanceTo(I_field_3a9bda27.player);
                  float var11 = MathHelper.clamp(1.0F - var10 / 20.0F, 0.5F, 1.0F) * 0.4F;
                  float var12 = 80.0F;
                  float var13 = 80.0F;
                  var2.push();
                  var2.translate(var4.x - var12 / 2.0F, var4.y - var13 / 2.0F, 0.0F);
                  iIiiiIIiI_Class371.II_method_e18635ac(var2, var12 / 2.0F, var13 / 2.0F, var11);
                  var1.getContext()
                     .drawBlurredRect(0.0F, 0.0F, var12, var13, 25.0F, 3.0F, IIiii_Class8.I_method_893b2757(14.0F), IiiiiIIIi_Class242.Ii_field_d0c8ec5);
                  var1.getContext()
                     .drawSquircle(0.0F, 0.0F, var12, var13, 3.0F, IIiii_Class8.I_method_893b2757(14.0F), new ColorRGBA(9.0F, 9.0F, 11.0F).mulAlpha(0.5F));
                  var1.getContext().drawCircleProgress(var12 / 2.0F, var13 / 2.0F, 28.0F, 4.0F, var9, IiiiiIIIi_Class242.i_method_5dfec6e());
                  var1.getContext().drawItem(var5, 24.0F, 24.0F, 2.0F);
                  iIiiiIIiI_Class371.I_method_10503b11(var2);
                  var2.pop();
               }
            }
         }
      }
   }

   private void I_method_bb5453ea(iiIIIIiii_Class392 var1, MatrixStack var2, List<ItemEntity> var3, Vec2f var4) {
      if (!var3.isEmpty()) {
         float var5 = this.I_method_bfc7acaa((Entity)var3.getFirst());
         List var6 = this.I_method_e650daea(var3);
         if (!var6.isEmpty()) {
            int var7 = (int)IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F).I_method_a649725c();
            int var8 = 0;

            for (iIIIIiII_Class133.Nested1_7169c0d3 var10 : (Iterable<iIIIIiII_Class133.Nested1_7169c0d3>)(Iterable<?>)var6) {
               var8 = Math.max(var8, (int)this.I_method_c38bc346(var1, var10));
            }

            var2.push();
            var2.translate(var4.x, var4.y, 0.0F);
            var2.scale(var5, var5, 1.0F);
            int var11 = var7 * var6.size() + 3 * (var6.size() - 1);
            var1.I_method_97950030(var2.peek().getPositionMatrix(), -var8 / 2.0F - 3.0F, 2.0F, var8 + 6, var11 + 6, new ColorRGBA(0.0F, 0.0F, 0.0F, 150.0F));
            var2.pop();
         }
      }
   }

   private void i_method_17e837ca(iiIIIIiii_Class392 var1, MatrixStack var2, List<ItemEntity> var3, Vec2f var4) {
      if (!var3.isEmpty()) {
         float var5 = this.I_method_bfc7acaa((Entity)var3.getFirst());
         List var6 = this.I_method_e650daea(var3);
         if (!var6.isEmpty()) {
            int var7 = (int)IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F).I_method_a649725c();
            var2.push();
            var2.translate(var4.x, var4.y, 0.0F);
            var2.scale(var5, var5, 1.0F);
            Matrix4f var8 = var2.peek().getPositionMatrix();

            for (int var9 = 0; var9 < var6.size(); var9++) {
               iIIIIiII_Class133.Nested1_7169c0d3 var10 = (iIIIIiII_Class133.Nested1_7169c0d3)var6.get(var9);
               float var11 = var1.I_method_4f299e89(var10.I_method_2e7043bd(), 11.0F);
               float var12 = -this.I_method_c38bc346(var1, var10) / 2.0F;
               float var13 = 5 + var9 * (var7 + 3);
               var1.I_method_5538aef7(var8, var10.I_method_2e7043bd(), 11.0F, var12, var13, 0.0F);
               var1.I_method_2cf0d2ea(var8, this.I_method_27cee658(var10), 11.0F, var12 + var11, var13, 0.0F, ColorRGBA.WHITE.getRGB());
            }

            var2.pop();
         }
      }
   }

   private void I_method_b4a75b00(iiIIIIiii_Class392 var1, MatrixStack var2, ItemEntity var3, Vec2f var4) {
      List var5 = Iiiiiiiii_Class256.I_method_27e808c6(var3.getStack());
      if (!var5.isEmpty()) {
         float var6 = this.I_method_bfc7acaa(var3);
         int var7 = Math.min(var5.size(), 9);
         int var8 = (int)Math.ceil(var5.size() / 9.0F);
         int var9 = var7 * 18 + 4;
         int var10 = var8 * 18 + 4;
         var2.push();
         var2.translate(var4.x, var4.y, 0.0F);
         var2.scale(var6, var6, 1.0F);
         var1.I_method_97950030(var2.peek().getPositionMatrix(), -var9 / 2.0F, -var10 / 2.0F, var9, var10, new ColorRGBA(0.0F, 0.0F, 0.0F, 180.0F));
         var2.pop();
      }
   }

   private void I_method_921ee535(PreHudRenderEvent var1, MatrixStack var2, ItemEntity var3, Vec2f var4) {
      List var5 = Iiiiiiiii_Class256.I_method_27e808c6(var3.getStack());
      if (!var5.isEmpty()) {
         float var6 = this.I_method_bfc7acaa(var3);
         int var7 = Math.min(var5.size(), 9);
         int var8 = (int)Math.ceil(var5.size() / 9.0F);
         int var9 = var7 * 18 + 4;
         int var10 = var8 * 18 + 4;
         var2.push();
         var2.translate(var4.x, var4.y, 0.0F);
         var2.scale(var6, var6, 1.0F);

         try (CustomDrawContext.Nested1_f061f568 var11 = var1.getContext().beginItemBatch()) {
            for (int var12 = 0; var12 < var5.size(); var12++) {
               int var13 = var12 % 9 * 18 - var9 / 2 + 3;
               int var14 = var12 / 9 * 18 - var10 / 2 + 3;
               var1.getContext().drawBatchItem((ItemStack)var5.get(var12), var13, var14);
            }
         }

         var2.pop();
      }
   }

   private void i_method_b9bb320(iiIIIIiii_Class392 var1, MatrixStack var2, ItemEntity var3, Vec2f var4) {
      List var5 = Iiiiiiiii_Class256.I_method_27e808c6(var3.getStack());
      if (!var5.isEmpty()) {
         float var6 = this.I_method_bfc7acaa(var3);
         int var7 = Math.min(var5.size(), 9);
         int var8 = (int)Math.ceil(var5.size() / 9.0F);
         int var9 = var7 * 18 + 4;
         int var10 = var8 * 18 + 4;
         var2.push();
         var2.translate(var4.x, var4.y, 0.0F);
         var2.scale(var6, var6, 1.0F);
         Matrix4f var11 = var2.peek().getPositionMatrix();
         var1.I_method_2cf0d2ea(var11, var3.getDisplayName().getString(), 11.0F, -var9 / 2.0F + 0.5F, -var10 / 2.0F - 11.0F, 0.0F, ColorRGBA.WHITE.getRGB());

         for (int var12 = 0; var12 < var5.size(); var12++) {
            ItemStack var13 = (ItemStack)var5.get(var12);
            if (var13.getCount() > 1) {
               float var14 = var12 % 9 * 18 - var9 / 2.0F + 3.0F;
               float var15 = var12 / 9 * 18 - var10 / 2.0F + 3.0F;
               String var16 = String.valueOf(var13.getCount());
               var1.I_method_2cf0d2ea(
                  var11,
                  var16,
                  11.0F,
                  var14 + 16.0F - IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F).I_method_2c375926(var16),
                  var15 + 9.0F,
                  0.0F,
                  ColorRGBA.WHITE.getRGB()
               );
            }
         }

         var2.pop();
      }
   }

   private void Ii_method_26a0c7d6(PreHudRenderEvent var1, MatrixStack var2, float var3) {
      for (Entity var5 : this.I_field_a567c40b.keySet()) {
         Vec2f var6 = this.I_method_120057bd(var5, var3);
         if (var6 != null) {
            Packets.Nested1_1da0dac9 var7 = this.I_field_a567c40b.get(var5);
            NameProtectModule var8 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
            IiIIiiII_Class77 var9 = RockstarClient.getInstance().I_method_7a5acaeb();
            boolean var10 = var8.I_method_7e8002b5().i_method_9b12da03();
            String var11 = var8.i_method_4d0caf15().II_method_da016c1e();
            boolean var12 = var10 && var9.I_method_19c9437a(var5.getName().getString()) && var8.isEnabled();
            if (var12 && IIIiIiIi_Class22.I_method_f1941870()) {
               var8.II_method_6ed9f394(var5.getName().getString());
               var12 = false;
            }

            MutableText var13;
            if (var12) {
               var13 = Text.of(var11).copy();
            } else if (var8.isEnabled() && var8.i_method_94157695().i_method_9b12da03()) {
               var13 = Text.of(var8.II_method_6ed9f394(var5.getName().getString())).copy();
            } else {
               var13 = var5.getDisplayName().copy();
            }

            float var14 = var5.distanceTo(I_field_3a9bda27.player);
            float var15 = MathHelper.clamp((1.0F - var14 / 20.0F) * 1.5F, 0.5F, 0.7F);
            boolean var16 = "none".equals(var7.visibility()) || "hidden".equals(var7.visibility());
            int var17 = var16 ? 80 : 255;
            String var18 = I_method_fa889be6(var13);
            String var19 = IIIiIiIi_Class22.I_method_7f49082a(var18);
            if (var19 != var18) {
               float[] var20 = new float[1];
               IIIiIiIi_Class22.I_method_4d8e94ea(() -> var20[0] = this.I_method_ef8ebdf2(var18, var7));
               float var21 = Math.max(var20[0], this.I_method_ef8ebdf2(var19, var7));
               IIIiIiIi_Class22.I_method_3ee425f8(
                  this.I_method_77245f7b(var2, var6, var15, var21),
                  () -> IIIiIiIi_Class22.I_method_4d8e94ea(() -> this.I_method_53283269(var1, var2, var7, var18, var6, var15, var17))
               );
            }

            IIIiIiIi_Class22.I_method_4d8e94ea(() -> this.I_method_53283269(var1, var2, var7, var19, var6, var15, var17));
            if (var5 instanceof PlayerEntity var22) {
               BooleanSetting var23 = this.I_method_62f3944d("esp.nametags.show_armor", IiiiiIII_Class121.Ii_field_12aa4f81);
               if (var23 != null && var23.i_method_9b12da03()) {
                  this.I_method_910bb6f(var1, var2, var22, var6, var15);
               }
            }
         }
      }
   }

   private void I_method_53283269(PreHudRenderEvent var1, MatrixStack var2, Packets.Nested1_1da0dac9 var3, String var4, Vec2f var5, float var6, int var7) {
      float var8 = this.I_method_ef8ebdf2(var4, var3);
      float var9 = 26.0F;
      var2.push();
      var2.translate(var5.x, var5.y, 0.0F);
      var2.scale(var6, var6, 1.0F);
      var2.translate(-var8 / 2.0F, -var9 / 2.0F, 0.0F);
      var1.getContext().drawRoundedRect(0.0F, 0.0F, var8, var9, IIiii_Class8.I_method_893b2757(7.0F), new ColorRGBA(12.0F, 12.0F, 12.0F, var7));
      var1.getContext().drawRoundedTexture(Information.getAvatar(var3.username()), 5.0F, 5.0F, 16.0F, 16.0F, IIiii_Class8.I_method_893b2757(7.0F));
      CosmeticRender.draw(
         var1.getContext(),
         IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(11.0F),
         var4,
         25.0F,
         9.0F,
         var3.nickStyle(),
         var3.badge(),
         ColorRGBA.WHITE.withAlpha(var7),
         9.0F
      );
      var2.pop();
   }

   private int[] I_method_77245f7b(MatrixStack var1, Vec2f var2, float var3, float var4) {
      var1.push();
      var1.translate(var2.x, var2.y, 0.0F);
      var1.scale(var3, var3, 1.0F);
      var1.translate(-var4 / 2.0F, -13.0F, 0.0F);
      int[] var5 = IIIiIiIi_Class22.I_method_a0f921e2(var1.peek().getPositionMatrix(), -2.0F, -2.0F, var4 + 2.0F, 28.0F);
      var1.pop();
      return var5;
   }

   private void I_method_910bb6f(PreHudRenderEvent var1, MatrixStack var2, PlayerEntity var3, Vec2f var4, float var5) {
      var2.push();
      var2.translate(var4.x, var4.y, 0.0F);
      var2.scale(var5, var5, 1.0F);
      LinkedList var6 = new LinkedList();
      var6.add((ItemStack)var3.getInventory().armor.get(3));
      var6.add((ItemStack)var3.getInventory().armor.get(2));
      var6.add((ItemStack)var3.getInventory().armor.get(1));
      var6.add((ItemStack)var3.getInventory().armor.get(0));
      var6.add(var3.getMainHandStack());
      var6.add(var3.getOffHandStack());
      var6.removeIf(value -> ((ItemStack)value).isEmpty());
      if (!var6.isEmpty()) {
         float var7 = (var6.size() - 1) * 18.0F + 16.0F;
         float var8 = -var7 / 2.0F;

         try (CustomDrawContext.Nested1_f061f568 var9 = var1.getContext().beginItemBatch()) {
            for (int var10 = 0; var10 < var6.size(); var10++) {
               var1.getContext().drawBatchItem((ItemStack)var6.get(var10), (int)(var8 + var10 * 18), -30.0F);
            }
         }
      }

      var2.pop();
   }

   public boolean I_method_260eb590(double var1, double var3) {
      if (!this.I_method_ea8b70b0()) {
         return false;
      } else {
         for (Entity var6 : this.I_field_7865b31) {
            if (var6.getType() == EntityType.PLAYER) {
               Vec2f var7 = this.I_method_120057bd(var6, 1.0F);
               if (var7 != null && this.I_method_cd860351(var6, var7, var1, var3)) {
                  return true;
               }
            }
         }

         for (Entity var9 : this.I_field_a567c40b.keySet()) {
            Vec2f var10 = this.I_method_120057bd(var9, 1.0F);
            if (var10 != null && this.i_method_13770731(var9, var10, var1, var3)) {
               return true;
            }
         }

         return false;
      }
   }

   private boolean I_method_cd860351(Entity var1, Vec2f var2, double var3, double var5) {
      float var7 = this.I_method_bfc7acaa(var1);
      float var8 = this.i_method_7abf2cca(var1);
      float var9 = var8 * var7;
      float var10 = 22.0F * var7;
      float var11 = var2.x - var9 / 2.0F;
      float var12 = var2.y + 3.0F * var7;
      return iIIiIIIiI_Class291.I_method_c3f86263(var11, var12, var9, var10, var3, var5);
   }

   private boolean i_method_13770731(Entity var1, Vec2f var2, double var3, double var5) {
      float var7 = this.I_method_430ff74e(var1, this.I_field_a567c40b.get(var1));
      float var8 = 26.0F;
      float var9 = var1.distanceTo(I_field_3a9bda27.player);
      float var10 = MathHelper.clamp((1.0F - var9 / 20.0F) * 1.5F, 0.5F, 0.7F);
      float var11 = var7 * var10;
      float var12 = var8 * var10;
      float var13 = var2.x - var11 / 2.0F;
      float var14 = var2.y - var12 / 2.0F;
      return iIIiIIIiI_Class291.I_method_c3f86263(var13, var14, var11, var12, var3, var5);
   }

   private float I_method_430ff74e(Entity var1, Packets.Nested1_1da0dac9 var2) {
      return this.I_method_ef8ebdf2(I_method_fa889be6(this.iI_method_611ee8e7(var1)), var2);
   }

   private float I_method_ef8ebdf2(String var1, Packets.Nested1_1da0dac9 var2) {
      String var3 = var2 == null ? null : var2.badge();
      return CosmeticRender.width(IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(11.0F), var1, var3, 9.0F) + 31.0F;
   }

   private static String I_method_fa889be6(Text var0) {
      return iIIIIiIiI_Class267.I_method_29fdec38(var0, IIiIiI_Class11.II_field_857c0621).getString();
   }

   private Text iI_method_611ee8e7(Entity var1) {
      NameProtectModule var2 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
      IiIIiiII_Class77 var3 = RockstarClient.getInstance().I_method_7a5acaeb();
      boolean var4 = var2.I_method_7e8002b5().i_method_9b12da03() && var3.I_method_19c9437a(var1.getName().getString()) && var2.isEnabled();
      if (var4 && IIIiIiIi_Class22.I_method_f1941870()) {
         var2.II_method_6ed9f394(var1.getName().getString());
         var4 = false;
      }

      if (var4) {
         return Text.of(var2.i_method_4d0caf15().II_method_da016c1e()).copy();
      } else {
         return var2.isEnabled() && var2.i_method_94157695().i_method_9b12da03()
            ? Text.of(var2.II_method_6ed9f394(var1.getName().getString())).copy()
            : var1.getDisplayName().copy();
      }
   }

   private void I_method_eb03d7ba(float var1, float var2, Entity var3) {
      IiIIiiII_Class77 var4 = RockstarClient.getInstance().I_method_7a5acaeb();
      IiIIIiIIi_Class138 var5 = RockstarClient.getInstance().I_method_9a638462();
      String var6 = var3.getName().getString();
      NameProtectModule var7 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
      String var8 = var7.isEnabled() ? var7.II_method_6ed9f394(var6) : var6;
      this.I_field_ab760aac = new IiIIiiIii_Class156(var1, var2, 100.0F, 6.0F)
         .i_method_a1faeedf(var8)
         .I_method_88131b75()
         .I_method_a9dcf031(IiIiIIII_Class81.I_method_f25a980a("friend"), var4.I_method_19c9437a(var6), var2x -> {
            if (var2x) {
               var4.I_method_19c94376(var6);
            } else {
               var4.i_method_ea809756(var6);
            }
         })
         .I_method_a9dcf031(IiIiIIII_Class81.I_method_f25a980a("enemy"), var5.I_method_9db25e6d(var6), var2x -> {
            if (var2x) {
               var5.I_method_9db25e69(var6);
            } else {
               var5.i_method_6e69b249(var6);
            }
         })
         .I_method_78c7e89(IiIiIIII_Class81.I_method_f25a980a("invsee"), "invsee", var2x -> {
            this.I_method_772abf96(var6);
            var2x.I_method_c3d80455(false);
         })
         .I_method_78c7e89(IiIiIIII_Class81.I_method_f25a980a("copy"), "copy", var1x -> {
            iIIIIiIiI_Class267.I_method_c791669(var6);
            var1x.I_method_c3d80455(false);
         });
   }

   private void I_method_772abf96(String var1) {
      if (I_field_3a9bda27.player != null) {
         this.I_field_523beb0a = var1;
         this.I_field_4a = System.currentTimeMillis() + 1500L;

         try {
            I_field_3a9bda27.player.networkHandler.sendChatCommand("invsee " + var1);
         } catch (RuntimeException var3) {
            this.I_field_4a = 0L;
         }
      }
   }

   private void II_method_43596015() {
      if (this.I_field_523beb0a != null) {
         if (I_field_3a9bda27.currentScreen instanceof HandledScreen) {
            this.I_field_523beb0a = null;
            this.I_field_4a = 0L;
         } else if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
            if (System.currentTimeMillis() >= this.I_field_4a) {
               String var1 = this.I_field_523beb0a;
               this.I_field_523beb0a = null;
               this.I_field_4a = 0L;
               RockstarClient.getInstance()
                  .I_method_b4d046cb()
                  .I_method_9e86975a(RockstarClient.getInstance().I_method_b4d046cb().I_method_80ea594() + "invsee " + var1);
            }
         } else {
            this.I_field_523beb0a = null;
            this.I_field_4a = 0L;
         }
      }
   }

   private Text I_method_f0838649(ItemStack var1, IiiiiIiii_Class248.Nested1_95187080 var2) {
      if (var2 == null || var1.contains(DataComponentTypes.CUSTOM_NAME)) {
         MutableText var3 = iIIIIiIiI_Class267.I_method_29fdec38(var1.getName(), IIiIiI_Class11.i_field_857c0621);
         if (!var3.getString().isBlank()) {
            return var3;
         }
      }

      ColorRGBA var5 = var2 != null ? var2.I_method_40d7118b(var1) : null;
      String var4 = var2 != null ? var2.I_method_2310f504(var1) : var1.getItem().getName().getString();
      return Text.literal(iIIIIiIiI_Class267.i_method_e7444577(var4)).withColor((var5 != null ? var5 : ColorRGBA.WHITE).getRGB() & 16777215);
   }

   private List<iIIIIiII_Class133.Nested1_7169c0d3> I_method_e650daea(List<ItemEntity> var1) {
      return this.i_field_a567c40b.computeIfAbsent((ItemEntity)var1.getFirst(), var2 -> {
         LinkedHashMap var3 = new LinkedHashMap();

         for (ItemEntity var5 : var1) {
            ItemStack var6 = var5.getStack();
            Text var7 = this.I_method_f0838649(var6, IiiiiIiii_Class248.I_method_7613ca72(var6));
            iIIIIiII_Class133.Nested1_7169c0d3 var8 = (iIIIIiII_Class133.Nested1_7169c0d3)var3.get(var7.getString());
            int var9 = (var8 == null ? 0 : var8.I_method_1566ceba()) + var6.getCount();
            var3.put(var7.getString(), new iIIIIiII_Class133.Nested1_7169c0d3(var7, var9));
         }

         return new ArrayList<>(var3.values());
      });
   }

   private float I_method_c38bc346(iiIIIIiii_Class392 var1, iIIIIiII_Class133.Nested1_7169c0d3 var2) {
      return var1.I_method_4f299e89(var2.I_method_2e7043bd(), 11.0F)
         + IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(11.0F).I_method_2c375926(this.I_method_27cee658(var2));
   }

   private String I_method_27cee658(iIIIIiII_Class133.Nested1_7169c0d3 var1) {
      return " " + var1.I_method_1566ceba() + "x";
   }

   public static Text I_method_e52338b0(Entity var0) {
      if (var0.getDisplayName() == null) {
         return Text.empty();
      } else {
         NameProtectModule var1 = RockstarClient.getInstance().getModuleManager().getModule(NameProtectModule.class);
         String var2 = var1.isEnabled() ? var1.II_method_6ed9f394(var0.getName().getString()) : var0.getDisplayName().getString();
         MutableText var3 = Text.of(var2).copy();
         if (var0 instanceof LivingEntity var4) {
            int var5 = var0 instanceof PlayerEntity var6 ? (int)IiiiiiiII_Class253.I_method_6c00a1c4(var6) : (int)var4.getHealth();
            if (!var3.getString().endsWith(" ")) {
               var3.append(" ");
            }

            return var3.append(Text.of("[" + (var5 == 1000 ? "?" : var5) + "]").copy().withColor(-2142128));
         } else {
            return var3;
         }
      }
   }

   @Generated
   public List<Entity> I_method_4bc0effb() {
      return this.I_field_7865b31;
   }

   @Generated
   public Map<Entity, Packets.Nested1_1da0dac9> iII_method_acd4ab01() {
      return this.I_field_a567c40b;
   }

   @Generated
   public Map<ItemEntity, List<iIIIIiII_Class133.Nested1_7169c0d3>> iIi_method_3f10eee1() {
      return this.i_field_a567c40b;
   }

   @Generated
   public Map<Entity, Text> iiI_method_6220e321() {
      return this.II_field_a567c40b;
   }

   @Generated
   public Map<Entity, Float> iii_method_f45d2701() {
      return this.Ii_field_a567c40b;
   }

   @Generated
   public Map<Entity, Float> IIII_method_1ef9dc6a() {
      return this.iI_field_a567c40b;
   }

   @Generated
   public BooleanSetting I_method_336e3342() {
      return this.I_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting i_method_4903a722() {
      return this.i_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting II_method_e8ece94b() {
      return this.II_field_ba20ca4c;
   }

   @Generated
   public BooleanSetting Ii_method_fe825d2b() {
      return this.Ii_field_ba20ca4c;
   }

   @Generated
   public iIiiIiiIi_Class366 I_method_87c3bb42() {
      return this.I_field_e76524c;
   }

   @Generated
   public IiIIiiIii_Class156 I_method_24c373a2() {
      return this.I_field_ab760aac;
   }

   @Generated
   public String i_method_5432574() {
      return this.I_field_523beb0a;
   }

   @Generated
   public long I_method_22bb0c0() {
      return this.I_field_4a;
   }

   @Generated
   public IiIIIiII_Class69<PreHudRenderEvent> I_method_b51a0f8b() {
      return this.I_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<ChatRenderEvent> i_method_df169fab() {
      return this.i_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<ChatClickEvent> II_method_4757f462() {
      return this.II_field_3d936f41;
   }

   @Generated
   public IiIIIiII_Class69<ReceivePacketEvent> Ii_method_71548482() {
      return this.Ii_field_3d936f41;
   }

   static final class Nested1_7169c0d3 {
      private final Text I_field_33c1784c;
      private final int I_field_49;

      Nested1_7169c0d3(Text var1, int var2) {
         this.I_field_33c1784c = var1;
         this.I_field_49 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_7169c0d3[name=" + this.I_field_33c1784c + ", count=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_33c1784c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         iIIIIiII_Class133.Nested1_7169c0d3 other = (iIIIIiII_Class133.Nested1_7169c0d3) var1;
         return java.util.Objects.equals(this.I_field_33c1784c, other.I_field_33c1784c)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public Text I_method_2e7043bd() {
         return this.I_field_33c1784c;
      }

      public int I_method_1566ceba() {
         return this.I_field_49;
      }
   }
}
