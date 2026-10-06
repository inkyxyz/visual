package rockstar.client;

import com.mojang.blaze3d.systems.RenderSystem;
import java.util.ArrayList;
import java.util.List;
import moscow.rockstar.mixin.accessors.ShaderProgramAccessor;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Defines;
import net.minecraft.client.gl.GlUniform;
import net.minecraft.client.gl.ShaderLoader;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.gl.ShaderProgramKey;
import net.minecraft.client.render.RenderPhase;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.ApiStatus;

public class IiiIi_Class14 {
    private static final List<Runnable> I_field_7865b31 = new ArrayList<Runnable>();
    protected ShaderProgram I_field_460ca9a2;
    protected ShaderProgramKey I_field_bb992b15;

    public IiiIi_Class14(Identifier identifier, VertexFormat vertexFormat) {
        this.I_field_bb992b15 = new ShaderProgramKey(identifier.withPrefixedPath("core/"), vertexFormat, Defines.EMPTY);
        I_field_7865b31.add(() -> {
            try {
                this.I_field_460ca9a2 = MinecraftClient.getInstance().getShaderLoader().getProgramToLoad(this.I_field_bb992b15);
                this.I_method_e7207e6c();
            }
            catch (ShaderLoader.LoadException loadException) {
                throw new RuntimeException("Failed to initialize shader program", loadException);
            }
        });
    }

    public RenderPhase.ShaderProgram I_method_bbcba39() {
        return new RenderPhase.ShaderProgram(this.I_field_bb992b15);
    }

    public boolean I_method_a04a46e3() {
        return this.I_field_460ca9a2 != null;
    }

    public ShaderProgram I_method_33f6c16b() {
        return RenderSystem.setShader((ShaderProgramKey)this.I_field_bb992b15);
    }

    protected void I_method_e7207e6c() {
    }

    public GlUniform I_method_cb7dbe45(String string) {
        if (this.I_field_460ca9a2 == null) {
            try {
                this.I_field_460ca9a2 = MinecraftClient.getInstance().getShaderLoader().getProgramToLoad(this.I_field_bb992b15);
            }
            catch (Throwable throwable) {
                return null;
            }
            if (this.I_field_460ca9a2 == null) {
                return null;
            }
        }
        return ((ShaderProgramAccessor)(Object)this.I_field_460ca9a2).getUniformsByName().get(string);
    }

    @ApiStatus.Internal
    public static void i_method_a058d2bf() {
        IiiIi_Class14.I_method_68ff47d5(false);
    }

    @ApiStatus.Internal
    public static void I_method_68ff47d5(boolean bl) {
        for (Runnable runnable : I_field_7865b31) {
            try {
                runnable.run();
            }
            catch (Throwable throwable) {
                if (bl) continue;
                StringBuilder stringBuilder = new StringBuilder();
                for (Throwable throwable2 = throwable; throwable2 != null && stringBuilder.length() < 2048; throwable2 = throwable2.getCause()) {
                    stringBuilder.append(stringBuilder.length() == 0 ? "" : "\n  caused by: ").append(throwable2);
                    if (throwable2 == throwable2.getCause()) break;
                }
                System.err.println("[Rockstar] Failed to (re)load a shader program, skipping: " + String.valueOf(stringBuilder));
            }
        }
    }
}

