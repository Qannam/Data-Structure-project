
public class test {

	public static void main(String[] args) {
//		SequenceSet s = SequenceSet.load("sample.fasta");
		/*            Test testGetUsage1() --> Output            */
		//SequenceSet s = SequenceSet.load("test.fasta");
		SequenceSet	s = SequenceSet.load("s2.fasta");
//		Usage actual = s.getUsage(3, 1);
//		Usage expected = new Usage();
//		expected.add("GAT", 5);
//		expected.add("ATT", 5);
//		expected.add("TTA", 1);
//		expected.add("TAC", 1);
//		expected.add("ACA", 1);
//		expected.add("CAG", 1);
//		expected.add("AGA", 1);
//		expected.add("TTC", 1);
//		expected.add("TCC", 1);
//		expected.add("CCA", 1);
//		expected.add("CAC", 3);
//		expected.add("ACT", 1);
//		expected.add("CTG", 1);
//		expected.add("TGC", 1);
//		expected.add("CTC", 2);
//		expected.add("TCA", 2);
//		expected.add("ACC", 2);
//		expected.add("CCG", 2);
//		expected.add("CGA", 2);
//		expected.add("TTG", 2);
		
//		/*   Test Usage 2 */
//		Usage actual = s.getUsage(4, 2);
//		actual.add("AGAT", 1);
//		actual.add("TTTT", 1);
//		Usage expected = new Usage();
//		expected.add("GATT", 4);
//		expected.add("TTAC", 1);
//		expected.add("ACAG", 1);
//		expected.add("AGAT", 1);
//		expected.add("TTCC", 1);
//		expected.add("CCAC", 1);
//		expected.add("ACTG", 1);
//		expected.add("CTCA", 2);
//		expected.add("CACC", 2);
//		expected.add("CCGA", 2);
		//s = SequenceSet.load("s2.fasta");
		int actual = s.getUsage(4, 2).getCount("GATT");
//		int exp = 4;
		//System.out.println(actual == exp);
		System.out.println("List of pairs from Usage expected (TestGetCount1()) : ");
		System.out.println("The actual count = "+actual);
//		expected.pList.findFirst();
//		actual.pList.findFirst();
//		while(!actual.pList.last()){
//		 System.out.println("kemr = "+actual.pList.retrieve().first+" , count = "+actual.pList.retrieve().second);
//		 actual.pList.findNext();
//		}
//		 System.out.println("kemr = "+actual.pList.retrieve().first+" , count = "+actual.pList.retrieve().second);
//		
		/*            Test testGetUsage1() --> Output  End         */
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
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
//		s.seqList.findFirst();
//		Sequence seq = s.seqList.retrieve();
//		Usage usageOfseq = seq.getUsage(1, 9);
//		
//		usageOfseq.pList.findFirst();
//		while(!usageOfseq.pList.empty() && !usageOfseq.pList.last()){
//			System.out.println(usageOfseq.pList.retrieve().first + ":"+ usageOfseq.pList.retrieve().second);
//			usageOfseq.pList.findNext();
//		}
//		System.out.println(usageOfseq.pList.retrieve().first + ":"+ usageOfseq.pList.retrieve().second);
		/* ======================================= END ====================================== */
				
	}

}
