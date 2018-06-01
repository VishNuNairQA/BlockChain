package ReleaseOne;

import java.security.NoSuchAlgorithmException;

public class MainNet {
	
	public static void main(String[] args) throws NoSuchAlgorithmException{
		
		BlockChain bc = new BlockChain();
		
		Block a = new Block("0x200", new java.util.Date(), "Transaction 02");
		Block b = new Block("0x221", new java.util.Date(), "Transaction 03");
		Block c = new Block("0x233", new java.util.Date(), "Transaction 04");
		
		bc.addBlock(a);
		bc.addBlock(b);
		bc.addBlock(c);
		
		bc.display();
		
	}

}
