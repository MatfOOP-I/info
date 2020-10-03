package v06.v11Interfejs;
public class Cat implements PetOutput
{
  public Cat(String aName)
  {
    //super("Cat");         // Call the base constructor
    name = aName;         // Supplied name
    breed = "Unknown";    // Default breed value
  }

  public Cat(String aName, String aBreed)
  {
    //super("Cat");         // Call the base constructor
    name = aName;         // Supplied name
    breed = aBreed;       // Supplied breed
  }

  // Return a String full of a cat's details
  public String toString()
  {
    return "\nIt's " + name + " the " + breed;
  }

  // A miaowing method
  public void sound()
  {
    System.out.println("Miiaooww");
  }

  private String name;     // Name of a cat
  private String breed;    // Cat breed
}
