
public class test {

	public static void main(String[] args) {
		SequenceSet s = SequenceSet.load("ecoli.fasta");
//		LinkedList<Sequence> list = s.seqList ;
//		kList.findFirst();
//		while(!list.last()){
//			System.out.println(list.retrieve().getHeader());
//			System.out.println(list.retrieve().getSeq()); 
//			list.findNext();
//		}
//		System.out.println(list.retrieve().getHeader());
//		System.out.println(list.retrieve().getSeq());
		
//00000
	Usage testUsage = s.getUsage(3, 20);
	LinkedList<Pair<String,Integer>> kList = testUsage.pList;
//	kList.findFirst();
//	kList.findNext();
	
	
//	Sequence kkk = list.retrieve();
//	LinkedList<Pair<String, Integer>> kList = kkk.getUsage(4,1).pList;
	kList.findFirst();
	while(!kList.last()){
		System.out.println(kList.retrieve().first + " " + kList.retrieve().second);
		kList.findNext();
	}
	System.out.println(kList.retrieve().first + " " + kList.retrieve().second);
	}

}
