package rockstar.client;

import com.mojang.authlib.GameProfile;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentHashMap.KeySetView;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import moscow.rockstar.mixin.accessors.EntityS2CPacketAccessor;
import moscow.rockstar.mixin.accessors.EntitySetHeadYawS2CPacketAccessor;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerPosition;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.network.packet.s2c.play.BlockUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDataS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkDeltaUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkLoadDistanceS2CPacket;
import net.minecraft.network.packet.s2c.play.ChunkRenderDistanceCenterS2CPacket;
import net.minecraft.network.packet.s2c.play.CommonPlayerSpawnInfo;
import net.minecraft.network.packet.s2c.play.EntitiesDestroyS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityPositionS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityPositionSyncS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityS2CPacket;
import net.minecraft.network.packet.s2c.play.EntitySetHeadYawS2CPacket;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.network.packet.s2c.play.EntityVelocityUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.GameJoinS2CPacket;
import net.minecraft.network.packet.s2c.play.GameStateChangeS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerListS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerRemoveS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerRespawnS2CPacket;
import net.minecraft.network.packet.s2c.play.ScoreboardDisplayS2CPacket;
import net.minecraft.network.packet.s2c.play.ScoreboardObjectiveUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.ScoreboardScoreResetS2CPacket;
import net.minecraft.network.packet.s2c.play.ScoreboardScoreUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.SimulationDistanceS2CPacket;
import net.minecraft.network.packet.s2c.play.TeamS2CPacket;
import net.minecraft.network.packet.s2c.play.WorldTimeUpdateS2CPacket;
import net.minecraft.network.packet.s2c.play.PlayerListS2CPacket.Action;
import net.minecraft.network.packet.s2c.play.PlayerListS2CPacket.Entry;
import net.minecraft.network.packet.s2c.play.TeamS2CPacket.Operation;
import net.minecraft.network.packet.s2c.play.TeamS2CPacket.SerializableTeam;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.scoreboard.ScoreAccess;
import net.minecraft.scoreboard.ScoreHolder;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.ScoreboardCriterion;
import net.minecraft.scoreboard.ScoreboardDisplaySlot;
import net.minecraft.scoreboard.ScoreboardEntry;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.scoreboard.Team;
import net.minecraft.scoreboard.AbstractTeam.CollisionRule;
import net.minecraft.scoreboard.AbstractTeam.VisibilityRule;
import net.minecraft.scoreboard.number.NumberFormat;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.BlockView;
import net.minecraft.world.EmptyBlockView;
import net.minecraft.world.GameMode;
import net.minecraft.world.World;
import net.minecraft.world.chunk.ChunkSection;
import net.minecraft.world.dimension.DimensionType;

public class IIIiIIii_Class20 {
   private final String I_field_523beb0a;
   private final Map<Integer, IIIiIIii_Class20.Nested1_834f18f3> I_field_a567c40b = new ConcurrentHashMap<>();
   private final Map<UUID, IIIiIIii_Class20.Nested1_834f1913> i_field_a567c40b = new ConcurrentHashMap<>();
   private final Map<Long, Long> II_field_a567c40b = new ConcurrentHashMap<>();
   private final Map<BlockPos, BlockState> Ii_field_a567c40b = new ConcurrentHashMap<>();
   private final Scoreboard I_field_c1395c2c = new Scoreboard();
   private static final Pattern I_field_5fd3861f = Pattern.compile("\\d+");
   private String i_field_523beb0a = "";
   private int I_field_49 = 25565;
   private int i_field_49 = -1;
   private RegistryKey<World> I_field_b0c3452b;
   private Set<RegistryKey<World>> I_field_a56a8dc5 = Collections.emptySet();
   private GameMode I_field_f90338a9;
   private GameMode i_field_f90338a9;
   private long I_field_4a;
   private long i_field_4a;
   private long II_field_4a;
   private boolean I_field_5a = true;
   private boolean i_field_5a;
   private boolean II_field_5a;
   private int II_field_49;
   private int Ii_field_49;
   private int iI_field_49;
   private int ii_field_49;
   private int III_field_49 = -64;
   private int IIi_field_49 = 384;
   private int IiI_field_49;
   private long Ii_field_4a;
   private boolean Ii_field_5a;
   private double I_field_44 = 4096.0;

   public IIIiIIii_Class20(String var1) {
      this.I_field_523beb0a = var1;
   }

   public void I_method_2934264d(String var1, int var2) {
      this.i_field_523beb0a = var1 == null ? "" : var1;
      this.I_field_49 = var2;
   }

   public void I_method_9235e4ac() {
      this.Ii_field_5a = true;
   }

   public void i_method_9244708c() {
      this.Ii_field_5a = false;
   }

