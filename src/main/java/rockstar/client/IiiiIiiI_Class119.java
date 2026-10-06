package rockstar.client;

import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.function.Function;
import lombok.Generated;
import net.minecraft.entity.Entity;

public abstract class IiiiIiiI_Class119 implements IIiiiIIiI_Class115, iIIiIIiIi_Class294, iIIiIIiiI_Class295 {
   private final String I_field_523beb0a;
   private final Set<IiiiiIiI_Class123> I_field_a56a8dc5;
   private final Set<IiiiiIII_Class121> i_field_a56a8dc5;
   private final Set<IiiiIiii_Class120> II_field_a56a8dc5;
   private final List<Setting> I_field_7865b31 = new ArrayList<>();
   private final Map<IiiiiIiI_Class123, BooleanSetting> I_field_a567c40b = new HashMap<>();
   private final Map<IiiiiIII_Class121, BooleanSetting> i_field_a567c40b = new HashMap<>();
   private final Map<IiiiIiii_Class120, BooleanSetting> II_field_a567c40b = new HashMap<>();
   private final Map<IiiiiIiI_Class123, KeybindSetting> Ii_field_a567c40b = new HashMap<>();
   private final Map<IiiiiIII_Class121, KeybindSetting> iI_field_a567c40b = new HashMap<>();
   private final Map<IiiiIiii_Class120, KeybindSetting> ii_field_a567c40b = new HashMap<>();
   private final Map<Setting, Set<IiiiiIiI_Class123>> III_field_a567c40b = new HashMap<>();
   private final Map<String, Map<IiiiiIiI_Class123, Setting>> IIi_field_a567c40b = new LinkedHashMap<>();
   private final Map<String, Map<IiiiiIII_Class121, Setting>> IiI_field_a567c40b = new LinkedHashMap<>();
   private final Map<String, Map<IiiiIiii_Class120, Setting>> Iii_field_a567c40b = new LinkedHashMap<>();

   protected IiiiIiiI_Class119(String var1, IiiiiIiI_Class123... var2) {
      this(var1, new IiiiIiii_Class120[0], var2);
   }

   protected IiiiIiiI_Class119(String var1, IiiiIiii_Class120[] var2, IiiiiIiI_Class123... var3) {
      this.I_field_523beb0a = var1;
      this.I_field_a56a8dc5 = var3.length > 0 ? new LinkedHashSet<>(Arrays.asList(var3)) : new LinkedHashSet<>(Arrays.asList(IiiiiIiI_Class123.values()));
      this.i_field_a56a8dc5 = this.I_field_a56a8dc5.contains(IiiiiIiI_Class123.I_field_12aac7a1)
         ? new LinkedHashSet<>(Arrays.asList(IiiiiIII_Class121.values()))
         : new LinkedHashSet<>();
      this.II_field_a56a8dc5 = this.I_field_a56a8dc5.contains(IiiiiIiI_Class123.Ii_field_12aac7a1) && var2.length > 0
         ? new LinkedHashSet<>(Arrays.asList(var2))
         : new LinkedHashSet<>();
   }

   protected BooleanSetting I_method_5436696c(String var1) {
      BooleanSetting var2 = null;

      for (IiiiiIiI_Class123 var4 : this.I_field_a56a8dc5) {
         if (var4 == IiiiiIiI_Class123.I_field_12aac7a1) {
            for (IiiiiIII_Class121 var12 : this.i_field_a56a8dc5) {
               BooleanSetting var13 = new BooleanSetting(this, var1);
               KeybindSetting var14 = new KeybindSetting(this, var1 + ".bind");
               this.i_field_a567c40b.put(var12, var13);
               this.iI_field_a567c40b.put(var12, var14);
               if (var2 == null) {
                  var2 = var13;
               }
            }
         } else if (var4 == IiiiiIiI_Class123.Ii_field_12aac7a1 && !this.II_field_a56a8dc5.isEmpty()) {
            for (IiiiIiii_Class120 var11 : this.II_field_a56a8dc5) {
               BooleanSetting var7 = new BooleanSetting(this, var1);
               KeybindSetting var8 = new KeybindSetting(this, var1 + ".bind");
               this.II_field_a567c40b.put(var11, var7);
               this.ii_field_a567c40b.put(var11, var8);
               if (var2 == null) {
                  var2 = var7;
               }
            }
         } else {
            BooleanSetting var5 = new BooleanSetting(this, var1);
            KeybindSetting var6 = new KeybindSetting(this, var1 + ".bind");
            this.I_field_a567c40b.put(var4, var5);
            this.Ii_field_a567c40b.put(var4, var6);
            if (var2 == null) {
               var2 = var5;
            }
         }
      }

      return var2;
   }

   protected void I_method_54b913ca(IiiiiIiI_Class123... var1) {
      for (IiiiiIiI_Class123 var5 : var1) {
         BooleanSetting var6 = this.I_field_a567c40b.get(var5);
         if (var6 != null) {
            var6.I_method_decd82b5();
         }
      }
   }

