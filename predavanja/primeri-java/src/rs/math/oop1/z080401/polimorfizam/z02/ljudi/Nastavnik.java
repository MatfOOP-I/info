package rs.math.oop1.z080401.polimorfizam.z02.ljudi;

class Nastavnik extends Covek
{
  String predmet;
  int godinaStaza;

  void predstaviSe()
  {
    System.out.println("Nastavnik: " 
      + ime + " " + prezime + " " 
      + predmet +" " + godinaStaza + "." + jeDobar() );
  }
  
  boolean jeDobar()
  {
  	return false;
  }
}