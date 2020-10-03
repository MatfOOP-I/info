package rs.math.oop1.z080501.dogadjaji.z02.koriscenje;

import java.util.Scanner;

public class PokretanjeDogadjajiSunce {

   private static void koriscenje() {
      System.out.println("Naredbe: p-<ime> = pretplati <ime> na događaje ");
      System.out.println("         r-<ime> = raskini pretplatu <ime> na događaje ");
      System.out.println("         i       = emituj događaj izlazak sunca ");
      System.out.println("         z       = emituj događaj zalazak sunca ");
      System.out.println("         k       = kraj ");
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
      koriscenje();
      Scanner sc = new Scanner(System.in);
      SunceKretanjeDogadjajIzvor sunceKretanjeEmiter = new SunceKretanjeDogadjajIzvor();
      boolean gotovo = false;
      while (!gotovo) {
         String ulaz = sc.next().trim();
         char naredba = ulaz.toCharArray()[0];
         switch (naredba) {
            case 'p': {
               String ime = ulaz.substring(2);
               System.out.println("Pretplacuje se '" + ime + "' na dogadjaje kretanja sunca");
               if (ime.equals("suncokret"))
                  sunceKretanjeEmiter.dodajOsluskivac(suncokret);
               if (ime.equals("nocnafrajla"))
                  sunceKretanjeEmiter.dodajOsluskivac(nocnaFrajla);
               if (ime.equals("petar"))
                  sunceKretanjeEmiter.dodajOsluskivac(petar);
               if (ime.equals("mitar"))
                  sunceKretanjeEmiter.dodajOsluskivac(mitar);
               if (ime.equals("miki"))
                  sunceKretanjeEmiter.dodajOsluskivac(miki);
               if (ime.equals("paja"))
                  sunceKretanjeEmiter.dodajOsluskivac(paja);
               if (ime.equals("milica"))
                  sunceKretanjeEmiter.dodajOsluskivac(milica);
               if (ime.equals("supermen"))
                  sunceKretanjeEmiter.dodajOsluskivac(supermen);
               if (ime.equals("spajdermen"))
                  sunceKretanjeEmiter.dodajOsluskivac(spajdermen);
               break;
            }
            case 'r': {
               String ime = ulaz.substring(2);
               System.out.println("Raskida se pretplata '" + ime + "' na dogadjaje kretanja sunca");
               if (ime.equals("nocnafrajla"))
                  sunceKretanjeEmiter.ukloniOsluskivac(nocnaFrajla);
               if (ime.equals("petar"))
                  sunceKretanjeEmiter.ukloniOsluskivac(petar);
               if (ime.equals("mitar"))
                  sunceKretanjeEmiter.ukloniOsluskivac(mitar);
               if (ime.equals("miki"))
                  sunceKretanjeEmiter.ukloniOsluskivac(miki);
               if (ime.equals("paja"))
                  sunceKretanjeEmiter.ukloniOsluskivac(paja);
               if (ime.equals("milica"))
                  sunceKretanjeEmiter.ukloniOsluskivac(milica);
               if (ime.equals("supermen"))
                  sunceKretanjeEmiter.ukloniOsluskivac(supermen);
               if (ime.equals("spajdermen"))
                  sunceKretanjeEmiter.ukloniOsluskivac(spajdermen);
               break;
            }
            case 'i':
               System.out.println("Emituje se dogadjaj za izlazak sunca");
               sunceKretanjeEmiter.ispaliDogadjaj(true);
               break;
            case 'z':
               System.out.println("Emituje se dogadjaj za zalazak sunca");
               sunceKretanjeEmiter.ispaliDogadjaj(false);
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


