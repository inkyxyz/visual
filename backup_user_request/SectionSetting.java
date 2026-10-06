package rockstar.client;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;
import lombok.Generated;
import org.jetbrains.annotations.NotNull;
import pyrock.utility.render.ColorRGBA;

public class SectionSetting extends AbstractSetting {
   private int I_field_49 = 1;
   private boolean I_field_5a;
   private boolean i_field_5a;

   public SectionSetting(@NotNull IIiiiIIiI_Class115 var1, String var2, String var3, @NotNull BooleanSupplier var4) {
      super(var1, var2, var4);
   }

   public SectionSetting(@NotNull IIiiiIIiI_Class115 var1, String var2, @NotNull BooleanSupplier var3) {
      super(var1, var2, var3);
   }

   public SectionSetting(@NotNull IIiiiIIiI_Class115 var1, String var2, String var3) {
      super(var1, var2);
   }

   public SectionSetting(@NotNull IIiiiIIiI_Class115 var1, String var2) {
      super(var1, var2);
   }

   public SectionSetting I_method_9505555a(int var1) {
      this.I_field_49 = var1;
      return this;
   }

   public SectionSetting I_method_17a15b35() {
      this.I_field_5a = true;
      return this;
   }

   public SectionSetting i_method_2d36cf15() {
      this.i_field_5a = true;
      return this;
   }

   @Override
   public final JsonElement toJson() {
      return new JsonPrimitive("\u043a\u043e\u0441\u0442\u044b\u043b\u044c");
   }

   @Override
   public final void fromJson(JsonElement var1) {
   }

   @Override
   public iii_Class8 createComponent() {
      IIiIIi_Class10 var1 = (this.I_field_5a ? IIiIiI_Class11.II_field_857c0621 : IIiIiI_Class11.Ii_field_857c0621).I_method_3a2d5e3(8 + this.I_field_49);
      Supplier var2 = () -> IiIiIIII_Class81.I_method_f25a980a(this.I_field_523beb0a);
      Object var3 = this.I_field_5a
         ? new iiIi_Class14(var1, var2)
            .I_method_93241bcf(this.i_field_5a)
            .I_method_94717391(var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.9F))
            .i_method_9583a6eb()
         : new Iii_Class4()
            .fillWidth()
            .height(var1.I_method_a649725c())
            .text(var1, var2, var0 -> IiiiiIIIi_Class242.iII_field_d0c8ec5.mulAlpha(0.9F))
            .textAlign(this.i_field_5a ? IIi_Class2.i_field_b5755e8c : IIi_Class2.I_field_b5755e8c)
            .fade(!this.i_field_5a)
            .textShadow(this.i_field_5a ? ColorRGBA.BLACK.withAlpha(100.0F) : null, 0.0F, 1.0F, 0.0F)
            .interactive(false);
      return new iii_Class8()
         .I_method_485bccf5()
         .III_method_9dc17555()
         .I_method_8939bffd(
            new iii_Class8()
               .I_method_485bccf5()
               .III_method_9dc17555()
               .I_method_7e2bb176(IIII.I_method_12c9a0cb(10.0F, 0.0F, 5.0F, 0.0F))
               .I_method_8939bffd((iiI_Class7)var3)
         );
   }

   @Generated
   public int I_method_23922e32() {
      return this.I_field_49;
   }

   @Generated
   public boolean i_method_9b12da03() {
      return this.I_field_5a;
   }

   @Generated
   public boolean II_method_4ec29106() {
      return this.i_field_5a;
   }

   @Generated
   public void I_method_4eb40ca4(int var1) {
      this.I_field_49 = var1;
   }

   @Generated
   public void I_method_4eb44c75(boolean var1) {
      this.I_field_5a = var1;
   }

   @Generated
   public void i_method_50773c95(boolean var1) {
      this.i_field_5a = var1;
   }
}