   public void I_method_f218e83(GameJoinS2CPacket var1) {
      this.i_field_49 = var1.playerEntityId();
      this.I_field_a56a8dc5 = Set.copyOf(var1.dimensionIds());
      this.II_field_49 = var1.viewDistance();
      this.Ii_field_49 = var1.simulationDistance();
      this.I_method_d91e1c5e(var1.commonPlayerSpawnInfo(), true);
      this.I_field_a567c40b.clear();
      this.II_field_a567c40b.clear();
      this.Ii_field_a567c40b.clear();
      this.II_method_b495a835();
   }

   public void I_method_fe2dea98(PlayerRespawnS2CPacket var1) {
      RegistryKey var2 = this.I_field_b0c3452b;
      this.I_method_d91e1c5e(var1.commonPlayerSpawnInfo(), false);
      if (var2 != null && this.I_field_b0c3452b != null && var2 != this.I_field_b0c3452b) {
         this.I_field_a567c40b.clear();
         this.II_field_a567c40b.clear();
         this.Ii_field_a567c40b.clear();
         this.II_method_b495a835();
      }
   }

   public void I_method_14617f9(WorldTimeUpdateS2CPacket var1) {
      this.i_field_4a = var1.time();
      this.II_field_4a = var1.timeOfDay();
      this.I_field_5a = var1.tickDayTime();
   }

   public void I_method_c57461c8(ChunkDataS2CPacket var1) {
      this.II_field_a567c40b.put(ChunkPos.toLong(var1.getChunkX(), var1.getChunkZ()), this.Ii_field_4a);
      this.i_method_4d4255a8(var1);
   }

   public void I_method_2881ff06(ChunkPos var1) {
      if (var1 != null) {
         this.II_field_a567c40b.remove(var1.toLong());
         this.Ii_field_a567c40b.keySet().removeIf(var1x -> var1x.getX() >> 4 == var1.x && var1x.getZ() >> 4 == var1.z);
      }
   }

   public void I_method_fb917e07(BlockUpdateS2CPacket var1) {
      if (var1 != null) {
         this.I_method_5b4462db(var1.getPos(), var1.getState());
      }
   }

   public void I_method_98cc913b(ChunkDeltaUpdateS2CPacket var1) {
      if (var1 != null) {
         var1.visitUpdates(this::I_method_5b4462db);
      }
   }

   public void I_method_eb47a4a9(EntitySpawnS2CPacket var1) {
      IIIiIIii_Class20.Nested1_834f18f3 var2 = new IIIiIIii_Class20.Nested1_834f18f3(
         var1.getEntityId(),
         var1.getUuid(),
         this.I_method_e5bd8a60(var1.getEntityType()),
         new Vec3d(var1.getX(), var1.getY(), var1.getZ()),
         var1.getYaw(),
         var1.getPitch(),
         var1.getHeadYaw(),
         var1.getVelocityX(),
         var1.getVelocityY(),
         var1.getVelocityZ(),
         this.Ii_field_4a
      );
      this.I_field_a567c40b.put(var2.I_method_cbb38a9a(), var2);
   }

   public void I_method_9de0826a(EntityS2CPacket var1) {
      int var2 = ((EntityS2CPacketAccessor)(Object)var1).getId();
      IIIiIIii_Class20.Nested1_834f18f3 var3 = this.I_field_a567c40b.get(var2);
      if (var3 != null) {
         Vec3d var4 = var3.I_method_5c773e1();
         if (var1.isPositionChanged()) {
            var4 = var4.add(var1.getDeltaX() / this.I_field_44, var1.getDeltaY() / this.I_field_44, var1.getDeltaZ() / this.I_field_44);
         }

         float var5 = var3.I_method_cbb38a97();
         float var6 = var3.i_method_cbc21677();
         if (var1.hasRotation()) {
            var5 = var1.getYaw();
            var6 = var1.getPitch();
         }

         this.I_field_a567c40b.put(var3.I_method_cbb38a9a(), var3.I_method_1332c0b(var4, var5, var6, var3.II_method_aaccc18a(), this.Ii_field_4a));
      }
   }

   public void I_method_4f0f8510(EntityVelocityUpdateS2CPacket var1) {
      IIIiIIii_Class20.Nested1_834f18f3 var2 = this.I_field_a567c40b.get(var1.getEntityId());
      if (var2 != null) {
         this.I_field_a567c40b
            .put(var2.I_method_cbb38a9a(), var2.I_method_cc5dd2a5(var1.getVelocityX(), var1.getVelocityY(), var1.getVelocityZ(), this.Ii_field_4a));
      }
   }

   public void I_method_52b2db37(EntitySetHeadYawS2CPacket var1) {
      int var2 = ((EntitySetHeadYawS2CPacketAccessor)(Object)var1).getEntityId();
      IIIiIIii_Class20.Nested1_834f18f3 var3 = this.I_field_a567c40b.get(var2);
      if (var3 != null) {
         this.I_field_a567c40b.put(var3.I_method_cbb38a9a(), var3.I_method_f3091d27(var1.getHeadYaw(), this.Ii_field_4a));
      }
   }

   public void I_method_55e44c33(EntityPositionS2CPacket var1) {
      this.I_method_3d765eee(var1.entityId(), var1.change(), var1.onGround());
   }