   protected void I_method_52f623aa(IiiiiIII_Class121... var1) {
      for (IiiiiIII_Class121 var5 : var1) {
         BooleanSetting var6 = this.i_field_a567c40b.get(var5);
         if (var6 != null) {
            var6.I_method_decd82b5();
         }
      }
   }

   protected void I_method_ee9b4b6a(IiiiIiii_Class120... var1) {
      for (IiiiIiii_Class120 var5 : var1) {
         BooleanSetting var6 = this.II_field_a567c40b.get(var5);
         if (var6 != null) {
            var6.I_method_decd82b5();
         }
      }
   }

   protected <T extends Setting> T I_method_ceb388bc(Function<IiiiIiiI_Class119, T> var1) {
      Setting var2 = null;
      HashMap var3 = new HashMap();
      HashMap var4 = new HashMap();
      HashMap var5 = new HashMap();

      for (IiiiiIiI_Class123 var7 : this.I_field_a56a8dc5) {
         if (var7 == IiiiiIiI_Class123.I_field_12aac7a1) {
            for (IiiiiIII_Class121 var14 : this.i_field_a56a8dc5) {
               Setting var15 = (Setting)var1.apply(this);
               var4.put(var14, var15);
               if (var2 == null) {
                  var2 = var15;
               }
            }
         } else if (var7 == IiiiiIiI_Class123.Ii_field_12aac7a1 && !this.II_field_a56a8dc5.isEmpty()) {
            for (IiiiIiii_Class120 var9 : this.II_field_a56a8dc5) {
               Setting var10 = (Setting)var1.apply(this);
               var5.put(var9, var10);
               if (var2 == null) {
                  var2 = var10;
               }
            }
         } else {
            Setting var8 = (Setting)var1.apply(this);
            var3.put(var7, var8);
            if (var2 == null) {
               var2 = var8;
            }
         }
      }

      String var11 = var2 != null ? var2.getName() : "";
      this.IIi_field_a567c40b.put(var11, var3);
      this.IiI_field_a567c40b.put(var11, var4);
      this.Iii_field_a567c40b.put(var11, var5);
      return (T)var2;
   }

   protected <T extends Setting> T I_method_61f9c255(IiiiIiiI_Class119.Nested1_2edc91d6<T> var1) {
      Setting var2 = null;
      HashMap var3 = new HashMap();
      HashMap var4 = new HashMap();
      HashMap var5 = new HashMap();

      for (IiiiiIiI_Class123 var7 : this.I_field_a56a8dc5) {
         if (var7 == IiiiiIiI_Class123.I_field_12aac7a1) {
            for (IiiiiIII_Class121 var16 : this.i_field_a56a8dc5) {
               BooleanSetting var17 = this.i_field_a567c40b.get(var16);
               Setting var18 = var1.create(this, var17);
               var4.put(var16, var18);
               if (var2 == null) {
                  var2 = var18;
               }
            }
         } else if (var7 == IiiiiIiI_Class123.Ii_field_12aac7a1 && !this.II_field_a56a8dc5.isEmpty()) {
            for (IiiiIiii_Class120 var15 : this.II_field_a56a8dc5) {
               BooleanSetting var10 = this.II_field_a567c40b.get(var15);
               Setting var11 = var1.create(this, var10);
               var5.put(var15, var11);
               if (var2 == null) {
                  var2 = var11;
               }
            }
         } else {
            BooleanSetting var8 = this.I_field_a567c40b.get(var7);
            Setting var9 = var1.create(this, var8);
            var3.put(var7, var9);
            if (var2 == null) {
               var2 = var9;
            }
         }
      }

      String var12 = var2 != null ? var2.getName() : "";
      this.IIi_field_a567c40b.put(var12, var3);
      this.IiI_field_a567c40b.put(var12, var4);
      this.Iii_field_a567c40b.put(var12, var5);
      return (T)var2;
   }

   protected <T extends Setting> T I_method_96c36dc8(String var1, IiiiIiiI_Class119.Nested1_9c50d13<T> var2) {
      Setting var3 = null;
      HashMap var4 = new HashMap();
      HashMap var5 = new HashMap();
      HashMap var6 = new HashMap();

      for (IiiiiIiI_Class123 var8 : this.I_field_a56a8dc5) {
         if (var8 == IiiiiIiI_Class123.I_field_12aac7a1) {
            for (IiiiiIII_Class121 var18 : this.i_field_a56a8dc5) {
               BooleanSetting var20 = this.i_field_a567c40b.get(var18);
               BooleanSetting var21 = this.I_method_62f3944d(var1, var18);
               Setting var22 = var2.create(this, var20, var21);
               var5.put(var18, var22);
               if (var3 == null) {
                  var3 = var22;
               }
            }
         } else if (var8 == IiiiiIiI_Class123.Ii_field_12aac7a1 && !this.II_field_a56a8dc5.isEmpty()) {
            for (IiiiIiii_Class120 var17 : this.II_field_a56a8dc5) {
               BooleanSetting var19 = this.II_field_a567c40b.get(var17);
               BooleanSetting var12 = this.I_method_60b28c0d(var1, var17);
               Setting var13 = var2.create(this, var19, var12);
               var6.put(var17, var13);
               if (var3 == null) {
                  var3 = var13;
               }
            }
         } else {
            BooleanSetting var9 = this.I_field_a567c40b.get(var8);
            BooleanSetting var10 = this.I_method_c9c6d(var1, var8);
            Setting var11 = var2.create(this, var9, var10);
            var4.put(var8, var11);
            if (var3 == null) {
               var3 = var11;
            }
         }
      }

      String var14 = var3 != null ? var3.getName() : "";
      this.IIi_field_a567c40b.put(var14, var4);
      this.IiI_field_a567c40b.put(var14, var5);
      this.Iii_field_a567c40b.put(var14, var6);
      return (T)var3;
   }

