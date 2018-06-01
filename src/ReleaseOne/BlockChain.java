package ReleaseOne;

import java.util.List;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class BlockChain {
	
	private List<Block> chain	;
	
	
	public BlockChain() throws NoSuchAlgorithmException{
		
		chain = new ArrayList<Block>();
		chain.add(genesisBlock());
	}


	private Block genesisBlock() throws NoSuchAlgorithmException {
		
		Block gB = new Block("0x200", new java.util.Date(), "Transaction 01");
		gB.setPreviousHash(null);
		gB.calculateHash();
		return gB;
	}
	
	public void addBlock(Block blk) throws NoSuchAlgorithmException{
		
		Block newBlock = blk;
		blk.setPreviousHash(chain.get(chain.size()-1).getHash());
		newBlock.calculateHash();
		this.chain.add(newBlock);
		
	}
	
	public Block getLatestBlock(){
		return this.chain.get(chain.size()-1);
	}
	
	public void display(){
		
		for(int i=0; i<chain.size(); i++){
			
			System.out.println("Block:" +i);
			System.out.println("Index: " +chain.get(i).getIndex());
			System.out.println("Data: " +chain.get(i).getData());
			System.out.println("TimeStamp: " +chain.get(i).getTimestamp());
			System.out.println("Previous Hash: " +chain.get(i).getPreviousHash());
			System.out.println("Current Hash: " +chain.get(i).getHash());
			
		}
	}
	
	public void isValid(){
	}

}
