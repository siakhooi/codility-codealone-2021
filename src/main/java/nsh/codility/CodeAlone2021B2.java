package nsh.codility;

public class CodeAlone2021B2 implements CodeAlone2021Interface {
	// B2
	final static int BIG_NUMBER = 1000001;

	class MinNode {
		int count = 0;
		int type;
		int minTo3[] = new int[] { BIG_NUMBER, BIG_NUMBER };

		int max[] = new int[] { 0, 0 };
		int min[] = new int[] { BIG_NUMBER, BIG_NUMBER };
		int totalCount[] = new int[] { 0, 0 };
		MinNode left, right;

		public void initTree(int from, int to) {
			int m = (from + to) / 2;
			if (from != m) {
				left = new MinNode();
				left.initTree(from, m);
			}
			if (m + 1 != to) {
				right = new MinNode();
				right.initTree(m + 1, to);
			}
		}

		public void initNode(MinNode mn, int i, int from, int to) {
			int m = (from + to) / 2;
			if (from == m && from == i)
				left = mn;
			else if (m + 1 == to && to == i)
				right = mn;
			else if (from != m && i >= from && i <= m)
				left.initNode(mn, i, from, m);
			else if (to != m + 1 && i >= m + 1 && i <= to)
				right.initNode(mn, i, m + 1, to);
		}

		public void update(int updateFrom, int updateTo, int from, int to) {
			if (from == to) {
				totalCount[type] = count;
				max[type] = count;
				min[type] = count;
				return;
			}
			int m = (from + to) / 2;
			if (updateFrom <= m && updateTo >= from)
				left.update(updateFrom, updateTo, from, m);
			if (updateFrom <= to && updateTo >= m + 1)
				right.update(updateFrom, updateTo, m + 1, to);

			totalCount[0] = left.totalCount[0] + right.totalCount[0];
			totalCount[1] += left.totalCount[1] + right.totalCount[1];
			max[0] = Math.max(right.max[0], left.max[0]);
			max[1] = Math.max(right.max[1], left.max[1]);
			min[0] = Math.min(right.min[0], left.min[0]);
			min[1] = Math.min(right.min[1], left.min[1]);
			minTo3[0] = Math.min(right.minTo3[0], left.minTo3[0]);
			minTo3[1] = Math.min(right.minTo3[1], left.minTo3[1]);
		}
	}

	MinNode[] N;
	int nodeCount = 0;
	MinNode Root = new MinNode();

	public int solution(String S) {
		char[] s = S.toCharArray();
		N = new MinNode[s.length];

		MinNode currentNode = new MinNode();
		N[nodeCount] = currentNode;
		currentNode.count = 1;
		currentNode.type = s[0] == 'a' ? 0 : 1;

		for (int i = 1; i < s.length; i++) {
			int ct = s[i] == 'a' ? 0 : 1;
			if (ct == currentNode.type)
				currentNode.count++;
			else {
				currentNode = new MinNode();
				currentNode.count = 1;
				currentNode.type = ct;
				N[++nodeCount] = currentNode;
			}
		}
		nodeCount++;
		if (nodeCount < 2)
			return -1;

		Root.initTree(0, nodeCount - 1);
		boolean has2112 = false;

		for (int i = 0; i < nodeCount; i++) {
			if (!has2112 && i < nodeCount - 3) {
				has2112 = ((N[i].count > 1) && (N[i + 1].count == 1) && (N[i + 2].count == 1) && (N[i + 3].count > 1));
			}
			updateMinTo3(i);
			Root.initNode(N[i], i, 0, nodeCount - 1);
		}
		Root.update(0, nodeCount - 1, 0, nodeCount - 1);

		if (Root.totalCount[0] < 3 || Root.totalCount[1] < 3)
			return -1;
		if (Root.max[0] >= 3 && Root.max[1] >= 3)
			return 0;
		if (has2112)
			return 1;
		if (Root.max[0] == 1 && Root.max[1] == 1)
			return 3;
		if (Root.max[0] == 2 && Root.max[1] == 2 && Root.min[0] == 2 && Root.min[1] == 2)
			return 3;
		if (Root.max[0] >= 3)
			return Root.minTo3[1];
		if (Root.max[1] >= 3)
			return Root.minTo3[0];

		int m = BIG_NUMBER;

		for (int i = 0; i < nodeCount && m > 2; i++) {
			MinNode mn = N[i];
			if (mn.count == 2) {
				if (i > 1) {
					m = testSwapNode(i - 2, i, -1, N[i - 1], m);
					m = testSwapNode(i - 2, i, 2, N[i - 1], m);
				}
				if (i < nodeCount - 2) {
					m = testSwapNode(i, i + 2, 1, N[i + 1], m);
					m = testSwapNode(i, i + 2, -2, N[i + 1], m);
				}
			}
		}

		return m;
	}

	int testSwapNode(int base, int target, int testValue, MinNode using, int m) {
		int from = (base == 0 ? 0 : base - 1);
		int to = (target == nodeCount - 1 ? nodeCount - 1 : target + 1);

		N[base].count += testValue;
		N[target].count -= testValue;

		for (int i = from; i <= to; i++)
			updateMinTo3(i);

		Root.update(from, to, 0, nodeCount - 1);

		m = Math.min(m, using.count * Math.abs(testValue) + Root.minTo3[using.type]);

		N[base].count -= testValue;
		N[target].count += testValue;
		for (int i = from; i <= to; i++)
			updateMinTo3(i);

		Root.update(from, to, 0, nodeCount - 1);
		return m;
	}

	private void updateMinTo3(int i) {
		MinNode n = N[i];

		int l = (i > 1) ? N[i - 1].count : BIG_NUMBER;
		int r = (i < nodeCount - 2) ? N[i + 1].count : BIG_NUMBER;

		n.minTo3[n.type] = BIG_NUMBER;
		if (n.count == 1 && i > 1 && i < nodeCount - 2)
			n.minTo3[n.type] = l + r;
		else if (n.count == 2)
			n.minTo3[n.type] = Math.min(l, r);
		else if (n.count > 2)
			n.minTo3[n.type] = 0;
	}
}
