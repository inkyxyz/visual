package rockstar.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import lombok.Generated;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.text.Text;
import pyrock.utility.render.ColorRGBA;

public final class IiiiiIiii_Class248 implements iIIiIIiIi_Class294 {
   static final Set<String> I_field_a56a8dc5 = Set.of("Eternity", "Infinity", "Stinger", "Immortal", "Armortality", "Flash", "Cerber");
   private static final Map<String, String> i_field_a567c40b = Map.ofEntries(
      Map.entry("eternity", "Eternity"),
      Map.entry("\u044d\u0442\u0435\u0440\u043d\u0438\u0442\u0438", "Eternity"),
      Map.entry("infinity", "Infinity"),
      Map.entry("\u0438\u043d\u0444\u0438\u043d\u0438\u0442\u0438", "Infinity"),
      Map.entry("stinger", "Stinger"),
      Map.entry("\u0441\u0442\u0438\u043d\u0433\u0435\u0440", "Stinger"),
      Map.entry("immortal", "Immortal"),
      Map.entry("\u0438\u043c\u043c\u043e\u0440\u0442\u0430\u043b\u0438\u0442\u0438", "Immortal"),
      Map.entry("\u0438\u043c\u043c\u043e\u0440\u0442\u0430\u043b", "Immortal"),
      Map.entry("armortality", "Armortality"),
      Map.entry("\u0430\u0440\u043c\u043e\u0440\u0442\u0430\u043b\u0438\u0442\u0438", "Armortality"),
      Map.entry("flash", "Flash"),
      Map.entry("\u0444\u043b\u0435\u0448", "Flash"),
      Map.entry("cerber", "Cerber"),
      Map.entry("\u0446\u0435\u0440\u0431\u0435\u0440", "Cerber")
   );
   private static final Map<String, String> II_field_a567c40b = Map.ofEntries(
      Map.entry("\u0414\u0443\u0445 \u0410\u0440\u0435\u0441\u0430 \u043f\u044b\u043b\u0430\u0435\u0442", "\u0410\u0440\u0435\u0441\u0430"),
      Map.entry(
         "\u0416\u0438\u0432\u0443\u0447\u0435\u0441\u0442\u044c \u0442\u0435\u043c\u043d\u044b\u0445 \u0433\u043b\u0443\u0431\u0438\u043d",
         "\u0413\u0438\u0434\u0440\u044b"
      ),
      Map.entry(
         "\u0412\u0435\u0447\u043d\u0430\u044f \u043c\u0435\u0440\u0437\u043b\u043e\u0442\u0430 \u0441\u043a\u043e\u0432\u044b\u0432\u0430\u0435\u0442",
         "\u041c\u043e\u0440\u043e\u0437\u0430"
      ),
      Map.entry(
         "\u0428\u0451\u043f\u043e\u0442 \u0421\u0430\u0442\u0438\u0440\u0430 \u0437\u0432\u0443\u0447\u0438\u0442", "\u0421\u0430\u0442\u0438\u0440\u0430"
      ),
      Map.entry(
         "\u041c\u043e\u0449\u044c \u0422\u0438\u0442\u0430\u043d\u043e\u0432 \u043a\u0440\u0435\u043f\u043a\u0430", "\u0422\u0438\u0442\u0430\u043d\u0430"
      ),
      Map.entry(
         "\u0425\u0430\u043e\u0441 \u0438\u0441\u043a\u0430\u0436\u0430\u0435\u0442 \u0440\u0435\u0430\u043b\u044c\u043d\u043e\u0441\u0442\u044c",
         "\u0425\u0430\u043e\u0441\u0430"
      ),
      Map.entry("\u0425\u043e\u043b\u043e\u0434 \u042d\u0440\u0438\u0434\u044b \u0432\u0435\u0447\u0435\u043d", "\u042d\u0440\u0438\u0434\u0430"),
      Map.entry(
         "\u0417\u0432\u0435\u0440\u0438\u043d\u0430\u044f \u0434\u0438\u043a\u0430\u044f \u043c\u043e\u0449\u044c", "\u0411\u0435\u0441\u0442\u0438\u0438"
      ),
      Map.entry("\u0425\u0440\u0430\u043d\u0438\u0442 \u0432\u043e\u043b\u044e \u0418\u043a\u0430\u0440\u0430", "\u0418\u043a\u0430\u0440\u0430")
   );
   private static final Map<String, String> Ii_field_a567c40b = Map.ofEntries(
      Map.entry("\u0412\u0438\u0445\u0440\u044c \u043d\u0435 \u0437\u043d\u0430\u0435\u0442 \u043f\u043e\u043a\u043e\u044f", "\u0412\u0438\u0445\u0440\u044f"),
      Map.entry(
         "\u041f\u043e\u0445\u0438\u0442\u0438\u0442\u0435\u043b\u044c \u043f\u0440\u0430\u0437\u0434\u043d\u0438\u043a\u0430 \u043b\u0435\u0433\u043e\u043a",
         "\u0413\u0440\u0438\u043d\u0447\u0430"
      ),
      Map.entry(
         "\u041f\u0435\u0447\u0430\u0442\u044c \u0440\u0430\u0437\u0436\u0438\u0433\u0430\u0435\u0442 \u044f\u0440\u043e\u0441\u0442\u044c",
         "\u0414\u0435\u043c\u043e\u043d\u0430"
      ),
      Map.entry(
         "\u041a\u0440\u0443\u0448\u0438\u0442\u0435\u043b\u044c \u043d\u0435 \u0437\u043d\u0430\u0435\u0442 \u043f\u043e\u0449\u0430\u0434\u044b",
         "\u041a\u0440\u0443\u0448\u0438\u0442\u0435\u043b\u044f"
      ),
      Map.entry(
         "\u041b\u043e\u043c\u0430\u044e\u0449\u0430\u044f \u043f\u0440\u0435\u0433\u0440\u0430\u0434\u044b",
         "\u041a\u0440\u0443\u0448\u0438\u0442\u0435\u043b\u044f"
      ),
      Map.entry(
         "\u041d\u0435\u0441\u0451\u0442 \u0441\u0442\u0440\u043e\u0433\u0438\u0439 \u043f\u0440\u0438\u0433\u043e\u0432\u043e\u0440",
         "\u041a\u0430\u0440\u0430\u0442\u0435\u043b\u044f"
      ),
      Map.entry(
         "\u041c\u0440\u0430\u043a \u0441\u0433\u0443\u0449\u0430\u0435\u0442\u0441\u044f \u0440\u044f\u0434\u043e\u043c", "\u041c\u0440\u0430\u043a\u0430"
      ),
      Map.entry(
         "\u0420\u0430\u0437\u0434\u043e\u0440 \u0436\u0430\u0436\u0434\u0435\u0442 \u0445\u0430\u043e\u0441\u0430",
         "\u0420\u0430\u0437\u0434\u043e\u0440\u0430"
      ),
      Map.entry(
         "\u0422\u0438\u0440\u0430\u043d \u043f\u043e\u0434\u0430\u0432\u043b\u044f\u0435\u0442 \u0441\u043b\u0430\u0431\u044b\u0445",
         "\u0422\u0438\u0440\u0430\u043d\u0430"
      ),
      Map.entry(
         "\u0427\u0438\u0441\u0442\u0430\u044f, \u0434\u0438\u043a\u0430\u044f \u0430\u0433\u0440\u0435\u0441\u0441\u0438\u044f",
         "\u042f\u0440\u043e\u0441\u0442\u0438"
      )
   );
   private static final Map<String, String> iI_field_a567c40b = Map.ofEntries(
      Map.entry("tal-vihrya", "\u0412\u0438\u0445\u0440\u044f"),
      Map.entry("tal-vihra", "\u0412\u0438\u0445\u0440\u044f"),
      Map.entry("tal-grincha", "\u0413\u0440\u0438\u043d\u0447\u0430"),
      Map.entry("tal-demona", "\u0414\u0435\u043c\u043e\u043d\u0430"),
      Map.entry("tal-krush", "\u041a\u0440\u0443\u0448\u0438\u0442\u0435\u043b\u044f"),
      Map.entry("tal-karatel", "\u041a\u0430\u0440\u0430\u0442\u0435\u043b\u044f"),
      Map.entry("tal-mraka", "\u041c\u0440\u0430\u043a\u0430"),
      Map.entry("tal-razdora", "\u0420\u0430\u0437\u0434\u043e\u0440\u0430"),
      Map.entry("tal-tirana", "\u0422\u0438\u0440\u0430\u043d\u0430"),
      Map.entry("tal-yarosti", "\u042f\u0440\u043e\u0441\u0442\u0438"),
      Map.entry("tal-jarosti", "\u042f\u0440\u043e\u0441\u0442\u0438")
   );
   private static final Map<String, String> ii_field_a567c40b = Map.ofEntries(
      Map.entry("sph-aresa", "\u0410\u0440\u0435\u0441\u0430"),
      Map.entry("sph-gidra", "\u0413\u0438\u0434\u0440\u044b"),
      Map.entry("sph-moroza", "\u041c\u043e\u0440\u043e\u0437\u0430"),
      Map.entry("sph-satira", "\u0421\u0430\u0442\u0438\u0440\u0430"),
      Map.entry("sph-titana", "\u0422\u0438\u0442\u0430\u043d\u0430"),
      Map.entry("sph-haosa", "\u0425\u0430\u043e\u0441\u0430"),
      Map.entry("sph-erida", "\u042d\u0440\u0438\u0434\u0430"),
      Map.entry("sph-bestia", "\u0411\u0435\u0441\u0442\u0438\u0438"),
      Map.entry("sph-ikara", "\u0418\u043a\u0430\u0440\u0430")
   );
   static final Map<String, String> III_field_a567c40b = Map.ofEntries(
      Map.entry("EXPLOSIVE_TRAP", "\u0412\u0437\u0440\u044b\u0432\u043d\u0430\u044f \u0442\u0440\u0430\u043f\u043a\u0430"),
      Map.entry("explosivetrap", "\u0412\u0437\u0440\u044b\u0432\u043d\u0430\u044f \u0442\u0440\u0430\u043f\u043a\u0430"),
      Map.entry("STUN_STAR", "\u0421\u0442\u0430\u043d"),
      Map.entry("ALTERNATIVE_TRAP", "\u0422\u0440\u0430\u043f\u043a\u0430"),
      Map.entry("ExplosiveStuff", "\u0412\u0437\u0440\u044b\u0432\u043d\u0430\u044f \u0448\u0442\u0443\u0447\u043a\u0430"),
      Map.entry("SnowBall", "\u0421\u043d\u0435\u0436\u043e\u043a"),
      Map.entry("SunHelmet", "\u0428\u043b\u0435\u043c \u0421\u043e\u043b\u043d\u0446\u0430"),
      Map.entry("desorientation", "\u0414\u0435\u0437\u043e\u0440\u0438\u0435\u043d\u0442\u0430\u0446\u0438\u044f"),
      Map.entry("sheerdust", "\u042f\u0432\u043d\u0430\u044f \u043f\u044b\u043b\u044c"),
      Map.entry("godsaura", "\u0410\u0443\u0440\u0430 \u0431\u043e\u0433\u0430"),
      Map.entry("effect-item-diz", "\u0414\u0435\u0437\u043e\u0440\u0438\u0435\u043d\u0442\u0430\u0446\u0438\u044f"),
      Map.entry("effect-item-dust", "\u042f\u0432\u043d\u0430\u044f \u043f\u044b\u043b\u044c"),
      Map.entry("effect-item-god", "\u0410\u0443\u0440\u0430 \u0431\u043e\u0433\u0430"),
      Map.entry("effect-item-trap", "\u0422\u0440\u0430\u043f\u043a\u0430"),
      Map.entry("effect-item-explosivetrap", "\u0412\u0437\u0440\u044b\u0432\u043d\u0430\u044f \u0442\u0440\u0430\u043f\u043a\u0430"),
      Map.entry("effect-item-snowball", "\u0421\u043d\u0435\u0436\u043e\u043a"),
      Map.entry("effect-item-stun", "\u0421\u0442\u0430\u043d"),
      Map.entry("attribute-item-tkryshitela", "\u041a\u0440\u0443\u0448\u0438\u0442\u0435\u043b\u044f"),
      Map.entry("attribute-item-tkaratela", "\u041a\u0430\u0440\u0430\u0442\u0435\u043b\u044f"),
      Map.entry("attribute-item-tvihra", "\u0412\u0438\u0445\u0440\u044f"),
      Map.entry("attribute-item-ttirana", "\u0422\u0438\u0440\u0430\u043d\u0430"),
      Map.entry("attribute-item-tgrincha", "\u0413\u0440\u0438\u043d\u0447\u0430"),
      Map.entry("attribute-item-tdemona", "\u0414\u0435\u043c\u043e\u043d\u0430"),
      Map.entry("attribute-item-tmraka", "\u041c\u0440\u0430\u043a\u0430"),
      Map.entry("attribute-item-trazdora", "\u0420\u0430\u0437\u0434\u043e\u0440\u0430"),
      Map.entry("attribute-item-tyarosti", "\u042f\u0440\u043e\u0441\u0442\u0438"),
      Map.entry("attribute-item-saresa", "\u0410\u0440\u0435\u0441\u0430"),
      Map.entry("attribute-item-shydra", "\u0413\u0438\u0434\u0440\u044b"),
      Map.entry("attribute-item-smoroza", "\u041c\u043e\u0440\u043e\u0437\u0430"),
      Map.entry("attribute-item-ssatira", "\u0421\u0430\u0442\u0438\u0440\u0430"),
      Map.entry("attribute-item-stitana", "\u0422\u0438\u0442\u0430\u043d\u0430"),
      Map.entry("attribute-item-shaosa", "\u0425\u0430\u043e\u0441\u0430"),
      Map.entry("attribute-item-serida", "\u042d\u0440\u0438\u0434\u0430"),
      Map.entry("attribute-item-sbestii", "\u0411\u0435\u0441\u0442\u0438\u0438"),
      Map.entry("attribute-item-sikara", "\u0418\u043a\u0430\u0440\u0430"),
      Map.entry("attribute-item-safina", "\u0410\u0444\u0438\u043d\u044b"),
      Map.entry("trap", "\u0422\u0440\u0430\u043f\u043a\u0430"),
      Map.entry("plast", "\u041f\u043b\u0430\u0441\u0442"),
      Map.entry("disorientation", "\u0414\u0435\u0437\u043e\u0440\u0438\u0435\u043d\u0442\u0430\u0446\u0438\u044f"),
      Map.entry("gods", "\u0411\u043e\u0436\u044c\u044f \u0430\u0443\u0440\u0430"),
      Map.entry("tornado", "\u041e\u0433\u043d\u0435\u043d\u043d\u044b\u0439 \u0441\u043c\u0435\u0440\u0447"),
      Map.entry("dust", "\u042f\u0432\u043d\u0430\u044f \u043f\u044b\u043b\u044c"),
      Map.entry("snowball", "\u0421\u043d\u0435\u0436\u043e\u043a"),
      Map.entry("krush", "\u041a\u0440\u0443\u0448\u0438\u0442\u0435\u043b\u044f"),
      Map.entry("karatelya", "\u041a\u0430\u0440\u0430\u0442\u0435\u043b\u044f"),
      Map.entry("dedala", "\u0414\u0435\u0434\u0430\u043b\u0430"),
      Map.entry("grani", "\u0413\u0440\u0430\u043d\u0438"),
      Map.entry("garmonii", "\u0413\u0430\u0440\u043c\u043e\u043d\u0438\u0438"),
      Map.entry("ehidna", "\u0415\u0445\u0438\u0434\u043d\u044b"),
      Map.entry("tritona", "\u0422\u0440\u0438\u0442\u043e\u043d\u0430"),
      Map.entry("fenixa", "\u0424\u0435\u043d\u0438\u043a\u0441\u0430"),
      Map.entry("yarosti", "\u042f\u0440\u043e\u0441\u0442\u0438"),
      Map.entry("andromeda", "\u0410\u043d\u0434\u0440\u043e\u043c\u0435\u0434\u044b"),
      Map.entry("titana", "\u0422\u0438\u0442\u0430\u043d\u0430"),
      Map.entry("apollona", "\u0410\u043f\u043e\u043b\u043b\u043e\u043d\u0430"),
      Map.entry("astreya", "\u0410\u0441\u0442\u0440\u0435\u044f"),
      Map.entry("osirisa", "\u041e\u0441\u0438\u0440\u0438\u0441\u0430"),
      Map.entry("satira", "\u0421\u0430\u0442\u0438\u0440\u0430"),
      Map.entry("pandori", "\u041f\u0430\u043d\u0434\u043e\u0440\u044b"),
      Map.entry("himeri", "\u0425\u0438\u043c\u0435\u0440\u044b")
   );
   static final Map<String, ColorRGBA> IIi_field_a567c40b = Map.ofEntries(
      Map.entry("ExplosiveStuff", ColorRGBA.fromHex("FF0000")),
      Map.entry("STUN_STAR", ColorRGBA.fromHex("E4E4E4")),
      Map.entry("EXPLOSIVE_TRAP", ColorRGBA.fromHex("7F83A5")),
      Map.entry("ALTERNATIVE_TRAP", ColorRGBA.fromHex("CE7FDA")),
      Map.entry("Eternity", ColorRGBA.fromHex("CD0078")),
      Map.entry("Infinity", ColorRGBA.fromHex("00B412")),
      Map.entry("Stinger", ColorRGBA.fromHex("FC0F00")),
      Map.entry("Immortal", ColorRGBA.fromHex("7700DF")),
      Map.entry("Armortality", ColorRGBA.fromHex("3E4E73")),
      Map.entry("Flash", ColorRGBA.fromHex("0080FA")),
      Map.entry("Cerber", ColorRGBA.fromHex("0080FA")),
      Map.entry("SunHelmet", ColorRGBA.fromHex("FCC700"))
   );
   public static final Map<Item, String> I_field_a567c40b = Map.ofEntries(
      Map.entry(Items.NETHERITE_SCRAP, "\u0422\u0440\u0430\u043f\u043a\u0430"),
      Map.entry(Items.ENDER_EYE, "\u0414\u0435\u0437\u043e\u0440\u0438\u0435\u043d\u0442\u0430\u0446\u0438\u044f"),
      Map.entry(Items.FIRE_CHARGE, "\u0421\u043c\u0435\u0440\u0447"),
      Map.entry(Items.DRIED_KELP, "\u041f\u043b\u0430\u0441\u0442"),
      Map.entry(Items.PHANTOM_MEMBRANE, "\u0410\u0443\u0440\u0430 \u0431\u043e\u0433\u0430"),
      Map.entry(Items.SUGAR, "\u041f\u044b\u043b\u044c"),
      Map.entry(Items.POPPED_CHORUS_FRUIT, "\u0422\u0440\u0430\u043f\u043a\u0430"),
      Map.entry(Items.NETHER_STAR, "\u0421\u0442\u0430\u043d"),
      Map.entry(Items.SNOWBALL, "\u0421\u043d\u0435\u0436\u043e\u043a"),
      Map.entry(Items.PRISMARINE_SHARD, "\u0412\u0437\u0440\u044b\u0432\u043d\u0430\u044f \u0442\u0440\u0430\u043f\u043a\u0430"),
      Map.entry(Items.FIREWORK_STAR, "\u0413\u0443\u043b\u044c")
   );
   static final ColorRGBA I_field_d0c8ec5 = ColorRGBA.fromHex("A9C7D8");
   static final ColorRGBA i_field_d0c8ec5 = ColorRGBA.fromHex("0080FA");
   static final ColorRGBA II_field_d0c8ec5 = ColorRGBA.fromHex("CD0078");
   static final ColorRGBA Ii_field_d0c8ec5 = ColorRGBA.fromHex("E700FA");
   static final ColorRGBA iI_field_d0c8ec5 = ColorRGBA.fromHex("F397FA");

