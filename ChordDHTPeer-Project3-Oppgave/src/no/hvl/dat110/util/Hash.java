package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	public static BigInteger hashOf(String entity) {		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		// compute the hash of the input 'entity'
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		// return the BigInteger

		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] dig = messageDigest.digest(entity.getBytes(StandardCharsets.UTF_8));
			StringBuffer stringBuffer = new StringBuffer();
			for (int i = 0; i < dig.length; i++){
				stringBuffer.append(byteToHex(dig[i]));
			}
			String hashvalue = stringBuffer.toString();
			hashint = new BigInteger(hashvalue, 16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}


		return hashint;
	}

	public static String byteToHex(byte a){
		char[] hexdigits = new char[2];
		hexdigits[0] = Character.forDigit((a >> 4) & 0xf, 16);
		hexdigits[1] = Character.forDigit((a & 0xf), 16);
		return new String(hexdigits);
	}

	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// get the digest length
		
		// compute the number of bits = digest length * 8
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		return null;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
