
public class test {

	public static void main(String[] args) {
		SequenceSet s = SequenceSet.load("ecoli.fasta");
		
		LinkedList<Sequence> list = s.getSequences() ;
		list.findFirst();
		Sequence ss = list.retrieve();
		int number = ss.getSeq().length();
		System.out.println(number);
		LinkedList<Pair<String,Integer>> usageList = s.getUsage(3,1).pList;
		
		usageList.findFirst();
		
		while(!usageList.last()){
			System.out.println(usageList.retrieve().first + " "+ usageList.retrieve().second);
			usageList.findNext();
		}
		System.out.println(usageList.retrieve().first + " "+ usageList.retrieve().second);
		
		
//00000
//	LinkedList<Pair<String,Integer>> kList = testUsage.pList;
//	kList.findFirst();
//	kList.findNext();
	
	
//	Sequence kkk = list.retrieve();
//	LinkedList<Pair<String, Integer>> kList = kkk.getUsage(4,1).pList;
//	kList.findFirst();
//	while(!kList.last()){
//		System.out.println(kList.retrieve().first + " " + kList.retrieve().second);
//		kList.findNext();
//	}
//	System.out.println(kList.retrieve().first + " " + kList.retrieve().second);
	}

}
