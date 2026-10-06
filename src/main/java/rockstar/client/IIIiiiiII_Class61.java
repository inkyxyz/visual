package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.Item.TooltipContext;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.network.packet.c2s.play.PlayerInteractItemC2SPacket;
import net.minecraft.network.packet.s2c.play.GameMessageS2CPacket;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.screen.slot.SlotActionType;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult.Type;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.RaycastContext.FluidHandling;
import net.minecraft.world.RaycastContext.ShapeType;
import pyrock.events.network.ReceivePacketEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.HudRenderEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import pyrock.utility.render.CustomDrawContext;

public class IIIiiiiII_Class61 extends IIIiiiIii_Class60 {
   private static final BlockPos I_field_670402ba = new BlockPos(-75, 84, 29);
   private static final BlockPos i_field_670402ba = new BlockPos(-54, 93, 50);
   private static final double I_field_44 = 12.0;
   private static final long I_field_4a = 25000L;
   private static final int I_field_49 = 1000;
   private static final BlockState I_field_fd3466f5 = Blocks.STONE.getDefaultState();
   private static final int i_field_49 = 2;
   private static final String I_field_523beb0a = "8789bb5c493b3d128719e8dfd48d32a4";
   private static final String i_field_523beb0a = "warp mine";
   private static final long i_field_4a = 5000L;
   private static final long II_field_4a = 10L;
   private static final long Ii_field_4a = 60000L;
   private final MultiSelectSetting I_field_bbe3ba6c;
   private final MultiSelectSetting.Nested1_42856060 I_field_51de8227;
   private final MultiSelectSetting.Nested1_42856060 i_field_51de8227;
   private final MultiSelectSetting.Nested1_42856060 II_field_51de8227;
   private final BooleanSetting I_field_ba20ca4c;
   private final MultiSelectSetting i_field_bbe3ba6c;
   private final MultiSelectSetting.Nested1_42856060 Ii_field_51de8227;
   private final MultiSelectSetting.Nested1_42856060 iI_field_51de8227;
   private final MultiSelectSetting.Nested1_42856060 ii_field_51de8227;
   private final MultiSelectSetting.Nested1_42856060 III_field_51de8227;
   private final MultiSelectSetting.Nested1_42856060 IIi_field_51de8227;
   private final MultiSelectSetting.Nested1_42856060 IiI_field_51de8227;
   private final BooleanSetting i_field_ba20ca4c;
   private final BooleanSetting II_field_ba20ca4c;
   private final MultiSelectSetting II_field_bbe3ba6c;
   private final MultiSelectSetting.Nested1_42856060 Iii_field_51de8227;
   private final MultiSelectSetting.Nested1_42856060 iII_field_51de8227;
   private final MultiSelectSetting.Nested1_42856060 iIi_field_51de8227;
   private final MultiSelectSetting.Nested1_42856060 iiI_field_51de8227;
   private final BooleanSetting Ii_field_ba20ca4c;
   private final TextSetting I_field_731802cc;
   private final SliderSetting I_field_73178e8c;
   private final BooleanSetting iI_field_ba20ca4c;
   private final SliderSetting i_field_73178e8c;
   private final SliderSetting II_field_73178e8c;
   private final SliderSetting Ii_field_73178e8c;
   private BooleanSetting ii_field_ba20ca4c;
   private SliderSetting iI_field_73178e8c;
   private static final Set<Item> I_field_a56a8dc5 = Set.of(
      Items.DIAMOND,
      Items.EMERALD,
      Items.ANCIENT_DEBRIS,
      Items.NETHERITE_SCRAP,
      Items.RAW_GOLD,
      Items.RAW_IRON,
      Items.RAW_COPPER,
      Items.GOLD_INGOT,
      Items.IRON_INGOT,
      Items.COPPER_INGOT,
      Items.LAPIS_LAZULI,
      Items.REDSTONE,
      Items.COAL,
      Items.QUARTZ
   );
   private static final Set<Item> i_field_a56a8dc5 = Set.of(
      Items.DIAMOND,
      Items.EMERALD,
      Items.ANCIENT_DEBRIS,
      Items.NETHERITE_SCRAP,
      Items.NETHERITE_INGOT,
      Items.RAW_GOLD,
      Items.RAW_IRON,
      Items.RAW_COPPER,
      Items.GOLD_INGOT,
      Items.IRON_INGOT,
      Items.COPPER_INGOT,
      Items.GOLD_NUGGET,
      Items.IRON_NUGGET,
      Items.LAPIS_LAZULI,
      Items.REDSTONE,
      Items.COAL,
      Items.QUARTZ,
      Items.DIAMOND_BLOCK,
      Items.EMERALD_BLOCK,
      Items.NETHERITE_BLOCK,
      Items.GOLD_BLOCK,
      Items.IRON_BLOCK
   );
   private static final Pattern I_field_5fd3861f = Pattern.compile("\u0437\u0430\\s+(\\d+)\\s*\u0448\u0442", 66);
   private IIIiiiiII_Class61.Nested1_b9e87c40 I_field_c6dee247;
   private volatile List<II> I_field_7865b31;
   private volatile long iI_field_4a;
   private volatile String II_field_523beb0a;
   private volatile long ii_field_4a;
   private Thread I_field_72a5fc31;
   private final iiIiIIiii_Class424 I_field_991c1e8c;
   private II I_field_502d1361;
   private int II_field_49;
   private boolean I_field_5a;
   private int Ii_field_49;
   private final iiIiIIiii_Class424 i_field_991c1e8c;
   private boolean i_field_5a;
   private long III_field_4a;
   private boolean II_field_5a;
   private boolean Ii_field_5a;
   private long IIi_field_4a;
   private final iiIiIIiii_Class424 II_field_991c1e8c;
   private final iiIiIIiii_Class424 Ii_field_991c1e8c;
   private BlockPos II_field_670402ba;
   private BlockPos Ii_field_670402ba;
   private int iI_field_49;
   private int ii_field_49;
   private double i_field_44;
   private double II_field_44;
   private final Set<BlockPos> II_field_a56a8dc5;
   private final iiIiIIiii_Class424 iI_field_991c1e8c;
   private final iiIiIIiii_Class424 ii_field_991c1e8c;
   private int III_field_49;
   private boolean iI_field_5a;
   private int IIi_field_49;
   private boolean ii_field_5a;
   private int IiI_field_49;
   private final iiIiIIiii_Class424 III_field_991c1e8c;
   private final iiIiIIiii_Class424 IIi_field_991c1e8c;
   private final iiIiIIiii_Class424 IiI_field_991c1e8c;
   private int Iii_field_49;
   private boolean III_field_5a;
   private boolean IIi_field_5a;
   private boolean IiI_field_5a;
   private final iiIiIIiii_Class424 Iii_field_991c1e8c;
   private Item I_field_3c05b08c;
   private int iII_field_49;
   private int iIi_field_49;
   private final iiIiIIiii_Class424 iII_field_991c1e8c;
   private final Set<Item> Ii_field_a56a8dc5;
   private boolean Iii_field_5a;
   private int iiI_field_49;
   private int iii_field_49;
   private int IIII_field_49;
   private boolean iII_field_5a;
   private final iiIiIIiii_Class424 iIi_field_991c1e8c;
   private final iiIiIIiii_Class424 iiI_field_991c1e8c;
   private final iiIiIIiii_Class424 iii_field_991c1e8c;
   private final iiIiIIiii_Class424 IIII_field_991c1e8c;
   private final iiIiIIiii_Class424 IIIi_field_991c1e8c;
   private int IIIi_field_49;
   private boolean iIi_field_5a;
   private final iiIiIIiii_Class424 IIiI_field_991c1e8c;
   private final iiIiIIiii_Class424 IIii_field_991c1e8c;
   private static final long IiI_field_4a = 300000L;
   private final iiIiIIiii_Class424 IiII_field_991c1e8c;
   private final IiIIIiII_Class69<ClientPlayerTickEvent> I_field_3d936f41;
   private final IiIIIiII_Class69<ReceivePacketEvent> i_field_3d936f41;
   private static final ColorRGBA I_field_d0c8ec5 = new ColorRGBA(96.0F, 180.0F, 255.0F);
   private final IiIIIiII_Class69<Render3DEvent> II_field_3d936f41;
   private final IiIIIiII_Class69<HudRenderEvent> Ii_field_3d936f41;

