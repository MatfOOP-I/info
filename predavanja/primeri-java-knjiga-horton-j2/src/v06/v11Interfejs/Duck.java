package v06.v11Interfejs;
public class Duck implements PetOutput
{
  public Duck(String aName)
  {
    //super("Duck");        // Call the base constructor
    name = aName;         // Supplied name
    breed = "Unknown";    // Default breed value
  }

  public void layEgg()
  {
    System.out.println("Egg laid");
  }


  public Duck(String aName, String aBreed)
  {
    //super("Duck");        // Call the base constructor
    name = aName;         // Supplied name
    breed = aBreed;       // Supplied breed
  }

  // Return a String full of a duck's details
  public String toString()
  {
    return "\nIt's " + name + " the " + breed;
  }

  // A quacking method
  public void sound()
  {
    System.out.println("Quack quackquack");
  }

  private String name;     // Duck name
  private String breed;    // Duck breed
}
