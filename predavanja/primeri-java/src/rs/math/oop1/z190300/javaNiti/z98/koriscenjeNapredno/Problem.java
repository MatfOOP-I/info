package rs.math.oop1.z190300.javaNiti.z98.koriscenjeNapredno;

import java.util.Random;

/**
 * primer preuzet (malo je modifikovan) sa adrese: http://www.vogella.com/articles/JavaConcurrency/article.html
 * 
 * jos jedna korisna stranica: http://docs.oracle.com/javase/tutorial/essential/concurrency/forkjoin.html
 */



/**
 * 
 * This class defines a long list of integers which defines the problem we will
 * later try to solve
 * 
 */

public class Problem {

	private final int[] list = new int[2_000_000];

	public Problem() {
		Random generator = new Random(19580427);
		for (int i = 0; i < list.length; i++) {
			list[i] = generator.nextInt(500000);
		}
	}

	public int[] getList() {
		return list;
	}
}