package rockstar.client;

import com.ibm.icu.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import lombok.Generated;
import net.minecraft.client.util.InputUtil;
import net.minecraft.text.MutableText;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

public final class iIIIIiIiI_Class267 implements iIIiIIiIi_Class294 {
   private static final String I_field_523beb0a = "[\u2605]";
   private static final List<String> I_field_7865b31 = Arrays.asList(
      "The",
      "Super",
      "Mega",
      "Ultra",
      "Power",
      "Master",
      "Great",
      "Hyper",
      "Quantum",
      "Atomic",
      "Cosmic",
      "Turbo",
      "Mighty",
      "Fantastic",
      "Legendary",
      "Epic",
      "Glorious",
      "Incredible",
      "Marvelous",
      "Supreme",
      "Stellar",
      "Dynamic",
      "Heroic",
      "Valiant",
      "Brave",
      "Noble",
      "Radiant",
      "Brilliant",
      "Bold",
      "Fearless",
      "Fierce",
      "Savage",
      "Infinite",
      "Storm",
      "Thunder",
      "Lightning",
      "Solar",
      "Lunar",
      "Galactic",
      "Nebula",
      "Phoenix",
      "Titan",
      "Colossal",
      "Majestic",
      "Regal",
      "Royal",
      "Sovereign",
      "Auroral",
      "Divine",
      "Ethereal",
      "Fiery",
      "Flaming",
      "Gigahertz",
      "Hypersonic",
      "Infernal",
      "Jovial",
      "Kaleidoscopic",
      "Luminous",
      "Magnetic",
      "Nebulous",
      "Olympian",
      "Pulsar",
      "Quasar",
      "Radiant",
      "Spectral",
      "Stellar",
      "Tachyon",
      "Umbra",
      "Vortex",
      "Warp",
      "Xenon",
      "Yellowstone",
      "Zephyr"
   );
   private static final List<String> i_field_7865b31 = Arrays.asList(
      "Swift",
      "Fierce",
      "Sneaky",
      "Brave",
      "Savage",
      "Fearless",
      "Stealthy",
      "Valiant",
      "Bold",
      "Cunning",
      "Mighty",
      "Noble",
      "Resolute",
      "Vigilant",
      "Relentless",
      "Intrepid",
      "Daring",
      "Gallant",
      "Tenacious",
      "Ferocious",
      "Unyielding",
      "Audacious",
      "Courageous",
      "Indomitable",
      "Dauntless",
      "Unstoppable",
      "Determined",
      "Invincible",
      "Unbreakable",
      "Epic",
      "Legendary",
      "Mythic",
      "Heroic",
      "Glorious",
      "Triumphant",
      "Fearsome",
      "Imposing",
      "Stalwart",
      "Stout",
      "Steadfast",
      "Grim",
      "Resolute",
      "Fateful",
      "Loyal",
      "Trusty",
      "Staunch",
      "Hardy",
      "Doughty",
      "Unflinching",
      "Unfaltering",
      "Brisk",
      "Keen",
      "Alert",
      "Quick",
      "Agile",
      "Nimble",
      "Lithe",
      "Spry",
      "Energetic",
      "Vibrant",
      "Dynamic",
      "Lively",
      "Sprightly",
      "Active",
      "Forceful",
      "Vigorous",
      "Spirited",
      "Animated",
      "Robust",
      "Brawny",
      "Muscular",
      "Husky",
      "Strong",
      "Tough",
      "Solid",
      "Sturdy",
      "Hefty",
      "Powerful",
      "Mighty",
      "Colossal",
      "Gigantic",
      "Mammoth",
      "Titanic",
      "Towering",
      "Massive",
      "Monumental",
      "Heroic",
      "Bravehearted",
      "Gutsy",
      "Doughty",
      "Unyielding",
      "Unwavering",
      "Ironwilled",
      "Strong-willed",
      "Unshakeable",
      "Elfie"
   );
   private static final List<String> II_field_7865b31 = Arrays.asList(
      "Wolf",
      "Tiger",
      "Lion",
      "Eagle",
      "Panther",
      "Dragon",
      "Phoenix",
      "Bear",
      "Leopard",
      "Hawk",
      "Falcon",
      "Cheetah",
      "Jaguar",
      "Griffin",
      "Raven",
      "Fox",
      "Shark",
      "Viper",
      "Cobra",
      "Falcon",
      "Crocodile",
      "Raptor",
      "Condor",
      "Lynx",
      "Ocelot",
      "Cougar",
      "Puma",
      "Hound",
      "Bison",
      "Mammoth",
      "Rhino",
      "Buffalo",
      "Stallion",
      "Mustang",
      "Pegasus",
      "Wyvern",
      "Cerberus",
      "Minotaur",
      "Chimera",
      "Hydra",
      "Kraken",
      "Basilisk",
      "Manticore",
      "Unicorn",
      "Sphinx",
      "Grizzly",
      "Kodiak",
      "Polar Bear",
      "Sabertooth",
      "Direwolf",
      "Orca",
      "Narwhal",
      "Walrus",
      "Beluga",
      "Elephant",
      "Hippo",
      "Gorilla",
      "Orangutan",
      "Chimpanzee",
      "Baboon",
      "Mongoose",
      "Ferret",
      "Weasel",
      "Otter",
      "Badger",
      "Wolverine",
      "Honey Badger",
      "Lizard",
      "Iguana",
      "Gecko",
      "Komodo Dragon",
      "Monitor Lizard",
      "Tortoise",
      "Turtle",
      "Alligator",
      "Caiman",
      "Anaconda",
      "Python",
      "Boa",
      "Eel",
      "Swordfish",
      "Marlin",
      "Barracuda",
      "Piranha",
      "Penguin",
      "Albatross",
      "Seagull",
      "Pelican",
      "Stork",
      "Heron",
      "Flamingo",
      "MasTyp6ek",
      "Tigr",
      "Legacy",
      "Masha"
   );
   private static final List<String> Ii_field_7865b31 = Arrays.asList(
      "Gamer",
      "Player",
      "Ninja",
      "Warrior",
      "Champion",
      "Legend",
      "Hero",
      "Master",
      "Conqueror",
      "Slayer",
      "Guardian",
      "Knight",
      "Paladin",
      "Crusader",
      "Ranger",
      "Assassin",
      "Mage",
      "Sorcerer",
      "Wizard",
      "Enchanter",
      "Necromancer",
      "Berserker",
      "Gladiator",
      "Samurai",
      "Viking",
      "Pirate",
      "Outlaw",
      "Mercenary",
      "Hunter",
      "Scout",
      "Rogue",
      "Thief",
      "Sentinel",
      "Protector",
      "Savior",
      "Defender",
      "Avenger",
      "Warlord",
      "Commander",
      "Captain",
      "General",
      "Marshal",
      "Overlord",
      "Monarch",
      "Emperor",
      "King",
      "Queen",
      "Prince",
      "Princess",
      "Duke",
      "Duchess",
      "Baron",
      "Baroness",
      "Lord",
      "Lady",
      "Warden",
      "Sentinel",
      "Crusader",
      "Champion",
      "Virtuoso",
      "Adept",
      "Prodigy",
      "Savant",
      "Genius",
      "Maven",
      "Whiz",
      "Ace",
      "Virtuoso",
      "Expert",
      "Specialist",
      "Technician",
      "Strategist",
      "Tactician",
      "Operative",
      "Agent",
      "Spy",
      "Infiltrator",
      "Saboteur",
      "Shadow",
      "Phantom",
      "Specter",
      "Shade",
      "Mystic",
      "Seer",
      "Oracle",
      "Prophet",
      "Visionary",
      "Dreamer",
      "Illusionist",
      "Conjurer",
      "Invoker",
      "Diviner",
      "Alchemist",
      "Shaman",
      "Druid",
      "Elementalist",
      "Geomancer",
      "Pyromancer",
      "Hydromancer",
      "Aeromancer",
      "Archon",
      "Brawler",
      "Catalyst",
      "Dynamo",
      "Energizer",
      "Flux",
      "Fusion",
      "Gizmo",
      "Hacker",
      "Innovator",
      "Juggernaut",
      "Kinetix",
      "Luminary",
      "Marauder",
      "Nomad",
      "Operator",
      "Pioneer",
      "Quickshot",
      "Rascal",
      "Slasher",
      "Titan",
      "Umbra",
      "Vanguard",
      "Warden",
      "Pro",
      "Xenon",
      "Yokai",
      "Zealot",
      "Zorro",
      "Zoltar"
   );
   private static final SimpleDateFormat I_field_1527bc0b = new SimpleDateFormat("HH:mm", Locale.getDefault());
   private static final Random I_field_6ece06ac = new Random();
   private static final String i_field_523beb0a = "\u1d00\u0299\u1d04\u1d05\u1d07\u0493\ua730\u0262\u029c\u026a\u1d0a\u1d0b\u029f\u1d0d\u0274\u1d0f\u1d18\ua7af\u01eb\u0280\ua731\u0455\u1d1b\u1d1c\u1d20\u1d21\u1d61\u028f\u1d22";
   private static final String II_field_523beb0a = "ABCDEFFGHIJKLMNOPQQRSSTUVWXYZ";

