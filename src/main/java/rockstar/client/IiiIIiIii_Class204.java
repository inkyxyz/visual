package rockstar.client;

import globals.client.WorldKey;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.multiplayer.MultiplayerScreen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.screen.world.SelectWorldScreen;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;
import ua.mintantileak.profile.Profile;
import ua.mintantileak.spk.Compile;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import org.joml.Matrix4f;

public class IiiIIiIii_Class204 extends ii_Class4 implements iIIiIIiIi_Class294 {
   public static boolean triggerReturnAnimation = false;
   private float returnAnimProgress = 0.0F;
   private static boolean I_field_5a;
   private static final List<IiiIIiIiI_Class203> I_field_7865b31 = new ArrayList<>();
   private static IiiIIiiIi_Class206 I_field_710ea66c;
   private static IiiIIiiII_Class205 I_field_710ea28c;
   private static final long I_field_4a = 1500L;
   private boolean i_field_5a;
   private long i_field_4a;
   private double I_field_44;
   private double i_field_44;
   private float I_field_46;
   private boolean II_field_5a;
   private final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(800L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
   private final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(171.0F, 254.0F, 255.0F);
   private final ColorRGBA i_field_d0c8ec5 = new ColorRGBA(203.0F, 254.0F, 255.0F);
   private final long II_field_4a = this.I_field_dc7facc.I_method_6ac4da73();
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private float i_field_46;
   private float II_field_46;
   private long Ii_field_4a = System.currentTimeMillis();
   private final iiIiIIiii_Class424 i_field_991c1e8c = new iiIiIIiii_Class424();
   private boolean Ii_field_5a;
   private final IiiiIiiIi_Class238 I_field_dd60e8c = new IiiiIiiIi_Class238(300L, new ColorRGBA(255.0F, 255.0F, 255.0F), IiiiIiiII_Class237.Iii_field_dd60aac);
   private float dropX = -1.0F;
   private int selectedButtonIndex = 0;
   private float dropHoverAnim = 0.0F;

   private float spinVelocityX = 0.0F;
   private float spinVelocityY = 0.0F;
   private float objectYaw = 0.0F;
   private float objectPitch = 0.0F;
   private float shockwaveRadius = 0.0F;
   private float shockwaveAlpha = 0.0F;
   private float coreSquish = 1.0F;
   private float assembleProgress = 0.0F;
   private boolean isShatteringAlt = false;
   private float shatterProgress = 0.0F;

   private static class ShatterFragment {
      float x, y, z;
      float vx, vy, vz;
      float rotX, rotY, rotZ;
      float vRotX, vRotY, vRotZ;
      float size;
      int color;
   }
   private final List<ShatterFragment> shatterFragments = new ArrayList<>();

   private static class ShockwaveSpark {
      float x, y, z;
      float vx, vy, vz;
      float size;
      float alpha;
   }
   private final List<ShockwaveSpark> shockwaveSparks = new ArrayList<>();

   private static class MenuPet3D {
      float x, y, z;
      float vx, vy, vz;
      float yaw, pitch, roll;
      float scale;
      float phase;
      int theme; // 0: butterfly, 1: leaf, 2: fpv drone, 3: fish
      float hitCooldown;

      void reset(int activeTheme) {
         this.theme = activeTheme;
         double theta = Math.random() * Math.PI * 2.0;
         double phi = (Math.random() - 0.5) * Math.PI * 0.75;
         float dist = (float) (170.0 + Math.random() * 80.0);
         this.x = (float) (Math.cos(phi) * Math.cos(theta) * dist);
         this.y = (float) (Math.sin(phi) * dist * 0.7);
         this.z = (float) (Math.cos(phi) * Math.sin(theta) * dist);

         float targetX = (float) ((Math.random() - 0.5) * 14.0);
         float targetY = (float) ((Math.random() - 0.5) * 16.0);
         float targetZ = (float) ((Math.random() - 0.5) * 14.0);
         float dx = targetX - this.x;
         float dy = targetY - this.y;
         float dz = targetZ - this.z;
         float len = (float) Math.max(1.0, Math.sqrt(dx * dx + dy * dy + dz * dz));

         float spd = switch (theme) {
            case 2 -> (float) (85.0 + Math.random() * 50.0); // FPV drone
            case 3 -> (float) (55.0 + Math.random() * 32.0); // Fish
            case 1 -> (float) (35.0 + Math.random() * 22.0); // Autumn leaf
            default -> (float) (45.0 + Math.random() * 26.0); // Butterfly
         };
         this.vx = (dx / len) * spd;
         this.vy = (dy / len) * spd;
         this.vz = (dz / len) * spd;
         this.scale = (float) (1.0 + Math.random() * 0.4);
         this.phase = (float) (Math.random() * Math.PI * 2.0);
         this.hitCooldown = 0.0F;
         this.yaw = (float) Math.toDegrees(Math.atan2(-dx, dz));
         this.pitch = (float) Math.toDegrees(Math.atan2(-dy, Math.sqrt(dx * dx + dz * dz)));
         this.roll = 0.0F;
      }

      void update(float dt, int activeTheme) {
         if (this.theme != activeTheme) {
            this.theme = activeTheme;
         }
         this.phase += dt * (theme == 2 ? 26.0F : (theme == 0 ? 14.0F : 8.0F));
         if (this.hitCooldown > 0.0F) {
            this.hitCooldown -= dt;
            this.yaw += dt * 380.0F;
            this.pitch += dt * 260.0F;
         } else {
            float lenXZ = (float) Math.sqrt(this.vx * this.vx + this.vz * this.vz);
            float targetYaw = (float) Math.toDegrees(Math.atan2(-this.vx, this.vz));
            float targetPitch = (float) Math.toDegrees(Math.atan2(-this.vy, lenXZ));
            this.yaw += (targetYaw - this.yaw) * Math.min(1.0F, dt * 6.0F);
            this.pitch += (targetPitch - this.pitch) * Math.min(1.0F, dt * 6.0F);
         }
         this.x += this.vx * dt;
         this.y += this.vy * dt;
         this.z += this.vz * dt;

         float dist = (float) Math.sqrt(this.x * this.x + this.y * this.y + this.z * this.z);
         if (dist > 300.0F || (dist < 8.0F && this.hitCooldown > 0.0F)) {
            this.reset(activeTheme);
         }
      }
   }
   private static final List<MenuPet3D> GLOBAL_MENU_PETS = new ArrayList<>();
   private final List<MenuPet3D> menuPets = GLOBAL_MENU_PETS;

   public static int getPetThemeForCurrentWallpaper() {
      IiiIIiiIi_Class206 wp = getWallpaperManager();
      int idx = wp != null ? wp.getCurrentWallpaperIndex() : 0;
      return switch (idx) {
         case 4, 11, 12 -> 2; // Ancient Nether, Crimson Forest, End Void -> FPV Drone
         case 0, 3, 15 -> 3;  // Twilight Lagoon, Coral Abyss, Abyssal Trench -> Fish
         case 2, 14 -> 1;     // Amber Windmill, Autumn Sanctuary -> Autumn Leaves
         default -> 0;        // Sakura, Caves, Campfire, Blossom, etc. -> Butterflies
      };
   }

   private static final List<Node3D> GLOBAL_NODES_3D = new ArrayList<>();

   private static class Node3D {
      float x, y, z;
      float vx, vy, vz;
      float size;
      float baseAlpha;
      float pulse;

      void reset(float spread) {
         this.x = (float) ((Math.random() - 0.5) * spread * 2.4);
         this.y = (float) ((Math.random() - 0.5) * spread * 1.6);
         this.z = (float) ((Math.random() - 0.5) * spread * 1.8);
         this.vx = (float) ((Math.random() - 0.5) * 10.0);
         this.vy = (float) ((Math.random() - 0.5) * 10.0);
         this.vz = (float) ((Math.random() - 0.5) * 10.0);
         this.size = (float) (2.0 + Math.random() * 3.5);
         this.baseAlpha = (float) (0.40 + Math.random() * 0.55);
         this.pulse = (float) (Math.random() * Math.PI * 2.0);
      }

      void update(float dt, float spread) {
         this.pulse += dt * 2.6F;
         this.x += this.vx * dt;
         this.y += this.vy * dt;
         this.z += this.vz * dt;
         if (Math.abs(this.x) > spread * 1.3F || Math.abs(this.y) > spread * 0.9F || Math.abs(this.z) > spread * 1.0F) {
            this.reset(spread);
         }
      }
   }
   private final List<Node3D> nodes3D = GLOBAL_NODES_3D;
   static {
      for (int i = 0; i < 75; i++) {
         Node3D n = new Node3D();
         n.reset(260.0F);
         GLOBAL_NODES_3D.add(n);
      }
   }

   private static class MenuSparkle {
      float x, y, vx, vy, size, alpha, maxAlpha, phase;
      void reset(float w, float h, boolean randomY) {
         this.x = (float) (Math.random() * w);
         this.y = randomY ? (float) (Math.random() * h) : h + (float) (Math.random() * 20.0);
         this.vx = (float) ((Math.random() - 0.5) * 16.0);
         this.vy = (float) (-18.0 - Math.random() * 26.0);
         this.size = (float) (1.4 + Math.random() * 2.8);
         this.maxAlpha = (float) (0.28 + Math.random() * 0.55);
         this.alpha = 0.0F;
         this.phase = (float) (Math.random() * Math.PI * 2.0);
      }
      void update(float dt, float w, float h) {
         this.phase += dt * 2.2F;
         this.x += (this.vx + (float) Math.sin(this.phase) * 8.0F) * dt;
         this.y += this.vy * dt;
         this.alpha = Math.min(this.maxAlpha, this.alpha + dt * 0.9F);
         if (this.y < -20.0F || this.x < -20.0F || this.x > w + 20.0F) {
            this.reset(w, h, false);
         }
      }
   }
   private final List<MenuSparkle> sparkles = new ArrayList<>();

   @Compile(
      obfuscation = 4
   )
   public void init() {
      String var1 = "image/mainmenu/icons/";
      I_method_f0183f35();
      I_method_f0183b55();
      if (this.sparkles.isEmpty()) {
         for (int i = 0; i < 45; i++) {
            MenuSparkle s = new MenuSparkle();
            s.reset(this.width > 0 ? this.width : 1920, this.height > 0 ? this.height : 1080, true);
            this.sparkles.add(s);
         }
      }
      if (this.nodes3D.isEmpty()) {
         for (int i = 0; i < 75; i++) {
            Node3D n = new Node3D();
            n.reset(260.0F);
            this.nodes3D.add(n);
         }
      }
      if (this.menuPets.isEmpty()) {
         int curTheme = getPetThemeForCurrentWallpaper();
         for (int i = 0; i < 20; i++) {
            MenuPet3D pet = new MenuPet3D();
            pet.reset(curTheme);
            this.menuPets.add(pet);
         }
      }
      this.assembleProgress = 0.0F;
      this.isShatteringAlt = false;
      this.shatterProgress = 0.0F;
      this.shatterFragments.clear();

      I_field_7865b31.clear();
      I_field_7865b31.add(new IiiIIiIiI_Class203(var1 + "single.png", 12.0F, () -> I_field_3a9bda27.setScreen(new SelectWorldScreen(this))));
      I_field_7865b31.add(new IiiIIiIiI_Class203(var1 + "multi.png", 12.0F, () -> I_field_3a9bda27.setScreen(new MultiplayerScreen(this))));
      I_field_7865b31.add(new IiiIIiIiI_Class203(var1 + "alt.png", 12.0F, () -> I_field_3a9bda27.setScreen(new AltManagerScreen(this))));
      I_field_7865b31.add(
         new IiiIIiIiI_Class203(var1 + "settings.png", 12.0F, () -> I_field_3a9bda27.setScreen(new OptionsScreen(this, I_field_3a9bda27.options)))
      );
      I_field_7865b31.add(new IiiIIiIiI_Class203(var1 + "quit.png", 14.0F, () -> {
         if (RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class).Ii_method_54c1f4f3().isSelected()) {
            iiIIiiiIi_Class414.iI_method_8d7ec562();
         }

         I_field_3a9bda27.stop();
      }));
      I_field_5a = true;

         try {
         if (RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class).isEnabled()
            && RockstarClient.getInstance().getModuleManager().getModule(SoundsModule.class).II_method_4eb9f913().isSelected()) {
            iiIIiiiIi_Class414.i_method_fc4deddf();
         }
      } catch (Throwable var3) {
         RockstarClient.I_field_ab0f6068
            .warn(
               "\u0433\u043e\u043b\u043e\u0441 \u043f\u0440\u0438\u0432\u0435\u0442\u0441\u0442\u0432\u0438\u044f \u043d\u0435 \u043f\u0440\u043e\u0438\u0433\u0440\u0430\u043b\u0441\u044f: {}",
               var3.toString()
            );
      }

