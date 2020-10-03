package softverskaMreza;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SoftverskaMreza {
	private String ime;
	private Map<String, List<Softver>> podaci;

	public SoftverskaMreza(String ime) {
		this.ime = ime;
		this.podaci = new TreeMap<>();
	}

	public boolean ucitajPodatke(String putanja) {
		Path ulaz = Paths.get(putanja);
		try {
			List<String> linije = Files.readAllLines(ulaz);
			for (String linija : linije) {
				String[] tokeni = linija.split(",");
				String tip = tokeni[0].trim();
				String ime = tokeni[1].trim();
				int brojLinija = Integer.parseInt(tokeni[2].trim());
				String jezik = tokeni[3].trim();

				// Pravimo listu za jezik ukoliko vec ne postoji
				// NAPOMENA: Ovo je izuzetno bitan detalj, svaki jezik u mapi
				// morati imati SOPSTVENU listu.
				if (!podaci.containsKey(jezik))
					podaci.put(jezik, new ArrayList<>());

				// Posto smo u prethodnom if-u obezbedili da uvek za jezik postoji
				// lista u mapi, naredni poziv metoda 'get' nad mapom sigurno
				// vraca instanciranu listu za prosledjeni jezik.
				if (tip.equals("1")) {
					String najecesciJezik = tokeni[4].trim();
					
					podaci.get(jezik).add(new Editor(ime, jezik, brojLinija, najecesciJezik));
					//      ^ vraca List<Softver>
					//                 ^ dodaje novi editor u listu
				} else {
					String opis = tokeni[4].trim();
					podaci.get(jezik).add(new Biblioteka(ime, jezik, brojLinija, opis));
				}
			}
			return true;
		} catch (IOException e) {
			System.out.println("Neuspelo otvaranje datoteke na putanji: " + putanja);
			return false;
		}
	}

	public String najpopularnijiJezik() {
		String jezik = "nema podataka";
		
		// Inicijalni maksimum.
		int brojPrograma = -1;

		// Jezik sa najvise programa je kljuc u mapi koji se preslikava
		// u listu sa najvise elemenata.
		for (Entry<String, List<Softver>> entry : podaci.entrySet()) {
			if (entry.getValue().size() > brojPrograma) {
				jezik = entry.getKey();
				brojPrograma = entry.getValue().size();
			}
		}

		return jezik;
	}

	// Metod 'get' vraca null ukoliko ne postoji softver za prosledjeni jezik,
	// treba obraditi ovaj slucaj pri pozivu metoda.
	public List<Softver> softverZaJezik(String jezik) {
		return podaci.get(jezik);
	}

	// Vraca ukupno linija koda za prosledjeni jezik.
	// Ukoliko jezik ne postoji u mapi, vraca 0.
	public int ukupnoLinijaKodaZaJezik(String jezik) {
		List<Softver> softver = podaci.get(jezik);
		// Slucaj kada mapa ne sadrzi podatke o prosledjenom jeziku.
		if (softver == null)
			return 0;

		int ukupnoLinijaZaJezik = 0;
		for (Softver s : softver)
			ukupnoLinijaZaJezik += s.getBrojLinija();

		return ukupnoLinijaZaJezik;
	}

	// Sumira broj linija koda u softverskoj mrezi.
	public int ukupnoLinija() {
		int ukupnoLinija = 0;
		for (String jezik : podaci.keySet())
			ukupnoLinija += ukupnoLinijaKodaZaJezik(jezik);
		return ukupnoLinija;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Softverska mreza: " + ime + "\n\n");

		for (Entry<String, List<Softver>> entry : podaci.entrySet()) {
			sb.append(entry.getKey()).append(":\n");
			for (Softver s : entry.getValue())
				sb.append("* " + s.toString() + "\n");
			sb.append("\n");
		}

		return sb.toString();
	}
}
