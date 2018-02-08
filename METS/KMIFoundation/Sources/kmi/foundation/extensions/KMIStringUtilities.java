package kmi.foundation.extensions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.Normalizer;
import java.text.Normalizer.Form;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Random;
import java.util.StringTokenizer;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import com.webobjects.foundation.NSForwardException;
import com.webobjects.foundation.NSTimestamp;

import er.extensions.foundation.ERXStringUtilities;

public class KMIStringUtilities extends ERXStringUtilities {


	public static final String ERROR_STRING_DIVIDER = "--------------------------------------------------";

	public static boolean isValidEmail(String emailAddress) {
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(".+@.+\\.[a-z]+");
		java.util.regex.Matcher m = p.matcher(emailAddress);
		return m.matches();
	}

	public static boolean isValidUrl(String aUrl) {
		boolean isValidUrl = true;
		try {
			@SuppressWarnings("unused")
			URL url = new URL(aUrl);
		} catch (MalformedURLException e) {
			isValidUrl = false;
		}	     
		return isValidUrl;
	}

	public static boolean checkIPAddress(String ipAddress) {
		String[] parts = ipAddress.split( "\\." );
		if ( parts.length != 4 ) {
			return false;
		}

		for ( String s : parts ) {
			int i = Integer.parseInt( s );
			if ( (i < 0) || (i > 255) )
			{
				return false;
			}
		}

		return true;
	}	

	public static int randomIntegerWithinRange(int aStart, int aEnd){

		Random aRandom = new Random();

		if ( aStart > aEnd ) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}

		//get the range, casting to long to avoid overflow problems
		long range = (long)aEnd - (long)aStart + 1;
		// compute a fraction of the range, 0 <= frac < range

