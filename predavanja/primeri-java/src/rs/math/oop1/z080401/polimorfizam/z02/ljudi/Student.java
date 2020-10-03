package rs.math.oop1.z080401.polimorfizam.z02.ljudi;

class Student extends Covek
{
  String smer;
  String brojIndeksa;
  int godinaStudija;

  void predstaviSe()
  {
    System.out.println("Student: " 
      + ime + " " + prezime + " " 
      + smer +" " + brojIndeksa + " "
      + godinaStudija + "." + jeDobar() );
  }
  
  boolean upisGodine( int godinaStudija )
  {
  	return true;
  }
}