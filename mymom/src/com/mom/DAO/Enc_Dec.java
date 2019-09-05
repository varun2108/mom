package com.mom.DAO;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Enc_Dec {
	//use: encripted_password=Enc_Dec.encode(normalPassword);
	public static String encode(String pass){
		Base64.Encoder encoder=Base64.getEncoder();
		String normalString=pass;
		String encodedString = encoder.encodeToString(normalString.getBytes(StandardCharsets.UTF_8));
		return encodedString;
	}
	//use: encripted_password=Enc_Dec.decode(normalPassword);
	public static String decode(String pass){
		Base64.Decoder decoder=Base64.getDecoder();
		String decodedString=pass;
		byte[] decodedByteArray = decoder.decode(decodedString);
		return decodedByteArray.toString();
	}
}
