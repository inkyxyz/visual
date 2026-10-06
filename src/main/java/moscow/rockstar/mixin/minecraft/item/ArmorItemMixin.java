package moscow.rockstar.mixin.minecraft.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import rockstar.client.iIiIiiIIi_Class346;

@Mixin(value={ArmorItem.class})
public abstract class ArmorItemMixin
implements iIiIiiIIi_Class346 {
    @Unique
    private EquipmentType rockstar$type;
    @Unique
    private ArmorMaterial rockstar$material;

    @Inject(method={"<init>"}, at={@At(value="TAIL")})
    public void saveArgs(ArmorMaterial armorMaterial, EquipmentType equipmentType, Item.Settings settings, CallbackInfo callbackInfo) {
        this.rockstar$type = equipmentType;
        this.rockstar$material = armorMaterial;
    }

    @Override
    public ArmorMaterial rockstar$getMaterial() {
        return this.rockstar$material;
    }

    @Override
    public EquipmentType rockstar$getType() {
        return this.rockstar$type;
    }
}

