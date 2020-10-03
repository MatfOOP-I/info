package v06.v02PrevazilazenjeMetodaNadklase;
public class TestDerived 
{
  public static void main(String[] args)
  {
    Dog aDog = new Dog("Fido", "Chihuahua");     // Create a dog
    Dog starDog = new Dog("Lassie");             // Create a Hollywood dog
    System.out.println(aDog);                    // Let's hear about it
    System.out.println(starDog);                 // and the star
  }
}
