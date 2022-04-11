package nsh.codility;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CodeAlone2021D1 implements CodeAlone2021Interface {
	public int solution(String S) {

		int[] count = new int[] {0, 0};
		int[][] pos = new int[2][S.length()];
		int[] poscount = new int[] {0, 0};

		boolean[] has3 = new boolean[] {false, false};

		for (int i = 0; i < S.length(); i++) {
			int n = S.charAt(i) - 'a';
			count[n]++;
			if (i > 1 && !has3[n])
				has3[n] = (S.charAt(i) == S.charAt(i - 1) && S.charAt(i) == S.charAt(i - 2));
			pos[n][poscount[n]++] = i;
		}

		if (count[0] < 3 || count[1] < 3)
			return -1;

		for (int i = 0; i < 2; i++)
			if (has3[i]) {
				int ans = S.length();
				int i2 = i == 0 ? 1 : 0;
				for (int j = 0; j < poscount[i2] - 2; j++)
					ans = Math.min(ans, pos[i2][j + 2] - pos[i2][j] - 2);
				return ans;
			}

		Map<String, Integer> d = new HashMap<>();
		Queue<String> q = new LinkedList<>();
		for (int i = 0; i < S.length(); i++) {
			String w = i + 8 < S.length() ? S.substring(i, i + 8) : S.substring(i);
			if (!d.containsKey(w)) {
				d.put(w, 0);
				q.add(w);
			}
		}
		while (!q.isEmpty()) {
			String w = q.remove();
			if (w.indexOf("aaa") != -1 && w.indexOf("bbb") != -1)
				return d.get(w);
			for (int i = 0; i < w.length() - 1; i++) {
				String w2 = w.substring(0, i) + w.charAt(i + 1) + w.charAt(i) + w.substring(i + 2);
				if (!d.containsKey(w2)) {
					d.put(w2, d.get(w) + 1);
					q.add(w2);
				}
			}
		}
		return 0;
	}
}