   public void I_method_44d986ee(EntityPositionSyncS2CPacket var1) {
      this.I_method_3d765eee(var1.id(), var1.values(), var1.onGround());
   }

   public void I_method_f54b384a(EntitiesDestroyS2CPacket var1) {
      var1.getEntityIds().forEach(var1x -> this.I_field_a567c40b.remove(var1x));
   }

   public void I_method_41256e26(PlayerListS2CPacket var1) {
      for (Entry var3 : var1.getEntries()) {
         IIIiIIii_Class20.Nested1_834f1913 var4 = this.i_field_a567c40b.get(var3.profileId());
         if (!var1.getActions().contains(Action.ADD_PLAYER) && var4 != null) {
            String var8 = var4.I_method_1f2954f9();
            var4 = new IIIiIIii_Class20.Nested1_834f1913(
               var3.profileId(),
               var8,
               var3.gameMode() == null ? var4.I_method_346e3418() : var3.gameMode(),
               var3.latency(),
               var3.listed(),
               var3.displayName() == null ? var4.I_method_c8d4d37d() : var3.displayName(),
               this.Ii_field_4a
            );
         } else {
            GameProfile var5 = var3.profile();
            String var6 = var5 == null ? var3.profileId().toString() : var5.getName();
            var4 = new IIIiIIii_Class20.Nested1_834f1913(
               var3.profileId(), var6, var3.gameMode(), var3.latency(), var3.listed(), var3.displayName(), this.Ii_field_4a
            );
         }

         this.i_field_a567c40b.put(var3.profileId(), var4);
      }
   }

   public void I_method_221a8a0c(PlayerRemoveS2CPacket var1) {
      for (UUID var3 : var1.profileIds()) {
         this.i_field_a567c40b.remove(var3);
      }
   }

   public void I_method_c90226a0(GameStateChangeS2CPacket var1) {
      if (var1 != null) {
         if (var1.getReason() == GameStateChangeS2CPacket.GAME_MODE_CHANGED) {
            GameMode var2 = GameMode.byId(MathHelper.floor(var1.getValue()));
            if (var2 != null) {
               this.i_field_f90338a9 = this.I_field_f90338a9;
               this.I_field_f90338a9 = var2;
            }
         }
      }
   }

   public void I_method_3517ed99(ChunkLoadDistanceS2CPacket var1) {
      if (var1 != null) {
         this.II_field_49 = var1.getDistance();
      }
   }

   public void I_method_286917a3(SimulationDistanceS2CPacket var1) {
      if (var1 != null) {
         this.Ii_field_49 = var1.simulationDistance();
      }
   }

   public void I_method_6a0a14fe(ChunkRenderDistanceCenterS2CPacket var1) {
      if (var1 != null) {
         this.iI_field_49 = var1.getChunkX();
         this.ii_field_49 = var1.getChunkZ();
      }
   }

   public void I_method_a09b06bf(ScoreboardObjectiveUpdateS2CPacket var1) {
      if (var1 != null) {
         String var2 = var1.getName();
         ScoreboardObjective var3 = this.I_field_c1395c2c.getNullableObjective(var2);
         if (var1.getMode() == 1) {
            if (var3 != null) {
               this.I_field_c1395c2c.removeObjective(var3);
            }
         } else if (var3 == null) {
            this.I_field_c1395c2c
               .addObjective(var2, ScoreboardCriterion.DUMMY, var1.getDisplayName(), var1.getType(), false, (NumberFormat)var1.getNumberFormat().orElse(null));
         } else {
            var3.setDisplayName(var1.getDisplayName());
            var3.setRenderType(var1.getType());
            var3.setNumberFormat((NumberFormat)var1.getNumberFormat().orElse(null));
         }
      }
   }

   public void I_method_a371f11f(ScoreboardDisplayS2CPacket var1) {
      if (var1 != null) {
         String var2 = var1.getName();
         ScoreboardObjective var3 = var2 == null ? null : this.I_field_c1395c2c.getNullableObjective(var2);
         this.I_field_c1395c2c.setObjectiveSlot(var1.getSlot(), var3);
      }
   }

   public void I_method_f076c058(ScoreboardScoreUpdateS2CPacket var1) {
      if (var1 != null) {
         ScoreboardObjective var2 = this.I_field_c1395c2c.getNullableObjective(var1.objectiveName());
         if (var2 != null) {
            ScoreAccess var3 = this.I_field_c1395c2c.getOrCreateScore(ScoreHolder.fromName(var1.scoreHolderName()), var2);
            var3.setScore(var1.score());
            var1.display().ifPresent(var3::setDisplayText);
            var1.numberFormat().ifPresent(var3::setNumberFormat);
         }
      }
   }