   protected <T extends Setting> T I_method_e97d5695(IiiiIiiI_Class119.Nested1_2edc9596<T> var1) {
      Setting var2 = null;
      HashMap var3 = new HashMap();
      HashMap var4 = new HashMap();
      HashMap var5 = new HashMap();

      for (IiiiiIiI_Class123 var7 : this.I_field_a56a8dc5) {
         if (var7 == IiiiiIiI_Class123.I_field_12aac7a1) {
            for (IiiiiIII_Class121 var16 : this.i_field_a56a8dc5) {
               BooleanSetting var17 = this.i_field_a567c40b.get(var16);
               Setting var18 = var1.create(this, var17, IiiiiIiI_Class123.I_field_12aac7a1);
               var4.put(var16, var18);
               if (var2 == null) {
                  var2 = var18;
               }
            }
         } else if (var7 == IiiiiIiI_Class123.Ii_field_12aac7a1 && !this.II_field_a56a8dc5.isEmpty()) {
            for (IiiiIiii_Class120 var15 : this.II_field_a56a8dc5) {
               BooleanSetting var10 = this.II_field_a567c40b.get(var15);
               Setting var11 = var1.create(this, var10, IiiiiIiI_Class123.Ii_field_12aac7a1);
               var5.put(var15, var11);
               if (var2 == null) {
                  var2 = var11;
               }
            }
         } else {
            BooleanSetting var8 = this.I_field_a567c40b.get(var7);
            Setting var9 = var1.create(this, var8, var7);
            var3.put(var7, var9);
            if (var2 == null) {
               var2 = var9;
            }
         }
      }

      String var12 = var2 != null ? var2.getName() : "";
      this.IIi_field_a567c40b.put(var12, var3);
      this.IiI_field_a567c40b.put(var12, var4);
      this.Iii_field_a567c40b.put(var12, var5);
      return (T)var2;
   }

   protected <T extends Setting> T I_method_492d23d7(String var1, String var2, String var3, IiiiIiiI_Class119.Nested1_2edc91b6<T> var4) {
      Setting var5 = null;
      HashMap var6 = new HashMap();
      HashMap var7 = new HashMap();
      HashMap var8 = new HashMap();

      for (IiiiiIiI_Class123 var10 : this.I_field_a56a8dc5) {
         if (var10 == IiiiiIiI_Class123.I_field_12aac7a1) {
            for (IiiiiIII_Class121 var22 : this.i_field_a56a8dc5) {
               BooleanSetting var24 = this.i_field_a567c40b.get(var22);
               BooleanSetting var26 = this.I_method_62f3944d(var1, var22);
               BooleanSetting var28 = this.I_method_62f3944d(var2, var22);
               BooleanSetting var29 = this.I_method_62f3944d(var3, var22);
               Setting var30 = var4.create(this, var24, var26, var28, var29);
               var7.put(var22, var30);
               if (var5 == null) {
                  var5 = var30;
               }
            }
         } else if (var10 == IiiiiIiI_Class123.Ii_field_12aac7a1 && !this.II_field_a56a8dc5.isEmpty()) {
            for (IiiiIiii_Class120 var21 : this.II_field_a56a8dc5) {
               BooleanSetting var23 = this.II_field_a567c40b.get(var21);
               BooleanSetting var25 = this.I_method_60b28c0d(var1, var21);
               BooleanSetting var27 = this.I_method_60b28c0d(var2, var21);
               BooleanSetting var16 = this.I_method_60b28c0d(var3, var21);
               Setting var17 = var4.create(this, var23, var25, var27, var16);
               var8.put(var21, var17);
               if (var5 == null) {
                  var5 = var17;
               }
            }
         } else {
            BooleanSetting var11 = this.I_field_a567c40b.get(var10);
            BooleanSetting var12 = this.I_method_c9c6d(var1, var10);
            BooleanSetting var13 = this.I_method_c9c6d(var2, var10);
            BooleanSetting var14 = this.I_method_c9c6d(var3, var10);
            Setting var15 = var4.create(this, var11, var12, var13, var14);
            var6.put(var10, var15);
            if (var5 == null) {
               var5 = var15;
            }
         }
      }

      String var18 = var5 != null ? var5.getName() : "";
      this.IIi_field_a567c40b.put(var18, var6);
      this.IiI_field_a567c40b.put(var18, var7);
      this.Iii_field_a567c40b.put(var18, var8);
      return (T)var5;
   }

