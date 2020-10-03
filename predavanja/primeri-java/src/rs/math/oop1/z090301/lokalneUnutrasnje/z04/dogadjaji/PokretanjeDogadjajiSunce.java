package rs.math.oop1.z090301.lokalneUnutrasnje.z04.dogadjaji;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PokretanjeDogadjajiSunce {

   private static void koriscenje() {
      System.out.println("Naredbe: p-<imeObjekta>-<slusalac> = kreiraj <slusalac>, pridruzi ga na <imeObjekta> ");
      System.out.println("                                  i pretplati slusalac na događaje ");
      System.out.println("         i = emituj događaj izlazak sunca ");
      System.out.println("         z = emituj događaj zalazak sunca ");
      System.out.println("         k = kraj ");
   }

   private void izvrsi() {
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
      System.out.println( "OsluskivacKretanjaSuncaCvetNormalni"
            + " - " + "SCvNor");
      System.out.println("OsluskivacKretanjaSuncaCvetInverzni"
            + " - " + "SCvInv");
      System.out.println("OsluskivacKretanjaSuncaDanUNedelji"
            + " - " + "SCoDun");
      System.out.println("OsluskivacKretanjaSuncaRaspust"
            + " - " + "SStRas");
      System.out.println();
      koriscenje();
      Scanner sc = new Scanner(System.in);
      SunceKretanjeEmiter emiter = new SunceKretanjeEmiter();
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
                  final class OsluskivacKretanjaSuncaCvetNormalni implements SunceKretanjeOsluskivac {

                     private Cvet trpiUticaj;

                     public OsluskivacKretanjaSuncaCvetNormalni(Cvet trpiUticaj) {
                        this.trpiUticaj = trpiUticaj;
                     }

                     @Override
                     public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
                        if(e.isIzaslo())
                           System.out.printf("Cvet %s je rasirio svoj cvet \n", trpiUticaj);
                        if(e.isZaslo())
                           System.out.printf("Cvet %s je sakupio svoj cvet \n", trpiUticaj);
                     }
                  }

                  if (tipOsluskivaca.equals("SCvNor")) {
                     OsluskivacKretanjaSuncaCvetNormalni slusa = new OsluskivacKretanjaSuncaCvetNormalni(
                           (Cvet) objekat);
                     emiter.dodajOsluskivac(slusa);
                  } else if (tipOsluskivaca.equals("SCvInv")) {
                     final class OsluskivacKretanjaSuncaCvetInverzni implements SunceKretanjeOsluskivac {

                        private Cvet trpiUticaj;

                        public OsluskivacKretanjaSuncaCvetInverzni(Cvet trpiUticaj) {
                           this.trpiUticaj = trpiUticaj;
                        }

                        @Override
                        public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
                           if(e.isIzaslo())
                              System.out.printf("Cvet %s je sakupio svoj cvet \n", trpiUticaj);
                           if(e.isZaslo())
                              System.out.printf("Cvet %s je rasirio svoj cvet \n", trpiUticaj);
                        }
                     }
                     OsluskivacKretanjaSuncaCvetInverzni slusa = new OsluskivacKretanjaSuncaCvetInverzni(
                           (Cvet) objekat);
                     emiter.dodajOsluskivac(slusa);
                  } else {
                     System.err.println("Specificiran nekompatiblini osluskivac");
                     break;
                  }
               } else if (objekat instanceof Student) {
                  if (tipOsluskivaca.equals("SStRas")) {
                     final class OsluskivacKretanjaSuncaRaspust implements SunceKretanjeOsluskivac {

                        private Student meta;

                        public OsluskivacKretanjaSuncaRaspust(Student meta) {
                           this.meta = meta;
                        }

                        @Override
                        public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
                           LocalDateTime datumVreme = e.getDatumVreme();
                           DateTimeFormatter formatDatum = DateTimeFormatter.ofPattern("dd.MM.YYYY.");
                           DateTimeFormatter formatVreme = DateTimeFormatter.ofPattern("HH:mm:ss");
                           System.out.printf("%s kaže: Sunce je dana %s %s u vreme %s. ",
                                 meta, datumVreme.format(formatDatum),
                                 e.isIzaslo() ? "izaslo" : "zaslo",
                                 datumVreme.format(formatVreme));
                           if (meta.isNaRaspustu()) {
                              if (e.isIzaslo()) {
                                 meta.setStatus(Status.SPAVANJE);
                                 System.out.printf("Zavrsen provod, idem na spavanje. Moj novi status: %s\n",
                                       Status.opis(meta.getStatus()));
                              } else {
                                 meta.setStatus(Status.PROVOD);
                                 System.out.printf("Gde cemo nocas u provod? Moj novi status: %s.\n",
                                       Status.opis(meta.getStatus()));
                              }
                           } else {
                              if (e.isIzaslo()) {
                                 meta.setStatus(Status.UCENJE);
                                 System.out.printf("Pocinje novi dan, moram da ucim. Moj novi status: %s.\n",
                                       Status.opis(meta.getStatus()));
                              } else {
                                 meta.setStatus(Status.SPAVANJE);
                                 System.out.printf("Vredno sam ucio, jos malo pa na spavanje. Moj novi status: %s.\n",
                                       Status.opis(meta.getStatus()));
                              }
                           }
                        }
                     }
                     OsluskivacKretanjaSuncaRaspust slusa = new OsluskivacKretanjaSuncaRaspust(
                           (Student) objekat);
                     emiter.dodajOsluskivac(slusa);
                  } else if (tipOsluskivaca.equals("SCoDun")) {
                     final class OsluskivacKretanjaSuncaDanUNedelji implements SunceKretanjeOsluskivac {

                        final class DanUNedelji {
                           public static final int PONEDELJAK = 1;
                           public static final int UTORAK = 2;
                           public static final int SREDA = 3;
                           public static final int CETVRTAK = 4;
                           public static final int PETAK = 5;
                           public static final int SUBOTA = 6;
                           public static final int NEDELJA = 7;

                           public final String opis(int dan) {
                              switch (dan) {
                                 case PONEDELJAK:
                                    return "ponedeljak";
                                 case UTORAK:
                                    return "utorak";
                                 case SREDA:
                                    return "sreda";
                                 case CETVRTAK:
                                    return "cetvrtak";
                                 case PETAK:
                                    return "petak";
                                 case SUBOTA:
                                    return "subota";
                                 case NEDELJA:
                                    return "nedelja";
                                 default:
                                    return "ovo ne bi smelo da se pojavi!";
                              }
                           }

                        }

                        private Covek meta;

                        public OsluskivacKretanjaSuncaDanUNedelji(Covek meta) {
                           this.meta = meta;
                        }

                        @Override
                        public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
                           LocalDateTime datumVreme = e.getDatumVreme();
                           DateTimeFormatter formatDatum = DateTimeFormatter.ofPattern("dd.MM.YYYY.");
                           DateTimeFormatter formatVreme = DateTimeFormatter.ofPattern("HH:mm:ss");
                           System.out.printf("%s kaže: Sunce je dana %s %s u vreme %s. ",
                                 meta, datumVreme.format(formatDatum),
                                 e.isIzaslo() ? "izaslo" : "zaslo", datumVreme.format(formatVreme));
                           int danUNedelji = datumVreme.getDayOfWeek().getValue();
                           System.out.printf(" %s - ", (new DanUNedelji()).opis(danUNedelji));
                           switch (danUNedelji) {
                              case DanUNedelji.PONEDELJAK:
                                 if (e.isIzaslo()) {
                                    meta.setStatus(Status.RAD);
                                    System.out.printf("Pcinje rad u novoj radnoj nedelji :( Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 if (e.isZaslo()) {
                                    meta.setStatus(Status.SPAVANJE);
                                    System.out.printf("Nekako sam pregurao prvi radni dan... Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 break;
                              case DanUNedelji.UTORAK:
                              case DanUNedelji.SREDA:
                              case DanUNedelji.CETVRTAK:
                                 if (e.isIzaslo()) {
                                    meta.setStatus(Status.RAD);
                                    System.out.printf("I danas treba uskoro da se pocne sa radom. Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 if (e.isZaslo()) {
                                    meta.setStatus(Status.SPAVANJE);
                                    System.out.printf("Za danas sam zavrsio sa poslom... Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 break;
                              case DanUNedelji.PETAK:
                                 if (e.isIzaslo()) {
                                    meta.setStatus(Status.RAD);
                                    System.out.printf("Sto bi petak bio lepsi da sutra nije subota radna. Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 if (e.isZaslo()) {
                                    meta.setStatus(Status.SPAVANJE);
                                    System.out.printf("Kraj dansenjeg posla. Jos sutra pa gotovo. Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 break;
                              case DanUNedelji.SUBOTA:
                                 if (e.isIzaslo()) {
                                    meta.setStatus(Status.RAD);
                                    System.out.printf("Mrzim radne subote! Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 if (e.isZaslo()) {
                                    meta.setStatus(Status.SPAVANJE);
                                    System.out.printf("Kraj subotnjeg posla. Slobodan sam!  Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 break;
                              case DanUNedelji.NEDELJA:
                                 if (e.isIzaslo()) {
                                    meta.setStatus(Status.ODMOR);
                                    System.out.printf("Sloboda!!! Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 if (e.isZaslo()) {
                                    meta.setStatus(Status.SPAVANJE);
                                    System.out.printf("Jos malo, pa ponovo na posao :(  Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 break;
                              default:
                                 System.out.printf("Ovo nikad ne bi smelo da se pojavi");
                           }
                        }
                     }
                     OsluskivacKretanjaSuncaDanUNedelji slusa = new OsluskivacKretanjaSuncaDanUNedelji(
                           (Covek) objekat);
                     emiter.dodajOsluskivac(slusa);
                  } else {
                     System.err.println("Specificiran nekompatiblini osluskivac");
                     break;
                  }
               } else if (objekat instanceof Covek) {
                  if (tipOsluskivaca.equals("SCoDun")) {

                     final class OsluskivacKretanjaSuncaDanUNedelji implements SunceKretanjeOsluskivac {

                        final class DanUNedelji {
                           public static final int PONEDELJAK = 1;
                           public static final int UTORAK = 2;
                           public static final int SREDA = 3;
                           public static final int CETVRTAK = 4;
                           public static final int PETAK = 5;
                           public static final int SUBOTA = 6;
                           public static final int NEDELJA = 7;

                           public final String opis(int dan) {
                              switch (dan) {
                                 case PONEDELJAK:
                                    return "ponedeljak";
                                 case UTORAK:
                                    return "utorak";
                                 case SREDA:
                                    return "sreda";
                                 case CETVRTAK:
                                    return "cetvrtak";
                                 case PETAK:
                                    return "petak";
                                 case SUBOTA:
                                    return "subota";
                                 case NEDELJA:
                                    return "nedelja";
                                 default:
                                    return "ovo ne bi smelo da se pojavi!";
                              }
                           }

                        }

                        private Covek meta;

                        public OsluskivacKretanjaSuncaDanUNedelji(Covek meta) {
                           this.meta = meta;
                        }

                        @Override
                        public void sunceSePomerilo(SunceKretanjeDogadjaj e) {
                           LocalDateTime datumVreme = e.getDatumVreme();
                           DateTimeFormatter formatDatum = DateTimeFormatter.ofPattern("dd.MM.YYYY.");
                           DateTimeFormatter formatVreme = DateTimeFormatter.ofPattern("HH:mm:ss");
                           System.out.printf("%s kaže: Sunce je dana %s %s u vreme %s. ",
                                 meta, datumVreme.format(formatDatum),
                                 e.isIzaslo() ? "izaslo" : "zaslo", datumVreme.format(formatVreme));
                           int danUNedelji = datumVreme.getDayOfWeek().getValue();
                           System.out.printf(" %s - ", (new DanUNedelji()).opis(danUNedelji));
                           switch (danUNedelji) {
                              case DanUNedelji.PONEDELJAK:
                                 if (e.isIzaslo()) {
                                    meta.setStatus(Status.RAD);
                                    System.out.printf("Pcinje rad u novoj radnoj nedelji :( Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 if (e.isZaslo()) {
                                    meta.setStatus(Status.SPAVANJE);
                                    System.out.printf("Nekako sam pregurao prvi radni dan... Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 break;
                              case DanUNedelji.UTORAK:
                              case DanUNedelji.SREDA:
                              case DanUNedelji.CETVRTAK:
                                 if (e.isIzaslo()) {
                                    meta.setStatus(Status.RAD);
                                    System.out.printf("I danas treba uskoro da se pocne sa radom. Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 if (e.isZaslo()) {
                                    meta.setStatus(Status.SPAVANJE);
                                    System.out.printf("Za danas sam zavrsio sa poslom... Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 break;
                              case DanUNedelji.PETAK:
                                 if (e.isIzaslo()) {
                                    meta.setStatus(Status.RAD);
                                    System.out.printf("Sto bi petak bio lepsi da sutra nije subota radna. Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 if (e.isZaslo()) {
                                    meta.setStatus(Status.SPAVANJE);
                                    System.out.printf("Kraj dansenjeg posla. Jos sutra pa gotovo. Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 break;
                              case DanUNedelji.SUBOTA:
                                 if (e.isIzaslo()) {
                                    meta.setStatus(Status.RAD);
                                    System.out.printf("Mrzim radne subote! Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 if (e.isZaslo()) {
                                    meta.setStatus(Status.SPAVANJE);
                                    System.out.printf("Kraj subotnjeg posla. Slobodan sam!  Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 break;
                              case DanUNedelji.NEDELJA:
                                 if (e.isIzaslo()) {
                                    meta.setStatus(Status.ODMOR);
                                    System.out.printf("Sloboda!!! Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 if (e.isZaslo()) {
                                    meta.setStatus(Status.SPAVANJE);
                                    System.out.printf("Jos malo, pa ponovo na posao :(  Moj novi status: %s. \n",
                                          Status.opis(meta.getStatus()));
                                 }
                                 break;
                              default:
                                 System.out.printf("Ovo nikad ne bi smelo da se pojavi");
                           }
                        }
                     }
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

   public static void main(String... argumenti) {
      (new PokretanjeDogadjajiSunce()).izvrsi();
   }


}


