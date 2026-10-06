package rockstar.client;

import java.util.List;
import net.minecraft.block.Block;

public final class iiIiiiiII_Class445 {
   public IIIiiIIi_Class26 I_method_ee22f198() {
      return IIIiiIiI_Class27.I_method_fa8865f9(
            "mine",
            var1 -> var1.i_method_cfe1a061("commands.mine.description")
               .i_method_3d6e11d9(
                  "block",
                  var1x -> var1x.I_method_2619a44a(
                     new IIiIIIII_Class33() {
                        @Override
                        public IIiIIIIi_Class34 validate(String var1) {
                           Block var2 = iiIiiiIII_Class441.I_method_b7c8d0a3(var1);
                           return (IIiIIIIi_Class34)(var2 == null
                              ? IIiIIIIi_Class34.I_method_c9d442bc("\u0411\u043b\u043e\u043a \u043d\u0435 \u043d\u0430\u0439\u0434\u0435\u043d: " + var1)
                              : IIiIIIIi_Class34.I_method_12fc454a(var2));
                        }

                        @Override
                        public List<String> suggestions(String var1) {
                           return iiIiiiIII_Class441.I_method_d63beb71(var1);
                        }
                     }
                  )
               )
               .I_method_16f05c8a(this::I_method_883e6700)
         )
         .I_method_9111538b();
   }

   private void I_method_883e6700(IIIiiIii_Class28 var1) {
      Block var2 = (Block)var1.I_method_557e5bfb().get(0);
      iiIiiIiIi_Class438.I_method_12f562b5().I_method_d87feab5().I_method_7bda9cc7(new iiiiIIIii_Class484(var2));
      iiiIIIIii_Class452.I_method_15375629("\u0418\u0434\u0451\u043c \u043a\u043e\u043f\u0430\u0442\u044c " + var2);
   }
}
