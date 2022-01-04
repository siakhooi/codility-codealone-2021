package nsh.codility;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public abstract class AbstractCodeAlone2021Test {
	abstract CodeAlone2021Interface getTestObject();

	CodeAlone2021Interface testObject;

	@BeforeEach
	void setup() {
		testObject = getTestObject();

	}

	@Test
	@DisplayName("Sample 1 - 111111")
	void test01() {
		String S = "ababab";
		int E = 3;

		assertEquals(E, testObject.solution(S));
	}

	@ParameterizedTest
	@CsvSource(textBlock = """
			4,abbbbaa
			4,baaaabb
			""")
	@DisplayName("Sample 2")
	void test02(int E, String S) {
		assertEquals(E, testObject.solution(S));
	}

	@Test
	@DisplayName("Sample 3")
	void test03() {
		String S = "bbbababaaab";
		int E = 0;

		assertEquals(E, testObject.solution(S));
	}

	@Test
	@DisplayName("Sample 4")
	void test04() {
		String S = "abbabb";
		int E = -1;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Sample 5 - 12121")
	void test05() {
		String S = "baabaab";
		int E = 5;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Sample 6")
	void test06() {
		String S = "abbbababb";
		int E = 4;

		assertEquals(E, testObject.solution(S));
	}
	@ParameterizedTest
	@CsvSource(textBlock = """
			-1,a
			-1,aa
			-1,aaa
			""")
	@DisplayName("Sample 7 -1")
	void test07(int E, String S) {
		assertEquals(E, testObject.solution(S));
	}
	@ParameterizedTest
	@CsvSource(textBlock = """
			-1,ab
			-1,aba
			-1,abab
			""")
	@DisplayName("Sample 8 -1")
	void test08(int E, String S) {
		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Sample 9 ababbababb 11121112")
	void test09() {
		String S = "ababbababb";
		int E = 3;

		assertEquals(E, testObject.solution(S));
	}
	@ParameterizedTest
	@CsvSource(textBlock = """
			4,abaabaaba
			3,abaababa
			3,ababaaba
			""")
	@DisplayName("Sample 10 abaabaaba move group 2")
	void test10(int E, String S) {
		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Sample 11 aababaab 211121")
	void test11() {
		String S = "aababaab";
		int E = 3;

		assertEquals(E, testObject.solution(S));
	}
	
	@ParameterizedTest
	@CsvSource(textBlock = """
			2,abbababaab
			2,abbababab
			2,abababaab
			""")
	@DisplayName("Sample 12 abbababaab")
	void test12(int E, String S) {
		assertEquals(E, testObject.solution(S));
	}
		
	@Test
	@DisplayName("Pattern 22222222")
	void test_pattern_22222222() {
		String S = "aabbaabbaabbaabb";
		int E = 3;

		assertEquals(E, testObject.solution(S));
	}

	@Test
	@DisplayName("Pattern 2211")
	void test_pattern_2211() {
		String S = "aabbab";
		int E = 2;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern 21212121")
	void test_pattern_21212121() {
		String S = "aabaabaabaab";
		int E = 4;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern 1221")
	void test_pattern_1221() {
		String S = "abbaab";
		int E = 4;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern 11221")
	void test_pattern_11221() {
		String S = "babbaab";
		int E = 2;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern 12111")
	void test_pattern_12111() {
		String S = "abbaba";
		int E = 4;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern 2112")
	void test_pattern_2112() {
		String S = "aababb";
		int E = 1;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Long b(a)*bb")
	void test_pattern_long_a() {
		String S = "baaaaaaaaaaaaaaaaaaaaaaaaaaaaaabb";
		int E = 30;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern 3111111")
	void test_pattern_3111111() {
		String S = "aaabababa";
		int E = 2;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern 32111111")
	void test_pattern_32111111() {
		String S = "aaabbababab";
		int E = 1;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long (ab)*")
	void test_pattern_super_long() {
		String S = "ab".repeat(50000);
		int E = 3;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long (abb)*")
	void test_pattern_super_long_abb() {
		String S = "abb".repeat(33333);
		int E = 4;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long (bba)*")
	void test_pattern_super_long_bba() {
		String S = "bba".repeat(33333);
		int E = 4;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long (abbaab)*")
	void test_pattern_super_long_abbaab() {
		String S = "abbaab".repeat(16666);
		int E = 1;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long b(a*)bb")
	void test_pattern_super_long_a99997() {
		String S = "b"+"a".repeat(99997)+"bb";
		int E = 99997;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long bb(ab)*aa")
	void test_pattern_super_long_bbabaa() {
		String S = "bb"+"ab".repeat(49998) +"aa";
		int E = 2;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long ab(aabb)*ab")
	void test_pattern_super_long_abaabbab() {
		String S = "ab"+"aabb".repeat(24999) +"ab";
		int E = 2;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long (aabb)*")
	void test_pattern_super_long_22() {
		String S = "aabb".repeat(25000);
		int E = 3;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long (aabb)*(ab)*(aabb)*")
	void test_pattern_super_long_2112() {
		String S = "aabb".repeat(12000)+"ab".repeat(2000)+"aabb".repeat(12000);
		int E = 2;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long ((aabb)*(ab)*(aabb)*)*")
	void test_pattern_super_long_2112_repeat() {
		String S = ("aabb".repeat(1200)+"ab".repeat(200)+"aabb".repeat(1200)).repeat(10);
		int E = 2;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long (ab)*aabb")
	void test_pattern_super_long_11_22() {
		String S = "ab".repeat(49998)+"aabb";
		int E = 2;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long (aabb)*ab")
	void test_pattern_super_long_22_11() {
		String S = "aabb".repeat(24999)+"ab";
		int E = 2;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long (aaaab)*")
	void test_pattern_super_long_31() {
		String S = "aaaab".repeat(20000);
		int E = 8;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long 1211 (abaab)*")
	void test_pattern_super_long_1211() {
		String S = "abaab".repeat(20000);
		int E = 3;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long 1222 (abbaabb)*")
	void test_pattern_super_long_1222() {
		String S = "abbaabb".repeat(14285);
		int E = 2;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long 1222 abb(aabb)*")
	void test_pattern_super_long_1222b() {
		String S = "abb"+"aabb".repeat(24999);
		int E = 3;

		assertEquals(E, testObject.solution(S));
	}
	@Test
	@DisplayName("Pattern Super Long 1222 (aabb)*abb")
	void test_pattern_super_long_1222c() {
		String S = "aabb".repeat(24999)+"abb";
		int E = 2;

		assertEquals(E, testObject.solution(S));
	}
	@ParameterizedTest
	@CsvSource(textBlock = """
			-1,abaab
            2,abaabb
            4,abbaab
            3,abbaabb
            -1,babaa
            4,babaab
            2,babaabb
            2,babbaa
            2,babbaab
            2,babbaabb
            1,bbabaa
            1,bbabaab
            1,bbabaabb
            2,bbabbaa
            2,bbabbaab
            2,bbabbaabb
			""")
	@DisplayName("New Test 1-2")
	void test_new_12(int E, String S) {
		assertEquals(E, testObject.solution(S));
	}
	@ParameterizedTest
	@CsvSource(textBlock = """
			-1,aabaab
            2,aabaabb
            3,aabbaab
            3,aabbaabb
            -1,baabaa
            5,baabaab
            2,baabaabb
            3,baabbaa
            3,baabbaab
            3,baabbaabb
            2,bbaabaa
            2,bbaabaab
            2,bbaabaabb
            3,bbaabbaa
            3,bbaabbaab
            3,bbaabbaabb
			""")
	@DisplayName("New Test 2-2")
	void test_new_22(int E, String S) {
		assertEquals(E, testObject.solution(S));
	}
	@ParameterizedTest
	@CsvSource(textBlock = """
			-1,ababa
            3,ababab
            2,abababb
            4,ababba
            3,ababbab
            3,ababbabb
            4,abbaba
            4,abbabab
            3,abbababb
            5,abbabba
            4,abbabbab
            4,abbabbabb
            3,bababa
            3,bababab
            2,babababb
            4,bababba
            3,bababbab
            3,bababbabb
            3,babbaba
            3,babbabab
            3,babbababb
            4,babbabba
            4,babbabbab
            4,babbabbabb
            2,bbababa
            2,bbababab
            2,bbabababb
            3,bbababba
            3,bbababbab
            3,bbababbabb
            3,bbabbaba
            3,bbabbabab
            3,bbabbababb
            4,bbabbabba
            4,bbabbabbab
            4,bbabbabbabb
			""")
	@DisplayName("New Test 1-1-1")
	void test_new_111(int E, String S) {
		assertEquals(E, testObject.solution(S));
	}
	@ParameterizedTest
	@CsvSource(textBlock = """
			-1,ababaa
            2,ababaabb
            2,bababaabb
            2,bbababaa
            2,bbababaab
            2,bbababaabb
            4,ababaab
            2,ababbaab
            2,ababbaabb
            1,abbabaabb
            2,bababaa
            2,bababaab
            2,bababbaab
            2,bababbaabb
            1,babbabaa
            1,babbabaab
            1,babbabaabb
            2,bbababbaa
            2,bbababbaab
            2,bbababbaabb
            1,bbabbabaa
            1,bbabbabaab
            1,bbabbabaabb
            2,ababbaa
            1,abbabaa
            1,abbabaab
            2,abbabbaab
            2,abbabbaabb
            2,bababbaa
            2,babbabbaa
            2,babbabbaab
            2,babbabbaabb
            2,bbabbabbaa
            2,bbabbabbaab
            2,bbabbabbaabb
            2,abbabbaa
			""")
	@DisplayName("New Test 1-1-2")
	void test_new_112(int E, String S) {
		assertEquals(E, testObject.solution(S));
	}
	
	
}
