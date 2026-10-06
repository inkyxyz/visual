package rockstar.client;

import globals.client.Information;
import globals.shared.proto.Packets;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.text.Text;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.IiiiiiiII_Class253;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iIIiIIiIi_Class294;

public class IiIIiiII_Class77
implements iIIiIIiIi_Class294 {
    private final List<String> I_field_7865b31 = new ArrayList<String>();
    private Set<String> I_field_a56a8dc5 = Set.of();
    private int I_field_49 = -1;
    private boolean I_field_5a = true;

    public final void I_method_19c94376(String string) {
        if (string == null || string.isBlank()) {
            return;
        }
        if (RockstarClient.getInstance().I_method_9a638462().I_method_d17b380e().contains(string)) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.friends.target")));
            return;
        }
        if (this.i_method_9140303b().contains(string)) {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.friends.exists", string)));
            return;
        }
        if (string.equalsIgnoreCase(I_field_3a9bda27.getSession().getUsername())) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.friends.self")));
            return;
        }
        this.I_field_7865b31.add(string);
        this.I_field_5a = true;
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.friends.added", string)));
        if (IiiiiiiII_Class253.i_method_1cc4aa23()) {
            RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
        }
    }

    public final void i_method_ea809756(String string) {
        if (string == null) {
            return;
        }
        if (this.I_field_7865b31.contains(string)) {
            this.I_field_7865b31.remove(string);
            this.I_field_5a = true;
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.friends.removed", string)));
        } else {
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("commands.friends.not_exists", string)));
        }
        RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
    }

    public final void I_method_b08d6cac() {
        if (this.I_field_7865b31.isEmpty()) {
            iIIIIIIii_Class260.II_method_e8fd4864(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.friends.empty")));
        } else {
            this.I_field_7865b31.clear();
            this.I_field_5a = true;
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("commands.friends.cleared")));
            RockstarClient.getInstance().I_method_7a4c3f0b().i_method_af563376("client");
        }
    }

    public final boolean I_method_7d4521a1(List<String> list) {
        this.I_field_7865b31.clear();
        this.I_field_5a = true;
        if (list == null) {
            return false;
        }
        boolean bl = false;
        for (String string : list) {
            if (string != null && !string.isBlank() && !this.I_field_7865b31.contains(string)) {
                this.I_field_7865b31.add(string);
                continue;
            }
            bl = true;
        }
        return bl;
    }

    private Set<String> I_method_9bc0ab9b() {
        int n = Information.getFriendsVersion();
        if (!this.I_field_5a && n == this.I_field_49) {
            return this.I_field_a56a8dc5;
        }
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<String>(this.I_field_7865b31);
        for (Packets.Nested1_1da0dac9 nested1_1da0dac9 : Information.getFriends()) {
            String string;
            if (nested1_1da0dac9 == null || nested1_1da0dac9.gameInfo() == null || (string = nested1_1da0dac9.gameInfo().nickname()) == null || string.isBlank()) continue;
            linkedHashSet.add(string);
        }
        this.I_field_a56a8dc5 = linkedHashSet;
        this.I_field_49 = n;
        this.I_field_5a = false;
        return this.I_field_a56a8dc5;
    }

    private List<String> i_method_9140303b() {
        return new ArrayList<String>(this.I_method_9bc0ab9b());
    }

    public final List<String> I_method_dbf3f81b() {
        return List.copyOf(this.I_method_9bc0ab9b());
    }

    public final boolean I_method_19c9437a(String string) {
        if (string == null) {
            return false;
        }
        return this.I_method_9bc0ab9b().contains(string);
    }

    private boolean friendlyFireProtection = true;

    public boolean isFriendlyFireProtection() {
        return this.friendlyFireProtection;
    }

    public void setFriendlyFireProtection(boolean friendlyFireProtection) {
        this.friendlyFireProtection = friendlyFireProtection;
    }
}