   protected <T extends Setting> T I_method_e0ef16b2(String var1, String var2, IiiiIiiI_Class119.Nested1_9c50cf3<T> var3) {
      Setting var4 = null;
      HashMap var5 = new HashMap();
      HashMap var6 = new HashMap();
      HashMap var7 = new HashMap();

      for (IiiiiIiI_Class123 var9 : this.I_field_a56a8dc5) {
         if (var9 == IiiiiIiI_Class123.I_field_12aac7a1) {
            for (IiiiiIII_Class121 var20 : this.i_field_a56a8dc5) {
               BooleanSetting var22 = this.i_field_a567c40b.get(var20);
               BooleanSetting var24 = this.I_method_62f3944d(var1, var20);
               BooleanSetting var25 = this.I_method_62f3944d(var2, var20);
               Setting var26 = var3.create(this, var22, var24, var25);
               var6.put(var20, var26);
               if (var4 == null) {
                  var4 = var26;
               }
            }
         } else if (var9 == IiiiiIiI_Class123.Ii_field_12aac7a1 && !this.II_field_a56a8dc5.isEmpty()) {
            for (IiiiIiii_Class120 var19 : this.II_field_a56a8dc5) {
               BooleanSetting var21 = this.II_field_a567c40b.get(var19);
               BooleanSetting var23 = this.I_method_60b28c0d(var1, var19);
               BooleanSetting var14 = this.I_method_60b28c0d(var2, var19);
               Setting var15 = var3.create(this, var21, var23, var14);
               var7.put(var19, var15);
               if (var4 == null) {
                  var4 = var15;
               }
            }
         } else {
            BooleanSetting var10 = this.I_field_a567c40b.get(var9);
            BooleanSetting var11 = this.I_method_c9c6d(var1, var9);
            BooleanSetting var12 = this.I_method_c9c6d(var2, var9);
            Setting var13 = var3.create(this, var10, var11, var12);
            var5.put(var9, var13);
            if (var4 == null) {
               var4 = var13;
            }
         }
      }

      String var16 = var4 != null ? var4.getName() : "";
      this.IIi_field_a567c40b.put(var16, var5);
      this.IiI_field_a567c40b.put(var16, var6);
      this.Iii_field_a567c40b.put(var16, var7);
      return (T)var4;
   }

   protected <T extends Setting> T I_method_db5556b2(String var1, Function<BooleanSetting, T> var2) {
      Setting var3 = null;
      HashMap var4 = new HashMap();
      HashMap var5 = new HashMap();
      HashMap var6 = new HashMap();

      for (IiiiiIiI_Class123 var8 : this.I_field_a56a8dc5) {
         if (var8 == IiiiiIiI_Class123.I_field_12aac7a1) {
            for (IiiiiIII_Class121 var17 : this.i_field_a56a8dc5) {
               BooleanSetting var18 = this.I_method_62f3944d(var1, var17);
               Setting var19 = (Setting)var2.apply(var18);
               var5.put(var17, var19);
               if (var3 == null) {
                  var3 = var19;
               }
            }
         } else if (var8 == IiiiiIiI_Class123.Ii_field_12aac7a1 && !this.II_field_a56a8dc5.isEmpty()) {
            for (IiiiIiii_Class120 var16 : this.II_field_a56a8dc5) {
               BooleanSetting var11 = this.I_method_60b28c0d(var1, var16);
               Setting var12 = (Setting)var2.apply(var11);
               var6.put(var16, var12);
               if (var3 == null) {
                  var3 = var12;
               }
            }
         } else {
            BooleanSetting var9 = this.I_method_c9c6d(var1, var8);
            Setting var10 = (Setting)var2.apply(var9);
            var4.put(var8, var10);
            if (var3 == null) {
               var3 = var10;
            }
         }
      }

      String var13 = var3 != null ? var3.getName() : "";
      this.IIi_field_a567c40b.put(var13, var4);
      this.IiI_field_a567c40b.put(var13, var5);
      this.Iii_field_a567c40b.put(var13, var6);
      return (T)var3;
   }

   protected <T extends Setting> T i_method_e56d20dc(Function<IiiiIiiI_Class119, T> var1) {
      Setting var2 = null;
      HashMap var3 = new HashMap();

      for (IiiiiIII_Class121 var5 : this.i_field_a56a8dc5) {
         Setting var6 = (Setting)var1.apply(this);
         var3.put(var5, var6);
         if (var2 == null) {
            var2 = var6;
         }
      }

      String var7 = var2 != null ? var2.getName() : "";
      this.IiI_field_a567c40b.put(var7, var3);
      return (T)var2;
   }

   public <T extends Setting> T I_method_c9c6d(String var1, IiiiiIiI_Class123 var2) {
      Map var3 = this.IIi_field_a567c40b.get(var1);
      return (T)(var3 != null ? var3.get(var2) : null);
   }

