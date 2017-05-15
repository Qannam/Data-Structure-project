import java.io.*;


//This class represents a set of sequences.
public class SequenceSet {
	 static LinkedList<Sequence> seqList;// = new LinkedList<Sequence>() ;
	
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
		 seqList = seq1.seqList ;
		return seq1;
	}
	
	
	
	
	public Usage getUsage(int k, int w){
		Usage usage = new Usage();
		
		try {
			seqList.findFirst();
			
			while(!seqList.last()){
				
				Usage seqUsage = seqList.retrieve().getUsage(k, w);
				
				seqUsage.pList.findFirst();
				
				while(!(seqUsage.pList.last())){
					
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
			usage.add(seqUsage.pList.retrieve().first, seqUsage.pList.retrieve().second);
		} catch (Exception e) {
			// TODO Auto-generated catch block
		} //last check
		
		
		
		
		
		return usage;
	}
	
	
		
		
	public LinkedList<Sequence> getSequences(){
		return seqList ;
	}
}
