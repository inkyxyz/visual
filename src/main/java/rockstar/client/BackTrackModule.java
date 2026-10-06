package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.List;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.PlayerListEntry;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Back Track",
   III_method_a89e5834 = "modules.descriptions.back_track",
   category = ModuleCategory.COMBAT
)
public class BackTrackModule extends Module {
   private BooleanSetting I_field_ba20ca4c;
   private BooleanSetting i_field_ba20ca4c;
   private BooleanSetting II_field_ba20ca4c;
   private BooleanSetting Ii_field_ba20ca4c;
   private SliderSetting I_field_73178e8c;
   private SliderSetting i_field_73178e8c;
   private SliderSetting II_field_73178e8c;
   private static final double I_field_44 = 6.0;
   private static final double i_field_44 = 180.0;
   private static final double II_field_44 = 0.6;
   private static final double Ii_field_44 = 0.4;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41 = var1 -> {
      if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
         long var2 = System.currentTimeMillis();
         boolean var4 = this.IiI_method_6b2039f0();

         for (Entity var6 : I_field_3a9bda27.world.getEntities()) {
            if (var6 instanceof iIiIiiIiI_Class347 var7) {
               List var8 = var7.rockstar2_0$getBackTracks();
               if (var4) {
                  this.I_method_d6830659(var6, var8, var2);
               } else if (!this.I_method_45d10de(var6)) {
                  var8.clear();
               } else {
                  this.I_method_d6830659(var6, var8, var2);
               }
            }
         }
      }
   };
   private final IiIIIiII_Class69<Render3DEvent> i_field_3d936f41 = var1 -> {
      if (this.I_field_ba20ca4c.i_method_9b12da03()) {
         if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
            if (!this.IiI_method_6b2039f0()) {
               MatrixStack var2 = var1.getMatrices();
               Vec3d var3 = I_field_3a9bda27.gameRenderer.getCamera().getPos();

               for (PlayerEntity var5 : I_field_3a9bda27.world.getPlayers()) {
                  if (var5 != I_field_3a9bda27.player
                     && !RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var5.getName().getString())
                     && var5 instanceof iIiIiiIiI_Class347 var6) {
                     List var7 = var6.rockstar2_0$getBackTracks();
                     if (!var7.isEmpty()) {
                        long var8 = System.currentTimeMillis();
                        this.I_method_d6830659(var5, var7, var8);
                        if (!var7.isEmpty()) {
                           Vec3d var10 = this.I_method_bc2002ec(var5, var7);
                           if (var10 != null) {
                              BufferBuilder var11 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
                              var2.push();
                              RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
                              RenderSystem.disableCull();
                              RenderSystem.enableBlend();
                              RenderSystem.defaultBlendFunc();
                              iIiiIIiIi_Class358.Ii_method_c1caf816(
                                 var2,
                                 var11,
                                 var5.getBoundingBox().offset(var10.subtract(var5.getPos())).offset(-var3.x, -var3.y, -var3.z),
                                 ColorRGBA.WHITE.withAlpha(180.0F)
                              );
                              BuiltBuffer var12 = var11.endNullable();
                              if (var12 != null) {
                                 BufferRenderer.drawWithGlobalProgram(var12);
                              }

                              RenderSystem.enableCull();
                              RenderSystem.disableBlend();
                              var2.pop();
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   };

   public BackTrackModule() {
      this.IiI_method_6b2039ec();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_6b2039ec() {
      this.I_field_ba20ca4c = new BooleanSetting(this, "modules.settings.backtrack.visual");
      this.i_field_ba20ca4c = new BooleanSetting(this, "modules.settings.backtrack.autoreset");
      this.II_field_ba20ca4c = new BooleanSetting(this, "Ping Based");
      this.Ii_field_ba20ca4c = new BooleanSetting(this, "TPS Based");
      this.I_field_73178e8c = new SliderSetting(this, "Delay")
         .I_method_d41e7abf("ms")
         .I_method_c8c9a7d7(50.0F)
         .i_method_65e2aff7(1200.0F)
         .II_method_b0f56334(25.0F)
         .Ii_method_4e0e6b54(150.0F);
      this.i_field_73178e8c = new SliderSetting(this, "Ping Multiplier", () -> !this.II_field_ba20ca4c.i_method_9b12da03())
         .I_method_d41e7abf("x")
         .I_method_c8c9a7d7(0.6F)
         .i_method_65e2aff7(2.0F)
         .II_method_b0f56334(0.1F)
         .Ii_method_4e0e6b54(1.1F);
      this.II_field_73178e8c = new SliderSetting(this, "Min TPS", () -> !this.Ii_field_ba20ca4c.i_method_9b12da03())
         .I_method_d41e7abf("")
         .I_method_c8c9a7d7(14.0F)
         .i_method_65e2aff7(20.0F)
         .II_method_b0f56334(0.5F)
         .Ii_method_4e0e6b54(17.0F);
   }

   private int II_method_4db83428() {
      if (I_field_3a9bda27.getNetworkHandler() != null && I_field_3a9bda27.player != null) {
         PlayerListEntry var1 = I_field_3a9bda27.getNetworkHandler().getPlayerListEntry(I_field_3a9bda27.player.getUuid());
         return var1 != null ? var1.getLatency() : 0;
      } else {
         return 0;
      }
   }

   private int I_method_b97003f4(PlayerEntity var1) {
      if (I_field_3a9bda27.getNetworkHandler() == null) {
         return 0;
      } else {
         PlayerListEntry var2 = I_field_3a9bda27.getNetworkHandler().getPlayerListEntry(var1.getUuid());
         return var2 != null ? var2.getLatency() : 0;
      }
   }

   private float I_method_4491d89c() {
      iIIIiiiIi_Class286 var1 = RockstarClient.getInstance().I_method_d1ad67e2();
      return var1 != null ? var1.I_method_2bde91cf() : 20.0F;
   }

   private boolean IiI_method_6b2039f0() {
      return this.Ii_field_ba20ca4c.i_method_9b12da03() && this.I_method_4491d89c() < this.II_field_73178e8c.Ii_method_a20abcd2();
   }

   private long I_method_45d10ce(Entity var1) {
      long var2 = (long)this.I_field_73178e8c.Ii_method_a20abcd2();
      if (this.II_field_ba20ca4c.i_method_9b12da03() && var1 instanceof PlayerEntity var4) {
         int var5 = this.II_method_4db83428() + this.I_method_b97003f4(var4);
         long var6 = (long)(var5 * this.i_field_73178e8c.Ii_method_a20abcd2());
         var2 = Math.clamp(var6, (long)this.I_field_73178e8c.I_method_b2a48e2f(), (long)this.I_field_73178e8c.i_method_b2b31a0f());
      }

      if (this.Ii_field_ba20ca4c.i_method_9b12da03()) {
         float var8 = this.I_method_4491d89c();
         if (var8 > 0.0F) {
            float var9 = MathHelper.clamp(
               20.0F / var8, 1.0F, this.I_field_73178e8c.i_method_b2b31a0f() / Math.max(this.I_field_73178e8c.I_method_b2a48e2f(), (float)var2)
            );
            var2 = (long)((float)var2 * var9);
         }
      }

      return Math.clamp(var2, (long)this.I_field_73178e8c.I_method_b2a48e2f(), (long)this.I_field_73178e8c.i_method_b2b31a0f());
   }

   private Vec3d I_method_bc2002ec(PlayerEntity var1, List<BackTrackModule.Nested1_cb97a4f3> var2) {
      if (var2.isEmpty()) {
         return null;
      } else {
         Vec3d var3 = ((BackTrackModule.Nested1_cb97a4f3)var2.getLast()).I_method_2b5367e1();
         if (!this.i_field_ba20ca4c.i_method_9b12da03()) {
            return var3;
         } else {
            Vec3d var4 = I_field_3a9bda27.player.getEyePos();
            Vec3d var5 = var1.getPos();
            Box var6 = var1.getBoundingBox();
            double var7 = this.I_method_3b89da34(var4, var6);

            for (int var9 = var2.size() - 1; var9 >= 0; var9--) {
               BackTrackModule.Nested1_cb97a4f3 var10 = (BackTrackModule.Nested1_cb97a4f3)var2.get(var9);
               Box var11 = var6.offset(var10.I_method_2b5367e1().subtract(var5));
               double var12 = this.I_method_3b89da34(var4, var11);
               if (var12 < var7) {
                  return var10.I_method_2b5367e1();
               }
            }

            return null;
         }
      }
   }

   private double I_method_3b89da34(Vec3d var1, Box var2) {
      double var3 = this.i_method_7aa5614(var1, var2);
      double var5 = this.II_method_30b09a3d(var1, var2);
      double var7 = Math.min(var3 / 6.0, 1.0);
      double var9 = Math.min(var5 / 180.0, 1.0);
      return var7 * 0.6 + var9 * 0.4;
   }

   private double i_method_7aa5614(Vec3d var1, Box var2) {
      double var3 = MathHelper.clamp(var1.x, var2.minX, var2.maxX);
      double var5 = MathHelper.clamp(var1.y, var2.minY, var2.maxY);
      double var7 = MathHelper.clamp(var1.z, var2.minZ, var2.maxZ);
      return var1.distanceTo(new Vec3d(var3, var5, var7));
   }

   private double II_method_30b09a3d(Vec3d var1, Box var2) {
      float var3 = I_field_3a9bda27.player.getYaw();
      float var4 = I_field_3a9bda27.player.getPitch();
      Vec3d var5 = this.I_method_8eb5e826(var4, var3);
      Vec3d var6 = this.I_method_6d7de340(var1, var2);
      Vec3d var7 = var6.subtract(var1).normalize();
      double var8 = var5.dotProduct(var7);
      var8 = MathHelper.clamp(var8, -1.0, 1.0);
      return Math.toDegrees(Math.acos(var8));
   }

   private Vec3d I_method_6d7de340(Vec3d var1, Box var2) {
      double var3 = MathHelper.clamp(var1.x, var2.minX, var2.maxX);
      double var5 = MathHelper.clamp(var1.y, var2.minY, var2.maxY);
      double var7 = MathHelper.clamp(var1.z, var2.minZ, var2.maxZ);
      return new Vec3d(var3, var5, var7);
   }

   private Vec3d I_method_8eb5e826(float var1, float var2) {
      float var3 = (float)Math.toRadians(var1);
      float var4 = (float)Math.toRadians(var2);
      float var5 = MathHelper.cos(-var4 - (float) Math.PI);
      float var6 = MathHelper.sin(-var4 - (float) Math.PI);
      float var7 = MathHelper.cos(-var3);
      float var8 = MathHelper.sin(-var3);
      return new Vec3d(var6 * var7, var8, var5 * var7);
   }

   public Vec3d I_method_73e25ed4(Entity var1) {
      if (!this.isEnabled()) {
         return null;
      } else if (I_field_3a9bda27.player == null) {
         return null;
      } else if (this.IiI_method_6b2039f0()) {
         return null;
      } else if (var1 instanceof iIiIiiIiI_Class347 var2) {
         if (var1 instanceof PlayerEntity var3) {
            if (!this.I_method_45d10de(var1)) {
               return null;
            } else {
               List var4 = var2.rockstar2_0$getBackTracks();
               if (var4.isEmpty()) {
                  return null;
               } else {
                  long var5 = System.currentTimeMillis();
                  this.I_method_d6830659(var1, var4, var5);
                  return var4.isEmpty() ? null : this.I_method_bc2002ec(var3, var4);
               }
            }
         } else {
            return null;
         }
      } else {
         return null;
      }
   }

   @Override
   public void onDisable() {
      this.Iii_method_6b2ec5cc();
   }

   public boolean I_method_45d10de(Entity var1) {
      if (!this.isEnabled()) {
         return false;
      } else if (I_field_3a9bda27.player == null) {
         return false;
      } else if (var1 instanceof PlayerEntity var2) {
         if (var2 == I_field_3a9bda27.player) {
            return false;
         } else {
            return RockstarClient.getInstance().I_method_7a5acaeb().I_method_19c9437a(var2.getName().getString()) ? false : !this.IiI_method_6b2039f0();
         }
      } else {
         return false;
      }
   }

   public void I_method_3d57e354(Entity var1, Vec3d var2, long var3) {
      if (this.I_method_45d10de(var1)) {
         if (var1 instanceof iIiIiiIiI_Class347 var5) {
            List var6 = var5.rockstar2_0$getBackTracks();
            this.I_method_d6830659(var1, var6, var3);
            var6.add(new BackTrackModule.Nested1_cb97a4f3(var2, var3));
         }
      }
   }

   public void i_method_f546e374(Entity var1, Vec3d var2, long var3) {
      if (var1 instanceof iIiIiiIiI_Class347 var5) {
         List var6 = var5.rockstar2_0$getBackTracks();
         var6.clear();
         if (this.I_method_45d10de(var1)) {
            var6.add(new BackTrackModule.Nested1_cb97a4f3(var2, var3));
         }
      }
   }

   private void I_method_d6830659(Entity var1, List<BackTrackModule.Nested1_cb97a4f3> var2, long var3) {
      long var5 = this.I_method_45d10ce(var1);
      var2.removeIf(var4 -> var3 - var4.I_method_56e27e9b() > var5);
   }

   private void Iii_method_6b2ec5cc() {
      if (I_field_3a9bda27.world != null) {
         for (Entity var2 : I_field_3a9bda27.world.getEntities()) {
            if (var2 instanceof iIiIiiIiI_Class347 var3) {
               var3.rockstar2_0$getBackTracks().clear();
            }
         }
      }
   }

   public static final class Nested1_cb97a4f3 {
      private final Vec3d I_field_5bba0d50;
      private final long I_field_4a;

      public Nested1_cb97a4f3(Vec3d var1, long var2) {
         this.I_field_5bba0d50 = var1;
         this.I_field_4a = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_cb97a4f3[pos=" + this.I_field_5bba0d50 + ", time=" + this.I_field_4a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         BackTrackModule.Nested1_cb97a4f3 other = (BackTrackModule.Nested1_cb97a4f3) var1;
         return java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a);
      }

      public Vec3d I_method_2b5367e1() {
         return this.I_field_5bba0d50;
      }

      public long I_method_56e27e9b() {
         return this.I_field_4a;
      }
   }
}
