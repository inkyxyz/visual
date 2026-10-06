package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.ShaderProgramKeys;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.render.BufferBuilder;
import net.minecraft.client.render.BufferRenderer;
import net.minecraft.client.render.BuiltBuffer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.VertexFormats;
import net.minecraft.client.render.VertexFormat.DrawMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.CreeperEntity;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.entity.mob.SpiderEntity;
import net.minecraft.entity.mob.ZombieEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Matrix4f;
import pyrock.events.game.AttackEvent;
import pyrock.events.game.EntityDeathEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.player.ClientPlayerTickEvent;
import pyrock.events.render.Render3DEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Dismemberment",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.dismemberment"
)
public class DismembermentModule extends Module {
    private static final Random RANDOM = new Random();

    public enum PartType {
        HEAD(0.24F, 0.24F, 0.24F, 8, 8, 8, 8, 8, 0, 16, 0, 0, 8, 16, 8, 24, 8),
        TORSO(0.26F, 0.36F, 0.16F, 20, 20, 8, 12, 20, 16, 28, 16, 16, 20, 28, 20, 32, 20),
        RIGHT_ARM(0.12F, 0.32F, 0.12F, 44, 20, 4, 12, 44, 16, 48, 16, 40, 20, 48, 20, 52, 20),
        LEFT_ARM(0.12F, 0.32F, 0.12F, 36, 52, 4, 12, 36, 48, 40, 48, 32, 52, 40, 52, 44, 52),
        RIGHT_LEG(0.13F, 0.34F, 0.13F, 4, 20, 4, 12, 4, 16, 8, 16, 0, 20, 8, 20, 12, 20),
        LEFT_LEG(0.13F, 0.34F, 0.13F, 20, 52, 4, 12, 20, 48, 24, 48, 16, 52, 24, 52, 28, 52),
        GORE_CHUNK(0.08F, 0.08F, 0.08F, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        final float sx, sy, sz;
        final int uFront, vFront, uW, vH;
        final int uTop, vTop, uBot, vBot;
        final int uRight, vRight, uLeft, vLeft, uBack, vBack;

        PartType(float sx, float sy, float sz, int uFront, int vFront, int uW, int vH,
                 int uTop, int vTop, int uBot, int vBot,
                 int uRight, int vRight, int uLeft, int vLeft, int uBack, int vBack) {
            this.sx = sx; this.sy = sy; this.sz = sz;
            this.uFront = uFront; this.vFront = vFront; this.uW = uW; this.vH = vH;
            this.uTop = uTop; this.vTop = vTop; this.uBot = uBot; this.vBot = vBot;
            this.uRight = uRight; this.vRight = vRight; this.uLeft = uLeft; this.vLeft = vLeft;
            this.uBack = uBack; this.vBack = vBack;
        }
    }

    public static class BodyPart {
        double x, y, z;
        double prevX, prevY, prevZ;
        double vx, vy, vz;
        float pitch, yaw, roll;
        float prevPitch, prevYaw, prevRoll;
        float vPitch, vYaw, vRoll;
        PartType type;
        Identifier texture;
        int color;
        long spawnTime;
        long lifeTime;
        boolean onFloor = false;

        public BodyPart(double x, double y, double z, double vx, double vy, double vz,
                        PartType type, Identifier texture, int color, long lifeTime) {
            this.x = x; this.y = y; this.z = z;
            this.prevX = x; this.prevY = y; this.prevZ = z;
            this.vx = vx; this.vy = vy; this.vz = vz;
            this.type = type;
            this.texture = texture;
            this.color = color;
            this.spawnTime = System.currentTimeMillis();
            this.lifeTime = lifeTime;
            this.pitch = RANDOM.nextFloat() * 360.0F;
            this.yaw = RANDOM.nextFloat() * 360.0F;
            this.roll = RANDOM.nextFloat() * 360.0F;
            this.prevPitch = this.pitch;
            this.prevYaw = this.yaw;
            this.prevRoll = this.roll;
            this.vPitch = (RANDOM.nextFloat() - 0.5F) * 32.0F;
            this.vYaw = (RANDOM.nextFloat() - 0.5F) * 32.0F;
            this.vRoll = (RANDOM.nextFloat() - 0.5F) * 32.0F;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - spawnTime > lifeTime;
        }
    }