		long fraction = (long)(range * aRandom.nextDouble());
		return (int)(fraction + aStart);    

	}	

	/*
	 * @param String
	 * @return an encrypted string
	 */
	public static String digestedStringSHA(String aValue) {

		String digestedString;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.reset();
			digestedString = new sun.misc.BASE64Encoder().encode(md.digest(aValue.getBytes()));
		} catch(NoSuchAlgorithmException e) {
			throw new NSForwardException(e);
		}

		return digestedString;

	}

	/*
	 * @param String
	 * @return an encrypted string
	 */
	public static String digestedStringSHA256(String aValue) {

		String digestedString;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.reset();
			digestedString = new sun.misc.BASE64Encoder().encode(md.digest(aValue.getBytes("UTF-8")));
		} catch(NoSuchAlgorithmException e) {
			throw new NSForwardException(e);
		} catch (UnsupportedEncodingException e) {
			throw new NSForwardException(e);
		}

		return digestedString;

	}

	public static String hostFromUrl(String address) {
	
		String host = null;
		
		try {
			URL url = new URL(address);
			host = url.getHost();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return host;		
	
	}

	public static String pathFromUrl(String address) {
		
		String path = null;
		
		try {
			URL url = new URL(address);
			path = url.getPath();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;		
	
	}

	
	public static String formattedDate(NSTimestamp date, String pattern) {
		return null != date ?  new SimpleDateFormat(pattern).format(date.getTime()) : "";
	}

	public static boolean isAlphaNumeric(final String s) {
		final char[] chars = s.toCharArray();
		for (int x = 0; x < chars.length; x++) {      
			final char c = chars[x];
			if ((c >= 'a') && (c <= 'z')) continue; // lowercase
			if ((c >= 'A') && (c <= 'Z')) continue; // uppercase
			if ((c >= '0') && (c <= '9')) continue; // numeric
			return false;
		}  

		return true;
	}

	public static String toPrettyURL(String string) {
	    return Normalizer.normalize(string.toLowerCase(), Form.NFD)
	        .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
	        .replaceAll("[^\\p{Alnum}]+", "_");
	}	
	
	public static HashMap<String, Object> queryParametersFromURL(String value) throws MalformedURLException {

		HashMap<String, Object> map = new HashMap<String, Object>();
		URL url = new URL(value);
		String queryParamters = url.getQuery();
		String[] params = queryParamters.split("&");
		for(String param : params) {
			map.put(param.split("=")[0], param.split("=")[1]);
		}
		return map;

	}

	public static String randomString(int length) {
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		char[] chars = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 
				'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4',
				'5', '6', '7', '8', '9'};
		for ( int i = 0; i < length; i++ ) {
			buffer.append(chars[random.nextInt(chars.length)]);
		}
		return buffer.toString();
	}	

	public static String removeSpaces(String s, String replace) {
		StringTokenizer st = new StringTokenizer(s," ",false);
		String t="";
		while (st.hasMoreTokens()) {
			t += st.nextToken();
			if(!stringIsNullOrEmpty(replace) && st.hasMoreTokens()) {
				t+=replace;
			}
		}
		return t;
	}	

	public static String replaceSpaces(String s, String replace) {
		StringTokenizer st = new StringTokenizer(s, replace, false);
		String t = "";
		while(st.hasMoreTokens()) {
			t += st.nextToken();
			if(st.hasMoreTokens()) {
				t+= " ";
			}
		}
		return t;
	}	

	public static String shortenedStringToWordCount(String aString, int wordCount) {

		StringBuilder shortenedStringBuilder = new StringBuilder();
		if(ERXStringUtilities.stringIsNullOrEmpty(aString) == false) {

			String[] words = aString.split(" ");
			
			if(words.length > wordCount) {
			
				for(int i = 0; i <= wordCount; i++) {
					shortenedStringBuilder.append(words[i]);
					shortenedStringBuilder.append(" ");
				}

			} else {
				shortenedStringBuilder.append(aString);
			}
			
		}
		
		return shortenedStringBuilder.toString();

	}
	
	public static String sixtyFourBitHash(String str) {

		int hash = 0x811c9dc5;
		for(char c : str.toCharArray()) {
			hash ^= 0xffff & c;
			hash *= 0x1000193;
		}
		return String.valueOf(0xffffffffL & (long)hash);

	}	

	public static String baseSixtyFourBitDecoder(String encodedBytes) throws IOException {
		BASE64Decoder decoder = new BASE64Decoder();
		return new String(decoder.decodeBuffer(encodedBytes));
	}
	
	public static String baseSixtyFourBitEncoder(byte[] value) {
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encodeBuffer(value);
	}
	
	public static String sixtyFourBitHashFromRandomStringWithLength(int length) {
		String hash = sixtyFourBitHash(KMIStringUtilities.randomString(255));
		if(hash.length() > length) {
			hash = hash.substring(0, length);
		}
		return hash;
	}

	public static String stackTraceToString(Exception e) {
		StringWriter sw = new StringWriter();
		e.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

	public static String stackTraceToString(Throwable t) {
		StringWriter sw = new StringWriter();
		t.printStackTrace(new PrintWriter(sw));
		return sw.toString();
	}

	public static String stripNonNumericCharactersFromString(String string) {
		return string.replaceAll( "[^\\d]", "");
	}
	
	public static boolean stringIsNullorEmptyOrWONoSelectionString(String value) {
		return stringIsNullOrEmpty(value) || value.equals("WONoSelectionString");
	}
	
	public static String splitCamelCase(String s) {
		return s.replaceAll(
				String.format("%s|%s|%s",
						"(?<=[A-Z])(?=[A-Z][a-z])",
						"(?<=[^A-Z])(?=[A-Z])",
						"(?<=[A-Za-z])(?=[^A-Za-z])"
						),
						" "
				);
	}	
	
	private static String _stringWithWildCards(String string, boolean prepend, boolean append) {
		String stringWithWildCards = "";
		if(prepend) {
			stringWithWildCards = "*";
		}
		stringWithWildCards += string;
		if(append) {
			stringWithWildCards += "*";
		}
		return stringWithWildCards;
	}

	public static String stringWithWildCards(String string) {
		return _stringWithWildCards(string, true, true);
	}

	public static String stringWithPrependedWildCard(String string) {
		return _stringWithWildCards(string, true, false);
	}

	public static String stringWithAppenededWildCard(String string) {
		return _stringWithWildCards(string, false, true);
	}

	public static boolean isValidPhoneNumber(String value) {
		// TODO Auto-generated method stub
		return false;
	}

	public static final HashMap<String, String> defaultHtmlEntities() {
		HashMap<String, String> htmlEntities = new HashMap<String,String>();
	    htmlEntities.put("&lt;","<")    ; htmlEntities.put("&gt;",">");
	    htmlEntities.put("&amp;","&")   ; htmlEntities.put("&quot;","\"");
	    htmlEntities.put("&agrave;","�"); htmlEntities.put("&Agrave;","�");
	    htmlEntities.put("&acirc;","�") ; htmlEntities.put("&auml;","�");
	    htmlEntities.put("&Auml;","�")  ; htmlEntities.put("&Acirc;","�");
	    htmlEntities.put("&aring;","�") ; htmlEntities.put("&Aring;","�");
	    htmlEntities.put("&aelig;","�") ; htmlEntities.put("&AElig;","�" );
	    htmlEntities.put("&ccedil;","�"); htmlEntities.put("&Ccedil;","�");
	    htmlEntities.put("&eacute;","�"); htmlEntities.put("&Eacute;","�" );
	    htmlEntities.put("&egrave;","�"); htmlEntities.put("&Egrave;","�");
	    htmlEntities.put("&ecirc;","�") ; htmlEntities.put("&Ecirc;","�");
	    htmlEntities.put("&euml;","�")  ; htmlEntities.put("&Euml;","�");
	    htmlEntities.put("&iuml;","�")  ; htmlEntities.put("&Iuml;","�");
	    htmlEntities.put("&ocirc;","�") ; htmlEntities.put("&Ocirc;","�");
	    htmlEntities.put("&ouml;","�")  ; htmlEntities.put("&Ouml;","�");
	    htmlEntities.put("&oslash;","�") ; htmlEntities.put("&Oslash;","�");
	    htmlEntities.put("&szlig;","�") ; htmlEntities.put("&ugrave;","�");
	    htmlEntities.put("&Ugrave;","�"); htmlEntities.put("&ucirc;","�");
	    htmlEntities.put("&Ucirc;","�") ; htmlEntities.put("&uuml;","�");
	    htmlEntities.put("&Uuml;","�")  ; htmlEntities.put("&nbsp;"," ");
	    htmlEntities.put("&copy;","\u00a9");
	    htmlEntities.put("&reg;","\u00ae");
	    htmlEntities.put("&euro;","\u20a0");
	    return htmlEntities;
	}

	public static final String unescapeHTML(String source, HashMap<String, String> htmlEntities) {
		if(htmlEntities == null) {
			htmlEntities = KMIStringUtilities.defaultHtmlEntities();
		}
		int i, j;

		boolean continueLoop;
		int skip = 0;
		do {
			continueLoop = false;
			i = source.indexOf("&", skip);
			if (i > -1) {
				j = source.indexOf(";", i);
				if (j > i) {
					String entityToLookFor = source.substring(i, j + 1);
					String value = (String) htmlEntities.get(entityToLookFor);
					if (value != null) {
						source = source.substring(0, i)
								+ value + source.substring(j + 1);
						continueLoop = true;
					}
					else if (value == null){
						skip = i+1;
						continueLoop = true;
					}
				}
			}
		} while (continueLoop);
		return source;
	}

	public static boolean firstCharacterIsVowel(String value) {
		boolean isVowel = false;
		String[] vowels = new String[]{"a", "e", "i", "o", "u"};
		for(String vowel : vowels) {
			if(value.substring(0, 1).toLowerCase().equals(vowel)) {
				isVowel = true;
				break;
			}
		}
		return isVowel;
	}

	public static String readFile(String path) throws IOException {
		FileInputStream stream = new FileInputStream(new File(path));
		try {
		    FileChannel fc = stream.getChannel();
		    MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
		    /* Instead of using default, pass in a decoder. */
		    return Charset.defaultCharset().decode(bb).toString();
		}
		finally {
			stream.close();
		}
	}

	public static String firstLetterOfEachWord(String aString) {
		StringBuffer result = new StringBuffer();
		for(String letter : aString.split("(?<=[\\S])[\\S]*\\s*")) {
			result.append(letter);
		}
		return result.toString();
	}	
	
	
}
