package nsh.codility;

public class CodeAlone2021A2 implements CodeAlone2021Interface {
	//A2
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
			int i2 = i % 2 == 0 ? 0 : 1;
			count[i2] += n;
			max[i2] = Math.max(max[i2], n);
		}

		if (count[0] < 3 || count[1] < 3)
			return -1;
		if (max[0] >= 3 && max[1] >= 3)
			return 0;
		if (max[0] == 1 && max[1] == 1)
			return 3;

		if (max[0] >= 3) {
			return findMin(N, segmentCount, 1);
		} else if (max[1] >= 3) {
			return findMin(N, segmentCount, 0);
		} else {
			int m = BIG_NUMBER;
			for (int i = 0; i < segmentCount && m > 1; i += 2) {
				int n = N[i];
				if (n == 2) {
					if (i > 0) {
						m = testSwap(N, segmentCount, m, 1, 1, i, N[i - 1], i - 2);
						m = testSwap(N, segmentCount, m, 1, -2, i, N[i - 1] + N[i - 1], i - 2);
					}
					if (i < segmentCount - 2) {
						m = testSwap(N, segmentCount, m, 1, 1, i, N[i + 1], i + 2);
						m = testSwap(N, segmentCount, m, 1, -2, i, N[i + 1] + N[i + 1], i + 2);
					}
				}
			}
			for (int i = 1; i < segmentCount && m > 1; i += 2) {
				int n = N[i];
				if (n == 2) {
					if (i > 1) {
						m = testSwap(N, segmentCount, m, 0, 1, i, N[i - 1], i - 2);
						m = testSwap(N, segmentCount, m, 0, -2, i, N[i - 1] + N[i - 1], i - 2);
					}
					if (i < segmentCount - 2) {
						m = testSwap(N, segmentCount, m, 0, 1, i, N[i + 1], i + 2);
						m = testSwap(N, segmentCount, m, 0, -2, i, N[i + 1] + N[i + 1], i + 2);
					}
				}
			}
			return m;
		}

	}

	int testSwap(int[] N, int segmentCount, int m, int start, int testValue, int base, int m1, int test_index) {
		if (m < m1)
			return m;
		N[test_index] -= testValue;
		N[base] += testValue;
		m = Math.min(m, m1 + findMin(N, segmentCount, start));
		N[test_index] += testValue;
		N[base] -= testValue;
		return m;
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