   public void I_method_cb1a92d8(ScoreboardScoreResetS2CPacket var1) {
      if (var1 != null) {
         ScoreHolder var2 = ScoreHolder.fromName(var1.scoreHolderName());
         if (var1.objectiveName() == null) {
            this.I_field_c1395c2c.removeScores(var2);
         } else {
            ScoreboardObjective var3 = this.I_field_c1395c2c.getNullableObjective(var1.objectiveName());
            if (var3 != null) {
               this.I_field_c1395c2c.removeScore(var2, var3);
            }
         }
      }
   }

   public void I_method_cd5650a4(TeamS2CPacket var1) {
      if (var1 != null) {
         Team var2 = this.I_field_c1395c2c.getTeam(var1.getTeamName());
         Operation var3 = var1.getTeamOperation();
         if (var3 == Operation.ADD) {
            var2 = var2 == null ? this.I_field_c1395c2c.addTeam(var1.getTeamName()) : var2;
            Team targetTeam = var2;
            var1.getTeam().ifPresent(var2x -> this.I_method_5a7acb51(targetTeam, var2x));
         } else {
            if (var3 == Operation.REMOVE) {
               if (var2 != null) {
                  this.I_field_c1395c2c.removeTeam(var2);
               }

               return;
            }

            if (var2 != null) {
               Team targetTeam = var2;
               var1.getTeam().ifPresent(var2x -> this.I_method_5a7acb51(targetTeam, var2x));
            }
         }

         Operation var4 = var1.getPlayerListOperation();
         if (var4 != null) {
            if (var2 == null && var4 == Operation.ADD) {
               var2 = this.I_field_c1395c2c.addTeam(var1.getTeamName());
            }

            if (var2 != null) {
               for (String var6 : var1.getPlayerNames()) {
                  if (var4 == Operation.ADD) {
                     this.I_field_c1395c2c.addScoreHolderToTeam(var6, var2);
                  } else if (var4 == Operation.REMOVE) {
                     this.I_field_c1395c2c.removeScoreHolderFromTeam(var6, var2);
                  }
               }
            }
         }
      }
   }

   public void I_method_9f766ed(IIIIIiIi_Class6 var1) {
      this.Ii_field_4a++;
      if (this.I_field_5a) {
         this.II_field_4a++;
      }

      this.i_field_4a++;
      this.i_method_1f8cdacd(var1);
   }

   public void i_method_1f8cdacd(IIIIIiIi_Class6 var1) {
      if (var1 != null && this.i_field_49 >= 0) {
         IIIiIIii_Class20.Nested1_834f18f3 var2 = this.I_field_a567c40b.get(this.i_field_49);
         UUID var3 = var2 == null ? null : var2.I_method_a9dd63();
         String var4 = var2 == null ? "minecraft:player" : var2.I_method_d8f62cd9();
         IIIiIIii_Class20.Nested1_834f18f3 var5 = new IIIiIIii_Class20.Nested1_834f18f3(
            this.i_field_49,
            var3,
            var4,
            var1.I_method_d573f06(),
            var1.I_method_6865f47c(),
            var1.i_method_6874805c(),
            var1.I_method_6865f47c(),
            0.0,
            0.0,
            0.0,
            this.Ii_field_4a
         );
         this.I_field_a567c40b.put(this.i_field_49, var5);
      }
   }

   public boolean I_method_dc5dca10(int var1, int var2) {
      return this.II_field_a567c40b.containsKey(ChunkPos.toLong(var1, var2));
   }

   public boolean I_method_747b892a(BlockPos var1) {
      return var1 != null && this.I_method_dc5dca10(var1.getX() >> 4, var1.getZ() >> 4);
   }

   public boolean i_method_9ecf1d0a(BlockPos var1) {
      return var1 != null && this.Ii_field_a567c40b.containsKey(var1);
   }

   public int I_method_9235e49f() {
      return this.Ii_field_a567c40b.size();
   }

   public BlockState I_method_27bc425(BlockPos var1) {
      if (var1 == null) {
         return Blocks.AIR.getDefaultState();
      } else {
         BlockState var2 = this.Ii_field_a567c40b.get(var1);
         if (var2 != null) {
            return var2;
         } else {
            MinecraftClient var3 = MinecraftClient.getInstance();
            return !this.I_method_b44051d7(var3) ? Blocks.AIR.getDefaultState() : var3.world.getBlockState(var1);
         }
      }
   }

   public boolean II_method_63292a73(BlockPos var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      ClientWorld var3 = var2.world;
      if (var1 == null) {
         return false;
      } else {
         BlockState var4 = this.I_method_27bc425(var1);
         return !var4.isAir() && !var4.getCollisionShape((BlockView)(var3 == null ? EmptyBlockView.INSTANCE : var3), var1).isEmpty();
      }
   }

   public int I_method_abc2e8e6(String... var1) {
      for (String var3 : this.I_method_ec443b9b()) {
         String var4 = var3.toUpperCase(Locale.ROOT);

         for (String var8 : var1) {
            if (var8 != null && !var8.isBlank() && var4.contains(var8.toUpperCase(Locale.ROOT))) {
               Matcher var9 = I_field_5fd3861f.matcher(var3);
               if (var9.find()) {
                  try {
                     return Integer.parseInt(var9.group());
                  } catch (NumberFormatException var11) {
                     return -1;
                  }
               }
            }
         }
      }

      return -1;
   }

