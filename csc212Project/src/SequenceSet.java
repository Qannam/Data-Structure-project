import java.io.*;


//This class represents a set of sequences.
public class SequenceSet {
	static LinkedList<Sequence> seqList = new LinkedList<Sequence>() ;
	
	public SequenceSet(){
		
	}
	public static SequenceSet load(String fileName){
		String header = null ;
		String seq = null;
		FileReader in;
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
	    		seqList.insert(s);
	    	}
	        line = br.readLine();
	    	
	    	
	    	
	    }
	    in.close();
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SequenceSet seq1 = new SequenceSet();
		seq1.seqList = seqList;
		return seq1;
	}
	
	// Return the global usage over all sequences in the set. The word length is k and window step size is w.
		public Usage getUsage(int k, int w){
			Usage returnedUsage = new Usage();
			seqList.findFirst();
			
			while(!seqList.last()){
				
				Sequence seq = seqList.retrieve();
				
				
				Usage u = seq.getUsage(k, w);
				
				
				u.pList.findFirst();
				while(!u.pList.last()){
					returnedUsage.pList.insert(u.pList.retrieve());
					u.pList.findNext();
				}
				returnedUsage.pList.insert(u.pList.retrieve());
				
				seqList.findNext();
			}
			Sequence seq = seqList.retrieve();
			
			
			Usage u = seq.getUsage(k, w);
			
			
			u.pList.findFirst();
			while(!u.pList.last()){
				returnedUsage.pList.insert(u.pList.retrieve());
				u.pList.findNext();
			}
			returnedUsage.pList.insert(u.pList.retrieve());
			
			//filter the final list
			
			returnedUsage.pList.findFirst();
			Pair<String,Integer> current;
			int flag = 0;
			LinkedList<Pair<String,Integer>> newReturnedList = new LinkedList<Pair<String,Integer>>();
			
			while(!returnedUsage.pList.empty()){
				flag = 0;
				returnedUsage.pList.findFirst();
				current = returnedUsage.pList.retrieve();
				while(!returnedUsage.pList.last()){
					if(current.first.equals(returnedUsage.pList.retrieve().first) && flag!=0){
						current.second+=returnedUsage.pList.retrieve().second;
						returnedUsage.pList.remove();
					}
					else{
						returnedUsage.pList.findNext();
						flag++;
					}
		
				}
				
				if(current.first.equals(returnedUsage.pList.retrieve().first) && flag!=0){
					current.second+=returnedUsage.pList.retrieve().second;
					returnedUsage.pList.remove();
				}
				
				newReturnedList.insert(current);
				returnedUsage.pList.findFirst();
				returnedUsage.pList.remove();
				
			}
			
			returnedUsage.pList= newReturnedList;
			return returnedUsage;
		}
		
		
	public LinkedList<Sequence> getSequences(){
		return seqList ;
	}
	

}
