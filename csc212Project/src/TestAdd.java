
public class TestAdd {
	private static boolean equal(LinkedList<Sequence> l1, LinkedList<Sequence> l2) {
		if (l1 == l2) {
			System.out.println("l1 == l2");
			return true;
		}
		if (((l1 == null) && l2.empty()) || ((l2 == null) && l1.empty())) {
			System.out.println("(l1 == null) && l2.empty()) || ((l2 == null) && l1.empty())");
			return true;
		}
		if ((l1 == null) || (l2 == null)) {
			System.out.println("(l1 == null) || (l2 == null)");
			return false;
		}
		if (l1.empty() != l2.empty()) {
			System.out.println("l1.empty() != l2.empty()");
			return false;
		}
		if (l1.empty()) {
			System.out.println("l1.empty()");
			return true;
		}
		int n1 = 0;
		l1.findFirst();
		while (!l1.last()) {
			n1++;
			l1.findNext();
		}
		int n2 = 0;
		l2.findFirst();
		while (!l2.last()) {
			n2++;
			l2.findNext();
		}
		if (n1 != n2) {
			System.out.println("n1 != n2");
			return false;
		}
		// return subset(l1, l2) && subset(l2, l1);
		l1.findFirst();
		l2.findFirst();
		while (!l1.last()) {
			if (!(l1.retrieve().getHeader().equals(l2.retrieve().getHeader())
					&& l1.retrieve().getSeq().equals(l2.retrieve().getSeq()))) {
				System.out.println("!(l1.retrieve().getHeader().equals(l2.retrieve().getHeader())&& l1.retrieve().getSeq().equals(l2.retrieve().getSeq()))");
				return false;
			} else {
				l1.findNext();
				l2.findNext();
			}
		}
		if (!(l1.retrieve().getHeader().equals(l2.retrieve().getHeader())
				&& l1.retrieve().getSeq().equals(l2.retrieve().getSeq()))) {
			System.out.println("!(l1.retrieve().getHeader().equals(l2.retrieve().getHeader())&& l1.retrieve().getSeq().equals(l2.retrieve().getSeq())))");
			return false;
		}
		System.out.println(" true ... end equal 1");
		return true;
	}

	private static boolean equal(Usage u1, Usage u2) {
		if (u1 == u2) {
			System.out.println("u1 == u2");
			return true;
		}
		if (u1 == null && u2 == null) {
			System.out.println("u1 == null && u2 == null");
			return true;
		}
		if ((u1 == null) || (u2 == null)) {
			System.out.println("u1 == null) || (u2 == null)");
			return false;
		}
		LinkedList<Pair<String, Integer>> l1 = u1.getCounts();
		LinkedList<Pair<String, Integer>> l2 = u2.getCounts();
		int n1 = 0;
		l1.findFirst();
		while (!l1.last()) {
			n1++;
			l1.findNext();
		}
		int n2 = 0;
		l2.findFirst();
		while (!l2.last()) {
			n2++;
			l2.findNext();
		}
		if (n1 != n2) {
			System.out.println("n1 != n2");
			return false;
		}
		// return subset(l1, l2) && subset(l2, l1);
		Pair<String, Integer> p1;
		Pair<String, Integer> p2;
		l1.findFirst();
		l2.findFirst();
		while (!l1.last()) {
			p1 = l1.retrieve();
			p2 = l2.retrieve();
			if (!equal(p1, p2)) {
				System.out.println("!equal(p1, p2)  ======= 1");
				return false;
			} else {
				l1.findNext();
				l2.findNext();
			}
		}
		p1 = l1.retrieve();
		p2 = l2.retrieve();
		if (!equal(p1, p2)) {
			System.out.println("!equal(p1, p2)  ======= 2");
			return false;
		}
		System.out.println(" true ... end ");
		return true;
	}

	private static boolean equal(Pair<String, Integer> p1, Pair<String, Integer> p2) {
		return p1.first.equals(p2.first) && p1.second.equals(p2.second);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		SequenceSet	s = SequenceSet.load("s2.fasta");
		Usage actual = s.getUsage(4, 2);
		actual.add("AGAT", 1);
		actual.add("TTTT", 1);
		
		Usage expected = new Usage();
		expected.add("GATT", 4);
		expected.add("TTAC", 1);
		expected.add("ACAG", 1);
		expected.add("AGAT", 2);//2
		expected.add("TTCC", 1);
		expected.add("CCAC", 1);
		expected.add("ACTG", 1);
		expected.add("CTCA", 2);
		expected.add("CACC", 2);
		expected.add("CCGA", 2);
		expected.add("TTTT", 1);
		System.out.println(equal(actual,expected));
		//expected.pList.findFirst();
//		actual.pList.findFirst();
//		while(!actual.pList.last()){
//		 System.out.println("kemr = "+actual.pList.retrieve().first+" , count = "+actual.pList.retrieve().second);
//		 actual.pList.findNext();
//		}
//		 System.out.println("kemr = "+actual.pList.retrieve().first+" , count = "+actual.pList.retrieve().second);
//		

	}

}
