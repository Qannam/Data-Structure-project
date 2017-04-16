
public class Sequence {
	private String header ;
	private String seq ;
	
	public Sequence(String header, String seq){
		this.header = header ;
		this.seq = seq ;
	}
	public String getHeader() {
		return header;
	}
	public String getSeq() {
		return seq;
	}
	// Return the usage for word length k and window step size w.
	public Usage getUsage(int k, int w){
		LinkedList<String> kmersList = new LinkedList<String>();
		String seq1 = seq;
		/*calculate the absolute deference between k and w to ignore the not complete kmer */
		int deference ;
		if(k > w)
			deference = k - w ;
		else
			deference = w - k ;
		/*calculate and insert kmers*/
		for(int i= 0; i < seq1.length() - deference ; i+=w){
			String kmer = "" ;
			for(int j = i ; j < i+k ; j++){
				kmer += seq1.charAt(j);
			}
			kmersList.insert(kmer);
		}
		/* ============abdullah============= */
		Usage usage = new Usage() ;
		kmersList.findFirst();
		while(!kmersList.empty()){
			kmersList.findFirst();
			String current = kmersList.retrieve();
			int occurrence = 1 ;
			kmersList.findFirst();
			/* calculate occurrences and delete it except first one */
			while(!kmersList.last()){
				if(kmersList.retrieve().equals(current)){
					occurrence++ ;
					kmersList.remove();
				}
				else{
					kmersList.findNext();
				}
			}
			/* add the kmers with occurrences to usage and delete it from kmersList */
			usage.add(current, occurrence);
			kmersList.findFirst();
			kmersList.remove();
		}
		return usage ;
	}	
}
