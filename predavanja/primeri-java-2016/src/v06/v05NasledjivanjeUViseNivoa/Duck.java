package v06.v05NasledjivanjeUViseNivoa;
public class Duck extends Animal
{
  public Duck(String aName)
  {
    super("Duck");        // Call the base constructor
    name = aName;         // Supplied name
    breed = "Unknown";    // Default breed value
  }

  public Duck(String aName, String aBreed)
  {
    super("Duck");        // Call the base constructor
    name = aName;         // Supplied name
    breed = aBreed;       // Supplied breed
  }

  // Return a String full of a duck's details
  public String toString()
  {
    return super.toString() + "\nIt's " + name + " the " + breed;
  }

  // A quacking method
  public void sound()
  {
    System.out.println("Quack quackquack");
  }

  private String name;     // Duck name
  private String breed;    // Duck breed
}