      IIIIi_Class2.III_method_92ee7b3f();
      RockstarClient.getInstance()
         .I_method_cd3d46d0()
         .info(I_field_3a9bda27.getSession().getUsername(), "", "", "", WorldKey.local().world(), "all", Profile.getUsername());
      RockstarClient.getInstance().I_method_cd3d46d0().update("main_menu");
      super.init();
   }

   private static IiiIIiiIi_Class206 I_method_f0183f35() {
      if (I_field_710ea66c == null) {
         int var0 = LocalTime.now().getHour();
         boolean var1 = var0 >= 6 && var0 < 19;
         int var2 = IiiIIiiIi_Class206.I_method_2d8cb612();
         int var3 = IiiIIiiIi_Class206.i_method_2d9b41f2() - var2;
         int var4 = var1 ? ThreadLocalRandom.current().nextInt(var2) : var2 + ThreadLocalRandom.current().nextInt(Math.max(1, var3));
         I_field_710ea66c = new IiiIIiiIi_Class206(var4);
      }

      return I_field_710ea66c;
   }

   public static IiiIIiiIi_Class206 getWallpaperManager() {
      return I_method_f0183f35();
   }

   public static void renderWallpaperBackground(III var1, int width, int height, float mouseX, float mouseY) {
      IiiIIiiIi_Class206 wp = I_method_f0183f35();
      if (wp != null) {
         float cx = width / 2.0F;
         float cy = height / 2.0F;
         float parX = MathHelper.clamp((mouseX - cx) / Math.max(1.0F, cx), -1.0F, 1.0F) * 8.0F;
         float parY = MathHelper.clamp((mouseY - cy) / Math.max(1.0F, cy), -1.0F, 1.0F) * 8.0F;
         wp.I_method_493e8287(var1, width, height, parX, parY, 0.0F, 0.0F);
         if (InterfaceModule.IiI_method_c4cbfac3()) {
            iIiiIIiii_Class360.I_field_6425294c.I_method_533784a1(1.5F);
         }
      }
   }

   private static IiiIIiiII_Class205 I_method_f0183b55() {
      if (I_field_710ea28c == null) {
         I_field_710ea28c = new IiiIIiiII_Class205(() -> I_method_f0183f35().I_method_2d8cb61f());
      }

      return I_field_710ea28c;
   }

   @Override
   public void render(III var1) {
      IIiIIi_Class10 var2 = IIiIiI_Class11.ii_field_857c0621.I_method_3a2d5e3(65.0F);
      IIiIIi_Class10 var3 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(16.0F);
      IIiIIi_Class10 var4 = IIiIiI_Class11.II_field_857c0621.I_method_3a2d5e3(10.0F);
      float var5 = 1.0F - I_method_f0183f35().I_method_2d8cb60f();
      float var6 = Math.max(140.0F, this.height - 180.0F);
      float var7 = 230.0F * var5;
      float var8 = var6;
      this.I_field_dc7facc.I_method_edd72835(false);
      var1.drawRoundedRect(0.0F, 0.0F, this.width, this.height, IIiii_Class8.I_field_2d98a52c, ColorRGBA.BLACK);
      long var9 = System.currentTimeMillis();
      float var11 = Math.min(0.1F, (float)(var9 - this.Ii_field_4a) / 1000.0F);
      this.Ii_field_4a = var9;
      this.I_method_fca6301b(var9, var11);
      float var12 = this.width / 2.0F;
      float var13 = this.height / 2.0F;
      float var14 = 10.0F * var5;
      float var15 = MathHelper.clamp((var1.I_method_b1c3e152() - var12) / Math.max(1.0F, var12), -1.0F, 1.0F) * var14;
      float var16 = MathHelper.clamp((var1.i_method_b1d26d32() - var13) / Math.max(1.0F, var13), -1.0F, 1.0F) * var14;
      float var17 = 1.0F - (float)Math.pow(0.0025F, var11);
      this.i_field_46 = this.i_field_46 + (var15 - this.i_field_46) * var17;
      this.II_field_46 = this.II_field_46 + (var16 - this.II_field_46) * var17;
      I_method_f0183f35()
         .I_method_493e8287(var1, this.width, this.height, this.i_field_46, this.II_field_46, this.I_field_dc7facc.I_method_6ac4da6f(), this.I_field_46);
      // Immediately refresh blur framebuffer so Liquid Glass has current wallpaper instantly
      if (InterfaceModule.IiI_method_c4cbfac3()) {
         iIiiIIiii_Class360.I_field_6425294c.I_method_533784a1(1.5F);
      }
      boolean var18 = I_field_3a9bda27.getOverlay() != null;
      float var19 = var18 ? 0.5F : 1.4F;
      float var20 = (var18 ? 1.0F : 0.0F) * var5;
      if (var20 > 0.01F) {
         iIiiIIiii_Class360.I_field_6425294c.I_method_533784a1(var19);
         var1.drawBlurredRect(0.0F, 0.0F, this.width, this.height, 15.0F, IIiii_Class8.I_field_2d98a52c, ColorRGBA.WHITE.withAlpha(255.0F * var20));
      }

      float var35 = var5;
      ColorRGBA wallAccent = I_method_f0183f35().getWallpaperAccentColor();

      // Assemble Animation easing from bottom
      this.assembleProgress = Math.min(1.0F, this.assembleProgress + var11 * 1.6F);
      float easeAssemble = (float)(1.0 - Math.pow(1.0 - this.assembleProgress, 3));
      float assembleSlideY = (1.0F - easeAssemble) * (this.height * 0.40F);

      // Breathtaking 3D Sacred Cyber-Core & Gyroscope Orbiting Scene
      float sceneCY = Math.max(180.0F, this.height * 0.58F) + assembleSlideY * 0.5F;
      this.render3DScene(var1, this.width / 2.0F, sceneCY, var11, (float)((var9 % 10000000L) / 1000.0), this.i_field_46, this.II_field_46, wallAccent, var5 * easeAssemble);

      float var21 = Math.min(220.0F, this.height * 0.45F);
      var1.drawRoundedRect(
         0.0F,
         this.height - var21,
         this.width,
         var21,
         IIiii_Class8.I_field_2d98a52c,
         new IiiII_Class13(new ColorRGBA(0.0F, 0.0F, 0.0F, 0.0F), new ColorRGBA(0.0F, 0.0F, 0.0F, (int)(90.0F * var5)))
      );
      float btnSize = 34.0F;
      float btnGap = 7.0F;
      float barPadX = 6.0F;
      float barPadY = 5.0F;
      float totalBtnsW = I_field_7865b31.size() * btnSize + Math.max(0, I_field_7865b31.size() - 1) * btnGap;
      float barW = totalBtnsW + barPadX * 2.0F;
      float barH = btnSize + barPadY * 2.0F;
      float barX = this.width / 2.0F - barW / 2.0F;

      if (var35 > 0.01F) {
         float slideUp = (1.0F - var35) * 80.0F + assembleSlideY;
         float barY = 48.0F - slideUp;
         float barRadius = barH / 2.0F;
         float clockY = barY + barH + 14.0F;

         if (this.i_field_991c1e8c.I_method_58432069(250L)) {
            double var22 = I_field_3a9bda27.getWindow().getScaleFactor();
            float var24 = clockY + 16.0F;
            ColorRGBA var25 = ColorRGBA.fromPixel(this.width / 2.0F * (float)var22, I_field_3a9bda27.getWindow().getHeight() - var24 * (float)var22);
            this.Ii_field_5a = (var25.getRed() + var25.getGreen() + var25.getBlue()) / 3.0F > 120.0F;
            this.i_field_991c1e8c.I_method_23e11e3f();
         }

         // Ethereal breathing aurora bloom behind the liquid glass capsule
         float glowPulse = (float) Math.sin(var9 * 0.002) * 0.5F + 0.5F;
         var1.drawBlurredRect(barX - 35.0F, barY - 14.0F, barW + 70.0F, barH + 34.0F, 36.0F, IIiii_Class8.I_method_893b2757(barRadius + 18.0F), wallAccent.withAlpha((34.0F + 18.0F * glowPulse) * var35));

         // Unified Liquid Glass capsule bar adapted to active wallpaper (smooth circle power 2.0F)
         if (InterfaceModule.IiI_method_c4cbfac3()) {
            var1.drawLiquidGlass(barX, barY, barW, barH, 2.0F, 0.10F, IIiii_Class8.I_method_893b2757(barRadius), ColorRGBA.WHITE.withAlpha(255.0F * var35));
            var1.drawRoundedRect(barX, barY, barW, barH, IIiii_Class8.I_method_893b2757(barRadius), new ColorRGBA(22.0F, 22.0F, 26.0F, 120.0F * var35));
            var1.drawRoundedBorder(barX, barY, barW, barH, 1.2F, IIiii_Class8.I_method_893b2757(barRadius), wallAccent.withAlpha(70.0F * var35));
         } else {
            var1.drawRoundedRect(barX, barY, barW, barH, IIiii_Class8.I_method_893b2757(barRadius), new ColorRGBA(18.0F, 18.0F, 22.0F, 180.0F * var35));
            var1.drawRoundedBorder(barX, barY, barW, barH, 1.2F, IIiii_Class8.I_method_893b2757(barRadius), wallAccent.withAlpha(50.0F * var35));
         }

         // Dynamic diagonal specular gleam across the liquid glass bar
         float sweepT = ((var9 % 4500L) / 4500.0F) * 1.6F - 0.3F;
         float sweepX = barX + barW * sweepT;
         if (sweepX >= barX - 10.0F && sweepX <= barX + barW) {
            float gleamW = 32.0F;
            var1.drawBlurredRect(Math.max(barX, sweepX), barY, Math.min(gleamW, barX + barW - sweepX), barH, 8.0F, IIiii_Class8.I_method_893b2757(barRadius), ColorRGBA.WHITE.withAlpha(26.0F * var35));
         }

         int mouseX = var1.I_method_b1c3e152();
         int mouseY = var1.i_method_b1d26d32();
         boolean anyHovered = false;

         for (int i = 0; i < I_field_7865b31.size(); i++) {
            float bx = barX + barPadX + i * (btnSize + btnGap);
            float by = barY + barPadY;
            IiiIIiIiI_Class203 btn = I_field_7865b31.get(i);
            btn.set(bx, by, btnSize, btnSize);
            if (var35 > 0.85F && btn.hovered(mouseX, mouseY)) {
               this.selectedButtonIndex = i;
               anyHovered = true;
               iIIIiIIiI_Class275.I_method_e7d43867(iIIIiIIIi_Class274.i_field_aa52e62c);
            }
         }

         float targetX = barX + barPadX + this.selectedButtonIndex * (btnSize + btnGap);
         if (this.dropX < 0.0F) {
            this.dropX = targetX;
         } else {
            this.dropX += (targetX - this.dropX) * Math.min(1.0F, var11 * 14.0F);
         }
         this.dropHoverAnim += ((anyHovered ? 1.0F : 0.35F) - this.dropHoverAnim) * Math.min(1.0F, var11 * 10.0F);

         float dropY = barY + barPadY;
         float dropSize = btnSize;
         float dropRadius = dropSize / 2.0F;

         boolean isQuitSelected = (this.selectedButtonIndex == I_field_7865b31.size() - 1);
         ColorRGBA currentDropAccent = isQuitSelected ? new ColorRGBA(255.0F, 50.0F, 75.0F, 255.0F) : wallAccent;

         // Animated liquid glass droplet wrapping around active button tinted by active wallpaper (power 2.0F)
         if (InterfaceModule.IiI_method_c4cbfac3()) {
            var1.drawLiquidGlass(this.dropX, dropY, dropSize, dropSize, 2.0F, 0.18F, IIiii_Class8.I_method_893b2757(dropRadius), ColorRGBA.WHITE.withAlpha(255.0F * var35 * this.dropHoverAnim));
         }
         var1.drawRoundedRect(this.dropX, dropY, dropSize, dropSize, IIiii_Class8.I_method_893b2757(dropRadius), currentDropAccent.withAlpha(35.0F * var35 * this.dropHoverAnim));
         var1.drawRoundedBorder(this.dropX, dropY, dropSize, dropSize, 1.5F, IIiii_Class8.I_method_893b2757(dropRadius), currentDropAccent.withAlpha(190.0F * var35 * this.dropHoverAnim));

         for (int i = 0; i < I_field_7865b31.size(); i++) {
            IiiIIiIiI_Class203 btn = I_field_7865b31.get(i);
            btn.renderIcon(var1, var35, (i == this.selectedButtonIndex || btn.hovered(mouseX, mouseY)) && var35 > 0.85F);
         }

         // Technological cyber time display directly below the capsule bubble (only time)
         IIiIIi_Class10 techClockFont = IIiIiI_Class11.I_field_857c0621.I_method_3a2d5e3(36.0F);
         String timeStr = iIIIIiIiI_Class267.i_method_8e352841();
         String[] timeParts = timeStr.split(":");
         String hourStr = timeParts.length > 0 ? timeParts[0] : timeStr;
         String minStr = timeParts.length > 1 ? timeParts[1] : "";

         float hourW = techClockFont.I_method_2c375926(hourStr);
         float colonW = techClockFont.I_method_2c375926(":");
         float minW = techClockFont.I_method_2c375926(minStr);
         float timeTotalW = hourW + colonW + minW;
         float timeStartX = this.width / 2.0F - timeTotalW / 2.0F;

         boolean colonBlink = (System.currentTimeMillis() % 1000L) < 500L;
         ColorRGBA colonColor = colonBlink ? wallAccent.withAlpha(255.0F * var35) : wallAccent.withAlpha(70.0F * var35);
         ColorRGBA digitsColor = (this.Ii_field_5a ? new ColorRGBA(24.0F, 24.0F, 28.0F, 245.0F * var35) : new ColorRGBA(255.0F, 255.0F, 255.0F, 245.0F * var35));

         var1.drawText(techClockFont, hourStr, timeStartX, clockY, digitsColor);
         var1.drawText(techClockFont, ":", timeStartX + hourW, clockY, colonColor);
         var1.drawText(techClockFont, minStr, timeStartX + hourW + colonW, clockY, digitsColor);
      } else {
         for (IiiIIiIiI_Class203 btn : I_field_7865b31) {
            btn.set(-9999.0F, -9999.0F, 0.0F, 0.0F);
         }
      }

      if (this.I_method_ce2e8263()) {
         RockstarClient.getInstance().I_method_35687482().I_method_35128395().render(var1, var5);
      }

      I_method_f0183f35().I_method_1146ee07(var1, this.width, this.height);
      I_method_f0183b55().I_method_3e377827(var1, this.width, this.height, var5, 1.0F);

      if (triggerReturnAnimation) {
         this.returnAnimProgress += (1.0F - this.returnAnimProgress) * 0.12F;
         if (this.returnAnimProgress > 0.98F) {
            triggerReturnAnimation = false;
            this.returnAnimProgress = 1.0F;
         }
         float t = this.returnAnimProgress;
         float frameScale = 1.0F - 0.55F * t;
         float frameY = -this.height * 0.75F * t;
         float frameAlpha = (1.0F - t);

         float cx = this.width / 2.0F;
         float cy = this.height / 2.0F;

         var1.getMatrices().push();
         var1.getMatrices().translate(cx, cy + frameY, 0.0F);
         var1.getMatrices().scale(frameScale, frameScale, 1.0F);
         var1.getMatrices().translate(-cx, -cy, 0.0F);

         float frameW = this.width - 48.0F;
         float frameH = this.height - 48.0F;
         float frameX = 24.0F;
         float fY = 24.0F;

         var1.drawShadow(frameX, fY, frameW, frameH, 30.0F, IIiii_Class8.I_method_893b2757(12.0F), ColorRGBA.BLACK.withAlpha(200.0F * frameAlpha));
         var1.drawRoundedRect(frameX, fY, frameW, frameH, IIiii_Class8.I_method_893b2757(12.0F), new ColorRGBA(8.0F, 10.0F, 16.0F, 230.0F * frameAlpha));
         var1.drawRoundedBorder(frameX, fY, frameW, frameH, 1.5F, IIiii_Class8.I_method_893b2757(12.0F), IiiiiIIIi_Class242.I_method_7df8e08e().withAlpha(180.0F * frameAlpha));

         IIiIIi_Class10 bFont = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(12.0F);
         String exitTxt = "Возвращение в главное меню...";
         float ew = bFont.I_method_2c375926(exitTxt);
         var1.drawText(bFont, exitTxt, cx - ew / 2.0F, cy - 8.0F, ColorRGBA.WHITE.withAlpha(255.0F * frameAlpha));

         var1.getMatrices().pop();
      }
   }

   private void I_method_fca6301b(long var1, float var3) {
      if (this.i_field_5a && !I_method_f0183f35().i_method_2d9b4203() && var1 - this.i_field_4a >= 1500L) {
         this.i_field_5a = false;
         this.II_field_5a = false;
         I_method_f0183f35().I_method_2d8cb61f();
      }

      float var4 = this.i_field_5a && !I_method_f0183f35().i_method_2d9b4203() ? MathHelper.clamp((float)(var1 - this.i_field_4a) / 1500.0F, 0.0F, 1.0F) : 0.0F;
      this.I_field_46 = this.I_field_46 + (var4 - this.I_field_46) * (1.0F - (float)Math.pow(6.0E-4F, var3));
   }

   @Compile(
      obfuscation = 1
   )
   @Override
   public void onMouseClicked(double var1, double var3, IiIII_Class9 var5) {
      if (I_method_f0183f35().I_method_2d8cb623()) {
         I_method_f0183f35().I_method_ab3304c8(var1, var3, var5.I_method_6d899712());
         return;
      } else if (!I_method_f0183b55().I_method_22a524a8(var1, var3, var5.I_method_6d899712())) {
         if (!this.I_method_ce2e8263()
            || !RockstarClient.getInstance().I_method_35687482().I_method_35128395().I_method_60a3f448((float)var1, (float)var3, var5.I_method_6d899712())) {
            float varOpen = 1.0F - I_method_f0183f35().I_method_2d8cb60f();
            if (varOpen > 0.85F) {
               for (IiiIIiIiI_Class203 var7 : I_field_7865b31) {
                  if (var7.hovered(var1, var3)) {
                     var7.I_method_f3cf064(var1, var3, var5.I_method_6d899712());
                     return;
                  }
               }
            }

            float sceneCX = this.width / 2.0F;
            float sceneCY = Math.max(180.0F, this.height * 0.58F);
            if (Math.hypot(var1 - sceneCX, var3 - sceneCY) < 130.0) {
               this.spinVelocityY += 620.0F;
               this.spinVelocityX += (float)(Math.random() - 0.5) * 350.0F;
               this.shockwaveRadius = 15.0F;
               this.shockwaveAlpha = 1.0F;
               this.coreSquish = 0.58F;
               this.shockwaveSparks.clear();
               for (int s = 0; s < 40; s++) {
                  ShockwaveSpark sp = new ShockwaveSpark();
                  double theta = Math.random() * Math.PI * 2.0;
                  double phi = (Math.random() - 0.5) * Math.PI;
                  float spd = (float)(90.0 + Math.random() * 160.0);
                  sp.vx = (float)(Math.cos(phi) * Math.cos(theta) * spd);
                  sp.vy = (float)(Math.sin(phi) * spd);
                  sp.vz = (float)(Math.cos(phi) * Math.sin(theta) * spd);
                  sp.size = (float)(2.2 + Math.random() * 3.5);
                  sp.alpha = 1.0F;
                  this.shockwaveSparks.add(sp);
               }
               return;
            }

            if (var5.I_method_6d899712() == 0) {
               this.i_field_5a = true;
               this.i_field_4a = System.currentTimeMillis();
               this.I_field_44 = var1;
               this.i_field_44 = var3;
            }

            super.onMouseClicked(var1, var3, var5);
         }
      }
   }


   @Override
   public void onMouseReleased(double var1, double var3, IiIII_Class9 var5) {
      if (I_method_f0183f35().i_method_2d9b4203()) {
         I_method_f0183f35().II_method_5d11b2e5(var1, var3, var5.I_method_6d899712());
      } else {
         if (this.i_field_5a && var5.I_method_6d899712() == 0) {
            this.i_field_5a = false;
         }
      }
   }

   @Override
   public void onMouseDragged(double var1, double var3, IiIII_Class9 var5, double var6, double var8) {
      if (I_method_f0183f35().i_method_2d9b4203()) {
         I_method_f0183f35().i_method_47fa6ce8(var1, var3, var5.I_method_6d899712());
      } else {
         if (this.i_field_5a && (Math.abs(var1 - this.I_field_44) > 6.0 || Math.abs(var3 - this.i_field_44) > 6.0)) {
            this.i_field_5a = false;
         }
      }
   }

   public boolean mouseScrolled(double mouseX, double mouseY, double horizontalAmount, double verticalAmount) {
      if (I_method_f0183f35().i_method_2d9b4203()) {
         I_method_f0183f35().I_method_840a6e03(verticalAmount);
         return true;
      } else {
         return super.mouseScrolled(mouseX, mouseY, horizontalAmount, verticalAmount);
      }
   }

   @Compile(
      obfuscation = 1
   )
   public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
      if (I_method_f0183f35().i_method_2d9b4203()) {
         if (keyCode == 256) {
            I_method_f0183f35().i_method_2d9b41ff();
         }

         if (keyCode == 263) {
            I_method_f0183f35().I_method_840a80c8(-1);
         }

         if (keyCode == 262) {
            I_method_f0183f35().I_method_840a80c8(1);
         }

         return true;
      } else if (I_method_f0183b55().I_method_22ede008(keyCode, scanCode, modifiers)) {
         return true;
      } else {

         if (keyCode == 69) {
            RockstarClient.getInstance().I_method_9a720c62().I_method_bcf65f();
         }

         if (keyCode == 82) {
            MinecraftClient.getInstance().setScreen(new MultiplayerScreen(this));
         }

         if (keyCode == 84) {
            MinecraftClient.getInstance().setScreen(new SelectWorldScreen(this));
         }

         return super.keyPressed(keyCode, scanCode, modifiers);
      }
   }

   private void render3DScene(III var1, float cx, float cy, float dt, float timeSec, float mouseXOffset, float mouseYOffset, ColorRGBA wallAccent, float alpha) {
      if (alpha <= 0.01F) return;
      String objType = InterfaceModule.getMenuObjectType();
      if ("Выключено".equalsIgnoreCase(objType)) return;

      // Update interactive torque & squish physics
      this.objectYaw += (24.0F + this.spinVelocityY) * dt;
      this.objectPitch += (10.0F + this.spinVelocityX) * dt;
      this.spinVelocityY *= (float) Math.pow(0.08, dt);
      this.spinVelocityX *= (float) Math.pow(0.08, dt);
      this.coreSquish += (1.0F - this.coreSquish) * Math.min(1.0F, dt * 14.0F);

      if (this.shockwaveAlpha > 0.01F) {
         this.shockwaveRadius += dt * 380.0F;
         this.shockwaveAlpha -= dt * 1.8F;
      }

      int baseColor = wallAccent.getRGB();
      int prim = baseColor;
      int acc = 0xFFFFFFFF;

      // 1. Ambient pulsing radial bloom behind the 3D core
      float pulse = (float) Math.sin(timeSec * 2.2F) * 0.5F + 0.5F;
      float bloomSize = (240.0F + 36.0F * pulse) * this.coreSquish;
      var1.drawBlurredRect(cx - bloomSize / 2.0F, cy - bloomSize / 2.0F, bloomSize, bloomSize, 42.0F, IIiii_Class8.I_method_893b2757(bloomSize / 2.0F), wallAccent.withAlpha((40.0F + 22.0F * pulse) * alpha));

      MatrixStack matrices = var1.getMatrices();
      matrices.push();
      matrices.translate(cx, cy, 0.0F);
      matrices.scale(this.coreSquish, this.coreSquish, this.coreSquish);

      // Mouse Parallax + 3D Space Rotation with physics velocity
      float tiltYaw = mouseXOffset * 2.8F;
      float tiltPitch = -mouseYOffset * 2.2F;
      matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(tiltYaw));
      matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(tiltPitch + 16.0F));

      RenderSystem.enableBlend();
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableCull();
      RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

      // --- EXPANDING 3D SHOCKWAVE RING ON CLICK ---
      if (this.shockwaveAlpha > 0.01F) {
         BufferBuilder shockBuf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         draw3DGlowingRing(shockBuf, matrices.peek().getPositionMatrix(), this.shockwaveRadius, 8.0F, 36, (acc & 0x00FFFFFF) | (int)(255.0F * this.shockwaveAlpha * alpha) << 24);
         draw3DGlowingRing(shockBuf, matrices.peek().getPositionMatrix(), this.shockwaveRadius * 0.88F, 5.0F, 32, (prim & 0x00FFFFFF) | (int)(200.0F * this.shockwaveAlpha * alpha) << 24);
         BuiltBuffer sb = shockBuf.endNullable();
         if (sb != null) BufferRenderer.drawWithGlobalProgram(sb);
      }

      // --- 3D INTERACTIVE EXPLODING SPARK PARTICLES ---
      if (!this.shockwaveSparks.isEmpty()) {
         BufferBuilder sparkBuf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
         Matrix4f sm = matrices.peek().getPositionMatrix();
         for (int i = this.shockwaveSparks.size() - 1; i >= 0; i--) {
            ShockwaveSpark sp = this.shockwaveSparks.get(i);
            sp.x += sp.vx * dt;
            sp.y += sp.vy * dt;
            sp.z += sp.vz * dt;
            sp.alpha -= dt * 1.5F;
            if (sp.alpha <= 0.0F) {
               this.shockwaveSparks.remove(i);
               continue;
            }
            float hs = sp.size * 0.5F;
            int scol = (acc & 0x00FFFFFF) | (int)(255.0F * sp.alpha * alpha) << 24;
            sparkBuf.vertex(sm, sp.x - hs, sp.y - hs, sp.z).color(scol);
            sparkBuf.vertex(sm, sp.x + hs, sp.y - hs, sp.z).color(scol);
            sparkBuf.vertex(sm, sp.x + hs, sp.y + hs, sp.z).color(scol);
            sparkBuf.vertex(sm, sp.x - hs, sp.y + hs, sp.z).color(scol);
         }
         BuiltBuffer sbb = sparkBuf.endNullable();
         if (sbb != null) BufferRenderer.drawWithGlobalProgram(sbb);
      }

      // --- 2. THEMED 3D PETS COLLIDING WITH 3D LETTER A ---
      int activePetTheme = getPetThemeForCurrentWallpaper();
      float letterARadius = 44.0F * this.coreSquish;

      // Update & Draw Pets in 3D Space
      for (MenuPet3D pet : this.menuPets) {
         pet.update(dt, activePetTheme);

         // Distance to center in 3D
         float pDist = (float) Math.sqrt(pet.x * pet.x + pet.y * pet.y + pet.z * pet.z);
         if (pDist < letterARadius + 8.0F && pet.hitCooldown <= 0.0F) {
            // Collision with the 3D letter "A"!
            pet.hitCooldown = 0.85F;
            float nx = pet.x / Math.max(1.0F, pDist);
            float ny = pet.y / Math.max(1.0F, pDist);
            float nz = pet.z / Math.max(1.0F, pDist);
            float dot = pet.vx * nx + pet.vy * ny + pet.vz * nz;

            // Elastic bounce recoil
            pet.vx = (pet.vx - 2.2F * dot * nx) + (float)(Math.random() - 0.5) * 35.0F;
            pet.vy = (pet.vy - 2.2F * dot * ny) + (float)(Math.random() - 0.5) * 35.0F;
            pet.vz = (pet.vz - 2.2F * dot * nz) + (float)(Math.random() - 0.5) * 35.0F;

            // Impact recoil on letter "A"
            this.spinVelocityY += (pet.vx > 0 ? 110.0F : -110.0F);
            this.spinVelocityX += (pet.vy > 0 ? 80.0F : -80.0F);
            this.coreSquish = 0.88F;

            // Spawn collision spark particles
            for (int s = 0; s < 7; s++) {
               ShockwaveSpark sp = new ShockwaveSpark();
               sp.x = pet.x; sp.y = pet.y; sp.z = pet.z;
               sp.vx = nx * 85.0F + (float)(Math.random() - 0.5) * 60.0F;
               sp.vy = ny * 85.0F + (float)(Math.random() - 0.5) * 60.0F;
               sp.vz = nz * 85.0F + (float)(Math.random() - 0.5) * 60.0F;
               sp.size = (float)(2.0 + Math.random() * 2.8);
               sp.alpha = 1.0F;
               this.shockwaveSparks.add(sp);
            }
         }

         // Draw Pet
         matrices.push();
         matrices.translate(pet.x, pet.y, pet.z);
         matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(pet.yaw));
         matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(pet.pitch));
         matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(pet.roll));
         matrices.scale(pet.scale, pet.scale, pet.scale);

         drawSingle3DPet(matrices.peek().getPositionMatrix(), pet, activePetTheme, wallAccent, alpha);
         matrices.pop();
      }

      // --- 3. 3D FACETED EXTRUDED LETTER "A" (ANTIGRAVITY / ROCKSTAR LOGO) ---
      float coreR = 54.0F * this.coreSquish * (1.0F + 0.04F * pulse);
      drawFaceted3DLetterA(matrices, coreR, timeSec, wallAccent, alpha, prim, acc);

      // 2C. Counter-Rotating Holographic Gyroscope Orbiting Rings
      BufferBuilder ringBuf = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
      matrices.push();
      matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(42.0F));
      matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(timeSec * 50.0F));
      draw3DGlowingRing(ringBuf, matrices.peek().getPositionMatrix(), coreR * 1.35F, 3.5F, 32, (prim & 0x00FFFFFF) | ((int)(210.0F * alpha) << 24));
      draw3DSatellite(ringBuf, matrices.peek().getPositionMatrix(), coreR * 1.35F, timeSec * 2.2F, 5.5F, (acc & 0x00FFFFFF) | ((int)(255.0F * alpha) << 24));
      draw3DSatellite(ringBuf, matrices.peek().getPositionMatrix(), coreR * 1.35F, timeSec * 2.2F + (float)Math.PI, 5.5F, (acc & 0x00FFFFFF) | ((int)(255.0F * alpha) << 24));
      matrices.pop();

      matrices.push();
      matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-48.0F));
      matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-timeSec * 60.0F));
      draw3DGlowingRing(ringBuf, matrices.peek().getPositionMatrix(), coreR * 1.15F, 2.5F, 28, (acc & 0x00FFFFFF) | ((int)(190.0F * alpha) << 24));
      draw3DSatellite(ringBuf, matrices.peek().getPositionMatrix(), coreR * 1.15F, -timeSec * 3.0F, 4.5F, (prim & 0x00FFFFFF) | ((int)(255.0F * alpha) << 24));
      matrices.pop();

      BuiltBuffer rBuilt = ringBuf.endNullable();
      if (rBuilt != null) BufferRenderer.drawWithGlobalProgram(rBuilt);

      RenderSystem.enableCull();
      RenderSystem.defaultBlendFunc();
      RenderSystem.disableBlend();
      matrices.pop();
   }

   public static void render3DSceneGlobal(CustomDrawContext var1, float cx, float cy, float dt, float timeSec, float mouseXOffset, float mouseYOffset, ColorRGBA wallAccent, float alpha) {
   }

   private static void drawSingle3DPet(Matrix4f mat, MenuPet3D pet, int theme, ColorRGBA wallAccent, float alpha) {
      BufferBuilder buf = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
      int aInt = (int)(230.0F * alpha);

      switch (theme) {
         case 0 -> { // Бабочки (Butterflies with flapping wings)
            float flap = (float) Math.sin(pet.phase) * 0.75F;
            int bodyCol = 0xFF222228;
            int wingCol1 = (wallAccent.getRGB() & 0x00FFFFFF) | (aInt << 24);
            int wingCol2 = 0xFFFFFFFF;

            // Body
            buf.vertex(mat, 0.0F, 0.0F, 5.0F).color(bodyCol);
            buf.vertex(mat, -1.0F, 0.0F, 0.0F).color(bodyCol);
            buf.vertex(mat, 1.0F, 0.0F, 0.0F).color(bodyCol);

            buf.vertex(mat, 0.0F, 0.0F, -5.0F).color(bodyCol);
            buf.vertex(mat, 1.0F, 0.0F, 0.0F).color(bodyCol);
            buf.vertex(mat, -1.0F, 0.0F, 0.0F).color(bodyCol);

            // Left Wing
            float lx = -8.5F * (float)Math.cos(flap);
            float ly = -8.5F * (float)Math.sin(flap);
            buf.vertex(mat, 0.0F, 0.0F, 2.0F).color(wingCol1);
            buf.vertex(mat, lx, ly, 6.0F).color(wingCol2);
            buf.vertex(mat, lx * 0.9F, ly, -3.0F).color(wingCol1);

            buf.vertex(mat, 0.0F, 0.0F, -3.0F).color(wingCol1);
            buf.vertex(mat, lx * 0.9F, ly, -3.0F).color(wingCol2);
            buf.vertex(mat, lx * 0.6F, ly, -7.0F).color(wingCol1);

            // Right Wing
            float rx = 8.5F * (float)Math.cos(flap);
            float ry = -8.5F * (float)Math.sin(flap);
            buf.vertex(mat, 0.0F, 0.0F, 2.0F).color(wingCol1);
            buf.vertex(mat, rx * 0.9F, ry, -3.0F).color(wingCol1);
            buf.vertex(mat, rx, ry, 6.0F).color(wingCol2);

            buf.vertex(mat, 0.0F, 0.0F, -3.0F).color(wingCol1);
            buf.vertex(mat, rx * 0.6F, ry, -7.0F).color(wingCol1);
            buf.vertex(mat, rx * 0.9F, ry, -3.0F).color(wingCol2);
         }
         case 1 -> { // Листья (Autumn Leaves tumbling in wind)
            int leafAmber = 0xFFFFA028;
            int leafCrimson = 0xFFFF4520;
            int leafGold = 0xFFFFCC33;

            buf.vertex(mat, 0.0F, 0.0F, 7.0F).color(leafGold);
            buf.vertex(mat, -4.5F, 1.5F, 1.0F).color(leafAmber);
            buf.vertex(mat, 0.0F, 0.0F, -6.0F).color(leafCrimson);

            buf.vertex(mat, 0.0F, 0.0F, 7.0F).color(leafGold);
            buf.vertex(mat, 0.0F, 0.0F, -6.0F).color(leafCrimson);
            buf.vertex(mat, 4.5F, 1.5F, 1.0F).color(leafAmber);
         }
         case 2 -> { // FPV Дроны (FPV Quadcopters with spinning rotors)
            int frameCol = 0xFF2A2D34;
            int ledCol = (0x00FF3333) | (aInt << 24);
            int propCol = (0x0088CCFF) | ((int)(160.0F * alpha) << 24);

            // Center pod
            buf.vertex(mat, -2.5F, -1.5F, 3.0F).color(frameCol);
            buf.vertex(mat, 2.5F, -1.5F, 3.0F).color(frameCol);
            buf.vertex(mat, 0.0F, 1.5F, -3.0F).color(frameCol);

            // LED eye
            buf.vertex(mat, -1.0F, -1.0F, 3.2F).color(ledCol);
            buf.vertex(mat, 1.0F, -1.0F, 3.2F).color(ledCol);
            buf.vertex(mat, 0.0F, 0.5F, 3.2F).color(ledCol);

            // 4 Carbon Arms & Rotor Propellers
            float[][] arms = new float[][]{
               {-6.0F, 5.0F}, {6.0F, 5.0F}, {-6.0F, -5.0F}, {6.0F, -5.0F}
            };
            float propSpin = pet.phase * 4.0F;
            float pR = 3.5F;
            for (float[] arm : arms) {
               float ax = arm[0], az = arm[1];
               buf.vertex(mat, 0.0F, 0.0F, 0.0F).color(frameCol);
               buf.vertex(mat, ax, 0.0F, az).color(frameCol);
               buf.vertex(mat, ax * 0.8F, -0.8F, az * 0.8F).color(frameCol);

               float px1 = ax + (float)Math.cos(propSpin) * pR;
               float pz1 = az + (float)Math.sin(propSpin) * pR;
               float px2 = ax - (float)Math.cos(propSpin) * pR;
               float pz2 = az - (float)Math.sin(propSpin) * pR;
               buf.vertex(mat, ax, 0.5F, az).color(propCol);
               buf.vertex(mat, px1, 0.5F, pz1).color(propCol);
               buf.vertex(mat, px2, 0.5F, pz2).color(propCol);
            }
         }
         case 3 -> { // Рыбки (Neon bioluminescent fish)
            float tailWiggle = (float) Math.sin(pet.phase) * 0.60F;
            int fishCyan = (0x0033E0FF) | (aInt << 24);
            int fishDeep = (0x000A5588) | (aInt << 24);
            int finCol = (0x0070FFFF) | ((int)(200.0F * alpha) << 24);

            buf.vertex(mat, 0.0F, 0.0F, 6.0F).color(fishCyan);
            buf.vertex(mat, -2.5F, 0.0F, 1.0F).color(fishDeep);
            buf.vertex(mat, 2.5F, 0.0F, 1.0F).color(fishDeep);

            buf.vertex(mat, 0.0F, 2.5F, 1.0F).color(finCol);
            buf.vertex(mat, -2.5F, 0.0F, 1.0F).color(fishDeep);
            buf.vertex(mat, 2.5F, 0.0F, 1.0F).color(fishDeep);

            float tx = (float) Math.sin(tailWiggle) * 5.5F;
            buf.vertex(mat, 0.0F, 0.0F, 1.0F).color(fishDeep);
            buf.vertex(mat, tx - 1.5F, 3.0F, -6.0F).color(finCol);
            buf.vertex(mat, tx + 1.5F, -3.0F, -6.0F).color(finCol);
         }
      }

      BuiltBuffer b = buf.endNullable();
      if (b != null) BufferRenderer.drawWithGlobalProgram(b);
   }

   private static void drawFaceted3DLetterA(MatrixStack matrices, float r, float timeSec, ColorRGBA wallAccent, float alpha, int prim, int acc) {
      Matrix4f mat = matrices.peek().getPositionMatrix();
      BufferBuilder buf = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);

      float w = r * 0.82F;
      float topY = -r * 1.15F;
      float botY = r * 1.15F;
      float legW = r * 0.28F;
      float barTop = r * 0.05F;
      float barBot = r * 0.35F;
      float holeW = r * 0.22F;
      float holeTop = -r * 0.45F;
      float z = r * 0.22F;

      // Front Face (+z)
      int fCol = ColorRGBA.WHITE.mix(wallAccent, 0.70F).withAlpha(235.0F * alpha).getRGB();
      buf.vertex(mat, 0.0F, topY, z).color(fCol);
      buf.vertex(mat, -holeW, holeTop, z).color(fCol);
      buf.vertex(mat, holeW, holeTop, z).color(fCol);

      buf.vertex(mat, 0.0F, topY, z).color(fCol);
      buf.vertex(mat, -w * 0.55F, barTop, z).color(fCol);
      buf.vertex(mat, -holeW, holeTop, z).color(fCol);

      buf.vertex(mat, 0.0F, topY, z).color(fCol);
      buf.vertex(mat, holeW, holeTop, z).color(fCol);
      buf.vertex(mat, w * 0.55F, barTop, z).color(fCol);

      buf.vertex(mat, -w * 0.55F, barTop, z).color(fCol);
      buf.vertex(mat, -w * 0.65F, barBot, z).color(fCol);
      buf.vertex(mat, w * 0.55F, barTop, z).color(fCol);

      buf.vertex(mat, w * 0.55F, barTop, z).color(fCol);
      buf.vertex(mat, -w * 0.65F, barBot, z).color(fCol);
      buf.vertex(mat, w * 0.65F, barBot, z).color(fCol);

      buf.vertex(mat, -w * 0.65F, barBot, z).color(fCol);
      buf.vertex(mat, -w, botY, z).color(fCol);
      buf.vertex(mat, -w + legW, botY, z).color(fCol);

      buf.vertex(mat, -w * 0.65F, barBot, z).color(fCol);
      buf.vertex(mat, -w + legW, botY, z).color(fCol);
      buf.vertex(mat, -w * 0.35F, barBot, z).color(fCol);

      buf.vertex(mat, w * 0.65F, barBot, z).color(fCol);
      buf.vertex(mat, w - legW, botY, z).color(fCol);
      buf.vertex(mat, w, botY, z).color(fCol);

      buf.vertex(mat, w * 0.65F, barBot, z).color(fCol);
      buf.vertex(mat, w * 0.35F, barBot, z).color(fCol);
      buf.vertex(mat, w - legW, botY, z).color(fCol);

      // Back Face (-z)
      int bCol = wallAccent.withAlpha(160.0F * alpha).getRGB();
      buf.vertex(mat, 0.0F, topY, -z).color(bCol);
      buf.vertex(mat, holeW, holeTop, -z).color(bCol);
      buf.vertex(mat, -holeW, holeTop, -z).color(bCol);

      buf.vertex(mat, 0.0F, topY, -z).color(bCol);
      buf.vertex(mat, -holeW, holeTop, -z).color(bCol);
      buf.vertex(mat, -w * 0.55F, barTop, -z).color(bCol);

      buf.vertex(mat, 0.0F, topY, -z).color(bCol);
      buf.vertex(mat, w * 0.55F, barTop, -z).color(bCol);
      buf.vertex(mat, holeW, holeTop, -z).color(bCol);

      buf.vertex(mat, -w * 0.55F, barTop, -z).color(bCol);
      buf.vertex(mat, w * 0.55F, barTop, -z).color(bCol);
      buf.vertex(mat, -w * 0.65F, barBot, -z).color(bCol);

      buf.vertex(mat, w * 0.55F, barTop, -z).color(bCol);
      buf.vertex(mat, w * 0.65F, barBot, -z).color(bCol);
      buf.vertex(mat, -w * 0.65F, barBot, -z).color(bCol);

      buf.vertex(mat, -w * 0.65F, barBot, -z).color(bCol);
      buf.vertex(mat, -w + legW, botY, -z).color(bCol);
      buf.vertex(mat, -w, botY, -z).color(bCol);

      buf.vertex(mat, -w * 0.65F, barBot, -z).color(bCol);
      buf.vertex(mat, -w * 0.35F, barBot, -z).color(bCol);
      buf.vertex(mat, -w + legW, botY, -z).color(bCol);

      buf.vertex(mat, w * 0.65F, barBot, -z).color(bCol);
      buf.vertex(mat, w, botY, -z).color(bCol);
      buf.vertex(mat, w - legW, botY, -z).color(bCol);

      buf.vertex(mat, w * 0.65F, barBot, -z).color(bCol);
      buf.vertex(mat, w - legW, botY, -z).color(bCol);
      buf.vertex(mat, w * 0.35F, barBot, -z).color(bCol);

      // Extrusion Side Walls (+z to -z)
      int sCol1 = wallAccent.withAlpha(200.0F * alpha).getRGB();
      int sCol2 = wallAccent.withAlpha(140.0F * alpha).getRGB();

      drawExtrusionQuad(buf, mat, 0.0F, topY, -w, botY, z, sCol1);
      drawExtrusionQuad(buf, mat, w, botY, 0.0F, topY, z, sCol1);
      drawExtrusionQuad(buf, mat, -w, botY, -w + legW, botY, z, sCol2);
      drawExtrusionQuad(buf, mat, w - legW, botY, w, botY, z, sCol2);
      drawExtrusionQuad(buf, mat, -w + legW, botY, -w * 0.35F, barBot, z, sCol2);
      drawExtrusionQuad(buf, mat, -w * 0.35F, barBot, w * 0.35F, barBot, z, sCol2);
      drawExtrusionQuad(buf, mat, w * 0.35F, barBot, w - legW, botY, z, sCol2);
      drawExtrusionQuad(buf, mat, -holeW, holeTop, holeW, holeTop, z, sCol1);
      drawExtrusionQuad(buf, mat, holeW, holeTop, 0.0F, topY + r * 0.25F, z, sCol1);
      drawExtrusionQuad(buf, mat, 0.0F, topY + r * 0.25F, -holeW, holeTop, z, sCol1);

      BuiltBuffer bBuilt = buf.endNullable();
      if (bBuilt != null) BufferRenderer.drawWithGlobalProgram(bBuilt);

      // Glowing Edge Wireframe Lines
      BufferBuilder lineBuf = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
      int edgeCol = (acc & 0x00FFFFFF) | ((int)(245.0F * alpha) << 24);

      drawLetterAWireframe(lineBuf, mat, w, topY, botY, legW, barTop, barBot, holeW, holeTop, z, edgeCol);
      drawLetterAWireframe(lineBuf, mat, w, topY, botY, legW, barTop, barBot, holeW, holeTop, -z, edgeCol);

      lineBuf.vertex(mat, 0.0F, topY, z).color(edgeCol);
      lineBuf.vertex(mat, 0.0F, topY, -z).color(edgeCol);
      lineBuf.vertex(mat, -w, botY, z).color(edgeCol);
      lineBuf.vertex(mat, -w, botY, -z).color(edgeCol);
      lineBuf.vertex(mat, w, botY, z).color(edgeCol);
      lineBuf.vertex(mat, w, botY, -z).color(edgeCol);
      lineBuf.vertex(mat, -w + legW, botY, z).color(edgeCol);
      lineBuf.vertex(mat, -w + legW, botY, -z).color(edgeCol);
      lineBuf.vertex(mat, w - legW, botY, z).color(edgeCol);
      lineBuf.vertex(mat, w - legW, botY, -z).color(edgeCol);

      BuiltBuffer lBuilt = lineBuf.endNullable();
      if (lBuilt != null) BufferRenderer.drawWithGlobalProgram(lBuilt);
   }

   private static void drawExtrusionQuad(BufferBuilder buf, Matrix4f mat, float x1, float y1, float x2, float y2, float z, int col) {
      buf.vertex(mat, x1, y1, z).color(col);
      buf.vertex(mat, x2, y2, z).color(col);
      buf.vertex(mat, x2, y2, -z).color(col);

      buf.vertex(mat, x1, y1, z).color(col);
      buf.vertex(mat, x2, y2, -z).color(col);
      buf.vertex(mat, x1, y1, -z).color(col);
   }

   private static void drawLetterAWireframe(BufferBuilder buf, Matrix4f mat, float w, float topY, float botY, float legW, float barTop, float barBot, float holeW, float holeTop, float z, int col) {
      buf.vertex(mat, 0.0F, topY, z).color(col);
      buf.vertex(mat, -w, botY, z).color(col);
      buf.vertex(mat, 0.0F, topY, z).color(col);
      buf.vertex(mat, w, botY, z).color(col);

      buf.vertex(mat, -w, botY, z).color(col);
      buf.vertex(mat, -w + legW, botY, z).color(col);
      buf.vertex(mat, w, botY, z).color(col);
      buf.vertex(mat, w - legW, botY, z).color(col);

      buf.vertex(mat, -w + legW, botY, z).color(col);
      buf.vertex(mat, -w * 0.35F, barBot, z).color(col);
      buf.vertex(mat, -w * 0.35F, barBot, z).color(col);
      buf.vertex(mat, w * 0.35F, barBot, z).color(col);
      buf.vertex(mat, w * 0.35F, barBot, z).color(col);
      buf.vertex(mat, w - legW, botY, z).color(col);

      buf.vertex(mat, -holeW, holeTop, z).color(col);
      buf.vertex(mat, holeW, holeTop, z).color(col);
      buf.vertex(mat, holeW, holeTop, z).color(col);
      buf.vertex(mat, 0.0F, topY + (barTop - topY) * 0.3F, z).color(col);
      buf.vertex(mat, 0.0F, topY + (barTop - topY) * 0.3F, z).color(col);
      buf.vertex(mat, -holeW, holeTop, z).color(col);
   }

   private static void draw3DGlowingRing(BufferBuilder buf, Matrix4f mat, float radius, float thickness, int segs, int color) {
      float dTheta = (float) (Math.PI * 2.0 / segs);
      for (int i = 0; i < segs; i++) {
         float theta1 = i * dTheta;
         float theta2 = (i + 1) * dTheta;

         float c1 = (float) Math.cos(theta1), s1 = (float) Math.sin(theta1);
         float c2 = (float) Math.cos(theta2), s2 = (float) Math.sin(theta2);

         float rIn = radius - thickness * 0.5F;
         float rOut = radius + thickness * 0.5F;

         buf.vertex(mat, c1 * rIn, 0.0F, s1 * rIn).color(color);
         buf.vertex(mat, c1 * rOut, 0.0F, s1 * rOut).color(color);
         buf.vertex(mat, c2 * rOut, 0.0F, s2 * rOut).color(color);
         buf.vertex(mat, c2 * rIn, 0.0F, s2 * rIn).color(color);
      }
   }

   private static void draw3DSatellite(BufferBuilder buf, Matrix4f mat, float radius, float angle, float size, int color) {
      float sx = (float) Math.cos(angle) * radius;
      float sz = (float) Math.sin(angle) * radius;
      float hs = size * 0.5F;

      buf.vertex(mat, sx, -hs, sz).color(color);
      buf.vertex(mat, sx + hs, 0.0F, sz).color(color);
      buf.vertex(mat, sx, hs, sz).color(color);
      buf.vertex(mat, sx - hs, 0.0F, sz).color(color);
   }

   private boolean I_method_ce2e8263() {
      return false;
   }

   public boolean shouldCloseOnEsc() {
      return false;
   }
}
