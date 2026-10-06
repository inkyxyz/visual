package rockstar.client;

import net.minecraft.client.gui.screen.ChatScreen;
import net.minecraft.item.Items;

public class IiIiIiiii_Class176 extends IiIiIIiII_Class165 {
   private static final float I_field_46 = 28.0F;
   private static final float i_field_46 = 27.0F;
   private static final float II_field_46 = 6.0F;
   private static final float Ii_field_46 = 5.5F;
   private static final float iI_field_46 = 1.5F;
   private static final float ii_field_46 = 28.0F;
   private static final float III_field_46 = 24.0F;
   private final ModeSetting I_field_bbe33e6c = new ModeSetting(this, "\u0422\u0438\u043f");
   private final ModeSetting.Nested1_42765c60 I_field_500d0627 = new ModeSetting.Nested1_42765c60(
      this.I_field_bbe33e6c, "\u0421\u0442\u0430\u0440\u044b\u0439"
   );
   private final ModeSetting.Nested1_42765c60 i_field_500d0627 = new ModeSetting.Nested1_42765c60(
         this.I_field_bbe33e6c, "\u041d\u043e\u0432\u044b\u0439"
      )
      .select();
   private boolean I_field_5a;

   public IiIiIiiii_Class176() {
      super("hud.totem_counter", "hud/hotbar");
      this.showing = true;
   }

   @Override
   public void update(III var1) {
      if (this.i_field_500d0627.isSelected()) {
         this.width = 28.0F;
         this.height = 27.0F;
      } else {
         this.width = 28.0F;
         this.height = 24.0F;
      }

      if (!this.I_field_5a && this.x == 0.0F && this.y == 0.0F) {
         this.x = var1.getScaledWindowWidth() / 2.0F + 101.0F;
         this.y = var1.getScaledWindowHeight() - 21.5F;
      }

      this.I_field_5a = true;
      super.update(var1);
   }

   @Override
   public void renderComponent(III var1) {
      int var2 = this.I_method_70b5ca72();
      if (var2 > 0) {
         if (this.i_field_500d0627.isSelected()) {
            this.I_method_f737a0dc(var1, var2);
         } else {
            this.i_method_326204bc(var1, var2);
         }
      }
   }

   private void I_method_f737a0dc(III var1, int var2) {
      IIiIIi_Class10 var3 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(6.0F);
      String var4 = String.valueOf(var2);
      float var5 = this.x + 6.0F;
      float var6 = this.y + 5.5F;
      var1.drawClientRect(this.x, this.y, 28.0F, 27.0F, 1.0F, 0.0F, 7.0F, 8.0F);
      var1.drawItem(Items.TOTEM_OF_UNDYING, var5, var6, 1.0F);
      var1.drawCenteredText(var3, var4, var5 + 8.0F + 1.5F, var6 + 14.0F, IiiiiIIIi_Class242.iI_method_8e08d3b1());
   }

   private void i_method_326204bc(III var1, int var2) {
      IIiIIi_Class10 var3 = IIiIiI_Class11.I_field_857c0621.I_method_3a2d5e3(7.0F);
      String var4 = String.valueOf(var2);
      float var5 = this.x + 6.0F;
      float var6 = this.y + 3.0F;
      var1.drawItem(Items.TOTEM_OF_UNDYING, var5, var6, 1.0F);
      var1.drawCenteredText(var3, var4, var5 + 16.1F, var6 + 12.3F, IiiiiIIIi_Class242.iI_method_8e08d3b1());
   }

   @Override
   public boolean show() {
      return I_field_3a9bda27.currentScreen instanceof ChatScreen || this.I_method_70b5ca83() && this.i_method_70c45652() > 0;
   }

   private int I_method_70b5ca72() {
      int var1 = this.i_method_70c45652();
      return var1 > 0 ? var1 : (I_field_3a9bda27.currentScreen instanceof ChatScreen ? 1 : 0);
   }

   private int i_method_70c45652() {
      return I_field_3a9bda27.player == null
         ? 0
         : iIIiiIiIi_Class310.i_method_7fde0a75()
            .I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695())
            .I_method_fdeecb5d(iIIiiIiIi_Class310.Ii_method_1c02fc38())
            .I_method_fdeecb5d(iIIiiIiIi_Class310.II_method_66d8858())
            .I_method_fe8cb900(Items.TOTEM_OF_UNDYING)
            .size();
   }

   private boolean I_method_70b5ca83() {
      AutoTotemModule var1 = RockstarClient.getInstance().getModuleManager().getModule(AutoTotemModule.class);
      return var1 != null && var1.isEnabled();
   }
}
