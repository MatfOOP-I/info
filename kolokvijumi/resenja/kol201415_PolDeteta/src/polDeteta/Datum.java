package polDeteta;

public class Datum {

	private int dan, mesec, godina;
	
	public Datum(int dan, int mesec, int godina) {
		this.dan=dan;
		this.mesec=mesec;
		this.godina=godina;
	}
	
	public Datum(final Datum d) {
		dan=d.dan;
		mesec=d.mesec;
		godina=d.godina;
	}
	
	public int getDan(){
		return dan;
	}
	public int getMesec(){
		return mesec;
	}
	public int getGodina(){
		return godina;
	}
	public void setDan(int dan){
		this.dan=dan;
	}
	public void setMesec(int mesec){
		this.mesec=mesec;
	}
	public void setGodina(int godina){
		this.godina=godina;
	}
	
	public String toString() {
		return dan + "." + mesec + "." + godina + ".";
	}
}