   public static String I_method_fb167821() {
      String var0 = I_method_f91a2950(I_field_7865b31);
      String var1 = I_method_f91a2950(i_field_7865b31);
      String var2 = I_method_f91a2950(II_field_7865b31);
      String var3 = I_method_f91a2950(Ii_field_7865b31);
      String var4 = I_field_6ece06ac.nextInt(100) < 30 ? String.valueOf(2000 + I_field_6ece06ac.nextInt(26)) : "";
      ArrayList var5 = new ArrayList();
      if (I_field_6ece06ac.nextBoolean()) {
         var5.add(var0);
      }

      if (I_field_6ece06ac.nextBoolean()) {
         var5.add(var1);
      }

      if (I_field_6ece06ac.nextBoolean()) {
         var5.add(var2);
      }

      if (I_field_6ece06ac.nextBoolean()) {
         var5.add(var3);
      }

      if (var5.isEmpty()) {
         var5.add(var0);
      }

      if (var5.size() < 2) {
         var5.add(I_field_6ece06ac.nextBoolean() ? var1 : var2);
      }

      String var6 = String.join("", var5) + var4;
      if (I_field_6ece06ac.nextInt(100) < 20) {
         var6 = var6 + (I_field_6ece06ac.nextBoolean() ? "52" : "69");
      } else {
         var6 = var6 + i_method_79eec87c(2 + I_field_6ece06ac.nextInt(3));
      }

      if (var6.length() > 16) {
         var6 = var6.substring(var6.length() - 16);
      }

      return var6;
   }

