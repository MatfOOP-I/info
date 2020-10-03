package predmeti;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class PlanNastave {
	public List<Predmet> predmeti;
	
	public PlanNastave() {
		predmeti = new ArrayList<>();
	}
	
	public boolean ucitajPredmete(String putanja){
		try (Scanner sc = new Scanner(Paths.get(putanja))) {
			while(sc.hasNextLine()){
				String[] str = sc.nextLine().split(",");
				if(str[0].charAt(0) == 'O') {
					predmeti.add(new ObavezanPredmet(str[2], str[3], Integer.parseInt(str[1]), Integer.parseInt(str[4]), Integer.parseInt(str[5])));
				}
				else {
					predmeti.add(new IzborniPredmet(str[2], str[3], Integer.parseInt(str[1]), Integer.parseInt(str[4]), str[5].charAt(0)));
				}
			}
			return true;
		} catch (IOException e) {
			return false;
		}
	}

	public boolean ucitajUslovne(String putanja) {
		try (Scanner sc = new Scanner(Paths.get(putanja))) {
			while(sc.hasNextLine()){
				String[] str = sc.nextLine().split(",");
				dodajUslovni(str[0], str[1]);
			}
			return true;
		} catch (IOException e) {
			return false;
		}
	}
	
	private void dodajUslovni(String predmet, String uslovniPredmet){
		for(Predmet p : predmeti) {
			if(p.getSifra().equals(predmet))
				((ObavezanPredmet)p).dodajUslovniPredmet(uslovniPredmet);
		}
	}
	
	public String ispisi(String opseg) {
		StringBuilder sb = new StringBuilder();
		// sortiranje
		Collections.sort(predmeti);
		for(Predmet k : predmeti) {
			if(opseg.equals("SVI")) {
				sb.append(k.toString() + "\n");
				sb.append("---------------------------------\n");
			}
			else if(opseg.equals("OBAVEZNI")) {
				if(k instanceof ObavezanPredmet) {
					sb.append(k.toString() + "\n");
					sb.append("---------------------------------\n");
				}
			}
			else if (k instanceof IzborniPredmet) {
				sb.append(k.toString() + "\n");
				sb.append("---------------------------------\n");
			}
			
		}
		return sb.toString();
	}
}
