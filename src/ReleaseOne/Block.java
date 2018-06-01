package ReleaseOne;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

public class Block {
	
	private String index;
	private String previousHash;
	private String hash;
	private Date timestamp;
	
	public void setIndex(String index) {
		this.index = index;
	}

	public void setPreviousHash(String previousHash) {
		this.previousHash = previousHash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

	public String getIndex() {
		return index;
	}

	public String getPreviousHash() {
		return previousHash;
	}

	public String getHash() {
		return hash;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getData() {
		return data;
	}

	public Block getBlock() {
		return block;
	}


	private String data;
	private Block block;
	
	public Block(String index, Date timestamp, String data) {

		this.index = index;
		this.timestamp = timestamp;
		this.data = data;
		try {
			hash = calculateHash();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public String calculateHash() throws NoSuchAlgorithmException {
		
		String str = "" + this.data + this.timestamp + this.index + this.previousHash;
		
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		
		byte[] bytes = md.digest(str.getBytes());
		
		StringBuilder builder = new StringBuilder();
		
		for(byte b : bytes){
			
			String hex = Integer.toHexString(0xff & b);
			
			System.out.println(hex);
			
			builder.append(hex);
		}
		
		System.out.println(builder.toString());
			
		return builder.toString();
		
	}
	
}