   public static String I_method_230e44c1(double var0) {
      if (var0 == (int)var0) {
         return String.valueOf((int)var0);
      } else {
         String var2 = String.format("%.2f", var0).replace(",", ".").replaceAll("\\.?0+$", "");
         return var2.endsWith(".") ? var2.replace(".", "") : var2;
      }
   }

   public static String i_method_f3c598a1(double var0) {
      return String.format("%.1f", var0).replace(",", ".");
   }

   private static String I_method_f91a2950(List<String> var0) {
      return (String)var0.get(I_field_6ece06ac.nextInt(var0.size()));
   }

   private static String i_method_79eec87c(int var0) {
      StringBuilder var1 = new StringBuilder();

      for (int var2 = 0; var2 < var0; var2++) {
         var1.append(I_field_6ece06ac.nextInt(10));
      }

      return var1.toString();
   }

   public static String I_method_c7255d57(String var0) {
      if (var0.endsWith("\u0430")) {
         return "\u0430";
      } else if (var0.endsWith("a")) {
         return "\u0430";
      } else if (var0.endsWith("y")) {
         return "\u043e";
      } else if (var0.endsWith("\u044e")) {
         return "o";
      } else if (var0.endsWith("u")) {
         return "o";
      } else if (var0.endsWith("\u044f")) {
         return "\u0430";
      } else if (var0.endsWith("\u044b")) {
         return "\u044b";
      } else {
         return var0.endsWith("\u0438") ? "\u044b" : "";
      }
   }

   public static String I_method_f251f17f(float var0) {
      double var1 = Math.abs(var0);
      long var3 = (long)Math.floor(var1);
      double var5 = var1 - var3;
      if (var5 > 1.0E-9) {
         return "\u0430";
      } else {
         int var7 = (int)(var3 % 100L);
         if (var7 >= 11 && var7 <= 14) {
            return "\u043e\u0432";
         } else {
            return switch (var7 % 10) {
               case 1 -> "";
               case 2, 3, 4 -> "\u0430";
               default -> "\u043e\u0432";
            };
         }
      }
   }

   public static String i_method_c309455f(float var0) {
      IiIIiiii_Class80 var1 = IiIiIIII_Class81.I_method_21a4cfeb();

      return switch (var1) {
         case i_field_3f56db61 -> II_method_bfd5ed42(var0);
         case II_field_3f56db61 -> Ii_method_908d4122(var0);
         case Ii_field_3f56db61 -> iI_method_6091562(var0);
         case I_field_3f56db61 -> ii_method_d6c06942(var0);
      };
   }

   private static String II_method_bfd5ed42(float var0) {
      double var1 = Math.abs(var0);
      long var3 = (long)Math.floor(var1);
      double var5 = var1 - var3;
      if (var5 > 1.0E-9) {
         return "\u0430";
      } else {
         int var7 = (int)(var3 % 100L);
         if (var7 >= 11 && var7 <= 14) {
            return "\u043e\u0432";
         } else {
            return switch (var7 % 10) {
               case 1 -> "";
               case 2, 3, 4 -> "\u0430";
               default -> "\u043e\u0432";
            };
         }
      }
   }

