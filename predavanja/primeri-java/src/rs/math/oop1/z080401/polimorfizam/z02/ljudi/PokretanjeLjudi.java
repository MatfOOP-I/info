package rs.math.oop1.z080401.polimorfizam.z02.ljudi;

/**
 * 
 * Program ilustruje koncept nasleđivanja.
 *
 */
public class PokretanjeLjudi
{

  public static void main(String[] args)
  {
    Covek marko = new Covek();
    marko.ime = "Marko";
    marko.prezime = "Markovic";
    
    Student janko = new Student();
    janko.ime = "Janko";
    janko.prezime = "Jankovic";
    janko.smer = "L smer";
    janko.brojIndeksa = "12/2012";
    janko.godinaStudija = 3;
    
    Nastavnik milica = new Nastavnik();
    milica.ime = "Milica";
    milica.prezime = "Jankovic";
    milica.predmet = "OOP";
    milica.godinaStaza = 12;
    
    marko.predstaviSe();
    janko.predstaviSe();
    milica.predstaviSe();
  }

}