   public <T extends Setting> T I_method_62f3944d(String var1, IiiiiIII_Class121 var2) {
      Map var3 = this.IiI_field_a567c40b.get(var1);
      return (T)(var3 != null ? var3.get(var2) : null);
   }

   public <T extends Setting> T I_method_60b28c0d(String var1, IiiiIiii_Class120 var2) {
      Map var3 = this.Iii_field_a567c40b.get(var1);
      return (T)(var3 != null ? var3.get(var2) : null);
   }

   protected void I_method_1b2c55bc(Setting var1, IiiiiIiI_Class123... var2) {
      this.III_field_a567c40b.put(var1, new HashSet<>(Arrays.asList(var2)));
   }

   public void I_method_ea8b70ac() {
      RockstarClient.getInstance().I_method_7897deab().I_method_2257cd48(this);
   }

   public boolean I_method_bcf84b51(IiiiiIiI_Class123 var1) {
      return this.I_field_a56a8dc5.contains(var1);
   }

   public boolean I_method_bb355b31(IiiiiIII_Class121 var1) {
      return this.i_field_a56a8dc5.contains(var1);
   }

   public boolean I_method_56da82f1(IiiiIiii_Class120 var1) {
      return this.II_field_a56a8dc5.contains(var1);
   }

   public boolean i_method_d28dbf31(IiiiiIiI_Class123 var1) {
      if (!IiiiiiiI_Class127.I_method_731950d0()) {
         return false;
      } else {
         BooleanSetting var2 = this.I_field_a567c40b.get(var1);
         return var2 != null && var2.i_method_9b12da03();
      }
   }

   public boolean i_method_d0cacf11(IiiiiIII_Class121 var1) {
      if (!IiiiiiiI_Class127.I_method_731950d0()) {
         return false;
      } else {
         BooleanSetting var2 = this.i_field_a567c40b.get(var1);
         return var2 != null && var2.i_method_9b12da03();
      }
   }

   public boolean i_method_6c6ff6d1(IiiiIiii_Class120 var1) {
      if (!IiiiiiiI_Class127.I_method_731950d0()) {
         return false;
      } else {
         BooleanSetting var2 = this.II_field_a567c40b.get(var1);
         return var2 != null && var2.i_method_9b12da03();
      }
   }

   public boolean I_method_ea8b70b0() {
      if (!IiiiiiiI_Class127.I_method_731950d0()) {
         return false;
      } else {
         for (BooleanSetting var2 : this.I_field_a567c40b.values()) {
            if (var2.i_method_9b12da03()) {
               return true;
            }
         }

         for (BooleanSetting var5 : this.i_field_a567c40b.values()) {
            if (var5.i_method_9b12da03()) {
               return true;
            }
         }

         for (BooleanSetting var6 : this.II_field_a567c40b.values()) {
            if (var6.i_method_9b12da03()) {
               return true;
            }
         }

         return false;
      }
   }

   public void I_method_d9976c2e(III var1, Entity var2, float var3, float var4, IiiiiIiI_Class123 var5, IiiiiIII_Class121 var6) {
   }

   public BooleanSetting I_method_6d27be83(IiiiiIiI_Class123 var1) {
      return this.I_field_a567c40b.get(var1);
   }

   public BooleanSetting I_method_d00eb663(IiiiiIII_Class121 var1) {
      return this.i_field_a567c40b.get(var1);
   }

   public BooleanSetting I_method_cdcdae23(IiiiIiii_Class120 var1) {
      return this.II_field_a567c40b.get(var1);
   }

   public KeybindSetting I_method_6d274663(IiiiiIiI_Class123 var1) {
      return this.Ii_field_a567c40b.get(var1);
   }

   public KeybindSetting I_method_d00e3e43(IiiiiIII_Class121 var1) {
      return this.iI_field_a567c40b.get(var1);
   }

   public KeybindSetting I_method_cdcd3603(IiiiIiii_Class120 var1) {
      return this.ii_field_a567c40b.get(var1);
   }

   public boolean I_method_66e317db(int var1) {
      boolean var2 = false;

      for (Entry var4 : this.Ii_field_a567c40b.entrySet()) {
         BooleanSetting var5 = this.I_field_a567c40b.get(var4.getKey());
         if (var5 != null && ((KeybindSetting)var4.getValue()).I_method_51ee2d08(var1)) {
            var5.toggle();
            var2 = true;
         }
      }

      for (Entry var8 : this.iI_field_a567c40b.entrySet()) {
         BooleanSetting var10 = this.i_field_a567c40b.get(var8.getKey());
         if (var10 != null && ((KeybindSetting)var8.getValue()).I_method_51ee2d08(var1)) {
            var10.toggle();
            var2 = true;
         }
      }

      for (Entry var9 : this.ii_field_a567c40b.entrySet()) {
         BooleanSetting var11 = this.II_field_a567c40b.get(var9.getKey());
         if (var11 != null && ((KeybindSetting)var9.getValue()).I_method_51ee2d08(var1)) {
            var11.toggle();
            var2 = true;
         }
      }

      return var2;
   }

