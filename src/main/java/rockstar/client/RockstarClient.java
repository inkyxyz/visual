package rockstar.client;

import globals.client.RocknetListener;
import globals.client.api.RockNetClient;
import globals.client.auth.SessionManager;
import globals.client.snowball.SnowballManager;
import globals.client.ui.RocknetMenu;
import lombok.Generated;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.SimpleSynchronousResourceReloadListener;
import net.funtimeevents.api.FunTimeEventsAPI;
import net.minecraft.entity.Entity;
import net.minecraft.resource.ResourceManager;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.mintantileak.spk.Compile;

public enum RockstarClient implements iIIiIIiIi_Class294 {
   I_field_502d1741;

   public static final String I_field_523beb0a = "Agravity";
   public static final String i_field_523beb0a = "1.0 alpha";
   public static final String II_field_523beb0a = "rockstar";
   public static final String Ii_field_523beb0a = "https://ftapi.rockstar.pub/v1/";
   public static final String iI_field_523beb0a = "rockstar.pub";
   public static final int I_field_49 = 443;
   public static final boolean I_field_5a = true;
   public static final String ii_field_523beb0a = "https://rockstar.pub";
   public static final Logger I_field_ab0f6068 = LoggerFactory.getLogger(II_field_523beb0a);
   public static Entity I_field_77e0818c;
   private IiIIIiIi_Class70 I_field_3d937321;
   private IiIIIiiII_Class141 I_field_74e906ac;
   private ModuleManager I_field_75f17721;
   private IIIiiiIi_Class30 I_field_79cbdb41;
   private IiIIiiII_Class77 I_field_3f565f61;
   private IiIIIIII_Class65 I_field_3d84e361;
   private iiIIiIiII_Class405 I_field_32ef4e4c;
   private iiIiiIiIi_Class438 I_field_cfb6ba4c;
   private IiIIIiIIi_Class138 I_field_74da7eac;
   private iiIiIIIiI_Class419 I_field_990d8ecc;
   private IiIIiIII_Class73 I_field_3f47d381;
   private iiIiiii_Class112 I_field_8c56b3ec;
   private IIiiiiiI_Class63 I_field_1693b7a1;
   private IiIiIiII_Class85 I_field_742e8321;
   private iiIIIIIi_Class194 I_field_c612c761;
   private iIIIiiiIi_Class286 I_field_ac24622c;
   private IiIiIIIii_Class164 I_field_fdf6ecc;
   private IiIIIiiii_Class144 I_field_74e982ac;
   private IiIIIiiiI_Class143 I_field_74e97ecc;
   private IiIIiIIIi_Class146 I_field_a9b2a26c;
   private IIiiIIiIi_Class102 I_field_83853e4c;
   private IiIIiIIII_Class145 I_field_a9b29e8c;
   private iiIIiIIi_Class202 I_field_c7d5b781;
   private IiIIIIiii_Class136 I_field_7326928c;
   private boolean i_field_5a;
   private RockNetClient I_field_4ef00546;
   private IIiiIIiiI_Class103 I_field_8385b28c;
   private IIiiIiiiI_Class111 I_field_8548a2ac;
   private IiIIIiiI_Class71 I_field_3d93e761;
   private iiiiIiI_Class123 I_field_c2e3380c;
   private IiiIIiiiI_Class207 I_field_710f1aac;
   private RocknetMenu I_field_bb171206;
   private iIiIIIIii_Class324 I_field_6fdde64c;
   boolean II_field_5a;

