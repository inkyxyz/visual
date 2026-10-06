package pyrock.classes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import org.jetbrains.annotations.Nullable;
import rockstar.client.IiIIIiIII_Class137;
import rockstar.client.IiIIIiIIi_Class138;
import rockstar.client.IiIIIiIiI_Class139;
import rockstar.client.RockstarClient;

public class PyTarget {
    public Nested1_a6ac17e8 query() {
        return new Nested1_a6ac17e8();
    }

    @Nullable
    public Entity best(Nested1_a6ac17e8 nested1_a6ac17e8) {
        if (nested1_a6ac17e8 == null) {
            return null;
        }
        return PyTarget.manager().I_method_d525569d(nested1_a6ac17e8.build());
    }

    public List<Entity> all(Nested1_a6ac17e8 nested1_a6ac17e8) {
        ArrayList<Entity> arrayList = new ArrayList<Entity>();
        if (nested1_a6ac17e8 == null || PyTarget.mc().world == null) {
            return arrayList;
        }
        IiIIIiIiI_Class139 iiIIIiIiI_Class139 = nested1_a6ac17e8.build();
        for (Entity entity : PyTarget.mc().world.getEntities()) {
            if (!iiIIIiIiI_Class139.I_method_b72bafcb(entity)) continue;
            arrayList.add(entity);
        }
        arrayList.sort(iiIIIiIiI_Class139.I_method_1e9cc50());
        return arrayList;
    }

    public boolean valid(Nested1_a6ac17e8 nested1_a6ac17e8, Entity entity) {
        return nested1_a6ac17e8 != null && entity != null && nested1_a6ac17e8.build().I_method_b72bafcb(entity);
    }

    @Nullable
    public Entity current() {
        return PyTarget.manager().I_method_9c10f815();
    }

    @Nullable
    public LivingEntity living() {
        return PyTarget.manager().I_method_4517f36c();
    }

    public void add(String string) {
        if (string != null && !string.isBlank()) {
            PyTarget.manager().I_method_9db25e69(string);
        }
    }

    public void remove(String string) {
        if (string != null && !string.isBlank()) {
            PyTarget.manager().i_method_6e69b249(string);
        }
    }

    public void clear() {
        PyTarget.manager().I_method_3b326e5f();
    }

    public boolean isTarget(String string) {
        return string != null && PyTarget.manager().I_method_9db25e6d(string);
    }

    public List<String> list() {
        return new ArrayList<String>(PyTarget.manager().I_method_d17b380e());
    }

    static Comparator<Entity> comparator(String string) {
        return switch (string.toLowerCase(Locale.ROOT)) {
            case "health", "hp" -> IiIIIiIII_Class137.i_field_c8f916f9;
            case "fov", "angle", "crosshair" -> IiIIIiIII_Class137.II_field_c8f916f9;
            case "bad_armor", "weakest" -> IiIIIiIII_Class137.Ii_field_c8f916f9;
            case "good_armor", "strongest" -> IiIIIiIII_Class137.iI_field_c8f916f9;
            default -> IiIIIiIII_Class137.I_field_c8f916f9;
        };
    }

    private static IiIIIiIIi_Class138 manager() {
        return RockstarClient.getInstance().I_method_9a638462();
    }

    private static MinecraftClient mc() {
        return MinecraftClient.getInstance();
    }

    public static final class Nested1_a6ac17e8 {
        private boolean players = true;
        private boolean animals;
        private boolean mobs;
        private boolean users;
        private boolean invisibles;
        private boolean naked = true;
        private boolean friends;
        private boolean armorStands;
        private boolean excludeTeammates;
        private float range = -1.0f;
        private String sort = "distance";

        public Nested1_a6ac17e8 players(boolean bl) {
            this.players = bl;
            return this;
        }

        public Nested1_a6ac17e8 animals(boolean bl) {
            this.animals = bl;
            return this;
        }

        public Nested1_a6ac17e8 mobs(boolean bl) {
            this.mobs = bl;
            return this;
        }

        public Nested1_a6ac17e8 users(boolean bl) {
            this.users = bl;
            return this;
        }

        public Nested1_a6ac17e8 invisibles(boolean bl) {
            this.invisibles = bl;
            return this;
        }

        public Nested1_a6ac17e8 naked(boolean bl) {
            this.naked = bl;
            return this;
        }

        public Nested1_a6ac17e8 friends(boolean bl) {
            this.friends = bl;
            return this;
        }

        public Nested1_a6ac17e8 armorStands(boolean bl) {
            this.armorStands = bl;
            return this;
        }

        public Nested1_a6ac17e8 excludeTeammates(boolean bl) {
            this.excludeTeammates = bl;
            return this;
        }

        public Nested1_a6ac17e8 range(double d) {
            this.range = (float)d;
            return this;
        }

        public Nested1_a6ac17e8 sort(String string) {
            this.sort = string == null ? "distance" : string;
            return this;
        }

        IiIIIiIiI_Class139 build() {
            return new IiIIIiIiI_Class139.Nested1_a87537e0().I_method_1f3a928b(this.players).i_method_da3212ab(this.animals).II_method_9a5032be(this.mobs).Ii_method_5547b2de(this.users).iI_method_3e48b69e(this.invisibles).ii_method_f94036be(this.naked).III_method_81ee98eb(this.friends).IIi_method_3ce6190b(this.armorStands).IiI_method_25e71ccb(this.excludeTeammates).I_method_7d0aed77(this.range).I_method_8fd609a4(PyTarget.comparator(this.sort)).I_method_7ebd8d70();
        }
    }
}

