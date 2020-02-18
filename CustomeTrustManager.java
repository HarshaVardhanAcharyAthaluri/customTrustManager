import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
public class CustomeTrustManager implements X509TrustManager{
	public CustomeTrustManager() {
	      super();
	   } 
	  private X509TrustManager trustManagerForCertificate(InputStream in) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, UnrecoverableKeyException {
	        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
	        Certificate certificate = certificateFactory.generateCertificate(in);
	        KeyStore keyStore = newEmptyKeystore();
	        keyStore.setCertificateEntry("alias", certificate);

	        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
	        keyManagerFactory.init(keyStore, "password".toCharArray());

	        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
	        trustManagerFactory.init(keyStore);

	        return (X509TrustManager) trustManagerFactory.getTrustManagers()[0];
	    }
//	  private X509TrustManager acceptAllCertsTrustManager() {
//	        X509TrustManager[] trustManagers = {
//	                new X509TrustManager() {
//	                    @Override
//	                    public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
//
//	                    @Override
//	                    public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {}
//
//	                    @Override
//	                    public X509Certificate[] getAcceptedIssuers() {
//	                        return new X509Certificate[0];
//	                    }
//	                }
//	        };
//	        return trustManagers[0];
//	    }
    
	  private KeyStore newEmptyKeystore() throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {
	        KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
	        instance.load(null, "password".toCharArray());
	        return instance;
	    }
	  public void passcertificate(String cert) throws UnrecoverableKeyException, CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException, KeyManagementException {
		  SSLContext sslContext = SSLContext.getInstance("TLS");
		  X509TrustManager trustManager = trustManagerForCertificate(new ByteArrayInputStream(cert.getBytes()));
          sslContext.init(null, new TrustManager[] { trustManager }, null);
	  }
	@Override
	public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		
	}
	@Override
	public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
		
	}
	@Override
	public X509Certificate[] getAcceptedIssuers() {
		 return new X509Certificate[0];
	}
}