   private static String Ii_method_908d4122(float var0) {
      double var1 = Math.abs(var0);
      long var3 = (long)Math.floor(var1);
      double var5 = var1 - var3;
      if (var5 > 1.0E-9) {
         return "\u0438";
      } else {
         int var7 = (int)(var3 % 100L);
         if (var7 >= 11 && var7 <= 14) {
            return "\u0456\u0432";
         } else {
            return switch (var7 % 10) {
               case 1 -> "";
               case 2, 3, 4 -> "\u0438";
               default -> "\u0456\u0432";
            };
         }
      }
   }

   private static String iI_method_6091562(float var0) {
      double var1 = Math.abs(var0);
      long var3 = (long)Math.floor(var1);
      double var5 = var1 - var3;
      if (var5 > 1.0E-9) {
         return "y";
      } else if (var3 == 1L) {
         return "";
      } else {
         return var3 >= 2L && var3 <= 4L ? "y" : "\u00f3w";
      }
   }

   private static String ii_method_d6c06942(float var0) {
      double var1 = Math.abs(var0);
      return var1 == 1.0 ? "" : "s";
   }

   public static String I_method_a937749c(int var0) {
      return iIIIIIIII_Class257.I_method_f90bbc5c(iIIIIIIII_Class257.i_method_69d48d7(var0)) + II_method_76bb705f(iIIIIIIII_Class257.I_method_4da58b7(var0));
   }

   private static String II_method_76bb705f(int var0) {
      if (var0 >= 0 && var0 <= 7) {
         return switch (var0) {
            case 0 -> IiIiIIII_Class81.I_method_f25a980a("mouse.lmb");
            case 1 -> IiIiIIII_Class81.I_method_f25a980a("mouse.rmb");
            case 2 -> IiIiIIII_Class81.I_method_f25a980a("mouse.mmb");
            case 3 -> "MOUSE4";
            case 4 -> "MOUSE5";
            case 5 -> "MOUSE6";
            case 6 -> "MOUSE7";
            case 7 -> "MOUSE8";
            default -> "MOUSE" + var0;
         };
      } else if (var0 <= -1) {
         return "NONE";
      } else {
         String var1 = InputUtil.fromKeyCode(var0, -1).getTranslationKey();
         var1 = var1.replace("key.keyboard.", "")
            .replace("key.", "")
            .replace(".", "")
            .replace("left", "l")
            .replace("right", "r")
            .replace("apostrophe", "apost")
            .replace("printscreen", "prtsc")
            .replace("graveaccent", "grave")
            .replace("control", "ctrl");
         return var1.toUpperCase();
      }
   }

   public static String i_method_8e352841() {
      return I_field_1527bc0b.format(new Date());
   }

   public static String II_method_6d1277fe() {
      LocalDate var0 = LocalDate.now();
      String[] var1 = new String[]{
         "time.days.monday", "time.days.tuesday", "time.days.wednesday", "time.days.thursday", "time.days.friday", "time.days.saturday", "time.days.sunday"
      };
      String[] var2 = new String[]{
         "time.months.january",
         "time.months.february",
         "time.months.march",
         "time.months.april",
         "time.months.may",
         "time.months.june",
         "time.months.july",
         "time.months.august",
         "time.months.september",
         "time.months.october",
         "time.months.november",
         "time.months.december"
      };
      DayOfWeek var3 = var0.getDayOfWeek();
      String var4 = IiIiIIII_Class81.I_method_f25a980a(var1[var3.getValue() - 1]);
      int var5 = var0.getDayOfMonth();
      Month var6 = var0.getMonth();
      String var7 = IiIiIIII_Class81.I_method_f25a980a(var2[var6.getValue() - 1]);
      return String.format("%s, %d %s", var4, var5, var7);
   }

   public static void I_method_c791669(String var0) {
      I_field_3a9bda27.keyboard.setClipboard(var0);
   }

