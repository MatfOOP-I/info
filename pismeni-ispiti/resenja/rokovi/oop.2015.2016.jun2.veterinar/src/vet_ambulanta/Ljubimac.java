package vet_ambulanta;

public abstract class Ljubimac {

	private String ime;
	private int starost;
	private String id;
	
	public Ljubimac(String ime, int starost) {
		super();
		this.ime = ime;
		this.starost = starost;
		this.id = generisiIdenfitikaciju();
	}
	
	public Ljubimac(String ime, int starost, String id) {
		super();
		this.ime = ime;
		this.starost = starost;
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public int getStarost() {
		return starost;
	}
	
	public String getId() {
		return id;
	}
	
	public abstract String generisiIdenfitikaciju();

	@Override
	public String toString() {
		return "#" + id + " Ime: " + ime + ", starost: " + starost;
	}
	
}
