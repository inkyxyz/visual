package rockstar.client;

import net.minecraft.client.MinecraftClient;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWNativeWin32;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GLCapabilities;
import rockstar.client.IIIiIiII_Class21;
import rockstar.client.RockstarClient;

public final class IIIiIiiI_Class23 {
    private static final String I_field_523beb0a = "#version 150\nin vec2 Position;\nout vec2 uv;\nvoid main() {\n    uv = Position * 0.5 + 0.5;\n    gl_Position = vec4(Position, 0.0, 1.0);\n}\n";
    private static final String i_field_523beb0a = "#version 150\nuniform sampler2D Sampler;\nin vec2 uv;\nout vec4 fragColor;\nvoid main() {\n    fragColor = texture(Sampler, uv);\n}\n";
    private long I_field_4a;
    private GLCapabilities I_field_418a15a2;
    private GLCapabilities i_field_418a15a2;
    private int I_field_49;
    private int i_field_49;
    private int II_field_49;
    private int Ii_field_49 = -1;
    private boolean I_field_5a;
    private boolean i_field_5a;
    private int iI_field_49 = Integer.MIN_VALUE;
    private int ii_field_49 = Integer.MIN_VALUE;
    private int III_field_49 = -1;
    private int IIi_field_49 = -1;

    public boolean I_method_57c06cb0() {
        return this.I_field_4a != 0L;
    }

    public boolean i_method_57cef890() {
        return this.i_field_5a;
    }

