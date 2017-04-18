
public class test {

	public static void main(String[] args) {
		SequenceSet s = SequenceSet.load("sample.fasta");
		
		
		/* ======================= test getUsage for SequenceSet class ======================= */
//		Usage usageOfSeqSet = s.getUsage(3, 2);
//		
//		usageOfSeqSet.pList.findFirst();
//		while(!usageOfSeqSet.pList.last()){
//			System.out.println(usageOfSeqSet.pList.retrieve().first + " "+ usageOfSeqSet.pList.retrieve().second);
//			usageOfSeqSet.pList.findNext();
//		}
//		System.out.println(usageOfSeqSet.pList.retrieve().first + " "+ usageOfSeqSet.pList.retrieve().second);
		/* ======================================= END ====================================== */
		
		
		/* ======================= test getUsage for Sequence class ======================= */
		s.seqList.findFirst();
		Sequence seq = s.seqList.retrieve();
		Usage usageOfseq = seq.getUsage(1, 9);
		
		usageOfseq.pList.findFirst();
		while(!usageOfseq.pList.empty() && !usageOfseq.pList.last()){
			System.out.println(usageOfseq.pList.retrieve().first + ":"+ usageOfseq.pList.retrieve().second);
			usageOfseq.pList.findNext();
		}
		System.out.println(usageOfseq.pList.retrieve().first + ":"+ usageOfseq.pList.retrieve().second);
		/* ======================================= END ====================================== */
				
	}

}