   public List<Setting> I_method_896de35a(IiiiiIiI_Class123 var1) {
      ArrayList var2 = new ArrayList();
      Set var3 = this.Ii_method_444ebb44();

      for (Setting var5 : this.I_field_7865b31) {
         if (!var3.contains(var5)) {
            Set var6 = this.III_field_a567c40b.get(var5);
            if (var6 == null || var6.contains(var1)) {
               var2.add(var5);
            }
         }
      }

      return var2;
   }

   public List<Setting> i_method_dd86337a(IiiiiIiI_Class123 var1) {
      ArrayList var2 = new ArrayList();

      for (Map var4 : this.IIi_field_a567c40b.values()) {
         Setting var5 = (Setting)var4.get(var1);
         if (var5 != null) {
            var2.add(var5);
         }
      }

      return var2;
   }

   public List<Setting> I_method_9533177a(IiiiiIII_Class121 var1) {
      ArrayList var2 = new ArrayList();

      for (Map var4 : this.IiI_field_a567c40b.values()) {
         Setting var5 = (Setting)var4.get(var1);
         if (var5 != null) {
            var2.add(var5);
         }
      }

      return var2;
   }

   public List<Setting> I_method_12177ba(IiiiIiii_Class120 var1) {
      ArrayList var2 = new ArrayList();

      for (Map var4 : this.Iii_field_a567c40b.values()) {
         Setting var5 = (Setting)var4.get(var1);
         if (var5 != null) {
            var2.add(var5);
         }
      }

      return var2;
   }

   private Set<Setting> Ii_method_444ebb44() {
      HashSet var1 = new HashSet();
      var1.addAll(this.I_field_a567c40b.values());
      var1.addAll(this.i_field_a567c40b.values());
      var1.addAll(this.II_field_a567c40b.values());
      var1.addAll(this.Ii_field_a567c40b.values());
      var1.addAll(this.iI_field_a567c40b.values());
      var1.addAll(this.ii_field_a567c40b.values());

      for (Map var3 : this.IIi_field_a567c40b.values()) {
         var1.addAll(var3.values());
      }

      for (Map var6 : this.IiI_field_a567c40b.values()) {
         var1.addAll(var6.values());
      }

      for (Map var7 : this.Iii_field_a567c40b.values()) {
         var1.addAll(var7.values());
      }

      return var1;
   }

   public JsonObject I_method_d1ac1716() {
      JsonObject var1 = new JsonObject();
      var1.addProperty("name", this.I_field_523beb0a);
      JsonObject var2 = new JsonObject();

      for (Entry var4 : this.I_field_a567c40b.entrySet()) {
         var2.add(((IiiiiIiI_Class123)var4.getKey()).I_method_213534(), ((BooleanSetting)var4.getValue()).toJson());
      }

      var1.add("enabledByType", var2);
      JsonObject var16 = new JsonObject();

      for (Entry var5 : this.i_field_a567c40b.entrySet()) {
         var16.add(((IiiiiIII_Class121)var5.getKey()).I_method_7fef5954(), ((BooleanSetting)var5.getValue()).toJson());
      }

      var1.add("enabledByPlayerSubType", var16);
      JsonObject var18 = new JsonObject();

      for (Entry var6 : this.II_field_a567c40b.entrySet()) {
         var18.add(((IiiiIiii_Class120)var6.getKey()).I_method_91339994(), ((BooleanSetting)var6.getValue()).toJson());
      }

      var1.add("enabledByItemSubType", var18);
      JsonObject var20 = new JsonObject();

      for (Entry var7 : this.Ii_field_a567c40b.entrySet()) {
         var20.add(((IiiiiIiI_Class123)var7.getKey()).I_method_213534(), ((KeybindSetting)var7.getValue()).toJson());
      }

      var1.add("bindsByType", var20);
      JsonObject var22 = new JsonObject();

      for (Entry var8 : this.iI_field_a567c40b.entrySet()) {
         var22.add(((IiiiiIII_Class121)var8.getKey()).I_method_7fef5954(), ((KeybindSetting)var8.getValue()).toJson());
      }

      var1.add("bindsByPlayerSubType", var22);
      JsonObject var24 = new JsonObject();

      for (Entry var9 : this.ii_field_a567c40b.entrySet()) {
         var24.add(((IiiiIiii_Class120)var9.getKey()).I_method_91339994(), ((KeybindSetting)var9.getValue()).toJson());
      }

      var1.add("bindsByItemSubType", var24);
      JsonObject var26 = new JsonObject();

      for (Entry var10 : this.IIi_field_a567c40b.entrySet()) {
         JsonObject var11 = new JsonObject();

         for (Entry var13 : (Iterable<Entry>)(Iterable<?>)((Map)var10.getValue()).entrySet()) {
            var11.add(((IiiiiIiI_Class123)var13.getKey()).I_method_213534(), ((Setting)var13.getValue()).toJson());
         }

         var26.add((String)var10.getKey(), var11);
      }

      var1.add("perTypeSettings", var26);
      JsonObject var28 = new JsonObject();

      for (Entry var31 : this.IiI_field_a567c40b.entrySet()) {
         JsonObject var34 = new JsonObject();

         for (Entry var14 : (Iterable<Entry>)(Iterable<?>)((Map)var31.getValue()).entrySet()) {
            var34.add(((IiiiiIII_Class121)var14.getKey()).I_method_7fef5954(), ((Setting)var14.getValue()).toJson());
         }

         var28.add((String)var31.getKey(), var34);
      }

      var1.add("perPlayerSubTypeSettings", var28);
      JsonObject var30 = new JsonObject();

      for (Entry var35 : this.Iii_field_a567c40b.entrySet()) {
         JsonObject var38 = new JsonObject();

         for (Entry var15 : (Iterable<Entry>)(Iterable<?>)((Map)var35.getValue()).entrySet()) {
            var38.add(((IiiiIiii_Class120)var15.getKey()).I_method_91339994(), ((Setting)var15.getValue()).toJson());
         }

         var30.add((String)var35.getKey(), var38);
      }

      var1.add("perItemSubTypeSettings", var30);
      JsonObject var33 = new JsonObject();
      Set var36 = this.Ii_method_444ebb44();

      for (Setting var41 : this.I_field_7865b31) {
         if (!var36.contains(var41)) {
            var33.add(var41.getName(), var41.toJson());
         }
      }

      var1.add("globalSettings", var33);
      return var1;
   }

