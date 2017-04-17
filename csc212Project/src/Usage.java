// This class represents usage data at the sequence or sequence set level.
public class Usage {
	// Constructor.
	public LinkedList<Pair<String, Integer>> pList;
	
	public Usage(){
		pList = new LinkedList<Pair<String, Integer>>();
	}


	// Add a kmer with the corresponding number of occurrences. 
	public void add(String kmer, int count){
		Pair<String, Integer> p = new Pair<String, Integer>(kmer, count);
		pList.insert(p);
		
	}
	
	// Return the number of occurrences of kmer.
	public int getCount(String kmer){
		pList.findFirst();
		while(!pList.last()){
			if(pList.retrieve().first.equals(kmer))
				return pList.retrieve().second ;
			pList.findFirst();
		}
		if(pList.retrieve().first.equals(kmer))
			return pList.retrieve().second ;
		return 0 ;
	}
	
	
	// Return all kmers with their count.
	public LinkedList<Pair<String, Integer>> getCounts(){
		return pList;
	}
}