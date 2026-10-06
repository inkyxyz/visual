package rockstar.client;

import java.util.LinkedHashSet;
import java.util.Set;
import lombok.Generated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.text.Text;
import org.jetbrains.annotations.Nullable;
import rockstar.client.IiIIIiIiI_Class139;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIiIIiIi_Class294;

public class IiIIIiIIi_Class138
implements iIIiIIiIi_Class294 {
    @Nullable
    private Entity I_field_77e0818c = null;
    private final Set<String> I_field_a56a8dc5 = new LinkedHashSet<String>();

    public final void I_method_aa3068e7(IiIIIiIiI_Class139 iiIIIiIiI_Class139) {
        this.I_field_77e0818c = this.I_method_d525569d(iiIIIiIiI_Class139);
    }

    public final void I_method_9db25e69(String string) {
        if (RockstarClient.getInstance().I_method_7a5acaeb().I_method_dbf3f81b().contains(string)) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.target.friend_error")));
            return;
        }
        if (this.I_field_a56a8dc5.contains(string)) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.target.already_exists", string)));
            return;
        }
        if (string.equalsIgnoreCase(I_field_3a9bda27.getSession().getUsername())) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.target.self_error")));
            return;
        }
        this.I_field_a56a8dc5.add(string);
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.target.added", string)));
    }

    public final void i_method_6e69b249(String string) {
        if (!this.I_field_a56a8dc5.contains(string)) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.target.not_found", string)));
            return;
        }
        this.I_field_a56a8dc5.remove(string);
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.target.removed", string)));
    }

    public final void I_method_3b326e5f() {
        if (this.I_field_a56a8dc5.isEmpty()) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.target.empty")));
            return;
        }
        this.I_field_a56a8dc5.clear();
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.target.cleared")));
    }

    public final void i_method_3b40fa3f() {
        if (this.I_field_a56a8dc5.isEmpty()) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.target.empty")));
            return;
        }
        int n = 1;
        for (String string : this.I_field_a56a8dc5) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)String.format(IiIiIIII_Class81.I_method_f25a980a("commands.target.list_entry"), n++, string)));
        }
    }

    @Nullable
    public final Entity I_method_d525569d(IiIIIiIiI_Class139 iiIIIiIiI_Class139) {
        if (IiIIIiIIi_Class138.I_field_3a9bda27.world == null) {
            return null;
        }
        Entity entity = null;
        boolean bl = false;
        for (Entity entity2 : IiIIIiIIi_Class138.I_field_3a9bda27.world.getEntities()) {
            boolean bl2;
            if (!iiIIIiIiI_Class139.I_method_b72bafcb(entity2)) continue;
            boolean bl3 = bl2 = !this.I_field_a56a8dc5.isEmpty() && this.I_field_a56a8dc5.contains(entity2.getName().getString());
            if (entity == null) {
                entity = entity2;
                bl = bl2;
                continue;
            }
            if (bl2 && !bl) {
                entity = entity2;
                bl = true;
                continue;
            }
            if (bl2 != bl || iiIIIiIiI_Class139.I_method_1e9cc50().compare(entity2, entity) >= 0) continue;
            entity = entity2;
        }
        return entity;
    }

    public final void II_method_2b2a54e2() {
        this.I_field_77e0818c = null;
    }

    public final boolean I_method_9db25e6d(String string) {
        return this.I_field_a56a8dc5.contains(string);
    }

    public final LivingEntity I_method_4517f36c() {
        LivingEntity livingEntity;
        Entity entity = RockstarClient.getInstance().I_method_9a638462().I_method_9c10f815();
        return entity instanceof LivingEntity ? (livingEntity = (LivingEntity)entity) : null;
    }

    @Nullable
    @Generated
    public Entity I_method_9c10f815() {
        return this.I_field_77e0818c;
    }

    @Generated
    public Set<String> I_method_d17b380e() {
        return this.I_field_a56a8dc5;
    }
}

