package ReleaseOne;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class hashAlgo {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub

		
		String str = "Hello World";
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		byte[] bytes = md.digest(str.getBytes());
		
		StringBuilder builder = new StringBuilder();
		
		for(byte b : bytes){
			
			String hex = Integer.toHexString(0xff & b);
			
			System.out.println(hex);
			
			builder.append(hex);
	
		}
		
		System.out.println(builder.toString());
	}

}
