import java.io.*;

public class SequenceSet {
	static LinkedList<Sequence> seqList = new LinkedList<Sequence>() ;
	
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
	public LinkedList<Sequence> getSequences(){
		return seqList ;
	}
	

}
