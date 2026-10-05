package d_stringovi;

// Primer ilustruje razliku u brzini konkatenacije stringova koristeci 'String' i 'StringBuilder'.
public class Primer11StringVSStringBuilder {

	static int TEST_SIZE = 10000;

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

		// Ilustracija, ne pouzdan mikrobenchmark: JVM zagrevanje i optimizacije utiču na rezultat.
	}

	static void runStringTest() {
		String tmp = "";
		String word = "test";
		for (int i = 0; i < TEST_SIZE; i++) {
			tmp += word;

			// logging
		}
	}

	static void runStringBuilderTest() {
		StringBuilder sb = new StringBuilder();
		String word = "test";
		for (int i = 0; i < TEST_SIZE; i++) {
			sb.append(word);
		}
	}

}
