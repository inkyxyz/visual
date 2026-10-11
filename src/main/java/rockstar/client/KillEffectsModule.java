package rockstar.client;

import com.mojang.blaze3d.platform.GlStateManager.DstFactor;
import com.mojang.blaze3d.platform.GlStateManager.SrcFactor;
import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.DefaultSkinHelper;
import net.minecraft.client.util.SkinTextures;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.decoration.ArmorStandEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.EntityDeathEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;
import ua.mintantileak.spk.Compile;

@ModuleInfo(
   name = "Kill Effects",
   category = ModuleCategory.VISUALS,
   iI_method_476ab839 = true,
   III_method_a89e5834 = "modules.descriptions.kill_effects"
)
public class KillEffectsModule extends Module {
   private final List<KillEffectsModule.Nested1_a9895880> lightningEffects = new CopyOnWriteArrayList<>();
   private final List<KillEffectsModule.Nested1_a9895860> particleEffects = new CopyOnWriteArrayList<>();
   private final List<TombstoneEffect> tombstoneEffects = new CopyOnWriteArrayList<>();
   private final List<SingularityEffect> singularityEffects = new CopyOnWriteArrayList<>();
   private final List<FireworkEffect> fireworkEffects = new CopyOnWriteArrayList<>();
   private final List<SoulAscendEffect> soulAscendEffects = new CopyOnWriteArrayList<>();
   private final List<SupernovaEffect> supernovaEffects = new CopyOnWriteArrayList<>();
   private final List<GlitchMatrixEffect> glitchMatrixEffects = new CopyOnWriteArrayList<>();
   private final List<HolyAscensionEffect> holyAscensionEffects = new CopyOnWriteArrayList<>();
   private final List<AngelicAscensionEffect> angelicAscensionEffects = new CopyOnWriteArrayList<>();
   private final List<BlackHoleEffect> blackHoleEffects = new CopyOnWriteArrayList<>();
   private final List<BloodExplosionEffect> bloodExplosionEffects = new CopyOnWriteArrayList<>();
   private final List<BloodPillarEffect> bloodPillarEffects = new CopyOnWriteArrayList<>();
   private final List<CardDeckAscensionEffect> cardDeckAscensionEffects = new CopyOnWriteArrayList<>();
   private final List<DisintegrationEffect> disintegrationEffects = new CopyOnWriteArrayList<>();
   private final List<NetherPortalAbductionEffect> netherPortalEffects = new CopyOnWriteArrayList<>();
   private final List<SingularityCollapseEffect> singularityCollapseEffects = new CopyOnWriteArrayList<>();
   private final List<GlacialTombEffect> glacialTombEffects = new CopyOnWriteArrayList<>();
   private final List<CyberVortexEffect> cyberVortexEffects = new CopyOnWriteArrayList<>();
   private final List<QuantumShatterEffect> quantumShatterEffects = new CopyOnWriteArrayList<>();
   private final List<SolarFlareEffect> solarFlareEffects = new CopyOnWriteArrayList<>();
   private final List<VoidTentaclesEffect> voidTentaclesEffects = new CopyOnWriteArrayList<>();

   private static PlayerEntityModel VICTIM_MODEL;

   public static PlayerEntityModel getVictimModel() {
      if (VICTIM_MODEL == null) {
         try {
            VICTIM_MODEL = new PlayerEntityModel(
               MinecraftClient.getInstance().getLoadedEntityModels().getModelPart(EntityModelLayers.PLAYER),
               false
            );
         } catch (Throwable ignored) {}
      }
      return VICTIM_MODEL;
   }

   static final Random RANDOM = new Random();
   private ModeSetting modeSetting;
   
   // Modes
   private ModeSetting.Nested1_42765c60 modeLightning;
   private ModeSetting.Nested1_42765c60 modeParticles;
   private ModeSetting.Nested1_42765c60 modeBlood;
   private ModeSetting.Nested1_42765c60 modeTombstone;
   private ModeSetting.Nested1_42765c60 modeSingularity;
   private ModeSetting.Nested1_42765c60 modeFirework;
   private ModeSetting.Nested1_42765c60 modeSoulAscend;
   private ModeSetting.Nested1_42765c60 modeSupernova;
   private ModeSetting.Nested1_42765c60 modeGlitchMatrix;
   private ModeSetting.Nested1_42765c60 modeHolyAscension;
   private ModeSetting.Nested1_42765c60 modeAngelic;
   private ModeSetting.Nested1_42765c60 modeBlackHole;
   private ModeSetting.Nested1_42765c60 modeBloodExplosion;
   private ModeSetting.Nested1_42765c60 modeBloodPillar;
   private ModeSetting.Nested1_42765c60 modeCardDeckAscension;
   private ModeSetting.Nested1_42765c60 modeNetherPortal;
   private ModeSetting.Nested1_42765c60 modeSingularityCollapse;
   private ModeSetting.Nested1_42765c60 modeGlacialTomb;
   private ModeSetting.Nested1_42765c60 modeCyberVortex;
   private ModeSetting.Nested1_42765c60 modeQuantumShatter;
   private ModeSetting.Nested1_42765c60 modeSolarFlare;
   private ModeSetting.Nested1_42765c60 modeVoidTentacles;
   private BooleanSetting disintegrationSetting;

   private ModeSetting cardDeckSetting;
   private ModeSetting.Nested1_42765c60 deckUnoCards;
   private ModeSetting.Nested1_42765c60 deckClassicPoker;
   private ModeSetting.Nested1_42765c60 deckRoyalFlush;
   private ModeSetting.Nested1_42765c60 deckAcesOnly;
   private ModeSetting.Nested1_42765c60 deckCourtCards;
   private ModeSetting.Nested1_42765c60 deckJokersWild;

   private ModeSetting cardBackSetting;
   private ModeSetting.Nested1_42765c60 backMeshRed;
   private ModeSetting.Nested1_42765c60 backMeshBlue;
   private ModeSetting.Nested1_42765c60 backUno;
   private ModeSetting.Nested1_42765c60 backBicycle;
   private ModeSetting.Nested1_42765c60 backRoyalGold;
   private ModeSetting.Nested1_42765c60 backCyberNeon;
   private ModeSetting.Nested1_42765c60 backDarkArcane;

   private SliderSetting durationSetting;
   private ModeSetting particlePhysics;
   private ModeSetting.Nested1_42765c60 physicsGravity;
   private ModeSetting.Nested1_42765c60 physicsScatter;
   private BooleanSetting syncTheme;
   private ColorSetting customColor;

   private boolean isCardMode() {
      return this.modeCardDeckAscension != null && this.modeCardDeckAscension.isSelected();
   }

   private Identifier[] getActiveDeck() {
      if (this.cardDeckSetting != null) {
         if (this.cardDeckSetting.isSelected("Uno Cards")) return CardRenderHelper.UNO_CARDS;
         if (this.cardDeckSetting.isSelected("Royal Flush")) return CardRenderHelper.ROYAL_FLUSH_CARDS;
         if (this.cardDeckSetting.isSelected("Aces Only")) return CardRenderHelper.ACES;
         if (this.cardDeckSetting.isSelected("Court Cards")) return CardRenderHelper.COURT_CARDS;
         if (this.cardDeckSetting.isSelected("Jokers Wild")) return CardRenderHelper.JOKERS;
         if (this.cardDeckSetting.isSelected("Classic Poker")) return CardRenderHelper.ALL_CARDS;
         if (this.cardDeckSetting.i_method_f85f3850() != null) {
            return CardRenderHelper.getDeckCards(this.cardDeckSetting.i_method_f85f3850().getName());
         }
      }
      return CardRenderHelper.ALL_CARDS;
   }

   private Identifier getActiveBack() {
      if (this.cardBackSetting != null) {
         if (this.cardBackSetting.isSelected("Uno Classic")) return CardRenderHelper.CARD_BACK_UNO;
         if (this.cardBackSetting.isSelected("Classic Mesh (Blue)")) return CardRenderHelper.CARD_BACK_MESH_BLUE;
         if (this.cardBackSetting.isSelected("Classic Mesh (Red)")) return CardRenderHelper.CARD_BACK_MESH;
         if (this.cardBackSetting.isSelected("Bicycle Classic")) return CardRenderHelper.CARD_BACK_BICYCLE;
         if (this.cardBackSetting.isSelected("Royal Gold")) return CardRenderHelper.CARD_BACK_ROYAL;
         if (this.cardBackSetting.isSelected("Cyber Neon")) return CardRenderHelper.CARD_BACK_CYBER;
         if (this.cardBackSetting.isSelected("Dark Arcane")) return CardRenderHelper.CARD_BACK_ARCANE;
         if (this.cardBackSetting.i_method_f85f3850() != null) {
            return CardRenderHelper.getDeckBack(this.cardBackSetting.i_method_f85f3850().getName());
         }
      }
      return CardRenderHelper.CARD_BACK_MESH;
   }

   private final IiIIIiII_Class69<EntityDeathEvent> deathListener = var1 -> {
      if (!var1.getEntity().isRemoved() && !(var1.getEntity() instanceof ArmorStandEntity)) {
         ColorRGBA var2 = this.syncTheme.i_method_9b12da03() ? IiiiiIIIi_Class242.i_method_5dfec6e() : this.customColor.I_method_bde5f08e();
         Vec3d pos = var1.getEntity().getPos();
         float entityYaw = var1.getEntity().getYaw();
         SkinTextures entitySkin = (var1.getEntity() instanceof AbstractClientPlayerEntity p)
            ? p.getSkinTextures()
            : DefaultSkinHelper.getSkinTextures(UUID.randomUUID());

         // Standalone Disintegration / Рассеивание checkbox (can trigger across all kill effects!)
         if (this.disintegrationSetting != null && this.disintegrationSetting.i_method_9b12da03()) {
            this.disintegrationEffects.add(new DisintegrationEffect(pos, var2));
         }

         if (this.modeLightning != null && this.modeLightning.isSelected()) {
            this.lightningEffects.add(new KillEffectsModule.Nested1_a9895880(pos, var2));
         } else if (this.modeParticles != null && this.modeParticles.isSelected()) {
            this.I_method_9937b821(var1.getEntity(), var2);
         } else if (this.modeBlood != null && this.modeBlood.isSelected()) {
            this.spawnBlood(pos);
         } else if (this.modeTombstone != null && this.modeTombstone.isSelected()) {
            this.tombstoneEffects.add(new TombstoneEffect(pos, var2));
         } else if (this.modeSingularity != null && this.modeSingularity.isSelected()) {
            this.singularityEffects.add(new SingularityEffect(pos, var2));
         } else if (this.modeFirework != null && this.modeFirework.isSelected()) {
            this.fireworkEffects.add(new FireworkEffect(pos, var2));
         } else if (this.modeSoulAscend != null && this.modeSoulAscend.isSelected()) {
            this.soulAscendEffects.add(new SoulAscendEffect(pos, var2));
         } else if (this.modeSupernova != null && this.modeSupernova.isSelected()) {
            this.supernovaEffects.add(new SupernovaEffect(pos, var2));
         } else if (this.modeGlitchMatrix != null && this.modeGlitchMatrix.isSelected()) {
            this.glitchMatrixEffects.add(new GlitchMatrixEffect(pos, var2));
         } else if ((this.modeHolyAscension != null && this.modeHolyAscension.isSelected()) || (this.modeAngelic != null && this.modeAngelic.isSelected())) {
            this.holyAscensionEffects.add(new HolyAscensionEffect(pos, var2));
            this.angelicAscensionEffects.add(new AngelicAscensionEffect(pos, var2, entitySkin, entityYaw));
         } else if (this.modeBlackHole != null && this.modeBlackHole.isSelected()) {
            this.blackHoleEffects.add(new BlackHoleEffect(pos, var2));
         } else if (this.modeBloodExplosion != null && this.modeBloodExplosion.isSelected()) {
            this.bloodExplosionEffects.add(new BloodExplosionEffect(pos, var2));
         } else if (this.modeBloodPillar != null && this.modeBloodPillar.isSelected()) {
            long durMs = (long)(this.durationSetting.Ii_method_a20abcd2() * 1000.0F);
            this.bloodPillarEffects.add(new BloodPillarEffect(pos, var2, durMs));
         } else if (this.modeCardDeckAscension != null && this.modeCardDeckAscension.isSelected()) {
            long durMs = (long)(this.durationSetting.Ii_method_a20abcd2() * 1000.0F);
            this.cardDeckAscensionEffects.add(new CardDeckAscensionEffect(pos, var2, durMs, this.getActiveDeck(), this.getActiveBack()));
         } else if (this.modeNetherPortal != null && this.modeNetherPortal.isSelected()) {
            this.netherPortalEffects.add(new NetherPortalAbductionEffect(pos, var2, entitySkin, entityYaw));
         } else if (this.modeSingularityCollapse != null && this.modeSingularityCollapse.isSelected()) {
            this.singularityCollapseEffects.add(new SingularityCollapseEffect(pos, var2, entitySkin, entityYaw));
         } else if (this.modeGlacialTomb != null && this.modeGlacialTomb.isSelected()) {
            this.glacialTombEffects.add(new GlacialTombEffect(pos, var2, entitySkin, entityYaw));
         } else if (this.modeCyberVortex != null && this.modeCyberVortex.isSelected()) {
            this.cyberVortexEffects.add(new CyberVortexEffect(pos, var2));
         } else if (this.modeQuantumShatter != null && this.modeQuantumShatter.isSelected()) {
            this.quantumShatterEffects.add(new QuantumShatterEffect(pos, var2));
         } else if (this.modeSolarFlare != null && this.modeSolarFlare.isSelected()) {
            this.solarFlareEffects.add(new SolarFlareEffect(pos, var2));
         } else if (this.modeVoidTentacles != null && this.modeVoidTentacles.isSelected()) {
            this.voidTentaclesEffects.add(new VoidTentaclesEffect(pos, var2, entitySkin, entityYaw));
         }
      }
   };

   private final IiIIIiII_Class69<Render3DEvent> renderListener = var1 -> {
      MatrixStack var2 = var1.getMatrices();
      Camera var3 = I_field_3a9bda27.gameRenderer.getCamera();
      var2.push();
      RenderSystem.enableBlend();
      RenderSystem.blendFunc(SrcFactor.SRC_ALPHA, DstFactor.ONE);
      RenderSystem.enableDepthTest();
      RenderSystem.disableCull();
      RenderSystem.depthMask(false);
      Identifier var4 = RockstarClient.id("textures/bloom.png");
      RenderSystem.setShaderTexture(0, var4);
      RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
      BufferBuilder var5 = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);

      for (KillEffectsModule.Nested1_a9895880 var7 : this.lightningEffects) {
         var7.I_method_b08fd268(var5, var1.getMatrices(), var3);
         if (var7.I_field_dc7facc.I_method_6ac4da6f() == 1.0F) {
            var7.I_field_5a = false;
         }
      }

      for (KillEffectsModule.Nested1_a9895860 var10 : this.particleEffects) {
         if (!var10.I_method_b508e75e()) {
            var10.I_method_b508e75a();
            var10.I_method_c50ff315(var1, var5);
         }
      }

      for (TombstoneEffect te : this.tombstoneEffects) {
         if (!te.isExpired()) {
            te.render(var1, var5, var3);
         }
      }

      for (SingularityEffect se : this.singularityEffects) {
         if (!se.isExpired()) {
            se.render(var1, var5, var3);
         }
      }

      for (FireworkEffect fe : this.fireworkEffects) {
         if (!fe.isExpired()) {
            fe.render(var1, var5, var3);
         }
      }

      for (SoulAscendEffect sa : this.soulAscendEffects) {
         if (!sa.isExpired()) {
            sa.render(var1, var5, var3);
         }
      }

