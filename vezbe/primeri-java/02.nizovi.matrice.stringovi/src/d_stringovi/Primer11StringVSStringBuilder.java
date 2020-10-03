package d_stringovi;

// Primer ilustruje razliku u brzini konkatenaciji stringova koristeci 'String' i 'StringBuilder'.
public class Primer11StringVSStringBuilder {

	static int TEST_SIZE = 100000;

	public static void main(String[] args) {
		long timeString, timeSBuilder;

		// Testiranje funkcije koja koristi String
		long t = System.nanoTime();
		runStringTest();
		timeString = System.nanoTime() - t;

		// Testiranje funkcije koja koristi StringBuilder
		t = System.nanoTime();
		runStringBuilderTest();
		timeSBuilder = System.nanoTime() - t;

		System.out.println("String:\t\t" + timeString);
		System.out.println("StringBuilder:\t" + timeSBuilder);

		// Zakljucite sta je brze :)
	}

	static void runStringTest() {
		String tmp = "";
		String word = "test";
		for (int i = 0; i < TEST_SIZE; i++) {
			tmp += word;

			// logging
			if (i % 10 == 0) System.out.println("String: " + i);
		}
	}

	static void runStringBuilderTest() {
		StringBuilder sb = new StringBuilder();
		String word = "test";
		for (int i = 0; i < TEST_SIZE; i++) {
			sb.append(word);
			if (i % 10 == 0) System.out.println("isb: " + i);
		}
	}

}
