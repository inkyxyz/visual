package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.Perspective;
import net.minecraft.entity.player.PlayerEntity;
import org.lwjgl.glfw.GLFW;
import pyrock.events.window.KeyPressEvent;
import moscow.rockstar.mixin.accessors.BipedEntityModelAccessor;

@ModuleInfo(
    name = "Animations",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = true,
    defaultKey = GLFW.GLFW_KEY_B,
    III_method_a89e5834 = "modules.descriptions.animations"
)
public class AnimationWheelModule extends Module {

    public enum CustomAnimation {
        NONE("Нет", "modules.animations.none", "Обычный"),
        FLOSS("Флосс", "modules.animations.floss", "Танец"),
        TAKE_THE_L("Take The L", "modules.animations.take_the_l", "Танец"),
        DEFAULT_DANCE("Дефолтный", "modules.animations.default_dance", "Танец"),
        ORANGE_JUSTICE("Orange Justice", "modules.animations.orange_justice", "Танец"),
        GRIDDY("Гридди", "modules.animations.griddy", "Танец"),
        HYPE("Хайп", "modules.animations.hype", "Танец"),
        BACKFLIP("Сальто", "modules.animations.backflip", "Акробатика"),
        WAVE("Приветствие", "modules.animations.wave", "Эмоция"),
        CLAP("Аплодисменты", "modules.animations.clap", "Эмоция"),
        T_POSE("Т-Поза", "modules.animations.t_pose", "Эмоция"),
        FLEX("Флекс", "modules.animations.flex", "Эмоция");

        private final String title;
        private final String desc;
        private final String category;

        CustomAnimation(String title, String desc, String category) {
            this.title = title;
            this.desc = desc;
            this.category = category;
        }

        public String getTitle() {
            return this.title;
        }

        public String getCategory() {
            return this.category;
        }
    }

    private final KeybindSetting wheelKey = new KeybindSetting(this, "Кнопка колеса")
        .I_method_4288e15a(GLFW.GLFW_KEY_B);

    private final SliderSetting animSpeed = new SliderSetting(this, "Скорость")
        .I_method_c8c9a7d7(0.5F).i_method_65e2aff7(2.5F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

    private static AnimationWheelModule INSTANCE;
    private static CustomAnimation activeAnimation = CustomAnimation.NONE;
    private static long animationStartTime = 0L;
    private static Perspective previousPerspective = null;

    private final IiIIIiII_Class69<KeyPressEvent> keyListener = event -> {
        if (!this.isEnabled()) return;
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.currentScreen != null) return;
        int target = this.getWheelKey();
        if (target > 0 && event.getAction() == GLFW.GLFW_PRESS && event.getKey() == target) {
            mc.setScreen(new AnimationWheelScreen());
        }
    };

    public AnimationWheelModule() {
        INSTANCE = this;
    }

    public static AnimationWheelModule getInstance() {
        return INSTANCE;
    }

    public int getWheelKey() {
        return this.wheelKey != null ? this.wheelKey.I_method_fa6281d2() : GLFW.GLFW_KEY_B;
    }

    public static CustomAnimation getActiveAnimation() {
        return activeAnimation;
    }

    public static void playAnimation(CustomAnimation anim) {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.player == null) return;

        // Auto switch to third-person perspective like Fortnite so the player can see themselves dancing
        if (activeAnimation == CustomAnimation.NONE && mc.options != null) {
            previousPerspective = mc.options.getPerspective();
            mc.options.setPerspective(Perspective.THIRD_PERSON_BACK);
        }

