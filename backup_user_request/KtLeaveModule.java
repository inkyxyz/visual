package rockstar.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.c2s.common.KeepAliveC2SPacket;
import net.minecraft.network.packet.c2s.play.PlayerMoveC2SPacket;
import net.minecraft.util.math.Vec3d;
import pyrock.events.game.WorldChangeEvent;
import pyrock.events.window.KeyPressEvent;
import pyrock.events.window.MouseEvent;
import rockstar.client.KeybindSetting;
import rockstar.client.ModeSetting;
import rockstar.client.IiIIIiII_Class69;
import rockstar.client.ModuleCategory;
import rockstar.client.ModuleInfo;
import rockstar.client.Module;
import ua.mintantileak.spk.Compile;

@ModuleInfo(name="KT Leave", category=ModuleCategory.OTHER)
public class KtLeaveModule
extends Module {
    private ModeSetting I_field_bbe33e6c;
    private ModeSetting.Nested1_42765c60 I_field_500d0627;
    private ModeSetting.Nested1_42765c60 i_field_500d0627;
    private ModeSetting.Nested1_42765c60 II_field_500d0627;
    private KeybindSetting I_field_ba20522c;
    private ServerSocket I_field_fe985f2;
    private ExecutorService I_field_331d0885 = Executors.newSingleThreadExecutor();
    boolean I_field_5a;
    private final IiIIIiII_Class69<WorldChangeEvent> I_field_3d936f41 = worldChangeEvent -> {
        if (this.I_field_500d0627.isSelected()) {
            this.toggle();
        }
    };
    private final IiIIIiII_Class69<KeyPressEvent> i_field_3d936f41 = keyPressEvent -> this.I_method_e2f802df(keyPressEvent.getKey(), keyPressEvent.getAction());
    private final IiIIIiII_Class69<MouseEvent> II_field_3d936f41 = mouseEvent -> this.I_method_e2f802df(mouseEvent.getButton(), mouseEvent.getAction());

    public KtLeaveModule() {
        this.Iii_method_e69a0a9f();
    }

    @Compile(obfuscation=4)
    private void Iii_method_e69a0a9f() {
        this.I_field_bbe33e6c = new ModeSetting(this, "\u0420\u0435\u0436\u0438\u043c");
        this.I_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "HW Classic");
        this.i_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "\u041e\u0441\u043d\u043e\u0432\u043d\u043e\u0439");
        this.II_field_500d0627 = new ModeSetting.Nested1_42765c60(this.I_field_bbe33e6c, "\u0414\u043e\u043f\u043e\u043b\u043d\u0438\u0442\u0435\u043b\u044c\u043d\u044b\u0439");
        this.I_field_ba20522c = new KeybindSetting(this, "\u041a\u043d\u043e\u043f\u043a\u0430 \u043b\u0438\u0432\u0430", () -> this.II_field_500d0627.isSelected() || this.I_field_500d0627.isSelected());
    }

    @Override
    public void II_method_6642fd22() {
        if (this.I_field_500d0627.isSelected()) {
            if (KtLeaveModule.I_field_3a9bda27.player == null || KtLeaveModule.I_field_3a9bda27.world == null || KtLeaveModule.I_field_3a9bda27.player.networkHandler == null) {
                return;
            }
            for (int i = 0; i < 41; ++i) {
                KtLeaveModule.I_field_3a9bda27.player.setSneaking(true);
                Vec3d vec3d = KtLeaveModule.I_field_3a9bda27.player.getPos().add((double)i, 0.0, (double)i);
                KtLeaveModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new PlayerMoveC2SPacket.PositionAndOnGround(vec3d.x, vec3d.y, vec3d.z, Math.random() > 0.5, KtLeaveModule.I_field_3a9bda27.player.horizontalCollision));
                KtLeaveModule.I_field_3a9bda27.player.networkHandler.sendPacket((Packet)new KeepAliveC2SPacket((long)((int)(Math.random() * 8.0))));
            }
        }
        if (!this.II_field_500d0627.isSelected()) {
            return;
        }
        if (this.I_field_5a) {
            this.IiI_method_e68b7ebf();
            this.I_field_5a = false;
        }
        this.I_field_331d0885.submit(() -> {
            try {
                Socket socket = this.I_field_fe985f2.accept();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String string = bufferedReader.readLine();
                if (string != null) {
                    this.I_field_5a = true;
                }
                socket.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        });
    }

    private void I_method_e2f802df(int n, int n2) {
        if (KtLeaveModule.I_field_3a9bda27.currentScreen == null && n2 == 1 && this.i_field_500d0627.isSelected() && this.I_field_ba20522c.I_method_51ee2d08(n)) {
            try {
                Socket socket = new Socket("localhost", 1524);
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
                printWriter.println("SIGNAL");
                socket.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    public void IiI_method_e68b7ebf() {
        if (KtLeaveModule.I_field_3a9bda27.player == null || KtLeaveModule.I_field_3a9bda27.world == null) {
            return;
        }
        I_field_3a9bda27.doItemUse();
    }

    @Override
    public void onDisable() {
        if (this.II_field_500d0627.isSelected() && this.I_field_fe985f2 != null) {
            try {
                this.I_field_fe985f2.close();
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }

    @Override
    public void onEnable() {
        if (this.II_field_500d0627.isSelected()) {
            try {
                this.I_field_fe985f2 = new ServerSocket(1524);
            }
            catch (IOException iOException) {
                iOException.printStackTrace();
            }
        }
    }
}