   public static IiiiiIiii_Class248.Nested1_95187080 I_method_7613ca72(ItemStack var0) {
      if (var0 != null && !var0.isEmpty()) {
         NbtCompound var1 = Iiiiiiiii_Class256.I_method_a9db800a(var0);
         if (var1 != null) {
            IiiiiIiii_Class248.Nested1_95187080 var2 = I_method_8f1046b(var1);
            if (var2 != null) {
               return var2;
            }

            var2 = II_method_c19a3866(var0, var1);
            if (var2 != null) {
               return var2;
            }

            var2 = i_method_fd2e1e29(var0, var1);
            if (var2 != null) {
               return var2;
            }

            var2 = I_method_47c28e09(var0, var1);
            if (var2 != null) {
               return var2;
            }

            var2 = Ii_method_7705c886(var0, var1);
            if (var2 != null) {
               return var2;
            }
         }

         return II_method_98af37b5(var0);
      } else {
         return null;
      }
   }

   private static IiiiiIiii_Class248.Nested1_95187080 I_method_47c28e09(ItemStack var0, NbtCompound var1) {
      if (var1.contains("sixtrap", 8)) {
         String var5 = var1.getString("sixtrap");
         String var8 = III_field_a567c40b.getOrDefault(var5, var5);
         return new IiiiiIiii_Class248.Nested1_95187080(
            IiiiiIiii_Class248.Nested1_95187060.I_field_51ad7227, var8, IiiiiIiii_Class248.Nested1_df59be9.Ii_field_e400d4a6
         );
      } else if (var1.contains("sixitem", 8)) {
         String var4 = var1.getString("sixitem");
         String var7 = III_field_a567c40b.getOrDefault(var4, var4);
         return new IiiiiIiii_Class248.Nested1_95187080(
            IiiiiIiii_Class248.Nested1_95187060.I_field_51ad7227, var7, IiiiiIiii_Class248.Nested1_df59be9.Ii_field_e400d4a6
         );
      } else {
         if (var1.contains("bettertalismans-talisman", 8)) {
            String var2 = var1.getString("bettertalismans-talisman");
            if (var0.getItem() == Items.PLAYER_HEAD) {
               String var6 = III_field_a567c40b.getOrDefault(var2, var2);
               return new IiiiiIiii_Class248.Nested1_95187080(
                  IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227, var6, IiiiiIiii_Class248.Nested1_df59be9.Ii_field_e400d4a6
               );
            }

            if (var0.getItem() == Items.TOTEM_OF_UNDYING) {
               String var3 = III_field_a567c40b.getOrDefault(var2, var2);
               return new IiiiiIiii_Class248.Nested1_95187080(
                  IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227, var3, IiiiiIiii_Class248.Nested1_df59be9.Ii_field_e400d4a6
               );
            }
         }

         return null;
      }
   }

