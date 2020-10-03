package pregled;

public enum FizickaAktivnost {

	S, M, A, VA;

	@Override
	public String toString() {
		switch (this) {
		case S:
			return "sedeci";
		case M:
			return "umereno aktivan";
		case A:
			return "aktivan";
		case VA:
			return "veoma aktivan";
		default:
			return "";
		}
	}
}
