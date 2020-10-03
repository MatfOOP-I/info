package rs.math.oop1.z080501.dogadjaji.z03.koriscenje;

import java.util.Scanner;

public class PokretanjeDogadjajiSunce {

   private static int BROJ_CVETOVA = 4;

   private static void koriscenje() {
      System.out.println("Naredbe: p-s = pretplati sve studente na događaje ");
      System.out.println("         r-s = raskini pretplatu za sve studente na događaje ");
      System.out.println("         p-r = pretplati sve radnike na događaje ");
      System.out.println("         r-r = raskini pretplatu za sve radnike na događaje ");
      System.out.println("         p-c = pretplati sve cvetove na događaje ");
      System.out.println("         r-c = raskini pretplatu za sve cvetove na događaje ");
      System.out.println("         i    = emituj događaj izlazak sunca ");
      System.out.println("         z    = emituj događaj zalazak sunca ");
      System.out.println("         k    = kraj ");
   }

   public static void main(String... argumenti) {
      Suncokret[] suncokreti = new Suncokret[BROJ_CVETOVA];
      OsluskivacKretanjaSuncaCvetNormalni[] slusaociCvetovi = new OsluskivacKretanjaSuncaCvetNormalni[BROJ_CVETOVA];
      for (int i = 0; i < suncokreti.length; i++) {
         suncokreti[i] = new Suncokret();
         slusaociCvetovi[i] = new OsluskivacKretanjaSuncaCvetNormalni(suncokreti[i]);
         System.out.println(suncokreti[i]);
      }
      Student petar = new Student("petar");
      Student mitar = new Student("mitar");
      Student miki = new Student("miki", true);
      Student paja = new Student("paja", true);
      Student milica = new Student("milica");
      Student[] studenti = {petar, mitar, miki, paja, milica};
      OsluskivacKretanjaSuncaRaspust[] slusaociRaspust = new OsluskivacKretanjaSuncaRaspust[studenti.length - 1];
      for (int i = 0; i < studenti.length - 1; i++) {
         slusaociRaspust[i] = new OsluskivacKretanjaSuncaRaspust(studenti[i]);
         System.out.println(studenti[i]);
      }
      Radnik supermen = new Radnik("supermen");
      Radnik spajdermen = new Radnik("spajdermen");
      Radnik[] radnici = {supermen, spajdermen};
      OsluskivacKretanjaSuncaDanUNedelji[] slusaociDanUNedelji =
            new OsluskivacKretanjaSuncaDanUNedelji[radnici.length + 1];
      for (int i = 0; i < radnici.length; i++) {
         slusaociDanUNedelji[i] = new OsluskivacKretanjaSuncaDanUNedelji(radnici[i]);
         System.out.println(studenti[i]);
      }
      slusaociDanUNedelji[radnici.length] = new OsluskivacKretanjaSuncaDanUNedelji(
            studenti[studenti.length - 1]);
      System.out.println();
      koriscenje();
      Scanner sc = new Scanner(System.in);
      SunceKretanjeDogadjajIzvor sunceKretanje = new SunceKretanjeDogadjajIzvor();
      boolean gotovo = false;
      while (!gotovo) {
         String ulaz = sc.next().trim();
         char naredba = ulaz.toCharArray()[0];
         switch (naredba) {
            case 'p': {
               char tip = ulaz.charAt(2);
               System.out.println("Kreira se pretplata '" + tip + "' na dogadjaje kretanja sunca");
               switch (tip) {
                  case 's':
                     for (OsluskivacKretanjaSuncaRaspust slusa : slusaociRaspust)
                        sunceKretanje.dodajOsluskivac(slusa);
                     break;
                  case 'r':
                     for (OsluskivacKretanjaSuncaDanUNedelji slusa : slusaociDanUNedelji)
                        sunceKretanje.dodajOsluskivac(slusa);
                     break;
                  case 'c':
                     for (OsluskivacKretanjaSuncaCvetNormalni slusa : slusaociCvetovi)
                        sunceKretanje.dodajOsluskivac(slusa);
                     break;
                  default:
               }
               break;
            }
            case 'r': {
               char tip = ulaz.charAt(2);
               System.out.println("Raskida se pretplata '" + tip + "' na dogadjaje kretanja sunca");
               switch (tip) {
                  case 's':
                     for (OsluskivacKretanjaSuncaRaspust slusa : slusaociRaspust)
                        sunceKretanje.ukloniOsluskivac(slusa);
                     break;
                  case 'r':
                     for (OsluskivacKretanjaSuncaDanUNedelji slusa : slusaociDanUNedelji)
                        sunceKretanje.ukloniOsluskivac(slusa);
                     break;
                  case 'c':
                     for (OsluskivacKretanjaSuncaCvetNormalni slusa : slusaociCvetovi)
                        sunceKretanje.ukloniOsluskivac(slusa);
                     break;
                  default:
               }
               break;
            }
            case 'i':
               System.out.println("Emituje se dogadjaj za izlazak sunca");
               sunceKretanje.ispaliDogadjaj(true);
               break;
            case 'z':
               System.out.println("Emituje se dogadjaj za zalazak sunca");
               sunceKretanje.ispaliDogadjaj(false);
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


