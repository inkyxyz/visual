package rockstar.client;

import com.google.gson.JsonObject;
import globals.client.api.RockNetClient;
import globals.shared.proto.Packet;
import globals.shared.proto.Packets;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import net.minecraft.client.MinecraftClient;
import rockstar.client.IiIIIiii_Class72;
import rockstar.client.IiIIiIiI_Class75;
import rockstar.client.RockstarClient;

public class IiIIIiiI_Class71 {
    private static final long I_field_4a = 15L;
    private final AtomicBoolean I_field_1232aa16 = new AtomicBoolean(false);
    private final AtomicBoolean i_field_1232aa16 = new AtomicBoolean(false);
    private final AtomicBoolean II_field_1232aa16 = new AtomicBoolean(false);
    private volatile String I_field_523beb0a;
    private final ScheduledExecutorService I_field_47254ffa = Executors.newSingleThreadScheduledExecutor(runnable -> {
        Thread thread = new Thread(runnable, "ClientData-Autosave");
        thread.setDaemon(true);
        return thread;
    });

    public IiIIIiiI_Class71() {
        this.I_field_47254ffa.scheduleWithFixedDelay(this::iI_method_d5e98855, 15L, 15L, TimeUnit.SECONDS);
    }

    public void I_method_c4c6f4ac() {
        this.i_field_1232aa16.set(false);
        this.I_method_f4aa441b(new Packets.Nested1_a3fa6b7b());
    }

    public void I_method_3756b258(JsonObject jsonObject) {
        IiIIiIiI_Class75 iiIIiIiI_Class75 = this.I_method_77dc40b();
        if (jsonObject != null && jsonObject.size() > 0) {
            this.I_field_1232aa16.set(true);
            MinecraftClient.getInstance().execute(() -> {
                try {
                    if (iiIIiIiI_Class75 != null) {
                        IiIIiIiI_Class75.Nested1_a5b02cb3 nested1_a5b02cb3 = iiIIiIiI_Class75.I_method_43faa9a(jsonObject);
                        if (!nested1_a5b02cb3.i_method_b1b75acb()) {
                            iiIIiIiI_Class75.i_method_d67b8788(true);
                        }
                        if (nested1_a5b02cb3.I_method_b1a8ceeb() && !iiIIiIiI_Class75.I_method_512f38f0()) {
                            this.I_method_f4aa441b(new Packets.Nested1_a3fa125d(iiIIiIiI_Class75.i_method_7c462ef6()));
                        }
                        if (!iiIIiIiI_Class75.I_method_512f38f0()) {
                            this.I_field_523beb0a = iiIIiIiI_Class75.i_method_7c462ef6().toString();
                        }
                    }
                }
                catch (Exception exception) {
                    RockstarClient.I_field_ab0f6068.error("[ClientData] apply failed", (Throwable)exception);
                }
                finally {
                    this.I_field_1232aa16.set(false);
                }
            });
        } else if (this.II_field_1232aa16.compareAndSet(false, true) && iiIIiIiI_Class75 != null && !iiIIiIiI_Class75.I_method_512f38f0()) {
            this.ii_method_d5f81435();
            iiIIiIiI_Class75.i_method_d67b8788(true);
        }
        this.i_field_1232aa16.set(true);
    }

    private void iI_method_d5e98855() {
        if (!this.i_field_1232aa16.get() || this.I_field_1232aa16.get()) {
            return;
        }
        IiIIiIiI_Class75 iiIIiIiI_Class75 = this.I_method_77dc40b();
        if (iiIIiIiI_Class75 == null) {
            return;
        }
        if (iiIIiIiI_Class75.I_method_512f38f0()) {
            return;
        }
        JsonObject jsonObject = iiIIiIiI_Class75.i_method_7c462ef6();
        String string = jsonObject.toString();
        if (string.equals(this.I_field_523beb0a)) {
            return;
        }
        this.I_field_523beb0a = string;
        this.I_method_f4aa441b(new Packets.Nested1_a3fa125d(jsonObject));
    }

    public void i_method_c4d5808c() {
        if (!this.i_field_1232aa16.get() && !this.II_field_1232aa16.get()) {
            return;
        }
        this.ii_method_d5f81435();
    }

    public void II_method_d4269835() {
        IiIIiIiI_Class75 iiIIiIiI_Class75 = this.I_method_77dc40b();
        if (iiIIiIiI_Class75 == null) {
            return;
        }
        iiIIiIiI_Class75.II_method_d4c6dbf5();
        this.I_field_523beb0a = null;
    }

    private void ii_method_d5f81435() {
        if (this.I_field_1232aa16.get()) {
            return;
        }
        IiIIiIiI_Class75 iiIIiIiI_Class75 = this.I_method_77dc40b();
        if (iiIIiIiI_Class75 == null) {
            return;
        }
        if (iiIIiIiI_Class75.I_method_512f38f0()) {
            return;
        }
        JsonObject jsonObject = iiIIiIiI_Class75.i_method_7c462ef6();
        this.I_field_523beb0a = jsonObject.toString();
        this.I_method_f4aa441b(new Packets.Nested1_a3fa125d(jsonObject));
    }

    public void Ii_method_d4352415() {
        this.I_field_47254ffa.shutdownNow();
    }

    private IiIIiIiI_Class75 I_method_77dc40b() {
        IiIIIiii_Class72 iiIIIiii_Class72 = RockstarClient.getInstance().I_method_7a4c3f0b().I_method_3272b401("client");
        return iiIIIiii_Class72 instanceof IiIIiIiI_Class75 ? (IiIIiIiI_Class75)iiIIIiii_Class72 : null;
    }

    private void I_method_f4aa441b(Packet packet) {
        RockNetClient rockNetClient = RockstarClient.getInstance().I_method_cd3d46d0();
        if (rockNetClient != null) {
            rockNetClient.send(packet);
        }
    }
}