   @Compile(
      obfuscation = 4
   )
   public void initialize() {
      I_field_ab0f6068.info("Initializing {}...", "Agravity");
      SessionManager.bootstrapEarly("https://rockstar.pub/api/v1");
      IiIIiiIi_Class78.I_method_e728808c();
      this.I_field_990d8ecc = new iiIiIIIiI_Class419();
      this.I_field_a9b29e8c = new IiIIiIIII_Class145();
      this.I_field_8385b28c = new IIiiIIiiI_Class103();
      this.I_field_3d937321 = new IiIIIiIi_Class70();
      this.I_field_3f565f61 = new IiIIiiII_Class77();
      this.I_field_7326928c = new IiIIIIiii_Class136();
      this.I_field_74e906ac = new IiIIIiiII_Class141();
      this.I_field_3d84e361 = new IiIIIIII_Class65();
      this.I_field_32ef4e4c = new iiIIiIiII_Class405(new iiIIiiIiI_Class411());
      this.I_field_cfb6ba4c = new iiIiiIiIi_Class438();
      this.I_field_74da7eac = new IiIIIiIIi_Class138();
      this.I_field_3f47d381 = new IiIIiIII_Class73();
      this.I_field_75f17721 = new ModuleManager(new iiIIiiII_Class205(), new iiIIiiIi_Class206());
      this.I_field_fdf6ecc = new IiIiIIIii_Class164();
      this.I_field_ac24622c = new iIIIiiiIi_Class286();
      this.I_field_8c56b3ec = new iiIiiii_Class112();
      this.I_field_3f47d381.I_method_b467d0cc();
      this.I_field_75f17721.registerModules();
      this.I_field_75f17721.enableDefaultModules();
      this.I_field_4ef00546 = RockNetClient.init("rockstar.pub", 443, true);
      this.I_field_4ef00546.setListener(new RocknetListener());

      try {
         FunTimeEventsAPI.builder().userAgent("Rockstar").baseUrl("https://ftapi.rockstar.pub/v1/").build();
      } catch (Throwable var2) {
         I_field_ab0f6068.warn("FunTimeEvents SDK \u043d\u0435 \u043f\u043e\u0434\u043d\u044f\u043b\u0441\u044f: {}", var2.toString());
      }

      IIiiIiIiI_Class107.I_method_46031e89(this.I_field_4ef00546.getHttpBase());
      iiiiIII_Class121.I_method_56a08ca9(this.I_field_4ef00546.getHttpBase());
      SnowballManager.getInstance().register();
      IiiiiiiI_Class127.I_method_e1e653cb().I_method_731950cc();
      this.I_field_1693b7a1 = new IIiiiiiI_Class63();
      this.I_field_1693b7a1.I_method_7ce4a4ec();
      this.I_field_8548a2ac = new IIiiIiiiI_Class111();
      this.I_field_3d93e761 = new IiIIIiiI_Class71();
      this.I_field_c2e3380c = new iiiiIiI_Class123();
      this.I_field_79cbdb41 = new IIIiiiIi_Class30();
      this.I_field_79cbdb41.I_method_7a21f88c();
      this.I_field_742e8321 = new IiIiIiII_Class85();
      this.I_field_c612c761 = new iiIIIIIi_Class194();
      this.I_field_c7d5b781 = new iiIIiIIi_Class202();
      this.I_field_c7d5b781.I_method_bb63b4cc();
      this.I_field_3f47d381.i_method_b4765cac();
      this.I_field_4ef00546.connect();
      SessionManager.bootstrapAsync(this.I_field_4ef00546);
      ResourceManagerHelper.get(ResourceType.CLIENT_RESOURCES).registerReloadListener(new SimpleSynchronousResourceReloadListener() {
         public Identifier getFabricId() {
            return RockstarClient.id("after_shader_load");
         }

         public void reload(ResourceManager var1) {
            if (!RockstarClient.this.II_field_5a) {
               IIiIiI_Class11.i_method_c84528c();
               IIiiII_Class13.I_method_6bd3fa6c();
               IiiIi_Class14.i_method_a058d2bf();
            }
         }
      });
      iIiiIIiii_Class360.i_method_49c385df();
      IiiIi_Class14.I_method_68ff47d5(true);
      IiIiIIII_Class81.I_method_b508148c();
      this.I_field_6fdde64c = new iIiIIIIii_Class324();
      this.I_field_74e97ecc = new IiIIIiiiI_Class143();
      this.I_field_74e982ac = new IiIIIiiii_Class144();
      this.I_field_a9b2a26c = new IiIIiIIIi_Class146();
      this.I_field_83853e4c = new IIiiIIiIi_Class102();
      String var1 = System.getProperty("user.name");
      this.i_field_5a = !System.getProperty("os.name").toLowerCase().contains("windows");
      if (!this.i_field_5a && !var1.equals("sheluvparis")) {
         this.I_field_3d84e361.i_method_2be87c8c();
      }

      IIiiiiii_Class64.I_method_b37fb8cc();
      iIIIIiIii_Class268.I_method_43523a3f();
      new IiIIIIii_Class68();
      new iiIIiiIii_Class412();
      IiIiiIII_Class89.I_method_fc295fcb().I_method_3d95f4ac();
      I_field_ab0f6068.info("{} initialized", "Agravity");
   }

   public void shutdown() {
      I_field_ab0f6068.info("Shutting down...");
      if (!this.i_method_e8604970()) {
         this.I_field_1693b7a1.Ii_method_1fcd7bd5();
         if (this.I_field_3d93e761 != null) {
            this.I_field_3d93e761.i_method_c4d5808c();
         }

         this.I_field_c7d5b781.I_method_3a70cfeb().i_method_84d72ccc();
      }

      this.I_field_4ef00546.close();
      if (this.I_field_8548a2ac != null) {
         this.I_field_8548a2ac.II_method_9df2b0e2();
      }

      if (this.I_field_3d93e761 != null) {
         this.I_field_3d93e761.Ii_method_d4352415();
      }

      this.I_field_3f47d381.II_method_d8a14015();
      this.I_method_21e6a6c8(false);
   }

   public static RockstarClient getInstance() {
      return I_field_502d1741;
   }

