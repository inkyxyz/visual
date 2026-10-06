package pyrock.utility.render;

import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import moscow.rockstar.mixin.accessors.NativeImageAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.texture.NativeImage;
import net.minecraft.client.texture.NativeImageBackedTexture;
import net.minecraft.client.texture.NativeImage.Format;
import net.minecraft.util.Identifier;
import org.lwjgl.system.MemoryUtil;
import rockstar.client.RockstarClient;

public final class PyDynamicTexture implements AutoCloseable {
   private static final AtomicInteger IDS = new AtomicInteger();
   private final int width;
   private final int height;
   private final NativeImage image;
   private final NativeImageBackedTexture texture;
   private final Identifier identifier;
   private final ByteBuffer pixels;
   private boolean closed;

   public PyDynamicTexture(String var1, int var2, int var3) {
      if (var2 > 0 && var3 > 0 && (long)var2 * var3 <= 16777216L) {
         this.width = var2;
         this.height = var3;
         this.image = new NativeImage(Format.RGBA, var2, var3, false);
         this.texture = new NativeImageBackedTexture(this.image);
         this.texture.setFilter(false, false);
         this.identifier = RockstarClient.id("scripts/dynamic/" + sanitize(var1) + "_" + IDS.incrementAndGet());
         this.pixels = MemoryUtil.memByteBuffer(((NativeImageAccessor)(Object)this.image).getPointer(), var2 * var3 * 4);
         MinecraftClient.getInstance().getTextureManager().registerTexture(this.identifier, this.texture);
      } else {
         throw new IllegalArgumentException("invalid dynamic texture size: " + var2 + "x" + var3);
      }
   }

   public Identifier identifier() {
      return this.identifier;
   }

   public int width() {
      return this.width;
   }

   public int height() {
      return this.height;
   }

   public void update(Object var1) {
      if (this.closed) {
         throw new IllegalStateException("dynamic texture is closed");
      } else if (var1 instanceof byte[] var2) {
         if (var2.length != this.pixels.capacity()) {
            throw new IllegalArgumentException("expected " + this.pixels.capacity() + " RGBA bytes, got " + var2.length);
         } else {
            this.pixels.clear();
            this.pixels.put(var2);
            this.pixels.clear();
            this.texture.upload();
         }
      } else {
         throw new IllegalArgumentException("dynamic texture pixels must be bytes");
      }
   }

   @Override
   public void close() {
      if (!this.closed) {
         this.closed = true;
         MinecraftClient.getInstance().getTextureManager().destroyTexture(this.identifier);
      }
   }

   private static String sanitize(String var0) {
      String var1 = var0 == null ? "texture" : var0.toLowerCase().replaceAll("[^a-z0-9/._-]", "_").replaceAll("_+", "_").replaceAll("^_+|_+$", "");
      return var1.isBlank() ? "texture" : var1;
   }
}
