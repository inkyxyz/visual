package rockstar.client;

import java.io.IOException;
import java.net.Socket;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509ExtendedTrustManager;

public class IIIiIIi_Class10
extends X509ExtendedTrustManager {
    public static SSLContext I_method_862f0695() throws IOException {
        try {
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new IIIiIIi_Class10()}, new SecureRandom());
            return sSLContext;
        }
        catch (Throwable throwable) {
            throw new IOException("Failed to create ignoring SSL socket factory", throwable);
        }
    }

    @Override
    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string, Socket socket) {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string, Socket socket) {
    }

    @Override
    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string, SSLEngine sSLEngine) {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string, SSLEngine sSLEngine) {
    }

    @Override
    public void checkClientTrusted(X509Certificate[] x509CertificateArray, String string) {
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509CertificateArray, String string) {
    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return null;
    }
}