        activeAnimation = anim;
        animationStartTime = System.currentTimeMillis();
    }

    public static void stopAnimation() {
        MinecraftClient mc = MinecraftClient.getInstance();
        if (previousPerspective != null && mc.options != null) {
            mc.options.setPerspective(previousPerspective);
            previousPerspective = null;
        }
        activeAnimation = CustomAnimation.NONE;
    }

    public static void applyTransforms(PlayerEntity player, BipedEntityModelAccessor accessor, float tickDelta) {
        if (activeAnimation == null || activeAnimation == CustomAnimation.NONE) return;

        // Auto-stop if player starts moving (WASD/Jump)
        if (player.getVelocity().horizontalLengthSquared() > 0.002 || Math.abs(player.getVelocity().y) > 0.22) {
            stopAnimation();
            return;
        }

        float elapsedSec = (System.currentTimeMillis() - animationStartTime) * 0.001F;
        float speed = INSTANCE != null ? INSTANCE.animSpeed.Ii_method_a20abcd2() : 1.0F;
        float t = elapsedSec * speed;

        switch (activeAnimation) {
            case FLOSS -> {
                // Iconic Fortnite Floss: hips swing opposite to arms, arms alternate passing front and back
                float omega = t * 7.5F;
                float swing = (float) Math.sin(omega);
                float cosSwing = (float) Math.cos(omega);

                // Body & head hips rhythm
                accessor.rockstar$getBody().yaw = -swing * 0.38F;
                accessor.rockstar$getBody().roll = -swing * 0.14F;
                accessor.rockstar$getHead().yaw = swing * 0.18F;
                accessor.rockstar$getHead().pitch = Math.abs(cosSwing) * 0.08F;

                // Alternate arms swinging across chest and behind back
                if (swing > 0.0F) {
                    // Arms swing right: left arm crosses front, right arm behind back
                    accessor.rockstar$getLeftArm().pitch = -0.32F - cosSwing * 0.2F;
                    accessor.rockstar$getLeftArm().yaw = -0.65F * swing;
                    accessor.rockstar$getLeftArm().roll = -0.25F;

                    accessor.rockstar$getRightArm().pitch = 0.28F + cosSwing * 0.2F;
                    accessor.rockstar$getRightArm().yaw = -0.55F * swing;
                    accessor.rockstar$getRightArm().roll = 0.25F;
                } else {
                    // Arms swing left: right arm crosses front, left arm behind back
                    accessor.rockstar$getRightArm().pitch = -0.32F - cosSwing * 0.2F;
                    accessor.rockstar$getRightArm().yaw = -0.65F * swing;
                    accessor.rockstar$getRightArm().roll = 0.25F;

                    accessor.rockstar$getLeftArm().pitch = 0.28F + cosSwing * 0.2F;
                    accessor.rockstar$getLeftArm().yaw = -0.55F * swing;
                    accessor.rockstar$getLeftArm().roll = -0.25F;
                }

                // Legs subtle knee bend
                accessor.rockstar$getLeftLeg().pitch = swing * 0.15F;
                accessor.rockstar$getRightLeg().pitch = -swing * 0.15F;
            }
            case TAKE_THE_L -> {
                // Fortnite "Take The L": L sign on forehead, other hand on hip, rhythmic leg kicks
                float omega = t * 8.2F;
                float beat = (float) Math.sin(omega);

                // Right arm holds 'L' shape to forehead
                accessor.rockstar$getRightArm().pitch = -2.15F + (float) Math.sin(omega * 0.5F) * 0.06F;
                accessor.rockstar$getRightArm().yaw = -0.42F;
                accessor.rockstar$getRightArm().roll = 0.32F;

                // Left hand rests on hip
                accessor.rockstar$getLeftArm().pitch = 0.25F;
                accessor.rockstar$getLeftArm().yaw = 0.45F;
                accessor.rockstar$getLeftArm().roll = -0.65F;

                // Head tilted with smug attitude
                accessor.rockstar$getHead().roll = -0.18F;
                accessor.rockstar$getHead().pitch = -0.10F;

                // Hopping body & kicking legs
                accessor.rockstar$getBody().roll = beat * 0.14F;
                accessor.rockstar$getLeftLeg().pitch = beat * 0.55F;
                accessor.rockstar$getRightLeg().pitch = -beat * 0.55F;
            }
            case DEFAULT_DANCE -> {
                // Fortnite Default Dance ("Dance Moves"): 4-part beat choreography
                float phase = (t * 2.8F) % 4.0F;
                float beatT = (t * 6.0F);

                if (phase < 1.0F) {
                    // Arm swings side to side with knee bob
                    float s = (float) Math.sin(beatT);
                    accessor.rockstar$getRightArm().pitch = -1.1F + s * 0.45F;
                    accessor.rockstar$getLeftArm().pitch = -1.1F - s * 0.45F;
                    accessor.rockstar$getBody().yaw = s * 0.25F;
                } else if (phase < 2.0F) {
                    // Chest pop and energetic bounce
                    float bounce = (float) Math.sin(beatT * 1.5F);
                    accessor.rockstar$getBody().pitch = bounce * 0.22F;
                    accessor.rockstar$getRightArm().pitch = -1.6F;
                    accessor.rockstar$getLeftArm().pitch = -1.6F;
                    accessor.rockstar$getRightArm().yaw = -0.4F;
                    accessor.rockstar$getLeftArm().yaw = 0.4F;
                } else if (phase < 3.0F) {
                    // High clap over head
                    float clap = (float) Math.sin(beatT * 2.0F) * 0.35F;
                    accessor.rockstar$getRightArm().pitch = -2.5F;
                    accessor.rockstar$getLeftArm().pitch = -2.5F;
                    accessor.rockstar$getRightArm().roll = 0.4F + clap;
                    accessor.rockstar$getLeftArm().roll = -0.4F - clap;
                } else {
                    // Hip drop & sway
                    float hip = (float) Math.sin(beatT);
                    accessor.rockstar$getBody().roll = hip * 0.28F;
                    accessor.rockstar$getRightArm().pitch = -0.6F;
                    accessor.rockstar$getLeftArm().pitch = -0.6F;
                }
            }
            case ORANGE_JUSTICE -> {
                // Fortnite Orange Justice: arms cross and sweep out, torso drops and bobs
                float omega = t * 8.5F;
                float s = (float) Math.sin(omega);
                float c = (float) Math.cos(omega * 2.0F);

                accessor.rockstar$getBody().pitch = 0.20F + c * 0.16F;
                accessor.rockstar$getBody().yaw = s * 0.18F;

                // Arms cross and flare outward
                accessor.rockstar$getRightArm().pitch = -0.6F + c * 0.35F;
                accessor.rockstar$getRightArm().yaw = s * 0.65F;
                accessor.rockstar$getRightArm().roll = 0.35F;

                accessor.rockstar$getLeftArm().pitch = -0.6F + c * 0.35F;
                accessor.rockstar$getLeftArm().yaw = -s * 0.65F;
                accessor.rockstar$getLeftArm().roll = -0.35F;

                // Stomping legs
                accessor.rockstar$getLeftLeg().pitch = s * 0.42F;
                accessor.rockstar$getRightLeg().pitch = -s * 0.42F;
            }
            case GRIDDY -> {
                // Fortnite The Griddy: creep walk, tapping goggles to eyes, swagger bobs
                float omega = t * 5.5F;
                float s = (float) Math.sin(omega);

                // Right foot creep rhythm
                accessor.rockstar$getRightLeg().pitch = s * 0.38F;
                accessor.rockstar$getLeftLeg().pitch = -s * 0.38F;
                accessor.rockstar$getBody().yaw = s * 0.12F;
                accessor.rockstar$getHead().pitch = (float) Math.sin(omega * 2.0F) * 0.16F;

                // Hands making goggles on face
                accessor.rockstar$getRightArm().pitch = -1.95F;
                accessor.rockstar$getRightArm().yaw = -0.45F;
                accessor.rockstar$getRightArm().roll = 0.55F;

                accessor.rockstar$getLeftArm().pitch = -1.95F;
                accessor.rockstar$getLeftArm().yaw = 0.45F;
                accessor.rockstar$getLeftArm().roll = -0.55F;
            }
            case HYPE -> {
                // Fortnite Hype: fist pumping into the air, hopping on one leg
                float omega = t * 7.0F;
                float s = (float) Math.sin(omega);

                // Right fist pumps the sky
                accessor.rockstar$getRightArm().pitch = -2.25F + s * 0.48F;
                accessor.rockstar$getRightArm().roll = 0.22F;

                // Left arm pumps rhythmically
                accessor.rockstar$getLeftArm().pitch = 0.2F - s * 0.25F;
                accessor.rockstar$getLeftArm().roll = -0.35F;

                // Hop on one leg
                accessor.rockstar$getLeftLeg().pitch = -0.55F * Math.max(0.0F, s);
                accessor.rockstar$getBody().pitch = Math.abs(s) * 0.12F;
            }
            case BACKFLIP -> {
                float cycle = (t % 1.25F) / 1.25F;
                float flipAngle = (float) (cycle * Math.PI * 2.0);
                accessor.rockstar$getBody().pitch = -flipAngle;
                accessor.rockstar$getHead().pitch = -flipAngle * 0.5F;
                accessor.rockstar$getRightArm().pitch = -2.4F;
                accessor.rockstar$getLeftArm().pitch = -2.4F;
                accessor.rockstar$getLeftLeg().pitch = -0.65F;
                accessor.rockstar$getRightLeg().pitch = -0.65F;
            }
            case WAVE -> {
                accessor.rockstar$getRightArm().pitch = (float) Math.toRadians(-150.0);
                accessor.rockstar$getRightArm().yaw = (float) Math.toRadians(-10.0);
                accessor.rockstar$getRightArm().roll = (float) (Math.toRadians(25.0) + Math.sin(t * 8.0) * 0.42);
                accessor.rockstar$getHead().yaw = (float) (Math.sin(t * 4.0) * 0.15);
            }
            case CLAP -> {
                float clapAngle = (float) (Math.sin(t * 11.0) * 0.32);
                accessor.rockstar$getRightArm().pitch = (float) Math.toRadians(-80.0);
                accessor.rockstar$getRightArm().yaw = (float) (Math.toRadians(-35.0) - clapAngle);
                accessor.rockstar$getLeftArm().pitch = (float) Math.toRadians(-80.0);
                accessor.rockstar$getLeftArm().yaw = (float) (Math.toRadians(35.0) + clapAngle);
            }
            case T_POSE -> {
                // Dominant T-Pose
                accessor.rockstar$getRightArm().pitch = 0.0F;
                accessor.rockstar$getRightArm().yaw = 0.0F;
                accessor.rockstar$getRightArm().roll = (float) Math.toRadians(90.0);

                accessor.rockstar$getLeftArm().pitch = 0.0F;
                accessor.rockstar$getLeftArm().yaw = 0.0F;
                accessor.rockstar$getLeftArm().roll = (float) Math.toRadians(-90.0);

                accessor.rockstar$getBody().pitch = 0.0F;
                accessor.rockstar$getHead().pitch = 0.0F;
                accessor.rockstar$getLeftLeg().pitch = 0.0F;
                accessor.rockstar$getRightLeg().pitch = 0.0F;
            }
            case FLEX -> {
                // Bodybuilder double-bicep flex
                accessor.rockstar$getRightArm().pitch = (float) Math.toRadians(-115.0);
                accessor.rockstar$getRightArm().yaw = (float) Math.toRadians(-45.0);
                accessor.rockstar$getRightArm().roll = (float) Math.toRadians(65.0);

                accessor.rockstar$getLeftArm().pitch = (float) Math.toRadians(-115.0);
                accessor.rockstar$getLeftArm().yaw = (float) Math.toRadians(45.0);
                accessor.rockstar$getLeftArm().roll = (float) Math.toRadians(-65.0);

                accessor.rockstar$getHead().pitch = -0.15F;
            }
        }
    }
}
