package br.ifpe.casamentoweb.utils;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class SenhaUtil {

	public static String gerarSal() throws NoSuchAlgorithmException {
		SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
		
		byte[] randomBytes = new byte[32];
		secureRandom.nextBytes(randomBytes);
		
		return Base64.getEncoder().encodeToString(randomBytes);
	}
}
