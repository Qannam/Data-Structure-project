
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
		/*calculate the absolute deference between k and w to ignore the not complete kmers */
		int def = 0;
		String kmer;
		if(k>w)
			def = k-w;
		else if(k==w)
			def = seq1.length()%k;
		else
			def = w-k;
			
			/*calculate and insert kmers*/
			try {
				for(int i= 0; i < seq1.length() - def ; i+=w){
					kmer = "" ;
					for(int j = i ; j < i+k ; j++){
						kmer += seq1.charAt(j);
					}
					kmersList.insert(kmer);
				}
			} catch (Exception e) {}
		
		/* ========================== */
		Usage usage = new Usage() ;
		kmersList.findFirst();
		String current;
		while(!kmersList.empty()){
			kmersList.findFirst();
			current = kmersList.retrieve();
			int occurrence = 1 ;
			kmersList.findFirst();
			/* calculate occurrences and delete it except first one */
			int flag = 0 ;
			while(!kmersList.last()){
				if(kmersList.retrieve().equals(current) && !(flag == 0)){
					occurrence++ ;
					kmersList.remove();
					flag++;
				}
				else{
					kmersList.findNext();
					flag++;
				}
			}
			/* last step */
			if(kmersList.retrieve().equals(current) && !(flag == 0)){
				occurrence++ ;
				kmersList.remove();
				flag++;
			}
			/* add the kmers with occurrences to usage and delete it from kmersList */
			usage.add(current, occurrence);
			kmersList.findFirst();
			kmersList.remove();
		}
		return usage ;
	}	
}