   private static IiiiiIiii_Class248.Nested1_95187080 i_method_fd2e1e29(ItemStack var0, NbtCompound var1) {
      if (var1.contains("Donat Item", 3)) {
         return new IiiiiIiii_Class248.Nested1_95187080(
            IiiiiIiii_Class248.Nested1_95187060.Ii_field_51ad7227, "SunHelmet", IiiiiIiii_Class248.Nested1_df59be9.i_field_e400d4a6
         );
      } else if (var1.contains("snowball", 1)) {
         return new IiiiiIiii_Class248.Nested1_95187080(
            IiiiiIiii_Class248.Nested1_95187060.I_field_51ad7227, "SnowBall", IiiiiIiii_Class248.Nested1_df59be9.i_field_e400d4a6
         );
      } else if (var1.contains("explosive-thing", 1)) {
         return new IiiiiIiii_Class248.Nested1_95187080(
            IiiiiIiii_Class248.Nested1_95187060.I_field_51ad7227, "ExplosiveStuff", IiiiiIiii_Class248.Nested1_df59be9.i_field_e400d4a6
         );
      } else {
         String var2 = I_method_eec63d92(var1, "PublicBukkitValues", "litetraps:item");
         if (var2 != null) {
            String var9 = switch (var2) {
               case "stun" -> "STUN_STAR";
               case "default" -> "ALTERNATIVE_TRAP";
               case "custom" -> "EXPLOSIVE_TRAP";
               default -> var2;
            };
            return new IiiiiIiii_Class248.Nested1_95187080(
               IiiiiIiii_Class248.Nested1_95187060.I_field_51ad7227, var9, IiiiiIiii_Class248.Nested1_df59be9.i_field_e400d4a6
            );
         } else {
            String var3 = I_method_eec63d92(var1, "PublicBukkitValues", "minecraft:talisman_type");
            if (var3 != null) {
               IiiiiIiii_Class248.Nested1_df59c09 var4 = IiiiiIiii_Class248.Nested1_df59c09.I_method_6afb2621(var3);
               HashMap var5 = new HashMap();
               NbtCompound var6 = var1.getCompound("PublicBukkitValues");
               if (var6.contains("minecraft:talisman_effect_speed", 3)) {
                  var5.put("hms-speed", var6.getInt("minecraft:talisman_effect_speed"));
               }

               if (var6.contains("minecraft:talisman_effect_damage", 3)) {
                  var5.put("hms-damage", var6.getInt("minecraft:talisman_effect_damage"));
               }

               if (var6.contains("minecraft:talisman_effect_armor", 3)) {
                  var5.put("hms-armor", var6.getInt("minecraft:talisman_effect_armor"));
               }

               IiiiiIiii_Class248.Nested1_95187060 var7 = var0.getItem() == Items.TOTEM_OF_UNDYING
                  ? IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227
                  : IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227;
               String var8 = i_method_2b81e39f(var0);
               return new IiiiiIiii_Class248.Nested1_95187080(var7, var8, var4, IiiiiIiii_Class248.Nested1_df59be9.i_field_e400d4a6, var5);
            } else {
               return null;
            }
         }
      }
   }