   public void I_method_81c92e58(JsonObject var1) {
      if (var1.has("enabledByType")) {
         JsonObject var2 = var1.getAsJsonObject("enabledByType");

         for (Entry var4 : this.I_field_a567c40b.entrySet()) {
            String var5 = ((IiiiiIiI_Class123)var4.getKey()).I_method_213534();
            if (var2.has(var5)) {
               ((BooleanSetting)var4.getValue()).fromJson(var2.get(var5));
            }
         }
      }

      if (var1.has("enabledByPlayerSubType")) {
         JsonObject var10 = var1.getAsJsonObject("enabledByPlayerSubType");

         for (Entry var28 : this.i_field_a567c40b.entrySet()) {
            String var37 = ((IiiiiIII_Class121)var28.getKey()).I_method_7fef5954();
            if (var10.has(var37)) {
               ((BooleanSetting)var28.getValue()).fromJson(var10.get(var37));
            }
         }
      }

      if (var1.has("enabledByItemSubType")) {
         JsonObject var11 = var1.getAsJsonObject("enabledByItemSubType");

         for (Entry var29 : this.II_field_a567c40b.entrySet()) {
            String var38 = ((IiiiIiii_Class120)var29.getKey()).I_method_91339994();
            if (var11.has(var38)) {
               ((BooleanSetting)var29.getValue()).fromJson(var11.get(var38));
            }
         }
      }

      if (var1.has("bindsByType")) {
         JsonObject var12 = var1.getAsJsonObject("bindsByType");

         for (Entry var30 : this.Ii_field_a567c40b.entrySet()) {
            String var39 = ((IiiiiIiI_Class123)var30.getKey()).I_method_213534();
            if (var12.has(var39)) {
               ((KeybindSetting)var30.getValue()).fromJson(var12.get(var39));
            }
         }
      }

      if (var1.has("bindsByPlayerSubType")) {
         JsonObject var13 = var1.getAsJsonObject("bindsByPlayerSubType");

         for (Entry var31 : this.iI_field_a567c40b.entrySet()) {
            String var40 = ((IiiiiIII_Class121)var31.getKey()).I_method_7fef5954();
            if (var13.has(var40)) {
               ((KeybindSetting)var31.getValue()).fromJson(var13.get(var40));
            }
         }
      }

      if (var1.has("bindsByItemSubType")) {
         JsonObject var14 = var1.getAsJsonObject("bindsByItemSubType");

         for (Entry var32 : this.ii_field_a567c40b.entrySet()) {
            String var41 = ((IiiiIiii_Class120)var32.getKey()).I_method_91339994();
            if (var14.has(var41)) {
               ((KeybindSetting)var32.getValue()).fromJson(var14.get(var41));
            }
         }
      }

      if (var1.has("perTypeSettings")) {
         JsonObject var15 = var1.getAsJsonObject("perTypeSettings");

         for (Entry var33 : this.IIi_field_a567c40b.entrySet()) {
            String var42 = (String)var33.getKey();
            if (var15.has(var42)) {
               JsonObject var6 = var15.getAsJsonObject(var42);

               for (Entry var8 : (Iterable<Entry>)(Iterable<?>)((Map)var33.getValue()).entrySet()) {
                  String var9 = ((IiiiiIiI_Class123)var8.getKey()).I_method_213534();
                  if (var6.has(var9)) {
                     ((Setting)var8.getValue()).fromJson(var6.get(var9));
                  }
               }
            }
         }
      }

      if (var1.has("perPlayerSubTypeSettings")) {
         JsonObject var16 = var1.getAsJsonObject("perPlayerSubTypeSettings");

         for (Entry var34 : this.IiI_field_a567c40b.entrySet()) {
            String var43 = (String)var34.getKey();
            if (var16.has(var43)) {
               JsonObject var46 = var16.getAsJsonObject(var43);

               for (Entry var50 : (Iterable<Entry>)(Iterable<?>)((Map)var34.getValue()).entrySet()) {
                  String var52 = ((IiiiiIII_Class121)var50.getKey()).I_method_7fef5954();
                  if (var46.has(var52)) {
                     ((Setting)var50.getValue()).fromJson(var46.get(var52));
                  }
               }
            }
         }
      }

      if (var1.has("perItemSubTypeSettings")) {
         JsonObject var17 = var1.getAsJsonObject("perItemSubTypeSettings");

         for (Entry var35 : this.Iii_field_a567c40b.entrySet()) {
            String var44 = (String)var35.getKey();
            if (var17.has(var44)) {
               JsonObject var47 = var17.getAsJsonObject(var44);

               for (Entry var51 : (Iterable<Entry>)(Iterable<?>)((Map)var35.getValue()).entrySet()) {
                  String var53 = ((IiiiIiii_Class120)var51.getKey()).I_method_91339994();
                  if (var47.has(var53)) {
                     ((Setting)var51.getValue()).fromJson(var47.get(var53));
                  }
               }
            }
         }
      }

      if (var1.has("globalSettings")) {
         JsonObject var18 = var1.getAsJsonObject("globalSettings");
         Set var27 = this.Ii_method_444ebb44();

         for (Setting var45 : this.I_field_7865b31) {
            if (!var27.contains(var45) && var18.has(var45.getName())) {
               var45.fromJson(var18.get(var45.getName()));
            }
         }
      }
   }

