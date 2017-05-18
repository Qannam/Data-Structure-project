
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
		Usage usage = new Usage() ;
		/*calculate the absolute deference between k and w to ignore the not complete kmers */
		String kmer;
		
			/*calculate and insert kmers*/
			
				for(int i= 0; seq1.length()-i >= k ; i+=w){
					kmer = "" ;
					for(int j = i ; j < i+k ; j++){
						kmer += seq1.charAt(j);
					}
					usage.add(kmer, 1);
					//kmersList.insert(kmer);
					
				}
				
//				kmersList.findFirst();
//				while(!kmersList.last()){
//					 System.out.println("kemr = "+kmersList.retrieve() );
//				 kmersList.findNext();
//				}
//				 System.out.println("kemr = "+kmersList.retrieve() );
//				 System.out.println("===========================");
			
		
		/* ========================== */
//		Usage usage = new Usage() ;
//		kmersList.findFirst();
//		String current;
//		while(!kmersList.empty()){
			
//			kmersList.findFirst();
//			current = kmersList.retrieve();
//			int occurrence = 1 ;
//			//kmersList.findFirst();
//			/* calculate occurrences and delete it except first one */
//			int flag = 0 ;
//			while(!kmersList.last()){
//				if(kmersList.retrieve().equals(current) && !(flag == 0)){
//					occurrence++ ;
//					kmersList.remove();
//					flag++;
//				}
//				else{
//					kmersList.findNext();
//					flag++;
//				}
//			}
//			/* last step */
//			if(kmersList.retrieve().equals(current) && !(flag == 0)){
//				occurrence++ ;
//				kmersList.remove();
//				flag++;
//			}
			/* add the kmers with occurrences to usage and delete it from kmersList */
//			usage.add(current, 1);
			//kmersList.findFirst();
//			kmersList.remove();
//		}
//		LinkedList<Pair<String, Integer>> actual = usage.pList;
//		actual.findFirst();
//		while(!actual.last()){
//		 System.out.println("kemr = "+actual.retrieve().first+" , count = "+actual.retrieve().second);
//		 actual.findNext();
//		}
//		 System.out.println("kemr = "+actual.retrieve().first+" , count = "+actual.retrieve().second);
//		 System.out.println("===========================");
		return usage ;
	}	
}
