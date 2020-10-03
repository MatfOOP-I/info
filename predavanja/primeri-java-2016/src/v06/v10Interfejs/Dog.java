package v06.v10Interfejs;
public class Dog implements PetOutput
{
   public Dog(String aName)
   {
      name = aName;         // Supplied name
      breed = "Unknown";    // Default breed value
   }

  public Dog(String aName, String aBreed)
  {
    name = aName;         // Supplied name
    breed = aBreed;       // Supplied breed
  }

// Present a dog's details as a string
  public String toString()
  {
    return "It's " + name + " the " + breed;
  }

  // A barking method
  public void sound()
  {
    System.out.println("Woof    Woof");
  }

  public String getName()
  {
    return name;
  }

  private String name;    // Name of a dog
  private String breed;   // Dog breed
}
