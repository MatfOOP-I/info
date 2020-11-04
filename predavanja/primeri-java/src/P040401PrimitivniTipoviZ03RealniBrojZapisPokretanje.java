// Програм илуструје запис реалних бројева у две различите прецизности. 

class PokretanjeRealniiTip {

	public static void main(String[] args) {
		// realni literal u dvostrukoj preciznosti, ovo je i podrazumevana preciznost za
		// realni broj
		double d1 = 23.57;
		// za jednostruku preciznost se mora eksplicitno navesti kvalifikator f na kraju
		// broja
		float f1 = 23.57f;
		float f2 = 23.57F;
		// može i veliko slovo F
		double d2 = .454;
		// celobrojni deo se može izostaviti, i tada se podrazumeva da iznosti 0
		double d3 = 2.2e-5;
		// broj koji iznosi 2.2 x 10^(-5)
		float f3 = 2e5f; // broj koji iznosi 2 x 10^5 = 200000.0 u jednostrukoj preciznosti
		System.out.println(f3);
		float f4 = 35535353.000003f;
		System.out.println(f4);
		// ispisuje 3.5535352E7, jer nema dovoljnu preciznost da zapamti ceo broj
		double d4 = 35535353.00003;
		System.out.println(d4);
		// ispisuje 3.553535300003E7, što je tačan broj
		double d5 = 35535353.0000000003;
		System.out.println(d5);
		// ispisuje 3.5535353E7, jer ni dvostruka preciznost više nije dovoljna

		double inf1 = 7.0 / (3 - 3);
		System.out.println(inf1);
		double inf2 = 8 - inf1;
		System.out.println(inf2);
		double rez = inf1 + inf2;
		System.out.println(rez);

	}
}