   public static Identifier id(String var0) {
      return Identifier.of(II_field_523beb0a, var0);
   }

   @Generated
   public IiIIIiIi_Class70 I_method_7897deab() {
      return this.I_field_3d937321;
   }

   @Generated
   public IiIIIiiII_Class141 I_method_9a720c62() {
      return this.I_field_74e906ac;
   }

   @Generated
   public ModuleManager getModuleManager() {
      return this.I_field_75f17721;
   }

   @Generated
   public IIIiiiIi_Class30 I_method_b4d046cb() {
      return this.I_field_79cbdb41;
   }

   @Generated
   public IiIIiiII_Class77 I_method_7a5acaeb() {
      return this.I_field_3f565f61;
   }

   @Generated
   public IiIIIIII_Class65 I_method_78894eeb() {
      return this.I_field_3d84e361;
   }

   @Generated
   public iiIIiIiII_Class405 I_method_58785402() {
      return this.I_field_32ef4e4c;
   }

   @Generated
   public iiIiiIiIi_Class438 I_method_f53fc002() {
      return this.I_field_cfb6ba4c;
   }

   @Generated
   public IiIIIiIIi_Class138 I_method_9a638462() {
      return this.I_field_74da7eac;
   }

   @Generated
   public iiIiIIIiI_Class419 I_method_be969482() {
      return this.I_field_990d8ecc;
   }

   @Generated
   public IiIIiIII_Class73 I_method_7a4c3f0b() {
      return this.I_field_3f47d381;
   }

   @Generated
   public iiIiiii_Class112 I_method_5cb1af22() {
      return this.I_field_8c56b3ec;
   }

   @Generated
   public IIiiiiiI_Class63 I_method_5198232b() {
      return this.I_field_1693b7a1;
   }

   @Generated
   public IiIiIiII_Class85 I_method_af32eeab() {
      return this.I_field_742e8321;
   }

   @Generated
   public iiIIIIIi_Class194 I_method_11732eb() {
      return this.I_field_c612c761;
   }

   @Generated
   public iIIIiiiIi_Class286 I_method_d1ad67e2() {
      return this.I_field_ac24622c;
   }

   @Generated
   public IiIiIIIii_Class164 I_method_35687482() {
      return this.I_field_fdf6ecc;
   }

   @Generated
   public IiIIIiiii_Class144 I_method_9a728862() {
      return this.I_field_74e982ac;
   }

   @Generated
   public IiIIIiiiI_Class143 I_method_9a728482() {
      return this.I_field_74e97ecc;
   }

   @Generated
   public IiIIiIIIi_Class146 I_method_cf3ba822() {
      return this.I_field_a9b2a26c;
   }

   @Generated
   public IIiiIIiIi_Class102 I_method_a90e4402() {
      return this.I_field_83853e4c;
   }

   @Generated
   public IiIIiIIII_Class145 I_method_cf3ba442() {
      return this.I_field_a9b29e8c;
   }

   @Generated
   public iiIIiIIi_Class202 I_method_2da230b() {
      return this.I_field_c7d5b781;
   }

   @Generated
   public IiIIIIiii_Class136 I_method_98af9842() {
      return this.I_field_7326928c;
   }

   @Generated
   public boolean I_method_e851bd90() {
      return this.i_field_5a;
   }

   @Generated
   public RockNetClient I_method_cd3d46d0() {
      return this.I_field_4ef00546;
   }

   @Generated
   public IIiiIIiiI_Class103 I_method_a90eb842() {
      return this.I_field_8385b28c;
   }

   @Generated
   public IIiiIiiiI_Class111 I_method_aad1a862() {
      return this.I_field_8548a2ac;
   }

   @Generated
   public IiIIIiiI_Class71 I_method_789852eb() {
      return this.I_field_3d93e761;
   }

   @Generated
   public iiiiIiI_Class123 I_method_933e3342() {
      return this.I_field_c2e3380c;
   }

   @Generated
   public IiiIIiiiI_Class207 I_method_96982062() {
      return this.I_field_710f1aac;
   }

   @Generated
   public RocknetMenu I_method_449a4cbc() {
      return this.I_field_bb171206;
   }

   @Generated
   public iIiIIIIii_Class324 I_method_9566ec02() {
      return this.I_field_6fdde64c;
   }

   @Generated
   public boolean i_method_e8604970() {
      return this.II_field_5a;
   }

   @Generated
   public void I_method_3eb992(RockNetClient var1) {
      this.I_field_4ef00546 = var1;
   }

   @Generated
   public void I_method_577f3d5a(IiiIIiiiI_Class207 var1) {
      this.I_field_710f1aac = var1;
   }

   @Generated
   public void I_method_d0f1adb4(RocknetMenu var1) {
      this.I_field_bb171206 = var1;
   }

   @Generated
   public void I_method_21e6a6c8(boolean var1) {
      this.II_field_5a = var1;
   }
}
