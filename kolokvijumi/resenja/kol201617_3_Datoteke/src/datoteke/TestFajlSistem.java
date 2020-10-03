package datoteke;

public class TestFajlSistem {

	public static void main(String[] args) {
		
		Datoteka datoteka = new Datoteka("mojfajl.txt", "-rwxr-xr-x", "lorem ipsum");
		Direktorijum dir1 = new Direktorijum("dir1", "drwxr-xr-x");
		ElementFajlSistema el[] = new ElementFajlSistema[2];
		el[0] = dir1;
		el[1] = datoteka;
		Direktorijum dir2 = new Direktorijum("dir2", "drwxr-xr-x", el);
		
		ElementFajlSistema[] elementi = {datoteka, dir1, dir2};
		for(ElementFajlSistema e : elementi) {
			System.out.println(e);
			e.ispisiSadrzaj();
			System.out.println("------------------------");
		}
	}
}
