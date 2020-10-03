package vet_ambulanta;

import java.util.Random;

public class Pas extends Ljubimac {
	
	private static char karakteri[] = {'a', 'b', 'c', '2', '4', '6', '8', '0'};
	private static int duzina = 5;

	public Pas(String ime, int starost) {
		super(ime, starost);
	}
	
	public Pas(String ime, int starost, String id) {
		super(ime, starost, id);
	}

	@Override
	public String toString() {
		return "[Pas] " + super.toString();
	}

	@Override
	public String generisiIdenfitikaciju() {

		Random r = new Random();
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < duzina; i++)
			sb.append(karakteri[r.nextInt(karakteri.length)]);
		
		/* da bi sigurno sadrzao bar jednu cifru */
		int index = r.nextInt(duzina); 
		sb.replace(index, index+1, karakteri[3 + r.nextInt(5)] + ""); 
		
		return sb.toString();
	}

	public static boolean validnaIdentifikacija(String id) {
		
		/* provera duzine */
		if(id.length() != duzina)
			return false;
		
		/* da li su svi karakteri iz dozvoljenog skupa vrednosti */
		int j;	
		for(int i = 0; i < id.length(); i++) {			
			for(j = 0; j < karakteri.length; j++) 
				if(id.charAt(i) == karakteri[j]) 
					break;
				
			if(j == karakteri.length)
				return false;
			
		}
		
		/* da li sadrzi bar 1 cifru */
		int br = 0;
		for(j = 0; j < id.length(); j++)
			if(Character.isDigit(id.charAt(j)))
				br++;
		
		if(br == 0)
			return false;
		
		return true;	
	}
}
