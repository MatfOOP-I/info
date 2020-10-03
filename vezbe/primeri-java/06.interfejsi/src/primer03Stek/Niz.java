package primer03Stek;

import java.util.Arrays;

public class Niz implements Stek {
	private int[] elementi;
	private int vrhSteka, kapacitet;

	public Niz() {
		this(10);
	}

	public Niz(int kapacitet) {
		this.kapacitet = kapacitet;
		vrhSteka = 0;
		elementi = new int[kapacitet];
	}

	public int getKapacitet() {
		return kapacitet;
	}

	@Override
	public int pop() {
		if (vrhSteka == 0) {
			System.err.println("Stack underflow!");
			return 0;
		}
		
		vrhSteka--;
		return elementi[vrhSteka];
	}

	@Override
	public void push(int x) {
		if (vrhSteka == kapacitet) {
			kapacitet *= 2;
			elementi = Arrays.copyOf(elementi, kapacitet);
		}

		elementi[vrhSteka] = x;
		vrhSteka++;
	}

	@Override
	public int top() {
		if (vrhSteka == 0) {
			System.err.println("Stack underflow!");
			return 0;
		}

		return elementi[vrhSteka-1];
	}
	
	@Override
	public void show() {
		System.out.println("Sadrzaj: [ " + toString() + "]");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < vrhSteka; i++)
			sb.append(elementi[i]).append(" ");
		return sb.toString();
	}

	@Override
	public int size() {
		return vrhSteka;
	}
}