   private static String i_method_2b81e39f(ItemStack var0) {
      String var1 = Iiiiiiiii_Class256.i_method_524c3f7f(var0).toLowerCase();
      Map var2 = Map.ofEntries(
         Map.entry("eternity", "Eternity"),
         Map.entry("\u1d07\u1d1b\u1d07\u0280\u0274\u026a\u1d1b\u028f", "Eternity"),
         Map.entry("\u044d\u0442\u0435\u0440\u043d\u0438\u0442\u0438", "Eternity"),
         Map.entry("infinity", "Infinity"),
         Map.entry("\u026a\u0274\ua730\u026a\u0274\u026a\u1d1b\u028f", "Infinity"),
         Map.entry("\u026a\u0274\u0493\u026a\u0274\u026a\u1d1b\u028f", "Infinity"),
         Map.entry("\u0438\u043d\u0444\u0438\u043d\u0438\u0442\u0438", "Infinity"),
         Map.entry("stinger", "Stinger"),
         Map.entry("\ua731\u1d1b\u026a\u0274\u0262\u1d07\u0280", "Stinger"),
         Map.entry("s\u1d1b\u026a\u0274\u0262\u1d07\u0280", "Stinger"),
         Map.entry("\u0441\u0442\u0438\u043d\u0433\u0435\u0440", "Stinger"),
         Map.entry("immortal", "Immortal"),
         Map.entry("\u026a\u1d0d\u1d0d\u1d0f\u0280\u1d1b\u1d00\u029f", "Immortal"),
         Map.entry("\u026a\u1d0d\u1d0d\u1d0f\u0280\u1d1b\u1d00\u029f\u026a\u1d1b\u028f", "Immortal"),
         Map.entry("\u0438\u043c\u043c\u043e\u0440\u0442\u0430\u043b", "Immortal"),
         Map.entry("armortality", "Armortality"),
         Map.entry("\u1d00\u0280\u1d0d\u1d0f\u0280\u1d1b\u1d00\u029f\u026a\u1d1b\u028f", "Armortality"),
         Map.entry("\u0430\u0440\u043c\u043e\u0440\u0442\u0430\u043b\u0438\u0442\u0438", "Armortality"),
         Map.entry("flash", "Flash"),
         Map.entry("\ua730\u029f\u1d00\ua731\u029c", "Flash"),
         Map.entry("\u0493\u029f\u1d00s\u029c", "Flash"),
         Map.entry("\u0444\u043b\u0435\u0448", "Flash"),
         Map.entry("cerber", "Cerber"),
         Map.entry("\u1d04\u1d07\u0280\u0299\u1d07\u0280", "Cerber"),
         Map.entry("\u0446\u0435\u0440\u0431\u0435\u0440", "Cerber")
      );

      for (Entry var4 : (Iterable<Entry>)(Iterable<?>)var2.entrySet()) {
         if (var1.contains((CharSequence)var4.getKey())) {
            return (String)var4.getValue();
         }
      }

      return null;
   }

   public static String I_method_203b3197(String var0) {
      if (var0 == null) {
         return "";
      } else {
         String var1 = var0.toLowerCase(Locale.ROOT);
         if (var1.startsWith("sphere-")) {
            return "sph-" + var1.substring("sphere-".length());
         } else {
            return var1.startsWith("talisman-") ? "tal-" + var1.substring("talisman-".length()) : var1;
         }
      }
   }

   private static IiiiiIiii_Class248.Nested1_95187080 II_method_98af37b5(ItemStack var0) {
      boolean var1 = var0.getItem() == Items.TOTEM_OF_UNDYING;
      boolean var2 = var0.getItem() == Items.PLAYER_HEAD;
      if (!var1 && !var2) {
         return null;
      } else {
         List var3 = I_method_e47834e6(var0);
         if (var3.isEmpty()) {
            return null;
         } else {
            IiiiiIiii_Class248.Nested1_95187060 var4 = var1
               ? IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227
               : IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227;
            Map var5 = var1 ? Ii_field_a567c40b : II_field_a567c40b;

            for (String var7 : (Iterable<String>)(Iterable<?>)var3) {
               for (Entry var9 : (Iterable<Entry>)(Iterable<?>)var5.entrySet()) {
                  if (var7.contains((CharSequence)var9.getKey())) {
                     return new IiiiiIiii_Class248.Nested1_95187080(var4, (String)var9.getValue(), null, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6);
                  }
               }
            }

            return !var0.hasEnchantments()
               ? null
               : new IiiiiIiii_Class248.Nested1_95187080(var4, null, null, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6);
         }
      }
   }

