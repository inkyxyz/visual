package rockstar.client;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import lombok.Generated;
import net.minecraft.text.Text;
import rockstar.client.IiIIiIII_Class73;
import rockstar.client.IiIiIIII_Class81;
import rockstar.client.RockstarClient;
import rockstar.client.iIIIIIIii_Class260;
import rockstar.client.iiIIiIII_Class201;
import ua.mintantileak.spk.Compile;

public class iiIIiIIi_Class202 {
    private final List<iiIIiIII_Class201> I_field_7865b31 = new ArrayList<iiIIiIII_Class201>();
    private iiIIiIII_Class201 I_field_c7d5b3a1;
    private boolean I_field_5a = false;

    @Compile
    public void I_method_bb63b4cc() {
        if (this.I_method_3a70cfeb() == null) {
            this.I_method_fbe9c396("autosave");
        }
        if (!this.I_field_5a) {
            this.iI_method_b2e4cc35();
            this.I_field_5a = true;
        }
    }

    public void i_method_bb7240ac() {
        String[] stringArray = new String[]{"explorer " + new File(String.valueOf(IiIIiIII_Class73.I_field_3a58077) + "/presets", "swing").getAbsolutePath()};
        try {
            Runtime.getRuntime().exec(stringArray);
        }
        catch (Exception exception) {
            RockstarClient.I_field_ab0f6068.error("\u0432\u0441\u0435 \u043d\u0430\u0435\u0431\u043d\u0443\u043b\u043e\u0441\u044c \u0432 dir \u043a\u043e\u043d\u0444\u0438\u0433\u0435 {}", (Object)exception.getMessage());
        }
    }

    public void I_method_fbe9c396(String string) {
        if (string == null) {
            return;
        }
        if (this.I_method_9c83fef9(string, false) != null) {
            RockstarClient.I_field_ab0f6068.warn("Preset {} already exists", (Object)string);
            return;
        }
        iiIIiIII_Class201 iiIIiIII_Class2012 = new iiIIiIII_Class201(string);
        if (string.equals("autosave")) {
            iiIIiIII_Class2012.I_method_84c8a0ec();
        }
        iiIIiIII_Class2012.i_method_84d72ccc();
        this.I_field_7865b31.add(iiIIiIII_Class2012);
    }

    public void II_method_b121dc15() {
        iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_f25a980a("swing_anim.preset_list")));
        for (iiIIiIII_Class201 iiIIiIII_Class2012 : this.I_field_7865b31) {
            int n = this.I_field_7865b31.indexOf(iiIIiIII_Class2012) + 1;
            iIIIIIIii_Class260.I_method_468cf607(Text.of((String)IiIiIIII_Class81.I_method_1410d1e5("swing_anim.preset_item", n, iiIIiIII_Class2012.I_method_5141c934())));
        }
    }

    private void iI_method_b2e4cc35() {
        this.I_field_7865b31.clear();
        Path path2 = Paths.get(String.valueOf(IiIIiIII_Class73.I_field_3a58077) + "/presets", "swing");
        if (!Files.exists(path2, new LinkOption[0])) {
            try {
                Files.createDirectories(path2, new FileAttribute[0]);
                return;
            }
            catch (IOException iOException) {
                RockstarClient.I_field_ab0f6068.error("\u041d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u0434\u0438\u0440\u0435\u043a\u0442\u043e\u0440\u0438\u044e \u043f\u0440\u0435\u0441\u0435\u0442\u043e\u0432: {}", (Object)iOException.getMessage());
                return;
            }
        }
        try (Stream<Path> stream = Files.list(path2);){
            stream.filter(path -> Files.isRegularFile(path, new LinkOption[0])).filter(path -> path.toString().endsWith(".rock")).forEach(path -> {
                String string = path.getFileName().toString();
                String string2 = string.substring(0, string.lastIndexOf(46));
                iiIIiIII_Class201 iiIIiIII_Class2012 = new iiIIiIII_Class201(string2);
                this.I_field_7865b31.add(iiIIiIII_Class2012);
            });
        }
        catch (IOException iOException) {
            RockstarClient.I_field_ab0f6068.error("\u041e\u0448\u0438\u0431\u043a\u0430 \u043f\u0440\u0438 \u0441\u043a\u0430\u043d\u0438\u0440\u043e\u0432\u0430\u043d\u0438\u0438 \u0434\u0438\u0440\u0435\u043a\u0442\u043e\u0440\u0438\u0438 \u043a\u043e\u043d\u0444\u0438\u0433\u043e\u0432: {}", (Object)iOException.getMessage());
        }
    }

    public iiIIiIII_Class201 I_method_9c83fef9(String string, boolean bl) {
        if (bl) {
            this.iI_method_b2e4cc35();
        }
        return this.I_field_7865b31.stream().filter(iiIIiIII_Class2012 -> iiIIiIII_Class2012.I_method_5141c934().equalsIgnoreCase(string)).findFirst().orElse(null);
    }

    public iiIIiIII_Class201 I_method_d4b21861(String string) {
        return this.I_method_9c83fef9(string, false);
    }

    public iiIIiIII_Class201 I_method_3a70cfeb() {
        return this.I_method_9c83fef9("autosave", true);
    }

    public void Ii_method_b13067f5() {
        this.iI_method_b2e4cc35();
    }

    @Generated
    public List<iiIIiIII_Class201> I_method_43006bfb() {
        return this.I_field_7865b31;
    }

    @Generated
    public iiIIiIII_Class201 i_method_646d600b() {
        return this.I_field_c7d5b3a1;
    }

    @Generated
    public boolean I_method_bb63b4d0() {
        return this.I_field_5a;
    }

    @Generated
    public void I_method_7885936d(iiIIiIII_Class201 iiIIiIII_Class2012) {
        this.I_field_c7d5b3a1 = iiIIiIII_Class2012;
    }
}

