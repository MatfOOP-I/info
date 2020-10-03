package rs.math.oop1.z080401.polimorfizam.z02.ljudi;

/**
 * 
 * Program ilustruje koncept nasleđivanja.
 *
 */
public class PokretanjeLjudi2
{

  public static void main(String[] args)
  {
    Apsolvent neko = new Apsolvent();
    neko.ime = "Janko";
    neko.prezime = "Jankovic";
    neko.smer = "I smer";
    neko.brojIndeksa = "12/2012";
    neko.godinaStudija = 3;
    neko.predstaviSe();
       
    Student janko = new Student();
    janko.ime = "Janko";
    janko.prezime = "Jankovic";
    janko.smer = "I smer";
    janko.brojIndeksa = "12/2012";
    janko.godinaStudija = 3;
    janko.predstaviSe();
    
    Nastavnik milica = new Nastavnik();
    milica.ime = "Milica";
    milica.prezime = "Jankovic";
    milica.predmet = "OOP";
    milica.godinaStaza = 12;    
    milica.predstaviSe();
  }

}
