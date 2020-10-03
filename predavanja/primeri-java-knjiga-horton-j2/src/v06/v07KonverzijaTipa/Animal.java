package v06.v07KonverzijaTipa;
public class Animal
{
  public Animal(String aType)
  {
    type = new String(aType);
  }

  public String toString()
  {
    return "This is a " + type;
  }

  // Dummy method to be implemented in the derived classes
  public void sound()
  {}

  private String type;
}