   public IIIiiiiII_Class61(AutoFarmModule var1, ModeSetting var2) {
      super(var1, var2, "modules.settings.auto_farm.modes.mine");
      this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.I_field_c6dee247;
      this.I_field_7865b31 = new ArrayList<>();
      this.I_field_991c1e8c = new iiIiIIiii_Class424();
      this.II_field_49 = -1;
      this.i_field_991c1e8c = new iiIiIIiii_Class424();
      this.II_field_991c1e8c = new iiIiIIiii_Class424();
      this.Ii_field_991c1e8c = new iiIiIIiii_Class424();
      this.II_field_a56a8dc5 = new HashSet<>();
      this.iI_field_991c1e8c = new iiIiIIiii_Class424();
      this.ii_field_991c1e8c = new iiIiIIiii_Class424();
      this.III_field_49 = -1;
      this.III_field_991c1e8c = new iiIiIIiii_Class424();
      this.IIi_field_991c1e8c = new iiIiIIiii_Class424();
      this.IiI_field_991c1e8c = new iiIiIIiii_Class424();
      this.Iii_field_49 = -1;
      this.Iii_field_991c1e8c = new iiIiIIiii_Class424();
      this.iII_field_991c1e8c = new iiIiIIiii_Class424();
      this.Ii_field_a56a8dc5 = new HashSet<>();
      this.iIi_field_991c1e8c = new iiIiIIiii_Class424();
      this.iiI_field_991c1e8c = new iiIiIIiii_Class424();
      this.iii_field_991c1e8c = new iiIiIIiii_Class424();
      this.IIII_field_991c1e8c = new iiIiIIiii_Class424();
      this.IIIi_field_991c1e8c = new iiIiIIiii_Class424();
      this.IIIi_field_49 = -1;
      this.IIiI_field_991c1e8c = new iiIiIIiii_Class424();
      this.IIii_field_991c1e8c = new iiIiIIiii_Class424();
      this.IiII_field_991c1e8c = new iiIiIIiii_Class424();
      this.I_field_3d936f41 = var1x -> {
         if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
            if (!iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
               this.I_method_cac07269("modules.mine_farm.not_funtime");
               this.iI_method_8024b102();
            } else {
               this.IIi_method_526e867f();
               if (!this.I_method_5620a243()) {
                  switch (this.I_field_c6dee247) {
                     case I_field_c6dee247:
                        this.IiI_method_5422eabf();
                        break;
                     case i_field_c6dee247:
                        this.Iii_method_5431769f();
                        break;
                     case II_field_c6dee247:
                        this.iIi_method_89099a5f();
                        break;
                     case Ii_field_c6dee247:
                        this.iii_method_8acc8a7f();
                        break;
                     case iI_field_c6dee247:
                        this.IIiI_method_fb7140c2();
                        break;
                     case ii_field_c6dee247:
                        this.IIii_method_fb7fcca2();
                        break;
                     case III_field_c6dee247:
                        this.IiII_method_30496482();
                        break;
                     case IIi_field_c6dee247:
                        this.IiIi_method_3057f062();
                        break;
                     case IiI_field_c6dee247:
                        this.iiIi_method_cd1f5882();
                        break;
                     case Iii_field_c6dee247:
                        this.iiii_method_cee248a2();
                        break;
                     case iII_field_c6dee247:
                        this.IIIII_method_3c2abaff();
                        break;
                     case iIi_field_c6dee247:
                        this.IIIIi_method_3c3946df();
                        break;
                     case iiI_field_c6dee247:
                        this.IIIiI_method_3dedab1f();
                  }
               }
            }
         }
      };
      this.i_field_3d936f41 = var1x -> {
         if (var1x.getPacket() instanceof GameMessageS2CPacket var2x) {
            String var4 = var2x.content().getString().toLowerCase();
            if (var4.contains("\u0434\u043e\u0441\u0442\u0430\u0442\u043e\u0447\u043d\u043e \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u043e\u0432")) {
               this.III_field_5a = false;
               this.IIi_field_5a = false;
            } else if (var4.contains("\u043f\u0440\u043e\u0434\u0430\u0432\u0430\u0442\u044c")) {
               if (var4.contains("\u0432\u0441\u0435 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u044b")
                  || var4.contains("\u0432\u0441\u0451 \u043f\u0440\u0435\u0434\u043c\u0435\u0442\u044b")) {
                  this.III_field_5a = true;
                  this.IIi_field_5a = false;
               } else if (var4.contains("\u043f\u0440\u043e\u0434\u0430\u0432\u0430\u0442\u044c \u043f\u043e")) {
                  this.III_field_5a = false;
                  this.IIi_field_5a = false;
               }
            }
         }
      };
      this.II_field_3d936f41 = var1x -> {
         if (I_field_3a9bda27.world != null && I_field_3a9bda27.player != null) {
            if (this.I_field_c6dee247 == IIIiiiiII_Class61.Nested1_b9e87c40.II_field_c6dee247
               || this.I_field_c6dee247 == IIIiiiiII_Class61.Nested1_b9e87c40.Ii_field_c6dee247) {
               MatrixStack var2x = var1x.getMatrices();
               Camera var3 = I_field_3a9bda27.gameRenderer.getCamera();
               Vec3d var4 = var3.getPos();
               Box var5 = new Box(
                     I_field_670402ba.getX(),
                     I_field_670402ba.getY(),
                     I_field_670402ba.getZ(),
                     i_field_670402ba.getX() + 1,
                     i_field_670402ba.getY() + 1,
                     i_field_670402ba.getZ() + 1
                  )
                  .offset(-var4.x, -var4.y, -var4.z);
               RenderSystem.enableBlend();
               RenderSystem.disableDepthTest();
               RenderSystem.disableCull();
               RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
               RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
               BufferBuilder var6 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
               iIiiIIiIi_Class358.i_method_5e35f7b9(var2x, var6, var5, I_field_d0c8ec5.mulAlpha(0.1F));
               iIiiiIIiI_Class371.I_method_c59155f0(var6);
               BufferBuilder var7 = RenderSystem.renderThreadTesselator().begin(DrawMode.DEBUG_LINES, VertexFormats.POSITION_COLOR);
               iIiiIIiIi_Class358.Ii_method_c1caf816(var2x, var7, var5, I_field_d0c8ec5.mulAlpha(0.7F));
               iIiiiIIiI_Class371.I_method_c59155f0(var7);
               RenderSystem.defaultBlendFunc();
               RenderSystem.enableCull();
               RenderSystem.enableDepthTest();
               RenderSystem.disableBlend();
            }
         }
      };
      this.Ii_field_3d936f41 = var1x -> {
         if (this.ii_field_ba20ca4c.i_method_9b12da03()) {
            if (I_field_3a9bda27.player != null) {
               CustomDrawContext var2x = var1x.getContext();
               IIiIIi_Class10 var3 = IIiIiI_Class11.Ii_field_857c0621.I_method_3a2d5e3(8.0F);
               IIiIIi_Class10 var4 = IIiIiI_Class11.i_field_857c0621.I_method_3a2d5e3(7.0F);
               ArrayList var5 = new ArrayList<>(this.I_field_7865b31);
               var5.sort(Comparator.comparingLong(this::I_method_1d887454));
               int var6 = Math.min(var5.size(), (int)this.iI_field_73178e8c.Ii_method_a20abcd2());
               float var7 = 6.0F;
               float var8 = 44.0F;
               float var9 = 5.0F;
               float var10 = 11.0F;
               float var11 = 188.0F;
               float var12 = 13.0F;
               float var13 = 11.0F;
               float var14 = var9 * 2.0F + var12 + var13 + var6 * var10;
               var2x.drawRoundedRect(var7, var8, var11, var14, IIiii_Class8.I_method_893b2757(5.0F), new ColorRGBA(14.0F, 14.0F, 16.0F).mulAlpha(0.78F));
               float var15 = var8 + var9;
               var2x.drawText(var3, "Mine Farm", var7 + var9, var15, IiiiiIIIi_Class242.iI_method_8e08d3b1());
               var15 += var12;
               String var16 = this.Ii_method_f3676bfe();
               var2x.drawText(var4, var16, var7 + var9, var15, IiiiiIIIi_Class242.i_method_5dfec6e());
               var15 += var13;

               for (int var17 = 0; var17 < var6; var17++) {
                  II var18 = (II)var5.get(var17);
                  boolean var19 = this.I_field_502d1361 != null && I_method_ffaf5a3c(var18.I_method_da8e5874()) == this.II_field_49;
                  ColorRGBA var20 = var19 ? IiiiiIIIi_Class242.i_method_5dfec6e() : IiiiiIIIi_Class242.iI_method_8e08d3b1();
                  String var21 = var18.i_method_6dad0894()
                     + "  "
                     + I_method_14835577(var18.Ii_method_fb5522b())
                     + "\u2192"
                     + I_method_14835577(var18.iI_method_4d4df5eb());
                  var2x.drawText(var4, var21, var7 + var9, var15, var20);
                  var2x.drawRightText(var4, I_method_840f8edb(this.I_method_1d887454(var18)), var7 + var11 - var9, var15, var20);
                  var15 += var10;
               }
            }
         }
      };
      this.I_field_bbe3ba6c = new MultiSelectSetting(var1, "modules.settings.mine_farm.rarities", () -> !this.isSelected());
      this.I_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.mine_farm.rarities.default").select();
      this.i_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.mine_farm.rarities.legendary").select();
      this.II_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.I_field_bbe3ba6c, "modules.settings.mine_farm.rarities.mythical").select();
      this.I_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.mine_farm.dig_all", () -> !this.isSelected());
      this.i_field_bbe3ba6c = new MultiSelectSetting(
         var1, "modules.settings.mine_farm.ore_types", () -> !this.isSelected() || this.I_field_ba20ca4c.i_method_9b12da03()
      );
      this.Ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.mine_farm.ore.diamond").select();
      this.iI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.mine_farm.ore.lapis");
      this.ii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.mine_farm.ore.redstone");
      this.III_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.mine_farm.ore.iron");
      this.IIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.mine_farm.ore.gold").select();
      this.IiI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.i_field_bbe3ba6c, "modules.settings.mine_farm.ore.debris").select();
      this.i_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.mine_farm.clean_inventory", () -> !this.isSelected()).I_method_decd82b5();
      this.II_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.mine_farm.drop_except", () -> !this.isSelected());
      this.II_field_bbe3ba6c = new MultiSelectSetting(
         var1, "modules.settings.mine_farm.keep_only", () -> !this.isSelected() || !this.II_field_ba20ca4c.i_method_9b12da03()
      );
      this.Iii_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.II_field_bbe3ba6c, "modules.settings.mine_farm.keep.diamond").select();
      this.iII_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.II_field_bbe3ba6c, "modules.settings.mine_farm.keep.debris").select();
      this.iIi_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.II_field_bbe3ba6c, "modules.settings.mine_farm.keep.iron").select();
      this.iiI_field_51de8227 = new MultiSelectSetting.Nested1_42856060(this.II_field_bbe3ba6c, "modules.settings.mine_farm.keep.gold").select();
      this.Ii_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.mine_farm.auto_sell", () -> !this.isSelected());
      this.I_field_731802cc = new TextSetting(
            var1, "modules.settings.mine_farm.sell_anarchy", () -> !this.isSelected() || !this.Ii_field_ba20ca4c.i_method_9b12da03()
         )
         .I_method_ec08f9eb(true)
         .I_method_104de33f("");
      this.I_field_73178e8c = new SliderSetting(
            var1, "modules.settings.mine_farm.sell_threshold", () -> !this.isSelected() || !this.Ii_field_ba20ca4c.i_method_9b12da03()
         )
         .II_method_b0f56334(1.0F)
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(36.0F)
         .Ii_method_4e0e6b54(10.0F)
         .I_method_d41e7abf(" \u0441\u0442");
      this.iI_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.mine_farm.auto_repair", () -> !this.isSelected()).I_method_decd82b5();
      this.i_field_73178e8c = new SliderSetting(
            var1, "modules.settings.mine_farm.repair_threshold", () -> !this.isSelected() || !this.iI_field_ba20ca4c.i_method_9b12da03()
         )
         .II_method_b0f56334(1.0F)
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(50.0F)
         .Ii_method_4e0e6b54(10.0F)
         .I_method_d41e7abf("%");
      this.II_field_73178e8c = new SliderSetting(
            var1, "modules.settings.mine_farm.repair_until", () -> !this.isSelected() || !this.iI_field_ba20ca4c.i_method_9b12da03()
         )
         .II_method_b0f56334(1.0F)
         .I_method_c8c9a7d7(20.0F)
         .i_method_65e2aff7(100.0F)
         .Ii_method_4e0e6b54(90.0F)
         .I_method_d41e7abf("%");
      this.Ii_field_73178e8c = new SliderSetting(
            var1, "modules.settings.mine_farm.bottle_target", () -> !this.isSelected() || !this.iI_field_ba20ca4c.i_method_9b12da03()
         )
         .II_method_b0f56334(1.0F)
         .I_method_c8c9a7d7(1.0F)
         .i_method_65e2aff7(128.0F)
         .Ii_method_4e0e6b54(64.0F)
         .I_method_d41e7abf(" \u0448\u0442");
      this.ii_field_ba20ca4c = new BooleanSetting(var1, "modules.settings.mine_farm.show_hud", () -> !this.isSelected()).I_method_decd82b5();
      this.iI_field_73178e8c = new SliderSetting(
            var1, "modules.settings.mine_farm.hud_count", () -> !this.isSelected() || !this.ii_field_ba20ca4c.i_method_9b12da03()
         )
         .II_method_b0f56334(1.0F)
         .I_method_c8c9a7d7(3.0F)
         .i_method_65e2aff7(15.0F)
         .Ii_method_4e0e6b54(8.0F);
   }

   @Override
   public void I_method_a0f53e1f() {
      if (I_field_3a9bda27.player == null || I_field_3a9bda27.world == null) {
         this.iI_method_8024b102();
      } else if (!iIIIiiiII_Class285.I_method_456510cb(iIIIiiIii_Class284.I_field_ac164e6c)) {
         this.I_method_cac07269("modules.mine_farm.not_funtime");
         this.iI_method_8024b102();
      } else {
         this.II_method_6e029d02();
         this.ii_method_6fd41902();
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.I_field_c6dee247;
      }
   }

   @Override
   public void i_method_a103c9ff() {
      this.III_method_525ffa9f();
      this.iIII_method_9675b8c2();
      this.II_method_6e029d02();
      this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.I_field_c6dee247;
   }

   private void II_method_6e029d02() {
      this.I_field_502d1361 = null;
      this.II_field_49 = -1;
      this.I_field_5a = false;
      this.Ii_field_49 = 0;
      this.i_field_5a = false;
      this.II_field_5a = false;
      this.Ii_field_5a = false;
      this.III_field_49 = -1;
      this.Iii_field_5a = false;
      this.IIII_field_49 = 0;
      this.iII_field_5a = false;
      this.iIi_field_5a = false;
      this.IIIi_field_49 = -1;
   }

   private void ii_method_6fd41902() {
      long var1 = ++this.ii_field_4a;
      this.I_field_991c1e8c.I_method_23e11e3f();
      Thread var3 = new Thread(() -> {
         I var3x = new I("8789bb5c493b3d128719e8dfd48d32a4");

         while (this.ii_field_4a == var1) {
            try {
               List var4 = var3x.i_method_5d4910c8();
               if (var4 != null) {
                  this.I_field_7865b31 = var4;
                  this.iI_field_4a = System.currentTimeMillis();
                  this.II_field_523beb0a = null;
               }
            } catch (Throwable var6) {
               this.II_field_523beb0a = var6.getMessage();
            }

            try {
               Thread.sleep(5000L);
            } catch (InterruptedException var5) {
            }
         }
      }, "MineFarm-API");
      var3.setDaemon(true);
      this.I_field_72a5fc31 = var3;
      var3.start();
   }

   private void III_method_525ffa9f() {
      this.ii_field_4a++;
      if (this.I_field_72a5fc31 != null) {
         this.I_field_72a5fc31.interrupt();
         this.I_field_72a5fc31 = null;
      }
   }

   private void IIi_method_526e867f() {
      boolean var1 = this.I_field_72a5fc31 == null || !this.I_field_72a5fc31.isAlive();
      boolean var2 = this.iI_field_4a > 0L && System.currentTimeMillis() - this.iI_field_4a > 10000L;
      if ((var1 || var2) && this.I_field_991c1e8c.I_method_58432069(5000L)) {
         this.ii_method_6fd41902();
      }
   }

   private long I_method_1d887454(II var1) {
      long var2 = (System.currentTimeMillis() - this.iI_field_4a) / 1000L;
      return Math.max(0L, var1.I_method_b1b6a9a0() - var2);
   }

   private boolean I_method_ffaf5a4d(String var1) {
      if (var1 == null) {
         return true;
      } else {
         String var2 = var1.toLowerCase();

         return switch (var2) {
            case "default" -> this.I_field_51de8227.isSelected();
            case "legendary" -> this.i_field_51de8227.isSelected();
            case "mythical" -> this.II_field_51de8227.isSelected();
            default -> true;
         };
      }
   }

   private static int I_method_ffaf5a3c(String var0) {
      if (var0 == null) {
         return -1;
      } else {
         String var1 = var0.replaceAll("[^0-9]", "");
         if (var1.isEmpty()) {
            return -1;
         } else {
            try {
               return Integer.parseInt(var1);
            } catch (NumberFormatException var3) {
               return -1;
            }
         }
      }
   }

   private II I_method_a02aeed8() {
      ArrayList var1 = new ArrayList<>(this.I_field_7865b31);
      var1.sort(Comparator.comparingLong(this::I_method_1d887454));
      int var2 = iIIIiiiII_Class285.i_field_49;
      long var3 = 10L;

      for (II var6 : (Iterable<II>)(Iterable<?>)var1) {
         if (this.I_method_ffaf5a4d(var6.iI_method_4d4df5eb())) {
            int var7 = I_method_ffaf5a3c(var6.I_method_da8e5874());
            if (var7 > 0 && var7 <= 1000 && (var7 == var2 || this.I_method_1d887454(var6) >= var3)) {
               return var6;
            }
         }
      }

      return null;
   }

   private void IiI_method_5422eabf() {
      this.iIiI_method_9838a8e2();
      if (this.iI_field_991c1e8c.I_method_58432069(500L)) {
         this.iI_field_991c1e8c.I_method_23e11e3f();
         if (this.III_method_525ffaa3() && this.IIi_method_526e8683()) {
            this.iIii_method_984734c2();
         } else if (!this.i_method_562f2e23()) {
            II var1 = this.I_method_a02aeed8();
            if (var1 != null) {
               this.I_field_502d1361 = var1;
               this.II_field_49 = I_method_ffaf5a3c(var1.I_method_da8e5874());
               if (this.II_field_49 <= 0) {
                  this.I_field_502d1361 = null;
               } else {
                  if (iIIIiiiII_Class285.i_field_49 == this.II_field_49) {
                     this.iII_method_88fb0e7f();
                  } else {
                     this.I_field_5a = false;
                     this.Ii_field_49 = 0;
                     this.i_field_991c1e8c.I_method_23e11e3f();
                     this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.i_field_c6dee247;
                  }
               }
            }
         }
      }
   }

   private void Iii_method_5431769f() {
      if (this.I_field_502d1361 == null) {
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.I_field_c6dee247;
      } else if (iIIIiiiII_Class285.i_field_49 == this.II_field_49) {
         this.iII_method_88fb0e7f();
      } else {
         if (!this.I_field_5a || this.i_field_991c1e8c.I_method_58432069(25000L)) {
            I_field_3a9bda27.player.networkHandler.sendChatCommand("an" + this.II_field_49);
            this.I_field_5a = true;
            this.i_field_991c1e8c.I_method_23e11e3f();
            this.Ii_field_49++;
            if (this.Ii_field_49 > 6) {
               this.I_field_502d1361 = null;
               this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.I_field_c6dee247;
               this.iI_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private void iII_method_88fb0e7f() {
      this.i_field_5a = false;
      this.III_field_4a = System.currentTimeMillis();
      this.Ii_field_49 = 0;
      this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.II_field_c6dee247;
   }

   private void iIi_method_89099a5f() {
      if (this.I_field_502d1361 == null) {
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.I_field_c6dee247;
      } else if (iIIIiiiII_Class285.i_field_49 != this.II_field_49) {
         this.I_field_5a = false;
         this.i_field_991c1e8c.I_method_23e11e3f();
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.i_field_c6dee247;
      } else if (this.I_method_5620a22d() <= 12.0) {
         this.iiI_method_8abdfe9f();
      } else {
         if (!this.i_field_5a || System.currentTimeMillis() - this.III_field_4a > 8000L) {
            I_field_3a9bda27.player.networkHandler.sendChatCommand("warp mine");
            this.i_field_5a = true;
            this.III_field_4a = System.currentTimeMillis();
            this.Ii_field_49++;
            if (this.Ii_field_49 > 8) {
               this.I_field_502d1361 = null;
               this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.I_field_c6dee247;
               this.iI_field_991c1e8c.I_method_23e11e3f();
            }
         }
      }
   }

   private void iiI_method_8abdfe9f() {
      this.II_field_5a = false;
      this.Ii_field_5a = this.ii_method_6fd41906();
      this.Ii_field_991c1e8c.I_method_23e11e3f();
      this.IIII_method_f9ae50a2();
      this.II_field_a56a8dc5.clear();
      this.II_field_670402ba = null;
      long var1 = this.I_field_502d1361 != null ? this.I_method_1d887454(this.I_field_502d1361) : 0L;
      this.IIi_field_4a = Math.max(30000L, Math.min(300000L, (var1 + 45L) * 1000L));
      this.II_field_991c1e8c.I_method_23e11e3f();
      this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.Ii_field_c6dee247;
   }

   private void iii_method_8acc8a7f() {
      this.iIII_method_9675b8c2();
      if (iIIIiiiII_Class285.i_field_49 != this.II_field_49) {
         this.I_field_5a = false;
         this.i_field_991c1e8c.I_method_23e11e3f();
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.i_field_c6dee247;
      } else if (this.III_method_525ffaa3() && this.IIi_method_526e8683()) {
         this.iIii_method_984734c2();
      } else if (this.i_method_562f2e23()) {
         this.iIII_method_9675b8c2();
      } else {
         if (!this.Ii_field_5a && this.ii_method_6fd41906()) {
            this.Ii_field_5a = true;
         }

         List var1 = this.I_method_b7b28a28();
         int var2 = var1.size();
         if (var2 == 0) {
            if (this.Ii_field_5a) {
               this.IIIi_method_f9bcdc82();
            } else {
               this.iIiI_method_9838a8e2();
               if (this.II_field_991c1e8c.I_method_58432069(this.IIi_field_4a)) {
                  this.I_field_502d1361 = null;
                  this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.I_field_c6dee247;
                  this.iI_field_991c1e8c.I_method_23e11e3f();
               }
            }
         } else if (this.Ii_field_991c1e8c.I_method_58432069(25000L)) {
            this.IIIi_method_f9bcdc82();
         } else {
            this.iIIi_method_968444a2();
            double var3 = I_field_3a9bda27.player.getBlockInteractionRange();
            double var5 = (var3 + 0.6) * (var3 + 0.6);
            int var7 = I_field_3a9bda27.player.getBlockY();
            BlockPos var8 = null;
            if (this.II_field_670402ba != null && !this.II_field_a56a8dc5.contains(this.II_field_670402ba) && this.i_method_fc40b5dd(this.II_field_670402ba)) {
               var8 = this.II_field_670402ba;
            } else {
               for (BlockPos var10 : (Iterable<BlockPos>)(Iterable<?>)var1) {
                  if (!this.II_field_a56a8dc5.contains(var10)) {
                     var8 = var10;
                     break;
                  }
               }

               this.II_field_670402ba = var8;
            }

            if (var8 == null) {
               this.IIIi_method_f9bcdc82();
            } else {
               Direction var11 = this.I_method_d1ed21e7(var8) <= var5 ? this.I_method_d54f2685(var8, var3) : null;
               if (var11 != null) {
                  this.IIII_method_f9ae50a2();
                  if (this.I_method_4d464c75(var8, this.I_method_ce8b7611(var8, var11))) {
                     I_field_3a9bda27.interactionManager.updateBlockBreakingProgress(var8, var11);
                     I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
                     this.Ii_field_991c1e8c.I_method_23e11e3f();
                  }

                  this.II_field_5a = true;
                  this.iIiI_method_9838a8e2();
               } else {
                  int var12 = var8.getY() - var7;
                  if (var12 > 1) {
                     if (var12 > var3) {
                        this.II_field_a56a8dc5.add(var8);
                        this.II_field_670402ba = null;
                        this.iIiI_method_9838a8e2();
                        return;
                     }

                     if (Math.sqrt(this.I_method_d1ed21e7(var8)) <= var3 + 2.5) {
                        if (!this.I_method_6bb77d69(var8, var3)) {
                           this.II_field_a56a8dc5.add(var8);
                           this.II_field_670402ba = null;
                        }

                        this.iIiI_method_9838a8e2();
                        return;
                     }
                  }

                  this.I_method_6bb77d65(var8, var3);
                  this.iIiI_method_9838a8e2();
               }
            }
         }
      }
   }

   private boolean I_method_6bb77d69(BlockPos var1, double var2) {
      Vec3d var4 = I_field_3a9bda27.player.getEyePos();
      Vec3d var5 = Vec3d.ofCenter(var1);
      Vec3d var6 = var5.subtract(var4);
      double var7 = var6.length();
      Vec3d var9 = var7 <= var2 ? var5 : var4.add(var6.multiply(var2 / Math.max(var7, 1.0E-4)));
      BlockHitResult var10 = I_field_3a9bda27.world.raycast(new RaycastContext(var4, var9, ShapeType.OUTLINE, FluidHandling.NONE, I_field_3a9bda27.player));
      if (var10.getType() != Type.BLOCK) {
         return false;
      } else {
         BlockPos var11 = var10.getBlockPos();
         if (!this.I_method_d1ed21fd(var11)) {
            return false;
         } else if (this.I_method_d1ed21e7(var11) > (var2 + 0.6) * (var2 + 0.6)) {
            return false;
         } else {
            if (this.I_method_4d464c75(var11, var10.getPos())) {
               I_field_3a9bda27.interactionManager.updateBlockBreakingProgress(var11, var10.getSide());
               I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
               this.Ii_field_991c1e8c.I_method_23e11e3f();
            }

            this.II_field_5a = true;
            return true;
         }
      }
   }

   private void I_method_6bb77d65(BlockPos var1, double var2) {
      Vec3d var4 = I_field_3a9bda27.player.getEyePos();
      int var5 = I_field_3a9bda27.player.getBlockY();
      double var6 = var1.getX() + 0.5 - I_field_3a9bda27.player.getX();
      double var8 = var1.getZ() + 0.5 - I_field_3a9bda27.player.getZ();
      double var10 = Math.sqrt(var6 * var6 + var8 * var8);
      float var12 = (float)(Math.toDegrees(Math.atan2(var8, var6)) - 90.0);
      double var13 = (var2 + 0.6) * (var2 + 0.6);
      BlockPos var15 = null;
      Direction var16 = null;
      Vec3d var17 = null;
      if (var10 > 1.0E-4) {
         Vec3d var18 = new Vec3d(var6 / var10, 0.0, var8 / var10);
         BlockHitResult var19 = I_field_3a9bda27.world
            .raycast(new RaycastContext(var4, var4.add(var18.multiply(var2)), ShapeType.OUTLINE, FluidHandling.NONE, I_field_3a9bda27.player));
         if (var19.getType() == Type.BLOCK
            && this.I_method_d1ed21fd(var19.getBlockPos())
            && var4.squaredDistanceTo(Vec3d.ofCenter(var19.getBlockPos())) <= var13) {
            var15 = var19.getBlockPos();
            var16 = var19.getSide();
            var17 = var19.getPos();
         }
      }

      boolean var23 = false;
      if (var15 == null && var1.getY() < var5 - 1 && var10 < 1.4) {
         BlockPos var24 = I_field_3a9bda27.player.getBlockPos().down();
         if (this.I_method_d1ed21fd(var24)) {
            var15 = var24;
            var16 = Direction.UP;
            var17 = Vec3d.ofCenter(var24);
            var23 = true;
         }
      }

      if (var17 == null && var10 > 0.5) {
         I_field_3a9bda27.player.setYaw(var12);
         I_field_3a9bda27.player.setPitch(0.0F);
         I_field_3a9bda27.player.setHeadYaw(var12);
         I_field_3a9bda27.player.setBodyYaw(var12);
      }

      if (!var23 && var10 > 0.5) {
         I_field_3a9bda27.options.forwardKey.setPressed(true);
         I_field_3a9bda27.options.sprintKey.setPressed(true);
      }

      if (var15 != null && this.I_method_4d464c75(var15, var17)) {
         I_field_3a9bda27.interactionManager.updateBlockBreakingProgress(var15, var16);
         I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
         this.Ii_field_991c1e8c.I_method_23e11e3f();
      }

      double var25 = I_field_3a9bda27.player.getX();
      double var21 = I_field_3a9bda27.player.getZ();
      if ((var25 - this.i_field_44) * (var25 - this.i_field_44) + (var21 - this.II_field_44) * (var21 - this.II_field_44) > 0.0225) {
         this.i_field_44 = var25;
         this.II_field_44 = var21;
         this.ii_field_49 = 0;
      } else {
         this.ii_field_49++;
      }

      if (this.ii_field_49 >= 8 && var15 == null && I_field_3a9bda27.player.isOnGround()) {
         I_field_3a9bda27.options.jumpKey.setPressed(true);
         this.ii_field_49 = 0;
      }

      this.II_field_5a = true;
   }

   private boolean I_method_5620a243() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.world != null) {
         BlockPos var1 = BlockPos.ofFloored(I_field_3a9bda27.player.getEyePos());
         BlockState var2 = I_field_3a9bda27.world.getBlockState(var1);
         if (!var2.shouldSuffocate(I_field_3a9bda27.world, var1)) {
            this.IiII_field_991c1e8c.I_method_23e11e3f();
            return false;
         } else {
            this.iIII_method_9675b8c2();
            this.iIIi_method_968444a2();
            Block var3 = var2.getBlock();
            boolean var4 = var3 != Blocks.BEDROCK && var3 != Blocks.BARRIER && var2.getFluidState().isEmpty();
            if (var4) {
               this.I_method_9cbe2141(Vec3d.ofCenter(var1));
               I_field_3a9bda27.interactionManager.updateBlockBreakingProgress(var1, Direction.UP);
               I_field_3a9bda27.player.swingHand(Hand.MAIN_HAND);
            }

            if (this.IiII_field_991c1e8c.I_method_58432069(1500L)) {
               I_field_3a9bda27.player.networkHandler.sendChatCommand("spawn");
               this.IiII_field_991c1e8c.I_method_23e11e3f();
            }

            return true;
         }
      } else {
         return false;
      }
   }

   private boolean I_method_d1ed21fd(BlockPos var1) {
      BlockState var2 = I_field_3a9bda27.world.getBlockState(var1);
      if (var2.isAir()) {
         return false;
      } else {
         Block var3 = var2.getBlock();
         return var3 != Blocks.BEDROCK && var3 != Blocks.BARRIER ? var2.getFluidState().isEmpty() : false;
      }
   }

   private void IIII_method_f9ae50a2() {
      this.ii_field_49 = 0;
      if (I_field_3a9bda27.player != null) {
         this.i_field_44 = I_field_3a9bda27.player.getX();
         this.II_field_44 = I_field_3a9bda27.player.getZ();
      }
   }

   private void IIIi_method_f9bcdc82() {
      this.iIII_method_9675b8c2();
      this.I_field_502d1361 = null;
      this.II_field_49 = -1;
      this.II_field_5a = false;
      this.Ii_field_5a = false;
      this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.I_field_c6dee247;
      this.iI_field_991c1e8c.I_method_23e11e3f();
   }

   private boolean i_method_562f2e23() {
      if (!this.Ii_field_ba20ca4c.i_method_9b12da03()) {
         return false;
      } else {
         boolean var1 = this.I_method_4d533a1a(Items.DIAMOND) >= (int)this.I_field_73178e8c.Ii_method_a20abcd2() * 64;
         if (var1) {
            return this.I_method_6df45879(false);
         } else {
            return this.Ii_method_6e1128d5() <= 1 && this.II_method_6e029d06() ? this.I_method_6df45879(true) : false;
         }
      }
   }

   private boolean II_method_6e029d06() {
      PlayerInventory var1 = I_field_3a9bda27.player.getInventory();

      for (int var2 = 0; var2 < var1.size(); var2++) {
         Item var3 = var1.getStack(var2).getItem();
         if (var3 != Items.DIAMOND && I_field_a56a8dc5.contains(var3)) {
            return true;
         }
      }

      return false;
   }

   private boolean I_method_6df45879(boolean var1) {
      int var2 = I_method_ffaf5a3c(this.I_field_731802cc.II_method_da016c1e());
      if (var2 > 0 && var2 <= 1000) {
         this.III_field_49 = var2;
         this.IiI_field_5a = var1;
         this.iI_field_5a = false;
         this.IIi_field_49 = 0;
         this.ii_field_5a = false;
         this.IiI_field_49 = 0;
         this.i_field_991c1e8c.I_method_23e11e3f();
         this.IIi_field_991c1e8c.I_method_23e11e3f();
         this.III_field_991c1e8c.I_method_23e11e3f();
         this.IiI_field_991c1e8c.I_method_23e11e3f();
         this.Iii_field_49 = -1;
         this.III_field_5a = false;
         this.IIi_field_5a = false;
         this.Iii_field_991c1e8c.I_method_23e11e3f();
         this.I_field_3c05b08c = null;
         this.iIi_field_49 = 0;
         this.iII_field_991c1e8c.I_method_23e11e3f();
         this.Ii_field_a56a8dc5.clear();
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.iI_field_c6dee247;
         return true;
      } else {
         return false;
      }
   }

   private void IIiI_method_fb7140c2() {
      if (this.III_field_49 <= 0) {
         this.IiiI_method_320c54a2();
      } else if (iIIIiiiII_Class285.i_field_49 == this.III_field_49) {
         this.ii_field_5a = false;
         this.IiI_field_49 = 0;
         this.IIi_field_991c1e8c.I_method_23e11e3f();
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.ii_field_c6dee247;
      } else {
         if (!this.iI_field_5a || this.i_field_991c1e8c.I_method_58432069(25000L)) {
            I_field_3a9bda27.player.networkHandler.sendChatCommand("an" + this.III_field_49);
            this.iI_field_5a = true;
            this.i_field_991c1e8c.I_method_23e11e3f();
            this.IIi_field_49++;
            if (this.IIi_field_49 > 6) {
               this.IiiI_method_320c54a2();
            }
         }
      }
   }

   private void IIii_method_fb7fcca2() {
      if (iIIIiiiII_Class285.i_field_49 != this.III_field_49) {
         this.iI_field_5a = false;
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.iI_field_c6dee247;
      } else if (!this.Ii_method_6e1128e6() && !this.iI_method_6fc58d26()) {
         if (!this.ii_field_5a || this.IIi_field_991c1e8c.I_method_58432069(4000L)) {
            String var1 = "buyer";
            if (var1 == null || var1.isBlank()) {
               var1 = "buyer";
            }

            if (var1.startsWith("/")) {
               var1 = var1.substring(1);
            }

            I_field_3a9bda27.player.networkHandler.sendChatCommand(var1);
            this.ii_field_5a = true;
            this.IIi_field_991c1e8c.I_method_23e11e3f();
            this.IiI_field_49++;
            if (this.IiI_field_49 > 6) {
               this.IiiI_method_320c54a2();
            }
         }
      } else {
         this.IIi_field_991c1e8c.I_method_23e11e3f();
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.III_field_c6dee247;
      }
   }

   private void IiII_method_30496482() {
      if (this.Ii_method_6e1128e6()) {
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.IIi_field_c6dee247;
         this.IIi_field_991c1e8c.I_method_23e11e3f();
         this.III_field_991c1e8c.I_method_23e11e3f();
         this.IiI_field_991c1e8c.I_method_23e11e3f();
         this.Iii_field_49 = -1;
      } else if (this.iI_method_6fc58d26()) {
         if (this.III_field_991c1e8c.I_method_58432069(350L)) {
            Slot var1 = this.I_method_9edfa8fe(Items.LAPIS_LAZULI);
            if (var1 != null) {
               this.I_method_508f6edf(var1.id, 0);
               this.III_field_991c1e8c.I_method_23e11e3f();
            }
         }

         if (this.IIi_field_991c1e8c.I_method_58432069(8000L)) {
            this.IiiI_method_320c54a2();
         }
      } else {
         if (this.IIi_field_991c1e8c.I_method_58432069(2500L)) {
            this.ii_field_5a = false;
            this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.ii_field_c6dee247;
         }
      }
   }

   private void IiIi_method_3057f062() {
      if (!this.Ii_method_6e1128e6()) {
         if (this.IIi_field_991c1e8c.I_method_58432069(2000L)) {
            this.ii_field_5a = false;
            this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.ii_field_c6dee247;
         }
      } else {
         int var1 = this.I_method_5620a232();
         if (var1 == 0) {
            this.IiiI_method_320c54a2();
         } else {
            if (this.Iii_field_49 < 0 || var1 < this.Iii_field_49) {
               this.Iii_field_49 = var1;
               this.IiI_field_991c1e8c.I_method_23e11e3f();
            }

            if (this.IiI_field_991c1e8c.I_method_58432069(15000L)) {
               this.IiiI_method_320c54a2();
            } else if (this.III_field_991c1e8c.I_method_58432069(250L)) {
               Slot var2 = this.I_method_1aeb3de6();
               if (var2 == null) {
                  this.IiiI_method_320c54a2();
               } else {
                  if (!this.III_field_5a) {
                     if (!this.i_method_43200745(var2.getStack())) {
                        if (this.IIi_field_5a && !this.Iii_field_991c1e8c.I_method_58432069(2000L)) {
                           return;
                        }

                        this.I_method_508f6edf(var2.id, 1);
                        this.IIi_field_5a = true;
                        this.Iii_field_991c1e8c.I_method_23e11e3f();
                        this.III_field_991c1e8c.I_method_23e11e3f();
                        return;
                     }

                     this.III_field_5a = true;
                  }

                  Item var3 = var2.getStack().getItem();
                  int var4 = this.I_method_4d533a1a(var3);
                  if (var3 == this.I_field_3c05b08c) {
                     if (var4 >= this.iII_field_49) {
                        if (!this.iII_field_991c1e8c.I_method_58432069(1200L)) {
                           return;
                        }

                        this.iIi_field_49++;
                        this.iII_field_991c1e8c.I_method_23e11e3f();
                        if (this.iIi_field_49 >= 3) {
                           this.Ii_field_a56a8dc5.add(var3);
                           this.I_field_3c05b08c = null;
                           this.iIi_field_49 = 0;
                        }

                        return;
                     }

                     this.I_field_3c05b08c = null;
                     this.iIi_field_49 = 0;
                  }

                  this.I_method_508f6edf(var2.id, 0);
                  this.I_field_3c05b08c = var3;
                  this.iII_field_49 = var4;
                  this.iII_field_991c1e8c.I_method_23e11e3f();
                  this.III_field_991c1e8c.I_method_23e11e3f();
               }
            }
         }
      }
   }

   private void IiiI_method_320c54a2() {
      this.Iiii_method_321ae082();
      this.III_field_49 = -1;
      this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.I_field_c6dee247;
      this.iI_field_991c1e8c.I_method_23e11e3f();
   }

   private void Iiii_method_321ae082() {
      if (I_field_3a9bda27.player != null && I_field_3a9bda27.player.currentScreenHandler != I_field_3a9bda27.player.playerScreenHandler) {
         I_field_3a9bda27.player.closeHandledScreen();
      }
   }

   private String i_method_3b36e861() {
      return I_field_3a9bda27.currentScreen instanceof HandledScreen var1 ? var1.getTitle().getString().toLowerCase() : "";
   }

   private boolean Ii_method_6e1128e6() {
      return this.i_method_3b36e861().contains("\u043a\u0443\u043f\u0449\u0438\u043a");
   }

   private boolean iI_method_6fc58d26() {
      return this.i_method_3b36e861().contains("\u0441\u0435\u043a\u0446\u0438");
   }

   private Slot I_method_9edfa8fe(Item var1) {
      if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var2) {
         for (Slot var4 : var2.slots) {
            if (var4.inventory != I_field_3a9bda27.player.getInventory() && var4.getStack().getItem() == var1) {
               return var4;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   private Slot I_method_1aeb3de6() {
      if (!(I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var1)) {
         return null;
      } else {
         for (Slot var3 : var1.slots) {
            if (var3.inventory != I_field_3a9bda27.player.getInventory() && var3.hasStack()) {
               ItemStack var4 = var3.getStack();
               if ((!this.IiI_field_5a || var4.getItem() != Items.DIAMOND)
                  && !this.Ii_field_a56a8dc5.contains(var4.getItem())
                  && this.I_method_4d533a1a(var4.getItem()) > 0
                  && this.I_method_9f278365(var4)) {
                  return var3;
               }
            }
         }

         return null;
      }
   }

   private boolean I_method_9f278365(ItemStack var1) {
      LoreComponent var2 = (LoreComponent)var1.get(DataComponentTypes.LORE);
      if (var2 == null) {
         return false;
      } else {
         for (Text var4 : var2.lines()) {
            String var5 = var4.getString().toLowerCase();
            if (var5.contains("\u043f\u0440\u043e\u0434\u0430\u0442\u044c") || var5.contains("\u0446\u0435\u043d\u0430 \u0437\u0430")) {
               return true;
            }
         }

         return false;
      }
   }

   private int I_method_5620a232() {
      if (!(I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var1)) {
         return 0;
      } else {
         HashSet var6 = new HashSet();

         for (Slot var4 : var1.slots) {
            if (var4.inventory != I_field_3a9bda27.player.getInventory() && var4.hasStack()) {
               ItemStack var5 = var4.getStack();
               if ((!this.IiI_field_5a || var5.getItem() != Items.DIAMOND) && !this.Ii_field_a56a8dc5.contains(var5.getItem()) && this.I_method_9f278365(var5)) {
                  var6.add(var5.getItem());
               }
            }
         }

         int var7 = 0;

         for (Item var9 : (Iterable<Item>)(Iterable<?>)var6) {
            var7 += this.I_method_4d533a1a(var9);
         }

         return var7;
      }
   }

   private void I_method_508f6edf(int var1, int var2) {
      if (I_field_3a9bda27.player.currentScreenHandler != null && I_field_3a9bda27.interactionManager != null) {
         I_field_3a9bda27.interactionManager
            .clickSlot(I_field_3a9bda27.player.currentScreenHandler.syncId, var1, var2, SlotActionType.PICKUP, I_field_3a9bda27.player);
      }
   }

   private int I_method_4d533a1a(Item var1) {
      int var2 = 0;
      PlayerInventory var3 = I_field_3a9bda27.player.getInventory();

      for (int var4 = 0; var4 < var3.size(); var4++) {
         ItemStack var5 = var3.getStack(var4);
         if (var5.getItem() == var1) {
            var2 += var5.getCount();
         }
      }

      return var2;
   }

   private int i_method_562f2e12() {
      int var1 = 0;
      PlayerInventory var2 = I_field_3a9bda27.player.getInventory();

      for (int var3 = 0; var3 < var2.size(); var3++) {
         ItemStack var4 = var2.getStack(var3);
         if (I_field_a56a8dc5.contains(var4.getItem())) {
            var1 += var4.getCount();
         }
      }

      return var1;
   }

   private int I_method_9f278354(ItemStack var1) {
      LoreComponent var2 = (LoreComponent)var1.get(DataComponentTypes.LORE);
      if (var2 != null) {
         for (Text var4 : var2.lines()) {
            String var5 = var4.getString();
            String var6 = var5.toLowerCase();
            if (var6.contains("\u0446\u0435\u043d\u0430 \u0437\u0430")) {
               if (var6.contains("\u0432\u0441\u0451") || var6.contains("\u0432\u0441\u0435")) {
                  return Integer.MAX_VALUE;
               }

               Matcher var7 = I_field_5fd3861f.matcher(var5);
               if (var7.find()) {
                  try {
                     return Integer.parseInt(var7.group(1));
                  } catch (NumberFormatException var9) {
                  }
               }
            }
         }
      }

      return 0;
   }

   private boolean i_method_43200745(ItemStack var1) {
      LoreComponent var2 = (LoreComponent)var1.get(DataComponentTypes.LORE);
      if (var2 == null) {
         return false;
      } else {
         for (Text var4 : var2.lines()) {
            String var5 = var4.getString();
            String var6 = var5.toLowerCase();
            if (var6.contains("\u043f\u0440\u043e\u0434\u0430")
               && (var6.contains("\u0432\u0441\u0451") || var6.contains("\u0432\u0441\u0435"))
               && (var5.contains(">") || var5.contains("\u25b6") || var5.contains("\u27a4") || var5.contains("\u279c"))) {
               return true;
            }
         }

         return false;
      }
   }

   private iiIIiIIii_Class404 I_method_9cbe2141(Vec3d var1) {
      Vec3d var2 = I_field_3a9bda27.player.getEyePos();
      double var3 = var1.x - var2.x;
      double var5 = var1.y - var2.y;
      double var7 = var1.z - var2.z;
      double var9 = Math.sqrt(var3 * var3 + var7 * var7);
      float var11 = (float)(Math.toDegrees(Math.atan2(var7, var3)) - 90.0);
      float var12 = MathHelper.clamp((float)(-Math.toDegrees(Math.atan2(var5, var9))), -90.0F, 90.0F);
      I_field_3a9bda27.player.setYaw(var11);
      I_field_3a9bda27.player.setPitch(var12);
      I_field_3a9bda27.player.setHeadYaw(var11);
      I_field_3a9bda27.player.setBodyYaw(var11);
      return new iiIIiIIii_Class404(var11, var12);
   }

   private boolean I_method_4d464c75(BlockPos var1, Vec3d var2) {
      iiIIiIIii_Class404 var3 = this.I_method_9cbe2141(var2);
      if (!var1.equals(this.Ii_field_670402ba)) {
         this.Ii_field_670402ba = var1;
         this.iI_field_49 = 0;
      }

      iiIIiIIii_Class404 var4 = RockstarClient.getInstance().I_method_58785402().Ii_method_62e6c38();
      if (var4.I_method_24e31c97(var3) <= 1.5F) {
         this.iI_field_49++;
         return this.iI_field_49 >= 2;
      } else {
         return false;
      }
   }

   private void iIII_method_9675b8c2() {
      if (I_field_3a9bda27.options != null) {
         I_field_3a9bda27.options.forwardKey.setPressed(false);
         I_field_3a9bda27.options.backKey.setPressed(false);
         I_field_3a9bda27.options.sprintKey.setPressed(false);
         I_field_3a9bda27.options.jumpKey.setPressed(false);
      }
   }

   private void iIIi_method_968444a2() {
      ItemStack var1 = I_field_3a9bda27.player.getMainHandStack();
      float var2 = var1.getItem() instanceof PickaxeItem ? var1.getMiningSpeedMultiplier(I_field_fd3466f5) : -1.0F;
      iIIiiiIii_Class316 var3 = null;

      for (iIIiiiIii_Class316 var5 : iIIiiIiIi_Class310.I_method_6a489695().I_method_617d3e68()) {
         ItemStack var6 = var5.I_method_7b7e0bb9();
         if (var6.getItem() instanceof PickaxeItem) {
            float var7 = var6.getMiningSpeedMultiplier(I_field_fd3466f5);
            if (var7 > var2) {
               var2 = var7;
               var3 = var5;
            }
         }
      }

      if (var3 != null) {
         iIIiIiIiI_Class299.I_method_4c2ca067(var3);
      }
   }

   private List<BlockPos> I_method_b7b28a28() {
      ArrayList var1 = new ArrayList();

      for (int var2 = i_field_670402ba.getY(); var2 >= I_field_670402ba.getY(); var2--) {
         for (int var3 = I_field_670402ba.getX(); var3 <= i_field_670402ba.getX(); var3++) {
            for (int var4 = I_field_670402ba.getZ(); var4 <= i_field_670402ba.getZ(); var4++) {
               BlockPos var5 = new BlockPos(var3, var2, var4);
               if (this.i_method_fc40b5dd(var5)) {
                  var1.add(var5);
               }
            }
         }
      }

      var1.sort(Comparator.comparingDouble(this::I_method_d1ed21e7));
      return var1;
   }

   private boolean i_method_fc40b5dd(BlockPos var1) {
      BlockState var2 = I_field_3a9bda27.world.getBlockState(var1);
      if (var2.isAir()) {
         return false;
      } else {
         Block var3 = var2.getBlock();
         if (var3 == Blocks.BEDROCK || var3 == Blocks.BARRIER) {
            return false;
         } else if (!var2.getFluidState().isEmpty()) {
            return false;
         } else {
            return this.I_field_ba20ca4c.i_method_9b12da03() ? true : this.I_method_8095256f(var3);
         }
      }
   }

   private boolean I_method_8095256f(Block var1) {
      if (!this.Ii_field_51de8227.isSelected() || var1 != Blocks.DIAMOND_ORE && var1 != Blocks.DEEPSLATE_DIAMOND_ORE) {
         if (!this.iI_field_51de8227.isSelected() || var1 != Blocks.LAPIS_ORE && var1 != Blocks.DEEPSLATE_LAPIS_ORE) {
            if (!this.ii_field_51de8227.isSelected() || var1 != Blocks.REDSTONE_ORE && var1 != Blocks.DEEPSLATE_REDSTONE_ORE) {
               if (!this.III_field_51de8227.isSelected() || var1 != Blocks.IRON_ORE && var1 != Blocks.DEEPSLATE_IRON_ORE) {
                  return !this.IIi_field_51de8227.isSelected() || var1 != Blocks.GOLD_ORE && var1 != Blocks.DEEPSLATE_GOLD_ORE
                     ? this.IiI_field_51de8227.isSelected() && var1 == Blocks.ANCIENT_DEBRIS
                     : true;
               } else {
                  return true;
               }
            } else {
               return true;
            }
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   private boolean ii_method_6fd41906() {
      for (int var1 = i_field_670402ba.getY(); var1 >= I_field_670402ba.getY(); var1--) {
         for (int var2 = I_field_670402ba.getX(); var2 <= i_field_670402ba.getX(); var2++) {
            for (int var3 = I_field_670402ba.getZ(); var3 <= i_field_670402ba.getZ(); var3++) {
               BlockState var4 = I_field_3a9bda27.world.getBlockState(new BlockPos(var2, var1, var3));
               if (!var4.isAir()) {
                  Block var5 = var4.getBlock();
                  if (var5 != Blocks.BEDROCK && var5 != Blocks.BARRIER && var4.getFluidState().isEmpty()) {
                     return true;
                  }
               }
            }
         }
      }

      return false;
   }

   private double I_method_d1ed21e7(BlockPos var1) {
      return I_field_3a9bda27.player.getEyePos().squaredDistanceTo(Vec3d.ofCenter(var1));
   }

   private Direction I_method_d54f2685(BlockPos var1, double var2) {
      Vec3d var4 = I_field_3a9bda27.player.getEyePos();
      double var5 = var2 * var2;
      Direction var7 = null;
      double var8 = Double.MAX_VALUE;

      for (Direction var13 : Direction.values()) {
         if (this.II_method_b3eaac00(var1.offset(var13))) {
            Vec3d var14 = Vec3d.ofCenter(var1).add(var13.getOffsetX() * 0.49, var13.getOffsetY() * 0.49, var13.getOffsetZ() * 0.49);
            double var15 = var4.squaredDistanceTo(var14);
            if (!(var15 > var5) && !(var15 >= var8)) {
               BlockHitResult var17 = I_field_3a9bda27.world
                  .raycast(new RaycastContext(var4, var14, ShapeType.OUTLINE, FluidHandling.NONE, I_field_3a9bda27.player));
               if (var17.getType() == Type.BLOCK && var17.getBlockPos().equals(var1)) {
                  var7 = var13;
                  var8 = var15;
               }
            }
         }
      }

      return var7;
   }

   private boolean II_method_b3eaac00(BlockPos var1) {
      BlockState var2 = I_field_3a9bda27.world.getBlockState(var1);
      return !var2.isAir() && !var2.isReplaceable() ? var2.getCollisionShape(I_field_3a9bda27.world, var1).isEmpty() : true;
   }

   private Vec3d I_method_ce8b7611(BlockPos var1, Direction var2) {
      return Vec3d.ofCenter(var1).add(var2.getOffsetX() * 0.5, var2.getOffsetY() * 0.5, var2.getOffsetZ() * 0.5);
   }

   private double I_method_5620a22d() {
      double var1 = I_field_3a9bda27.player.getX();
      double var3 = I_field_3a9bda27.player.getZ();
      double var5 = MathHelper.clamp(var1, I_field_670402ba.getX(), i_field_670402ba.getX());
      double var7 = MathHelper.clamp(var3, I_field_670402ba.getZ(), i_field_670402ba.getZ());
      double var9 = var1 - var5;
      double var11 = var3 - var7;
      return Math.sqrt(var9 * var9 + var11 * var11);
   }

   private void iIiI_method_9838a8e2() {
      if (this.i_field_ba20ca4c.i_method_9b12da03() || this.II_field_ba20ca4c.i_method_9b12da03()) {
         if (I_field_3a9bda27.player.currentScreenHandler != null) {
            double var1 = Math.hypot(I_field_3a9bda27.player.getVelocity().x, I_field_3a9bda27.player.getVelocity().z);
            boolean var3 = var1 > 0.06;
            boolean var4 = this.Ii_method_6e1128d5() <= 2;
            if (!var3 || var4) {
               long var5 = var3 ? 150L : 0L;
               if (this.ii_field_991c1e8c.I_method_58432069(var5)) {
                  int var7 = var3 ? 1 : 3;
                  int var8 = 36 + I_field_3a9bda27.player.getInventory().selectedSlot;
                  iIIiiIiII_Class309 var9 = iIIiiIiIi_Class310.i_method_7fde0a75().I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695());
                  int var10 = 0;

                  for (iIIiIiIii_Class300 var12 : (Iterable<iIIiIiIii_Class300>)(Iterable<?>)var9.I_method_617d3e68()) {
                     if (var10 >= var7) {
                        break;
                     }

                     ItemStack var13 = var12.I_method_7b7e0bb9();
                     if (!var13.isEmpty() && var12.I_method_dfe89252() != var8 && !this.II_method_b82886e8(var13)) {
                        I_field_3a9bda27.interactionManager
                           .clickSlot(
                              I_field_3a9bda27.player.currentScreenHandler.syncId, var12.I_method_dfe89252(), 1, SlotActionType.THROW, I_field_3a9bda27.player
                           );
                        var10++;
                     }
                  }

                  if (var10 > 0) {
                     this.ii_field_991c1e8c.I_method_23e11e3f();
                  }
               }
            }
         }
      }
   }

   private boolean II_method_b82886e8(ItemStack var1) {
      Item var2 = var1.getItem();
      if (var2 instanceof PickaxeItem
         || var2 instanceof SwordItem
         || var2 instanceof AxeItem
         || var2 instanceof ShovelItem
         || var2 instanceof HoeItem
         || var2 instanceof ArmorItem) {
         return true;
      } else if (var1.contains(DataComponentTypes.FOOD)) {
         return true;
      } else if (var2 == Items.EXPERIENCE_BOTTLE
         || var2 == Items.TOTEM_OF_UNDYING
         || var2 == Items.ELYTRA
         || var2 == Items.ENDER_PEARL
         || var2 == Items.ENDER_CHEST) {
         return true;
      } else {
         return this.II_field_ba20ca4c.i_method_9b12da03() ? this.I_method_4d533a2b(var2) : i_field_a56a8dc5.contains(var2);
      }
   }

   private boolean I_method_4d533a2b(Item var1) {
      if (!this.Iii_field_51de8227.isSelected() || var1 != Items.DIAMOND && var1 != Items.DIAMOND_BLOCK) {
         if (!this.iII_field_51de8227.isSelected()
            || var1 != Items.ANCIENT_DEBRIS && var1 != Items.NETHERITE_SCRAP && var1 != Items.NETHERITE_INGOT && var1 != Items.NETHERITE_BLOCK) {
            return !this.iIi_field_51de8227.isSelected()
                  || var1 != Items.RAW_IRON && var1 != Items.IRON_INGOT && var1 != Items.IRON_NUGGET && var1 != Items.IRON_BLOCK
               ? this.iiI_field_51de8227.isSelected()
                  && (var1 == Items.RAW_GOLD || var1 == Items.GOLD_INGOT || var1 == Items.GOLD_NUGGET || var1 == Items.GOLD_BLOCK)
               : true;
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   private boolean III_method_525ffaa3() {
      if (!this.iI_field_ba20ca4c.i_method_9b12da03()) {
         return false;
      } else if (this.iIi_field_5a && !this.IIii_field_991c1e8c.I_method_58432069(300000L)) {
         return false;
      } else {
         this.iIi_field_5a = false;
         this.iIIi_method_968444a2();
         ItemStack var1 = I_field_3a9bda27.player.getMainHandStack();
         return var1.getItem() instanceof PickaxeItem && var1.isDamageable()
            ? this.I_method_9f27834f(var1) < this.i_field_73178e8c.Ii_method_a20abcd2()
            : false;
      }
   }

   private boolean IIi_method_526e8683() {
      if (this.II_method_6e029cf5() > 0) {
         return true;
      } else if (this.iII_field_5a && !this.iii_field_991c1e8c.I_method_58432069(60000L)) {
         return false;
      } else {
         return this.Iii_method_543176a3()
            ? true
            : this.Ii_field_ba20ca4c.i_method_9b12da03() && this.i_method_562f2e12() > 0 && I_method_ffaf5a3c(this.I_field_731802cc.II_method_da016c1e()) > 0;
      }
   }

   private void iIii_method_984734c2() {
      this.iIII_method_9675b8c2();
      this.IIII_field_991c1e8c.I_method_23e11e3f();
      this.IIIi_field_49 = -1;
      this.IIiI_field_991c1e8c.I_method_23e11e3f();
      this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.IiI_field_c6dee247;
   }

   private void iiII_method_cd10cca2() {
      this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.I_field_c6dee247;
      this.iI_field_991c1e8c.I_method_23e11e3f();
   }

   private void iiIi_method_cd1f5882() {
      this.iIII_method_9675b8c2();
      this.iIIi_method_968444a2();
      ItemStack var1 = I_field_3a9bda27.player.getMainHandStack();
      if (var1.getItem() instanceof PickaxeItem && var1.isDamageable()) {
         if (this.I_method_9f27834f(var1) >= this.II_field_73178e8c.Ii_method_a20abcd2()) {
            this.iiII_method_cd10cca2();
         } else if (this.II_method_6e029cf5() <= 0) {
            this.iiiI_method_ced3bcc2();
         } else if (I_field_3a9bda27.player.getOffHandStack().getItem() != Items.EXPERIENCE_BOTTLE) {
            iIIiIiIii_Class300 var4 = iIIiiIiIi_Class310.i_method_7fde0a75()
               .I_method_fdeecb5d(iIIiiIiIi_Class310.I_method_6a489695())
               .I_method_77fa4424(var0 -> var0.getItem() == Items.EXPERIENCE_BOTTLE);
            if (var4 == null) {
               this.iiiI_method_ced3bcc2();
            } else {
               iIIiIiIiI_Class299.I_method_2e11f97f(var4, iIIiIiIiI_Class299.I_method_d0337735());
               this.IIII_field_991c1e8c.I_method_23e11e3f();
            }
         } else {
            int var2 = var1.getDamage();
            if (this.IIIi_field_49 >= 0 && var2 >= this.IIIi_field_49) {
               if (this.IIiI_field_991c1e8c.I_method_58432069(12000L)) {
                  this.iIi_field_5a = true;
                  this.IIii_field_991c1e8c.I_method_23e11e3f();
                  if (this.IIIi_field_991c1e8c.I_method_58432069(5000L)) {
                     this.i_method_9b77c649("modules.mine_farm.repair_stuck");
                     this.IIIi_field_991c1e8c.I_method_23e11e3f();
                  }

                  this.iiII_method_cd10cca2();
                  return;
               }
            } else {
               this.IIIi_field_49 = var2;
               this.IIiI_field_991c1e8c.I_method_23e11e3f();
            }

            float var3 = I_field_3a9bda27.player.getYaw();
            I_field_3a9bda27.player.setPitch(90.0F);
            I_field_3a9bda27.player.setHeadYaw(var3);
            if (this.IIII_field_991c1e8c.I_method_58432069(120L)) {
               I_field_3a9bda27.interactionManager
                  .sendSequencedPacket(I_field_3a9bda27.world, var1x -> new PlayerInteractItemC2SPacket(Hand.OFF_HAND, var1x, var3, 90.0F));
               this.IIII_field_991c1e8c.I_method_23e11e3f();
            }
         }
      } else {
         this.iiII_method_cd10cca2();
      }
   }

   private void iiiI_method_ced3bcc2() {
      if (!this.Iii_method_543176a3()) {
         if (!this.Ii_field_ba20ca4c.i_method_9b12da03()
            || this.i_method_562f2e12() <= 0
            || I_method_ffaf5a3c(this.I_field_731802cc.II_method_da016c1e()) <= 0
            || !this.I_method_6df45879(true)) {
            this.Ii_method_1e469e2c("modules.mine_farm.inventory_full");
         }
      } else {
         this.Iii_field_5a = false;
         this.iiI_field_49 = 0;
         this.iii_field_49 = 0;
         this.IIII_field_49 = 0;
         this.iIi_field_991c1e8c.I_method_23e11e3f();
         this.iiI_field_991c1e8c.I_method_23e11e3f();
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.Iii_field_c6dee247;
      }
   }

   private void Ii_method_1e469e2c(String var1) {
      if (I_field_3a9bda27.currentScreen != null) {
         I_field_3a9bda27.player.closeHandledScreen();
      }

      this.iII_field_5a = true;
      this.iii_field_991c1e8c.I_method_23e11e3f();
      if (this.IIIi_field_991c1e8c.I_method_58432069(5000L)) {
         this.i_method_9b77c649(var1);
         this.IIIi_field_991c1e8c.I_method_23e11e3f();
      }

      this.iiII_method_cd10cca2();
   }

   private String II_method_6048bbde() {
      String var1 = "\u0411\u0443\u0442\u044b\u043b\u043e\u0447\u043a\u0430 \u043e\u043f\u044b\u0442\u0430";
      if (var1 == null || var1.isBlank()) {
         var1 = "\u0431\u0443\u0442\u044b\u043b\u043e\u0447\u043a\u0430 \u043e\u043f\u044b\u0442\u0430";
      }

      return var1;
   }

   private boolean IiI_method_5422eac3() {
      if (!(I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler)) {
         return false;
      } else {
         return IiiiiIIii_Class244.II_method_6da14e50(this.i_method_3b36e861()) ? true : this.i_method_3b36e861().contains("\u0431\u0443\u0442\u044b\u043b");
      }
   }

   private void iiii_method_cee248a2() {
      if (this.IiI_method_5422eac3()) {
         this.iIi_field_991c1e8c.I_method_23e11e3f();
         this.iiI_field_991c1e8c.I_method_23e11e3f();
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.iII_field_c6dee247;
      } else if (I_field_3a9bda27.currentScreen != null) {
         if (this.iiI_field_991c1e8c.I_method_58432069(2500L)) {
            I_field_3a9bda27.player.closeHandledScreen();
            this.iiI_field_991c1e8c.I_method_23e11e3f();
         }
      } else {
         if (!this.Iii_field_5a || this.iiI_field_991c1e8c.I_method_58432069(3500L)) {
            I_field_3a9bda27.player.networkHandler.sendChatCommand("ah search " + this.II_method_6048bbde());
            this.Iii_field_5a = true;
            this.iiI_field_991c1e8c.I_method_23e11e3f();
            this.iiI_field_49++;
            if (this.iiI_field_49 > 6) {
               this.Ii_method_1e469e2c("modules.mine_farm.auction_failed");
            }
         }
      }
   }

   private void IIIII_method_3c2abaff() {
      if (!this.IiI_method_5422eac3()) {
         this.Iii_field_5a = false;
         this.iiI_field_991c1e8c.I_method_23e11e3f();
         this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.Iii_field_c6dee247;
      } else if (this.iIi_field_991c1e8c.I_method_58432069(400L)) {
         int var1 = this.iI_method_6fc58d15();
         if (var1 < 0) {
            this.Ii_method_1e469e2c("modules.mine_farm.bottles_not_found");
         } else {
            this.I_method_508f6edf(var1, 0);
            this.iiI_field_991c1e8c.I_method_23e11e3f();
            this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.iIi_field_c6dee247;
         }
      }
   }

   private void IIIIi_method_3c3946df() {
      String var1 = this.i_method_3b36e861();
      if (var1.contains("\u043f\u043e\u0434\u0442\u0432\u0435\u0440\u0436\u0434\u0435\u043d\u0438\u0435 \u043f\u043e\u043a\u0443\u043f\u043a\u0438")) {
         if (this.iiI_field_991c1e8c.I_method_58432069(300L)) {
            this.I_method_508f6edf(2, 0);
            this.iiI_field_991c1e8c.I_method_23e11e3f();
            this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.iiI_field_c6dee247;
         }
      } else if (this.IiI_method_5422eac3()) {
         if (this.iiI_field_991c1e8c.I_method_58432069(600L)) {
            this.iIi_field_991c1e8c.I_method_23e11e3f();
            this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.iII_field_c6dee247;
         }
      } else {
         if (this.iiI_field_991c1e8c.I_method_58432069(2500L)) {
            this.iii_field_49++;
            if (this.iii_field_49 > 4) {
               this.Ii_method_1e469e2c("modules.mine_farm.buy_failed");
               return;
            }

            this.Iii_field_5a = false;
            this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.Iii_field_c6dee247;
         }
      }
   }

   private void IIIiI_method_3dedab1f() {
      if (this.iiI_field_991c1e8c.I_method_58432069(400L)) {
         if (I_field_3a9bda27.currentScreen != null) {
            I_field_3a9bda27.player.closeHandledScreen();
         }

         this.iII_field_5a = false;
         this.IIII_field_49++;
         if (this.II_method_6e029cf5() < (int)this.Ii_field_73178e8c.Ii_method_a20abcd2() && this.Iii_method_543176a3() && this.IIII_field_49 < 20) {
            this.Iii_field_5a = false;
            this.iiI_field_49 = 0;
            this.iiI_field_991c1e8c.I_method_23e11e3f();
            this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.Iii_field_c6dee247;
         } else {
            this.IIII_field_991c1e8c.I_method_23e11e3f();
            this.I_field_c6dee247 = IIIiiiiII_Class61.Nested1_b9e87c40.IiI_field_c6dee247;
         }
      }
   }

   private double I_method_9f27834f(ItemStack var1) {
      return var1.isDamageable() && var1.getMaxDamage() > 0 ? (double)(var1.getMaxDamage() - var1.getDamage()) / var1.getMaxDamage() * 100.0 : 100.0;
   }

   private int II_method_6e029cf5() {
      int var1 = 0;
      PlayerInventory var2 = I_field_3a9bda27.player.getInventory();

      for (int var3 = 0; var3 < var2.size(); var3++) {
         ItemStack var4 = var2.getStack(var3);
         if (var4.getItem() == Items.EXPERIENCE_BOTTLE) {
            var1 += var4.getCount();
         }
      }

      return var1;
   }

   private boolean Iii_method_543176a3() {
      return this.Ii_method_6e1128d5() > 0;
   }

   private int Ii_method_6e1128d5() {
      PlayerInventory var1 = I_field_3a9bda27.player.getInventory();
      int var2 = 0;

      for (int var3 = 0; var3 < 36; var3++) {
         if (var1.getStack(var3).isEmpty()) {
            var2++;
         }
      }

      return var2;
   }

   private long I_method_9f278355(ItemStack var1) {
      for (Text var3 : var1.getTooltip(
         TooltipContext.create(I_field_3a9bda27.world),
         I_field_3a9bda27.player,
         I_field_3a9bda27.options.advancedItemTooltips ? TooltipType.ADVANCED : TooltipType.BASIC
      )) {
         String var4 = var3.getString();
         String var5 = var4.toLowerCase();
         if ((var4.contains("$") || var5.contains("\u0446\u0435\u043d\u0430") || var5.contains("\u0441\u0442\u043e\u0438\u043c")) && !var4.contains("%")) {
            String var6 = var4.replaceAll("[^0-9]", "");
            if (!var6.isEmpty()) {
               try {
                  long var7 = Long.parseLong(var6);
                  if (var7 > 0L) {
                     return var7;
                  }
               } catch (NumberFormatException var9) {
               }
            }
         }
      }

      return -1L;
   }

   private int iI_method_6fc58d15() {
      if (I_field_3a9bda27.player.currentScreenHandler instanceof GenericContainerScreenHandler var1) {
         int var14 = var1.slots.size() - 36;
         double var3 = Double.MAX_VALUE;
         int var5 = -1;

         for (int var6 = 0; var6 < var14; var6++) {
            Slot var7 = var1.getSlot(var6);
            if (var7 != null && var7.hasStack()) {
               ItemStack var8 = var7.getStack();
               if (var8.getItem() == Items.EXPERIENCE_BOTTLE) {
                  long var9 = this.I_method_9f278355(var8);
                  if (var9 > 0L) {
                     int var11 = Math.max(1, var8.getCount());
                     double var12 = (double)var9 / var11;
                     if (var12 < var3) {
                        var3 = var12;
                        var5 = var7.id;
                     }
                  }
               }
            }
         }

         return var5;
      } else {
         return -1;
      }
   }

   private String Ii_method_f3676bfe() {
      String var1 = this.I_field_502d1361 != null ? String.valueOf(this.II_field_49) : "-";

      return switch (this.I_field_c6dee247) {
         case I_field_c6dee247 -> this.II_field_523beb0a != null
            ? "API: " + this.II_field_523beb0a
            : "\u0412\u044b\u0431\u043e\u0440 \u0448\u0430\u0445\u0442\u044b...";
         case i_field_c6dee247 -> "\u041f\u0435\u0440\u0435\u0445\u043e\u0434 \u043d\u0430 \u0430\u043d\u0430\u0440\u0445\u0438\u044e " + var1;
         case II_field_c6dee247 -> "\u0422\u0435\u043b\u0435\u043f\u043e\u0440\u0442 \u043d\u0430 \u0448\u0430\u0445\u0442\u0443 (\u0430\u043d. " + var1 + ")";
         case Ii_field_c6dee247 -> this.II_field_5a
            ? "\u041a\u043e\u043f\u0430\u044e \u0448\u0430\u0445\u0442\u0443 (\u0430\u043d. " + var1 + ")"
            : "\u0416\u0434\u0443 \u0441\u0431\u0440\u043e\u0441\u0430 (\u0430\u043d. " + var1 + ")";
         case iI_field_c6dee247 -> "\u0418\u0434\u0443 \u043f\u0440\u043e\u0434\u0430\u0432\u0430\u0442\u044c (\u0430\u043d. "
            + (this.III_field_49 > 0 ? this.III_field_49 : "?")
            + ")";
         case ii_field_c6dee247 -> "\u041e\u0442\u043a\u0440\u044b\u0432\u0430\u044e \u0441\u043a\u0443\u043f\u0449\u0438\u043a\u0430";
         case III_field_c6dee247 -> "\u0412\u044b\u0431\u043e\u0440 \u0441\u0435\u043a\u0446\u0438\u0438";
         case IIi_field_c6dee247 -> "\u041f\u0440\u043e\u0434\u0430\u044e \u0440\u0443\u0434\u0443";
         case IiI_field_c6dee247 -> "\u0427\u0438\u043d\u044e \u043a\u0438\u0440\u043a\u0443 (" + this.II_method_6e029cf5() + " \u0431\u0443\u0442.)";
         case Iii_field_c6dee247, iII_field_c6dee247, iIi_field_c6dee247, iiI_field_c6dee247 -> "\u0417\u0430\u043a\u0443\u043f\u0430\u044e \u0431\u0443\u0442\u044b\u043b\u044c\u043a\u0438 ("
            + this.II_method_6e029cf5()
            + ")";
      };
   }

   private static String I_method_14835577(String var0) {
      if (var0 == null) {
         return "?";
      } else {
         String var1 = var0.toLowerCase();

         return switch (var1) {
            case "default" -> "def";
            case "legendary" -> "leg";
            case "mythical" -> "myth";
            default -> var0;
         };
      }
   }

   private static String I_method_840f8edb(long var0) {
      long var2 = var0 / 60L;
      long var4 = var0 % 60L;
      return String.format("%02d:%02d", var2, var4);
   }

   static enum Nested1_b9e87c40 {
      I_field_c6dee247,
      i_field_c6dee247,
      II_field_c6dee247,
      Ii_field_c6dee247,
      iI_field_c6dee247,
      ii_field_c6dee247,
      III_field_c6dee247,
      IIi_field_c6dee247,
      IiI_field_c6dee247,
      Iii_field_c6dee247,
      iII_field_c6dee247,
      iIi_field_c6dee247,
      iiI_field_c6dee247;
   }
}
