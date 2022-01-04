package nsh.codility;

public class CodeAlone2021C1 implements CodeAlone2021Interface {
	// C1
	public int solution(String S) {
		char[] s = S.toCharArray();
		int[] N = new int[s.length];

		int segmentCount = 0;
		char currentChar = s[0];
		N[segmentCount] = 1;

		for (int i = 1; i < s.length; i++) {
			char c = s[i];
			if (c == currentChar)
				N[segmentCount]++;
			else {
				currentChar = c;
				N[++segmentCount] = 1;
			}
		}
		segmentCount++;
		int[] max = new int[] { 0, 0 };
		int[] count = new int[] { 0, 0 };

		for (int i = 0; i < segmentCount; i++) {
			int n = N[i];
			int iType = (i % 2 == 0) ? 0 : 1;
			count[iType] += n;
			max[iType] = Math.max(max[iType], n);
		}

		if (count[0] < 3 || count[1] < 3)
			return -1;
		if (max[0] >= 3 && max[1] >= 3)
			return 0;
		if (max[0] == 1 && max[1] == 1)
			return 3;

		if (max[0] >= 3)
			return findMin(N, segmentCount, 1);
		else if (max[1] >= 3)
			return findMin(N, segmentCount, 0);

		int m = BIG_NUMBER;
		for (int i = 0; i < segmentCount - 2 && m > 1; i++) {
			int a0 = N[i];
			int a1 = N[i + 2];
			int a2 = (i + 4 < segmentCount) ? N[i + 4] : 0;
			int b0 = (i > 0) ? N[i - 1] : 0;
			int b1 = N[i + 1];
			int b2 = (i + 3 < segmentCount) ? N[i + 3] : 0;
			int b3 = (i + 5 < segmentCount) ? N[i + 5] : 0;

			if (a0 == 1 && a1 == 2)
				m = Math.min(m, find12(b0, b1, b2));
			else if (a0 == 2 && a1 == 1)
				m = Math.min(m, find12(b2, b1, b0));
			else if (a0 == 2 && a1 == 2)
				m = Math.min(m, find22(b0, b1, b2));
			else if (a0 == 1 && a1 == 1 && a2 == 1)
				m = Math.min(m, find111(b0, b1, b2, b3));
			else if (a0 == 1 && a1 == 1 && a2 == 2)
				m = Math.min(m, find112(b0, b1, b2, b3));
			else if (a0 == 2 && a1 == 1 && a2 == 1)
				m = Math.min(m, find112(b3, b2, b1, b0));

		}
		return m;

	}

	private int find112(int b0, int b1, int b2, int b3) {
		//partial
		if (b0 == 2 && b1 == 1 && b2 == 1)
			return 2;
		return BIG_NUMBER;
	}

	private int find111(int b0, int b1, int b2, int b3) {
		if (b1 == 2 && b2 == 2)
			return (b0 == 0 && b3 == 0) ? 5 : 4;
		if (b0 == 0 && b3 == 0)
			return 4;
		if (b0 == 0 && b1 == 2 && b2 == 1 && b3 == 1)
			return 4;
		if (b0 == 1 && b1 == 1 && b2 == 2 && b3 == 0)
			return 4;
		if (b1 == 1 && b2 == 1 && (b0 == 2 || b3 == 2))
			return 2;

		return 3;
	}

	private int find22(int b0, int b1, int b2) {
		if (b0 == 1 && b1 == 1 && b2 == 0)
			return BIG_NUMBER;
		if (b0 == 0 && b1 == 1 && b2 == 1)
			return BIG_NUMBER;
		if (b1 == 2)
			return 3;
		if (b0 == 1 && b2 == 1)
			return 5;
		return 2;
	}

	private int find12(int b0, int b1, int b2) {
		if (b0 == 1 && b1 == 1 && b2 == 0)
			return BIG_NUMBER;
		if (b0 == 0 && b1 == 1 && b2 == 1)
			return BIG_NUMBER;
		if (b0 == 2 && b1 == 1)
			return 1;
		if (b0 == 0 && b1 == 2 && b2 == 2)
			return 3;
		if (b0 == 0 && b1 == 2 && b2 == 1)
			return 4;
		if (b0 == 1 && b1 == 1 && b2 == 1)
			return 4;
		return 2;

	}

	final static int BIG_NUMBER = 1000001;

	private int findMin(int[] N, int size, int start) {

		int m = BIG_NUMBER;
		for (int i = start; i < size && m > 0; i += 2) {
			int i1 = N[i];
			int l = (i > start) ? N[i - 1] : BIG_NUMBER;
			int r = (i < size - 1 - start) ? N[i + 1] : BIG_NUMBER;
			if (i1 == 1 && i > start && i < size - 2) {
				m = Math.min(m, l + r);

			} else if (i1 == 2) {
				if (i > start)
					m = Math.min(m, l);
				if (i < size - 2)
					m = Math.min(m, r);
			}
		}

		return m;
	}
}
