package rs.math.oop1.z080401.polimorfizam.z02.ljudi;

public class Apsolvent extends Student
{
  int brojRokovaDoIstekaStaza;
  
  void predstaviSe()
  {
    System.out.println("Apsolvent: " 
      + ime + " " + prezime + " " 
      + smer +" " + brojIndeksa + " "
      + godinaStudija 
      + brojRokovaDoIstekaStaza + "." + jeDobar());
  }
}
