package v06.v06Kloniranje;
public class PetDog extends Animal implements Cloneable
{
  // Constructor
  public PetDog(String name, String breed)
  {
    super("Dog");
    petFlea = new Flea("Max","circus flea");       // Initialize petFlea
    this.name = name;
    this.breed = breed;
  }

  // Rename the dog
  public void setName(String name)
  {
    this.name = name;
  }

  // Return the dog's name
  public String getName()
  {
    return name;
  }

  // Return the breed
  public String getBreed()
  {
    return breed;
  }

  // Return the flea
  public Flea getFlea()
  {
    return petFlea;
  }

  public void sound()
  {
    System.out.println("Woof");
  }

  // Return a String for the pet dog
  public String toString()
  {
    return super.toString() + "\nIt's " + name + " the " + breed +
                                                               " & \n" + petFlea;
  }

  // Override inherited clone() to make it public
  public Object clone() throws CloneNotSupportedException
  {
    return super.clone();
  }

  private Flea petFlea;                   // The pet flea
  private String name;                    // Dog's name
  private String breed;                   // Dog's breed
}