   private static List<String> I_method_e47834e6(ItemStack var0) {
      LoreComponent var1 = (LoreComponent)var0.get(DataComponentTypes.LORE);
      if (var1 == null) {
         return List.of();
      } else {
         ArrayList var2 = new ArrayList(var1.lines().size());

         for (Text var4 : var1.lines()) {
            var2.add(var4.getString());
         }

         return var2;
      }
   }

   public static IiiiiIiii_Class248.Nested1_95187080 i_method_fde1be52(ItemStack var0) {
      if (var0 != null && !var0.isEmpty()) {
         IiiiiIiii_Class248.Nested1_95187080 var1 = I_method_7613ca72(var0);
         if (var1 != null) {
            return var1;
         } else {
            IiiiiIiii_Class248.Nested1_95187080 var2 = Ii_method_207d2b95(var0);
            if (var2 != null) {
               return var2;
            } else if (var0.getItem() == Items.TOTEM_OF_UNDYING && var0.hasEnchantments()) {
               return new IiiiiIiii_Class248.Nested1_95187080(
                  IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227, null, null, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6
               );
            } else {
               return var0.getItem() == Items.PLAYER_HEAD && var0.hasEnchantments()
                  ? new IiiiiIiii_Class248.Nested1_95187080(
                     IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227, null, null, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6
                  )
                  : null;
            }
         }
      } else {
         return null;
      }
   }

   private static IiiiiIiii_Class248.Nested1_95187080 Ii_method_207d2b95(ItemStack var0) {
      try {
         if (!(var0.toNbt(I_field_3a9bda27.world.getRegistryManager()) instanceof NbtCompound var2)) {
            return null;
         }

         boolean var3 = var0.getItem() == Items.PLAYER_HEAD;
         boolean var4 = var0.getItem() == Items.TOTEM_OF_UNDYING;
         IiiiiIiii_Class248.Nested1_95187080 var5 = I_method_cd01186b(var2, var3, var4);
         if (var5 != null) {
            return var5;
         }

         if (var2.contains("components", 10)) {
            NbtCompound var6 = var2.getCompound("components");
            if (var6.contains("minecraft:custom_data", 10)) {
               NbtCompound var7 = var6.getCompound("minecraft:custom_data");
               var5 = I_method_cd01186b(var7, var3, var4);
               if (var5 != null) {
                  return var5;
               }

               if (var3 && var7.contains("display", 10)) {
                  String var8 = I_method_1217326(var7);
                  if (var8 != null) {
                     return new IiiiiIiii_Class248.Nested1_95187080(
                        IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227, var8, null, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6
                     );
                  }
               }
            }
         }

         if (var3 && var0.hasEnchantments()) {
            return new IiiiiIiii_Class248.Nested1_95187080(
               IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227, null, null, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6
            );
         }
      } catch (Exception var9) {
      }

      return null;
   }

   private static IiiiiIiii_Class248.Nested1_95187080 I_method_cd01186b(NbtCompound var0, boolean var1, boolean var2) {
      if (!var0.contains("itemServiceId", 10)) {
         return null;
      } else {
         NbtCompound var3 = var0.getCompound("itemServiceId");
         if (!var3.contains("name", 8)) {
            return null;
         } else {
            String var4 = var3.getString("name").toLowerCase();
            String var5 = i_method_405a19b7(var4);
            IiiiiIiii_Class248.Nested1_df59c09 var6 = I_method_dd71b393(var4);
            boolean var7 = var4.startsWith("\u0442\u0430\u043b\u0438\u0441\u043c\u0430\u043d");
            if (var2 || var7) {
               return new IiiiiIiii_Class248.Nested1_95187080(
                  IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227, var5, var6, IiiiiIiii_Class248.Nested1_df59be9.I_field_e400d4a6
               );
            } else {
               return var1
                  ? new IiiiiIiii_Class248.Nested1_95187080(
                     IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227, var5, var6, IiiiiIiii_Class248.Nested1_df59be9.I_field_e400d4a6
                  )
                  : null;
            }
         }
      }
   }

   private static String i_method_405a19b7(String var0) {
      for (Entry var2 : i_field_a567c40b.entrySet()) {
         if (var0.contains((CharSequence)var2.getKey())) {
            return (String)var2.getValue();
         }
      }

      return null;
   }

   private static IiiiiIiii_Class248.Nested1_df59c09 I_method_dd71b393(String var0) {
      if (var0.contains("\u043c\u0438\u0444\u0438\u0447\u0435\u0441\u043a") || var0.contains("mythic")) {
         return IiiiiIiii_Class248.Nested1_df59c09.Ii_field_e400d886;
      } else if (var0.contains("\u043b\u0435\u0433\u0435\u043d\u0434\u0430\u0440\u043d") || var0.contains("legendary")) {
         return IiiiiIiii_Class248.Nested1_df59c09.II_field_e400d886;
      } else if (!var0.contains("\u044d\u043f\u0438\u0447\u0435\u0441\u043a") && !var0.contains("epic")) {
         if (!var0.contains("\u043e\u0431\u044b\u0447\u043d") && !var0.contains("normal")) {
            for (String var2 : I_field_a56a8dc5) {
               if (var0.contains(var2.toLowerCase())) {
                  return IiiiiIiii_Class248.Nested1_df59c09.iI_field_e400d886;
               }
            }

            return null;
         } else {
            return IiiiiIiii_Class248.Nested1_df59c09.I_field_e400d886;
         }
      } else {
         return IiiiiIiii_Class248.Nested1_df59c09.i_field_e400d886;
      }
   }

   private static IiiiiIiii_Class248.Nested1_95187080 I_method_8f1046b(NbtCompound var0) {
      String var1 = I_method_eec63d92(var0, "PublicBukkitValues", "spookyitems:spooky-item");
      if (var1 == null) {
         var1 = I_method_30db811c(var0, "spooky-item");
      }

      if (var1 == null) {
         return null;
      } else {
         IiiiiIiii_Class248.Nested1_95187060 var2 = I_method_ee5e817a(var1);
         return new IiiiiIiii_Class248.Nested1_95187080(var2, var1, IiiiiIiii_Class248.Nested1_df59be9.iI_field_e400d4a6);
      }
   }

   private static IiiiiIiii_Class248.Nested1_95187060 I_method_ee5e817a(String var0) {
      if (var0.startsWith("effect-item-") || var0.startsWith("schematic-item-")) {
         return IiiiiIiii_Class248.Nested1_95187060.I_field_51ad7227;
      } else if (var0.startsWith("attribute-item-t")) {
         return IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227;
      } else {
         return var0.startsWith("attribute-item-s")
            ? IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227
            : IiiiiIiii_Class248.Nested1_95187060.iI_field_51ad7227;
      }
   }