   public Collection<String> I_method_ec443b9b() {
      KeySetView var1 = ConcurrentHashMap.newKeySet();

      for (ScoreboardDisplaySlot var5 : ScoreboardDisplaySlot.values()) {
         ScoreboardObjective var6 = this.I_field_c1395c2c.getObjectiveForSlot(var5);
         if (var6 != null) {
            var1.add(var6.getDisplayName().getString());

            for (ScoreboardEntry var8 : this.I_field_c1395c2c.getScoreboardEntries(var6)) {
               String var9 = var8.owner();
               String var10 = var8.display() == null ? var9 : var8.display().getString();
               Team var11 = this.I_field_c1395c2c.getScoreHolderTeam(var9);
               if (var11 != null) {
                  var10 = var11.getPrefix().getString() + var10 + var11.getSuffix().getString();
               }

               var1.add(var10);
            }
         }
      }

      return var1;
   }

   public Collection<IIIiIIii_Class20.Nested1_834f18f3> i_method_724ddbbb() {
      return Collections.unmodifiableCollection(this.I_field_a567c40b.values());
   }

   public Optional<IIIiIIii_Class20.Nested1_834f18f3> I_method_43af118e(int var1) {
      return Optional.ofNullable(this.I_field_a567c40b.get(var1));
   }

   public Collection<IIIiIIii_Class20.Nested1_834f1913> II_method_25fd37b2() {
      return Collections.unmodifiableCollection(this.i_field_a567c40b.values());
   }

   private void I_method_d91e1c5e(CommonPlayerSpawnInfo var1, boolean var2) {
      if (var1 != null) {
         this.I_field_b0c3452b = var1.dimension();
         this.III_field_49 = ((DimensionType)var1.dimensionType().value()).minY();
         this.IIi_field_49 = ((DimensionType)var1.dimensionType().value()).height();
         this.I_field_4a = var1.seed();
         this.I_field_f90338a9 = var1.gameMode();
         this.i_field_f90338a9 = var1.prevGameMode();
         this.i_field_5a = var1.isDebug();
         this.II_field_5a = var1.isFlat();
         this.IiI_field_49 = var1.seaLevel();
         if (var2) {
            this.Ii_field_4a = 0L;
         }
      }
   }

   private void I_method_5b4462db(BlockPos var1, BlockState var2) {
      if (var1 != null && var2 != null) {
         this.Ii_field_a567c40b.put(var1.toImmutable(), var2);
      }
   }

   private void i_method_4d4255a8(ChunkDataS2CPacket var1) {
      MinecraftClient var2 = MinecraftClient.getInstance();
      if (var1 != null && var2.world != null) {
         Registry var3 = var2.world.getRegistryManager().getOrThrow(RegistryKeys.BIOME);
         PacketByteBuf var4 = new PacketByteBuf(var1.getChunkData().getSectionsDataBuf().copy());
         int var5 = var1.getChunkX();
         int var6 = var1.getChunkZ();
         this.Ii_field_a567c40b.keySet().removeIf(var2x -> var2x.getX() >> 4 == var5 && var2x.getZ() >> 4 == var6);
         int var7 = Math.max(0, this.IIi_field_49 >> 4);

         try {
            for (int var8 = 0; var8 < var7 && var4.isReadable(); var8++) {
               ChunkSection var9 = new ChunkSection(var3);
               var9.readDataPacket(var4);
               if (!var9.isEmpty()) {
                  int var10 = var5 << 4;
                  int var11 = this.III_field_49 + (var8 << 4);
                  int var12 = var6 << 4;

                  for (int var13 = 0; var13 < 16; var13++) {
                     for (int var14 = 0; var14 < 16; var14++) {
                        for (int var15 = 0; var15 < 16; var15++) {
                           BlockState var16 = var9.getBlockState(var15, var13, var14);
                           if (!var16.isAir()) {
                              this.Ii_field_a567c40b.put(new BlockPos(var10 + var15, var11 + var13, var12 + var14), var16);
                           }
                        }
                     }
                  }
               }
            }
         } catch (Exception var20) {
            this.Ii_field_a567c40b.keySet().removeIf(var2x -> var2x.getX() >> 4 == var5 && var2x.getZ() >> 4 == var6);
         } finally {
            var4.release();
         }
      }
   }

   private boolean I_method_b44051d7(MinecraftClient var1) {
      if (var1 == null || var1.world == null || this.I_field_b0c3452b == null || !this.I_field_b0c3452b.equals(var1.world.getRegistryKey())) {
         return false;
      } else if (var1.getCurrentServerEntry() == null) {
         return false;
      } else {
         IIIiIIii_Class20.Nested1_e69405b6 var2 = this.I_method_c24e52b1(var1.getCurrentServerEntry().address);
         return var2 != null && var2.I_method_ee49d55c().equalsIgnoreCase(this.i_field_523beb0a) && var2.I_method_d7631fb7() == this.I_field_49;
      }
   }

