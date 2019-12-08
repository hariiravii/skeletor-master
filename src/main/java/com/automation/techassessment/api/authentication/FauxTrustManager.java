package com.automation.techassessment.api.authentication;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * This class should never be used as part of production code. It defines a trust manager which trusts all certificates.
 */
public class FauxTrustManager implements X509TrustManager {
    @Override public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException { }

    @Override public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException { }

    @Override public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}