    public static class BloodPuddle {
        double x, y, z;
        float maxRadius;
        long spawnTime;
        long lifeTime;

        public BloodPuddle(double x, double y, double z, float maxRadius, long lifeTime) {
            this.x = x; this.y = y; this.z = z;
            this.maxRadius = maxRadius;
            this.spawnTime = System.currentTimeMillis();
            this.lifeTime = lifeTime;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() - spawnTime > lifeTime;
        }
    }

    private final List<BodyPart> bodyParts = new CopyOnWriteArrayList<>();
    private final List<BloodPuddle> bloodPuddles = new CopyOnWriteArrayList<>();

    private BooleanSetting affectPlayers;
    private BooleanSetting affectMobs;
    private BooleanSetting bloodSetting;
    private BooleanSetting bloodDecals;
    private SliderSetting headScaleSetting;
    private BooleanSetting playerPhysics;
    private SliderSetting physicsImpulse;
    private SliderSetting partLifetime;
    private SliderSetting goreAmount;

    private final IiIIIiII_Class69<EntityDeathEvent> deathListener = this::onEntityDeath;
    private final IiIIIiII_Class69<AttackEvent> attackListener = this::onPlayerAttackKick;
    private final IiIIIiII_Class69<ClientPlayerTickEvent> tickListener = this::onTick;
    private final IiIIIiII_Class69<Render3DEvent> renderListener = this::onRender3D;
    private final IiIIIiII_Class69<WorldChangeEvent> worldChangeListener = var1 -> {
        this.bodyParts.clear();
        this.bloodPuddles.clear();
    };

    public DismembermentModule() {
        this.initSettings();
    }

    private void initSettings() {
        this.affectPlayers = new BooleanSetting(this, "Players").I_method_decd82b5();
        this.affectMobs = new BooleanSetting(this, "Mobs").I_method_decd82b5();
        this.bloodSetting = new BooleanSetting(this, "Blood / Кровь").I_method_decd82b5();
        this.bloodDecals = new BooleanSetting(this, "Blood Decals").I_method_decd82b5();
        this.headScaleSetting = new SliderSetting(this, "Размер головы")
            .I_method_c8c9a7d7(1.0F)
            .i_method_65e2aff7(2.5F)
            .II_method_b0f56334(0.1F)
            .Ii_method_4e0e6b54(1.8F);
        this.playerPhysics = new BooleanSetting(this, "Interactive Ragdoll").I_method_decd82b5();

        this.physicsImpulse = new SliderSetting(this, "Kick Force")
            .I_method_c8c9a7d7(0.5F)
            .i_method_65e2aff7(3.5F)
            .II_method_b0f56334(0.1F)
            .Ii_method_4e0e6b54(1.4F);
        this.partLifetime = new SliderSetting(this, "Lifetime (s)")
            .I_method_c8c9a7d7(5.0F)
            .i_method_65e2aff7(60.0F)
            .II_method_b0f56334(1.0F)
            .Ii_method_4e0e6b54(15.0F);
        this.goreAmount = new SliderSetting(this, "Gore Amount")
            .I_method_c8c9a7d7(1.0F)
            .i_method_65e2aff7(4.0F)
            .II_method_b0f56334(1.0F)
            .Ii_method_4e0e6b54(2.0F);
    }

    @Override
    public String i_method_bf522194() {
        return "Интерактивный рэгдолл мобов и игроков: реальные текстурированные части тела (голова, торс, руки, ноги), отлетающие и пинаемые игроком!";
    }

    private void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (!(entity instanceof LivingEntity living)) return;
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null) return;