   @Generated
   public String I_method_4b007174() {
      return this.I_field_523beb0a;
   }

   @Generated
   public Set<IiiiiIiI_Class123> I_method_eee7af9b() {
      return this.I_field_a56a8dc5;
   }

   @Generated
   public Set<IiiiiIII_Class121> i_method_8123f37b() {
      return this.i_field_a56a8dc5;
   }

   @Generated
   public Set<IiiiIiii_Class120> II_method_b2127764() {
      return this.II_field_a56a8dc5;
   }

   @Generated
   @Override
   public List<Setting> getSettings() {
      return this.I_field_7865b31;
   }

   @Generated
   public Map<IiiiiIiI_Class123, BooleanSetting> I_method_eee4e5e1() {
      return this.I_field_a567c40b;
   }

   @Generated
   public Map<IiiiiIII_Class121, BooleanSetting> i_method_812129c1() {
      return this.i_field_a567c40b;
   }

   @Generated
   public Map<IiiiIiii_Class120, BooleanSetting> II_method_b20fadaa() {
      return this.II_field_a567c40b;
   }

   @Generated
   public Map<IiiiiIiI_Class123, KeybindSetting> Ii_method_444bf18a() {
      return this.Ii_field_a567c40b;
   }

   @Generated
   public Map<IiiiiIII_Class121, KeybindSetting> iI_method_675be5ca() {
      return this.iI_field_a567c40b;
   }

   @Generated
   public Map<IiiiIiii_Class120, KeybindSetting> ii_method_f99829aa() {
      return this.ii_field_a567c40b;
   }

   @Generated
   public Map<Setting, Set<IiiiiIiI_Class123>> III_method_543ddf01() {
      return this.III_field_a567c40b;
   }

   @Generated
   public Map<String, Map<IiiiiIiI_Class123, Setting>> IIi_method_e67a22e1() {
      return this.IIi_field_a567c40b;
   }

   @Generated
   public Map<String, Map<IiiiiIII_Class121, Setting>> IiI_method_98a1721() {
      return this.IiI_field_a567c40b;
   }

   @Generated
   public Map<String, Map<IiiiIiii_Class120, Setting>> Iii_method_9bc65b01() {
      return this.Iii_field_a567c40b;
   }

   @FunctionalInterface
   protected interface Nested1_2edc91b6<T extends Setting> {
      T create(IiiiIiiI_Class119 var1, BooleanSetting var2, BooleanSetting var3, BooleanSetting var4, BooleanSetting var5);
   }

   @FunctionalInterface
   protected interface Nested1_2edc91d6<T extends Setting> {
      T create(IiiiIiiI_Class119 var1, BooleanSetting var2);
   }

   @FunctionalInterface
   protected interface Nested1_2edc9596<T extends Setting> {
      T create(IiiiIiiI_Class119 var1, BooleanSetting var2, IiiiiIiI_Class123 var3);
   }

   @FunctionalInterface
   protected interface Nested1_9c50cf3<T extends Setting> {
      T create(IiiiIiiI_Class119 var1, BooleanSetting var2, BooleanSetting var3, BooleanSetting var4);
   }

   @FunctionalInterface
   protected interface Nested1_9c50d13<T extends Setting> {
      T create(IiiiIiiI_Class119 var1, BooleanSetting var2, BooleanSetting var3);
   }
}
