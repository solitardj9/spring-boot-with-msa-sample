package com.solitardj9.msa.utils.securityUtils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionUtil {
	
	public static String sha256(String msg) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(msg.getBytes());
		
		return bytesToHex(md.digest());
	}
	
	private static String bytesToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b: bytes) {
			builder.append(String.format("%02x", b));
		}
		return builder.toString();
	}
}