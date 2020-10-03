package dekodiranje;

public class KodiranaPoruka {
	private String bitoviM;
	private String bitoviC;
	
	public KodiranaPoruka(String bitoviM, String bitoviC) {
		this.bitoviM = bitoviM;
		this.bitoviC = bitoviC;
	}
	public String getBitoviM() {
		return bitoviM;
	}
	public String getBitoviC() {
		return bitoviC;
	}
	public String toString() {
		return bitoviM + " : " + bitoviC;
	}
}