        boolean isPlayer = entity instanceof PlayerEntity;
        if (!isPlayer && !this.affectMobs.i_method_9b12da03()) return;

        double ex = living.getX();
        double ey = living.getY();
        double ez = living.getZ();

        long lifeMs = (long) (this.partLifetime.Ii_method_a20abcd2() * 1000.0F);

        // Determine Entity Texture
        Identifier texture = null;
        if (living instanceof AbstractClientPlayerEntity player) {
            texture = player.getSkinTextures().texture();
        } else if (isPlayer && living instanceof PlayerEntity p) {
            if (mc.getNetworkHandler() != null) {
                var entry = mc.getNetworkHandler().getPlayerListEntry(p.getUuid());
                if (entry != null) {
                    texture = entry.getSkinTextures().texture();
                }
            }
            if (texture == null) {
                texture = Identifier.of("minecraft", "textures/entity/player/wide/steve.png");
            }
        } else if (living instanceof ZombieEntity) {
            texture = Identifier.of("minecraft", "textures/entity/zombie/zombie.png");
        } else if (living instanceof SkeletonEntity) {
            texture = Identifier.of("minecraft", "textures/entity/skeleton/skeleton.png");
        } else if (living instanceof CreeperEntity) {
            texture = Identifier.of("minecraft", "textures/entity/creeper/creeper.png");
        } else if (living instanceof SpiderEntity) {
            texture = Identifier.of("minecraft", "textures/entity/spider/spider.png");
        }

        int defaultColor = isPlayer ? 0xFFE0BA98 : 0xFF558855;
        int bloodCol = 0xFF8A0303;

        double vSpread = 0.22;

        // 1. Spawning textured model limbs
        // Guaranteed Player Head Drop
        if (isPlayer) {
            BodyPart head = new BodyPart(ex, ey + 1.4, ez,
                (RANDOM.nextDouble() - 0.5) * 0.35, 0.32 + RANDOM.nextDouble() * 0.20, (RANDOM.nextDouble() - 0.5) * 0.35,
                PartType.HEAD, texture, defaultColor, Math.max(lifeMs, 15000L));
            head.vPitch = (RANDOM.nextFloat() - 0.5F) * 60.0F;
            head.vYaw = (RANDOM.nextFloat() - 0.5F) * 60.0F;
            head.vRoll = (RANDOM.nextFloat() - 0.5F) * 60.0F;
            bodyParts.add(head);

            if (!this.affectPlayers.i_method_9b12da03()) {
                return;
            }
        } else {
            bodyParts.add(new BodyPart(ex, ey + 1.4, ez,
                (RANDOM.nextDouble() - 0.5) * vSpread, 0.24 + RANDOM.nextDouble() * 0.16, (RANDOM.nextDouble() - 0.5) * vSpread,
                PartType.HEAD, texture, defaultColor, lifeMs));
        }

        // Torso
        bodyParts.add(new BodyPart(ex, ey + 0.9, ez,
            (RANDOM.nextDouble() - 0.5) * (vSpread * 0.6), 0.16 + RANDOM.nextDouble() * 0.12, (RANDOM.nextDouble() - 0.5) * (vSpread * 0.6),
            PartType.TORSO, texture, defaultColor, lifeMs));

        // Right Arm & Left Arm
        bodyParts.add(new BodyPart(ex - 0.32, ey + 1.0, ez,
            -0.14 - RANDOM.nextDouble() * 0.12, 0.18 + RANDOM.nextDouble() * 0.15, (RANDOM.nextDouble() - 0.5) * vSpread,
            PartType.RIGHT_ARM, texture, defaultColor, lifeMs));
        bodyParts.add(new BodyPart(ex + 0.32, ey + 1.0, ez,
            0.14 + RANDOM.nextDouble() * 0.12, 0.18 + RANDOM.nextDouble() * 0.15, (RANDOM.nextDouble() - 0.5) * vSpread,
            PartType.LEFT_ARM, texture, defaultColor, lifeMs));

