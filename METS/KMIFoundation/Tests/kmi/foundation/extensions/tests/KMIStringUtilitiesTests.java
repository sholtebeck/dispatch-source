package kmi.foundation.extensions.tests;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.math.BigInteger;

import junit.framework.Assert;
import kmi.foundation.extensions.KMIStringUtilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import er.extensions.crypting.ERXCryptoString;


public class KMIStringUtilitiesTests {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testBaseSixtyFourBitDecoder() {
		try {
			String stringToEncode = new String("Johnny");
			String encodedString = KMIStringUtilities.baseSixtyFourBitEncoder(stringToEncode.getBytes());
			String decodedString = KMIStringUtilities.baseSixtyFourBitDecoder(encodedString);
			Assert.assertEquals(stringToEncode, decodedString);
		} catch(IOException e) {
			fail("IOException");
		}
	}

	@Test
	public void testCreditCardEncryptionDecryption() {
		
		try {

			// GOING TO USE BLOWFISH http://en.wikipedia.org/wiki/Blowfish_(cipher)
			System.setProperty("er.extensions.ERXBlowfishCipherKey", "DefaultBlowfishCipherKey");
			
			String creditCardNumber = "5424000000000015";
			String passphrase = "Hawaii Executive Transportation";

			// CREATE SIXTY FOUR BIT HASH FROM PASSPHRASE
			String pin = KMIStringUtilities.sixtyFourBitHash(passphrase);

			// MULTIPLY CREDIT CARD NUMBER WITH PIN
			BigInteger bi1 = new BigInteger(creditCardNumber);
			BigInteger bi2 = new BigInteger(pin);
			bi1 = bi1.multiply(bi2);

			// STRING WE ARE GOING TO ENCRYPT
			String secretString = bi1.toString();

			// FIRST STEP OF ENCODING - ENCODE TO SIXTY FOUR BIT 
			String encodedString = KMIStringUtilities.baseSixtyFourBitEncoder(secretString.getBytes());

			// SECOND STEP ENCRYPT STRING
			ERXCryptoString encrypter = new ERXCryptoString(encodedString);
			String encryptedString = encrypter.toCryptoString();
			
			// START REVERSE
			// DECRYPT STRING
			ERXCryptoString decrypter = ERXCryptoString.createInstanceFromCryptoString(encryptedString);
			String decryptedString = decrypter.toString();
			
			// DECODE TO SIXTY FOUR BIT -- THIS VALUE IS USELESS WITHOUT PIN
			String decodedString = KMIStringUtilities.baseSixtyFourBitDecoder(decryptedString);

			// DIVIDE WITH PIN
			BigInteger bi3 = new BigInteger(decodedString);
			bi3 = bi3.divide(bi2);
			
			String noSoSecretAnymoreString = bi3.toString();

			Assert.assertEquals(creditCardNumber, noSoSecretAnymoreString);
			
		} catch(IOException e) {
			fail("IOException");
		}
		
		
		
	}
	
}
