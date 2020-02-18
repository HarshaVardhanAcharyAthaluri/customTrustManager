import java.io.IOException;
import java.security.GeneralSecurityException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
public class Main {
	public static void main(String[] args) throws SQLException, IOException, GeneralSecurityException {

		SSLCheck ssltrust =  new SSLCheck();
ssltrust.passcertificate("-----BEGIN CERTIFICATE-----\r\n" + 
		"MIIERzCCAy+gAwIBAgIJAOe0rTZBwfmfMA0GCSqGSIb3DQEBCwUAMIGVMQswCQYD\r\n" + 
		"VQQGEwJJTjELMAkGA1UECAwCVFMxDDAKBgNVBAcMA0hZRDETMBEGA1UECgwKR0Ug\r\n" + 
		"RGlnaXRhbDELMAkGA1UECwwCSVQxIjAgBgNVBAMMGVBST0NfQ09NTU9OLmh0Y2xh\r\n" + 
		"Yi5nZS5jb20xJTAjBgkqhkiG9w0BCQEWFmF0aGFsdXJpLmhhcnNoYUBnZS5jb20w\r\n" + 
		"HhcNMjAwMjE3MTQwMTI5WhcNMjEwNzAxMTQwMTI5WjCBlTELMAkGA1UEBhMCSU4x\r\n" + 
		"CzAJBgNVBAgMAlRTMQwwCgYDVQQHDANIWUQxEzARBgNVBAoMCkdFIERJZ2l0YWwx\r\n" + 
		"CzAJBgNVBAsMAklUMSIwIAYDVQQDDBlQUk9DX0NPTU1PTi5odGNsYWIuZ2UuY29t\r\n" + 
		"MSUwIwYJKoZIhvcNAQkBFhZhdGhhbHVyaS5oYXJzaGFAZ2UuY29tMIIBIjANBgkq\r\n" + 
		"hkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5sLQqoSxjIw+LxgL8v0kknknxoBd1cjw\r\n" + 
		"WhZEUzBZiCEPRlBow9eujqRYmEdgUmzLh8t1AJYkqrgC1HslkWHEU4IZN8pTF3j6\r\n" + 
		"igTw1Oi2nzFBIRuTt7M2WjQPmrwZu/hOEixKIXqDwvhDWKh72+hnc68jd4nAqx/t\r\n" + 
		"nmT5zKKh38l1sA+HFHtAxUhGH/1SiHMbvh8noME1E7DZvXo/sryyqjGV/dlLBHUN\r\n" + 
		"QGdBAhO+AXrMriUj72GHx0LyBKe8hYwsoA0iN3fgUdD1afOAg2oKjeC5YYZsku5v\r\n" + 
		"YjTosVhoam8nBvmgvMYS2FaalG0HNrMUeVsq9e03/vJRJJDrcSGFRQIDAQABo4GX\r\n" + 
		"MIGUMB8GA1UdIwQYMBaAFNJ+yxFmJdlLQo8lyel120m78d2XMAkGA1UdEwQCMAAw\r\n" + 
		"CwYDVR0PBAQDAgTwMFkGA1UdEQRSMFCCGVBST0NfQ09NTU9OLmh0Y2xhYi5nZS5j\r\n" + 
		"b22CHlBST0NfQ09NTU9OLmh0Y2xhYi5nZS5jb206MTQzM4ITMTAuMTgxLjIxMy4x\r\n" + 
		"MTQ6MTQzMzANBgkqhkiG9w0BAQsFAAOCAQEAOvw8y2MnQC28MKwveSdn4QO3a8p8\r\n" + 
		"/uuG1LhtGBSAwc8ziLrVeRtgql+I0O39oXQMZvKDhp+XZ3yERN8dcymoFiIMw6Bu\r\n" + 
		"rWLAdyP/imZwXFqgHnCkMZdpUkPCX7SAcuLSuNGY62m3gqxu5hU9h5onFkAfVMlN\r\n" + 
		"yn4Bz8AiAutQ7hWL/3muWqc4xov+0pXnZIWmjV1XuEjnBc1iyZQbN4QHsv1VlsYc\r\n" + 
		"i4Qj9YA2v4qYdgGEUtYJndZVcvmL41SwDduqbPK0a6J5OVSOeaUVfMnh2ezlh/n3\r\n" + 
		"hLwfzd1+pJlY+tb7p+ac9+2oOLhckAvg4pK9MaOXSDvTKZNcD4tl1LrQ+g==\r\n" + 
		"-----END CERTIFICATE-----\r\n" + 
		"");
		String url = "jdbc:sqlserver://10.181.213.114:1433;DatabaseName=" + ";trustManagerClass=" +SSLCheck.class.getName()
                 + ";encrypt=true;"+"trustServerCertificate=false;";
		//String url = "jdbc:sqlserver://10.181.213.114:1433;DatabaseName=;encrypt=true;trustServerCertificate=false";
		Connection con = DriverManager.getConnection(url, "sa", "Gei321ipc");
		if (con != null) {
			DatabaseMetaData dm = (DatabaseMetaData) con.getMetaData();
			System.out.println("Driver name: " + dm.getDriverName());
			System.out.println("Driver version: " + dm.getDriverVersion());
			System.out.println("Product name: " + dm.getDatabaseProductName());
			System.out.println("Product version: " + dm.getDatabaseProductVersion());
		}

	}
}
