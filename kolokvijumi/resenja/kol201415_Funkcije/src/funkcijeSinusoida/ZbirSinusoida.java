package funkcijeSinusoida;

public class ZbirSinusoida extends Funkcija {
	
	private Clan[] clanovi;

	public ZbirSinusoida(double x, Clan[] clanovi) {
		super(x);
		this.clanovi = new Clan[clanovi.length];
		for(int i=0; i<clanovi.length; i++)
			this.clanovi[i]=new Clan(clanovi[i]);
	}
	
	public String toString() {
		StringBuffer s = new StringBuffer();
		for (int i=0; i<clanovi.length; i++) {
			if (clanovi[i].getA() > 0) 
				s.append('+');
	    	s.append(clanovi[i].getA()).append("*sin(").append(clanovi[i].getB())
	    	 .append('*').append(getX()).append("*PI)");
	    }
		if(s.charAt(0) == '+')
			s.deleteCharAt(0);
	    return s.toString();
	}

	public double vrednost() {
		double zbir = 0;
	    for (int i=0; i<clanovi.length; i++) 
	    	zbir += clanovi[i].getA() * Math.sin(clanovi[i].getB()*getX()*Math.PI);
		return zbir;
	}
}