   private IIIiIIii_Class20.Nested1_e69405b6 I_method_c24e52b1(String var1) {
      if (var1 != null && !var1.isBlank()) {
         String var2 = var1.trim();
         int var3 = 25565;
         int var4 = var2.lastIndexOf(58);
         if (var4 > 0 && var4 < var2.length() - 1) {
            try {
               var3 = Integer.parseInt(var2.substring(var4 + 1));
               var2 = var2.substring(0, var4);
            } catch (NumberFormatException var6) {
            }
         }

         return new IIIiIIii_Class20.Nested1_e69405b6(var2, var3);
      } else {
         return null;
      }
   }

   private void I_method_5a7acb51(Team var1, SerializableTeam var2) {
      if (var1 != null && var2 != null) {
         var1.setDisplayName(var2.getDisplayName());
         var1.setFriendlyFlagsBitwise(var2.getFriendlyFlagsBitwise());
         Formatting var3 = var2.getColor();
         if (var3 != null) {
            var1.setColor(var3);
         }

         var1.setPrefix(var2.getPrefix());
         var1.setSuffix(var2.getSuffix());
         VisibilityRule var4 = VisibilityRule.getRule(var2.getNameTagVisibilityRule());
         if (var4 != null) {
            var1.setNameTagVisibilityRule(var4);
         }

         CollisionRule var5 = CollisionRule.getRule(var2.getCollisionRule());
         if (var5 != null) {
            var1.setCollisionRule(var5);
         }
      }
   }

   private void II_method_b495a835() {
      for (ScoreboardObjective var2 : Set.copyOf(this.I_field_c1395c2c.getObjectives())) {
         this.I_field_c1395c2c.removeObjective(var2);
      }

      for (Team var4 : Set.copyOf(this.I_field_c1395c2c.getTeams())) {
         this.I_field_c1395c2c.removeTeam(var4);
      }
   }

   private void I_method_3d765eee(int var1, PlayerPosition var2, boolean var3) {
      if (var2 != null) {
         IIIiIIii_Class20.Nested1_834f18f3 var4 = this.I_field_a567c40b.get(var1);
         if (var4 == null) {
            var4 = new IIIiIIii_Class20.Nested1_834f18f3(
               var1,
               null,
               var1 == this.i_field_49 ? "minecraft:player" : "minecraft:unknown",
               var2.position(),
               var2.yaw(),
               var2.pitch(),
               var2.yaw(),
               var2.deltaMovement().x,
               var2.deltaMovement().y,
               var2.deltaMovement().z,
               this.Ii_field_4a
            );
         } else {
            var4 = var4.I_method_1332c0b(var2.position(), var2.yaw(), var2.pitch(), var4.II_method_aaccc18a(), this.Ii_field_4a)
               .I_method_cc5dd2a5(var2.deltaMovement().x, var2.deltaMovement().y, var2.deltaMovement().z, this.Ii_field_4a);
         }

         this.I_field_a567c40b.put(var1, var4);
      }
   }

   private String I_method_e5bd8a60(EntityType<?> var1) {
      Identifier var2 = Registries.ENTITY_TYPE.getId(var1);
      return var2 == null ? "minecraft:unknown" : var2.toString();
   }

   @Generated
   public String I_method_c70c7d74() {
      return this.I_field_523beb0a;
   }

   @Generated
   public Map<Integer, IIIiIIii_Class20.Nested1_834f18f3> I_method_513459e1() {
      return this.I_field_a567c40b;
   }

   @Generated
   public Map<UUID, IIIiIIii_Class20.Nested1_834f1913> i_method_e3709dc1() {
      return this.i_field_a567c40b;
   }

   @Generated
   public Map<Long, Long> II_method_99aeb9aa() {
      return this.II_field_a567c40b;
   }

   @Generated
   public Map<BlockPos, BlockState> Ii_method_2beafd8a() {
      return this.Ii_field_a567c40b;
   }

   @Generated
   public Scoreboard I_method_2fae4d82() {
      return this.I_field_c1395c2c;
   }

   @Generated
   public String i_method_5a2b2d94() {
      return this.i_field_523beb0a;
   }

   @Generated
   public int i_method_9244707f() {
      return this.I_field_49;
   }

   @Generated
   public int II_method_b495a828() {
      return this.i_field_49;
   }

   @Generated
   public RegistryKey<World> I_method_e5dfd115() {
      return this.I_field_b0c3452b;
   }

   @Generated
   public Set<RegistryKey<World>> I_method_5137239b() {
      return this.I_field_a56a8dc5;
   }

   @Generated
   public GameMode I_method_31c97c13() {
      return this.I_field_f90338a9;
   }

   @Generated
   public GameMode i_method_ecc0fc33() {
      return this.i_field_f90338a9;
   }

