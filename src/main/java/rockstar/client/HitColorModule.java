package rockstar.client;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import pyrock.events.game.AfterAttackEvent;
import pyrock.events.game.AttackEvent;
import pyrock.events.game.PostAttackEvent;
import pyrock.events.game.WorldChangeEvent;
import pyrock.utility.render.ColorRGBA;

@ModuleInfo(
    name = "Hit Color",
    category = ModuleCategory.VISUALS,
    iI_method_476ab839 = false,
    III_method_a89e5834 = "modules.descriptions.hit_color"
)
public class HitColorModule extends Module {
    private ModeSetting targetMode;
    private ModeSetting.Nested1_42765c60 modeAttacked;
    private ModeSetting.Nested1_42765c60 modeAllHurt;

    private ModeSetting partMode;
    private ModeSetting.Nested1_42765c60 partBoth;
    private ModeSetting.Nested1_42765c60 partEntity;
    private ModeSetting.Nested1_42765c60 partArmor;

    private BooleanSetting syncTheme;
    private ColorSetting hitColor;
    private SliderSetting durationMs;

    private final Map<Integer, Long> hitEntities = new ConcurrentHashMap<>();

    private final IiIIIiII_Class69<AfterAttackEvent> afterAttack = event -> {
        if (event.getEntity() != null) recordHit(event.getEntity());
    };

    private final IiIIIiII_Class69<AttackEvent> attackEvent = event -> {
        if (event.getEntity() != null) recordHit(event.getEntity());
    };

    private final IiIIIiII_Class69<PostAttackEvent> postAttack = event -> {
        if (event.getEntity() != null) recordHit(event.getEntity());
    };

    private final IiIIIiII_Class69<WorldChangeEvent> worldChange = event -> {
        this.hitEntities.clear();
    };

    public HitColorModule() {
        this.targetMode = new ModeSetting(this, "Target");
        this.modeAttacked = new ModeSetting.Nested1_42765c60(this.targetMode, "Attacked").select();
        this.modeAllHurt = new ModeSetting.Nested1_42765c60(this.targetMode, "All Hurt");

        this.partMode = new ModeSetting(this, "Apply To");
        this.partBoth = new ModeSetting.Nested1_42765c60(this.partMode, "Both").select();
        this.partEntity = new ModeSetting.Nested1_42765c60(this.partMode, "Entity");
        this.partArmor = new ModeSetting.Nested1_42765c60(this.partMode, "Armor");

        this.syncTheme = new BooleanSetting(this, "Sync Theme").I_method_decd82b5();
        this.hitColor = new ColorSetting(this, "Color").I_method_a62f5dd6(new ColorRGBA(255.0F, 50.0F, 80.0F, 255.0F));
        this.durationMs = new SliderSetting(this, "Duration (ms)")
            .I_method_c8c9a7d7(100.0F)
            .i_method_65e2aff7(1500.0F)
            .II_method_b0f56334(50.0F)
            .Ii_method_4e0e6b54(450.0F);
    }

    private void recordHit(Entity entity) {
        if (entity == null) return;
        MinecraftClient mc = MinecraftClient.getInstance();
        if (entity == mc.player) return;
        long dur = (long) this.durationMs.Ii_method_a20abcd2();
        this.hitEntities.put(entity.getId(), System.currentTimeMillis() + dur);
    }

    public boolean isHitActive(Entity entity) {
        if (!this.isEnabled() || entity == null) return false;
        MinecraftClient mc = MinecraftClient.getInstance();
        if (entity == mc.player) return false;

        if (this.modeAllHurt != null && this.modeAllHurt.isSelected()) {
            if (entity instanceof LivingEntity living && living.hurtTime > 0) {
                return true;
            }
        }

        Long expire = this.hitEntities.get(entity.getId());
        if (expire != null) {
            if (System.currentTimeMillis() < expire) {
                return true;
            } else {
                this.hitEntities.remove(entity.getId());
            }
        }
        return false;
    }

    public boolean shouldTintEntity(Entity entity) {
        if (!isHitActive(entity)) return false;
        return this.partBoth.isSelected() || this.partEntity.isSelected();
    }

    public boolean shouldTintArmor(Entity entity) {
        if (!isHitActive(entity)) return false;
        return this.partBoth.isSelected() || this.partArmor.isSelected();
    }

    public int getTintColor(Entity entity) {
        ColorRGBA col = this.syncTheme.i_method_9b12da03()
            ? IiiiiIIIi_Class242.I_method_7df8e08e()
            : this.hitColor.I_method_bde5f08e();
        return col.getRGB();
    }

    @Override
    public String i_method_bf522194() {
        return "Кастомизирует цвет урона и цвет брони/модели атакуемого игрока или моба.";
    }
}
