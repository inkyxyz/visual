package rockstar.client;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import javax.annotation.Nonnull;
import rockstar.client.iIIIii_Class36;
import rockstar.client.iIiIII_Class41;
import rockstar.client.iiiIII_Class57;

public class iIiIiI_Class43
extends iIiIII_Class41 {
    private final File I_field_3a58077;

    public iIiIiI_Class43(File file) {
        this(iIIIii_Class36.iI_field_58cf7a41, file);
    }

    public iIiIiI_Class43(iiiIII_Class57 iiiIII_Class572, File file) {
        super(iiiIII_Class572);
        this.I_field_3a58077 = file;
    }

    @Override
    public boolean I_method_533eee70() {
        return true;
    }

    @Override
    public int I_method_533eee5f() {
        return (int)this.I_field_3a58077.length();
    }

    @Override
    @Nonnull
    protected InputStream I_method_23a0bb6f() throws IOException {
        return Files.newInputStream(this.I_field_3a58077.toPath(), new OpenOption[0]);
    }
}