   @Generated
   public long I_method_9235e4a0() {
      return this.I_field_4a;
   }

   @Generated
   public long i_method_92447080() {
      return this.i_field_4a;
   }

   @Generated
   public long II_method_b495a829() {
      return this.II_field_4a;
   }

   @Generated
   public boolean I_method_9235e4b0() {
      return this.I_field_5a;
   }

   @Generated
   public boolean i_method_92447090() {
      return this.i_field_5a;
   }

   @Generated
   public boolean II_method_b495a839() {
      return this.II_field_5a;
   }

   @Generated
   public int Ii_method_b4a43408() {
      return this.II_field_49;
   }

   @Generated
   public int iI_method_b6589848() {
      return this.Ii_field_49;
   }

   @Generated
   public int ii_method_b6672428() {
      return this.iI_field_49;
   }

   @Generated
   public int III_method_de2e55bf() {
      return this.ii_field_49;
   }

   @Generated
   public int IIi_method_de3ce19f() {
      return this.III_field_49;
   }

   @Generated
   public int IiI_method_dff145df() {
      return this.IIi_field_49;
   }

   @Generated
   public int Iii_method_dfffd1bf() {
      return this.IiI_field_49;
   }

   @Generated
   public long Ii_method_b4a43409() {
      return this.Ii_field_4a;
   }

   @Generated
   public boolean Ii_method_b4a43419() {
      return this.Ii_field_5a;
   }

   @Generated
   public double I_method_9235e49a() {
      return this.I_field_44;
   }

   public static final class Nested1_834f18f3 {
      private final int I_field_49;
      private final UUID I_field_7fb73d4;
      private final String I_field_523beb0a;
      private final Vec3d I_field_5bba0d50;
      private final float I_field_46;
      private final float i_field_46;
      private final float II_field_46;
      private final double I_field_44;
      private final double i_field_44;
      private final double II_field_44;
      private final long I_field_4a;

      public Nested1_834f18f3(
         int var1, UUID var2, String var3, Vec3d var4, float var5, float var6, float var7, double var8, double var10, double var12, long var14
      ) {
         this.I_field_49 = var1;
         this.I_field_7fb73d4 = var2;
         this.I_field_523beb0a = var3;
         this.I_field_5bba0d50 = var4;
         this.I_field_46 = var5;
         this.i_field_46 = var6;
         this.II_field_46 = var7;
         this.I_field_44 = var8;
         this.i_field_44 = var10;
         this.II_field_44 = var12;
         this.I_field_4a = var14;
      }

      IIIiIIii_Class20.Nested1_834f18f3 I_method_1332c0b(Vec3d var1, float var2, float var3, float var4, long var5) {
         return new IIIiIIii_Class20.Nested1_834f18f3(
            this.I_field_49,
            this.I_field_7fb73d4,
            this.I_field_523beb0a,
            var1,
            MathHelper.wrapDegrees(var2),
            MathHelper.clamp(var3, -90.0F, 90.0F),
            var4,
            this.I_field_44,
            this.i_field_44,
            this.II_field_44,
            var5
         );
      }

      IIIiIIii_Class20.Nested1_834f18f3 I_method_cc5dd2a5(double var1, double var3, double var5, long var7) {
         return new IIIiIIii_Class20.Nested1_834f18f3(
            this.I_field_49,
            this.I_field_7fb73d4,
            this.I_field_523beb0a,
            this.I_field_5bba0d50,
            this.I_field_46,
            this.i_field_46,
            this.II_field_46,
            var1,
            var3,
            var5,
            var7
         );
      }

      IIIiIIii_Class20.Nested1_834f18f3 I_method_f3091d27(float var1, long var2) {
         return new IIIiIIii_Class20.Nested1_834f18f3(
            this.I_field_49,
            this.I_field_7fb73d4,
            this.I_field_523beb0a,
            this.I_field_5bba0d50,
            this.I_field_46,
            this.i_field_46,
            MathHelper.wrapDegrees(var1),
            this.I_field_44,
            this.i_field_44,
            this.II_field_44,
            var2
         );
      }

