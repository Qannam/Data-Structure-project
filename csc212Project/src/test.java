
public class test {

	public static void main(String[] args) {
		SequenceSet s = SequenceSet.load("sample.fasta");
		LinkedList<Sequence> list = s.seqList ;
		list.findFirst();
//		while(!list.last()){
//			System.out.println(list.retrieve().getHeader());
//			System.out.println(list.retrieve().getSeq());
//			list.findNext();
//		}
//		System.out.println(list.retrieve().getHeader());
//		System.out.println(list.retrieve().getSeq());
		

	
	list.findFirst();
	
	Sequence kkk = list.retrieve();
	LinkedList<Pair<String, Integer>> kList = kkk.getUsage(3,3).pList;
	kList.findFirst();
	while(!kList.last()){
		System.out.println(kList.retrieve().first + " " + kList.retrieve().second);
		System.out.println("==============");
		System.out.println("==============");
		kList.findNext();
	}
	System.out.println(kList.retrieve().first + " " + kList.retrieve().second);
	}

}
