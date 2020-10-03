package vet_ambulanta;

import java.util.LinkedList;

public class Red {

	private LinkedList<Ljubimac> red;
	
	public Red() {
		red = new LinkedList<>();
	}
	
	public void dodajURed(Ljubimac ljubimac) {
		red.add(ljubimac);
	}
	
	public Ljubimac prozoviSledeceg() {
		return red.poll();
	}
	
	@Override
	public String toString() {

		StringBuilder sb = new StringBuilder();
		int i = 1;
		for(Ljubimac ljubimac : red) 			
			sb.append(i++ + ": " + ljubimac + "\n");
		
		return sb.toString();
	}
}
