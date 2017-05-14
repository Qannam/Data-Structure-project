// This class represents usage data at the sequence or sequence set level.
public class Usage {
	// Constructor.
	public LinkedList<Pair<String, Integer>> pList;
	
	public Usage(){
		pList = new LinkedList<Pair<String, Integer>>();
	}


	// Add a kmer with the corresponding number of occurrences. 
	public void add(String kmer, int count){
		if(getCount(kmer) == 0 || pList.empty()){
			pList.insert(new Pair<String, Integer>(kmer, count));
		}
		else{
			pList.findFirst();
			while(!pList.last()){
				if(pList.retrieve().first.equals(kmer)){
					int x = pList.retrieve().second;
					pList.update(new Pair<String, Integer>(kmer, count+x));
					return;
				}
				pList.findNext();
			}
			if(pList.retrieve().first.equals(kmer)){
				int x = pList.retrieve().second;
				pList.update(new Pair<String, Integer>(kmer, count+x));
			}
		}
	}
	
	// Return the number of occurrences of kmer.
	public int getCount(String kmer){
		if(pList.empty())
			return 0;
		pList.findFirst();
		while(!pList.last()){
			if(pList.retrieve().first.equals(kmer))
				return pList.retrieve().second ;
			pList.findNext();
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