   private static IiiiiIiii_Class248.Nested1_95187080 II_method_c19a3866(ItemStack var0, NbtCompound var1) {
      if (var1.contains("pyrotechnic-item", 10)) {
         String var2 = var1.getCompound("pyrotechnic-item").getString("name");
         if (!var2.isEmpty()) {
            return new IiiiiIiii_Class248.Nested1_95187080(
               IiiiiIiii_Class248.Nested1_95187060.I_field_51ad7227, var2, IiiiiIiii_Class248.Nested1_df59be9.I_field_e400d4a6
            );
         }
      }

      if (var1.contains("kringeItems", 10)) {
         String var10 = var1.getCompound("kringeItems").getString("type");
         if (!var10.isEmpty()) {
            if (var10.equals("SunHelmet")) {
               return new IiiiiIiii_Class248.Nested1_95187080(
                  IiiiiIiii_Class248.Nested1_95187060.Ii_field_51ad7227, var10, IiiiiIiii_Class248.Nested1_df59be9.I_field_e400d4a6
               );
            }

            return new IiiiiIiii_Class248.Nested1_95187080(
               IiiiiIiii_Class248.Nested1_95187060.I_field_51ad7227, var10, IiiiiIiii_Class248.Nested1_df59be9.I_field_e400d4a6
            );
         }
      }

      if (var1.contains("kringeEffect", 10)) {
         String var11 = var1.getCompound("kringeEffect").getString("type");
         if (!var11.isEmpty()) {
            return new IiiiiIiii_Class248.Nested1_95187080(
               IiiiiIiii_Class248.Nested1_95187060.Ii_field_51ad7227, var11, IiiiiIiii_Class248.Nested1_df59be9.I_field_e400d4a6
            );
         }
      }

      if (var1.contains("sphereEffect", 10)) {
         NbtCompound var13 = var1.getCompound("sphereEffect");
         String var14 = var13.getString("name");
         String var15 = var13.getString("rank");
         boolean var16 = var13.getBoolean("isMascot");
         String var17 = var13.getString("effects");
         HashMap var18 = new HashMap();
         if (var17 != null && !var17.isEmpty()) {
            I_method_399bea3c(var17, var18);
         }

         IiiiiIiii_Class248.Nested1_df59c09 var8 = IiiiiIiii_Class248.Nested1_df59c09.I_method_6afb2621(var15);
         IiiiiIiii_Class248.Nested1_95187060 var9;
         if (var0.getItem() == Items.TOTEM_OF_UNDYING) {
            var9 = IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227;
         } else if (var0.getItem() == Items.PLAYER_HEAD) {
            var9 = IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227;
         } else {
            var9 = var16 ? IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227 : IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227;
         }

         return new IiiiiIiii_Class248.Nested1_95187080(var9, var14.isEmpty() ? null : var14, var8, IiiiiIiii_Class248.Nested1_df59be9.I_field_e400d4a6, var18);
      } else {
         if (var1.contains("itemServiceId", 10)) {
            NbtCompound var12 = var1.getCompound("itemServiceId");
            String var3 = var12.getString("name");
            if (!var3.isEmpty()) {
               String var4 = var3.toLowerCase();
               String var5 = i_method_405a19b7(var4);
               IiiiiIiii_Class248.Nested1_df59c09 var6 = var5 != null ? IiiiiIiii_Class248.Nested1_df59c09.iI_field_e400d886 : I_method_dd71b393(var4);
               IiiiiIiii_Class248.Nested1_95187060 var7;
               if (var0.getItem() == Items.TOTEM_OF_UNDYING) {
                  var7 = IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227;
               } else if (var0.getItem() == Items.PLAYER_HEAD) {
                  var7 = IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227;
               } else {
                  var7 = IiiiiIiii_Class248.Nested1_95187060.iI_field_51ad7227;
               }

               return new IiiiiIiii_Class248.Nested1_95187080(var7, var5, var6, IiiiiIiii_Class248.Nested1_df59be9.I_field_e400d4a6);
            }
         }

         return null;
      }
   }

   private static IiiiiIiii_Class248.Nested1_95187080 Ii_method_7705c886(ItemStack var0, NbtCompound var1) {
      String var2 = I_method_eec63d92(var1, "PublicBukkitValues", "minecraft:don-item");
      if (var2 == null) {
         var2 = I_method_30db811c(var1, "don-item");
      }

      if (var2 != null) {
         String var6 = I_method_203b3197(var2);
         if (var6.startsWith("tal-")) {
            String var8 = iI_field_a567c40b.get(var6);
            return new IiiiiIiii_Class248.Nested1_95187080(
               IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227, var8, null, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6
            );
         } else if (var6.startsWith("sph-")) {
            String var7 = ii_field_a567c40b.get(var6);
            return new IiiiiIiii_Class248.Nested1_95187080(
               IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227, var7, null, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6
            );
         } else if (var0.getItem() == Items.PLAYER_HEAD) {
            String var4 = I_method_1217326(var1);
            if (var4 == null) {
               var4 = II_method_1f026a1c(var0);
            }

            return var4 != null
               ? new IiiiiIiii_Class248.Nested1_95187080(
                  IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227, var4, null, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6
               )
               : new IiiiiIiii_Class248.Nested1_95187080(
                  IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227, null, null, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6
               );
         } else {
            return new IiiiiIiii_Class248.Nested1_95187080(
               IiiiiIiii_Class248.Nested1_95187060.I_field_51ad7227, var2, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6
            );
         }
      } else if (var0.getItem() == Items.TOTEM_OF_UNDYING && var0.hasEnchantments()) {
         String var5 = i_method_bc34bf06(var1);
         if (var5 == null) {
            var5 = Ii_method_9066223c(var0);
         }

         return new IiiiiIiii_Class248.Nested1_95187080(
            IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227, var5, null, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6
         );
      } else {
         if (var0.getItem() == Items.PLAYER_HEAD) {
            String var3 = I_method_1217326(var1);
            if (var3 == null) {
               var3 = II_method_1f026a1c(var0);
            }

            if (var3 != null) {
               return new IiiiiIiii_Class248.Nested1_95187080(
                  IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227, var3, null, IiiiiIiii_Class248.Nested1_df59be9.II_field_e400d4a6
               );
            }
         }

         return null;
      }
   }

   private static String II_method_1f026a1c(ItemStack var0) {
      try {
         if (!(var0.toNbt(I_field_3a9bda27.world.getRegistryManager()) instanceof NbtCompound var2)) {
            return null;
         }

         if (!var2.contains("components", 10)) {
            return null;
         }

         NbtCompound var3 = var2.getCompound("components");
         if (!var3.contains("minecraft:lore", 9)) {
            return null;
         }

         NbtList var4 = var3.getList("minecraft:lore", 8);
         if (var4.isEmpty()) {
            return null;
         }

         String var5 = var4.getString(0);

         for (Entry var7 : II_field_a567c40b.entrySet()) {
            if (var5.contains((CharSequence)var7.getKey())) {
               return (String)var7.getValue();
            }
         }
      } catch (Exception var8) {
      }

      return null;
   }

   private static String Ii_method_9066223c(ItemStack var0) {
      try {
         if (!(var0.toNbt(I_field_3a9bda27.world.getRegistryManager()) instanceof NbtCompound var2)) {
            return null;
         }

         if (!var2.contains("components", 10)) {
            return null;
         }

         NbtCompound var3 = var2.getCompound("components");
         if (!var3.contains("minecraft:lore", 9)) {
            return null;
         }

         NbtList var4 = var3.getList("minecraft:lore", 8);
         if (var4.isEmpty()) {
            return null;
         }

         String var5 = var4.getString(0);

         for (Entry var7 : Ii_field_a567c40b.entrySet()) {
            if (var5.contains((CharSequence)var7.getKey())) {
               return (String)var7.getValue();
            }
         }
      } catch (Exception var8) {
      }

      return null;
   }

   @Nullable
   public static String I_method_ba1e2b7f(ItemStack var0) {
      NbtCompound var1 = Iiiiiiiii_Class256.I_method_a9db800a(var0);
      if (var1 == null) {
         return null;
      } else {
         if (var1.contains("PublicBukkitValues", 10)) {
            NbtCompound var2 = var1.getCompound("PublicBukkitValues");
            if (var2.contains("minecraft:don-item", 8)) {
               return var2.getString("minecraft:don-item");
            }
         }

         if (var1.contains("minecraft:don-item", 8)) {
            return var1.getString("minecraft:don-item");
         } else {
            return var1.contains("don-item", 8) ? var1.getString("don-item") : null;
         }
      }
   }

