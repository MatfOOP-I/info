package rs.math.oop1.z080501.dogadjaji.z03.koriscenje;

import java.util.Scanner;

public class PokretanjeDogadjajiSunce2 {

   private static int BROJ_CVETOVA = 4;

   private static void koriscenje() {
      System.out.println("Naredbe: p-<imeObjekta>-<slusalac> = kreiraj <slusalac>, pridruzi ga na <imeObjekta> ");
      System.out.println("                                  i pretplati slusalac na događaje ");
      System.out.println("         i = emituj događaj izlazak sunca ");
      System.out.println("         z = emituj događaj zalazak sunca ");
      System.out.println("         k = kraj ");
   }

   public static void main(String... argumenti) {
      System.out.println("Objekti: ");
      Suncokret suncokret = new Suncokret();
      System.out.println("suncokret");
      NocnaFrajla nocnaFrajla = new NocnaFrajla();
      System.out.println("nocnafrajla");
      Student petar = new Student("petar");
      System.out.println(petar);
      Student mitar = new Student("mitar");
      System.out.println(mitar);
      Student miki = new Student("miki", true);
      System.out.println(miki);
      Student paja = new Student("paja", true);
      System.out.println(paja);
      Student milica = new Student("milica");
      System.out.println(milica);
      Radnik supermen = new Radnik("supermen");
      System.out.println(supermen);
      Radnik spajdermen = new Radnik("spajdermen");
      System.out.println(spajdermen);
      System.out.println();

      System.out.println("Slusaoci: ");
      System.out.println(OsluskivacKretanjaSuncaCvetNormalni.class
            + " - " + OsluskivacKretanjaSuncaCvetNormalni.skracenica);
      System.out.println(OsluskivacKretanjaSuncaCvetInverzni.class
            + " - " + OsluskivacKretanjaSuncaCvetInverzni.skracenica);
      System.out.println(OsluskivacKretanjaSuncaDanUNedelji.class
            + " - " + OsluskivacKretanjaSuncaDanUNedelji.skracenica);
      System.out.println(OsluskivacKretanjaSuncaRaspust.class
            + " - " + OsluskivacKretanjaSuncaRaspust.skracenica);
      System.out.println();
      koriscenje();
      Scanner sc = new Scanner(System.in);
      SunceKretanjeDogadjajIzvor emiter = new SunceKretanjeDogadjajIzvor();
      boolean gotovo = false;
      while (!gotovo) {
         String ulaz = sc.next().trim();
         char naredba = ulaz.charAt(0);
         switch (naredba) {
            case 'p': {
               String[] delovi = ulaz.split("-");
               if( delovi.length != 3){
                  System.err.println("Komanda nema pravilan format");
                  break;
               }
               String imeObjekta = delovi[1];
               String tipOsluskivaca = delovi[2];
               System.out.println("Pretplata na dogadjaj - objekat: "
                     + imeObjekta + " osluskivac tip: " + tipOsluskivaca);
               Object objekat = null;
               if (imeObjekta.equals("suncokret"))
                  objekat = suncokret;
               else if (imeObjekta.equals("nocnafrajla"))
                  objekat = nocnaFrajla;
               else if (imeObjekta.equals("petar"))
                  objekat = petar;
               else if (imeObjekta.equals("mitar"))
                  objekat = mitar;
               else if (imeObjekta.equals("miki"))
                  objekat = miki;
               else if (imeObjekta.equals("paja"))
                  objekat = paja;
               else if (imeObjekta.equals("milica"))
                  objekat = milica;
               else if (imeObjekta.equals("supermen"))
                  objekat = supermen;
               else if (imeObjekta.equals("spajdermen"))
                  objekat = spajdermen;
               else {
                  System.err.println("Nije specificairan pravi objekat!");
                  break;
               }
               if (objekat instanceof Cvet) {
                  if (tipOsluskivaca.equals(OsluskivacKretanjaSuncaCvetNormalni.skracenica)) {
                     OsluskivacKretanjaSuncaCvetNormalni slusa = new OsluskivacKretanjaSuncaCvetNormalni(
                           (Cvet) objekat);
                     emiter.dodajOsluskivac(slusa);
                  } else if (tipOsluskivaca.equals(OsluskivacKretanjaSuncaCvetInverzni.skracenica)) {
                     OsluskivacKretanjaSuncaCvetInverzni slusa = new OsluskivacKretanjaSuncaCvetInverzni(
                           (Cvet) objekat);
                     emiter.dodajOsluskivac(slusa);
                  } else {
                     System.err.println("Specificiran nekompatiblini osluskivac");
                     break;
                  }
               } else if (objekat instanceof Student) {
                  if (tipOsluskivaca.equals(OsluskivacKretanjaSuncaRaspust.skracenica)) {
                     OsluskivacKretanjaSuncaRaspust slusa = new OsluskivacKretanjaSuncaRaspust(
                           (Student) objekat);
                     emiter.dodajOsluskivac(slusa);
                  } else if (tipOsluskivaca.equals(OsluskivacKretanjaSuncaDanUNedelji.skracenica)) {
                     OsluskivacKretanjaSuncaDanUNedelji slusa = new OsluskivacKretanjaSuncaDanUNedelji(
                           (Covek) objekat);
                     emiter.dodajOsluskivac(slusa);
                  } else {
                     System.err.println("Specificiran nekompatiblini osluskivac");
                     break;
                  }
               } else if (objekat instanceof Covek) {
                  if (tipOsluskivaca.equals(OsluskivacKretanjaSuncaDanUNedelji.skracenica)) {
                     OsluskivacKretanjaSuncaDanUNedelji slusa = new OsluskivacKretanjaSuncaDanUNedelji(
                           (Covek) objekat);
                     emiter.dodajOsluskivac(slusa);
                  } else {
                     System.err.println("Specificiran nekompatiblini osluskivac");
                     break;
                  }
               } else {
                  System.err.println("Specificiran nepostojeci osluskivac");
                  break;
               }
               break;
            }
            case 'i':
               System.out.println("Emituje se dogadjaj za izlazak sunca");
               emiter.ispaliDogadjaj(true);
               break;
            case 'z':
               System.out.println("Emituje se dogadjaj za zalazak sunca");
               emiter.ispaliDogadjaj(false);
               break;
            case 'k':
               System.out.println("Zavrsetak rada");
               gotovo = true;
               break;
            default:
               System.out.println("Nekorektna naredba");
               koriscenje();
         }
      }
      sc.close();
   }
}