      for (SupernovaEffect se : this.supernovaEffects) {
         if (!se.isExpired()) se.render(var1, var5, var3);
      }
      for (GlitchMatrixEffect gm : this.glitchMatrixEffects) {
         if (!gm.isExpired()) gm.render(var1, var5, var3);
      }
      for (HolyAscensionEffect ha : this.holyAscensionEffects) {
         if (!ha.isExpired()) ha.render(var1, var5, var3);
      }
      for (AngelicAscensionEffect aae : this.angelicAscensionEffects) {
         if (!aae.isExpired()) aae.render(var1, var5, var3);
      }
      for (BlackHoleEffect bh : this.blackHoleEffects) {
         if (!bh.isExpired()) bh.render(var1, var5, var3);
      }
      for (BloodExplosionEffect be : this.bloodExplosionEffects) {
         if (!be.isExpired()) be.render(var1, var5, var3);
      }
      for (BloodPillarEffect bp : this.bloodPillarEffects) {
         if (!bp.isExpired()) bp.render(var1, var5, var3);
      }
      for (CardDeckAscensionEffect cda : this.cardDeckAscensionEffects) {
         if (!cda.isExpired()) cda.render(var1, var5, var3);
      }
      for (DisintegrationEffect de : this.disintegrationEffects) {
         if (!de.isExpired()) de.render(var1, var5, var3);
      }
      for (NetherPortalAbductionEffect npa : this.netherPortalEffects) {
         if (!npa.isExpired()) npa.render(var1, var5, var3);
      }
      for (SingularityCollapseEffect sce : this.singularityCollapseEffects) {
         if (!sce.isExpired()) sce.render(var1, var5, var3);
      }
      for (GlacialTombEffect gte : this.glacialTombEffects) {
         if (!gte.isExpired()) gte.render(var1, var5, var3);
      }
      for (CyberVortexEffect cve : this.cyberVortexEffects) {
         if (!cve.isExpired()) cve.render(var1, var5, var3);
      }
      for (QuantumShatterEffect qse : this.quantumShatterEffects) {
         if (!qse.isExpired()) qse.render(var1, var5, var3);
      }
      for (SolarFlareEffect sfe : this.solarFlareEffects) {
         if (!sfe.isExpired()) sfe.render(var1, var5, var3);
      }
      for (VoidTentaclesEffect vte : this.voidTentaclesEffects) {
         if (!vte.isExpired()) vte.render(var1, var5, var3);
      }

      this.particleEffects.removeIf(KillEffectsModule.Nested1_a9895860::I_method_b508e75e);
      this.tombstoneEffects.removeIf(TombstoneEffect::isExpired);
      this.singularityEffects.removeIf(SingularityEffect::isExpired);
      this.fireworkEffects.removeIf(FireworkEffect::isExpired);
      this.soulAscendEffects.removeIf(SoulAscendEffect::isExpired);
      this.supernovaEffects.removeIf(SupernovaEffect::isExpired);
      this.glitchMatrixEffects.removeIf(GlitchMatrixEffect::isExpired);
      this.holyAscensionEffects.removeIf(HolyAscensionEffect::isExpired);
      this.angelicAscensionEffects.removeIf(AngelicAscensionEffect::isExpired);
      this.blackHoleEffects.removeIf(BlackHoleEffect::isExpired);
      this.bloodExplosionEffects.removeIf(BloodExplosionEffect::isExpired);
      this.bloodPillarEffects.removeIf(BloodPillarEffect::isExpired);
      this.cardDeckAscensionEffects.removeIf(CardDeckAscensionEffect::isExpired);
      this.disintegrationEffects.removeIf(DisintegrationEffect::isExpired);
      this.netherPortalEffects.removeIf(NetherPortalAbductionEffect::isExpired);
      this.singularityCollapseEffects.removeIf(SingularityCollapseEffect::isExpired);
      this.glacialTombEffects.removeIf(GlacialTombEffect::isExpired);
      this.cyberVortexEffects.removeIf(CyberVortexEffect::isExpired);
      this.quantumShatterEffects.removeIf(QuantumShatterEffect::isExpired);
      this.solarFlareEffects.removeIf(SolarFlareEffect::isExpired);
      this.voidTentaclesEffects.removeIf(VoidTentaclesEffect::isExpired);

      BuiltBuffer var9 = var5.endNullable();
      if (var9 != null) {
         BufferRenderer.drawWithGlobalProgram(var9);
      }

      // Render 3D player models for cinematic kill effects
      for (AngelicAscensionEffect aae : this.angelicAscensionEffects) {
         if (!aae.isExpired()) aae.renderModel(var1, var3);
      }
      for (NetherPortalAbductionEffect npa : this.netherPortalEffects) {
         if (!npa.isExpired()) npa.renderModel(var1, var3);
      }
      for (SingularityCollapseEffect sce : this.singularityCollapseEffects) {
         if (!sce.isExpired()) sce.renderModel(var1, var3);
      }
      for (GlacialTombEffect gte : this.glacialTombEffects) {
         if (!gte.isExpired()) gte.renderModel(var1, var3);
      }
      for (VoidTentaclesEffect vte : this.voidTentaclesEffects) {
         if (!vte.isExpired()) vte.renderModel(var1, var3);
      }