    public boolean II_method_a05c2039() {
        if (this.I_field_4a != 0L) {
            return true;
        }
        if (this.i_field_5a) {
            return false;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        long l = minecraftClient.getWindow().getHandle();
        try {
            this.i_field_418a15a2 = GL.getCapabilities();
            GLFW.glfwDefaultWindowHints();
            GLFW.glfwWindowHint((int)139266, (int)3);
            GLFW.glfwWindowHint((int)139267, (int)2);
            GLFW.glfwWindowHint((int)139272, (int)204801);
            GLFW.glfwWindowHint((int)131076, (int)0);
            GLFW.glfwWindowHint((int)131077, (int)0);
            GLFW.glfwWindowHint((int)131079, (int)1);
            GLFW.glfwWindowHint((int)131075, (int)0);
            GLFW.glfwWindowHint((int)131073, (int)0);
            GLFW.glfwWindowHint((int)131084, (int)0);
            GLFW.glfwWindowHint((int)131085, (int)1);
            GLFW.glfwWindowHint((int)131082, (int)1);
            GLFW.glfwWindowHint((int)135172, (int)8);
            GLFW.glfwWindowHint((int)135173, (int)0);
            GLFW.glfwWindowHint((int)135174, (int)0);
            this.I_field_4a = GLFW.glfwCreateWindow((int)Math.max(1, minecraftClient.getWindow().getWidth()), (int)Math.max(1, minecraftClient.getWindow().getHeight()), (CharSequence)"", (long)0L, (long)l);
            GLFW.glfwDefaultWindowHints();
            if (this.I_field_4a == 0L) {
                this.i_field_5a = true;
                return false;
            }
            if (GLFW.glfwGetWindowAttrib((long)this.I_field_4a, (int)131082) != 1) {
                this.i_method_57cef88c();
                this.i_field_5a = true;
                return false;
            }
            long l2 = GLFWNativeWin32.glfwGetWin32Window((long)this.I_field_4a);
            if (l2 == 0L || !IIIiIiII_Class21.excludeFromCapture(l2)) {
                this.i_method_57cef88c();
                this.i_field_5a = true;
                return false;
            }
            IIIiIiII_Class21.makeGhost(l2);
            GLFW.glfwMakeContextCurrent((long)this.I_field_4a);
            this.I_field_418a15a2 = GL.createCapabilities();
            GLFW.glfwSwapInterval((int)0);
            this.II_method_a05c2035();
            GLFW.glfwMakeContextCurrent((long)l);
            GL.setCapabilities((GLCapabilities)this.i_field_418a15a2);
            return true;
        }
        catch (Throwable throwable) {
            RockstarClient.I_field_ab0f6068.error("[CaptureShield] \u043d\u0435 \u0443\u0434\u0430\u043b\u043e\u0441\u044c \u0441\u043e\u0437\u0434\u0430\u0442\u044c \u043e\u043a\u043d\u043e \u043f\u0440\u0438\u0432\u0430\u0442\u043d\u043e\u0433\u043e \u0441\u043b\u043e\u044f", throwable);
            try {
                GLFW.glfwMakeContextCurrent((long)l);
                if (this.i_field_418a15a2 != null) {
                    GL.setCapabilities((GLCapabilities)this.i_field_418a15a2);
                }
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
            this.i_method_57cef88c();
            this.i_field_5a = true;
            return false;
        }
    }

    private void II_method_a05c2035() {
        int n = this.I_method_6d1a1dd4(35633, I_field_523beb0a);
        int n2 = this.I_method_6d1a1dd4(35632, i_field_523beb0a);
        this.I_field_49 = GL20.glCreateProgram();
        GL20.glAttachShader((int)this.I_field_49, (int)n);
        GL20.glAttachShader((int)this.I_field_49, (int)n2);
        GL20.glBindAttribLocation((int)this.I_field_49, (int)0, (CharSequence)"Position");
        GL20.glLinkProgram((int)this.I_field_49);
        if (GL20.glGetProgrami((int)this.I_field_49, (int)35714) == 0) {
            throw new IllegalStateException("link: " + GL20.glGetProgramInfoLog((int)this.I_field_49));
        }
        GL20.glDeleteShader((int)n);
        GL20.glDeleteShader((int)n2);
        this.Ii_field_49 = GL20.glGetUniformLocation((int)this.I_field_49, (CharSequence)"Sampler");
        this.i_field_49 = GL30.glGenVertexArrays();
        this.II_field_49 = GL15.glGenBuffers();
        GL30.glBindVertexArray((int)this.i_field_49);
        GL15.glBindBuffer((int)34962, (int)this.II_field_49);
        GL15.glBufferData((int)34962, (float[])new float[]{-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f}, (int)35044);
        GL20.glEnableVertexAttribArray((int)0);
        GL20.glVertexAttribPointer((int)0, (int)2, (int)5126, (boolean)false, (int)8, (long)0L);
        GL30.glBindVertexArray((int)0);
        GL15.glBindBuffer((int)34962, (int)0);
    }

    private int I_method_6d1a1dd4(int n, String string) {
        int n2 = GL20.glCreateShader((int)n);
        GL20.glShaderSource((int)n2, (CharSequence)string);
        GL20.glCompileShader((int)n2);
        if (GL20.glGetShaderi((int)n2, (int)35713) == 0) {
            throw new IllegalStateException("compile: " + GL20.glGetShaderInfoLog((int)n2));
        }
        return n2;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void I_method_b8ccbf5e(int n, int[] nArray, int n2, int n3, int n4) {
        if (this.I_field_4a == 0L) {
            return;
        }
        MinecraftClient minecraftClient = MinecraftClient.getInstance();
        long l = minecraftClient.getWindow().getHandle();
        if (!this.I_method_a04d9f9c(l)) {
            this.I_method_57c06cac();
            return;
        }
        try {
            GL11.glFlush();
            GLFW.glfwMakeContextCurrent((long)this.I_field_4a);
            GL.setCapabilities((GLCapabilities)this.I_field_418a15a2);
            int[] nArray2 = new int[1];
            int[] nArray3 = new int[1];
            GLFW.glfwGetFramebufferSize((long)this.I_field_4a, (int[])nArray2, (int[])nArray3);
            GL11.glViewport((int)0, (int)0, (int)nArray2[0], (int)nArray3[0]);
            GL11.glDisable((int)2929);
            GL11.glDisable((int)3042);
            GL11.glDisable((int)3089);
            GL11.glDisable((int)2884);
            GL11.glColorMask((boolean)true, (boolean)true, (boolean)true, (boolean)true);
            GL11.glClearColor((float)0.0f, (float)0.0f, (float)0.0f, (float)0.0f);
            GL11.glClear((int)16384);
            if (n != 0 && n2 > 0 && n3 > 0 && n4 > 0) {
                GL20.glUseProgram((int)this.I_field_49);
                if (this.Ii_field_49 >= 0) {
                    GL20.glUniform1i((int)this.Ii_field_49, (int)0);
                }
                GL13.glActiveTexture((int)33984);
                GL11.glBindTexture((int)3553, (int)n);
                GL30.glBindVertexArray((int)this.i_field_49);
                float f = (float)nArray2[0] / (float)n3;
                float f2 = (float)nArray3[0] / (float)n4;
                GL11.glEnable((int)3089);
                for (int i = 0; i < n2; ++i) {
                    int n5 = i * 4;
                    GL11.glScissor((int)((int)Math.floor((float)nArray[n5] * f)), (int)((int)Math.floor((float)nArray[n5 + 1] * f2)), (int)((int)Math.ceil((float)nArray[n5 + 2] * f)), (int)((int)Math.ceil((float)nArray[n5 + 3] * f2)));
                    GL11.glDrawArrays((int)5, (int)0, (int)4);
                }
                GL11.glDisable((int)3089);
                GL30.glBindVertexArray((int)0);
                GL11.glBindTexture((int)3553, (int)0);
                GL20.glUseProgram((int)0);
            }
            GLFW.glfwSwapBuffers((long)this.I_field_4a);
        }
        catch (Throwable throwable) {
            RockstarClient.I_field_ab0f6068.error("[CaptureShield] \u043e\u0448\u0438\u0431\u043a\u0430 \u0432\u044b\u0432\u043e\u0434\u0430 \u043f\u0440\u0438\u0432\u0430\u0442\u043d\u043e\u0433\u043e \u0441\u043b\u043e\u044f", throwable);
            this.i_field_5a = true;
        }
        finally {
            GLFW.glfwMakeContextCurrent((long)l);
            GL.setCapabilities((GLCapabilities)this.i_field_418a15a2);
        }
        if (!this.I_field_5a) {
            GLFW.glfwShowWindow((long)this.I_field_4a);
            this.I_field_5a = true;
        }
    }

    private boolean I_method_a04d9f9c(long l) {
        if (GLFW.glfwGetWindowAttrib((long)l, (int)131074) == 1) {
            return false;
        }
        if (GLFW.glfwGetWindowAttrib((long)l, (int)131073) != 1) {
            return false;
        }
        int[] nArray = new int[1];
        int[] nArray2 = new int[1];
        int[] nArray3 = new int[1];
        int[] nArray4 = new int[1];
        GLFW.glfwGetWindowPos((long)l, (int[])nArray, (int[])nArray2);
        GLFW.glfwGetWindowSize((long)l, (int[])nArray3, (int[])nArray4);
        if (nArray3[0] <= 0 || nArray4[0] <= 0) {
            return false;
        }
        if (nArray3[0] != this.III_field_49 || nArray4[0] != this.IIi_field_49) {
            GLFW.glfwSetWindowSize((long)this.I_field_4a, (int)nArray3[0], (int)nArray4[0]);
            this.III_field_49 = nArray3[0];
            this.IIi_field_49 = nArray4[0];
        }
        if (nArray[0] != this.iI_field_49 || nArray2[0] != this.ii_field_49) {
            GLFW.glfwSetWindowPos((long)this.I_field_4a, (int)nArray[0], (int)nArray2[0]);
            this.iI_field_49 = nArray[0];
            this.ii_field_49 = nArray2[0];
        }
        return true;
    }

    public void I_method_57c06cac() {
        if (this.I_field_4a != 0L && this.I_field_5a) {
            GLFW.glfwHideWindow((long)this.I_field_4a);
            this.I_field_5a = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void i_method_57cef88c() {
        if (this.I_field_4a == 0L) {
            return;
        }
        long l = MinecraftClient.getInstance().getWindow().getHandle();
        try {
            GLFW.glfwMakeContextCurrent((long)this.I_field_4a);
            GL.setCapabilities((GLCapabilities)this.I_field_418a15a2);
            if (this.II_field_49 != 0) {
                GL15.glDeleteBuffers((int)this.II_field_49);
            }
            if (this.i_field_49 != 0) {
                GL30.glDeleteVertexArrays((int)this.i_field_49);
            }
            if (this.I_field_49 != 0) {
                GL20.glDeleteProgram((int)this.I_field_49);
            }
        }
        catch (Throwable throwable) {
        }
        finally {
            GLFW.glfwMakeContextCurrent((long)l);
            if (this.i_field_418a15a2 != null) {
                GL.setCapabilities((GLCapabilities)this.i_field_418a15a2);
            }
        }
        GLFW.glfwDestroyWindow((long)this.I_field_4a);
        this.I_field_4a = 0L;
        this.i_field_49 = 0;
        this.II_field_49 = 0;
        this.I_field_49 = 0;
        this.I_field_5a = false;
        this.iI_field_49 = Integer.MIN_VALUE;
        this.ii_field_49 = Integer.MIN_VALUE;
        this.III_field_49 = -1;
        this.IIi_field_49 = -1;
    }
}

