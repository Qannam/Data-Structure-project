
public class TJunitEqual {
	private static boolean equal(LinkedList<Sequence> l1, LinkedList<Sequence> l2) {
		if (l1 == l2) {
			return true;
		}
		if (((l1 == null) && l2.empty()) || ((l2 == null) && l1.empty())) {
			return true;
		}
		if ((l1 == null) || (l2 == null)) {
			return false;
		}
		if (l1.empty() != l2.empty()) {
			return false;
		}
		if (l1.empty()) {
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
			return false;
		}
		// return subset(l1, l2) && subset(l2, l1);
		l1.findFirst();
		l2.findFirst();
		while (!l1.last()) {
			if (!(l1.retrieve().getHeader().equals(l2.retrieve().getHeader())
					&& l1.retrieve().getSeq().equals(l2.retrieve().getSeq()))) {
				return false;
			} else {
				l1.findNext();
				l2.findNext();
			}
		}
		if (!(l1.retrieve().getHeader().equals(l2.retrieve().getHeader())
				&& l1.retrieve().getSeq().equals(l2.retrieve().getSeq()))) {
			return false;
		}
		return true;
	}

	private static boolean equal(Usage u1, Usage u2) {
		if (u1 == u2) {
			return true;
		}
		if (u1 == null && u2 == null) {
			return true;
		}
		if ((u1 == null) || (u2 == null)) {
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
				return false;
			} else {
				l1.findNext();
				l2.findNext();
			}
		}
		p1 = l1.retrieve();
		p2 = l2.retrieve();
		if (!equal(p1, p2)) {
			return false;
		}
		return true;
	}
	private static boolean equal(Pair<String, Integer> p1, Pair<String, Integer> p2) {
		return p1.first.equals(p2.first) && p1.second.equals(p2.second);
	}
}
