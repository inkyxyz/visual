package rockstar.client;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class iiIIIiIii_Class396 {
   private static final Logger I_field_ab0f6068 = LoggerFactory.getLogger(iiIIIiIii_Class396.class);
   private static final List<iiIIIiIii_Class396> I_field_7865b31 = new ArrayList<>();
   private final Map<Identifier, iiIIIiIii_Class396.Nested1_450c0840> I_field_a567c40b = new HashMap<>();
   private final List<iiIIIiIii_Class396.Nested1_450c0820> i_field_7865b31 = new ArrayList<>();
   private Identifier I_field_6a3d6525;
   private boolean I_field_5a = false;
   private final int I_field_49;
   private final int i_field_49;

   public static iiIIIiIii_Class396 I_method_58cff815(int var0, int var1) {
      for (iiIIIiIii_Class396 var3 : I_field_7865b31) {
         if (var3.I_field_49 == var0 && var3.i_field_49 == var1 && !var3.I_method_13b30a63()) {
            return var3;
         }
      }

      iiIIIiIii_Class396 var4 = new iiIIIiIii_Class396(var0, var1);
      I_field_7865b31.add(var4);
      return var4;
   }

   private iiIIIiIii_Class396(int var1, int var2) {
      this.I_field_49 = var1;
      this.i_field_49 = var2;
   }

   public void I_method_c1fc7157(Identifier var1, iiIIIiiII_Class397 var2, List<NativeImage> var3) {
      if (this.I_field_5a) {
         throw new RuntimeException(
            "\u0410\u0442\u043b\u0430\u0441 \u0443\u0436\u0435 \u0441\u043e\u0431\u0440\u0430\u043d! \u0420\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u0443\u0439\u0442\u0435 \u0430\u043d\u0438\u043c\u0430\u0446\u0438\u0438 \u0434\u043e \u0432\u044b\u0437\u043e\u0432\u0430 buildAtlas()"
         );
      } else if (var3.isEmpty()) {
         I_field_ab0f6068.warn("\u041f\u0443\u0441\u0442\u0430\u044f \u0430\u043d\u0438\u043c\u0430\u0446\u0438\u044f: {}", var1);
      } else {
         for (NativeImage var5 : var3) {
            if (var5.getWidth() != this.I_field_49 || var5.getHeight() != this.i_field_49) {
               throw new RuntimeException(
                  String.format(
                     "\u0420\u0430\u0437\u043c\u0435\u0440 \u043a\u0430\u0434\u0440\u043e\u0432 \u0430\u043d\u0438\u043c\u0430\u0446\u0438\u0438 %s (%dx%d) \u043d\u0435 \u0441\u043e\u0432\u043f\u0430\u0434\u0430\u0435\u0442 \u0441 \u0440\u0430\u0437\u043c\u0435\u0440\u043e\u043c \u044d\u0442\u043e\u0433\u043e \u0430\u0442\u043b\u0430\u0441\u0430 (%dx%d)",
                     var1,
                     var5.getWidth(),
                     var5.getHeight(),
                     this.I_field_49,
                     this.i_field_49
                  )
               );
            }
         }

         int var6 = this.i_field_7865b31.size();

         for (int var7 = 0; var7 < var3.size(); var7++) {
            this.i_field_7865b31.add(new iiIIIiIii_Class396.Nested1_450c0820(var1, var7, (NativeImage)var3.get(var7)));
         }

         iiIIIiIii_Class396.Nested1_450c0840 var8 = new iiIIIiIii_Class396.Nested1_450c0840(var1, var2, var6, var3.size(), null);
         this.I_field_a567c40b.put(var1, var8);
         I_field_ab0f6068.info(
            "\u0417\u0430\u0440\u0435\u0433\u0438\u0441\u0442\u0440\u0438\u0440\u043e\u0432\u0430\u043d\u0430 \u0430\u043d\u0438\u043c\u0430\u0446\u0438\u044f {} \u0441 {} \u043a\u0430\u0434\u0440\u0430\u043c\u0438 \u0432 \u0430\u0442\u043b\u0430\u0441\u0435 {}x{}",
            new Object[]{var1, var3.size(), this.I_field_49, this.i_field_49}
         );
      }
   }

   public void I_method_8b098de0(Identifier var1) {
      try {
         ResourceManager var2 = MinecraftClient.getInstance().getResourceManager();
         Optional var3 = var2.getResource(var1);
         if (var3.isEmpty()) {
            throw new RuntimeException("\u0424\u0430\u0439\u043b \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d: " + var1);
         } else {
            Resource var4 = (Resource)var3.get();
            iiIIIiiII_Class397 var5 = null;
            ArrayList var6 = new ArrayList();

            try (
               InputStream var7 = var4.getInputStream();
               ZipInputStream var8 = new ZipInputStream(var7);
            ) {
               TreeMap var9;
               ZipEntry var10;
               for (var9 = new TreeMap(); (var10 = var8.getNextEntry()) != null; var8.closeEntry()) {
                  String var11 = var10.getName();
                  if ("meta.json".equals(var11)) {
                     ByteArrayOutputStream var22 = new ByteArrayOutputStream();
                     byte[] var24 = new byte[1024];

                     int var26;
                     while ((var26 = var8.read(var24)) > 0) {
                        var22.write(var24, 0, var26);
                     }

                     String var15 = var22.toString(StandardCharsets.UTF_8);
                     var5 = iiIIIiiII_Class397.I_method_29f5b2bf(var15);
                  } else if (var11.startsWith("frames/") && var11.endsWith(".png")) {
                     ByteArrayOutputStream var12 = new ByteArrayOutputStream();
                     byte[] var13 = new byte[1024];

                     int var14;
                     while ((var14 = var8.read(var13)) > 0) {
                        var12.write(var13, 0, var14);
                     }

                     var9.put(var11, var12.toByteArray());
                  }
               }

               for (byte[] var23 : (Iterable<byte[]>)(Iterable<?>)var9.values()) {
                  NativeImage var25 = NativeImage.read(new ByteArrayInputStream(var23));
                  var6.add(var25);
               }
            }

            if (var5 == null) {
               throw new RuntimeException("\u041d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d meta.json \u0432 " + var1);
            } else if (var6.isEmpty()) {
               throw new RuntimeException(
                  "\u041d\u0435\u0442 \u043a\u0430\u0434\u0440\u043e\u0432 \u0434\u043b\u044f \u0430\u043d\u0438\u043c\u0430\u0446\u0438\u0438 " + var1
               );
            } else if (((NativeImage)var6.get(0)).getWidth() == this.I_field_49 && ((NativeImage)var6.get(0)).getHeight() == this.i_field_49) {
               this.I_method_c1fc7157(var1, var5, var6);
            } else {
               throw new RuntimeException(
                  String.format(
                     "\u0420\u0430\u0437\u043c\u0435\u0440 \u043a\u0430\u0434\u0440\u043e\u0432 \u0430\u043d\u0438\u043c\u0430\u0446\u0438\u0438 %s (%dx%d) \u043d\u0435 \u0441\u043e\u0432\u043f\u0430\u0434\u0430\u0435\u0442 \u0441 \u0440\u0430\u0437\u043c\u0435\u0440\u043e\u043c \u044d\u0442\u043e\u0433\u043e \u0430\u0442\u043b\u0430\u0441\u0430 (%dx%d)",
                     var1,
                     ((NativeImage)var6.get(0)).getWidth(),
                     ((NativeImage)var6.get(0)).getHeight(),
                     this.I_field_49,
                     this.i_field_49
                  )
               );
            }
         }
      } catch (Exception var20) {
         throw new RuntimeException(
            "\u041e\u0448\u0438\u0431\u043a\u0430 \u0437\u0430\u0433\u0440\u0443\u0437\u043a\u0438 \u0430\u043d\u0438\u043c\u0430\u0446\u0438\u0438 \u0438\u0437 "
               + var1,
            var20
         );
      }
   }

   public void I_method_13b30a5f() {
      if (this.I_field_5a) {
         I_field_ab0f6068.warn("\u0410\u0442\u043b\u0430\u0441 \u0443\u0436\u0435 \u0441\u043e\u0431\u0440\u0430\u043d!");
      } else if (this.i_field_7865b31.isEmpty()) {
         I_field_ab0f6068.warn(
            "\u041d\u0435\u0442 \u043a\u0430\u0434\u0440\u043e\u0432 \u0434\u043b\u044f \u0441\u043e\u0437\u0434\u0430\u043d\u0438\u044f \u0430\u0442\u043b\u0430\u0441\u0430!"
         );
      } else {
         int var1 = this.i_field_7865b31.size();
         int var2 = (int)Math.ceil(Math.sqrt(var1));
         int var3 = (int)Math.ceil((double)var1 / var2);
         int var4 = var2 * this.I_field_49;
         int var5 = var3 * this.i_field_49;
         NativeImage var6 = new NativeImage(var4, var5, false);

         for (int var7 = 0; var7 < var4; var7++) {
            for (int var8 = 0; var8 < var5; var8++) {
               var6.setColor(var7, var8, 0);
            }
         }

         for (int var20 = 0; var20 < var1; var20++) {
            int var22 = var20 % var2;
            int var9 = var20 / var2;
            int var10 = var22 * this.I_field_49;
            int var11 = var9 * this.i_field_49;
            NativeImage var12 = this.i_field_7865b31.get(var20).I_field_cb9f726f;

            for (int var13 = 0; var13 < this.I_field_49; var13++) {
               for (int var14 = 0; var14 < this.i_field_49; var14++) {
                  var6.setColor(var10 + var13, var11 + var14, var12.getColor(var13, var14));
               }
            }
         }

         this.I_field_6a3d6525 = Identifier.of("rockstar", "global_animation_atlas_" + this.I_field_49 + "x" + this.i_field_49);
         NativeImageBackedTexture var21 = new NativeImageBackedTexture(var6);
         MinecraftClient.getInstance().getTextureManager().registerTexture(this.I_field_6a3d6525, var21);

         for (iiIIIiIii_Class396.Nested1_450c0840 var24 : this.I_field_a567c40b.values()) {
            var24.i_field_6a3d6525 = this.I_field_6a3d6525;
            ArrayList var25 = new ArrayList();

            for (int var26 = 0; var26 < var24.i_field_49; var26++) {
               int var27 = var24.I_field_49 + var26;
               int var28 = var27 % var2;
               int var29 = var27 / var2;
               float var15 = (float)var28 / var2;
               float var16 = (float)var29 / var3;
               float var17 = (float)(var28 + 1) / var2;
               float var18 = (float)(var29 + 1) / var3;
               iiIIIiiiI_Class399 var19 = new iiIIIiiiI_Class399(this.I_field_6a3d6525, var15, var16, var17, var18, this.I_field_49, this.i_field_49);
               var25.add(var19);
            }

            var24.I_field_7865b31 = var25;
         }

         this.I_field_5a = true;
         I_field_ab0f6068.info(
            "\u0410\u0442\u043b\u0430\u0441 {}x{} \u0441\u043e\u0431\u0440\u0430\u043d \u0441 {} \u0430\u043d\u0438\u043c\u0430\u0446\u0438\u044f\u043c\u0438 \u0438 {} \u043a\u0430\u0434\u0440\u0430\u043c\u0438",
            new Object[]{this.I_field_49, this.i_field_49, this.I_field_a567c40b.size(), var1}
         );
      }
   }

   public static iiIIIiIii_Class396.Nested1_450c0840 I_method_f9a210d1(Identifier var0) {
      for (iiIIIiIii_Class396 var2 : I_field_7865b31) {
         iiIIIiIii_Class396.Nested1_450c0840 var3 = var2.I_field_a567c40b.get(var0);
         if (var3 != null) {
            return var3;
         }
      }

      return null;
   }

   public Identifier I_method_16b1f96e() {
      return this.I_field_6a3d6525;
   }

   public boolean I_method_13b30a63() {
      return this.I_field_5a;
   }

   public void i_method_13c1963f() {
      if (this.I_field_6a3d6525 != null) {
         MinecraftClient.getInstance().getTextureManager().destroyTexture(this.I_field_6a3d6525);
      }

      for (iiIIIiIii_Class396.Nested1_450c0820 var2 : this.i_field_7865b31) {
         try {
            var2.I_field_cb9f726f.close();
         } catch (Exception var4) {
         }
      }

      this.I_field_a567c40b.clear();
      this.i_field_7865b31.clear();
      this.I_field_5a = false;
   }

   public static void II_method_62bd38e2() {
      for (iiIIIiIii_Class396 var1 : I_field_7865b31) {
         var1.i_method_13c1963f();
      }

      I_field_7865b31.clear();
   }

   static class Nested1_450c0820 {
      public final Identifier I_field_6a3d6525;
      public final int I_field_49;
      public final NativeImage I_field_cb9f726f;

      public Nested1_450c0820(Identifier var1, int var2, NativeImage var3) {
         this.I_field_6a3d6525 = var1;
         this.I_field_49 = var2;
         this.I_field_cb9f726f = var3;
      }
   }

   public static class Nested1_450c0840 {
      public final Identifier I_field_6a3d6525;
      public final iiIIIiiII_Class397 I_field_fe172a8c;
      public final int I_field_49;
      public final int i_field_49;
      public Identifier i_field_6a3d6525;
      public List<iiIIIiiiI_Class399> I_field_7865b31;

      public Nested1_450c0840(Identifier var1, iiIIIiiII_Class397 var2, int var3, int var4, Identifier var5) {
         this.I_field_6a3d6525 = var1;
         this.I_field_fe172a8c = var2;
         this.I_field_49 = var3;
         this.i_field_49 = var4;
         this.i_field_6a3d6525 = var5;
      }

      public iiIIIiiiI_Class399 I_method_2a3c675f(int var1) {
         return this.I_field_7865b31 != null && var1 >= 0 && var1 < this.I_field_7865b31.size() ? this.I_field_7865b31.get(var1) : null;
      }
   }
}
