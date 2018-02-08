package kmi.foundation.extensions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.json.JSONArray;
import org.json.JSONException;

public class KMIJSONUtilities {

	

	/**
	 * @param url
	 * @return
	 * @throws IOException
	 * @throws JSONException
	 */
	public static JSONArray readJsonFromUrl(String url) throws IOException, JSONException {

		JSONArray json = null;
	    final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {

	    	@Override
	        public void checkClientTrusted( final X509Certificate[] chain, final String authType ) {
	        }
	        
	    	@Override
	        public void checkServerTrusted( final X509Certificate[] chain, final String authType ) {
	        }
	        
	    	@Override
	        public X509Certificate[] getAcceptedIssuers() {
	            return null;
	        }

	    } };
		
	    InputStream is = null;
		try {
		    SSLContext sslContext = SSLContext.getInstance( "SSL" );
		    sslContext.init( null, trustAllCerts, new java.security.SecureRandom() );
		    SSLSocketFactory sslSocketFactory = sslContext.getSocketFactory();
		    URLConnection urlCon = new URL( url ).openConnection();
		    ( (HttpsURLConnection) urlCon ).setSSLSocketFactory( sslSocketFactory );
		    is = urlCon.getInputStream();
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			json = new JSONArray(jsonText);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(is != null) {
				is.close();
			}
		}		
		return json;
	}
	
	
	
	private static String readAll(Reader rd) throws IOException {
		
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
	
		return sb.toString();

	}	
	
	
}
