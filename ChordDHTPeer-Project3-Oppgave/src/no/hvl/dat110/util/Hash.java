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
	private static int digestLength;
	public static BigInteger hashOf(String entity) {		
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		
		// we use MD5 with 128 bits digest
		
		// compute the hash of the input 'entity'
		
		// convert the hash into hex format
		
		// convert the hex into BigInteger
		
		// return the BigInteger
		MessageDigest messageDigest = null;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		messageDigest.update(entity.getBytes(StandardCharsets.UTF_8));
		byte[] digest = messageDigest.digest();
		String hash = toHex(digest);
		hashint = new BigInteger(hash, 16);
		return hashint;
	}



	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// get the digest length
		
		// compute the number of bits = digest length * 8
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		try {
			digestLength = MessageDigest.getInstance("MD5").getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		BigInteger size = new BigInteger("2");
		return size.pow(digestLength*8);
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		try {
			digestLength = MessageDigest.getInstance("MD5").getDigestLength();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
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
