import java.io.*;


//This class represents a set of sequences.
public class SequenceSet {
	 LinkedList<Sequence> seqList;// = new LinkedList<Sequence>() ;
	
	public SequenceSet(){
		seqList = new LinkedList<Sequence>() ;
	}
	public static SequenceSet load(String fileName){
		String header = null ;
		String seq = null;
		FileReader in;

		SequenceSet seq1 = new SequenceSet();
		try {
			in = new FileReader(fileName);
		    BufferedReader br = new BufferedReader(in);
		    String line = br.readLine();
		    int count = 0 ;
	
		    while (line!=null) {
		    	if(count++ % 2 == 0)
		        header = line ;
		    	else{
		    		seq = line ;
		    		Sequence s = new Sequence(header, seq);
		    		seq1.seqList.insert(s);
		    	}
		        line = br.readLine();	
	    }
	    in.close();
	    br.close();
	    } catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
		//seq1.seqList = seqList;
		return seq1;
	}
	
	public Usage getUsage(int k, int w){
		Usage usage = new Usage();
		
		seqList.findFirst();
		
		while(!seqList.last()){
			
			Usage seqUsage = seqList.retrieve().getUsage(k, w);
			
			seqUsage.pList.findFirst();
			
			while(!seqUsage.pList.last()){
				
				usage.add(seqUsage.pList.retrieve().first, seqUsage.pList.retrieve().second);
				
				seqUsage.pList.findNext();
				
			}
			usage.add(seqUsage.pList.retrieve().first, seqUsage.pList.retrieve().second); //last check
			
			
			seqList.findNext();
		}
		
		//last seqList check
		Usage seqUsage = seqList.retrieve().getUsage(k, w);
		
		seqUsage.pList.findFirst();
		
		while(!seqUsage.pList.last()){
			
			usage.add(seqUsage.pList.retrieve().first, seqUsage.pList.retrieve().second);
			
			seqUsage.pList.findNext();
			
		}
		usage.add(seqUsage.pList.retrieve().first, seqUsage.pList.retrieve().second); //last check
		
		
		
		
		
		return usage;
	}
	
	// Return the global usage over all sequences in the set. The word length is k and window step size is w.
//		public Usage getUsage(int k, int w){
//			if(seqList.empty())
//				return null;
//			Usage returnedUsage = new Usage();
//			seqList.findFirst();
//			Usage u = null ;
//			while(!seqList.last()){
//				Sequence seq = seqList.retrieve();
//				u = seq.getUsage(k, w);
//
//				u.pList.findFirst();
//				while(!u.pList.last()){
//					int count = u.pList.retrieve().second;
//					String kmer = u.pList.retrieve().first;
//					returnedUsage.add(kmer, count);
//					u.pList.findNext();
//				}
//				int count = u.pList.retrieve().second;
//				String kmer = u.pList.retrieve().first;
//				returnedUsage.add(kmer, count);				
//				seqList.findNext();
//			}
//			/* ==================== last step for "while(!seqList.last())"  ======================*/
//			Sequence seq = seqList.retrieve();
//			u = seq.getUsage(k, w);
//
//			u.pList.findFirst();
//			while(!u.pList.last()){
//				int count = u.pList.retrieve().second;
//				String kmer = u.pList.retrieve().first;
//				returnedUsage.add(kmer, count);
//				u.pList.findNext();
//			}
//			int count = u.pList.retrieve().second;
//			String kmer = u.pList.retrieve().first;
//			returnedUsage.add(kmer, count);				
//			
//			
//			/* filter from the kmers that repeated */
////			returnedUsage.pList.findFirst();
////			Pair<String,Integer> current;
////			int flag = 0;
////			LinkedList<Pair<String,Integer>> newReturnedList = new LinkedList<Pair<String,Integer>>();
////			
////			while(!returnedUsage.pList.empty()){
////				flag = 0;
////				returnedUsage.pList.findFirst();
////				current = returnedUsage.pList.retrieve();
////				while(!returnedUsage.pList.last()){
////					if(current.first.equals(returnedUsage.pList.retrieve().first) && flag!=0){
////						current.second+=returnedUsage.pList.retrieve().second;
////						returnedUsage.pList.remove();
////					}
////					else{
////						returnedUsage.pList.findNext();
////						flag++;
////					}
////				}
////				if(current.first.equals(returnedUsage.pList.retrieve().first) && flag!=0){
////					current.second+=returnedUsage.pList.retrieve().second;
////					returnedUsage.pList.remove();
////				}
////				/* insert the current to new List after filter the old List from it */
////				newReturnedList.insert(current);
////				returnedUsage.pList.findFirst();
////				returnedUsage.pList.remove();
//				
////			}
//			
//			//returnedUsage.pList= newReturnedList;
//			return returnedUsage;
//		}
		
		
	public LinkedList<Sequence> getSequences(){
		return seqList ;
	}
}