   public static String i_method_e7444577(String var0) {
      if (var0 != null && !var0.isEmpty()) {
         StringBuilder var1 = new StringBuilder(var0.length());
         int var2 = 0;
         boolean var3 = false;

         for (int var4 = 0; var4 <= var0.length(); var4++) {
            if (var4 != var0.length() && !Character.isWhitespace(var0.charAt(var4))) {
               char var7 = var0.charAt(var4);
               int var6 = "\u1d00\u0299\u1d04\u1d05\u1d07\u0493\ua730\u0262\u029c\u026a\u1d0a\u1d0b\u029f\u1d0d\u0274\u1d0f\u1d18\ua7af\u01eb\u0280\ua731\u0455\u1d1b\u1d1c\u1d20\u1d21\u1d61\u028f\u1d22"
                  .indexOf(var7);
               if (var6 < 0) {
                  var1.append(var7);
               } else {
                  var1.append("ABCDEFFGHIJKLMNOPQQRSSTUVWXYZ".charAt(var6));
                  var3 = true;
               }
            } else {
               if (var3) {
                  for (int var5 = var2; var5 < var1.length(); var5++) {
                     var1.setCharAt(var5, Character.toUpperCase(var1.charAt(var5)));
                  }
               }

               if (var4 < var0.length()) {
                  var1.append(var0.charAt(var4));
               }

               var2 = var1.length();
               var3 = false;
            }
         }

         return var1.toString();
      } else {
         return "";
      }
   }

   public static MutableText I_method_29fdec38(Text var0, IIiiii_Class16 var1) {
      if (var0 == null) {
         return Text.empty();
      } else {
         StringBuilder var2 = new StringBuilder();
         ArrayList var3 = new ArrayList();
         BitSet var4 = new BitSet();
         var0.visit((var3x, var4x) -> {
            var4x.codePoints().forEach(var4xx -> {
               String var5x = IIiiIi_Class14.I_method_4201b49(var4xx);
               if (var5x != null) {
                  boolean var6x = IIiiIi_Class14.I_method_ab732e3b(var4xx);
                  var4.set(var2.length(), var2.length() + var5x.length());

                  for (int var7x = 0; var7x < var5x.length(); var7x++) {
                     var2.append(var5x.charAt(var7x));
                     var3.add(var6x ? var3x.withColor(IIiiIi_Class14.I_method_7b38064d(var4xx, var7x, var5x.length(), 1.0F, 0) & 16777215) : var3x);
                  }
               } else {
                  var2.appendCodePoint(var4xx);

                  while (var3.size() < var2.length()) {
                     var3.add(var3x);
                  }
               }
            });
            return Optional.empty();
         }, Style.EMPTY);
         int var5 = 0;

         for (int var6 = 0; var5 <= var2.length(); var5++) {
            if (var5 >= var2.length() || Character.isWhitespace(var2.charAt(var5))) {
               int var7 = var4.nextSetBit(var6);
               if (var7 >= 0 && var7 < var5) {
                  for (int var8 = var6; var8 < var5; var8++) {
                     var2.setCharAt(var8, Character.toUpperCase(var2.charAt(var8)));
                  }
               }

               var6 = var5 + 1;
            }
         }

         StringBuilder var11 = new StringBuilder();
         ArrayList var12 = new ArrayList();
         boolean var13 = var1 != null && var1.I_method_a798b395('a');

         for (int var14 = 0; var14 < var2.length(); var14++) {
            char var9 = var2.charAt(var14);
            char var10 = var11.isEmpty() ? 0 : var11.charAt(var11.length() - 1);
            if (var9 == 167) {
               var14++;
            } else if ((var9 != ' ' || var10 != 0 && var10 != ' ') && (var9 == ' ' || !var13 || var1.I_method_a798b395(var9))) {
               if (var9 == ']' && var10 == '[') {
                  var11.deleteCharAt(var11.length() - 1);
                  var12.removeLast();
               } else {
                  var11.append(var9);
                  var12.add((Style)var3.get(var14));
               }
            }
         }

         while (!var11.isEmpty() && var11.charAt(var11.length() - 1) == ' ') {
            var11.deleteCharAt(var11.length() - 1);
            var12.removeLast();
         }

         MutableText var15 = Text.empty();
         int var16 = 0;

         for (int var17 = 1; var17 <= var11.length(); var17++) {
            if (var17 >= var11.length() || !((Style)var12.get(var17)).equals(var12.get(var16))) {
               var15.append(Text.literal(var11.substring(var16, var17)).setStyle((Style)var12.get(var16)));
               var16 = var17;
            }
         }

         return var15;
      }
   }

   public static MutableText I_method_a6472357(String var0) {
      if (var0.startsWith("[\u2605]")) {
         String var1 = var0.substring("[\u2605]".length());
         MutableText var2 = Text.literal("[\u2605]").formatted(Formatting.RED);
         MutableText var3 = Text.literal(var1).formatted(Formatting.GOLD);
         return Text.literal("").append(var2).append(var3);
      } else {
         return Text.literal(var0);
      }
   }

   @Generated
   private iIIIIiIiI_Class267() {
      throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
   }
}