   private static String I_method_1217326(NbtCompound var0) {
      if (var0.contains("display", 10)) {
         NbtCompound var1 = var0.getCompound("display");
         if (var1.contains("Lore", 9)) {
            NbtList var2 = var1.getList("Lore", 8);
            if (!var2.isEmpty()) {
               String var3 = var2.getString(0);

               for (Entry var5 : II_field_a567c40b.entrySet()) {
                  if (var3.contains((CharSequence)var5.getKey())) {
                     return (String)var5.getValue();
                  }
               }
            }
         }
      }

      return null;
   }

   private static String i_method_bc34bf06(NbtCompound var0) {
      if (!var0.contains("display", 10)) {
         return null;
      } else {
         NbtCompound var1 = var0.getCompound("display");
         if (!var1.contains("Lore", 9)) {
            return null;
         } else {
            NbtList var2 = var1.getList("Lore", 8);
            if (var2.isEmpty()) {
               return null;
            } else {
               String var3 = var2.getString(0);

               for (Entry var5 : Ii_field_a567c40b.entrySet()) {
                  if (var3.contains((CharSequence)var5.getKey())) {
                     return (String)var5.getValue();
                  }
               }

               return null;
            }
         }
      }
   }

   private static void I_method_399bea3c(String var0, Map<String, Integer> var1) {
      String[] var2 = new String[]{"hms-speed", "hms-damage", "hms-armor"};

      for (String var6 : var2) {
         String var7 = "\"nbtName\":\"" + var6 + "\"";
         int var8 = var0.indexOf(var7);
         if (var8 != -1) {
            int var9 = var0.lastIndexOf("{", var8);
            int var10 = var0.indexOf("}", var8);
            if (var9 != -1 && var10 != -1) {
               String var11 = var0.substring(var9, var10 + 1);
               int var12 = var11.indexOf("\"lvl\":");
               if (var12 != -1) {
                  int var13 = var12 + 6;
                  int var14 = var13;

                  while (var14 < var11.length() && Character.isDigit(var11.charAt(var14))) {
                     var14++;
                  }

                  if (var14 > var13) {
                     var1.put(var6, Integer.parseInt(var11.substring(var13, var14)));
                  }
               }
            }
         }
      }
   }

   private static String I_method_eec63d92(NbtCompound var0, String var1, String var2) {
      if (!var0.contains(var1, 10)) {
         return null;
      } else {
         NbtCompound var3 = var0.getCompound(var1);
         if (!var3.contains(var2, 8)) {
            return null;
         } else {
            String var4 = var3.getString(var2);
            return var4.isEmpty() ? null : var4;
         }
      }
   }

   private static String I_method_30db811c(NbtCompound var0, String var1) {
      if (!var0.contains(var1, 8)) {
         return null;
      } else {
         String var2 = var0.getString(var1);
         return var2.isEmpty() ? null : var2;
      }
   }

   public static IiiiiIiii_Class248.Nested1_95187060 I_method_7613c692(ItemStack var0) {
      IiiiiIiii_Class248.Nested1_95187080 var1 = I_method_7613ca72(var0);
      return var1 != null ? var1.I_method_7d1d70b() : null;
   }

   public static boolean I_method_10be9345(ItemStack var0) {
      return I_method_7613ca72(var0) != null;
   }

   public static boolean i_method_b4b71725(ItemStack var0) {
      IiiiiIiii_Class248.Nested1_95187080 var1 = I_method_7613ca72(var0);
      return var1 != null && var1.ii_method_e498f76b();
   }

   public static boolean II_method_79737308(ItemStack var0) {
      IiiiiIiii_Class248.Nested1_95187080 var1 = I_method_7613ca72(var0);
      return var1 != null && var1.Ii_method_e2d6074b();
   }

   public static boolean Ii_method_1d6bf6e8(ItemStack var0) {
      IiiiiIiii_Class248.Nested1_95187080 var1 = I_method_7613ca72(var0);
      return var1 != null && var1.iI_method_e48a6b8b();
   }

   public static boolean iI_method_548b6b28(ItemStack var0) {
      IiiiiIiii_Class248.Nested1_95187080 var1 = I_method_7613ca72(var0);
      return var1 != null && var1.III_method_7636e8de();
   }

