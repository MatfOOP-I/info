package v06.v02PrevazilazenjeMetodaNadklase;
public class Dog extends Animal
{
  public Dog(String aName)
  {
    super("Dog");                            // Call the base constructor
    name = aName;                            // Supplied name
    breed = "Unknown";                       // Default breed value
  }

  public Dog(String aName, String aBreed)
  {
    super("Dog");                            // Call the base constructor
    name = aName;                            // Supplied name
    breed = aBreed;                          // Supplied breed
  }

  // Present a dog's details as a string
  public String toString()
  {
    return "It's " + name + " the " + breed;
  }

  private String name;                       // Name of a Dog
  private String breed;                      // Dog breed
}
