package v06.v07KonverzijaTipa;
public class LayEggs
{
  public static void main(String[] args)
  {
    Duck aDuck = new Duck("Donald", "Eider");
    Animal aPet = aDuck;                    // Cast the Duck to Animal
    ((Duck)aPet).layEgg();                  // This works fine  
  }
}
