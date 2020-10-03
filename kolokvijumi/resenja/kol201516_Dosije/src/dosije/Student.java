package dosije;

public class Student extends Dosije {
	
	private int brIndeksa;
	private int godinaUpisa;
	private int studije;
	
	private static int brStudenata;
	
	public Student(String osoba, String jmbg, int brIndeksa, int godinaUpisa, int studije){
		super(osoba, jmbg);
		this.brIndeksa = brIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.studije = studije;
		brStudenata++;
	}
	public Student(final Student s){
		super(s);
		brIndeksa = s.brIndeksa;
		godinaUpisa = s.godinaUpisa;
		studije = s.studije;
		brStudenata++;
	}

	public static int brStudenata() {
		return brStudenata;
	}
	public void setStudije(int studije) {
		this.studije = studije;
	}
	
	public String toString() {
		String tipS = "";
		if(studije == 0)
			tipS = "Osnovne";
		else if(studije == 1)
			tipS = "MSc";
		else
			tipS = "PhD";
		
		return "Student: " + super.toString() + 
			   "\nbroj indeksa: " + brIndeksa + "/" + String.valueOf(godinaUpisa).substring(2) +
			   "\nstudije: " + tipS;
	}
}