        // Right Leg & Left Leg
        bodyParts.add(new BodyPart(ex - 0.16, ey + 0.4, ez,
            (RANDOM.nextDouble() - 0.5) * vSpread, 0.12 + RANDOM.nextDouble() * 0.12, -0.12 - RANDOM.nextDouble() * 0.12,
            PartType.RIGHT_LEG, texture, defaultColor, lifeMs));
        bodyParts.add(new BodyPart(ex + 0.16, ey + 0.4, ez,
            (RANDOM.nextDouble() - 0.5) * vSpread, 0.12 + RANDOM.nextDouble() * 0.12, 0.12 + RANDOM.nextDouble() * 0.12,
            PartType.LEFT_LEG, texture, defaultColor, lifeMs));

        // Meat & Gore chunks (can be completely disabled via bloodSetting)
        if (this.bloodSetting.i_method_9b12da03()) {
            int chunks = (int)(5 * this.goreAmount.Ii_method_a20abcd2());
            for (int i = 0; i < chunks; i++) {
                bodyParts.add(new BodyPart(ex + (RANDOM.nextDouble() - 0.5) * 0.3, ey + 0.8, ez + (RANDOM.nextDouble() - 0.5) * 0.3,
                    (RANDOM.nextDouble() - 0.5) * 0.38, 0.22 + RANDOM.nextDouble() * 0.28, (RANDOM.nextDouble() - 0.5) * 0.38,
                    PartType.GORE_CHUNK, null, bloodCol, lifeMs));
            }

            // 2. Spawn Expanding Blood Decal Puddle on the Ground
            if (this.bloodDecals.i_method_9b12da03()) {
                double groundY = findGroundY(mc.world, ex, ey, ez);
                bloodPuddles.add(new BloodPuddle(ex, groundY + 0.012, ez, 0.90F + RANDOM.nextFloat() * 0.45F, lifeMs));
            }
        }
    }

    private void onPlayerAttackKick(AttackEvent event) {
        // Player punching in the air kicks nearby ragdoll parts
        MinecraftClient mc = MinecraftClient.getInstance();
        ClientPlayerEntity player = mc.player;
        if (player == null || !this.playerPhysics.i_method_9b12da03()) return;

        Vec3d eye = player.getEyePos();
        Vec3d look = player.getRotationVec(1.0F);
        float kickForce = this.physicsImpulse.Ii_method_a20abcd2() * 2.2F;

        for (BodyPart part : bodyParts) {
            Vec3d partPos = new Vec3d(part.x, part.y, part.z);
            double dist = eye.distanceTo(partPos);
            if (dist < 3.2) {
                Vec3d toPart = partPos.subtract(eye).normalize();
                double dot = look.dotProduct(toPart);
                if (dot > 0.65) { // In front of player
                    part.vx += look.x * kickForce;
                    part.vy += (look.y * kickForce * 0.5) + 0.25;
                    part.vz += look.z * kickForce;
                    part.vPitch += (float)((RANDOM.nextDouble() - 0.5) * 60.0);
                    part.vRoll += (float)((RANDOM.nextDouble() - 0.5) * 60.0);
                    part.vYaw += (float)((RANDOM.nextDouble() - 0.5) * 60.0);
                    part.onFloor = false;
                }
            }
        }
    }

    private double findGroundY(net.minecraft.world.World world, double x, double y, double z) {
        int bx = (int) Math.floor(x);
        int bz = (int) Math.floor(z);
        int by = (int) Math.floor(y);
        for (int curY = by; curY >= by - 5; curY--) {
            BlockPos bp = new BlockPos(bx, curY, bz);
            BlockState bs = world.getBlockState(bp);
            if (!bs.isAir() && bs.isSolid()) {
                return curY + 1.0;
            }
        }
        return y;
    }

    private void onTick(ClientPlayerTickEvent event) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null) return;
        ClientPlayerEntity player = mc.player;

        // Cleanup expired
        bodyParts.removeIf(BodyPart::isExpired);
        bloodPuddles.removeIf(BloodPuddle::isExpired);

        float impulseMultiplier = this.physicsImpulse.Ii_method_a20abcd2();
        boolean allowPlayerPhysics = this.playerPhysics.i_method_9b12da03() && player != null;

        Vec3d playerPos = player != null ? player.getPos() : Vec3d.ZERO;
        Vec3d playerVel = player != null ? player.getVelocity() : Vec3d.ZERO;
        double playerSpeed = playerVel.horizontalLength();

        for (BodyPart part : bodyParts) {
            part.prevX = part.x;
            part.prevY = part.y;
            part.prevZ = part.z;
            part.prevPitch = part.pitch;
            part.prevYaw = part.yaw;
            part.prevRoll = part.roll;

            // Gravity & velocity integration
            if (!part.onFloor) {
                part.vy -= 0.038;
            }
            part.x += part.vx;
            part.y += part.vy;
            part.z += part.vz;

            part.vx *= 0.95;
            part.vz *= 0.95;
            part.vy *= 0.98;

            part.pitch += part.vPitch;
            part.yaw += part.vYaw;
            part.roll += part.vRoll;

            // Ground floor collision check
            float halfH = part.type.sy * 0.5F;
            BlockPos bp = BlockPos.ofFloored(part.x, part.y - halfH, part.z);
            BlockState bs = mc.world.getBlockState(bp);
            double floorY = bp.getY() + 1.0;

            if (bs.isSolid() && part.y - halfH <= floorY) {
                part.y = floorY + halfH;
                if (Math.abs(part.vy) > 0.05) {
                    part.vy = -part.vy * 0.35; // Bounce
                    part.vPitch *= 0.65F;
                    part.vRoll *= 0.65F;
                } else {
                    part.vy = 0.0;
                    part.onFloor = true;
                    part.vx *= 0.72;
                    part.vz *= 0.72;
                    part.vPitch *= 0.72F;
                    part.vYaw *= 0.72F;
                    part.vRoll *= 0.72F;
                }
            } else {
                part.onFloor = false;
            }

            // INTERACTIVE PLAYER KICKING PHYSICS
            if (allowPlayerPhysics) {
                double dx = part.x - playerPos.x;
                double dy = part.y - playerPos.y;
                double dz = part.z - playerPos.z;
                double distH = Math.sqrt(dx * dx + dz * dz);

                // If player walks into or collides with body part
                if (distH < 0.70 && dy >= -0.3 && dy <= 1.8) {
                    double normX = (distH > 0.001) ? dx / distH : 0.707;
                    double normZ = (distH > 0.001) ? dz / distH : 0.707;

                    // Push impulse combines player direction + speed + user multiplier
                    double kickStrength = (0.15 + playerSpeed * 0.9) * impulseMultiplier;
                    part.vx += normX * kickStrength + playerVel.x * 0.8;
                    part.vz += normZ * kickStrength + playerVel.z * 0.8;
                    part.vy += 0.12 * impulseMultiplier; // Pop into the air!

                    // Dynamic tumbling / rolling angular velocities
                    part.vRoll += (float)((normZ * 50.0 + (RANDOM.nextDouble() - 0.5) * 25.0) * impulseMultiplier);
                    part.vPitch += (float)((-normX * 50.0 + (RANDOM.nextDouble() - 0.5) * 25.0) * impulseMultiplier);
                    part.vYaw += (float)((RANDOM.nextDouble() - 0.5) * 40.0);
                    part.onFloor = false;
                }
            }
        }
    }

    private void onRender3D(Render3DEvent event) {
        if (this.bodyParts.isEmpty() && this.bloodPuddles.isEmpty()) return;
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.world == null) return;

        Camera cam = event.getCamera();
        Vec3d camPos = cam.getPos();
        MatrixStack matrices = event.getMatrices();
        long now = System.currentTimeMillis();
        float tickDelta = mc.getRenderTickCounter().getTickDelta(false);

        // 1. RENDER EXPANDING BLOOD PUDDLES ON THE FLOOR
        if (!this.bloodPuddles.isEmpty() && this.bloodSetting.i_method_9b12da03()) {
            matrices.push();
            matrices.translate(-camPos.x, -camPos.y, -camPos.z);

            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(false);
            RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);

            BufferBuilder puddleBuf = RenderSystem.renderThreadTesselator().begin(DrawMode.TRIANGLES, VertexFormats.POSITION_COLOR);
            Matrix4f puddleMat = matrices.peek().getPositionMatrix();

            for (BloodPuddle puddle : bloodPuddles) {
                float progress = Math.min(1.0F, (now - puddle.spawnTime) / 1200.0F);
                float curR = puddle.maxRadius * (float)Math.sin(progress * Math.PI * 0.5);
                float fade = (float)(puddle.lifeTime - (now - puddle.spawnTime)) / (float)puddle.lifeTime;
                fade = MathHelper.clamp(fade, 0.0F, 1.0F);

                int bloodCenter = ((int)(220 * fade) << 24) | 0x00780202;
                int bloodEdge = ((int)(40 * fade) << 24) | 0x004A0000;

                int segs = 16;
                for (int i = 0; i < segs; i++) {
                    double a1 = (Math.PI * 2.0 * i) / segs;
                    double a2 = (Math.PI * 2.0 * (i + 1)) / segs;
                    float r1 = curR * (0.85F + 0.15F * (float)Math.sin(i * 3.7));
                    float r2 = curR * (0.85F + 0.15F * (float)Math.sin((i + 1) * 3.7));

                    float x1 = (float)(puddle.x + Math.cos(a1) * r1);
                    float z1 = (float)(puddle.z + Math.sin(a1) * r1);
                    float x2 = (float)(puddle.x + Math.cos(a2) * r2);
                    float z2 = (float)(puddle.z + Math.sin(a2) * r2);

                    puddleBuf.vertex(puddleMat, (float)puddle.x, (float)puddle.y, (float)puddle.z).color(bloodCenter);
                    puddleBuf.vertex(puddleMat, x1, (float)puddle.y, z1).color(bloodEdge);
                    puddleBuf.vertex(puddleMat, x2, (float)puddle.y, z2).color(bloodEdge);
                }
            }

            BuiltBuffer builtPuddles = puddleBuf.endNullable();
            if (builtPuddles != null) {
                BufferRenderer.drawWithGlobalProgram(builtPuddles);
            }
            RenderSystem.depthMask(true);
            matrices.pop();
        }

        // 2. RENDER 3D TEXTURED MODEL BODY PARTS & RAGDOLL PIECES WITH SMOOTH INTERPOLATION & FADE
        if (!this.bodyParts.isEmpty()) {
            RenderSystem.enableBlend();
            RenderSystem.defaultBlendFunc();
            RenderSystem.enableDepthTest();
            RenderSystem.depthMask(true);
            RenderSystem.disableCull();

            for (BodyPart part : bodyParts) {
                if (part.type == PartType.GORE_CHUNK && !this.bloodSetting.i_method_9b12da03()) {
                    continue;
                }
                double rx = MathHelper.lerp((double)tickDelta, part.prevX, part.x);
                double ry = MathHelper.lerp((double)tickDelta, part.prevY, part.y);
                double rz = MathHelper.lerp((double)tickDelta, part.prevZ, part.z);
                float rYaw = MathHelper.lerpAngleDegrees(tickDelta, part.prevYaw, part.yaw);
                float rPitch = MathHelper.lerpAngleDegrees(tickDelta, part.prevPitch, part.pitch);
                float rRoll = MathHelper.lerpAngleDegrees(tickDelta, part.prevRoll, part.roll);

                float timeLeft = (float)(part.lifeTime - (now - part.spawnTime));
                float alpha = MathHelper.clamp(timeLeft / 800.0F, 0.0F, 1.0F);
                int aInt = (int)(255 * alpha);

                matrices.push();
                matrices.translate(rx - camPos.x, ry - camPos.y, rz - camPos.z);
                matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(rYaw));
                matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(rPitch));
                matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(rRoll));

                Matrix4f partMat = matrices.peek().getPositionMatrix();
                float headMul = (part.type == PartType.HEAD && this.headScaleSetting != null)
                    ? this.headScaleSetting.Ii_method_a20abcd2()
                    : 1.0F;
                float hx = part.type.sx * 0.5F * headMul;
                float hy = part.type.sy * 0.5F * headMul;
                float hz = part.type.sz * 0.5F * headMul;

                if (part.texture != null) {
                    RenderSystem.setShader(ShaderProgramKeys.POSITION_TEX_COLOR);
                    RenderSystem.setShaderTexture(0, part.texture);
                    BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_TEXTURE_COLOR);
                    int tint = (aInt << 24) | 0x00FFFFFF;
                    drawTexturedCuboid(bb, partMat, hx, hy, hz, part.type, tint);
                    BuiltBuffer built = bb.endNullable();
                    if (built != null) BufferRenderer.drawWithGlobalProgram(built);
                } else {
                    RenderSystem.setShader(ShaderProgramKeys.POSITION_COLOR);
                    BufferBuilder bb = RenderSystem.renderThreadTesselator().begin(DrawMode.QUADS, VertexFormats.POSITION_COLOR);
                    int col = (aInt << 24) | (part.color & 0x00FFFFFF);
                    drawColoredCuboid(bb, partMat, hx, hy, hz, col);
                    BuiltBuffer built = bb.endNullable();
                    if (built != null) BufferRenderer.drawWithGlobalProgram(built);
                }

                matrices.pop();
            }
            RenderSystem.enableCull();
        }
    }

    private static void drawTexturedCuboid(BufferBuilder bb, Matrix4f mat, float hx, float hy, float hz, PartType t, int tintColor) {
        float tw = 64.0F, th = 64.0F;

        // Front Face (+Z)
        float u1 = t.uFront / tw, v1 = t.vFront / th;
        float u2 = (t.uFront + t.uW) / tw, v2 = (t.vFront + t.vH) / th;
        bb.vertex(mat, -hx, -hy, hz).texture(u1, v2).color(tintColor);
        bb.vertex(mat, hx, -hy, hz).texture(u2, v2).color(tintColor);
        bb.vertex(mat, hx, hy, hz).texture(u2, v1).color(tintColor);
        bb.vertex(mat, -hx, hy, hz).texture(u1, v1).color(tintColor);

        // Back Face (-Z)
        u1 = t.uBack / tw; v1 = t.vBack / th;
        u2 = (t.uBack + t.uW) / tw; v2 = (t.vBack + t.vH) / th;
        bb.vertex(mat, hx, -hy, -hz).texture(u1, v2).color(tintColor);
        bb.vertex(mat, -hx, -hy, -hz).texture(u2, v2).color(tintColor);
        bb.vertex(mat, -hx, hy, -hz).texture(u2, v1).color(tintColor);
        bb.vertex(mat, hx, hy, -hz).texture(u1, v1).color(tintColor);

        // Top Face (+Y)
        u1 = t.uTop / tw; v1 = t.vTop / th;
        u2 = (t.uTop + t.uW) / tw; v2 = (t.vTop + t.uW) / th;
        bb.vertex(mat, -hx, hy, -hz).texture(u1, v1).color(tintColor);
        bb.vertex(mat, -hx, hy, hz).texture(u1, v2).color(tintColor);
        bb.vertex(mat, hx, hy, hz).texture(u2, v2).color(tintColor);
        bb.vertex(mat, hx, hy, -hz).texture(u2, v1).color(tintColor);

        // Bottom Face (-Y)
        u1 = t.uBot / tw; v1 = t.vBot / th;
        u2 = (t.uBot + t.uW) / tw; v2 = (t.vBot + t.uW) / th;
        bb.vertex(mat, -hx, -hy, -hz).texture(u1, v1).color(tintColor);
        bb.vertex(mat, hx, -hy, -hz).texture(u2, v1).color(tintColor);
        bb.vertex(mat, hx, -hy, hz).texture(u2, v2).color(tintColor);
        bb.vertex(mat, -hx, -hy, hz).texture(u1, v2).color(tintColor);

        // Left Face (-X)
        u1 = t.uLeft / tw; v1 = t.vLeft / th;
        u2 = (t.uLeft + t.sz) / tw; v2 = (t.vLeft + t.vH) / th;
        bb.vertex(mat, -hx, -hy, -hz).texture(u1, v2).color(tintColor);
        bb.vertex(mat, -hx, -hy, hz).texture(u2, v2).color(tintColor);
        bb.vertex(mat, -hx, hy, hz).texture(u2, v1).color(tintColor);
        bb.vertex(mat, -hx, hy, -hz).texture(u1, v1).color(tintColor);

        // Right Face (+X)
        u1 = t.uRight / tw; v1 = t.vRight / th;
        u2 = (t.uRight + t.sz) / tw; v2 = (t.vRight + t.vH) / th;
        bb.vertex(mat, hx, -hy, hz).texture(u1, v2).color(tintColor);
        bb.vertex(mat, hx, -hy, -hz).texture(u2, v2).color(tintColor);
        bb.vertex(mat, hx, hy, -hz).texture(u2, v1).color(tintColor);
        bb.vertex(mat, hx, hy, hz).texture(u1, v1).color(tintColor);
    }

    private static void drawColoredCuboid(BufferBuilder bb, Matrix4f mat, float hx, float hy, float hz, int col) {
        int cTop = shade(col, 1.2F);
        int cSide = col;
        int cBot = shade(col, 0.7F);

        // Top
        bb.vertex(mat, -hx, hy, -hz).color(cTop);
        bb.vertex(mat, -hx, hy, hz).color(cTop);
        bb.vertex(mat, hx, hy, hz).color(cTop);
        bb.vertex(mat, hx, hy, -hz).color(cTop);
        // Bottom
        bb.vertex(mat, -hx, -hy, -hz).color(cBot);
        bb.vertex(mat, hx, -hy, -hz).color(cBot);
        bb.vertex(mat, hx, -hy, hz).color(cBot);
        bb.vertex(mat, -hx, -hy, hz).color(cBot);
        // North
        bb.vertex(mat, -hx, -hy, -hz).color(cSide);
        bb.vertex(mat, -hx, hy, -hz).color(cSide);
        bb.vertex(mat, hx, hy, -hz).color(cSide);
        bb.vertex(mat, hx, -hy, -hz).color(cSide);
        // South
        bb.vertex(mat, -hx, -hy, hz).color(cSide);
        bb.vertex(mat, hx, -hy, hz).color(cSide);
        bb.vertex(mat, hx, hy, hz).color(cSide);
        bb.vertex(mat, -hx, hy, hz).color(cSide);
        // West
        bb.vertex(mat, -hx, -hy, -hz).color(cSide);
        bb.vertex(mat, -hx, -hy, hz).color(cSide);
        bb.vertex(mat, -hx, hy, hz).color(cSide);
        bb.vertex(mat, -hx, hy, -hz).color(cSide);
        // East
        bb.vertex(mat, hx, -hy, -hz).color(cSide);
        bb.vertex(mat, hx, hy, -hz).color(cSide);
        bb.vertex(mat, hx, hy, hz).color(cSide);
        bb.vertex(mat, hx, -hy, hz).color(cSide);
    }

    private static int shade(int col, float factor) {
        int a = (col >> 24) & 0xFF;
        int r = Math.min(255, (int)(((col >> 16) & 0xFF) * factor));
        int g = Math.min(255, (int)(((col >> 8) & 0xFF) * factor));
        int b = Math.min(255, (int)((col & 0xFF) * factor));
        return (a << 24) | (r << 16) | (g << 8) | b;
    }
}
