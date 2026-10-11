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
        FLEX("Флекс", "modules.animations.flex", "Эмоция"),
        FACEPALM("Фейспалм", "modules.animations.facepalm", "Эмоция"),
        SALUTE("Салют", "modules.animations.salute", "Эмоция"),
        BOW("Поклон", "modules.animations.bow", "Эмоция"),
        LAUGH("Смех", "modules.animations.laugh", "Эмоция"),
        SHRUG("Пожатие плечами", "modules.animations.shrug", "Эмоция"),
        DAB("Дэб", "modules.animations.dab", "Танец"),
        SIT("Сидение", "modules.animations.sit", "Поза"),
        SPIN("Вращение", "modules.animations.spin", "Акробатика");

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

    private final SliderSetting armSwing = new SliderSetting(this, "Размах рук")
        .I_method_c8c9a7d7(0.2F).i_method_65e2aff7(2.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

    private final SliderSetting legSwing = new SliderSetting(this, "Размах ног")
        .I_method_c8c9a7d7(0.2F).i_method_65e2aff7(2.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

    private final SliderSetting bodyLean = new SliderSetting(this, "Наклон тела")
        .I_method_c8c9a7d7(0.0F).i_method_65e2aff7(2.0F).II_method_b0f56334(0.1F).Ii_method_4e0e6b54(1.0F);

    private final ModeSetting idleAnimSetting = new ModeSetting(this, "Покой");
    private final ModeSetting.Nested1_42765c60 idleRoblox;
    private final ModeSetting.Nested1_42765c60 idleDefault;
    private final ModeSetting.Nested1_42765c60 idleBreathing;
    private final ModeSetting.Nested1_42765c60 idleCombat;
    private final ModeSetting.Nested1_42765c60 idleLevitation;

    private final ModeSetting walkingAnim = new ModeSetting(this, "Ходьба");
    private final ModeSetting.Nested1_42765c60 walkRoblox;
    private final ModeSetting.Nested1_42765c60 walkDefault;
    private final ModeSetting.Nested1_42765c60 walkSkating;
    private final ModeSetting.Nested1_42765c60 walkSprint;
    private final ModeSetting.Nested1_42765c60 walkMarch;
    private final ModeSetting.Nested1_42765c60 walkSwagger;
    private final ModeSetting.Nested1_42765c60 walkZombie;
    private final ModeSetting.Nested1_42765c60 walkLevitation;

    private final ModeSetting jumpAnimSetting = new ModeSetting(this, "Прыжок");
    private final ModeSetting.Nested1_42765c60 jumpRoblox;
    private final ModeSetting.Nested1_42765c60 jumpDefault;
    private final ModeSetting.Nested1_42765c60 jumpSomersault;
    private final ModeSetting.Nested1_42765c60 jumpTuck;
    private final ModeSetting.Nested1_42765c60 jumpHero;

    private final ModeSetting fallAnimSetting = new ModeSetting(this, "Падение");
    private final ModeSetting.Nested1_42765c60 fallRoblox;
    private final ModeSetting.Nested1_42765c60 fallDefault;
    private final ModeSetting.Nested1_42765c60 fallDive;
    private final ModeSetting.Nested1_42765c60 fallPanic;

    private final ModeSetting climbAnimSetting = new ModeSetting(this, "Лестница");
    private final ModeSetting.Nested1_42765c60 climbRoblox;
    private final ModeSetting.Nested1_42765c60 climbDefault;
    private final ModeSetting.Nested1_42765c60 climbParkour;

    private final ModeSetting swimAnimSetting = new ModeSetting(this, "Плавание");
    private final ModeSetting.Nested1_42765c60 swimRoblox;
    private final ModeSetting.Nested1_42765c60 swimDefault;
    private final ModeSetting.Nested1_42765c60 swimFreestyle;
    private final ModeSetting.Nested1_42765c60 swimDolphin;

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
        // Idle
        this.idleRoblox = new ModeSetting.Nested1_42765c60(this.idleAnimSetting, "Роблокс").select();
        this.idleDefault = new ModeSetting.Nested1_42765c60(this.idleAnimSetting, "Обычный");
        this.idleBreathing = new ModeSetting.Nested1_42765c60(this.idleAnimSetting, "Дыхание");
        this.idleCombat = new ModeSetting.Nested1_42765c60(this.idleAnimSetting, "Боевая стойка");
        this.idleLevitation = new ModeSetting.Nested1_42765c60(this.idleAnimSetting, "Левитация");

        // Walk
        this.walkRoblox = new ModeSetting.Nested1_42765c60(this.walkingAnim, "Роблокс").select();
        this.walkDefault = new ModeSetting.Nested1_42765c60(this.walkingAnim, "Обычная");
        this.walkSkating = new ModeSetting.Nested1_42765c60(this.walkingAnim, "Коньки");
        this.walkSprint = new ModeSetting.Nested1_42765c60(this.walkingAnim, "Спринт");
        this.walkMarch = new ModeSetting.Nested1_42765c60(this.walkingAnim, "Марш");
        this.walkSwagger = new ModeSetting.Nested1_42765c60(this.walkingAnim, "Вразвалку");
        this.walkZombie = new ModeSetting.Nested1_42765c60(this.walkingAnim, "Зомби");
        this.walkLevitation = new ModeSetting.Nested1_42765c60(this.walkingAnim, "Левитация");

        // Jump
        this.jumpRoblox = new ModeSetting.Nested1_42765c60(this.jumpAnimSetting, "Роблокс").select();
        this.jumpDefault = new ModeSetting.Nested1_42765c60(this.jumpAnimSetting, "Обычный");
        this.jumpSomersault = new ModeSetting.Nested1_42765c60(this.jumpAnimSetting, "Сальто");
        this.jumpTuck = new ModeSetting.Nested1_42765c60(this.jumpAnimSetting, "Группировка");
        this.jumpHero = new ModeSetting.Nested1_42765c60(this.jumpAnimSetting, "Супергерой");

        // Fall
        this.fallRoblox = new ModeSetting.Nested1_42765c60(this.fallAnimSetting, "Роблокс").select();
        this.fallDefault = new ModeSetting.Nested1_42765c60(this.fallAnimSetting, "Обычное");
        this.fallDive = new ModeSetting.Nested1_42765c60(this.fallAnimSetting, "Пикирование");
        this.fallPanic = new ModeSetting.Nested1_42765c60(this.fallAnimSetting, "Паника");

        // Climb
        this.climbRoblox = new ModeSetting.Nested1_42765c60(this.climbAnimSetting, "Роблокс").select();
        this.climbDefault = new ModeSetting.Nested1_42765c60(this.climbAnimSetting, "Обычная");
        this.climbParkour = new ModeSetting.Nested1_42765c60(this.climbAnimSetting, "Паркур");

        // Swim
        this.swimRoblox = new ModeSetting.Nested1_42765c60(this.swimAnimSetting, "Роблокс").select();
        this.swimDefault = new ModeSetting.Nested1_42765c60(this.swimAnimSetting, "Обычное");
        this.swimFreestyle = new ModeSetting.Nested1_42765c60(this.swimAnimSetting, "Брасс");
        this.swimDolphin = new ModeSetting.Nested1_42765c60(this.swimAnimSetting, "Дельфин");
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

    private static void applyWalkingTransforms(PlayerEntity player, BipedEntityModelAccessor accessor, float tickDelta) {
        if (INSTANCE == null || !INSTANCE.isEnabled()) return;

        float spd = INSTANCE.animSpeed != null ? INSTANCE.animSpeed.Ii_method_a20abcd2() : 1.0F;
        float aScale = INSTANCE.armSwing != null ? INSTANCE.armSwing.Ii_method_a20abcd2() : 1.0F;
        float lScale = INSTANCE.legSwing != null ? INSTANCE.legSwing.Ii_method_a20abcd2() : 1.0F;
        float bScale = INSTANCE.bodyLean != null ? INSTANCE.bodyLean.Ii_method_a20abcd2() : 1.0F;

        // 1. Climbing Animation (Ladders / Vines)
        if (player.isClimbing()) {
            if (INSTANCE.climbRoblox.isSelected()) {
                float climbPhase = (player.age + tickDelta) * 0.45F * spd;
                float climbStep = (float) Math.sin(climbPhase);
                accessor.rockstar$getBody().pitch = 0.04F * bScale;
                accessor.rockstar$getBody().pivotY = Math.abs(climbStep) * 0.8F;
                accessor.rockstar$getLeftArm().pitch = -2.15F + climbStep * 0.75F * aScale;
                accessor.rockstar$getRightArm().pitch = -2.15F - climbStep * 0.75F * aScale;
                accessor.rockstar$getLeftArm().roll = -0.22F * aScale;
                accessor.rockstar$getRightArm().roll = 0.22F * aScale;
                accessor.rockstar$getLeftLeg().pitch = -climbStep * 0.55F * lScale;
                accessor.rockstar$getRightLeg().pitch = climbStep * 0.55F * lScale;
            } else if (INSTANCE.climbParkour.isSelected()) {
                float climbPhase = (player.age + tickDelta) * 0.55F * spd;
                float step = (float) Math.sin(climbPhase);
                accessor.rockstar$getBody().yaw = step * 0.15F * bScale;
                accessor.rockstar$getLeftArm().pitch = -2.4F + step * 0.9F * aScale;
                accessor.rockstar$getRightArm().pitch = -2.4F - step * 0.9F * aScale;
                accessor.rockstar$getLeftLeg().pitch = step * 0.7F * lScale;
                accessor.rockstar$getRightLeg().pitch = -step * 0.7F * lScale;
            }
            return;
        }

        // 2. Swimming Animation (Water)
        if (player.isTouchingWater() || player.isSwimming()) {
            if (INSTANCE.swimRoblox.isSelected()) {
                float swimPhase = (player.age + tickDelta) * 0.35F * spd;
                float stroke = (float) Math.sin(swimPhase);
                accessor.rockstar$getBody().pitch = (player.isSwimming() ? 1.25F : 0.65F) * bScale;
                accessor.rockstar$getHead().pitch = -0.55F;
                accessor.rockstar$getLeftArm().pitch = -0.85F + stroke * 0.95F * aScale;
                accessor.rockstar$getLeftArm().roll = -0.45F - Math.abs((float) Math.cos(swimPhase)) * 0.65F * aScale;
                accessor.rockstar$getRightArm().pitch = -0.85F - stroke * 0.95F * aScale;
                accessor.rockstar$getRightArm().roll = 0.45F + Math.abs((float) Math.cos(swimPhase)) * 0.65F * aScale;
                accessor.rockstar$getLeftLeg().pitch = (float) Math.sin(swimPhase * 2.2F) * 0.45F * lScale;
                accessor.rockstar$getRightLeg().pitch = -(float) Math.sin(swimPhase * 2.2F) * 0.45F * lScale;
            } else if (INSTANCE.swimFreestyle.isSelected()) {
                float swimPhase = (player.age + tickDelta) * 0.45F * spd;
                float stroke = (float) Math.sin(swimPhase);
                accessor.rockstar$getBody().pitch = 1.35F * bScale;
                accessor.rockstar$getBody().roll = stroke * 0.25F * bScale;
                accessor.rockstar$getLeftArm().pitch = -1.8F + stroke * 1.2F * aScale;
                accessor.rockstar$getRightArm().pitch = -1.8F - stroke * 1.2F * aScale;
                accessor.rockstar$getLeftLeg().pitch = (float) Math.sin(swimPhase * 3.0F) * 0.55F * lScale;
                accessor.rockstar$getRightLeg().pitch = -(float) Math.sin(swimPhase * 3.0F) * 0.55F * lScale;
            } else if (INSTANCE.swimDolphin.isSelected()) {
                float swimPhase = (player.age + tickDelta) * 0.3F * spd;
                float undul = (float) Math.sin(swimPhase);
                accessor.rockstar$getBody().pitch = (1.2F + undul * 0.3F) * bScale;
                accessor.rockstar$getLeftArm().pitch = -2.8F;
                accessor.rockstar$getRightArm().pitch = -2.8F;
                accessor.rockstar$getLeftLeg().pitch = undul * 0.6F * lScale;
                accessor.rockstar$getRightLeg().pitch = undul * 0.6F * lScale;
            }
            return;
        }

        // 3. In-Air Jumping / Falling Animation
        if (!player.isOnGround()) {
            double vy = player.getVelocity().y;
            if (vy > 0.05) {
                // Jump Modes
                if (INSTANCE.jumpRoblox.isSelected()) {
                    accessor.rockstar$getBody().pitch = -0.18F * bScale;
                    accessor.rockstar$getLeftArm().pitch = -2.25F * aScale;
                    accessor.rockstar$getRightArm().pitch = -2.25F * aScale;
                    accessor.rockstar$getLeftArm().roll = -0.55F * aScale;
                    accessor.rockstar$getRightArm().roll = 0.55F * aScale;
                    accessor.rockstar$getLeftLeg().pitch = 0.55F * lScale;
                    accessor.rockstar$getRightLeg().pitch = 0.32F * lScale;
                } else if (INSTANCE.jumpSomersault.isSelected()) {
                    float flip = (player.age + tickDelta) * 0.45F * spd;
                    accessor.rockstar$getBody().pitch = (flip % ((float)Math.PI * 2.0F)) * bScale;
                    accessor.rockstar$getLeftArm().pitch = 1.2F * aScale;
                    accessor.rockstar$getRightArm().pitch = 1.2F * aScale;
                    accessor.rockstar$getLeftLeg().pitch = 1.2F * lScale;
                    accessor.rockstar$getRightLeg().pitch = 1.2F * lScale;
                } else if (INSTANCE.jumpTuck.isSelected()) {
                    accessor.rockstar$getBody().pitch = 0.25F * bScale;
                    accessor.rockstar$getLeftArm().pitch = 0.85F * aScale;
                    accessor.rockstar$getRightArm().pitch = 0.85F * aScale;
                    accessor.rockstar$getLeftLeg().pitch = 1.15F * lScale;
                    accessor.rockstar$getRightLeg().pitch = 1.15F * lScale;
                } else if (INSTANCE.jumpHero.isSelected()) {
                    accessor.rockstar$getBody().pitch = -0.2F * bScale;
                    accessor.rockstar$getLeftArm().pitch = 0.6F * aScale;
                    accessor.rockstar$getRightArm().pitch = -2.9F * aScale;
                    accessor.rockstar$getLeftLeg().pitch = 0.3F * lScale;
                    accessor.rockstar$getRightLeg().pitch = -0.4F * lScale;
                }
            } else {
                // Fall Modes
                if (INSTANCE.fallRoblox.isSelected()) {
                    accessor.rockstar$getBody().pitch = 0.22F * bScale;
                    float flail = (float) Math.sin((player.age + tickDelta) * 0.45F * spd) * 0.16F;
                    accessor.rockstar$getLeftArm().pitch = (-2.55F + flail) * aScale;
                    accessor.rockstar$getRightArm().pitch = (-2.55F - flail) * aScale;
                    accessor.rockstar$getLeftArm().roll = -0.42F * aScale;
                    accessor.rockstar$getRightArm().roll = 0.42F * aScale;
                    accessor.rockstar$getLeftLeg().pitch = (-0.32F + flail * 0.8F) * lScale;
                    accessor.rockstar$getRightLeg().pitch = (0.15F - flail * 0.8F) * lScale;
                } else if (INSTANCE.fallDive.isSelected()) {
                    accessor.rockstar$getBody().pitch = 1.1F * bScale;
                    accessor.rockstar$getLeftArm().pitch = 0.8F * aScale;
                    accessor.rockstar$getRightArm().pitch = 0.8F * aScale;
                    accessor.rockstar$getLeftArm().roll = -0.6F * aScale;
                    accessor.rockstar$getRightArm().roll = 0.6F * aScale;
                    accessor.rockstar$getLeftLeg().pitch = -0.3F * lScale;
                    accessor.rockstar$getRightLeg().pitch = -0.3F * lScale;
                } else if (INSTANCE.fallPanic.isSelected()) {
                    float thrash = (float) Math.sin((player.age + tickDelta) * 0.85F * spd) * 0.65F;
                    accessor.rockstar$getBody().pitch = 0.35F * bScale;
                    accessor.rockstar$getBody().yaw = thrash * 0.25F * bScale;
                    accessor.rockstar$getLeftArm().pitch = (-1.8F + thrash) * aScale;
                    accessor.rockstar$getRightArm().pitch = (-1.8F - thrash) * aScale;
                    accessor.rockstar$getLeftLeg().pitch = thrash * lScale;
                    accessor.rockstar$getRightLeg().pitch = -thrash * lScale;
                }
            }
            return;
        }

        boolean isMoving = player.getVelocity().horizontalLengthSquared() > 0.001;

        // 4. Idle Animations
        if (!isMoving) {
            float idlePhase = (player.age + tickDelta) * 0.08F * spd;
            if (INSTANCE.idleRoblox.isSelected()) {
                accessor.rockstar$getBody().pivotY = (float) Math.sin(idlePhase * 2.0F) * 0.45F;
                accessor.rockstar$getBody().pitch = (float) Math.sin(idlePhase * 2.0F) * 0.02F * bScale;
                accessor.rockstar$getLeftArm().pitch = (0.05F + (float) Math.sin(idlePhase) * 0.03F) * aScale;
                accessor.rockstar$getRightArm().pitch = (0.05F - (float) Math.sin(idlePhase) * 0.03F) * aScale;
                accessor.rockstar$getLeftArm().roll = (-0.16F - (float) Math.cos(idlePhase) * 0.02F) * aScale;
                accessor.rockstar$getRightArm().roll = (0.16F + (float) Math.cos(idlePhase) * 0.02F) * aScale;
                accessor.rockstar$getHead().yaw = (float) Math.sin(idlePhase * 0.8F) * 0.04F;
                accessor.rockstar$getHead().pitch = (float) Math.cos(idlePhase * 0.6F) * 0.03F;
            } else if (INSTANCE.idleBreathing.isSelected()) {
                float breath = (float) Math.sin(idlePhase * 1.5F);
                accessor.rockstar$getBody().pivotY = breath * 0.3F;
                accessor.rockstar$getBody().pitch = breath * 0.04F * bScale;
                accessor.rockstar$getLeftArm().roll = (-0.1F - breath * 0.03F) * aScale;
                accessor.rockstar$getRightArm().roll = (0.1F + breath * 0.03F) * aScale;
            } else if (INSTANCE.idleCombat.isSelected()) {
                float bounce = (float) Math.sin(idlePhase * 3.0F);
                accessor.rockstar$getBody().yaw = -0.3F * bScale;
                accessor.rockstar$getBody().pivotY = Math.abs(bounce) * 0.6F;
                accessor.rockstar$getLeftArm().pitch = -1.2F * aScale;
                accessor.rockstar$getRightArm().pitch = -1.1F * aScale;
                accessor.rockstar$getLeftArm().roll = 0.4F * aScale;
                accessor.rockstar$getRightArm().roll = -0.4F * aScale;
            } else if (INSTANCE.idleLevitation.isSelected()) {
                float floatWave = (float) Math.sin(idlePhase * 2.0F);
                accessor.rockstar$getBody().pivotY = -4.0F + floatWave * 1.2F;
                accessor.rockstar$getLeftArm().pitch = -0.2F * aScale;
                accessor.rockstar$getRightArm().pitch = -0.2F * aScale;
                accessor.rockstar$getLeftArm().roll = -0.35F * aScale;
                accessor.rockstar$getRightArm().roll = 0.35F * aScale;
                accessor.rockstar$getLeftLeg().pitch = 0.25F * lScale;
                accessor.rockstar$getRightLeg().pitch = -0.15F * lScale;
            }
            return;
        }

        // 5. Ground Walking Animations
        float timeSec = (player.age + tickDelta) * 0.22F * spd;
        if (INSTANCE.walkRoblox.isSelected()) {
            // Authentic Roblox R15/R6 Procedural Walk: cubic bounce, rigid swinging arms with outward flare
            float walkPhase = (player.age + tickDelta) * 0.65F;
            float swing = (float) Math.sin(walkPhase);

            accessor.rockstar$getBody().yaw = swing * 0.18F;
            accessor.rockstar$getBody().roll = swing * 0.10F;
            accessor.rockstar$getBody().pivotY = Math.abs((float) Math.cos(walkPhase)) * 2.2F;
            accessor.rockstar$getHead().yaw = -swing * 0.08F;
            accessor.rockstar$getHead().pitch = 0.04F + Math.abs(swing) * 0.04F;

            accessor.rockstar$getLeftArm().pitch = -swing * 1.15F;
            accessor.rockstar$getRightArm().pitch = swing * 1.15F;
            accessor.rockstar$getLeftArm().roll = -0.28F;
            accessor.rockstar$getRightArm().roll = 0.28F;

            accessor.rockstar$getLeftLeg().pitch = swing * 0.95F;
            accessor.rockstar$getRightLeg().pitch = -swing * 0.95F;
        } else if (INSTANCE.walkDefault.isSelected()) {
            // Enhanced Natural Human Walk: smooth torso sway, counter-rotating shoulders
            float walkPhase = (player.age + tickDelta) * 0.55F;
            float swing = (float) Math.sin(walkPhase);

            accessor.rockstar$getBody().yaw = swing * 0.08F;
            accessor.rockstar$getBody().roll = swing * 0.04F;
            accessor.rockstar$getBody().pivotY = Math.abs((float) Math.cos(walkPhase)) * 0.8F;

            accessor.rockstar$getLeftArm().pitch = -swing * 0.65F;
            accessor.rockstar$getRightArm().pitch = swing * 0.65F;
            accessor.rockstar$getLeftArm().roll = -0.12F;
            accessor.rockstar$getRightArm().roll = 0.12F;

            accessor.rockstar$getLeftLeg().pitch = swing * 0.65F;
            accessor.rockstar$getRightLeg().pitch = -swing * 0.65F;
        } else if (INSTANCE.walkSkating.isSelected()) {
            // Коньки (Skating) - wide graceful leg kicks, body roll tilt
            float sway = (float) Math.sin(timeSec * 2.2F);
            accessor.rockstar$getBody().roll = sway * 0.22F;
            accessor.rockstar$getBody().pitch = 0.28F;
            accessor.rockstar$getLeftLeg().roll = Math.max(0.0F, -sway) * 0.42F;
            accessor.rockstar$getRightLeg().roll = Math.max(0.0F, sway) * 0.42F;
            accessor.rockstar$getLeftLeg().yaw = -sway * 0.32F;
            accessor.rockstar$getRightLeg().yaw = -sway * 0.32F;
            accessor.rockstar$getLeftArm().pitch = 0.45F + sway * 0.45F;
            accessor.rockstar$getRightArm().pitch = 0.45F - sway * 0.45F;
            accessor.rockstar$getLeftArm().roll = -0.20F;
            accessor.rockstar$getRightArm().roll = 0.20F;
        } else if (INSTANCE.walkSprint.isSelected()) {
            // Спринт (Ninja Sprint) - deep forward lean, arms trailing back
            accessor.rockstar$getBody().pitch = 0.65F;
            accessor.rockstar$getHead().pitch = -0.55F;
            accessor.rockstar$getLeftArm().pitch = 1.45F;
            accessor.rockstar$getRightArm().pitch = 1.45F;
            accessor.rockstar$getLeftArm().roll = -0.22F;
            accessor.rockstar$getRightArm().roll = 0.22F;
            float legSwing = (float) Math.sin((player.age + tickDelta) * 0.85F) * 0.85F;
            accessor.rockstar$getLeftLeg().pitch = legSwing;
            accessor.rockstar$getRightLeg().pitch = -legSwing;
        } else if (INSTANCE.walkMarch.isSelected()) {
            // Марш (March) - high knee lift, sharp swinging arms
            float marchArm = (float) Math.sin(timeSec * 3.5F) * 1.35F;
            accessor.rockstar$getLeftArm().pitch = marchArm;
            accessor.rockstar$getRightArm().pitch = -marchArm;
            accessor.rockstar$getLeftLeg().pitch = -marchArm * 0.85F;
            accessor.rockstar$getRightLeg().pitch = marchArm * 0.85F;
            accessor.rockstar$getBody().pitch = -0.06F;
            accessor.rockstar$getHead().pitch = 0.04F;
        } else if (INSTANCE.walkSwagger.isSelected()) {
            // Вразвалку (Swagger) - exaggerated hip & shoulder roll sway
            float swagger = (float) Math.sin(timeSec * 2.0F);
            accessor.rockstar$getBody().roll = swagger * 0.28F;
            accessor.rockstar$getHead().roll = -swagger * 0.18F;
            accessor.rockstar$getLeftArm().roll = -0.42F - swagger * 0.22F;
            accessor.rockstar$getRightArm().roll = 0.42F - swagger * 0.22F;
            accessor.rockstar$getLeftArm().pitch = swagger * 0.45F;
            accessor.rockstar$getRightArm().pitch = -swagger * 0.45F;
        } else if (INSTANCE.walkZombie.isSelected()) {
            // Зомби (Zombie) - arms extended forward with subtle sway
            float sway = (float) Math.sin(timeSec * 2.5F) * 0.08F;
            accessor.rockstar$getLeftArm().pitch = -1.65F + sway;
            accessor.rockstar$getRightArm().pitch = -1.65F - sway;
            accessor.rockstar$getLeftArm().roll = -0.10F;
            accessor.rockstar$getRightArm().roll = 0.10F;
            accessor.rockstar$getHead().pitch = 0.14F;
            accessor.rockstar$getHead().roll = sway * 1.8F;
        } else if (INSTANCE.walkLevitation.isSelected()) {
            // Левитация (Hover / Gliding) - gentle floating hover
            float floatBob = (float) Math.sin(timeSec * 2.8F) * 0.06F;
            accessor.rockstar$getLeftLeg().pitch = 0.12F + floatBob;
            accessor.rockstar$getRightLeg().pitch = 0.16F - floatBob;
            accessor.rockstar$getLeftLeg().roll = -0.08F;
            accessor.rockstar$getRightLeg().roll = 0.08F;
            accessor.rockstar$getLeftArm().pitch = 0.10F;
            accessor.rockstar$getRightArm().pitch = 0.10F;
            accessor.rockstar$getLeftArm().roll = -0.28F - floatBob;
            accessor.rockstar$getRightArm().roll = 0.28F + floatBob;
        }
    }

    public static void applyTransforms(PlayerEntity player, BipedEntityModelAccessor accessor, float tickDelta) {
        applyWalkingTransforms(player, accessor, tickDelta);

        if (activeAnimation == null || activeAnimation == CustomAnimation.NONE) return;

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
            case FACEPALM -> {
                accessor.rockstar$getRightArm().pitch = -1.90F;
                accessor.rockstar$getRightArm().yaw = -0.35F;
                accessor.rockstar$getRightArm().roll = 0.55F;
                accessor.rockstar$getHead().pitch = 0.35F;
                accessor.rockstar$getHead().yaw = 0.15F;
            }
            case SALUTE -> {
                accessor.rockstar$getRightArm().pitch = -2.35F;
                accessor.rockstar$getRightArm().yaw = -0.45F;
                accessor.rockstar$getRightArm().roll = 0.65F;
                accessor.rockstar$getHead().pitch = -0.10F;
                accessor.rockstar$getBody().pitch = -0.05F;
            }
            case BOW -> {
                accessor.rockstar$getBody().pitch = 0.65F;
                accessor.rockstar$getHead().pitch = 0.35F;
                accessor.rockstar$getRightArm().pitch = 0.35F;
                accessor.rockstar$getRightArm().roll = 0.25F;
                accessor.rockstar$getLeftArm().pitch = 0.35F;
                accessor.rockstar$getLeftArm().roll = -0.25F;
            }
            case LAUGH -> {
                float laugh = (float) Math.sin(t * 14.0) * 0.18F;
                accessor.rockstar$getHead().pitch = -0.35F + laugh;
                accessor.rockstar$getBody().pitch = laugh * 0.6F;
                accessor.rockstar$getRightArm().pitch = -0.6F + laugh;
                accessor.rockstar$getLeftArm().pitch = -0.6F + laugh;
            }
            case SHRUG -> {
                accessor.rockstar$getRightArm().pitch = -0.7F;
                accessor.rockstar$getRightArm().roll = 0.9F;
                accessor.rockstar$getRightArm().yaw = 0.4F;
                accessor.rockstar$getLeftArm().pitch = -0.7F;
                accessor.rockstar$getLeftArm().roll = -0.9F;
                accessor.rockstar$getLeftArm().yaw = -0.4F;
                accessor.rockstar$getHead().roll = 0.22F;
            }
            case DAB -> {
                accessor.rockstar$getHead().pitch = 0.45F;
                accessor.rockstar$getHead().yaw = 0.65F;
                accessor.rockstar$getLeftArm().pitch = -1.45F;
                accessor.rockstar$getLeftArm().roll = -1.25F;
                accessor.rockstar$getRightArm().pitch = -1.55F;
                accessor.rockstar$getRightArm().roll = -1.55F;
            }
            case SIT -> {
                accessor.rockstar$getLeftLeg().pitch = -1.57F;
                accessor.rockstar$getRightLeg().pitch = -1.57F;
                accessor.rockstar$getLeftLeg().yaw = -0.2F;
                accessor.rockstar$getRightLeg().yaw = 0.2F;
                accessor.rockstar$getBody().pitch = 0.1F;
            }
            case SPIN -> {
                float spinCycle = (t * 6.0F) % ((float) Math.PI * 2.0F);
                accessor.rockstar$getBody().yaw = spinCycle;
                accessor.rockstar$getHead().yaw = spinCycle;
                accessor.rockstar$getRightArm().roll = 1.3F;
                accessor.rockstar$getLeftArm().roll = -1.3F;
            }
        }
    }
}
