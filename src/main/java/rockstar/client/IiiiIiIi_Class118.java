package rockstar.client;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import javax.imageio.ImageIO;
import net.minecraft.block.MapColor;
import net.minecraft.component.type.MapIdComponent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.decoration.ItemFrameEntity;
import net.minecraft.item.map.MapState;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.Vec3i;

public class IiiiIiIi_Class118 implements iIIiIIiIi_Class294 {
   private static final int I_field_49 = 128;
   private static final int i_field_49 = 4;
   private static final int II_field_49 = 3;
   private static final int Ii_field_49 = 3;
   private static final double I_field_44 = 16.0;
   private static final double i_field_44 = 100.0;
   private static final double II_field_44 = 50.0;
   private static final HttpClient I_field_d877234 = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(5L)).build();
   private final iiIiIIiii_Class424 I_field_991c1e8c = new iiIiIIiii_Class424();
   private String I_field_523beb0a;
   private String i_field_523beb0a;
   private boolean I_field_5a;
   private boolean i_field_5a;
   private int iI_field_49;

   public void I_method_b3f68336(String var1) {
      String var2 = var1.toLowerCase();
      if (var2.contains("\u043a\u0430\u0440\u0442\u0438\u043d\u043a") || var2.contains("\u043a\u0430\u043f\u0447") || var2.contains("captcha")) {
         this.i_field_5a = true;
         this.iI_field_49 = 0;
         this.I_field_991c1e8c.I_method_23e11e3f();
      }
   }

   public void I_method_845f1c6c() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null && this.i_field_5a && !this.I_field_5a) {
         if (iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
            if (this.iI_field_49 < 3 && this.I_field_991c1e8c.I_method_58432069(this.iI_field_49 == 0 ? 500L : 3000L)) {
               List var1 = this.I_method_2697fb4a(this.I_method_b014d05b());
               if (!var1.isEmpty()) {
                  String var2 = this.I_method_f365e8e3(var1);
                  if (var2 != null && !var2.equals(this.i_field_523beb0a)) {
                     BufferedImage var3 = this.I_method_36e9b89e(var1);
                     if (var3 != null) {
                        this.iI_field_49++;
                        this.I_field_5a = true;
                        this.I_field_523beb0a = var2;
                        this.I_field_991c1e8c.I_method_23e11e3f();
                        this.I_method_6d3cf6bb(var3, var2);
                     }
                  }
               }
            }
         }
      }
   }

   private List<ItemFrameEntity> I_method_b014d05b() {
      ArrayList var1 = new ArrayList();

      for (Entity var3 : I_field_3a9bda27.world.getEntities()) {
         if (var3 instanceof ItemFrameEntity var4 && var4.containsMap() && !(var4.squaredDistanceTo(I_field_3a9bda27.player) > 256.0)) {
            var1.add(var4);
         }
      }

      return var1;
   }

   private List<ItemFrameEntity> I_method_2697fb4a(List<ItemFrameEntity> var1) {
      HashMap<String, Map<Long, ItemFrameEntity>> var2 = new HashMap<>();

      for (ItemFrameEntity var4 : var1) {
         Direction var5 = var4.getHorizontalFacing();
         if (!var5.getAxis().isVertical()) {
            BlockPos var6 = var4.getBlockPos();
            Vec3i var7 = var5.getVector();
            String var8 = var5.asString() + ":" + (var6.getX() * var7.getX() + var6.getZ() * var7.getZ());
            var2.computeIfAbsent(var8, var0 -> new HashMap<>()).put(this.I_method_e91811c0(this.I_method_326342bd(var6, var5), var6.getY()), var4);
         }
      }

      Vec3d var20 = I_field_3a9bda27.player.getEyePos();
      Vec3d var21 = I_field_3a9bda27.player.getRotationVec(1.0F);
      double var22 = Math.cos(Math.toRadians(50.0));
      List var23 = List.of();
      double var24 = var22;
      boolean var10 = false;

      for (Map var12 : (Iterable<Map>)(Iterable<?>)var2.values()) {
         boolean var13 = var12.size() == 12;

         for (ItemFrameEntity var15 : (Iterable<ItemFrameEntity>)(Iterable<?>)var12.values()) {
            List var16 = this.I_method_253879f5(var12, var15);
            if (var16 != null) {
               Vec3d var17 = Vec3d.ZERO;

               for (ItemFrameEntity var19 : (Iterable<ItemFrameEntity>)(Iterable<?>)var16) {
                  var17 = var17.add(var19.getPos());
               }

               double var25 = var21.dotProduct(var17.multiply(1.0 / var16.size()).subtract(var20).normalize());
               if (!(var25 < var22) && (var13 && !var10 || var13 == var10 && var25 > var24)) {
                  var24 = var25;
                  var10 = var13;
                  var23 = var16;
               }
            }
         }
      }

      return var23;
   }

   private List<ItemFrameEntity> I_method_253879f5(Map<Long, ItemFrameEntity> var1, ItemFrameEntity var2) {
      Direction var3 = var2.getHorizontalFacing();
      int var4 = this.I_method_326342bd(var2.getBlockPos(), var3);
      int var5 = var2.getBlockPos().getY();
      ArrayList var6 = new ArrayList(12);

      for (int var7 = 0; var7 < 3; var7++) {
         for (int var8 = 0; var8 < 4; var8++) {
            ItemFrameEntity var9 = (ItemFrameEntity)var1.get(this.I_method_e91811c0(var4 + var8, var5 - var7));
            if (var9 == null) {
               return null;
            }

            var6.add(var9);
         }
      }

      return var6;
   }

   private long I_method_e91811c0(int var1, int var2) {
      return (long)var1 << 32 | var2 & 4294967295L;
   }

   private int I_method_326342bd(BlockPos var1, Direction var2) {
      Vec3i var3 = var2.rotateYCounterclockwise().getVector();
      return var1.getX() * var3.getX() + var1.getZ() * var3.getZ();
   }

   private BufferedImage I_method_36e9b89e(List<ItemFrameEntity> var1) {
      Direction var2 = ((ItemFrameEntity)var1.getFirst()).getHorizontalFacing();
      int var3 = Integer.MAX_VALUE;
      int var4 = Integer.MIN_VALUE;
      int var5 = Integer.MAX_VALUE;
      int var6 = Integer.MIN_VALUE;

      for (ItemFrameEntity var8 : var1) {
         int var9 = this.I_method_326342bd(var8.getBlockPos(), var2);
         int var10 = var8.getBlockPos().getY();
         var3 = Math.min(var3, var9);
         var4 = Math.max(var4, var9);
         var5 = Math.min(var5, var10);
         var6 = Math.max(var6, var10);
      }

      BufferedImage var15 = new BufferedImage((var4 - var3 + 1) * 128, (var6 - var5 + 1) * 128, 1);
      Graphics2D var16 = var15.createGraphics();
      var16.setColor(Color.WHITE);
      var16.fillRect(0, 0, var15.getWidth(), var15.getHeight());

      for (ItemFrameEntity var18 : var1) {
         MapIdComponent var11 = var18.getMapId(var18.getHeldItemStack());
         MapState var12 = var11 == null ? null : I_field_3a9bda27.world.getMapState(var11);
         if (var12 == null) {
            var16.dispose();
            return null;
         }

         int var13 = (this.I_method_326342bd(var18.getBlockPos(), var2) - var3) * 128;
         int var14 = (var6 - var18.getBlockPos().getY()) * 128;
         var16.drawImage(this.I_method_a3190bab(var12.colors, var18.getRotation() & 3), var13, var14, null);
      }

      var16.dispose();
      return var15;
   }

   private String I_method_f365e8e3(List<ItemFrameEntity> var1) {
      ArrayList var2 = new ArrayList();

      for (ItemFrameEntity var4 : var1) {
         MapIdComponent var5 = var4.getMapId(var4.getHeldItemStack());
         if (var5 == null || I_field_3a9bda27.world.getMapState(var5) == null) {
            return null;
         }

         var2.add(var5.id());
      }

      Collections.sort(var2);
      return var2.toString();
   }

   private BufferedImage I_method_a3190bab(byte[] var1, int var2) {
      BufferedImage var3 = new BufferedImage(128, 128, 1);

      for (int var4 = 0; var4 < 128; var4++) {
         for (int var5 = 0; var5 < 128; var5++) {
            int var6 = var5;
            int var7 = var4;

            for (int var8 = 0; var8 < var2; var8++) {
               int var10 = 127 - var6;
               var6 = var7;
               var7 = var10;
            }

            var3.setRGB(var5, var4, MapColor.getRenderColor(var1[var6 + var7 * 128] & 255));
         }
      }

      return var3;
   }

   private void I_method_6d3cf6bb(BufferedImage var1, String var2) {
      this.I_method_447f2163(var1, var2x -> {
         IiiiIiIi_Class118.Nested1_9b6f933 var3 = this.I_method_a250ebc(var2x);
         this.I_method_4fd10b92(var3 == null ? null : var3.I_method_7a9c5d19(), var3 == null ? -1.0 : var3.I_method_d86dd255(), var2);
      });
   }

   private void I_method_447f2163(BufferedImage var1, Consumer<String> var2) {
      byte[] var3;
      try (ByteArrayOutputStream var4 = new ByteArrayOutputStream()) {
         ImageIO.write(var1, "png", var4);
         var3 = var4.toByteArray();
      } catch (Exception var9) {
         this.I_field_5a = false;
         RockstarClient.I_field_ab0f6068
            .warn("[AutoCaptcha] \u043d\u0435 \u0441\u043c\u043e\u0433 \u0441\u043e\u0431\u0440\u0430\u0442\u044c png: {}", var9.toString());
         return;
      }

      JsonObject var10 = new JsonObject();
      var10.addProperty("base64", Base64.getEncoder().encodeToString(var3));
      HttpRequest var5 = HttpRequest.newBuilder(URI.create("https://ftapi.rockstar.pub/v1/captcha"))
         .header("Content-Type", "application/json")
         .header("User-Agent", "Rockstar")
         .timeout(Duration.ofSeconds(15L))
         .POST(BodyPublishers.ofString(var10.toString(), StandardCharsets.UTF_8))
         .build();
      I_field_d877234.sendAsync(var5, BodyHandlers.ofString(StandardCharsets.UTF_8))
         .thenAccept(var1x -> I_field_3a9bda27.execute(() -> var2.accept(var1x.body())))
         .exceptionally(
            var1x -> {
               I_field_3a9bda27.execute(
                  () -> {
                     this.I_field_5a = false;
                     RockstarClient.I_field_ab0f6068
                        .warn("[AutoCaptcha] \u0437\u0430\u043f\u0440\u043e\u0441 \u043d\u0435 \u0434\u043e\u0448\u0451\u043b: {}", var1x.toString());
                  }
               );
               return null;
            }
         );
   }

   private IiiiIiIi_Class118.Nested1_9b6f933 I_method_a250ebc(String var1) {
      try {
         JsonObject var2 = JsonParser.parseString(var1).getAsJsonObject();
         JsonObject var3 = var2.has("data") && var2.get("data").isJsonObject() ? var2.getAsJsonObject("data") : var2;
         String var4 = null;
         if (var3.has("solved") && var3.get("solved").getAsBoolean() && var3.has("text") && !var3.get("text").isJsonNull()) {
            var4 = var3.get("text").getAsString();
         }

         double var5 = -1.0;
         if (var3.has("overall_percent") && !var3.get("overall_percent").isJsonNull()) {
            var5 = var3.get("overall_percent").getAsDouble();
         }

         return new IiiiIiIi_Class118.Nested1_9b6f933(var4, var5);
      } catch (Exception var7) {
         RockstarClient.I_field_ab0f6068.warn("[AutoCaptcha] \u043d\u0435\u043f\u043e\u043d\u044f\u0442\u043d\u044b\u0439 \u043e\u0442\u0432\u0435\u0442: {}", var1);
         return null;
      }
   }

   private void I_method_4fd10b92(String var1, double var2, String var4) {
      this.I_field_5a = false;
      if (I_field_3a9bda27.player != null && var4.equals(this.I_field_523beb0a) && !var4.equals(this.i_field_523beb0a)) {
         if (var1 != null && !var1.isBlank()) {
            if (var2 >= 0.0 && var2 < 50.0) {
               if (this.iI_field_49 >= 3) {
                  iIIIIIIii_Class260.i_method_70898627(Text.of(IiIiIIII_Class81.I_method_1410d1e5("auto_captcha.low_confidence", var1, (int)var2)));
               }
            } else {
               this.i_field_523beb0a = var4;
               this.i_field_5a = false;
               I_field_3a9bda27.player.networkHandler.sendChatMessage(var1);
               iIIIIIIii_Class260.I_method_468cf607(Text.of(IiIiIIII_Class81.I_method_1410d1e5("auto_captcha.solved", var1)));
            }
         } else {
            if (this.iI_field_49 >= 3) {
               iIIIIIIii_Class260.i_method_70898627(Text.of(IiIiIIII_Class81.I_method_f25a980a("auto_captcha.failed")));
            }
         }
      }
   }

   public void i_method_846da84c() {
      this.I_field_523beb0a = null;
      this.i_field_523beb0a = null;
      this.iI_field_49 = 0;
      this.i_field_5a = false;
   }

   static final class Nested1_9b6f933 {
      private final String I_field_523beb0a;
      private final double I_field_44;

      Nested1_9b6f933(String var1, double var2) {
         this.I_field_523beb0a = var1;
         this.I_field_44 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_9b6f933[text=" + this.I_field_523beb0a + ", percent=" + this.I_field_44 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IiiiIiIi_Class118.Nested1_9b6f933 other = (IiiiIiIi_Class118.Nested1_9b6f933) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44);
      }

      public String I_method_7a9c5d19() {
         return this.I_field_523beb0a;
      }

      public double I_method_d86dd255() {
         return this.I_field_44;
      }
   }
}