      @Override
      public final String toString() {
         return "Nested1_834f18f3[id=" + this.I_field_49 + ", uuid=" + this.I_field_7fb73d4 + ", typeId=" + this.I_field_523beb0a + ", position=" + this.I_field_5bba0d50 + ", yaw=" + this.I_field_46 + ", pitch=" + this.i_field_46 + ", headYaw=" + this.II_field_46 + ", velocityX=" + this.I_field_44 + ", velocityY=" + this.i_field_44 + ", velocityZ=" + this.II_field_44 + ", lastSeenTick=" + this.I_field_4a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7fb73d4);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5bba0d50);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_46);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.i_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.II_field_44);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIiIIii_Class20.Nested1_834f18f3 other = (IIIiIIii_Class20.Nested1_834f18f3) var1;
         return java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_7fb73d4, other.I_field_7fb73d4)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_5bba0d50, other.I_field_5bba0d50)
            && java.util.Objects.equals(this.I_field_46, other.I_field_46)
            && java.util.Objects.equals(this.i_field_46, other.i_field_46)
            && java.util.Objects.equals(this.II_field_46, other.II_field_46)
            && java.util.Objects.equals(this.I_field_44, other.I_field_44)
            && java.util.Objects.equals(this.i_field_44, other.i_field_44)
            && java.util.Objects.equals(this.II_field_44, other.II_field_44)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a);
      }

      public int I_method_cbb38a9a() {
         return this.I_field_49;
      }

      public UUID I_method_a9dd63() {
         return this.I_field_7fb73d4;
      }

      public String I_method_d8f62cd9() {
         return this.I_field_523beb0a;
      }

      public Vec3d I_method_5c773e1() {
         return this.I_field_5bba0d50;
      }

      public float I_method_cbb38a97() {
         return this.I_field_46;
      }

      public float i_method_cbc21677() {
         return this.i_field_46;
      }

      public float II_method_aaccc18a() {
         return this.II_field_46;
      }

      public double I_method_cbb38a95() {
         return this.I_field_44;
      }

      public double i_method_cbc21675() {
         return this.i_field_44;
      }

      public double II_method_aaccc188() {
         return this.II_field_44;
      }

      public long I_method_cbb38a9b() {
         return this.I_field_4a;
      }
   }

   public static final class Nested1_834f1913 {
      private final UUID I_field_7fb73d4;
      private final String I_field_523beb0a;
      private final GameMode I_field_f90338a9;
      private final int I_field_49;
      private final boolean I_field_5a;
      private final Text I_field_33c1784c;
      private final long I_field_4a;

      public Nested1_834f1913(UUID var1, String var2, GameMode var3, int var4, boolean var5, Text var6, long var7) {
         this.I_field_7fb73d4 = var1;
         this.I_field_523beb0a = var2;
         this.I_field_f90338a9 = var3;
         this.I_field_49 = var4;
         this.I_field_5a = var5;
         this.I_field_33c1784c = var6;
         this.I_field_4a = var7;
      }

      @Override
      public final String toString() {
         return "Nested1_834f1913[uuid=" + this.I_field_7fb73d4 + ", name=" + this.I_field_523beb0a + ", gameMode=" + this.I_field_f90338a9 + ", latency=" + this.I_field_49 + ", listed=" + this.I_field_5a + ", displayName=" + this.I_field_33c1784c + ", lastSeenTick=" + this.I_field_4a + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_7fb73d4);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_f90338a9);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_5a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_33c1784c);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_4a);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIiIIii_Class20.Nested1_834f1913 other = (IIIiIIii_Class20.Nested1_834f1913) var1;
         return java.util.Objects.equals(this.I_field_7fb73d4, other.I_field_7fb73d4)
            && java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_f90338a9, other.I_field_f90338a9)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49)
            && java.util.Objects.equals(this.I_field_5a, other.I_field_5a)
            && java.util.Objects.equals(this.I_field_33c1784c, other.I_field_33c1784c)
            && java.util.Objects.equals(this.I_field_4a, other.I_field_4a);
      }

      public UUID I_method_93c88d83() {
         return this.I_field_7fb73d4;
      }

      public String I_method_1f2954f9() {
         return this.I_field_523beb0a;
      }

      public GameMode I_method_346e3418() {
         return this.I_field_f90338a9;
      }

      public int I_method_24e9e7a() {
         return this.I_field_49;
      }

      public boolean I_method_24e9e8b() {
         return this.I_field_5a;
      }

      public Text I_method_c8d4d37d() {
         return this.I_field_33c1784c;
      }

      public long I_method_24e9e7b() {
         return this.I_field_4a;
      }
   }

   static final class Nested1_e69405b6 {
      private final String I_field_523beb0a;
      private final int I_field_49;

      Nested1_e69405b6(String var1, int var2) {
         this.I_field_523beb0a = var1;
         this.I_field_49 = var2;
      }

      @Override
      public final String toString() {
         return "Nested1_e69405b6[address=" + this.I_field_523beb0a + ", port=" + this.I_field_49 + "]";
      }

      @Override
      public final int hashCode() {
         int result = 0;
         result = 31 * result + java.util.Objects.hashCode(this.I_field_523beb0a);
         result = 31 * result + java.util.Objects.hashCode(this.I_field_49);
         return result;
      }

      @Override
      public final boolean equals(Object var1) {
         if (this == var1) return true;
         if (var1 == null || getClass() != var1.getClass()) return false;
         IIIiIIii_Class20.Nested1_e69405b6 other = (IIIiIIii_Class20.Nested1_e69405b6) var1;
         return java.util.Objects.equals(this.I_field_523beb0a, other.I_field_523beb0a)
            && java.util.Objects.equals(this.I_field_49, other.I_field_49);
      }

      public String I_method_ee49d55c() {
         return this.I_field_523beb0a;
      }

      public int I_method_d7631fb7() {
         return this.I_field_49;
      }
   }
}