   @Generated
   private IiiiiIiii_Class248() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }

   public static enum Nested1_95187060 {
      I_field_51ad7227("\u0420\u0430\u0441\u0445\u043e\u0434\u043d\u0438\u043a"),
      i_field_51ad7227("\u0421\u0444\u0435\u0440\u0430"),
      II_field_51ad7227("\u0422\u0430\u043b\u0438\u0441\u043c\u0430\u043d"),
      Ii_field_51ad7227("\u0410\u0440\u0442\u0435\u0444\u0430\u043a\u0442"),
      iI_field_51ad7227("\u041d\u0435\u0438\u0437\u0432\u0435\u0441\u0442\u043d\u043e");

      private final String I_field_523beb0a;

      private Nested1_95187060(String var3) {
         this.I_field_523beb0a = var3;
      }

      @Generated
      public String I_method_f0328486() {
         return this.I_field_523beb0a;
      }
   }

   public static class Nested1_95187080 {
      private final IiiiiIiii_Class248.Nested1_95187060 I_field_51ad7227;
      private final String I_field_523beb0a;
      private final IiiiiIiii_Class248.Nested1_df59c09 I_field_e400d886;
      private final IiiiiIiii_Class248.Nested1_df59be9 I_field_e400d4a6;
      private final Map<String, Integer> I_field_a567c40b;

      public Nested1_95187080(
         IiiiiIiii_Class248.Nested1_95187060 var1,
         String var2,
         IiiiiIiii_Class248.Nested1_df59c09 var3,
         IiiiiIiii_Class248.Nested1_df59be9 var4,
         Map<String, Integer> var5
      ) {
         this.I_field_51ad7227 = var1;
         this.I_field_523beb0a = var2;
         this.I_field_e400d886 = var3;
         this.I_field_e400d4a6 = var4;
         this.I_field_a567c40b = var5 != null ? var5 : Map.of();
      }

      public Nested1_95187080(
         IiiiiIiii_Class248.Nested1_95187060 var1,
         String var2,
         IiiiiIiii_Class248.Nested1_df59c09 var3,
         IiiiiIiii_Class248.Nested1_df59be9 var4,
         String var5,
         int var6
      ) {
         this(var1, var2, var3, var4, var5 != null ? Map.of(var5, var6) : Map.of());
      }

      public Nested1_95187080(
         IiiiiIiii_Class248.Nested1_95187060 var1, String var2, IiiiiIiii_Class248.Nested1_df59c09 var3, IiiiiIiii_Class248.Nested1_df59be9 var4
      ) {
         this(var1, var2, var3, var4, Map.of());
      }

      public Nested1_95187080(IiiiiIiii_Class248.Nested1_95187060 var1, String var2, IiiiiIiii_Class248.Nested1_df59be9 var3) {
         this(var1, var2, null, var3, Map.of());
      }

      public boolean I_method_d5c3e33e() {
         return this.I_field_a567c40b.containsKey("hms-speed");
      }

      public boolean i_method_d5d26f1e() {
         return this.I_field_a567c40b.containsKey("hms-damage") || this.I_field_a567c40b.containsKey("hms-armor");
      }

      public int I_method_d5c3e32d() {
         return this.I_field_a567c40b.getOrDefault("hms-speed", 0);
      }

      public int i_method_d5d26f0d() {
         return this.I_field_a567c40b.getOrDefault("hms-damage", 0);
      }

      public int II_method_e2c77b5a() {
         return this.I_field_a567c40b.getOrDefault("hms-armor", 0);
      }

      public int Ii_method_e2d6073a() {
         return this.I_field_a567c40b.values().stream().max(Integer::compareTo).orElse(0);
      }

      public boolean II_method_e2c77b6b() {
         return this.I_field_523beb0a != null && IiiiiIiii_Class248.I_field_a56a8dc5.contains(this.I_field_523beb0a);
      }

      public boolean Ii_method_e2d6074b() {
         return this.I_field_51ad7227 == IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227;
      }

      public boolean iI_method_e48a6b8b() {
         return this.I_field_51ad7227 == IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227;
      }

      public boolean ii_method_e498f76b() {
         return this.I_field_51ad7227 == IiiiiIiii_Class248.Nested1_95187060.I_field_51ad7227;
      }

      public boolean III_method_7636e8de() {
         return this.I_field_51ad7227 == IiiiiIiii_Class248.Nested1_95187060.Ii_field_51ad7227;
      }

      public String I_method_2310f504(ItemStack var1) {
         if (this.I_field_51ad7227 == IiiiiIiii_Class248.Nested1_95187060.Ii_field_51ad7227) {
            if (this.I_field_523beb0a != null) {
               String var5 = IiiiiIiii_Class248.III_field_a567c40b.get(this.I_field_523beb0a);
               if (var5 != null) {
                  return var5;
               }
            }

            return this.I_field_51ad7227.I_method_f0328486();
         } else if (this.I_field_51ad7227 != IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227
            && this.I_field_51ad7227 != IiiiiIiii_Class248.Nested1_95187060.II_field_51ad7227) {
            if (this.I_field_51ad7227 == IiiiiIiii_Class248.Nested1_95187060.I_field_51ad7227 && this.I_field_523beb0a != null) {
               String var4 = IiiiiIiii_Class248.III_field_a567c40b.get(this.I_field_523beb0a);
               if (var4 != null) {
                  return var4;
               }
            }

            return Iiiiiiiii_Class256.i_method_524c3f7f(var1);
         } else if (this.II_method_e2c77b6b()) {
            return this.I_field_51ad7227.I_method_f0328486() + " " + this.I_field_523beb0a;
         } else if (this.I_field_e400d886 != null) {
            String var3 = this.I_field_51ad7227 == IiiiiIiii_Class248.Nested1_95187060.i_field_51ad7227
               ? this.I_field_e400d886.i_method_97ea4b8f()
               : this.I_field_e400d886.II_method_9a01be70();
            return var3 + " " + this.I_field_51ad7227.I_method_f0328486().toLowerCase();
         } else if (this.I_field_523beb0a != null) {
            String var2 = IiiiiIiii_Class248.III_field_a567c40b.getOrDefault(this.I_field_523beb0a, this.I_field_523beb0a);
            return this.I_field_51ad7227.I_method_f0328486() + " " + var2;
         } else {
            return this.I_field_51ad7227.I_method_f0328486();
         }
      }

      public ColorRGBA I_method_9eebe1a9() {
         if (this.I_field_e400d4a6 != IiiiiIiii_Class248.Nested1_df59be9.I_field_e400d4a6) {
            return null;
         } else {
            if (this.I_field_523beb0a != null) {
               ColorRGBA var1 = IiiiiIiii_Class248.IIi_field_a567c40b.get(this.I_field_523beb0a);
               if (var1 != null) {
                  return var1;
               }
            }

            if (this.I_field_51ad7227 == IiiiiIiii_Class248.Nested1_95187060.Ii_field_51ad7227) {
               return IiiiiIiii_Class248.I_field_d0c8ec5;
            } else if (this.I_field_e400d886 != null) {
               return switch (this.I_field_e400d886) {
                  case i_field_e400d886 -> IiiiiIiii_Class248.Ii_field_d0c8ec5;
                  case II_field_e400d886 -> IiiiiIiii_Class248.i_field_d0c8ec5;
                  case Ii_field_e400d886, iI_field_e400d886 -> IiiiiIiii_Class248.II_field_d0c8ec5;
                  default -> IiiiiIiii_Class248.iI_field_d0c8ec5;
               };
            } else {
               return IiiiiIiii_Class248.iI_field_d0c8ec5;
            }
         }
      }

      public ColorRGBA I_method_40d7118b(ItemStack var1) {
         return this.I_method_9eebe1a9() != null ? this.I_method_9eebe1a9() : Iiiiiiiii_Class256.I_method_81452456(var1.getName());
      }

      public boolean I_method_51483acb(IiiiiIiii_Class248.Nested1_95187080 var1) {
         return var1 == null
            ? false
            : this.I_field_51ad7227 == var1.I_field_51ad7227
               && Objects.equals(this.I_field_523beb0a, var1.I_field_523beb0a)
               && this.I_field_e400d886 == var1.I_field_e400d886;
      }

      @Generated
      public IiiiiIiii_Class248.Nested1_95187060 I_method_7d1d70b() {
         return this.I_field_51ad7227;
      }

      @Generated
      public String I_method_3665aca6() {
         return this.I_field_523beb0a;
      }

      @Generated
      public IiiiiIiii_Class248.Nested1_df59c09 I_method_f2691022() {
         return this.I_field_e400d886;
      }

      @Generated
      public IiiiiIiii_Class248.Nested1_df59be9 I_method_f2690c42() {
         return this.I_field_e400d4a6;
      }

      @Generated
      public Map<String, Integer> I_method_6522c7ef() {
         return this.I_field_a567c40b;
      }
   }

   public static enum Nested1_df59be9 {
      I_field_e400d4a6,
      i_field_e400d4a6,
      II_field_e400d4a6,
      Ii_field_e400d4a6,
      iI_field_e400d4a6,
      ii_field_e400d4a6;
   }

   public static enum Nested1_df59c09 {
      I_field_e400d886("NORMAL", "\u041e\u0431\u044b\u0447\u043d\u0430\u044f", "\u041e\u0431\u044b\u0447\u043d\u044b\u0439"),
      i_field_e400d886("EPIC", "\u042d\u043f\u0438\u0447\u0435\u0441\u043a\u0430\u044f", "\u042d\u043f\u0438\u0447\u0435\u0441\u043a\u0438\u0439"),
      II_field_e400d886(
         "LEGENDARY",
         "\u041b\u0435\u0433\u0435\u043d\u0434\u0430\u0440\u043d\u0430\u044f",
         "\u041b\u0435\u0433\u0435\u043d\u0434\u0430\u0440\u043d\u044b\u0439"
      ),
      Ii_field_e400d886(
         "MYTHICAL", "\u041c\u0438\u0444\u0438\u0447\u0435\u0441\u043a\u0430\u044f", "\u041c\u0438\u0444\u0438\u0447\u0435\u0441\u043a\u0438\u0439"
      ),
      iI_field_e400d886("ETERNITY", "Eternity", "Eternity");

      private final String I_field_523beb0a;
      private final String i_field_523beb0a;
      private final String II_field_523beb0a;

      private Nested1_df59c09(String var3, String var4, String var5) {
         this.I_field_523beb0a = var3;
         this.i_field_523beb0a = var4;
         this.II_field_523beb0a = var5;
      }

      public static IiiiiIiii_Class248.Nested1_df59c09 I_method_6afb2621(String var0) {
         if (var0 == null) {
            return null;
         } else {
            for (IiiiiIiii_Class248.Nested1_df59c09 var4 : values()) {
               if (var4.I_field_523beb0a.equalsIgnoreCase(var0)) {
                  return var4;
               }
            }

            return null;
         }
      }

      @Generated
      public String I_method_4cb9b6f() {
         return this.I_field_523beb0a;
      }

      @Generated
      public String i_method_97ea4b8f() {
         return this.i_field_523beb0a;
      }

      @Generated
      public String II_method_9a01be70() {
         return this.II_field_523beb0a;
      }
   }
}
