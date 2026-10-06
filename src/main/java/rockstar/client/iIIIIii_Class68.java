package rockstar.client;

import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;
import rockstar.client.IIIiiII_Class13;
import rockstar.client.IiiIiIi_Class54;
import rockstar.client.IiiIiiI_Class55;
import rockstar.client.IiiiIIi_Class58;
import rockstar.client.Iiiiiii_Class64;
import rockstar.client.iIIIII_Class33;
import rockstar.client.iIIIiI_Class35;

public class iIIIIii_Class68
extends Iiiiiii_Class64 {
    private final Consumer<URL> I_field_f9f609fa;
    private final int I_field_49;

    public iIIIIii_Class68(iIIIII_Class33 iIIIII_Class332, IiiIiiI_Class55 iiiIiiI_Class55, Consumer<URL> consumer) {
        this(iIIIII_Class332, iiiIiiI_Class55, consumer, 300000);
    }

    public iIIIIii_Class68(iIIIII_Class33 iIIIII_Class332, IiiIiiI_Class55 iiiIiiI_Class55, Consumer<URL> consumer, int n) {
        super(iIIIII_Class332, iiiIiiI_Class55);
        if (this.I_field_c50937ec.Ii_method_cbd5165e() == null) {
            throw new IllegalArgumentException("The application config must have a redirect uri set");
        }
        this.I_field_f9f609fa = consumer;
        this.I_field_49 = n;
    }

    /*
     * Exception decompiling
     */
    @Override
    public IiiiIIi_Class58 I_method_a2a3535() throws IOException, InterruptedException, TimeoutException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [3[CATCHBLOCK]], but top level block is 2[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static /* synthetic */ void I_method_7805f318(CompletableFuture completableFuture, HttpExchange httpExchange) throws IOException {
        try {
            IIIiiII_Class13.Nested1_ed389a00 nested1_ed389a00 = IIIiiII_Class13.I_method_35282557(httpExchange.getRequestURI()).I_method_1c698690();
            Optional<String> optional = nested1_ed389a00.I_method_d9c92b41("error");
            Optional<String> optional2 = nested1_ed389a00.I_method_d9c92b41("error_description");
            if (optional.isPresent() && optional2.isPresent()) {
                iIIIiI_Class35 iIIIiI_Class352 = new iIIIiI_Class35(null, 500, new byte[0], Collections.emptyMap());
                throw new IiiIiIi_Class54(iIIIiI_Class352, optional.get(), optional2.get());
            }
            Optional<String> optional3 = nested1_ed389a00.I_method_d9c92b41("code");
            if (!optional3.isPresent()) {
                throw new IllegalStateException("Failed to extract auth code from response url");
            }
            byte[] byArray = "You have been logged in! You can now close this window.".getBytes(StandardCharsets.UTF_8);
            httpExchange.sendResponseHeaders(200, byArray.length);
            httpExchange.getResponseBody().write(byArray);
            httpExchange.close();
            completableFuture.complete(optional3.get());
        }
        catch (Throwable throwable) {
            byte[] byArray = ("Login failed. Error message: " + throwable.getMessage()).getBytes(StandardCharsets.UTF_8);
            httpExchange.sendResponseHeaders(500, byArray.length);
            httpExchange.getResponseBody().write(byArray);
            httpExchange.close();
            completableFuture.completeExceptionally(throwable);
        }
    }
}

