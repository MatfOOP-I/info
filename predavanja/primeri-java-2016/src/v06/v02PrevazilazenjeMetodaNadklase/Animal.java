package v06.v02PrevazilazenjeMetodaNadklase;
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

  private String type;
}
