package rs.math.oop1.z080100.apstraktneKlase.z06.zaposleniMenadzeri;

class Student extends Osoba
{
	private String usmerenje;

	public Student( String ime, String usmerenje, int godina, int mesec, int dan ) {
		super( ime, godina, mesec, dan );
		this.usmerenje = usmerenje;
	}
	
	public String getUsmerenje() {
		return usmerenje;
	}

	@Override
	public String toString() {
		return "Student{" +
				super.toString() +
				"usmerenje='" + usmerenje + '\'' +
				'}';
	}
}
