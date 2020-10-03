package v06.v01IzvedenaKlasa;
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

  private String name;                       // Name of a Dog
  private String breed;                      // Dog breed
}