      RenderSystem.depthMask(true);
      RenderSystem.setShaderTexture(0, 0);
      RenderSystem.disableBlend();
      RenderSystem.enableCull();
      RenderSystem.disableDepthTest();
      var2.pop();
      this.lightningEffects.removeIf(var0 -> !var0.I_field_5a && var0.I_field_dc7facc.I_method_6ac4da6f() == 0.0F);
   };

   private final IiIIIiII_Class69<WorldChangeEvent> worldChangeListener = var1 -> {
      this.lightningEffects.clear();
      this.particleEffects.clear();
      this.tombstoneEffects.clear();
      this.singularityEffects.clear();
      this.fireworkEffects.clear();
      this.soulAscendEffects.clear();
      this.supernovaEffects.clear();
      this.glitchMatrixEffects.clear();
      this.holyAscensionEffects.clear();
      this.angelicAscensionEffects.clear();
      this.blackHoleEffects.clear();
      this.bloodExplosionEffects.clear();
      this.bloodPillarEffects.clear();
      this.cardDeckAscensionEffects.clear();
      this.disintegrationEffects.clear();
      this.netherPortalEffects.clear();
      this.singularityCollapseEffects.clear();
      this.glacialTombEffects.clear();
      this.cyberVortexEffects.clear();
      this.quantumShatterEffects.clear();
      this.solarFlareEffects.clear();
      this.voidTentaclesEffects.clear();
   };

   public KillEffectsModule() {
      this.IiI_method_c946a29f();
   }

   @Compile(
      obfuscation = 4
   )
   private void IiI_method_c946a29f() {
      this.modeSetting = new ModeSetting(this, "modules.settings.kill_effects.mode");
      this.modeLightning = new ModeSetting.Nested1_42765c60(this.modeSetting, "Lightning");
      this.modeParticles = new ModeSetting.Nested1_42765c60(this.modeSetting, "Particles").select();
      this.modeBlood = new ModeSetting.Nested1_42765c60(this.modeSetting, "Blood");
      this.modeTombstone = new ModeSetting.Nested1_42765c60(this.modeSetting, "Tombstone");
      this.modeSingularity = new ModeSetting.Nested1_42765c60(this.modeSetting, "Singularity");
      this.modeFirework = new ModeSetting.Nested1_42765c60(this.modeSetting, "Firework");
      this.modeSoulAscend = new ModeSetting.Nested1_42765c60(this.modeSetting, "Soul Ascend");
      this.modeSupernova = new ModeSetting.Nested1_42765c60(this.modeSetting, "Supernova");
      this.modeGlitchMatrix = new ModeSetting.Nested1_42765c60(this.modeSetting, "GlitchMatrix");
      this.modeHolyAscension = new ModeSetting.Nested1_42765c60(this.modeSetting, "HolyAscension");
      this.modeAngelic = new ModeSetting.Nested1_42765c60(this.modeSetting, "Angelic Ascension");
      this.modeBlackHole = new ModeSetting.Nested1_42765c60(this.modeSetting, "BlackHole");
      this.modeBloodExplosion = new ModeSetting.Nested1_42765c60(this.modeSetting, "BloodExplosion");
      this.modeBloodPillar = new ModeSetting.Nested1_42765c60(this.modeSetting, "Blood Pillar");
      this.modeCardDeckAscension = new ModeSetting.Nested1_42765c60(this.modeSetting, "Card Deck Ascension");
      this.modeNetherPortal = new ModeSetting.Nested1_42765c60(this.modeSetting, "Nether Abduction");
      this.modeSingularityCollapse = new ModeSetting.Nested1_42765c60(this.modeSetting, "Celestial Judgement");
      this.modeGlacialTomb = new ModeSetting.Nested1_42765c60(this.modeSetting, "Glacial Tomb");
      this.modeCyberVortex = new ModeSetting.Nested1_42765c60(this.modeSetting, "Cyber Vortex");
      this.modeQuantumShatter = new ModeSetting.Nested1_42765c60(this.modeSetting, "Quantum Shatter");
      this.modeSolarFlare = new ModeSetting.Nested1_42765c60(this.modeSetting, "Solar Flare");
      this.modeVoidTentacles = new ModeSetting.Nested1_42765c60(this.modeSetting, "Void Tentacles");

      this.disintegrationSetting = new BooleanSetting(this, "Рассеивание").I_method_decd82b5();

      this.cardDeckSetting = new ModeSetting(this, "Card Deck", () -> !this.isCardMode());
      this.deckUnoCards = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Uno Cards");
      this.deckClassicPoker = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Classic Poker").select();
      this.deckRoyalFlush = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Royal Flush");
      this.deckAcesOnly = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Aces Only");
      this.deckCourtCards = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Court Cards");
      this.deckJokersWild = new ModeSetting.Nested1_42765c60(this.cardDeckSetting, "Jokers Wild");

      this.cardBackSetting = new ModeSetting(this, "Card Back", () -> !this.isCardMode());
      this.backMeshRed = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Classic Mesh (Red)").select();
      this.backMeshBlue = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Classic Mesh (Blue)");
      this.backUno = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Uno Classic");
      this.backBicycle = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Bicycle Classic");
      this.backRoyalGold = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Royal Gold");
      this.backCyberNeon = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Cyber Neon");
      this.backDarkArcane = new ModeSetting.Nested1_42765c60(this.cardBackSetting, "Dark Arcane");

      this.durationSetting = new SliderSetting(this, "Duration (s)")
         .I_method_c8c9a7d7(0.5F).i_method_65e2aff7(5.0F).II_method_b0f56334(0.25F).Ii_method_4e0e6b54(1.8F);

      this.particlePhysics = new ModeSetting(
         this, "modules.settings.kill_effects.particlePhysics", () -> this.modeParticles == null || !this.modeParticles.isSelected()
      );
      this.physicsGravity = new ModeSetting.Nested1_42765c60(this.particlePhysics, "modules.settings.kill_effects.particlePhysics.gravity");
      this.physicsScatter = new ModeSetting.Nested1_42765c60(this.particlePhysics, "modules.settings.kill_effects.particlePhysics.scatter").select();
      this.syncTheme = new BooleanSetting(this, "theme.sync").I_method_decd82b5();
      this.customColor = new ColorSetting(this, "modules.settings.kill_effects.color", this.syncTheme::i_method_9b12da03)
         .I_method_a62f5dd6(IiiiiIIIi_Class242.i_method_5dfec6e());
   }

   private void spawnBlood(Vec3d pos) {
      ColorRGBA bloodCol = new ColorRGBA(190.0F, 15.0F, 20.0F, 255.0F);
      ColorRGBA darkBlood = new ColorRGBA(120.0F, 5.0F, 10.0F, 255.0F);
      for (int i = 0; i < 90; i++) {
         float vx = (RANDOM.nextFloat() - 0.5F) * 0.08F;
         float vy = 0.03F + RANDOM.nextFloat() * 0.06F;
         float vz = (RANDOM.nextFloat() - 0.5F) * 0.08F;
         ColorRGBA col = (i % 2 == 0) ? bloodCol : darkBlood;
         this.particleEffects.add(new KillEffectsModule.Nested1_a9895860(
            pos.add(0.0, 0.8, 0.0),
            (RANDOM.nextFloat() - 0.5F) * 0.4F,
            (RANDOM.nextFloat() - 0.5F) * 0.4F,
            (RANDOM.nextFloat() - 0.5F) * 0.4F,
            vx, vy, vz, col, true
         ));
      }
   }

   private void I_method_9937b821(LivingEntity var1, ColorRGBA var2) {
      Vec3d var3 = var1.getPos();
      float var4 = var1.getHeight();
      float var5 = var1.getWidth();
      float var6 = (float)Math.toRadians(-var1.bodyYaw + 90.0F);
      boolean var7 = this.particlePhysics.I_method_ce989e26(this.physicsGravity);
      short var8 = 250;
      float var9 = var4 - 0.2F;
      float var10 = var5 * 0.4F;
      this.I_method_7680cd27(var3.add(0.0, var9, 0.0), var10, var8 / 10, var6, var2, var7);
      float var11 = var4 * 0.85F;
      float var12 = var4 * 0.4F;
      float var13 = var5 * 0.4F;
      float var14 = var5 * 0.2F;
      this.I_method_4cdff743(var3, var12, var11, var13, var14, var6, var8 / 4, var2, var7);
      float var15 = var4 * 0.4F;
      float var16 = var5 * 0.15F;

      for (int var17 = -1; var17 <= 1; var17 += 2) {
         Vec3d var18 = new Vec3d(Math.sin(var6) * var5 * 0.5 * var17, var4 * 0.75F, Math.cos(var6) * var5 * 0.5 * var17);
         this.I_method_9eb5a603(var3.add(var18), var15, var16, var6, var8 / 8, var2, var7);
      }

      float var21 = var4 * 0.45F;
      float var22 = var5 * 0.15F;

      for (int var19 = -1; var19 <= 1; var19 += 2) {
         Vec3d var20 = new Vec3d(Math.sin(var6) * var5 * 0.15F * var19, var4 * 0.4F, Math.cos(var6) * var5 * 0.15F * var19);
         this.I_method_9eb5a603(var3.add(var20), var21, var22, var6, var8 / 6, var2, var7);
      }
   }

   private void I_method_7680cd27(Vec3d var1, float var2, int var3, float var4, ColorRGBA var5, boolean var6) {
      for (int var7 = 0; var7 < var3; var7++) {
         float var8 = RANDOM.nextFloat() * (float) Math.PI * 2.0F;
         float var9 = (float)Math.acos(2.0F * RANDOM.nextFloat() - 1.0F);
         float var10 = var2 * (float)Math.cbrt(RANDOM.nextFloat());
         float var11 = var10 * (float)(Math.sin(var9) * Math.cos(var8));
         float var12 = var10 * (float)(Math.sin(var9) * Math.sin(var8));
         float var13 = var10 * (float)Math.cos(var9);
         float var14 = var6 ? 0.02F : 0.008F;
         float var15 = (RANDOM.nextFloat() - 0.5F) * var14;
         float var16 = var6 ? 0.03F + RANDOM.nextFloat() * 0.04F : (RANDOM.nextFloat() - 0.5F) * 0.008F;
         float var17 = (RANDOM.nextFloat() - 0.5F) * var14;
         this.particleEffects.add(new KillEffectsModule.Nested1_a9895860(var1, var11, var12, var13, var15, var16, var17, var5, var6));
      }
   }

   private void I_method_4cdff743(Vec3d var1, float var2, float var3, float var4, float var5, float var6, int var7, ColorRGBA var8, boolean var9) {
      for (int var10 = 0; var10 < var7; var10++) {
         float var11 = (RANDOM.nextFloat() - 0.5F) * var4 * 2.0F;
         float var12 = var2 + RANDOM.nextFloat() * (var3 - var2);
         float var13 = (RANDOM.nextFloat() - 0.5F) * var5 * 2.0F;
         float var14 = (float)(var11 * Math.cos(var6) - var13 * Math.sin(var6));
         float var15 = (float)(var11 * Math.sin(var6) + var13 * Math.cos(var6));
         float var16 = var9 ? 0.025F : 0.01F;
         float var17 = (RANDOM.nextFloat() - 0.5F) * var16;
         float var18 = var9 ? 0.04F + RANDOM.nextFloat() * 0.05F : (RANDOM.nextFloat() - 0.5F) * 0.01F;
         float var19 = (RANDOM.nextFloat() - 0.5F) * var16;
         this.particleEffects.add(new KillEffectsModule.Nested1_a9895860(var1, var14, var12, var15, var17, var18, var19, var8, var9));
      }
   }

   private void I_method_9eb5a603(Vec3d var1, float var2, float var3, float var4, int var5, ColorRGBA var6, boolean var7) {
      for (int var8 = 0; var8 < var5; var8++) {
         float var9 = RANDOM.nextFloat();
         float var10 = (RANDOM.nextFloat() - 0.5F) * var3 * 2.0F;
         float var11 = -var9 * var2;
         float var12 = (RANDOM.nextFloat() - 0.5F) * var3 * 2.0F;
         float var13 = var7 ? 0.018F : 0.006F;
         float var14 = (RANDOM.nextFloat() - 0.5F) * var13;
         float var15 = var7 ? 0.025F + RANDOM.nextFloat() * 0.035F : (RANDOM.nextFloat() - 0.5F) * 0.006F;
         float var16 = (RANDOM.nextFloat() - 0.5F) * var13;
         this.particleEffects.add(new KillEffectsModule.Nested1_a9895860(var1, var10, var11, var12, var14, var15, var16, var6, var7));
      }
   }

   // 4. Tombstone Effect
   static class TombstoneEffect {
      final Vec3d pos;
      final ColorRGBA col;
      final long startTime = System.currentTimeMillis();
      final long duration = 2800L;

      TombstoneEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.col = col;
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > this.duration;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         float prog = (System.currentTimeMillis() - this.startTime) / (float) this.duration;
         float alpha = prog < 0.2F ? (prog / 0.2F) : (prog > 0.7F ? (1.0F - (prog - 0.7F) / 0.3F) : 1.0F);
         float rise = Math.min(1.0F, prog * 3.0F);

         MatrixStack m = event.getMatrices();
         m.push();
         iIiiiIIiI_Class371.I_method_7d461059(m, this.pos);

         // Tombstone base slab
         m.push();
         m.translate(0.0F, rise * 0.6F, 0.0F);
         m.multiply(cam.getRotation());
         ColorRGBA stoneCol = new ColorRGBA(80.0F, 85.0F, 95.0F, 255.0F);
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -0.45F, -0.6F, 0.0F, 0.9F, 1.2F, stoneCol.withAlpha(stoneCol.getAlpha() * alpha * 0.9F));
         // Glowing gravestone cross/symbol
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -0.06F, -0.2F, 0.0F, 0.12F, 0.6F, this.col.withAlpha(this.col.getAlpha() * alpha * 0.95F));
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -0.2F, 0.05F, 0.0F, 0.4F, 0.12F, this.col.withAlpha(this.col.getAlpha() * alpha * 0.95F));
         m.pop();

         // Ascending ghostly mist motes
         for (int i = 0; i < 8; i++) {
            float mProg = ((prog * 2.0F + i / 8.0F) % 1.0F);
            float my = rise * 0.8F + mProg * 1.8F;
            float mx = (float)Math.sin(prog * 10.0F + i) * 0.3F;
            float mz = (float)Math.cos(prog * 10.0F + i) * 0.3F;
            m.push();
            m.translate(mx, my, mz);
            m.multiply(cam.getRotation());
            float mAlpha = (1.0F - mProg) * alpha * 0.6F;
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -0.15F, -0.15F, 0.0F, 0.3F, 0.3F, this.col.withAlpha(this.col.getAlpha() * mAlpha));
            m.pop();
         }

         m.pop();
      }
   }

   // 5. Singularity Effect
   static class SingularityEffect {
      final Vec3d pos;
      final ColorRGBA col;
      final long startTime = System.currentTimeMillis();
      final long duration = 2400L;

      SingularityEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.col = col;
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > this.duration;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         float prog = (System.currentTimeMillis() - this.startTime) / (float) this.duration;
         MatrixStack m = event.getMatrices();
         m.push();
         iIiiiIIiI_Class371.I_method_7d461059(m, this.pos.add(0.0, 1.0, 0.0));

         if (prog < 0.75F) {
            // Implosion accretion phase
            float inProg = prog / 0.75F;
            float rad = (1.0F - inProg) * 2.2F;
            float alpha = (float)Math.sin(inProg * Math.PI);
            for (int i = 0; i < 16; i++) {
               float a = (float)(i * Math.PI * 2.0 / 16 + inProg * Math.PI * 8.0);
               float x = (float)Math.cos(a) * rad;
               float z = (float)Math.sin(a) * rad;
               float y = (float)Math.sin(a * 2.0F) * 0.3F;
               m.push();
               m.translate(x, y, z);
               m.multiply(cam.getRotation());
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -0.12F, -0.12F, 0.0F, 0.24F, 0.24F, this.col.withAlpha(this.col.getAlpha() * alpha * 0.9F));
               m.pop();
            }
            // Dark center
            m.push();
            m.multiply(cam.getRotation());
            float cSize = 0.5F * inProg;
            ColorRGBA dark = new ColorRGBA(20.0F, 0.0F, 35.0F, 255.0F);
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -cSize / 2.0F, -cSize / 2.0F, 0.0F, cSize, cSize, dark.withAlpha(dark.getAlpha() * alpha));
            m.pop();
         } else {
            // Explosion pulse phase
            float outProg = (prog - 0.75F) / 0.25F;
            float outR = outProg * 3.5F;
            float outAlpha = (1.0F - outProg);
            m.push();
            m.multiply(cam.getRotation());
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -outR / 2.0F, -outR / 2.0F, 0.0F, outR, outR, this.col.withAlpha(this.col.getAlpha() * outAlpha * 0.9F));
            m.pop();
         }

         m.pop();
      }
   }

   // 6. Firework Effect
   static class FireworkEffect {
      final Vec3d pos;
      final ColorRGBA col;
      final long startTime = System.currentTimeMillis();
      final long duration = 2500L;
      final List<Vec3d> sparkVels = new ArrayList<>();
      final List<ColorRGBA> sparkColors = new ArrayList<>();

      FireworkEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.col = col;
         ColorRGBA[] palette = new ColorRGBA[]{
            new ColorRGBA(255.0F, 60.0F, 60.0F, 255.0F),
            new ColorRGBA(60.0F, 240.0F, 255.0F, 255.0F),
            new ColorRGBA(255.0F, 220.0F, 50.0F, 255.0F),
            new ColorRGBA(240.0F, 80.0F, 255.0F, 255.0F),
            new ColorRGBA(60.0F, 255.0F, 120.0F, 255.0F)
         };
         for (int i = 0; i < 60; i++) {
            float phi = RANDOM.nextFloat() * (float)Math.PI * 2.0F;
            float theta = (float)Math.acos(2.0F * RANDOM.nextFloat() - 1.0F);
            float speed = 0.08F + RANDOM.nextFloat() * 0.14F;
            this.sparkVels.add(new Vec3d(
               Math.sin(theta) * Math.cos(phi) * speed,
               Math.cos(theta) * speed,
               Math.sin(theta) * Math.sin(phi) * speed
            ));
            this.sparkColors.add(palette[i % palette.length]);
         }
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > this.duration;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         float prog = (System.currentTimeMillis() - this.startTime) / (float) this.duration;
         MatrixStack m = event.getMatrices();

         if (prog < 0.3F) {
            // Rocket ascending phase
            float rProg = prog / 0.3F;
            float ry = rProg * 5.5F;
            m.push();
            iIiiiIIiI_Class371.I_method_7d461059(m, this.pos.add(0.0, ry, 0.0));
            m.multiply(cam.getRotation());
            ColorRGBA spark = new ColorRGBA(255.0F, 240.0F, 150.0F, 255.0F);
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -0.15F, -0.15F, 0.0F, 0.3F, 0.3F, spark);
            m.pop();
         } else {
            // Burst phase
            float bProg = (prog - 0.3F) / 0.7F;
            float alpha = 1.0F - bProg;
            Vec3d burstOrigin = this.pos.add(0.0, 5.5, 0.0);
            for (int i = 0; i < this.sparkVels.size(); i++) {
               Vec3d vel = this.sparkVels.get(i);
               ColorRGBA c = this.sparkColors.get(i);
               double sx = burstOrigin.x + vel.x * bProg * 25.0;
               double sy = burstOrigin.y + vel.y * bProg * 25.0 - (bProg * bProg * 3.0);
               double sz = burstOrigin.z + vel.z * bProg * 25.0;

               m.push();
               iIiiiIIiI_Class371.I_method_7d461059(m, new Vec3d(sx, sy, sz));
               m.multiply(cam.getRotation());
               float twinkle = 0.16F * (0.6F + 0.4F * (float)Math.sin(prog * 30.0F + i));
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -twinkle / 2.0F, -twinkle / 2.0F, 0.0F, twinkle, twinkle, c.withAlpha(c.getAlpha() * alpha * 0.9F));
               m.pop();
            }
         }
      }
   }

   // 7. Soul Ascend Effect
   static class SoulAscendEffect {
      final Vec3d pos;
      final ColorRGBA col;
      final long startTime = System.currentTimeMillis();
      final long duration = 3500L;

      SoulAscendEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.col = col;
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > this.duration;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         float prog = (System.currentTimeMillis() - this.startTime) / (float) this.duration;
         float alpha = (1.0F - prog);
         float y = prog * 5.0F;

         MatrixStack m = event.getMatrices();
         m.push();
         iIiiiIIiI_Class371.I_method_7d461059(m, this.pos.add(0.0, y, 0.0));

         // Ascending radiant soul orb
         m.push();
         m.multiply(cam.getRotation());
         float pulse = 0.55F + 0.1F * (float)Math.sin(prog * 20.0F);
         ColorRGBA soulWhite = new ColorRGBA(245.0F, 255.0F, 255.0F, 255.0F);
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -pulse / 2.0F, -pulse / 2.0F, 0.0F, pulse, pulse, this.col.withAlpha(this.col.getAlpha() * alpha * 0.85F));
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -pulse * 0.5F / 2.0F, -pulse * 0.5F / 2.0F, 0.0F, pulse * 0.5F, pulse * 0.5F, soulWhite.withAlpha(soulWhite.getAlpha() * alpha * 0.95F));
         m.pop();

         // Winged halo rings around soul
         for (int i = 0; i < 6; i++) {
            float a = (float)(i * Math.PI * 2.0 / 6 + prog * 8.0F);
            float rad = 0.55F;
            float px = (float)Math.cos(a) * rad;
            float pz = (float)Math.sin(a) * rad;
            m.push();
            m.translate(px, (float)Math.sin(a * 2.0F) * 0.15F, pz);
            m.multiply(cam.getRotation());
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -0.08F, -0.08F, 0.0F, 0.16F, 0.16F, this.col.withAlpha(this.col.getAlpha() * alpha * 0.8F));
            m.pop();
         }

         m.pop();
      }
   }

   class Nested1_a9895860 {
      double I_field_44;
      double i_field_44;
      double II_field_44;
      float I_field_46;
      float i_field_46;
      float II_field_46;
      long I_field_4a;
      long i_field_4a;
      float Ii_field_46;
      long II_field_4a;
      boolean I_field_5a;
      float iI_field_46;
      ColorRGBA I_field_d0c8ec5;
      static final float ii_field_46 = 0.5F;

      Nested1_a9895860(Vec3d var2, float var3, float var4, float var5, float var6, float var7, float var8, ColorRGBA var9, boolean var10) {
         this.I_field_44 = var2.x + var3;
         this.i_field_44 = var2.y + var4;
         this.II_field_44 = var2.z + var5;
         this.I_field_d0c8ec5 = var9;
         this.I_field_4a = System.currentTimeMillis();
         this.i_field_4a = this.I_field_4a;
         this.I_field_5a = var10;
         this.Ii_field_46 = 0.005F + KillEffectsModule.RANDOM.nextFloat() * 0.005F;
         this.II_field_4a = 1500 + KillEffectsModule.RANDOM.nextInt(1500);
         this.iI_field_46 = var10 ? 0.999F : 0.995F;
         float var11 = var10 ? 0.04F : 0.03F;
         this.I_field_46 = (KillEffectsModule.RANDOM.nextFloat() - 0.5F) * var11;
         this.i_field_46 = var10
            ? 0.025F + KillEffectsModule.RANDOM.nextFloat() * 0.035F
            : (KillEffectsModule.RANDOM.nextFloat() - 0.5F) * 0.03F;
         this.II_field_46 = (KillEffectsModule.RANDOM.nextFloat() - 0.5F) * var11;
      }

      void I_method_b508e75a() {
         float var1 = 0.5F;
         long var2 = System.currentTimeMillis();
         float var4 = (float)(var2 - this.i_field_4a) / 16.67F;
         this.i_field_4a = var2;
         if (var4 > 5.0F) {
            var4 = 5.0F;
         }

         if (this.I_field_5a) {
            this.i_field_46 = this.i_field_46 - this.Ii_field_46 * var4;
         }

         float var5 = (float)Math.pow(this.iI_field_46, var4);
         this.I_field_46 *= var5;
         this.i_field_46 *= var5;
         this.II_field_46 *= var5;
         double var6 = this.I_field_44 + this.I_field_46 * var4;
         double var8 = this.i_field_44 + this.i_field_46 * var4;
         double var10 = this.II_field_44 + this.II_field_46 * var4;
         if (this.I_field_5a && iIIiIIiIi_Class294.I_field_3a9bda27.world != null) {
            BlockPos var12 = BlockPos.ofFloored(this.I_field_44, var8 - 0.05F, this.II_field_44);
            if (!iIIiIIiIi_Class294.I_field_3a9bda27.world.getBlockState(var12).isAir()) {
               this.i_field_46 = -this.i_field_46 * var1;
               var8 = this.I_field_44;
            }

            BlockPos var13 = BlockPos.ofFloored(var6, this.i_field_44, this.II_field_44);
            if (!iIIiIIiIi_Class294.I_field_3a9bda27.world.getBlockState(var13).isAir()) {
               this.I_field_46 = -this.I_field_46 * var1;
               var6 = this.I_field_44;
            }

            BlockPos var14 = BlockPos.ofFloored(this.I_field_44, this.i_field_44, var10);
            if (!iIIiIIiIi_Class294.I_field_3a9bda27.world.getBlockState(var14).isAir()) {
               this.II_field_46 = -this.II_field_46 * var1;
               var10 = this.II_field_44;
            }
         }

         if (Math.abs(this.i_field_46) <= 1.0E-4F) {
            this.I_field_46 = 0.0F;
            this.II_field_46 = 0.0F;
         }

         this.I_field_44 = var6;
         this.i_field_44 = var8;
         this.II_field_44 = var10;
      }

      float I_method_b508e74a() {
         return MathHelper.clamp((float)(System.currentTimeMillis() - this.I_field_4a) / (float)this.II_field_4a, 0.0F, 1.0F);
      }

      float i_method_b517732a() {
         return 1.0F - this.I_method_b508e74a();
      }

      boolean I_method_b508e75e() {
         return System.currentTimeMillis() - this.I_field_4a > this.II_field_4a;
      }

      void I_method_c50ff315(Render3DEvent var1, BufferBuilder var2) {
         float var3 = 0.1F;
         float var4 = 0.5F;
         MatrixStack var5 = var1.getMatrices();
         Camera var6 = iIIiIIiIi_Class294.I_field_3a9bda27.gameRenderer.getCamera();
         float var7 = this.i_method_b517732a();
         var5.push();
         iIiiiIIiI_Class371.I_method_7d461059(var5, new Vec3d(this.I_field_44, this.i_field_44, this.II_field_44));
         var5.multiply(var6.getRotation());
         iIiiIIiii_Class360.I_method_a9f124df(var5, var2, -var3 / 2.0F, -var3 / 2.0F, 0.0, var3, var3, this.I_field_d0c8ec5.mulAlpha(0.9F * var7));
         iIiiIIiii_Class360.I_method_a9f124df(var5, var2, -var4 / 2.0F, -var4 / 2.0F, 0.0, var4, var4, this.I_field_d0c8ec5.mulAlpha(0.15F * var7));
         var5.pop();
      }
   }

   static class Nested1_a9895880 {
      final Vec3d I_field_5bba0d50;
      final ColorRGBA I_field_d0c8ec5;
      boolean I_field_5a = true;
      final IiiiIiIii_Class236 I_field_dc7facc = new IiiiIiIii_Class236(300L, 0.0F, IiiiIiiII_Class237.III_field_dd60aac);
      final List<Vec3d> I_field_7865b31 = new ArrayList<>();

      public Nested1_a9895880(Vec3d var1, ColorRGBA var2) {
         this.I_field_5bba0d50 = var1;
         this.I_field_d0c8ec5 = var2;
         Vec3d var3 = var1;

         for (int var4 = 0; var4 < 200; var4++) {
            this.I_field_7865b31.add(var3 = var3.add(iIIiiiiiI_Class319.I_method_b56b22f(-0.4F, 0.4F), 0.25, iIIiiiiiI_Class319.I_method_b56b22f(-0.4F, 0.4F)));
         }
      }

      void I_method_b08fd268(BufferBuilder var1, MatrixStack var2, Camera var3) {
         this.I_field_dc7facc.I_method_df2f9087(IiiiIiiII_Class237.IIIiI_field_dd60aac);
         this.I_field_dc7facc.I_method_edd6ec25(500L);
         this.I_field_dc7facc.I_method_edd72835(this.I_field_5a);

         for (Vec3d var5 : this.I_field_7865b31) {
            float var6 = (float)(2.0 + 5.0 * (var5.y - this.I_field_5bba0d50.y) / 50.0);
            var2.push();
            iIiiiIIiI_Class371.I_method_7d461059(var2, var5);
            var2.multiply(var3.getRotation());
            iIiiIIiii_Class360.I_method_a9f124df(
               var2,
               var1,
               -var6 / 2.0F,
               -var6 / 2.0F,
               0.0,
               var6,
               var6,
               this.I_field_d0c8ec5.withAlpha(255.0F * this.I_field_dc7facc.I_method_6ac4da6f() * 0.4F)
            );
            var2.pop();
         }
      }
   }

   // ==========================================
   // 5 NEW KILL EFFECTS
   // ==========================================

   static class SupernovaEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final long startTime;
      private static final long DURATION = 1800L;

      SupernovaEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.col = col;
         this.startTime = System.currentTimeMillis();
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = (float)elapsed / DURATION;
         float alpha = (float)Math.sin(prog * Math.PI);
         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y + 0.8, this.pos.z - cpos.z);

         // Blazing core
         m.push();
         m.multiply(cam.getRotation());
         float coreScale = 0.4F + prog * 2.2F;
         ColorRGBA coreCol = new ColorRGBA(255.0F, 255.0F, 230.0F, 255.0F);
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -coreScale * 0.5F, -coreScale * 0.5F, 0.0, coreScale, coreScale, coreCol.withAlpha(alpha * 0.95F * 255.0F));
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -coreScale * 0.8F, -coreScale * 0.8F, 0.0, coreScale * 1.6F, coreScale * 1.6F, this.col.withAlpha(alpha * 0.75F * 255.0F));
         m.pop();

         // 12 Coronal relativistic flares radiating outwards
         for (int i = 0; i < 12; i++) {
            double angle = (Math.PI * 2.0 * i / 12) + prog * 4.0;
            float dist = 0.3F + prog * 2.6F;
            float fx = (float)Math.cos(angle) * dist;
            float fz = (float)Math.sin(angle) * dist;
            float fy = (float)Math.sin(angle * 3.0) * 0.5F;
            m.push();
            m.translate(fx, fy, fz);
            m.multiply(cam.getRotation());
            float fSize = 0.25F * (1.0F - prog * 0.7F);
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -fSize * 0.5F, -fSize * 0.5F, 0.0, fSize, fSize, this.col.withAlpha(alpha * 0.8F * 255.0F));
            m.pop();
         }

         m.pop();
      }
   }

   static class GlitchMatrixEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final long startTime;
      private static final long DURATION = 2000L;
      private final float[] offsets = new float[24 * 3];

      GlitchMatrixEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.col = col;
         this.startTime = System.currentTimeMillis();
         for (int i = 0; i < offsets.length; i++) {
            offsets[i] = (KillEffectsModule.RANDOM.nextFloat() - 0.5F);
         }
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = (float)elapsed / DURATION;
         float alpha = (1.0F - prog);
         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y + 0.6, this.pos.z - cpos.z);

         ColorRGBA cyanCode = new ColorRGBA(50.0F, 255.0F, 180.0F, 255.0F);

         for (int i = 0; i < 24; i++) {
            float ox = offsets[i * 3] * (0.8F + prog * 1.5F);
            float oy = offsets[i * 3 + 1] * 1.2F + prog * 0.6F;
            float oz = offsets[i * 3 + 2] * (0.8F + prog * 1.5F);

            // Digital jitter
            float jitter = ((float)Math.sin(prog * 30.0F + i * 2.0F)) * 0.05F;

            m.push();
            m.translate(ox + jitter, oy, oz);
            m.multiply(cam.getRotation());
            float size = 0.12F * (1.0F - prog * 0.5F);
            ColorRGBA c = (i % 2 == 0) ? this.col : cyanCode;
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -size * 0.5F, -size * 0.5F, 0.0, size, size, c.withAlpha(alpha * 0.9F * 255.0F));
            m.pop();
         }

         m.pop();
      }
   }

   static class HolyAscensionEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final long startTime;
      private static final long DURATION = 2200L;

      HolyAscensionEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.col = col;
         this.startTime = System.currentTimeMillis();
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = (float)elapsed / DURATION;
         float alpha = (float)Math.sin(prog * Math.PI);
         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y, this.pos.z - cpos.z);

         ColorRGBA gold = new ColorRGBA(255.0F, 225.0F, 100.0F, 255.0F);

         // Ascending vertical pillar nodes
         for (int i = 0; i < 10; i++) {
            float y = i * 0.45F + prog * 1.2F;
            m.push();
            m.translate(0.0F, y, 0.0F);
            m.multiply(cam.getRotation());
            float s = 0.35F + 0.05F * (float)Math.sin(prog * 10.0F + i);
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -s * 0.5F, -s * 0.5F, 0.0, s, s, gold.withAlpha(alpha * 0.75F * 255.0F));
            m.pop();
         }

         // Ascending sacred halo rings
         for (int r = 0; r < 3; r++) {
            float ringY = ((prog * 3.5F + r * 1.2F) % 3.6F);
            float ringScale = 0.65F + 0.15F * r;
            int segs = 8;
            for (int s = 0; s < segs; s++) {
               double a = (Math.PI * 2.0 * s / segs) + prog * 4.0;
               m.push();
               m.translate((float)Math.cos(a) * ringScale, ringY, (float)Math.sin(a) * ringScale);
               m.multiply(cam.getRotation());
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -0.09F, -0.09F, 0.0, 0.18F, 0.18F, this.col.withAlpha(alpha * 0.85F * 255.0F));
               m.pop();
            }
         }

         m.pop();
      }
   }

   static class BlackHoleEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final long startTime;
      private static final long DURATION = 2500L;

      BlackHoleEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.col = col;
         this.startTime = System.currentTimeMillis();
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = (float)elapsed / DURATION;
         float alpha = (float)Math.sin(prog * Math.PI);
         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y + 0.8, this.pos.z - cpos.z);

         // Event Horizon dark core with purple rim
         m.push();
         m.multiply(cam.getRotation());
         float coreS = 0.5F;
         ColorRGBA darkPurple = new ColorRGBA(40.0F, 0.0F, 70.0F, 255.0F);
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -coreS * 0.5F, -coreS * 0.5F, 0.0, coreS, coreS, darkPurple.withAlpha(alpha * 0.95F * 255.0F));
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -coreS * 0.7F, -coreS * 0.7F, 0.0, coreS * 1.4F, coreS * 1.4F, this.col.withAlpha(alpha * 0.7F * 255.0F));
         m.pop();

         // Swirling inward accretion particles
         for (int i = 0; i < 18; i++) {
            float spiralT = ((1.0F - prog) * 2.0F + (float)i / 18) % 1.0F;
            float r = 0.25F + spiralT * 1.6F;
            double a = (Math.PI * 6.0 * spiralT) + (Math.PI * 2.0 * i / 18);
            m.push();
            m.translate((float)Math.cos(a) * r, (float)Math.sin(a * 2.0) * 0.15F, (float)Math.sin(a) * r);
            m.multiply(cam.getRotation());
            float pSize = 0.12F * spiralT;
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -pSize * 0.5F, -pSize * 0.5F, 0.0, pSize, pSize, this.col.withAlpha(alpha * 0.85F * 255.0F));
            m.pop();
         }

         m.pop();
      }
   }

   static class BloodExplosionEffect {
      private final Vec3d pos;
      private final long startTime;
      private static final long DURATION = 2000L;
      private final float[] vel = new float[30 * 3];

      BloodExplosionEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.startTime = System.currentTimeMillis();
         for (int i = 0; i < 30; i++) {
            vel[i * 3] = (KillEffectsModule.RANDOM.nextFloat() - 0.5F) * 3.5F;
            vel[i * 3 + 1] = 1.0F + KillEffectsModule.RANDOM.nextFloat() * 2.5F;
            vel[i * 3 + 2] = (KillEffectsModule.RANDOM.nextFloat() - 0.5F) * 3.5F;
         }
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = (float)elapsed / DURATION;
         float alpha = (1.0F - prog * prog);
         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         ColorRGBA bloodRed = new ColorRGBA(195.0F, 10.0F, 25.0F, 255.0F);
         ColorRGBA darkCrimson = new ColorRGBA(115.0F, 0.0F, 10.0F, 255.0F);

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y + 0.6, this.pos.z - cpos.z);

         float t = prog * 1.5F;
         for (int i = 0; i < 30; i++) {
            float vx = vel[i * 3];
            float vy = vel[i * 3 + 1];
            float vz = vel[i * 3 + 2];

            float dx = vx * t;
            float dy = vy * t - 0.5F * 4.9F * t * t; // Gravity
            float dz = vz * t;

            if (dy < -0.5F) dy = -0.5F; // Ground splatter

            m.push();
            m.translate(dx, dy, dz);
            m.multiply(cam.getRotation());
            float s = (dy <= -0.48F) ? (0.22F * (1.0F - prog * 0.5F)) : 0.14F;
            ColorRGBA c = (i % 2 == 0) ? bloodRed : darkCrimson;
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -s * 0.5F, -s * 0.5F, 0.0, s, s, c.withAlpha(alpha * 0.9F * 255.0F));
            m.pop();
         }

         m.pop();
      }
   }

   static class BloodPillarEffect {
      private final Vec3d pos;
      private final long startTime;
      private final long duration;
      private final ColorRGBA col;

      BloodPillarEffect(Vec3d pos, ColorRGBA col, long duration) {
         this.pos = pos;
         this.startTime = System.currentTimeMillis();
         this.duration = Math.max(500L, duration);
         this.col = col;
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > this.duration;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = (float)elapsed / this.duration;
         float alpha = 1.0F - prog;
         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         ColorRGBA bloodCol = new ColorRGBA(220.0F, 10.0F, 30.0F, 240.0F * alpha);
         ColorRGBA darkBlood = new ColorRGBA(100.0F, 0.0F, 15.0F, 200.0F * alpha);

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y, this.pos.z - cpos.z);

         // Pillar of blood ascending 14 blocks upwards
         float pillarHeight = 14.0F * (float)Math.sin(Math.min(1.0F, prog * 2.0F) * Math.PI * 0.5);
         int segments = 18;
         for (int i = 0; i < segments; i++) {
            float y = (pillarHeight / segments) * i;
            float swirl = prog * 15.0F + i * 0.4F;
            float r = 0.55F + (float)Math.sin(swirl) * 0.15F;
            m.push();
            m.translate(Math.cos(swirl) * 0.1, y, Math.sin(swirl) * 0.1);
            m.multiply(cam.getRotation());
            float s = 0.8F + (1.0F - (float)i / segments) * 0.6F;
            ColorRGBA c = (i % 2 == 0) ? bloodCol : darkBlood;
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -s * 0.5F, -s * 0.5F, 0.0, s, s, c);
            m.pop();
         }
         m.pop();
      }
   }

   static class CardDeckAscensionEffect {
      private final Vec3d pos;
      private final long startTime;
      private final long duration;
      private final ColorRGBA col;
      private final Identifier[] deck;
      private final Identifier back;
      private final SingleCard[] cards;

      private static class SingleCard {
         float vx, vy, vz;
         float pitch, yaw, roll;
         float vPitch, vYaw, vRoll;
         float scale;
         int cardIndex;
      }

      CardDeckAscensionEffect(Vec3d pos, ColorRGBA col, long duration, Identifier[] deck, Identifier back) {
         this.pos = pos;
         this.startTime = System.currentTimeMillis();
         this.duration = Math.max(800L, duration);
         this.col = col;
         this.deck = deck != null ? deck : CardRenderHelper.ALL_CARDS;
         this.back = back != null ? back : CardRenderHelper.CARD_BACK_MESH;

         int count = 32;
         this.cards = new SingleCard[count];
         for (int i = 0; i < count; i++) {
            SingleCard c = new SingleCard();
            double angle = (2.0 * Math.PI * i) / count + (KillEffectsModule.RANDOM.nextDouble() - 0.5) * 0.3;
            double speed = 1.8 + KillEffectsModule.RANDOM.nextDouble() * 2.2;
            c.vx = (float)(Math.cos(angle) * speed);
            c.vy = (float)(3.2 + KillEffectsModule.RANDOM.nextDouble() * 3.5);
            c.vz = (float)(Math.sin(angle) * speed);
            c.pitch = KillEffectsModule.RANDOM.nextFloat() * 360.0F;
            c.yaw = KillEffectsModule.RANDOM.nextFloat() * 360.0F;
            c.roll = KillEffectsModule.RANDOM.nextFloat() * 360.0F;
            c.vPitch = (KillEffectsModule.RANDOM.nextFloat() - 0.5F) * 720.0F;
            c.vYaw = (KillEffectsModule.RANDOM.nextFloat() - 0.5F) * 720.0F;
            c.vRoll = (KillEffectsModule.RANDOM.nextFloat() - 0.5F) * 720.0F;
            c.scale = 0.40F + KillEffectsModule.RANDOM.nextFloat() * 0.15F;
            c.cardIndex = i % this.deck.length;
            this.cards[i] = c;
         }
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > this.duration;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float t = (float)elapsed / 1000.0F;
         float prog = (float)elapsed / (float)this.duration;
         float alpha = Math.clamp(1.0F - prog * prog, 0.0F, 1.0F);
         if (alpha <= 0.01F) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y + 0.8, this.pos.z - cpos.z);

         for (SingleCard card : this.cards) {
            float drag = (float)Math.exp(-0.85F * t);
            float cx = card.vx * (1.0F - drag) / 0.85F;
            float cy = (card.vy * (1.0F - drag) / 0.85F) - (0.5F * 5.5F * t * t);
            float cz = card.vz * (1.0F - drag) / 0.85F;

            if (cy < -0.7F) {
               cy = -0.7F;
            }

            float curPitch = card.pitch + card.vPitch * t;
            float curYaw = card.yaw + card.vYaw * t;
            float curRoll = card.roll + card.vRoll * t;

            m.push();
            m.translate(cx, cy, cz);
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(curYaw));
            m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(curPitch));
            m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(curRoll));

            float s = card.scale;
            CardRenderHelper.renderCard(m, s * 0.70F, s, this.deck[card.cardIndex], this.back, alpha, true);
            m.pop();
         }
         m.pop();
      }
   }

   static class DisintegrationEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final long startTime;
      private static final long DURATION = 2200L;
      private static final int VOXEL_COUNT = 96;
      private final float[] voxelData = new float[VOXEL_COUNT * 7];

      DisintegrationEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.col = col;
         this.startTime = System.currentTimeMillis();

         for (int i = 0; i < VOXEL_COUNT; i++) {
            // Humanoid vertical distribution from crown of head (1.95F) down to feet (0.05F)
            float norm = (float) i / (float) VOXEL_COUNT;
            float vySpan = 0.05F + norm * 1.90F;
            float spreadX = (vySpan > 1.5F) ? 0.22F : ((vySpan > 0.8F) ? 0.38F : 0.22F);
            float spreadZ = (vySpan > 1.5F) ? 0.22F : 0.18F;
            float ox = (KillEffectsModule.RANDOM.nextFloat() - 0.5F) * spreadX * 2.0F;
            float oz = (KillEffectsModule.RANDOM.nextFloat() - 0.5F) * spreadZ * 2.0F;

            // Upward drift and vortex turbulence
            float speed = 0.30F + KillEffectsModule.RANDOM.nextFloat() * 0.80F;
            double angle = KillEffectsModule.RANDOM.nextDouble() * Math.PI * 2.0;

            int idx = i * 7;
            voxelData[idx] = ox;
            voxelData[idx + 1] = vySpan; // origY
            voxelData[idx + 2] = oz;
            voxelData[idx + 3] = (float)Math.cos(angle) * speed; // vx
            voxelData[idx + 4] = 0.40F + KillEffectsModule.RANDOM.nextFloat() * 0.90F; // vy (upward draft)
            voxelData[idx + 5] = (float)Math.sin(angle) * speed; // vz
            voxelData[idx + 6] = 0.05F + KillEffectsModule.RANDOM.nextFloat() * 0.06F; // sz
         }
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         float alpha = MathHelper.clamp(1.0F - prog * 1.05F, 0.0F, 1.0F);
         if (alpha <= 0.01F) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y, this.pos.z - cpos.z);

         // Disintegration wave sweeps STRICTLY from crown of head (1.95F) down to feet (0.0F)
         float waveFrontY = 1.95F - (prog / 0.70F) * 1.95F;

         for (int i = 0; i < VOXEL_COUNT; i++) {
            int idx = i * 7;
            float origY = voxelData[idx + 1];
            // Delay starts at 0.0 for crown of head (1.95F) and increases towards feet (0.0F)
            float delay = MathHelper.clamp((1.95F - origY) / 1.95F * 0.65F, 0.0F, 0.65F);

            if (prog < delay) {
               // Intact voxel awaiting the disintegration wave
               m.push();
               m.translate(voxelData[idx], origY, voxelData[idx + 2]);
               m.multiply(cam.getRotation());
               float sz = voxelData[idx + 6];
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -sz * 0.5F, -sz * 0.5F, 0.0, sz, sz, this.col.withAlpha(240.0F * alpha));
               m.pop();
            } else {
               // Crumbled into floating burning particle
               float particleProg = (prog - delay) / (1.0F - delay);
               float pAlpha = MathHelper.clamp((1.0F - particleProg) * alpha, 0.0F, 1.0F);
               if (pAlpha <= 0.01F) continue;

               float swirlAngle = particleProg * 4.0F;
               float px = voxelData[idx] + voxelData[idx + 3] * (particleProg * 1.5F) + (float)Math.sin(swirlAngle + i) * 0.12F;
               float py = origY + voxelData[idx + 4] * (particleProg * 2.2F);
               float pz = voxelData[idx + 2] + voxelData[idx + 5] * (particleProg * 1.5F) + (float)Math.cos(swirlAngle + i) * 0.12F;
               float sz = voxelData[idx + 6] * (1.0F - particleProg * 0.55F);

               // Neon ember / fire glow at the disintegration boundary
               boolean isAtFront = Math.abs(origY - waveFrontY) < 0.25F && particleProg < 0.35F;
               ColorRGBA c = isAtFront ? ColorRGBA.WHITE : ((i % 3 == 0) ? new ColorRGBA(255.0F, 220.0F, 140.0F, 255.0F) : this.col);

               m.push();
               m.translate(px, py, pz);
               m.multiply(cam.getRotation());
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -sz * 0.5F, -sz * 0.5F, 0.0, sz, sz, c.withAlpha(pAlpha * 255.0F));
               m.pop();
            }
         }

         m.pop();
      }
   }

   static class NetherPortalAbductionEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final SkinTextures skin;
      private final float initialYaw;
      private final long startTime;
      private static final long DURATION = 3000L;

      NetherPortalAbductionEffect(Vec3d pos, ColorRGBA col, SkinTextures skin, float initialYaw) {
         this.pos = pos;
         this.col = col;
         this.skin = (skin != null) ? skin : DefaultSkinHelper.getSkinTextures(UUID.randomUUID());
         this.initialYaw = initialYaw;
         this.startTime = System.currentTimeMillis();
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         float alpha = (prog < 0.85F) ? Math.min(1.0F, prog * 4.5F) : (1.0F - (prog - 0.85F) / 0.15F);
         if (alpha <= 0.01F) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y + 0.02F, this.pos.z - cpos.z);

         // Vibrant infernal magma colors
         ColorRGBA magmaCore = new ColorRGBA(255.0F, 70.0F, 10.0F, 245.0F * alpha);
         ColorRGBA hotOrange = new ColorRGBA(255.0F, 140.0F, 20.0F, 230.0F * alpha);
         ColorRGBA darkBasalt = new ColorRGBA(30.0F, 4.0F, 6.0F, 250.0F * alpha);
         ColorRGBA bloodCrimson = new ColorRGBA(200.0F, 15.0F, 25.0F, 230.0F * alpha);
         ColorRGBA voidBlack = new ColorRGBA(10.0F, 2.0F, 4.0F, 255.0F * alpha);

         float riftRadius = Math.min(1.75F, prog * 5.2F) * (1.0F - Math.max(0.0F, prog - 0.86F) * 7.0F);
         float rotSpeed = (float)elapsed * 0.025F;
         org.joml.Matrix4f mat = m.peek().getPositionMatrix();

         // 1. Jagged Demonic Abyss Fissure (NO basic circle! 8 jagged magma-ruptured fissures)
         int riftPoints = 8;
         float[] fissureOuterR = new float[riftPoints];
         float[] fissureInnerR = new float[riftPoints];
         for (int i = 0; i < riftPoints; i++) {
            float seed = (float)Math.sin(i * 3.7 + elapsed * 0.003);
            fissureOuterR[i] = riftRadius * (0.85F + 0.25F * seed);
            fissureInnerR[i] = riftRadius * (0.35F + 0.15F * (float)Math.cos(i * 2.3));
         }

         // Inner molten void depth
         for (int i = 0; i < riftPoints; i++) {
            int next = (i + 1) % riftPoints;
            double a1 = (Math.PI * 2.0 * i) / riftPoints;
            double a2 = (Math.PI * 2.0 * next) / riftPoints;

            float x1 = (float)Math.cos(a1) * fissureInnerR[i];
            float z1 = (float)Math.sin(a1) * fissureInnerR[i];
            float x2 = (float)Math.cos(a2) * fissureInnerR[next];
            float z2 = (float)Math.sin(a2) * fissureInnerR[next];

            buf.vertex(mat, 0.0F, -0.05F, 0.0F).texture(0.5F, 0.5F).color(voidBlack.getRGB());
            buf.vertex(mat, x1, -0.02F, z1).texture(0.0F, 0.0F).color(darkBasalt.getRGB());
            buf.vertex(mat, x2, -0.02F, z2).texture(1.0F, 0.0F).color(darkBasalt.getRGB());
            buf.vertex(mat, 0.0F, -0.05F, 0.0F).texture(0.5F, 0.5F).color(voidBlack.getRGB());
         }

         // Glowing Magma Fissure Veins radiating outward
         for (int i = 0; i < riftPoints; i++) {
            int next = (i + 1) % riftPoints;
            double a1 = (Math.PI * 2.0 * i) / riftPoints;
            double a2 = (Math.PI * 2.0 * next) / riftPoints;

            float xIn1 = (float)Math.cos(a1) * fissureInnerR[i];
            float zIn1 = (float)Math.sin(a1) * fissureInnerR[i];
            float xIn2 = (float)Math.cos(a2) * fissureInnerR[next];
            float zIn2 = (float)Math.sin(a2) * fissureInnerR[next];

            float xOut1 = (float)Math.cos(a1) * fissureOuterR[i];
            float zOut1 = (float)Math.sin(a1) * fissureOuterR[i];
            float xOut2 = (float)Math.cos(a2) * fissureOuterR[next];
            float zOut2 = (float)Math.sin(a2) * fissureOuterR[next];

            // Outer magma crust
            buf.vertex(mat, xIn1, 0.001F, zIn1).texture(0.0F, 0.0F).color(magmaCore.getRGB());
            buf.vertex(mat, xIn2, 0.001F, zIn2).texture(1.0F, 0.0F).color(magmaCore.getRGB());
            buf.vertex(mat, xOut2, 0.001F, zOut2).texture(1.0F, 1.0F).color(bloodCrimson.getRGB());
            buf.vertex(mat, xOut1, 0.001F, zOut1).texture(0.0F, 1.0F).color(bloodCrimson.getRGB());
         }

         // 2. Burning Demonic Runic Star connecting the jagged fissure tips
         for (int sp = 0; sp < riftPoints; sp++) {
            int targetIdx = (sp + 3) % riftPoints;
            double a1 = (Math.PI * 2.0 * sp) / riftPoints + rotSpeed * 0.3;
            double a2 = (Math.PI * 2.0 * targetIdx) / riftPoints + rotSpeed * 0.3;

            float x1 = (float)Math.cos(a1) * (riftRadius * 0.85F);
            float z1 = (float)Math.sin(a1) * (riftRadius * 0.85F);
            float x2 = (float)Math.cos(a2) * (riftRadius * 0.85F);
            float z2 = (float)Math.sin(a2) * (riftRadius * 0.85F);

            float dx = x2 - x1, dz = z2 - z1;
            float len = (float)Math.hypot(dx, dz);
            if (len > 0.01F) {
               float px = -dz / len * 0.035F;
               float pz = dx / len * 0.035F;
               buf.vertex(mat, x1 - px, 0.004F, z1 - pz).texture(0.0F, 0.0F).color(hotOrange.getRGB());
               buf.vertex(mat, x2 - px, 0.004F, z2 - pz).texture(1.0F, 0.0F).color(hotOrange.getRGB());
               buf.vertex(mat, x2 + px, 0.004F, z2 + pz).texture(1.0F, 1.0F).color(magmaCore.getRGB());
               buf.vertex(mat, x1 + px, 0.004F, z1 + pz).texture(0.0F, 1.0F).color(magmaCore.getRGB());
            }
         }

         // 3. Rising Hellfire Spires & Volcanic Embers erupting upwards from the cracks
         int numEmbers = 22;
         for (int e = 0; e < numEmbers; e++) {
            float eProg = ((prog * 2.2F + (float)e / numEmbers) % 1.0F);
            double eAngle = (e * 137.5 * Math.PI / 180.0) + elapsed * 0.001;
            float eRadius = 0.25F + (e % 4) * 0.35F;
            float eX = (float)Math.cos(eAngle) * eRadius;
            float eZ = (float)Math.sin(eAngle) * eRadius;
            float eY = eProg * 2.8F;

            m.push();
            m.translate(eX, eY, eZ);
            m.multiply(cam.getRotation());
            float emberSz = 0.14F * (1.0F - eProg * 0.5F);
            ColorRGBA eCol = (e % 2 == 0) ? hotOrange : magmaCore;
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -emberSz * 0.5F, -emberSz * 0.5F, 0.0, emberSz, emberSz, eCol.withAlpha(alpha * (1.0F - eProg) * 240.0F));
            m.pop();
         }

         // 4. Barbed Hellforged Chains pulling the victim down
         int numChains = 4;
         for (int ch = 0; ch < numChains; ch++) {
            double chAngle = (Math.PI * 2.0 * ch) / numChains + rotSpeed * 0.2;
            float baseCos = (float)Math.cos(chAngle);
            float baseSin = (float)Math.sin(chAngle);

            float chainBaseX = baseCos * (riftRadius * 0.95F);
            float chainBaseZ = baseSin * (riftRadius * 0.95F);

            // Victim sinking progress with smooth ease
            float sinkEase = (float)Math.pow(prog / 0.82F, 2.0);
            float targetY = Math.max(0.05F, 0.70F * (1.0F - sinkEase));
            float targetX = baseCos * 0.18F;
            float targetZ = baseSin * 0.18F;

            float thick = 0.045F;
            buf.vertex(mat, chainBaseX - thick, 0.01F, chainBaseZ - thick).texture(0.0F, 0.0F).color(darkBasalt.getRGB());
            buf.vertex(mat, targetX - thick, targetY, targetZ - thick).texture(1.0F, 0.0F).color(magmaCore.getRGB());
            buf.vertex(mat, targetX + thick, targetY, targetZ + thick).texture(1.0F, 1.0F).color(magmaCore.getRGB());
            buf.vertex(mat, chainBaseX + thick, 0.01F, chainBaseZ + thick).texture(0.0F, 1.0F).color(darkBasalt.getRGB());
         }

         m.pop();
      }

      // Render 3D victim model being smoothly dragged into the underworld
      void renderModel(Render3DEvent event, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         if (prog > 0.85F) return; // Completely submerged into the infernal rift

         PlayerEntityModel victimModel = KillEffectsModule.getVictimModel();
         if (victimModel == null || this.skin == null) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         // Smooth, cinematic ease-in sinking animation (starts slow, then dragged down)
         float sinkEase = (float)Math.pow(prog / 0.85F, 1.8);
         float sinkY = -sinkEase * 2.1F;

         // Smooth struggle animation (no abrupt snaps)
         float struggleTilt = (float)Math.sin(elapsed * 0.012F) * 12.0F * (1.0F - prog * 0.7F);
         float struggleYaw = this.initialYaw + (float)Math.cos(elapsed * 0.010F) * 14.0F;

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y + sinkY, this.pos.z - cpos.z);
         m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(struggleYaw));
         m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(struggleTilt));

         m.scale(-0.9375F, -0.9375F, 0.9375F);
         m.translate(0.0, -1.501, 0.0);

         // Smooth, desperate struggle: arms clawing and reaching upwards
         float armWave = (float)Math.sin(elapsed * 0.018F) * 0.45F;
         victimModel.leftArm.pitch = -2.2F + armWave;
         victimModel.rightArm.pitch = -2.2F - armWave;
         victimModel.leftArm.roll = -0.30F;
         victimModel.rightArm.roll = 0.30F;
         victimModel.head.pitch = -0.40F; // Looking up desperately
         victimModel.head.yaw = (float)Math.sin(elapsed * 0.015F) * 0.25F;
         victimModel.leftLeg.pitch = 0.20F * (float)Math.sin(elapsed * 0.012F);
         victimModel.rightLeg.pitch = -0.20F * (float)Math.sin(elapsed * 0.012F);

         // Gradual fade and fiery red tint as they submerge into hell
         int colorAlpha = (int)(MathHelper.clamp(1.0F - (prog / 0.85F) * 0.5F, 0.2F, 1.0F) * 255.0F);
         int tint = (colorAlpha << 24) | 0x00FF8888; // Reddish burning tint

         try {
            VertexConsumerProvider.Immediate consumers = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
            VertexConsumer vc = consumers.getBuffer(RenderLayer.getEntityTranslucent(this.skin.texture()));
            victimModel.render(m, vc, 15728880, OverlayTexture.DEFAULT_UV, tint);
            consumers.draw();
         } catch (Throwable ignored) {}

         m.pop();
      }
   }

   static class AngelicAscensionEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final SkinTextures skin;
      private final float initialYaw;
      private final long startTime;
      private static final long DURATION = 3400L;

      AngelicAscensionEffect(Vec3d pos, ColorRGBA col, SkinTextures skin, float initialYaw) {
         this.pos = pos;
         this.col = col;
         this.skin = (skin != null) ? skin : DefaultSkinHelper.getSkinTextures(UUID.randomUUID());
         this.initialYaw = initialYaw;
         this.startTime = System.currentTimeMillis();
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         float alpha = (prog < 0.84F) ? Math.min(1.0F, prog * 3.5F) : (1.0F - (prog - 0.84F) / 0.16F);
         if (alpha <= 0.01F) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y, this.pos.z - cpos.z);

         ColorRGBA brilliantGold = new ColorRGBA(255.0F, 225.0F, 90.0F, 245.0F * alpha);
         ColorRGBA sacredAmber = new ColorRGBA(255.0F, 195.0F, 50.0F, 230.0F * alpha);
         ColorRGBA pureLight = new ColorRGBA(255.0F, 255.0F, 240.0F, 220.0F * alpha);
         ColorRGBA softAura = new ColorRGBA(255.0F, 240.0F, 160.0F, 150.0F * alpha);

         org.joml.Matrix4f mat = m.peek().getPositionMatrix();

         // 1. Grand Divine Godrays (Angled beams of heavenly light projecting from clouds to ground)
         int numRays = 8;
         float rayHeight = 11.0F;
         for (int r = 0; r < numRays; r++) {
            double rayAngle = (Math.PI * 2.0 * r) / numRays + elapsed * 0.003;
            float topRadius = 2.4F;
            float botRadius = 0.75F;
            float cos = (float)Math.cos(rayAngle);
            float sin = (float)Math.sin(rayAngle);

            float xBot = cos * botRadius;
            float zBot = sin * botRadius;
            float xTop = cos * topRadius;
            float zTop = sin * topRadius;

            float perpX = -sin * 0.35F;
            float perpZ = cos * 0.35F;

            int beamAlpha = (int)((70.0F + 35.0F * (float)Math.sin(elapsed * 0.004 + r)) * alpha);
            int colTop = (pureLight.getRGB() & 0x00FFFFFF) | (beamAlpha << 24);
            int colBot = (brilliantGold.getRGB() & 0x00FFFFFF) | ((beamAlpha / 2) << 24);

            buf.vertex(mat, xBot - perpX, 0.05F, zBot - perpZ).texture(0.0F, 0.0F).color(colBot);
            buf.vertex(mat, xBot + perpX, 0.05F, zBot + perpZ).texture(1.0F, 0.0F).color(colBot);
            buf.vertex(mat, xTop + perpX, rayHeight, zTop + perpZ).texture(1.0F, 1.0F).color(colTop);
            buf.vertex(mat, xTop - perpX, rayHeight, zTop - perpZ).texture(0.0F, 1.0F).color(colTop);
         }

         // 2. Concentric Sacred Ground Sigil with rotating divine runes
         int sigilSegs = 28;
         float sigilR1 = 1.15F;
         float sigilR2 = 1.45F;
         for (int i = 0; i < sigilSegs; i++) {
            double a1 = (Math.PI * 2.0 * i) / sigilSegs + elapsed * 0.015;
            double a2 = (Math.PI * 2.0 * (i + 1)) / sigilSegs + elapsed * 0.015;
            float c1 = (float)Math.cos(a1), s1 = (float)Math.sin(a1);
            float c2 = (float)Math.cos(a2), s2 = (float)Math.sin(a2);

            buf.vertex(mat, c1 * sigilR1, 0.02F, s1 * sigilR1).texture(0.0F, 0.0F).color(sacredAmber.getRGB());
            buf.vertex(mat, c2 * sigilR1, 0.02F, s2 * sigilR1).texture(1.0F, 0.0F).color(sacredAmber.getRGB());
            buf.vertex(mat, c2 * sigilR2, 0.02F, s2 * sigilR2).texture(1.0F, 1.0F).color(softAura.getRGB());
            buf.vertex(mat, c1 * sigilR2, 0.02F, s1 * sigilR2).texture(0.0F, 1.0F).color(softAura.getRGB());
         }

         // 3. Swirling Ascending Golden Feathers & Divine Embers
         int numFeathers = 18;
         for (int f = 0; f < numFeathers; f++) {
            float fOffset = (float)f / numFeathers;
            float fProg = ((prog * 1.5F + fOffset) % 1.0F);
            float fY = fProg * (rayHeight * 0.75F) + 0.3F;
            double fAngle = fOffset * Math.PI * 2.0 + elapsed * 0.0025F * (f % 2 == 0 ? 1 : -1);
            float sway = (float)Math.sin(elapsed * 0.005F + f) * 0.22F;
            float fR = 0.55F + (f % 3) * 0.35F + sway;
            float fX = (float)Math.cos(fAngle) * fR;
            float fZ = (float)Math.sin(fAngle) * fR;

            m.push();
            m.translate(fX, fY, fZ);
            m.multiply(cam.getRotation());
            float fSize = 0.18F;
            ColorRGBA fCol = (f % 2 == 0) ? brilliantGold : pureLight;
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -fSize * 0.5F, -fSize * 0.5F, 0.0, fSize, fSize, fCol.withAlpha(alpha * 230.0F));
            m.pop();
         }

         // 4. Attach Magnificent Angelic Wings & Grand Sacred Halo to Ascending Position
         float ascendY = prog * 4.6F + (float)Math.sin(elapsed * 0.004F) * 0.15F;
         float gentleYaw = this.initialYaw + (float)Math.sin(elapsed * 0.0025F) * 10.0F;

         m.push();
         m.translate(0.0F, ascendY, 0.0F);
         m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(gentleYaw));

         // --- SPECTACULAR MULTI-RING SACRED HALO (Нимб) ---
         float haloY = 2.02F;
         float haloR = 0.42F;
         float haloThick = 0.045F;
         int haloSegs = 24;
         org.joml.Matrix4f haloMat = m.peek().getPositionMatrix();

         // Outer spinning sacred sunburst ring with golden rays
         for (int i = 0; i < haloSegs; i++) {
            double a1 = (Math.PI * 2.0 * i) / haloSegs + elapsed * 0.035;
            double a2 = (Math.PI * 2.0 * (i + 1)) / haloSegs + elapsed * 0.035;
            float c1 = (float)Math.cos(a1), s1 = (float)Math.sin(a1);
            float c2 = (float)Math.cos(a2), s2 = (float)Math.sin(a2);

            buf.vertex(haloMat, c1 * (haloR - haloThick), haloY, s1 * (haloR - haloThick)).texture(0.0F, 0.0F).color(brilliantGold.getRGB());
            buf.vertex(haloMat, c2 * (haloR - haloThick), haloY, s2 * (haloR - haloThick)).texture(1.0F, 0.0F).color(brilliantGold.getRGB());
            buf.vertex(haloMat, c2 * (haloR + haloThick), haloY, s2 * (haloR + haloThick)).texture(1.0F, 1.0F).color(pureLight.getRGB());
            buf.vertex(haloMat, c1 * (haloR + haloThick), haloY, s1 * (haloR + haloThick)).texture(0.0F, 1.0F).color(pureLight.getRGB());

            // Radiating sacred sunburst rays
            if (i % 2 == 0) {
               float rayLen = 0.14F * (1.0F + 0.3F * (float)Math.sin(elapsed * 0.008 + i));
               buf.vertex(haloMat, c1 * haloR, haloY, s1 * haloR).texture(0.0F, 0.0F).color(pureLight.getRGB());
               buf.vertex(haloMat, c1 * (haloR + rayLen), haloY, s1 * (haloR + rayLen)).texture(1.0F, 0.0F).color(brilliantGold.withAlpha(0.0F).getRGB());
               buf.vertex(haloMat, c2 * (haloR + rayLen), haloY, s2 * (haloR + rayLen)).texture(1.0F, 1.0F).color(brilliantGold.withAlpha(0.0F).getRGB());
               buf.vertex(haloMat, c2 * haloR, haloY, s2 * haloR).texture(0.0F, 1.0F).color(pureLight.getRGB());
            }
         }

         // Inner concentric golden core ring
         float innerHaloR = 0.22F;
         for (int i = 0; i < haloSegs; i++) {
            double a1 = (Math.PI * 2.0 * i) / haloSegs - elapsed * 0.045;
            double a2 = (Math.PI * 2.0 * (i + 1)) / haloSegs - elapsed * 0.045;
            float c1 = (float)Math.cos(a1), s1 = (float)Math.sin(a1);
            float c2 = (float)Math.cos(a2), s2 = (float)Math.sin(a2);

            buf.vertex(haloMat, c1 * (innerHaloR - 0.02F), haloY + 0.01F, s1 * (innerHaloR - 0.02F)).texture(0.0F, 0.0F).color(sacredAmber.getRGB());
            buf.vertex(haloMat, c2 * (innerHaloR - 0.02F), haloY + 0.01F, s2 * (innerHaloR - 0.02F)).texture(1.0F, 0.0F).color(sacredAmber.getRGB());
            buf.vertex(haloMat, c2 * (innerHaloR + 0.02F), haloY + 0.01F, s2 * (innerHaloR + 0.02F)).texture(1.0F, 1.0F).color(pureLight.getRGB());
            buf.vertex(haloMat, c1 * (innerHaloR + 0.02F), haloY + 0.01F, s1 * (innerHaloR + 0.02F)).texture(0.0F, 1.0F).color(pureLight.getRGB());
         }

         // --- MAJESTIC ANGELIC WINGS (Flapping OUTWARDS away from spine!) ---
         // Wing flap angle: smooth soaring sinusoidal motion
         float wingFlap = (float)Math.sin(elapsed * 0.0055F) * 34.0F;
         ColorRGBA wingFeather = new ColorRGBA(255.0F, 252.0F, 235.0F, 240.0F * alpha);
         ColorRGBA wingGlow = new ColorRGBA(255.0F, 225.0F, 110.0F, 210.0F * alpha);
         ColorRGBA wingTip = new ColorRGBA(255.0F, 245.0F, 180.0F, 190.0F * alpha);

         // LEFT WING: Mounted on left shoulder (-X), spreads OUTWARD to the left (-X) and back (+Z)
         m.push();
         m.translate(-0.16F, 1.28F, 0.16F);
         m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-24.0F - wingFlap));
         m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(-16.0F));
         m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(8.0F));
         renderMajesticWing(m, buf, -1.0F, wingFeather, wingGlow, wingTip);
         m.pop();

         // RIGHT WING: Mounted on right shoulder (+X), spreads OUTWARD to the right (+X) and back (+Z)
         m.push();
         m.translate(0.16F, 1.28F, 0.16F);
         m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(24.0F + wingFlap));
         m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(16.0F));
         m.multiply(RotationAxis.POSITIVE_X.rotationDegrees(8.0F));
         renderMajesticWing(m, buf, 1.0F, wingFeather, wingGlow, wingTip);
         m.pop();

         m.pop();

         m.pop();
      }

      // Render full 3D layered feathered wing spreading outward in direction 'dir' (1.0 = right, -1.0 = left)
      private static void renderMajesticWing(MatrixStack m, BufferBuilder buf, float dir, ColorRGBA feather, ColorRGBA glow, ColorRGBA tip) {
         org.joml.Matrix4f mat = m.peek().getPositionMatrix();

         // Tier 1: Long Primary Flight Feathers (sweeping 1.15m outward and up)
         float x1 = dir * 0.40F, y1 = 0.55F, z1 = 0.05F;
         float x2 = dir * 0.95F, y2 = 1.05F, z2 = 0.12F;
         float x3 = dir * 1.15F, y3 = 0.75F, z3 = 0.08F;
         float x4 = dir * 0.70F, y4 = 0.15F, z4 = 0.02F;

         // Double sided rendering for full 360-degree spectacle
         buf.vertex(mat, 0.0F, 0.0F, 0.0F).texture(0.0F, 0.0F).color(glow.getRGB());
         buf.vertex(mat, x1, y1, z1).texture(1.0F, 0.0F).color(feather.getRGB());
         buf.vertex(mat, x2, y2, z2).texture(1.0F, 1.0F).color(tip.getRGB());
         buf.vertex(mat, x4, y4, z4).texture(0.0F, 1.0F).color(feather.getRGB());

         buf.vertex(mat, x4, y4, z4).texture(0.0F, 1.0F).color(feather.getRGB());
         buf.vertex(mat, x2, y2, z2).texture(1.0F, 1.0F).color(tip.getRGB());
         buf.vertex(mat, x1, y1, z1).texture(1.0F, 0.0F).color(feather.getRGB());
         buf.vertex(mat, 0.0F, 0.0F, 0.0F).texture(0.0F, 0.0F).color(glow.getRGB());

         // Primary wing tip
         buf.vertex(mat, x4, y4, z4).texture(0.0F, 0.0F).color(feather.getRGB());
         buf.vertex(mat, x2, y2, z2).texture(1.0F, 0.0F).color(tip.getRGB());
         buf.vertex(mat, x3, y3, z3).texture(1.0F, 1.0F).color(tip.getRGB());
         buf.vertex(mat, dir * 0.55F, -0.15F, 0.0F).texture(0.0F, 1.0F).color(feather.getRGB());

         buf.vertex(mat, dir * 0.55F, -0.15F, 0.0F).texture(0.0F, 1.0F).color(feather.getRGB());
         buf.vertex(mat, x3, y3, z3).texture(1.0F, 1.0F).color(tip.getRGB());
         buf.vertex(mat, x2, y2, z2).texture(1.0F, 0.0F).color(tip.getRGB());
         buf.vertex(mat, x4, y4, z4).texture(0.0F, 0.0F).color(feather.getRGB());

         // Tier 2: Secondary Feathers (mid-wing body)
         float sx1 = dir * 0.55F, sy1 = -0.15F, sz1 = 0.0F;
         float sx2 = dir * 0.85F, sy2 = 0.35F, sz2 = 0.06F;
         float sx3 = dir * 0.45F, sy3 = -0.45F, sz3 = -0.04F;

         buf.vertex(mat, 0.0F, -0.10F, 0.0F).texture(0.0F, 0.0F).color(glow.getRGB());
         buf.vertex(mat, sx1, sy1, sz1).texture(1.0F, 0.0F).color(feather.getRGB());
         buf.vertex(mat, sx2, sy2, sz2).texture(1.0F, 1.0F).color(tip.getRGB());
         buf.vertex(mat, sx3, sy3, sz3).texture(0.0F, 1.0F).color(feather.getRGB());

         buf.vertex(mat, sx3, sy3, sz3).texture(0.0F, 1.0F).color(feather.getRGB());
         buf.vertex(mat, sx2, sy2, sz2).texture(1.0F, 1.0F).color(tip.getRGB());
         buf.vertex(mat, sx1, sy1, sz1).texture(1.0F, 0.0F).color(feather.getRGB());
         buf.vertex(mat, 0.0F, -0.10F, 0.0F).texture(0.0F, 0.0F).color(glow.getRGB());

         // Tier 3: Soft Downy Feathers at base
         buf.vertex(mat, 0.0F, 0.0F, 0.0F).texture(0.0F, 0.0F).color(glow.getRGB());
         buf.vertex(mat, dir * 0.30F, 0.25F, 0.04F).texture(1.0F, 0.0F).color(tip.getRGB());
         buf.vertex(mat, dir * 0.35F, -0.25F, 0.0F).texture(1.0F, 1.0F).color(tip.getRGB());
         buf.vertex(mat, 0.0F, -0.20F, 0.0F).texture(0.0F, 1.0F).color(glow.getRGB());
      }

      // Render 3D Angelic victim model ascending gracefully into heaven
      void renderModel(Render3DEvent event, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         float alpha = (prog < 0.80F) ? Math.min(1.0F, prog * 3.5F) : (1.0F - (prog - 0.80F) / 0.20F);
         if (alpha <= 0.01F) return;

         PlayerEntityModel victimModel = KillEffectsModule.getVictimModel();
         if (victimModel == null || this.skin == null) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         float ascendY = prog * 4.6F + (float)Math.sin(elapsed * 0.004F) * 0.15F;
         float gentleYaw = this.initialYaw + (float)Math.sin(elapsed * 0.0025F) * 10.0F;

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y + ascendY, this.pos.z - cpos.z);
         m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(gentleYaw));

         m.scale(-0.9375F, -0.9375F, 0.9375F);
         m.translate(0.0, -1.501, 0.0);

         // Graceful peaceful ascension posture: head looking to heaven, arms outstretched peacefully
         victimModel.head.pitch = -0.48F;
         victimModel.head.yaw = 0.0F;
         victimModel.leftArm.pitch = -0.65F;
         victimModel.leftArm.roll = -0.75F;
         victimModel.rightArm.pitch = -0.65F;
         victimModel.rightArm.roll = 0.75F;
         victimModel.leftLeg.pitch = 0.18F;
         victimModel.rightLeg.pitch = 0.10F;
         victimModel.body.pitch = -0.12F;

         int colorAlpha = (int)(alpha * 255.0F);
         int tint = (colorAlpha << 24) | 0x00FFFFFF;

         try {
            VertexConsumerProvider.Immediate consumers = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
            VertexConsumer vc = consumers.getBuffer(RenderLayer.getEntityTranslucent(this.skin.texture()));
            victimModel.render(m, vc, 15728880, OverlayTexture.DEFAULT_UV, tint);
            consumers.draw();
         } catch (Throwable ignored) {}

         m.pop();
      }
   }

   // --- REPLACED BLACK HOLE WITH SPECTACULAR "CELESTIAL JUDGEMENT / БОЖЕСТВЕННЫЙ МЕЧ" ---
   static class SingularityCollapseEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final SkinTextures skin;
      private final float initialYaw;
      private final long startTime;
      private static final long DURATION = 3200L;
      private final float[] shardVx = new float[36];
      private final float[] shardVy = new float[36];
      private final float[] shardVz = new float[36];
      private final float[] shardSize = new float[36];

      SingularityCollapseEffect(Vec3d pos, ColorRGBA col, SkinTextures skin, float initialYaw) {
         this.pos = pos;
         this.col = col;
         this.skin = (skin != null) ? skin : DefaultSkinHelper.getSkinTextures(UUID.randomUUID());
         this.initialYaw = initialYaw;
         this.startTime = System.currentTimeMillis();

         // Precompute explosive crystal shards
         for (int i = 0; i < 36; i++) {
            double theta = RANDOM.nextDouble() * Math.PI * 2.0;
            double phi = (RANDOM.nextDouble() - 0.3) * Math.PI * 0.8;
            float speed = 2.5F + RANDOM.nextFloat() * 4.5F;
            this.shardVx[i] = (float)(Math.cos(phi) * Math.cos(theta) * speed);
            this.shardVy[i] = (float)(Math.sin(phi) * speed) + 1.8F;
            this.shardVz[i] = (float)(Math.cos(phi) * Math.sin(theta) * speed);
            this.shardSize[i] = 0.12F + RANDOM.nextFloat() * 0.18F;
         }
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         float alpha = (prog < 0.88F) ? Math.min(1.0F, prog * 5.0F) : (1.0F - (prog - 0.88F) / 0.12F);
         if (alpha <= 0.01F) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y, this.pos.z - cpos.z);

         ColorRGBA divineGold = new ColorRGBA(255.0F, 215.0F, 50.0F, 245.0F * alpha);
         ColorRGBA celestialCyan = new ColorRGBA(70.0F, 230.0F, 255.0F, 235.0F * alpha);
         ColorRGBA pureWhite = new ColorRGBA(255.0F, 255.0F, 255.0F, 255.0F * alpha);

         org.joml.Matrix4f mat = m.peek().getPositionMatrix();

         // Phase 1 (0.0 to 0.38): The Celestial Sword plunges from high heavens (Y = 14.0 down to ground Y = 0.0)
         // Impact occurs at prog = 0.38
         float swordY;
         if (prog < 0.38F) {
            float dropProgress = prog / 0.38F;
            swordY = (1.0F - (float)Math.pow(dropProgress, 3.0)) * 14.0F;
         } else {
            swordY = 0.0F; // Impaled in the earth
         }

         // --- 1. RENDER THE GIGANTIC 4-METER SACRED GREATSWORD OF JUDGEMENT ---
         m.push();
         m.translate(0.0F, swordY, 0.0F);
         m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(this.initialYaw + 45.0F));

         org.joml.Matrix4f swordMat = m.peek().getPositionMatrix();
         float bladeW = 0.32F;
         float bladeLen = 3.6F;
         float guardW = 0.95F;

         // Glowing Dual-Edged Holy Blade
         buf.vertex(swordMat, -bladeW, 0.8F, 0.0F).texture(0.0F, 0.0F).color(celestialCyan.getRGB());
         buf.vertex(swordMat, bladeW, 0.8F, 0.0F).texture(1.0F, 0.0F).color(celestialCyan.getRGB());
         buf.vertex(swordMat, 0.0F, 0.8F + bladeLen, 0.0F).texture(0.5F, 1.0F).color(pureWhite.getRGB());
         buf.vertex(swordMat, 0.0F, 0.8F + bladeLen, 0.0F).texture(0.5F, 1.0F).color(pureWhite.getRGB());

         // Reverse side of blade
         buf.vertex(swordMat, 0.0F, 0.8F + bladeLen, 0.0F).texture(0.5F, 1.0F).color(pureWhite.getRGB());
         buf.vertex(swordMat, bladeW, 0.8F, 0.0F).texture(1.0F, 0.0F).color(celestialCyan.getRGB());
         buf.vertex(swordMat, -bladeW, 0.8F, 0.0F).texture(0.0F, 0.0F).color(celestialCyan.getRGB());
         buf.vertex(swordMat, 0.0F, 0.8F + bladeLen, 0.0F).texture(0.5F, 1.0F).color(pureWhite.getRGB());

         // Golden Crossguard
         buf.vertex(swordMat, -guardW, 0.8F, -0.06F).texture(0.0F, 0.0F).color(divineGold.getRGB());
         buf.vertex(swordMat, guardW, 0.8F, -0.06F).texture(1.0F, 0.0F).color(divineGold.getRGB());
         buf.vertex(swordMat, guardW, 0.95F, 0.06F).texture(1.0F, 1.0F).color(divineGold.getRGB());
         buf.vertex(swordMat, -guardW, 0.95F, 0.06F).texture(0.0F, 1.0F).color(divineGold.getRGB());

         // Sacred Pommel & Hilt
         buf.vertex(swordMat, -0.08F, 0.3F, 0.0F).texture(0.0F, 0.0F).color(divineGold.getRGB());
         buf.vertex(swordMat, 0.08F, 0.3F, 0.0F).texture(1.0F, 0.0F).color(divineGold.getRGB());
         buf.vertex(swordMat, 0.08F, 0.8F, 0.0F).texture(1.0F, 1.0F).color(celestialCyan.getRGB());
         buf.vertex(swordMat, -0.08F, 0.8F, 0.0F).texture(0.0F, 1.0F).color(celestialCyan.getRGB());

         m.pop();

         // --- 2. IMPACT DETONATION (prog >= 0.38): SEISMIC CELESTIAL SHOCKWAVES & RUNE CIRCLES ---
         if (prog >= 0.38F) {
            float impactT = (prog - 0.38F) / 0.62F;
            float shockRadius = impactT * 4.8F;
            float shockAlpha = (1.0F - impactT) * alpha;

            // Concentric Golden Shockwave Rings
            int shockSegs = 32;
            for (int r = 1; r <= 2; r++) {
               float rIn = shockRadius * (r == 1 ? 0.92F : 0.65F);
               float rOut = shockRadius * (r == 1 ? 1.04F : 0.74F);
               for (int i = 0; i < shockSegs; i++) {
                  double a1 = (Math.PI * 2.0 * i) / shockSegs;
                  double a2 = (Math.PI * 2.0 * (i + 1)) / shockSegs;
                  float c1 = (float)Math.cos(a1), s1 = (float)Math.sin(a1);
                  float c2 = (float)Math.cos(a2), s2 = (float)Math.sin(a2);

                  int ringCol = (r == 1 ? celestialCyan : divineGold).withAlpha(shockAlpha * 240.0F).getRGB();
                  buf.vertex(mat, c1 * rIn, 0.03F, s1 * rIn).texture(0.0F, 0.0F).color(ringCol);
                  buf.vertex(mat, c2 * rIn, 0.03F, s2 * rIn).texture(1.0F, 0.0F).color(ringCol);
                  buf.vertex(mat, c2 * rOut, 0.03F, s2 * rOut).texture(1.0F, 1.0F).color(ringCol);
                  buf.vertex(mat, c1 * rOut, 0.03F, s1 * rOut).texture(0.0F, 1.0F).color(ringCol);
               }
            }

            // Radiating Ground Fissure Light Beams
            int fissureRays = 8;
            for (int fr = 0; fr < fissureRays; fr++) {
               double fa = (Math.PI * 2.0 * fr) / fissureRays + 0.3;
               float fc = (float)Math.cos(fa), fs = (float)Math.sin(fa);
               float fx1 = fc * 0.2F, fz1 = fs * 0.2F;
               float fx2 = fc * shockRadius, fz2 = fs * shockRadius;
               float perpX = -fs * 0.05F, perpZ = fc * 0.05F;

               buf.vertex(mat, fx1 - perpX, 0.04F, fz1 - perpZ).texture(0.0F, 0.0F).color(pureWhite.withAlpha(shockAlpha * 255.0F).getRGB());
               buf.vertex(mat, fx2 - perpX, 0.04F, fz2 - perpZ).texture(1.0F, 0.0F).color(divineGold.withAlpha(0.0F).getRGB());
               buf.vertex(mat, fx2 + perpX, 0.04F, fz2 + perpZ).texture(1.0F, 1.0F).color(divineGold.withAlpha(0.0F).getRGB());
               buf.vertex(mat, fx1 + perpX, 0.04F, fz1 + perpZ).texture(0.0F, 1.0F).color(pureWhite.withAlpha(shockAlpha * 255.0F).getRGB());
            }

            // Exploding Tumbling Crystalline Shards (the shattered victim)
            for (int s = 0; s < 36; s++) {
               float sx = this.shardVx[s] * impactT;
               float sy = this.shardVy[s] * impactT - 0.5F * 9.8F * (impactT * impactT * 0.7F);
               float sz = this.shardVz[s] * impactT;
               if (sy < 0.02F) sy = 0.02F;

               m.push();
               m.translate(sx, sy, sz);
               m.multiply(cam.getRotation());
               float szDim = this.shardSize[s] * (1.0F - impactT * 0.6F);
               ColorRGBA sCol = (s % 2 == 0) ? pureWhite : celestialCyan;
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -szDim * 0.5F, -szDim * 0.5F, 0.0, szDim, szDim, sCol.withAlpha(shockAlpha * 240.0F));
               m.pop();
            }
         }

         m.pop();
      }

      // Render 3D victim model until the sword impact detonates them into crystals
      void renderModel(Render3DEvent event, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         if (prog >= 0.38F) return; // Shattered on impact into crystalline shards!

         PlayerEntityModel victimModel = KillEffectsModule.getVictimModel();
         if (victimModel == null || this.skin == null) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         // Victim stands locked in place looking up in awe at the descending greatsword
         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y, this.pos.z - cpos.z);
         m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(this.initialYaw));

         m.scale(-0.9375F, -0.9375F, 0.9375F);
         m.translate(0.0, -1.501, 0.0);

         // Looking up at the sword
         victimModel.head.pitch = -0.75F;
         victimModel.leftArm.pitch = -0.40F;
         victimModel.rightArm.pitch = -0.40F;

         // Divine cyan/gold illumination on victim
         int tint = (255 << 24) | 0x00FFFFFF;
         try {
            VertexConsumerProvider.Immediate consumers = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
            VertexConsumer vc = consumers.getBuffer(RenderLayer.getEntityTranslucent(this.skin.texture()));
            victimModel.render(m, vc, 15728880, OverlayTexture.DEFAULT_UV, tint);
            consumers.draw();
         } catch (Throwable ignored) {}

         m.pop();
      }
   }

   static class GlacialTombEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final SkinTextures skin;
      private final float initialYaw;
      private final long startTime;
      private static final long DURATION = 2700L;

      GlacialTombEffect(Vec3d pos, ColorRGBA col, SkinTextures skin, float initialYaw) {
         this.pos = pos;
         this.col = col;
         this.skin = (skin != null) ? skin : DefaultSkinHelper.getSkinTextures(UUID.randomUUID());
         this.initialYaw = initialYaw;
         this.startTime = System.currentTimeMillis();
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         float alpha = (prog < 0.88F) ? Math.min(1.0F, prog * 5.0F) : (1.0F - (prog - 0.88F) / 0.12F);
         if (alpha <= 0.01F) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y, this.pos.z - cpos.z);

         ColorRGBA iceCyan = new ColorRGBA(120.0F, 220.0F, 255.0F, 210.0F * alpha);
         ColorRGBA iceGleam = new ColorRGBA(220.0F, 245.0F, 255.0F, 240.0F * alpha);
         ColorRGBA frostMist = new ColorRGBA(180.0F, 230.0F, 255.0F, 160.0F * alpha);

         if (prog < 0.72F) {
            // Crystalline Glacial Ice Monolith encasing the player
            float freezeRise = Math.min(1.0F, prog * 3.5F);
            float monoH = 2.2F * freezeRise;
            float monoW = 1.1F;

            // 4 vertical ice monolith panels forming a 3D prism
            for (int p = 0; p < 4; p++) {
               m.push();
               m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(p * 90.0F + 45.0F));
               m.translate(0.0, monoH * 0.5F, 0.50F);
               m.multiply(cam.getRotation());
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -monoW * 0.5F, -monoH * 0.5F, 0.0, monoW, monoH, iceCyan);
               m.pop();
            }

            // Glowing frost crystals at the base
            for (int b = 0; b < 8; b++) {
               double ba = (Math.PI * 2.0 * b) / 8.0;
               m.push();
               m.translate((float)Math.cos(ba) * 0.85F, 0.25F, (float)Math.sin(ba) * 0.85F);
               m.multiply(cam.getRotation());
               float spkSz = 0.35F * freezeRise;
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -spkSz * 0.5F, -spkSz * 0.5F, 0.0, spkSz, spkSz, iceGleam);
               m.pop();
            }
         } else {
            // Shatter detonation! Explosive burst of ice shards and cryogenic vapor
            float shatterProg = (prog - 0.72F) / 0.28F;
            float sDist = (float)Math.pow(shatterProg, 0.65) * 3.8F;
            float sAlpha = (1.0F - shatterProg) * alpha;

            for (int s = 0; s < 28; s++) {
               double sa = s * 1.35;
               float sx = (float)Math.cos(sa) * sDist;
               float sy = 0.9F + (float)Math.sin(sa * 2.4) * sDist * 0.6F;
               float sz = (float)Math.sin(sa) * sDist;

               m.push();
               m.translate(sx, sy, sz);
               m.multiply(cam.getRotation());
               float shardSz = 0.24F * (1.0F - shatterProg * 0.6F);
               ColorRGBA sc = (s % 2 == 0) ? iceGleam : frostMist;
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -shardSz * 0.5F, -shardSz * 0.5F, 0.0, shardSz, shardSz, sc.withAlpha(sAlpha * 255.0F));
               m.pop();
            }
         }

         m.pop();
      }

      void renderModel(Render3DEvent event, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         if (prog > 0.72F) return; // Shattered together with the ice

         PlayerEntityModel victimModel = KillEffectsModule.getVictimModel();
         if (victimModel == null || this.skin == null) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         // Shivering violently before freezing solid
         float shiver = (prog < 0.35F) ? (float)Math.sin(elapsed * 0.12F) * 0.04F : 0.0F;

         m.push();
         m.translate(this.pos.x - cpos.x + shiver, this.pos.y - cpos.y, this.pos.z - cpos.z);
         m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(this.initialYaw));

         m.scale(-0.9375F, -0.9375F, 0.9375F);
         m.translate(0.0, -1.501, 0.0);

         // Frozen shivering pose: arms pulled close to chest
         victimModel.leftArm.pitch = -0.5F;
         victimModel.rightArm.pitch = -0.5F;
         victimModel.leftArm.roll = 0.4F;
         victimModel.rightArm.roll = -0.4F;
         victimModel.head.pitch = 0.25F;
         victimModel.leftLeg.pitch = 0.0F;
         victimModel.rightLeg.pitch = 0.0F;

         // Cyan frozen tint
         int tint = (220 << 24) | 0x00A0F0FF;

         try {
            VertexConsumerProvider.Immediate consumers = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
            VertexConsumer vc = consumers.getBuffer(RenderLayer.getEntityTranslucent(this.skin.texture()));
            victimModel.render(m, vc, 15728880, OverlayTexture.DEFAULT_UV, tint);
            consumers.draw();
         } catch (Throwable ignored) {}

         m.pop();
      }
   }

   static class CyberVortexEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final long startTime;
      private static final long DURATION = 3000L;
      private final float[][] bitOffsets = new float[36][3];
      private final float[] bitSpeeds = new float[36];

      CyberVortexEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.col = col;
         this.startTime = System.currentTimeMillis();
         Random r = KillEffectsModule.RANDOM;
         for (int i = 0; i < 36; i++) {
            this.bitOffsets[i][0] = r.nextFloat() * (float)Math.PI * 2.0F;
            this.bitOffsets[i][1] = 0.4F + r.nextFloat() * 1.6F;
            this.bitOffsets[i][2] = r.nextFloat() * 2.5F;
            this.bitSpeeds[i] = 1.5F + r.nextFloat() * 2.5F;
         }
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         float alpha = (prog < 0.85F) ? Math.min(1.0F, prog * 5.0F) : (1.0F - (prog - 0.85F) / 0.15F);
         if (alpha <= 0.01F) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y, this.pos.z - cpos.z);

         ColorRGBA cyan = new ColorRGBA(0.0F, 240.0F, 255.0F, 220.0F * alpha);
         ColorRGBA magenta = new ColorRGBA(255.0F, 20.0F, 147.0F, 210.0F * alpha);
         ColorRGBA white = new ColorRGBA(255.0F, 255.0F, 255.0F, 240.0F * alpha);

         for (int b = 0; b < 3; b++) {
            m.push();
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(elapsed * 0.15F + b * 120.0F));
            m.translate(0.0, 2.5, 0.0);
            m.multiply(cam.getRotation());
            float beamH = 5.0F * (1.0F - prog * 0.3F);
            float beamW = 0.18F;
            ColorRGBA bc = (b % 2 == 0) ? cyan : magenta;
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -beamW * 0.5F, -beamH * 0.5F, 0.0, beamW, beamH, bc);
            m.pop();
         }

         int ringCount = 4;
         for (int r = 0; r < ringCount; r++) {
            float ry = 0.3F + r * 0.9F;
            float radius = 1.4F - r * 0.2F + (float)Math.sin(elapsed * 0.003F + r) * 0.15F;
            float rot = (elapsed * 0.12F * (r % 2 == 0 ? 1.0F : -1.0F)) + r * 45.0F;

            int segs = 16;
            for (int s = 0; s < segs; s++) {
               double a = Math.toRadians(rot + (s * 360.0F / segs));
               float sx = (float)Math.cos(a) * radius;
               float sz = (float)Math.sin(a) * radius;

               m.push();
               m.translate(sx, ry, sz);
               m.multiply(cam.getRotation());
               float segW = 0.28F;
               float segH = 0.08F;
               ColorRGBA ringCol = (s % 2 == 0) ? cyan : magenta;
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -segW * 0.5F, -segH * 0.5F, 0.0, segW, segH, ringCol);
               m.pop();
            }
         }

         for (int i = 0; i < 36; i++) {
            float curA = this.bitOffsets[i][0] + (elapsed * 0.004F * this.bitSpeeds[i]);
            float curR = this.bitOffsets[i][1] * (1.0F - prog * 0.4F);
            float curY = (this.bitOffsets[i][2] + (elapsed * 0.0025F * this.bitSpeeds[i])) % 4.5F;

            float bx = (float)Math.cos(curA) * curR;
            float bz = (float)Math.sin(curA) * curR;

            m.push();
            m.translate(bx, curY, bz);
            m.multiply(cam.getRotation());
            float bitSz = 0.12F + (i % 3 == 0 ? 0.06F : 0.0F);
            ColorRGBA bitC = (i % 3 == 0) ? white : ((i % 2 == 0) ? cyan : magenta);
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -bitSz * 0.5F, -bitSz * 0.5F, 0.0, bitSz, bitSz, bitC);
            m.pop();
         }

         m.pop();
      }
   }

   static class QuantumShatterEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final long startTime;
      private static final long DURATION = 2800L;
      private final float[][] shardDir = new float[42][3];
      private final float[] shardRot = new float[42];
      private final float[] shardScale = new float[42];

      QuantumShatterEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.col = col;
         this.startTime = System.currentTimeMillis();
         Random r = KillEffectsModule.RANDOM;
         for (int i = 0; i < 42; i++) {
            double theta = r.nextDouble() * Math.PI * 2.0;
            double phi = (r.nextDouble() - 0.5) * Math.PI;
            float speed = 2.0F + r.nextFloat() * 4.0F;
            this.shardDir[i][0] = (float)(Math.cos(phi) * Math.cos(theta)) * speed;
            this.shardDir[i][1] = (float)Math.sin(phi) * speed + 1.2F;
            this.shardDir[i][2] = (float)(Math.cos(phi) * Math.sin(theta)) * speed;
            this.shardRot[i] = r.nextFloat() * 360.0F;
            this.shardScale[i] = 0.15F + r.nextFloat() * 0.22F;
         }
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         float alpha = (prog < 0.85F) ? Math.min(1.0F, prog * 6.0F) : (1.0F - (prog - 0.85F) / 0.15F);
         if (alpha <= 0.01F) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y, this.pos.z - cpos.z);

         if (prog < 0.25F) {
            float prepProg = prog / 0.25F;
            float jitter = (float)Math.sin(elapsed * 0.3F) * 0.08F * prepProg;
            m.push();
            m.translate(jitter, 1.1 + jitter, -jitter);
            m.multiply(cam.getRotation());
            float coreSz = 0.6F * (1.0F - prepProg * 0.4F);
            ColorRGBA red = new ColorRGBA(255.0F, 50.0F, 50.0F, 180.0F * alpha);
            ColorRGBA cyan = new ColorRGBA(50.0F, 220.0F, 255.0F, 180.0F * alpha);
            ColorRGBA white = new ColorRGBA(255.0F, 255.0F, 255.0F, 240.0F * alpha);
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -coreSz * 0.5F - 0.04F, -coreSz * 0.5F, 0.0, coreSz, coreSz, red);
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -coreSz * 0.5F + 0.04F, -coreSz * 0.5F, 0.0, coreSz, coreSz, cyan);
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -coreSz * 0.5F, -coreSz * 0.5F, 0.0, coreSz, coreSz, white);
            m.pop();
         } else {
            float shatterProg = (prog - 0.25F) / 0.75F;
            float drag = (float)Math.pow(shatterProg, 0.75);

            float shockRadius = shatterProg * 5.0F;
            float shockAlpha = (1.0F - shatterProg) * alpha * 180.0F;
            for (int sr = 0; sr < 20; sr++) {
               double sAng = (Math.PI * 2.0 * sr) / 20.0;
               m.push();
               m.translate((float)Math.cos(sAng) * shockRadius, 0.15F, (float)Math.sin(sAng) * shockRadius);
               m.multiply(cam.getRotation());
               float rSz = 0.22F * (1.0F - shatterProg);
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -rSz * 0.5F, -rSz * 0.5F, 0.0, rSz, rSz, new ColorRGBA(100.0F, 200.0F, 255.0F, shockAlpha));
               m.pop();
            }

            for (int i = 0; i < 42; i++) {
               float sx = this.shardDir[i][0] * drag;
               float sy = 1.1F + this.shardDir[i][1] * drag - (shatterProg * shatterProg * 1.8F);
               float sz = this.shardDir[i][2] * drag;

               m.push();
               m.translate(sx, sy, sz);
               m.multiply(cam.getRotation());
               m.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(this.shardRot[i] + elapsed * 0.2F));

               float sSize = this.shardScale[i] * (1.0F - shatterProg * 0.5F);
               float shardA = (1.0F - shatterProg * 0.8F) * alpha;

               ColorRGBA colCyan = new ColorRGBA(0.0F, 230.0F, 255.0F, shardA * 210.0F);
               ColorRGBA colViolet = new ColorRGBA(220.0F, 60.0F, 255.0F, shardA * 210.0F);
               ColorRGBA colGleam = new ColorRGBA(255.0F, 255.0F, 255.0F, shardA * 240.0F);

               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -sSize * 0.5F - 0.02F, -sSize * 0.5F, 0.0, sSize, sSize, colCyan);
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -sSize * 0.5F + 0.02F, -sSize * 0.5F, 0.0, sSize, sSize, colViolet);
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -sSize * 0.4F, -sSize * 0.4F, 0.0, sSize * 0.8F, sSize * 0.8F, colGleam);
               m.pop();
            }
         }

         m.pop();
      }
   }

   static class SolarFlareEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final long startTime;
      private static final long DURATION = 3200L;
      private final float[][] plasmaSparks = new float[36][3];
      private final float[] sparkVelocity = new float[36];

      SolarFlareEffect(Vec3d pos, ColorRGBA col) {
         this.pos = pos;
         this.col = col;
         this.startTime = System.currentTimeMillis();
         Random r = KillEffectsModule.RANDOM;
         for (int i = 0; i < 36; i++) {
            double ang = r.nextDouble() * Math.PI * 2.0;
            float spd = 1.5F + r.nextFloat() * 3.5F;
            this.plasmaSparks[i][0] = (float)Math.cos(ang) * spd;
            this.plasmaSparks[i][1] = 1.0F + r.nextFloat() * 4.0F;
            this.plasmaSparks[i][2] = (float)Math.sin(ang) * spd;
            this.sparkVelocity[i] = 0.5F + r.nextFloat() * 0.8F;
         }
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         float alpha = (prog < 0.85F) ? Math.min(1.0F, prog * 5.0F) : (1.0F - (prog - 0.85F) / 0.15F);
         if (alpha <= 0.01F) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y, this.pos.z - cpos.z);

         ColorRGBA solarWhite = new ColorRGBA(255.0F, 255.0F, 220.0F, 245.0F * alpha);
         ColorRGBA solarGold = new ColorRGBA(255.0F, 190.0F, 30.0F, 220.0F * alpha);
         ColorRGBA solarOrange = new ColorRGBA(255.0F, 80.0F, 10.0F, 190.0F * alpha);

         float corePulse = 1.0F + (float)Math.sin(elapsed * 0.008F) * 0.15F;
         float coreSize = (0.8F + (1.0F - prog) * 0.5F) * corePulse;
         m.push();
         m.translate(0.0, 1.3, 0.0);
         m.multiply(cam.getRotation());
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -coreSize * 1.2F * 0.5F, -coreSize * 1.2F * 0.5F, 0.0, coreSize * 1.2F, coreSize * 1.2F, solarOrange);
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -coreSize * 0.8F * 0.5F, -coreSize * 0.8F * 0.5F, 0.0, coreSize * 0.8F, coreSize * 0.8F, solarGold);
         iIiiIIiii_Class360.I_method_a9f124df(m, buf, -coreSize * 0.4F * 0.5F, -coreSize * 0.4F * 0.5F, 0.0, coreSize * 0.4F, coreSize * 0.4F, solarWhite);
         m.pop();

         for (int p = 0; p < 3; p++) {
            float loopRot = p * 120.0F + elapsed * 0.05F;
            m.push();
            m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(loopRot));

            int arcSteps = 16;
            for (int s = 0; s <= arcSteps; s++) {
               float t = (float)s / (float)arcSteps;
               float arcX = (t - 0.5F) * 2.8F;
               float arcY = 1.3F + (1.0F - 4.0F * (t - 0.5F) * (t - 0.5F)) * 1.8F;
               float arcZ = (float)Math.sin(t * Math.PI + elapsed * 0.006F) * 0.3F;

               m.push();
               m.translate(arcX, arcY, arcZ);
               m.multiply(cam.getRotation());
               float pSize = 0.22F * (1.0F - Math.abs(t - 0.5F));
               ColorRGBA arcCol = (s % 2 == 0) ? solarGold : solarOrange;
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -pSize * 0.5F, -pSize * 0.5F, 0.0, pSize, pSize, arcCol);
               m.pop();
            }
            m.pop();
         }

         float sparkProg = (float)Math.pow(prog, 0.6);
         for (int i = 0; i < 36; i++) {
            float px = this.plasmaSparks[i][0] * sparkProg;
            float py = 1.3F + this.plasmaSparks[i][1] * sparkProg - (prog * prog * 2.5F);
            float pz = this.plasmaSparks[i][2] * sparkProg;

            m.push();
            m.translate(px, py, pz);
            m.multiply(cam.getRotation());
            float sparkSz = 0.16F * (1.0F - prog * 0.7F);
            ColorRGBA sc = (i % 3 == 0) ? solarWhite : ((i % 2 == 0) ? solarGold : solarOrange);
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -sparkSz * 0.5F, -sparkSz * 0.5F, 0.0, sparkSz, sparkSz, sc);
            m.pop();
         }

         float groundR = 1.6F * (1.0F - prog * 0.2F);
         for (int gr = 0; gr < 14; gr++) {
            double ga = (Math.PI * 2.0 * gr) / 14.0;
            m.push();
            m.translate((float)Math.cos(ga) * groundR, 0.08F, (float)Math.sin(ga) * groundR);
            m.multiply(cam.getRotation());
            float gSz = 0.25F;
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -gSz * 0.5F, -gSz * 0.5F, 0.0, gSz, gSz, solarOrange.withAlpha(alpha * 140.0F));
            m.pop();
         }

         m.pop();
      }
   }

   static class VoidTentaclesEffect {
      private final Vec3d pos;
      private final ColorRGBA col;
      private final SkinTextures skin;
      private final float initialYaw;
      private final long startTime;
      private static final long DURATION = 3500L;

      VoidTentaclesEffect(Vec3d pos, ColorRGBA col, SkinTextures skin, float initialYaw) {
         this.pos = pos;
         this.col = col;
         this.skin = (skin != null) ? skin : DefaultSkinHelper.getSkinTextures(UUID.randomUUID());
         this.initialYaw = initialYaw;
         this.startTime = System.currentTimeMillis();
      }

      boolean isExpired() {
         return System.currentTimeMillis() - this.startTime > DURATION;
      }

      void render(Render3DEvent event, BufferBuilder buf, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         float alpha = (prog < 0.85F) ? Math.min(1.0F, prog * 4.0F) : (1.0F - (prog - 0.85F) / 0.15F);
         if (alpha <= 0.01F) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         m.push();
         m.translate(this.pos.x - cpos.x, this.pos.y - cpos.y, this.pos.z - cpos.z);

         ColorRGBA voidBlack = new ColorRGBA(15.0F, 5.0F, 25.0F, 230.0F * alpha);
         ColorRGBA voidPurple = new ColorRGBA(140.0F, 20.0F, 220.0F, 210.0F * alpha);
         ColorRGBA voidNeon = new ColorRGBA(200.0F, 50.0F, 255.0F, 240.0F * alpha);

         float riftRadius = 1.5F * Math.min(1.0F, prog * 3.0F);
         int riftSegs = 20;
         for (int s = 0; s < riftSegs; s++) {
            double angle = (Math.PI * 2.0 * s) / riftSegs + (elapsed * 0.002);
            float rx = (float)Math.cos(angle) * riftRadius;
            float rz = (float)Math.sin(angle) * riftRadius;

            m.push();
            m.translate(rx, 0.05F, rz);
            m.multiply(cam.getRotation());
            float rSz = 0.45F;
            ColorRGBA rc = (s % 2 == 0) ? voidPurple : voidBlack;
            iIiiIIiii_Class360.I_method_a9f124df(m, buf, -rSz * 0.5F, -rSz * 0.5F, 0.0, rSz, rSz, rc);
            m.pop();
         }

         int tentacleCount = 6;
         float emerge = Math.min(1.0F, prog * 2.5F);

         for (int t = 0; t < tentacleCount; t++) {
            double baseAngle = (Math.PI * 2.0 * t) / tentacleCount;
            float rootDist = 0.75F;
            float rootX = (float)Math.cos(baseAngle) * rootDist;
            float rootZ = (float)Math.sin(baseAngle) * rootDist;

            int segCount = 12;
            float curX = rootX;
            float curY = 0.05F;
            float curZ = rootZ;

            for (int seg = 0; seg < segCount; seg++) {
               float segT = (float)seg / (float)segCount;
               float wave = (float)Math.sin(elapsed * 0.006F + t * 1.2F + seg * 0.5F);
               float constrict = (prog > 0.4F) ? (prog - 0.4F) * 1.5F : 0.0F;

               float targetRadius = Math.max(0.2F, rootDist * (1.0F - constrict * 0.7F));
               float waveOffset = wave * 0.18F;

               curX += (float)Math.cos(baseAngle) * (targetRadius / segCount) + waveOffset * (float)Math.sin(baseAngle);
               curY += (2.2F * emerge) / segCount;
               curZ += (float)Math.sin(baseAngle) * (targetRadius / segCount) - waveOffset * (float)Math.cos(baseAngle);

               m.push();
               m.translate(curX, curY, curZ);
               m.multiply(cam.getRotation());

               float nodeSz = (0.28F * (1.0F - segT * 0.65F));
               ColorRGBA segCol = (seg == segCount - 1) ? voidNeon : ((seg % 2 == 0) ? voidPurple : voidBlack);
               iIiiIIiii_Class360.I_method_a9f124df(m, buf, -nodeSz * 0.5F, -nodeSz * 0.5F, 0.0, nodeSz, nodeSz, segCol);
               m.pop();
            }
         }

         m.pop();
      }

      void renderModel(Render3DEvent event, Camera cam) {
         long elapsed = System.currentTimeMillis() - this.startTime;
         float prog = MathHelper.clamp((float)elapsed / (float)DURATION, 0.0F, 1.0F);
         if (prog > 0.85F) return;

         PlayerEntityModel victimModel = KillEffectsModule.getVictimModel();
         if (victimModel == null || this.skin == null) return;

         MatrixStack m = event.getMatrices();
         Vec3d cpos = cam.getPos();

         float sinkY = (prog > 0.35F) ? (float)Math.pow((prog - 0.35F) / 0.5F, 1.4) * 2.2F : 0.0F;
         float struggle = (prog < 0.6F) ? (float)Math.sin(elapsed * 0.18F) * 0.05F : 0.0F;

         m.push();
         m.translate(this.pos.x - cpos.x + struggle, this.pos.y - cpos.y - sinkY, this.pos.z - cpos.z);
         m.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(this.initialYaw));

         m.scale(-0.9375F, -0.9375F, 0.9375F);
         m.translate(0.0, -1.501, 0.0);

         victimModel.leftArm.pitch = -2.2F;
         victimModel.rightArm.pitch = -2.4F;
         victimModel.leftArm.roll = -0.5F;
         victimModel.rightArm.roll = 0.5F;
         victimModel.head.pitch = -0.8F;

         float modelAlpha = Math.max(0.1F, 1.0F - (sinkY / 2.2F));
         int aInt = (int)(modelAlpha * 240.0F);
         int tint = (aInt << 24) | 0x004B0082;

         try {
            VertexConsumerProvider.Immediate consumers = MinecraftClient.getInstance().getBufferBuilders().getEntityVertexConsumers();
            VertexConsumer vc = consumers.getBuffer(RenderLayer.getEntityTranslucent(this.skin.texture()));
            victimModel.render(m, vc, 15728880, OverlayTexture.DEFAULT_UV, tint);
            consumers.draw();
         } catch (Throwable ignored) {}

         m.pop();
      }
   }
}
