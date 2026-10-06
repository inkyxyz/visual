package rockstar.client;

import java.awt.Container;
import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.JFrame;
import rockstar.client.IIIiiII_Class13;
import rockstar.client.IiiIiIi_Class54;
import rockstar.client.IiiIiiI_Class55;
import rockstar.client.IiiiIIi_Class58;
import rockstar.client.IiiiIiI_Class59;
import rockstar.client.Iiiiiii_Class64;
import rockstar.client.iIIIII_Class33;
import rockstar.client.iIIIiI_Class35;

public class iIIIIiI_Class67
extends Iiiiiii_Class64 {
    private final Consumer<JFrame> I_field_f9f609fa;
    private final Consumer<JFrame> i_field_f9f609fa;
    private final int I_field_49;

    public iIIIIiI_Class67(iIIIII_Class33 iIIIII_Class332, IiiIiiI_Class55 iiiIiiI_Class55) {
        this(iIIIII_Class332, iiiIiiI_Class55, jFrame -> jFrame.setVisible(true), Window::dispose);
    }

    public iIIIIiI_Class67(iIIIII_Class33 iIIIII_Class332, IiiIiiI_Class55 iiiIiiI_Class55, Consumer<JFrame> consumer, Consumer<JFrame> consumer2) {
        this(iIIIII_Class332, iiiIiiI_Class55, consumer, consumer2, 300000);
    }

    public iIIIIiI_Class67(iIIIII_Class33 iIIIII_Class332, IiiIiiI_Class55 iiiIiiI_Class55, Consumer<JFrame> consumer, Consumer<JFrame> consumer2, int n) {
        super(iIIIII_Class332, iiiIiiI_Class55);
        this.I_field_f9f609fa = consumer;
        this.i_field_f9f609fa = consumer2;
        this.I_field_49 = n;
    }

    @Override
    public IiiiIIi_Class58 I_method_a2a3535() throws IOException, InterruptedException, TimeoutException {
        URL uRL = IIIiiII_Class13.i_method_6e1bdf1f(this.I_field_c50937ec.I_method_37e8d915().i_method_e3089621()).I_method_1c698690().I_method_3c2cdd7c(this.I_field_c50937ec.I_method_15b03494()).I_method_e8ddf150().I_method_56a838d6();
        final CompletableFuture completableFuture = new CompletableFuture();
        JFXPanel jFXPanel = new JFXPanel();
        JFrame jFrame = new JFrame("MinecraftAuth - Microsoft Login");
        jFrame.setDefaultCloseOperation(0);
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setResizable(false);
        jFrame.setContentPane((Container)jFXPanel);
        jFrame.addWindowListener(new WindowAdapter(){

            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (!completableFuture.isDone()) {
                    completableFuture.completeExceptionally(new Nested1_3d7701e0());
                }
            }
        });
        Platform.runLater(() -> {
            WebView webView = new WebView();
            webView.setContextMenuEnabled(false);
            this.I_field_20717641.I_method_a5598def("User-Agent").ifPresent(arg_0 -> ((WebEngine)webView.getEngine()).setUserAgent(arg_0));
            webView.getEngine().load(uRL.toString());
            webView.getEngine().locationProperty().addListener((observableValue, string, string2) -> {
                try {
                    IIIiiII_Class13.Nested1_ed389a00 nested1_ed389a00 = IIIiiII_Class13.II_method_3a54c182(string2).I_method_1c698690();
                    Optional<String> optional = nested1_ed389a00.I_method_d9c92b41("error");
                    Optional<String> optional2 = nested1_ed389a00.I_method_d9c92b41("error_description");
                    if (optional.isPresent() && optional2.isPresent()) {
                        iIIIiI_Class35 iIIIiI_Class352 = new iIIIiI_Class35(null, 500, new byte[0], Collections.emptyMap());
                        throw new IiiIiIi_Class54(iIIIiI_Class352, optional.get(), optional2.get());
                    }
                    nested1_ed389a00.I_method_d9c92b41("code").ifPresent(completableFuture::complete);
                }
                catch (Throwable throwable) {
                    completableFuture.completeExceptionally(throwable);
                }
            });
            jFXPanel.setScene(new Scene((Parent)webView, (double)jFrame.getWidth(), (double)jFrame.getHeight()));
            this.I_field_f9f609fa.accept(jFrame);
        });
        try {
            String string = (String)completableFuture.get(this.I_field_49, TimeUnit.MILLISECONDS);
            IiiiIIi_Class58 iiiiIIi_Class58 = (IiiiIIi_Class58)this.I_field_20717641.I_method_fc2df765(new IiiiIiI_Class59(this.I_field_c50937ec, string));
            return iiiiIIi_Class58;
        }
        catch (TimeoutException timeoutException) {
            throw new TimeoutException("Login timed out");
        }
        catch (ExecutionException executionException) {
            if (executionException.getCause() instanceof RuntimeException) {
                throw (RuntimeException)executionException.getCause();
            }
            throw new RuntimeException(executionException);
        }
        finally {
            this.i_field_f9f609fa.accept(jFrame);
        }
    }

    public static class Nested1_3d7701e0
    extends RuntimeException {
        public Nested1_3d7701e0() {
            super("User closed the login window");
        }
    }
}

