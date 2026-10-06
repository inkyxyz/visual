package rockstar.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import pyrock.events.game.AfterAttackEvent;
import pyrock.events.game.AttackEvent;
import pyrock.events.game.PostAttackEvent;

@ModuleInfo(
    name = "HitSounds",
    category = ModuleCategory.INTERFACE,
    iI_method_476ab839 = true,
    III_method_a89e5834 = "modules.descriptions.hitsounds"
)
public class HitSoundsModule extends Module {
    private final ModeSetting soundMode = new ModeSetting(this, "Звук");
    private final ModeSetting.Nested1_42765c60 modeNeverlose = new ModeSetting.Nested1_42765c60(this.soundMode, "Neverlose").select();
    private final ModeSetting.Nested1_42765c60 modeBubble = new ModeSetting.Nested1_42765c60(this.soundMode, "Bubble");
    private final ModeSetting.Nested1_42765c60 modeSkeet = new ModeSetting.Nested1_42765c60(this.soundMode, "Skeet");
    private final ModeSetting.Nested1_42765c60 modeBonk = new ModeSetting.Nested1_42765c60(this.soundMode, "Bonk");
    private final ModeSetting.Nested1_42765c60 modeCrit = new ModeSetting.Nested1_42765c60(this.soundMode, "Crit");
    private final ModeSetting.Nested1_42765c60 modeBell = new ModeSetting.Nested1_42765c60(this.soundMode, "Bell");
    private final ModeSetting.Nested1_42765c60 modeXp = new ModeSetting.Nested1_42765c60(this.soundMode, "XP Ding");
    private final ModeSetting.Nested1_42765c60 modeAmethyst = new ModeSetting.Nested1_42765c60(this.soundMode, "Amethyst");
    private final ModeSetting.Nested1_42765c60 modePop = new ModeSetting.Nested1_42765c60(this.soundMode, "Pop");

    private final SliderSetting volume = new SliderSetting(this, "Volume")
        .I_method_c8c9a7d7(10.0F)
        .i_method_65e2aff7(100.0F)
        .Ii_method_4e0e6b54(80.0F)
        .II_method_b0f56334(5.0F)
        .I_method_d41e7abf("%");
    private final SliderSetting pitch = new SliderSetting(this, "Pitch")
        .I_method_c8c9a7d7(0.5F)
        .i_method_65e2aff7(2.0F)
        .Ii_method_4e0e6b54(1.0F)
        .II_method_b0f56334(0.05F);
    private final BooleanSetting onlyPlayers = new BooleanSetting(this, "Only Players").I_method_a4d009eb(false);

    private long lastHitTime = 0L;

    private final IiIIIiII_Class69<AttackEvent> attackListener = event -> this.onHit(event.getEntity());
    private final IiIIIiII_Class69<AfterAttackEvent> afterAttackListener = event -> this.onHit(event.getEntity());
    private final IiIIIiII_Class69<PostAttackEvent> postAttackListener = event -> this.onHit(event.getEntity());

    public HitSoundsModule() {
    }

    private void onHit(Entity entity) {
        if (entity == null) return;
        if (this.onlyPlayers.i_method_9b12da03() && !(entity instanceof PlayerEntity)) return;

        long now = System.currentTimeMillis();
        if (now - this.lastHitTime < 50L) return;
        this.lastHitTime = now;

        MinecraftClient mc = MinecraftClient.getInstance();
        if (mc.getSoundManager() == null) return;

        float vol = this.volume.Ii_method_a20abcd2() / 100.0F;
        float p = this.pitch.Ii_method_a20abcd2();

        SoundEvent soundEvent = SoundEvents.BLOCK_NOTE_BLOCK_BELL.value();

        if (this.modeNeverlose.isSelected()) {
            soundEvent = SoundEvents.BLOCK_NOTE_BLOCK_BELL.value();
            p *= 1.4F;
        } else if (this.modeBubble.isSelected()) {
            soundEvent = SoundEvents.BLOCK_BUBBLE_COLUMN_BUBBLE_POP;
            p *= 1.1F;
        } else if (this.modeSkeet.isSelected()) {
            soundEvent = SoundEvents.BLOCK_NOTE_BLOCK_HAT.value();
            p *= 1.25F;
        } else if (this.modeBonk.isSelected()) {
            soundEvent = SoundEvents.BLOCK_ANVIL_LAND;
            p *= 1.6F;
        } else if (this.modeCrit.isSelected()) {
            soundEvent = SoundEvents.ENTITY_PLAYER_ATTACK_CRIT;
            p *= 1.05F;
        } else if (this.modeBell.isSelected()) {
            soundEvent = SoundEvents.BLOCK_NOTE_BLOCK_BELL.value();
            p *= 1.0F;
        } else if (this.modeXp.isSelected()) {
            soundEvent = SoundEvents.ENTITY_EXPERIENCE_ORB_PICKUP;
            p *= 1.2F;
        } else if (this.modeAmethyst.isSelected()) {
            soundEvent = SoundEvents.BLOCK_AMETHYST_BLOCK_HIT;
            p *= 1.35F;
        } else if (this.modePop.isSelected()) {
            soundEvent = SoundEvents.BLOCK_NOTE_BLOCK_CHIME.value();
            p *= 1.45F;
        }

        mc.getSoundManager().play(PositionedSoundInstance.master(soundEvent, p, vol));
    }
}
