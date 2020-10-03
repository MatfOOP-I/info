package rs.math.oop1.z070502.prevazilazenje.z02.ljudi;

class Nastavnik
{
  String ime;
  String prezime;
  String predmet;
  int godinaStaza;

  void predstaviSe()
  {
    System.out.println("Nastavnik: " 
      + ime + " " + prezime + " " 
      + predmet +" " + godinaStaza + ".");
  }
}